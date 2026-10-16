// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1013a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1016d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f1018f;
    public ArrayList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f1019h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1014b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1015c = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1017e = -1;

    public o() {
        ArrayList arrayList = new ArrayList();
        this.f1018f = arrayList;
        arrayList.add("");
    }

    public final p a() {
        ArrayList arrayList;
        String str = this.f1013a;
        if (str == null) {
            throw new IllegalStateException("scheme == null");
        }
        String strE = C0055b.e(this.f1014b, 0, 0, false, 7);
        String strE2 = C0055b.e(this.f1015c, 0, 0, false, 7);
        String str2 = this.f1016d;
        if (str2 == null) {
            throw new IllegalStateException("host == null");
        }
        int iB = b();
        ArrayList arrayList2 = this.f1018f;
        ArrayList arrayList3 = new ArrayList(p036u0.h.q(arrayList2));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(C0055b.e((String) it.next(), 0, 0, false, 7));
        }
        ArrayList<String> arrayList4 = this.g;
        if (arrayList4 != null) {
            arrayList = new ArrayList(p036u0.h.q(arrayList4));
            for (String str3 : arrayList4) {
                arrayList.add(str3 != null ? C0055b.e(str3, 0, 0, true, 3) : null);
            }
        } else {
            arrayList = null;
        }
        String str4 = this.f1019h;
        return new p(str, strE, strE2, str2, iB, arrayList3, arrayList, str4 != null ? C0055b.e(str4, 0, 0, false, 7) : null, toString());
    }

    public final int b() {
        int i2 = this.f1017e;
        if (i2 != -1) {
            return i2;
        }
        String str = this.f1013a;
        F0.i.b(str);
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0226  */
    /* JADX WARN: Code duplicated, block: B:102:0x022e A[LOOP:4: B:102:0x022e->B:229:?, LOOP_START, PHI: r4
  0x022e: PHI (r4v20 int) = (r4v13 int), (r4v21 int) binds: [B:101:0x022c, B:229:?] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:104:0x0232  */
    /* JADX WARN: Code duplicated, block: B:107:0x023c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x024c  */
    /* JADX WARN: Code duplicated, block: B:123:0x027d  */
    /* JADX WARN: Code duplicated, block: B:126:0x0283  */
    /* JADX WARN: Code duplicated, block: B:127:0x0289  */
    /* JADX WARN: Code duplicated, block: B:129:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:131:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:132:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:134:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:135:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:139:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:195:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:225:0x0243 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:226:0x023e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:227:0x023a A[EDGE_INSN: B:227:0x023a->B:106:0x023a BREAK  A[LOOP:4: B:102:0x022e->B:229:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:4:0x002a  */
    /* JADX WARN: Code duplicated, block: B:73:0x013d  */
    /* JADX WARN: Code duplicated, block: B:76:0x014b  */
    /* JADX WARN: Code duplicated, block: B:77:0x0150  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void c(p pVar, String str) {
        int i2;
        byte b2;
        byte b3;
        int i3;
        int iG;
        byte bCharAt;
        String str2;
        String str3;
        String str4;
        ArrayList arrayList;
        int i4;
        int i5;
        int i6;
        boolean z2;
        String str5;
        int i7;
        int i8;
        int i9;
        char cCharAt;
        int i10;
        ArrayList arrayList2;
        char cCharAt2;
        F0.i.e(str, "input");
        byte[] bArr = Y0.b.f1119a;
        int iN = Y0.b.n(str, 0, str.length());
        int iO = Y0.b.o(str, iN, str.length());
        byte b4 = -1;
        if (iO - iN >= 2) {
            char cCharAt3 = str.charAt(iN);
            char c2 = 'a';
            if ((F0.i.f(cCharAt3, 97) >= 0 && F0.i.f(cCharAt3, 122) <= 0) || (F0.i.f(cCharAt3, 65) >= 0 && F0.i.f(cCharAt3, 90) <= 0)) {
                i2 = iN + 1;
                while (true) {
                    if (i2 < iO) {
                        char cCharAt4 = str.charAt(i2);
                        if ((c2 > cCharAt4 || cCharAt4 >= '{') && (('A' > cCharAt4 || cCharAt4 >= '[') && !(('0' <= cCharAt4 && cCharAt4 < ':') || cCharAt4 == '+' || cCharAt4 == '-' || cCharAt4 == '.'))) {
                            if (cCharAt4 == ':') {
                                break;
                            } else {
                                break;
                            }
                        } else {
                            i2++;
                            c2 = 'a';
                        }
                    }
                    i2 = -1;
                    break;
                }
            } else {
                i2 = -1;
                break;
            }
        } else {
            i2 = -1;
            break;
        }
        String str6 = "http";
        String str7 = "https";
        String str8 = "this as java.lang.String…ing(startIndex, endIndex)";
        if (i2 != -1) {
            if (M0.m.Q(str, "https:", iN, true)) {
                this.f1013a = "https";
                iN += 6;
            } else {
                if (!M0.m.Q(str, "http:", iN, true)) {
                    StringBuilder sb = new StringBuilder("Expected URL scheme 'http' or 'https' but was '");
                    String strSubstring = str.substring(0, i2);
                    F0.i.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    sb.append(strSubstring);
                    sb.append('\'');
                    throw new IllegalArgumentException(sb.toString());
                }
                this.f1013a = "http";
                iN += 5;
            }
        } else {
            if (pVar == null) {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no scheme was found for " + (str.length() > 6 ? M0.e.i0(6, str).concat("...") : str));
            }
            this.f1013a = pVar.f1021a;
        }
        int i11 = iN;
        int i12 = 0;
        while (true) {
            b2 = 47;
            b3 = 92;
            if (i11 >= iO || !((cCharAt2 = str.charAt(i11)) == '\\' || cCharAt2 == '/')) {
                break;
            }
            i12++;
            i11++;
        }
        ArrayList arrayList3 = this.f1018f;
        byte b5 = 35;
        if (i12 >= 2 || pVar == null) {
            i3 = iN + i12;
            boolean z3 = false;
            boolean z4 = false;
            while (true) {
                iG = Y0.b.g(str, i3, iO, "@/\\?#");
                if (iG != iO) {
                    bCharAt = str.charAt(iG);
                } else {
                    bCharAt = b4;
                }
                if (bCharAt == b4 || bCharAt == b5 || bCharAt == b2 || bCharAt == b3 || bCharAt == 63) {
                    break;
                }
                if (bCharAt == 64) {
                    if (z3) {
                        i10 = iG;
                        this.f1015c += "%40" + C0055b.b(str, i3, i10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 240);
                    } else {
                        int iF = Y0.b.f(str, ':', i3, iG);
                        i10 = iG;
                        String strB = C0055b.b(str, i3, iF, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 240);
                        if (z4) {
                            strB = this.f1014b + "%40" + strB;
                        }
                        this.f1014b = strB;
                        if (iF != i10) {
                            this.f1015c = C0055b.b(str, iF + 1, i10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 240);
                            z3 = true;
                        }
                        z4 = true;
                    }
                    i3 = i10 + 1;
                    arrayList3 = arrayList3;
                    str8 = str8;
                    str7 = str7;
                    str6 = str6;
                    b5 = 35;
                    b3 = 92;
                    b4 = -1;
                    b2 = 47;
                }
            }
            str2 = str8;
            str3 = str7;
            str4 = str6;
            arrayList = arrayList3;
            i4 = i3;
            while (true) {
                if (i4 >= iG) {
                    i5 = iG;
                    break;
                }
                cCharAt = str.charAt(i4);
                if (cCharAt == '[') {
                    if (cCharAt == ':') {
                        i5 = i4;
                        break;
                    }
                } else {
                    do {
                        i4++;
                        if (i4 < iG) {
                            break;
                        }
                    } while (str.charAt(i4) != ']');
                }
                i4++;
            }
            i6 = i5 + 1;
            if (i6 < iG) {
                this.f1016d = f1.l.Z(C0055b.e(str, i3, i5, false, 4));
                i8 = i3;
                try {
                    i9 = Integer.parseInt(C0055b.b(str, i6, iG, "", false, false, false, false, 248));
                    if (1 <= i9 || i9 >= 65536) {
                        i9 = -1;
                    }
                } catch (NumberFormatException unused) {
                }
                this.f1017e = i9;
                if (i9 != -1) {
                    StringBuilder sb2 = new StringBuilder("Invalid URL port: \"");
                    String strSubstring2 = str.substring(i6, iG);
                    F0.i.d(strSubstring2, str2);
                    sb2.append(strSubstring2);
                    sb2.append('\"');
                    throw new IllegalArgumentException(sb2.toString().toString());
                }
                i3 = i8;
                z2 = false;
            } else {
                z2 = false;
                this.f1016d = f1.l.Z(C0055b.e(str, i3, i5, false, 4));
                str5 = this.f1013a;
                F0.i.b(str5);
                if (str5.equals(str4)) {
                    i7 = 80;
                } else if (str5.equals(str3)) {
                    i7 = 443;
                } else {
                    i7 = -1;
                }
                this.f1017e = i7;
            }
            if (this.f1016d != null) {
                StringBuilder sb3 = new StringBuilder("Invalid URL host: \"");
                String strSubstring3 = str.substring(i3, i5);
                F0.i.d(strSubstring3, str2);
                sb3.append(strSubstring3);
                sb3.append('\"');
                throw new IllegalArgumentException(sb3.toString().toString());
            }
            iN = iG;
        } else if (F0.i.a(pVar.f1021a, this.f1013a)) {
            this.f1014b = pVar.e();
            this.f1015c = pVar.a();
            this.f1016d = pVar.f1024d;
            this.f1017e = pVar.f1025e;
            arrayList3.clear();
            arrayList3.addAll(pVar.c());
            if (iN == iO || str.charAt(iN) == '#') {
                String strD = pVar.d();
                this.g = strD != null ? C0055b.f(C0055b.b(strD, 0, 0, " \"'<>#", true, false, true, false, 211)) : null;
            }
            arrayList = arrayList3;
            z2 = false;
        } else {
            i3 = iN + i12;
            boolean z5 = false;
            boolean z6 = false;
            while (true) {
                iG = Y0.b.g(str, i3, iO, "@/\\?#");
                if (iG != iO) {
                    bCharAt = str.charAt(iG);
                } else {
                    bCharAt = b4;
                }
                if (bCharAt == b4) {
                    break;
                } else {
                    break;
                }
            }
            str2 = str8;
            str3 = str7;
            str4 = str6;
            arrayList = arrayList3;
            i4 = i3;
            while (true) {
                if (i4 >= iG) {
                    i5 = iG;
                    break;
                }
                cCharAt = str.charAt(i4);
                if (cCharAt == '[') {
                    if (cCharAt == ':') {
                        i5 = i4;
                        break;
                    }
                } else {
                    do {
                        i4++;
                        if (i4 < iG) {
                            break;
                            break;
                        }
                    } while (str.charAt(i4) != ']');
                }
                i4++;
            }
            i6 = i5 + 1;
            if (i6 < iG) {
                this.f1016d = f1.l.Z(C0055b.e(str, i3, i5, false, 4));
                i8 = i3;
                i9 = Integer.parseInt(C0055b.b(str, i6, iG, "", false, false, false, false, 248));
                if (1 <= i9) {
                    i9 = -1;
                } else {
                    i9 = -1;
                }
                this.f1017e = i9;
                if (i9 != -1) {
                    StringBuilder sb4 = new StringBuilder("Invalid URL port: \"");
                    String strSubstring4 = str.substring(i6, iG);
                    F0.i.d(strSubstring4, str2);
                    sb4.append(strSubstring4);
                    sb4.append('\"');
                    throw new IllegalArgumentException(sb4.toString().toString());
                }
                i3 = i8;
                z2 = false;
            } else {
                z2 = false;
                this.f1016d = f1.l.Z(C0055b.e(str, i3, i5, false, 4));
                str5 = this.f1013a;
                F0.i.b(str5);
                if (str5.equals(str4)) {
                    i7 = 80;
                } else if (str5.equals(str3)) {
                    i7 = 443;
                } else {
                    i7 = -1;
                }
                this.f1017e = i7;
            }
            if (this.f1016d != null) {
                StringBuilder sb5 = new StringBuilder("Invalid URL host: \"");
                String strSubstring5 = str.substring(i3, i5);
                F0.i.d(strSubstring5, str2);
                sb5.append(strSubstring5);
                sb5.append('\"');
                throw new IllegalArgumentException(sb5.toString().toString());
            }
            iN = iG;
        }
        int iG2 = Y0.b.g(str, iN, iO, "?#");
        if (iN != iG2) {
            char cCharAt5 = str.charAt(iN);
            if (cCharAt5 == '/' || cCharAt5 == '\\') {
                arrayList2 = arrayList;
                arrayList2.clear();
                arrayList2.add("");
                iN++;
            } else {
                arrayList2 = arrayList;
                arrayList2.set(arrayList.size() - 1, "");
            }
            int i13 = iN;
            while (i13 < iG2) {
                int iG3 = Y0.b.g(str, i13, iG2, "/\\");
                boolean z7 = iG3 < iG2 ? true : z2;
                String strB2 = C0055b.b(str, i13, iG3, " \"<>^`{}|/\\?#", true, false, false, false, 240);
                if (!strB2.equals(".") && !strB2.equalsIgnoreCase("%2e")) {
                    if (!strB2.equals("..") && !strB2.equalsIgnoreCase("%2e.") && !strB2.equalsIgnoreCase(".%2e") && !strB2.equalsIgnoreCase("%2e%2e")) {
                        if (((CharSequence) arrayList2.get(arrayList2.size() - 1)).length() == 0) {
                            arrayList2.set(arrayList2.size() - 1, strB2);
                        } else {
                            arrayList2.add(strB2);
                        }
                        if (z7) {
                            arrayList2.add("");
                        }
                    } else if (((String) arrayList2.remove(arrayList2.size() - 1)).length() != 0 || arrayList2.isEmpty()) {
                        arrayList2.add("");
                    } else {
                        arrayList2.set(arrayList2.size() - 1, "");
                    }
                }
                i13 = z7 ? iG3 + 1 : iG3;
            }
        }
        if (iG2 < iO && str.charAt(iG2) == '?') {
            int iF2 = Y0.b.f(str, '#', iG2, iO);
            this.g = C0055b.f(C0055b.b(str, iG2 + 1, iF2, " \"'<>#", true, false, true, false, 208));
            iG2 = iF2;
        }
        if (iG2 >= iO || str.charAt(iG2) != '#') {
            return;
        }
        this.f1019h = C0055b.b(str, iG2 + 1, iO, "", true, false, false, true, 176);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008b  */
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.f1013a;
        if (str != null) {
            sb.append(str);
            sb.append("://");
        } else {
            sb.append("//");
        }
        if (this.f1014b.length() > 0 || this.f1015c.length() > 0) {
            sb.append(this.f1014b);
            if (this.f1015c.length() > 0) {
                sb.append(':');
                sb.append(this.f1015c);
            }
            sb.append('@');
        }
        String str2 = this.f1016d;
        if (str2 != null) {
            if (M0.e.S(str2, ':')) {
                sb.append('[');
                sb.append(this.f1016d);
                sb.append(']');
            } else {
                sb.append(this.f1016d);
            }
        }
        int i2 = -1;
        if (this.f1017e != -1 || this.f1013a != null) {
            int iB = b();
            String str3 = this.f1013a;
            if (str3 == null) {
                sb.append(':');
                sb.append(iB);
            } else {
                if (str3.equals("http")) {
                    i2 = 80;
                } else if (str3.equals("https")) {
                    i2 = 443;
                }
                if (iB != i2) {
                    sb.append(':');
                    sb.append(iB);
                }
            }
        }
        ArrayList arrayList = this.f1018f;
        F0.i.e(arrayList, "<this>");
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            sb.append('/');
            sb.append((String) arrayList.get(i3));
        }
        if (this.g != null) {
            sb.append('?');
            ArrayList arrayList2 = this.g;
            F0.i.b(arrayList2);
            C0055b.g(arrayList2, sb);
        }
        if (this.f1019h != null) {
            sb.append('#');
            sb.append(this.f1019h);
        }
        String string = sb.toString();
        F0.i.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
