// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.view.WindowInsets;

/* JADX INFO: loaded from: classes.dex */
public class u0 extends t0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public p033t.c f82n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public p033t.c f83o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public p033t.c f84p;

    public u0(z0 z0Var, WindowInsets windowInsets) {
        super(z0Var, windowInsets);
        this.f82n = null;
        this.f83o = null;
        this.f84p = null;
    }

    @Override // A.x0
    public p033t.c g() {
        if (this.f83o == null) {
            this.f83o = p033t.c.b(this.f72c.getMandatorySystemGestureInsets());
        }
        return this.f83o;
    }

    @Override // A.x0
    public p033t.c i() {
        if (this.f82n == null) {
            this.f82n = p033t.c.b(this.f72c.getSystemGestureInsets());
        }
        return this.f82n;
    }

    @Override // A.x0
    public p033t.c k() {
        if (this.f84p == null) {
            this.f84p = p033t.c.b(this.f72c.getTappableElementInsets());
        }
        return this.f84p;
    }

    @Override // A.r0, A.x0
    public z0 l(int i2, int i3, int i4, int i5) {
        return z0.c(this.f72c.inset(i2, i3, i4, i5), null);
    }

    @Override // A.s0, A.x0
    public void q(p033t.c cVar) {
    }
}
