// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h2;

import c2.t;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f2058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2062f;

    public static long c(long j3, long j4) {
        if (j3 > Long.MAX_VALUE - j4) {
            return Long.MAX_VALUE;
        }
        return j3 + j4;
    }

    public final void a(int i3) {
        if (i3 == this.f2057a) {
            this.f2060d = false;
        }
    }

    public final t b(int i3, boolean z2, boolean z3, long j3) {
        long jMax = Math.max(0L, j3);
        if (i3 != this.f2057a) {
            this.f2057a = i3;
            this.f2058b = z3 ? jMax : c(jMax, 8000L);
            this.f2059c = 0L;
            this.f2060d = false;
            this.f2061e = z2;
            this.f2062f = z3;
        }
        if (!z2) {
            this.f2060d = false;
            this.f2061e = false;
            this.f2062f = false;
            return new t(1, -1L);
        }
        if (z3) {
            this.f2058b = jMax;
            this.f2059c = 0L;
            this.f2060d = false;
            this.f2061e = true;
            this.f2062f = true;
            return new t(3, 0L);
        }
        if (!this.f2061e || this.f2062f) {
            this.f2058b = c(jMax, 8000L);
        }
        this.f2061e = true;
        this.f2062f = false;
        if (this.f2060d) {
            return new t(2, -1L);
        }
        long jMax2 = Math.max(this.f2058b, this.f2059c);
        if (jMax < jMax2) {
            return new t(2, jMax2 - jMax);
        }
        this.f2060d = true;
        return new t(4, 0L);
    }
}
