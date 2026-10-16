// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e4 f3981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l4 f3982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h4 f3983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n f3984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f3985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f3986g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3987h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public i4 f3988i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f3989j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public h2 f3990k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f3991l;

    public f4(Object obj, e4 e4Var, l4 l4Var, h4 h4Var, n nVar, long j3, boolean z2) {
        if (j3 < 0) {
            o2.i("expected duration must not be negative");
            throw null;
        }
        this.f3980a = obj;
        this.f3981b = e4Var;
        this.f3982c = l4Var;
        this.f3983d = h4Var;
        this.f3984e = nVar;
        this.f3985f = j3;
        this.f3986g = z2;
    }
}
