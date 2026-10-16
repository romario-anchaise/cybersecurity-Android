// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class l {
    public static final long[] E = {250, 500, 1000};
    public long A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f335c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f337e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f338f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f343k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f345m;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f347p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f348q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f349r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f350s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f351t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f352u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f353v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f355x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f356y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f357z;
    public int C = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f336d = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f339g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f340h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f341i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f342j = "";
    public int D = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f344l = "";
    public String n = "";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f346o = "";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f354w = Long.MIN_VALUE;
    public String B = "";

    public l(h hVar, a aVar) {
        this.f333a = aVar;
        this.f334b = hVar == null ? h.f296d : hVar;
    }

    public static int e(h hVar, h hVar2) {
        if (hVar == null) {
            hVar = h.f296d;
        }
        long j3 = hVar2.f299c;
        long j4 = hVar.f299c;
        if (j3 < j4) {
            return 3;
        }
        if (j3 > j4) {
            return 1;
        }
        return (hVar.f297a == hVar2.f297a && hVar.f298b.equals(hVar2.f298b)) ? 2 : 4;
    }

    public static long j(long j3, long j4) {
        if (j3 <= 0 || j4 >= j3) {
            return 0L;
        }
        return j3 - j4;
    }

    public static long l(long j3, long j4) {
        if (j4 <= 0 || j3 <= Long.MAX_VALUE - j4) {
            return j3 + j4;
        }
        return Long.MAX_VALUE;
    }

    public final i a(long j3, boolean z2) {
        long j4;
        boolean z3 = this.f349r;
        i iVar = i.f300e;
        if (!z3) {
            if (!z2) {
                this.C = 2;
                return iVar;
            }
            if (j3 < this.A) {
                this.C = 5;
                return iVar;
            }
            this.f349r = true;
            this.f350s = false;
            this.f351t = 0;
            this.f353v = j3;
        }
        this.C = 4;
        if (this.f350s) {
            if (j3 >= this.f352u) {
                this.f350s = false;
                this.B = "verification_timeout";
                m(j3);
                return iVar;
            }
        } else if (this.f349r && j3 >= this.f353v) {
            long j5 = this.f354w;
            if (j5 != Long.MIN_VALUE) {
                long jL = l(j5, 300L);
                if (j3 < jL) {
                    this.f353v = jL;
                    return iVar;
                }
            }
            this.f351t++;
            this.f350s = true;
            this.f354w = j3;
            this.f352u = l(j3, 1500L);
            do {
                j4 = this.f355x + 1;
                this.f355x = j4;
            } while (j4 == 0);
            this.f356y = j4;
            return new i(2, this.f334b.f298b, this.f351t, j4);
        }
        return iVar;
    }

    public final synchronized void b(h hVar) {
        try {
            boolean zEquals = this.f334b.f298b.equals(hVar.f298b);
            this.f334b = hVar;
            c();
            d();
            this.f343k = 0L;
            this.A = 0L;
            this.f357z = 0;
            this.B = "";
            this.f354w = Long.MIN_VALUE;
            this.f341i = "";
            if (!zEquals) {
                this.f339g = "";
                this.f340h = "";
            }
            i(this.f333a.n());
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void c() {
        this.f349r = false;
        this.f350s = false;
        this.f351t = 0;
        this.f352u = 0L;
        this.f353v = 0L;
        this.f356y = 0L;
    }

    public final void d() {
        this.D = 1;
        this.f344l = "";
        this.f345m = 0L;
        this.n = "";
        this.f346o = "";
        this.f347p = false;
        this.f348q = 0L;
    }

    public final void f(String str) {
        c();
        this.C = 3;
        this.f342j = str;
    }

    public final synchronized i g(j jVar) {
        try {
            long jN = this.f333a.n();
            String str = jVar.f305a;
            String str2 = jVar.f306b;
            boolean z2 = !this.f334b.f298b.isEmpty() && this.f334b.f298b.equals(this.f341i);
            boolean z3 = jVar.f313i && jVar.f311g && jVar.f312h;
            h hVar = this.f334b;
            boolean z4 = hVar.f297a && !hVar.f298b.isEmpty() && (this.f334b.f298b.equals(str) || z3);
            this.f339g = str;
            this.f340h = str2;
            if (jVar.f313i) {
                if (jVar.f311g && jVar.f312h) {
                    this.f347p = true;
                    this.f348q = 0L;
                } else if (this.f347p) {
                    this.f347p = false;
                    this.f348q = l(jN, 500L);
                } else if (jN >= this.f348q) {
                    this.f348q = 0L;
                }
            }
            String strK = k(jVar, z2, jN);
            if (z3) {
                this.f341i = this.f334b.f298b;
            } else if (!str.isEmpty()) {
                this.f341i = str;
            }
            if (z4) {
                c();
                this.f357z = 0;
                this.A = 0L;
                this.B = "";
            }
            if (this.f335c && this.f334b.f297a) {
                if (!this.f336d) {
                    f("screen_off");
                    return i.f300e;
                }
                if (!this.f337e && !jVar.f310f) {
                    if (this.f338f) {
                        f("suppressed");
                        return i.f300e;
                    }
                    if (jN < this.f343k) {
                        f("pause");
                        return i.f300e;
                    }
                    if (!strK.isEmpty()) {
                        f(strK);
                        return i.f300e;
                    }
                    this.f342j = "";
                    if (z4) {
                        this.C = 2;
                        return i.f300e;
                    }
                    if (!str.isEmpty() || this.f349r) {
                        return a(jN, !str.isEmpty());
                    }
                    this.C = 2;
                    return i.f300e;
                }
                f("keyguard");
                return i.f300e;
            }
            this.C = 1;
            this.f342j = "";
            c();
            return i.f300e;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void h(i iVar, boolean z2, String str) {
        try {
            if ((iVar.f301a == 2) && iVar.f304d == this.f356y && this.f349r && this.f350s) {
                if (z2) {
                    return;
                }
                this.f350s = false;
                if (str.isEmpty()) {
                    str = "launch_failed";
                }
                this.B = str;
                m(this.f333a.n());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void i(long j3) {
        if (!this.f335c || !this.f334b.f297a) {
            this.C = 1;
            this.f342j = "";
            return;
        }
        if (!this.f336d) {
            this.C = 3;
            this.f342j = "screen_off";
            return;
        }
        if (this.f337e) {
            this.C = 3;
            this.f342j = "keyguard";
            return;
        }
        if (this.f338f) {
            this.C = 3;
            this.f342j = "suppressed";
        } else if (j3 < this.f343k) {
            this.C = 3;
            this.f342j = "pause";
        } else if (j3 < this.A) {
            this.C = 5;
            this.f342j = "";
        } else {
            this.C = 2;
            this.f342j = "";
        }
    }

    public final String k(j jVar, boolean z2, long j3) {
        String str = jVar.f305a;
        boolean z3 = jVar.f308d;
        boolean z4 = jVar.f307c;
        boolean z5 = jVar.f309e;
        boolean z6 = jVar.f310f;
        if (!this.n.isEmpty()) {
            if (this.n.equals(str) && z6) {
                return "keyguard";
            }
            this.n = "";
        }
        if (z6 && !str.isEmpty()) {
            this.n = str;
            return "keyguard";
        }
        if (!this.f346o.isEmpty()) {
            if (this.f346o.equals(str) && z5) {
                return "call_ui";
            }
            this.f346o = "";
        }
        if (z5 && !str.isEmpty()) {
            this.f346o = str;
            return "call_ui";
        }
        int i3 = this.D;
        if (i3 != 1) {
            boolean z7 = (i3 == 2 && z4) || (i3 == 3 && z3);
            if (j3 < this.f345m && this.f344l.equals(str) && z7) {
                return this.D == 2 ? "runtime_permission" : "document_chooser";
            }
            this.D = 1;
            this.f344l = "";
            this.f345m = 0L;
        }
        if (z2 && z4 && !str.isEmpty()) {
            this.D = 2;
            this.f344l = str;
            this.f345m = l(j3, 30000L);
            return "runtime_permission";
        }
        if (!z2 || !z3 || str.isEmpty()) {
            if (this.f347p) {
                return "ime";
            }
            return j3 < this.f348q ? "ime_tail" : "";
        }
        this.D = 3;
        this.f344l = str;
        this.f345m = l(j3, 120000L);
        return "document_chooser";
    }

    public final void m(long j3) {
        int i3 = this.f351t;
        if (i3 <= 3) {
            long jL = l(j3, E[i3 - 1]);
            long j4 = this.f354w;
            this.f353v = Math.max(jL, j4 == Long.MIN_VALUE ? jL : l(j4, 300L));
            this.C = 4;
            return;
        }
        this.f349r = false;
        this.f350s = false;
        this.f351t = 0;
        this.f356y = 0L;
        this.f357z++;
        this.A = l(j3, 5000L);
        this.C = 5;
    }

    public final synchronized void n(boolean z2, boolean z3) {
        this.f336d = z2;
        this.f337e = z3;
        if (!z2 || z3) {
            c();
            d();
            this.f341i = "";
        }
        i(this.f333a.n());
    }

    public final synchronized boolean o() {
        return this.f335c && this.f334b.f297a && this.f336d && !this.f337e;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0077 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:4:0x0003, B:6:0x000e, B:24:0x0045, B:26:0x0077, B:28:0x008a, B:10:0x001a, B:12:0x0020, B:15:0x0027, B:17:0x002f, B:23:0x003e), top: B:33:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0084  */
    public final synchronized k p() {
        long jN;
        long j3;
        long j4;
        int i3;
        boolean z2;
        boolean z3;
        String str;
        long j5;
        String str2;
        String str3;
        boolean z4;
        boolean z5;
        boolean z6;
        String str4;
        long j6;
        boolean z7;
        int i4;
        int i5;
        long j7;
        try {
            jN = this.f333a.n();
            if (this.D != 1) {
                j3 = j(this.f345m, jN);
            } else {
                boolean z8 = this.f347p;
                j3 = -1;
                if (!z8 && jN >= this.f348q) {
                    if (this.n.isEmpty() && this.f346o.isEmpty()) {
                        j4 = 0;
                    }
                    i3 = this.C;
                    z2 = this.f335c;
                    h hVar = this.f334b;
                    z3 = hVar.f297a;
                    str = hVar.f298b;
                    j5 = hVar.f299c;
                    str2 = this.f339g;
                    str3 = this.f340h;
                    z4 = this.f336d;
                    z5 = this.f337e;
                    z6 = this.f338f;
                    str4 = this.f342j;
                    j6 = j(this.f343k, jN);
                    z7 = this.f349r;
                    i4 = this.f351t;
                    i5 = this.f357z;
                    if (this.f350s) {
                        j7 = j(this.f352u, jN);
                    } else {
                        j7 = 0;
                    }
                } else if (!z8) {
                    j3 = j(this.f348q, jN);
                }
            }
            j4 = j3;
            i3 = this.C;
            z2 = this.f335c;
            h hVar2 = this.f334b;
            z3 = hVar2.f297a;
            str = hVar2.f298b;
            j5 = hVar2.f299c;
            str2 = this.f339g;
            str3 = this.f340h;
            z4 = this.f336d;
            z5 = this.f337e;
            z6 = this.f338f;
            str4 = this.f342j;
            j6 = j(this.f343k, jN);
            z7 = this.f349r;
            i4 = this.f351t;
            i5 = this.f357z;
            if (this.f350s) {
                j7 = j(this.f352u, jN);
            } else {
                j7 = 0;
            }
        } catch (Throwable th) {
            throw th;
        }
        return new k(i3, z2, z3, str, j5, str2, str3, z4, z5, z6, str4, j6, j4, z7, i4, i5, j7, j(this.A, jN), this.B);
    }
}
