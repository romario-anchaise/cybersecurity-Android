// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y;

import w1.j4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f5998u = p.m.f("WorkSpec");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f6001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p.e f6003e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p.e f6004f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f6005g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f6006h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f6007i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p.d f6008j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f6009k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6010l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f6011m;
    public long n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f6012o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f6013p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f6014q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f6015r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f6016s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f6017t;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ o(String str, int i3, String str2, String str3, p.e eVar, p.e eVar2, long j3, long j4, long j5, p.d dVar, int i4, int i5, long j6, long j7, long j8, long j9, boolean z2, int i6, int i7, int i8, int i9) {
        p.e eVar3;
        p.e eVar4;
        int i10 = (i8 & 2) != 0 ? 1 : i3;
        String str4 = (i8 & 8) != 0 ? null : str3;
        if ((i8 & 16) != 0) {
            p.e eVar5 = p.e.f2842c;
            eVar5.getClass();
            eVar3 = eVar5;
        } else {
            eVar3 = eVar;
        }
        if ((i8 & 32) != 0) {
            p.e eVar6 = p.e.f2842c;
            eVar6.getClass();
            eVar4 = eVar6;
        } else {
            eVar4 = eVar2;
        }
        this(str, i10, str2, str4, eVar3, eVar4, (i8 & 64) != 0 ? 0L : j3, (i8 & 128) != 0 ? 0L : j4, (i8 & 256) != 0 ? 0L : j5, (i8 & 512) != 0 ? p.d.f2832i : dVar, (i8 & 1024) != 0 ? 0 : i4, (i8 & 2048) != 0 ? 1 : i5, (i8 & 4096) != 0 ? 30000L : j6, (i8 & 8192) != 0 ? 0L : j7, (i8 & 16384) != 0 ? 0L : j8, (32768 & i8) != 0 ? -1L : j9, (65536 & i8) != 0 ? false : z2, (131072 & i8) != 0 ? 1 : i6, (i8 & 262144) != 0 ? 0 : i7, 0);
    }

    public static o b(o oVar, String str, int i3, int i4, long j3, int i5, int i6) {
        String str2 = (i6 & 1) != 0 ? oVar.f5999a : str;
        int i7 = (i6 & 2) != 0 ? oVar.f6000b : i3;
        String str3 = oVar.f6001c;
        String str4 = oVar.f6002d;
        p.e eVar = oVar.f6003e;
        p.e eVar2 = oVar.f6004f;
        long j4 = oVar.f6005g;
        long j5 = oVar.f6006h;
        long j6 = oVar.f6007i;
        p.d dVar = oVar.f6008j;
        int i8 = (i6 & 1024) != 0 ? oVar.f6009k : i4;
        int i9 = oVar.f6010l;
        long j7 = oVar.f6011m;
        long j8 = (i6 & 8192) != 0 ? oVar.n : j3;
        long j9 = oVar.f6012o;
        long j10 = oVar.f6013p;
        boolean z2 = oVar.f6014q;
        int i10 = oVar.f6015r;
        int i11 = oVar.f6016s;
        int i12 = (i6 & 524288) != 0 ? oVar.f6017t : i5;
        oVar.getClass();
        str2.getClass();
        if (i7 == 0) {
            throw null;
        }
        str3.getClass();
        eVar.getClass();
        eVar2.getClass();
        dVar.getClass();
        if (i9 == 0 || i10 == 0) {
            throw null;
        }
        return new o(str2, i7, str3, str4, eVar, eVar2, j4, j5, j6, dVar, i8, i9, j7, j8, j9, j10, z2, i10, i11, i12);
    }

    public final long a() {
        int i3;
        if (this.f6000b == 1 && (i3 = this.f6009k) > 0) {
            int i4 = this.f6010l;
            long j3 = this.f6011m;
            long jScalb = i4 == 2 ? j3 * ((long) i3) : (long) Math.scalb(j3, i3 - 1);
            long j4 = this.n;
            if (jScalb > 18000000) {
                jScalb = 18000000;
            }
            return j4 + jScalb;
        }
        boolean zD = d();
        long j5 = this.f6005g;
        if (!zD) {
            long jCurrentTimeMillis = this.n;
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            return jCurrentTimeMillis + j5;
        }
        long j6 = this.n;
        int i5 = this.f6016s;
        if (i5 == 0) {
            j6 += j5;
        }
        long j7 = this.f6007i;
        long j8 = this.f6006h;
        if (j7 != j8) {
            return j6 + j8 + (i5 == 0 ? ((long) (-1)) * j7 : 0L);
        }
        return j6 + (i5 != 0 ? j8 : 0L);
    }

    public final boolean c() {
        return !q1.e.a(p.d.f2832i, this.f6008j);
    }

    public final boolean d() {
        return this.f6006h != 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return q1.e.a(this.f5999a, oVar.f5999a) && this.f6000b == oVar.f6000b && q1.e.a(this.f6001c, oVar.f6001c) && q1.e.a(this.f6002d, oVar.f6002d) && q1.e.a(this.f6003e, oVar.f6003e) && q1.e.a(this.f6004f, oVar.f6004f) && this.f6005g == oVar.f6005g && this.f6006h == oVar.f6006h && this.f6007i == oVar.f6007i && q1.e.a(this.f6008j, oVar.f6008j) && this.f6009k == oVar.f6009k && this.f6010l == oVar.f6010l && this.f6011m == oVar.f6011m && this.n == oVar.n && this.f6012o == oVar.f6012o && this.f6013p == oVar.f6013p && this.f6014q == oVar.f6014q && this.f6015r == oVar.f6015r && this.f6016s == oVar.f6016s && this.f6017t == oVar.f6017t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r2v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v33 */
    public final int hashCode() {
        int iE = a0.a.e((g.d.a(this.f6000b) + (this.f5999a.hashCode() * 31)) * 31, 31, this.f6001c);
        String str = this.f6002d;
        int iB = j4.b(j4.b(j4.b(j4.b((g.d.a(this.f6010l) + ((Integer.hashCode(this.f6009k) + ((this.f6008j.hashCode() + j4.b(j4.b(j4.b((this.f6004f.hashCode() + ((this.f6003e.hashCode() + ((iE + (str == null ? 0 : str.hashCode())) * 31)) * 31)) * 31, 31, this.f6005g), 31, this.f6006h), 31, this.f6007i)) * 31)) * 31)) * 31, 31, this.f6011m), 31, this.n), 31, this.f6012o), 31, this.f6013p);
        boolean z2 = this.f6014q;
        ?? r3 = z2;
        if (z2) {
            r3 = 1;
        }
        return Integer.hashCode(this.f6017t) + ((Integer.hashCode(this.f6016s) + ((g.d.a(this.f6015r) + ((iB + r3) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "{WorkSpec: " + this.f5999a + '}';
    }

    public o(String str, int i3, String str2, String str3, p.e eVar, p.e eVar2, long j3, long j4, long j5, p.d dVar, int i4, int i5, long j6, long j7, long j8, long j9, boolean z2, int i6, int i7, int i8) {
        str.getClass();
        if (i3 == 0) {
            throw null;
        }
        str2.getClass();
        eVar.getClass();
        eVar2.getClass();
        dVar.getClass();
        if (i5 != 0 && i6 != 0) {
            this.f5999a = str;
            this.f6000b = i3;
            this.f6001c = str2;
            this.f6002d = str3;
            this.f6003e = eVar;
            this.f6004f = eVar2;
            this.f6005g = j3;
            this.f6006h = j4;
            this.f6007i = j5;
            this.f6008j = dVar;
            this.f6009k = i4;
            this.f6010l = i5;
            this.f6011m = j6;
            this.n = j7;
            this.f6012o = j8;
            this.f6013p = j9;
            this.f6014q = z2;
            this.f6015r = i6;
            this.f6016s = i7;
            this.f6017t = i8;
            return;
        }
        throw null;
    }
}
