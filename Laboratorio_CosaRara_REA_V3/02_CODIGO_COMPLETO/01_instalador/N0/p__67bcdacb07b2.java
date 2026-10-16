// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

/* JADX INFO: renamed from: N0.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0044p implements p040w0.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F0.j f449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p040w0.h f450b;

    /* JADX WARN: Multi-variable type inference failed */
    public C0044p(p040w0.h hVar, E0.l lVar) {
        F0.i.e(hVar, "baseKey");
        this.f449a = (F0.j) lVar;
        this.f450b = hVar instanceof C0044p ? ((C0044p) hVar).f450b : hVar;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [E0.l, F0.j] */
    public final p040w0.g a(AbstractC0045q abstractC0045q) {
        return (p040w0.g) this.f449a.d(abstractC0045q);
    }
}
