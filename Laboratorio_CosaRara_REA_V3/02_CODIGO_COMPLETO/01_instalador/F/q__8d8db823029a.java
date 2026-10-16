// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import A.G;
import A.InterfaceC0024y;
import A.J;
import A.M;
import A.X;
import A.m0;
import A.o0;
import A.p0;
import A.q0;
import A.x0;
import A.z0;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActionBarContextView;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import p013i.n;
import p013i.z;
import p015j.InterfaceC0161n0;
import p015j.y1;
import p031r.d;
import p033t.c;

/* JADX INFO: loaded from: classes.dex */
public final class q implements InterfaceC0024y, InterfaceC0161n0, z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z f2514b;

    public /* synthetic */ q(z zVar, int i2) {
        this.f2513a = i2;
        this.f2514b = zVar;
    }

    @Override // p013i.z
    public void a(n nVar, boolean z2) {
        y yVar;
        switch (this.f2513a) {
            case 2:
                this.f2514b.s(nVar);
                break;
            default:
                n nVarK = nVar.k();
                int i2 = 0;
                boolean z3 = nVarK != nVar;
                if (z3) {
                    nVar = nVarK;
                }
                z zVar = this.f2514b;
                y[] yVarArr = zVar.f2559L;
                int length = yVarArr != null ? yVarArr.length : 0;
                while (true) {
                    if (i2 >= length) {
                        yVar = null;
                    } else {
                        yVar = yVarArr[i2];
                        if (yVar == null || yVar.f2535h != nVar) {
                            i2++;
                        }
                    }
                }
                if (yVar != null) {
                    if (!z3) {
                        zVar.t(yVar, z2);
                    } else {
                        zVar.r(yVar.f2529a, yVar, nVarK);
                        zVar.t(yVar, true);
                    }
                }
                break;
        }
    }

    @Override // A.InterfaceC0024y
    public z0 b(View view, z0 z0Var) {
        int i2;
        boolean z2;
        z0 z0VarB;
        q0 o0Var;
        boolean z3;
        x0 x0Var = z0Var.f91a;
        int i3 = x0Var.j().f4104b;
        z zVar = this.f2514b;
        zVar.getClass();
        int i4 = x0Var.j().f4104b;
        ActionBarContextView actionBarContextView = zVar.f2592v;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            i2 = 0;
            z2 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) zVar.f2592v.getLayoutParams();
            if (zVar.f2592v.isShown()) {
                if (zVar.f2575c0 == null) {
                    zVar.f2575c0 = new Rect();
                    zVar.f2576d0 = new Rect();
                }
                Rect rect = zVar.f2575c0;
                Rect rect2 = zVar.f2576d0;
                rect.set(x0Var.j().f4103a, x0Var.j().f4104b, x0Var.j().f4105c, x0Var.j().f4106d);
                ViewGroup viewGroup = zVar.f2548A;
                Method method = y1.f3354a;
                if (method != null) {
                    try {
                        method.invoke(viewGroup, rect, rect2);
                    } catch (Exception e2) {
                        Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e2);
                    }
                }
                int i5 = rect.top;
                int i6 = rect.left;
                int i7 = rect.right;
                ViewGroup viewGroup2 = zVar.f2548A;
                WeakHashMap weakHashMap = X.f14a;
                z0 z0VarA = M.a(viewGroup2);
                int i8 = z0VarA == null ? 0 : z0VarA.f91a.j().f4103a;
                int i9 = z0VarA == null ? 0 : z0VarA.f91a.j().f4105c;
                if (marginLayoutParams.topMargin == i5 && marginLayoutParams.leftMargin == i6 && marginLayoutParams.rightMargin == i7) {
                    z3 = false;
                } else {
                    marginLayoutParams.topMargin = i5;
                    marginLayoutParams.leftMargin = i6;
                    marginLayoutParams.rightMargin = i7;
                    z3 = true;
                }
                Context context = zVar.f2581k;
                if (i5 <= 0 || zVar.f2550C != null) {
                    View view2 = zVar.f2550C;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        int i10 = marginLayoutParams2.height;
                        int i11 = marginLayoutParams.topMargin;
                        if (i10 != i11 || marginLayoutParams2.leftMargin != i8 || marginLayoutParams2.rightMargin != i9) {
                            marginLayoutParams2.height = i11;
                            marginLayoutParams2.leftMargin = i8;
                            marginLayoutParams2.rightMargin = i9;
                            zVar.f2550C.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view3 = new View(context);
                    zVar.f2550C = view3;
                    view3.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = i8;
                    layoutParams.rightMargin = i9;
                    zVar.f2548A.addView(zVar.f2550C, -1, layoutParams);
                }
                View view4 = zVar.f2550C;
                z2 = view4 != null;
                if (z2 && view4.getVisibility() != 0) {
                    View view5 = zVar.f2550C;
                    view5.setBackgroundColor((G.g(view5) & 8192) != 0 ? d.a(context, R.color.abc_decor_view_status_guard_light) : d.a(context, R.color.abc_decor_view_status_guard));
                }
                if (!zVar.f2555H && z2) {
                    i4 = 0;
                }
                i2 = 0;
            } else {
                i2 = 0;
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z2 = false;
                    z3 = true;
                } else {
                    z3 = false;
                    z2 = false;
                }
            }
            if (z3) {
                zVar.f2592v.setLayoutParams(marginLayoutParams);
            }
        }
        View view6 = zVar.f2550C;
        if (view6 != null) {
            if (!z2) {
                i2 = 8;
            }
            view6.setVisibility(i2);
        }
        if (i3 != i4) {
            int i12 = x0Var.j().f4103a;
            int i13 = x0Var.j().f4105c;
            int i14 = x0Var.j().f4106d;
            int i15 = Build.VERSION.SDK_INT;
            if (i15 >= 30) {
                o0Var = new p0(z0Var);
            } else {
                o0Var = i15 >= 29 ? new o0(z0Var) : new m0(z0Var);
            }
            o0Var.d(c.a(i12, i4, i13, i14));
            z0VarB = o0Var.b();
        } else {
            z0VarB = z0Var;
        }
        WeakHashMap weakHashMap2 = X.f14a;
        WindowInsets windowInsetsB = z0VarB.b();
        if (windowInsetsB == null) {
            return z0VarB;
        }
        WindowInsets windowInsetsB2 = J.b(view, windowInsetsB);
        return !windowInsetsB2.equals(windowInsetsB) ? z0.c(windowInsetsB2, view) : z0VarB;
    }

    @Override // p013i.z
    public boolean j(n nVar) {
        Window.Callback callback;
        switch (this.f2513a) {
            case 2:
                Window.Callback callback2 = this.f2514b.f2582l.getCallback();
                if (callback2 != null) {
                    callback2.onMenuOpened(108, nVar);
                }
                break;
            default:
                if (nVar == nVar.k()) {
                    z zVar = this.f2514b;
                    if (zVar.f2553F && (callback = zVar.f2582l.getCallback()) != null && !zVar.f2564Q) {
                        callback.onMenuOpened(108, nVar);
                        break;
                    }
                }
                break;
        }
        return true;
    }
}
