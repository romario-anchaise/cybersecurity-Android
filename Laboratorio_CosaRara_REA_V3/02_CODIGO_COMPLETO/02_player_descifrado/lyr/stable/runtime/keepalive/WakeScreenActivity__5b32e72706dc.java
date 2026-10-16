// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.keepalive;

import a0.a;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import c2.w;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class WakeScreenActivity extends Activity {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicLong f2632e = new AtomicLong();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLong f2633f = new AtomicLong();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile long f2634g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f2635a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f2638d;

    public static void a(WakeScreenActivity wakeScreenActivity) {
        long jUptimeMillis = SystemClock.uptimeMillis() - wakeScreenActivity.f2638d;
        try {
            PowerManager powerManager = (PowerManager) wakeScreenActivity.getSystemService("power");
            if (powerManager == null || !powerManager.isInteractive()) {
                if (jUptimeMillis < 1200) {
                    wakeScreenActivity.f2635a.postDelayed(new w(wakeScreenActivity, 0), 50L);
                    return;
                }
            }
        } catch (Throwable unused) {
        }
        wakeScreenActivity.setShowWhenLocked(false);
        wakeScreenActivity.getWindow().clearFlags(524288);
        try {
            wakeScreenActivity.finish();
        } catch (Throwable unused2) {
        }
    }

    public static void b(Context context, String str) {
        long jIncrementAndGet;
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent(applicationContext, (Class<?>) WakeScreenActivity.class);
        intent.putExtra("wake_source", str);
        if ("remote-wake-gesture".equals(str)) {
            jIncrementAndGet = f2632e.incrementAndGet();
            f2633f.set(jIncrementAndGet);
            f2634g = SystemClock.uptimeMillis() + 1700;
            intent.putExtra("remote_cover_token", jIncrementAndGet);
        } else {
            jIncrementAndGet = 0;
        }
        intent.addFlags(1350631424);
        try {
            applicationContext.startActivity(intent);
            Log.i("Keepalive", "WakeScreenActivity requested source=".concat(str));
        } catch (Throwable th) {
            if (jIncrementAndGet != 0) {
                f2633f.compareAndSet(jIncrementAndGet, 0L);
            }
            a.p(th, new StringBuilder("WakeScreenActivity launch failed: "), "Keepalive");
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f2636b = "remote-wake-gesture".equals(getIntent() != null ? getIntent().getStringExtra("wake_source") : "");
        this.f2637c = getIntent() != null ? getIntent().getLongExtra("remote_cover_token", 0L) : 0L;
        this.f2638d = SystemClock.uptimeMillis();
        setShowWhenLocked(true);
        setTurnScreenOn(true);
        getWindow().addFlags(2621584);
        boolean z2 = this.f2636b;
        Handler handler = this.f2635a;
        if (z2) {
            handler.postDelayed(new w(this, 0), 120L);
        } else {
            handler.postDelayed(new w(this, 1), 1200L);
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        this.f2635a.removeCallbacksAndMessages(null);
        long j3 = this.f2637c;
        if (j3 != 0) {
            f2633f.compareAndSet(j3, 0L);
        }
        super.onDestroy();
    }
}
