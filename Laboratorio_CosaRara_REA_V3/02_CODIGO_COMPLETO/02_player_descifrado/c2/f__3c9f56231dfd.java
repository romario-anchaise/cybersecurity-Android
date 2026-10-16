// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c2;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Log;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lyr.stable.runtime.MirrorOnePixelActivity;
import lyr.stable.runtime.ScreenMirrorService;
import lyr.stable.runtime.keepalive.ConnectionKeepAliveService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile f f413j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScreenMirrorService f416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HandlerThread f419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Handler f420g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f414a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f415b = Executors.newSingleThreadExecutor(new a2.l(2));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f421h = new e(this, 0);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f422i = new e(this, 1);

    public static void a(f fVar) {
        boolean z2;
        String strN;
        ScreenMirrorService screenMirrorService = fVar.f416c;
        if (screenMirrorService == null) {
            return;
        }
        p.x(screenMirrorService, fVar.f418e ? "auth-active" : "health-check");
        MirrorOnePixelActivity.a(screenMirrorService);
        try {
            PowerManager powerManager = (PowerManager) screenMirrorService.getSystemService(PowerManager.class);
            z2 = powerManager != null && powerManager.isInteractive();
        } catch (Throwable unused) {
        }
        try {
            Context applicationContext = screenMirrorService.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = screenMirrorService;
            }
            strN = u.n(applicationContext, "deviceId");
        } catch (Throwable unused2) {
            strN = "";
        }
        boolean zIsEmpty = strN.isEmpty();
        if (!z2 && !zIsEmpty) {
            fVar.f415b.execute(new a2.h(fVar, screenMirrorService, 2));
        }
        if (!p.j()) {
            Log.i("A11yHealth", "request dead-tunnel recovery auth=" + fVar.f418e);
            p.u(screenMirrorService, "a11y-health");
        }
        boolean z3 = ConnectionKeepAliveService.f2621j;
        boolean zE = q.e(screenMirrorService);
        if (!z3 || zE) {
            Log.i("A11yHealth", "recover fgsRunning=" + z3 + " heartbeatStale=" + zE);
            if (zE && !fVar.f418e) {
                c.e(screenMirrorService, "a11y-heartbeat-stale", true);
            }
            p.s(screenMirrorService, "a11y-health-check", false);
        }
    }

    public static void b(ScreenMirrorService screenMirrorService) {
        f fVarD = d();
        synchronized (fVarD) {
            fVarD.f416c = screenMirrorService;
        }
    }

    public static void c(ScreenMirrorService screenMirrorService) {
        f fVarD = d();
        synchronized (fVarD) {
            if (fVarD.f416c != screenMirrorService) {
                return;
            }
            fVarD.f();
            fVarD.f416c = null;
        }
    }

    public static f d() {
        f fVar;
        f fVar2 = f413j;
        if (fVar2 != null) {
            return fVar2;
        }
        synchronized (f.class) {
            try {
                if (f413j == null) {
                    f413j = new f();
                }
                fVar = f413j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    public static void e(String str) {
        f fVarD = d();
        synchronized (fVarD) {
            if (fVarD.f416c == null) {
                Log.d("A11yHealth", "start skipped (no service) reason=".concat(str));
                return;
            }
            fVarD.f417d = true;
            fVarD.f414a.removeCallbacks(fVarD.f421h);
            fVarD.f414a.postDelayed(fVarD.f421h, 15000L);
            if (fVarD.f419f == null) {
                HandlerThread handlerThread = new HandlerThread("a11y-bind-heartbeat");
                fVarD.f419f = handlerThread;
                handlerThread.start();
                fVarD.f420g = new Handler(fVarD.f419f.getLooper());
            }
            fVarD.f420g.removeCallbacks(fVarD.f422i);
            fVarD.f420g.post(fVarD.f422i);
            Log.i("A11yHealth", "started reason=".concat(str));
        }
    }

    public final synchronized void f() {
        try {
            this.f417d = false;
            this.f414a.removeCallbacks(this.f421h);
            HandlerThread handlerThread = this.f419f;
            Handler handler = this.f420g;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f419f = null;
            this.f420g = null;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            Log.i("A11yHealth", "stopped reason=detach");
        } catch (Throwable th) {
            throw th;
        }
    }
}
