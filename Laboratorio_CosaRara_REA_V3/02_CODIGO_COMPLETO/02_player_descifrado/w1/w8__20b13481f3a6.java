// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class w8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f5408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f5411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f5412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f5413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f5414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f5415h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f5416i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f5417j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f5418k;

    public w8(boolean z2, boolean z3, long j3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f5408a = z2;
        this.f5409b = z3;
        this.f5412e = j3;
        this.f5413f = z4;
        this.f5414g = z5;
        this.f5417j = z6;
        this.f5418k = z7;
        boolean z8 = false;
        boolean z9 = z4 && z5 && z6 && z7;
        this.f5416i = z9;
        this.f5415h = z4 && z5 && !z9;
        boolean z10 = z2 && z3 && ((z4 && z5) || (z6 && z7));
        this.f5411d = z10;
        if (z2 && z3 && !z10) {
            z8 = true;
        }
        this.f5410c = z8;
    }
}
