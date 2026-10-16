// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.transition.Transition;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes.dex */
public abstract class K0 {
    public static void a(PopupWindow popupWindow, Transition transition) {
        popupWindow.setEnterTransition(transition);
    }

    public static void b(PopupWindow popupWindow, Transition transition) {
        popupWindow.setExitTransition(transition);
    }
}
