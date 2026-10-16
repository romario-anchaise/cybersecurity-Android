// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

/* JADX INFO: loaded from: classes.dex */
public final class l0 implements p040w0.g, p040w0.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l0 f444a = new l0();

    @Override // p040w0.i
    public final p040w0.g j(p040w0.h hVar) {
        return p028p0.a.g(this, hVar);
    }

    @Override // p040w0.i
    public final Object n(Object obj, E0.p pVar) {
        return pVar.c(obj, this);
    }

    @Override // p040w0.i
    public final p040w0.i r(p040w0.h hVar) {
        return p028p0.a.n(this, hVar);
    }

    @Override // p040w0.i
    public final p040w0.i t(p040w0.i iVar) {
        F0.i.e(iVar, "context");
        return p029q.j.n(this, iVar);
    }

    @Override // p040w0.g
    public final p040w0.h getKey() {
        return this;
    }
}
