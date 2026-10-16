// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package v1;

import d2.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import w1.j4;
import w1.o2;

/* JADX INFO: loaded from: classes.dex */
public abstract class d extends l {
    public static boolean A(CharSequence charSequence, char c3) {
        charSequence.getClass();
        return D(charSequence, c3, 0, 2) >= 0;
    }

    public static boolean B(CharSequence charSequence, String str) {
        charSequence.getClass();
        return C(charSequence, str, 0, false) >= 0;
    }

    public static final int C(CharSequence charSequence, String str, int i3, boolean z2) {
        String str2;
        boolean z3;
        boolean zRegionMatches;
        charSequence.getClass();
        str.getClass();
        if (!z2 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i3);
        }
        int length = charSequence.length();
        if (i3 < 0) {
            i3 = 0;
        }
        int length2 = charSequence.length();
        if (length > length2) {
            length = length2;
        }
        s1.c cVar = new s1.c(i3, length, 1);
        boolean z4 = charSequence instanceof String;
        int i4 = cVar.f3231e;
        int i5 = cVar.f3230d;
        if (!z4 || str == null) {
            if ((i4 > 0 && i3 <= i5) || (i4 < 0 && i5 <= i3)) {
                while (true) {
                    int length3 = str.length();
                    str.getClass();
                    charSequence.getClass();
                    boolean z5 = false;
                    if (i3 >= 0 && str.length() - length3 >= 0 && i3 <= charSequence.length() - length3) {
                        int i6 = 0;
                        while (true) {
                            if (i6 >= length3) {
                                z5 = true;
                                break;
                            }
                            if (!q2.c.k(str.charAt(0 + i6), charSequence.charAt(i3 + i6), z2)) {
                                break;
                            }
                            i6++;
                        }
                    }
                    if (z5) {
                        return i3;
                    }
                    if (i3 != i5) {
                        i3 += i4;
                    }
                }
            }
        } else if ((i4 > 0 && i3 <= i5) || (i4 < 0 && i5 <= i3)) {
            int i7 = i3;
            while (true) {
                String str3 = (String) charSequence;
                int length4 = str.length();
                if (z2) {
                    str2 = str;
                    z3 = z2;
                    zRegionMatches = str2.regionMatches(z3, 0, str3, i7, length4);
                } else {
                    zRegionMatches = str.regionMatches(0, str3, i7, length4);
                    str2 = str;
                    z3 = z2;
                }
                if (zRegionMatches) {
                    return i7;
                }
                if (i7 != i5) {
                    i7 += i4;
                    str = str2;
                    z2 = z3;
                }
            }
        }
        return -1;
    }

    public static int D(CharSequence charSequence, char c3, int i3, int i4) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        charSequence.getClass();
        return !(charSequence instanceof String) ? E(charSequence, new char[]{c3}, i3, false) : ((String) charSequence).indexOf(c3, i3);
    }

    public static final int E(CharSequence charSequence, char[] cArr, int i3, boolean z2) {
        char c3;
        charSequence.getClass();
        if (!z2 && cArr.length == 1 && (charSequence instanceof String)) {
            int length = cArr.length;
            if (length == 0) {
                throw new NoSuchElementException("Array is empty.");
            }
            if (length == 1) {
                c3 = cArr[0];
            } else {
                o2.i("Array has more than one element.");
                c3 = 0;
            }
            return ((String) charSequence).indexOf(c3, i3);
        }
        if (i3 < 0) {
            i3 = 0;
        }
        int length2 = charSequence.length() - 1;
        if (i3 > length2) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i3);
            for (char c4 : cArr) {
                if (q2.c.k(c4, cCharAt, z2)) {
                    return i3;
                }
            }
            if (i3 == length2) {
                return -1;
            }
            i3++;
        }
    }

    public static boolean F(String str) {
        str.getClass();
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (!q2.c.u(str.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    public static int G(String str, char c3, int i3, int i4) {
        if ((i4 & 2) != 0) {
            i3 = str.length() - 1;
        }
        return str.lastIndexOf(c3, i3);
    }

    public static List H(String str, char[] cArr) {
        if (cArr.length == 1) {
            String strValueOf = String.valueOf(cArr[0]);
            int iC = C(str, strValueOf, 0, false);
            if (iC == -1) {
                return m0.a.k(str.toString());
            }
            ArrayList arrayList = new ArrayList(10);
            int length = 0;
            do {
                arrayList.add(str.subSequence(length, iC).toString());
                length = strValueOf.length() + iC;
                iC = C(str, strValueOf, length, false);
            } while (iC != -1);
            arrayList.add(str.subSequence(length, str.length()).toString());
            return arrayList;
        }
        u1.c cVar = new u1.c(new y.l(str, new o(8, cArr)));
        ArrayList arrayList2 = new ArrayList(i1.k.A(cVar));
        Iterator it = cVar.iterator();
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return arrayList2;
            }
            s1.c cVar2 = (s1.c) bVar.next();
            cVar2.getClass();
            arrayList2.add(str.subSequence(cVar2.f3229c, cVar2.f3230d + 1).toString());
        }
    }

    public static String I(String str, int i3) {
        str.getClass();
        if (i3 < 0) {
            o2.h(j4.c(i3, "Requested character count ", " is less than zero."));
            return null;
        }
        int length = str.length();
        if (i3 > length) {
            i3 = length;
        }
        return str.substring(0, i3);
    }

    public static CharSequence J(String str) {
        str.getClass();
        int length = str.length() - 1;
        int i3 = 0;
        boolean z2 = false;
        while (i3 <= length) {
            boolean zU = q2.c.u(str.charAt(!z2 ? i3 : length));
            if (z2) {
                if (!zU) {
                    break;
                }
                length--;
            } else if (zU) {
                i3++;
            } else {
                z2 = true;
            }
        }
        return str.subSequence(i3, length + 1);
    }
}
