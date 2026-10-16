// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import com.o2s2m.gae1fc3b2uc0u.R;

/* JADX INFO: loaded from: classes.dex */
public abstract class L {
    public static void a(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    public static z0 b(View view, z0 z0Var, Rect rect) {
        WindowInsets windowInsetsB = z0Var.b();
        if (windowInsetsB != null) {
            return z0.c(view.computeSystemWindowInsets(windowInsetsB, rect), view);
        }
        rect.setEmpty();
        return z0Var;
    }

    public static boolean c(View view, float f2, float f3, boolean z2) {
        return view.dispatchNestedFling(f2, f3, z2);
    }

    public static boolean d(View view, float f2, float f3) {
        return view.dispatchNestedPreFling(f2, f3);
    }

    public static boolean e(View view, int i2, int i3, int[] iArr, int[] iArr2) {
        return view.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    public static boolean f(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        return view.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    public static ColorStateList g(View view) {
        return view.getBackgroundTintList();
    }

    public static PorterDuff.Mode h(View view) {
        return view.getBackgroundTintMode();
    }

    public static float i(View view) {
        return view.getElevation();
    }

    public static z0 j(View view) {
        q0 o0Var;
        if (!l0.f50d || !view.isAttachedToWindow()) {
            return null;
        }
        try {
            Object obj = l0.f47a.get(view.getRootView());
            if (obj == null) {
                return null;
            }
            Rect rect = (Rect) l0.f48b.get(obj);
            Rect rect2 = (Rect) l0.f49c.get(obj);
            if (rect == null || rect2 == null) {
                return null;
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                o0Var = new p0();
            } else {
                o0Var = i2 >= 29 ? new o0() : new m0();
            }
            o0Var.c(p033t.c.a(rect.left, rect.top, rect.right, rect.bottom));
            o0Var.d(p033t.c.a(rect2.left, rect2.top, rect2.right, rect2.bottom));
            z0 z0VarB = o0Var.b();
            z0VarB.f91a.p(z0VarB);
            z0VarB.f91a.d(view.getRootView());
            return z0VarB;
        } catch (IllegalAccessException e2) {
            Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e2.getMessage(), e2);
            return null;
        }
    }

    public static String k(View view) {
        return view.getTransitionName();
    }

    public static float l(View view) {
        return view.getTranslationZ();
    }

    public static float m(View view) {
        return view.getZ();
    }

    public static boolean n(View view) {
        return view.hasNestedScrollingParent();
    }

    public static boolean o(View view) {
        return view.isImportantForAccessibility();
    }

    public static boolean p(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void q(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    public static void r(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void s(View view, float f2) {
        view.setElevation(f2);
    }

    public static void t(View view, boolean z2) {
        view.setNestedScrollingEnabled(z2);
    }

    public static void u(View view, InterfaceC0024y interfaceC0024y) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R.id.tag_on_apply_window_listener, interfaceC0024y);
        }
        if (interfaceC0024y == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        } else {
            view.setOnApplyWindowInsetsListener(new K(view, interfaceC0024y));
        }
    }

    public static void v(View view, String str) {
        view.setTransitionName(str);
    }

    public static void w(View view, float f2) {
        view.setTranslationZ(f2);
    }

    public static void x(View view, float f2) {
        view.setZ(f2);
    }

    public static boolean y(View view, int i2) {
        return view.startNestedScroll(i2);
    }

    public static void z(View view) {
        view.stopNestedScroll();
    }
}
