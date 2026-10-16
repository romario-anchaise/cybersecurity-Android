// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package J;

import H.l;
import android.text.InputFilter;
import android.text.Spanned;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public final class d implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f266b;

    public d(TextView textView) {
        this.f265a = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
        TextView textView = this.f265a;
        if (textView.isInEditMode()) {
            return charSequence;
        }
        int iB = l.a().b();
        if (iB != 0) {
            if (iB == 1) {
                if ((i5 == 0 && i4 == 0 && spanned.length() == 0 && charSequence == textView.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i2 != 0 || i3 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i2, i3);
                }
                return l.a().e(charSequence, 0, charSequence.length());
            }
            if (iB != 3) {
                return charSequence;
            }
        }
        l lVarA = l.a();
        if (this.f266b == null) {
            this.f266b = new c(textView, this);
        }
        lVarA.f(this.f266b);
        return charSequence;
    }
}
