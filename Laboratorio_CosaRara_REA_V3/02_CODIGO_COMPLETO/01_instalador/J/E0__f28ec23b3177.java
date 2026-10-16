// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.graphics.Rect;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes.dex */
public abstract class E0 {
    public static void a(PopupWindow popupWindow, Rect rect) {
        popupWindow.setEpicenterBounds(rect);
    }

    public static void b(PopupWindow popupWindow, boolean z2) {
        popupWindow.setIsClippedToScreen(z2);
    }
}
