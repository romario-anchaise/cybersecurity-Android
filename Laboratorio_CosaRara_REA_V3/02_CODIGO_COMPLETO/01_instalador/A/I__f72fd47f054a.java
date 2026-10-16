// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes.dex */
public abstract class I {
    public static int a(View view) {
        return view.getAccessibilityLiveRegion();
    }

    public static boolean b(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean c(View view) {
        return view.isLaidOut();
    }

    public static boolean d(View view) {
        return view.isLayoutDirectionResolved();
    }

    public static void e(ViewParent viewParent, View view, View view2, int i2) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i2);
    }

    public static void f(View view, int i2) {
        view.setAccessibilityLiveRegion(i2);
    }

    public static void g(AccessibilityEvent accessibilityEvent, int i2) {
        accessibilityEvent.setContentChangeTypes(i2);
    }
}
