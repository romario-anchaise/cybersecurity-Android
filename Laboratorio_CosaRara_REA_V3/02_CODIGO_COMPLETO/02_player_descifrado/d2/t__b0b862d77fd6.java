// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d2;

import e2.c1;
import e2.g1;
import e2.m1;
import e2.q0;
import e2.t1;
import e2.v1;
import e2.z0;
import lyr.stable.runtime.ScreenMirrorService;
import w1.ba;
import w1.f4;
import w1.g2;
import w1.h2;
import w1.m4;
import w1.v8;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements g1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f614e;

    public /* synthetic */ t(ScreenMirrorService screenMirrorService, long j3, Object obj) {
        this.f614e = screenMirrorService;
        this.f612c = j3;
        this.f613d = obj;
    }

    @Override // e2.g1
    public void a(c1 c1Var) {
        ScreenMirrorService.h((ScreenMirrorService) this.f614e, this.f612c, new q0(this, c1Var, (m1) this.f613d, 14));
    }

    @Override // e2.g1
    public void b(t1 t1Var) {
        ScreenMirrorService.h((ScreenMirrorService) this.f614e, this.f612c, new ba((m1) this.f613d, t1Var, 6));
    }

    @Override // e2.g1
    public void c(v1 v1Var) {
        ScreenMirrorService.h((ScreenMirrorService) this.f614e, this.f612c, new q0(this, v1Var, (m1) this.f613d, 13));
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003f  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a4  */
    public boolean e(g2 g2Var) {
        boolean z2;
        boolean z3;
        boolean asBoolean;
        m4 m4Var = (m4) this.f614e;
        f4 f4Var = (f4) this.f613d;
        long j3 = this.f612c;
        synchronized (m4Var) {
            boolean z4 = false;
            if (f4Var == m4Var.f4506c && f4Var.f3987h == 3 && j3 == f4Var.f3989j && j3 == m4Var.f4517o) {
                boolean z5 = true;
                if (f4Var.f3991l) {
                    z2 = true;
                    z5 = false;
                } else {
                    f4Var.f3991l = true;
                    if (f4Var.f3986g) {
                        m4Var.d();
                        if (m4Var.k(f4Var, false)) {
                            z2 = false;
                            z5 = false;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                        z5 = false;
                    }
                }
                if (z5 || z2) {
                    z3 = false;
                } else {
                    try {
                        asBoolean = g2Var.getAsBoolean();
                    } catch (Throwable unused) {
                        asBoolean = false;
                    }
                    z3 = asBoolean;
                    z2 = !asBoolean;
                }
                h2 h2Var = null;
                if (m4Var.f4506c == f4Var && f4Var.f3987h == 3 && j3 == f4Var.f3989j && j3 == m4Var.f4517o && (z5 || z2)) {
                    m4Var.d();
                    m4Var.f4506c = null;
                    m4Var.f4517o = 0L;
                    f4Var.f3987h = 4;
                    f4Var.f3988i.f4240a = 6;
                    h2 h2Var2 = f4Var.f3990k;
                    f4Var.f3990k = null;
                    if (z5) {
                        m4Var.f4521s++;
                    }
                    h2Var = h2Var2;
                    z4 = z5;
                } else {
                    z2 = false;
                }
                m4.i(h2Var);
                try {
                    if (!z4) {
                        if (z2) {
                            f4Var.f3984e.b0();
                        }
                        if (z4 || z2) {
                            m4Var.g();
                        }
                        return z3;
                    }
                    f4Var.f3984e.e0();
                } catch (Throwable unused2) {
                }
                if (z4) {
                    m4Var.g();
                } else {
                    m4Var.g();
                }
                return z3;
            }
            return false;
        }
    }

    @Override // e2.g1
    public void f() {
        ScreenMirrorService.h((ScreenMirrorService) this.f614e, this.f612c, new ba(this, (m1) this.f613d, 7));
    }

    @Override // e2.g1
    public void g(long j3) {
        ScreenMirrorService.h((ScreenMirrorService) this.f614e, this.f612c, new b2.b(this, (m1) this.f613d, j3, 6));
    }

    @Override // e2.g1
    public void i(String str, long j3) {
        ScreenMirrorService.h((ScreenMirrorService) this.f614e, this.f612c, new g2.m(this, (m1) this.f613d, j3, str, 2));
    }

    @Override // e2.g1
    public void j() {
        ScreenMirrorService.h((ScreenMirrorService) this.f614e, this.f612c, new v8(5, this));
    }

    @Override // e2.g1
    public void d(z0 z0Var) {
    }

    @Override // e2.g1
    public void h(String str, long j3) {
    }
}
