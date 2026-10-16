// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o1 f1027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p1.a f1028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p1.l f1029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p1.l f1030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p1.p f1031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f1032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f1033g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f1034h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public t0 f1035i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f1036j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f1037k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f1038l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f1039m;
    public long n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f1040o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f1041p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f1042q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f1043r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public b f1044s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f1045t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f1046u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f1047v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1048w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1049x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f1050y;

    public v0(o1 o1Var, p1.l lVar) {
        s0 s0Var = s0.f986k;
        z zVar = new z(1, a2.f711a, a2.class, "packetize", "packetize(Llyr/stable/runtime/rtc/WebpFrame;)Ljava/util/List;", 7);
        b2.a aVar = new b2.a(4);
        this.f1027a = o1Var;
        this.f1028b = s0Var;
        this.f1029c = zVar;
        this.f1030d = lVar;
        this.f1031e = aVar;
        this.f1032f = new Object();
    }

    /* JADX WARN: Code duplicated, block: B:31:0x007c A[Catch: all -> 0x0045, TRY_LEAVE, TryCatch #0 {all -> 0x0045, blocks: (B:4:0x0003, B:9:0x000d, B:13:0x0028, B:15:0x003f, B:29:0x0074, B:31:0x007c, B:20:0x004a, B:22:0x0058, B:23:0x005d, B:25:0x006a, B:27:0x006e, B:12:0x0023), top: B:40:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0083  */
    /* JADX WARN: Code duplicated, block: B:36:0x008a  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    public final void a(u0 u0Var, boolean z2) {
        c2 c2Var;
        u0 u0VarC;
        synchronized (this.f1032f) {
            try {
                if (this.f1033g != u0Var.f1012a) {
                    return;
                }
                long j3 = u0Var.f1014c;
                long jLongValue = ((Number) this.f1028b.d()).longValue();
                long j4 = jLongValue <= j3 ? 0L : (jLongValue - j3) / 1000000;
                this.f1042q = j4;
                this.f1043r = Math.max(this.f1043r, j4);
                if (b(u0Var.f1013b.f999a)) {
                    if (z2) {
                        this.f1038l++;
                        this.f1049x = 0;
                        this.f1050y = false;
                        if (!this.f1048w) {
                            this.f1048w = true;
                            c2Var = c2.f737c;
                        }
                    } else {
                        this.f1039m++;
                        int i3 = this.f1049x + 1;
                        this.f1049x = i3;
                        if (i3 >= 3 && !this.f1050y) {
                            this.f1050y = true;
                            c2Var = c2.f738d;
                        }
                    }
                    this.f1033g = 0L;
                    t0 t0Var = this.f1035i;
                    this.f1035i = null;
                    u0VarC = t0Var != null ? c(t0Var) : null;
                    if (c2Var != null) {
                        this.f1030d.f(c2Var);
                    }
                    if (u0VarC != null) {
                        d(u0VarC);
                    }
                }
                this.f1040o++;
                c2Var = null;
                this.f1033g = 0L;
                t0 t0Var2 = this.f1035i;
                this.f1035i = null;
                if (t0Var2 != null) {
                }
                if (c2Var != null) {
                    this.f1030d.f(c2Var);
                }
                if (u0VarC != null) {
                    d(u0VarC);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b(n0 n0Var) {
        return n0Var.f903b == b.f714e || n0Var.f904c >= this.f1046u;
    }

    public final u0 c(t0 t0Var) {
        long j3 = this.f1034h + 1;
        this.f1034h = j3;
        this.f1037k++;
        this.f1033g = j3;
        long jLongValue = ((Number) this.f1028b.d()).longValue();
        long j4 = t0Var.f1000b;
        this.f1041p = jLongValue <= j4 ? 0L : (jLongValue - j4) / 1000000;
        n0 n0Var = t0Var.f999a;
        this.f1044s = n0Var.f903b;
        this.f1045t = n0Var.f904c;
        return new u0(j3, t0Var, jLongValue);
    }

    public final void d(u0 u0Var) throws Exception {
        boolean z2;
        boolean z3;
        boolean z4;
        synchronized (this.f1032f) {
            z2 = this.f1033g == u0Var.f1012a && b(u0Var.f1013b.f999a);
        }
        if (!z2) {
            a(u0Var, false);
            return;
        }
        try {
            z1 z1Var = u0Var.f1013b.f999a.f902a;
            List list = (List) this.f1029c.f(z1Var);
            t0 t0Var = u0Var.f1013b;
            long j3 = t0Var.f1000b;
            n0 n0Var = t0Var.f999a;
            b2 b2Var = new b2(z1Var, list, j3, n0Var.f903b, n0Var.f904c);
            synchronized (this.f1032f) {
                z3 = !this.f1047v && this.f1033g == u0Var.f1012a && b(u0Var.f1013b.f999a);
            }
            if (!z3) {
                a(u0Var, false);
                return;
            }
            try {
                p1.p pVar = this.f1031e;
                n0 n0Var2 = u0Var.f1013b.f999a;
                pVar.e(n0Var2.f903b, Long.valueOf(n0Var2.f904c));
            } catch (Throwable unused) {
            }
            synchronized (this.f1032f) {
                z4 = !this.f1047v && this.f1033g == u0Var.f1012a && b(u0Var.f1013b.f999a);
            }
            if (!z4) {
                a(u0Var, false);
                return;
            }
            h hVar = new h(new AtomicBoolean(false), this, u0Var);
            try {
                this.f1027a.a(b2Var, hVar);
            } catch (Exception unused2) {
                hVar.f(Boolean.FALSE);
            } catch (OutOfMemoryError unused3) {
                hVar.f(Boolean.FALSE);
            }
        } catch (Exception e3) {
            a(u0Var, false);
            throw e3;
        } catch (OutOfMemoryError unused4) {
            a(u0Var, false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0056 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x0058 A[Catch: all -> 0x0031, TryCatch #0 {all -> 0x0031, blocks: (B:4:0x0017, B:8:0x001d, B:10:0x002b, B:13:0x0033, B:15:0x003b, B:16:0x0040, B:18:0x0044, B:20:0x004c, B:22:0x0050, B:24:0x0058, B:25:0x005d), top: B:32:0x0017 }] */
    public final void e(n0 n0Var) throws Exception {
        n0Var.getClass();
        t0 t0Var = new t0(n0Var, ((Number) this.f1028b.d()).longValue());
        synchronized (this.f1032f) {
            try {
                if (this.f1047v) {
                    return;
                }
                this.f1036j++;
                u0 u0VarC = null;
                if (!b(n0Var)) {
                    this.f1040o++;
                } else if (this.f1033g == 0) {
                    u0VarC = c(t0Var);
                } else {
                    t0 t0Var2 = this.f1035i;
                    if (t0Var2 != null) {
                        b bVar = t0Var2.f999a.f903b;
                        b bVar2 = b.f714e;
                        if (bVar != bVar2 || n0Var.f903b == bVar2) {
                            if (t0Var2 != null) {
                                this.n++;
                            }
                            this.f1035i = t0Var;
                        } else {
                            this.n++;
                        }
                    } else {
                        if (t0Var2 != null) {
                            this.n++;
                        }
                        this.f1035i = t0Var;
                    }
                }
                if (u0VarC != null) {
                    d(u0VarC);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
