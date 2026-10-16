// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends i2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i2.c f1500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y.c f1501b;

    public a(i2.c cVar, y.c cVar2) {
        this.f1500a = cVar;
        this.f1501b = cVar2;
    }

    @Override // i2.c
    public final void i(v2.g gVar, int i3, String str) {
        y.c cVar = this.f1501b;
        cVar.getClass();
        cVar.l(new b(i3, str, -1, null));
        this.f1500a.i(gVar, i3, str);
    }

    @Override // i2.c
    public final void j(v2.g gVar, int i3, String str) {
        y.c cVar = this.f1501b;
        cVar.getClass();
        cVar.l(new b(i3, str, -1, null));
        this.f1500a.j(gVar, i3, str);
    }

    @Override // i2.c
    public final void k(v2.g gVar, Exception exc, i2.y yVar) {
        y.c cVar = this.f1501b;
        cVar.getClass();
        cVar.l(new b(-1, "", yVar == null ? -1 : yVar.f2290f, exc));
        this.f1500a.k(gVar, exc, yVar);
    }

    @Override // i2.c
    public final void l(String str, v2.g gVar) {
        this.f1500a.l(str, gVar);
    }

    @Override // i2.c
    public final void m(v2.g gVar, w2.k kVar) {
        this.f1500a.m(gVar, kVar);
    }

    @Override // i2.c
    public final void n(v2.g gVar, i2.y yVar) {
        this.f1500a.n(gVar, yVar);
    }
}
