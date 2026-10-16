// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package B;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public static l a(int i2, int i3, int i4, int i5, boolean z2) {
        return new l(AccessibilityNodeInfo.CollectionItemInfo.obtain(i2, i3, i4, i5, z2));
    }

    public static Object b(int i2, float f2, float f3, float f4) {
        return AccessibilityNodeInfo.RangeInfo.obtain(i2, f2, f3, f4);
    }

    public static Bundle c(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getExtras();
    }
}
