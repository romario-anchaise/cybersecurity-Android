// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.view.WindowInsets;

/* JADX INFO: loaded from: classes.dex */
public class s0 extends r0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public p033t.c f76m;

    public s0(z0 z0Var, WindowInsets windowInsets) {
        super(z0Var, windowInsets);
        this.f76m = null;
    }

    @Override // A.x0
    public z0 b() {
        return z0.c(this.f72c.consumeStableInsets(), null);
    }

    @Override // A.x0
    public z0 c() {
        return z0.c(this.f72c.consumeSystemWindowInsets(), null);
    }

    @Override // A.x0
    public final p033t.c h() {
        if (this.f76m == null) {
            WindowInsets windowInsets = this.f72c;
            this.f76m = p033t.c.a(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f76m;
    }

    @Override // A.x0
    public boolean m() {
        return this.f72c.isConsumed();
    }

    @Override // A.x0
    public void q(p033t.c cVar) {
        this.f76m = cVar;
    }
}
