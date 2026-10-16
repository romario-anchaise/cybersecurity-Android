// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OverScroller f1899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Interpolator f1900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1902f;
    public final /* synthetic */ RecyclerView g;

    public b0(RecyclerView recyclerView) {
        this.g = recyclerView;
        C c2 = RecyclerView.G0;
        this.f1900d = c2;
        this.f1901e = false;
        this.f1902f = false;
        this.f1899c = new OverScroller(recyclerView.getContext(), c2);
    }

    public final void a(int i2, int i3) {
        RecyclerView recyclerView = this.g;
        recyclerView.setScrollState(2);
        this.f1898b = 0;
        this.f1897a = 0;
        Interpolator interpolator = this.f1900d;
        C c2 = RecyclerView.G0;
        if (interpolator != c2) {
            this.f1900d = c2;
            this.f1899c = new OverScroller(recyclerView.getContext(), c2);
        }
        this.f1899c.fling(0, 0, i2, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.f1901e) {
            this.f1902f = true;
            return;
        }
        recyclerView.removeCallbacks(this);
        WeakHashMap weakHashMap = A.X.f14a;
        A.G.m(recyclerView, this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        RecyclerView recyclerView = this.g;
        if (recyclerView.f1813n == null) {
            recyclerView.removeCallbacks(this);
            this.f1899c.abortAnimation();
            return;
        }
        this.f1902f = false;
        this.f1901e = true;
        recyclerView.m();
        OverScroller overScroller = this.f1899c;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i7 = currX - this.f1897a;
            int i8 = currY - this.f1898b;
            this.f1897a = currX;
            this.f1898b = currY;
            int iL = RecyclerView.l(i7, recyclerView.f1773H, recyclerView.f1775J, recyclerView.getWidth());
            int iL2 = RecyclerView.l(i8, recyclerView.f1774I, recyclerView.f1776K, recyclerView.getHeight());
            int[] iArr = recyclerView.f1822r0;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean zR = recyclerView.r(iL, iL2, 1, iArr, null);
            int[] iArr2 = recyclerView.f1822r0;
            if (zR) {
                iL -= iArr2[0];
                iL2 -= iArr2[1];
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.k(iL, iL2);
            }
            if (recyclerView.f1811m != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
                recyclerView.a0(iL, iL2, iArr2);
                int i9 = iArr2[0];
                int i10 = iArr2[1];
                recyclerView.f1813n.getClass();
                i5 = i9;
                i2 = iL - i9;
                i3 = iL2 - i10;
                i4 = i10;
            } else {
                i2 = iL;
                i3 = iL2;
                i4 = 0;
                i5 = 0;
            }
            if (!recyclerView.f1817p.isEmpty()) {
                recyclerView.invalidate();
            }
            int[] iArr3 = recyclerView.f1822r0;
            iArr3[0] = 0;
            iArr3[1] = 0;
            int i11 = i4;
            recyclerView.s(i5, i4, i2, i3, null, 1, iArr3);
            int i12 = i2 - iArr2[0];
            int i13 = i3 - iArr2[1];
            if (i5 != 0 || i11 != 0) {
                recyclerView.t(i5, i11);
            }
            if (!recyclerView.awakenScrollBars()) {
                recyclerView.invalidate();
            }
            boolean z2 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i12 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i13 != 0));
            recyclerView.f1813n.getClass();
            if (z2) {
                if (recyclerView.getOverScrollMode() != 2) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    if (i12 < 0) {
                        i6 = -currVelocity;
                    } else {
                        i6 = i12 > 0 ? currVelocity : 0;
                    }
                    if (i13 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i13 <= 0) {
                        currVelocity = 0;
                    }
                    if (i6 < 0) {
                        recyclerView.v();
                        if (recyclerView.f1773H.isFinished()) {
                            recyclerView.f1773H.onAbsorb(-i6);
                        }
                    } else if (i6 > 0) {
                        recyclerView.w();
                        if (recyclerView.f1775J.isFinished()) {
                            recyclerView.f1775J.onAbsorb(i6);
                        }
                    }
                    if (currVelocity < 0) {
                        recyclerView.x();
                        if (recyclerView.f1774I.isFinished()) {
                            recyclerView.f1774I.onAbsorb(-currVelocity);
                        }
                    } else if (currVelocity > 0) {
                        recyclerView.u();
                        if (recyclerView.f1776K.isFinished()) {
                            recyclerView.f1776K.onAbsorb(currVelocity);
                        }
                    }
                    if (i6 != 0 || currVelocity != 0) {
                        WeakHashMap weakHashMap = A.X.f14a;
                        A.G.k(recyclerView);
                    }
                }
                if (RecyclerView.f1761E0) {
                    r rVar = recyclerView.f1797e0;
                    int[] iArr4 = rVar.f2030c;
                    if (iArr4 != null) {
                        Arrays.fill(iArr4, -1);
                    }
                    rVar.f2031d = 0;
                }
            } else {
                if (this.f1901e) {
                    this.f1902f = true;
                } else {
                    recyclerView.removeCallbacks(this);
                    WeakHashMap weakHashMap2 = A.X.f14a;
                    A.G.m(recyclerView, this);
                }
                RunnableC0101t runnableC0101t = recyclerView.f1795d0;
                if (runnableC0101t != null) {
                    runnableC0101t.a(recyclerView, i5, i11);
                }
            }
        }
        recyclerView.f1813n.getClass();
        this.f1901e = false;
        if (!this.f1902f) {
            recyclerView.setScrollState(0);
            recyclerView.f0(1);
        } else {
            recyclerView.removeCallbacks(this);
            WeakHashMap weakHashMap3 = A.X.f14a;
            A.G.m(recyclerView, this);
        }
    }
}
