// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c1;

import A.C0005e;
import F0.i;
import X0.B;
import X0.C;
import X0.C0054a;
import X0.C0055b;
import X0.C0059f;
import X0.D;
import X0.F;
import X0.G;
import X0.H;
import X0.n;
import X0.p;
import X0.r;
import X0.s;
import X0.w;
import X0.y;
import b1.j;
import b1.m;
import b1.o;
import b1.q;
import e1.C0108a;
import f1.l;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public final class a implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2179a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f2180b;

    public a(C0055b c0055b) {
        i.e(c0055b, "cookieJar");
        this.f2180b = c0055b;
    }

    public static int d(D d2, int i2) {
        String strA = D.a(d2, "Retry-After");
        if (strA == null) {
            return i2;
        }
        Pattern patternCompile = Pattern.compile("\\d+");
        i.d(patternCompile, "compile(...)");
        if (!patternCompile.matcher(strA).matches()) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strA);
        i.d(numValueOf, "valueOf(header)");
        return numValueOf.intValue();
    }

    @Override // X0.r
    public final D a(f fVar) {
        G g;
        D dB;
        SSLSocketFactory sSLSocketFactory;
        j1.c cVar;
        C0059f c0059f;
        switch (this.f2179a) {
            case 0:
                y yVar = fVar.f2188e;
                V.a aVarF = yVar.f();
                B b2 = (B) yVar.f1101e;
                if (b2 != null) {
                    s sVarB = b2.b();
                    if (sVarB != null) {
                        aVarF.f("Content-Type", sVarB.f1032a);
                    }
                    long jA = b2.a();
                    if (jA != -1) {
                        aVarF.f("Content-Length", String.valueOf(jA));
                        ((C0005e) aVarF.f652d).G("Transfer-Encoding");
                    } else {
                        aVarF.f("Transfer-Encoding", "chunked");
                        ((C0005e) aVarF.f652d).G("Content-Length");
                    }
                }
                n nVar = (n) yVar.f1100d;
                String strA = nVar.a("Host");
                boolean z2 = false;
                p pVar = (p) yVar.f1099c;
                if (strA == null) {
                    aVarF.f("Host", Y0.b.v(pVar, false));
                }
                if (nVar.a("Connection") == null) {
                    aVarF.f("Connection", "Keep-Alive");
                }
                if (nVar.a("Accept-Encoding") == null && nVar.a("Range") == null) {
                    aVarF.f("Accept-Encoding", "gzip");
                    z2 = true;
                }
                C0055b c0055b = (C0055b) this.f2180b;
                c0055b.getClass();
                i.e(pVar, "url");
                if (nVar.a("User-Agent") == null) {
                    aVarF.f("User-Agent", "okhttp/4.12.0");
                }
                D dB2 = fVar.b(aVarF.c());
                n nVar2 = dB2.f909f;
                e.b(c0055b, pVar, nVar2);
                C cJ = dB2.j();
                cJ.f892a = yVar;
                if (z2 && "gzip".equalsIgnoreCase(D.a(dB2, "Content-Encoding")) && e.a(dB2) && (g = dB2.g) != null) {
                    k1.s sVar = new k1.s(g.j());
                    C0005e c0005eC = nVar2.c();
                    c0005eC.G("Content-Encoding");
                    c0005eC.G("Content-Length");
                    cJ.f897f = c0005eC.B().c();
                    cJ.g = new F(D.a(dB2, "Content-Type"), -1L, l.f(sVar), 1);
                }
                return cJ.a();
            default:
                y yVar2 = fVar.f2188e;
                j jVar = fVar.f2184a;
                List listZ = p036u0.n.f4146a;
                D d2 = null;
                int i2 = 0;
                y yVarB = yVar2;
                while (true) {
                    boolean z3 = true;
                    while (true) {
                        jVar.getClass();
                        i.e(yVarB, "request");
                        if (jVar.f2138i != null) {
                            throw new IllegalStateException("Check failed.");
                        }
                        synchronized (jVar) {
                            try {
                                if (jVar.f2140k) {
                                    throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
                                }
                                if (jVar.f2139j) {
                                    throw new IllegalStateException("Check failed.");
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (z3) {
                            b1.n nVar3 = jVar.f2133c;
                            p pVar2 = (p) yVarB.f1099c;
                            boolean z4 = pVar2.f1029j;
                            w wVar = jVar.f2131a;
                            if (z4) {
                                SSLSocketFactory sSLSocketFactory2 = wVar.f1079o;
                                if (sSLSocketFactory2 == null) {
                                    throw new IllegalStateException("CLEARTEXT-only client");
                                }
                                j1.c cVar2 = wVar.f1083s;
                                c0059f = wVar.f1084t;
                                sSLSocketFactory = sSLSocketFactory2;
                                cVar = cVar2;
                            } else {
                                sSLSocketFactory = null;
                                cVar = null;
                                c0059f = null;
                            }
                            jVar.g = new b1.f(nVar3, new C0054a(pVar2.f1024d, pVar2.f1025e, wVar.f1075k, wVar.f1078n, sSLSocketFactory, cVar, c0059f, wVar.f1077m, wVar.f1082r, wVar.f1081q, wVar.f1076l), jVar);
                        }
                        try {
                            if (jVar.f2142m) {
                                throw new IOException("Canceled");
                            }
                            try {
                                dB = fVar.b(yVarB);
                            } catch (o e2) {
                                List list = listZ;
                                if (!c(e2.f2169b, jVar, yVarB, false)) {
                                    IOException iOException = e2.f2168a;
                                    i.e(iOException, "<this>");
                                    Iterator it = list.iterator();
                                    while (it.hasNext()) {
                                        p029q.j.a(iOException, (Exception) it.next());
                                    }
                                    throw iOException;
                                }
                                listZ = p036u0.f.z(list, e2.f2168a);
                                jVar.h(true);
                                z3 = false;
                            } catch (IOException e3) {
                                if (!c(e3, jVar, yVarB, !(e3 instanceof C0108a))) {
                                    Iterator it2 = listZ.iterator();
                                    while (it2.hasNext()) {
                                        p029q.j.a(e3, (Exception) it2.next());
                                    }
                                    throw e3;
                                }
                                listZ = p036u0.f.z(listZ, e3);
                                jVar.h(true);
                                z3 = false;
                            }
                        } catch (Throwable th2) {
                            jVar.h(true);
                            throw th2;
                        }
                        break;
                    }
                    if (d2 != null) {
                        C cJ2 = dB.j();
                        C cJ3 = d2.j();
                        cJ3.g = null;
                        D dA = cJ3.a();
                        if (dA.g != null) {
                            throw new IllegalArgumentException("priorResponse.body != null");
                        }
                        cJ2.f900j = dA;
                        dB = cJ2.a();
                    }
                    d2 = dB;
                    yVarB = b(d2, jVar.f2138i);
                    if (yVarB == null) {
                        jVar.h(false);
                        return d2;
                    }
                    G g2 = d2.g;
                    if (g2 != null) {
                        Y0.b.d(g2);
                    }
                    i2++;
                    if (i2 > 20) {
                        throw new ProtocolException("Too many follow-up requests: " + i2);
                    }
                    jVar.h(true);
                    listZ = listZ;
                }
                break;
        }
    }

    public y b(D d2, b1.e eVar) throws ProtocolException {
        String strA;
        m mVar;
        H h2 = (eVar == null || (mVar = eVar.f2117e) == null) ? null : mVar.f2149b;
        int i2 = d2.f907d;
        String str = (String) d2.f904a.f1098b;
        if (i2 != 307 && i2 != 308) {
            if (i2 == 401) {
                ((w) this.f2180b).g.getClass();
                return null;
            }
            if (i2 == 421) {
                if (eVar == null || i.a(eVar.f2114b.f2119b.f941h.f1024d, eVar.f2117e.f2149b.f926a.f941h.f1024d)) {
                    return null;
                }
                m mVar2 = eVar.f2117e;
                synchronized (mVar2) {
                    mVar2.f2157k = true;
                }
                return d2.f904a;
            }
            if (i2 == 503) {
                D d3 = d2.f912j;
                if ((d3 == null || d3.f907d != 503) && d(d2, Integer.MAX_VALUE) == 0) {
                    return d2.f904a;
                }
                return null;
            }
            if (i2 == 407) {
                i.b(h2);
                if (h2.f927b.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                ((w) this.f2180b).f1077m.getClass();
                return null;
            }
            if (i2 == 408) {
                if (!((w) this.f2180b).f1071f) {
                    return null;
                }
                D d4 = d2.f912j;
                if ((d4 == null || d4.f907d != 408) && d(d2, 0) <= 0) {
                    return d2.f904a;
                }
                return null;
            }
            switch (i2) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        w wVar = (w) this.f2180b;
        if (!wVar.f1072h || (strA = D.a(d2, "Location")) == null) {
            return null;
        }
        y yVar = d2.f904a;
        p pVar = (p) yVar.f1099c;
        pVar.getClass();
        X0.o oVarF = pVar.f(strA);
        p pVarA = oVarF != null ? oVarF.a() : null;
        if (pVarA == null) {
            return null;
        }
        if (!i.a(pVarA.f1021a, ((p) yVar.f1099c).f1021a) && !wVar.f1073i) {
            return null;
        }
        V.a aVarF = yVar.f();
        if (f1.d.u(str)) {
            boolean zEquals = str.equals("PROPFIND");
            int i3 = d2.f907d;
            boolean z2 = zEquals || i3 == 308 || i3 == 307;
            if (str.equals("PROPFIND") || i3 == 308 || i3 == 307) {
                aVarF.g(str, z2 ? (B) yVar.f1101e : null);
            } else {
                aVarF.g("GET", null);
            }
            if (!z2) {
                ((C0005e) aVarF.f652d).G("Transfer-Encoding");
                ((C0005e) aVarF.f652d).G("Content-Length");
                ((C0005e) aVarF.f652d).G("Content-Type");
            }
        }
        if (!Y0.b.a((p) yVar.f1099c, pVarA)) {
            ((C0005e) aVarF.f652d).G("Authorization");
        }
        aVarF.f650b = pVarA;
        return aVarF.c();
    }

    public boolean c(IOException iOException, j jVar, y yVar, boolean z2) {
        q qVar;
        boolean zI;
        m mVar;
        if (!((w) this.f2180b).f1071f) {
            return false;
        }
        if ((z2 && (iOException instanceof FileNotFoundException)) || (iOException instanceof ProtocolException) || (!(iOException instanceof InterruptedIOException) ? !(((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) : (iOException instanceof SocketTimeoutException) && !z2)) {
            return false;
        }
        b1.f fVar = jVar.g;
        i.b(fVar);
        int i2 = fVar.f2123f;
        if (i2 == 0 && fVar.g == 0 && fVar.f2124h == 0) {
            zI = false;
        } else if (fVar.f2125i != null) {
            zI = true;
        } else {
            H h2 = null;
            if (i2 <= 1 && fVar.g <= 1 && fVar.f2124h <= 0 && (mVar = fVar.f2120c.f2137h) != null) {
                synchronized (mVar) {
                    if (mVar.f2158l == 0 && Y0.b.a(mVar.f2149b.f926a.f941h, fVar.f2119b.f941h)) {
                        h2 = mVar.f2149b;
                    }
                }
            }
            if (h2 != null) {
                fVar.f2125i = h2;
            } else {
                b1.p pVar = fVar.f2121d;
                if ((pVar == null || !pVar.d()) && (qVar = fVar.f2122e) != null) {
                    zI = qVar.i();
                }
            }
            zI = true;
        }
        return zI;
    }

    public a(w wVar) {
        i.e(wVar, "client");
        this.f2180b = wVar;
    }
}
