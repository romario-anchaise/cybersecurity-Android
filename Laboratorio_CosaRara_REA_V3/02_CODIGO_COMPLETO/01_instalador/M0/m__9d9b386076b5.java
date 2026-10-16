// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package M0;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class m extends l {
    public static boolean L(String str, String str2, boolean z2) {
        F0.i.e(str, "<this>");
        return !z2 ? str.endsWith(str2) : O(str.length() - str2.length(), 0, str2.length(), str, str2, true);
    }

    public static boolean M(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static boolean N(String str) {
        F0.i.e(str, "<this>");
        if (str.length() == 0) {
            return true;
        }
        Iterable cVar = new J0.c(0, str.length() - 1, 1);
        if ((cVar instanceof Collection) && ((Collection) cVar).isEmpty()) {
            return true;
        }
        Iterator it = cVar.iterator();
        while (((J0.b) it).f283c) {
            char cCharAt = str.charAt(((J0.b) it).a());
            if (!Character.isWhitespace(cCharAt) && !Character.isSpaceChar(cCharAt)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean O(int i2, int i3, int i4, String str, String str2, boolean z2) {
        F0.i.e(str, "<this>");
        F0.i.e(str2, "other");
        return !z2 ? str.regionMatches(i2, str2, i3, i4) : str.regionMatches(z2, i2, str2, i3, i4);
    }

    public static String P(String str, String str2, String str3) {
        F0.i.e(str, "<this>");
        int iW = e.W(str, str2, 0, false);
        if (iW < 0) {
            return str;
        }
        int length = str2.length();
        int i2 = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        int i3 = 0;
        do {
            sb.append((CharSequence) str, i3, iW);
            sb.append(str3);
            i3 = iW + length;
            if (iW >= str.length()) {
                break;
            }
            iW = e.W(str, str2, iW + i2, false);
        } while (iW > 0);
        sb.append((CharSequence) str, i3, str.length());
        String string = sb.toString();
        F0.i.d(string, "toString(...)");
        return string;
    }

    public static boolean Q(String str, String str2, int i2, boolean z2) {
        F0.i.e(str, "<this>");
        return !z2 ? str.startsWith(str2, i2) : O(i2, 0, str2.length(), str, str2, z2);
    }

    public static boolean R(String str, String str2, boolean z2) {
        F0.i.e(str, "<this>");
        F0.i.e(str2, "prefix");
        return !z2 ? str.startsWith(str2) : O(0, 0, str2.length(), str, str2, z2);
    }
}
