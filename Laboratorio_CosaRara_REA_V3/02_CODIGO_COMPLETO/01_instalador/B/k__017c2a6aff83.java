// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package B;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.time.Duration;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
        accessibilityNodeInfo.getBoundsInWindow(rect);
    }

    public static CharSequence b(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getContainerTitle();
    }

    public static long c(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getMinDurationBetweenContentChanges().toMillis();
    }

    public static boolean d(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
    }

    public static boolean e(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isAccessibilityDataSensitive();
    }

    public static void f(AccessibilityNodeInfo accessibilityNodeInfo, boolean z2) {
        accessibilityNodeInfo.setAccessibilityDataSensitive(z2);
    }

    public static void g(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
        accessibilityNodeInfo.setBoundsInWindow(rect);
    }

    public static void h(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
        accessibilityNodeInfo.setContainerTitle(charSequence);
    }

    public static void i(AccessibilityNodeInfo accessibilityNodeInfo, long j2) {
        accessibilityNodeInfo.setMinDurationBetweenContentChanges(Duration.ofMillis(j2));
    }

    public static void j(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z2) {
        accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z2);
    }

    public static void k(AccessibilityNodeInfo accessibilityNodeInfo, boolean z2) {
        accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z2);
    }
}
