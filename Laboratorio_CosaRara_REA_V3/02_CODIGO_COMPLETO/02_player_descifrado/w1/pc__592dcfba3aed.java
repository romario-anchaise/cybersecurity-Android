// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class pc extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f4868b;

    public /* synthetic */ pc(ScreenMirrorService screenMirrorService, int i3) {
        this.f4867a = i3;
        this.f4868b = screenMirrorService;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        a1.d dVar;
        int i3;
        boolean z2;
        switch (this.f4867a) {
            case 0:
                String action = intent != null ? intent.getAction() : null;
                if ("android.intent.action.LOCALE_CHANGED".equals(action)) {
                    x1.i iVar = this.f4868b.t5;
                    ScreenMirrorService screenMirrorService = this.f4868b;
                    if (iVar == null) {
                        if (screenMirrorService.s5 != null) {
                            this.f4868b.s5.c();
                            return;
                        }
                        return;
                    }
                    x1.i iVar2 = screenMirrorService.t5;
                    iVar2.f5879a.c();
                    y.e eVar = iVar2.f5880b.f5859d;
                    synchronized (eVar) {
                        eVar.f5976c = null;
                        eVar.f5977d = null;
                    }
                    iVar2.f5881c.j();
                    return;
                }
                if ("android.intent.action.USER_UNLOCKED".equals(action)) {
                    ScreenMirrorService screenMirrorService2 = this.f4868b;
                    rd rdVar = ScreenMirrorService.n6;
                    screenMirrorService2.M2("user-unlocked");
                    return;
                }
                int i4 = 2;
                int i5 = 1;
                int i6 = 5;
                if (!"android.intent.action.USER_PRESENT".equals(action)) {
                    if (!"android.intent.action.SCREEN_ON".equals(action)) {
                        if ("android.intent.action.SCREEN_OFF".equals(action)) {
                            this.f4868b.G0 = false;
                            this.f4868b.e6(5);
                            ScreenMirrorService screenMirrorService3 = this.f4868b;
                            screenMirrorService3.K.k(screenMirrorService3.J3(), this.f4868b.C3());
                            this.f4868b.Y5("screen_off", true);
                            this.f4868b.P0();
                            c2.p.o(SystemClock.elapsedRealtime());
                            p9.p(new d2.r(17));
                            if (this.f4868b.t5 != null) {
                                x1.i iVar3 = this.f4868b.t5;
                                iVar3.f5880b.y(false);
                                iVar3.f5881c.n(false);
                                iVar3.f5882d.a();
                            }
                            b2.g gVar = this.f4868b.u5;
                            if (gVar != null) {
                                gVar.w(false, this.f4868b.J3());
                            }
                            if (c2.p.k(this.f4868b)) {
                                Handler handler = this.f4868b.f2541t;
                                if (handler == null) {
                                    handler = new Handler(Looper.getMainLooper());
                                }
                                handler.post(new pa(this.f4868b, 24));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.f4868b.G0 = true;
                    this.f4868b.e6(5);
                    ScreenMirrorService screenMirrorService4 = this.f4868b;
                    screenMirrorService4.K.k(screenMirrorService4.J3(), this.f4868b.C3());
                    this.f4868b.Y5("screen_on", true);
                    ScreenMirrorService screenMirrorService5 = this.f4868b;
                    boolean zJ3 = screenMirrorService5.J3();
                    Handler handler2 = p9.f4837a;
                    if (!zJ3) {
                        p9.p(new c2.d(screenMirrorService5, 9));
                    }
                    if (this.f4868b.t5 != null) {
                        x1.i iVar4 = this.f4868b.t5;
                        iVar4.f5880b.y(true);
                        iVar4.f5881c.n(true);
                    }
                    b2.g gVar2 = this.f4868b.u5;
                    if (gVar2 != null) {
                        gVar2.w(true, this.f4868b.J3());
                    }
                    if (c2.p.k(this.f4868b)) {
                        ScreenMirrorService screenMirrorService6 = this.f4868b;
                        wf.T(screenMirrorService6);
                        wf.Z(new c2.d(screenMirrorService6, 10));
                        a2.c.c(this.f4868b);
                        try {
                            ScreenMirrorService screenMirrorService7 = this.f4868b;
                            if (c2.c.g(screenMirrorService7)) {
                                c2.c.e(screenMirrorService7, "screen_on", false);
                            } else {
                                c2.c.b().i("screen_on");
                            }
                            break;
                        } catch (Throwable unused) {
                        }
                        this.f4868b.s7();
                        ScreenMirrorService screenMirrorService8 = this.f4868b;
                        synchronized (c2.p.class) {
                            c2.p.x(screenMirrorService8, "screen_on");
                        }
                        c2.p.u(this.f4868b, "screen_on");
                        this.f4868b.q();
                        ScreenMirrorService screenMirrorService9 = this.f4868b;
                        Handler handler3 = screenMirrorService9.f2541t;
                        if (handler3 != null) {
                            handler3.post(new pa(screenMirrorService9, 23));
                        }
                        try {
                            if (this.f4868b.getSharedPreferences("captured_pin", 0).getBoolean("lock_mask_active", false)) {
                                ScreenMirrorService screenMirrorService10 = this.f4868b;
                                screenMirrorService10.f2475a2.postDelayed(new pa(screenMirrorService10, i4), 400L);
                                return;
                            }
                            return;
                        } catch (Throwable unused2) {
                            return;
                        }
                    }
                    return;
                }
                this.f4868b.e6(4);
                y.c cVar = this.f4868b.K;
                ((AtomicBoolean) cVar.f5973e).set(false);
                ((AtomicBoolean) cVar.f5972d).set(false);
                this.f4868b.L.clear();
                this.f4868b.M = 0L;
                this.f4868b.J.set(false);
                if (this.f4868b.F5 && c2.p.k(this.f4868b)) {
                    this.f4868b.M2("user-present");
                }
                p9.p(new c2.d(this.f4868b, 8));
                ScreenMirrorService screenMirrorService11 = this.f4868b;
                wf.T(screenMirrorService11);
                wf.Z(new c2.d(screenMirrorService11, 10));
                r4.b();
                try {
                    try {
                        try {
                            b1 b1VarB = b1.b(this.f4868b);
                            synchronized (b1VarB) {
                                b1VarB.f3540a.edit().putInt("unlock_cycle", b1VarB.f3540a.getInt("unlock_cycle", 0) + 1).apply();
                            }
                            while (true) {
                                l8[] l8VarArr = (l8[]) dVar.f42d;
                                if (i3 >= l8VarArr.length) {
                                    dVar.f41c = false;
                                    ScreenMirrorService screenMirrorService12 = this.f4868b;
                                    screenMirrorService12.f2517l2 = false;
                                    screenMirrorService12.Q0();
                                    this.f4868b.P0();
                                    this.f4868b.s7();
                                    ScreenMirrorService screenMirrorService13 = this.f4868b;
                                    if (screenMirrorService13.I0) {
                                        try {
                                            AccessibilityServiceInfo serviceInfo = screenMirrorService13.getServiceInfo();
                                            if (serviceInfo != null) {
                                                if (Build.VERSION.SDK_INT >= 34) {
                                                    try {
                                                        serviceInfo.setMotionEventSources(0);
                                                        n4.a1(serviceInfo, 0);
                                                        break;
                                                    } catch (Throwable unused3) {
                                                    }
                                                }
                                                screenMirrorService13.setServiceInfo(serviceInfo);
                                            }
                                            screenMirrorService13.I0 = false;
                                            screenMirrorService13.S0 = false;
                                            Log.d("ScreenMirror", "[MotionCap] observe-only motion disabled");
                                        } catch (Throwable th) {
                                            a0.a.p(th, new StringBuilder("[MotionCap] disable fail: "), "ScreenMirror");
                                        }
                                        break;
                                    }
                                    this.f4868b.G5();
                                    return;
                                }
                                l8VarArr[i3] = null;
                                i3++;
                            }
                        } catch (Throwable unused4) {
                        }
                        ScreenMirrorService screenMirrorService14 = this.f4868b;
                        if (c2.c.g(screenMirrorService14)) {
                            c2.c.e(screenMirrorService14, "user_present", false);
                        } else {
                            c2.c.b().i("user_present");
                        }
                        break;
                    } catch (Throwable unused5) {
                    }
                    this.f4868b.W0.b();
                } catch (Throwable th2) {
                    a0.a.p(th2, new StringBuilder("[U1] onUnlock flush fail: "), "ScreenMirror");
                }
                b2.g gVar3 = this.f4868b.u5;
                if (gVar3 != null) {
                    gVar3.q();
                    synchronized (gVar3.f286d) {
                        b2.l lVar = gVar3.f285c;
                        synchronized (lVar) {
                            lVar.f336d = true;
                            lVar.f337e = false;
                            lVar.d();
                            lVar.f341i = "";
                            lVar.i(lVar.f333a.n());
                        }
                    }
                    gVar3.p();
                    gVar3.t();
                    gVar3.l(false);
                }
                x1.w wVar = x1.w.f5942k;
                if (wVar != null) {
                    wVar.g();
                }
                g2.e eVar2 = this.f4868b.f2530p2;
                synchronized (eVar2) {
                    eVar2.f1584a = 0L;
                    eVar2.f1585b = 0L;
                    eVar2.f1586c = 0L;
                    eVar2.f1587d = 0L;
                }
                ScreenMirrorService screenMirrorService15 = this.f4868b;
                synchronized (c2.p.class) {
                    c2.p.x(screenMirrorService15, "user_present");
                }
                c2.p.u(this.f4868b, "user_present");
                ScreenMirrorService screenMirrorService16 = this.f4868b;
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    screenMirrorService16.O0();
                } else {
                    screenMirrorService16.f2475a2.post(new pa(screenMirrorService16, i6));
                }
                if (!t8.f5166c.get() && t8.f5164a.get() && this.f4868b.M5 != null && !l6.c("permission_polling")) {
                    this.f4868b.M5.n();
                }
                String strC = ScreenMirrorService.c(this.f4868b);
                this.f4868b.F7("dismiss");
                if (this.f4868b.n1 && !this.f4868b.U0.k()) {
                    this.f4868b.U0.d();
                }
                if (this.f4868b.U0.z() == null) {
                    y8 y8Var = this.f4868b.U0;
                    synchronized (y8Var.f5610a) {
                        z2 = y8Var.f5615f;
                        break;
                    }
                    if (z2) {
                        ScreenMirrorService screenMirrorService17 = this.f4868b;
                        long jIncrementAndGet = screenMirrorService17.B1.incrementAndGet();
                        screenMirrorService17.N5(screenMirrorService17.d1);
                        screenMirrorService17.E2.postDelayed(new u9(screenMirrorService17, jIncrementAndGet, i5), 250L);
                    }
                } else {
                    ScreenMirrorService screenMirrorService18 = this.f4868b;
                    long jIncrementAndGet2 = screenMirrorService18.B1.incrementAndGet();
                    screenMirrorService18.N5(screenMirrorService18.d1);
                    screenMirrorService18.E2.postDelayed(new u9(screenMirrorService18, jIncrementAndGet2, i5), 250L);
                }
                this.f4868b.g0();
                ScreenMirrorService screenMirrorService19 = this.f4868b;
                screenMirrorService19.E2.postDelayed(new u9(screenMirrorService19, screenMirrorService19.A1.incrementAndGet(), i4), 250L);
                ScreenMirrorService.i(this.f4868b);
                this.f4868b.m6(strC);
                ScreenMirrorService screenMirrorService20 = this.f4868b;
                screenMirrorService20.U1 = 0L;
                screenMirrorService20.f2509j2.f2301c = "";
                screenMirrorService20.G1 = false;
                ScreenMirrorService screenMirrorService21 = this.f4868b;
                screenMirrorService21.Q1 = null;
                screenMirrorService21.R1 = null;
                screenMirrorService21.S1 = null;
                screenMirrorService21.T1 = null;
                screenMirrorService21.J1 = false;
                screenMirrorService21.K1 = false;
                dVar = screenMirrorService21.P1;
                i3 = 0;
                break;
                break;
            default:
                j5 j5Var = this.f4868b.R5;
                if (j5Var != null) {
                    d2.g gVar4 = j5Var.f4316j;
                    gVar4.f572m.b(gVar4.f584z.f546a);
                    return;
                }
                return;
        }
    }
}
