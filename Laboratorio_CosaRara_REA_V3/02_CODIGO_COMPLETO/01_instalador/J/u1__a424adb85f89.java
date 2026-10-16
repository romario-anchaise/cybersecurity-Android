// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import A.G;
import A.I;
import A.X;
import A.Z;
import A.a0;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class u1 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static u1 f3308k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static u1 f3309l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f3310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f3311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t1 f3313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t1 f3314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3315f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public v1 f3316h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3317i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3318j;

    /* JADX WARN: Type inference failed for: r0v0, types: [j.t1] */
    /* JADX WARN: Type inference failed for: r0v1, types: [j.t1] */
    public u1(View view, CharSequence charSequence) {
        final int i2 = 0;
        this.f3313d = new Runnable(this) { // from class: j.t1

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ u1 f3304b;

            {
                this.f3304b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        this.f3304b.c(false);
                        break;
                    default:
                        this.f3304b.a();
                        break;
                }
            }
        };
        final int i3 = 1;
        this.f3314e = new Runnable(this) { // from class: j.t1

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ u1 f3304b;

            {
                this.f3304b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i3) {
                    case 0:
                        this.f3304b.c(false);
                        break;
                    default:
                        this.f3304b.a();
                        break;
                }
            }
        };
        this.f3310a = view;
        this.f3311b = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = a0.f20a;
        this.f3312c = Build.VERSION.SDK_INT >= 28 ? Z.a(viewConfiguration) : viewConfiguration.getScaledTouchSlop() / 2;
        this.f3318j = true;
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void b(u1 u1Var) {
        u1 u1Var2 = f3308k;
        if (u1Var2 != null) {
            u1Var2.f3310a.removeCallbacks(u1Var2.f3313d);
        }
        f3308k = u1Var;
        if (u1Var != null) {
            u1Var.f3310a.postDelayed(u1Var.f3313d, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        u1 u1Var = f3309l;
        View view = this.f3310a;
        if (u1Var == this) {
            f3309l = null;
            v1 v1Var = this.f3316h;
            if (v1Var != null) {
                View view2 = v1Var.f3327b;
                if (view2.getParent() != null) {
                    ((WindowManager) v1Var.f3326a.getSystemService("window")).removeView(view2);
                }
                this.f3316h = null;
                this.f3318j = true;
                view.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f3308k == this) {
            b(null);
        }
        view.removeCallbacks(this.f3314e);
    }

    public final void c(boolean z2) {
        int height;
        int i2;
        int i3;
        long longPressTimeout;
        long j2;
        long j3;
        WeakHashMap weakHashMap = X.f14a;
        View view = this.f3310a;
        if (I.b(view)) {
            b(null);
            u1 u1Var = f3309l;
            if (u1Var != null) {
                u1Var.a();
            }
            f3309l = this;
            this.f3317i = z2;
            v1 v1Var = new v1(view.getContext());
            this.f3316h = v1Var;
            int width = this.f3315f;
            int i4 = this.g;
            boolean z3 = this.f3317i;
            View view2 = v1Var.f3327b;
            ViewParent parent = view2.getParent();
            Context context = v1Var.f3326a;
            if (parent != null && view2.getParent() != null) {
                ((WindowManager) context.getSystemService("window")).removeView(view2);
            }
            v1Var.f3328c.setText(this.f3311b);
            WindowManager.LayoutParams layoutParams = v1Var.f3329d;
            layoutParams.token = view.getApplicationWindowToken();
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
            if (view.getWidth() < dimensionPixelOffset) {
                width = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
                height = i4 + dimensionPixelOffset2;
                i2 = i4 - dimensionPixelOffset2;
            } else {
                height = view.getHeight();
                i2 = 0;
            }
            layoutParams.gravity = 49;
            int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(z3 ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
            View rootView = view.getRootView();
            ViewGroup.LayoutParams layoutParams2 = rootView.getLayoutParams();
            if (!(layoutParams2 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams2).type != 2) {
                for (Context context2 = view.getContext(); context2 instanceof ContextWrapper; context2 = ((ContextWrapper) context2).getBaseContext()) {
                    if (context2 instanceof Activity) {
                        rootView = ((Activity) context2).getWindow().getDecorView();
                        break;
                    }
                }
            }
            if (rootView == null) {
                Log.e("TooltipPopup", "Cannot find app view");
            } else {
                Rect rect = v1Var.f3330e;
                rootView.getWindowVisibleDisplayFrame(rect);
                if (rect.left >= 0 || rect.top >= 0) {
                    i3 = 0;
                } else {
                    Resources resources = context.getResources();
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    i3 = 0;
                    rect.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                int[] iArr = v1Var.g;
                rootView.getLocationOnScreen(iArr);
                int[] iArr2 = v1Var.f3331f;
                view.getLocationOnScreen(iArr2);
                int i5 = iArr2[i3] - iArr[i3];
                iArr2[i3] = i5;
                iArr2[1] = iArr2[1] - iArr[1];
                layoutParams.x = (i5 + width) - (rootView.getWidth() / 2);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, i3);
                view2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredHeight = view2.getMeasuredHeight();
                int i6 = iArr2[1];
                int i7 = ((i2 + i6) - dimensionPixelOffset3) - measuredHeight;
                int i8 = i6 + height + dimensionPixelOffset3;
                if (z3) {
                    if (i7 >= 0) {
                        layoutParams.y = i7;
                    } else {
                        layoutParams.y = i8;
                    }
                } else if (measuredHeight + i8 <= rect.height()) {
                    layoutParams.y = i8;
                } else {
                    layoutParams.y = i7;
                }
            }
            ((WindowManager) context.getSystemService("window")).addView(view2, layoutParams);
            view.addOnAttachStateChangeListener(this);
            if (this.f3317i) {
                j3 = 2500;
            } else {
                if ((G.g(view) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j2 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j2 = 15000;
                }
                j3 = j2 - longPressTimeout;
            }
            t1 t1Var = this.f3314e;
            view.removeCallbacks(t1Var);
            view.postDelayed(t1Var, j3);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0066  */
    @Override // android.view.View.OnHoverListener
    public final boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f3316h != null && this.f3317i) {
            return false;
        }
        View view2 = this.f3310a;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view2.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                this.f3318j = true;
                a();
            }
        } else if (view2.isEnabled() && this.f3316h == null) {
            int x2 = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (this.f3318j) {
                this.f3315f = x2;
                this.g = y2;
                this.f3318j = false;
                b(this);
            } else {
                int iAbs = Math.abs(x2 - this.f3315f);
                int i2 = this.f3312c;
                if (iAbs > i2 || Math.abs(y2 - this.g) > i2) {
                    this.f3315f = x2;
                    this.g = y2;
                    this.f3318j = false;
                    b(this);
                }
            }
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f3315f = view.getWidth() / 2;
        this.g = view.getHeight() / 2;
        c(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        a();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
