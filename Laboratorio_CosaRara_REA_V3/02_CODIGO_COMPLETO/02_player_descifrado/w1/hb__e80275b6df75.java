// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class hb implements qd, md {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Rect f4217c;

    public /* synthetic */ hb(Rect rect) {
        this.f4217c = rect;
    }

    @Override // w1.qd
    public AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return ScreenMirrorService.D2(accessibilityNodeInfo, this.f4217c);
    }

    @Override // w1.md
    public boolean d(AccessibilityNodeInfo accessibilityNodeInfo) {
        Rect rect = this.f4217c;
        rd rdVar = ScreenMirrorService.n6;
        try {
            CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
            CharSequence text = accessibilityNodeInfo.getText();
            String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
            String string = null;
            String string2 = contentDescription == null ? null : contentDescription.toString();
            if (text != null) {
                string = text.toString();
            }
            if (!ScreenMirrorService.k3(string2, string, viewIdResourceName)) {
                return false;
            }
            Rect rect2 = new Rect();
            accessibilityNodeInfo.getBoundsInScreen(rect2);
            int iCenterY = rect2.centerY();
            int iMax = Math.max(rect.height(), 1);
            return iCenterY >= rect.top - iMax && iCenterY <= rect.bottom + iMax && rect2.right >= rect.left;
        } catch (Throwable unused) {
            return false;
        }
    }
}
