// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends N {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final C0105x f1722A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final int f1723B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final int[] f1724C;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1725o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public C0106y f1726p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public H.h f1727q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1728r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f1729s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f1730t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f1731u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f1732v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f1733w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1734x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public C0107z f1735y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final C0104w f1736z;

    public LinearLayoutManager() {
        this.f1725o = 1;
        this.f1729s = false;
        this.f1730t = false;
        this.f1731u = false;
        this.f1732v = true;
        this.f1733w = -1;
        this.f1734x = Integer.MIN_VALUE;
        this.f1735y = null;
        this.f1736z = new C0104w();
        this.f1722A = new C0105x();
        this.f1723B = 2;
        this.f1724C = new int[2];
        Q0(1);
        b(null);
        if (this.f1729s) {
            this.f1729s = false;
            h0();
        }
    }

    public final View A0(boolean z2) {
        return this.f1730t ? D0(0, u(), z2) : D0(u() - 1, -1, z2);
    }

    public final View B0(boolean z2) {
        return this.f1730t ? D0(u() - 1, -1, z2) : D0(0, u(), z2);
    }

    public final View C0(int i2, int i3) {
        int i4;
        int i5;
        y0();
        if (i3 <= i2 && i3 >= i2) {
            return t(i2);
        }
        if (this.f1727q.e(t(i2)) < this.f1727q.k()) {
            i4 = 16644;
            i5 = 16388;
        } else {
            i4 = 4161;
            i5 = 4097;
        }
        return this.f1725o == 0 ? this.f1743c.r(i2, i3, i4, i5) : this.f1744d.r(i2, i3, i4, i5);
    }

    public final View D0(int i2, int i3, boolean z2) {
        y0();
        int i4 = z2 ? 24579 : 320;
        return this.f1725o == 0 ? this.f1743c.r(i2, i3, i4, 320) : this.f1744d.r(i2, i3, i4, 320);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0075  */
    /* JADX WARN: Code duplicated, block: B:35:0x0079  */
    public View E0(U u2, Y y2, boolean z2, boolean z3) {
        int i2;
        int iU;
        int i3;
        y0();
        int iU2 = u();
        if (z3) {
            iU = u() - 1;
            i2 = -1;
            i3 = -1;
        } else {
            i2 = iU2;
            iU = 0;
            i3 = 1;
        }
        int iB = y2.b();
        int iK = this.f1727q.k();
        int iG = this.f1727q.g();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (iU != i2) {
            View viewT = t(iU);
            int iC = N.C(viewT);
            int iE = this.f1727q.e(viewT);
            int iB2 = this.f1727q.b(viewT);
            if (iC >= 0 && iC < iB) {
                if (!((O) viewT.getLayoutParams()).f1754a.isRemoved()) {
                    boolean z4 = iB2 <= iK && iE < iK;
                    boolean z5 = iE >= iG && iB2 > iG;
                    if (!z4 && !z5) {
                        return viewT;
                    }
                    if (z2) {
                        if (z5) {
                            view2 = viewT;
                        } else if (view == null) {
                            view = viewT;
                        }
                    } else if (z4) {
                        view2 = viewT;
                    } else if (view == null) {
                        view = viewT;
                    }
                } else if (view3 == null) {
                    view3 = viewT;
                }
            }
            iU += i3;
        }
        if (view != null) {
            return view;
        }
        return view2 != null ? view2 : view3;
    }

    public final int F0(int i2, U u2, Y y2, boolean z2) {
        int iG;
        int iG2 = this.f1727q.g() - i2;
        if (iG2 <= 0) {
            return 0;
        }
        int i3 = -P0(-iG2, u2, y2);
        int i4 = i2 + i3;
        if (!z2 || (iG = this.f1727q.g() - i4) <= 0) {
            return i3;
        }
        this.f1727q.p(iG);
        return iG + i3;
    }

    @Override // androidx.recyclerview.widget.N
    public final boolean G() {
        return true;
    }

    public final int G0(int i2, U u2, Y y2, boolean z2) {
        int iK;
        int iK2 = i2 - this.f1727q.k();
        if (iK2 <= 0) {
            return 0;
        }
        int i3 = -P0(iK2, u2, y2);
        int i4 = i2 + i3;
        if (!z2 || (iK = i4 - this.f1727q.k()) <= 0) {
            return i3;
        }
        this.f1727q.p(-iK);
        return i3 - iK;
    }

    public final View H0() {
        return t(this.f1730t ? 0 : u() - 1);
    }

    public final View I0() {
        return t(this.f1730t ? u() - 1 : 0);
    }

    public final boolean J0() {
        RecyclerView recyclerView = this.f1742b;
        WeakHashMap weakHashMap = A.X.f14a;
        return A.H.d(recyclerView) == 1;
    }

    public void K0(U u2, Y y2, C0106y c0106y, C0105x c0105x) {
        int iZ;
        int i2;
        int i3;
        int iD;
        View viewB = c0106y.b(u2);
        if (viewB == null) {
            c0105x.f2059b = true;
            return;
        }
        O o2 = (O) viewB.getLayoutParams();
        if (c0106y.f2071k == null) {
            if (this.f1730t == (c0106y.f2067f == -1)) {
                a(viewB, -1, false);
            } else {
                a(viewB, 0, false);
            }
        } else {
            if (this.f1730t == (c0106y.f2067f == -1)) {
                a(viewB, -1, true);
            } else {
                a(viewB, 0, true);
            }
        }
        O o3 = (O) viewB.getLayoutParams();
        Rect rectJ = this.f1742b.J(viewB);
        int i4 = rectJ.left + rectJ.right;
        int i5 = rectJ.top + rectJ.bottom;
        int iV = N.v(this.f1752m, this.f1750k, A() + z() + ((ViewGroup.MarginLayoutParams) o3).leftMargin + ((ViewGroup.MarginLayoutParams) o3).rightMargin + i4, ((ViewGroup.MarginLayoutParams) o3).width, c());
        int iV2 = N.v(this.f1753n, this.f1751l, y() + B() + ((ViewGroup.MarginLayoutParams) o3).topMargin + ((ViewGroup.MarginLayoutParams) o3).bottomMargin + i5, ((ViewGroup.MarginLayoutParams) o3).height, d());
        if (p0(viewB, iV, iV2, o3)) {
            viewB.measure(iV, iV2);
        }
        c0105x.f2058a = this.f1727q.c(viewB);
        if (this.f1725o == 1) {
            if (J0()) {
                iD = this.f1752m - A();
                iZ = iD - this.f1727q.d(viewB);
            } else {
                iZ = z();
                iD = this.f1727q.d(viewB) + iZ;
            }
            if (c0106y.f2067f == -1) {
                i2 = c0106y.f2063b;
                i3 = i2 - c0105x.f2058a;
            } else {
                i3 = c0106y.f2063b;
                i2 = c0105x.f2058a + i3;
            }
        } else {
            int iB = B();
            int iD2 = this.f1727q.d(viewB) + iB;
            if (c0106y.f2067f == -1) {
                int i6 = c0106y.f2063b;
                int i7 = i6 - c0105x.f2058a;
                iD = i6;
                i2 = iD2;
                iZ = i7;
                i3 = iB;
            } else {
                int i8 = c0106y.f2063b;
                int i9 = c0105x.f2058a + i8;
                iZ = i8;
                i2 = iD2;
                i3 = iB;
                iD = i9;
            }
        }
        N.I(viewB, iZ, i3, iD, i2);
        if (o2.f1754a.isRemoved() || o2.f1754a.isUpdated()) {
            c0105x.f2060c = true;
        }
        c0105x.f2061d = viewB.hasFocusable();
    }

    public void L0(U u2, Y y2, C0104w c0104w, int i2) {
    }

    public final void M0(U u2, C0106y c0106y) {
        if (!c0106y.f2062a || c0106y.f2072l) {
            return;
        }
        int i2 = c0106y.g;
        int i3 = c0106y.f2069i;
        if (c0106y.f2067f == -1) {
            int iU = u();
            if (i2 < 0) {
                return;
            }
            int iF = (this.f1727q.f() - i2) + i3;
            if (this.f1730t) {
                for (int i4 = 0; i4 < iU; i4++) {
                    View viewT = t(i4);
                    if (this.f1727q.e(viewT) < iF || this.f1727q.o(viewT) < iF) {
                        N0(u2, 0, i4);
                        return;
                    }
                }
                return;
            }
            int i5 = iU - 1;
            for (int i6 = i5; i6 >= 0; i6--) {
                View viewT2 = t(i6);
                if (this.f1727q.e(viewT2) < iF || this.f1727q.o(viewT2) < iF) {
                    N0(u2, i5, i6);
                    return;
                }
            }
            return;
        }
        if (i2 < 0) {
            return;
        }
        int i7 = i2 - i3;
        int iU2 = u();
        if (!this.f1730t) {
            for (int i8 = 0; i8 < iU2; i8++) {
                View viewT3 = t(i8);
                if (this.f1727q.b(viewT3) > i7 || this.f1727q.n(viewT3) > i7) {
                    N0(u2, 0, i8);
                    return;
                }
            }
            return;
        }
        int i9 = iU2 - 1;
        for (int i10 = i9; i10 >= 0; i10--) {
            View viewT4 = t(i10);
            if (this.f1727q.b(viewT4) > i7 || this.f1727q.n(viewT4) > i7) {
                N0(u2, i9, i10);
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.N
    public View N(View view, int i2, U u2, Y y2) {
        int iX0;
        View viewC0;
        O0();
        if (u() == 0 || (iX0 = x0(i2)) == Integer.MIN_VALUE) {
            return null;
        }
        y0();
        S0(iX0, (int) (this.f1727q.l() * 0.33333334f), false, y2);
        C0106y c0106y = this.f1726p;
        c0106y.g = Integer.MIN_VALUE;
        c0106y.f2062a = false;
        z0(u2, c0106y, y2, true);
        if (iX0 == -1) {
            viewC0 = this.f1730t ? C0(u() - 1, -1) : C0(0, u());
        } else {
            viewC0 = this.f1730t ? C0(0, u()) : C0(u() - 1, -1);
        }
        View viewI0 = iX0 == -1 ? I0() : H0();
        if (!viewI0.hasFocusable()) {
            return viewC0;
        }
        if (viewC0 == null) {
            return null;
        }
        return viewI0;
    }

    public final void N0(U u2, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        if (i3 <= i2) {
            while (i2 > i3) {
                View viewT = t(i2);
                f0(i2);
                u2.h(viewT);
                i2--;
            }
            return;
        }
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            View viewT2 = t(i4);
            f0(i4);
            u2.h(viewT2);
        }
    }

    @Override // androidx.recyclerview.widget.N
    public final void O(AccessibilityEvent accessibilityEvent) {
        super.O(accessibilityEvent);
        if (u() > 0) {
            View viewD0 = D0(0, u(), false);
            accessibilityEvent.setFromIndex(viewD0 == null ? -1 : N.C(viewD0));
            View viewD1 = D0(u() - 1, -1, false);
            accessibilityEvent.setToIndex(viewD1 != null ? N.C(viewD1) : -1);
        }
    }

    public final void O0() {
        if (this.f1725o == 1 || !J0()) {
            this.f1730t = this.f1729s;
        } else {
            this.f1730t = !this.f1729s;
        }
    }

    public final int P0(int i2, U u2, Y y2) {
        if (u() == 0 || i2 == 0) {
            return 0;
        }
        y0();
        this.f1726p.f2062a = true;
        int i3 = i2 > 0 ? 1 : -1;
        int iAbs = Math.abs(i2);
        S0(i3, iAbs, true, y2);
        C0106y c0106y = this.f1726p;
        int iZ0 = z0(u2, c0106y, y2, false) + c0106y.g;
        if (iZ0 < 0) {
            return 0;
        }
        if (iAbs > iZ0) {
            i2 = i3 * iZ0;
        }
        this.f1727q.p(-i2);
        this.f1726p.f2070j = i2;
        return i2;
    }

    public final void Q0(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException(F0.h.b(i2, "invalid orientation:"));
        }
        b(null);
        if (i2 != this.f1725o || this.f1727q == null) {
            H.h hVarA = H.h.a(this, i2);
            this.f1727q = hVarA;
            this.f1736z.f2053a = hVarA;
            this.f1725o = i2;
            h0();
        }
    }

    public void R0(boolean z2) {
        b(null);
        if (this.f1731u == z2) {
            return;
        }
        this.f1731u = z2;
        h0();
    }

    public final void S0(int i2, int i3, boolean z2, Y y2) {
        int iK;
        this.f1726p.f2072l = this.f1727q.i() == 0 && this.f1727q.f() == 0;
        this.f1726p.f2067f = i2;
        int[] iArr = this.f1724C;
        iArr[0] = 0;
        iArr[1] = 0;
        y2.getClass();
        int i4 = this.f1726p.f2067f;
        iArr[0] = 0;
        iArr[1] = 0;
        int iMax = Math.max(0, 0);
        int iMax2 = Math.max(0, iArr[1]);
        boolean z3 = i2 == 1;
        C0106y c0106y = this.f1726p;
        int i5 = z3 ? iMax2 : iMax;
        c0106y.f2068h = i5;
        if (!z3) {
            iMax = iMax2;
        }
        c0106y.f2069i = iMax;
        if (z3) {
            c0106y.f2068h = this.f1727q.h() + i5;
            View viewH0 = H0();
            C0106y c0106y2 = this.f1726p;
            c0106y2.f2066e = this.f1730t ? -1 : 1;
            int iC = N.C(viewH0);
            C0106y c0106y3 = this.f1726p;
            c0106y2.f2065d = iC + c0106y3.f2066e;
            c0106y3.f2063b = this.f1727q.b(viewH0);
            iK = this.f1727q.b(viewH0) - this.f1727q.g();
        } else {
            View viewI0 = I0();
            C0106y c0106y4 = this.f1726p;
            c0106y4.f2068h = this.f1727q.k() + c0106y4.f2068h;
            C0106y c0106y5 = this.f1726p;
            c0106y5.f2066e = this.f1730t ? 1 : -1;
            int iC2 = N.C(viewI0);
            C0106y c0106y6 = this.f1726p;
            c0106y5.f2065d = iC2 + c0106y6.f2066e;
            c0106y6.f2063b = this.f1727q.e(viewI0);
            iK = (-this.f1727q.e(viewI0)) + this.f1727q.k();
        }
        C0106y c0106y7 = this.f1726p;
        c0106y7.f2064c = i3;
        if (z2) {
            c0106y7.f2064c = i3 - iK;
        }
        c0106y7.g = iK;
    }

    public final void T0(int i2, int i3) {
        this.f1726p.f2064c = this.f1727q.g() - i3;
        C0106y c0106y = this.f1726p;
        c0106y.f2066e = this.f1730t ? -1 : 1;
        c0106y.f2065d = i2;
        c0106y.f2067f = 1;
        c0106y.f2063b = i3;
        c0106y.g = Integer.MIN_VALUE;
    }

    public final void U0(int i2, int i3) {
        this.f1726p.f2064c = i3 - this.f1727q.k();
        C0106y c0106y = this.f1726p;
        c0106y.f2065d = i2;
        c0106y.f2066e = this.f1730t ? 1 : -1;
        c0106y.f2067f = -1;
        c0106y.f2063b = i3;
        c0106y.g = Integer.MIN_VALUE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:107:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:110:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:114:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:118:0x0208 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:120:0x020c  */
    /* JADX WARN: Code duplicated, block: B:122:0x020f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:124:0x0213  */
    /* JADX WARN: Code duplicated, block: B:126:0x0216 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:127:0x0218  */
    /* JADX WARN: Code duplicated, block: B:129:0x021c  */
    /* JADX WARN: Code duplicated, block: B:131:0x0220  */
    /* JADX WARN: Code duplicated, block: B:133:0x0227  */
    /* JADX WARN: Code duplicated, block: B:134:0x022d  */
    /* JADX WARN: Code duplicated, block: B:91:0x018a  */
    /* JADX WARN: Code duplicated, block: B:93:0x018e  */
    @Override // androidx.recyclerview.widget.N
    public void X(U u2, Y y2) {
        View focusedChild;
        int iB;
        RecyclerView recyclerView;
        View focusedChild2;
        boolean z2;
        boolean z3;
        View viewE0;
        int iE;
        int iB2;
        int iK;
        int iG;
        boolean z4;
        boolean z5;
        O o2;
        int i2;
        int i3;
        int i4;
        List list;
        int i5;
        int i6;
        int iF0;
        int i7;
        View viewP;
        int iE2;
        int iG2;
        int i8;
        int i9 = -1;
        if (!(this.f1735y == null && this.f1733w == -1) && y2.b() == 0) {
            c0(u2);
            return;
        }
        C0107z c0107z = this.f1735y;
        if (c0107z != null && (i8 = c0107z.f2073a) >= 0) {
            this.f1733w = i8;
        }
        y0();
        this.f1726p.f2062a = false;
        O0();
        RecyclerView recyclerView2 = this.f1742b;
        if (recyclerView2 == null || (focusedChild = recyclerView2.getFocusedChild()) == null || this.f1741a.f1908c.contains(focusedChild)) {
            focusedChild = null;
        }
        C0104w c0104w = this.f1736z;
        if (!c0104w.f2057e || this.f1733w != -1 || this.f1735y != null) {
            c0104w.d();
            c0104w.f2056d = this.f1730t ^ this.f1731u;
            if (y2.f1880f || (i2 = this.f1733w) == -1) {
                if (u() != 0) {
                    recyclerView = this.f1742b;
                    if (recyclerView != null || (focusedChild2 = recyclerView.getFocusedChild()) == null || this.f1741a.f1908c.contains(focusedChild2)) {
                        focusedChild2 = null;
                    }
                    if (focusedChild2 != null) {
                        o2 = (O) focusedChild2.getLayoutParams();
                        if (!o2.f1754a.isRemoved() || o2.f1754a.getLayoutPosition() < 0 || o2.f1754a.getLayoutPosition() >= y2.b()) {
                            z2 = this.f1728r;
                            z3 = this.f1731u;
                            if (z2 == z3 || (viewE0 = E0(u2, y2, c0104w.f2056d, z3)) == null) {
                                c0104w.a();
                                if (this.f1731u) {
                                    iB = y2.b() - 1;
                                } else {
                                    iB = 0;
                                }
                                c0104w.f2054b = iB;
                            } else {
                                c0104w.b(viewE0, N.C(viewE0));
                                if (!y2.f1880f && s0()) {
                                    iE = this.f1727q.e(viewE0);
                                    iB2 = this.f1727q.b(viewE0);
                                    iK = this.f1727q.k();
                                    iG = this.f1727q.g();
                                    if (iB2 <= iK || iE >= iK) {
                                        z4 = false;
                                    } else {
                                        z4 = true;
                                    }
                                    if (iE >= iG || iB2 <= iG) {
                                        z5 = false;
                                    } else {
                                        z5 = true;
                                    }
                                    if (z4 || z5) {
                                        if (c0104w.f2056d) {
                                            iK = iG;
                                        }
                                        c0104w.f2055c = iK;
                                    }
                                }
                            }
                        } else {
                            c0104w.c(focusedChild2, N.C(focusedChild2));
                        }
                    } else {
                        z2 = this.f1728r;
                        z3 = this.f1731u;
                        if (z2 == z3) {
                            c0104w.a();
                            if (this.f1731u) {
                                iB = y2.b() - 1;
                            } else {
                                iB = 0;
                            }
                            c0104w.f2054b = iB;
                        } else {
                            c0104w.b(viewE0, N.C(viewE0));
                            if (!y2.f1880f) {
                                iE = this.f1727q.e(viewE0);
                                iB2 = this.f1727q.b(viewE0);
                                iK = this.f1727q.k();
                                iG = this.f1727q.g();
                                if (iB2 <= iK) {
                                    z4 = false;
                                } else {
                                    z4 = false;
                                }
                                if (iE >= iG) {
                                    z5 = false;
                                } else {
                                    z5 = false;
                                }
                                if (z4) {
                                    if (c0104w.f2056d) {
                                        iK = iG;
                                    }
                                    c0104w.f2055c = iK;
                                } else {
                                    if (c0104w.f2056d) {
                                        iK = iG;
                                    }
                                    c0104w.f2055c = iK;
                                }
                            }
                        }
                    }
                } else {
                    c0104w.a();
                    if (this.f1731u) {
                        iB = y2.b() - 1;
                    } else {
                        iB = 0;
                    }
                    c0104w.f2054b = iB;
                }
            } else if (i2 < 0 || i2 >= y2.b()) {
                this.f1733w = -1;
                this.f1734x = Integer.MIN_VALUE;
                if (u() != 0) {
                    recyclerView = this.f1742b;
                    if (recyclerView != null) {
                        focusedChild2 = null;
                    } else {
                        focusedChild2 = null;
                    }
                    if (focusedChild2 != null) {
                        o2 = (O) focusedChild2.getLayoutParams();
                        if (o2.f1754a.isRemoved()) {
                            z2 = this.f1728r;
                            z3 = this.f1731u;
                            if (z2 == z3) {
                                c0104w.a();
                                if (this.f1731u) {
                                    iB = y2.b() - 1;
                                } else {
                                    iB = 0;
                                }
                                c0104w.f2054b = iB;
                            } else {
                                c0104w.b(viewE0, N.C(viewE0));
                                if (!y2.f1880f) {
                                    iE = this.f1727q.e(viewE0);
                                    iB2 = this.f1727q.b(viewE0);
                                    iK = this.f1727q.k();
                                    iG = this.f1727q.g();
                                    if (iB2 <= iK) {
                                        z4 = false;
                                    } else {
                                        z4 = false;
                                    }
                                    if (iE >= iG) {
                                        z5 = false;
                                    } else {
                                        z5 = false;
                                    }
                                    if (z4) {
                                        if (c0104w.f2056d) {
                                            iK = iG;
                                        }
                                        c0104w.f2055c = iK;
                                    } else {
                                        if (c0104w.f2056d) {
                                            iK = iG;
                                        }
                                        c0104w.f2055c = iK;
                                    }
                                }
                            }
                        } else {
                            z2 = this.f1728r;
                            z3 = this.f1731u;
                            if (z2 == z3) {
                                c0104w.a();
                                if (this.f1731u) {
                                    iB = y2.b() - 1;
                                } else {
                                    iB = 0;
                                }
                                c0104w.f2054b = iB;
                            } else {
                                c0104w.b(viewE0, N.C(viewE0));
                                if (!y2.f1880f) {
                                    iE = this.f1727q.e(viewE0);
                                    iB2 = this.f1727q.b(viewE0);
                                    iK = this.f1727q.k();
                                    iG = this.f1727q.g();
                                    if (iB2 <= iK) {
                                        z4 = false;
                                    } else {
                                        z4 = false;
                                    }
                                    if (iE >= iG) {
                                        z5 = false;
                                    } else {
                                        z5 = false;
                                    }
                                    if (z4) {
                                        if (c0104w.f2056d) {
                                            iK = iG;
                                        }
                                        c0104w.f2055c = iK;
                                    } else {
                                        if (c0104w.f2056d) {
                                            iK = iG;
                                        }
                                        c0104w.f2055c = iK;
                                    }
                                }
                            }
                        }
                    } else {
                        z2 = this.f1728r;
                        z3 = this.f1731u;
                        if (z2 == z3) {
                            c0104w.a();
                            if (this.f1731u) {
                                iB = y2.b() - 1;
                            } else {
                                iB = 0;
                            }
                            c0104w.f2054b = iB;
                        } else {
                            c0104w.b(viewE0, N.C(viewE0));
                            if (!y2.f1880f) {
                                iE = this.f1727q.e(viewE0);
                                iB2 = this.f1727q.b(viewE0);
                                iK = this.f1727q.k();
                                iG = this.f1727q.g();
                                if (iB2 <= iK) {
                                    z4 = false;
                                } else {
                                    z4 = false;
                                }
                                if (iE >= iG) {
                                    z5 = false;
                                } else {
                                    z5 = false;
                                }
                                if (z4) {
                                    if (c0104w.f2056d) {
                                        iK = iG;
                                    }
                                    c0104w.f2055c = iK;
                                } else {
                                    if (c0104w.f2056d) {
                                        iK = iG;
                                    }
                                    c0104w.f2055c = iK;
                                }
                            }
                        }
                    }
                } else {
                    c0104w.a();
                    if (this.f1731u) {
                        iB = y2.b() - 1;
                    } else {
                        iB = 0;
                    }
                    c0104w.f2054b = iB;
                }
            } else {
                int i10 = this.f1733w;
                c0104w.f2054b = i10;
                C0107z c0107z2 = this.f1735y;
                if (c0107z2 != null && c0107z2.f2073a >= 0) {
                    boolean z6 = c0107z2.f2075c;
                    c0104w.f2056d = z6;
                    if (z6) {
                        c0104w.f2055c = this.f1727q.g() - this.f1735y.f2074b;
                    } else {
                        c0104w.f2055c = this.f1727q.k() + this.f1735y.f2074b;
                    }
                } else if (this.f1734x == Integer.MIN_VALUE) {
                    View viewP2 = p(i10);
                    if (viewP2 == null) {
                        if (u() > 0) {
                            c0104w.f2056d = (this.f1733w < N.C(t(0))) == this.f1730t;
                        }
                        c0104w.a();
                    } else if (this.f1727q.c(viewP2) > this.f1727q.l()) {
                        c0104w.a();
                    } else if (this.f1727q.e(viewP2) - this.f1727q.k() < 0) {
                        c0104w.f2055c = this.f1727q.k();
                        c0104w.f2056d = false;
                    } else if (this.f1727q.g() - this.f1727q.b(viewP2) < 0) {
                        c0104w.f2055c = this.f1727q.g();
                        c0104w.f2056d = true;
                    } else {
                        c0104w.f2055c = c0104w.f2056d ? this.f1727q.m() + this.f1727q.b(viewP2) : this.f1727q.e(viewP2);
                    }
                } else {
                    boolean z7 = this.f1730t;
                    c0104w.f2056d = z7;
                    if (z7) {
                        c0104w.f2055c = this.f1727q.g() - this.f1734x;
                    } else {
                        c0104w.f2055c = this.f1727q.k() + this.f1734x;
                    }
                }
            }
            c0104w.f2057e = true;
        } else if (focusedChild != null && (this.f1727q.e(focusedChild) >= this.f1727q.g() || this.f1727q.b(focusedChild) <= this.f1727q.k())) {
            c0104w.c(focusedChild, N.C(focusedChild));
        }
        C0106y c0106y = this.f1726p;
        c0106y.f2067f = c0106y.f2070j >= 0 ? 1 : -1;
        int[] iArr = this.f1724C;
        iArr[0] = 0;
        iArr[1] = 0;
        y2.getClass();
        int i11 = this.f1726p.f2067f;
        iArr[0] = 0;
        iArr[1] = 0;
        int iK2 = this.f1727q.k() + Math.max(0, 0);
        int iH = this.f1727q.h() + Math.max(0, iArr[1]);
        if (y2.f1880f && (i7 = this.f1733w) != -1 && this.f1734x != Integer.MIN_VALUE && (viewP = p(i7)) != null) {
            if (this.f1730t) {
                iG2 = this.f1727q.g() - this.f1727q.b(viewP);
                iE2 = this.f1734x;
            } else {
                iE2 = this.f1727q.e(viewP) - this.f1727q.k();
                iG2 = this.f1734x;
            }
            int i12 = iG2 - iE2;
            if (i12 > 0) {
                iK2 += i12;
            } else {
                iH -= i12;
            }
        }
        if (!c0104w.f2056d ? !this.f1730t : this.f1730t) {
            i9 = 1;
        }
        L0(u2, y2, c0104w, i9);
        o(u2);
        this.f1726p.f2072l = this.f1727q.i() == 0 && this.f1727q.f() == 0;
        this.f1726p.getClass();
        this.f1726p.f2069i = 0;
        if (c0104w.f2056d) {
            U0(c0104w.f2054b, c0104w.f2055c);
            C0106y c0106y2 = this.f1726p;
            c0106y2.f2068h = iK2;
            z0(u2, c0106y2, y2, false);
            C0106y c0106y3 = this.f1726p;
            i4 = c0106y3.f2063b;
            int i13 = c0106y3.f2065d;
            int i14 = c0106y3.f2064c;
            if (i14 > 0) {
                iH += i14;
            }
            T0(c0104w.f2054b, c0104w.f2055c);
            C0106y c0106y4 = this.f1726p;
            c0106y4.f2068h = iH;
            c0106y4.f2065d += c0106y4.f2066e;
            z0(u2, c0106y4, y2, false);
            C0106y c0106y5 = this.f1726p;
            i3 = c0106y5.f2063b;
            int i15 = c0106y5.f2064c;
            if (i15 > 0) {
                U0(i13, i4);
                C0106y c0106y6 = this.f1726p;
                c0106y6.f2068h = i15;
                z0(u2, c0106y6, y2, false);
                i4 = this.f1726p.f2063b;
            }
        } else {
            T0(c0104w.f2054b, c0104w.f2055c);
            C0106y c0106y7 = this.f1726p;
            c0106y7.f2068h = iH;
            z0(u2, c0106y7, y2, false);
            C0106y c0106y8 = this.f1726p;
            i3 = c0106y8.f2063b;
            int i16 = c0106y8.f2065d;
            int i17 = c0106y8.f2064c;
            if (i17 > 0) {
                iK2 += i17;
            }
            U0(c0104w.f2054b, c0104w.f2055c);
            C0106y c0106y9 = this.f1726p;
            c0106y9.f2068h = iK2;
            c0106y9.f2065d += c0106y9.f2066e;
            z0(u2, c0106y9, y2, false);
            C0106y c0106y10 = this.f1726p;
            int i18 = c0106y10.f2063b;
            int i19 = c0106y10.f2064c;
            if (i19 > 0) {
                T0(i16, i3);
                C0106y c0106y11 = this.f1726p;
                c0106y11.f2068h = i19;
                z0(u2, c0106y11, y2, false);
                i3 = this.f1726p.f2063b;
            }
            i4 = i18;
        }
        if (u() > 0) {
            if (this.f1730t ^ this.f1731u) {
                int iF1 = F0(i3, u2, y2, true);
                i5 = i4 + iF1;
                i6 = i3 + iF1;
                iF0 = G0(i5, u2, y2, false);
            } else {
                int iG0 = G0(i4, u2, y2, true);
                i5 = i4 + iG0;
                i6 = i3 + iG0;
                iF0 = F0(i6, u2, y2, false);
            }
            i4 = i5 + iF0;
            i3 = i6 + iF0;
        }
        if (y2.f1883j && u() != 0 && !y2.f1880f && s0()) {
            List list2 = u2.f1869d;
            int size = list2.size();
            int iC = N.C(t(0));
            int iC2 = 0;
            int iC3 = 0;
            for (int i20 = 0; i20 < size; i20++) {
                c0 c0Var = (c0) list2.get(i20);
                if (!c0Var.isRemoved()) {
                    if ((c0Var.getLayoutPosition() < iC) != this.f1730t) {
                        iC2 += this.f1727q.c(c0Var.itemView);
                    } else {
                        iC3 += this.f1727q.c(c0Var.itemView);
                    }
                }
            }
            this.f1726p.f2071k = list2;
            if (iC2 > 0) {
                U0(N.C(I0()), i4);
                C0106y c0106y12 = this.f1726p;
                c0106y12.f2068h = iC2;
                c0106y12.f2064c = 0;
                c0106y12.a(null);
                z0(u2, this.f1726p, y2, false);
            }
            if (iC3 > 0) {
                T0(N.C(H0()), i3);
                C0106y c0106y13 = this.f1726p;
                c0106y13.f2068h = iC3;
                c0106y13.f2064c = 0;
                list = null;
                c0106y13.a(null);
                z0(u2, this.f1726p, y2, false);
            } else {
                list = null;
            }
            this.f1726p.f2071k = list;
        }
        if (y2.f1880f) {
            c0104w.d();
        } else {
            H.h hVar = this.f1727q;
            hVar.f199a = hVar.l();
        }
        this.f1728r = this.f1731u;
    }

    @Override // androidx.recyclerview.widget.N
    public void Y(Y y2) {
        this.f1735y = null;
        this.f1733w = -1;
        this.f1734x = Integer.MIN_VALUE;
        this.f1736z.d();
    }

    @Override // androidx.recyclerview.widget.N
    public final void Z(Parcelable parcelable) {
        if (parcelable instanceof C0107z) {
            C0107z c0107z = (C0107z) parcelable;
            this.f1735y = c0107z;
            if (this.f1733w != -1) {
                c0107z.f2073a = -1;
            }
            h0();
        }
    }

    @Override // androidx.recyclerview.widget.N
    public final Parcelable a0() {
        C0107z c0107z = this.f1735y;
        if (c0107z != null) {
            C0107z c0107z2 = new C0107z();
            c0107z2.f2073a = c0107z.f2073a;
            c0107z2.f2074b = c0107z.f2074b;
            c0107z2.f2075c = c0107z.f2075c;
            return c0107z2;
        }
        C0107z c0107z3 = new C0107z();
        if (u() > 0) {
            y0();
            boolean z2 = this.f1728r ^ this.f1730t;
            c0107z3.f2075c = z2;
            if (z2) {
                View viewH0 = H0();
                c0107z3.f2074b = this.f1727q.g() - this.f1727q.b(viewH0);
                c0107z3.f2073a = N.C(viewH0);
            } else {
                View viewI0 = I0();
                c0107z3.f2073a = N.C(viewI0);
                c0107z3.f2074b = this.f1727q.e(viewI0) - this.f1727q.k();
            }
        } else {
            c0107z3.f2073a = -1;
        }
        return c0107z3;
    }

    @Override // androidx.recyclerview.widget.N
    public final void b(String str) {
        RecyclerView recyclerView;
        if (this.f1735y != null || (recyclerView = this.f1742b) == null) {
            return;
        }
        recyclerView.h(str);
    }

    @Override // androidx.recyclerview.widget.N
    public final boolean c() {
        return this.f1725o == 0;
    }

    @Override // androidx.recyclerview.widget.N
    public final boolean d() {
        return this.f1725o == 1;
    }

    @Override // androidx.recyclerview.widget.N
    public final void g(int i2, int i3, Y y2, r rVar) {
        if (this.f1725o != 0) {
            i2 = i3;
        }
        if (u() == 0 || i2 == 0) {
            return;
        }
        y0();
        S0(i2 > 0 ? 1 : -1, Math.abs(i2), true, y2);
        t0(y2, this.f1726p, rVar);
    }

    @Override // androidx.recyclerview.widget.N
    public final void h(int i2, r rVar) {
        boolean z2;
        int i3;
        C0107z c0107z = this.f1735y;
        if (c0107z == null || (i3 = c0107z.f2073a) < 0) {
            O0();
            z2 = this.f1730t;
            i3 = this.f1733w;
            if (i3 == -1) {
                i3 = z2 ? i2 - 1 : 0;
            }
        } else {
            z2 = c0107z.f2075c;
        }
        int i4 = z2 ? -1 : 1;
        for (int i5 = 0; i5 < this.f1723B && i3 >= 0 && i3 < i2; i5++) {
            rVar.a(i3, 0);
            i3 += i4;
        }
    }

    @Override // androidx.recyclerview.widget.N
    public final int i(Y y2) {
        return u0(y2);
    }

    @Override // androidx.recyclerview.widget.N
    public int i0(int i2, U u2, Y y2) {
        if (this.f1725o == 1) {
            return 0;
        }
        return P0(i2, u2, y2);
    }

    @Override // androidx.recyclerview.widget.N
    public int j(Y y2) {
        return v0(y2);
    }

    @Override // androidx.recyclerview.widget.N
    public int j0(int i2, U u2, Y y2) {
        if (this.f1725o == 0) {
            return 0;
        }
        return P0(i2, u2, y2);
    }

    @Override // androidx.recyclerview.widget.N
    public int k(Y y2) {
        return w0(y2);
    }

    @Override // androidx.recyclerview.widget.N
    public final int l(Y y2) {
        return u0(y2);
    }

    @Override // androidx.recyclerview.widget.N
    public int m(Y y2) {
        return v0(y2);
    }

    @Override // androidx.recyclerview.widget.N
    public int n(Y y2) {
        return w0(y2);
    }

    @Override // androidx.recyclerview.widget.N
    public final View p(int i2) {
        int iU = u();
        if (iU == 0) {
            return null;
        }
        int iC = i2 - N.C(t(0));
        if (iC >= 0 && iC < iU) {
            View viewT = t(iC);
            if (N.C(viewT) == i2) {
                return viewT;
            }
        }
        return super.p(i2);
    }

    @Override // androidx.recyclerview.widget.N
    public O q() {
        return new O(-2, -2);
    }

    @Override // androidx.recyclerview.widget.N
    public final boolean q0() {
        if (this.f1751l == 1073741824 || this.f1750k == 1073741824) {
            return false;
        }
        int iU = u();
        for (int i2 = 0; i2 < iU; i2++) {
            ViewGroup.LayoutParams layoutParams = t(i2).getLayoutParams();
            if (layoutParams.width < 0 && layoutParams.height < 0) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.N
    public boolean s0() {
        return this.f1735y == null && this.f1728r == this.f1731u;
    }

    public void t0(Y y2, C0106y c0106y, r rVar) {
        int i2 = c0106y.f2065d;
        if (i2 < 0 || i2 >= y2.b()) {
            return;
        }
        rVar.a(i2, Math.max(0, c0106y.g));
    }

    public final int u0(Y y2) {
        if (u() == 0) {
            return 0;
        }
        y0();
        H.h hVar = this.f1727q;
        boolean z2 = !this.f1732v;
        return f1.l.n(y2, hVar, B0(z2), A0(z2), this, this.f1732v);
    }

    public final int v0(Y y2) {
        if (u() == 0) {
            return 0;
        }
        y0();
        H.h hVar = this.f1727q;
        boolean z2 = !this.f1732v;
        return f1.l.o(y2, hVar, B0(z2), A0(z2), this, this.f1732v, this.f1730t);
    }

    public final int w0(Y y2) {
        if (u() == 0) {
            return 0;
        }
        y0();
        H.h hVar = this.f1727q;
        boolean z2 = !this.f1732v;
        return f1.l.p(y2, hVar, B0(z2), A0(z2), this, this.f1732v);
    }

    public final int x0(int i2) {
        if (i2 == 1) {
            return (this.f1725o != 1 && J0()) ? 1 : -1;
        }
        if (i2 == 2) {
            return (this.f1725o != 1 && J0()) ? -1 : 1;
        }
        if (i2 == 17) {
            return this.f1725o == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i2 == 33) {
            return this.f1725o == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i2 != 66) {
            return (i2 == 130 && this.f1725o == 1) ? 1 : Integer.MIN_VALUE;
        }
        return this.f1725o == 0 ? 1 : Integer.MIN_VALUE;
    }

    public final void y0() {
        if (this.f1726p == null) {
            C0106y c0106y = new C0106y();
            c0106y.f2062a = true;
            c0106y.f2068h = 0;
            c0106y.f2069i = 0;
            c0106y.f2071k = null;
            this.f1726p = c0106y;
        }
    }

    public final int z0(U u2, C0106y c0106y, Y y2, boolean z2) {
        int i2;
        int i3 = c0106y.f2064c;
        int i4 = c0106y.g;
        if (i4 != Integer.MIN_VALUE) {
            if (i3 < 0) {
                c0106y.g = i4 + i3;
            }
            M0(u2, c0106y);
        }
        int i5 = c0106y.f2064c + c0106y.f2068h;
        while (true) {
            if ((!c0106y.f2072l && i5 <= 0) || (i2 = c0106y.f2065d) < 0 || i2 >= y2.b()) {
                break;
            }
            C0105x c0105x = this.f1722A;
            c0105x.f2058a = 0;
            c0105x.f2059b = false;
            c0105x.f2060c = false;
            c0105x.f2061d = false;
            K0(u2, y2, c0106y, c0105x);
            if (!c0105x.f2059b) {
                int i6 = c0106y.f2063b;
                int i7 = c0105x.f2058a;
                c0106y.f2063b = (c0106y.f2067f * i7) + i6;
                if (!c0105x.f2060c || c0106y.f2071k != null || !y2.f1880f) {
                    c0106y.f2064c -= i7;
                    i5 -= i7;
                }
                int i8 = c0106y.g;
                if (i8 != Integer.MIN_VALUE) {
                    int i9 = i8 + i7;
                    c0106y.g = i9;
                    int i10 = c0106y.f2064c;
                    if (i10 < 0) {
                        c0106y.g = i9 + i10;
                    }
                    M0(u2, c0106y);
                }
                if (z2 && c0105x.f2061d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i3 - c0106y.f2064c;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f1725o = 1;
        this.f1729s = false;
        this.f1730t = false;
        this.f1731u = false;
        this.f1732v = true;
        this.f1733w = -1;
        this.f1734x = Integer.MIN_VALUE;
        this.f1735y = null;
        this.f1736z = new C0104w();
        this.f1722A = new C0105x();
        this.f1723B = 2;
        this.f1724C = new int[2];
        M mD = N.D(context, attributeSet, i2, i3);
        Q0(mD.f1737a);
        boolean z2 = mD.f1739c;
        b(null);
        if (z2 != this.f1729s) {
            this.f1729s = z2;
            h0();
        }
        R0(mD.f1740d);
    }

    @Override // androidx.recyclerview.widget.N
    public final void M(RecyclerView recyclerView) {
    }
}
