// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package A;

import android.text.PrecomputedText;
import android.text.TextPaint;

/* JADX INFO: renamed from: A.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0010j {
    public static /* synthetic */ PrecomputedText.Params.Builder g(TextPaint textPaint) {
        return new PrecomputedText.Params.Builder(textPaint);
    }

    public static /* bridge */ /* synthetic */ boolean q(CharSequence charSequence) {
        return charSequence instanceof PrecomputedText;
    }
}
