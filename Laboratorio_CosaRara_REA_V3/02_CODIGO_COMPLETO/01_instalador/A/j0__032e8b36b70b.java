// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public abstract class j0 {
    public static void a(Window window, boolean z2) {
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(z2 ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
    }
}
