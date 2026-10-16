// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f5345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f5348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f5349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f5350f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f5351g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f5352h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f5353i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f5354j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f5355k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f5356l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f5357m;
    public final long n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f5358o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f5359p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f5360q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long f5361r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f5362s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f5363t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f5364u;

    public w(long j3, boolean z2, long j4, long j5, long j6, long j7, long j8, long j9, long j10, int i3, int i4, int i5, int i6, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18) {
        this.f5345a = j3;
        this.f5346b = z2;
        this.f5347c = j4;
        this.f5348d = j5;
        this.f5349e = j6;
        this.f5350f = j7;
        this.f5351g = j8;
        this.f5352h = j9;
        this.f5353i = j10;
        this.f5354j = i3;
        this.f5355k = i4;
        this.f5356l = i5;
        this.f5357m = i6;
        this.n = j11;
        this.f5358o = j12;
        Math.max(j11, j12);
        this.f5359p = j13;
        this.f5360q = j14;
        this.f5361r = j15;
        this.f5362s = j16;
        this.f5363t = j17;
        this.f5364u = j18;
    }

    public static long a(long j3, long j4, boolean z2) {
        if (z2) {
            return Math.max(j3, j4);
        }
        if (j4 <= 0 || j3 <= Long.MAX_VALUE - j4) {
            return j3 + j4;
        }
        return Long.MAX_VALUE;
    }

    public static w b(w wVar, w wVar2) {
        if (wVar == null) {
            return wVar2;
        }
        long j3 = wVar.f5345a;
        long j4 = wVar2.f5345a;
        boolean z2 = j3 == j4;
        return new w(Math.max(j3, j4), wVar2.f5346b, a(wVar.f5347c, wVar2.f5347c, z2), a(wVar.f5348d, wVar2.f5348d, z2), a(wVar.f5349e, wVar2.f5349e, z2), a(wVar.f5350f, wVar2.f5350f, z2), a(wVar.f5351g, wVar2.f5351g, z2), a(wVar.f5352h, wVar2.f5352h, z2), a(wVar.f5353i, wVar2.f5353i, z2), wVar2.f5354j, wVar2.f5355k, Math.max(wVar.f5356l, wVar2.f5356l), Math.max(wVar.f5357m, wVar2.f5357m), Math.max(wVar.n, wVar2.n), Math.max(wVar.f5358o, wVar2.f5358o), Math.max(wVar.f5359p, wVar2.f5359p), Math.max(wVar.f5360q, wVar2.f5360q), a(wVar.f5361r, wVar2.f5361r, z2), a(wVar.f5362s, wVar2.f5362s, z2), a(wVar.f5363t, wVar2.f5363t, z2), Math.max(wVar.f5364u, wVar2.f5364u));
    }
}
