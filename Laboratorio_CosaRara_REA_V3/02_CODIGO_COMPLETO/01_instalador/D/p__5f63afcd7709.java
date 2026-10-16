// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package D;

import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {
    public static boolean a(PopupWindow popupWindow) {
        return popupWindow.getOverlapAnchor();
    }

    public static int b(PopupWindow popupWindow) {
        return popupWindow.getWindowLayoutType();
    }

    public static void c(PopupWindow popupWindow, boolean z2) {
        popupWindow.setOverlapAnchor(z2);
    }

    public static void d(PopupWindow popupWindow, int i2) {
        popupWindow.setWindowLayoutType(i2);
    }
}
