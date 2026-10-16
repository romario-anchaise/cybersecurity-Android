// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;
import android.widget.TextView;

/* JADX INFO: renamed from: j.h0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0149h0 {
    public static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3, TextView textView, TextPaint textPaint, AbstractC0155k0 abstractC0155k0) {
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i2);
        StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
        if (i3 == -1) {
            i3 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i3);
        try {
            abstractC0155k0.a(builderObtain, textView);
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return builderObtain.build();
    }
}
