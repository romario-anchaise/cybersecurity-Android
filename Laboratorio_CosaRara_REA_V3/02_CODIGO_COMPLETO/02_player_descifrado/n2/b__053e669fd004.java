// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package n2;

import g.j;
import g0.k;
import i2.a0;
import i2.o;
import i2.r;
import i2.x;
import i2.y;
import java.io.IOException;
import java.net.ProtocolException;
import m2.i;
import m2.m;
import w2.q;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2761a;

    public b(boolean z2) {
        this.f2761a = z2;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0186 A[Catch: IOException -> 0x0124, TryCatch #10 {IOException -> 0x0124, blocks: (B:79:0x0114, B:81:0x011d, B:85:0x0129, B:93:0x014c, B:95:0x0155, B:96:0x0158, B:97:0x016c, B:101:0x0179, B:103:0x0194, B:105:0x01a7, B:112:0x01c0, B:114:0x01c4, B:118:0x01d1, B:120:0x01e4, B:122:0x01ee, B:123:0x01f8, B:107:0x01b1, B:102:0x0186), top: B:149:0x0114 }] */
    /* JADX WARN: Code duplicated, block: B:107:0x01b1 A[Catch: IOException -> 0x0124, TryCatch #10 {IOException -> 0x0124, blocks: (B:79:0x0114, B:81:0x011d, B:85:0x0129, B:93:0x014c, B:95:0x0155, B:96:0x0158, B:97:0x016c, B:101:0x0179, B:103:0x0194, B:105:0x01a7, B:112:0x01c0, B:114:0x01c4, B:118:0x01d1, B:120:0x01e4, B:122:0x01ee, B:123:0x01f8, B:107:0x01b1, B:102:0x0186), top: B:149:0x0114 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x01c0 A[Catch: IOException -> 0x0124, TryCatch #10 {IOException -> 0x0124, blocks: (B:79:0x0114, B:81:0x011d, B:85:0x0129, B:93:0x014c, B:95:0x0155, B:96:0x0158, B:97:0x016c, B:101:0x0179, B:103:0x0194, B:105:0x01a7, B:112:0x01c0, B:114:0x01c4, B:118:0x01d1, B:120:0x01e4, B:122:0x01ee, B:123:0x01f8, B:107:0x01b1, B:102:0x0186), top: B:149:0x0114 }] */
    /* JADX WARN: Code duplicated, block: B:114:0x01c4 A[Catch: IOException -> 0x0124, TryCatch #10 {IOException -> 0x0124, blocks: (B:79:0x0114, B:81:0x011d, B:85:0x0129, B:93:0x014c, B:95:0x0155, B:96:0x0158, B:97:0x016c, B:101:0x0179, B:103:0x0194, B:105:0x01a7, B:112:0x01c0, B:114:0x01c4, B:118:0x01d1, B:120:0x01e4, B:122:0x01ee, B:123:0x01f8, B:107:0x01b1, B:102:0x0186), top: B:149:0x0114 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:118:0x01d1 A[Catch: IOException -> 0x0124, TryCatch #10 {IOException -> 0x0124, blocks: (B:79:0x0114, B:81:0x011d, B:85:0x0129, B:93:0x014c, B:95:0x0155, B:96:0x0158, B:97:0x016c, B:101:0x0179, B:103:0x0194, B:105:0x01a7, B:112:0x01c0, B:114:0x01c4, B:118:0x01d1, B:120:0x01e4, B:122:0x01ee, B:123:0x01f8, B:107:0x01b1, B:102:0x0186), top: B:149:0x0114 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x01e4 A[Catch: IOException -> 0x0124, TryCatch #10 {IOException -> 0x0124, blocks: (B:79:0x0114, B:81:0x011d, B:85:0x0129, B:93:0x014c, B:95:0x0155, B:96:0x0158, B:97:0x016c, B:101:0x0179, B:103:0x0194, B:105:0x01a7, B:112:0x01c0, B:114:0x01c4, B:118:0x01d1, B:120:0x01e4, B:122:0x01ee, B:123:0x01f8, B:107:0x01b1, B:102:0x0186), top: B:149:0x0114 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:130:0x0202 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:74:0x010b  */
    /* JADX WARN: Code duplicated, block: B:78:0x0113  */
    /* JADX WARN: Code duplicated, block: B:81:0x011d A[Catch: IOException -> 0x0124, TryCatch #10 {IOException -> 0x0124, blocks: (B:79:0x0114, B:81:0x011d, B:85:0x0129, B:93:0x014c, B:95:0x0155, B:96:0x0158, B:97:0x016c, B:101:0x0179, B:103:0x0194, B:105:0x01a7, B:112:0x01c0, B:114:0x01c4, B:118:0x01d1, B:120:0x01e4, B:122:0x01ee, B:123:0x01f8, B:107:0x01b1, B:102:0x0186), top: B:149:0x0114 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0127 A[PHI: r16
  0x0127: PHI (r16v3 i2.x) = (r16v2 i2.x), (r16v4 i2.x) binds: [B:77:0x0111, B:80:0x011b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:87:0x0141  */
    /* JADX WARN: Code duplicated, block: B:95:0x0155 A[Catch: IOException -> 0x0124, TryCatch #10 {IOException -> 0x0124, blocks: (B:79:0x0114, B:81:0x011d, B:85:0x0129, B:93:0x014c, B:95:0x0155, B:96:0x0158, B:97:0x016c, B:101:0x0179, B:103:0x0194, B:105:0x01a7, B:112:0x01c0, B:114:0x01c4, B:118:0x01d1, B:120:0x01e4, B:122:0x01ee, B:123:0x01f8, B:107:0x01b1, B:102:0x0186), top: B:149:0x0114 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // i2.r
    public final y a(g gVar) throws Throwable {
        x xVarE;
        IOException iOException;
        ?? r6;
        IOException iOException2;
        x xVar;
        ?? r7;
        y yVarA;
        int i3;
        y yVarA2;
        b2.d dVar;
        a0 a0Var;
        long jD;
        a0 a0Var2;
        Object objValueOf;
        x xVar2;
        boolean z2;
        k kVar = gVar.f2766d;
        kVar.getClass();
        i iVar = (i) kVar.f1473d;
        e eVar = (e) kVar.f1476g;
        m mVar = (m) kVar.f1477h;
        i2.m mVar2 = (i2.m) kVar.f1474e;
        b2.d dVar2 = gVar.f2767e;
        j jVar = (j) dVar2.f268e;
        long jCurrentTimeMillis = System.currentTimeMillis();
        ?? r13 = 1;
        boolean z3 = true;
        r13 = 1;
        r13 = 1;
        r13 = 1;
        try {
            try {
                mVar2.getClass();
                eVar.b(dVar2);
                try {
                    if (!m0.a.o(dVar2.f265b) || jVar == null) {
                        eVar = eVar;
                        iOException = null;
                        iVar.h(kVar, true, false, null);
                        xVarE = null;
                    } else {
                        ?? r15 = "100-continue";
                        try {
                            try {
                                if ("100-continue".equalsIgnoreCase(((o) dVar2.f267d).a("Expect"))) {
                                    try {
                                        eVar.e();
                                        x xVarE2 = kVar.e(true);
                                        try {
                                            mVar2.c(iVar);
                                            xVar2 = xVarE2;
                                            z2 = false;
                                        } catch (IOException e3) {
                                            e = e3;
                                            eVar = eVar;
                                            xVarE = xVarE2;
                                            iOException = null;
                                            if (!(e instanceof p2.a) || !kVar.f1472c) {
                                                throw e;
                                            }
                                            r6 = r13;
                                            iOException2 = e;
                                            if (xVarE == null) {
                                                try {
                                                    xVarE = kVar.e(false);
                                                    xVarE.getClass();
                                                    if (r6 != 0) {
                                                        mVar2.c(iVar);
                                                        xVar = xVarE;
                                                        r7 = 0;
                                                    } else {
                                                        xVar = xVarE;
                                                        r7 = r6;
                                                    }
                                                } catch (IOException e4) {
                                                    if (iOException2 == null) {
                                                        throw e4;
                                                    }
                                                    y.f.a(iOException2, e4);
                                                    throw iOException2;
                                                }
                                            } else {
                                                xVar = xVarE;
                                                r7 = r6;
                                            }
                                            xVar.f2274a = dVar2;
                                            xVar.f2278e = mVar.f2744e;
                                            xVar.f2284k = jCurrentTimeMillis;
                                            xVar.f2285l = System.currentTimeMillis();
                                            yVarA = xVar.a();
                                            i3 = yVarA.f2290f;
                                            if (i3 != 100) {
                                                x xVarE3 = kVar.e(false);
                                                xVarE3.getClass();
                                                if (r7 != 0) {
                                                    mVar2.c(iVar);
                                                }
                                                xVarE3.f2274a = dVar2;
                                                xVarE3.f2278e = mVar.f2744e;
                                                xVarE3.f2284k = jCurrentTimeMillis;
                                                xVarE3.f2285l = System.currentTimeMillis();
                                                yVarA = xVarE3.a();
                                                i3 = yVarA.f2290f;
                                            } else {
                                                x xVarE4 = kVar.e(false);
                                                xVarE4.getClass();
                                                if (r7 != 0) {
                                                    mVar2.c(iVar);
                                                }
                                                xVarE4.f2274a = dVar2;
                                                xVarE4.f2278e = mVar.f2744e;
                                                xVarE4.f2284k = jCurrentTimeMillis;
                                                xVarE4.f2285l = System.currentTimeMillis();
                                                yVarA = xVarE4.a();
                                                i3 = yVarA.f2290f;
                                            }
                                            mVar2.getClass();
                                            if (this.f2761a) {
                                                x xVarW = yVarA.w();
                                                xVarW.f2280g = kVar.d(yVarA);
                                                yVarA2 = xVarW.a();
                                            } else {
                                                x xVarW2 = yVarA.w();
                                                xVarW2.f2280g = kVar.d(yVarA);
                                                yVarA2 = xVarW2.a();
                                            }
                                            dVar = yVarA2.f2287c;
                                            dVar.getClass();
                                            if ("close".equalsIgnoreCase(((o) dVar.f267d).a("Connection"))) {
                                                eVar.h().k();
                                            } else {
                                                eVar.h().k();
                                            }
                                            if (i3 != 204) {
                                                a0Var = yVarA2.f2293i;
                                                if (a0Var != null) {
                                                    jD = a0Var.d();
                                                } else {
                                                    jD = -1;
                                                }
                                                if (jD > 0) {
                                                    StringBuilder sb = new StringBuilder("HTTP ");
                                                    sb.append(i3);
                                                    sb.append(" had non-zero Content-Length: ");
                                                    a0Var2 = yVarA2.f2293i;
                                                    if (a0Var2 != null) {
                                                        objValueOf = Long.valueOf(a0Var2.d());
                                                    } else {
                                                        objValueOf = iOException;
                                                    }
                                                    sb.append(objValueOf);
                                                    throw new ProtocolException(sb.toString());
                                                }
                                            } else {
                                                a0Var = yVarA2.f2293i;
                                                if (a0Var != null) {
                                                    jD = a0Var.d();
                                                } else {
                                                    jD = -1;
                                                }
                                                if (jD > 0) {
                                                    StringBuilder sb2 = new StringBuilder("HTTP ");
                                                    sb2.append(i3);
                                                    sb2.append(" had non-zero Content-Length: ");
                                                    a0Var2 = yVarA2.f2293i;
                                                    if (a0Var2 != null) {
                                                        objValueOf = Long.valueOf(a0Var2.d());
                                                    } else {
                                                        objValueOf = iOException;
                                                    }
                                                    sb2.append(objValueOf);
                                                    throw new ProtocolException(sb2.toString());
                                                }
                                            }
                                            return yVarA2;
                                        }
                                    } catch (IOException e5) {
                                        mVar2.getClass();
                                        kVar.f(e5);
                                        throw e5;
                                    }
                                } else {
                                    z2 = true;
                                    xVar2 = null;
                                }
                                try {
                                    if (xVar2 == null) {
                                        try {
                                            jVar.getClass();
                                            r15 = z2;
                                            long j3 = jVar.f1413b;
                                            try {
                                                mVar2.getClass();
                                                xVarE = xVar2;
                                                try {
                                                    eVar = eVar;
                                                    q qVar = new q(new m2.c(kVar, eVar.c(dVar2, j3), j3));
                                                    byte[] bArr = (byte[]) jVar.f1415d;
                                                    int i4 = jVar.f1413b;
                                                    if (qVar.f5797e) {
                                                        throw new IllegalStateException("closed");
                                                    }
                                                    qVar.f5796d.G(i4, bArr);
                                                    qVar.d();
                                                    qVar.close();
                                                } catch (IOException e6) {
                                                    e = e6;
                                                    eVar = eVar;
                                                    r13 = r15;
                                                    iOException = null;
                                                    if (!(e instanceof p2.a)) {
                                                        throw e;
                                                    }
                                                    throw e;
                                                }
                                            } catch (IOException e7) {
                                                e = e7;
                                                r15 = r15;
                                                xVarE = xVar2;
                                                r13 = r15;
                                                iOException = null;
                                                if (!(e instanceof p2.a)) {
                                                    throw e;
                                                }
                                                throw e;
                                            }
                                        } catch (IOException e8) {
                                            e = e8;
                                            r15 = z2;
                                        }
                                    } else {
                                        eVar = eVar;
                                        r15 = z2;
                                        xVarE = xVar2;
                                        iVar.h(kVar, true, false, null);
                                        if (mVar.f2746g == null) {
                                            z3 = false;
                                        }
                                        if (!z3) {
                                            eVar.h().k();
                                        }
                                    }
                                    r13 = r15;
                                    iOException = null;
                                } catch (IOException e9) {
                                    e = e9;
                                }
                            } catch (IOException e10) {
                                e = e10;
                                eVar = eVar;
                                iOException = null;
                                xVarE = null;
                                if (!(e instanceof p2.a)) {
                                    throw e;
                                }
                                throw e;
                            }
                        } catch (IOException e11) {
                            e = e11;
                        }
                    }
                    try {
                        eVar.d();
                        r6 = r13 == true ? 1 : 0;
                        iOException2 = iOException;
                        if (xVarE == null) {
                            xVarE = kVar.e(false);
                            xVarE.getClass();
                            if (r6 != 0) {
                                mVar2.c(iVar);
                                xVar = xVarE;
                                r7 = 0;
                            } else {
                                xVar = xVarE;
                                r7 = r6;
                            }
                        } else {
                            xVar = xVarE;
                            r7 = r6;
                        }
                        xVar.f2274a = dVar2;
                        xVar.f2278e = mVar.f2744e;
                        xVar.f2284k = jCurrentTimeMillis;
                        xVar.f2285l = System.currentTimeMillis();
                        yVarA = xVar.a();
                        i3 = yVarA.f2290f;
                        if (i3 != 100 || (102 <= i3 && i3 < 200)) {
                            x xVarE5 = kVar.e(false);
                            xVarE5.getClass();
                            if (r7 != 0) {
                                mVar2.c(iVar);
                            }
                            xVarE5.f2274a = dVar2;
                            xVarE5.f2278e = mVar.f2744e;
                            xVarE5.f2284k = jCurrentTimeMillis;
                            xVarE5.f2285l = System.currentTimeMillis();
                            yVarA = xVarE5.a();
                            i3 = yVarA.f2290f;
                        }
                        mVar2.getClass();
                        if (this.f2761a || i3 != 101) {
                            x xVarW3 = yVarA.w();
                            xVarW3.f2280g = kVar.d(yVarA);
                            yVarA2 = xVarW3.a();
                        } else {
                            x xVarW4 = yVarA.w();
                            xVarW4.f2280g = j2.b.f2363c;
                            yVarA2 = xVarW4.a();
                        }
                        dVar = yVarA2.f2287c;
                        dVar.getClass();
                        if ("close".equalsIgnoreCase(((o) dVar.f267d).a("Connection")) || "close".equalsIgnoreCase(y.d(yVarA2, "Connection"))) {
                            eVar.h().k();
                        }
                        if (i3 != 204 || i3 == 205) {
                            a0Var = yVarA2.f2293i;
                            if (a0Var != null) {
                                jD = a0Var.d();
                            } else {
                                jD = -1;
                            }
                            if (jD > 0) {
                                StringBuilder sb3 = new StringBuilder("HTTP ");
                                sb3.append(i3);
                                sb3.append(" had non-zero Content-Length: ");
                                a0Var2 = yVarA2.f2293i;
                                if (a0Var2 != null) {
                                    objValueOf = Long.valueOf(a0Var2.d());
                                } else {
                                    objValueOf = iOException;
                                }
                                sb3.append(objValueOf);
                                throw new ProtocolException(sb3.toString());
                            }
                        }
                        return yVarA2;
                    } catch (IOException e12) {
                        try {
                            kVar.f(e12);
                            throw e12;
                        } catch (IOException e13) {
                            e = e13;
                            if (!(e instanceof p2.a)) {
                                throw e;
                            }
                            throw e;
                        }
                    }
                } catch (IOException e14) {
                    e = e14;
                    eVar = eVar;
                    iOException = null;
                    xVarE = null;
                    if (!(e instanceof p2.a)) {
                        throw e;
                    }
                    throw e;
                }
            } catch (IOException e15) {
                e = e15;
            }
        } catch (IOException e16) {
            mVar2.getClass();
            kVar.f(e16);
            throw e16;
        }
    }
}
