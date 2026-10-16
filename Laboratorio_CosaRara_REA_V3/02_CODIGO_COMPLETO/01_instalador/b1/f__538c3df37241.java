// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b1;

import A.C0005e;
import X0.C0054a;
import X0.H;
import e1.C;
import e1.C0108a;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f2118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0054a f2119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f2120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p f2121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public q f2122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2123f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2124h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public H f2125i;

    public f(n nVar, C0054a c0054a, j jVar) {
        F0.i.e(nVar, "connectionPool");
        F0.i.e(jVar, "call");
        this.f2118a = nVar;
        this.f2119b = c0054a;
        this.f2120c = jVar;
    }

    /* JADX WARN: Code duplicated, block: B:124:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:127:0x02be  */
    /* JADX WARN: Code duplicated, block: B:129:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:130:0x02da  */
    /* JADX WARN: Code duplicated, block: B:132:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:141:0x0324  */
    /* JADX WARN: Code duplicated, block: B:142:0x033f  */
    /* JADX WARN: Code duplicated, block: B:185:0x0340 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x0310 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:196:0x03ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:197:0x027b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:202:0x03a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:203:0x03a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0062  */
    /* JADX WARN: Code duplicated, block: B:32:0x0071  */
    /* JADX WARN: Code duplicated, block: B:34:0x0075  */
    /* JADX WARN: Code duplicated, block: B:36:0x007a  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:56:0x00df  */
    /* JADX WARN: Code duplicated, block: B:59:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:73:0x015e  */
    /* JADX WARN: Type inference failed for: r7v14, types: [java.lang.Object, java.util.List] */
    public final m a(int i2, int i3, int i4, boolean z2, boolean z3) throws IOException {
        H h2;
        p pVar;
        q qVar;
        ArrayList arrayList;
        p pVar2;
        boolean z4;
        C0054a c0054a;
        Proxy proxy;
        String hostAddress;
        int port;
        List arrayList2;
        List listM;
        boolean zContains;
        C0005e c0005e;
        Socket socketM;
        int i5 = 1;
        while (!this.f2120c.f2142m) {
            m mVar = this.f2120c.f2137h;
            if (mVar != null) {
                synchronized (mVar) {
                    try {
                        socketM = (mVar.f2156j || !b(mVar.f2149b.f926a.f941h)) ? this.f2120c.m() : null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (this.f2120c.f2137h == null) {
                    if (socketM != null) {
                        Y0.b.e(socketM);
                    }
                    F0.i.e(this.f2120c, "call");
                    this.f2123f = 0;
                    this.g = 0;
                    this.f2124h = 0;
                    if (this.f2118a.a(this.f2119b, this.f2120c, null, false)) {
                        mVar = this.f2120c.f2137h;
                        F0.i.b(mVar);
                        F0.i.e(this.f2120c, "call");
                    } else {
                        h2 = this.f2125i;
                        try {
                            if (h2 != null) {
                                this.f2125i = null;
                            } else {
                                pVar = this.f2121d;
                                if (pVar == null && pVar.d()) {
                                    p pVar3 = this.f2121d;
                                    F0.i.b(pVar3);
                                    if (!pVar3.d()) {
                                        throw new NoSuchElementException();
                                    }
                                    int i6 = pVar3.f2170a;
                                    pVar3.f2170a = i6 + 1;
                                    h2 = (H) ((ArrayList) pVar3.f2171b).get(i6);
                                } else {
                                    qVar = this.f2122e;
                                    if (qVar == null) {
                                        C0054a c0054a2 = this.f2119b;
                                        j jVar = this.f2120c;
                                        qVar = new q(c0054a2, jVar.f2131a.f1089y, jVar);
                                        this.f2122e = qVar;
                                    }
                                    if (qVar.i()) {
                                        throw new NoSuchElementException();
                                    }
                                    arrayList = new ArrayList();
                                    while (qVar.f2172a < ((List) qVar.f2176e).size()) {
                                        if (qVar.f2172a < ((List) qVar.f2176e).size()) {
                                            z4 = true;
                                        } else {
                                            z4 = false;
                                        }
                                        c0054a = (C0054a) qVar.f2173b;
                                        if (z4) {
                                            throw new SocketException("No route to " + c0054a.f941h.f1024d + "; exhausted proxy configurations: " + ((List) qVar.f2176e));
                                        }
                                        List list = (List) qVar.f2176e;
                                        int i7 = qVar.f2172a;
                                        qVar.f2172a = i7 + 1;
                                        proxy = (Proxy) list.get(i7);
                                        ArrayList arrayList3 = new ArrayList();
                                        qVar.f2177f = arrayList3;
                                        if (proxy.type() != Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                                            X0.p pVar4 = c0054a.f941h;
                                            hostAddress = pVar4.f1024d;
                                            port = pVar4.f1025e;
                                        } else {
                                            SocketAddress socketAddressAddress = proxy.address();
                                            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                                                throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass()).toString());
                                            }
                                            F0.i.d(socketAddressAddress, "proxyAddress");
                                            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                                            F0.i.e(inetSocketAddress, "<this>");
                                            InetAddress address = inetSocketAddress.getAddress();
                                            if (address == null) {
                                                hostAddress = inetSocketAddress.getHostName();
                                                F0.i.d(hostAddress, "hostName");
                                            } else {
                                                hostAddress = address.getHostAddress();
                                                F0.i.d(hostAddress, "address.hostAddress");
                                            }
                                            port = inetSocketAddress.getPort();
                                        }
                                        if (1 <= port || port >= 65536) {
                                            throw new SocketException("No route to " + hostAddress + ':' + port + "; port is out of range");
                                        }
                                        if (proxy.type() == Proxy.Type.SOCKS) {
                                            arrayList3.add(InetSocketAddress.createUnresolved(hostAddress, port));
                                        } else {
                                            byte[] bArr = Y0.b.f1119a;
                                            F0.i.e(hostAddress, "<this>");
                                            M0.d dVar = Y0.b.f1124f;
                                            dVar.getClass();
                                            if (((Pattern) dVar.f374b).matcher(hostAddress).matches()) {
                                                listM = p029q.j.m(InetAddress.getByName(hostAddress));
                                            } else {
                                                F0.i.e((j) qVar.f2175d, "call");
                                                c0054a.f935a.getClass();
                                                try {
                                                    InetAddress[] allByName = InetAddress.getAllByName(hostAddress);
                                                    F0.i.d(allByName, "getAllByName(hostname)");
                                                    int length = allByName.length;
                                                    if (length != 0) {
                                                        arrayList2 = length != 1 ? new ArrayList(new p021m.d(i5, allByName)) : p029q.j.m(allByName[0]);
                                                    } else {
                                                        arrayList2 = p036u0.n.f4146a;
                                                    }
                                                    if (arrayList2.isEmpty()) {
                                                        throw new UnknownHostException(c0054a.f935a + " returned no addresses for " + hostAddress);
                                                    }
                                                    listM = arrayList2;
                                                } catch (NullPointerException e2) {
                                                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(hostAddress));
                                                    unknownHostException.initCause(e2);
                                                    throw unknownHostException;
                                                }
                                            }
                                            Iterator it = listM.iterator();
                                            while (it.hasNext()) {
                                                arrayList3.add(new InetSocketAddress((InetAddress) it.next(), port));
                                            }
                                        }
                                        Iterator it2 = qVar.f2177f.iterator();
                                        while (it2.hasNext()) {
                                            H h3 = new H((C0054a) qVar.f2173b, proxy, (InetSocketAddress) it2.next());
                                            C0005e c0005e2 = (C0005e) qVar.f2174c;
                                            synchronized (c0005e2) {
                                                zContains = ((LinkedHashSet) c0005e2.f34b).contains(h3);
                                            }
                                            if (zContains) {
                                                ((ArrayList) qVar.g).add(h3);
                                            } else {
                                                arrayList.add(h3);
                                            }
                                        }
                                        if (!arrayList.isEmpty()) {
                                            break;
                                        }
                                    }
                                    if (arrayList.isEmpty()) {
                                        p036u0.l.r((ArrayList) qVar.g, arrayList);
                                        ((ArrayList) qVar.g).clear();
                                    }
                                    pVar2 = new p(arrayList);
                                    this.f2121d = pVar2;
                                    if (!this.f2120c.f2142m) {
                                        throw new IOException("Canceled");
                                    }
                                    if (this.f2118a.a(this.f2119b, this.f2120c, arrayList, false)) {
                                        mVar = this.f2120c.f2137h;
                                        F0.i.b(mVar);
                                        F0.i.e(this.f2120c, "call");
                                    } else {
                                        if (pVar2.d()) {
                                            throw new NoSuchElementException();
                                        }
                                        int i8 = pVar2.f2170a;
                                        pVar2.f2170a = i8 + 1;
                                        h2 = (H) arrayList.get(i8);
                                        mVar = new m(this.f2118a, h2);
                                        this.f2120c.f2144o = mVar;
                                        mVar.c(i2, i3, i4, z2, this.f2120c);
                                        this.f2120c.f2144o = null;
                                        c0005e = this.f2120c.f2131a.f1089y;
                                        synchronized (c0005e) {
                                            ((LinkedHashSet) c0005e.f34b).remove(h2);
                                        }
                                        if (this.f2118a.a(this.f2119b, this.f2120c, arrayList, true)) {
                                            m mVar2 = this.f2120c.f2137h;
                                            F0.i.b(mVar2);
                                            this.f2125i = h2;
                                            Socket socket = mVar.f2151d;
                                            F0.i.b(socket);
                                            Y0.b.e(socket);
                                            F0.i.e(this.f2120c, "call");
                                            mVar = mVar2;
                                        } else {
                                            synchronized (mVar) {
                                                n nVar = this.f2118a;
                                                nVar.getClass();
                                                byte[] bArr2 = Y0.b.f1119a;
                                                nVar.f2167d.add(mVar);
                                                nVar.f2165b.c(nVar.f2166c, 0L);
                                                this.f2120c.c(mVar);
                                            }
                                            F0.i.e(this.f2120c, "call");
                                        }
                                    }
                                }
                            }
                            mVar.c(i2, i3, i4, z2, this.f2120c);
                            this.f2120c.f2144o = null;
                            c0005e = this.f2120c.f2131a.f1089y;
                            synchronized (c0005e) {
                                ((LinkedHashSet) c0005e.f34b).remove(h2);
                                if (this.f2118a.a(this.f2119b, this.f2120c, arrayList, true)) {
                                    m mVar3 = this.f2120c.f2137h;
                                    F0.i.b(mVar3);
                                    this.f2125i = h2;
                                    Socket socket2 = mVar.f2151d;
                                    F0.i.b(socket2);
                                    Y0.b.e(socket2);
                                    F0.i.e(this.f2120c, "call");
                                    mVar = mVar3;
                                } else {
                                    synchronized (mVar) {
                                        n nVar2 = this.f2118a;
                                        nVar2.getClass();
                                        byte[] bArr3 = Y0.b.f1119a;
                                        nVar2.f2167d.add(mVar);
                                        nVar2.f2165b.c(nVar2.f2166c, 0L);
                                        this.f2120c.c(mVar);
                                        F0.i.e(this.f2120c, "call");
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            this.f2120c.f2144o = null;
                            throw th2;
                        }
                        arrayList = null;
                        mVar = new m(this.f2118a, h2);
                        this.f2120c.f2144o = mVar;
                    }
                } else if (socketM != null) {
                    throw new IllegalStateException("Check failed.");
                }
            } else {
                this.f2123f = 0;
                this.g = 0;
                this.f2124h = 0;
                if (this.f2118a.a(this.f2119b, this.f2120c, null, false)) {
                    mVar = this.f2120c.f2137h;
                    F0.i.b(mVar);
                    F0.i.e(this.f2120c, "call");
                } else {
                    h2 = this.f2125i;
                    if (h2 != null) {
                        this.f2125i = null;
                    } else {
                        pVar = this.f2121d;
                        if (pVar == null) {
                        }
                        qVar = this.f2122e;
                        if (qVar == null) {
                            C0054a c0054a3 = this.f2119b;
                            j jVar2 = this.f2120c;
                            qVar = new q(c0054a3, jVar2.f2131a.f1089y, jVar2);
                            this.f2122e = qVar;
                        }
                        if (qVar.i()) {
                            throw new NoSuchElementException();
                        }
                        arrayList = new ArrayList();
                        while (qVar.f2172a < ((List) qVar.f2176e).size()) {
                            if (qVar.f2172a < ((List) qVar.f2176e).size()) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            c0054a = (C0054a) qVar.f2173b;
                            if (z4) {
                                throw new SocketException("No route to " + c0054a.f941h.f1024d + "; exhausted proxy configurations: " + ((List) qVar.f2176e));
                            }
                            List list2 = (List) qVar.f2176e;
                            int i9 = qVar.f2172a;
                            qVar.f2172a = i9 + 1;
                            proxy = (Proxy) list2.get(i9);
                            ArrayList arrayList4 = new ArrayList();
                            qVar.f2177f = arrayList4;
                            if (proxy.type() != Proxy.Type.DIRECT) {
                                X0.p pVar5 = c0054a.f941h;
                                hostAddress = pVar5.f1024d;
                                port = pVar5.f1025e;
                            } else {
                                X0.p pVar6 = c0054a.f941h;
                                hostAddress = pVar6.f1024d;
                                port = pVar6.f1025e;
                            }
                            if (1 <= port) {
                            }
                            throw new SocketException("No route to " + hostAddress + ':' + port + "; port is out of range");
                        }
                        if (arrayList.isEmpty()) {
                            p036u0.l.r((ArrayList) qVar.g, arrayList);
                            ((ArrayList) qVar.g).clear();
                        }
                        pVar2 = new p(arrayList);
                        this.f2121d = pVar2;
                        if (!this.f2120c.f2142m) {
                            throw new IOException("Canceled");
                        }
                        if (this.f2118a.a(this.f2119b, this.f2120c, arrayList, false)) {
                            mVar = this.f2120c.f2137h;
                            F0.i.b(mVar);
                            F0.i.e(this.f2120c, "call");
                        } else {
                            if (pVar2.d()) {
                                throw new NoSuchElementException();
                            }
                            int i10 = pVar2.f2170a;
                            pVar2.f2170a = i10 + 1;
                            h2 = (H) arrayList.get(i10);
                            mVar = new m(this.f2118a, h2);
                            this.f2120c.f2144o = mVar;
                            mVar.c(i2, i3, i4, z2, this.f2120c);
                            this.f2120c.f2144o = null;
                            c0005e = this.f2120c.f2131a.f1089y;
                            synchronized (c0005e) {
                                ((LinkedHashSet) c0005e.f34b).remove(h2);
                                if (this.f2118a.a(this.f2119b, this.f2120c, arrayList, true)) {
                                    m mVar4 = this.f2120c.f2137h;
                                    F0.i.b(mVar4);
                                    this.f2125i = h2;
                                    Socket socket3 = mVar.f2151d;
                                    F0.i.b(socket3);
                                    Y0.b.e(socket3);
                                    F0.i.e(this.f2120c, "call");
                                    mVar = mVar4;
                                } else {
                                    synchronized (mVar) {
                                        n nVar3 = this.f2118a;
                                        nVar3.getClass();
                                        byte[] bArr4 = Y0.b.f1119a;
                                        nVar3.f2167d.add(mVar);
                                        nVar3.f2165b.c(nVar3.f2166c, 0L);
                                        this.f2120c.c(mVar);
                                        F0.i.e(this.f2120c, "call");
                                    }
                                }
                            }
                        }
                    }
                    arrayList = null;
                    mVar = new m(this.f2118a, h2);
                    this.f2120c.f2144o = mVar;
                    mVar.c(i2, i3, i4, z2, this.f2120c);
                    this.f2120c.f2144o = null;
                    c0005e = this.f2120c.f2131a.f1089y;
                    synchronized (c0005e) {
                        ((LinkedHashSet) c0005e.f34b).remove(h2);
                        if (this.f2118a.a(this.f2119b, this.f2120c, arrayList, true)) {
                            m mVar5 = this.f2120c.f2137h;
                            F0.i.b(mVar5);
                            this.f2125i = h2;
                            Socket socket4 = mVar.f2151d;
                            F0.i.b(socket4);
                            Y0.b.e(socket4);
                            F0.i.e(this.f2120c, "call");
                            mVar = mVar5;
                        } else {
                            synchronized (mVar) {
                                n nVar4 = this.f2118a;
                                nVar4.getClass();
                                byte[] bArr5 = Y0.b.f1119a;
                                nVar4.f2167d.add(mVar);
                                nVar4.f2165b.c(nVar4.f2166c, 0L);
                                this.f2120c.c(mVar);
                                F0.i.e(this.f2120c, "call");
                            }
                        }
                    }
                }
            }
            if (mVar.i(z3)) {
                return mVar;
            }
            mVar.k();
            if (this.f2125i == null) {
                p pVar7 = this.f2121d;
                if (pVar7 != null ? pVar7.d() : true) {
                    continue;
                } else {
                    q qVar2 = this.f2122e;
                    if (!(qVar2 != null ? qVar2.i() : true)) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
        throw new IOException("Canceled");
    }

    public final boolean b(X0.p pVar) {
        F0.i.e(pVar, "url");
        X0.p pVar2 = this.f2119b.f941h;
        return pVar.f1025e == pVar2.f1025e && F0.i.a(pVar.f1024d, pVar2.f1024d);
    }

    public final void c(IOException iOException) {
        F0.i.e(iOException, "e");
        this.f2125i = null;
        if ((iOException instanceof C) && ((C) iOException).f2275a == 8) {
            this.f2123f++;
        } else if (iOException instanceof C0108a) {
            this.g++;
        } else {
            this.f2124h++;
        }
    }
}
