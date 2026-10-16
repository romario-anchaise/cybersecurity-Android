// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c1;

import F0.i;
import X0.B;
import X0.C;
import X0.D;
import X0.G;
import X0.n;
import X0.r;
import X0.y;
import b1.j;
import b1.m;
import e1.C0108a;
import f1.l;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: loaded from: classes.dex */
public final class b implements r {
    /* JADX WARN: Code duplicated, block: B:101:0x0182  */
    /* JADX WARN: Code duplicated, block: B:103:0x0186 A[Catch: IOException -> 0x0145, TRY_ENTER, TryCatch #9 {IOException -> 0x0145, blocks: (B:78:0x0109, B:86:0x0124, B:88:0x012d, B:89:0x0130, B:92:0x0148, B:94:0x0169, B:103:0x0186, B:107:0x0193, B:109:0x01a4, B:111:0x01ae, B:112:0x01b8, B:96:0x0173), top: B:135:0x0109 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x018b  */
    /* JADX WARN: Code duplicated, block: B:107:0x0193 A[Catch: IOException -> 0x0145, TryCatch #9 {IOException -> 0x0145, blocks: (B:78:0x0109, B:86:0x0124, B:88:0x012d, B:89:0x0130, B:92:0x0148, B:94:0x0169, B:103:0x0186, B:107:0x0193, B:109:0x01a4, B:111:0x01ae, B:112:0x01b8, B:96:0x0173), top: B:135:0x0109 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x01a4 A[Catch: IOException -> 0x0145, TryCatch #9 {IOException -> 0x0145, blocks: (B:78:0x0109, B:86:0x0124, B:88:0x012d, B:89:0x0130, B:92:0x0148, B:94:0x0169, B:103:0x0186, B:107:0x0193, B:109:0x01a4, B:111:0x01ae, B:112:0x01b8, B:96:0x0173), top: B:135:0x0109 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:115:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:117:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:119:0x01c3 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:64:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:71:0x00f1 A[Catch: IOException -> 0x00fe, TryCatch #11 {IOException -> 0x00fe, blocks: (B:69:0x00e8, B:71:0x00f1, B:76:0x0100), top: B:139:0x00e8 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x00fb A[PHI: r16
  0x00fb: PHI (r16v3 X0.C) = (r16v2 X0.C), (r16v4 X0.C) binds: [B:67:0x00e5, B:70:0x00ef] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:80:0x0119  */
    /* JADX WARN: Code duplicated, block: B:81:0x011b  */
    /* JADX WARN: Code duplicated, block: B:88:0x012d A[Catch: IOException -> 0x0145, TryCatch #9 {IOException -> 0x0145, blocks: (B:78:0x0109, B:86:0x0124, B:88:0x012d, B:89:0x0130, B:92:0x0148, B:94:0x0169, B:103:0x0186, B:107:0x0193, B:109:0x01a4, B:111:0x01ae, B:112:0x01b8, B:96:0x0173), top: B:135:0x0109 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0169 A[Catch: IOException -> 0x0145, TryCatch #9 {IOException -> 0x0145, blocks: (B:78:0x0109, B:86:0x0124, B:88:0x012d, B:89:0x0130, B:92:0x0148, B:94:0x0169, B:103:0x0186, B:107:0x0193, B:109:0x01a4, B:111:0x01ae, B:112:0x01b8, B:96:0x0173), top: B:135:0x0109 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x0173 A[Catch: IOException -> 0x0145, TRY_LEAVE, TryCatch #9 {IOException -> 0x0145, blocks: (B:78:0x0109, B:86:0x0124, B:88:0x012d, B:89:0x0130, B:92:0x0148, B:94:0x0169, B:103:0x0186, B:107:0x0193, B:109:0x01a4, B:111:0x01ae, B:112:0x01b8, B:96:0x0173), top: B:135:0x0109 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x017e  */
    @Override // X0.r
    public final D a(f fVar) throws Throwable {
        C c2;
        IOException iOException;
        C c3;
        D dA;
        int i2;
        D dA2;
        G g;
        long jA;
        Long lValueOf;
        IOException iOException2;
        C c4;
        boolean z2;
        boolean z3;
        b1.e eVar = fVar.f2187d;
        i.b(eVar);
        j jVar = eVar.f2113a;
        d dVar = eVar.f2115c;
        m mVar = eVar.f2117e;
        y yVar = fVar.f2188e;
        B b2 = (B) yVar.f1101e;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z4 = true;
        try {
            try {
                i.e(jVar, "call");
                dVar.g(yVar);
                try {
                    if (!f1.d.u((String) yVar.f1098b) || b2 == null) {
                        iOException2 = null;
                        jVar.k(eVar, true, false, null);
                        c2 = null;
                    } else {
                        try {
                            if ("100-continue".equalsIgnoreCase(((n) yVar.f1100d).a("Expect"))) {
                                try {
                                    dVar.d();
                                    c4 = eVar.c(true);
                                    try {
                                        i.e(jVar, "call");
                                        z2 = false;
                                    } catch (IOException e2) {
                                        e = e2;
                                        c2 = c4;
                                        if (e instanceof C0108a) {
                                            throw e;
                                        }
                                        throw e;
                                    }
                                } catch (IOException e3) {
                                    i.e(jVar, "call");
                                    eVar.d(e3);
                                    throw e3;
                                }
                            } else {
                                z2 = true;
                                c4 = null;
                            }
                            try {
                                if (c4 == null) {
                                    try {
                                        B b3 = (B) yVar.f1101e;
                                        i.b(b3);
                                        long jA2 = b3.a();
                                        i.e(jVar, "call");
                                        c2 = c4;
                                        try {
                                            z3 = z2;
                                            k1.B bE = l.e(new b1.c(eVar, dVar.e(yVar, jA2), jA2));
                                            b2.c(bE);
                                            bE.close();
                                        } catch (IOException e4) {
                                            e = e4;
                                            z3 = z2;
                                            z4 = z3;
                                            if ((e instanceof C0108a) || !eVar.f2116d) {
                                                throw e;
                                            }
                                            iOException = e;
                                            if (c2 != null) {
                                                c3 = c2;
                                                c3.f892a = yVar;
                                                c3.f896e = mVar.f2152e;
                                                c3.f901k = jCurrentTimeMillis;
                                                c3.f902l = System.currentTimeMillis();
                                                dA = c3.a();
                                                i2 = dA.f907d;
                                                if (i2 != 100) {
                                                    C c5 = eVar.c(false);
                                                    i.b(c5);
                                                    if (z4) {
                                                        i.e(jVar, "call");
                                                    }
                                                    c5.f892a = yVar;
                                                    c5.f896e = mVar.f2152e;
                                                    c5.f901k = jCurrentTimeMillis;
                                                    c5.f902l = System.currentTimeMillis();
                                                    dA = c5.a();
                                                    i2 = dA.f907d;
                                                } else {
                                                    C c6 = eVar.c(false);
                                                    i.b(c6);
                                                    if (z4) {
                                                        i.e(jVar, "call");
                                                    }
                                                    c6.f892a = yVar;
                                                    c6.f896e = mVar.f2152e;
                                                    c6.f901k = jCurrentTimeMillis;
                                                    c6.f902l = System.currentTimeMillis();
                                                    dA = c6.a();
                                                    i2 = dA.f907d;
                                                }
                                                i.e(jVar, "call");
                                                C cJ = dA.j();
                                                cJ.g = eVar.b(dA);
                                                dA2 = cJ.a();
                                                if ("close".equalsIgnoreCase(((n) dA2.f904a.f1100d).a("Connection"))) {
                                                    dVar.h().k();
                                                } else {
                                                    dVar.h().k();
                                                }
                                                if (i2 != 204) {
                                                    g = dA2.g;
                                                    if (g != null) {
                                                        jA = g.a();
                                                    } else {
                                                        jA = -1;
                                                    }
                                                    if (jA > 0) {
                                                        StringBuilder sb = new StringBuilder("HTTP ");
                                                        sb.append(i2);
                                                        sb.append(" had non-zero Content-Length: ");
                                                        if (g != null) {
                                                            lValueOf = Long.valueOf(g.a());
                                                        } else {
                                                            lValueOf = null;
                                                        }
                                                        sb.append(lValueOf);
                                                        throw new ProtocolException(sb.toString());
                                                    }
                                                } else {
                                                    g = dA2.g;
                                                    if (g != null) {
                                                        jA = g.a();
                                                    } else {
                                                        jA = -1;
                                                    }
                                                    if (jA > 0) {
                                                        StringBuilder sb2 = new StringBuilder("HTTP ");
                                                        sb2.append(i2);
                                                        sb2.append(" had non-zero Content-Length: ");
                                                        if (g != null) {
                                                            lValueOf = Long.valueOf(g.a());
                                                        } else {
                                                            lValueOf = null;
                                                        }
                                                        sb2.append(lValueOf);
                                                        throw new ProtocolException(sb2.toString());
                                                    }
                                                }
                                                return dA2;
                                            }
                                            try {
                                                c2 = eVar.c(false);
                                                i.b(c2);
                                                if (z4) {
                                                    i.e(jVar, "call");
                                                    c3 = c2;
                                                    z4 = false;
                                                } else {
                                                    c3 = c2;
                                                }
                                                c3.f892a = yVar;
                                                c3.f896e = mVar.f2152e;
                                                c3.f901k = jCurrentTimeMillis;
                                                try {
                                                    c3.f902l = System.currentTimeMillis();
                                                    dA = c3.a();
                                                    i2 = dA.f907d;
                                                    if (i2 != 100) {
                                                        C c7 = eVar.c(false);
                                                        i.b(c7);
                                                        if (z4) {
                                                            i.e(jVar, "call");
                                                        }
                                                        c7.f892a = yVar;
                                                        c7.f896e = mVar.f2152e;
                                                        c7.f901k = jCurrentTimeMillis;
                                                        c7.f902l = System.currentTimeMillis();
                                                        dA = c7.a();
                                                        i2 = dA.f907d;
                                                    } else {
                                                        C c8 = eVar.c(false);
                                                        i.b(c8);
                                                        if (z4) {
                                                            i.e(jVar, "call");
                                                        }
                                                        c8.f892a = yVar;
                                                        c8.f896e = mVar.f2152e;
                                                        c8.f901k = jCurrentTimeMillis;
                                                        c8.f902l = System.currentTimeMillis();
                                                        dA = c8.a();
                                                        i2 = dA.f907d;
                                                    }
                                                    i.e(jVar, "call");
                                                    C cJ2 = dA.j();
                                                    cJ2.g = eVar.b(dA);
                                                    dA2 = cJ2.a();
                                                    if ("close".equalsIgnoreCase(((n) dA2.f904a.f1100d).a("Connection"))) {
                                                        dVar.h().k();
                                                    } else {
                                                        dVar.h().k();
                                                    }
                                                    if (i2 != 204) {
                                                        g = dA2.g;
                                                        if (g != null) {
                                                            jA = g.a();
                                                        } else {
                                                            jA = -1;
                                                        }
                                                        if (jA > 0) {
                                                            StringBuilder sb3 = new StringBuilder("HTTP ");
                                                            sb3.append(i2);
                                                            sb3.append(" had non-zero Content-Length: ");
                                                            if (g != null) {
                                                                lValueOf = Long.valueOf(g.a());
                                                            } else {
                                                                lValueOf = null;
                                                            }
                                                            sb3.append(lValueOf);
                                                            throw new ProtocolException(sb3.toString());
                                                        }
                                                    } else {
                                                        g = dA2.g;
                                                        if (g != null) {
                                                            jA = g.a();
                                                        } else {
                                                            jA = -1;
                                                        }
                                                        if (jA > 0) {
                                                            StringBuilder sb4 = new StringBuilder("HTTP ");
                                                            sb4.append(i2);
                                                            sb4.append(" had non-zero Content-Length: ");
                                                            if (g != null) {
                                                                lValueOf = Long.valueOf(g.a());
                                                            } else {
                                                                lValueOf = null;
                                                            }
                                                            sb4.append(lValueOf);
                                                            throw new ProtocolException(sb4.toString());
                                                        }
                                                    }
                                                    return dA2;
                                                } catch (IOException e5) {
                                                    e = e5;
                                                }
                                            } catch (IOException e6) {
                                                e = e6;
                                            }
                                            if (iOException != 0) {
                                                throw e;
                                            }
                                            IOException iOException3 = iOException;
                                            p029q.j.a(iOException3, e);
                                            throw iOException3;
                                        }
                                    } catch (IOException e7) {
                                        e = e7;
                                        c2 = c4;
                                    }
                                } else {
                                    c2 = c4;
                                    z3 = z2;
                                    jVar.k(eVar, true, false, null);
                                    if (mVar.g == null) {
                                        z4 = false;
                                    }
                                    if (!z4) {
                                        dVar.h().k();
                                    }
                                }
                                z4 = z3;
                                iOException2 = null;
                            } catch (IOException e8) {
                                e = e8;
                            }
                        } catch (IOException e9) {
                            e = e9;
                            c2 = null;
                        }
                    }
                    try {
                        dVar.a();
                        iOException = iOException2;
                        if (c2 != null) {
                            c2 = eVar.c(false);
                            i.b(c2);
                            if (z4) {
                                i.e(jVar, "call");
                                c3 = c2;
                                z4 = false;
                            } else {
                                c3 = c2;
                            }
                            c3.f892a = yVar;
                            c3.f896e = mVar.f2152e;
                            c3.f901k = jCurrentTimeMillis;
                            c3.f902l = System.currentTimeMillis();
                            dA = c3.a();
                            i2 = dA.f907d;
                            if (i2 != 100 || (102 <= i2 && i2 < 200)) {
                                C c9 = eVar.c(false);
                                i.b(c9);
                                if (z4) {
                                    i.e(jVar, "call");
                                }
                                c9.f892a = yVar;
                                c9.f896e = mVar.f2152e;
                                c9.f901k = jCurrentTimeMillis;
                                c9.f902l = System.currentTimeMillis();
                                dA = c9.a();
                                i2 = dA.f907d;
                            }
                            i.e(jVar, "call");
                            C cJ3 = dA.j();
                            cJ3.g = eVar.b(dA);
                            dA2 = cJ3.a();
                            if ("close".equalsIgnoreCase(((n) dA2.f904a.f1100d).a("Connection")) || "close".equalsIgnoreCase(D.a(dA2, "Connection"))) {
                                dVar.h().k();
                            }
                            if (i2 != 204 || i2 == 205) {
                                g = dA2.g;
                                if (g != null) {
                                    jA = g.a();
                                } else {
                                    jA = -1;
                                }
                                if (jA > 0) {
                                    StringBuilder sb5 = new StringBuilder("HTTP ");
                                    sb5.append(i2);
                                    sb5.append(" had non-zero Content-Length: ");
                                    if (g != null) {
                                        lValueOf = Long.valueOf(g.a());
                                    } else {
                                        lValueOf = null;
                                    }
                                    sb5.append(lValueOf);
                                    throw new ProtocolException(sb5.toString());
                                }
                            }
                            return dA2;
                        }
                        c3 = c2;
                        c3.f892a = yVar;
                        c3.f896e = mVar.f2152e;
                        c3.f901k = jCurrentTimeMillis;
                        c3.f902l = System.currentTimeMillis();
                        dA = c3.a();
                        i2 = dA.f907d;
                        if (i2 != 100) {
                            C c10 = eVar.c(false);
                            i.b(c10);
                            if (z4) {
                                i.e(jVar, "call");
                            }
                            c10.f892a = yVar;
                            c10.f896e = mVar.f2152e;
                            c10.f901k = jCurrentTimeMillis;
                            c10.f902l = System.currentTimeMillis();
                            dA = c10.a();
                            i2 = dA.f907d;
                        } else {
                            C c11 = eVar.c(false);
                            i.b(c11);
                            if (z4) {
                                i.e(jVar, "call");
                            }
                            c11.f892a = yVar;
                            c11.f896e = mVar.f2152e;
                            c11.f901k = jCurrentTimeMillis;
                            c11.f902l = System.currentTimeMillis();
                            dA = c11.a();
                            i2 = dA.f907d;
                        }
                        i.e(jVar, "call");
                        C cJ4 = dA.j();
                        cJ4.g = eVar.b(dA);
                        dA2 = cJ4.a();
                        if ("close".equalsIgnoreCase(((n) dA2.f904a.f1100d).a("Connection"))) {
                            dVar.h().k();
                        } else {
                            dVar.h().k();
                        }
                        if (i2 != 204) {
                            g = dA2.g;
                            if (g != null) {
                                jA = g.a();
                            } else {
                                jA = -1;
                            }
                            if (jA > 0) {
                                StringBuilder sb6 = new StringBuilder("HTTP ");
                                sb6.append(i2);
                                sb6.append(" had non-zero Content-Length: ");
                                if (g != null) {
                                    lValueOf = Long.valueOf(g.a());
                                } else {
                                    lValueOf = null;
                                }
                                sb6.append(lValueOf);
                                throw new ProtocolException(sb6.toString());
                            }
                        } else {
                            g = dA2.g;
                            if (g != null) {
                                jA = g.a();
                            } else {
                                jA = -1;
                            }
                            if (jA > 0) {
                                StringBuilder sb7 = new StringBuilder("HTTP ");
                                sb7.append(i2);
                                sb7.append(" had non-zero Content-Length: ");
                                if (g != null) {
                                    lValueOf = Long.valueOf(g.a());
                                } else {
                                    lValueOf = null;
                                }
                                sb7.append(lValueOf);
                                throw new ProtocolException(sb7.toString());
                            }
                        }
                        return dA2;
                        if (iOException != 0) {
                            throw e;
                        }
                        IOException iOException4 = iOException;
                        p029q.j.a(iOException4, e);
                        throw iOException4;
                    } catch (IOException e10) {
                        try {
                            eVar.d(e10);
                            throw e10;
                        } catch (IOException e11) {
                            e = e11;
                            if (e instanceof C0108a) {
                                throw e;
                            }
                            throw e;
                        }
                    }
                } catch (IOException e12) {
                    e = e12;
                    c2 = null;
                    if (e instanceof C0108a) {
                        throw e;
                    }
                    throw e;
                }
            } catch (IOException e13) {
                i.e(jVar, "call");
                eVar.d(e13);
                throw e13;
            }
        } catch (IOException e14) {
            e = e14;
        }
    }
}
