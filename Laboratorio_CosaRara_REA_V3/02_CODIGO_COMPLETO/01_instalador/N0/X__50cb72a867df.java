// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

/* JADX INFO: loaded from: classes.dex */
public final class X extends W {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a0 f405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Y f406f;
    public final C0037i g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f407h;

    public X(a0 a0Var, Y y2, C0037i c0037i, Object obj) {
        this.f405e = a0Var;
        this.f406f = y2;
        this.g = c0037i;
        this.f407h = obj;
    }

    @Override // E0.l
    public final /* bridge */ /* synthetic */ Object d(Object obj) {
        l((Throwable) obj);
        return p034t0.h.f4132b;
    }

    @Override // N0.W
    public final void l(Throwable th) {
        C0037i c0037i = this.g;
        a0 a0Var = this.f405e;
        a0Var.getClass();
        C0037i c0037iF = a0.F(c0037i);
        Y y2 = this.f406f;
        Object obj = this.f407h;
        if (c0037iF != null) {
            while (AbstractC0049v.g(c0037iF.f429e, false, new X(a0Var, y2, c0037iF, obj), 1) == c0.f421a) {
                c0037iF = a0.F(c0037iF);
                if (c0037iF == null) {
                }
            }
            return;
        }
        a0Var.h(a0Var.s(y2, obj));
    }
}
