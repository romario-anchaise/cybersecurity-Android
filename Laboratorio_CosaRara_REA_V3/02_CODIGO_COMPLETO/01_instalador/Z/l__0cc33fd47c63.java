// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package Z;

import H.C0028c;
import N0.C0033e;
import N0.C0041m;
import W.n;
import W.q;
import X0.C0056c;
import X0.D;
import X0.G;
import X0.InterfaceC0057d;
import X0.s;
import X0.w;
import X0.y;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.NetworkOnMainThreadException;
import android.webkit.MimeTypeMap;
import java.io.IOException;
import java.util.Map;
import k1.C;
import k1.C0196l;
import k1.InterfaceC0195k;
import k1.o;
import k1.z;

/* JADX INFO: loaded from: classes.dex */
public final class l implements g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0056c f1147f = new C0056c(true, true, -1, -1, false, false, false, -1, -1, false, false, false, null);
    public static final C0056c g = new C0056c(true, false, -1, -1, false, false, false, -1, -1, true, false, false, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p010f0.m f1149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p034t0.g f1151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f1152e;

    public l(String str, p010f0.m mVar, p034t0.b bVar, p034t0.g gVar, boolean z2) {
        this.f1148a = str;
        this.f1149b = mVar;
        this.f1150c = bVar;
        this.f1151d = gVar;
        this.f1152e = z2;
    }

    public static String d(String str, s sVar) {
        String strB;
        String str2 = sVar != null ? sVar.f1032a : null;
        if ((str2 == null || M0.m.R(str2, "text/plain", false)) && (strB = p016j0.f.b(MimeTypeMap.getSingleton(), str)) != null) {
            return strB;
        }
        if (str2 == null) {
            return null;
        }
        int iX = M0.e.X(str2, ';', 0, false, 6);
        if (iX == -1) {
            return str2;
        }
        String strSubstring = str2.substring(0, iX);
        F0.i.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0201 A[Catch: Exception -> 0x01fe, TryCatch #1 {Exception -> 0x01fe, blocks: (B:93:0x01d2, B:95:0x01d8, B:99:0x01fa, B:103:0x0201, B:104:0x0206), top: B:114:0x01d2 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x009c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:95:0x01d8 A[Catch: Exception -> 0x01fe, TryCatch #1 {Exception -> 0x01fe, blocks: (B:93:0x01d2, B:95:0x01d8, B:99:0x01fa, B:103:0x0201, B:104:0x0206), top: B:114:0x01d2 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:98:0x01f9  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r12v8, types: [X.i] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [Z.l] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r18v0, types: [Z.l] */
    /* JADX WARN: Type inference failed for: r2v10, types: [Z.l, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.lang.Object, t0.b] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, t0.b] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object, t0.b] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v10, types: [X.i] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v16 */
    @Override // Z.g
    public final Object a(p040w0.d dVar) throws Exception {
        k kVar;
        ?? r12;
        X.i iVar;
        p008e0.d dVarA;
        ?? r13;
        p008e0.d dVar2;
        p008e0.b bVar;
        X.j jVar;
        X.i iVar2;
        ?? r4;
        D d2;
        ?? r2;
        D d3;
        G g2;
        if (dVar instanceof k) {
            kVar = (k) dVar;
            int i2 = kVar.f1146i;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                kVar.f1146i = i2 - Integer.MIN_VALUE;
            } else {
                kVar = new k(this, (p044y0.c) dVar);
            }
        } else {
            kVar = new k(this, (p044y0.c) dVar);
        }
        Object objB = kVar.g;
        p042x0.a aVar = p042x0.a.f4189a;
        ?? r5 = kVar.f1146i;
        W.g gVar = W.g.f752d;
        W.g gVar2 = W.g.f751c;
        try {
            if (r5 == 0) {
                p029q.j.o(objB);
                p010f0.m mVar = this.f1149b;
                boolean z2 = mVar.f2678n.f2602a;
                String str = this.f1148a;
                if (!z2 || (jVar = (X.j) this.f1151d.getValue()) == null) {
                    iVar = null;
                } else {
                    String str2 = mVar.f2673i;
                    if (str2 == null) {
                        str2 = str;
                    }
                    C0196l c0196l = C0196l.f3483d;
                    X.d dVarJ = jVar.f887b.j(C0028c.p(str2).b("SHA-256").d());
                    if (dVarJ != null) {
                        iVar2 = new X.i(dVarJ);
                    } else {
                        iVar = null;
                    }
                }
                if (iVar != null) {
                    o oVarC = c();
                    X.d dVar3 = iVar.f885a;
                    if (dVar3.f863b) {
                        iVar = iVar2;
                        throw new IllegalStateException("snapshot is closed");
                    }
                    Long l2 = oVarC.e((z) dVar3.f862a.f856c.get(0)).f3493d;
                    if (l2 == null) {
                        iVar = iVar2;
                    } else if (l2.longValue() == 0) {
                        iVar = iVar2;
                        return new m(g(iVar), d(str, null), gVar2);
                    }
                    iVar = iVar2;
                    if (!this.f1152e) {
                        n nVarG = g(iVar);
                        p008e0.b bVarF = f(iVar);
                        return new m(nVarG, d(str, bVarF != null ? (s) bVarF.f2254b.getValue() : null), gVar2);
                    }
                    dVarA = new p008e0.c(e(), f(iVar)).a();
                    if (dVarA.f2269a == null && (bVar = dVarA.f2270b) != null) {
                        return new m(g(iVar), d(str, (s) bVar.f2254b.getValue()), gVar2);
                    }
                } else {
                    iVar = iVar2;
                    dVarA = new p008e0.c(e(), null).a();
                }
                y yVar = dVarA.f2269a;
                F0.i.b(yVar);
                kVar.f1142d = this;
                kVar.f1143e = iVar;
                kVar.f1144f = dVarA;
                kVar.f1146i = 1;
                Object objB2 = b(yVar, kVar);
                if (objB2 == aVar) {
                    return aVar;
                }
                r13 = this;
                dVar2 = dVarA;
                objB = objB2;
                r4 = iVar;
            } else {
                if (r5 != 1) {
                    if (r5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d2 = (D) kVar.f1144f;
                    X.i iVar3 = kVar.f1143e;
                    l lVar = kVar.f1142d;
                    try {
                        p029q.j.o(objB);
                        r2 = lVar;
                        d3 = (D) objB;
                        try {
                            Bitmap.Config config = p016j0.f.f3375a;
                            g2 = d3.g;
                            if (g2 != null) {
                                throw new IllegalStateException("response body == null");
                            }
                            r2.getClass();
                            InterfaceC0195k interfaceC0195kJ = g2.j();
                            Context context = r2.f1149b.f2666a;
                            q qVar = new q(interfaceC0195kJ, null);
                            String strD = d(r2.f1148a, g2.f());
                            if (d3.f910h != null) {
                                gVar = gVar2;
                            }
                            return new m(qVar, strD, gVar);
                        } catch (Exception e2) {
                            e = e2;
                            d2 = d3;
                            p016j0.f.a(d2);
                            throw e;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        p016j0.f.a(d2);
                        throw e;
                    }
                }
                p008e0.d dVar4 = (p008e0.d) kVar.f1144f;
                r12 = kVar.f1143e;
                l lVar2 = kVar.f1142d;
                try {
                    p029q.j.o(objB);
                    dVar2 = dVar4;
                    r4 = r12;
                    r13 = lVar2;
                } catch (Exception e4) {
                    e = e4;
                    if (r12 != 0) {
                        p016j0.f.a(r12);
                    }
                    throw e;
                }
            }
            D d4 = (D) objB;
            Bitmap.Config config2 = p016j0.f.f3375a;
            G g3 = d4.g;
            if (g3 == null) {
                throw new IllegalStateException("response body == null");
            }
            try {
                X.i iVarH = r13.h(r4, dVar2.f2269a, d4, dVar2.f2270b);
                String str3 = r13.f1148a;
                if (iVarH != null) {
                    n nVarG2 = r13.g(iVarH);
                    p008e0.b bVarF2 = r13.f(iVarH);
                    return new m(nVarG2, d(str3, bVarF2 != null ? (s) bVarF2.f2254b.getValue() : null), gVar);
                }
                if (g3.a() > 0) {
                    InterfaceC0195k interfaceC0195kJ2 = g3.j();
                    Context context2 = r13.f1149b.f2666a;
                    q qVar2 = new q(interfaceC0195kJ2, null);
                    String strD2 = d(str3, g3.f());
                    if (d4.f910h == null) {
                        gVar = gVar2;
                    }
                    return new m(qVar2, strD2, gVar);
                }
                p016j0.f.a(d4);
                y yVarE = r13.e();
                kVar.f1142d = r13;
                kVar.f1143e = iVarH;
                kVar.f1144f = d4;
                kVar.f1146i = 2;
                objB = r13.b(yVarE, kVar);
                if (objB == aVar) {
                    return aVar;
                }
                r2 = r13;
                d2 = d4;
                d3 = (D) objB;
                Bitmap.Config config3 = p016j0.f.f3375a;
                g2 = d3.g;
                if (g2 != null) {
                    throw new IllegalStateException("response body == null");
                }
                r2.getClass();
                InterfaceC0195k interfaceC0195kJ3 = g2.j();
                Context context3 = r2.f1149b.f2666a;
                q qVar3 = new q(interfaceC0195kJ3, null);
                String strD3 = d(r2.f1148a, g2.f());
                if (d3.f910h != null) {
                    gVar = gVar2;
                }
                return new m(qVar3, strD3, gVar);
            } catch (Exception e5) {
                e = e5;
                d2 = d4;
                p016j0.f.a(d2);
                throw e;
            }
        } catch (Exception e6) {
            e = e6;
            r12 = r5;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, t0.b] */
    public final Object b(y yVar, p044y0.c cVar) throws Throwable {
        j jVar;
        D dG;
        int i2;
        if (cVar instanceof j) {
            jVar = (j) cVar;
            int i3 = jVar.f1141f;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                jVar.f1141f = i3 - Integer.MIN_VALUE;
            } else {
                jVar = new j(this, cVar);
            }
        } else {
            jVar = new j(this, cVar);
        }
        Object objP = jVar.f1139d;
        p042x0.a aVar = p042x0.a.f4189a;
        int i4 = jVar.f1141f;
        if (i4 == 0) {
            p029q.j.o(objP);
            Bitmap.Config config = p016j0.f.f3375a;
            boolean zA = F0.i.a(Looper.myLooper(), Looper.getMainLooper());
            ?? r2 = this.f1150c;
            if (!zA) {
                w wVar = (w) ((InterfaceC0057d) r2.getValue());
                wVar.getClass();
                F0.i.e(yVar, "request");
                b1.j jVar2 = new b1.j(wVar, yVar);
                jVar.f1141f = 1;
                C0033e c0033e = new C0033e(p029q.j.l(jVar), 1);
                c0033e.q();
                p016j0.g gVar = new p016j0.g(jVar2, c0033e);
                jVar2.e(gVar);
                c0033e.s(gVar);
                objP = c0033e.p();
                if (objP == aVar) {
                    return aVar;
                }
            } else {
                if (this.f1149b.f2679o.f2602a) {
                    throw new NetworkOnMainThreadException();
                }
                w wVar2 = (w) ((InterfaceC0057d) r2.getValue());
                wVar2.getClass();
                F0.i.e(yVar, "request");
                dG = new b1.j(wVar2, yVar).g();
            }
            if (!dG.f() || (i2 = dG.f907d) == 304) {
                return dG;
            }
            G g2 = dG.g;
            if (g2 != null) {
                p016j0.f.a(g2);
            }
            throw new C0041m("HTTP " + i2 + ": " + dG.f906c);
        }
        if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        p029q.j.o(objP);
        dG = (D) objP;
        if (dG.f()) {
        }
        return dG;
    }

    public final o c() {
        Object value = this.f1151d.getValue();
        F0.i.b(value);
        return ((X.j) value).f886a;
    }

    public final y e() {
        V.a aVar = new V.a();
        aVar.l(this.f1148a);
        p010f0.m mVar = this.f1149b;
        X0.n nVar = mVar.f2674j;
        F0.i.e(nVar, "headers");
        aVar.f652d = nVar.c();
        for (Map.Entry entry : mVar.f2675k.f2690a.entrySet()) {
            Object key = entry.getKey();
            F0.i.c(key, "null cannot be cast to non-null type java.lang.Class<kotlin.Any>");
            aVar.k((Class) key, entry.getValue());
        }
        p010f0.b bVar = mVar.f2678n;
        boolean z2 = bVar.f2602a;
        boolean z3 = mVar.f2679o.f2602a;
        if (!z3 && z2) {
            aVar.d(C0056c.f948o);
        } else if (!z3 || z2) {
            if (!z3 && !z2) {
                aVar.d(g);
            }
        } else if (bVar.f2603b) {
            aVar.d(C0056c.f947n);
        } else {
            aVar.d(f1147f);
        }
        return aVar.c();
    }

    public final p008e0.b f(X.i iVar) throws Throwable {
        Throwable th;
        p008e0.b bVar;
        try {
            o oVarC = c();
            X.d dVar = iVar.f885a;
            if (dVar.f863b) {
                throw new IllegalStateException("snapshot is closed");
            }
            C cF = f1.l.f(oVarC.i((z) dVar.f862a.f856c.get(0)));
            try {
                bVar = new p008e0.b(cF);
                try {
                    cF.close();
                    th = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                try {
                    cF.close();
                } catch (Throwable th4) {
                    p029q.j.a(th3, th4);
                }
                th = th3;
                bVar = null;
            }
            if (th != null) {
                throw th;
            }
            F0.i.b(bVar);
            return bVar;
        } catch (IOException unused) {
            return null;
        }
    }

    public final n g(X.i iVar) {
        X.d dVar = iVar.f885a;
        if (dVar.f863b) {
            throw new IllegalStateException("snapshot is closed");
        }
        z zVar = (z) dVar.f862a.f856c.get(1);
        o oVarC = c();
        String str = this.f1149b.f2673i;
        if (str == null) {
            str = this.f1148a;
        }
        return new n(zVar, oVarC, str, iVar);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0087  */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
    
        if (F0.i.a(r7.f909f.a("Vary"), "*") == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final X.i h(X.i r5, X0.y r6, X0.D r7, p008e0.b r8) {
        /*
            Method dump skipped, instruction units count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: Z.l.h(X.i, X0.y, X0.D, e0.b):X.i");
    }
}
