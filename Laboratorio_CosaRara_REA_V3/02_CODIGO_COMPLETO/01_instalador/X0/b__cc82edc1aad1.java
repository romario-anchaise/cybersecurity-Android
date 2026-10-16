// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import k1.C0193i;

/* JADX INFO: renamed from: X0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0055b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0055b f944a = new C0055b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0055b f945b = new C0055b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0055b f946c = new C0055b();

    public static final C0061h a(C0055b c0055b, String str) {
        C0061h c0061h = new C0061h(str);
        C0061h.f966d.put(str, c0061h);
        return c0061h;
    }

    public static String b(String str, int i2, int i3, String str2, boolean z2, boolean z3, boolean z4, boolean z5, int i4) throws EOFException {
        int i5 = (i4 & 1) != 0 ? 0 : i2;
        int length = (i4 & 2) != 0 ? str.length() : i3;
        boolean z6 = (i4 & 8) != 0 ? false : z2;
        boolean z7 = (i4 & 16) != 0 ? false : z3;
        boolean z8 = (i4 & 32) != 0 ? false : z4;
        boolean z9 = (i4 & 64) == 0 ? z5 : false;
        F0.i.e(str, "<this>");
        int iCharCount = i5;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            int i6 = 32;
            int i7 = 128;
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z9) || M0.e.S(str2, (char) iCodePointAt) || ((iCodePointAt == 37 && (!z6 || (z7 && !d(str, iCharCount, length)))) || (iCodePointAt == 43 && z8)))) {
                C0193i c0193i = new C0193i();
                c0193i.V(str, i5, iCharCount);
                C0193i c0193i2 = null;
                while (iCharCount < length) {
                    int iCodePointAt2 = str.codePointAt(iCharCount);
                    if (!z6 || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                        if (iCodePointAt2 == 43 && z8) {
                            c0193i.U(z6 ? "+" : "%2B");
                        } else if (iCodePointAt2 < i6 || iCodePointAt2 == 127 || ((iCodePointAt2 >= i7 && !z9) || M0.e.S(str2, (char) iCodePointAt2) || (iCodePointAt2 == 37 && (!z6 || (z7 && !d(str, iCharCount, length)))))) {
                            if (c0193i2 == null) {
                                c0193i2 = new C0193i();
                            }
                            c0193i2.W(iCodePointAt2);
                            while (!c0193i2.w()) {
                                byte B2 = c0193i2.B();
                                c0193i.Q(37);
                                char[] cArr = p.f1020k;
                                c0193i.Q(cArr[((B2 & 255) >> 4) & 15]);
                                c0193i.Q(cArr[B2 & 15]);
                            }
                        } else {
                            c0193i.W(iCodePointAt2);
                        }
                    }
                    iCharCount += Character.charCount(iCodePointAt2);
                    i6 = 32;
                    i7 = 128;
                }
                return c0193i.J();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        String strSubstring = str.substring(i5, length);
        F0.i.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static boolean d(String str, int i2, int i3) {
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && Y0.b.r(str.charAt(i2 + 1)) != -1 && Y0.b.r(str.charAt(i4)) != -1;
    }

    public static String e(String str, int i2, int i3, boolean z2, int i4) {
        int i5;
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        if ((i4 & 4) != 0) {
            z2 = false;
        }
        F0.i.e(str, "<this>");
        int iCharCount = i2;
        while (iCharCount < i3) {
            char cCharAt = str.charAt(iCharCount);
            if (cCharAt == '%' || (cCharAt == '+' && z2)) {
                C0193i c0193i = new C0193i();
                c0193i.V(str, i2, iCharCount);
                while (iCharCount < i3) {
                    int iCodePointAt = str.codePointAt(iCharCount);
                    if (iCodePointAt == 37 && (i5 = iCharCount + 2) < i3) {
                        int iR = Y0.b.r(str.charAt(iCharCount + 1));
                        int iR2 = Y0.b.r(str.charAt(i5));
                        if (iR == -1 || iR2 == -1) {
                            c0193i.W(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        } else {
                            c0193i.Q((iR << 4) + iR2);
                            iCharCount = Character.charCount(iCodePointAt) + i5;
                        }
                    } else if (iCodePointAt == 43 && z2) {
                        c0193i.Q(32);
                        iCharCount++;
                    } else {
                        c0193i.W(iCodePointAt);
                        iCharCount += Character.charCount(iCodePointAt);
                    }
                }
                return c0193i.J();
            }
            iCharCount++;
        }
        String strSubstring = str.substring(i2, i3);
        F0.i.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static ArrayList f(String str) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int iX = M0.e.X(str, '&', i2, false, 4);
            if (iX == -1) {
                iX = str.length();
            }
            int iX2 = M0.e.X(str, '=', i2, false, 4);
            if (iX2 == -1 || iX2 > iX) {
                String strSubstring = str.substring(i2, iX);
                F0.i.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                arrayList.add(strSubstring);
                arrayList.add(null);
            } else {
                String strSubstring2 = str.substring(i2, iX2);
                F0.i.d(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                arrayList.add(strSubstring2);
                String strSubstring3 = str.substring(iX2 + 1, iX);
                F0.i.d(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                arrayList.add(strSubstring3);
            }
            i2 = iX + 1;
        }
        return arrayList;
    }

    public static void g(ArrayList arrayList, StringBuilder sb) {
        F0.i.e(arrayList, "<this>");
        J0.a aVarB = f1.d.B(f1.d.F(0, arrayList.size()), 2);
        int i2 = aVarB.f278a;
        int i3 = aVarB.f279b;
        int i4 = aVarB.f280c;
        if ((i4 <= 0 || i2 > i3) && (i4 >= 0 || i3 > i2)) {
            return;
        }
        while (true) {
            String str = (String) arrayList.get(i2);
            String str2 = (String) arrayList.get(i2 + 1);
            if (i2 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
            if (i2 == i3) {
                return;
            } else {
                i2 += i4;
            }
        }
    }

    public synchronized C0061h c(String str) {
        C0061h c0061h;
        String strConcat;
        try {
            F0.i.e(str, "javaName");
            LinkedHashMap linkedHashMap = C0061h.f966d;
            c0061h = (C0061h) linkedHashMap.get(str);
            if (c0061h == null) {
                if (M0.m.R(str, "TLS_", false)) {
                    String strSubstring = str.substring(4);
                    F0.i.d(strSubstring, "this as java.lang.String).substring(startIndex)");
                    strConcat = "SSL_".concat(strSubstring);
                } else if (M0.m.R(str, "SSL_", false)) {
                    String strSubstring2 = str.substring(4);
                    F0.i.d(strSubstring2, "this as java.lang.String).substring(startIndex)");
                    strConcat = "TLS_".concat(strSubstring2);
                } else {
                    strConcat = str;
                }
                c0061h = (C0061h) linkedHashMap.get(strConcat);
                if (c0061h == null) {
                    c0061h = new C0061h(str);
                }
                linkedHashMap.put(str, c0061h);
            }
        } catch (Throwable th) {
            throw th;
        }
        return c0061h;
    }
}
