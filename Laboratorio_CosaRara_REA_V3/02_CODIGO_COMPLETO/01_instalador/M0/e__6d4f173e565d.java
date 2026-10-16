// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package M0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public abstract class e extends m {
    public static boolean S(CharSequence charSequence, char c2) {
        F0.i.e(charSequence, "<this>");
        return X(charSequence, c2, 0, false, 2) >= 0;
    }

    public static boolean T(CharSequence charSequence, String str) {
        F0.i.e(charSequence, "<this>");
        return Y(charSequence, str, 0, false, 2) >= 0;
    }

    public static boolean U(String str, char c2) {
        return str.length() > 0 && f1.l.v(str.charAt(V(str)), c2, false);
    }

    public static final int V(CharSequence charSequence) {
        F0.i.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int W(CharSequence charSequence, String str, int i2, boolean z2) {
        F0.i.e(charSequence, "<this>");
        F0.i.e(str, "string");
        if (!z2 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i2);
        }
        int length = charSequence.length();
        if (i2 < 0) {
            i2 = 0;
        }
        int length2 = charSequence.length();
        if (length > length2) {
            length = length2;
        }
        J0.c cVar = new J0.c(i2, length, 1);
        boolean z3 = charSequence instanceof String;
        int i3 = cVar.f280c;
        int i4 = cVar.f279b;
        int i5 = cVar.f278a;
        if (!z3 || str == null) {
            if ((i3 > 0 && i5 <= i4) || (i3 < 0 && i4 <= i5)) {
                while (!b0(str, 0, charSequence, i5, str.length(), z2)) {
                    if (i5 != i4) {
                        i5 += i3;
                    }
                }
                return i5;
            }
            return -1;
        }
        if ((i3 > 0 && i5 <= i4) || (i3 < 0 && i4 <= i5)) {
            while (!m.O(0, i5, str.length(), str, (String) charSequence, z2)) {
                if (i5 != i4) {
                    i5 += i3;
                }
            }
            return i5;
        }
        return -1;
    }

    public static int X(CharSequence charSequence, char c2, int i2, boolean z2, int i3) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        F0.i.e(charSequence, "<this>");
        return (z2 || !(charSequence instanceof String)) ? Z(charSequence, new char[]{c2}, i2, z2) : ((String) charSequence).indexOf(c2, i2);
    }

    public static /* synthetic */ int Y(CharSequence charSequence, String str, int i2, boolean z2, int i3) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return W(charSequence, str, i2, z2);
    }

    public static final int Z(CharSequence charSequence, char[] cArr, int i2, boolean z2) {
        int i3;
        F0.i.e(charSequence, "<this>");
        boolean z3 = true;
        if (!z2 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(p036u0.e.y(cArr), i2);
        }
        if (i2 < 0) {
            i2 = 0;
        }
        J0.c cVar = new J0.c(i2, V(charSequence), 1);
        int i4 = cVar.f280c;
        int i5 = cVar.f279b;
        if (i4 <= 0 ? i2 < i5 : i2 > i5) {
            z3 = false;
        }
        if (!z3) {
            i2 = i5;
        }
        while (z3) {
            if (i2 != i5) {
                i3 = i2 + i4;
            } else {
                if (!z3) {
                    throw new NoSuchElementException();
                }
                i3 = i2;
                z3 = false;
            }
            char cCharAt = charSequence.charAt(i2);
            for (char c2 : cArr) {
                if (f1.l.v(c2, cCharAt, z2)) {
                    return i2;
                }
            }
            i2 = i3;
        }
        return -1;
    }

    public static int a0(CharSequence charSequence, char c2, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i2 = V(charSequence);
        }
        F0.i.e(charSequence, "<this>");
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(c2, i2);
        }
        char[] cArr = {c2};
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(p036u0.e.y(cArr), i2);
        }
        int iV = V(charSequence);
        if (i2 > iV) {
            i2 = iV;
        }
        while (-1 < i2) {
            if (f1.l.v(cArr[0], charSequence.charAt(i2), false)) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static final boolean b0(String str, int i2, CharSequence charSequence, int i3, int i4, boolean z2) {
        F0.i.e(str, "<this>");
        F0.i.e(charSequence, "other");
        if (i3 < 0 || i2 < 0 || i2 > str.length() - i4 || i3 > charSequence.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!f1.l.v(str.charAt(i2 + i5), charSequence.charAt(i3 + i5), z2)) {
                return false;
            }
        }
        return true;
    }

    public static String c0(String str, String str2) {
        if (!m.R(str, str2, false)) {
            return str;
        }
        String strSubstring = str.substring(str2.length());
        F0.i.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final void d0(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException(F0.h.b(i2, "Limit must be non-negative, but was ").toString());
        }
    }

    public static List e0(String str, char[] cArr) {
        F0.i.e(str, "<this>");
        boolean z2 = false;
        if (cArr.length == 1) {
            String strValueOf = String.valueOf(cArr[0]);
            d0(0);
            int iW = W(str, strValueOf, 0, false);
            if (iW == -1) {
                return p029q.j.m(str.toString());
            }
            ArrayList arrayList = new ArrayList(10);
            int length = 0;
            do {
                arrayList.add(str.subSequence(length, iW).toString());
                length = strValueOf.length() + iW;
                iW = W(str, strValueOf, length, false);
            } while (iW != -1);
            arrayList.add(str.subSequence(length, str.length()).toString());
            return arrayList;
        }
        d0(0);
        L0.h hVar = new L0.h(new c(str, 0, 0, new n(cArr, z2, 0)));
        ArrayList arrayList2 = new ArrayList(p036u0.h.q(hVar));
        Iterator it = hVar.iterator();
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return arrayList2;
            }
            J0.c cVar = (J0.c) bVar.next();
            F0.i.e(cVar, "range");
            arrayList2.add(str.subSequence(cVar.f278a, cVar.f279b + 1).toString());
        }
    }

    public static String f0(String str, String str2) {
        F0.i.e(str2, "delimiter");
        int iY = Y(str, str2, 0, false, 6);
        if (iY == -1) {
            return str;
        }
        String strSubstring = str.substring(str2.length() + iY, str.length());
        F0.i.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String g0(String str, char c2, String str2) {
        F0.i.e(str, "<this>");
        F0.i.e(str2, "missingDelimiterValue");
        int iA0 = a0(str, c2, 0, 6);
        if (iA0 == -1) {
            return str2;
        }
        String strSubstring = str.substring(iA0 + 1, str.length());
        F0.i.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String h0(String str, char c2) {
        F0.i.e(str, "<this>");
        F0.i.e(str, "missingDelimiterValue");
        int iA0 = a0(str, c2, 0, 6);
        if (iA0 == -1) {
            return str;
        }
        String strSubstring = str.substring(0, iA0);
        F0.i.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String i0(int i2, String str) {
        F0.i.e(str, "<this>");
        if (i2 < 0) {
            throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
        }
        int length = str.length();
        if (i2 > length) {
            i2 = length;
        }
        String strSubstring = str.substring(0, i2);
        F0.i.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static CharSequence j0(String str) {
        F0.i.e(str, "<this>");
        int length = str.length() - 1;
        int i2 = 0;
        boolean z2 = false;
        while (i2 <= length) {
            char cCharAt = str.charAt(!z2 ? i2 : length);
            boolean z3 = Character.isWhitespace(cCharAt) || Character.isSpaceChar(cCharAt);
            if (z2) {
                if (!z3) {
                    break;
                }
                length--;
            } else if (z3) {
                i2++;
            } else {
                z2 = true;
            }
        }
        return str.subSequence(i2, length + 1);
    }
}
