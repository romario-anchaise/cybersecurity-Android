// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.appcompat.widget;

import A.AbstractC0014n;
import A.G;
import A.H;
import A.X;
import A.r;
import C.h;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import com.o2s2m.gae1fc3b2uc0u.R;
import f1.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import p009f.I;
import p009f.J;
import p009f.ViewOnClickListenerC0113c;
import p011h.j;
import p013i.n;
import p013i.p;
import p015j.C0143e0;
import p015j.C0154k;
import p015j.C0179x;
import p015j.C0181y;
import p015j.InterfaceC0165p0;
import p015j.S0;
import p015j.j1;
import p015j.k1;
import p015j.l1;
import p015j.m1;
import p015j.n1;
import p015j.o1;
import p015j.p1;
import p015j.r1;
import p015j.y1;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public ColorStateList f1417A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public boolean f1418B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f1419C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final ArrayList f1420D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final ArrayList f1421E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final int[] f1422F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final r f1423G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public ArrayList f1424H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public o1 f1425I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final k1 f1426J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public r1 f1427K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public C0154k f1428L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public m1 f1429M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public J f1430N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public I f1431O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public boolean f1432P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public OnBackInvokedCallback f1433Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public OnBackInvokedDispatcher f1434R;
    public boolean S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public final D.b f1435T;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActionMenuView f1436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0143e0 f1437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C0143e0 f1438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0179x f1439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C0181y f1440e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Drawable f1441f;
    public final CharSequence g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public C0179x f1442h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f1443i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Context f1444j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1445k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1446l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1447m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f1448n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f1449o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1450p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1451q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1452r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1453s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public S0 f1454t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1455u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1456v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f1457w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CharSequence f1458x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public CharSequence f1459y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ColorStateList f1460z;

    public Toolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.toolbarStyle);
        this.f1457w = 8388627;
        this.f1420D = new ArrayList();
        this.f1421E = new ArrayList();
        this.f1422F = new int[2];
        this.f1423G = new r(new j1(this, 1));
        this.f1424H = new ArrayList();
        this.f1426J = new k1(this);
        this.f1435T = new D.b(4, this);
        Context context2 = getContext();
        int[] iArr = p007e.a.f2248x;
        h hVarP = h.p(context2, attributeSet, iArr, R.attr.toolbarStyle);
        X.g(this, context, iArr, attributeSet, (TypedArray) hVarP.f112b, R.attr.toolbarStyle);
        TypedArray typedArray = (TypedArray) hVarP.f112b;
        this.f1446l = typedArray.getResourceId(28, 0);
        this.f1447m = typedArray.getResourceId(19, 0);
        this.f1457w = typedArray.getInteger(0, 8388627);
        this.f1448n = typedArray.getInteger(2, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(22, 0);
        dimensionPixelOffset = typedArray.hasValue(27) ? typedArray.getDimensionPixelOffset(27, dimensionPixelOffset) : dimensionPixelOffset;
        this.f1453s = dimensionPixelOffset;
        this.f1452r = dimensionPixelOffset;
        this.f1451q = dimensionPixelOffset;
        this.f1450p = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f1450p = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f1451q = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.f1452r = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.f1453s = dimensionPixelOffset5;
        }
        this.f1449o = typedArray.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(8, 0);
        d();
        S0 s1 = this.f1454t;
        s1.f3114h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            s1.f3112e = dimensionPixelSize;
            s1.f3108a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            s1.f3113f = dimensionPixelSize2;
            s1.f3109b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            s1.a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.f1455u = typedArray.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.f1456v = typedArray.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.f1441f = hVarP.l(4);
        this.g = typedArray.getText(3);
        CharSequence text = typedArray.getText(21);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(18);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f1444j = getContext();
        setPopupTheme(typedArray.getResourceId(17, 0));
        Drawable drawableL = hVarP.l(16);
        if (drawableL != null) {
            setNavigationIcon(drawableL);
        }
        CharSequence text3 = typedArray.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawableL2 = hVarP.l(11);
        if (drawableL2 != null) {
            setLogo(drawableL2);
        }
        CharSequence text4 = typedArray.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(29)) {
            setTitleTextColor(hVarP.k(29));
        }
        if (typedArray.hasValue(20)) {
            setSubtitleTextColor(hVarP.k(20));
        }
        if (typedArray.hasValue(14)) {
            getMenuInflater().inflate(typedArray.getResourceId(14, 0), getMenu());
        }
        hVarP.r();
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i2 = 0; i2 < menu.size(); i2++) {
            arrayList.add(menu.getItem(i2));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new j(getContext());
    }

    public static n1 h() {
        n1 n1Var = new n1(-2, -2);
        n1Var.f3254b = 0;
        n1Var.f3253a = 8388627;
        return n1Var;
    }

    public static n1 i(ViewGroup.LayoutParams layoutParams) {
        boolean z2 = layoutParams instanceof n1;
        if (z2) {
            n1 n1Var = (n1) layoutParams;
            n1 n1Var2 = new n1(n1Var);
            n1Var2.f3254b = 0;
            n1Var2.f3254b = n1Var.f3254b;
            return n1Var2;
        }
        if (z2) {
            n1 n1Var3 = new n1((n1) layoutParams);
            n1Var3.f3254b = 0;
            return n1Var3;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            n1 n1Var4 = new n1(layoutParams);
            n1Var4.f3254b = 0;
            return n1Var4;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        n1 n1Var5 = new n1(marginLayoutParams);
        n1Var5.f3254b = 0;
        ((ViewGroup.MarginLayoutParams) n1Var5).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) n1Var5).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) n1Var5).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) n1Var5).bottomMargin = marginLayoutParams.bottomMargin;
        return n1Var5;
    }

    public static int l(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return AbstractC0014n.b(marginLayoutParams) + AbstractC0014n.c(marginLayoutParams);
    }

    public static int m(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(ArrayList arrayList, int i2) {
        WeakHashMap weakHashMap = X.f14a;
        boolean z2 = H.d(this) == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, H.d(this));
        arrayList.clear();
        if (!z2) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                n1 n1Var = (n1) childAt.getLayoutParams();
                if (n1Var.f3254b == 0 && u(childAt) && j(n1Var.f3253a) == absoluteGravity) {
                    arrayList.add(childAt);
                }
            }
            return;
        }
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            n1 n1Var2 = (n1) childAt2.getLayoutParams();
            if (n1Var2.f3254b == 0 && u(childAt2) && j(n1Var2.f3253a) == absoluteGravity) {
                arrayList.add(childAt2);
            }
        }
    }

    public final void b(View view, boolean z2) {
        n1 n1VarI;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            n1VarI = h();
        } else {
            n1VarI = !checkLayoutParams(layoutParams) ? i(layoutParams) : (n1) layoutParams;
        }
        n1VarI.f3254b = 1;
        if (!z2 || this.f1443i == null) {
            addView(view, n1VarI);
        } else {
            view.setLayoutParams(n1VarI);
            this.f1421E.add(view);
        }
    }

    public final void c() {
        if (this.f1442h == null) {
            C0179x c0179x = new C0179x(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.f1442h = c0179x;
            c0179x.setImageDrawable(this.f1441f);
            this.f1442h.setContentDescription(this.g);
            n1 n1VarH = h();
            n1VarH.f3253a = (this.f1448n & 112) | 8388611;
            n1VarH.f3254b = 2;
            this.f1442h.setLayoutParams(n1VarH);
            this.f1442h.setOnClickListener(new ViewOnClickListenerC0113c(2, this));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof n1);
    }

    public final void d() {
        if (this.f1454t == null) {
            S0 s1 = new S0();
            s1.f3108a = 0;
            s1.f3109b = 0;
            s1.f3110c = Integer.MIN_VALUE;
            s1.f3111d = Integer.MIN_VALUE;
            s1.f3112e = 0;
            s1.f3113f = 0;
            s1.g = false;
            s1.f3114h = false;
            this.f1454t = s1;
        }
    }

    public final void e() {
        f();
        ActionMenuView actionMenuView = this.f1436a;
        if (actionMenuView.f1352p == null) {
            n nVar = (n) actionMenuView.getMenu();
            if (this.f1429M == null) {
                this.f1429M = new m1(this);
            }
            this.f1436a.setExpandedActionViewsExclusive(true);
            nVar.b(this.f1429M, this.f1444j);
            w();
        }
    }

    public final void f() {
        if (this.f1436a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f1436a = actionMenuView;
            actionMenuView.setPopupTheme(this.f1445k);
            this.f1436a.setOnMenuItemClickListener(this.f1426J);
            ActionMenuView actionMenuView2 = this.f1436a;
            J j2 = this.f1430N;
            k1 k1Var = new k1(this);
            actionMenuView2.f1357u = j2;
            actionMenuView2.f1358v = k1Var;
            n1 n1VarH = h();
            n1VarH.f3253a = (this.f1448n & 112) | 8388613;
            this.f1436a.setLayoutParams(n1VarH);
            b(this.f1436a, false);
        }
    }

    public final void g() {
        if (this.f1439d == null) {
            this.f1439d = new C0179x(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            n1 n1VarH = h();
            n1VarH.f3253a = (this.f1448n & 112) | 8388611;
            this.f1439d.setLayoutParams(n1VarH);
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return h();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return i(layoutParams);
    }

    public CharSequence getCollapseContentDescription() {
        C0179x c0179x = this.f1442h;
        if (c0179x != null) {
            return c0179x.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        C0179x c0179x = this.f1442h;
        if (c0179x != null) {
            return c0179x.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        S0 s1 = this.f1454t;
        if (s1 != null) {
            return s1.g ? s1.f3108a : s1.f3109b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i2 = this.f1456v;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        S0 s1 = this.f1454t;
        if (s1 != null) {
            return s1.f3108a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        S0 s1 = this.f1454t;
        if (s1 != null) {
            return s1.f3109b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        S0 s1 = this.f1454t;
        if (s1 != null) {
            return s1.g ? s1.f3109b : s1.f3108a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i2 = this.f1455u;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        n nVar;
        ActionMenuView actionMenuView = this.f1436a;
        return (actionMenuView == null || (nVar = actionMenuView.f1352p) == null || !nVar.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.f1456v, 0));
    }

    public int getCurrentContentInsetLeft() {
        WeakHashMap weakHashMap = X.f14a;
        return H.d(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        WeakHashMap weakHashMap = X.f14a;
        return H.d(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f1455u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        C0181y c0181y = this.f1440e;
        if (c0181y != null) {
            return c0181y.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        C0181y c0181y = this.f1440e;
        if (c0181y != null) {
            return c0181y.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        e();
        return this.f1436a.getMenu();
    }

    public View getNavButtonView() {
        return this.f1439d;
    }

    public CharSequence getNavigationContentDescription() {
        C0179x c0179x = this.f1439d;
        if (c0179x != null) {
            return c0179x.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        C0179x c0179x = this.f1439d;
        if (c0179x != null) {
            return c0179x.getDrawable();
        }
        return null;
    }

    public C0154k getOuterActionMenuPresenter() {
        return this.f1428L;
    }

    public Drawable getOverflowIcon() {
        e();
        return this.f1436a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f1444j;
    }

    public int getPopupTheme() {
        return this.f1445k;
    }

    public CharSequence getSubtitle() {
        return this.f1459y;
    }

    public final TextView getSubtitleTextView() {
        return this.f1438c;
    }

    public CharSequence getTitle() {
        return this.f1458x;
    }

    public int getTitleMarginBottom() {
        return this.f1453s;
    }

    public int getTitleMarginEnd() {
        return this.f1451q;
    }

    public int getTitleMarginStart() {
        return this.f1450p;
    }

    public int getTitleMarginTop() {
        return this.f1452r;
    }

    public final TextView getTitleTextView() {
        return this.f1437b;
    }

    public InterfaceC0165p0 getWrapper() {
        if (this.f1427K == null) {
            this.f1427K = new r1(this, true);
        }
        return this.f1427K;
    }

    public final int j(int i2) {
        WeakHashMap weakHashMap = X.f14a;
        int iD = H.d(this);
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, iD) & 7;
        if (absoluteGravity == 1 || absoluteGravity == 3 || absoluteGravity == 5) {
            return absoluteGravity;
        }
        return iD == 1 ? 5 : 3;
    }

    public final int k(View view, int i2) {
        n1 n1Var = (n1) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        int i4 = n1Var.f3253a & 112;
        if (i4 != 16 && i4 != 48 && i4 != 80) {
            i4 = this.f1457w & 112;
        }
        if (i4 == 48) {
            return getPaddingTop() - i3;
        }
        if (i4 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) n1Var).bottomMargin) - i3;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i5 = ((ViewGroup.MarginLayoutParams) n1Var).topMargin;
        if (iMax < i5) {
            iMax = i5;
        } else {
            int i6 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i7 = ((ViewGroup.MarginLayoutParams) n1Var).bottomMargin;
            if (i6 < i7) {
                iMax = Math.max(0, iMax - (i7 - i6));
            }
        }
        return paddingTop + iMax;
    }

    public final void n() {
        Iterator it = this.f1424H.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        getMenuInflater();
        Iterator it2 = this.f1423G.f65b.iterator();
        if (it2.hasNext()) {
            it2.next().getClass();
            throw new ClassCastException();
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.f1424H = currentMenuItems2;
    }

    public final boolean o(View view) {
        return view.getParent() == this || this.f1421E.contains(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        w();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1435T);
        w();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1419C = false;
        }
        if (!this.f1419C) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f1419C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1419C = false;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0262  */
    /* JADX WARN: Code duplicated, block: B:101:0x0284  */
    /* JADX WARN: Code duplicated, block: B:103:0x0287  */
    /* JADX WARN: Code duplicated, block: B:104:0x028c  */
    /* JADX WARN: Code duplicated, block: B:107:0x029b A[LOOP:0: B:106:0x0299->B:107:0x029b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:110:0x02b8 A[LOOP:1: B:109:0x02b6->B:110:0x02b8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:113:0x02d6 A[LOOP:2: B:112:0x02d4->B:113:0x02d6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:117:0x0317 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:118:0x0319  */
    /* JADX WARN: Code duplicated, block: B:119:0x031d  */
    /* JADX WARN: Code duplicated, block: B:122:0x0325 A[LOOP:3: B:121:0x0323->B:122:0x0325, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:19:0x0062 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x0064  */
    /* JADX WARN: Code duplicated, block: B:21:0x006b  */
    /* JADX WARN: Code duplicated, block: B:24:0x0079 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x007b  */
    /* JADX WARN: Code duplicated, block: B:26:0x0082  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:31:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:34:0x00cd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:40:0x0101  */
    /* JADX WARN: Code duplicated, block: B:42:0x0106  */
    /* JADX WARN: Code duplicated, block: B:43:0x011e  */
    /* JADX WARN: Code duplicated, block: B:48:0x012b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x012d  */
    /* JADX WARN: Code duplicated, block: B:50:0x0130  */
    /* JADX WARN: Code duplicated, block: B:52:0x0134  */
    /* JADX WARN: Code duplicated, block: B:53:0x0137  */
    /* JADX WARN: Code duplicated, block: B:56:0x0147  */
    /* JADX WARN: Code duplicated, block: B:58:0x014f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:65:0x016a  */
    /* JADX WARN: Code duplicated, block: B:67:0x016e  */
    /* JADX WARN: Code duplicated, block: B:69:0x017d  */
    /* JADX WARN: Code duplicated, block: B:70:0x017f  */
    /* JADX WARN: Code duplicated, block: B:72:0x018a  */
    /* JADX WARN: Code duplicated, block: B:74:0x0196  */
    /* JADX WARN: Code duplicated, block: B:75:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:77:0x01b1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:78:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:80:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:83:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:84:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:86:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:87:0x0216  */
    /* JADX WARN: Code duplicated, block: B:89:0x0219  */
    /* JADX WARN: Code duplicated, block: B:91:0x0222 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0224  */
    /* JADX WARN: Code duplicated, block: B:94:0x0228  */
    /* JADX WARN: Code duplicated, block: B:97:0x023c  */
    /* JADX WARN: Code duplicated, block: B:98:0x025f  */
    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int iQ;
        int iR;
        int iMax;
        int iMin;
        boolean zU;
        boolean zU2;
        int measuredHeight;
        C0143e0 c0143e0;
        C0143e0 c0143e1;
        n1 n1Var;
        n1 n1Var2;
        boolean z3;
        int i6;
        int i7;
        int paddingTop;
        int i8;
        int iMax2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int iMax3;
        int i14;
        int i15;
        int i16;
        int i17;
        ArrayList arrayList;
        int size;
        int iQ2;
        int i18;
        int i19;
        int size2;
        int i20;
        int size3;
        int i21;
        int i22;
        int i23;
        int measuredWidth;
        int i24;
        int i25;
        int size4;
        int i26;
        WeakHashMap weakHashMap = X.f14a;
        boolean z4 = H.d(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i27 = width - paddingRight;
        int[] iArr = this.f1422F;
        iArr[1] = 0;
        iArr[0] = 0;
        int iD = G.d(this);
        int iMin2 = iD >= 0 ? Math.min(iD, i5 - i3) : 0;
        if (u(this.f1439d)) {
            if (z4) {
                iR = r(this.f1439d, i27, iMin2, iArr);
                iQ = paddingLeft;
            } else {
                iQ = q(this.f1439d, paddingLeft, iMin2, iArr);
            }
            if (u(this.f1442h)) {
                if (z4) {
                    iR = r(this.f1442h, iR, iMin2, iArr);
                } else {
                    iQ = q(this.f1442h, iQ, iMin2, iArr);
                }
            }
            if (u(this.f1436a)) {
                if (z4) {
                    iQ = q(this.f1436a, iQ, iMin2, iArr);
                } else {
                    iR = r(this.f1436a, iR, iMin2, iArr);
                }
            }
            int currentContentInsetLeft = getCurrentContentInsetLeft();
            int currentContentInsetRight = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft - iQ);
            iArr[1] = Math.max(0, currentContentInsetRight - (i27 - iR));
            iMax = Math.max(iQ, currentContentInsetLeft);
            iMin = Math.min(iR, i27 - currentContentInsetRight);
            if (u(this.f1443i)) {
                if (z4) {
                    iMin = r(this.f1443i, iMin, iMin2, iArr);
                } else {
                    iMax = q(this.f1443i, iMax, iMin2, iArr);
                }
            }
            if (u(this.f1440e)) {
                if (z4) {
                    iMin = r(this.f1440e, iMin, iMin2, iArr);
                } else {
                    iMax = q(this.f1440e, iMax, iMin2, iArr);
                }
            }
            zU = u(this.f1437b);
            zU2 = u(this.f1438c);
            if (zU) {
                n1 n1Var3 = (n1) this.f1437b.getLayoutParams();
                measuredHeight = ((ViewGroup.MarginLayoutParams) n1Var3).bottomMargin + this.f1437b.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) n1Var3).topMargin;
            } else {
                measuredHeight = 0;
            }
            if (zU2) {
                n1 n1Var4 = (n1) this.f1438c.getLayoutParams();
                measuredHeight += this.f1438c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) n1Var4).topMargin + ((ViewGroup.MarginLayoutParams) n1Var4).bottomMargin;
            }
            if (!zU || zU2) {
                if (zU) {
                    c0143e0 = this.f1437b;
                } else {
                    c0143e0 = this.f1438c;
                }
                if (zU2) {
                    c0143e1 = this.f1438c;
                } else {
                    c0143e1 = this.f1437b;
                }
                n1Var = (n1) c0143e0.getLayoutParams();
                n1Var2 = (n1) c0143e1.getLayoutParams();
                z3 = (!zU && this.f1437b.getMeasuredWidth() > 0) || (zU2 && this.f1438c.getMeasuredWidth() > 0);
                i6 = this.f1457w & 112;
                i7 = iMin2;
                if (i6 == 48) {
                    paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) n1Var).topMargin + this.f1452r;
                } else if (i6 != 80) {
                    iMax3 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                    i14 = ((ViewGroup.MarginLayoutParams) n1Var).topMargin + this.f1452r;
                    if (iMax3 < i14) {
                        iMax3 = i14;
                    } else {
                        i15 = (((height - paddingBottom) - measuredHeight) - iMax3) - paddingTop2;
                        i16 = ((ViewGroup.MarginLayoutParams) n1Var).bottomMargin;
                        i17 = this.f1453s;
                        if (i15 < i16 + i17) {
                            iMax3 = Math.max(0, iMax3 - ((((ViewGroup.MarginLayoutParams) n1Var2).bottomMargin + i17) - i15));
                        }
                    }
                    paddingTop = paddingTop2 + iMax3;
                } else {
                    paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) n1Var2).bottomMargin) - this.f1453s) - measuredHeight;
                }
                if (z4) {
                    if (z3) {
                        i11 = this.f1450p;
                    } else {
                        i11 = 0;
                    }
                    int i28 = i11 - iArr[1];
                    iMin -= Math.max(0, i28);
                    iArr[1] = Math.max(0, -i28);
                    if (zU) {
                        n1 n1Var5 = (n1) this.f1437b.getLayoutParams();
                        int measuredWidth2 = iMin - this.f1437b.getMeasuredWidth();
                        int measuredHeight2 = this.f1437b.getMeasuredHeight() + paddingTop;
                        this.f1437b.layout(measuredWidth2, paddingTop, iMin, measuredHeight2);
                        i12 = measuredWidth2 - this.f1451q;
                        paddingTop = measuredHeight2 + ((ViewGroup.MarginLayoutParams) n1Var5).bottomMargin;
                    } else {
                        i12 = iMin;
                    }
                    if (zU2) {
                        int i29 = paddingTop + ((ViewGroup.MarginLayoutParams) ((n1) this.f1438c.getLayoutParams())).topMargin;
                        this.f1438c.layout(iMin - this.f1438c.getMeasuredWidth(), i29, iMin, this.f1438c.getMeasuredHeight() + i29);
                        i13 = iMin - this.f1451q;
                    } else {
                        i13 = iMin;
                    }
                    if (z3) {
                        iMin = Math.min(i12, i13);
                    }
                    iMax = iMax;
                } else {
                    if (z3) {
                        i8 = this.f1450p;
                    } else {
                        i8 = 0;
                    }
                    int i30 = i8 - iArr[0];
                    iMax2 = Math.max(0, i30) + iMax;
                    iArr[0] = Math.max(0, -i30);
                    if (zU) {
                        n1 n1Var6 = (n1) this.f1437b.getLayoutParams();
                        int measuredWidth3 = this.f1437b.getMeasuredWidth() + iMax2;
                        int measuredHeight3 = this.f1437b.getMeasuredHeight() + paddingTop;
                        this.f1437b.layout(iMax2, paddingTop, measuredWidth3, measuredHeight3);
                        i9 = measuredWidth3 + this.f1451q;
                        paddingTop = measuredHeight3 + ((ViewGroup.MarginLayoutParams) n1Var6).bottomMargin;
                    } else {
                        i9 = iMax2;
                    }
                    if (zU2) {
                        int i31 = paddingTop + ((ViewGroup.MarginLayoutParams) ((n1) this.f1438c.getLayoutParams())).topMargin;
                        int measuredWidth4 = this.f1438c.getMeasuredWidth() + iMax2;
                        this.f1438c.layout(iMax2, i31, measuredWidth4, this.f1438c.getMeasuredHeight() + i31);
                        i10 = measuredWidth4 + this.f1451q;
                    } else {
                        i10 = iMax2;
                    }
                    if (z3) {
                        iMax = Math.max(i9, i10);
                    } else {
                        iMax = iMax2;
                    }
                }
            } else {
                paddingLeft = paddingLeft;
                i7 = iMin2;
            }
            arrayList = this.f1420D;
            a(arrayList, 3);
            size = arrayList.size();
            iQ2 = iMax;
            for (i18 = 0; i18 < size; i18++) {
                iQ2 = q((View) arrayList.get(i18), iQ2, i7, iArr);
            }
            i19 = i7;
            a(arrayList, 5);
            size2 = arrayList.size();
            for (i20 = 0; i20 < size2; i20++) {
                iMin = r((View) arrayList.get(i20), iMin, i19, iArr);
            }
            a(arrayList, 1);
            int i32 = iArr[0];
            int i33 = iArr[1];
            size3 = arrayList.size();
            i21 = i33;
            i22 = i32;
            i23 = 0;
            measuredWidth = 0;
            while (i23 < size3) {
                View view = (View) arrayList.get(i23);
                n1 n1Var7 = (n1) view.getLayoutParams();
                int i34 = ((ViewGroup.MarginLayoutParams) n1Var7).leftMargin - i22;
                int i35 = ((ViewGroup.MarginLayoutParams) n1Var7).rightMargin - i21;
                int iMax4 = Math.max(0, i34);
                int iMax5 = Math.max(0, i35);
                int iMax6 = Math.max(0, -i34);
                int iMax7 = Math.max(0, -i35);
                measuredWidth += view.getMeasuredWidth() + iMax4 + iMax5;
                i23++;
                i21 = iMax7;
                i22 = iMax6;
            }
            i24 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
            i25 = measuredWidth + i24;
            if (i24 >= iQ2) {
                if (i25 > iMin) {
                    iQ2 = i24 - (i25 - iMin);
                } else {
                    iQ2 = i24;
                }
            }
            size4 = arrayList.size();
            for (i26 = 0; i26 < size4; i26++) {
                iQ2 = q((View) arrayList.get(i26), iQ2, i19, iArr);
            }
            arrayList.clear();
        }
        iQ = paddingLeft;
        iR = i27;
        if (u(this.f1442h)) {
            if (z4) {
                iR = r(this.f1442h, iR, iMin2, iArr);
            } else {
                iQ = q(this.f1442h, iQ, iMin2, iArr);
            }
        }
        if (u(this.f1436a)) {
            if (z4) {
                iQ = q(this.f1436a, iQ, iMin2, iArr);
            } else {
                iR = r(this.f1436a, iR, iMin2, iArr);
            }
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - iQ);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i27 - iR));
        iMax = Math.max(iQ, currentContentInsetLeft2);
        iMin = Math.min(iR, i27 - currentContentInsetRight2);
        if (u(this.f1443i)) {
            if (z4) {
                iMin = r(this.f1443i, iMin, iMin2, iArr);
            } else {
                iMax = q(this.f1443i, iMax, iMin2, iArr);
            }
        }
        if (u(this.f1440e)) {
            if (z4) {
                iMin = r(this.f1440e, iMin, iMin2, iArr);
            } else {
                iMax = q(this.f1440e, iMax, iMin2, iArr);
            }
        }
        zU = u(this.f1437b);
        zU2 = u(this.f1438c);
        if (zU) {
            n1 n1Var8 = (n1) this.f1437b.getLayoutParams();
            measuredHeight = ((ViewGroup.MarginLayoutParams) n1Var8).bottomMargin + this.f1437b.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) n1Var8).topMargin;
        } else {
            measuredHeight = 0;
        }
        if (zU2) {
            n1 n1Var9 = (n1) this.f1438c.getLayoutParams();
            measuredHeight += this.f1438c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) n1Var9).topMargin + ((ViewGroup.MarginLayoutParams) n1Var9).bottomMargin;
        }
        if (zU) {
            if (zU) {
                c0143e0 = this.f1437b;
            } else {
                c0143e0 = this.f1438c;
            }
            if (zU2) {
                c0143e1 = this.f1438c;
            } else {
                c0143e1 = this.f1437b;
            }
            n1Var = (n1) c0143e0.getLayoutParams();
            n1Var2 = (n1) c0143e1.getLayoutParams();
            if (zU) {
            }
            i6 = this.f1457w & 112;
            i7 = iMin2;
            if (i6 == 48) {
                paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) n1Var).topMargin + this.f1452r;
            } else if (i6 != 80) {
                iMax3 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                i14 = ((ViewGroup.MarginLayoutParams) n1Var).topMargin + this.f1452r;
                if (iMax3 < i14) {
                    iMax3 = i14;
                } else {
                    i15 = (((height - paddingBottom) - measuredHeight) - iMax3) - paddingTop2;
                    i16 = ((ViewGroup.MarginLayoutParams) n1Var).bottomMargin;
                    i17 = this.f1453s;
                    if (i15 < i16 + i17) {
                        iMax3 = Math.max(0, iMax3 - ((((ViewGroup.MarginLayoutParams) n1Var2).bottomMargin + i17) - i15));
                    }
                }
                paddingTop = paddingTop2 + iMax3;
            } else {
                paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) n1Var2).bottomMargin) - this.f1453s) - measuredHeight;
            }
            if (z4) {
                if (z3) {
                    i11 = this.f1450p;
                } else {
                    i11 = 0;
                }
                int i210 = i11 - iArr[1];
                iMin -= Math.max(0, i210);
                iArr[1] = Math.max(0, -i210);
                if (zU) {
                    n1 n1Var10 = (n1) this.f1437b.getLayoutParams();
                    int measuredWidth5 = iMin - this.f1437b.getMeasuredWidth();
                    int measuredHeight4 = this.f1437b.getMeasuredHeight() + paddingTop;
                    this.f1437b.layout(measuredWidth5, paddingTop, iMin, measuredHeight4);
                    i12 = measuredWidth5 - this.f1451q;
                    paddingTop = measuredHeight4 + ((ViewGroup.MarginLayoutParams) n1Var10).bottomMargin;
                } else {
                    i12 = iMin;
                }
                if (zU2) {
                    int i211 = paddingTop + ((ViewGroup.MarginLayoutParams) ((n1) this.f1438c.getLayoutParams())).topMargin;
                    this.f1438c.layout(iMin - this.f1438c.getMeasuredWidth(), i211, iMin, this.f1438c.getMeasuredHeight() + i211);
                    i13 = iMin - this.f1451q;
                } else {
                    i13 = iMin;
                }
                if (z3) {
                    iMin = Math.min(i12, i13);
                }
                iMax = iMax;
            } else {
                if (z3) {
                    i8 = this.f1450p;
                } else {
                    i8 = 0;
                }
                int i36 = i8 - iArr[0];
                iMax2 = Math.max(0, i36) + iMax;
                iArr[0] = Math.max(0, -i36);
                if (zU) {
                    n1 n1Var11 = (n1) this.f1437b.getLayoutParams();
                    int measuredWidth6 = this.f1437b.getMeasuredWidth() + iMax2;
                    int measuredHeight5 = this.f1437b.getMeasuredHeight() + paddingTop;
                    this.f1437b.layout(iMax2, paddingTop, measuredWidth6, measuredHeight5);
                    i9 = measuredWidth6 + this.f1451q;
                    paddingTop = measuredHeight5 + ((ViewGroup.MarginLayoutParams) n1Var11).bottomMargin;
                } else {
                    i9 = iMax2;
                }
                if (zU2) {
                    int i37 = paddingTop + ((ViewGroup.MarginLayoutParams) ((n1) this.f1438c.getLayoutParams())).topMargin;
                    int measuredWidth7 = this.f1438c.getMeasuredWidth() + iMax2;
                    this.f1438c.layout(iMax2, i37, measuredWidth7, this.f1438c.getMeasuredHeight() + i37);
                    i10 = measuredWidth7 + this.f1451q;
                } else {
                    i10 = iMax2;
                }
                if (z3) {
                    iMax = Math.max(i9, i10);
                } else {
                    iMax = iMax2;
                }
            }
        } else {
            if (zU) {
                c0143e0 = this.f1437b;
            } else {
                c0143e0 = this.f1438c;
            }
            if (zU2) {
                c0143e1 = this.f1438c;
            } else {
                c0143e1 = this.f1437b;
            }
            n1Var = (n1) c0143e0.getLayoutParams();
            n1Var2 = (n1) c0143e1.getLayoutParams();
            if (zU) {
            }
            i6 = this.f1457w & 112;
            i7 = iMin2;
            if (i6 == 48) {
                paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) n1Var).topMargin + this.f1452r;
            } else if (i6 != 80) {
                iMax3 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                i14 = ((ViewGroup.MarginLayoutParams) n1Var).topMargin + this.f1452r;
                if (iMax3 < i14) {
                    iMax3 = i14;
                } else {
                    i15 = (((height - paddingBottom) - measuredHeight) - iMax3) - paddingTop2;
                    i16 = ((ViewGroup.MarginLayoutParams) n1Var).bottomMargin;
                    i17 = this.f1453s;
                    if (i15 < i16 + i17) {
                        iMax3 = Math.max(0, iMax3 - ((((ViewGroup.MarginLayoutParams) n1Var2).bottomMargin + i17) - i15));
                    }
                }
                paddingTop = paddingTop2 + iMax3;
            } else {
                paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) n1Var2).bottomMargin) - this.f1453s) - measuredHeight;
            }
            if (z4) {
                if (z3) {
                    i11 = this.f1450p;
                } else {
                    i11 = 0;
                }
                int i212 = i11 - iArr[1];
                iMin -= Math.max(0, i212);
                iArr[1] = Math.max(0, -i212);
                if (zU) {
                    n1 n1Var12 = (n1) this.f1437b.getLayoutParams();
                    int measuredWidth8 = iMin - this.f1437b.getMeasuredWidth();
                    int measuredHeight6 = this.f1437b.getMeasuredHeight() + paddingTop;
                    this.f1437b.layout(measuredWidth8, paddingTop, iMin, measuredHeight6);
                    i12 = measuredWidth8 - this.f1451q;
                    paddingTop = measuredHeight6 + ((ViewGroup.MarginLayoutParams) n1Var12).bottomMargin;
                } else {
                    i12 = iMin;
                }
                if (zU2) {
                    int i213 = paddingTop + ((ViewGroup.MarginLayoutParams) ((n1) this.f1438c.getLayoutParams())).topMargin;
                    this.f1438c.layout(iMin - this.f1438c.getMeasuredWidth(), i213, iMin, this.f1438c.getMeasuredHeight() + i213);
                    i13 = iMin - this.f1451q;
                } else {
                    i13 = iMin;
                }
                if (z3) {
                    iMin = Math.min(i12, i13);
                }
                iMax = iMax;
            } else {
                if (z3) {
                    i8 = this.f1450p;
                } else {
                    i8 = 0;
                }
                int i38 = i8 - iArr[0];
                iMax2 = Math.max(0, i38) + iMax;
                iArr[0] = Math.max(0, -i38);
                if (zU) {
                    n1 n1Var13 = (n1) this.f1437b.getLayoutParams();
                    int measuredWidth9 = this.f1437b.getMeasuredWidth() + iMax2;
                    int measuredHeight7 = this.f1437b.getMeasuredHeight() + paddingTop;
                    this.f1437b.layout(iMax2, paddingTop, measuredWidth9, measuredHeight7);
                    i9 = measuredWidth9 + this.f1451q;
                    paddingTop = measuredHeight7 + ((ViewGroup.MarginLayoutParams) n1Var13).bottomMargin;
                } else {
                    i9 = iMax2;
                }
                if (zU2) {
                    int i39 = paddingTop + ((ViewGroup.MarginLayoutParams) ((n1) this.f1438c.getLayoutParams())).topMargin;
                    int measuredWidth10 = this.f1438c.getMeasuredWidth() + iMax2;
                    this.f1438c.layout(iMax2, i39, measuredWidth10, this.f1438c.getMeasuredHeight() + i39);
                    i10 = measuredWidth10 + this.f1451q;
                } else {
                    i10 = iMax2;
                }
                if (z3) {
                    iMax = Math.max(i9, i10);
                } else {
                    iMax = iMax2;
                }
            }
        }
        arrayList = this.f1420D;
        a(arrayList, 3);
        size = arrayList.size();
        iQ2 = iMax;
        while (i18 < size) {
            iQ2 = q((View) arrayList.get(i18), iQ2, i7, iArr);
        }
        i19 = i7;
        a(arrayList, 5);
        size2 = arrayList.size();
        while (i20 < size2) {
            iMin = r((View) arrayList.get(i20), iMin, i19, iArr);
        }
        a(arrayList, 1);
        int i310 = iArr[0];
        int i311 = iArr[1];
        size3 = arrayList.size();
        i21 = i311;
        i22 = i310;
        i23 = 0;
        measuredWidth = 0;
        while (i23 < size3) {
            View view2 = (View) arrayList.get(i23);
            n1 n1Var14 = (n1) view2.getLayoutParams();
            int i312 = ((ViewGroup.MarginLayoutParams) n1Var14).leftMargin - i22;
            int i313 = ((ViewGroup.MarginLayoutParams) n1Var14).rightMargin - i21;
            int iMax8 = Math.max(0, i312);
            int iMax9 = Math.max(0, i313);
            int iMax10 = Math.max(0, -i312);
            int iMax11 = Math.max(0, -i313);
            measuredWidth += view2.getMeasuredWidth() + iMax8 + iMax9;
            i23++;
            i21 = iMax11;
            i22 = iMax10;
        }
        i24 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth / 2);
        i25 = measuredWidth + i24;
        if (i24 >= iQ2) {
            if (i25 > iMin) {
                iQ2 = i24 - (i25 - iMin);
            } else {
                iQ2 = i24;
            }
        }
        size4 = arrayList.size();
        while (i26 < size4) {
            iQ2 = q((View) arrayList.get(i26), iQ2, i19, iArr);
        }
        arrayList.clear();
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        int iL;
        int iMax;
        int iCombineMeasuredStates;
        int iL2;
        int iM;
        int iCombineMeasuredStates2;
        int iMax2;
        boolean zA = y1.a(this);
        int i4 = !zA ? 1 : 0;
        int i5 = 0;
        if (u(this.f1439d)) {
            t(this.f1439d, i2, 0, i3, this.f1449o);
            iL = l(this.f1439d) + this.f1439d.getMeasuredWidth();
            iMax = Math.max(0, m(this.f1439d) + this.f1439d.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f1439d.getMeasuredState());
        } else {
            iL = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (u(this.f1442h)) {
            t(this.f1442h, i2, 0, i3, this.f1449o);
            iL = l(this.f1442h) + this.f1442h.getMeasuredWidth();
            iMax = Math.max(iMax, m(this.f1442h) + this.f1442h.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1442h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, iL);
        int iMax4 = Math.max(0, currentContentInsetStart - iL);
        int[] iArr = this.f1422F;
        iArr[zA ? 1 : 0] = iMax4;
        if (u(this.f1436a)) {
            t(this.f1436a, i2, iMax3, i3, this.f1449o);
            iL2 = l(this.f1436a) + this.f1436a.getMeasuredWidth();
            iMax = Math.max(iMax, m(this.f1436a) + this.f1436a.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1436a.getMeasuredState());
        } else {
            iL2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax5 = iMax3 + Math.max(currentContentInsetEnd, iL2);
        iArr[i4] = Math.max(0, currentContentInsetEnd - iL2);
        if (u(this.f1443i)) {
            iMax5 += s(this.f1443i, i2, iMax5, i3, 0, iArr);
            iMax = Math.max(iMax, m(this.f1443i) + this.f1443i.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1443i.getMeasuredState());
        }
        if (u(this.f1440e)) {
            iMax5 += s(this.f1440e, i2, iMax5, i3, 0, iArr);
            iMax = Math.max(iMax, m(this.f1440e) + this.f1440e.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1440e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (((n1) childAt.getLayoutParams()).f3254b == 0 && u(childAt)) {
                iMax5 += s(childAt, i2, iMax5, i3, 0, iArr);
                iMax = Math.max(iMax, m(childAt) + childAt.getMeasuredHeight());
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i7 = this.f1452r + this.f1453s;
        int i8 = this.f1450p + this.f1451q;
        if (u(this.f1437b)) {
            s(this.f1437b, i2, iMax5 + i8, i3, i7, iArr);
            int iL3 = l(this.f1437b) + this.f1437b.getMeasuredWidth();
            iM = m(this.f1437b) + this.f1437b.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f1437b.getMeasuredState());
            iMax2 = iL3;
        } else {
            iM = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (u(this.f1438c)) {
            iMax2 = Math.max(iMax2, s(this.f1438c, i2, iMax5 + i8, i3, iM + i7, iArr));
            iM += m(this.f1438c) + this.f1438c.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f1438c.getMeasuredState());
        }
        int iMax6 = Math.max(iMax, iM);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax6;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight + iMax5 + iMax2, getSuggestedMinimumWidth()), i2, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i3, iCombineMeasuredStates2 << 16);
        if (!this.f1432P) {
            i5 = iResolveSizeAndState2;
            break;
        }
        int childCount2 = getChildCount();
        for (int i9 = 0; i9 < childCount2; i9++) {
            View childAt2 = getChildAt(i9);
            if (u(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                i5 = iResolveSizeAndState2;
                break;
            }
        }
        setMeasuredDimension(iResolveSizeAndState, i5);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof p1)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        p1 p1Var = (p1) parcelable;
        super.onRestoreInstanceState(p1Var.f184a);
        ActionMenuView actionMenuView = this.f1436a;
        n nVar = actionMenuView != null ? actionMenuView.f1352p : null;
        int i2 = p1Var.f3262c;
        if (i2 != 0 && this.f1429M != null && nVar != null && (menuItemFindItem = nVar.findItem(i2)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (p1Var.f3263d) {
            D.b bVar = this.f1435T;
            removeCallbacks(bVar);
            post(bVar);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        d();
        S0 s1 = this.f1454t;
        boolean z2 = i2 == 1;
        if (z2 == s1.g) {
            return;
        }
        s1.g = z2;
        if (!s1.f3114h) {
            s1.f3108a = s1.f3112e;
            s1.f3109b = s1.f3113f;
            return;
        }
        if (z2) {
            int i3 = s1.f3111d;
            if (i3 == Integer.MIN_VALUE) {
                i3 = s1.f3112e;
            }
            s1.f3108a = i3;
            int i4 = s1.f3110c;
            if (i4 == Integer.MIN_VALUE) {
                i4 = s1.f3113f;
            }
            s1.f3109b = i4;
            return;
        }
        int i5 = s1.f3110c;
        if (i5 == Integer.MIN_VALUE) {
            i5 = s1.f3112e;
        }
        s1.f3108a = i5;
        int i6 = s1.f3111d;
        if (i6 == Integer.MIN_VALUE) {
            i6 = s1.f3113f;
        }
        s1.f3109b = i6;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        p pVar;
        p1 p1Var = new p1(super.onSaveInstanceState());
        m1 m1Var = this.f1429M;
        if (m1Var != null && (pVar = m1Var.f3251b) != null) {
            p1Var.f3262c = pVar.f2960a;
        }
        p1Var.f3263d = p();
        return p1Var;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1418B = false;
        }
        if (!this.f1418B) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f1418B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1418B = false;
        }
        return true;
    }

    public final boolean p() {
        C0154k c0154k;
        ActionMenuView actionMenuView = this.f1436a;
        return (actionMenuView == null || (c0154k = actionMenuView.f1356t) == null || !c0154k.i()) ? false : true;
    }

    public final int q(View view, int i2, int i3, int[] iArr) {
        n1 n1Var = (n1) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) n1Var).leftMargin - iArr[0];
        int iMax = Math.max(0, i4) + i2;
        iArr[0] = Math.max(0, -i4);
        int iK = k(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iK, iMax + measuredWidth, view.getMeasuredHeight() + iK);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) n1Var).rightMargin + iMax;
    }

    public final int r(View view, int i2, int i3, int[] iArr) {
        n1 n1Var = (n1) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) n1Var).rightMargin - iArr[1];
        int iMax = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int iK = k(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iK, iMax, view.getMeasuredHeight() + iK);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) n1Var).leftMargin);
    }

    public final int s(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i7) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + iMax + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i4, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public void setBackInvokedCallbackEnabled(boolean z2) {
        if (this.S != z2) {
            this.S = z2;
            w();
        }
    }

    public void setCollapseContentDescription(int i2) {
        setCollapseContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setCollapseIcon(int i2) {
        setCollapseIcon(l.A(getContext(), i2));
    }

    public void setCollapsible(boolean z2) {
        this.f1432P = z2;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.f1456v) {
            this.f1456v = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.f1455u) {
            this.f1455u = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i2) {
        setLogo(l.A(getContext(), i2));
    }

    public void setLogoDescription(int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setNavigationContentDescription(int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setNavigationIcon(int i2) {
        setNavigationIcon(l.A(getContext(), i2));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        g();
        this.f1439d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(o1 o1Var) {
        this.f1425I = o1Var;
    }

    public void setOverflowIcon(Drawable drawable) {
        e();
        this.f1436a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i2) {
        if (this.f1445k != i2) {
            this.f1445k = i2;
            if (i2 == 0) {
                this.f1444j = getContext();
            } else {
                this.f1444j = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setSubtitle(int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitleTextColor(int i2) {
        setSubtitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setTitle(int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitleMarginBottom(int i2) {
        this.f1453s = i2;
        requestLayout();
    }

    public void setTitleMarginEnd(int i2) {
        this.f1451q = i2;
        requestLayout();
    }

    public void setTitleMarginStart(int i2) {
        this.f1450p = i2;
        requestLayout();
    }

    public void setTitleMarginTop(int i2) {
        this.f1452r = i2;
        requestLayout();
    }

    public void setTitleTextColor(int i2) {
        setTitleTextColor(ColorStateList.valueOf(i2));
    }

    public final void t(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final boolean u(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public final boolean v() {
        C0154k c0154k;
        ActionMenuView actionMenuView = this.f1436a;
        return (actionMenuView == null || (c0154k = actionMenuView.f1356t) == null || !c0154k.l()) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0023  */
    public final void w() {
        boolean z2;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        int i2 = 0;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = l1.a(this);
            m1 m1Var = this.f1429M;
            if (m1Var == null || m1Var.f3251b == null || onBackInvokedDispatcherA == null) {
                z2 = false;
            } else {
                WeakHashMap weakHashMap = X.f14a;
                if (A.I.b(this) && this.S) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            if (z2 && this.f1434R == null) {
                if (this.f1433Q == null) {
                    this.f1433Q = l1.b(new j1(this, i2));
                }
                l1.c(onBackInvokedDispatcherA, this.f1433Q);
                this.f1434R = onBackInvokedDispatcherA;
                return;
            }
            if (z2 || (onBackInvokedDispatcher = this.f1434R) == null) {
                return;
            }
            l1.d(onBackInvokedDispatcher, this.f1433Q);
            this.f1434R = null;
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        n1 n1Var = new n1(context, attributeSet);
        n1Var.f3253a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p007e.a.f2227b);
        n1Var.f3253a = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        n1Var.f3254b = 0;
        return n1Var;
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        C0179x c0179x = this.f1442h;
        if (c0179x != null) {
            c0179x.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.f1442h.setImageDrawable(drawable);
        } else {
            C0179x c0179x = this.f1442h;
            if (c0179x != null) {
                c0179x.setImageDrawable(this.f1441f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f1440e == null) {
                this.f1440e = new C0181y(getContext(), null, 0);
            }
            if (!o(this.f1440e)) {
                b(this.f1440e, true);
            }
        } else {
            C0181y c0181y = this.f1440e;
            if (c0181y != null && o(c0181y)) {
                removeView(this.f1440e);
                this.f1421E.remove(this.f1440e);
            }
        }
        C0181y c0181y2 = this.f1440e;
        if (c0181y2 != null) {
            c0181y2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f1440e == null) {
            this.f1440e = new C0181y(getContext(), null, 0);
        }
        C0181y c0181y = this.f1440e;
        if (c0181y != null) {
            c0181y.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        C0179x c0179x = this.f1439d;
        if (c0179x != null) {
            c0179x.setContentDescription(charSequence);
            f1.d.z(this.f1439d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!o(this.f1439d)) {
                b(this.f1439d, true);
            }
        } else {
            C0179x c0179x = this.f1439d;
            if (c0179x != null && o(c0179x)) {
                removeView(this.f1439d);
                this.f1421E.remove(this.f1439d);
            }
        }
        C0179x c0179x2 = this.f1439d;
        if (c0179x2 != null) {
            c0179x2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            C0143e0 c0143e0 = this.f1438c;
            if (c0143e0 != null && o(c0143e0)) {
                removeView(this.f1438c);
                this.f1421E.remove(this.f1438c);
            }
        } else {
            if (this.f1438c == null) {
                Context context = getContext();
                C0143e0 c0143e1 = new C0143e0(context, null);
                this.f1438c = c0143e1;
                c0143e1.setSingleLine();
                this.f1438c.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.f1447m;
                if (i2 != 0) {
                    this.f1438c.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.f1417A;
                if (colorStateList != null) {
                    this.f1438c.setTextColor(colorStateList);
                }
            }
            if (!o(this.f1438c)) {
                b(this.f1438c, true);
            }
        }
        C0143e0 c0143e2 = this.f1438c;
        if (c0143e2 != null) {
            c0143e2.setText(charSequence);
        }
        this.f1459y = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.f1417A = colorStateList;
        C0143e0 c0143e0 = this.f1438c;
        if (c0143e0 != null) {
            c0143e0.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            C0143e0 c0143e0 = this.f1437b;
            if (c0143e0 != null && o(c0143e0)) {
                removeView(this.f1437b);
                this.f1421E.remove(this.f1437b);
            }
        } else {
            if (this.f1437b == null) {
                Context context = getContext();
                C0143e0 c0143e1 = new C0143e0(context, null);
                this.f1437b = c0143e1;
                c0143e1.setSingleLine();
                this.f1437b.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.f1446l;
                if (i2 != 0) {
                    this.f1437b.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.f1460z;
                if (colorStateList != null) {
                    this.f1437b.setTextColor(colorStateList);
                }
            }
            if (!o(this.f1437b)) {
                b(this.f1437b, true);
            }
        }
        C0143e0 c0143e2 = this.f1437b;
        if (c0143e2 != null) {
            c0143e2.setText(charSequence);
        }
        this.f1458x = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f1460z = colorStateList;
        C0143e0 c0143e0 = this.f1437b;
        if (c0143e0 != null) {
            c0143e0.setTextColor(colorStateList);
        }
    }
}
