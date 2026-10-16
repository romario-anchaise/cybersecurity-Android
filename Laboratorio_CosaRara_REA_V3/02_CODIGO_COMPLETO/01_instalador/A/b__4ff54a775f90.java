// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeProvider;

/* JADX INFO: renamed from: A.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0002b {
    public static AccessibilityNodeProvider a(View.AccessibilityDelegate accessibilityDelegate, View view) {
        return accessibilityDelegate.getAccessibilityNodeProvider(view);
    }

    public static boolean b(View.AccessibilityDelegate accessibilityDelegate, View view, int i2, Bundle bundle) {
        return accessibilityDelegate.performAccessibilityAction(view, i2, bundle);
    }
}
