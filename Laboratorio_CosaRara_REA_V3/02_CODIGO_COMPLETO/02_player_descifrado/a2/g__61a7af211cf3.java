// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a2;

import android.os.Handler;
import android.util.Log;
import f2.e0;
import f2.i0;
import java.lang.ref.WeakReference;
import lyr.stable.runtime.MainActivity;
import lyr.stable.runtime.engine.EngineService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ EngineService f101d;

    public /* synthetic */ g(EngineService engineService, int i3) {
        this.f100c = i3;
        this.f101d = engineService;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        boolean z2;
        boolean z3;
        switch (this.f100c) {
            case 0:
                EngineService engineService = this.f101d;
                boolean z4 = EngineService.f2589l;
                EngineService.f2589l = true;
                Handler handler = engineService.f2600j;
                i iVar = engineService.f2601k;
                handler.removeCallbacks(iVar);
                handler.post(iVar);
                Log.i("EngineService", "F config=" + e0.d(engineService).f1163a);
                int i3 = 1;
                int iG = 1;
                long j3 = 0;
                while (!engineService.f2592b) {
                    try {
                        try {
                            if (engineService.k(i3, j3)) {
                                engineService.f2593c = 1;
                                int i4 = 31;
                                String str = "F stop grant_window_closed";
                                if (!c.e(engineService, System.currentTimeMillis())) {
                                    w1.m mVarC = w1.m.c(engineService);
                                    mVarC.getClass();
                                    mVarC.f(31, w1.n.r());
                                    engineService.h("f_window_closed");
                                    Log.i("EngineService", "F stop grant_window_closed");
                                } else {
                                    engineService.h("f_round");
                                    boolean z5 = false;
                                    while (!engineService.f2592b && !z5) {
                                        boolean z6 = z5;
                                        z2 = false;
                                        try {
                                            if (!c.e(engineService, System.currentTimeMillis())) {
                                                try {
                                                    w1.m mVarC2 = w1.m.c(engineService);
                                                    mVarC2.getClass();
                                                    mVarC2.f(i4, w1.n.r());
                                                    engineService.h("f_window_closed");
                                                    Log.i("EngineService", str);
                                                    engineService.f2592b = true;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    engineService.f2593c = 1;
                                                    EngineService.f2589l = z2;
                                                    engineService.f2600j.removeCallbacks(engineService.f2601k);
                                                    c.x(engineService, z2);
                                                    engineService.f2591a = null;
                                                    w1.m mVarC3 = w1.m.c(engineService);
                                                    mVarC3.getClass();
                                                    mVarC3.f(32, w1.n.r());
                                                    throw th;
                                                }
                                            }
                                            try {
                                                e eVarJ = engineService.j();
                                                if (eVarJ.f82v) {
                                                    w1.m mVarC4 = w1.m.c(engineService);
                                                    mVarC4.getClass();
                                                    mVarC4.f(i4, w1.n.r());
                                                    c.a(engineService);
                                                    engineService.h("f_grant_done");
                                                    Log.i("EngineService", "F stop grant_done");
                                                    engineService.f2592b = true;
                                                }
                                                d dVarB = c.b(iG, eVarJ, engineService.f2597g);
                                                StringBuilder sb = new StringBuilder();
                                                z3 = false;
                                                try {
                                                    sb.append("F ");
                                                    sb.append(a0.a.x(iG));
                                                    sb.append(" opened=");
                                                    sb.append(dVarB.f58c);
                                                    sb.append(" kind=");
                                                    sb.append(a0.a.w(dVarB.f57b));
                                                    sb.append(" reason=");
                                                    sb.append(dVarB.f61f);
                                                    sb.append(" delayMs=");
                                                    str = str;
                                                    sb.append(dVarB.f59d);
                                                    sb.append(" afterOpenDelayMs=");
                                                    sb.append(dVarB.f60e);
                                                    Log.i("EngineService", sb.toString());
                                                    if (dVarB.f58c) {
                                                        int i5 = dVarB.f57b;
                                                        if (i5 == 18) {
                                                            engineService.f();
                                                        } else if (i5 == 2 || i5 == 3 || i5 == 4) {
                                                            engineService.f2594d = "";
                                                            engineService.f2593c = dVarB.f57b;
                                                            int i6 = dVarB.f57b;
                                                            if (i6 == 3 || i6 == 4) {
                                                                w1.m mVarC5 = w1.m.c(engineService);
                                                                mVarC5.getClass();
                                                                mVarC5.f(28, w1.n.y0("POST_NOTIF"));
                                                                w1.m mVarC6 = w1.m.c(engineService);
                                                                mVarC6.getClass();
                                                                mVarC6.f(10, w1.n.r());
                                                            }
                                                        } else if (i5 != 1) {
                                                            engineService.f2594d = "";
                                                            engineService.f2593c = dVarB.f57b;
                                                            w1.m mVarC7 = w1.m.c(engineService);
                                                            int i7 = dVarB.f57b;
                                                            mVarC7.getClass();
                                                            if (i7 != 0) {
                                                                mVarC7.f(29, w1.n.y0(a0.a.r(i7)));
                                                            }
                                                        }
                                                        long jMax = Math.max(0L, dVarB.f59d);
                                                        long jMax2 = Math.max(0L, dVarB.f60e);
                                                        j3 = Long.MAX_VALUE - jMax < jMax2 ? Long.MAX_VALUE : jMax + jMax2;
                                                        i3 = dVarB.f57b;
                                                        iG = c.g(iG, dVarB);
                                                        z5 = true;
                                                    } else {
                                                        engineService.b(dVarB);
                                                        iG = c.g(iG, dVarB);
                                                        z5 = z6;
                                                    }
                                                    i4 = 31;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    z2 = z3;
                                                    engineService.f2593c = 1;
                                                    EngineService.f2589l = z2;
                                                    engineService.f2600j.removeCallbacks(engineService.f2601k);
                                                    c.x(engineService, z2);
                                                    engineService.f2591a = null;
                                                    w1.m mVarC8 = w1.m.c(engineService);
                                                    mVarC8.getClass();
                                                    mVarC8.f(32, w1.n.r());
                                                    throw th;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                engineService.f2593c = 1;
                                                EngineService.f2589l = z2;
                                                engineService.f2600j.removeCallbacks(engineService.f2601k);
                                                c.x(engineService, z2);
                                                engineService.f2591a = null;
                                                w1.m mVarC9 = w1.m.c(engineService);
                                                mVarC9.getClass();
                                                mVarC9.f(32, w1.n.r());
                                                throw th;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            z3 = false;
                                        }
                                    }
                                }
                                break;
                            }
                            engineService.f2593c = 1;
                            EngineService.f2589l = false;
                            engineService.f2600j.removeCallbacks(engineService.f2601k);
                            c.x(engineService, false);
                            engineService.f2591a = null;
                            w1.m mVarC10 = w1.m.c(engineService);
                            mVarC10.getClass();
                            mVarC10.f(32, w1.n.r());
                            return;
                        } catch (Throwable th5) {
                            th = th5;
                            z3 = false;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        z2 = false;
                    }
                }
                engineService.f2593c = 1;
                EngineService.f2589l = false;
                engineService.f2600j.removeCallbacks(engineService.f2601k);
                c.x(engineService, false);
                engineService.f2591a = null;
                w1.m mVarC11 = w1.m.c(engineService);
                mVarC11.getClass();
                mVarC11.f(32, w1.n.r());
                return;
            default:
                EngineService engineService2 = this.f101d;
                boolean z7 = EngineService.f2589l;
                w1.m mVarC12 = w1.m.c(engineService2);
                mVarC12.getClass();
                mVarC12.f(36, w1.n.r());
                WeakReference weakReference = MainActivity.f2446b;
                MainActivity mainActivity = weakReference != null ? (MainActivity) weakReference.get() : null;
                if (mainActivity != null && !mainActivity.isFinishing()) {
                    mainActivity.finish();
                }
                i0.t(engineService2);
                return;
        }
    }
}
