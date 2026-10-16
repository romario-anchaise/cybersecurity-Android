// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f3827e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f3828f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f3829g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f3830h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f3831i;

    public e(boolean z2, boolean z3, long j3, int i3, long j4, long j5, long j6, int i4, long j7) {
        this.f3823a = z2;
        this.f3824b = z3;
        this.f3825c = j3;
        this.f3826d = i3;
        this.f3827e = j4;
        this.f3828f = j5;
        this.f3829g = j6;
        this.f3830h = i4;
        this.f3831i = j7;
    }

    public static e a() {
        return new e(false, false, 0L, 0, 0L, 0L, 0L, -1, 0L);
    }

    public final boolean b(long j3) {
        return n.h(true, this.f3824b, this.f3827e, this.f3829g, j3) == 1;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f3823a == eVar.f3823a && this.f3824b == eVar.f3824b && this.f3825c == eVar.f3825c && this.f3826d == eVar.f3826d && this.f3827e == eVar.f3827e && this.f3828f == eVar.f3828f && this.f3829g == eVar.f3829g && this.f3830h == eVar.f3830h && this.f3831i == eVar.f3831i;
    }

    public final int hashCode() {
        long j3 = (((((((this.f3825c * 31) + this.f3827e) * 31) + this.f3828f) * 31) + this.f3829g) * 31) + this.f3831i;
        return (int) (j3 ^ (j3 >>> 32));
    }
}
