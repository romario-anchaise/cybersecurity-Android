// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class rd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5019a = 500;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f5023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f5024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f5026h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f5027i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f5028j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f5029k;

    public static long a(long j3, long j4, long j5) {
        return Math.max(j4, Math.min(j5, j3));
    }

    public final void b(long j3) {
        this.f5029k = j3 > 9223372036854715807L ? Long.MAX_VALUE : j3 + 60000;
    }

    public final synchronized void c(int i3, long j3) {
        this.f5027i = 0;
        if (i3 != 3) {
            i(j3);
            this.f5024f = a(Math.max(this.f5024f, Math.max(this.f5019a, this.f5023e) + 80), 350L, 3000L);
            b(j3);
            g();
            return;
        }
        if (i(j3)) {
            g();
            return;
        }
        this.f5023e = a(Math.max(400L, Math.max(this.f5023e, this.f5019a) + 80), 350L, 3000L);
        b(j3);
        g();
    }

    public final synchronized void d(long j3, long j4) {
        this.f5025g = 0;
        this.f5026h = Math.max(0L, this.f5026h - 400);
        long jMin = 1;
        if (j3 >= 1) {
            jMin = Math.min(3000L, j3);
        }
        j(jMin);
        this.f5022d++;
        long j5 = this.f5024f;
        if (j5 > 0) {
            long jMax = this.f5024f - Math.max(80L, j5 / 4);
            this.f5024f = jMax;
            if (jMax <= 350) {
                this.f5024f = 0L;
            }
        }
        h(j4);
        if (this.f5022d >= 4 || this.f5023e != 0) {
            g();
        } else {
            this.f5019a = a(Math.max(this.f5019a, !this.f5021c ? 500L : a(this.f5020b + 40, 350L, 3000L)), 350L, 3000L);
        }
    }

    public final synchronized void e(long j3) {
        try {
            this.f5025g++;
            this.f5026h = Math.min(2000L, this.f5026h + 800);
            this.f5027i = 0;
            boolean zI = i(j3);
            if (this.f5025g >= 2) {
                j(Math.min(3000L, Math.max(this.f5019a, 2000L)));
                this.f5024f = a(Math.max(this.f5024f, Math.max(this.f5019a, this.f5023e) + 200), 350L, 3000L);
                b(j3);
            } else if (zI) {
                b(j3);
            }
            g();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized long f() {
        return a(Math.max(350L, this.f5023e), 350L, this.f5019a);
    }

    public final void g() {
        this.f5019a = a(Math.max(Math.max(!this.f5021c ? 500L : a(this.f5020b + 40, 350L, 3000L), this.f5023e), this.f5024f), 350L, 3000L);
    }

    public final void h(long j3) {
        if (this.f5028j > 0) {
            this.f5028j = 0L;
        }
        if (this.f5023e <= 350) {
            this.f5027i = 0;
            return;
        }
        int iMin = Math.min(8, this.f5027i + 1);
        this.f5027i = iMin;
        if (iMin < 8 || j3 < this.f5029k) {
            return;
        }
        long j4 = this.f5023e;
        long jMax = Math.max(350L, j4 - Math.max(80L, j4 / 4));
        if (jMax >= j4) {
            this.f5027i = 0;
            return;
        }
        this.f5028j = j4;
        this.f5023e = jMax;
        this.f5027i = 0;
    }

    public final boolean i(long j3) {
        long j4 = this.f5028j;
        if (j4 <= 0) {
            return false;
        }
        this.f5023e = Math.max(this.f5023e, j4);
        this.f5028j = 0L;
        b(j3);
        return true;
    }

    public final void j(long j3) {
        if (this.f5021c) {
            this.f5020b = ((j3 * 2) + (this.f5020b * 3)) / 5;
        } else {
            this.f5020b = j3;
            this.f5021c = true;
        }
    }

    public final synchronized long k() {
        synchronized (this) {
        }
        return this.f5019a * 1000000;
        return this.f5019a * 1000000;
    }

    public final synchronized long l() {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return a((this.f5021c ? Math.max(4000L, Math.max((this.f5020b * 2) + 200, this.f5019a + 800)) : 4000L) + this.f5026h, 4000L, 6000L);
    }
}
