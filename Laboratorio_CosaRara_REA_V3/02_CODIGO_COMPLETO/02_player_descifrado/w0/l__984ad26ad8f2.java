// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w0;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x0.c f3409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x0.a f3411c;

    public l(x0.c cVar, String str, x0.a aVar) {
        this.f3409a = cVar;
        this.f3410b = str;
        this.f3411c = aVar;
    }

    @Override // w0.m
    public final void destroy() {
        this.f3409a.b(this.f3410b, this.f3411c);
    }
}
