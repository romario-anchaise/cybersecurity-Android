// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package v1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l extends k {
    public static boolean w(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static String x(String str, String str2, String str3) {
        str.getClass();
        int iC = d.C(str, str2, 0, false);
        if (iC < 0) {
            return str;
        }
        int length = str2.length();
        int i3 = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        int i4 = 0;
        do {
            sb.append((CharSequence) str, i4, iC);
            sb.append(str3);
            i4 = iC + length;
            if (iC >= str.length()) {
                break;
            }
            iC = d.C(str, str2, iC + i3, false);
        } while (iC > 0);
        sb.append((CharSequence) str, i4, str.length());
        return sb.toString();
    }

    public static boolean y(String str, String str2, int i3, boolean z2) {
        str.getClass();
        if (!z2) {
            return str.startsWith(str2, i3);
        }
        int length = str2.length();
        return !z2 ? str.regionMatches(i3, str2, 0, length) : str.regionMatches(z2, i3, str2, 0, length);
    }

    public static boolean z(String str, String str2, boolean z2) {
        str.getClass();
        if (!z2) {
            return str.startsWith(str2);
        }
        int length = str2.length();
        return !z2 ? str.regionMatches(0, str2, 0, length) : str.regionMatches(z2, 0, str2, 0, length);
    }
}
