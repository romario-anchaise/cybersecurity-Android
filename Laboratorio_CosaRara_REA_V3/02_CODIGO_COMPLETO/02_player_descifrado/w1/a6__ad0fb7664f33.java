// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f3467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3469c;

    public final void a(int i3, Rect rect, boolean z2) {
        int i4;
        if (c6.k(rect)) {
            long jWidth = ((long) rect.width()) * ((long) rect.height());
            if (this.f3467a != null && i3 <= (i4 = this.f3468b)) {
                if (i3 != i4) {
                    return;
                }
                long j3 = this.f3469c;
                if (z2) {
                    if (jWidth >= j3) {
                        return;
                    }
                } else if (jWidth <= j3) {
                    return;
                }
            }
            this.f3467a = new Rect(rect);
            this.f3468b = i3;
            this.f3469c = jWidth;
        }
    }
}
