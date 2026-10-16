// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import android.text.TextPaint;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f193b = new ThreadLocal();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPaint f194a;

    public e() {
        TextPaint textPaint = new TextPaint();
        this.f194a = textPaint;
        textPaint.setTextSize(10.0f);
    }
}
