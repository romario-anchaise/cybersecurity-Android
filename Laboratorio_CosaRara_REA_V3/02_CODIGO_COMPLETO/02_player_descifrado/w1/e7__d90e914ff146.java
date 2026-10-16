// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e7 {
    public long B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public long I;
    public long J;
    public long K;
    public long L;
    public long M;
    public long N;
    public long O;
    public long P;
    public long Q;
    public long R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3879d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f3880e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f3881f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f3882g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f3883h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f3884i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f3885j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f3886k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f3887l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f3888m;
    public long n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f3889o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f3890p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f3891q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f3892r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3893s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f3894t = "";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final p2.x f3895u = new p2.x(1);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final p2.x f3896v = new p2.x(1);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final p2.x f3897w = new p2.x(1);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final p2.x f3898x = new p2.x(1);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final p2.x f3899y = new p2.x(1);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final p2.x f3900z = new p2.x(1);
    public final p2.x A = new p2.x(1);

    public final synchronized void a(long j3, long j4, long j5, long j6, long j7, long j8, long j9, int i3, int i4, int i5, String str, boolean z2) {
        try {
            this.f3876a++;
            if (!z2) {
                this.f3877b++;
            }
            this.f3878c += Math.max(0L, j3);
            this.f3879d = Math.max(this.f3879d, Math.max(0L, j3));
            this.f3880e += Math.max(0L, j4);
            this.f3881f = Math.max(this.f3881f, Math.max(0L, j4));
            this.f3882g += Math.max(0L, j5);
            this.f3883h = Math.max(this.f3883h, Math.max(0L, j5));
            this.f3884i += Math.max(0L, j6);
            this.f3885j = Math.max(this.f3885j, Math.max(0L, j6));
            this.f3886k += Math.max(0L, j7);
            this.f3887l = Math.max(this.f3887l, Math.max(0L, j7));
            this.f3888m += Math.max(0L, j8);
            this.n = Math.max(this.n, Math.max(0L, j8));
            this.f3889o += Math.max(0L, j9);
            this.f3890p = Math.max(this.f3890p, Math.max(0L, j9));
            this.f3895u.a(j3);
            this.f3896v.a(j4);
            this.f3897w.a(j5);
            this.f3898x.a(j6);
            this.f3899y.a(j7);
            this.f3900z.a(j8);
            this.A.a(j9);
            this.f3891q = Math.max(0, i3);
            this.f3892r = Math.max(0, i4);
            this.f3893s = Math.max(0, i5);
            this.f3894t = str == null ? "" : str;
            if ("wire_limit".equals(str)) {
                this.C++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(long j3, boolean z2) {
        try {
            this.I++;
            if (!z2) {
                this.K++;
            }
            if (j3 >= 20000) {
                this.J++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c() {
        this.H++;
    }

    public final synchronized void d(long j3, long j4) {
        this.Q += Math.max(0L, j3);
        this.R += Math.max(0L, j4);
    }

    public final synchronized void e(boolean z2) {
        try {
            this.D++;
            if (z2) {
                this.E++;
            } else {
                this.F++;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void f() {
        this.G++;
    }

    public final synchronized d7 g() {
        return new d7(this.f3876a, this.f3877b, this.f3878c, this.f3879d, this.f3895u, this.f3880e, this.f3881f, this.f3896v, this.f3882g, this.f3883h, this.f3897w, this.f3884i, this.f3885j, this.f3898x, this.f3886k, this.f3887l, this.f3899y, this.f3888m, this.n, this.f3900z, this.f3889o, this.f3890p, this.A, this.f3891q, this.f3892r, this.f3893s, this.f3894t, this.B, this.C, this.D, this.E, this.F, this.G, this.H, this.I, this.J, this.K, this.L, this.M, this.N, this.O, this.P, this.Q, this.R);
    }
}
