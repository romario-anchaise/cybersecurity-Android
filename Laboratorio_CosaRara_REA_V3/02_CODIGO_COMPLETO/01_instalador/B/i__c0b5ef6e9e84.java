// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package B;

import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static Object a(int i2, float f2, float f3, float f4) {
        return new AccessibilityNodeInfo.RangeInfo(i2, f2, f3, f4);
    }

    public static CharSequence b(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getStateDescription();
    }

    public static void c(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
        accessibilityNodeInfo.setStateDescription(charSequence);
    }
}
