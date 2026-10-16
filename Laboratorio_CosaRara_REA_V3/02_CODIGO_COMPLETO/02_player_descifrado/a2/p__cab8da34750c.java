// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f131g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f132h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f133i;

    public p(long j3, long j4, int i3, long j5, long j6, boolean z2, long j7, boolean z3, boolean z4) {
        this.f125a = j3;
        this.f126b = j4;
        this.f127c = i3;
        this.f128d = j5;
        this.f129e = j6;
        this.f130f = z2;
        this.f131g = j7;
        this.f132h = z3;
        this.f133i = z4;
    }

    public static p a(long j3) {
        return new p(Long.MIN_VALUE, Long.MIN_VALUE, 0, 0L, 0L, false, Math.max(0L, j3), false, false);
    }
}
