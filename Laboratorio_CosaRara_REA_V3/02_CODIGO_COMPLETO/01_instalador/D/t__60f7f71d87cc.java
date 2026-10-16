// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package D;

import android.icu.text.DecimalFormatSymbols;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class t {
    public static DecimalFormatSymbols a(Locale locale) {
        return DecimalFormatSymbols.getInstance(locale);
    }
}
