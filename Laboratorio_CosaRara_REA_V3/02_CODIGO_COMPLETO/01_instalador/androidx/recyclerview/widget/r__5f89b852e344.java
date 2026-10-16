// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.recyclerview.widget;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f2030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2031d;

    public final void a(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }
        int i4 = this.f2031d;
        int i5 = i4 * 2;
        int[] iArr = this.f2030c;
        if (iArr == null) {
            int[] iArr2 = new int[4];
            this.f2030c = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i5 >= iArr.length) {
            int[] iArr3 = new int[i4 * 4];
            this.f2030c = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        }
        int[] iArr4 = this.f2030c;
        iArr4[i5] = i2;
        iArr4[i5 + 1] = i3;
        this.f2031d++;
    }

    public final void b(RecyclerView recyclerView, boolean z2) {
        this.f2031d = 0;
        int[] iArr = this.f2030c;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        N n2 = recyclerView.f1813n;
        if (recyclerView.f1811m == null || n2 == null || !n2.f1747h) {
            return;
        }
        if (z2) {
            if (!recyclerView.f1796e.j()) {
                n2.h(recyclerView.f1811m.getItemCount(), this);
            }
        } else if (!recyclerView.K()) {
            n2.g(this.f2028a, this.f2029b, recyclerView.f1799f0, this);
        }
        int i2 = this.f2031d;
        if (i2 > n2.f1748i) {
            n2.f1748i = i2;
            n2.f1749j = z2;
            recyclerView.f1792c.m();
        }
    }
}
