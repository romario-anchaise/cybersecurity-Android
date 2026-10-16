// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

import A.C0005e;
import X0.D;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import k1.C0196l;
import k1.G;
import k1.I;

/* JADX INFO: loaded from: classes.dex */
public final class p implements c1.d {
    public static final List g = Y0.b.l("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List f2344h = Y0.b.l("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b1.m f2345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c1.f f2346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f2347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile w f2348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final X0.x f2349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f2350f;

    public p(X0.w wVar, b1.m mVar, c1.f fVar, o oVar) {
        F0.i.e(wVar, "client");
        F0.i.e(mVar, "connection");
        F0.i.e(oVar, "http2Connection");
        this.f2345a = mVar;
        this.f2346b = fVar;
        this.f2347c = oVar;
        X0.x xVar = X0.x.f1094f;
        this.f2349e = wVar.f1082r.contains(xVar) ? xVar : X0.x.f1093e;
    }

    @Override // c1.d
    public final void a() {
        w wVar = this.f2348d;
        F0.i.b(wVar);
        wVar.f().close();
    }

    @Override // c1.d
    public final I b(D d2) {
        w wVar = this.f2348d;
        F0.i.b(wVar);
        return wVar.f2379i;
    }

    @Override // c1.d
    public final long c(D d2) {
        if (c1.e.a(d2)) {
            return Y0.b.k(d2);
        }
        return 0L;
    }

    @Override // c1.d
    public final void cancel() {
        this.f2350f = true;
        w wVar = this.f2348d;
        if (wVar != null) {
            wVar.e(9);
        }
    }

    @Override // c1.d
    public final void d() {
        this.f2347c.flush();
    }

    @Override // c1.d
    public final G e(X0.y yVar, long j2) {
        F0.i.e(yVar, "request");
        w wVar = this.f2348d;
        F0.i.b(wVar);
        return wVar.f();
    }

    @Override // c1.d
    public final X0.C f(boolean z2) throws IOException {
        X0.n nVar;
        w wVar = this.f2348d;
        if (wVar == null) {
            throw new IOException("stream wasn't created");
        }
        synchronized (wVar) {
            wVar.f2381k.h();
            while (wVar.g.isEmpty() && wVar.f2383m == 0) {
                try {
                    wVar.k();
                } catch (Throwable th) {
                    wVar.f2381k.k();
                    throw th;
                }
            }
            wVar.f2381k.k();
            if (wVar.g.isEmpty()) {
                IOException iOException = wVar.f2384n;
                if (iOException != null) {
                    throw iOException;
                }
                int i2 = wVar.f2383m;
                F0.h.f(i2);
                throw new C(i2);
            }
            Object objRemoveFirst = wVar.g.removeFirst();
            F0.i.d(objRemoveFirst, "headersQueue.removeFirst()");
            nVar = (X0.n) objRemoveFirst;
        }
        X0.x xVar = this.f2349e;
        F0.i.e(xVar, "protocol");
        ArrayList arrayList = new ArrayList(20);
        int size = nVar.size();
        c1.g gVarM = null;
        for (int i3 = 0; i3 < size; i3++) {
            String strB = nVar.b(i3);
            String strD = nVar.d(i3);
            if (F0.i.a(strB, ":status")) {
                gVarM = f1.l.M("HTTP/1.1 " + strD);
            } else if (!f2344h.contains(strB)) {
                F0.i.e(strB, "name");
                F0.i.e(strD, "value");
                arrayList.add(strB);
                arrayList.add(M0.e.j0(strD).toString());
            }
        }
        if (gVarM == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        X0.C c2 = new X0.C();
        c2.f893b = xVar;
        c2.f894c = gVarM.f2193b;
        c2.f895d = (String) gVarM.f2195d;
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        C0005e c0005e = new C0005e(10);
        ArrayList arrayList2 = (ArrayList) c0005e.f34b;
        F0.i.e(arrayList2, "<this>");
        F0.i.e(strArr, "elements");
        arrayList2.addAll(p036u0.e.p(strArr));
        c2.f897f = c0005e;
        if (z2 && c2.f894c == 100) {
            return null;
        }
        return c2;
    }

    @Override // c1.d
    public final void g(X0.y yVar) throws IOException {
        int i2;
        w wVar;
        F0.i.e(yVar, "request");
        if (this.f2348d != null) {
            return;
        }
        boolean z2 = true;
        boolean z3 = ((X0.B) yVar.f1101e) != null;
        X0.n nVar = (X0.n) yVar.f1100d;
        ArrayList arrayList = new ArrayList(nVar.size() + 4);
        arrayList.add(new C0109b(C0109b.f2278f, (String) yVar.f1098b));
        C0196l c0196l = C0109b.g;
        X0.p pVar = (X0.p) yVar.f1099c;
        F0.i.e(pVar, "url");
        String strB = pVar.b();
        String strD = pVar.d();
        if (strD != null) {
            strB = strB + '?' + strD;
        }
        arrayList.add(new C0109b(c0196l, strB));
        String strA = ((X0.n) yVar.f1100d).a("Host");
        if (strA != null) {
            arrayList.add(new C0109b(C0109b.f2280i, strA));
        }
        arrayList.add(new C0109b(C0109b.f2279h, pVar.f1021a));
        int size = nVar.size();
        for (int i3 = 0; i3 < size; i3++) {
            String strB2 = nVar.b(i3);
            Locale locale = Locale.US;
            F0.i.d(locale, "US");
            String lowerCase = strB2.toLowerCase(locale);
            F0.i.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (!g.contains(lowerCase) || (lowerCase.equals("te") && F0.i.a(nVar.d(i3), "trailers"))) {
                arrayList.add(new C0109b(lowerCase, nVar.d(i3)));
            }
        }
        o oVar = this.f2347c;
        oVar.getClass();
        boolean z4 = !z3;
        synchronized (oVar.f2341w) {
            synchronized (oVar) {
                try {
                    if (oVar.f2324e > 1073741823) {
                        oVar.n(8);
                    }
                    if (oVar.f2325f) {
                        throw new C0108a();
                    }
                    i2 = oVar.f2324e;
                    oVar.f2324e = i2 + 2;
                    wVar = new w(i2, oVar, z4, false, null);
                    if (z3 && oVar.f2338t < oVar.f2339u && wVar.f2376e < wVar.f2377f) {
                        z2 = false;
                    }
                    if (wVar.h()) {
                        oVar.f2321b.put(Integer.valueOf(i2), wVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            oVar.f2341w.r(z4, i2, arrayList);
        }
        if (z2) {
            oVar.f2341w.flush();
        }
        this.f2348d = wVar;
        if (this.f2350f) {
            w wVar2 = this.f2348d;
            F0.i.b(wVar2);
            wVar2.e(9);
            throw new IOException("Canceled");
        }
        w wVar3 = this.f2348d;
        F0.i.b(wVar3);
        v vVar = wVar3.f2381k;
        long j2 = this.f2346b.g;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        vVar.g(j2, timeUnit);
        w wVar4 = this.f2348d;
        F0.i.b(wVar4);
        wVar4.f2382l.g(this.f2346b.f2190h, timeUnit);
    }

    @Override // c1.d
    public final b1.m h() {
        return this.f2345a;
    }
}
