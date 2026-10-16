// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import android.util.Log;
import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import lyr.stable.runtime.ScreenMirrorService;
import w1.aa;
import w1.bd;
import w1.cf;
import w1.dc;
import w1.fc;
import w1.j6;
import w1.q9;
import w1.r9;
import w1.wc;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s1 f870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final aa f871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n1 f872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dc f873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final aa f874e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public v1 f876g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g f877h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g f878i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f880k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f882m;
    public boolean n;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public l1 f886r;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public h0 f892x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f893y;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f875f = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f879j = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f881l = "";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public j0 f883o = j0.f828e;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public l1 f884p = l1.f863f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public h0 f885q = h0.f815f;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f887s = "bootstrap";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public k0 f888t = k0.f841d;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public l0 f889u = l0.f851d;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public i0 f890v = i0.f819d;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f891w = "";

    public m1(s1 s1Var, aa aaVar, n1 n1Var, dc dcVar, aa aaVar2) {
        this.f870a = s1Var;
        this.f871b = aaVar;
        this.f872c = n1Var;
        this.f873d = dcVar;
        this.f874e = aaVar2;
    }

    public static void c(k1 k1Var) {
        g gVar = k1Var.f847a;
        if (gVar != null) {
            gVar.a();
        }
        g gVar2 = k1Var.f848b;
        if (gVar2 != null) {
            gVar2.a();
        }
    }

    public final void a(long j3, l0 l0Var, i0 i0Var) {
        boolean zH = h();
        synchronized (this) {
            try {
                if (!this.n && j3 == this.f875f && this.f876g != null) {
                    g gVarE = e();
                    this.f885q = h0.f815f;
                    this.f886r = null;
                    this.f888t = k0.f843f;
                    this.f889u = l0Var;
                    if (zH) {
                        i0Var = i0.f821f;
                    }
                    this.f890v = i0Var;
                    this.f892x = h0.f814e;
                    if (gVarE != null) {
                        gVarE.a();
                    }
                    j();
                    l(j3, zH ? 0L : 500L);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:143:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:171:0x0207  */
    /* JADX WARN: Code duplicated, block: B:175:0x020f  */
    /* JADX WARN: Code duplicated, block: B:185:0x0230  */
    /* JADX WARN: Code duplicated, block: B:188:0x0234  */
    /* JADX WARN: Code duplicated, block: B:194:0x023e  */
    /* JADX WARN: Code duplicated, block: B:207:0x025d  */
    /* JADX WARN: Code duplicated, block: B:262:0x0213 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:273:0x0242 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:277:0x0208 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:280:? A[RETURN, SYNTHETIC] */
    public final void b(String str, long j3) {
        boolean z2;
        v1 v1Var;
        boolean z3;
        s1 s1Var;
        long j4;
        g gVarE;
        boolean z4;
        g gVarE2;
        boolean z5;
        bd bdVar;
        g2.m0 m0Var;
        boolean zD;
        boolean z6;
        boolean z7;
        Long lValueOf;
        synchronized (this) {
            z2 = !this.n && j3 == this.f875f && q1.e.a(this.f887s, str) && this.f876g != null && this.f892x == h0.f814e;
        }
        if (z2) {
            fc fcVar = (fc) this.f871b.d();
            if (fcVar == null) {
                synchronized (this) {
                    try {
                        if (!this.n && j3 == this.f875f && q1.e.a(this.f887s, str)) {
                            int i3 = this.f882m;
                            if (i3 >= 8) {
                                this.f888t = k0.f844g;
                                this.f889u = l0.f854g;
                                this.f892x = null;
                                lValueOf = -1L;
                            } else {
                                this.f882m = i3 + 1;
                                if (i3 > 4) {
                                    i3 = 4;
                                }
                                long j5 = 500 << i3;
                                if (j5 > 5000) {
                                    j5 = 5000;
                                }
                                lValueOf = Long.valueOf(j5);
                            }
                        } else {
                            lValueOf = null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (lValueOf != null) {
                    if (lValueOf.longValue() >= 0) {
                        l(j3, lValueOf.longValue());
                        return;
                    }
                    j();
                    this.f873d.f3821a.c4 = null;
                    Log.e("ScreenMirror", "RTC fallback failed generation=" + j3);
                    return;
                }
                return;
            }
            synchronized (this) {
                v1Var = (!this.n && j3 == this.f875f && q1.e.a(this.f887s, str) && this.f892x == h0.f814e) ? this.f876g : null;
            }
            if (v1Var == null) {
                fcVar.b();
                return;
            }
            s1 s1Var2 = this.f870a;
            d2.o oVar = new d2.o(3, this);
            try {
                y1 y1Var = new y1();
                q1.h hVar = new q1.h();
                synchronized (s1Var2) {
                    if (!s1Var2.f997k && v1Var.f1051a >= s1Var2.f989c) {
                        r1 r1VarD = s1Var2.d();
                        s1Var2.f989c = v1Var.f1051a;
                        long j6 = s1Var2.f993g + 1;
                        s1Var2.f993g = j6;
                        hVar.f3127c = j6;
                        s1Var2.f994h = j6;
                        s1Var2.f991e = y1Var;
                        s1Var2.h(r1VarD, "webp_switch");
                        if (r1VarD.f958a != q1.f931d) {
                            try {
                                cf cfVarK = cf.K();
                                synchronized (cfVarK.C) {
                                    try {
                                        cfVarK.I = true;
                                        bdVar = cfVarK.E;
                                        m0Var = cfVarK.F;
                                        cfVarK.E = null;
                                        cfVarK.F = null;
                                    } catch (Throwable unused) {
                                    }
                                }
                                if (bdVar != null) {
                                    bdVar.a();
                                }
                                cf.o(m0Var);
                                j6.d("hybrid:h264");
                            } catch (Throwable unused2) {
                            }
                        }
                        a0 a0Var = new a0(fcVar, oVar, new o1(s1Var2, v1Var, hVar), new o1(s1Var2, v1Var, hVar));
                        try {
                            zD = y1Var.d(a0Var);
                        } catch (Throwable unused3) {
                            zD = false;
                        }
                        if (zD) {
                            synchronized (s1Var2) {
                                if (s1Var2.f997k) {
                                    z6 = false;
                                    z3 = false;
                                } else {
                                    long j7 = s1Var2.f989c;
                                    long j8 = v1Var.f1051a;
                                    if (j7 == j8 && s1Var2.f994h == hVar.f3127c && s1Var2.f991e == y1Var) {
                                        s1Var2.f992f = a0Var;
                                        z6 = s1Var2.f995i > 0 && s1Var2.f996j == j8;
                                        z3 = true;
                                    } else {
                                        z6 = false;
                                        z3 = false;
                                    }
                                }
                            }
                            if (!z3) {
                                a0Var.b();
                            } else if (z6) {
                                try {
                                    synchronized (a0Var.f707f) {
                                        if (!a0Var.f704c.get()) {
                                            a0Var.a();
                                        }
                                    }
                                } catch (Throwable unused4) {
                                }
                            }
                        } else {
                            synchronized (s1Var2) {
                                if (s1Var2.f989c == v1Var.f1051a && s1Var2.f994h == hVar.f3127c && s1Var2.f991e == y1Var) {
                                    s1Var2.f991e = null;
                                    s1Var2.f994h = 0L;
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                            }
                            if (z7) {
                                y1Var.a("webp_start_failed");
                                a0Var.b();
                                d2.t tVar = s1Var2.f987a;
                                ScreenMirrorService.h((ScreenMirrorService) tVar.f614e, tVar.f612c, new wc((m1[]) tVar.f613d, v1Var.f1051a));
                            }
                        }
                        if (z3) {
                            synchronized (this) {
                                gVarE2 = e();
                            }
                            if (gVarE2 != null) {
                                gVarE2.a();
                            }
                            synchronized (this) {
                                if (this.f875f == j3 || !q1.e.a(this.f887s, str)) {
                                    z5 = false;
                                } else {
                                    this.f888t = k0.f844g;
                                    this.f889u = l0.f856i;
                                    this.f892x = null;
                                    z5 = true;
                                }
                            }
                            if (z5) {
                                j();
                            }
                        }
                        s1Var = this.f870a;
                        synchronized (s1Var) {
                            if (s1Var.f997k && j3 == s1Var.f989c && s1Var.f991e != null) {
                                j4 = s1Var.f994h;
                            } else {
                                j4 = 0;
                            }
                        }
                        if (j4 > 0 || !this.f870a.f(j3, j4)) {
                            return;
                        }
                        ScheduledFuture<?> scheduledFutureSchedule = ((ScheduledExecutorService) this.f872c.f905c).schedule(new j1(this, j3, str, j4, 0), 15000L, TimeUnit.MILLISECONDS);
                        scheduledFutureSchedule.getClass();
                        g gVar = new g(scheduledFutureSchedule, 1);
                        synchronized (this) {
                            if (!this.n && this.f875f == j3 && q1.e.a(this.f887s, str) && this.f892x == h0.f814e && this.f888t == k0.f843f) {
                                gVarE = e();
                                this.f878i = gVar;
                                this.f879j = j3;
                                this.f880k = j4;
                                this.f881l = str;
                                z4 = false;
                            } else {
                                gVarE = null;
                                z4 = true;
                            }
                        }
                        if (gVarE != null) {
                            gVarE.a();
                        }
                        if (z4) {
                            gVar.a();
                            return;
                        }
                        return;
                    }
                    y1Var.a("stale_webp_start");
                    fcVar.b();
                }
            } catch (Throwable unused5) {
                fcVar.b();
            }
            z3 = false;
            if (z3) {
                s1Var = this.f870a;
                synchronized (s1Var) {
                    if (s1Var.f997k) {
                        j4 = 0;
                    } else {
                        j4 = 0;
                    }
                    if (j4 > 0) {
                        return;
                    } else {
                        return;
                    }
                }
            }
            synchronized (this) {
                gVarE2 = e();
                if (gVarE2 != null) {
                    gVarE2.a();
                }
                synchronized (this) {
                    if (this.f875f == j3) {
                        z5 = false;
                    } else {
                        z5 = false;
                    }
                    if (z5) {
                        j();
                    }
                }
            }
        }
    }

    public final void d() {
        synchronized (this) {
            if (this.n) {
                return;
            }
            this.n = true;
            k1 k1VarF = f();
            this.f875f = -1L;
            this.f876g = null;
            k();
            c(k1VarF);
            this.f870a.c();
            ((ScheduledExecutorService) this.f872c.f905c).shutdownNow();
        }
    }

    public final g e() {
        g gVar = this.f878i;
        this.f878i = null;
        this.f879j = -1L;
        this.f880k = 0L;
        this.f881l = "";
        return gVar;
    }

    public final k1 f() {
        g gVar = this.f877h;
        this.f877h = null;
        return new k1(gVar, e());
    }

    public final void g(long j3, String str, l0 l0Var) {
        boolean z2;
        synchronized (this) {
            if (!this.n && j3 == this.f875f && q1.e.a(str, this.f887s) && this.f883o == j0.f829f && this.f888t == k0.f842e) {
                this.f888t = k0.f844g;
                this.f889u = l0Var;
                this.f890v = i0.f819d;
                this.f892x = null;
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (z2) {
            j();
        }
    }

    public final boolean h() {
        try {
            return b1.i(this.f873d.f3821a.getApplicationContext()).f1015a == 2;
        } catch (Throwable unused) {
            return true;
        }
    }

    public final void i(long j3, long j4) {
        boolean z2;
        g gVar;
        synchronized (this) {
            try {
                z2 = false;
                gVar = null;
                if (!this.n && j3 == this.f875f && this.f870a.f(j3, j4)) {
                    g gVarE = e();
                    this.f885q = h0.f814e;
                    this.f886r = l1.f863f;
                    this.f888t = k0.f841d;
                    l0 l0Var = this.f889u;
                    if (l0Var != l0.f855h && l0Var != l0.f857j) {
                        this.f889u = l0.f851d;
                    }
                    this.f890v = h() ? i0.f821f : i0.f819d;
                    this.f892x = null;
                    this.f882m = 0;
                    z2 = true;
                    gVar = gVarE;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (gVar != null) {
            gVar.a();
        }
        if (z2) {
            j();
            Log.i("ScreenMirror", "RTC media ready generation=" + j3);
        }
    }

    public final void j() {
        d1 d1VarM;
        q9 q9Var;
        boolean z2;
        synchronized (this) {
            d1VarM = (this.n || this.f875f < 0) ? null : m();
        }
        if (d1VarM == null) {
            return;
        }
        cf cfVarK = cf.K();
        r9 r9Var = cfVarK.S;
        synchronized (r9Var) {
            q9Var = r9Var.f5002c;
        }
        if (q9Var == null) {
            Log.w("TunnelManager", "RTC capture status dropped: no control stream");
            return;
        }
        r9 r9Var2 = cfVarK.S;
        synchronized (r9Var2) {
            try {
                z2 = false;
                if (r9Var2.b(q9Var)) {
                    Object obj = q9Var.f4931e;
                    synchronized (obj) {
                        synchronized (r9Var2) {
                            if (r9Var2.b(q9Var)) {
                                g2.d0 d0Var = (g2.d0) q9Var.f4927a;
                                try {
                                    f1.j(d0Var.f1578k, d1VarM, q9Var.f4932f);
                                    z2 = true;
                                } catch (IOException unused) {
                                    cfVarK.S.c(q9Var);
                                    try {
                                        d0Var.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Log.i("TunnelManager", "RTC capture status type=" + d1VarM.f752e + " generation=" + d1VarM.f748a + " requestId=" + d1VarM.f749b + " sent=" + z2);
    }

    public final void k() {
        this.f882m = 0;
        this.f883o = j0.f828e;
        this.f884p = l1.f863f;
        this.f885q = h0.f815f;
        this.f886r = null;
        this.f887s = "bootstrap";
        this.f888t = k0.f841d;
        this.f889u = l0.f851d;
        this.f890v = i0.f819d;
        this.f891w = "";
        this.f892x = null;
        this.f893y = null;
    }

    public final void l(long j3, long j4) {
        boolean z2;
        n1 n1Var = this.f872c;
        ScheduledFuture<?> scheduledFutureSchedule = ((ScheduledExecutorService) n1Var.f905c).schedule(new i1(this, j3, 0), j4, TimeUnit.MILLISECONDS);
        scheduledFutureSchedule.getClass();
        g gVar = new g(scheduledFutureSchedule, 1);
        synchronized (this) {
            if (!this.n && this.f875f == j3 && this.f877h == null) {
                this.f877h = gVar;
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (z2) {
            gVar.a();
        }
    }

    public final d1 m() {
        long j3 = this.f875f;
        String str = this.f887s;
        j0 j0Var = this.f883o;
        String str2 = j0Var.f832c;
        String str3 = this.f885q.f817c;
        String str4 = this.f888t.f846c;
        String str5 = this.f889u.f860c;
        String str6 = j0Var == j0.f830g ? this.f884p.f865c : "h264";
        l1 l1Var = this.f886r;
        String str7 = l1Var != null ? l1Var.f865c : null;
        if (str7 == null) {
            str7 = "";
        }
        return new d1(j3, str, str2, str3, str4, str5, str6, str7, this.f890v.f823c, this.f891w);
    }
}
