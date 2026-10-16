// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p1 implements p1.l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s1 f917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h f918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f919e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f920f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ y1 f921g;

    public /* synthetic */ p1(s1 s1Var, h hVar, long j3, long j4, y1 y1Var) {
        this.f917c = s1Var;
        this.f918d = hVar;
        this.f919e = j3;
        this.f920f = j4;
        this.f921g = y1Var;
    }

    @Override // p1.l
    public final Object f(Object obj) {
        boolean z2;
        boolean z3;
        s1 s1Var = this.f917c;
        h hVar = this.f918d;
        long j3 = this.f919e;
        long j4 = this.f920f;
        y1 y1Var = this.f921g;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        synchronized (s1Var) {
            z2 = false;
            z3 = !s1Var.f997k && j3 == s1Var.f989c && j4 == s1Var.f994h && s1Var.f991e == y1Var;
        }
        if (zBooleanValue && z3) {
            z2 = true;
        }
        hVar.f(Boolean.valueOf(z2));
        return h1.e.f1953c;
    }
}
