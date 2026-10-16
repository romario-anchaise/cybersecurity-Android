// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements w0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f1648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1649c;

    public /* synthetic */ k(Object obj, long j3, int i3) {
        this.f1647a = i3;
        this.f1649c = obj;
        this.f1648b = j3;
    }

    @Override // w0.a
    public final void a(Object[] objArr) {
        switch (this.f1647a) {
            case 0:
                ((a0) this.f1649c).v(this.f1648b, objArr);
                break;
            default:
                ((k0) this.f1649c).H(this.f1648b, objArr);
                break;
        }
    }
}
