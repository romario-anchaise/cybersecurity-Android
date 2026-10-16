// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package D;

import android.icu.text.DecimalFormatSymbols;
import android.text.PrecomputedText;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public abstract class u {
    public static String[] b(DecimalFormatSymbols decimalFormatSymbols) {
        return decimalFormatSymbols.getDigitStrings();
    }

    public static PrecomputedText.Params c(TextView textView) {
        return textView.getTextMetricsParams();
    }

    public static void d(TextView textView, int i2) {
        textView.setFirstBaselineToTopHeight(i2);
    }

    public static CharSequence a(PrecomputedText precomputedText) {
        return precomputedText;
    }
}
