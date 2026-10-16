// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x0;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f5833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f5834c;

    public b(c cVar, String str, a aVar) {
        this.f5834c = cVar;
        this.f5832a = str;
        this.f5833b = aVar;
    }

    @Override // x0.a
    public final void a(Object... objArr) {
        this.f5834c.b(this.f5832a, this);
        this.f5833b.a(objArr);
    }
}
