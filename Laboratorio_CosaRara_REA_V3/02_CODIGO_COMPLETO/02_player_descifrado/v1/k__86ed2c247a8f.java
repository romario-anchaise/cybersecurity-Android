// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package v1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k extends j {
    public static Integer v(String str, int i3) {
        boolean z2;
        int i4;
        int i5;
        q2.c.g(i3);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i6 = 0;
        char cCharAt = str.charAt(0);
        int i7 = -2147483647;
        if (q1.e.b(cCharAt, 48) < 0) {
            i4 = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z2 = false;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                i7 = Integer.MIN_VALUE;
                z2 = true;
            }
        } else {
            z2 = false;
            i4 = 0;
        }
        int i8 = -59652323;
        while (i4 < length) {
            int iDigit = Character.digit((int) str.charAt(i4), i3);
            if (iDigit < 0) {
                return null;
            }
            if ((i6 < i8 && (i8 != -59652323 || i6 < (i8 = i7 / i3))) || (i5 = i6 * i3) < i7 + iDigit) {
                return null;
            }
            i6 = i5 - iDigit;
            i4++;
        }
        return z2 ? Integer.valueOf(i6) : Integer.valueOf(-i6);
    }
}
