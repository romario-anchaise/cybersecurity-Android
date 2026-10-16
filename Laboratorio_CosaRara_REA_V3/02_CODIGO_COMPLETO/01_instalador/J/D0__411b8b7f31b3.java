// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes.dex */
public abstract class D0 {
    public static int a(PopupWindow popupWindow, View view, int i2, boolean z2) {
        return popupWindow.getMaxAvailableHeight(view, i2, z2);
    }
}
