// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0086d f1741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f1742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final H.s f1743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final H.s f1744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1746f;
    public final boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f1747h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1748i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1749j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1750k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1751l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1752m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1753n;

    public N() {
        L l2 = new L(0, this);
        L l3 = new L(1, this);
        this.f1743c = new H.s(l2);
        this.f1744d = new H.s(l3);
        this.f1745e = false;
        this.f1746f = false;
        this.g = true;
        this.f1747h = true;
    }

    public static int C(View view) {
        return ((O) view.getLayoutParams()).f1754a.getLayoutPosition();
    }

    public static M D(Context context, AttributeSet attributeSet, int i2, int i3) {
        M m2 = new M();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, P.a.f513a, i2, i3);
        m2.f1737a = typedArrayObtainStyledAttributes.getInt(0, 1);
        m2.f1738b = typedArrayObtainStyledAttributes.getInt(10, 1);
        m2.f1739c = typedArrayObtainStyledAttributes.getBoolean(9, false);
        m2.f1740d = typedArrayObtainStyledAttributes.getBoolean(11, false);
        typedArrayObtainStyledAttributes.recycle();
        return m2;
    }

    public static boolean H(int i2, int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (i4 > 0 && i2 != i4) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i2;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i2;
        }
        return true;
    }

    public static void I(View view, int i2, int i3, int i4, int i5) {
        O o2 = (O) view.getLayoutParams();
        Rect rect = o2.f1755b;
        view.layout(i2 + rect.left + ((ViewGroup.MarginLayoutParams) o2).leftMargin, i3 + rect.top + ((ViewGroup.MarginLayoutParams) o2).topMargin, (i4 - rect.right) - ((ViewGroup.MarginLayoutParams) o2).rightMargin, (i5 - rect.bottom) - ((ViewGroup.MarginLayoutParams) o2).bottomMargin);
    }

    public static int f(int i2, int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            return mode != 1073741824 ? Math.max(i3, i4) : size;
        }
        return Math.min(size, Math.max(i3, i4));
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001a  */
    /* JADX WARN: Code duplicated, block: B:14:0x0022  */
    /* JADX WARN: Code duplicated, block: B:5:0x0010  */
    public static int v(int i2, int i3, int i4, int i5, boolean z2) {
        int iMax = Math.max(0, i2 - i4);
        if (z2) {
            if (i5 >= 0) {
                i3 = 1073741824;
            } else if (i5 != -1 || (i3 != Integer.MIN_VALUE && (i3 == 0 || i3 != 1073741824))) {
                i3 = 0;
                i5 = 0;
            } else {
                i5 = iMax;
            }
        } else if (i5 >= 0) {
            i3 = 1073741824;
        } else if (i5 == -1) {
            i5 = iMax;
        } else if (i5 != -2) {
            i3 = 0;
            i5 = 0;
        } else if (i3 == Integer.MIN_VALUE || i3 == 1073741824) {
            i5 = iMax;
            i3 = Integer.MIN_VALUE;
        } else {
            i5 = iMax;
            i3 = 0;
        }
        return View.MeasureSpec.makeMeasureSpec(i5, i3);
    }

    public static void x(View view, Rect rect) {
        boolean z2 = RecyclerView.f1764y0;
        O o2 = (O) view.getLayoutParams();
        Rect rect2 = o2.f1755b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) o2).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) o2).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) o2).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) o2).bottomMargin);
    }

    public final int A() {
        RecyclerView recyclerView = this.f1742b;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public final int B() {
        RecyclerView recyclerView = this.f1742b;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public int E(U u2, Y y2) {
        return -1;
    }

    public final void F(View view, Rect rect) {
        Matrix matrix;
        Rect rect2 = ((O) view.getLayoutParams()).f1755b;
        rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        if (this.f1742b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.f1742b.f1809l;
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public abstract boolean G();

    public void J(int i2) {
        RecyclerView recyclerView = this.f1742b;
        if (recyclerView != null) {
            int iE = recyclerView.f1798f.e();
            for (int i3 = 0; i3 < iE; i3++) {
                recyclerView.f1798f.d(i3).offsetLeftAndRight(i2);
            }
        }
    }

    public void K(int i2) {
        RecyclerView recyclerView = this.f1742b;
        if (recyclerView != null) {
            int iE = recyclerView.f1798f.e();
            for (int i3 = 0; i3 < iE; i3++) {
                recyclerView.f1798f.d(i3).offsetTopAndBottom(i2);
            }
        }
    }

    public abstract void M(RecyclerView recyclerView);

    public abstract View N(View view, int i2, U u2, Y y2);

    public void O(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.f1742b;
        U u2 = recyclerView.f1792c;
        Y y2 = recyclerView.f1799f0;
        if (recyclerView == null || accessibilityEvent == null) {
            return;
        }
        boolean z2 = true;
        if (!recyclerView.canScrollVertically(1) && !this.f1742b.canScrollVertically(-1) && !this.f1742b.canScrollHorizontally(-1) && !this.f1742b.canScrollHorizontally(1)) {
            z2 = false;
        }
        accessibilityEvent.setScrollable(z2);
        F f2 = this.f1742b.f1811m;
        if (f2 != null) {
            accessibilityEvent.setItemCount(f2.getItemCount());
        }
    }

    public void P(U u2, Y y2, B.m mVar) {
        boolean zCanScrollVertically = this.f1742b.canScrollVertically(-1);
        AccessibilityNodeInfo accessibilityNodeInfo = mVar.f103a;
        if (zCanScrollVertically || this.f1742b.canScrollHorizontally(-1)) {
            accessibilityNodeInfo.addAction(8192);
            accessibilityNodeInfo.setScrollable(true);
        }
        if (this.f1742b.canScrollVertically(1) || this.f1742b.canScrollHorizontally(1)) {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.setScrollable(true);
        }
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(E(u2, y2), w(u2, y2), false, 0));
    }

    public final void Q(View view, B.m mVar) {
        c0 c0VarI = RecyclerView.I(view);
        if (c0VarI == null || c0VarI.isRemoved()) {
            return;
        }
        C0086d c0086d = this.f1741a;
        if (c0086d.f1908c.contains(c0VarI.itemView)) {
            return;
        }
        RecyclerView recyclerView = this.f1742b;
        R(recyclerView.f1792c, recyclerView.f1799f0, view, mVar);
    }

    public abstract void X(U u2, Y y2);

    public abstract void Y(Y y2);

    public abstract void Z(Parcelable parcelable);

    /* JADX WARN: Code duplicated, block: B:21:0x005c  */
    public final void a(View view, int i2, boolean z2) {
        int iB;
        c0 c0VarI = RecyclerView.I(view);
        if (z2 || c0VarI.isRemoved()) {
            p021m.i iVar = (p021m.i) this.f1742b.g.f232b;
            l0 l0VarA = (l0) iVar.get(c0VarI);
            if (l0VarA == null) {
                l0VarA = l0.a();
                iVar.put(c0VarI, l0VarA);
            }
            l0VarA.f1991a |= 1;
        } else {
            this.f1742b.g.F(c0VarI);
        }
        O o2 = (O) view.getLayoutParams();
        if (c0VarI.wasReturnedFromScrap() || c0VarI.isScrap()) {
            if (c0VarI.isScrap()) {
                c0VarI.unScrap();
            } else {
                c0VarI.clearReturnedFromScrapFlag();
            }
            this.f1741a.b(view, i2, view.getLayoutParams(), false);
        } else if (view.getParent() == this.f1742b) {
            C0086d c0086d = this.f1741a;
            int iIndexOfChild = c0086d.f1906a.f1703a.indexOfChild(view);
            if (iIndexOfChild == -1) {
                iB = -1;
            } else {
                C0085c c0085c = c0086d.f1907b;
                if (c0085c.d(iIndexOfChild)) {
                    iB = -1;
                } else {
                    iB = iIndexOfChild - c0085c.b(iIndexOfChild);
                }
            }
            if (i2 == -1) {
                i2 = this.f1741a.e();
            }
            if (iB == -1) {
                StringBuilder sb = new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                sb.append(this.f1742b.indexOfChild(view));
                throw new IllegalStateException(F0.h.c(this.f1742b, sb));
            }
            if (iB != i2) {
                N n2 = this.f1742b.f1813n;
                View viewT = n2.t(iB);
                if (viewT == null) {
                    throw new IllegalArgumentException("Cannot move a child from non-existing index:" + iB + n2.f1742b.toString());
                }
                n2.t(iB);
                n2.f1741a.c(iB);
                O o3 = (O) viewT.getLayoutParams();
                c0 c0VarI2 = RecyclerView.I(viewT);
                if (c0VarI2.isRemoved()) {
                    p021m.i iVar2 = (p021m.i) n2.f1742b.g.f232b;
                    l0 l0VarA2 = (l0) iVar2.get(c0VarI2);
                    if (l0VarA2 == null) {
                        l0VarA2 = l0.a();
                        iVar2.put(c0VarI2, l0VarA2);
                    }
                    l0VarA2.f1991a = 1 | l0VarA2.f1991a;
                } else {
                    n2.f1742b.g.F(c0VarI2);
                }
                n2.f1741a.b(viewT, i2, o3, c0VarI2.isRemoved());
            }
        } else {
            this.f1741a.a(view, i2, false);
            o2.f1756c = true;
        }
        if (o2.f1757d) {
            if (RecyclerView.f1765z0) {
                Log.d("RecyclerView", "consuming pending invalidate on child " + o2.f1754a);
            }
            c0VarI.itemView.invalidate();
            o2.f1757d = false;
        }
    }

    public abstract Parcelable a0();

    public abstract void b(String str);

    public void b0(int i2) {
    }

    public abstract boolean c();

    public final void c0(U u2) {
        for (int iU = u() - 1; iU >= 0; iU--) {
            if (!RecyclerView.I(t(iU)).shouldIgnore()) {
                View viewT = t(iU);
                f0(iU);
                u2.h(viewT);
            }
        }
    }

    public abstract boolean d();

    public final void d0(U u2) {
        ArrayList arrayList;
        int size = u2.f1866a.size();
        int i2 = size - 1;
        while (true) {
            arrayList = u2.f1866a;
            if (i2 < 0) {
                break;
            }
            View view = ((c0) arrayList.get(i2)).itemView;
            c0 c0VarI = RecyclerView.I(view);
            if (!c0VarI.shouldIgnore()) {
                c0VarI.setIsRecyclable(false);
                if (c0VarI.isTmpDetached()) {
                    this.f1742b.removeDetachedView(view, false);
                }
                K k2 = this.f1742b.f1777L;
                if (k2 != null) {
                    k2.d(c0VarI);
                }
                c0VarI.setIsRecyclable(true);
                c0 c0VarI2 = RecyclerView.I(view);
                c0VarI2.mScrapContainer = null;
                c0VarI2.mInChangeScrap = false;
                c0VarI2.clearReturnedFromScrapFlag();
                u2.i(c0VarI2);
            }
            i2--;
        }
        arrayList.clear();
        ArrayList arrayList2 = u2.f1867b;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (size > 0) {
            this.f1742b.invalidate();
        }
    }

    public boolean e(O o2) {
        return o2 != null;
    }

    public final void e0(View view, U u2) {
        C0086d c0086d = this.f1741a;
        D d2 = c0086d.f1906a;
        int i2 = c0086d.f1909d;
        if (i2 == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        }
        if (i2 == 2) {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
        try {
            c0086d.f1909d = 1;
            c0086d.f1910e = view;
            int iIndexOfChild = d2.f1703a.indexOfChild(view);
            if (iIndexOfChild >= 0) {
                if (c0086d.f1907b.g(iIndexOfChild)) {
                    c0086d.j(view);
                }
                d2.h(iIndexOfChild);
            }
            c0086d.f1909d = 0;
            c0086d.f1910e = null;
            u2.h(view);
        } catch (Throwable th) {
            c0086d.f1909d = 0;
            c0086d.f1910e = null;
            throw th;
        }
    }

    public final void f0(int i2) {
        if (t(i2) != null) {
            C0086d c0086d = this.f1741a;
            D d2 = c0086d.f1906a;
            int i3 = c0086d.f1909d;
            if (i3 == 1) {
                throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
            }
            if (i3 == 2) {
                throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
            }
            try {
                int iF = c0086d.f(i2);
                View childAt = d2.f1703a.getChildAt(iF);
                if (childAt != null) {
                    c0086d.f1909d = 1;
                    c0086d.f1910e = childAt;
                    if (c0086d.f1907b.g(iF)) {
                        c0086d.j(childAt);
                    }
                    d2.h(iF);
                }
            } finally {
                c0086d.f1909d = 0;
                c0086d.f1910e = null;
            }
        }
    }

    public abstract void g(int i2, int i3, Y y2, r rVar);

    /* JADX WARN: Code duplicated, block: B:28:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:34:0x00be  */
    public final boolean g0(RecyclerView recyclerView, View view, Rect rect, boolean z2, boolean z3) {
        int iZ = z();
        int iB = B();
        int iA = this.f1752m - A();
        int iY = this.f1753n - y();
        int left = (view.getLeft() + rect.left) - view.getScrollX();
        int top = (view.getTop() + rect.top) - view.getScrollY();
        int iWidth = rect.width() + left;
        int iHeight = rect.height() + top;
        int i2 = left - iZ;
        int iMin = Math.min(0, i2);
        int i3 = top - iB;
        int iMin2 = Math.min(0, i3);
        int i4 = iWidth - iA;
        int iMax = Math.max(0, i4);
        int iMax2 = Math.max(0, iHeight - iY);
        RecyclerView recyclerView2 = this.f1742b;
        WeakHashMap weakHashMap = A.X.f14a;
        if (A.H.d(recyclerView2) != 1) {
            if (iMin == 0) {
                iMin = Math.min(i2, iMax);
            }
            iMax = iMin;
        } else if (iMax == 0) {
            iMax = Math.max(iMin, i4);
        }
        if (iMin2 == 0) {
            iMin2 = Math.min(i3, iMax2);
        }
        int[] iArr = {iMax, iMin2};
        int i5 = iArr[0];
        int i6 = iArr[1];
        if (z3) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild != null) {
                int iZ2 = z();
                int iB2 = B();
                int iA2 = this.f1752m - A();
                int iY2 = this.f1753n - y();
                Rect rect2 = this.f1742b.f1805j;
                x(focusedChild, rect2);
                if (rect2.left - i5 < iA2 && rect2.right - i5 > iZ2 && rect2.top - i6 < iY2 && rect2.bottom - i6 > iB2) {
                    if (i5 == 0) {
                    }
                    if (z2) {
                        recyclerView.scrollBy(i5, i6);
                    } else {
                        recyclerView.c0(i5, i6, false);
                    }
                    return true;
                }
            }
        } else if (i5 == 0 || i6 != 0) {
            if (z2) {
                recyclerView.scrollBy(i5, i6);
            } else {
                recyclerView.c0(i5, i6, false);
            }
            return true;
        }
        return false;
    }

    public final void h0() {
        RecyclerView recyclerView = this.f1742b;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public abstract int i(Y y2);

    public abstract int i0(int i2, U u2, Y y2);

    public abstract int j(Y y2);

    public abstract int j0(int i2, U u2, Y y2);

    public abstract int k(Y y2);

    public final void k0(RecyclerView recyclerView) {
        l0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
    }

    public abstract int l(Y y2);

    public final void l0(int i2, int i3) {
        this.f1752m = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        this.f1750k = mode;
        if (mode == 0 && !RecyclerView.f1760C0) {
            this.f1752m = 0;
        }
        this.f1753n = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        this.f1751l = mode2;
        if (mode2 != 0 || RecyclerView.f1760C0) {
            return;
        }
        this.f1753n = 0;
    }

    public abstract int m(Y y2);

    public void m0(Rect rect, int i2, int i3) {
        int iA = A() + z() + rect.width();
        int iY = y() + B() + rect.height();
        RecyclerView recyclerView = this.f1742b;
        WeakHashMap weakHashMap = A.X.f14a;
        this.f1742b.setMeasuredDimension(f(i2, iA, A.G.e(recyclerView)), f(i3, iY, A.G.d(this.f1742b)));
    }

    public abstract int n(Y y2);

    public final void n0(int i2, int i3) {
        int iU = u();
        if (iU == 0) {
            this.f1742b.n(i2, i3);
            return;
        }
        int i4 = Integer.MIN_VALUE;
        int i5 = Integer.MAX_VALUE;
        int i6 = Integer.MIN_VALUE;
        int i7 = Integer.MAX_VALUE;
        for (int i8 = 0; i8 < iU; i8++) {
            View viewT = t(i8);
            Rect rect = this.f1742b.f1805j;
            x(viewT, rect);
            int i9 = rect.left;
            if (i9 < i7) {
                i7 = i9;
            }
            int i10 = rect.right;
            if (i10 > i4) {
                i4 = i10;
            }
            int i11 = rect.top;
            if (i11 < i5) {
                i5 = i11;
            }
            int i12 = rect.bottom;
            if (i12 > i6) {
                i6 = i12;
            }
        }
        this.f1742b.f1805j.set(i7, i5, i4, i6);
        m0(this.f1742b.f1805j, i2, i3);
    }

    public final void o(U u2) {
        for (int iU = u() - 1; iU >= 0; iU--) {
            View viewT = t(iU);
            c0 c0VarI = RecyclerView.I(viewT);
            if (c0VarI.shouldIgnore()) {
                if (RecyclerView.f1765z0) {
                    Log.d("RecyclerView", "ignoring view " + c0VarI);
                }
            } else if (!c0VarI.isInvalid() || c0VarI.isRemoved() || this.f1742b.f1811m.hasStableIds()) {
                t(iU);
                this.f1741a.c(iU);
                u2.j(viewT);
                this.f1742b.g.F(c0VarI);
            } else {
                f0(iU);
                u2.i(c0VarI);
            }
        }
    }

    public final void o0(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.f1742b = null;
            this.f1741a = null;
            this.f1752m = 0;
            this.f1753n = 0;
        } else {
            this.f1742b = recyclerView;
            this.f1741a = recyclerView.f1798f;
            this.f1752m = recyclerView.getWidth();
            this.f1753n = recyclerView.getHeight();
        }
        this.f1750k = 1073741824;
        this.f1751l = 1073741824;
    }

    public View p(int i2) {
        int iU = u();
        for (int i3 = 0; i3 < iU; i3++) {
            View viewT = t(i3);
            c0 c0VarI = RecyclerView.I(viewT);
            if (c0VarI != null && c0VarI.getLayoutPosition() == i2 && !c0VarI.shouldIgnore() && (this.f1742b.f1799f0.f1880f || !c0VarI.isRemoved())) {
                return viewT;
            }
        }
        return null;
    }

    public final boolean p0(View view, int i2, int i3, O o2) {
        return (!view.isLayoutRequested() && this.g && H(view.getWidth(), i2, ((ViewGroup.MarginLayoutParams) o2).width) && H(view.getHeight(), i3, ((ViewGroup.MarginLayoutParams) o2).height)) ? false : true;
    }

    public abstract O q();

    public boolean q0() {
        return false;
    }

    public O r(Context context, AttributeSet attributeSet) {
        return new O(context, attributeSet);
    }

    public final boolean r0(View view, int i2, int i3, O o2) {
        return (this.g && H(view.getMeasuredWidth(), i2, ((ViewGroup.MarginLayoutParams) o2).width) && H(view.getMeasuredHeight(), i3, ((ViewGroup.MarginLayoutParams) o2).height)) ? false : true;
    }

    public O s(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof O) {
            return new O((O) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new O((ViewGroup.MarginLayoutParams) layoutParams) : new O(layoutParams);
    }

    public abstract boolean s0();

    public final View t(int i2) {
        C0086d c0086d = this.f1741a;
        if (c0086d != null) {
            return c0086d.d(i2);
        }
        return null;
    }

    public final int u() {
        C0086d c0086d = this.f1741a;
        if (c0086d != null) {
            return c0086d.e();
        }
        return 0;
    }

    public int w(U u2, Y y2) {
        return -1;
    }

    public final int y() {
        RecyclerView recyclerView = this.f1742b;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public final int z() {
        RecyclerView recyclerView = this.f1742b;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public void L() {
    }

    public void T() {
    }

    public void S(int i2, int i3) {
    }

    public void U(int i2, int i3) {
    }

    public void V(int i2, int i3) {
    }

    public void W(int i2, int i3) {
    }

    public void h(int i2, r rVar) {
    }

    public void R(U u2, Y y2, View view, B.m mVar) {
    }
}
