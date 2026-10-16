// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k2;

import b2.d;
import e2.n1;
import i2.a0;
import i2.o;
import i2.r;
import i2.v;
import i2.x;
import i2.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import n2.g;
import v1.l;
import y.e;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements r {
    /* JADX WARN: Code duplicated, block: B:171:0x011d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x007a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:174:0x0080 A[EDGE_INSN: B:174:0x0080->B:24:0x0080 BREAK  A[LOOP:2: B:18:0x0064->B:22:0x0075], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:17:0x005f  */
    /* JADX WARN: Code duplicated, block: B:19:0x0066  */
    /* JADX WARN: Code duplicated, block: B:22:0x0075 A[LOOP:2: B:18:0x0064->B:22:0x0075, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:53:0x010f  */
    /* JADX WARN: Code duplicated, block: B:56:0x011b  */
    /* JADX WARN: Code duplicated, block: B:58:0x0121  */
    /* JADX WARN: Code duplicated, block: B:60:0x0129  */
    /* JADX WARN: Code duplicated, block: B:61:0x012c  */
    /* JADX WARN: Code duplicated, block: B:63:0x0134  */
    /* JADX WARN: Code duplicated, block: B:64:0x013a  */
    /* JADX WARN: Code duplicated, block: B:66:0x0143  */
    /* JADX WARN: Code duplicated, block: B:67:0x0148  */
    /* JADX WARN: Code duplicated, block: B:69:0x0150  */
    /* JADX WARN: Code duplicated, block: B:70:0x0153  */
    /* JADX WARN: Code duplicated, block: B:72:0x015b  */
    /* JADX WARN: Code duplicated, block: B:73:0x015e  */
    /* JADX WARN: Code duplicated, block: B:75:0x0166  */
    /* JADX WARN: Code duplicated, block: B:76:0x0169  */
    /* JADX WARN: Code duplicated, block: B:78:0x0171  */
    /* JADX WARN: Code duplicated, block: B:79:0x0179  */
    /* JADX WARN: Code duplicated, block: B:81:0x0181  */
    /* JADX WARN: Code duplicated, block: B:82:0x0187  */
    /* JADX WARN: Code duplicated, block: B:84:0x0190  */
    /* JADX WARN: Code duplicated, block: B:85:0x0193  */
    /* JADX WARN: Code duplicated, block: B:87:0x019b  */
    /* JADX WARN: Code duplicated, block: B:88:0x019f  */
    /* JADX WARN: Code duplicated, block: B:90:0x01a7  */
    @Override // i2.r
    public final y a(g gVar) {
        e eVar;
        e eVar2;
        int i3;
        int i4;
        int length;
        int length2;
        e eVar3;
        String string;
        String string2;
        System.currentTimeMillis();
        d dVar = gVar.f2767e;
        e eVar4 = new e(dVar, null);
        i2.d dVar2 = (i2.d) dVar.f270g;
        if (dVar2 == null) {
            int i5 = i2.d.n;
            o oVar = (o) dVar.f267d;
            int size = oVar.size();
            String str = null;
            int i6 = 0;
            boolean z2 = true;
            boolean z3 = false;
            boolean z4 = false;
            int iY = -1;
            int iY2 = -1;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            int iY3 = -1;
            int iY4 = -1;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            while (i6 < size) {
                String strB = oVar.b(i6);
                String strE = oVar.e(i6);
                if (l.w(strB, "Cache-Control")) {
                    if (str == null) {
                        str = strE;
                    }
                    i4 = 0;
                    while (i4 < strE.length()) {
                        length = strE.length();
                        length2 = i4;
                        while (true) {
                            if (length2 < length) {
                                eVar3 = eVar4;
                                length2 = strE.length();
                                break;
                            }
                            eVar3 = eVar4;
                            if (v1.d.A("=,;", strE.charAt(length2))) {
                                break;
                            }
                            length2++;
                            eVar4 = eVar3;
                        }
                        string = v1.d.J(strE.substring(i4, length2)).toString();
                        if (length2 != strE.length() || strE.charAt(length2) == ',' || strE.charAt(length2) == ';') {
                            i4 = length2 + 1;
                            string2 = null;
                        } else {
                            int length3 = length2 + 1;
                            byte[] bArr = j2.b.f2361a;
                            int length4 = strE.length();
                            while (true) {
                                if (length3 >= length4) {
                                    length3 = strE.length();
                                    break;
                                }
                                char cCharAt = strE.charAt(length3);
                                if (cCharAt != ' ' && cCharAt != '\t') {
                                    break;
                                }
                                length3++;
                            }
                            if (length3 >= strE.length() || strE.charAt(length3) != '\"') {
                                int length5 = strE.length();
                                int length6 = length3;
                                while (true) {
                                    if (length6 >= length5) {
                                        length6 = strE.length();
                                        break;
                                    }
                                    int i7 = length5;
                                    if (v1.d.A(",;", strE.charAt(length6))) {
                                        break;
                                    }
                                    length6++;
                                    length5 = i7;
                                }
                                int i8 = length6;
                                string2 = v1.d.J(strE.substring(length3, length6)).toString();
                                i4 = i8;
                            } else {
                                int i9 = length3 + 1;
                                int iD = v1.d.D(strE, '\"', i9, 4);
                                string2 = strE.substring(i9, iD);
                                i4 = iD + 1;
                            }
                        }
                        if ("no-cache".equalsIgnoreCase(string)) {
                            z3 = true;
                        } else if ("no-store".equalsIgnoreCase(string)) {
                            z4 = true;
                        } else if ("max-age".equalsIgnoreCase(string)) {
                            iY = j2.b.y(string2, -1);
                        } else if ("s-maxage".equalsIgnoreCase(string)) {
                            iY2 = j2.b.y(string2, -1);
                        } else if ("private".equalsIgnoreCase(string)) {
                            z5 = true;
                        } else if ("public".equalsIgnoreCase(string)) {
                            z6 = true;
                        } else if ("must-revalidate".equalsIgnoreCase(string)) {
                            z7 = true;
                        } else if ("max-stale".equalsIgnoreCase(string)) {
                            iY3 = j2.b.y(string2, Integer.MAX_VALUE);
                        } else if ("min-fresh".equalsIgnoreCase(string)) {
                            iY4 = j2.b.y(string2, -1);
                        } else if ("only-if-cached".equalsIgnoreCase(string)) {
                            z8 = true;
                        } else if ("no-transform".equalsIgnoreCase(string)) {
                            z9 = true;
                        } else if ("immutable".equalsIgnoreCase(string)) {
                            z10 = true;
                        }
                        eVar4 = eVar3;
                    }
                    i6++;
                    eVar4 = eVar4;
                } else {
                    if (l.w(strB, "Pragma")) {
                    }
                    i6++;
                    eVar4 = eVar4;
                }
                z2 = false;
                i4 = 0;
                while (i4 < strE.length()) {
                    length = strE.length();
                    length2 = i4;
                    while (true) {
                        if (length2 < length) {
                            eVar3 = eVar4;
                            length2 = strE.length();
                            break;
                        }
                        eVar3 = eVar4;
                        if (v1.d.A("=,;", strE.charAt(length2))) {
                            break;
                            break;
                        }
                        length2++;
                        eVar4 = eVar3;
                    }
                    string = v1.d.J(strE.substring(i4, length2)).toString();
                    if (length2 != strE.length()) {
                        i4 = length2 + 1;
                        string2 = null;
                    } else {
                        i4 = length2 + 1;
                        string2 = null;
                    }
                    if ("no-cache".equalsIgnoreCase(string)) {
                        z3 = true;
                    } else if ("no-store".equalsIgnoreCase(string)) {
                        z4 = true;
                    } else if ("max-age".equalsIgnoreCase(string)) {
                        iY = j2.b.y(string2, -1);
                    } else if ("s-maxage".equalsIgnoreCase(string)) {
                        iY2 = j2.b.y(string2, -1);
                    } else if ("private".equalsIgnoreCase(string)) {
                        z5 = true;
                    } else if ("public".equalsIgnoreCase(string)) {
                        z6 = true;
                    } else if ("must-revalidate".equalsIgnoreCase(string)) {
                        z7 = true;
                    } else if ("max-stale".equalsIgnoreCase(string)) {
                        iY3 = j2.b.y(string2, Integer.MAX_VALUE);
                    } else if ("min-fresh".equalsIgnoreCase(string)) {
                        iY4 = j2.b.y(string2, -1);
                    } else if ("only-if-cached".equalsIgnoreCase(string)) {
                        z8 = true;
                    } else if ("no-transform".equalsIgnoreCase(string)) {
                        z9 = true;
                    } else if ("immutable".equalsIgnoreCase(string)) {
                        z10 = true;
                    }
                    eVar4 = eVar3;
                }
                i6++;
                eVar4 = eVar4;
            }
            eVar = eVar4;
            i2.d dVar3 = new i2.d(z3, z4, iY, iY2, z5, z6, z7, iY3, iY4, z8, z9, z10, !z2 ? null : str);
            dVar.f270g = dVar3;
            dVar2 = dVar3;
        } else {
            eVar = eVar4;
        }
        if (dVar2.f2139j) {
            Object obj = null;
            eVar2 = new e(obj, obj);
        } else {
            eVar2 = eVar;
        }
        d dVar4 = (d) eVar2.f5976c;
        y yVar = (y) eVar2.f5977d;
        if (dVar4 == null && yVar == null) {
            return new y(dVar, v.f2262e, "Unsatisfiable Request (only-if-cached)", 504, null, new o((String[]) new ArrayList(20).toArray(new String[0])), j2.b.f2363c, null, null, null, -1L, System.currentTimeMillis(), null);
        }
        if (dVar4 == null) {
            yVar.getClass();
            x xVarW = yVar.w();
            y yVarA = a.a(yVar);
            x.b(yVarA, "cacheResponse");
            xVarW.f2282i = yVarA;
            return xVarW.a();
        }
        y yVarB = gVar.b(dVar4);
        if (yVar != null) {
            if (yVarB.f2290f == 304) {
                x xVarW2 = yVar.w();
                o oVar2 = yVar.f2292h;
                o oVar3 = yVarB.f2292h;
                ArrayList arrayList = new ArrayList(20);
                int i10 = 0;
                for (int size2 = oVar2.size(); i10 < size2; size2 = i3) {
                    String strB2 = oVar2.b(i10);
                    String strE2 = oVar2.e(i10);
                    if ("Warning".equalsIgnoreCase(strB2)) {
                        i3 = size2;
                        if (l.z(strE2, "1", false)) {
                        }
                        i10++;
                    } else {
                        i3 = size2;
                    }
                    if ("Content-Length".equalsIgnoreCase(strB2) || "Content-Encoding".equalsIgnoreCase(strB2) || "Content-Type".equalsIgnoreCase(strB2) || !a.b(strB2) || oVar3.a(strB2) == null) {
                        strB2.getClass();
                        strE2.getClass();
                        arrayList.add(strB2);
                        arrayList.add(v1.d.J(strE2).toString());
                    }
                    i10++;
                }
                int size3 = oVar3.size();
                for (int i11 = 0; i11 < size3; i11++) {
                    String strB3 = oVar3.b(i11);
                    if (!"Content-Length".equalsIgnoreCase(strB3) && !"Content-Encoding".equalsIgnoreCase(strB3) && !"Content-Type".equalsIgnoreCase(strB3) && a.b(strB3)) {
                        String strE3 = oVar3.e(i11);
                        strB3.getClass();
                        strE3.getClass();
                        arrayList.add(strB3);
                        arrayList.add(v1.d.J(strE3).toString());
                    }
                }
                String[] strArr = (String[]) arrayList.toArray(new String[0]);
                n1 n1Var = new n1(9);
                ArrayList arrayList2 = (ArrayList) n1Var.f905c;
                arrayList2.getClass();
                strArr.getClass();
                List listAsList = Arrays.asList(strArr);
                listAsList.getClass();
                arrayList2.addAll(listAsList);
                xVarW2.f2279f = n1Var;
                xVarW2.f2284k = yVarB.f2297m;
                xVarW2.f2285l = yVarB.n;
                y yVarA2 = a.a(yVar);
                x.b(yVarA2, "cacheResponse");
                xVarW2.f2282i = yVarA2;
                y yVarA3 = a.a(yVarB);
                x.b(yVarA3, "networkResponse");
                xVarW2.f2281h = yVarA3;
                xVarW2.a();
                a0 a0Var = yVarB.f2293i;
                a0Var.getClass();
                a0Var.close();
                throw null;
            }
            a0 a0Var2 = yVar.f2293i;
            if (a0Var2 != null) {
                j2.b.d(a0Var2);
            }
        }
        x xVarW3 = yVarB.w();
        y yVarA4 = a.a(yVar);
        x.b(yVarA4, "cacheResponse");
        xVarW3.f2282i = yVarA4;
        y yVarA5 = a.a(yVarB);
        x.b(yVarA5, "networkResponse");
        xVarW3.f2281h = yVarA5;
        return xVarW3.a();
    }
}
