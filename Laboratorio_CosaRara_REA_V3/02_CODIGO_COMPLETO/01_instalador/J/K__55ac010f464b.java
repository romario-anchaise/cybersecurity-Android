// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.content.res.Resources;
import android.widget.ThemedSpinnerAdapter;
import p045z.b;

/* JADX INFO: loaded from: classes.dex */
public abstract class K {
    public static void a(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
        if (b.a(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
            return;
        }
        themedSpinnerAdapter.setDropDownViewTheme(theme);
    }
}
