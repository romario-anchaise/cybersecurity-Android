// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package B;

import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static int a(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }

    public static void b(AccessibilityEvent accessibilityEvent, int i2) {
        accessibilityEvent.setContentChangeTypes(i2);
    }
}
