// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class r0 extends x0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f67h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Method f68i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Class f69j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Field f70k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Field f71l;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WindowInsets f72c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p033t.c[] f73d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p033t.c f74e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public z0 f75f;
    public p033t.c g;

    public r0(z0 z0Var, WindowInsets windowInsets) {
        super(z0Var);
        this.f74e = null;
        this.f72c = windowInsets;
    }

    private p033t.c r(int i2, boolean z2) {
        p033t.c cVarA = p033t.c.f4102e;
        for (int i3 = 1; i3 <= 256; i3 <<= 1) {
            if ((i2 & i3) != 0) {
                p033t.c cVarS = s(i3, z2);
                cVarA = p033t.c.a(Math.max(cVarA.f4103a, cVarS.f4103a), Math.max(cVarA.f4104b, cVarS.f4104b), Math.max(cVarA.f4105c, cVarS.f4105c), Math.max(cVarA.f4106d, cVarS.f4106d));
            }
        }
        return cVarA;
    }

    private p033t.c t() {
        z0 z0Var = this.f75f;
        return z0Var != null ? z0Var.f91a.h() : p033t.c.f4102e;
    }

    private p033t.c u(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
        if (!f67h) {
            v();
        }
        Method method = f68i;
        if (method != null && f69j != null && f70k != null) {
            try {
                Object objInvoke = method.invoke(view, null);
                if (objInvoke == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) f70k.get(f71l.get(objInvoke));
                if (rect != null) {
                    return p033t.c.a(rect.left, rect.top, rect.right, rect.bottom);
                }
                return null;
            } catch (ReflectiveOperationException e2) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
            }
        }
        return null;
    }

    private static void v() {
        try {
            f68i = View.class.getDeclaredMethod("getViewRootImpl", null);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            f69j = cls;
            f70k = cls.getDeclaredField("mVisibleInsets");
            f71l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            f70k.setAccessible(true);
            f71l.setAccessible(true);
        } catch (ReflectiveOperationException e2) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
        }
        f67h = true;
    }

    @Override // A.x0
    public void d(View view) {
        p033t.c cVarU = u(view);
        if (cVarU == null) {
            cVarU = p033t.c.f4102e;
        }
        w(cVarU);
    }

    @Override // A.x0
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return Objects.equals(this.g, ((r0) obj).g);
        }
        return false;
    }

    @Override // A.x0
    public p033t.c f(int i2) {
        return r(i2, false);
    }

    @Override // A.x0
    public final p033t.c j() {
        if (this.f74e == null) {
            WindowInsets windowInsets = this.f72c;
            this.f74e = p033t.c.a(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.f74e;
    }

    @Override // A.x0
    public z0 l(int i2, int i3, int i4, int i5) {
        q0 o0Var;
        z0 z0VarC = z0.c(this.f72c, null);
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 30) {
            o0Var = new p0(z0VarC);
        } else {
            o0Var = i6 >= 29 ? new o0(z0VarC) : new m0(z0VarC);
        }
        o0Var.d(z0.a(j(), i2, i3, i4, i5));
        o0Var.c(z0.a(h(), i2, i3, i4, i5));
        return o0Var.b();
    }

    @Override // A.x0
    public boolean n() {
        return this.f72c.isRound();
    }

    @Override // A.x0
    public void o(p033t.c[] cVarArr) {
        this.f73d = cVarArr;
    }

    @Override // A.x0
    public void p(z0 z0Var) {
        this.f75f = z0Var;
    }

    public p033t.c s(int i2, boolean z2) {
        p033t.c cVarH;
        int i3;
        if (i2 == 1) {
            return z2 ? p033t.c.a(0, Math.max(t().f4104b, j().f4104b), 0, 0) : p033t.c.a(0, j().f4104b, 0, 0);
        }
        if (i2 == 2) {
            if (z2) {
                p033t.c cVarT = t();
                p033t.c cVarH2 = h();
                return p033t.c.a(Math.max(cVarT.f4103a, cVarH2.f4103a), 0, Math.max(cVarT.f4105c, cVarH2.f4105c), Math.max(cVarT.f4106d, cVarH2.f4106d));
            }
            p033t.c cVarJ = j();
            z0 z0Var = this.f75f;
            cVarH = z0Var != null ? z0Var.f91a.h() : null;
            int iMin = cVarJ.f4106d;
            if (cVarH != null) {
                iMin = Math.min(iMin, cVarH.f4106d);
            }
            return p033t.c.a(cVarJ.f4103a, 0, cVarJ.f4105c, iMin);
        }
        p033t.c cVar = p033t.c.f4102e;
        if (i2 == 8) {
            p033t.c[] cVarArr = this.f73d;
            cVarH = cVarArr != null ? cVarArr[3] : null;
            if (cVarH != null) {
                return cVarH;
            }
            p033t.c cVarJ2 = j();
            p033t.c cVarT2 = t();
            int i4 = cVarJ2.f4106d;
            if (i4 > cVarT2.f4106d) {
                return p033t.c.a(0, 0, 0, i4);
            }
            p033t.c cVar2 = this.g;
            return (cVar2 == null || cVar2.equals(cVar) || (i3 = this.g.f4106d) <= cVarT2.f4106d) ? cVar : p033t.c.a(0, 0, 0, i3);
        }
        if (i2 == 16) {
            return i();
        }
        if (i2 == 32) {
            return g();
        }
        if (i2 == 64) {
            return k();
        }
        if (i2 != 128) {
            return cVar;
        }
        z0 z0Var2 = this.f75f;
        C0012l c0012lE = z0Var2 != null ? z0Var2.f91a.e() : e();
        if (c0012lE == null) {
            return cVar;
        }
        int i5 = Build.VERSION.SDK_INT;
        return p033t.c.a(i5 >= 28 ? AbstractC0011k.d(c0012lE.f46a) : 0, i5 >= 28 ? AbstractC0011k.f(c0012lE.f46a) : 0, i5 >= 28 ? AbstractC0011k.e(c0012lE.f46a) : 0, i5 >= 28 ? AbstractC0011k.c(c0012lE.f46a) : 0);
    }

    public void w(p033t.c cVar) {
        this.g = cVar;
    }
}
