// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes.dex */
public final class C implements Spannable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f188a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Spannable f189b;

    public C(Spannable spannable) {
        this.f189b = spannable;
    }

    public final void a() {
        Spannable spannable = this.f189b;
        if (!this.f188a) {
            if ((Build.VERSION.SDK_INT < 28 ? new C0028c(3) : new B(3)).w(spannable)) {
                this.f189b = new SpannableString(spannable);
            }
        }
        this.f188a = true;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i2) {
        return this.f189b.charAt(i2);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return this.f189b.chars();
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return this.f189b.codePoints();
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.f189b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.f189b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.f189b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i2, int i3, Class cls) {
        return this.f189b.getSpans(i2, i3, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f189b.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i2, int i3, Class cls) {
        return this.f189b.nextSpanTransition(i2, i3, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        a();
        this.f189b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i2, int i3, int i4) {
        a();
        this.f189b.setSpan(obj, i2, i3, i4);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i2, int i3) {
        return this.f189b.subSequence(i2, i3);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f189b.toString();
    }

    public C(CharSequence charSequence) {
        this.f189b = new SpannableString(charSequence);
    }
}
