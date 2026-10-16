// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.appcompat.widget;

import A.G;
import A.X;
import A.h0;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.o2s2m.gae1fc3b2uc0u.R;
import f1.l;
import java.util.WeakHashMap;
import p009f.ViewOnClickListenerC0113c;
import p013i.C;
import p013i.n;
import p015j.C0134a;
import p015j.C0146g;
import p015j.C0154k;
import p015j.y1;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0134a f1305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ActionMenuView f1307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0154k f1308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h0 f1310f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1311h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CharSequence f1312i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f1313j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f1314k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f1315l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f1316m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LinearLayout f1317n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f1318o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f1319p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f1320q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f1321r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1322s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f1323t;

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        int resourceId;
        super(context, attributeSet, R.attr.actionModeStyle);
        this.f1305a = new C0134a(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1306b = context;
        } else {
            this.f1306b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p007e.a.f2229d, R.attr.actionModeStyle, 0);
        Drawable drawable = (!typedArrayObtainStyledAttributes.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes.getDrawable(0) : l.A(context, resourceId);
        WeakHashMap weakHashMap = X.f14a;
        G.q(this, drawable);
        this.f1320q = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.f1321r = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        this.f1309e = typedArrayObtainStyledAttributes.getLayoutDimension(3, 0);
        this.f1323t = typedArrayObtainStyledAttributes.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static int f(View view, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), i3);
        return Math.max(0, i2 - view.getMeasuredWidth());
    }

    public static int g(View view, int i2, int i3, int i4, boolean z2) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i5 = ((i4 - measuredHeight) / 2) + i3;
        if (z2) {
            view.layout(i2 - measuredWidth, i5, i2, measuredHeight + i5);
        } else {
            view.layout(i2, i5, i2 + measuredWidth, measuredHeight + i5);
        }
        return z2 ? -measuredWidth : measuredWidth;
    }

    public final void c(p011h.b bVar) {
        int i2 = 1;
        View view = this.f1314k;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f1323t, (ViewGroup) this, false);
            this.f1314k = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f1314k);
        }
        View viewFindViewById = this.f1314k.findViewById(R.id.action_mode_close_button);
        this.f1315l = viewFindViewById;
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC0113c(i2, bVar));
        n nVarC = bVar.c();
        C0154k c0154k = this.f1308d;
        if (c0154k != null) {
            c0154k.e();
            C0146g c0146g = c0154k.f3224t;
            if (c0146g != null && c0146g.b()) {
                c0146g.f3004i.dismiss();
            }
        }
        C0154k c0154k2 = new C0154k(getContext());
        this.f1308d = c0154k2;
        c0154k2.f3216l = true;
        c0154k2.f3217m = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        nVarC.b(this.f1308d, this.f1306b);
        C0154k c0154k3 = this.f1308d;
        C c2 = c0154k3.f3212h;
        if (c2 == null) {
            C c3 = (C) c0154k3.f3209d.inflate(c0154k3.f3211f, (ViewGroup) this, false);
            c0154k3.f3212h = c3;
            c3.b(c0154k3.f3208c);
            c0154k3.c();
        }
        C c4 = c0154k3.f3212h;
        if (c2 != c4) {
            ((ActionMenuView) c4).setPresenter(c0154k3);
        }
        ActionMenuView actionMenuView = (ActionMenuView) c4;
        this.f1307c = actionMenuView;
        WeakHashMap weakHashMap = X.f14a;
        G.q(actionMenuView, null);
        addView(this.f1307c, layoutParams);
    }

    public final void d() {
        if (this.f1317n == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1317n = linearLayout;
            this.f1318o = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f1319p = (TextView) this.f1317n.findViewById(R.id.action_bar_subtitle);
            int i2 = this.f1320q;
            if (i2 != 0) {
                this.f1318o.setTextAppearance(getContext(), i2);
            }
            int i3 = this.f1321r;
            if (i3 != 0) {
                this.f1319p.setTextAppearance(getContext(), i3);
            }
        }
        this.f1318o.setText(this.f1312i);
        this.f1319p.setText(this.f1313j);
        boolean zIsEmpty = TextUtils.isEmpty(this.f1312i);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f1313j);
        this.f1319p.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f1317n.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.f1317n.getParent() == null) {
            addView(this.f1317n);
        }
    }

    public final void e() {
        removeAllViews();
        this.f1316m = null;
        this.f1307c = null;
        this.f1308d = null;
        View view = this.f1315l;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getAnimatedVisibility() {
        return this.f1310f != null ? this.f1305a.f3137b : getVisibility();
    }

    public int getContentHeight() {
        return this.f1309e;
    }

    public CharSequence getSubtitle() {
        return this.f1313j;
    }

    public CharSequence getTitle() {
        return this.f1312i;
    }

    @Override // android.view.View
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void setVisibility(int i2) {
        if (i2 != getVisibility()) {
            h0 h0Var = this.f1310f;
            if (h0Var != null) {
                h0Var.b();
            }
            super.setVisibility(i2);
        }
    }

    public final h0 i(int i2, long j2) {
        h0 h0Var = this.f1310f;
        if (h0Var != null) {
            h0Var.b();
        }
        C0134a c0134a = this.f1305a;
        if (i2 != 0) {
            h0 h0VarA = X.a(this);
            h0VarA.a(0.0f);
            h0VarA.c(j2);
            c0134a.f3138c.f1310f = h0VarA;
            c0134a.f3137b = i2;
            h0VarA.d(c0134a);
            return h0VarA;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        h0 h0VarA2 = X.a(this);
        h0VarA2.a(1.0f);
        h0VarA2.c(j2);
        c0134a.f3138c.f1310f = h0VarA2;
        c0134a.f3137b = i2;
        h0VarA2.d(c0134a);
        return h0VarA2;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        int i2;
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, p007e.a.f2226a, R.attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(13, 0));
        typedArrayObtainStyledAttributes.recycle();
        C0154k c0154k = this.f1308d;
        if (c0154k != null) {
            Configuration configuration2 = c0154k.f3207b.getResources().getConfiguration();
            int i3 = configuration2.screenWidthDp;
            int i4 = configuration2.screenHeightDp;
            if (configuration2.smallestScreenWidthDp > 600 || i3 > 600 || ((i3 > 960 && i4 > 720) || (i3 > 720 && i4 > 960))) {
                i2 = 5;
            } else if (i3 >= 500 || ((i3 > 640 && i4 > 480) || (i3 > 480 && i4 > 640))) {
                i2 = 4;
            } else {
                i2 = i3 >= 360 ? 3 : 2;
            }
            c0154k.f3220p = i2;
            n nVar = c0154k.f3208c;
            if (nVar != null) {
                nVar.p(true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0154k c0154k = this.f1308d;
        if (c0154k != null) {
            c0154k.e();
            C0146g c0146g = this.f1308d.f3224t;
            if (c0146g == null || !c0146g.b()) {
                return;
            }
            c0146g.f3004i.dismiss();
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1311h = false;
        }
        if (!this.f1311h) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f1311h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1311h = false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        boolean zA = y1.a(this);
        int paddingRight = zA ? (i4 - i2) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
        View view = this.f1314k;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1314k.getLayoutParams();
            int i6 = zA ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = zA ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i8 = zA ? paddingRight - i6 : paddingRight + i6;
            int iG = g(this.f1314k, i8, paddingTop, paddingTop2, zA) + i8;
            paddingRight = zA ? iG - i7 : iG + i7;
        }
        LinearLayout linearLayout = this.f1317n;
        if (linearLayout != null && this.f1316m == null && linearLayout.getVisibility() != 8) {
            paddingRight += g(this.f1317n, paddingRight, paddingTop, paddingTop2, zA);
        }
        View view2 = this.f1316m;
        if (view2 != null) {
            g(view2, paddingRight, paddingTop, paddingTop2, zA);
        }
        int paddingLeft = zA ? getPaddingLeft() : (i4 - i2) - getPaddingRight();
        ActionMenuView actionMenuView = this.f1307c;
        if (actionMenuView != null) {
            g(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zA);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
        }
        if (View.MeasureSpec.getMode(i3) == 0) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        int size = View.MeasureSpec.getSize(i2);
        int size2 = this.f1309e;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i3);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingBottom;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f1314k;
        if (view != null) {
            int iF = f(view, paddingLeft, iMakeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1314k.getLayoutParams();
            paddingLeft = iF - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f1307c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = f(this.f1307c, paddingLeft, iMakeMeasureSpec);
        }
        LinearLayout linearLayout = this.f1317n;
        if (linearLayout != null && this.f1316m == null) {
            if (this.f1322s) {
                this.f1317n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f1317n.getMeasuredWidth();
                boolean z2 = measuredWidth <= paddingLeft;
                if (z2) {
                    paddingLeft -= measuredWidth;
                }
                this.f1317n.setVisibility(z2 ? 0 : 8);
            } else {
                paddingLeft = f(linearLayout, paddingLeft, iMakeMeasureSpec);
            }
        }
        View view2 = this.f1316m;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i4 = layoutParams.width;
            int i5 = i4 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i4 >= 0) {
                paddingLeft = Math.min(i4, paddingLeft);
            }
            int i6 = layoutParams.height;
            int i7 = i6 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i6 >= 0) {
                iMin = Math.min(i6, iMin);
            }
            this.f1316m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i5), View.MeasureSpec.makeMeasureSpec(iMin, i7));
        }
        if (this.f1309e > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            int measuredHeight = getChildAt(i9).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i8) {
                i8 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i8);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.g = false;
        }
        if (!this.g) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.g = false;
        }
        return true;
    }

    public void setContentHeight(int i2) {
        this.f1309e = i2;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f1316m;
        if (view2 != null) {
            removeView(view2);
        }
        this.f1316m = view;
        if (view != null && (linearLayout = this.f1317n) != null) {
            removeView(linearLayout);
            this.f1317n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1313j = charSequence;
        d();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1312i = charSequence;
        d();
        X.i(this, charSequence);
    }

    public void setTitleOptional(boolean z2) {
        if (z2 != this.f1322s) {
            requestLayout();
        }
        this.f1322s = z2;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
