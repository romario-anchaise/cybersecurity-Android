// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package n2;

import e2.n1;
import g.j;
import g0.k;
import i2.a0;
import i2.b0;
import i2.o;
import i2.p;
import i2.q;
import i2.r;
import i2.s;
import i2.u;
import i2.w;
import i2.x;
import i2.y;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import m2.i;
import m2.n;
import w1.o2;
import w2.m;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2759a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f2760b;

    public a(i2.b bVar) {
        bVar.getClass();
        this.f2760b = bVar;
    }

    public static int d(y yVar, int i3) {
        String strD = y.d(yVar, "Retry-After");
        if (strD == null) {
            return i3;
        }
        Pattern patternCompile = Pattern.compile("\\d+");
        patternCompile.getClass();
        if (!patternCompile.matcher(strD).matches()) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strD);
        numValueOf.getClass();
        return numValueOf.intValue();
    }

    @Override // i2.r
    public final y a(g gVar) {
        a0 a0Var;
        y yVarB;
        SSLSocketFactory sSLSocketFactory;
        u2.c cVar;
        i2.f fVar;
        switch (this.f2759a) {
            case 0:
                i2.b bVar = (i2.b) this.f2760b;
                b2.d dVar = gVar.f2767e;
                w wVarA = dVar.a();
                q qVar = (q) dVar.f266c;
                o oVar = (o) dVar.f267d;
                j jVar = (j) dVar.f268e;
                if (jVar != null) {
                    s sVar = (s) jVar.f1414c;
                    if (sVar != null) {
                        wVarA.b("Content-Type", sVar.f2211a);
                    }
                    long j3 = jVar.f1413b;
                    if (j3 != -1) {
                        wVarA.b("Content-Length", String.valueOf(j3));
                        ((n1) wVarA.f2271c).q("Transfer-Encoding");
                    } else {
                        wVarA.b("Transfer-Encoding", "chunked");
                        ((n1) wVarA.f2271c).q("Content-Length");
                    }
                }
                boolean z2 = false;
                if (oVar.a("Host") == null) {
                    wVarA.b("Host", j2.b.w(qVar, false));
                }
                if (oVar.a("Connection") == null) {
                    wVarA.b("Connection", "Keep-Alive");
                }
                if (oVar.a("Accept-Encoding") == null && oVar.a("Range") == null) {
                    wVarA.b("Accept-Encoding", "gzip");
                    z2 = true;
                }
                bVar.getClass();
                qVar.getClass();
                if (oVar.a("User-Agent") == null) {
                    wVarA.b("User-Agent", "okhttp/4.12.0");
                }
                y yVarB2 = gVar.b(wVarA.a());
                o oVar2 = yVarB2.f2292h;
                f.b(bVar, qVar, oVar2);
                x xVarW = yVarB2.w();
                xVarW.f2274a = dVar;
                if (z2 && "gzip".equalsIgnoreCase(y.d(yVarB2, "Content-Encoding")) && f.a(yVarB2) && (a0Var = yVarB2.f2293i) != null) {
                    m mVar = new m(a0Var.y());
                    n1 n1VarC = oVar2.c();
                    n1VarC.q("Content-Encoding");
                    n1VarC.q("Content-Length");
                    xVarW.f2279f = n1VarC.g().c();
                    xVarW.f2280g = new h(y.d(yVarB2, "Content-Type"), -1L, new w2.r(mVar));
                }
                return xVarW.a();
            default:
                b2.d dVar2 = gVar.f2767e;
                i iVar = gVar.f2763a;
                List list = i1.q.f2104c;
                y yVar = null;
                int i3 = 0;
                b2.d dVarB = dVar2;
                while (true) {
                    boolean z3 = true;
                    while (true) {
                        if (iVar.n == null) {
                            synchronized (iVar) {
                                try {
                                    if (iVar.f2728p) {
                                        throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
                                    }
                                    if (iVar.f2727o) {
                                        throw new IllegalStateException("Check failed.");
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            if (z3) {
                                d2.y yVar2 = iVar.f2719f;
                                q qVar2 = (q) dVarB.f266c;
                                u uVar = iVar.f2716c;
                                if (qVar2.f2208i) {
                                    SSLSocketFactory sSLSocketFactory2 = uVar.f2251q;
                                    if (sSLSocketFactory2 != null) {
                                        u2.c cVar2 = uVar.f2255u;
                                        fVar = uVar.f2256v;
                                        sSLSocketFactory = sSLSocketFactory2;
                                        cVar = cVar2;
                                    } else {
                                        o2.k("CLEARTEXT-only client");
                                    }
                                } else {
                                    sSLSocketFactory = null;
                                    cVar = null;
                                    fVar = null;
                                }
                                iVar.f2724k = new m2.e(yVar2, new i2.a(qVar2.f2203d, qVar2.f2204e, uVar.f2248m, uVar.f2250p, sSLSocketFactory, cVar, fVar, uVar.f2249o, uVar.f2254t, uVar.f2253s, uVar.n), iVar, iVar.f2720g);
                            }
                            try {
                                if (iVar.f2730r) {
                                    throw new IOException("Canceled");
                                }
                                try {
                                    yVarB = gVar.b(dVarB);
                                } catch (IOException e3) {
                                    if (!c(e3, iVar, dVarB, !(e3 instanceof p2.a))) {
                                        Iterator it = list.iterator();
                                        while (it.hasNext()) {
                                            y.f.a(e3, (Exception) it.next());
                                        }
                                        throw e3;
                                    }
                                    ArrayList arrayList = new ArrayList(list.size() + 1);
                                    arrayList.addAll(list);
                                    arrayList.add(e3);
                                    iVar.f(true);
                                    list = arrayList;
                                    z3 = false;
                                } catch (n e4) {
                                    boolean zC = c(e4.f2757d, iVar, dVarB, false);
                                    IOException iOException = e4.f2756c;
                                    if (!zC) {
                                        iOException.getClass();
                                        Iterator it2 = list.iterator();
                                        while (it2.hasNext()) {
                                            y.f.a(iOException, (Exception) it2.next());
                                        }
                                        throw iOException;
                                    }
                                    ArrayList arrayList2 = new ArrayList(list.size() + 1);
                                    arrayList2.addAll(list);
                                    arrayList2.add(iOException);
                                    iVar.f(true);
                                    list = arrayList2;
                                    z3 = false;
                                }
                            } catch (Throwable th2) {
                                iVar.f(true);
                                throw th2;
                            }
                        } else {
                            o2.k("Check failed.");
                        }
                        break;
                    }
                    if (yVar != null) {
                        x xVarW2 = yVarB.w();
                        x xVarW3 = yVar.w();
                        xVarW3.f2280g = null;
                        y yVarA = xVarW3.a();
                        if (yVarA.f2293i != null) {
                            throw new IllegalArgumentException("priorResponse.body != null");
                        }
                        xVarW2.f2283j = yVarA;
                        yVarB = xVarW2.a();
                    }
                    yVar = yVarB;
                    dVarB = b(yVar, iVar.n);
                    if (dVarB == null) {
                        iVar.f(false);
                        return yVar;
                    }
                    a0 a0Var2 = yVar.f2293i;
                    if (a0Var2 != null) {
                        j2.b.d(a0Var2);
                    }
                    i3++;
                    if (i3 > 20) {
                        throw new ProtocolException("Too many follow-up requests: " + i3);
                    }
                    iVar.f(true);
                }
                return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0139  */
    /* JADX WARN: Code duplicated, block: B:105:0x015e  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:77:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:78:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:88:0x0110  */
    /* JADX WARN: Code duplicated, block: B:92:0x011c  */
    /* JADX WARN: Code duplicated, block: B:98:0x012d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:99:0x012f  */
    public b2.d b(y yVar, k kVar) throws ProtocolException {
        u uVar;
        String strD;
        b2.d dVar;
        p pVar;
        q qVarA;
        w wVarA;
        boolean z2;
        y yVar2;
        m2.m mVar;
        b0 b0Var = (kVar == null || (mVar = (m2.m) kVar.f1477h) == null) ? null : mVar.f2741b;
        int i3 = yVar.f2290f;
        String str = yVar.f2287c.f265b;
        if (i3 == 307 || i3 == 308) {
            uVar = (u) this.f2760b;
            if (uVar.f2245j) {
                strD = y.d(yVar, "Location");
                dVar = yVar.f2287c;
                if (strD != null) {
                    q qVar = (q) dVar.f266c;
                    qVar.getClass();
                    try {
                        pVar = new p();
                        pVar.d(qVar, strD);
                    } catch (IllegalArgumentException unused) {
                        pVar = null;
                    }
                    if (pVar != null) {
                        qVarA = pVar.a();
                    } else {
                        qVarA = null;
                    }
                    if (qVarA != null && (q1.e.a(qVarA.f2200a, ((q) dVar.f266c).f2200a) || uVar.f2246k)) {
                        wVarA = dVar.a();
                        if (m0.a.o(str)) {
                            int i4 = yVar.f2290f;
                            z2 = !str.equals("PROPFIND") || i4 == 308 || i4 == 307;
                            if (!str.equals("PROPFIND") || i4 == 308 || i4 == 307) {
                                wVarA.c(str, z2 ? (j) dVar.f268e : null);
                            } else {
                                wVarA.c("GET", null);
                            }
                            if (!z2) {
                                ((n1) wVarA.f2271c).q("Transfer-Encoding");
                                ((n1) wVarA.f2271c).q("Content-Length");
                                ((n1) wVarA.f2271c).q("Content-Type");
                            }
                        }
                        if (!j2.b.a((q) dVar.f266c, qVarA)) {
                            ((n1) wVarA.f2271c).q("Authorization");
                        }
                        wVarA.f2270b = qVarA;
                        return wVarA.a();
                    }
                }
            }
        } else {
            if (i3 == 401) {
                ((u) this.f2760b).f2244i.getClass();
                return null;
            }
            if (i3 != 421) {
                if (i3 == 503) {
                    y yVar3 = yVar.f2296l;
                    if ((yVar3 == null || yVar3.f2290f != 503) && d(yVar, Integer.MAX_VALUE) == 0) {
                        return yVar.f2287c;
                    }
                } else {
                    if (i3 == 407) {
                        b0Var.getClass();
                        if (b0Var.f2121b.type() != Proxy.Type.HTTP) {
                            throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                        }
                        ((u) this.f2760b).f2249o.getClass();
                        return null;
                    }
                    if (i3 != 408) {
                        switch (i3) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                uVar = (u) this.f2760b;
                                if (uVar.f2245j) {
                                    strD = y.d(yVar, "Location");
                                    dVar = yVar.f2287c;
                                    if (strD != null) {
                                        q qVar2 = (q) dVar.f266c;
                                        qVar2.getClass();
                                        pVar = new p();
                                        pVar.d(qVar2, strD);
                                        if (pVar != null) {
                                            qVarA = pVar.a();
                                        } else {
                                            qVarA = null;
                                        }
                                        if (qVarA != null) {
                                            wVarA = dVar.a();
                                            if (m0.a.o(str)) {
                                                int i5 = yVar.f2290f;
                                                if (str.equals("PROPFIND")) {
                                                }
                                                if (str.equals("PROPFIND")) {
                                                    wVarA.c(str, z2 ? (j) dVar.f268e : null);
                                                } else {
                                                    wVarA.c(str, z2 ? (j) dVar.f268e : null);
                                                }
                                                if (!z2) {
                                                    ((n1) wVarA.f2271c).q("Transfer-Encoding");
                                                    ((n1) wVarA.f2271c).q("Content-Length");
                                                    ((n1) wVarA.f2271c).q("Content-Type");
                                                }
                                            }
                                            if (!j2.b.a((q) dVar.f266c, qVarA)) {
                                                ((n1) wVarA.f2271c).q("Authorization");
                                            }
                                            wVarA.f2270b = qVarA;
                                            return wVarA.a();
                                        }
                                    }
                                }
                            default:
                                return null;
                        }
                    } else if (((u) this.f2760b).f2243h && (((yVar2 = yVar.f2296l) == null || yVar2.f2290f != 408) && d(yVar, 0) <= 0)) {
                        return yVar.f2287c;
                    }
                }
            } else if (kVar != null && !q1.e.a(((m2.e) kVar.f1475f).f2702b.f2114h.f2203d, ((m2.m) kVar.f1477h).f2741b.f2120a.f2114h.f2203d)) {
                m2.m mVar2 = (m2.m) kVar.f1477h;
                synchronized (mVar2) {
                    mVar2.f2750k = true;
                }
                return yVar.f2287c;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0049  */
    /* JADX WARN: Code duplicated, block: B:36:0x004e  */
    /* JADX WARN: Code duplicated, block: B:38:0x0051  */
    /* JADX WARN: Code duplicated, block: B:49:0x0066 A[ADDED_TO_REGION, DONT_GENERATE, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:51:0x0068 A[Catch: all -> 0x007e, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:47:0x0062, B:51:0x0068, B:55:0x007a), top: B:76:0x0062 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0083  */
    /* JADX WARN: Code duplicated, block: B:63:0x0085  */
    /* JADX WARN: Code duplicated, block: B:64:0x0087  */
    /* JADX WARN: Code duplicated, block: B:66:0x008b  */
    /* JADX WARN: Code duplicated, block: B:69:0x0092  */
    /* JADX WARN: Code duplicated, block: B:75:0x009e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:76:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public boolean c(IOException iOException, i iVar, b2.d dVar, boolean z2) {
        m2.e eVar;
        int i3;
        boolean zC;
        b0 b0Var;
        f2.e eVar2;
        p pVar;
        m2.m mVar;
        if (!((u) this.f2760b).f2243h || ((z2 && (iOException instanceof FileNotFoundException)) || (iOException instanceof ProtocolException))) {
            return false;
        }
        if (!(iOException instanceof InterruptedIOException)) {
            if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
                return false;
            }
            eVar = iVar.f2724k;
            eVar.getClass();
            i3 = eVar.f2707g;
            if (i3 != 0) {
                if (eVar.f2710j != null) {
                    zC = true;
                } else {
                    b0Var = null;
                    if (i3 <= 1) {
                        synchronized (mVar) {
                            if (mVar.f2751l != 0) {
                                b0Var = mVar.f2741b;
                            }
                        }
                    }
                    if (b0Var != null) {
                        eVar.f2710j = b0Var;
                    } else {
                        eVar2 = eVar.f2705e;
                        zC = eVar2 != null ? pVar.c() : pVar.c();
                    }
                    zC = true;
                }
            } else if (eVar.f2710j != null) {
                zC = true;
            } else {
                b0Var = null;
                if (i3 <= 1) {
                    synchronized (mVar) {
                        if (mVar.f2751l != 0) {
                            b0Var = mVar.f2741b;
                        }
                    }
                }
                if (b0Var != null) {
                    eVar.f2710j = b0Var;
                } else {
                    eVar2 = eVar.f2705e;
                    if (eVar2 != null) {
                    }
                }
                zC = true;
            }
            if (!zC) {
                return true;
            }
        } else if ((iOException instanceof SocketTimeoutException) && !z2) {
            eVar = iVar.f2724k;
            eVar.getClass();
            i3 = eVar.f2707g;
            if (i3 != 0 && eVar.f2708h == 0 && eVar.f2709i == 0) {
                zC = false;
            } else if (eVar.f2710j != null) {
                zC = true;
            } else {
                b0Var = null;
                if (i3 <= 1 && eVar.f2708h <= 1 && eVar.f2709i <= 0 && (mVar = eVar.f2703c.f2725l) != null) {
                    synchronized (mVar) {
                        if (mVar.f2751l != 0 && j2.b.a(mVar.f2741b.f2120a.f2114h, eVar.f2702b.f2114h)) {
                            b0Var = mVar.f2741b;
                        }
                    }
                }
                if (b0Var != null) {
                    eVar.f2710j = b0Var;
                } else {
                    eVar2 = eVar.f2705e;
                    if ((eVar2 != null || !eVar2.a()) && (pVar = eVar.f2706f) != null) {
                    }
                }
                zC = true;
            }
            if (!zC) {
                return true;
            }
        }
        return false;
    }

    public a(u uVar) {
        uVar.getClass();
        this.f2760b = uVar;
    }
}
