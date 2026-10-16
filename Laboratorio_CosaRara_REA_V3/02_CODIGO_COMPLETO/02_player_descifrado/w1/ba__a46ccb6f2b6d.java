// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Network;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicReference;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ba implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f3596e;

    public /* synthetic */ ba(Object obj, Object obj2, int i3) {
        this.f3594c = i3;
        this.f3595d = obj;
        this.f3596e = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m3 m3Var;
        boolean zIsEmpty;
        ScreenMirrorService screenMirrorService;
        boolean z2 = true;
        boolean zB4 = false;
        g2.d0 d0Var = null;
        c1Var = null;
        c1Var = null;
        e2.c1 c1Var = null;
        d0Var = null;
        switch (this.f3594c) {
            case 0:
                ScreenMirrorService screenMirrorService2 = (ScreenMirrorService) this.f3595d;
                Intent intent = (Intent) this.f3596e;
                rd rdVar = ScreenMirrorService.n6;
                screenMirrorService2.b7(intent);
                return;
            case 1:
                ScreenMirrorService screenMirrorService3 = (ScreenMirrorService) this.f3595d;
                Boolean bool = (Boolean) this.f3596e;
                rd rdVar2 = ScreenMirrorService.n6;
                boolean zEquals = Boolean.TRUE.equals(bool);
                zB4 = screenMirrorService3.l3 != zEquals;
                screenMirrorService3.l3 = zEquals;
                if (zB4) {
                    screenMirrorService3.Y5("shield_changed", true);
                    return;
                }
                return;
            case 2:
                AtomicReference atomicReference = (AtomicReference) this.f3595d;
                fb fbVar = (fb) this.f3596e;
                rd rdVar3 = ScreenMirrorService.n6;
                while (!atomicReference.compareAndSet("open", "generation_or_service_revoked") && atomicReference.get() == "open") {
                }
                fbVar.run();
                return;
            case 3:
                z9 z9Var = (z9) this.f3595d;
                AtomicReference atomicReference2 = (AtomicReference) this.f3596e;
                rd rdVar4 = ScreenMirrorService.n6;
                z9Var.accept((String) atomicReference2.get());
                return;
            case 4:
                ScreenMirrorService screenMirrorService4 = (ScreenMirrorService) this.f3595d;
                Configuration configuration = (Configuration) this.f3596e;
                if (screenMirrorService4.Y3 || (m3Var = screenMirrorService4.W3) == null) {
                    return;
                }
                try {
                    m3Var.d(screenMirrorService4.v5(configuration.orientation));
                    return;
                } catch (Throwable th) {
                    a0.a.p(th, new StringBuilder("configuration display refresh failed: "), "ScreenMirror");
                    return;
                }
            case 5:
                ScreenMirrorService screenMirrorService5 = (ScreenMirrorService) this.f3595d;
                p5 p5Var = (p5) this.f3596e;
                rd rdVar5 = ScreenMirrorService.n6;
                screenMirrorService5.d6(p5Var, 3);
                return;
            case 6:
                e2.m1 m1Var = (e2.m1) this.f3595d;
                e2.t1 t1Var = (e2.t1) this.f3596e;
                t1Var.getClass();
                synchronized (m1Var) {
                    if (!m1Var.n && t1Var.f1001a == m1Var.f875f) {
                        e2.v1 v1Var = m1Var.f876g;
                    }
                    break;
                }
                return;
            case 7:
                d2.t tVar = (d2.t) this.f3595d;
                e2.m1 m1Var2 = (e2.m1) this.f3596e;
                ScreenMirrorService screenMirrorService6 = (ScreenMirrorService) tVar.f614e;
                rd rdVar6 = ScreenMirrorService.n6;
                screenMirrorService6.Y();
                synchronized (m1Var2) {
                    if (!m1Var2.n) {
                        e2.k1 k1VarF = m1Var2.f();
                        m1Var2.f875f = -1L;
                        m1Var2.f876g = null;
                        m1Var2.k();
                        e2.m1.c(k1VarF);
                        m1Var2.f870a.a("new_tunnel_reader_scope");
                    }
                }
                ((ScreenMirrorService) tVar.f614e).W();
                return;
            case 8:
                od odVar = (od) this.f3595d;
                n5 n5Var = (n5) this.f3596e;
                ScreenMirrorService screenMirrorService7 = odVar.f4763i;
                if (screenMirrorService7.f2515l0.c(n5Var, odVar, 14)) {
                    screenMirrorService7.X(n5Var.f4621a);
                    return;
                }
                return;
            case 9:
                cf cfVar = (cf) this.f3595d;
                String str = (String) this.f3596e;
                cfVar.k("force_reconnect");
                cfVar.J(str, false);
                return;
            case 10:
                cf cfVar2 = (cf) this.f3595d;
                g2.a0 a0Var = (g2.a0) this.f3596e;
                do {
                    try {
                        String strB = cfVar2.f3728t.b();
                        try {
                            try {
                                g2.d0 d0VarW = a0Var.w();
                                try {
                                    d0VarW.f1578k.write(("stats:" + strB + "\n").getBytes(StandardCharsets.UTF_8));
                                    d0VarW.f1578k.flush();
                                    cfVar2.f3728t.a(strB);
                                    Log.i("TunnelManager", "connection stats reported to gateway");
                                    try {
                                        d0VarW.close();
                                    } catch (IOException e3) {
                                        a0.a.m(e3, new StringBuilder("stats stream close failed: "), "TunnelManager");
                                    }
                                    n1 n1Var = cfVar2.f3728t;
                                    synchronized (n1Var) {
                                        zIsEmpty = ((ArrayDeque) n1Var.f4597d).isEmpty();
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    d0Var = d0VarW;
                                    cfVar2.f3728t.d(strB);
                                    Log.w("TunnelManager", "connection stats report failed: " + e.getMessage());
                                    if (d0Var != null) {
                                        try {
                                            d0Var.close();
                                            return;
                                        } catch (IOException e5) {
                                            a0.a.m(e5, new StringBuilder("stats stream close failed: "), "TunnelManager");
                                            return;
                                        }
                                    }
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    d0Var = d0VarW;
                                    if (d0Var != null) {
                                        try {
                                            d0Var.close();
                                        } catch (IOException e6) {
                                            a0.a.m(e6, new StringBuilder("stats stream close failed: "), "TunnelManager");
                                        }
                                        break;
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Exception e7) {
                            e = e7;
                        }
                    } catch (RuntimeException e8) {
                        Log.w("TunnelManager", "connection stats serialization failed: " + e8.getMessage());
                        return;
                    }
                    break;
                } while (!zIsEmpty);
                return;
            case 11:
                cf cfVar3 = (cf) this.f3595d;
                af afVar = (af) this.f3596e;
                if (cfVar3.f3715l0 == afVar) {
                    if (cfVar3.f3694b.get() && cfVar3.f3706h == h2.c.f1965h) {
                        return;
                    }
                    long jMax = Math.max(0L, SystemClock.elapsedRealtime() - afVar.f3517b);
                    if (jMax >= 1500) {
                        boolean zL = c2.p.l(cfVar3.B0, afVar.f3518c, afVar.f3519d, afVar.f3516a);
                        cfVar3.f3715l0 = null;
                        long j3 = zL ? 200L : afVar.f3520e;
                        Log.i("TunnelManager", "screen-off fast recovery deadline controlReady=false pulseArmed=" + zL + " recoveryAgeMs=" + jMax + " nextDelayMs=" + j3);
                        cfVar3.a0(j3, new ge(cfVar3, 6));
                        return;
                    }
                    return;
                }
                return;
            case 12:
                cf cfVar4 = (cf) this.f3595d;
                e2.h1 h1Var = (e2.h1) this.f3596e;
                d2.t tVar2 = cfVar4.T;
                synchronized (tVar2) {
                    try {
                        h1Var.getClass();
                        if (!(h1Var instanceof e2.d1) && h1Var.b() >= tVar2.f612c) {
                            try {
                                if (h1Var.b() > tVar2.f612c) {
                                    ((ve) tVar2.f613d).g(h1Var.b());
                                }
                                if (h1Var instanceof e2.v1) {
                                    ((ve) tVar2.f613d).c((e2.v1) h1Var);
                                } else if (h1Var instanceof e2.w1) {
                                    ((ve) tVar2.f613d).i(((e2.w1) h1Var).f1070b, ((e2.w1) h1Var).f1069a);
                                } else if (h1Var instanceof e2.t1) {
                                    ((ve) tVar2.f613d).b((e2.t1) h1Var);
                                } else if (h1Var instanceof e2.z0) {
                                    ((ve) tVar2.f613d).d((e2.z0) h1Var);
                                } else if (h1Var instanceof e2.y0) {
                                    ((ve) tVar2.f613d).h(((e2.y0) h1Var).f1088c, ((e2.y0) h1Var).f1087b);
                                } else if (h1Var instanceof e2.c1) {
                                    ((ve) tVar2.f613d).a((e2.c1) h1Var);
                                } else if (!(h1Var instanceof e2.d1)) {
                                    throw new h1.a();
                                }
                                if (h1Var instanceof e2.c1) {
                                    c1Var = (e2.c1) h1Var;
                                } else if (!(h1Var instanceof e2.v1) && !(h1Var instanceof e2.w1) && h1Var.b() <= tVar2.f612c) {
                                    c1Var = (e2.c1) tVar2.f614e;
                                }
                                tVar2.f614e = c1Var;
                                tVar2.f612c = h1Var.b();
                            } catch (Throwable unused) {
                            }
                        }
                        z2 = false;
                    } catch (Throwable th4) {
                        throw th4;
                    }
                }
                Log.i("TunnelManager", "RTC control-plane received type=" + h1Var.a() + " generation=" + h1Var.b() + " accepted=" + z2);
                return;
            case 13:
                ve veVar = (ve) this.f3595d;
                if (((g2.k0) this.f3596e) == veVar.f5338c.D && (screenMirrorService = veVar.f5338c.f3731u0) != null) {
                    screenMirrorService.W5();
                    return;
                }
                return;
            case 14:
                ye yeVar = (ye) this.f3595d;
                Network network = (Network) this.f3596e;
                cf cfVar5 = yeVar.f5651b;
                if (!network.equals(cfVar5.f3716m)) {
                    cf.a(cfVar5, cfVar5.d0());
                    return;
                } else {
                    cfVar5.f3716m = null;
                    cf.a(cfVar5, new n6(cfVar5.f3712k.incrementAndGet(), "", false, false));
                    return;
                }
            case 15:
                sf sfVar = (sf) this.f3595d;
                f2 f2Var = (f2) this.f3596e;
                d8 d8Var = wf.P;
                b8 b8Var = sfVar.f5107i;
                d8Var.r();
                if (d8Var.c(b8Var) && b8Var.f3579d == f2Var) {
                    b8Var.f3579d = null;
                    return;
                }
                return;
            case 16:
                sf sfVar2 = (sf) this.f3595d;
                f2 f2Var2 = (f2) this.f3596e;
                d8 d8Var2 = wf.P;
                b8 b8Var2 = sfVar2.f5107i;
                d8Var2.r();
                if (d8Var2.c(b8Var2) && b8Var2.f3580e == f2Var2) {
                    b8Var2.f3580e = null;
                    b8Var2.f3581f = null;
                    if (b8Var2 == d8Var2.f3803f && b8Var2.f3583h && d8Var2.f3800c == 5) {
                        d8Var2.f3800c = 4;
                        return;
                    }
                    return;
                }
                return;
            case 17:
                ag agVar = (ag) this.f3595d;
                yf yfVar = (yf) this.f3596e;
                if (agVar.f3526g || agVar.f3525f != yfVar) {
                    return;
                }
                try {
                    ScreenMirrorService screenMirrorService8 = agVar.f3523d.f3821a;
                    rd rdVar7 = ScreenMirrorService.n6;
                    zB4 = screenMirrorService8.b4();
                    break;
                } catch (Throwable unused2) {
                }
                agVar.d(yfVar, zB4);
                return;
            case 18:
                x1.w wVar = (x1.w) this.f3595d;
                f2.q0 q0Var = (f2.q0) this.f3596e;
                if (wVar.c()) {
                    wVar.a(q0Var.f1309b, q0Var.f1310c, q0Var.f1308a, "unlock-recheck");
                    return;
                } else {
                    wVar.f(q0Var.f1309b, q0Var.f1310c, q0Var.f1308a);
                    return;
                }
            default:
                z.p pVar = (z.p) this.f3595d;
                a0.l lVar = (a0.l) this.f3596e;
                if (pVar.f6259c.f32c instanceof a0.b) {
                    lVar.cancel(true);
                    return;
                } else {
                    lVar.k(pVar.f6262f.a());
                    return;
                }
        }
    }
}
