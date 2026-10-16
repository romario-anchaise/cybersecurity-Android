// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.text.GetChars;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class v5 implements CharSequence, GetChars {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f5295c;

    public v5(CharSequence charSequence) {
        this.f5295c = charSequence;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i3) {
        CharSequence charSequence = this.f5295c;
        if (i3 >= 0 && i3 < charSequence.length()) {
            return (char) 8226;
        }
        StringBuilder sbI = a0.a.i(i3, "index=", " length=");
        sbI.append(charSequence.length());
        throw new IndexOutOfBoundsException(sbI.toString());
    }

    @Override // android.text.GetChars
    public final void getChars(int i3, int i4, char[] cArr, int i5) {
        int length = this.f5295c.length();
        if (i3 < 0 || i4 < i3 || i4 > length) {
            b2.a.h("range=", i3, "..", i4, " length=", length);
        } else {
            Arrays.fill(cArr, i5, (i4 + i5) - i3, (char) 8226);
        }
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f5295c.length();
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i3, int i4) {
        int length = this.f5295c.length();
        if (i3 < 0 || i4 < i3 || i4 > length) {
            b2.a.h("range=", i3, "..", i4, " length=", length);
            return null;
        }
        char[] cArr = new char[i4 - i3];
        Arrays.fill(cArr, (char) 8226);
        return new String(cArr);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        char[] cArr = new char[this.f5295c.length()];
        Arrays.fill(cArr, (char) 8226);
        return new String(cArr);
    }
}
