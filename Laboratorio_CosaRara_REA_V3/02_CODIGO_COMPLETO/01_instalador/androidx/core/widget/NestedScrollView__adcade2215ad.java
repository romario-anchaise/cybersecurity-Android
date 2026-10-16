// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.core.widget;

import A.C0020u;
import A.C0023x;
import A.G;
import A.InterfaceC0022w;
import A.L;
import A.X;
import D.f;
import D.j;
import D.k;
import D.n;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import f1.l;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements InterfaceC0022w {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final float f1489A = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final j f1490B = new j();

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final int[] f1491C = {R.attr.fillViewport};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f1492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f1494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OverScroller f1495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EdgeEffect f1496e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final EdgeEffect f1497f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1498h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1499i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f1500j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1501k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public VelocityTracker f1502l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f1503m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f1504n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f1505o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f1506p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f1507q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1508r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int[] f1509s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int[] f1510t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1511u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1512v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public n f1513w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final C0023x f1514x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final C0020u f1515y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f1516z;

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.o2s2m.gae1fc3b2uc0u.R.attr.nestedScrollViewStyle);
        this.f1494c = new Rect();
        this.f1498h = true;
        this.f1499i = false;
        this.f1500j = null;
        this.f1501k = false;
        this.f1504n = true;
        this.f1508r = -1;
        this.f1509s = new int[2];
        this.f1510t = new int[2];
        int i2 = Build.VERSION.SDK_INT;
        this.f1496e = i2 >= 31 ? f.a(context, attributeSet) : new EdgeEffect(context);
        this.f1497f = i2 >= 31 ? f.a(context, attributeSet) : new EdgeEffect(context);
        this.f1492a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        this.f1495d = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f1505o = viewConfiguration.getScaledTouchSlop();
        this.f1506p = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1507q = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1491C, com.o2s2m.gae1fc3b2uc0u.R.attr.nestedScrollViewStyle, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f1514x = new C0023x();
        this.f1515y = new C0020u(this);
        setNestedScrollingEnabled(true);
        X.h(this, f1490B);
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f1516z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f1516z = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f1516z;
    }

    public static boolean m(View view, NestedScrollView nestedScrollView) {
        if (view == nestedScrollView) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && m((View) parent, nestedScrollView);
    }

    @Override // A.InterfaceC0021v
    public final void a(int i2, int i3, int[] iArr, int i4) {
        i(i2, i3, i4, iArr, null);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // A.InterfaceC0021v
    public final void b(View view, View view2, int i2, int i3) {
        C0023x c0023x = this.f1514x;
        if (i3 == 1) {
            c0023x.f87b = i2;
        } else {
            c0023x.f86a = i2;
        }
        w(2, i3);
    }

    @Override // A.InterfaceC0021v
    public final void c(ViewGroup viewGroup, int i2, int i3, int i4, int i5, int i6) {
        o(i5, i6, null);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x007b  */
    /* JADX WARN: Code duplicated, block: B:23:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:27:0x00aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:30:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:31:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:33:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:38:0x00db  */
    @Override // android.view.View
    public final void computeScroll() {
        int iRound;
        int[] iArr;
        int i2;
        int scrollRange;
        int overScrollMode;
        OverScroller overScroller = this.f1495d;
        if (overScroller.isFinished()) {
            return;
        }
        overScroller.computeScrollOffset();
        int currY = overScroller.getCurrY();
        int i3 = currY - this.f1512v;
        int height = getHeight();
        EdgeEffect edgeEffect = this.f1497f;
        EdgeEffect edgeEffect2 = this.f1496e;
        if (i3 <= 0 || l.z(edgeEffect2) == 0.0f) {
            if (i3 < 0 && l.z(edgeEffect) != 0.0f) {
                float f2 = height;
                iRound = Math.round(l.K(edgeEffect, (i3 * 4.0f) / f2, 0.5f) * (f2 / 4.0f));
                if (iRound != i3) {
                    edgeEffect.finish();
                }
            }
            this.f1512v = currY;
            iArr = this.f1510t;
            iArr[1] = 0;
            i(0, i3, 1, iArr, null);
            i2 = i3 - iArr[1];
            scrollRange = getScrollRange();
            if (i2 != 0) {
                int scrollY = getScrollY();
                q(i2, getScrollX(), scrollY, scrollRange);
                int scrollY2 = getScrollY() - scrollY;
                int i4 = i2 - scrollY2;
                iArr[1] = 0;
                this.f1515y.d(0, scrollY2, 0, i4, this.f1509s, 1, iArr);
                i2 = i4 - iArr[1];
            }
            if (i2 != 0) {
                overScrollMode = getOverScrollMode();
                if (overScrollMode != 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    if (i2 < 0) {
                        if (edgeEffect2.isFinished()) {
                            edgeEffect2.onAbsorb((int) overScroller.getCurrVelocity());
                        }
                    } else if (edgeEffect.isFinished()) {
                        edgeEffect.onAbsorb((int) overScroller.getCurrVelocity());
                    }
                }
                overScroller.abortAnimation();
                y(1);
            }
            if (!overScroller.isFinished()) {
                y(1);
            } else {
                WeakHashMap weakHashMap = X.f14a;
                G.k(this);
            }
        }
        iRound = Math.round(l.K(edgeEffect2, ((-i3) * 4.0f) / height, 0.5f) * ((-height) / 4.0f));
        if (iRound != i3) {
            edgeEffect2.finish();
        }
        i3 -= iRound;
        this.f1512v = currY;
        iArr = this.f1510t;
        iArr[1] = 0;
        i(0, i3, 1, iArr, null);
        i2 = i3 - iArr[1];
        scrollRange = getScrollRange();
        if (i2 != 0) {
            int scrollY3 = getScrollY();
            q(i2, getScrollX(), scrollY3, scrollRange);
            int scrollY4 = getScrollY() - scrollY3;
            int i5 = i2 - scrollY4;
            iArr[1] = 0;
            this.f1515y.d(0, scrollY4, 0, i5, this.f1509s, 1, iArr);
            i2 = i5 - iArr[1];
        }
        if (i2 != 0) {
            overScrollMode = getOverScrollMode();
            if (overScrollMode != 0) {
                if (i2 < 0) {
                    if (edgeEffect2.isFinished()) {
                        edgeEffect2.onAbsorb((int) overScroller.getCurrVelocity());
                    }
                } else if (edgeEffect.isFinished()) {
                    edgeEffect.onAbsorb((int) overScroller.getCurrVelocity());
                }
            } else if (i2 < 0) {
                if (edgeEffect2.isFinished()) {
                    edgeEffect2.onAbsorb((int) overScroller.getCurrVelocity());
                }
            } else if (edgeEffect.isFinished()) {
                edgeEffect.onAbsorb((int) overScroller.getCurrVelocity());
            }
            overScroller.abortAnimation();
            y(1);
        }
        if (!overScroller.isFinished()) {
            y(1);
        } else {
            WeakHashMap weakHashMap2 = X.f14a;
            G.k(this);
        }
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        return scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    @Override // A.InterfaceC0021v
    public final void d(View view, int i2) {
        C0023x c0023x = this.f1514x;
        if (i2 == 1) {
            c0023x.f87b = 0;
        } else {
            c0023x.f86a = 0;
        }
        y(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || j(keyEvent);
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.f1515y.a(f2, f3, z2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f2, float f3) {
        return this.f1515y.b(f2, f3);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.f1515y.c(i2, i3, 0, iArr, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.f1515y.d(i2, i3, i4, i5, iArr, 0, null);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        int scrollY = getScrollY();
        EdgeEffect edgeEffect = this.f1496e;
        int paddingLeft2 = 0;
        if (!edgeEffect.isFinished()) {
            int iSave = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int iMin = Math.min(0, scrollY);
            if (k.a(this)) {
                width -= getPaddingRight() + getPaddingLeft();
                paddingLeft = getPaddingLeft();
            } else {
                paddingLeft = 0;
            }
            if (k.a(this)) {
                height -= getPaddingBottom() + getPaddingTop();
                iMin += getPaddingTop();
            }
            canvas.translate(paddingLeft, iMin);
            edgeEffect.setSize(width, height);
            if (edgeEffect.draw(canvas)) {
                WeakHashMap weakHashMap = X.f14a;
                G.k(this);
            }
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect2 = this.f1497f;
        if (edgeEffect2.isFinished()) {
            return;
        }
        int iSave2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int iMax = Math.max(getScrollRange(), scrollY) + height2;
        if (k.a(this)) {
            width2 -= getPaddingRight() + getPaddingLeft();
            paddingLeft2 = getPaddingLeft();
        }
        if (k.a(this)) {
            height2 -= getPaddingBottom() + getPaddingTop();
            iMax -= getPaddingBottom();
        }
        canvas.translate(paddingLeft2 - width2, iMax);
        canvas.rotate(180.0f, width2, 0.0f);
        edgeEffect2.setSize(width2, height2);
        if (edgeEffect2.draw(canvas)) {
            WeakHashMap weakHashMap2 = X.f14a;
            G.k(this);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // A.InterfaceC0022w
    public final void e(ViewGroup viewGroup, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        o(i5, i6, iArr);
    }

    @Override // A.InterfaceC0021v
    public final boolean f(View view, View view2, int i2, int i3) {
        return (i2 & 2) != 0;
    }

    public final boolean g(int i2) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i2);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !n(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i2 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i2 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i2 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            t(maxScrollAmount, 0, 1, true);
        } else {
            Rect rect = this.f1494c;
            viewFindNextFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(viewFindNextFocus, rect);
            t(h(rect), 0, 1, true);
            viewFindNextFocus.requestFocus(i2);
        }
        if (viewFindFocus != null && viewFindFocus.isFocused() && !n(viewFindFocus, 0, getHeight())) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        C0023x c0023x = this.f1514x;
        return c0023x.f87b | c0023x.f86a;
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public final int h(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i2 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i3 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i2 - verticalFadingEdgeLength : i2;
        int i4 = rect.bottom;
        if (i4 > i3 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i3, (childAt.getBottom() + layoutParams.bottomMargin) - i2);
        }
        if (rect.top >= scrollY || i4 >= i3) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i3 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.f1515y.f(0);
    }

    public final boolean i(int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        return this.f1515y.c(i2, i3, i4, iArr, null);
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.f1515y.f80d;
    }

    public final boolean j(KeyEvent keyEvent) {
        this.f1494c.setEmpty();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 19) {
                    return keyEvent.isAltPressed() ? l(33) : g(33);
                }
                if (keyCode == 20) {
                    return keyEvent.isAltPressed() ? l(130) : g(130);
                }
                if (keyCode == 62) {
                    r(keyEvent.isShiftPressed() ? 33 : 130);
                    return false;
                }
                if (keyCode == 92) {
                    return l(33);
                }
                if (keyCode == 93) {
                    return l(130);
                }
                if (keyCode == 122) {
                    r(33);
                    return false;
                }
                if (keyCode != 123) {
                    return false;
                }
                r(130);
                return false;
            }
        }
        if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        }
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
        return (viewFindNextFocus == null || viewFindNextFocus == this || !viewFindNextFocus.requestFocus(130)) ? false : true;
    }

    public final void k(int i2) {
        if (getChildCount() > 0) {
            this.f1495d.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            w(2, 1);
            this.f1512v = getScrollY();
            WeakHashMap weakHashMap = X.f14a;
            G.k(this);
        }
    }

    public final boolean l(int i2) {
        int childCount;
        boolean z2 = i2 == 130;
        int height = getHeight();
        Rect rect = this.f1494c;
        rect.top = 0;
        rect.bottom = height;
        if (z2 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            rect.bottom = paddingBottom;
            rect.top = paddingBottom - height;
        }
        return s(i2, rect.top, rect.bottom);
    }

    @Override // android.view.ViewGroup
    public final void measureChild(View view, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    public final void measureChildWithMargins(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public final boolean n(View view, int i2, int i3) {
        Rect rect = this.f1494c;
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        return rect.bottom + i2 >= getScrollY() && rect.top - i2 <= getScrollY() + i3;
    }

    public final void o(int i2, int i3, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i2);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f1515y.d(0, scrollY2, 0, i2 - scrollY2, null, i3, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1499i = false;
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int width;
        float axisValue;
        if (motionEvent.getAction() == 8 && !this.f1501k) {
            if ((motionEvent.getSource() & 2) == 2) {
                axisValue = motionEvent.getAxisValue(9);
                width = (int) motionEvent.getX();
            } else if ((motionEvent.getSource() & 4194304) == 4194304) {
                axisValue = motionEvent.getAxisValue(26);
                width = getWidth() / 2;
            } else {
                width = 0;
                axisValue = 0.0f;
            }
            if (axisValue != 0.0f) {
                t(-((int) (axisValue * getVerticalScrollFactorCompat())), width, 1, (motionEvent.getSource() & 8194) == 8194);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0085  */
    /* JADX WARN: Code duplicated, block: B:36:0x008d  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:62:0x0117  */
    /* JADX WARN: Code duplicated, block: B:70:0x012b  */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        OverScroller overScroller = this.f1495d;
        int action = motionEvent.getAction();
        boolean z2 = true;
        if (action == 2 && this.f1501k) {
            return true;
        }
        int i2 = action & 255;
        if (i2 == 0) {
            int y2 = (int) motionEvent.getY();
            int x2 = (int) motionEvent.getX();
            if (getChildCount() > 0) {
                int scrollY = getScrollY();
                View childAt = getChildAt(0);
                if (y2 < childAt.getTop() - scrollY || y2 >= childAt.getBottom() - scrollY || x2 < childAt.getLeft() || x2 >= childAt.getRight()) {
                    if (!x(motionEvent) && overScroller.isFinished()) {
                        z2 = false;
                    }
                    this.f1501k = z2;
                    velocityTracker = this.f1502l;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        this.f1502l = null;
                    }
                } else {
                    this.g = y2;
                    this.f1508r = motionEvent.getPointerId(0);
                    VelocityTracker velocityTracker3 = this.f1502l;
                    if (velocityTracker3 == null) {
                        this.f1502l = VelocityTracker.obtain();
                    } else {
                        velocityTracker3.clear();
                    }
                    this.f1502l.addMovement(motionEvent);
                    overScroller.computeScrollOffset();
                    if (!x(motionEvent) && overScroller.isFinished()) {
                        z2 = false;
                    }
                    this.f1501k = z2;
                    w(2, 0);
                }
            } else {
                if (!x(motionEvent)) {
                    z2 = false;
                }
                this.f1501k = z2;
                velocityTracker = this.f1502l;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.f1502l = null;
                }
            }
        } else if (i2 == 1) {
            this.f1501k = false;
            this.f1508r = -1;
            velocityTracker2 = this.f1502l;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f1502l = null;
            }
            if (this.f1495d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                WeakHashMap weakHashMap = X.f14a;
                G.k(this);
            }
            y(0);
        } else if (i2 == 2) {
            int i3 = this.f1508r;
            if (i3 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i3);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + i3 + " in onInterceptTouchEvent");
                } else {
                    int y3 = (int) motionEvent.getY(iFindPointerIndex);
                    if (Math.abs(y3 - this.g) > this.f1505o && (getNestedScrollAxes() & 2) == 0) {
                        this.f1501k = true;
                        this.g = y3;
                        if (this.f1502l == null) {
                            this.f1502l = VelocityTracker.obtain();
                        }
                        this.f1502l.addMovement(motionEvent);
                        this.f1511u = 0;
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
            }
        } else if (i2 == 3) {
            this.f1501k = false;
            this.f1508r = -1;
            velocityTracker2 = this.f1502l;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f1502l = null;
            }
            if (this.f1495d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                WeakHashMap weakHashMap2 = X.f14a;
                G.k(this);
            }
            y(0);
        } else if (i2 == 6) {
            p(motionEvent);
        }
        return this.f1501k;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int measuredHeight;
        super.onLayout(z2, i2, i3, i4, i5);
        int i6 = 0;
        this.f1498h = false;
        View view = this.f1500j;
        if (view != null && m(view, this)) {
            View view2 = this.f1500j;
            Rect rect = this.f1494c;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int iH = h(rect);
            if (iH != 0) {
                scrollBy(0, iH);
            }
        }
        this.f1500j = null;
        if (!this.f1499i) {
            if (this.f1513w != null) {
                scrollTo(getScrollX(), this.f1513w.f142a);
                this.f1513w = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                measuredHeight = 0;
            }
            int paddingTop = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            if (paddingTop < measuredHeight && scrollY >= 0) {
                i6 = paddingTop + scrollY > measuredHeight ? measuredHeight - paddingTop : scrollY;
            }
            if (i6 != scrollY) {
                scrollTo(getScrollX(), i6);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1499i = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f1503m && View.MeasureSpec.getMode(i3) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        if (z2) {
            return false;
        }
        dispatchNestedFling(0.0f, f3, true);
        k((int) f3);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f2, float f3) {
        return this.f1515y.b(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        i(i2, i3, 0, iArr, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        o(i5, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i2) {
        b(view, view2, i2, 0);
    }

    @Override // android.view.View
    public final void onOverScrolled(int i2, int i3, boolean z2, boolean z3) {
        super.scrollTo(i2, i3);
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (i2 == 2) {
            i2 = 130;
        } else if (i2 == 1) {
            i2 = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i2) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i2);
        if (viewFindNextFocus != null && n(viewFindNextFocus, 0, getHeight())) {
            return viewFindNextFocus.requestFocus(i2, rect);
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof n)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        n nVar = (n) parcelable;
        super.onRestoreInstanceState(nVar.getSuperState());
        this.f1513w = nVar;
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        n nVar = new n(super.onSaveInstanceState());
        nVar.f142a = getScrollY();
        return nVar;
    }

    @Override // android.view.View
    public final void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !n(viewFindFocus, 0, i5)) {
            return;
        }
        Rect rect = this.f1494c;
        viewFindFocus.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(viewFindFocus, rect);
        int iH = h(rect);
        if (iH != 0) {
            if (this.f1504n) {
                v(0, iH, false);
            } else {
                scrollBy(0, iH);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i2) {
        return f(view, view2, i2, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        d(view, 0);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        OverScroller overScroller = this.f1495d;
        int i2 = this.f1505o;
        EdgeEffect edgeEffect = this.f1496e;
        EdgeEffect edgeEffect2 = this.f1497f;
        if (this.f1502l == null) {
            this.f1502l = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1511u = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        float f2 = 0.0f;
        motionEventObtain.offsetLocation(0.0f, this.f1511u);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f1502l;
                velocityTracker.computeCurrentVelocity(1000, this.f1507q);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f1508r);
                if (Math.abs(yVelocity) >= this.f1506p) {
                    if (l.z(edgeEffect) != 0.0f) {
                        if (u(edgeEffect, yVelocity)) {
                            edgeEffect.onAbsorb(yVelocity);
                        } else {
                            k(-yVelocity);
                        }
                    } else if (l.z(edgeEffect2) != 0.0f) {
                        int i3 = -yVelocity;
                        if (u(edgeEffect2, i3)) {
                            edgeEffect2.onAbsorb(i3);
                        } else {
                            k(i3);
                        }
                    } else {
                        int i4 = -yVelocity;
                        float f3 = i4;
                        if (!this.f1515y.b(0.0f, f3)) {
                            dispatchNestedFling(0.0f, f3, true);
                            k(i4);
                        }
                    }
                } else if (this.f1495d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    WeakHashMap weakHashMap = X.f14a;
                    G.k(this);
                }
                this.f1508r = -1;
                this.f1501k = false;
                VelocityTracker velocityTracker2 = this.f1502l;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.f1502l = null;
                }
                y(0);
                edgeEffect.onRelease();
                edgeEffect2.onRelease();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f1508r);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.f1508r + " in onTouchEvent");
                } else {
                    int y2 = (int) motionEvent.getY(iFindPointerIndex);
                    int i5 = this.g - y2;
                    float x2 = motionEvent.getX(iFindPointerIndex) / getWidth();
                    float height = i5 / getHeight();
                    if (l.z(edgeEffect) != 0.0f) {
                        float f4 = -l.K(edgeEffect, -height, x2);
                        if (l.z(edgeEffect) == 0.0f) {
                            edgeEffect.onRelease();
                        }
                        f2 = f4;
                    } else if (l.z(edgeEffect2) != 0.0f) {
                        float fK = l.K(edgeEffect2, height, 1.0f - x2);
                        if (l.z(edgeEffect2) == 0.0f) {
                            edgeEffect2.onRelease();
                        }
                        f2 = fK;
                    }
                    int iRound = Math.round(f2 * getHeight());
                    if (iRound != 0) {
                        invalidate();
                    }
                    int i6 = i5 - iRound;
                    if (!this.f1501k && Math.abs(i6) > i2) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f1501k = true;
                        i6 = i6 > 0 ? i6 - i2 : i6 + i2;
                    }
                    if (this.f1501k) {
                        int iT = t(i6, (int) motionEvent.getX(iFindPointerIndex), 0, false);
                        this.g = y2 - iT;
                        this.f1511u += iT;
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f1501k && getChildCount() > 0 && this.f1495d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    WeakHashMap weakHashMap2 = X.f14a;
                    G.k(this);
                }
                this.f1508r = -1;
                this.f1501k = false;
                VelocityTracker velocityTracker3 = this.f1502l;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.f1502l = null;
                }
                y(0);
                edgeEffect.onRelease();
                edgeEffect2.onRelease();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.g = (int) motionEvent.getY(actionIndex);
                this.f1508r = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                p(motionEvent);
                this.g = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f1508r));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.f1501k && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!overScroller.isFinished()) {
                overScroller.abortAnimation();
                y(1);
            }
            int y3 = (int) motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            this.g = y3;
            this.f1508r = pointerId;
            w(2, 0);
        }
        VelocityTracker velocityTracker4 = this.f1502l;
        if (velocityTracker4 != null) {
            velocityTracker4.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    public final void p(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f1508r) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.g = (int) motionEvent.getY(i2);
            this.f1508r = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.f1502l;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final boolean q(int i2, int i3, int i4, int i5) {
        boolean z2;
        boolean z3;
        getOverScrollMode();
        super.computeHorizontalScrollRange();
        super.computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        super.computeVerticalScrollExtent();
        int i6 = i4 + i2;
        if (i3 <= 0 && i3 >= 0) {
            z2 = false;
        } else {
            i3 = 0;
            z2 = true;
        }
        if (i6 > i5) {
            z3 = true;
        } else if (i6 < 0) {
            i5 = 0;
            z3 = true;
        } else {
            i5 = i6;
            z3 = false;
        }
        if (z3 && !this.f1515y.f(1)) {
            this.f1495d.springBack(i3, i5, 0, 0, 0, getScrollRange());
        }
        super.scrollTo(i3, i5);
        return z2 || z3;
    }

    public final void r(int i2) {
        boolean z2 = i2 == 130;
        int height = getHeight();
        Rect rect = this.f1494c;
        if (z2) {
            rect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                if (rect.top + height > paddingBottom) {
                    rect.top = paddingBottom - height;
                }
            }
        } else {
            int scrollY = getScrollY() - height;
            rect.top = scrollY;
            if (scrollY < 0) {
                rect.top = 0;
            }
        }
        int i3 = rect.top;
        int i4 = height + i3;
        rect.bottom = i4;
        s(i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        if (this.f1498h) {
            this.f1500j = view2;
        } else {
            Rect rect = this.f1494c;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int iH = h(rect);
            if (iH != 0) {
                scrollBy(0, iH);
            }
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int iH = h(rect);
        boolean z3 = iH != 0;
        if (z3) {
            if (z2) {
                scrollBy(0, iH);
            } else {
                v(0, iH, false);
            }
        }
        return z3;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z2) {
        VelocityTracker velocityTracker;
        if (z2 && (velocityTracker = this.f1502l) != null) {
            velocityTracker.recycle();
            this.f1502l = null;
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f1498h = true;
        super.requestLayout();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0068  */
    public final boolean s(int i2, int i3, int i4) {
        boolean z2;
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = height + scrollY;
        boolean z3 = i2 == 33;
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z4 = false;
        for (int i6 = 0; i6 < size; i6++) {
            View view2 = focusables.get(i6);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i3 < bottom && top < i4) {
                boolean z5 = i3 < top && bottom < i4;
                if (view == null) {
                    view = view2;
                    z4 = z5;
                } else {
                    boolean z6 = (z3 && top < view.getTop()) || (!z3 && bottom > view.getBottom());
                    if (z4) {
                        if (z5 && z6) {
                            view = view2;
                        }
                    } else if (z5) {
                        view = view2;
                        z4 = true;
                    } else if (z6) {
                        view = view2;
                    }
                }
            }
        }
        if (view == null) {
            view = this;
        }
        if (i3 < scrollY || i4 > i5) {
            t(z3 ? i3 - scrollY : i4 - i5, 0, 1, true);
            z2 = true;
        } else {
            z2 = false;
        }
        if (view != findFocus()) {
            view.requestFocus(i2);
        }
        return z2;
    }

    @Override // android.view.View
    public final void scrollTo(int i2, int i3) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (width >= width2 || i2 < 0) {
                i2 = 0;
            } else if (width + i2 > width2) {
                i2 = width2 - width;
            }
            if (height >= height2 || i3 < 0) {
                i3 = 0;
            } else if (height + i3 > height2) {
                i3 = height2 - height;
            }
            if (i2 == getScrollX() && i3 == getScrollY()) {
                return;
            }
            super.scrollTo(i2, i3);
        }
    }

    public void setFillViewport(boolean z2) {
        if (z2 != this.f1503m) {
            this.f1503m = z2;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        C0020u c0020u = this.f1515y;
        if (c0020u.f80d) {
            WeakHashMap weakHashMap = X.f14a;
            L.z(c0020u.f79c);
        }
        c0020u.f80d = z2;
    }

    public void setSmoothScrollingEnabled(boolean z2) {
        this.f1504n = z2;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i2) {
        return this.f1515y.g(i2, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        y(0);
    }

    public final int t(int i2, int i3, int i4, boolean z2) {
        int i5;
        int i6;
        boolean z3;
        if (i4 == 1) {
            w(2, i4);
        }
        boolean zC = this.f1515y.c(0, i2, i4, this.f1510t, this.f1509s);
        int[] iArr = this.f1510t;
        int[] iArr2 = this.f1509s;
        if (zC) {
            i5 = i2 - iArr[1];
            i6 = iArr2[1];
        } else {
            i5 = i2;
            i6 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        int overScrollMode = getOverScrollMode();
        boolean z4 = (overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0)) && !z2;
        boolean z5 = q(i5, 0, scrollY, scrollRange) && !this.f1515y.f(i4);
        int scrollY2 = getScrollY() - scrollY;
        iArr[1] = 0;
        this.f1515y.d(0, scrollY2, 0, i5 - scrollY2, this.f1509s, i4, iArr);
        int i7 = i6 + iArr2[1];
        int i8 = i5 - iArr[1];
        int i9 = scrollY + i8;
        EdgeEffect edgeEffect = this.f1497f;
        EdgeEffect edgeEffect2 = this.f1496e;
        if (i9 < 0) {
            if (z4) {
                l.K(edgeEffect2, (-i8) / getHeight(), i3 / getWidth());
                if (!edgeEffect.isFinished()) {
                    edgeEffect.onRelease();
                }
            }
        } else if (i9 > scrollRange && z4) {
            l.K(edgeEffect, i8 / getHeight(), 1.0f - (i3 / getWidth()));
            if (!edgeEffect2.isFinished()) {
                edgeEffect2.onRelease();
            }
        }
        if (edgeEffect2.isFinished() && edgeEffect.isFinished()) {
            z3 = z5;
        } else {
            WeakHashMap weakHashMap = X.f14a;
            G.k(this);
            z3 = false;
        }
        if (z3 && i4 == 0) {
            this.f1502l.clear();
        }
        if (i4 == 1) {
            y(i4);
            edgeEffect2.onRelease();
            edgeEffect.onRelease();
        }
        return i7;
    }

    public final boolean u(EdgeEffect edgeEffect, int i2) {
        if (i2 > 0) {
            return true;
        }
        float fZ = l.z(edgeEffect) * getHeight();
        float fAbs = Math.abs(-i2) * 0.35f;
        float f2 = this.f1492a * 0.015f;
        double dLog = Math.log(fAbs / f2);
        double d2 = f1489A;
        return ((float) (Math.exp((d2 / (d2 - 1.0d)) * dLog) * ((double) f2))) < fZ;
    }

    public final void v(int i2, int i3, boolean z2) {
        OverScroller overScroller = this.f1495d;
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f1493b > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f1495d.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i3 + scrollY, Math.max(0, height - height2))) - scrollY, 250);
            if (z2) {
                w(2, 1);
            } else {
                y(1);
            }
            this.f1512v = getScrollY();
            WeakHashMap weakHashMap = X.f14a;
            G.k(this);
        } else {
            if (!overScroller.isFinished()) {
                overScroller.abortAnimation();
                y(1);
            }
            scrollBy(i2, i3);
        }
        this.f1493b = AnimationUtils.currentAnimationTimeMillis();
    }

    public final void w(int i2, int i3) {
        this.f1515y.g(2, i3);
    }

    public final boolean x(MotionEvent motionEvent) {
        boolean z2;
        EdgeEffect edgeEffect = this.f1496e;
        if (l.z(edgeEffect) != 0.0f) {
            l.K(edgeEffect, 0.0f, motionEvent.getX() / getWidth());
            z2 = true;
        } else {
            z2 = false;
        }
        EdgeEffect edgeEffect2 = this.f1497f;
        if (l.z(edgeEffect2) == 0.0f) {
            return z2;
        }
        l.K(edgeEffect2, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    public final void y(int i2) {
        this.f1515y.h(i2);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2) {
        if (getChildCount() <= 0) {
            super.addView(view, i2);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void setOnScrollChangeListener(D.l lVar) {
    }
}
