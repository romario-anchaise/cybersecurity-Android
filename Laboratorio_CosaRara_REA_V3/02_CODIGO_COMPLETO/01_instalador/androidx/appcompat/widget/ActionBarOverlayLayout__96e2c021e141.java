// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.appcompat.widget;

import A.C0023x;
import A.G;
import A.InterfaceC0021v;
import A.InterfaceC0022w;
import A.J;
import A.L;
import A.X;
import A.m0;
import A.o0;
import A.p0;
import A.q0;
import A.x0;
import A.z0;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.util.WeakHashMap;
import p009f.P;
import p011h.l;
import p013i.n;
import p013i.z;
import p015j.C0138c;
import p015j.C0144f;
import p015j.C0154k;
import p015j.InterfaceC0142e;
import p015j.InterfaceC0163o0;
import p015j.InterfaceC0165p0;
import p015j.RunnableC0140d;
import p015j.m1;
import p015j.r1;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements InterfaceC0163o0, InterfaceC0021v, InterfaceC0022w {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final int[] f1324B = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final C0023x f1325A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ContentFrameLayout f1328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActionBarContainer f1329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public InterfaceC0165p0 f1330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f1331f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1332h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1333i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1334j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1335k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1336l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1337m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Rect f1338n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Rect f1339o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Rect f1340p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public z0 f1341q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public z0 f1342r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public z0 f1343s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public z0 f1344t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public InterfaceC0142e f1345u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public OverScroller f1346v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ViewPropertyAnimator f1347w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final C0138c f1348x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final RunnableC0140d f1349y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final RunnableC0140d f1350z;

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1327b = 0;
        this.f1338n = new Rect();
        this.f1339o = new Rect();
        this.f1340p = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        z0 z0Var = z0.f90b;
        this.f1341q = z0Var;
        this.f1342r = z0Var;
        this.f1343s = z0Var;
        this.f1344t = z0Var;
        this.f1348x = new C0138c(this);
        this.f1349y = new RunnableC0140d(this, 0);
        this.f1350z = new RunnableC0140d(this, 1);
        i(context);
        this.f1325A = new C0023x();
    }

    public static boolean g(View view, Rect rect, boolean z2) {
        boolean z3;
        C0144f c0144f = (C0144f) view.getLayoutParams();
        int i2 = ((ViewGroup.MarginLayoutParams) c0144f).leftMargin;
        int i3 = rect.left;
        if (i2 != i3) {
            ((ViewGroup.MarginLayoutParams) c0144f).leftMargin = i3;
            z3 = true;
        } else {
            z3 = false;
        }
        int i4 = ((ViewGroup.MarginLayoutParams) c0144f).topMargin;
        int i5 = rect.top;
        if (i4 != i5) {
            ((ViewGroup.MarginLayoutParams) c0144f).topMargin = i5;
            z3 = true;
        }
        int i6 = ((ViewGroup.MarginLayoutParams) c0144f).rightMargin;
        int i7 = rect.right;
        if (i6 != i7) {
            ((ViewGroup.MarginLayoutParams) c0144f).rightMargin = i7;
            z3 = true;
        }
        if (z2) {
            int i8 = ((ViewGroup.MarginLayoutParams) c0144f).bottomMargin;
            int i9 = rect.bottom;
            if (i8 != i9) {
                ((ViewGroup.MarginLayoutParams) c0144f).bottomMargin = i9;
                return true;
            }
        }
        return z3;
    }

    @Override // A.InterfaceC0021v
    public final void b(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    @Override // A.InterfaceC0021v
    public final void c(ViewGroup viewGroup, int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            onNestedScroll(viewGroup, i2, i3, i4, i5);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0144f;
    }

    @Override // A.InterfaceC0021v
    public final void d(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.f1331f == null || this.g) {
            return;
        }
        if (this.f1329d.getVisibility() == 0) {
            translationY = (int) (this.f1329d.getTranslationY() + this.f1329d.getBottom() + 0.5f);
        } else {
            translationY = 0;
        }
        this.f1331f.setBounds(0, translationY, getWidth(), this.f1331f.getIntrinsicHeight() + translationY);
        this.f1331f.draw(canvas);
    }

    @Override // A.InterfaceC0022w
    public final void e(ViewGroup viewGroup, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        c(viewGroup, i2, i3, i4, i5, i6);
    }

    @Override // A.InterfaceC0021v
    public final boolean f(View view, View view2, int i2, int i3) {
        return i3 == 0 && onStartNestedScroll(view, view2, i2);
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0144f(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0144f(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f1329d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        C0023x c0023x = this.f1325A;
        return c0023x.f87b | c0023x.f86a;
    }

    public CharSequence getTitle() {
        k();
        return ((r1) this.f1330e).f3276a.getTitle();
    }

    public final void h() {
        removeCallbacks(this.f1349y);
        removeCallbacks(this.f1350z);
        ViewPropertyAnimator viewPropertyAnimator = this.f1347w;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void i(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1324B);
        this.f1326a = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.f1331f = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.g = context.getApplicationInfo().targetSdkVersion < 19;
        this.f1346v = new OverScroller(context);
    }

    public final void j(int i2) {
        k();
        if (i2 == 2) {
            ((r1) this.f1330e).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else if (i2 == 5) {
            ((r1) this.f1330e).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else {
            if (i2 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public final void k() {
        InterfaceC0165p0 wrapper;
        if (this.f1328c == null) {
            this.f1328c = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f1329d = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(R.id.action_bar);
            if (callbackFindViewById instanceof InterfaceC0165p0) {
                wrapper = (InterfaceC0165p0) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.f1330e = wrapper;
        }
    }

    public final void l(n nVar, z zVar) {
        k();
        r1 r1Var = (r1) this.f1330e;
        C0154k c0154k = r1Var.f3287m;
        Toolbar toolbar = r1Var.f3276a;
        if (c0154k == null) {
            r1Var.f3287m = new C0154k(toolbar.getContext());
        }
        C0154k c0154k2 = r1Var.f3287m;
        c0154k2.f3210e = zVar;
        if (nVar == null && toolbar.f1436a == null) {
            return;
        }
        toolbar.f();
        n nVar2 = toolbar.f1436a.f1352p;
        if (nVar2 == nVar) {
            return;
        }
        if (nVar2 != null) {
            nVar2.r(toolbar.f1428L);
            nVar2.r(toolbar.f1429M);
        }
        if (toolbar.f1429M == null) {
            toolbar.f1429M = new m1(toolbar);
        }
        c0154k2.f3221q = true;
        if (nVar != null) {
            nVar.b(c0154k2, toolbar.f1444j);
            nVar.b(toolbar.f1429M, toolbar.f1444j);
        } else {
            c0154k2.g(toolbar.f1444j, null);
            toolbar.f1429M.g(toolbar.f1444j, null);
            c0154k2.c();
            toolbar.f1429M.c();
        }
        toolbar.f1436a.setPopupTheme(toolbar.f1445k);
        toolbar.f1436a.setPresenter(c0154k2);
        toolbar.f1428L = c0154k2;
        toolbar.w();
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        k();
        z0 z0VarC = z0.c(windowInsets, this);
        x0 x0Var = z0VarC.f91a;
        boolean zG = g(this.f1329d, new Rect(x0Var.j().f4103a, x0Var.j().f4104b, x0Var.j().f4105c, x0Var.j().f4106d), false);
        WeakHashMap weakHashMap = X.f14a;
        Rect rect = this.f1338n;
        L.b(this, z0VarC, rect);
        z0 z0VarL = x0Var.l(rect.left, rect.top, rect.right, rect.bottom);
        this.f1341q = z0VarL;
        boolean z2 = true;
        if (!this.f1342r.equals(z0VarL)) {
            this.f1342r = this.f1341q;
            zG = true;
        }
        Rect rect2 = this.f1339o;
        if (rect2.equals(rect)) {
            z2 = zG;
        } else {
            rect2.set(rect);
        }
        if (z2) {
            requestLayout();
        }
        return x0Var.a().f91a.c().f91a.b().b();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        i(getContext());
        WeakHashMap weakHashMap = X.f14a;
        J.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C0144f c0144f = (C0144f) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = ((ViewGroup.MarginLayoutParams) c0144f).leftMargin + paddingLeft;
                int i8 = ((ViewGroup.MarginLayoutParams) c0144f).topMargin + paddingTop;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        int measuredHeight;
        q0 o0Var;
        k();
        measureChildWithMargins(this.f1329d, i2, 0, i3, 0);
        C0144f c0144f = (C0144f) this.f1329d.getLayoutParams();
        int iMax = Math.max(0, this.f1329d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0144f).leftMargin + ((ViewGroup.MarginLayoutParams) c0144f).rightMargin);
        int iMax2 = Math.max(0, this.f1329d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0144f).topMargin + ((ViewGroup.MarginLayoutParams) c0144f).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f1329d.getMeasuredState());
        WeakHashMap weakHashMap = X.f14a;
        boolean z2 = (G.g(this) & 256) != 0;
        if (z2) {
            measuredHeight = this.f1326a;
            if (this.f1333i && this.f1329d.getTabContainer() != null) {
                measuredHeight += this.f1326a;
            }
        } else {
            measuredHeight = this.f1329d.getVisibility() != 8 ? this.f1329d.getMeasuredHeight() : 0;
        }
        Rect rect = this.f1338n;
        Rect rect2 = this.f1340p;
        rect2.set(rect);
        z0 z0Var = this.f1341q;
        this.f1343s = z0Var;
        if (this.f1332h || z2) {
            p033t.c cVarA = p033t.c.a(z0Var.f91a.j().f4103a, this.f1343s.f91a.j().f4104b + measuredHeight, this.f1343s.f91a.j().f4105c, this.f1343s.f91a.j().f4106d);
            z0 z0Var2 = this.f1343s;
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 30) {
                o0Var = new p0(z0Var2);
            } else {
                o0Var = i4 >= 29 ? new o0(z0Var2) : new m0(z0Var2);
            }
            o0Var.d(cVarA);
            this.f1343s = o0Var.b();
        } else {
            rect2.top += measuredHeight;
            rect2.bottom = rect2.bottom;
            this.f1343s = z0Var.f91a.l(0, measuredHeight, 0, 0);
        }
        g(this.f1328c, rect2, true);
        if (!this.f1344t.equals(this.f1343s)) {
            z0 z0Var3 = this.f1343s;
            this.f1344t = z0Var3;
            ContentFrameLayout contentFrameLayout = this.f1328c;
            WindowInsets windowInsetsB = z0Var3.b();
            if (windowInsetsB != null) {
                WindowInsets windowInsetsA = J.a(contentFrameLayout, windowInsetsB);
                if (!windowInsetsA.equals(windowInsetsB)) {
                    z0.c(windowInsetsA, contentFrameLayout);
                }
            }
        }
        measureChildWithMargins(this.f1328c, i2, 0, i3, 0);
        C0144f c0144f2 = (C0144f) this.f1328c.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f1328c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0144f2).leftMargin + ((ViewGroup.MarginLayoutParams) c0144f2).rightMargin);
        int iMax4 = Math.max(iMax2, this.f1328c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0144f2).topMargin + ((ViewGroup.MarginLayoutParams) c0144f2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f1328c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax3, getSuggestedMinimumWidth()), i2, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax4, getSuggestedMinimumHeight()), i3, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        if (!this.f1334j || !z2) {
            return false;
        }
        this.f1346v.fling(0, 0, 0, (int) f3, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.f1346v.getFinalY() > this.f1329d.getHeight()) {
            h();
            this.f1350z.run();
        } else {
            h();
            this.f1349y.run();
        }
        this.f1335k = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        int i6 = this.f1336l + i3;
        this.f1336l = i6;
        setActionBarHideOffset(i6);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i2) {
        P p2;
        l lVar;
        this.f1325A.f86a = i2;
        this.f1336l = getActionBarHideOffset();
        h();
        InterfaceC0142e interfaceC0142e = this.f1345u;
        if (interfaceC0142e == null || (lVar = (p2 = (P) interfaceC0142e).f2455s) == null) {
            return;
        }
        lVar.a();
        p2.f2455s = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.f1329d.getVisibility() != 0) {
            return false;
        }
        return this.f1334j;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.f1334j || this.f1335k) {
            return;
        }
        if (this.f1336l <= this.f1329d.getHeight()) {
            h();
            postDelayed(this.f1349y, 600L);
        } else {
            h();
            postDelayed(this.f1350z, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i2) {
        super.onWindowSystemUiVisibilityChanged(i2);
        k();
        int i3 = this.f1337m ^ i2;
        this.f1337m = i2;
        boolean z2 = (i2 & 4) == 0;
        boolean z3 = (i2 & 256) != 0;
        InterfaceC0142e interfaceC0142e = this.f1345u;
        if (interfaceC0142e != null) {
            P p2 = (P) interfaceC0142e;
            p2.f2451o = !z3;
            if (z2 || !z3) {
                if (p2.f2452p) {
                    p2.f2452p = false;
                    p2.s(true);
                }
            } else if (!p2.f2452p) {
                p2.f2452p = true;
                p2.s(true);
            }
        }
        if ((i3 & 256) == 0 || this.f1345u == null) {
            return;
        }
        WeakHashMap weakHashMap = X.f14a;
        J.c(this);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.f1327b = i2;
        InterfaceC0142e interfaceC0142e = this.f1345u;
        if (interfaceC0142e != null) {
            ((P) interfaceC0142e).f2450n = i2;
        }
    }

    public void setActionBarHideOffset(int i2) {
        h();
        this.f1329d.setTranslationY(-Math.max(0, Math.min(i2, this.f1329d.getHeight())));
    }

    public void setActionBarVisibilityCallback(InterfaceC0142e interfaceC0142e) {
        this.f1345u = interfaceC0142e;
        if (getWindowToken() != null) {
            ((P) this.f1345u).f2450n = this.f1327b;
            int i2 = this.f1337m;
            if (i2 != 0) {
                onWindowSystemUiVisibilityChanged(i2);
                WeakHashMap weakHashMap = X.f14a;
                J.c(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z2) {
        this.f1333i = z2;
    }

    public void setHideOnContentScrollEnabled(boolean z2) {
        if (z2 != this.f1334j) {
            this.f1334j = z2;
            if (z2) {
                return;
            }
            h();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i2) {
        k();
        r1 r1Var = (r1) this.f1330e;
        r1Var.f3279d = i2 != 0 ? f1.l.A(r1Var.f3276a.getContext(), i2) : null;
        r1Var.c();
    }

    public void setLogo(int i2) {
        k();
        r1 r1Var = (r1) this.f1330e;
        r1Var.f3280e = i2 != 0 ? f1.l.A(r1Var.f3276a.getContext(), i2) : null;
        r1Var.c();
    }

    public void setOverlayMode(boolean z2) {
        this.f1332h = z2;
        this.g = z2 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z2) {
    }

    public void setUiOptions(int i2) {
    }

    @Override // p015j.InterfaceC0163o0
    public void setWindowCallback(Window.Callback callback) {
        k();
        ((r1) this.f1330e).f3285k = callback;
    }

    @Override // p015j.InterfaceC0163o0
    public void setWindowTitle(CharSequence charSequence) {
        k();
        r1 r1Var = (r1) this.f1330e;
        if (r1Var.g) {
            return;
        }
        r1Var.f3282h = charSequence;
        if ((r1Var.f3277b & 8) != 0) {
            Toolbar toolbar = r1Var.f3276a;
            toolbar.setTitle(charSequence);
            if (r1Var.g) {
                X.i(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0144f(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        k();
        r1 r1Var = (r1) this.f1330e;
        r1Var.f3279d = drawable;
        r1Var.c();
    }

    @Override // A.InterfaceC0021v
    public final void a(int i2, int i3, int[] iArr, int i4) {
    }
}
