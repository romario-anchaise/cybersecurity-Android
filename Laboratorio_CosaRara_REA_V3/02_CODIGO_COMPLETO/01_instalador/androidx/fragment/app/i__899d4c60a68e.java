// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.fragment.app;

import A.J;
import A.X;
import A.z0;
import android.animation.LayoutTransition;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class i extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f1552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f1553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f1554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1555d;

    public final void a(View view) {
        ArrayList arrayList = this.f1553b;
        if (arrayList == null || !arrayList.contains(view)) {
            return;
        }
        if (this.f1552a == null) {
            this.f1552a = new ArrayList();
        }
        this.f1552a.add(view);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        view.getTag(R.id.fragment_container_view_tag);
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    public final boolean addViewInLayout(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z2) {
        view.getTag(R.id.fragment_container_view_tag);
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        z0 z0VarC;
        z0 z0VarC2 = z0.c(windowInsets, null);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f1554c;
        if (onApplyWindowInsetsListener != null) {
            z0VarC = z0.c(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets), null);
        } else {
            WeakHashMap weakHashMap = X.f14a;
            WindowInsets windowInsetsB = z0VarC2.b();
            if (windowInsetsB != null) {
                WindowInsets windowInsetsB2 = J.b(this, windowInsetsB);
                if (!windowInsetsB2.equals(windowInsetsB)) {
                    z0VarC2 = z0.c(windowInsetsB2, this);
                }
            }
            z0VarC = z0VarC2;
        }
        if (!z0VarC.f91a.m()) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                WeakHashMap weakHashMap2 = X.f14a;
                WindowInsets windowInsetsB3 = z0VarC.b();
                if (windowInsetsB3 != null) {
                    WindowInsets windowInsetsA = J.a(childAt, windowInsetsB3);
                    if (!windowInsetsA.equals(windowInsetsB3)) {
                        z0.c(windowInsetsA, childAt);
                    }
                }
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        if (this.f1555d && this.f1552a != null) {
            for (int i2 = 0; i2 < this.f1552a.size(); i2++) {
                super.drawChild(canvas, (View) this.f1552a.get(i2), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j2) {
        ArrayList arrayList;
        if (!this.f1555d || (arrayList = this.f1552a) == null || arrayList.size() <= 0 || !this.f1552a.contains(view)) {
            return super.drawChild(canvas, view, j2);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        ArrayList arrayList = this.f1553b;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList arrayList2 = this.f1552a;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f1555d = true;
            }
        }
        super.endViewTransition(view);
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z2) {
        if (z2) {
            a(view);
        }
        super.removeDetachedView(view, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i2) {
        a(getChildAt(i2));
        super.removeViewAt(i2);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            a(getChildAt(i4));
        }
        super.removeViews(i2, i3);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            a(getChildAt(i4));
        }
        super.removeViewsInLayout(i2, i3);
    }

    public void setDrawDisappearingViewsLast(boolean z2) {
        this.f1555d = z2;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.f1554c = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.f1553b == null) {
                this.f1553b = new ArrayList();
            }
            this.f1553b.add(view);
        }
        super.startViewTransition(view);
    }
}
