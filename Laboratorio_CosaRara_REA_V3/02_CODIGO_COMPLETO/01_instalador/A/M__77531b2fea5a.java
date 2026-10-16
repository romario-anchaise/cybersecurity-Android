// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes.dex */
public abstract class M {
    public static z0 a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        z0 z0VarC = z0.c(rootWindowInsets, null);
        x0 x0Var = z0VarC.f91a;
        x0Var.p(z0VarC);
        x0Var.d(view.getRootView());
        return z0VarC;
    }

    public static int b(View view) {
        return view.getScrollIndicators();
    }

    public static void c(View view, int i2) {
        view.setScrollIndicators(i2);
    }

    public static void d(View view, int i2, int i3) {
        view.setScrollIndicators(i2, i3);
    }
}
