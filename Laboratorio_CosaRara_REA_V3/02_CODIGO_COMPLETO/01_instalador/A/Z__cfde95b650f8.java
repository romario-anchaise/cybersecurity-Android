// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public abstract class Z {
    public static int a(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledHoverSlop();
    }

    public static boolean b(ViewConfiguration viewConfiguration) {
        return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
    }
}
