// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b1;

import A.C0005e;
import X0.C0054a;
import X0.C0059f;
import X0.D;
import X0.H;
import X0.w;
import X0.x;
import X0.y;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import k1.B;
import k1.C;
import k1.C0193i;
import k1.K;

/* JADX INFO: loaded from: classes.dex */
public final class m extends e1.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H f2149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Socket f2150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Socket f2151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public X0.m f2152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public x f2153f;
    public e1.o g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public C f2154h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public B f2155i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2156j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2157k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2158l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2159m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2160n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2161o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList f2162p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f2163q;

    public m(n nVar, H h2) {
        F0.i.e(nVar, "connectionPool");
        F0.i.e(h2, "route");
        this.f2149b = h2;
        this.f2161o = 1;
        this.f2162p = new ArrayList();
        this.f2163q = Long.MAX_VALUE;
    }

    public static void d(w wVar, H h2, IOException iOException) {
        F0.i.e(wVar, "client");
        F0.i.e(h2, "failedRoute");
        F0.i.e(iOException, "failure");
        if (h2.f927b.type() != Proxy.Type.DIRECT) {
            C0054a c0054a = h2.f926a;
            c0054a.g.connectFailed(c0054a.f941h.h(), h2.f927b.address(), iOException);
        }
        C0005e c0005e = wVar.f1089y;
        synchronized (c0005e) {
            ((LinkedHashSet) c0005e.f34b).add(h2);
        }
    }

    @Override // e1.h
    public final synchronized void a(e1.o oVar, e1.B b2) {
        F0.i.e(oVar, "connection");
        F0.i.e(b2, "settings");
        this.f2161o = (b2.f2273a & 16) != 0 ? b2.f2274b[4] : Integer.MAX_VALUE;
    }

    @Override // e1.h
    public final void b(e1.w wVar) {
        wVar.c(8, null);
    }

    public final void c(int i2, int i3, int i4, boolean z2, j jVar) throws Throwable {
        F0.i.e(jVar, "call");
        if (this.f2153f != null) {
            throw new IllegalStateException("already connected");
        }
        List list = this.f2149b.f926a.f943j;
        b bVar = new b(list);
        C0054a c0054a = this.f2149b.f926a;
        if (c0054a.f937c == null) {
            if (!list.contains(X0.j.f988f)) {
                throw new o(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String str = this.f2149b.f926a.f941h.f1024d;
            f1.n nVar = f1.n.f2736a;
            if (!f1.n.f2736a.h(str)) {
                throw new o(new UnknownServiceException(F0.h.e("CLEARTEXT communication to ", str, " not permitted by network security policy")));
            }
        } else if (c0054a.f942i.contains(x.f1094f)) {
            throw new o(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        o oVar = null;
        while (true) {
            try {
                H h2 = this.f2149b;
                if (h2.f926a.f937c != null && h2.f927b.type() == Proxy.Type.HTTP) {
                    f(i2, i3, i4, jVar);
                    if (this.f2150c != null) {
                        break;
                    } else {
                        break;
                    }
                }
                e(i2, i3, jVar);
                g(bVar, jVar);
                F0.i.e(this.f2149b.f928c, "inetSocketAddress");
                break;
            } catch (IOException e2) {
                Socket socket = this.f2151d;
                if (socket != null) {
                    Y0.b.e(socket);
                }
                Socket socket2 = this.f2150c;
                if (socket2 != null) {
                    Y0.b.e(socket2);
                }
                this.f2151d = null;
                this.f2150c = null;
                this.f2154h = null;
                this.f2155i = null;
                this.f2152e = null;
                this.f2153f = null;
                this.g = null;
                this.f2161o = 1;
                F0.i.e(this.f2149b.f928c, "inetSocketAddress");
                if (oVar == null) {
                    oVar = new o(e2);
                } else {
                    p029q.j.a(oVar.f2168a, e2);
                    oVar.f2169b = e2;
                }
                if (!z2) {
                    throw oVar;
                }
                bVar.f2102d = true;
                if (!bVar.f2101c) {
                    throw oVar;
                }
                if (e2 instanceof ProtocolException) {
                    throw oVar;
                }
                if (e2 instanceof InterruptedIOException) {
                    throw oVar;
                }
                if ((e2 instanceof SSLHandshakeException) && (e2.getCause() instanceof CertificateException)) {
                    throw oVar;
                }
                if (e2 instanceof SSLPeerUnverifiedException) {
                    throw oVar;
                }
                if (!(e2 instanceof SSLException)) {
                    throw oVar;
                }
            }
        }
        H h3 = this.f2149b;
        if (h3.f926a.f937c != null && h3.f927b.type() == Proxy.Type.HTTP && this.f2150c == null) {
            throw new o(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        this.f2163q = System.nanoTime();
    }

    public final void e(int i2, int i3, j jVar) throws IOException {
        Socket socketCreateSocket;
        H h2 = this.f2149b;
        Proxy proxy = h2.f927b;
        C0054a c0054a = h2.f926a;
        Proxy.Type type = proxy.type();
        int i4 = type == null ? -1 : k.f2145a[type.ordinal()];
        if (i4 == 1 || i4 == 2) {
            socketCreateSocket = c0054a.f936b.createSocket();
            F0.i.b(socketCreateSocket);
        } else {
            socketCreateSocket = new Socket(proxy);
        }
        this.f2150c = socketCreateSocket;
        InetSocketAddress inetSocketAddress = this.f2149b.f928c;
        F0.i.e(jVar, "call");
        F0.i.e(inetSocketAddress, "inetSocketAddress");
        socketCreateSocket.setSoTimeout(i3);
        try {
            f1.n nVar = f1.n.f2736a;
            f1.n.f2736a.e(socketCreateSocket, this.f2149b.f928c, i2);
            try {
                this.f2154h = f1.l.f(f1.l.X(socketCreateSocket));
                this.f2155i = f1.l.e(f1.l.V(socketCreateSocket));
            } catch (NullPointerException e2) {
                if (F0.i.a(e2.getMessage(), "throw with null exception")) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f2149b.f928c);
            connectException.initCause(e3);
            throw connectException;
        }
    }

    public final void f(int i2, int i3, int i4, j jVar) throws IOException {
        V.a aVar = new V.a();
        H h2 = this.f2149b;
        X0.p pVar = h2.f926a.f941h;
        F0.i.e(pVar, "url");
        aVar.f650b = pVar;
        aVar.g("CONNECT", null);
        C0054a c0054a = h2.f926a;
        aVar.f("Host", Y0.b.v(c0054a.f941h, true));
        aVar.f("Proxy-Connection", "Keep-Alive");
        aVar.f("User-Agent", "okhttp/4.12.0");
        y yVarC = aVar.c();
        C0005e c0005e = new C0005e(10);
        f1.l.j("Proxy-Authenticate");
        f1.l.l("OkHttp-Preemptive", "Proxy-Authenticate");
        c0005e.G("Proxy-Authenticate");
        c0005e.z("Proxy-Authenticate", "OkHttp-Preemptive");
        c0005e.B();
        c0054a.f940f.getClass();
        e(i2, i3, jVar);
        String str = "CONNECT " + Y0.b.v((X0.p) yVarC.f1099c, true) + " HTTP/1.1";
        C c2 = this.f2154h;
        F0.i.b(c2);
        B b2 = this.f2155i;
        F0.i.b(b2);
        q qVar = new q(null, this, c2, b2);
        K kC = c2.f3441a.c();
        long j2 = i3;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        kC.g(j2, timeUnit);
        b2.f3438a.c().g(i4, timeUnit);
        qVar.k((X0.n) yVarC.f1100d, str);
        qVar.a();
        X0.C cF = qVar.f(false);
        F0.i.b(cF);
        cF.f892a = yVarC;
        D dA = cF.a();
        long jK = Y0.b.k(dA);
        if (jK != -1) {
            d1.d dVarJ = qVar.j(jK);
            Y0.b.t(dVarJ, Integer.MAX_VALUE, timeUnit);
            dVarJ.close();
        }
        int i5 = dA.f907d;
        if (i5 != 200) {
            if (i5 != 407) {
                throw new IOException(F0.h.b(i5, "Unexpected response code for CONNECT: "));
            }
            c0054a.f940f.getClass();
            throw new IOException("Failed to authenticate with proxy");
        }
        if (!c2.f3442b.w() || !b2.f3439b.w()) {
            throw new IOException("TLS tunnel buffered too many bytes!");
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void g(b bVar, j jVar) throws Throwable {
        C0054a c0054a = this.f2149b.f926a;
        SSLSocketFactory sSLSocketFactory = c0054a.f937c;
        x xVarW = x.f1091c;
        if (sSLSocketFactory == null) {
            List list = c0054a.f942i;
            x xVar = x.f1094f;
            if (!list.contains(xVar)) {
                this.f2151d = this.f2150c;
                this.f2153f = xVarW;
                return;
            } else {
                this.f2151d = this.f2150c;
                this.f2153f = xVar;
                l();
                return;
            }
        }
        F0.i.e(jVar, "call");
        C0054a c0054a2 = this.f2149b.f926a;
        SSLSocketFactory sSLSocketFactory2 = c0054a2.f937c;
        SSLSocket sSLSocket = null;
        String strF = null;
        try {
            F0.i.b(sSLSocketFactory2);
            Socket socket = this.f2150c;
            X0.p pVar = c0054a2.f941h;
            Socket socketCreateSocket = sSLSocketFactory2.createSocket(socket, pVar.f1024d, pVar.f1025e, true);
            F0.i.c(socketCreateSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            SSLSocket sSLSocket2 = (SSLSocket) socketCreateSocket;
            try {
                X0.j jVarA = bVar.a(sSLSocket2);
                if (jVarA.f990b) {
                    f1.n nVar = f1.n.f2736a;
                    f1.n.f2736a.d(sSLSocket2, c0054a2.f941h.f1024d, c0054a2.f942i);
                }
                sSLSocket2.startHandshake();
                SSLSession session = sSLSocket2.getSession();
                F0.i.d(session, "sslSocketSession");
                X0.m mVarP = f1.d.p(session);
                j1.c cVar = c0054a2.f938d;
                F0.i.b(cVar);
                if (!cVar.verify(c0054a2.f941h.f1024d, session)) {
                    List listA = mVarP.a();
                    if (listA.isEmpty()) {
                        throw new SSLPeerUnverifiedException("Hostname " + c0054a2.f941h.f1024d + " not verified (no certificates)");
                    }
                    Object obj = listA.get(0);
                    F0.i.c(obj, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    X509Certificate x509Certificate = (X509Certificate) obj;
                    StringBuilder sb = new StringBuilder("\n              |Hostname ");
                    sb.append(c0054a2.f941h.f1024d);
                    sb.append(" not verified:\n              |    certificate: ");
                    C0059f c0059f = C0059f.f961c;
                    sb.append(f1.d.v(x509Certificate));
                    sb.append("\n              |    DN: ");
                    sb.append(x509Certificate.getSubjectDN().getName());
                    sb.append("\n              |    subjectAltNames: ");
                    sb.append(p036u0.f.y(j1.c.a(x509Certificate, 7), j1.c.a(x509Certificate, 2)));
                    sb.append("\n              ");
                    throw new SSLPeerUnverifiedException(M0.f.I(sb.toString()));
                }
                C0059f c0059f2 = c0054a2.f939e;
                F0.i.b(c0059f2);
                this.f2152e = new X0.m(mVarP.f1008a, mVarP.f1009b, mVarP.f1010c, new l(c0059f2, mVarP, c0054a2));
                F0.i.e(c0054a2.f941h.f1024d, "hostname");
                Iterator it = c0059f2.f962a.iterator();
                if (it.hasNext()) {
                    it.next().getClass();
                    throw new ClassCastException();
                }
                if (jVarA.f990b) {
                    f1.n nVar2 = f1.n.f2736a;
                    strF = f1.n.f2736a.f(sSLSocket2);
                }
                this.f2151d = sSLSocket2;
                this.f2154h = f1.l.f(f1.l.X(sSLSocket2));
                this.f2155i = f1.l.e(f1.l.V(sSLSocket2));
                if (strF != null) {
                    xVarW = f1.l.w(strF);
                }
                this.f2153f = xVarW;
                f1.n nVar3 = f1.n.f2736a;
                f1.n.f2736a.a(sSLSocket2);
                if (this.f2153f == x.f1093e) {
                    l();
                }
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    f1.n nVar4 = f1.n.f2736a;
                    f1.n.f2736a.a(sSLSocket);
                }
                if (sSLSocket != null) {
                    Y0.b.e(sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean h(C0054a c0054a, ArrayList arrayList) {
        X0.m mVar;
        byte[] bArr = Y0.b.f1119a;
        if (this.f2162p.size() < this.f2161o && !this.f2156j) {
            H h2 = this.f2149b;
            if (!h2.f926a.a(c0054a)) {
                return false;
            }
            X0.p pVar = c0054a.f941h;
            String str = pVar.f1024d;
            C0054a c0054a2 = h2.f926a;
            if (F0.i.a(str, c0054a2.f941h.f1024d)) {
                return true;
            }
            if (this.g != null && arrayList != null && !arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    H h3 = (H) it.next();
                    Proxy.Type type = h3.f927b.type();
                    Proxy.Type type2 = Proxy.Type.DIRECT;
                    if (type == type2 && h2.f927b.type() == type2) {
                        if (F0.i.a(h2.f928c, h3.f928c)) {
                            if (c0054a.f938d == j1.c.f3401a) {
                                byte[] bArr2 = Y0.b.f1119a;
                                X0.p pVar2 = c0054a2.f941h;
                                if (pVar.f1025e != pVar2.f1025e) {
                                    break;
                                }
                                String str2 = pVar2.f1024d;
                                String str3 = pVar.f1024d;
                                if (!F0.i.a(str3, str2)) {
                                    if (!this.f2157k && (mVar = this.f2152e) != null) {
                                        List listA = mVar.a();
                                        if (!listA.isEmpty()) {
                                            Object obj = listA.get(0);
                                            F0.i.c(obj, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                                            if (!j1.c.c(str3, (X509Certificate) obj)) {
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    } else {
                                        break;
                                        break;
                                    }
                                }
                                try {
                                    C0059f c0059f = c0054a.f939e;
                                    F0.i.b(c0059f);
                                    X0.m mVar2 = this.f2152e;
                                    F0.i.b(mVar2);
                                    List listA2 = mVar2.a();
                                    F0.i.e(str3, "hostname");
                                    F0.i.e(listA2, "peerCertificates");
                                    Iterator it2 = c0059f.f962a.iterator();
                                    if (!it2.hasNext()) {
                                        return true;
                                    }
                                    it2.next().getClass();
                                    throw new ClassCastException();
                                } catch (SSLPeerUnverifiedException unused) {
                                    break;
                                }
                            }
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final boolean i(boolean z2) {
        long j2;
        byte[] bArr = Y0.b.f1119a;
        long jNanoTime = System.nanoTime();
        Socket socket = this.f2150c;
        F0.i.b(socket);
        Socket socket2 = this.f2151d;
        F0.i.b(socket2);
        C c2 = this.f2154h;
        F0.i.b(c2);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        e1.o oVar = this.g;
        if (oVar != null) {
            synchronized (oVar) {
                if (oVar.f2325f) {
                    return false;
                }
                return oVar.f2332n >= oVar.f2331m || jNanoTime < oVar.f2333o;
            }
        }
        synchronized (this) {
            j2 = jNanoTime - this.f2163q;
        }
        if (j2 < 10000000000L || !z2) {
            return true;
        }
        try {
            int soTimeout = socket2.getSoTimeout();
            try {
                socket2.setSoTimeout(1);
                return !c2.a();
            } finally {
                socket2.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public final c1.d j(w wVar, c1.f fVar) throws SocketException {
        F0.i.e(wVar, "client");
        Socket socket = this.f2151d;
        F0.i.b(socket);
        C c2 = this.f2154h;
        F0.i.b(c2);
        B b2 = this.f2155i;
        F0.i.b(b2);
        e1.o oVar = this.g;
        if (oVar != null) {
            return new e1.p(wVar, this, fVar, oVar);
        }
        int i2 = fVar.g;
        socket.setSoTimeout(i2);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        c2.f3441a.c().g(i2, timeUnit);
        b2.f3438a.c().g(fVar.f2190h, timeUnit);
        return new q(wVar, this, c2, b2);
    }

    public final synchronized void k() {
        this.f2156j = true;
    }

    public final void l() throws SocketException {
        int i2;
        Socket socket = this.f2151d;
        F0.i.b(socket);
        C c2 = this.f2154h;
        F0.i.b(c2);
        B b2 = this.f2155i;
        F0.i.b(b2);
        socket.setSoTimeout(0);
        a1.d dVar = a1.d.f1235h;
        y yVar = new y(dVar);
        String str = this.f2149b.f926a.f941h.f1024d;
        F0.i.e(str, "peerName");
        yVar.f1100d = socket;
        String str2 = Y0.b.g + ' ' + str;
        F0.i.e(str2, "<set-?>");
        yVar.f1098b = str2;
        yVar.f1101e = c2;
        yVar.f1102f = b2;
        yVar.g = this;
        e1.o oVar = new e1.o(yVar);
        this.g = oVar;
        e1.B b3 = e1.o.f2319z;
        int i3 = 4;
        this.f2161o = (b3.f2273a & 16) != 0 ? b3.f2274b[4] : Integer.MAX_VALUE;
        e1.x xVar = oVar.f2341w;
        synchronized (xVar) {
            try {
                if (xVar.f2389d) {
                    throw new IOException("closed");
                }
                Logger logger = e1.x.f2385f;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(Y0.b.i(">> CONNECTION " + e1.f.f2300a.d(), new Object[0]));
                }
                xVar.f2386a.p(e1.f.f2300a);
                xVar.f2386a.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
        e1.x xVar2 = oVar.f2341w;
        e1.B b4 = oVar.f2334p;
        synchronized (xVar2) {
            try {
                F0.i.e(b4, "settings");
                if (xVar2.f2389d) {
                    throw new IOException("closed");
                }
                xVar2.j(0, Integer.bitCount(b4.f2273a) * 6, 4, 0);
                int i4 = 0;
                while (i4 < 10) {
                    boolean z2 = true;
                    if (((1 << i4) & b4.f2273a) == 0) {
                        z2 = false;
                    }
                    if (z2) {
                        if (i4 != i3) {
                            i2 = i4 != 7 ? i4 : i3;
                        } else {
                            i2 = 3;
                        }
                        B b5 = xVar2.f2386a;
                        if (b5.f3440c) {
                            throw new IllegalStateException("closed");
                        }
                        C0193i c0193i = b5.f3439b;
                        k1.D dM = c0193i.M(2);
                        int i5 = dM.f3446c;
                        byte[] bArr = dM.f3444a;
                        bArr[i5] = (byte) ((i2 >>> 8) & 255);
                        bArr[i5 + 1] = (byte) (i2 & 255);
                        dM.f3446c = i5 + 2;
                        c0193i.f3482b += 2;
                        b5.a();
                        xVar2.f2386a.f(b4.f2274b[i4]);
                    }
                    i4++;
                    i3 = 4;
                }
                xVar2.f2386a.flush();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        int iA = oVar.f2334p.a();
        if (iA != 65535) {
            oVar.f2341w.v(0, iA - 65535);
        }
        dVar.e().c(new a1.b(oVar.f2322c, oVar.f2342x, 0), 0L);
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("Connection{");
        H h2 = this.f2149b;
        sb.append(h2.f926a.f941h.f1024d);
        sb.append(':');
        sb.append(h2.f926a.f941h.f1025e);
        sb.append(", proxy=");
        sb.append(h2.f927b);
        sb.append(" hostAddress=");
        sb.append(h2.f928c);
        sb.append(" cipherSuite=");
        X0.m mVar = this.f2152e;
        if (mVar == null || (obj = mVar.f1009b) == null) {
            obj = "none";
        }
        sb.append(obj);
        sb.append(" protocol=");
        sb.append(this.f2153f);
        sb.append('}');
        return sb.toString();
    }
}
