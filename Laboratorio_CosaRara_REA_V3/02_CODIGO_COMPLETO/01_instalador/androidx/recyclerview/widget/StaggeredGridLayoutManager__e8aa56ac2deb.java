// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends N {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final H.s f1841A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final int f1842B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f1843C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f1844D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public i0 f1845E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final Rect f1846F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final f0 f1847G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public final boolean f1848H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public int[] f1849I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final RunnableC0094l f1850J;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f1851o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final j0[] f1852p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final H.h f1853q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final H.h f1854r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f1855s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f1856t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final C0103v f1857u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f1858v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final BitSet f1860x;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1859w = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f1861y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f1862z = Integer.MIN_VALUE;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f1851o = -1;
        this.f1858v = false;
        H.s sVar = new H.s(7);
        this.f1841A = sVar;
        this.f1842B = 2;
        this.f1846F = new Rect();
        this.f1847G = new f0(this);
        this.f1848H = true;
        this.f1850J = new RunnableC0094l(1, this);
        M mD = N.D(context, attributeSet, i2, i3);
        int i4 = mD.f1737a;
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        b(null);
        if (i4 != this.f1855s) {
            this.f1855s = i4;
            H.h hVar = this.f1853q;
            this.f1853q = this.f1854r;
            this.f1854r = hVar;
            h0();
        }
        int i5 = mD.f1738b;
        b(null);
        if (i5 != this.f1851o) {
            sVar.n();
            h0();
            this.f1851o = i5;
            this.f1860x = new BitSet(this.f1851o);
            this.f1852p = new j0[this.f1851o];
            for (int i6 = 0; i6 < this.f1851o; i6++) {
                this.f1852p[i6] = new j0(this, i6);
            }
            h0();
        }
        boolean z2 = mD.f1739c;
        b(null);
        i0 i0Var = this.f1845E;
        if (i0Var != null && i0Var.f1957h != z2) {
            i0Var.f1957h = z2;
        }
        this.f1858v = z2;
        h0();
        C0103v c0103v = new C0103v();
        c0103v.f2045a = true;
        c0103v.f2050f = 0;
        c0103v.g = 0;
        this.f1857u = c0103v;
        this.f1853q = H.h.a(this, this.f1855s);
        this.f1854r = H.h.a(this, 1 - this.f1855s);
    }

    public static int V0(int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0) {
            return i2;
        }
        int mode = View.MeasureSpec.getMode(i2);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - i3) - i4), mode) : i2;
    }

    public final void A0(U u2, Y y2, boolean z2) {
        int iG;
        int iE0 = E0(Integer.MIN_VALUE);
        if (iE0 != Integer.MIN_VALUE && (iG = this.f1853q.g() - iE0) > 0) {
            int i2 = iG - (-R0(-iG, u2, y2));
            if (!z2 || i2 <= 0) {
                return;
            }
            this.f1853q.p(i2);
        }
    }

    public final void B0(U u2, Y y2, boolean z2) {
        int iK;
        int iF0 = F0(Integer.MAX_VALUE);
        if (iF0 != Integer.MAX_VALUE && (iK = iF0 - this.f1853q.k()) > 0) {
            int iR0 = iK - R0(iK, u2, y2);
            if (!z2 || iR0 <= 0) {
                return;
            }
            this.f1853q.p(-iR0);
        }
    }

    public final int C0() {
        if (u() == 0) {
            return 0;
        }
        return N.C(t(0));
    }

    public final int D0() {
        int iU = u();
        if (iU == 0) {
            return 0;
        }
        return N.C(t(iU - 1));
    }

    public final int E0(int i2) {
        int iH = this.f1852p[0].h(i2);
        for (int i3 = 1; i3 < this.f1851o; i3++) {
            int iH2 = this.f1852p[i3].h(i2);
            if (iH2 > iH) {
                iH = iH2;
            }
        }
        return iH;
    }

    public final int F0(int i2) {
        int iJ = this.f1852p[0].j(i2);
        for (int i3 = 1; i3 < this.f1851o; i3++) {
            int iJ2 = this.f1852p[i3].j(i2);
            if (iJ2 < iJ) {
                iJ = iJ2;
            }
        }
        return iJ;
    }

    @Override // androidx.recyclerview.widget.N
    public final boolean G() {
        return this.f1842B != 0;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0034  */
    /* JADX WARN: Code duplicated, block: B:22:0x0036  */
    /* JADX WARN: Code duplicated, block: B:25:0x003a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0042  */
    /* JADX WARN: Code duplicated, block: B:30:0x0052 A[LOOP:0: B:26:0x0040->B:30:0x0052, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:32:0x0057  */
    /* JADX WARN: Code duplicated, block: B:35:0x0069  */
    /* JADX WARN: Code duplicated, block: B:38:0x0078 A[LOOP:1: B:34:0x0067->B:38:0x0078, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:41:0x007e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0093  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:53:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:55:0x00cc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:64:0x0050 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x007b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x007c A[EDGE_INSN: B:66:0x007c->B:40:0x007c BREAK  A[LOOP:1: B:34:0x0067->B:38:0x0078], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:? A[RETURN, SYNTHETIC] */
    public final void G0(int i2, int i3, int i4) {
        int i5;
        int i6;
        H.s sVar;
        int[] iArr;
        int iD0;
        ArrayList arrayList;
        h0 h0Var;
        int size;
        int i7;
        int i8;
        int size2;
        h0 h0Var2;
        int iD1 = this.f1859w ? D0() : C0();
        if (i4 == 8) {
            if (i2 < i3) {
                i5 = i3 + 1;
            } else {
                i5 = i2 + 1;
                i6 = i3;
            }
            sVar = this.f1841A;
            iArr = (int[]) sVar.f232b;
            if (iArr != null && i6 < iArr.length) {
                arrayList = (ArrayList) sVar.f233c;
                if (arrayList == null) {
                    i8 = -1;
                } else {
                    h0Var = null;
                    if (arrayList != null) {
                        for (size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            h0Var2 = (h0) ((ArrayList) sVar.f233c).get(size2);
                            if (h0Var2.f1941a == i6) {
                                h0Var = h0Var2;
                                break;
                            }
                        }
                    }
                    if (h0Var != null) {
                        ((ArrayList) sVar.f233c).remove(h0Var);
                    }
                    size = ((ArrayList) sVar.f233c).size();
                    i7 = 0;
                    while (true) {
                        if (i7 < size) {
                            i7 = -1;
                            break;
                        } else if (((h0) ((ArrayList) sVar.f233c).get(i7)).f1941a >= i6) {
                            break;
                        } else {
                            i7++;
                        }
                    }
                    if (i7 != -1) {
                        h0 h0Var3 = (h0) ((ArrayList) sVar.f233c).get(i7);
                        ((ArrayList) sVar.f233c).remove(i7);
                        i8 = h0Var3.f1941a;
                    } else {
                        i8 = -1;
                    }
                }
                if (i8 == -1) {
                    int[] iArr2 = (int[]) sVar.f232b;
                    Arrays.fill(iArr2, i6, iArr2.length, -1);
                    int length = ((int[]) sVar.f232b).length;
                } else {
                    Arrays.fill((int[]) sVar.f232b, i6, Math.min(i8 + 1, ((int[]) sVar.f232b).length), -1);
                }
            }
            if (i4 != 1) {
                sVar.B(i2, i3);
            } else if (i4 != 2) {
                sVar.C(i2, i3);
            } else if (i4 == 8) {
                sVar.C(i2, 1);
                sVar.B(i3, 1);
            }
            if (i5 <= iD1) {
                return;
            }
            if (this.f1859w) {
                iD0 = C0();
            } else {
                iD0 = D0();
            }
            if (i6 <= iD0) {
                h0();
            }
        }
        i5 = i2 + i3;
        i6 = i2;
        sVar = this.f1841A;
        iArr = (int[]) sVar.f232b;
        if (iArr != null) {
            arrayList = (ArrayList) sVar.f233c;
            if (arrayList == null) {
                i8 = -1;
            } else {
                h0Var = null;
                if (arrayList != null) {
                    while (size2 >= 0) {
                        h0Var2 = (h0) ((ArrayList) sVar.f233c).get(size2);
                        if (h0Var2.f1941a == i6) {
                            h0Var = h0Var2;
                            break;
                        }
                    }
                }
                if (h0Var != null) {
                    ((ArrayList) sVar.f233c).remove(h0Var);
                }
                size = ((ArrayList) sVar.f233c).size();
                i7 = 0;
                while (true) {
                    if (i7 < size) {
                        i7 = -1;
                        break;
                    } else {
                        if (((h0) ((ArrayList) sVar.f233c).get(i7)).f1941a >= i6) {
                            break;
                            break;
                        }
                        i7++;
                    }
                }
                if (i7 != -1) {
                    h0 h0Var4 = (h0) ((ArrayList) sVar.f233c).get(i7);
                    ((ArrayList) sVar.f233c).remove(i7);
                    i8 = h0Var4.f1941a;
                } else {
                    i8 = -1;
                }
            }
            if (i8 == -1) {
                int[] iArr3 = (int[]) sVar.f232b;
                Arrays.fill(iArr3, i6, iArr3.length, -1);
                int length2 = ((int[]) sVar.f232b).length;
            } else {
                Arrays.fill((int[]) sVar.f232b, i6, Math.min(i8 + 1, ((int[]) sVar.f232b).length), -1);
            }
        }
        if (i4 != 1) {
            sVar.B(i2, i3);
        } else if (i4 != 2) {
            sVar.C(i2, i3);
        } else if (i4 == 8) {
            sVar.C(i2, 1);
            sVar.B(i3, 1);
        }
        if (i5 <= iD1) {
            return;
        }
        if (this.f1859w) {
            iD0 = C0();
        } else {
            iD0 = D0();
        }
        if (i6 <= iD0) {
            h0();
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:53:0x0102  */
    /* JADX WARN: Code duplicated, block: B:54:0x0104  */
    /* JADX WARN: Code duplicated, block: B:67:0x0107 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x002c A[SYNTHETIC] */
    public final View H0() {
        boolean z2;
        boolean z3;
        int iU = u();
        int i2 = iU - 1;
        BitSet bitSet = new BitSet(this.f1851o);
        bitSet.set(0, this.f1851o, true);
        byte b2 = (this.f1855s == 1 && I0()) ? (byte) 1 : (byte) -1;
        if (this.f1859w) {
            iU = -1;
        } else {
            i2 = 0;
        }
        int i3 = i2 < iU ? 1 : -1;
        while (i2 != iU) {
            View viewT = t(i2);
            g0 g0Var = (g0) viewT.getLayoutParams();
            if (bitSet.get(g0Var.f1935e.f1969e)) {
                j0 j0Var = g0Var.f1935e;
                if (this.f1859w) {
                    int i4 = j0Var.f1967c;
                    if (i4 == Integer.MIN_VALUE) {
                        j0Var.a();
                        i4 = j0Var.f1967c;
                    }
                    if (i4 < this.f1853q.g()) {
                        ArrayList arrayList = (ArrayList) j0Var.f1970f;
                        ((g0) ((View) arrayList.get(arrayList.size() - 1)).getLayoutParams()).getClass();
                        return viewT;
                    }
                    bitSet.clear(g0Var.f1935e.f1969e);
                } else {
                    int i5 = j0Var.f1966b;
                    if (i5 == Integer.MIN_VALUE) {
                        View view = (View) ((ArrayList) j0Var.f1970f).get(0);
                        g0 g0Var2 = (g0) view.getLayoutParams();
                        j0Var.f1966b = ((StaggeredGridLayoutManager) j0Var.g).f1853q.e(view);
                        g0Var2.getClass();
                        i5 = j0Var.f1966b;
                    }
                    if (i5 > this.f1853q.k()) {
                        ((g0) ((View) ((ArrayList) j0Var.f1970f).get(0)).getLayoutParams()).getClass();
                        return viewT;
                    }
                    bitSet.clear(g0Var.f1935e.f1969e);
                }
            }
            i2 += i3;
            if (i2 != iU) {
                View viewT2 = t(i2);
                if (this.f1859w) {
                    int iB = this.f1853q.b(viewT);
                    int iB2 = this.f1853q.b(viewT2);
                    if (iB < iB2) {
                        return viewT;
                    }
                    if (iB == iB2) {
                        if (g0Var.f1935e.f1969e - ((g0) viewT2.getLayoutParams()).f1935e.f1969e < 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (b2 < 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z2 != z3) {
                            return viewT;
                        }
                    } else {
                        continue;
                    }
                } else {
                    int iE = this.f1853q.e(viewT);
                    int iE2 = this.f1853q.e(viewT2);
                    if (iE > iE2) {
                        return viewT;
                    }
                    if (iE == iE2) {
                        if (g0Var.f1935e.f1969e - ((g0) viewT2.getLayoutParams()).f1935e.f1969e < 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (b2 < 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z2 != z3) {
                            return viewT;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    public final boolean I0() {
        RecyclerView recyclerView = this.f1742b;
        WeakHashMap weakHashMap = A.X.f14a;
        return A.H.d(recyclerView) == 1;
    }

    @Override // androidx.recyclerview.widget.N
    public final void J(int i2) {
        super.J(i2);
        for (int i3 = 0; i3 < this.f1851o; i3++) {
            j0 j0Var = this.f1852p[i3];
            int i4 = j0Var.f1966b;
            if (i4 != Integer.MIN_VALUE) {
                j0Var.f1966b = i4 + i2;
            }
            int i5 = j0Var.f1967c;
            if (i5 != Integer.MIN_VALUE) {
                j0Var.f1967c = i5 + i2;
            }
        }
    }

    public final void J0(View view, int i2, int i3) {
        RecyclerView recyclerView = this.f1742b;
        Rect rect = this.f1846F;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.J(view));
        }
        g0 g0Var = (g0) view.getLayoutParams();
        int iV0 = V0(i2, ((ViewGroup.MarginLayoutParams) g0Var).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) g0Var).rightMargin + rect.right);
        int iV1 = V0(i3, ((ViewGroup.MarginLayoutParams) g0Var).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) g0Var).bottomMargin + rect.bottom);
        if (p0(view, iV0, iV1, g0Var)) {
            view.measure(iV0, iV1);
        }
    }

    @Override // androidx.recyclerview.widget.N
    public final void K(int i2) {
        super.K(i2);
        for (int i3 = 0; i3 < this.f1851o; i3++) {
            j0 j0Var = this.f1852p[i3];
            int i4 = j0Var.f1966b;
            if (i4 != Integer.MIN_VALUE) {
                j0Var.f1966b = i4 + i2;
            }
            int i5 = j0Var.f1967c;
            if (i5 != Integer.MIN_VALUE) {
                j0Var.f1967c = i5 + i2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:108:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:109:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:123:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:125:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:131:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:133:0x0209  */
    /* JADX WARN: Code duplicated, block: B:255:0x0419  */
    /* JADX WARN: Code duplicated, block: B:266:0x01fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:270:0x01fc A[SYNTHETIC] */
    public final void K0(U u2, Y y2, boolean z2) {
        boolean z3;
        i0 i0Var;
        int iU;
        int i2;
        int iC;
        int iC2;
        int iU2;
        int i3;
        boolean z4;
        i0 i0Var2 = this.f1845E;
        f0 f0Var = this.f1847G;
        if (!(i0Var2 == null && this.f1861y == -1) && y2.b() == 0) {
            c0(u2);
            f0Var.a();
            return;
        }
        boolean z5 = (f0Var.f1927e && this.f1861y == -1 && this.f1845E == null) ? false : true;
        H.s sVar = this.f1841A;
        StaggeredGridLayoutManager staggeredGridLayoutManager = f0Var.g;
        if (z5) {
            f0Var.a();
            i0 i0Var3 = this.f1845E;
            if (i0Var3 != null) {
                int i4 = i0Var3.f1953c;
                if (i4 > 0) {
                    if (i4 == this.f1851o) {
                        for (int i5 = 0; i5 < this.f1851o; i5++) {
                            this.f1852p[i5].b();
                            i0 i0Var4 = this.f1845E;
                            int iG = i0Var4.f1954d[i5];
                            if (iG != Integer.MIN_VALUE) {
                                iG += i0Var4.f1958i ? this.f1853q.g() : this.f1853q.k();
                            }
                            j0 j0Var = this.f1852p[i5];
                            j0Var.f1966b = iG;
                            j0Var.f1967c = iG;
                        }
                    } else {
                        i0Var3.f1954d = null;
                        i0Var3.f1953c = 0;
                        i0Var3.f1955e = 0;
                        i0Var3.f1956f = null;
                        i0Var3.g = null;
                        i0Var3.f1951a = i0Var3.f1952b;
                    }
                }
                i0 i0Var5 = this.f1845E;
                this.f1844D = i0Var5.f1959j;
                boolean z6 = i0Var5.f1957h;
                b(null);
                i0 i0Var6 = this.f1845E;
                if (i0Var6 != null && i0Var6.f1957h != z6) {
                    i0Var6.f1957h = z6;
                }
                this.f1858v = z6;
                h0();
                Q0();
                i0 i0Var7 = this.f1845E;
                int i6 = i0Var7.f1951a;
                if (i6 != -1) {
                    this.f1861y = i6;
                    f0Var.f1925c = i0Var7.f1958i;
                } else {
                    f0Var.f1925c = this.f1859w;
                }
                if (i0Var7.f1955e > 1) {
                    sVar.f232b = i0Var7.f1956f;
                    sVar.f233c = i0Var7.g;
                }
            } else {
                Q0();
                f0Var.f1925c = this.f1859w;
            }
            if (y2.f1880f || (i3 = this.f1861y) == -1) {
                if (this.f1843C) {
                    int iB = y2.b();
                    iU2 = u() - 1;
                    while (true) {
                        if (iU2 < 0) {
                            iC2 = 0;
                            break;
                        }
                        iC2 = N.C(t(iU2));
                        if (iC2 < 0 && iC2 < iB) {
                            break;
                        } else {
                            iU2--;
                        }
                    }
                } else {
                    int iB2 = y2.b();
                    iU = u();
                    i2 = 0;
                    while (true) {
                        if (i2 >= iU) {
                            iC2 = 0;
                            break;
                        }
                        iC = N.C(t(i2));
                        if (iC < 0 && iC < iB2) {
                            iC2 = iC;
                            break;
                        }
                        i2++;
                    }
                }
                f0Var.f1923a = iC2;
                f0Var.f1924b = Integer.MIN_VALUE;
            } else if (i3 < 0 || i3 >= y2.b()) {
                this.f1861y = -1;
                this.f1862z = Integer.MIN_VALUE;
                if (this.f1843C) {
                    int iB3 = y2.b();
                    iU2 = u() - 1;
                    while (true) {
                        if (iU2 < 0) {
                            iC2 = 0;
                            break;
                        } else {
                            iC2 = N.C(t(iU2));
                            if (iC2 < 0) {
                            }
                            iU2--;
                        }
                    }
                } else {
                    int iB4 = y2.b();
                    iU = u();
                    i2 = 0;
                    while (true) {
                        if (i2 >= iU) {
                            iC2 = 0;
                            break;
                        } else {
                            iC = N.C(t(i2));
                            if (iC < 0) {
                            }
                            i2++;
                        }
                    }
                }
                f0Var.f1923a = iC2;
                f0Var.f1924b = Integer.MIN_VALUE;
            } else {
                i0 i0Var8 = this.f1845E;
                if (i0Var8 == null || i0Var8.f1951a == -1 || i0Var8.f1953c < 1) {
                    View viewP = p(this.f1861y);
                    if (viewP != null) {
                        f0Var.f1923a = this.f1859w ? D0() : C0();
                        if (this.f1862z != Integer.MIN_VALUE) {
                            if (f0Var.f1925c) {
                                f0Var.f1924b = (this.f1853q.g() - this.f1862z) - this.f1853q.b(viewP);
                            } else {
                                f0Var.f1924b = (this.f1853q.k() + this.f1862z) - this.f1853q.e(viewP);
                            }
                        } else if (this.f1853q.c(viewP) > this.f1853q.l()) {
                            f0Var.f1924b = f0Var.f1925c ? this.f1853q.g() : this.f1853q.k();
                        } else {
                            int iE = this.f1853q.e(viewP) - this.f1853q.k();
                            if (iE < 0) {
                                f0Var.f1924b = -iE;
                            } else {
                                int iG2 = this.f1853q.g() - this.f1853q.b(viewP);
                                if (iG2 < 0) {
                                    f0Var.f1924b = iG2;
                                } else {
                                    f0Var.f1924b = Integer.MIN_VALUE;
                                }
                            }
                        }
                    } else {
                        int i7 = this.f1861y;
                        f0Var.f1923a = i7;
                        int i8 = this.f1862z;
                        if (i8 == Integer.MIN_VALUE) {
                            if (u() != 0) {
                                if ((i7 < C0()) != this.f1859w) {
                                    z4 = false;
                                } else {
                                    z4 = true;
                                }
                            } else if (this.f1859w) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            f0Var.f1925c = z4;
                            f0Var.f1924b = z4 ? staggeredGridLayoutManager.f1853q.g() : staggeredGridLayoutManager.f1853q.k();
                        } else if (f0Var.f1925c) {
                            f0Var.f1924b = staggeredGridLayoutManager.f1853q.g() - i8;
                        } else {
                            f0Var.f1924b = staggeredGridLayoutManager.f1853q.k() + i8;
                        }
                        f0Var.f1926d = true;
                    }
                } else {
                    f0Var.f1924b = Integer.MIN_VALUE;
                    f0Var.f1923a = this.f1861y;
                }
            }
            f0Var.f1927e = true;
        }
        if (this.f1845E == null && this.f1861y == -1 && (f0Var.f1925c != this.f1843C || I0() != this.f1844D)) {
            sVar.n();
            f0Var.f1926d = true;
        }
        if (u() > 0 && ((i0Var = this.f1845E) == null || i0Var.f1953c < 1)) {
            if (f0Var.f1926d) {
                for (int i9 = 0; i9 < this.f1851o; i9++) {
                    this.f1852p[i9].b();
                    int i10 = f0Var.f1924b;
                    if (i10 != Integer.MIN_VALUE) {
                        j0 j0Var2 = this.f1852p[i9];
                        j0Var2.f1966b = i10;
                        j0Var2.f1967c = i10;
                    }
                }
            } else if (z5 || f0Var.f1928f == null) {
                for (int i11 = 0; i11 < this.f1851o; i11++) {
                    j0 j0Var3 = this.f1852p[i11];
                    boolean z7 = this.f1859w;
                    int i12 = f0Var.f1924b;
                    int iH = z7 ? j0Var3.h(Integer.MIN_VALUE) : j0Var3.j(Integer.MIN_VALUE);
                    j0Var3.b();
                    if (iH != Integer.MIN_VALUE) {
                        StaggeredGridLayoutManager staggeredGridLayoutManager2 = (StaggeredGridLayoutManager) j0Var3.g;
                        if ((!z7 || iH >= staggeredGridLayoutManager2.f1853q.g()) && (z7 || iH <= staggeredGridLayoutManager2.f1853q.k())) {
                            if (i12 != Integer.MIN_VALUE) {
                                iH += i12;
                            }
                            j0Var3.f1967c = iH;
                            j0Var3.f1966b = iH;
                        }
                    }
                }
                j0[] j0VarArr = this.f1852p;
                int length = j0VarArr.length;
                int[] iArr = f0Var.f1928f;
                if (iArr == null || iArr.length < length) {
                    f0Var.f1928f = new int[staggeredGridLayoutManager.f1852p.length];
                }
                for (int i13 = 0; i13 < length; i13++) {
                    f0Var.f1928f[i13] = j0VarArr[i13].j(Integer.MIN_VALUE);
                }
            } else {
                for (int i14 = 0; i14 < this.f1851o; i14++) {
                    j0 j0Var4 = this.f1852p[i14];
                    j0Var4.b();
                    int i15 = f0Var.f1928f[i14];
                    j0Var4.f1966b = i15;
                    j0Var4.f1967c = i15;
                }
            }
        }
        o(u2);
        C0103v c0103v = this.f1857u;
        c0103v.f2045a = false;
        int iL = this.f1854r.l();
        this.f1856t = iL / this.f1851o;
        View.MeasureSpec.makeMeasureSpec(iL, this.f1854r.i());
        T0(f0Var.f1923a);
        if (f0Var.f1925c) {
            S0(-1);
            x0(u2, c0103v, y2);
            S0(1);
            c0103v.f2047c = f0Var.f1923a + c0103v.f2048d;
            x0(u2, c0103v, y2);
        } else {
            S0(1);
            x0(u2, c0103v, y2);
            S0(-1);
            c0103v.f2047c = f0Var.f1923a + c0103v.f2048d;
            x0(u2, c0103v, y2);
        }
        if (this.f1854r.i() != 1073741824) {
            int iU3 = u();
            float fMax = 0.0f;
            for (int i16 = 0; i16 < iU3; i16++) {
                View viewT = t(i16);
                float fC = this.f1854r.c(viewT);
                if (fC >= fMax) {
                    ((g0) viewT.getLayoutParams()).getClass();
                    fMax = Math.max(fMax, fC);
                }
            }
            int i17 = this.f1856t;
            int iRound = Math.round(fMax * this.f1851o);
            if (this.f1854r.i() == Integer.MIN_VALUE) {
                iRound = Math.min(iRound, this.f1854r.l());
            }
            this.f1856t = iRound / this.f1851o;
            View.MeasureSpec.makeMeasureSpec(iRound, this.f1854r.i());
            if (this.f1856t != i17) {
                for (int i18 = 0; i18 < iU3; i18++) {
                    View viewT2 = t(i18);
                    g0 g0Var = (g0) viewT2.getLayoutParams();
                    g0Var.getClass();
                    if (I0() && this.f1855s == 1) {
                        int i19 = -((this.f1851o - 1) - g0Var.f1935e.f1969e);
                        viewT2.offsetLeftAndRight((this.f1856t * i19) - (i19 * i17));
                    } else {
                        int i20 = g0Var.f1935e.f1969e;
                        int i21 = this.f1856t * i20;
                        int i22 = i20 * i17;
                        if (this.f1855s == 1) {
                            viewT2.offsetLeftAndRight(i21 - i22);
                        } else {
                            viewT2.offsetTopAndBottom(i21 - i22);
                        }
                    }
                }
            }
        }
        if (u() > 0) {
            if (this.f1859w) {
                A0(u2, y2, true);
                B0(u2, y2, false);
            } else {
                B0(u2, y2, true);
                A0(u2, y2, false);
            }
        }
        if (z2 && !y2.f1880f && this.f1842B != 0 && u() > 0 && H0() != null) {
            RecyclerView recyclerView = this.f1742b;
            if (recyclerView != null) {
                recyclerView.removeCallbacks(this.f1850J);
            }
            z3 = t0();
        }
        if (y2.f1880f) {
            f0Var.a();
        }
        this.f1843C = f0Var.f1925c;
        this.f1844D = I0();
        if (z3) {
            f0Var.a();
            K0(u2, y2, false);
        }
    }

    @Override // androidx.recyclerview.widget.N
    public final void L() {
        this.f1841A.n();
        for (int i2 = 0; i2 < this.f1851o; i2++) {
            this.f1852p[i2].b();
        }
    }

    public final boolean L0(int i2) {
        if (this.f1855s == 0) {
            return (i2 == -1) != this.f1859w;
        }
        return ((i2 == -1) == this.f1859w) == I0();
    }

    @Override // androidx.recyclerview.widget.N
    public final void M(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f1742b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(this.f1850J);
        }
        for (int i2 = 0; i2 < this.f1851o; i2++) {
            this.f1852p[i2].b();
        }
        recyclerView.requestLayout();
    }

    public final void M0(int i2) {
        int iC0;
        int i3;
        if (i2 > 0) {
            iC0 = D0();
            i3 = 1;
        } else {
            iC0 = C0();
            i3 = -1;
        }
        C0103v c0103v = this.f1857u;
        c0103v.f2045a = true;
        T0(iC0);
        S0(i3);
        c0103v.f2047c = iC0 + c0103v.f2048d;
        c0103v.f2046b = Math.abs(i2);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0059  */
    /* JADX WARN: Code duplicated, block: B:46:0x0061  */
    @Override // androidx.recyclerview.widget.N
    public final View N(View view, int i2, U u2, Y y2) {
        View viewA;
        int i3;
        if (u() == 0) {
            return null;
        }
        RecyclerView recyclerView = this.f1742b;
        if (recyclerView == null || (viewA = recyclerView.A(view)) == null || this.f1741a.f1908c.contains(viewA)) {
            viewA = null;
        }
        if (viewA == null) {
            return null;
        }
        Q0();
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 17) {
                    if (i2 != 33) {
                        if (i2 == 66 ? this.f1855s == 0 : !(i2 != 130 || this.f1855s != 1)) {
                            i3 = 1;
                        }
                    } else if (this.f1855s == 1) {
                        i3 = -1;
                    }
                    i3 = Integer.MIN_VALUE;
                } else if (this.f1855s == 0) {
                    i3 = -1;
                } else {
                    i3 = Integer.MIN_VALUE;
                }
            } else if (this.f1855s != 1 && I0()) {
                i3 = -1;
            } else {
                i3 = 1;
            }
        } else if (this.f1855s != 1 && I0()) {
            i3 = 1;
        } else {
            i3 = -1;
        }
        if (i3 == Integer.MIN_VALUE) {
            return null;
        }
        g0 g0Var = (g0) viewA.getLayoutParams();
        g0Var.getClass();
        j0 j0Var = g0Var.f1935e;
        int iD0 = i3 == 1 ? D0() : C0();
        T0(iD0);
        S0(i3);
        C0103v c0103v = this.f1857u;
        c0103v.f2047c = c0103v.f2048d + iD0;
        c0103v.f2046b = (int) (this.f1853q.l() * 0.33333334f);
        c0103v.f2051h = true;
        c0103v.f2045a = false;
        x0(u2, c0103v, y2);
        this.f1843C = this.f1859w;
        View viewI = j0Var.i(iD0, i3);
        if (viewI != null && viewI != viewA) {
            return viewI;
        }
        if (L0(i3)) {
            for (int i4 = this.f1851o - 1; i4 >= 0; i4--) {
                View viewI2 = this.f1852p[i4].i(iD0, i3);
                if (viewI2 != null && viewI2 != viewA) {
                    return viewI2;
                }
            }
        } else {
            for (int i5 = 0; i5 < this.f1851o; i5++) {
                View viewI3 = this.f1852p[i5].i(iD0, i3);
                if (viewI3 != null && viewI3 != viewA) {
                    return viewI3;
                }
            }
        }
        boolean z2 = (this.f1858v ^ true) == (i3 == -1);
        View viewP = p(z2 ? j0Var.d() : j0Var.e());
        if (viewP != null && viewP != viewA) {
            return viewP;
        }
        if (L0(i3)) {
            for (int i6 = this.f1851o - 1; i6 >= 0; i6--) {
                if (i6 != j0Var.f1969e) {
                    View viewP2 = p(z2 ? this.f1852p[i6].d() : this.f1852p[i6].e());
                    if (viewP2 != null && viewP2 != viewA) {
                        return viewP2;
                    }
                }
            }
        } else {
            for (int i7 = 0; i7 < this.f1851o; i7++) {
                View viewP3 = p(z2 ? this.f1852p[i7].d() : this.f1852p[i7].e());
                if (viewP3 != null && viewP3 != viewA) {
                    return viewP3;
                }
            }
        }
        return null;
    }

    public final void N0(U u2, C0103v c0103v) {
        int iMin;
        if (!c0103v.f2045a || c0103v.f2052i) {
            return;
        }
        if (c0103v.f2046b == 0) {
            if (c0103v.f2049e == -1) {
                O0(u2, c0103v.g);
                return;
            } else {
                P0(u2, c0103v.f2050f);
                return;
            }
        }
        int i2 = 1;
        if (c0103v.f2049e == -1) {
            int i3 = c0103v.f2050f;
            int iJ = this.f1852p[0].j(i3);
            while (i2 < this.f1851o) {
                int iJ2 = this.f1852p[i2].j(i3);
                if (iJ2 > iJ) {
                    iJ = iJ2;
                }
                i2++;
            }
            int i4 = i3 - iJ;
            O0(u2, i4 < 0 ? c0103v.g : c0103v.g - Math.min(i4, c0103v.f2046b));
            return;
        }
        int i5 = c0103v.g;
        int iH = this.f1852p[0].h(i5);
        while (i2 < this.f1851o) {
            int iH2 = this.f1852p[i2].h(i5);
            if (iH2 < iH) {
                iH = iH2;
            }
            i2++;
        }
        int i6 = iH - c0103v.g;
        if (i6 < 0) {
            iMin = c0103v.f2050f;
        } else {
            iMin = Math.min(i6, c0103v.f2046b) + c0103v.f2050f;
        }
        P0(u2, iMin);
    }

    @Override // androidx.recyclerview.widget.N
    public final void O(AccessibilityEvent accessibilityEvent) {
        super.O(accessibilityEvent);
        if (u() > 0) {
            View viewZ0 = z0(false);
            View viewY0 = y0(false);
            if (viewZ0 == null || viewY0 == null) {
                return;
            }
            int iC = N.C(viewZ0);
            int iC2 = N.C(viewY0);
            if (iC < iC2) {
                accessibilityEvent.setFromIndex(iC);
                accessibilityEvent.setToIndex(iC2);
            } else {
                accessibilityEvent.setFromIndex(iC2);
                accessibilityEvent.setToIndex(iC);
            }
        }
    }

    public final void O0(U u2, int i2) {
        for (int iU = u() - 1; iU >= 0; iU--) {
            View viewT = t(iU);
            if (this.f1853q.e(viewT) < i2 || this.f1853q.o(viewT) < i2) {
                return;
            }
            g0 g0Var = (g0) viewT.getLayoutParams();
            g0Var.getClass();
            if (((ArrayList) g0Var.f1935e.f1970f).size() == 1) {
                return;
            }
            j0 j0Var = g0Var.f1935e;
            ArrayList arrayList = (ArrayList) j0Var.f1970f;
            int size = arrayList.size();
            View view = (View) arrayList.remove(size - 1);
            g0 g0Var2 = (g0) view.getLayoutParams();
            g0Var2.f1935e = null;
            if (g0Var2.f1754a.isRemoved() || g0Var2.f1754a.isUpdated()) {
                j0Var.f1968d -= ((StaggeredGridLayoutManager) j0Var.g).f1853q.c(view);
            }
            if (size == 1) {
                j0Var.f1966b = Integer.MIN_VALUE;
            }
            j0Var.f1967c = Integer.MIN_VALUE;
            e0(viewT, u2);
        }
    }

    public final void P0(U u2, int i2) {
        while (u() > 0) {
            View viewT = t(0);
            if (this.f1853q.b(viewT) > i2 || this.f1853q.n(viewT) > i2) {
                return;
            }
            g0 g0Var = (g0) viewT.getLayoutParams();
            g0Var.getClass();
            if (((ArrayList) g0Var.f1935e.f1970f).size() == 1) {
                return;
            }
            j0 j0Var = g0Var.f1935e;
            ArrayList arrayList = (ArrayList) j0Var.f1970f;
            View view = (View) arrayList.remove(0);
            g0 g0Var2 = (g0) view.getLayoutParams();
            g0Var2.f1935e = null;
            if (arrayList.size() == 0) {
                j0Var.f1967c = Integer.MIN_VALUE;
            }
            if (g0Var2.f1754a.isRemoved() || g0Var2.f1754a.isUpdated()) {
                j0Var.f1968d -= ((StaggeredGridLayoutManager) j0Var.g).f1853q.c(view);
            }
            j0Var.f1966b = Integer.MIN_VALUE;
            e0(viewT, u2);
        }
    }

    public final void Q0() {
        if (this.f1855s == 1 || !I0()) {
            this.f1859w = this.f1858v;
        } else {
            this.f1859w = !this.f1858v;
        }
    }

    public final int R0(int i2, U u2, Y y2) {
        if (u() == 0 || i2 == 0) {
            return 0;
        }
        M0(i2);
        C0103v c0103v = this.f1857u;
        int iX0 = x0(u2, c0103v, y2);
        if (c0103v.f2046b >= iX0) {
            i2 = i2 < 0 ? -iX0 : iX0;
        }
        this.f1853q.p(-i2);
        this.f1843C = this.f1859w;
        c0103v.f2046b = 0;
        N0(u2, c0103v);
        return i2;
    }

    @Override // androidx.recyclerview.widget.N
    public final void S(int i2, int i3) {
        G0(i2, i3, 1);
    }

    public final void S0(int i2) {
        C0103v c0103v = this.f1857u;
        c0103v.f2049e = i2;
        c0103v.f2048d = this.f1859w != (i2 == -1) ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.N
    public final void T() {
        this.f1841A.n();
        h0();
    }

    public final void T0(int i2) {
        C0103v c0103v = this.f1857u;
        boolean z2 = false;
        c0103v.f2046b = 0;
        c0103v.f2047c = i2;
        RecyclerView recyclerView = this.f1742b;
        if (recyclerView == null || !recyclerView.f1801h) {
            c0103v.g = this.f1853q.f();
            c0103v.f2050f = 0;
        } else {
            c0103v.f2050f = this.f1853q.k();
            c0103v.g = this.f1853q.g();
        }
        c0103v.f2051h = false;
        c0103v.f2045a = true;
        if (this.f1853q.i() == 0 && this.f1853q.f() == 0) {
            z2 = true;
        }
        c0103v.f2052i = z2;
    }

    @Override // androidx.recyclerview.widget.N
    public final void U(int i2, int i3) {
        G0(i2, i3, 8);
    }

    public final void U0(j0 j0Var, int i2, int i3) {
        int i4 = j0Var.f1968d;
        int i5 = j0Var.f1969e;
        if (i2 != -1) {
            int i6 = j0Var.f1967c;
            if (i6 == Integer.MIN_VALUE) {
                j0Var.a();
                i6 = j0Var.f1967c;
            }
            if (i6 - i4 >= i3) {
                this.f1860x.set(i5, false);
                return;
            }
            return;
        }
        int i7 = j0Var.f1966b;
        if (i7 == Integer.MIN_VALUE) {
            View view = (View) ((ArrayList) j0Var.f1970f).get(0);
            g0 g0Var = (g0) view.getLayoutParams();
            j0Var.f1966b = ((StaggeredGridLayoutManager) j0Var.g).f1853q.e(view);
            g0Var.getClass();
            i7 = j0Var.f1966b;
        }
        if (i7 + i4 <= i3) {
            this.f1860x.set(i5, false);
        }
    }

    @Override // androidx.recyclerview.widget.N
    public final void V(int i2, int i3) {
        G0(i2, i3, 2);
    }

    @Override // androidx.recyclerview.widget.N
    public final void W(int i2, int i3) {
        G0(i2, i3, 4);
    }

    @Override // androidx.recyclerview.widget.N
    public final void X(U u2, Y y2) {
        K0(u2, y2, true);
    }

    @Override // androidx.recyclerview.widget.N
    public final void Y(Y y2) {
        this.f1861y = -1;
        this.f1862z = Integer.MIN_VALUE;
        this.f1845E = null;
        this.f1847G.a();
    }

    @Override // androidx.recyclerview.widget.N
    public final void Z(Parcelable parcelable) {
        if (parcelable instanceof i0) {
            i0 i0Var = (i0) parcelable;
            this.f1845E = i0Var;
            if (this.f1861y != -1) {
                i0Var.f1951a = -1;
                i0Var.f1952b = -1;
                i0Var.f1954d = null;
                i0Var.f1953c = 0;
                i0Var.f1955e = 0;
                i0Var.f1956f = null;
                i0Var.g = null;
            }
            h0();
        }
    }

    @Override // androidx.recyclerview.widget.N
    public final Parcelable a0() {
        int iJ;
        int iK;
        int[] iArr;
        i0 i0Var = this.f1845E;
        if (i0Var != null) {
            i0 i0Var2 = new i0();
            i0Var2.f1953c = i0Var.f1953c;
            i0Var2.f1951a = i0Var.f1951a;
            i0Var2.f1952b = i0Var.f1952b;
            i0Var2.f1954d = i0Var.f1954d;
            i0Var2.f1955e = i0Var.f1955e;
            i0Var2.f1956f = i0Var.f1956f;
            i0Var2.f1957h = i0Var.f1957h;
            i0Var2.f1958i = i0Var.f1958i;
            i0Var2.f1959j = i0Var.f1959j;
            i0Var2.g = i0Var.g;
            return i0Var2;
        }
        i0 i0Var3 = new i0();
        i0Var3.f1957h = this.f1858v;
        i0Var3.f1958i = this.f1843C;
        i0Var3.f1959j = this.f1844D;
        H.s sVar = this.f1841A;
        if (sVar == null || (iArr = (int[]) sVar.f232b) == null) {
            i0Var3.f1955e = 0;
        } else {
            i0Var3.f1956f = iArr;
            i0Var3.f1955e = iArr.length;
            i0Var3.g = (ArrayList) sVar.f233c;
        }
        if (u() > 0) {
            i0Var3.f1951a = this.f1843C ? D0() : C0();
            View viewY0 = this.f1859w ? y0(true) : z0(true);
            i0Var3.f1952b = viewY0 != null ? N.C(viewY0) : -1;
            int i2 = this.f1851o;
            i0Var3.f1953c = i2;
            i0Var3.f1954d = new int[i2];
            for (int i3 = 0; i3 < this.f1851o; i3++) {
                if (this.f1843C) {
                    iJ = this.f1852p[i3].h(Integer.MIN_VALUE);
                    if (iJ != Integer.MIN_VALUE) {
                        iK = this.f1853q.g();
                        iJ -= iK;
                    }
                } else {
                    iJ = this.f1852p[i3].j(Integer.MIN_VALUE);
                    if (iJ != Integer.MIN_VALUE) {
                        iK = this.f1853q.k();
                        iJ -= iK;
                    }
                }
                i0Var3.f1954d[i3] = iJ;
            }
        } else {
            i0Var3.f1951a = -1;
            i0Var3.f1952b = -1;
            i0Var3.f1953c = 0;
        }
        return i0Var3;
    }

    @Override // androidx.recyclerview.widget.N
    public final void b(String str) {
        RecyclerView recyclerView;
        if (this.f1845E != null || (recyclerView = this.f1742b) == null) {
            return;
        }
        recyclerView.h(str);
    }

    @Override // androidx.recyclerview.widget.N
    public final void b0(int i2) {
        if (i2 == 0) {
            t0();
        }
    }

    @Override // androidx.recyclerview.widget.N
    public final boolean c() {
        return this.f1855s == 0;
    }

    @Override // androidx.recyclerview.widget.N
    public final boolean d() {
        return this.f1855s == 1;
    }

    @Override // androidx.recyclerview.widget.N
    public final boolean e(O o2) {
        return o2 instanceof g0;
    }

    @Override // androidx.recyclerview.widget.N
    public final void g(int i2, int i3, Y y2, r rVar) {
        C0103v c0103v;
        int iH;
        int iJ;
        if (this.f1855s != 0) {
            i2 = i3;
        }
        if (u() == 0 || i2 == 0) {
            return;
        }
        M0(i2);
        int[] iArr = this.f1849I;
        if (iArr == null || iArr.length < this.f1851o) {
            this.f1849I = new int[this.f1851o];
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = this.f1851o;
            c0103v = this.f1857u;
            if (i4 >= i6) {
                break;
            }
            if (c0103v.f2048d == -1) {
                iH = c0103v.f2050f;
                iJ = this.f1852p[i4].j(iH);
            } else {
                iH = this.f1852p[i4].h(c0103v.g);
                iJ = c0103v.g;
            }
            int i7 = iH - iJ;
            if (i7 >= 0) {
                this.f1849I[i5] = i7;
                i5++;
            }
            i4++;
        }
        Arrays.sort(this.f1849I, 0, i5);
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = c0103v.f2047c;
            if (i9 < 0 || i9 >= y2.b()) {
                return;
            }
            rVar.a(c0103v.f2047c, this.f1849I[i8]);
            c0103v.f2047c += c0103v.f2048d;
        }
    }

    @Override // androidx.recyclerview.widget.N
    public final int i(Y y2) {
        return u0(y2);
    }

    @Override // androidx.recyclerview.widget.N
    public final int i0(int i2, U u2, Y y2) {
        return R0(i2, u2, y2);
    }

    @Override // androidx.recyclerview.widget.N
    public final int j(Y y2) {
        return v0(y2);
    }

    @Override // androidx.recyclerview.widget.N
    public final int j0(int i2, U u2, Y y2) {
        return R0(i2, u2, y2);
    }

    @Override // androidx.recyclerview.widget.N
    public final int k(Y y2) {
        return w0(y2);
    }

    @Override // androidx.recyclerview.widget.N
    public final int l(Y y2) {
        return u0(y2);
    }

    @Override // androidx.recyclerview.widget.N
    public final int m(Y y2) {
        return v0(y2);
    }

    @Override // androidx.recyclerview.widget.N
    public final void m0(Rect rect, int i2, int i3) {
        int iF;
        int iF2;
        int i4 = this.f1851o;
        int iA = A() + z();
        int iY = y() + B();
        if (this.f1855s == 1) {
            int iHeight = rect.height() + iY;
            RecyclerView recyclerView = this.f1742b;
            WeakHashMap weakHashMap = A.X.f14a;
            iF2 = N.f(i3, iHeight, A.G.d(recyclerView));
            iF = N.f(i2, (this.f1856t * i4) + iA, A.G.e(this.f1742b));
        } else {
            int iWidth = rect.width() + iA;
            RecyclerView recyclerView2 = this.f1742b;
            WeakHashMap weakHashMap2 = A.X.f14a;
            iF = N.f(i2, iWidth, A.G.e(recyclerView2));
            iF2 = N.f(i3, (this.f1856t * i4) + iY, A.G.d(this.f1742b));
        }
        this.f1742b.setMeasuredDimension(iF, iF2);
    }

    @Override // androidx.recyclerview.widget.N
    public final int n(Y y2) {
        return w0(y2);
    }

    @Override // androidx.recyclerview.widget.N
    public final O q() {
        return this.f1855s == 0 ? new g0(-2, -1) : new g0(-1, -2);
    }

    @Override // androidx.recyclerview.widget.N
    public final O r(Context context, AttributeSet attributeSet) {
        return new g0(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.N
    public final O s(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new g0((ViewGroup.MarginLayoutParams) layoutParams) : new g0(layoutParams);
    }

    @Override // androidx.recyclerview.widget.N
    public final boolean s0() {
        return this.f1845E == null;
    }

    public final boolean t0() {
        int iC0;
        if (u() != 0 && this.f1842B != 0 && this.f1746f) {
            if (this.f1859w) {
                iC0 = D0();
                C0();
            } else {
                iC0 = C0();
                D0();
            }
            H.s sVar = this.f1841A;
            if (iC0 == 0 && H0() != null) {
                sVar.n();
                this.f1745e = true;
                h0();
                return true;
            }
        }
        return false;
    }

    public final int u0(Y y2) {
        if (u() == 0) {
            return 0;
        }
        H.h hVar = this.f1853q;
        boolean z2 = !this.f1848H;
        return f1.l.n(y2, hVar, z0(z2), y0(z2), this, this.f1848H);
    }

    public final int v0(Y y2) {
        if (u() == 0) {
            return 0;
        }
        H.h hVar = this.f1853q;
        boolean z2 = !this.f1848H;
        return f1.l.o(y2, hVar, z0(z2), y0(z2), this, this.f1848H, this.f1859w);
    }

    public final int w0(Y y2) {
        if (u() == 0) {
            return 0;
        }
        H.h hVar = this.f1853q;
        boolean z2 = !this.f1848H;
        return f1.l.p(y2, hVar, z0(z2), y0(z2), this, this.f1848H);
    }

    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean, int] */
    public final int x0(U u2, C0103v c0103v, Y y2) {
        j0 j0Var;
        ?? r6;
        int i2;
        int iJ;
        int iC;
        int iK;
        int iC2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        int i8 = 1;
        this.f1860x.set(0, this.f1851o, true);
        C0103v c0103v2 = this.f1857u;
        int i9 = c0103v2.f2052i ? c0103v.f2049e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : c0103v.f2049e == 1 ? c0103v.g + c0103v.f2046b : c0103v.f2050f - c0103v.f2046b;
        int i10 = c0103v.f2049e;
        for (int i11 = 0; i11 < this.f1851o; i11++) {
            if (!((ArrayList) this.f1852p[i11].f1970f).isEmpty()) {
                U0(this.f1852p[i11], i10, i9);
            }
        }
        int iG = this.f1859w ? this.f1853q.g() : this.f1853q.k();
        boolean z2 = false;
        while (true) {
            int i12 = c0103v.f2047c;
            if (((i12 < 0 || i12 >= y2.b()) ? i7 : i8) == 0 || (!c0103v2.f2052i && this.f1860x.isEmpty())) {
                break;
            }
            View view = u2.k(c0103v.f2047c, Long.MAX_VALUE).itemView;
            c0103v.f2047c += c0103v.f2048d;
            g0 g0Var = (g0) view.getLayoutParams();
            int layoutPosition = g0Var.f1754a.getLayoutPosition();
            H.s sVar = this.f1841A;
            int[] iArr = (int[]) sVar.f232b;
            int i13 = (iArr == null || layoutPosition >= iArr.length) ? -1 : iArr[layoutPosition];
            if (i13 == -1) {
                if (L0(c0103v.f2049e)) {
                    i6 = this.f1851o - i8;
                    i5 = -1;
                    i4 = -1;
                } else {
                    i4 = i8;
                    i5 = this.f1851o;
                    i6 = i7;
                }
                j0 j0Var2 = null;
                if (c0103v.f2049e == i8) {
                    int iK2 = this.f1853q.k();
                    int i14 = Integer.MAX_VALUE;
                    while (i6 != i5) {
                        j0 j0Var3 = this.f1852p[i6];
                        int iH = j0Var3.h(iK2);
                        if (iH < i14) {
                            i14 = iH;
                            j0Var2 = j0Var3;
                        }
                        i6 += i4;
                    }
                } else {
                    int iG2 = this.f1853q.g();
                    int i15 = Integer.MIN_VALUE;
                    while (i6 != i5) {
                        j0 j0Var4 = this.f1852p[i6];
                        int iJ2 = j0Var4.j(iG2);
                        if (iJ2 > i15) {
                            j0Var2 = j0Var4;
                            i15 = iJ2;
                        }
                        i6 += i4;
                    }
                }
                j0Var = j0Var2;
                sVar.p(layoutPosition);
                ((int[]) sVar.f232b)[layoutPosition] = j0Var.f1969e;
            } else {
                j0Var = this.f1852p[i13];
            }
            g0Var.f1935e = j0Var;
            if (c0103v.f2049e == 1) {
                r6 = 0;
                a(view, -1, false);
            } else {
                r6 = 0;
                a(view, 0, false);
            }
            if (this.f1855s == 1) {
                i2 = 1;
                J0(view, N.v(this.f1856t, this.f1750k, r6, ((ViewGroup.MarginLayoutParams) g0Var).width, r6), N.v(this.f1753n, this.f1751l, y() + B(), ((ViewGroup.MarginLayoutParams) g0Var).height, true));
            } else {
                i2 = 1;
                J0(view, N.v(this.f1752m, this.f1750k, A() + z(), ((ViewGroup.MarginLayoutParams) g0Var).width, true), N.v(this.f1856t, this.f1751l, 0, ((ViewGroup.MarginLayoutParams) g0Var).height, false));
            }
            if (c0103v.f2049e == i2) {
                iC = j0Var.h(iG);
                iJ = this.f1853q.c(view) + iC;
            } else {
                iJ = j0Var.j(iG);
                iC = iJ - this.f1853q.c(view);
            }
            if (c0103v.f2049e == 1) {
                j0 j0Var5 = g0Var.f1935e;
                j0Var5.getClass();
                g0 g0Var2 = (g0) view.getLayoutParams();
                g0Var2.f1935e = j0Var5;
                ArrayList arrayList = (ArrayList) j0Var5.f1970f;
                arrayList.add(view);
                j0Var5.f1967c = Integer.MIN_VALUE;
                if (arrayList.size() == 1) {
                    j0Var5.f1966b = Integer.MIN_VALUE;
                }
                if (g0Var2.f1754a.isRemoved() || g0Var2.f1754a.isUpdated()) {
                    j0Var5.f1968d = ((StaggeredGridLayoutManager) j0Var5.g).f1853q.c(view) + j0Var5.f1968d;
                }
            } else {
                j0 j0Var6 = g0Var.f1935e;
                j0Var6.getClass();
                g0 g0Var3 = (g0) view.getLayoutParams();
                g0Var3.f1935e = j0Var6;
                ArrayList arrayList2 = (ArrayList) j0Var6.f1970f;
                arrayList2.add(0, view);
                j0Var6.f1966b = Integer.MIN_VALUE;
                if (arrayList2.size() == 1) {
                    j0Var6.f1967c = Integer.MIN_VALUE;
                }
                if (g0Var3.f1754a.isRemoved() || g0Var3.f1754a.isUpdated()) {
                    j0Var6.f1968d = ((StaggeredGridLayoutManager) j0Var6.g).f1853q.c(view) + j0Var6.f1968d;
                }
            }
            if (I0() && this.f1855s == 1) {
                iC2 = this.f1854r.g() - (((this.f1851o - 1) - j0Var.f1969e) * this.f1856t);
                iK = iC2 - this.f1854r.c(view);
            } else {
                iK = this.f1854r.k() + (j0Var.f1969e * this.f1856t);
                iC2 = this.f1854r.c(view) + iK;
            }
            if (this.f1855s == 1) {
                N.I(view, iK, iC, iC2, iJ);
            } else {
                N.I(view, iC, iK, iJ, iC2);
            }
            U0(j0Var, c0103v2.f2049e, i9);
            N0(u2, c0103v2);
            if (c0103v2.f2051h && view.hasFocusable()) {
                i3 = 0;
                this.f1860x.set(j0Var.f1969e, false);
            } else {
                i3 = 0;
            }
            i7 = i3;
            i8 = 1;
            z2 = true;
        }
        int i16 = i7;
        if (!z2) {
            N0(u2, c0103v2);
        }
        int iK3 = c0103v2.f2049e == -1 ? this.f1853q.k() - F0(this.f1853q.k()) : E0(this.f1853q.g()) - this.f1853q.g();
        return iK3 > 0 ? Math.min(c0103v.f2046b, iK3) : i16;
    }

    public final View y0(boolean z2) {
        int iK = this.f1853q.k();
        int iG = this.f1853q.g();
        View view = null;
        for (int iU = u() - 1; iU >= 0; iU--) {
            View viewT = t(iU);
            int iE = this.f1853q.e(viewT);
            int iB = this.f1853q.b(viewT);
            if (iB > iK && iE < iG) {
                if (iB <= iG || !z2) {
                    return viewT;
                }
                if (view == null) {
                    view = viewT;
                }
            }
        }
        return view;
    }

    public final View z0(boolean z2) {
        int iK = this.f1853q.k();
        int iG = this.f1853q.g();
        int iU = u();
        View view = null;
        for (int i2 = 0; i2 < iU; i2++) {
            View viewT = t(i2);
            int iE = this.f1853q.e(viewT);
            if (this.f1853q.b(viewT) > iK && iE < iG) {
                if (iE >= iK || !z2) {
                    return viewT;
                }
                if (view == null) {
                    view = viewT;
                }
            }
        }
        return view;
    }
}
