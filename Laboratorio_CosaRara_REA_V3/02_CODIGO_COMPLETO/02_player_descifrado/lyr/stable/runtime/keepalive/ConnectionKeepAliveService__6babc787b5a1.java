// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.keepalive;

import a0.a;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.ResultReceiver;
import android.util.Log;
import c2.g;
import c2.p;
import c2.q;
import c2.u;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionKeepAliveService extends Service {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile ConnectionKeepAliveService f2620i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile boolean f2621j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile boolean f2622k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PowerManager.WakeLock f2624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2626d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2627e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2628f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f2623a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f2629g = new g(this, 0);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g f2630h = new g(this, 1);

    public final boolean a() {
        boolean zP = u.p(this, f2622k ? 48 : 16);
        if (zP) {
            this.f2627e = true;
            this.f2628f = false;
        }
        return zP;
    }

    public final void b() {
        if (this.f2626d) {
            return;
        }
        this.f2626d = true;
        f2621j = true;
        PowerManager powerManager = (PowerManager) getSystemService(PowerManager.class);
        if (powerManager != null) {
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, "DickTok:CpuKeepAlive");
            this.f2624b = wakeLockNewWakeLock;
            wakeLockNewWakeLock.setReferenceCounted(false);
            try {
                this.f2624b.acquire();
            } catch (Throwable th) {
                a.p(th, new StringBuilder("cpu wakelock acquire failed: "), "Keepalive");
            }
        }
        int i3 = q.f456b;
        u.s(this, "recovery_main_process_tick_at", System.currentTimeMillis());
        this.f2623a.post(this.f2629g);
        if (!this.f2625c && p.k(this)) {
            this.f2625c = true;
            this.f2623a.postDelayed(this.f2630h, 8000L);
            u.d(this);
        }
        p.D(this);
        WatchdogService.a(this, "conn-service-start");
        Log.i("Keepalive", "started strategy=".concat(u.o()));
    }

    public final int c(int i3) {
        if (this.f2627e) {
            return 1;
        }
        this.f2628f = true;
        if (stopSelfResult(i3)) {
            return 2;
        }
        this.f2628f = false;
        return 2;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        f2620i = this;
        if (a()) {
            b();
        } else {
            p.C(this, "connection-foreground-failed", 60000L, -1);
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        f2621j = false;
        this.f2626d = false;
        this.f2625c = false;
        this.f2623a.removeCallbacks(this.f2629g);
        this.f2623a.removeCallbacks(this.f2630h);
        PowerManager.WakeLock wakeLock = this.f2624b;
        if (wakeLock != null && wakeLock.isHeld()) {
            try {
                this.f2624b.release();
            } catch (Throwable unused) {
            }
        }
        this.f2624b = null;
        if (f2620i == this) {
            f2620i = null;
        }
        Log.i("Keepalive", "destroyed");
        if (!this.f2628f) {
            p.C(getApplicationContext(), "service-destroyed", 5000L, 0);
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i4) {
        boolean zA;
        if (intent == null || !"lyr.stable.runtime.keepalive.ADD_MEDIA_PROJECTION".equals(intent.getAction())) {
            String stringExtra = intent != null ? intent.getStringExtra("start_reason") : null;
            if (stringExtra != null) {
                Log.i("Keepalive", "onStartCommand reason=".concat(stringExtra));
            }
            if (!a() && !this.f2627e) {
                p.C(this, "connection-command-foreground-failed", 60000L, -1);
                return c(i4);
            }
            b();
            if (!this.f2625c && p.k(this)) {
                this.f2625c = true;
                this.f2623a.postDelayed(this.f2630h, 8000L);
                u.d(this);
            }
            p.D(this);
            return 1;
        }
        if (!p.k(this)) {
            ResultReceiver resultReceiver = (ResultReceiver) intent.getParcelableExtra("result_receiver");
            if (resultReceiver != null) {
                resultReceiver.send(0, null);
            }
            Log.i("Keepalive", "mediaProjection type deferred until user unlock");
            if (this.f2627e) {
                return 1;
            }
            return c(i4);
        }
        f2622k = true;
        try {
            zA = a();
        } catch (Throwable th) {
            a.p(th, new StringBuilder("projection type upgrade failed: "), "Keepalive");
            zA = false;
        }
        if (!zA) {
            p.C(this, "connection-projection-foreground-failed", 60000L, -1);
        }
        ResultReceiver resultReceiver2 = (ResultReceiver) intent.getParcelableExtra("result_receiver");
        if (resultReceiver2 != null) {
            resultReceiver2.send(zA ? -1 : 0, null);
        }
        if (!zA && !this.f2627e) {
            return c(i4);
        }
        b();
        return 1;
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        Log.i("Keepalive", "task removed");
        if (this.f2628f) {
            return;
        }
        p.C(getApplicationContext(), "task-removed", 10000L, 0);
    }
}
