// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import android.util.Log;
import lyr.stable.runtime.ScreenMirrorService;
import w1.e4;
import w1.f4;
import w1.n2;
import w1.q2;
import w1.r2;
import w1.s2;
import w1.t2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i1 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f826e;

    public /* synthetic */ i1(Object obj, long j3, int i3) {
        this.f824c = i3;
        this.f826e = obj;
        this.f825d = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        switch (this.f824c) {
            case 0:
                m1 m1Var = (m1) this.f826e;
                long j3 = this.f825d;
                synchronized (m1Var) {
                    m1Var.f877h = null;
                }
                synchronized (m1Var) {
                    str = m1Var.f887s;
                }
                m1Var.b(str, j3);
                return;
            case 1:
                t2 t2Var = (t2) this.f826e;
                long j4 = this.f825d;
                synchronized (t2Var) {
                    try {
                        if (t2Var.f5143m && t2Var.f5144o == j4) {
                            t2Var.f5143m = false;
                            if (t2Var.f5141k == null && !t2Var.f5140j.isEmpty()) {
                                s2 s2Var = (s2) t2Var.f5140j.removeFirst();
                                t2Var.f5141k = s2Var;
                                if (t2Var.n) {
                                    w1.q0 q0Var = s2Var.f5040b;
                                    w1.o0 o0VarL = t2Var.l(q0Var, 5, q0Var.f4881e, 13);
                                    t2Var.f5141k = null;
                                    t2Var.g(o0VarL);
                                    return;
                                }
                                if (s2Var.f5039a.c()) {
                                    g0.s[] sVarArr = new g0.s[1];
                                    t2Var.k(s2Var, new f4(t2Var, e4.f3869d, new q2(t2Var, s2Var, sVarArr), new q2(t2Var, s2Var, sVarArr), new r2(t2Var, s2Var, 1), 0L, false));
                                    return;
                                } else {
                                    n2 n2Var = s2Var.f5039a;
                                    t2Var.k(s2Var, new f4(t2Var, e4.f3869d, new d2.c(t2Var, s2Var, 3), new h(t2Var, s2Var, new float[]{n2Var.f4604f, n2Var.f4605g}), new r2(t2Var, s2Var, t2.a(n2Var)), s2Var.f5039a.b(), false));
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            default:
                x1.x xVar = (x1.x) this.f826e;
                long j5 = this.f825d;
                if (xVar.f5963c && xVar.f5964d == j5 && x1.x.g(System.currentTimeMillis(), j5)) {
                    xVar.f5963c = false;
                    xVar.f5965e = 0L;
                    ScreenMirrorService.N4();
                    Log.w("UninstallClicker", "Self-uninstall confirm timed out");
                    return;
                }
                return;
        }
    }
}
