// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p043y;

import A.AbstractC0010j;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f4191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextDirectionHeuristic f4192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f4194d;

    public b(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            AbstractC0010j.g(textPaint).setBreakStrategy(i2).setHyphenationFrequency(i3).setTextDirection(textDirectionHeuristic).build();
        }
        this.f4191a = textPaint;
        this.f4192b = textDirectionHeuristic;
        this.f4193c = i2;
        this.f4194d = i3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f4193c == bVar.f4193c && this.f4194d == bVar.f4194d) {
            TextPaint textPaint = this.f4191a;
            float textSize = textPaint.getTextSize();
            TextPaint textPaint2 = bVar.f4191a;
            return textSize == textPaint2.getTextSize() && textPaint.getTextScaleX() == textPaint2.getTextScaleX() && textPaint.getTextSkewX() == textPaint2.getTextSkewX() && textPaint.getLetterSpacing() == textPaint2.getLetterSpacing() && TextUtils.equals(textPaint.getFontFeatureSettings(), textPaint2.getFontFeatureSettings()) && textPaint.getFlags() == textPaint2.getFlags() && textPaint.getTextLocales().equals(textPaint2.getTextLocales()) && (textPaint.getTypeface() != null ? textPaint.getTypeface().equals(textPaint2.getTypeface()) : textPaint2.getTypeface() == null) && this.f4192b == bVar.f4192b;
        }
        return false;
    }

    public final int hashCode() {
        TextPaint textPaint = this.f4191a;
        return p045z.b.b(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocales(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), this.f4192b, Integer.valueOf(this.f4193c), Integer.valueOf(this.f4194d));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        StringBuilder sb2 = new StringBuilder("textSize=");
        TextPaint textPaint = this.f4191a;
        sb2.append(textPaint.getTextSize());
        sb.append(sb2.toString());
        sb.append(", textScaleX=" + textPaint.getTextScaleX());
        sb.append(", textSkewX=" + textPaint.getTextSkewX());
        int i2 = Build.VERSION.SDK_INT;
        sb.append(", letterSpacing=" + textPaint.getLetterSpacing());
        sb.append(", elegantTextHeight=" + textPaint.isElegantTextHeight());
        sb.append(", textLocale=" + textPaint.getTextLocales());
        sb.append(", typeface=" + textPaint.getTypeface());
        if (i2 >= 26) {
            sb.append(", variationSettings=" + textPaint.getFontVariationSettings());
        }
        sb.append(", textDir=" + this.f4192b);
        sb.append(", breakStrategy=" + this.f4193c);
        sb.append(", hyphenationFrequency=" + this.f4194d);
        sb.append("}");
        return sb.toString();
    }

    public b(PrecomputedText.Params params) {
        this.f4191a = params.getTextPaint();
        this.f4192b = params.getTextDirection();
        this.f4193c = params.getBreakStrategy();
        this.f4194d = params.getHyphenationFrequency();
    }
}
