// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import android.content.Intent;
import lyr.stable.runtime.ScreenMirrorService;
import w1.cf;
import w1.dc;
import w1.n3;
import w1.wc;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d2.t f987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dc f988b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y1 f991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a0 f992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f993g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f994h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f995i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f997k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f989c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q1 f990d = q1.f930c;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f996j = -1;

    public s1(d2.t tVar, dc dcVar) {
        this.f987a = tVar;
        this.f988b = dcVar;
    }

    public final void a(String str) {
        synchronized (this) {
            if (this.f997k) {
                return;
            }
            r1 r1VarD = d();
            this.f989c = -1L;
            h(r1VarD, str);
        }
    }

    public final boolean b(long j3, long j4, String str) {
        y1 y1Var;
        synchronized (this) {
            if (!this.f997k && j3 == this.f989c && j4 == this.f994h && (y1Var = this.f991e) != null && this.f990d != q1.f932e) {
                a0 a0Var = this.f992f;
                this.f991e = null;
                this.f992f = null;
                this.f994h = 0L;
                try {
                    y1Var.a(str);
                } catch (Throwable unused) {
                }
                if (a0Var == null) {
                    return true;
                }
                try {
                    a0Var.b();
                    return true;
                } catch (Throwable unused2) {
                    return true;
                }
            }
            return false;
        }
    }

    public final void c() {
        synchronized (this) {
            if (this.f997k) {
                return;
            }
            this.f997k = true;
            r1 r1VarD = d();
            this.f989c = -1L;
            h(r1VarD, "closed");
        }
    }

    public final r1 d() {
        r1 r1Var = new r1(this.f990d, this.f989c, this.f991e);
        this.f990d = q1.f930c;
        this.f991e = null;
        this.f992f = null;
        this.f994h = 0L;
        return r1Var;
    }

    public final boolean e() {
        boolean z2;
        synchronized (this) {
            z2 = !this.f997k && this.f989c >= 0;
        }
        return z2;
    }

    public final boolean f(long j3, long j4) {
        boolean z2;
        synchronized (this) {
            z2 = !this.f997k && j3 == this.f989c && j4 == this.f994h && this.f991e != null;
        }
        return z2;
    }

    public final void g(long j3) {
        boolean z2;
        synchronized (this) {
            if (!this.f997k && this.f989c == j3 && this.f990d == q1.f931d) {
                this.f990d = q1.f930c;
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (z2) {
            try {
                x1.a();
            } catch (Throwable unused) {
            }
            d2.t tVar = this.f987a;
            ScreenMirrorService.h((ScreenMirrorService) tVar.f614e, tVar.f612c, new wc(j3, (m1[]) tVar.f613d, 2));
        }
    }

    public final void h(r1 r1Var, String str) {
        y1 y1Var = r1Var.f960c;
        long j3 = r1Var.f959b;
        if (y1Var != null) {
            try {
                y1Var.a(str);
            } catch (Throwable unused) {
            }
        }
        if (r1Var.f958a != q1.f931d || j3 < 0) {
            return;
        }
        try {
            x1.a();
        } catch (Throwable unused2) {
        }
        try {
            this.f988b.k(str, j3);
        } catch (Throwable unused3) {
        }
    }

    public final boolean i(long j3, Intent intent) {
        boolean zJ;
        boolean z2;
        boolean z3;
        synchronized (this) {
            if (!this.f997k && j3 >= this.f989c) {
                r1 r1VarD = d();
                this.f989c = j3;
                h(r1VarD, "projection_switch");
                try {
                    zJ = this.f988b.j(j3, intent);
                } catch (Throwable unused) {
                    zJ = false;
                }
                if (!zJ) {
                    d2.t tVar = this.f987a;
                    ScreenMirrorService.h((ScreenMirrorService) tVar.f614e, tVar.f612c, new wc((m1[]) tVar.f613d, j3));
                    return false;
                }
                synchronized (this) {
                    if (!this.f997k && this.f989c == j3 && this.f990d == q1.f930c) {
                        this.f990d = q1.f931d;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
                if (!z2) {
                    this.f988b.k("stale_projection_start", j3);
                    return false;
                }
                try {
                    cf cfVarK = cf.K();
                    synchronized (cfVarK.C) {
                        cfVarK.I = false;
                    }
                    cfVarK.V();
                    z3 = true;
                } catch (Throwable unused2) {
                    z3 = false;
                }
                if (z3) {
                    d2.t tVar2 = this.f987a;
                    ScreenMirrorService.h((ScreenMirrorService) tVar2.f614e, tVar2.f612c, new b2.b((m1[]) tVar2.f613d, j3, h0.f813d, 8));
                    d2.t tVar3 = this.f987a;
                    ScreenMirrorService.h((ScreenMirrorService) tVar3.f614e, tVar3.f612c, new b2.b(tVar3, j3, (m1[]) tVar3.f613d, 9));
                    return true;
                }
                synchronized (this) {
                    if (this.f989c == j3 && this.f990d == q1.f931d) {
                        this.f990d = q1.f930c;
                    }
                }
                this.f988b.k("video_route_failed", j3);
                d2.t tVar4 = this.f987a;
                ScreenMirrorService.h((ScreenMirrorService) tVar4.f614e, tVar4.f612c, new wc((m1[]) tVar4.f613d, j3));
                return false;
            }
            return false;
        }
    }

    public final void j(n3 n3Var) {
        n3Var.getClass();
        synchronized (this) {
            if (!this.f997k) {
                q1 q1Var = this.f990d;
                q1 q1Var2 = q1.f931d;
            }
        }
    }

    public final b0 k() {
        b0 b0VarC;
        synchronized (this) {
            a0 a0Var = this.f992f;
            b0VarC = a0Var != null ? a0Var.c() : null;
        }
        return b0VarC;
    }
}
