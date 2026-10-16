// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class z0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z0 f90b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x0 f91a;

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f90b = w0.f85q;
        } else {
            f90b = x0.f88b;
        }
    }

    public z0(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            this.f91a = new w0(this, windowInsets);
            return;
        }
        if (i2 >= 29) {
            this.f91a = new u0(this, windowInsets);
        } else if (i2 >= 28) {
            this.f91a = new t0(this, windowInsets);
        } else {
            this.f91a = new s0(this, windowInsets);
        }
    }

    public static p033t.c a(p033t.c cVar, int i2, int i3, int i4, int i5) {
        int iMax = Math.max(0, cVar.f4103a - i2);
        int iMax2 = Math.max(0, cVar.f4104b - i3);
        int iMax3 = Math.max(0, cVar.f4105c - i4);
        int iMax4 = Math.max(0, cVar.f4106d - i5);
        return (iMax == i2 && iMax2 == i3 && iMax3 == i4 && iMax4 == i5) ? cVar : p033t.c.a(iMax, iMax2, iMax3, iMax4);
    }

    public static z0 c(WindowInsets windowInsets, View view) {
        windowInsets.getClass();
        z0 z0Var = new z0(windowInsets);
        if (view != null) {
            WeakHashMap weakHashMap = X.f14a;
            if (I.b(view)) {
                z0 z0VarA = M.a(view);
                x0 x0Var = z0Var.f91a;
                x0Var.p(z0VarA);
                x0Var.d(view.getRootView());
            }
        }
        return z0Var;
    }

    public final WindowInsets b() {
        x0 x0Var = this.f91a;
        if (x0Var instanceof r0) {
            return ((r0) x0Var).f72c;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z0)) {
            return false;
        }
        return p045z.b.a(this.f91a, ((z0) obj).f91a);
    }

    public final int hashCode() {
        x0 x0Var = this.f91a;
        if (x0Var == null) {
            return 0;
        }
        return x0Var.hashCode();
    }

    public z0() {
        this.f91a = new x0(this);
    }
}
