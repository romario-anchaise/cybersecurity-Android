// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.appcompat.widget;

import A.C0005e;
import H.C0028c;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import p009f.J;
import p013i.C;
import p013i.l;
import p013i.m;
import p013i.n;
import p013i.p;
import p013i.z;
import p015j.A0;
import p015j.B0;
import p015j.C0146g;
import p015j.C0152j;
import p015j.C0154k;
import p015j.C0158m;
import p015j.InterfaceC0156l;
import p015j.InterfaceC0160n;
import p015j.y1;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends B0 implements m, C {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public InterfaceC0160n f1351A;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public n f1352p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Context f1353q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1354r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1355s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public C0154k f1356t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public J f1357u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public l f1358v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1359w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1360x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f1361y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f1362z;

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f1361y = (int) (56.0f * f2);
        this.f1362z = (int) (f2 * 4.0f);
        this.f1353q = context;
        this.f1354r = 0;
    }

    public static C0158m k() {
        C0158m c0158m = new C0158m(-2, -2);
        c0158m.f3241a = false;
        ((LinearLayout.LayoutParams) c0158m).gravity = 16;
        return c0158m;
    }

    public static C0158m l(ViewGroup.LayoutParams layoutParams) {
        C0158m c0158m;
        if (layoutParams == null) {
            return k();
        }
        if (layoutParams instanceof C0158m) {
            C0158m c0158m2 = (C0158m) layoutParams;
            c0158m = new C0158m(c0158m2);
            c0158m.f3241a = c0158m2.f3241a;
        } else {
            c0158m = new C0158m(layoutParams);
        }
        if (((LinearLayout.LayoutParams) c0158m).gravity <= 0) {
            ((LinearLayout.LayoutParams) c0158m).gravity = 16;
        }
        return c0158m;
    }

    @Override // p013i.C
    public final void b(n nVar) {
        this.f1352p = nVar;
    }

    @Override // p013i.m
    public final boolean c(p pVar) {
        return this.f1352p.q(pVar, null, 0);
    }

    @Override // p015j.B0, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0158m;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // p015j.B0
    /* JADX INFO: renamed from: g */
    public final /* bridge */ /* synthetic */ A0 generateDefaultLayoutParams() {
        return k();
    }

    @Override // p015j.B0, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return k();
    }

    @Override // p015j.B0, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return l(layoutParams);
    }

    public Menu getMenu() {
        if (this.f1352p == null) {
            Context context = getContext();
            n nVar = new n(context);
            this.f1352p = nVar;
            nVar.f2935e = new C0005e(20, this);
            C0154k c0154k = new C0154k(context);
            this.f1356t = c0154k;
            c0154k.f3216l = true;
            c0154k.f3217m = true;
            z c0028c = this.f1357u;
            if (c0028c == null) {
                c0028c = new C0028c(17);
            }
            c0154k.f3210e = c0028c;
            this.f1352p.b(c0154k, this.f1353q);
            C0154k c0154k2 = this.f1356t;
            c0154k2.f3212h = this;
            this.f1352p = c0154k2.f3208c;
        }
        return this.f1352p;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        C0154k c0154k = this.f1356t;
        C0152j c0152j = c0154k.f3213i;
        if (c0152j != null) {
            return c0152j.getDrawable();
        }
        if (c0154k.f3215k) {
            return c0154k.f3214j;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.f1354r;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // p015j.B0
    /* JADX INFO: renamed from: h */
    public final A0 generateLayoutParams(AttributeSet attributeSet) {
        return new C0158m(getContext(), attributeSet);
    }

    @Override // p015j.B0
    /* JADX INFO: renamed from: i */
    public final /* bridge */ /* synthetic */ A0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return l(layoutParams);
    }

    public final boolean m(int i2) {
        boolean zB = false;
        if (i2 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i2 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i2);
        if (i2 < getChildCount() && (childAt instanceof InterfaceC0156l)) {
            zB = ((InterfaceC0156l) childAt).b();
        }
        return (i2 <= 0 || !(childAt2 instanceof InterfaceC0156l)) ? zB : zB | ((InterfaceC0156l) childAt2).a();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0154k c0154k = this.f1356t;
        if (c0154k != null) {
            c0154k.c();
            if (this.f1356t.i()) {
                this.f1356t.e();
                this.f1356t.l();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0154k c0154k = this.f1356t;
        if (c0154k != null) {
            c0154k.e();
            C0146g c0146g = c0154k.f3224t;
            if (c0146g == null || !c0146g.b()) {
                return;
            }
            c0146g.f3004i.dismiss();
        }
    }

    @Override // p015j.B0, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int width;
        int paddingLeft;
        if (!this.f1359w) {
            super.onLayout(z2, i2, i3, i4, i5);
            return;
        }
        int childCount = getChildCount();
        int i6 = (i5 - i3) / 2;
        int dividerWidth = getDividerWidth();
        int i7 = i4 - i2;
        int paddingRight = (i7 - getPaddingRight()) - getPaddingLeft();
        boolean zA = y1.a(this);
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                C0158m c0158m = (C0158m) childAt.getLayoutParams();
                if (c0158m.f3241a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (m(i10)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zA) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) c0158m).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) c0158m).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i11 = i6 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i11, width, measuredHeight + i11);
                    paddingRight -= measuredWidth;
                    i8 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) c0158m).leftMargin) + ((LinearLayout.LayoutParams) c0158m).rightMargin;
                    m(i10);
                    i9++;
                }
            }
        }
        if (childCount == 1 && i8 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i12 = (i7 / 2) - (measuredWidth2 / 2);
            int i13 = i6 - (measuredHeight2 / 2);
            childAt2.layout(i12, i13, measuredWidth2 + i12, measuredHeight2 + i13);
            return;
        }
        int i14 = i9 - (i8 ^ 1);
        int iMax = Math.max(0, i14 > 0 ? paddingRight / i14 : 0);
        if (zA) {
            int width2 = getWidth() - getPaddingRight();
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt3 = getChildAt(i15);
                C0158m c0158m2 = (C0158m) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !c0158m2.f3241a) {
                    int i16 = width2 - ((LinearLayout.LayoutParams) c0158m2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i17 = i6 - (measuredHeight3 / 2);
                    childAt3.layout(i16 - measuredWidth3, i17, i16, measuredHeight3 + i17);
                    width2 = i16 - ((measuredWidth3 + ((LinearLayout.LayoutParams) c0158m2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt4 = getChildAt(i18);
            C0158m c0158m3 = (C0158m) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !c0158m3.f3241a) {
                int i19 = paddingLeft2 + ((LinearLayout.LayoutParams) c0158m3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i20 = i6 - (measuredHeight4 / 2);
                childAt4.layout(i19, i20, i19 + measuredWidth4, measuredHeight4 + i20);
                paddingLeft2 = measuredWidth4 + ((LinearLayout.LayoutParams) c0158m3).rightMargin + iMax + i19;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v36 */
    @Override // p015j.B0, android.view.View
    public final void onMeasure(int i2, int i3) {
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        int i6;
        ?? r4;
        int i7;
        n nVar;
        boolean z4 = this.f1359w;
        boolean z5 = View.MeasureSpec.getMode(i2) == 1073741824;
        this.f1359w = z5;
        if (z4 != z5) {
            this.f1360x = 0;
        }
        int size = View.MeasureSpec.getSize(i2);
        if (this.f1359w && (nVar = this.f1352p) != null && size != this.f1360x) {
            this.f1360x = size;
            nVar.p(true);
        }
        int childCount = getChildCount();
        if (!this.f1359w || childCount <= 0) {
            for (int i8 = 0; i8 < childCount; i8++) {
                C0158m c0158m = (C0158m) getChildAt(i8).getLayoutParams();
                ((LinearLayout.LayoutParams) c0158m).rightMargin = 0;
                ((LinearLayout.LayoutParams) c0158m).leftMargin = 0;
            }
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i2);
        int size3 = View.MeasureSpec.getSize(i3);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingBottom, -2);
        int i9 = size2 - paddingRight;
        int i10 = this.f1361y;
        int i11 = i9 / i10;
        int i12 = i9 % i10;
        if (i11 == 0) {
            setMeasuredDimension(i9, 0);
            return;
        }
        int i13 = (i12 / i11) + i10;
        int childCount2 = getChildCount();
        int iMax = 0;
        int i14 = 0;
        int iMax2 = 0;
        int i15 = 0;
        boolean z6 = false;
        int i16 = 0;
        long j2 = 0;
        while (true) {
            i4 = this.f1362z;
            if (i15 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i15);
            int i17 = size3;
            int i18 = i9;
            if (childAt.getVisibility() != 8) {
                boolean z7 = childAt instanceof ActionMenuItemView;
                int i19 = i14 + 1;
                if (z7) {
                    childAt.setPadding(i4, 0, i4, 0);
                }
                C0158m c0158m2 = (C0158m) childAt.getLayoutParams();
                c0158m2.f3246f = false;
                c0158m2.f3243c = 0;
                c0158m2.f3242b = 0;
                c0158m2.f3244d = false;
                ((LinearLayout.LayoutParams) c0158m2).leftMargin = 0;
                ((LinearLayout.LayoutParams) c0158m2).rightMargin = 0;
                c0158m2.f3245e = z7 && !TextUtils.isEmpty(((ActionMenuItemView) childAt).getText());
                int i20 = c0158m2.f3241a ? 1 : i11;
                C0158m c0158m3 = (C0158m) childAt.getLayoutParams();
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - paddingBottom, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z7 ? (ActionMenuItemView) childAt : null;
                boolean z8 = (actionMenuItemView == null || TextUtils.isEmpty(actionMenuItemView.getText())) ? false : true;
                if (i20 <= 0 || (z8 && i20 < 2)) {
                    i7 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i20 * i13, Integer.MIN_VALUE), iMakeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i7 = measuredWidth / i13;
                    if (measuredWidth % i13 != 0) {
                        i7++;
                    }
                    if (z8 && i7 < 2) {
                        i7 = 2;
                    }
                }
                c0158m3.f3244d = !c0158m3.f3241a && z8;
                c0158m3.f3242b = i7;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i7 * i13, 1073741824), iMakeMeasureSpec);
                iMax2 = Math.max(iMax2, i7);
                if (c0158m2.f3244d) {
                    i16++;
                }
                if (c0158m2.f3241a) {
                    z6 = true;
                }
                i11 -= i7;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (i7 == 1) {
                    j2 |= (long) (1 << i15);
                }
                i14 = i19;
            }
            i15++;
            size3 = i17;
            i9 = i18;
            paddingBottom = paddingBottom;
            mode = mode;
        }
        int i21 = mode;
        int i22 = i9;
        int i23 = size3;
        boolean z9 = z6 && i14 == 2;
        boolean z10 = false;
        while (true) {
            if (i16 <= 0 || i11 <= 0) {
                z2 = z10;
                break;
            }
            int i24 = Integer.MAX_VALUE;
            int i25 = 0;
            int i26 = 0;
            long j3 = 0;
            while (i26 < childCount2) {
                C0158m c0158m4 = (C0158m) getChildAt(i26).getLayoutParams();
                boolean z11 = z10;
                if (c0158m4.f3244d) {
                    int i27 = c0158m4.f3242b;
                    if (i27 < i24) {
                        j3 = 1 << i26;
                        i24 = i27;
                        i25 = 1;
                    } else if (i27 == i24) {
                        j3 |= 1 << i26;
                        i25++;
                    }
                }
                i26++;
                z10 = z11;
            }
            z2 = z10;
            j2 |= j3;
            if (i25 > i11) {
                break;
            }
            int i28 = i24 + 1;
            int i29 = 0;
            while (i29 < childCount2) {
                View childAt2 = getChildAt(i29);
                C0158m c0158m5 = (C0158m) childAt2.getLayoutParams();
                int i30 = iMax;
                int i31 = childMeasureSpec;
                int i32 = childCount2;
                long j4 = 1 << i29;
                if ((j3 & j4) != 0) {
                    if (z9 && c0158m5.f3245e) {
                        r4 = 1;
                        r4 = 1;
                        if (i11 == 1) {
                            childAt2.setPadding(i4 + i13, 0, i4, 0);
                        }
                    } else {
                        r4 = 1;
                    }
                    c0158m5.f3242b += r4;
                    c0158m5.f3246f = r4;
                    i11--;
                } else if (c0158m5.f3242b == i28) {
                    j2 |= j4;
                }
                i29++;
                childMeasureSpec = i31;
                iMax = i30;
                childCount2 = i32;
            }
            z10 = true;
        }
        int i33 = iMax;
        int i34 = childMeasureSpec;
        int i35 = childCount2;
        boolean z12 = !z6 && i14 == 1;
        if (i11 <= 0 || j2 == 0 || (i11 >= i14 - 1 && !z12 && iMax2 <= 1)) {
            i5 = i35;
            z3 = z2;
        } else {
            float fBitCount = Long.bitCount(j2);
            if (!z12) {
                if ((j2 & 1) != 0 && !((C0158m) getChildAt(0).getLayoutParams()).f3245e) {
                    fBitCount -= 0.5f;
                }
                int i36 = i35 - 1;
                if ((j2 & ((long) (1 << i36))) != 0 && !((C0158m) getChildAt(i36).getLayoutParams()).f3245e) {
                    fBitCount -= 0.5f;
                }
            }
            int i37 = fBitCount > 0.0f ? (int) ((i11 * i13) / fBitCount) : 0;
            boolean z13 = z2;
            i5 = i35;
            for (int i38 = 0; i38 < i5; i38++) {
                if ((j2 & ((long) (1 << i38))) != 0) {
                    View childAt3 = getChildAt(i38);
                    C0158m c0158m6 = (C0158m) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        c0158m6.f3243c = i37;
                        c0158m6.f3246f = true;
                        if (i38 == 0 && !c0158m6.f3245e) {
                            ((LinearLayout.LayoutParams) c0158m6).leftMargin = (-i37) / 2;
                        }
                        z13 = true;
                    } else if (c0158m6.f3241a) {
                        c0158m6.f3243c = i37;
                        c0158m6.f3246f = true;
                        ((LinearLayout.LayoutParams) c0158m6).rightMargin = (-i37) / 2;
                        z13 = true;
                    } else {
                        if (i38 != 0) {
                            ((LinearLayout.LayoutParams) c0158m6).leftMargin = i37 / 2;
                        }
                        if (i38 != i5 - 1) {
                            ((LinearLayout.LayoutParams) c0158m6).rightMargin = i37 / 2;
                        }
                    }
                }
            }
            z3 = z13;
        }
        if (z3) {
            int i39 = 0;
            while (i39 < i5) {
                View childAt4 = getChildAt(i39);
                C0158m c0158m7 = (C0158m) childAt4.getLayoutParams();
                if (c0158m7.f3246f) {
                    i6 = i34;
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((c0158m7.f3242b * i13) + c0158m7.f3243c, 1073741824), i6);
                } else {
                    i6 = i34;
                }
                i39++;
                i34 = i6;
            }
        }
        setMeasuredDimension(i22, i21 != 1073741824 ? i33 : i23);
    }

    public void setExpandedActionViewsExclusive(boolean z2) {
        this.f1356t.f3221q = z2;
    }

    public void setOnMenuItemClickListener(InterfaceC0160n interfaceC0160n) {
        this.f1351A = interfaceC0160n;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        C0154k c0154k = this.f1356t;
        C0152j c0152j = c0154k.f3213i;
        if (c0152j != null) {
            c0152j.setImageDrawable(drawable);
        } else {
            c0154k.f3215k = true;
            c0154k.f3214j = drawable;
        }
    }

    public void setOverflowReserved(boolean z2) {
        this.f1355s = z2;
    }

    public void setPopupTheme(int i2) {
        if (this.f1354r != i2) {
            this.f1354r = i2;
            if (i2 == 0) {
                this.f1353q = getContext();
            } else {
                this.f1353q = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setPresenter(C0154k c0154k) {
        this.f1356t = c0154k;
        c0154k.f3212h = this;
        this.f1352p = c0154k.f3208c;
    }

    @Override // p015j.B0, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0158m(getContext(), attributeSet);
    }
}
