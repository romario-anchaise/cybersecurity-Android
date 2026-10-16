// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.TextView;

/* JADX INFO: renamed from: j.f0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0145f0 {
    public static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i2, TextView textView, TextPaint textPaint) {
        return new StaticLayout(charSequence, textPaint, i2, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
    }

    public static int b(TextView textView) {
        return textView.getMaxLines();
    }
}
