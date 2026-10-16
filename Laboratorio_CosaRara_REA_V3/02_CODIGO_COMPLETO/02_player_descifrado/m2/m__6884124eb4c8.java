// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m2;

import d2.y;
import e2.n1;
import i2.b0;
import i2.u;
import i2.v;
import i2.x;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
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
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import p2.a0;
import w1.o2;
import w2.o;
import w2.q;
import w2.r;
import w2.w;
import w2.z;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends p2.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b0 f2741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Socket f2742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Socket f2743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i2.n f2744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public v f2745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p2.n f2746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public r f2747h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public q f2748i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2749j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f2750k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f2751l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f2752m;
    public int n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f2753o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList f2754p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f2755q;

    public m(y yVar, b0 b0Var) {
        yVar.getClass();
        b0Var.getClass();
        this.f2741b = b0Var;
        this.f2753o = 1;
        this.f2754p = new ArrayList();
        this.f2755q = Long.MAX_VALUE;
    }

    public static void d(u uVar, b0 b0Var, IOException iOException) {
        uVar.getClass();
        b0Var.getClass();
        iOException.getClass();
        if (b0Var.f2121b.type() != Proxy.Type.DIRECT) {
            i2.a aVar = b0Var.f2120a;
            aVar.f2113g.connectFailed(aVar.f2114h.g(), b0Var.f2121b.address(), iOException);
        }
        n1 n1Var = uVar.B;
        synchronized (n1Var) {
            ((LinkedHashSet) n1Var.f905c).add(b0Var);
        }
    }

    @Override // p2.h
    public final synchronized void a(p2.n nVar, a0 a0Var) {
        a0Var.getClass();
        this.f2753o = (a0Var.f2874a & 16) != 0 ? ((int[]) a0Var.f2875b)[4] : Integer.MAX_VALUE;
    }

    @Override // p2.h
    public final void b(p2.v vVar) {
        vVar.c(8, null);
    }

    public final void c(int i3, int i4, int i5, boolean z2, i iVar, i2.m mVar) throws Throwable {
        i iVar2;
        i2.m mVar2;
        mVar.getClass();
        if (this.f2745f != null) {
            o2.k("already connected");
            return;
        }
        List list = this.f2741b.f2120a.f2116j;
        b bVar = new b(list);
        i2.a aVar = this.f2741b.f2120a;
        if (aVar.f2109c == null) {
            if (!list.contains(i2.i.f2166f)) {
                throw new n(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String str = this.f2741b.f2120a.f2114h.f2203d;
            q2.m mVar3 = q2.m.f3156a;
            if (!q2.m.f3156a.f(str)) {
                throw new n(new UnknownServiceException(a0.a.h("CLEARTEXT communication to ", str, " not permitted by network security policy")));
            }
        } else if (aVar.f2115i.contains(v.f2265h)) {
            throw new n(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        n nVar = null;
        while (true) {
            try {
                b0 b0Var = this.f2741b;
                try {
                    if (b0Var.f2120a.f2109c != null && b0Var.f2121b.type() == Proxy.Type.HTTP) {
                        iVar2 = iVar;
                        mVar2 = mVar;
                        f(i3, i4, i5, iVar2, mVar2);
                        if (this.f2742c != null) {
                            break;
                        } else {
                            break;
                        }
                    }
                    iVar2 = iVar;
                    mVar2 = mVar;
                    e(i3, i4, iVar2, mVar2);
                    g(bVar, iVar2, mVar2);
                    this.f2741b.f2122c.getClass();
                    break;
                } catch (IOException e3) {
                    e = e3;
                    Socket socket = this.f2743d;
                    if (socket != null) {
                        j2.b.e(socket);
                    }
                    Socket socket2 = this.f2742c;
                    if (socket2 != null) {
                        j2.b.e(socket2);
                    }
                    this.f2743d = null;
                    this.f2742c = null;
                    this.f2747h = null;
                    this.f2748i = null;
                    this.f2744e = null;
                    this.f2745f = null;
                    this.f2746g = null;
                    this.f2753o = 1;
                    this.f2741b.f2122c.getClass();
                    if (nVar == null) {
                        nVar = new n(e);
                    } else {
                        y.f.a(nVar.f2756c, e);
                        nVar.f2757d = e;
                    }
                    if (!z2) {
                        throw nVar;
                    }
                    bVar.f2685b = true;
                    if (!bVar.f2684a) {
                        throw nVar;
                    }
                    if (e instanceof ProtocolException) {
                        throw nVar;
                    }
                    if (e instanceof InterruptedIOException) {
                        throw nVar;
                    }
                    if ((e instanceof SSLHandshakeException) && (e.getCause() instanceof CertificateException)) {
                        throw nVar;
                    }
                    if (e instanceof SSLPeerUnverifiedException) {
                        throw nVar;
                    }
                    if (!(e instanceof SSLException)) {
                        throw nVar;
                    }
                }
            } catch (IOException e4) {
                e = e4;
            }
        }
        b0 b0Var2 = this.f2741b;
        if (b0Var2.f2120a.f2109c != null && b0Var2.f2121b.type() == Proxy.Type.HTTP && this.f2742c == null) {
            throw new n(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        this.f2755q = System.nanoTime();
    }

    public final void e(int i3, int i4, i iVar, i2.m mVar) throws IOException {
        Socket socketCreateSocket;
        b0 b0Var = this.f2741b;
        Proxy proxy = b0Var.f2121b;
        i2.a aVar = b0Var.f2120a;
        Proxy.Type type = proxy.type();
        int i5 = type == null ? -1 : j.f2733a[type.ordinal()];
        int i6 = 1;
        if (i5 == 1 || i5 == 2) {
            socketCreateSocket = aVar.f2108b.createSocket();
            socketCreateSocket.getClass();
        } else {
            socketCreateSocket = new Socket(proxy);
        }
        this.f2742c = socketCreateSocket;
        mVar.a(iVar, this.f2741b.f2122c, proxy);
        socketCreateSocket.setSoTimeout(i4);
        try {
            q2.m mVar2 = q2.m.f3156a;
            q2.m mVar3 = q2.m.f3156a;
            InetSocketAddress inetSocketAddress = this.f2741b.f2122c;
            mVar3.getClass();
            inetSocketAddress.getClass();
            socketCreateSocket.connect(inetSocketAddress, i3);
            try {
                Logger logger = o.f5792a;
                w wVar = new w(socketCreateSocket);
                InputStream inputStream = socketCreateSocket.getInputStream();
                inputStream.getClass();
                this.f2747h = new r(new w2.e(wVar, new w2.e(inputStream, wVar, i6), 0));
                w wVar2 = new w(socketCreateSocket);
                OutputStream outputStream = socketCreateSocket.getOutputStream();
                outputStream.getClass();
                this.f2748i = new q(new w2.d(wVar2, new w2.d(outputStream, wVar2)));
            } catch (NullPointerException e3) {
                if (q1.e.a(e3.getMessage(), "throw with null exception")) {
                    throw new IOException(e3);
                }
            }
        } catch (ConnectException e4) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f2741b.f2122c);
            connectException.initCause(e4);
            throw connectException;
        }
    }

    public final void f(int i3, int i4, int i5, i iVar, i2.m mVar) throws IOException {
        i2.w wVar = new i2.w(0);
        b0 b0Var = this.f2741b;
        i2.q qVar = b0Var.f2120a.f2114h;
        qVar.getClass();
        wVar.f2270b = qVar;
        wVar.c("CONNECT", null);
        i2.a aVar = b0Var.f2120a;
        wVar.b("Host", j2.b.w(aVar.f2114h, true));
        wVar.b("Proxy-Connection", "Keep-Alive");
        wVar.b("User-Agent", "okhttp/4.12.0");
        b2.d dVarA = wVar.a();
        ArrayList arrayList = new ArrayList(20);
        i2.c.a("Proxy-Authenticate");
        i2.c.b("OkHttp-Preemptive", "Proxy-Authenticate");
        int i6 = 0;
        while (i6 < arrayList.size()) {
            if ("Proxy-Authenticate".equalsIgnoreCase((String) arrayList.get(i6))) {
                arrayList.remove(i6);
                arrayList.remove(i6);
                i6 -= 2;
            }
            i6 += 2;
        }
        arrayList.add("Proxy-Authenticate");
        arrayList.add(v1.d.J("OkHttp-Preemptive").toString());
        aVar.f2112f.getClass();
        i2.q qVar2 = (i2.q) dVarA.f266c;
        e(i3, i4, iVar, mVar);
        String str = "CONNECT " + j2.b.w(qVar2, true) + " HTTP/1.1";
        r rVar = this.f2747h;
        rVar.getClass();
        q qVar3 = this.f2748i;
        qVar3.getClass();
        o2.g gVar = new o2.g(null, this, rVar, qVar3);
        z zVarA = rVar.f5798c.a();
        long j3 = i4;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        zVarA.g(j3, timeUnit);
        qVar3.f5795c.a().g(i5, timeUnit);
        gVar.j((i2.o) dVarA.f267d, str);
        gVar.d();
        x xVarG = gVar.g(false);
        xVarG.getClass();
        xVarG.f2274a = dVarA;
        i2.y yVarA = xVarG.a();
        int i7 = yVarA.f2290f;
        long jK = j2.b.k(yVarA);
        if (jK != -1) {
            o2.d dVarI = gVar.i(jK);
            j2.b.u(dVarI, Integer.MAX_VALUE);
            dVarI.close();
        }
        if (i7 == 200) {
            if (rVar.f5799d.w() && qVar3.f5796d.w()) {
                return;
            }
            o2.l("TLS tunnel buffered too many bytes!");
            return;
        }
        if (i7 != 407) {
            o2.l(a0.a.g("Unexpected response code for CONNECT: ", i7));
        } else {
            aVar.f2112f.getClass();
            o2.l("Failed to authenticate with proxy");
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
    public final void g(b bVar, i iVar, i2.m mVar) throws Throwable {
        v vVarG = v.f2262e;
        i2.a aVar = this.f2741b.f2120a;
        if (aVar.f2109c == null) {
            List list = aVar.f2115i;
            v vVar = v.f2265h;
            boolean zContains = list.contains(vVar);
            Socket socket = this.f2742c;
            if (!zContains) {
                this.f2743d = socket;
                this.f2745f = vVarG;
                return;
            } else {
                this.f2743d = socket;
                this.f2745f = vVar;
                l();
                return;
            }
        }
        mVar.d(iVar);
        i2.a aVar2 = this.f2741b.f2120a;
        SSLSocketFactory sSLSocketFactory = aVar2.f2109c;
        SSLSocket sSLSocket = null;
        String strE = null;
        try {
            sSLSocketFactory.getClass();
            Socket socket2 = this.f2742c;
            i2.q qVar = aVar2.f2114h;
            int i3 = 1;
            Socket socketCreateSocket = sSLSocketFactory.createSocket(socket2, qVar.f2203d, qVar.f2204e, true);
            socketCreateSocket.getClass();
            SSLSocket sSLSocket2 = (SSLSocket) socketCreateSocket;
            try {
                i2.i iVarA = bVar.a(sSLSocket2);
                if (iVarA.f2168b) {
                    q2.m mVar2 = q2.m.f3156a;
                    q2.m.f3156a.d(sSLSocket2, aVar2.f2114h.f2203d, aVar2.f2115i);
                }
                sSLSocket2.startHandshake();
                SSLSession session = sSLSocket2.getSession();
                session.getClass();
                i2.n nVarE = i2.c.e(session);
                HostnameVerifier hostnameVerifier = aVar2.f2110d;
                hostnameVerifier.getClass();
                boolean zVerify = hostnameVerifier.verify(aVar2.f2114h.f2203d, session);
                int i4 = 0;
                if (zVerify) {
                    i2.f fVar = aVar2.f2111e;
                    fVar.getClass();
                    this.f2744e = new i2.n(nVarE.f2185a, nVarE.f2186b, nVarE.f2187c, new k(fVar, nVarE, aVar2, i4));
                    aVar2.f2114h.f2203d.getClass();
                    Iterator it = fVar.f2144a.iterator();
                    if (it.hasNext()) {
                        a0.a.n(it.next());
                        throw null;
                    }
                    if (iVarA.f2168b) {
                        q2.m mVar3 = q2.m.f3156a;
                        strE = q2.m.f3156a.e(sSLSocket2);
                    }
                    this.f2743d = sSLSocket2;
                    Logger logger = o.f5792a;
                    w wVar = new w(sSLSocket2);
                    InputStream inputStream = sSLSocket2.getInputStream();
                    inputStream.getClass();
                    this.f2747h = new r(new w2.e(wVar, new w2.e(inputStream, wVar, i3), i4));
                    w wVar2 = new w(sSLSocket2);
                    OutputStream outputStream = sSLSocket2.getOutputStream();
                    outputStream.getClass();
                    this.f2748i = new q(new w2.d(wVar2, new w2.d(outputStream, wVar2)));
                    if (strE != null) {
                        vVarG = i2.c.g(strE);
                    }
                    this.f2745f = vVarG;
                    q2.m mVar4 = q2.m.f3156a;
                    q2.m.f3156a.a(sSLSocket2);
                    if (this.f2745f == v.f2264g) {
                        l();
                        return;
                    }
                    return;
                }
                List listA = nVarE.a();
                if (listA.isEmpty()) {
                    throw new SSLPeerUnverifiedException("Hostname " + aVar2.f2114h.f2203d + " not verified (no certificates)");
                }
                Object obj = listA.get(0);
                obj.getClass();
                X509Certificate x509Certificate = (X509Certificate) obj;
                StringBuilder sb = new StringBuilder("\n              |Hostname ");
                sb.append(aVar2.f2114h.f2203d);
                sb.append(" not verified:\n              |    certificate: ");
                i2.f fVar2 = i2.f.f2143c;
                StringBuilder sb2 = new StringBuilder("sha256/");
                w2.k kVar = w2.k.f5778f;
                byte[] encoded = x509Certificate.getPublicKey().getEncoded();
                encoded.getClass();
                sb2.append(e0.i.e(encoded).b("SHA-256").a());
                sb.append(sb2.toString());
                sb.append("\n              |    DN: ");
                sb.append(x509Certificate.getSubjectDN().getName());
                sb.append("\n              |    subjectAltNames: ");
                List listA2 = u2.c.a(x509Certificate, 7);
                List listA3 = u2.c.a(x509Certificate, 2);
                ArrayList arrayList = new ArrayList(listA3.size() + listA2.size());
                arrayList.addAll(listA2);
                arrayList.addAll(listA3);
                sb.append(arrayList);
                sb.append("\n              ");
                throw new SSLPeerUnverifiedException(v1.e.u(sb.toString()));
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    q2.m mVar5 = q2.m.f3156a;
                    q2.m.f3156a.a(sSLSocket);
                }
                if (sSLSocket != null) {
                    j2.b.e(sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final boolean h(i2.a aVar, List list) {
        i2.n nVar;
        i2.q qVar = aVar.f2114h;
        byte[] bArr = j2.b.f2361a;
        if (this.f2754p.size() < this.f2753o && !this.f2749j) {
            b0 b0Var = this.f2741b;
            i2.a aVar2 = b0Var.f2120a;
            i2.a aVar3 = b0Var.f2120a;
            if (aVar2.a(aVar)) {
                String str = qVar.f2203d;
                String str2 = qVar.f2203d;
                if (!q1.e.a(str, aVar3.f2114h.f2203d)) {
                    if (this.f2746g != null && list != null && !list.isEmpty()) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            b0 b0Var2 = (b0) it.next();
                            Proxy.Type type = b0Var2.f2121b.type();
                            Proxy.Type type2 = Proxy.Type.DIRECT;
                            if (type == type2 && b0Var.f2121b.type() == type2 && q1.e.a(b0Var.f2122c, b0Var2.f2122c)) {
                                if (aVar.f2110d != u2.c.f3266a) {
                                    break;
                                }
                                byte[] bArr2 = j2.b.f2361a;
                                i2.q qVar2 = aVar3.f2114h;
                                if (qVar.f2204e != qVar2.f2204e) {
                                    break;
                                }
                                if (!q1.e.a(str2, qVar2.f2203d)) {
                                    if (!this.f2750k && (nVar = this.f2744e) != null) {
                                        List listA = nVar.a();
                                        if (!listA.isEmpty()) {
                                            Object obj = listA.get(0);
                                            obj.getClass();
                                            if (!u2.c.c(str2, (X509Certificate) obj)) {
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
                                    i2.f fVar = aVar.f2111e;
                                    fVar.getClass();
                                    i2.n nVar2 = this.f2744e;
                                    nVar2.getClass();
                                    List listA2 = nVar2.a();
                                    str2.getClass();
                                    listA2.getClass();
                                    Iterator it2 = fVar.f2144a.iterator();
                                    if (!it2.hasNext()) {
                                        return true;
                                    }
                                    a0.a.n(it2.next());
                                    throw null;
                                } catch (SSLPeerUnverifiedException unused) {
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean i(boolean z2) {
        long j3;
        byte[] bArr = j2.b.f2361a;
        long jNanoTime = System.nanoTime();
        Socket socket = this.f2742c;
        socket.getClass();
        Socket socket2 = this.f2743d;
        socket2.getClass();
        r rVar = this.f2747h;
        rVar.getClass();
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        p2.n nVar = this.f2746g;
        if (nVar != null) {
            synchronized (nVar) {
                if (nVar.f2930h) {
                    return false;
                }
                return nVar.f2937p >= nVar.f2936o || jNanoTime < nVar.f2938q;
            }
        }
        synchronized (this) {
            j3 = jNanoTime - this.f2755q;
        }
        if (j3 < 10000000000L || !z2) {
            return true;
        }
        try {
            int soTimeout = socket2.getSoTimeout();
            try {
                socket2.setSoTimeout(1);
                return !rVar.d();
            } finally {
                socket2.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public final n2.e j(u uVar, n2.g gVar) throws SocketException {
        uVar.getClass();
        int i3 = gVar.f2769g;
        Socket socket = this.f2743d;
        socket.getClass();
        r rVar = this.f2747h;
        rVar.getClass();
        q qVar = this.f2748i;
        qVar.getClass();
        p2.n nVar = this.f2746g;
        if (nVar != null) {
            return new p2.o(uVar, this, gVar, nVar);
        }
        socket.setSoTimeout(i3);
        z zVarA = rVar.f5798c.a();
        long j3 = i3;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        zVarA.g(j3, timeUnit);
        qVar.f5795c.a().g(gVar.f2770h, timeUnit);
        return new o2.g(uVar, this, rVar, qVar);
    }

    public final synchronized void k() {
        this.f2749j = true;
    }

    public final void l() throws SocketException {
        int i3;
        Socket socket = this.f2743d;
        socket.getClass();
        r rVar = this.f2747h;
        rVar.getClass();
        q qVar = this.f2748i;
        qVar.getClass();
        socket.setSoTimeout(0);
        l2.e eVar = l2.e.f2421h;
        b2.d dVar = new b2.d(eVar);
        String str = this.f2741b.f2120a.f2114h.f2203d;
        str.getClass();
        dVar.f267d = socket;
        dVar.f265b = j2.b.f2367g + ' ' + str;
        dVar.f268e = rVar;
        dVar.f269f = qVar;
        dVar.f270g = this;
        p2.n nVar = new p2.n(dVar);
        this.f2746g = nVar;
        a0 a0Var = p2.n.B;
        this.f2753o = (a0Var.f2874a & 16) != 0 ? ((int[]) a0Var.f2875b)[4] : Integer.MAX_VALUE;
        p2.w wVar = nVar.f2946y;
        synchronized (wVar) {
            try {
                if (wVar.f2994f) {
                    throw new IOException("closed");
                }
                Logger logger = p2.w.f2990h;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(j2.b.i(">> CONNECTION " + p2.f.f2903a.d(), new Object[0]));
                }
                wVar.f2991c.x(p2.f.f2903a);
                wVar.f2991c.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
        p2.w wVar2 = nVar.f2946y;
        a0 a0Var2 = nVar.f2939r;
        synchronized (wVar2) {
            try {
                a0Var2.getClass();
                if (wVar2.f2994f) {
                    throw new IOException("closed");
                }
                wVar2.y(0, Integer.bitCount(a0Var2.f2874a) * 6, 4, 0);
                int i4 = 0;
                while (i4 < 10) {
                    boolean z2 = true;
                    if (((1 << i4) & a0Var2.f2874a) == 0) {
                        z2 = false;
                    }
                    if (z2) {
                        if (i4 != 4) {
                            i3 = i4 != 7 ? i4 : 4;
                        } else {
                            i3 = 3;
                        }
                        wVar2.f2991c.writeShort(i3);
                        wVar2.f2991c.writeInt(((int[]) a0Var2.f2875b)[i4]);
                    }
                    i4++;
                }
                wVar2.f2991c.flush();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        int iA = nVar.f2939r.a();
        if (iA != 65535) {
            nVar.f2946y.D(0, iA - 65535);
        }
        eVar.e().c(new l2.b(nVar.f2927e, nVar.f2947z, 0), 0L);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        b0 b0Var = this.f2741b;
        sb.append(b0Var.f2120a.f2114h.f2203d);
        sb.append(':');
        sb.append(b0Var.f2120a.f2114h.f2204e);
        sb.append(", proxy=");
        sb.append(b0Var.f2121b);
        sb.append(" hostAddress=");
        sb.append(b0Var.f2122c);
        sb.append(" cipherSuite=");
        i2.n nVar = this.f2744e;
        sb.append(nVar != null ? nVar.f2186b : "none");
        sb.append(" protocol=");
        sb.append(this.f2745f);
        sb.append('}');
        return sb.toString();
    }
}
