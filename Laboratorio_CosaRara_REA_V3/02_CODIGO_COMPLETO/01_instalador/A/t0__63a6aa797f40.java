// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class t0 extends s0 {
    public t0(z0 z0Var, WindowInsets windowInsets) {
        super(z0Var, windowInsets);
    }

    @Override // A.x0
    public z0 a() {
        return z0.c(this.f72c.consumeDisplayCutout(), null);
    }

    @Override // A.x0
    public C0012l e() {
        DisplayCutout displayCutout = this.f72c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new C0012l(displayCutout);
    }

    @Override // A.r0, A.x0
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t0)) {
            return false;
        }
        t0 t0Var = (t0) obj;
        return Objects.equals(this.f72c, t0Var.f72c) && Objects.equals(this.g, t0Var.g);
    }

    @Override // A.x0
    public int hashCode() {
        return this.f72c.hashCode();
    }
}
