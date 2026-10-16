// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.appcompat.widget;

import A.G;
import A.X;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.util.WeakHashMap;
import p015j.C0136b;
import p015j.T0;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f1298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f1299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f1300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Drawable f1301e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f1302f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1303h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f1304i;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C0136b c0136b = new C0136b(this);
        WeakHashMap weakHashMap = X.f14a;
        G.q(this, c0136b);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p007e.a.f2226a);
        boolean z2 = false;
        this.f1300d = typedArrayObtainStyledAttributes.getDrawable(0);
        this.f1301e = typedArrayObtainStyledAttributes.getDrawable(2);
        this.f1304i = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.g = true;
            this.f1302f = typedArrayObtainStyledAttributes.getDrawable(1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.g ? !(this.f1300d != null || this.f1301e != null) : this.f1302f == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1300d;
        if (drawable != null && drawable.isStateful()) {
            this.f1300d.setState(getDrawableState());
        }
        Drawable drawable2 = this.f1301e;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f1301e.setState(getDrawableState());
        }
        Drawable drawable3 = this.f1302f;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f1302f.setState(getDrawableState());
    }

    public View getTabContainer() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1300d;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1301e;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f1302f;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f1298b = findViewById(R.id.action_bar);
        this.f1299c = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1297a || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        boolean z3 = true;
        if (this.g) {
            Drawable drawable = this.f1302f;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z3 = false;
            }
        } else {
            if (this.f1300d == null) {
                z3 = false;
            } else if (this.f1298b.getVisibility() == 0) {
                this.f1300d.setBounds(this.f1298b.getLeft(), this.f1298b.getTop(), this.f1298b.getRight(), this.f1298b.getBottom());
            } else {
                View view = this.f1299c;
                if (view == null || view.getVisibility() != 0) {
                    this.f1300d.setBounds(0, 0, 0, 0);
                } else {
                    this.f1300d.setBounds(this.f1299c.getLeft(), this.f1299c.getTop(), this.f1299c.getRight(), this.f1299c.getBottom());
                }
            }
            this.f1303h = false;
        }
        if (z3) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        int i4;
        if (this.f1298b == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i4 = this.f1304i) >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i4, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        if (this.f1298b == null) {
            return;
        }
        View.MeasureSpec.getMode(i3);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f1300d;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f1300d);
        }
        this.f1300d = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f1298b;
            if (view != null) {
                this.f1300d.setBounds(view.getLeft(), this.f1298b.getTop(), this.f1298b.getRight(), this.f1298b.getBottom());
            }
        }
        boolean z2 = false;
        if (!this.g ? !(this.f1300d != null || this.f1301e != null) : this.f1302f == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f1302f;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f1302f);
        }
        this.f1302f = drawable;
        boolean z2 = this.g;
        boolean z3 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z2 && (drawable2 = this.f1302f) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z2 ? !(this.f1300d != null || this.f1301e != null) : this.f1302f == null) {
            z3 = true;
        }
        setWillNotDraw(z3);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2 = this.f1301e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f1301e);
        }
        this.f1301e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1303h && this.f1301e != null) {
                throw null;
            }
        }
        boolean z2 = false;
        if (!this.g ? !(this.f1300d != null || this.f1301e != null) : this.f1302f == null) {
            z2 = true;
        }
        setWillNotDraw(z2);
        invalidate();
        invalidateOutline();
    }

    public void setTransitioning(boolean z2) {
        this.f1297a = z2;
        setDescendantFocusability(z2 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z2 = i2 == 0;
        Drawable drawable = this.f1300d;
        if (drawable != null) {
            drawable.setVisible(z2, false);
        }
        Drawable drawable2 = this.f1301e;
        if (drawable2 != null) {
            drawable2.setVisible(z2, false);
        }
        Drawable drawable3 = this.f1302f;
        if (drawable3 != null) {
            drawable3.setVisible(z2, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1300d;
        boolean z2 = this.g;
        return (drawable == drawable2 && !z2) || (drawable == this.f1301e && this.f1303h) || ((drawable == this.f1302f && z2) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }

    public void setTabContainer(T0 t1) {
    }
}
