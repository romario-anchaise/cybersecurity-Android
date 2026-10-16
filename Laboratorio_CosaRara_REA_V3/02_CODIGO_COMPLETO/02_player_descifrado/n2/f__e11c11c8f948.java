// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package n2;

import e0.i;
import i2.j;
import i2.o;
import i2.q;
import i2.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import v1.l;
import w2.k;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    static {
        k kVar = k.f5778f;
        i.d("\"\\");
        i.d("\t ,=");
    }

    public static final boolean a(y yVar) {
        if (q1.e.a(yVar.f2287c.f265b, "HEAD")) {
            return false;
        }
        int i3 = yVar.f2290f;
        return (((i3 >= 100 && i3 < 200) || i3 == 204 || i3 == 304) && j2.b.k(yVar) == -1 && !"chunked".equalsIgnoreCase(y.d(yVar, "Transfer-Encoding"))) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x009e  */
    public static final void b(i2.b bVar, q qVar, o oVar) {
        int i3;
        List list;
        j jVar;
        long j3;
        j jVar2;
        String strSubstring;
        bVar.getClass();
        qVar.getClass();
        oVar.getClass();
        if (bVar == i2.b.f2118b) {
            return;
        }
        Pattern pattern = j.f2171j;
        int size = oVar.size();
        int i4 = 0;
        ArrayList arrayList = null;
        while (true) {
            i3 = 2;
            if (i4 >= size) {
                break;
            }
            if ("Set-Cookie".equalsIgnoreCase(oVar.b(i4))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(oVar.e(i4));
            }
            i4++;
        }
        List listUnmodifiableList = i1.q.f2104c;
        if (arrayList != null) {
            List listUnmodifiableList2 = Collections.unmodifiableList(arrayList);
            listUnmodifiableList2.getClass();
            list = listUnmodifiableList2;
        } else {
            list = listUnmodifiableList;
        }
        int size2 = list.size();
        int i5 = 0;
        ArrayList arrayList2 = null;
        while (i5 < size2) {
            String str = (String) list.get(i5);
            str.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            char c3 = ';';
            int iH = j2.b.h(str, ';', 0, 0, 6);
            char c4 = '=';
            int iH2 = j2.b.h(str, '=', 0, iH, i3);
            if (iH2 == iH) {
                jVar = null;
            } else {
                int iN = j2.b.n(0, iH2, str);
                String strSubstring2 = str.substring(iN, j2.b.o(iN, iH2, str));
                if (strSubstring2.length() != 0 && j2.b.m(strSubstring2) == -1) {
                    int iN2 = j2.b.n(iH2 + 1, iH, str);
                    String strSubstring3 = str.substring(iN2, j2.b.o(iN2, iH, str));
                    if (j2.b.m(strSubstring3) == -1) {
                        int i6 = iH + 1;
                        int length = str.length();
                        boolean z2 = false;
                        boolean z3 = false;
                        boolean z4 = false;
                        long j4 = -1;
                        long jO = 253402300799999L;
                        String strSubstring4 = null;
                        String str2 = null;
                        boolean z5 = true;
                        while (true) {
                            if (i6 >= length) {
                                if (j4 == Long.MIN_VALUE) {
                                    j3 = Long.MIN_VALUE;
                                } else if (j4 != -1) {
                                    long j5 = jCurrentTimeMillis + (j4 <= 9223372036854775L ? j4 * ((long) 1000) : Long.MAX_VALUE);
                                    j3 = (j5 < jCurrentTimeMillis || j5 > 253402300799999L) ? 253402300799999L : j5;
                                } else {
                                    j3 = jO;
                                }
                                String str3 = qVar.f2203d;
                                if (str2 != null) {
                                    if (!q1.e.a(str3, str2)) {
                                        str3.getClass();
                                        if (str3.endsWith(str2) && str3.charAt((str3.length() - str2.length()) - 1) == '.') {
                                            q1.i iVar = j2.b.f2366f;
                                            iVar.getClass();
                                            if (!((Pattern) iVar.f3129d).matcher(str3).matches()) {
                                            }
                                        }
                                        jVar2 = null;
                                    }
                                    jVar = jVar2;
                                    break;
                                }
                                str2 = str3;
                                if (str3.length() == str2.length() || PublicSuffixDatabase.f2815g.a(str2) != null) {
                                    if (strSubstring4 == null || !l.z(strSubstring4, "/", false)) {
                                        String strB = qVar.b();
                                        int iG = v1.d.G(strB, '/', 0, 6);
                                        strSubstring4 = iG != 0 ? strB.substring(0, iG) : "/";
                                    }
                                    jVar2 = new j(strSubstring2, strSubstring3, j3, str2, strSubstring4, z4, z2, z3, z5);
                                } else {
                                    jVar2 = null;
                                }
                                jVar = jVar2;
                                break;
                            }
                            int iG2 = j2.b.g(str, c3, i6, length);
                            int iG3 = j2.b.g(str, c4, i6, iG2);
                            int iN3 = j2.b.n(i6, iG3, str);
                            String strSubstring5 = str.substring(iN3, j2.b.o(iN3, iG3, str));
                            if (iG3 < iG2) {
                                int iN4 = j2.b.n(iG3 + 1, iG2, str);
                                strSubstring = str.substring(iN4, j2.b.o(iN4, iG2, str));
                            } else {
                                strSubstring = "";
                            }
                            if (strSubstring5.equalsIgnoreCase("expires")) {
                                try {
                                    jO = i2.c.o(strSubstring, strSubstring.length());
                                    z3 = true;
                                } catch (NumberFormatException | IllegalArgumentException unused) {
                                }
                            } else if (strSubstring5.equalsIgnoreCase("max-age")) {
                                try {
                                    j4 = Long.parseLong(strSubstring);
                                    if (j4 <= 0) {
                                        j4 = Long.MIN_VALUE;
                                    }
                                } catch (NumberFormatException e3) {
                                    Pattern patternCompile = Pattern.compile("-?\\d+");
                                    patternCompile.getClass();
                                    if (!patternCompile.matcher(strSubstring).matches()) {
                                        throw e3;
                                    }
                                    j4 = l.z(strSubstring, "-", false) ? Long.MIN_VALUE : Long.MAX_VALUE;
                                }
                                z3 = true;
                            } else if (strSubstring5.equalsIgnoreCase("domain")) {
                                if (strSubstring.endsWith(".")) {
                                    throw new IllegalArgumentException("Failed requirement.");
                                }
                                if (l.z(strSubstring, ".", false)) {
                                    strSubstring = strSubstring.substring(".".length());
                                }
                                String strC = q2.c.C(strSubstring);
                                if (strC == null) {
                                    throw new IllegalArgumentException();
                                }
                                str2 = strC;
                                z5 = false;
                            } else if (strSubstring5.equalsIgnoreCase("path")) {
                                strSubstring4 = strSubstring;
                            } else if (strSubstring5.equalsIgnoreCase("secure")) {
                                z4 = true;
                            } else if (strSubstring5.equalsIgnoreCase("httponly")) {
                                z2 = true;
                            }
                            i6 = iG2 + 1;
                            c3 = ';';
                            c4 = '=';
                        }
                    } else {
                        jVar = null;
                    }
                } else {
                    jVar = null;
                }
            }
            if (jVar != null) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(jVar);
            }
            i5++;
            i3 = 2;
        }
        if (arrayList2 != null) {
            listUnmodifiableList = Collections.unmodifiableList(arrayList2);
            listUnmodifiableList.getClass();
        }
        listUnmodifiableList.isEmpty();
    }
}
