// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f1706D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public int f1707E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public int[] f1708F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public View[] f1709G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public final SparseIntArray f1710H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final SparseIntArray f1711I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final H.s f1712J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public final Rect f1713K;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f1706D = false;
        this.f1707E = -1;
        this.f1710H = new SparseIntArray();
        this.f1711I = new SparseIntArray();
        this.f1712J = new H.s(6);
        this.f1713K = new Rect();
        c1(N.D(context, attributeSet, i2, i3).f1738b);
    }

    @Override // androidx.recyclerview.widget.N
    public final int E(U u2, Y y2) {
        if (this.f1725o == 0) {
            return this.f1707E;
        }
        if (y2.b() < 1) {
            return 0;
        }
        return Y0(y2.b() - 1, u2, y2) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final View E0(U u2, Y y2, boolean z2, boolean z3) {
        int i2;
        int iU;
        int iU2 = u();
        int i3 = 1;
        if (z3) {
            iU = u() - 1;
            i2 = -1;
            i3 = -1;
        } else {
            i2 = iU2;
            iU = 0;
        }
        int iB = y2.b();
        y0();
        int iK = this.f1727q.k();
        int iG = this.f1727q.g();
        View view = null;
        View view2 = null;
        while (iU != i2) {
            View viewT = t(iU);
            int iC = N.C(viewT);
            if (iC >= 0 && iC < iB && Z0(iC, u2, y2) == 0) {
                if (((O) viewT.getLayoutParams()).f1754a.isRemoved()) {
                    if (view2 == null) {
                        view2 = viewT;
                    }
                } else {
                    if (this.f1727q.e(viewT) < iG && this.f1727q.b(viewT) >= iK) {
                        return viewT;
                    }
                    if (view == null) {
                        view = viewT;
                    }
                }
            }
            iU += i3;
        }
        return view != null ? view : view2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v37 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void K0(U u2, Y y2, C0106y c0106y, C0105x c0105x) {
        int i2;
        int i3;
        int i4;
        int iD;
        int iZ;
        int iB;
        int iD2;
        int iV;
        int iV2;
        ?? r8;
        int i5;
        View viewB;
        int iJ = this.f1727q.j();
        boolean z2 = iJ != 1073741824;
        int i6 = u() > 0 ? this.f1708F[this.f1707E] : 0;
        if (z2) {
            d1();
        }
        boolean z3 = c0106y.f2066e == 1;
        int iZ0 = this.f1707E;
        if (!z3) {
            iZ0 = Z0(c0106y.f2065d, u2, y2) + a1(c0106y.f2065d, u2, y2);
        }
        int i7 = 0;
        while (i7 < this.f1707E && (i5 = c0106y.f2065d) >= 0 && i5 < y2.b() && iZ0 > 0) {
            int i8 = c0106y.f2065d;
            int iA1 = a1(i8, u2, y2);
            if (iA1 > this.f1707E) {
                throw new IllegalArgumentException("Item at position " + i8 + " requires " + iA1 + " spans but GridLayoutManager has only " + this.f1707E + " spans.");
            }
            iZ0 -= iA1;
            if (iZ0 < 0 || (viewB = c0106y.b(u2)) == null) {
                break;
            }
            this.f1709G[i7] = viewB;
            i7++;
        }
        if (i7 == 0) {
            c0105x.f2059b = true;
            return;
        }
        if (z3) {
            i4 = 1;
            i3 = i7;
            i2 = 0;
        } else {
            i2 = i7 - 1;
            i3 = -1;
            i4 = -1;
        }
        int i9 = 0;
        while (i2 != i3) {
            View view = this.f1709G[i2];
            C0102u c0102u = (C0102u) view.getLayoutParams();
            int iA2 = a1(N.C(view), u2, y2);
            c0102u.f2044f = iA2;
            c0102u.f2043e = i9;
            i9 += iA2;
            i2 += i4;
        }
        float f2 = 0.0f;
        int i10 = 0;
        for (int i11 = 0; i11 < i7; i11++) {
            View view2 = this.f1709G[i11];
            if (c0106y.f2071k != null) {
                r8 = 0;
                r8 = 0;
                if (z3) {
                    a(view2, -1, true);
                } else {
                    a(view2, 0, true);
                }
            } else if (z3) {
                r8 = 0;
                a(view2, -1, false);
            } else {
                r8 = 0;
                a(view2, 0, false);
            }
            RecyclerView recyclerView = this.f1742b;
            Rect rect = this.f1713K;
            if (recyclerView == null) {
                rect.set(r8, r8, r8, r8);
            } else {
                rect.set(recyclerView.J(view2));
            }
            b1(view2, iJ, r8);
            int iC = this.f1727q.c(view2);
            if (iC > i10) {
                i10 = iC;
            }
            float fD = (this.f1727q.d(view2) * 1.0f) / ((C0102u) view2.getLayoutParams()).f2044f;
            if (fD > f2) {
                f2 = fD;
            }
        }
        if (z2) {
            V0(Math.max(Math.round(f2 * this.f1707E), i6));
            i10 = 0;
            for (int i12 = 0; i12 < i7; i12++) {
                View view3 = this.f1709G[i12];
                b1(view3, 1073741824, true);
                int iC2 = this.f1727q.c(view3);
                if (iC2 > i10) {
                    i10 = iC2;
                }
            }
        }
        for (int i13 = 0; i13 < i7; i13++) {
            View view4 = this.f1709G[i13];
            if (this.f1727q.c(view4) != i10) {
                C0102u c0102u2 = (C0102u) view4.getLayoutParams();
                Rect rect2 = c0102u2.f1755b;
                int i14 = rect2.top + rect2.bottom + ((ViewGroup.MarginLayoutParams) c0102u2).topMargin + ((ViewGroup.MarginLayoutParams) c0102u2).bottomMargin;
                int i15 = rect2.left + rect2.right + ((ViewGroup.MarginLayoutParams) c0102u2).leftMargin + ((ViewGroup.MarginLayoutParams) c0102u2).rightMargin;
                int iX0 = X0(c0102u2.f2043e, c0102u2.f2044f);
                if (this.f1725o == 1) {
                    iV2 = N.v(iX0, 1073741824, i15, ((ViewGroup.MarginLayoutParams) c0102u2).width, false);
                    iV = View.MeasureSpec.makeMeasureSpec(i10 - i14, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10 - i15, 1073741824);
                    iV = N.v(iX0, 1073741824, i14, ((ViewGroup.MarginLayoutParams) c0102u2).height, false);
                    iV2 = iMakeMeasureSpec;
                }
                if (r0(view4, iV2, iV, (O) view4.getLayoutParams())) {
                    view4.measure(iV2, iV);
                }
            }
        }
        c0105x.f2058a = i10;
        if (this.f1725o != 1) {
            if (c0106y.f2067f == -1) {
                int i16 = c0106y.f2063b;
                iZ = i16 - i10;
                iD = i16;
            } else {
                int i17 = c0106y.f2063b;
                iD = i17 + i10;
                iZ = i17;
            }
            iB = 0;
            iD2 = 0;
        } else if (c0106y.f2067f == -1) {
            iD2 = c0106y.f2063b;
            iB = iD2 - i10;
            iZ = 0;
            iD = 0;
        } else {
            int i18 = c0106y.f2063b;
            iB = i18;
            iD = 0;
            iD2 = i18 + i10;
            iZ = 0;
        }
        for (int i19 = 0; i19 < i7; i19++) {
            View view5 = this.f1709G[i19];
            C0102u c0102u3 = (C0102u) view5.getLayoutParams();
            if (this.f1725o != 1) {
                iB = B() + this.f1708F[c0102u3.f2043e];
                iD2 = this.f1727q.d(view5) + iB;
            } else if (J0()) {
                int iZ2 = z() + this.f1708F[this.f1707E - c0102u3.f2043e];
                iD = iZ2;
                iZ = iZ2 - this.f1727q.d(view5);
            } else {
                iZ = z() + this.f1708F[c0102u3.f2043e];
                iD = this.f1727q.d(view5) + iZ;
            }
            N.I(view5, iZ, iB, iD, iD2);
            if (c0102u3.f1754a.isRemoved() || c0102u3.f1754a.isUpdated()) {
                c0105x.f2060c = true;
            }
            c0105x.f2061d = view5.hasFocusable() | c0105x.f2061d;
        }
        Arrays.fill(this.f1709G, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void L0(U u2, Y y2, C0104w c0104w, int i2) {
        d1();
        if (y2.b() > 0 && !y2.f1880f) {
            boolean z2 = i2 == 1;
            int iZ0 = Z0(c0104w.f2054b, u2, y2);
            if (z2) {
                while (iZ0 > 0) {
                    int i3 = c0104w.f2054b;
                    if (i3 <= 0) {
                        break;
                    }
                    int i4 = i3 - 1;
                    c0104w.f2054b = i4;
                    iZ0 = Z0(i4, u2, y2);
                }
            } else {
                int iB = y2.b() - 1;
                int i5 = c0104w.f2054b;
                while (i5 < iB) {
                    int i6 = i5 + 1;
                    int iZ1 = Z0(i6, u2, y2);
                    if (iZ1 <= iZ0) {
                        break;
                    }
                    i5 = i6;
                    iZ0 = iZ1;
                }
                c0104w.f2054b = i5;
            }
        }
        W0();
    }

    /* JADX WARN: Code duplicated, block: B:81:0x0109  */
    /* JADX WARN: Code duplicated, block: B:82:0x011a  */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00df, code lost:
    
        if (r13 == (r2 > r15)) goto L55;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.N
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View N(android.view.View r23, int r24, androidx.recyclerview.widget.U r25, androidx.recyclerview.widget.Y r26) {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.N(android.view.View, int, androidx.recyclerview.widget.U, androidx.recyclerview.widget.Y):android.view.View");
    }

    @Override // androidx.recyclerview.widget.N
    public final void P(U u2, Y y2, B.m mVar) {
        super.P(u2, y2, mVar);
        mVar.f103a.setClassName("android.widget.GridView");
    }

    @Override // androidx.recyclerview.widget.N
    public final void R(U u2, Y y2, View view, B.m mVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof C0102u)) {
            Q(view, mVar);
            return;
        }
        C0102u c0102u = (C0102u) layoutParams;
        int iY0 = Y0(c0102u.f1754a.getLayoutPosition(), u2, y2);
        int i2 = this.f1725o;
        AccessibilityNodeInfo accessibilityNodeInfo = mVar.f103a;
        if (i2 == 0) {
            accessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(c0102u.f2043e, c0102u.f2044f, iY0, 1, false, false));
        } else {
            accessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(iY0, 1, c0102u.f2043e, c0102u.f2044f, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void R0(boolean z2) {
        if (z2) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.R0(false);
    }

    @Override // androidx.recyclerview.widget.N
    public final void S(int i2, int i3) {
        H.s sVar = this.f1712J;
        sVar.z();
        ((SparseIntArray) sVar.f233c).clear();
    }

    @Override // androidx.recyclerview.widget.N
    public final void T() {
        H.s sVar = this.f1712J;
        sVar.z();
        ((SparseIntArray) sVar.f233c).clear();
    }

    @Override // androidx.recyclerview.widget.N
    public final void U(int i2, int i3) {
        H.s sVar = this.f1712J;
        sVar.z();
        ((SparseIntArray) sVar.f233c).clear();
    }

    @Override // androidx.recyclerview.widget.N
    public final void V(int i2, int i3) {
        H.s sVar = this.f1712J;
        sVar.z();
        ((SparseIntArray) sVar.f233c).clear();
    }

    public final void V0(int i2) {
        int i3;
        int[] iArr = this.f1708F;
        int i4 = this.f1707E;
        if (iArr == null || iArr.length != i4 + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i4 + 1];
        }
        int i5 = 0;
        iArr[0] = 0;
        int i6 = i2 / i4;
        int i7 = i2 % i4;
        int i8 = 0;
        for (int i9 = 1; i9 <= i4; i9++) {
            i5 += i7;
            if (i5 <= 0 || i4 - i5 >= i7) {
                i3 = i6;
            } else {
                i3 = i6 + 1;
                i5 -= i4;
            }
            i8 += i3;
            iArr[i9] = i8;
        }
        this.f1708F = iArr;
    }

    @Override // androidx.recyclerview.widget.N
    public final void W(int i2, int i3) {
        H.s sVar = this.f1712J;
        sVar.z();
        ((SparseIntArray) sVar.f233c).clear();
    }

    public final void W0() {
        View[] viewArr = this.f1709G;
        if (viewArr == null || viewArr.length != this.f1707E) {
            this.f1709G = new View[this.f1707E];
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.N
    public final void X(U u2, Y y2) {
        boolean z2 = y2.f1880f;
        SparseIntArray sparseIntArray = this.f1711I;
        SparseIntArray sparseIntArray2 = this.f1710H;
        if (z2) {
            int iU = u();
            for (int i2 = 0; i2 < iU; i2++) {
                C0102u c0102u = (C0102u) t(i2).getLayoutParams();
                int layoutPosition = c0102u.f1754a.getLayoutPosition();
                sparseIntArray2.put(layoutPosition, c0102u.f2044f);
                sparseIntArray.put(layoutPosition, c0102u.f2043e);
            }
        }
        super.X(u2, y2);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    public final int X0(int i2, int i3) {
        if (this.f1725o != 1 || !J0()) {
            int[] iArr = this.f1708F;
            return iArr[i3 + i2] - iArr[i2];
        }
        int[] iArr2 = this.f1708F;
        int i4 = this.f1707E;
        return iArr2[i4 - i2] - iArr2[(i4 - i2) - i3];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.N
    public final void Y(Y y2) {
        super.Y(y2);
        this.f1706D = false;
    }

    public final int Y0(int i2, U u2, Y y2) {
        boolean z2 = y2.f1880f;
        H.s sVar = this.f1712J;
        if (!z2) {
            int i3 = this.f1707E;
            sVar.getClass();
            return H.s.x(i2, i3);
        }
        int iB = u2.b(i2);
        if (iB != -1) {
            int i4 = this.f1707E;
            sVar.getClass();
            return H.s.x(iB, i4);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i2);
        return 0;
    }

    public final int Z0(int i2, U u2, Y y2) {
        boolean z2 = y2.f1880f;
        H.s sVar = this.f1712J;
        if (!z2) {
            int i3 = this.f1707E;
            sVar.getClass();
            return i2 % i3;
        }
        int i4 = this.f1711I.get(i2, -1);
        if (i4 != -1) {
            return i4;
        }
        int iB = u2.b(i2);
        if (iB != -1) {
            int i5 = this.f1707E;
            sVar.getClass();
            return iB % i5;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
        return 0;
    }

    public final int a1(int i2, U u2, Y y2) {
        boolean z2 = y2.f1880f;
        H.s sVar = this.f1712J;
        if (!z2) {
            sVar.getClass();
            return 1;
        }
        int i3 = this.f1710H.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        if (u2.b(i2) != -1) {
            sVar.getClass();
            return 1;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
        return 1;
    }

    public final void b1(View view, int i2, boolean z2) {
        int iV;
        int iV2;
        C0102u c0102u = (C0102u) view.getLayoutParams();
        Rect rect = c0102u.f1755b;
        int i3 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) c0102u).topMargin + ((ViewGroup.MarginLayoutParams) c0102u).bottomMargin;
        int i4 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) c0102u).leftMargin + ((ViewGroup.MarginLayoutParams) c0102u).rightMargin;
        int iX0 = X0(c0102u.f2043e, c0102u.f2044f);
        if (this.f1725o == 1) {
            iV2 = N.v(iX0, i2, i4, ((ViewGroup.MarginLayoutParams) c0102u).width, false);
            iV = N.v(this.f1727q.l(), this.f1751l, i3, ((ViewGroup.MarginLayoutParams) c0102u).height, true);
        } else {
            int iV3 = N.v(iX0, i2, i3, ((ViewGroup.MarginLayoutParams) c0102u).height, false);
            int iV4 = N.v(this.f1727q.l(), this.f1750k, i4, ((ViewGroup.MarginLayoutParams) c0102u).width, true);
            iV = iV3;
            iV2 = iV4;
        }
        O o2 = (O) view.getLayoutParams();
        if (z2 ? r0(view, iV2, iV, o2) : p0(view, iV2, iV, o2)) {
            view.measure(iV2, iV);
        }
    }

    public final void c1(int i2) {
        if (i2 == this.f1707E) {
            return;
        }
        this.f1706D = true;
        if (i2 < 1) {
            throw new IllegalArgumentException(F0.h.b(i2, "Span count should be at least 1. Provided "));
        }
        this.f1707E = i2;
        this.f1712J.z();
        h0();
    }

    public final void d1() {
        int iY;
        int iB;
        if (this.f1725o == 1) {
            iY = this.f1752m - A();
            iB = z();
        } else {
            iY = this.f1753n - y();
            iB = B();
        }
        V0(iY - iB);
    }

    @Override // androidx.recyclerview.widget.N
    public final boolean e(O o2) {
        return o2 instanceof C0102u;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.N
    public final int i0(int i2, U u2, Y y2) {
        d1();
        W0();
        return super.i0(i2, u2, y2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.N
    public final int j(Y y2) {
        return v0(y2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.N
    public final int j0(int i2, U u2, Y y2) {
        d1();
        W0();
        return super.j0(i2, u2, y2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.N
    public final int k(Y y2) {
        return w0(y2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.N
    public final int m(Y y2) {
        return v0(y2);
    }

    @Override // androidx.recyclerview.widget.N
    public final void m0(Rect rect, int i2, int i3) {
        int iF;
        int iF2;
        if (this.f1708F == null) {
            super.m0(rect, i2, i3);
        }
        int iA = A() + z();
        int iY = y() + B();
        if (this.f1725o == 1) {
            int iHeight = rect.height() + iY;
            RecyclerView recyclerView = this.f1742b;
            WeakHashMap weakHashMap = A.X.f14a;
            iF2 = N.f(i3, iHeight, A.G.d(recyclerView));
            int[] iArr = this.f1708F;
            iF = N.f(i2, iArr[iArr.length - 1] + iA, A.G.e(this.f1742b));
        } else {
            int iWidth = rect.width() + iA;
            RecyclerView recyclerView2 = this.f1742b;
            WeakHashMap weakHashMap2 = A.X.f14a;
            iF = N.f(i2, iWidth, A.G.e(recyclerView2));
            int[] iArr2 = this.f1708F;
            iF2 = N.f(i3, iArr2[iArr2.length - 1] + iY, A.G.d(this.f1742b));
        }
        this.f1742b.setMeasuredDimension(iF, iF2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.N
    public final int n(Y y2) {
        return w0(y2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.N
    public final O q() {
        return this.f1725o == 0 ? new C0102u(-2, -1) : new C0102u(-1, -2);
    }

    @Override // androidx.recyclerview.widget.N
    public final O r(Context context, AttributeSet attributeSet) {
        C0102u c0102u = new C0102u(context, attributeSet);
        c0102u.f2043e = -1;
        c0102u.f2044f = 0;
        return c0102u;
    }

    @Override // androidx.recyclerview.widget.N
    public final O s(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            C0102u c0102u = new C0102u((ViewGroup.MarginLayoutParams) layoutParams);
            c0102u.f2043e = -1;
            c0102u.f2044f = 0;
            return c0102u;
        }
        C0102u c0102u2 = new C0102u(layoutParams);
        c0102u2.f2043e = -1;
        c0102u2.f2044f = 0;
        return c0102u2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.N
    public final boolean s0() {
        return this.f1735y == null && !this.f1706D;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void t0(Y y2, C0106y c0106y, r rVar) {
        int i2;
        int i3 = this.f1707E;
        for (int i4 = 0; i4 < this.f1707E && (i2 = c0106y.f2065d) >= 0 && i2 < y2.b() && i3 > 0; i4++) {
            rVar.a(c0106y.f2065d, Math.max(0, c0106y.g));
            this.f1712J.getClass();
            i3--;
            c0106y.f2065d += c0106y.f2066e;
        }
    }

    @Override // androidx.recyclerview.widget.N
    public final int w(U u2, Y y2) {
        if (this.f1725o == 1) {
            return this.f1707E;
        }
        if (y2.b() < 1) {
            return 0;
        }
        return Y0(y2.b() - 1, u2, y2) + 1;
    }

    public GridLayoutManager() {
        this.f1706D = false;
        this.f1707E = -1;
        this.f1710H = new SparseIntArray();
        this.f1711I = new SparseIntArray();
        this.f1712J = new H.s(6);
        this.f1713K = new Rect();
        c1(2);
    }
}
