// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c1;

import F0.i;
import H.C0028c;
import M0.m;
import X0.C0055b;
import X0.D;
import X0.k;
import X0.n;
import X0.p;
import f1.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import k1.C0196l;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    static {
        C0196l c0196l = C0196l.f3483d;
        C0028c.p("\"\\");
        C0028c.p("\t ,=");
    }

    public static final boolean a(D d2) {
        if (i.a((String) d2.f904a.f1098b, "HEAD")) {
            return false;
        }
        int i2 = d2.f907d;
        return (((i2 >= 100 && i2 < 200) || i2 == 204 || i2 == 304) && Y0.b.k(d2) == -1 && !"chunked".equalsIgnoreCase(D.a(d2, "Transfer-Encoding"))) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0094 A[EDGE_INSN: B:27:0x0094->B:125:0x0239 BREAK  A[LOOP:2: B:32:0x00bd->B:80:0x0182]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r25v3 */
    /* JADX WARN: Type inference failed for: r26v2 */
    public static final void b(C0055b c0055b, p pVar, n nVar) {
        List list;
        k kVar;
        String str;
        int i2 = 1;
        i.e(c0055b, "<this>");
        i.e(pVar, "url");
        i.e(nVar, "headers");
        if (c0055b == C0055b.f945b) {
            return;
        }
        Pattern pattern = k.f993j;
        int size = nVar.size();
        int i3 = 0;
        ArrayList arrayList = null;
        for (int i4 = 0; i4 < size; i4++) {
            if ("Set-Cookie".equalsIgnoreCase(nVar.b(i4))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(nVar.d(i4));
            }
        }
        List listUnmodifiableList = p036u0.n.f4146a;
        if (arrayList != null) {
            List listUnmodifiableList2 = Collections.unmodifiableList(arrayList);
            i.d(listUnmodifiableList2, "{\n      Collections.unmodifiableList(result)\n    }");
            list = listUnmodifiableList2;
        } else {
            list = listUnmodifiableList;
        }
        int size2 = list.size();
        ArrayList arrayList2 = null;
        for (int i5 = 0; i5 < size2; i5++) {
            String str2 = (String) list.get(i5);
            i.e(str2, "setCookie");
            long jCurrentTimeMillis = System.currentTimeMillis();
            byte[] bArr = Y0.b.f1119a;
            char c2 = ';';
            int iF = Y0.b.f(str2, ';', i3, str2.length());
            char c3 = '=';
            int iF2 = Y0.b.f(str2, '=', i3, iF);
            if (iF2 == iF) {
                kVar = null;
                break;
            }
            String strY = Y0.b.y(str2, i3, iF2);
            if (strY.length() == 0 || Y0.b.m(strY) != -1) {
                kVar = null;
                i3 = 0;
                break;
            }
            String strY2 = Y0.b.y(str2, iF2 + i2, iF);
            if (Y0.b.m(strY2) != -1) {
                kVar = null;
                i3 = 0;
                break;
            }
            int i6 = iF + i2;
            int length = str2.length();
            long j2 = 253402300799999L;
            boolean z2 = i2;
            long jN = 253402300799999L;
            String str3 = null;
            long j3 = -1;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = 0;
            String str4 = null;
            while (true) {
                if (i6 >= length) {
                    if (j3 == Long.MIN_VALUE) {
                        j2 = Long.MIN_VALUE;
                    } else if (j3 != -1) {
                        long j4 = jCurrentTimeMillis + (j3 <= 9223372036854775L ? j3 * ((long) 1000) : Long.MAX_VALUE);
                        if (j4 >= jCurrentTimeMillis && j4 <= 253402300799999L) {
                            j2 = j4;
                        }
                    } else {
                        j2 = jN;
                    }
                    String str5 = pVar.f1024d;
                    if (str3 == null) {
                        str3 = str5;
                    } else if (!i.a(str5, str3)) {
                        if (m.L(str5, str3, false) && str5.charAt((str5.length() - str3.length()) - 1) == '.') {
                            M0.d dVar = Y0.b.f1124f;
                            dVar.getClass();
                            if (!((Pattern) dVar.f374b).matcher(str5).matches()) {
                            }
                        }
                        i3 = 0;
                        kVar = null;
                        break;
                    }
                    if (str5.length() != str3.length() && PublicSuffixDatabase.g.a(str3) == null) {
                        kVar = null;
                        i3 = 0;
                        break;
                    }
                    String strSubstring = "/";
                    String str6 = str4;
                    i3 = 0;
                    if (str6 == null || !m.R(str6, "/", false)) {
                        String strB = pVar.b();
                        int iA0 = M0.e.a0(strB, '/', 0, 6);
                        if (iA0 != 0) {
                            strSubstring = strB.substring(0, iA0);
                            i.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        }
                        str = strSubstring;
                    } else {
                        str = str6;
                    }
                    kVar = new k(strY, strY2, j2, str3, str, z3, z4, z5, z2);
                    break;
                }
                int iF3 = Y0.b.f(str2, c2, i6, length);
                int iF4 = Y0.b.f(str2, c3, i6, iF3);
                String strY3 = Y0.b.y(str2, i6, iF4);
                String strY4 = iF4 < iF3 ? Y0.b.y(str2, iF4 + i2, iF3) : "";
                if (strY3.equalsIgnoreCase("expires")) {
                    try {
                        jN = l.N(strY4.length(), strY4);
                        z5 = i2;
                    } catch (NumberFormatException | IllegalArgumentException unused) {
                        i2 = 1;
                    }
                } else if (strY3.equalsIgnoreCase("max-age")) {
                    try {
                        long j5 = Long.parseLong(strY4);
                        j3 = j5 > 0 ? j5 : Long.MIN_VALUE;
                    } catch (NumberFormatException e2) {
                        Pattern patternCompile = Pattern.compile("-?\\d+");
                        i.d(patternCompile, "compile(...)");
                        if (!patternCompile.matcher(strY4).matches()) {
                            throw e2;
                        }
                        j3 = m.R(strY4, "-", false) ? Long.MIN_VALUE : Long.MAX_VALUE;
                    }
                    i2 = 1;
                    z5 = 1;
                } else if (!strY3.equalsIgnoreCase("domain")) {
                    if (strY3.equalsIgnoreCase("path")) {
                        str4 = strY4;
                    } else if (strY3.equalsIgnoreCase("secure")) {
                        i2 = 1;
                        z3 = true;
                    } else if (strY3.equalsIgnoreCase("httponly")) {
                        i2 = 1;
                        z4 = true;
                    }
                    i2 = 1;
                } else {
                    if (m.L(strY4, ".", false)) {
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                    String strZ = l.Z(M0.e.c0(strY4, "."));
                    if (strZ == null) {
                        throw new IllegalArgumentException();
                    }
                    str3 = strZ;
                    i2 = 1;
                    z2 = 0;
                }
                i6 = iF3 + 1;
                c2 = ';';
                c3 = '=';
                z5 = z5;
                z2 = z2;
            }
            if (kVar != null) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(kVar);
            }
            i2 = 1;
        }
        if (arrayList2 != null) {
            listUnmodifiableList = Collections.unmodifiableList(arrayList2);
            i.d(listUnmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
        }
        listUnmodifiableList.isEmpty();
    }
}
