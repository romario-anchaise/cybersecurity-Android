// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

/* JADX INFO: loaded from: classes.dex */
public final class k0 extends R0.s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ThreadLocal f441e;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public k0(p040w0.i iVar, p044y0.c cVar) {
        l0 l0Var = l0.f444a;
        super(iVar.j(l0Var) == null ? iVar.t(l0Var) : iVar, cVar);
        this.f441e = new ThreadLocal();
        p040w0.i iVar2 = cVar.f4197b;
        F0.i.b(iVar2);
        if (iVar2.j(p040w0.e.f4164a) instanceof AbstractC0045q) {
            return;
        }
        Object objJ = R0.a.j(iVar, null);
        R0.a.e(iVar, objJ);
        O(iVar, objJ);
    }

    public final boolean N() {
        boolean z2 = this.threadLocalIsSet && this.f441e.get() == null;
        this.f441e.remove();
        return !z2;
    }

    public final void O(p040w0.i iVar, Object obj) {
        this.threadLocalIsSet = true;
        this.f441e.set(new p034t0.d(iVar, obj));
    }

    @Override // R0.s, N0.a0
    public final void i(Object obj) {
        if (this.threadLocalIsSet) {
            p034t0.d dVar = (p034t0.d) this.f441e.get();
            if (dVar != null) {
                R0.a.e((p040w0.i) dVar.f4126a, dVar.f4127b);
            }
            this.f441e.remove();
        }
        Object objJ = AbstractC0049v.j(obj);
        p044y0.c cVar = this.f571d;
        p040w0.i iVar = cVar.f4197b;
        F0.i.b(iVar);
        Object objJ2 = R0.a.j(iVar, null);
        k0 k0VarM = objJ2 != R0.a.f540f ? AbstractC0049v.m(cVar, iVar, objJ2) : null;
        try {
            this.f571d.b(objJ);
        } finally {
            if (k0VarM == null || k0VarM.N()) {
                R0.a.e(iVar, objJ2);
            }
        }
    }
}
