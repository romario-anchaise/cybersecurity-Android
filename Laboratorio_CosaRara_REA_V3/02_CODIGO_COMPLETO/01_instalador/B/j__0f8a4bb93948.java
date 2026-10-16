// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package B;

import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    public static l a(boolean z2, int i2, int i3, int i4, int i5, boolean z3, String str, String str2) {
        return new l(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z2).setColumnIndex(i2).setRowIndex(i3).setColumnSpan(i4).setRowSpan(i5).setSelected(z3).setRowTitle(str).setColumnTitle(str2).build());
    }

    public static m b(AccessibilityNodeInfo accessibilityNodeInfo, int i2, int i3) {
        AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i2, i3);
        if (child != null) {
            return new m(child, 0);
        }
        return null;
    }

    public static String c(Object obj) {
        return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnTitle();
    }

    public static String d(Object obj) {
        return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowTitle();
    }

    public static AccessibilityNodeInfo.ExtraRenderingInfo e(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getExtraRenderingInfo();
    }

    public static m f(AccessibilityNodeInfo accessibilityNodeInfo, int i2) {
        AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent(i2);
        if (parent != null) {
            return new m(parent, 0);
        }
        return null;
    }

    public static String g(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getUniqueId();
    }

    public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isTextSelectable();
    }

    public static void i(AccessibilityNodeInfo accessibilityNodeInfo, boolean z2) {
        accessibilityNodeInfo.setTextSelectable(z2);
    }

    public static void j(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        accessibilityNodeInfo.setUniqueId(str);
    }
}
