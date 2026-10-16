// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package M0;

/* JADX INFO: loaded from: classes.dex */
public abstract class l extends k {
    public static Integer J(String str) {
        boolean z2;
        int i2;
        int i3;
        f1.l.k(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char cCharAt = str.charAt(0);
        int i5 = -2147483647;
        if (F0.i.f(cCharAt, 48) < 0) {
            i2 = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                i5 = Integer.MIN_VALUE;
                z2 = true;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z2 = false;
            }
        } else {
            z2 = false;
            i2 = 0;
        }
        int i6 = -59652323;
        while (i2 < length) {
            int iDigit = Character.digit((int) str.charAt(i2), 10);
            if (iDigit < 0) {
                return null;
            }
            if ((i4 < i6 && (i6 != -59652323 || i4 < (i6 = i5 / 10))) || (i3 = i4 * 10) < i5 + iDigit) {
                return null;
            }
            i4 = i3 - iDigit;
            i2++;
        }
        return z2 ? Integer.valueOf(i4) : Integer.valueOf(-i4);
    }

    public static Long K(String str) {
        boolean z2;
        F0.i.e(str, "<this>");
        f1.l.k(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char cCharAt = str.charAt(0);
        long j2 = -9223372036854775807L;
        if (F0.i.f(cCharAt, 48) < 0) {
            z2 = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                j2 = Long.MIN_VALUE;
                i2 = 1;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z2 = false;
                i2 = 1;
            }
        } else {
            z2 = false;
        }
        long j3 = -256204778801521550L;
        long j4 = 0;
        long j5 = -256204778801521550L;
        while (i2 < length) {
            int iDigit = Character.digit((int) str.charAt(i2), 10);
            if (iDigit < 0) {
                return null;
            }
            if (j4 < j5) {
                if (j5 != j3) {
                    return null;
                }
                j5 = j2 / ((long) 10);
                if (j4 < j5) {
                    return null;
                }
            }
            long j6 = j4 * ((long) 10);
            long j7 = iDigit;
            if (j6 < j2 + j7) {
                return null;
            }
            j4 = j6 - j7;
            i2++;
            j3 = -256204778801521550L;
        }
        return z2 ? Long.valueOf(j4) : Long.valueOf(-j4);
    }
}
