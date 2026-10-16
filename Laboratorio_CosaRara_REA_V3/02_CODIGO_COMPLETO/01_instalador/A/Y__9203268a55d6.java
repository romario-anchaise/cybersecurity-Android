// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public abstract class Y {
    public static float a(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledHorizontalScrollFactor();
    }

    public static float b(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledVerticalScrollFactor();
    }
}
