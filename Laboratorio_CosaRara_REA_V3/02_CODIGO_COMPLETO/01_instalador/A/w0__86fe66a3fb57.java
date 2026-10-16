// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes.dex */
public final class w0 extends u0 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final z0 f85q = z0.c(WindowInsets.CONSUMED, null);

    public w0(z0 z0Var, WindowInsets windowInsets) {
        super(z0Var, windowInsets);
    }

    @Override // A.r0, A.x0
    public p033t.c f(int i2) {
        return p033t.c.b(this.f72c.getInsets(y0.a(i2)));
    }

    @Override // A.r0, A.x0
    public final void d(View view) {
    }
}
