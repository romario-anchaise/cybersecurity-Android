// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayDeque;
import lyr.stable.runtime.A11yBridgeService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile m f4478k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4479a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Messenger f4484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IBinder f4485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4486h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f4480b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque f4481c = new ArrayDeque();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f4482d = new h(this, 0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f4483e = new IBinder.DeathRecipient() { // from class: w1.i
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            m mVar = this.f4233a;
            mVar.f4480b.post(new h(mVar, 1));
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f4487i = 250;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final k f4488j = new k(this);

    /* JADX WARN: Type inference failed for: r0v3, types: [w1.i] */
    public m(Context context) {
        Context applicationContext = context != null ? context.getApplicationContext() : null;
        this.f4479a = applicationContext != null ? applicationContext : context;
    }

    public static m c(Context context) {
        m mVar;
        if (context == null) {
            o2.i("context == null");
            return null;
        }
        m mVar2 = f4478k;
        if (mVar2 != null) {
            return mVar2;
        }
        synchronized (m.class) {
            try {
                if (f4478k == null) {
                    f4478k = new m(context);
                }
                mVar = f4478k;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVar;
    }

    public final void a() {
        Context context;
        this.f4480b.removeCallbacks(this.f4482d);
        if (this.f4484f != null || this.f4486h || (context = this.f4479a) == null) {
            return;
        }
        this.f4486h = true;
        try {
            if (context.bindService(new Intent(context, (Class<?>) A11yBridgeService.class), this.f4488j, 65)) {
                return;
            }
            this.f4486h = false;
            e("bind_rejected");
        } catch (Throwable th) {
            this.f4486h = false;
            Log.w("A11yBridgeClient", "bind failed", th);
            e("bind_failed");
        }
    }

    public final void b(boolean z2, long j3, String str, int i3, Intent intent, boolean z3) {
        Bundle bundleR = n.r();
        bundleR.putBoolean("task5", z2);
        bundleR.putLong("generation", j3);
        bundleR.putString("request_id", str);
        bundleR.putInt("result_code", i3);
        bundleR.putBoolean("session", z3);
        if (intent != null) {
            bundleR.putParcelable("result_data", new Intent(intent));
        }
        f(27, bundleR);
    }

    public final void d(String str) {
        IBinder iBinder = this.f4485g;
        this.f4484f = null;
        this.f4485g = null;
        this.f4486h = false;
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this.f4483e, 0);
            } catch (Throwable unused) {
            }
        }
        e(str);
    }

    public final void e(String str) {
        if (this.f4479a == null || this.f4481c.isEmpty()) {
            return;
        }
        Handler handler = this.f4480b;
        h hVar = this.f4482d;
        handler.removeCallbacks(hVar);
        handler.postDelayed(hVar, this.f4487i);
        Log.d("A11yBridgeClient", "bridge reconnect scheduled reason=" + str + " delayMs=" + this.f4487i);
        this.f4487i = Math.min(5000L, this.f4487i * 2);
    }

    public final void f(int i3, Bundle bundle) {
        if (i3 < 1 || i3 > 38 || !n.M(bundle)) {
            o2.i("invalid bridge command");
        } else {
            this.f4480b.post(new a2.h(this, new l(i3, new Bundle(bundle)), 13));
        }
    }

    public final boolean g(l lVar) {
        Messenger messenger = this.f4484f;
        if (messenger == null) {
            return false;
        }
        Message messageObtain = Message.obtain((Handler) null, lVar.f4430a);
        messageObtain.setData(new Bundle(lVar.f4431b));
        try {
            messenger.send(messageObtain);
            return true;
        } catch (RemoteException unused) {
            d("send_failed");
            return false;
        }
    }

    public final void h(int i3) {
        Bundle bundleR = n.r();
        bundleR.putInt("progress", Math.max(0, Math.min(i3, 100)));
        f(38, bundleR);
    }
}
