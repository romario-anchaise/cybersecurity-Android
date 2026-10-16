// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class S {
    public static int a(View view) {
        return view.getImportantForContentCapture();
    }

    public static CharSequence b(View view) {
        return view.getStateDescription();
    }

    public static boolean c(View view) {
        return view.isImportantForContentCapture();
    }

    public static void d(View view, int i2) {
        view.setImportantForContentCapture(i2);
    }

    public static void e(View view, CharSequence charSequence) {
        view.setStateDescription(charSequence);
    }
}
