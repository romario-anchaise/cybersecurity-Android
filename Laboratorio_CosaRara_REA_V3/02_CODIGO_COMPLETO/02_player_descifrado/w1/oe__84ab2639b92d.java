// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class oe implements qd {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4765d;

    public /* synthetic */ oe(int i3, Object obj) {
        this.f4764c = obj;
        this.f4765d = i3;
    }

    @Override // w1.qd
    public AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return ScreenMirrorService.r2(this.f4765d, (Rect) this.f4764c, accessibilityNodeInfo);
    }
}
