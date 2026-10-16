// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.AccessibilityService;
import android.view.View;
import android.widget.ScrollView;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m9 extends ScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4545a;

    public m9(AccessibilityService accessibilityService, int i3) {
        super(accessibilityService);
        this.f4545a = i3;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i3, int i4) {
        int size = View.MeasureSpec.getSize(i4);
        int iMin = this.f4545a;
        if (size > 0) {
            iMin = Math.min(size, iMin);
        }
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE));
    }
}
