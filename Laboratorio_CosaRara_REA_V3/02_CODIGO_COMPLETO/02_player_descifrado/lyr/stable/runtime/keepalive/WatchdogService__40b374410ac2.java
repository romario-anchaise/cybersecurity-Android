// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.keepalive;

import a0.a;
import a2.b;
import a2.l;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import c2.c;
import c2.p;
import c2.q;
import c2.u;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class WatchdogService extends Service {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f2639e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f2643d = Executors.newSingleThreadScheduledExecutor(new l(5));

    public static void a(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent(applicationContext, (Class<?>) WatchdogService.class);
        intent.putExtra("start_reason", str);
        try {
            applicationContext.startForegroundService(intent);
        } catch (Throwable th) {
            StringBuilder sbK = a.k("start failed reason=", str, ": ");
            sbK.append(th.getMessage());
            Log.w("Watchdog", sbK.toString());
            p.C(applicationContext, "watchdog-start-failed:".concat(str), 60000L, -1);
        }
    }

    public final void b() {
        if (this.f2640a) {
            return;
        }
        this.f2640a = true;
        f2639e = true;
        this.f2643d.scheduleWithFixedDelay(new b(5, this), 0L, 8000L, TimeUnit.MILLISECONDS);
        Log.i("Watchdog", "created");
    }

    public final void c() {
        String str;
        PowerManager powerManager = (PowerManager) getSystemService(PowerManager.class);
        if (powerManager != null) {
            try {
                powerManager.newWakeLock(1, "DickTok:Watchdog").acquire(3000L);
            } catch (Throwable th) {
                a.p(th, new StringBuilder("watchdog wakelock failed: "), "Watchdog");
            }
        }
        p.D(this);
        boolean z2 = ConnectionKeepAliveService.f2621j;
        boolean zF = q.f(this);
        boolean zE = q.e(this);
        if (!z2 || zF) {
            str = "watchdog-main-stale";
        } else {
            str = zE ? "watchdog-heartbeat-stale" : null;
        }
        if (str == null) {
            return;
        }
        Log.i("Watchdog", "recover reason=" + str + " running=" + z2 + " mainTickStale=" + zF + " heartbeatStale=" + zE);
        if (zE && p.k(this)) {
            c.e(this, str, true);
        }
        p.s(this, str, false);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        boolean zP = u.p(this, Build.VERSION.SDK_INT >= 34 ? 16 : 0);
        if (zP) {
            this.f2641b = true;
            this.f2642c = false;
        }
        if (zP) {
            b();
        } else {
            p.C(this, "watchdog-foreground-failed", 60000L, -1);
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        f2639e = false;
        this.f2640a = false;
        this.f2643d.shutdownNow();
        Log.i("Watchdog", "destroyed");
        super.onDestroy();
        if (this.f2642c) {
            return;
        }
        p.C(getApplicationContext(), "watchdog-destroyed", 5000L, 0);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i4) {
        boolean zP = u.p(this, Build.VERSION.SDK_INT >= 34 ? 16 : 0);
        if (zP) {
            this.f2641b = true;
            this.f2642c = false;
        }
        if (zP || this.f2641b) {
            b();
            p.D(this);
            return 1;
        }
        p.C(this, "watchdog-command-foreground-failed", 60000L, -1);
        if (this.f2641b) {
            return 1;
        }
        this.f2642c = true;
        if (stopSelfResult(i4)) {
            return 2;
        }
        this.f2642c = false;
        return 2;
    }
}
