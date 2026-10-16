// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i2;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f2117a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f2118b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f2119c = new b();

    public static final h a(b bVar, String str) {
        h hVar = new h(str);
        h.f2148d.put(str, hVar);
        return hVar;
    }

    public static String b(String str, int i3, int i4, String str2, int i5) {
        int i6 = (i5 & 1) != 0 ? 0 : i3;
        int length = (i5 & 2) != 0 ? str.length() : i4;
        boolean z2 = (i5 & 8) == 0;
        boolean z3 = (i5 & 16) == 0;
        boolean z4 = (i5 & 32) == 0;
        boolean z5 = (i5 & 64) == 0;
        str.getClass();
        int iCharCount = i6;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            int i7 = 128;
            int i8 = 32;
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z5) || v1.d.A(str2, (char) iCodePointAt) || ((iCodePointAt == 37 && (!z2 || (z3 && !d(iCharCount, length, str)))) || (iCodePointAt == 43 && z4)))) {
                w2.h hVar = new w2.h();
                hVar.N(i6, iCharCount, str);
                w2.h hVar2 = null;
                while (iCharCount < length) {
                    int iCodePointAt2 = str.codePointAt(iCharCount);
                    if (!z2 || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                        if (iCodePointAt2 == 43 && z4) {
                            hVar.O(z2 ? "+" : "%2B");
                        } else if (iCodePointAt2 < i8 || iCodePointAt2 == 127 || ((iCodePointAt2 >= i7 && !z5) || v1.d.A(str2, (char) iCodePointAt2) || (iCodePointAt2 == 37 && (!z2 || (z3 && !d(iCharCount, length, str)))))) {
                            if (hVar2 == null) {
                                hVar2 = new w2.h();
                            }
                            hVar2.P(iCodePointAt2);
                            while (!hVar2.w()) {
                                byte b3 = hVar2.readByte();
                                hVar.J(37);
                                char[] cArr = q.f2199j;
                                hVar.J(cArr[((b3 & 255) >> 4) & 15]);
                                hVar.J(cArr[b3 & 15]);
                            }
                        } else {
                            hVar.P(iCodePointAt2);
                        }
                    }
                    iCharCount += Character.charCount(iCodePointAt2);
                    i7 = 128;
                    i8 = 32;
                }
                return hVar.D();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.substring(i6, length);
    }

    public static boolean d(int i3, int i4, String str) {
        int i5 = i3 + 2;
        return i5 < i4 && str.charAt(i3) == '%' && j2.b.r(str.charAt(i3 + 1)) != -1 && j2.b.r(str.charAt(i5)) != -1;
    }

    public static String e(String str, int i3, int i4, int i5) {
        int i6;
        if ((i5 & 1) != 0) {
            i3 = 0;
        }
        if ((i5 & 2) != 0) {
            i4 = str.length();
        }
        boolean z2 = (i5 & 4) == 0;
        str.getClass();
        int iCharCount = i3;
        while (iCharCount < i4) {
            char cCharAt = str.charAt(iCharCount);
            if (cCharAt == '%' || (cCharAt == '+' && z2)) {
                w2.h hVar = new w2.h();
                hVar.N(i3, iCharCount, str);
                while (iCharCount < i4) {
                    int iCodePointAt = str.codePointAt(iCharCount);
                    if (iCodePointAt == 37 && (i6 = iCharCount + 2) < i4) {
                        int iR = j2.b.r(str.charAt(iCharCount + 1));
                        int iR2 = j2.b.r(str.charAt(i6));
                        if (iR == -1 || iR2 == -1) {
                            hVar.P(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        } else {
                            hVar.J((iR << 4) + iR2);
                            iCharCount = Character.charCount(iCodePointAt) + i6;
                        }
                    } else if (iCodePointAt == 43 && z2) {
                        hVar.J(32);
                        iCharCount++;
                    } else {
                        hVar.P(iCodePointAt);
                        iCharCount += Character.charCount(iCodePointAt);
                    }
                }
                return hVar.D();
            }
            iCharCount++;
        }
        return str.substring(i3, i4);
    }

    public static ArrayList f(String str) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 <= str.length()) {
            int iD = v1.d.D(str, '&', i3, 4);
            if (iD == -1) {
                iD = str.length();
            }
            int iD2 = v1.d.D(str, '=', i3, 4);
            if (iD2 == -1 || iD2 > iD) {
                arrayList.add(str.substring(i3, iD));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i3, iD2));
                arrayList.add(str.substring(iD2 + 1, iD));
            }
            i3 = iD + 1;
        }
        return arrayList;
    }

    public synchronized h c(String str) {
        h hVar;
        String strConcat;
        try {
            str.getClass();
            LinkedHashMap linkedHashMap = h.f2148d;
            hVar = (h) linkedHashMap.get(str);
            if (hVar == null) {
                if (v1.l.z(str, "TLS_", false)) {
                    strConcat = "SSL_".concat(str.substring(4));
                } else {
                    strConcat = v1.l.z(str, "SSL_", false) ? "TLS_".concat(str.substring(4)) : str;
                }
                hVar = (h) linkedHashMap.get(strConcat);
                if (hVar == null) {
                    hVar = new h(str);
                }
                linkedHashMap.put(str, hVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return hVar;
    }
}
