// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m2;

import d2.y;
import e2.n1;
import i1.o;
import i2.b0;
import i2.p;
import i2.q;
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
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Pattern;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f2701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i2.a f2702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f2703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i2.m f2704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f2.e f2705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p f2706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2707g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2708h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2709i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b0 f2710j;

    public e(y yVar, i2.a aVar, i iVar, i2.m mVar) {
        yVar.getClass();
        mVar.getClass();
        this.f2701a = yVar;
        this.f2702b = aVar;
        this.f2703c = iVar;
        this.f2704d = mVar;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x028b  */
    /* JADX WARN: Code duplicated, block: B:128:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:130:0x02af  */
    /* JADX WARN: Code duplicated, block: B:131:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:133:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:142:0x0308  */
    /* JADX WARN: Code duplicated, block: B:143:0x0321  */
    /* JADX WARN: Code duplicated, block: B:183:0x0322 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x02f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:198:0x0391 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:199:0x0263 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:204:0x038b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:205:0x0385 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x0074  */
    /* JADX WARN: Code duplicated, block: B:36:0x0081  */
    /* JADX WARN: Code duplicated, block: B:38:0x0085  */
    /* JADX WARN: Code duplicated, block: B:40:0x008a  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:73:0x0151  */
    /* JADX WARN: Type inference failed for: r5v16, types: [java.lang.Object, java.util.List] */
    public final m a(int i3, int i4, int i5, boolean z2, boolean z3) throws IOException {
        b0 b0Var;
        f2.e eVar;
        p pVar;
        ArrayList arrayList;
        f2.e eVar2;
        i2.a aVar;
        Proxy proxy;
        String hostAddress;
        int port;
        List arrayList2;
        List listK;
        boolean zContains;
        m mVar;
        n1 n1Var;
        Socket socketJ;
        while (!this.f2703c.f2730r) {
            m mVar2 = this.f2703c.f2725l;
            if (mVar2 != null) {
                synchronized (mVar2) {
                    try {
                        if (!mVar2.f2749j) {
                            q qVar = mVar2.f2741b.f2120a.f2114h;
                            qVar.getClass();
                            q qVar2 = this.f2702b.f2114h;
                            socketJ = !(qVar.f2204e == qVar2.f2204e && q1.e.a(qVar.f2203d, qVar2.f2203d)) ? this.f2703c.j() : null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (this.f2703c.f2725l == null) {
                    if (socketJ != null) {
                        j2.b.e(socketJ);
                    }
                    this.f2704d.getClass();
                    this.f2707g = 0;
                    this.f2708h = 0;
                    this.f2709i = 0;
                    if (this.f2701a.a(this.f2702b, this.f2703c, null, false)) {
                        mVar2 = this.f2703c.f2725l;
                        mVar2.getClass();
                        this.f2704d.getClass();
                    } else {
                        b0Var = this.f2710j;
                        try {
                            if (b0Var != null) {
                                this.f2710j = null;
                            } else {
                                eVar = this.f2705e;
                                if (eVar == null && eVar.a()) {
                                    f2.e eVar3 = this.f2705e;
                                    eVar3.getClass();
                                    if (!eVar3.a()) {
                                        throw new NoSuchElementException();
                                    }
                                    ArrayList arrayList3 = eVar3.f1180b;
                                    int i6 = eVar3.f1179a;
                                    eVar3.f1179a = i6 + 1;
                                    b0Var = (b0) arrayList3.get(i6);
                                } else {
                                    pVar = this.f2706f;
                                    if (pVar == null) {
                                        i2.a aVar2 = this.f2702b;
                                        i iVar = this.f2703c;
                                        pVar = new p(aVar2, iVar.f2716c.B, iVar, this.f2704d);
                                        this.f2706f = pVar;
                                    }
                                    if (pVar.c()) {
                                        throw new NoSuchElementException();
                                    }
                                    arrayList = new ArrayList();
                                    while (pVar.f2191b < ((List) pVar.f2197h).size()) {
                                        aVar = (i2.a) pVar.f2193d;
                                        if (pVar.f2191b < ((List) pVar.f2197h).size()) {
                                            throw new SocketException("No route to " + aVar.f2114h.f2203d + "; exhausted proxy configurations: " + ((List) pVar.f2197h));
                                        }
                                        List list = (List) pVar.f2197h;
                                        int i7 = pVar.f2191b;
                                        pVar.f2191b = i7 + 1;
                                        proxy = (Proxy) list.get(i7);
                                        i iVar2 = (i) pVar.f2195f;
                                        i2.m mVar3 = (i2.m) pVar.f2196g;
                                        ArrayList arrayList4 = new ArrayList();
                                        pVar.f2198i = arrayList4;
                                        if (proxy.type() != Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                                            q qVar3 = aVar.f2114h;
                                            hostAddress = qVar3.f2203d;
                                            port = qVar3.f2204e;
                                        } else {
                                            SocketAddress socketAddressAddress = proxy.address();
                                            if (!(socketAddressAddress instanceof InetSocketAddress)) {
                                                b2.a.l(socketAddressAddress.getClass(), "Proxy.address() is not an InetSocketAddress: ");
                                                return null;
                                            }
                                            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                                            InetAddress address = inetSocketAddress.getAddress();
                                            if (address == null) {
                                                hostAddress = inetSocketAddress.getHostName();
                                                hostAddress.getClass();
                                            } else {
                                                hostAddress = address.getHostAddress();
                                                hostAddress.getClass();
                                            }
                                            port = inetSocketAddress.getPort();
                                        }
                                        if (1 <= port || port >= 65536) {
                                            throw new SocketException("No route to " + hostAddress + ':' + port + "; port is out of range");
                                        }
                                        if (proxy.type() == Proxy.Type.SOCKS) {
                                            arrayList4.add(InetSocketAddress.createUnresolved(hostAddress, port));
                                        } else {
                                            byte[] bArr = j2.b.f2361a;
                                            hostAddress.getClass();
                                            q1.i iVar3 = j2.b.f2366f;
                                            iVar3.getClass();
                                            if (((Pattern) iVar3.f3129d).matcher(hostAddress).matches()) {
                                                listK = m0.a.k(InetAddress.getByName(hostAddress));
                                            } else {
                                                mVar3.b(iVar2, hostAddress);
                                                aVar.f2107a.getClass();
                                                try {
                                                    InetAddress[] allByName = InetAddress.getAllByName(hostAddress);
                                                    allByName.getClass();
                                                    int length = allByName.length;
                                                    if (length != 0) {
                                                        arrayList2 = length != 1 ? new ArrayList(new i1.g(allByName, false)) : m0.a.k(allByName[0]);
                                                    } else {
                                                        arrayList2 = i1.q.f2104c;
                                                    }
                                                    if (arrayList2.isEmpty()) {
                                                        throw new UnknownHostException(aVar.f2107a + " returned no addresses for " + hostAddress);
                                                    }
                                                    listK = arrayList2;
                                                } catch (NullPointerException e3) {
                                                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(hostAddress));
                                                    unknownHostException.initCause(e3);
                                                    throw unknownHostException;
                                                }
                                            }
                                            Iterator it = listK.iterator();
                                            while (it.hasNext()) {
                                                arrayList4.add(new InetSocketAddress((InetAddress) it.next(), port));
                                            }
                                        }
                                        Iterator it2 = pVar.f2198i.iterator();
                                        while (it2.hasNext()) {
                                            b0 b0Var2 = new b0((i2.a) pVar.f2193d, proxy, (InetSocketAddress) it2.next());
                                            n1 n1Var2 = (n1) pVar.f2194e;
                                            synchronized (n1Var2) {
                                                zContains = ((LinkedHashSet) n1Var2.f905c).contains(b0Var2);
                                            }
                                            if (zContains) {
                                                pVar.f2192c.add(b0Var2);
                                            } else {
                                                arrayList.add(b0Var2);
                                            }
                                        }
                                        if (!arrayList.isEmpty()) {
                                            break;
                                        }
                                    }
                                    if (arrayList.isEmpty()) {
                                        o.B(arrayList, pVar.f2192c);
                                        pVar.f2192c.clear();
                                    }
                                    eVar2 = new f2.e(arrayList, 2);
                                    this.f2705e = eVar2;
                                    if (!this.f2703c.f2730r) {
                                        o2.l("Canceled");
                                        return null;
                                    }
                                    if (this.f2701a.a(this.f2702b, this.f2703c, arrayList, false)) {
                                        mVar2 = this.f2703c.f2725l;
                                        mVar2.getClass();
                                        this.f2704d.getClass();
                                    } else {
                                        if (eVar2.a()) {
                                            throw new NoSuchElementException();
                                        }
                                        int i8 = eVar2.f1179a;
                                        eVar2.f1179a = i8 + 1;
                                        b0Var = (b0) arrayList.get(i8);
                                        mVar = new m(this.f2701a, b0Var);
                                        this.f2703c.f2732t = mVar;
                                        mVar.c(i3, i4, i5, z2, this.f2703c, this.f2704d);
                                        this.f2703c.f2732t = null;
                                        n1Var = this.f2703c.f2716c.B;
                                        synchronized (n1Var) {
                                            ((LinkedHashSet) n1Var.f905c).remove(b0Var);
                                        }
                                        if (this.f2701a.a(this.f2702b, this.f2703c, arrayList, true)) {
                                            m mVar4 = this.f2703c.f2725l;
                                            mVar4.getClass();
                                            this.f2710j = b0Var;
                                            Socket socket = mVar.f2743d;
                                            socket.getClass();
                                            j2.b.e(socket);
                                            this.f2704d.getClass();
                                            mVar2 = mVar4;
                                        } else {
                                            synchronized (mVar) {
                                                y yVar = this.f2701a;
                                                yVar.getClass();
                                                byte[] bArr2 = j2.b.f2361a;
                                                ((ConcurrentLinkedQueue) yVar.f652b).add(mVar);
                                                ((l2.c) yVar.f654d).c((l2.b) yVar.f651a, 0L);
                                                this.f2703c.b(mVar);
                                            }
                                            this.f2704d.getClass();
                                            mVar2 = mVar;
                                        }
                                    }
                                }
                            }
                            mVar.c(i3, i4, i5, z2, this.f2703c, this.f2704d);
                            this.f2703c.f2732t = null;
                            n1Var = this.f2703c.f2716c.B;
                            synchronized (n1Var) {
                                ((LinkedHashSet) n1Var.f905c).remove(b0Var);
                                if (this.f2701a.a(this.f2702b, this.f2703c, arrayList, true)) {
                                    m mVar5 = this.f2703c.f2725l;
                                    mVar5.getClass();
                                    this.f2710j = b0Var;
                                    Socket socket2 = mVar.f2743d;
                                    socket2.getClass();
                                    j2.b.e(socket2);
                                    this.f2704d.getClass();
                                    mVar2 = mVar5;
                                } else {
                                    synchronized (mVar) {
                                        y yVar2 = this.f2701a;
                                        yVar2.getClass();
                                        byte[] bArr3 = j2.b.f2361a;
                                        ((ConcurrentLinkedQueue) yVar2.f652b).add(mVar);
                                        ((l2.c) yVar2.f654d).c((l2.b) yVar2.f651a, 0L);
                                        this.f2703c.b(mVar);
                                        this.f2704d.getClass();
                                        mVar2 = mVar;
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            this.f2703c.f2732t = null;
                            throw th2;
                        }
                        arrayList = null;
                        mVar = new m(this.f2701a, b0Var);
                        this.f2703c.f2732t = mVar;
                    }
                } else if (socketJ != null) {
                    o2.k("Check failed.");
                    return null;
                }
            } else {
                this.f2707g = 0;
                this.f2708h = 0;
                this.f2709i = 0;
                if (this.f2701a.a(this.f2702b, this.f2703c, null, false)) {
                    mVar2 = this.f2703c.f2725l;
                    mVar2.getClass();
                    this.f2704d.getClass();
                } else {
                    b0Var = this.f2710j;
                    if (b0Var != null) {
                        this.f2710j = null;
                    } else {
                        eVar = this.f2705e;
                        if (eVar == null) {
                        }
                        pVar = this.f2706f;
                        if (pVar == null) {
                            i2.a aVar3 = this.f2702b;
                            i iVar4 = this.f2703c;
                            pVar = new p(aVar3, iVar4.f2716c.B, iVar4, this.f2704d);
                            this.f2706f = pVar;
                        }
                        if (pVar.c()) {
                            throw new NoSuchElementException();
                        }
                        arrayList = new ArrayList();
                        while (pVar.f2191b < ((List) pVar.f2197h).size()) {
                            aVar = (i2.a) pVar.f2193d;
                            if (pVar.f2191b < ((List) pVar.f2197h).size()) {
                                throw new SocketException("No route to " + aVar.f2114h.f2203d + "; exhausted proxy configurations: " + ((List) pVar.f2197h));
                            }
                            List list2 = (List) pVar.f2197h;
                            int i9 = pVar.f2191b;
                            pVar.f2191b = i9 + 1;
                            proxy = (Proxy) list2.get(i9);
                            i iVar5 = (i) pVar.f2195f;
                            i2.m mVar6 = (i2.m) pVar.f2196g;
                            ArrayList arrayList5 = new ArrayList();
                            pVar.f2198i = arrayList5;
                            if (proxy.type() != Proxy.Type.DIRECT) {
                                q qVar4 = aVar.f2114h;
                                hostAddress = qVar4.f2203d;
                                port = qVar4.f2204e;
                            } else {
                                q qVar5 = aVar.f2114h;
                                hostAddress = qVar5.f2203d;
                                port = qVar5.f2204e;
                            }
                            if (1 <= port) {
                            }
                            throw new SocketException("No route to " + hostAddress + ':' + port + "; port is out of range");
                        }
                        if (arrayList.isEmpty()) {
                            o.B(arrayList, pVar.f2192c);
                            pVar.f2192c.clear();
                        }
                        eVar2 = new f2.e(arrayList, 2);
                        this.f2705e = eVar2;
                        if (!this.f2703c.f2730r) {
                            o2.l("Canceled");
                            return null;
                        }
                        if (this.f2701a.a(this.f2702b, this.f2703c, arrayList, false)) {
                            mVar2 = this.f2703c.f2725l;
                            mVar2.getClass();
                            this.f2704d.getClass();
                        } else {
                            if (eVar2.a()) {
                                throw new NoSuchElementException();
                            }
                            int i10 = eVar2.f1179a;
                            eVar2.f1179a = i10 + 1;
                            b0Var = (b0) arrayList.get(i10);
                            mVar = new m(this.f2701a, b0Var);
                            this.f2703c.f2732t = mVar;
                            mVar.c(i3, i4, i5, z2, this.f2703c, this.f2704d);
                            this.f2703c.f2732t = null;
                            n1Var = this.f2703c.f2716c.B;
                            synchronized (n1Var) {
                                ((LinkedHashSet) n1Var.f905c).remove(b0Var);
                                if (this.f2701a.a(this.f2702b, this.f2703c, arrayList, true)) {
                                    m mVar7 = this.f2703c.f2725l;
                                    mVar7.getClass();
                                    this.f2710j = b0Var;
                                    Socket socket3 = mVar.f2743d;
                                    socket3.getClass();
                                    j2.b.e(socket3);
                                    this.f2704d.getClass();
                                    mVar2 = mVar7;
                                } else {
                                    synchronized (mVar) {
                                        y yVar3 = this.f2701a;
                                        yVar3.getClass();
                                        byte[] bArr4 = j2.b.f2361a;
                                        ((ConcurrentLinkedQueue) yVar3.f652b).add(mVar);
                                        ((l2.c) yVar3.f654d).c((l2.b) yVar3.f651a, 0L);
                                        this.f2703c.b(mVar);
                                        this.f2704d.getClass();
                                        mVar2 = mVar;
                                    }
                                }
                            }
                        }
                    }
                    arrayList = null;
                    mVar = new m(this.f2701a, b0Var);
                    this.f2703c.f2732t = mVar;
                    mVar.c(i3, i4, i5, z2, this.f2703c, this.f2704d);
                    this.f2703c.f2732t = null;
                    n1Var = this.f2703c.f2716c.B;
                    synchronized (n1Var) {
                        ((LinkedHashSet) n1Var.f905c).remove(b0Var);
                        if (this.f2701a.a(this.f2702b, this.f2703c, arrayList, true)) {
                            m mVar8 = this.f2703c.f2725l;
                            mVar8.getClass();
                            this.f2710j = b0Var;
                            Socket socket4 = mVar.f2743d;
                            socket4.getClass();
                            j2.b.e(socket4);
                            this.f2704d.getClass();
                            mVar2 = mVar8;
                        } else {
                            synchronized (mVar) {
                                y yVar4 = this.f2701a;
                                yVar4.getClass();
                                byte[] bArr5 = j2.b.f2361a;
                                ((ConcurrentLinkedQueue) yVar4.f652b).add(mVar);
                                ((l2.c) yVar4.f654d).c((l2.b) yVar4.f651a, 0L);
                                this.f2703c.b(mVar);
                                this.f2704d.getClass();
                                mVar2 = mVar;
                            }
                        }
                    }
                }
            }
            if (mVar2.i(z3)) {
                return mVar2;
            }
            mVar2.k();
            if (this.f2710j == null) {
                f2.e eVar4 = this.f2705e;
                if (eVar4 != null ? eVar4.a() : true) {
                    continue;
                } else {
                    p pVar2 = this.f2706f;
                    if (!(pVar2 != null ? pVar2.c() : true)) {
                        o2.l("exhausted all routes");
                        return null;
                    }
                }
            }
        }
        o2.l("Canceled");
        return null;
    }

    public final void b(IOException iOException) {
        iOException.getClass();
        this.f2710j = null;
        if ((iOException instanceof p2.b0) && ((p2.b0) iOException).f2885c == 8) {
            this.f2707g++;
        } else if (iOException instanceof p2.a) {
            this.f2708h++;
        } else {
            this.f2709i++;
        }
    }
}
