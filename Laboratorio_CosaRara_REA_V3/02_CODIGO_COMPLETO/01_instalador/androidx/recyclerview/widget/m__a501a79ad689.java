// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

/* JADX INFO: renamed from: androidx.recyclerview.widget.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0095m extends Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0098p f1994a;

    public C0095m(C0098p c0098p) {
        this.f1994a = c0098p;
    }

    @Override // androidx.recyclerview.widget.Q
    public final void a(RecyclerView recyclerView) {
        int iComputeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
        int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        C0098p c0098p = this.f1994a;
        int iComputeVerticalScrollRange = c0098p.f2019s.computeVerticalScrollRange();
        int i2 = c0098p.f2018r;
        int i3 = iComputeVerticalScrollRange - i2;
        int i4 = c0098p.f2002a;
        c0098p.f2020t = i3 > 0 && i2 >= i4;
        int iComputeHorizontalScrollRange = c0098p.f2019s.computeHorizontalScrollRange();
        int i5 = c0098p.f2017q;
        boolean z2 = iComputeHorizontalScrollRange - i5 > 0 && i5 >= i4;
        c0098p.f2021u = z2;
        boolean z3 = c0098p.f2020t;
        if (!z3 && !z2) {
            if (c0098p.f2022v != 0) {
                c0098p.d(0);
                return;
            }
            return;
        }
        if (z3) {
            float f2 = i2;
            c0098p.f2012l = (int) ((((f2 / 2.0f) + iComputeVerticalScrollOffset) * f2) / iComputeVerticalScrollRange);
            c0098p.f2011k = Math.min(i2, (i2 * i2) / iComputeVerticalScrollRange);
        }
        if (c0098p.f2021u) {
            float f3 = iComputeHorizontalScrollOffset;
            float f4 = i5;
            c0098p.f2015o = (int) ((((f4 / 2.0f) + f3) * f4) / iComputeHorizontalScrollRange);
            c0098p.f2014n = Math.min(i5, (i5 * i5) / iComputeHorizontalScrollRange);
        }
        int i6 = c0098p.f2022v;
        if (i6 == 0 || i6 == 1) {
            c0098p.d(1);
        }
    }
}
