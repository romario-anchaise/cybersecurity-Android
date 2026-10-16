// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i2;

import e2.n1;
import java.net.ProtocolException;
import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements Cloneable, d0 {
    public static final List C = j2.b.l(v.f2264g, v.f2262e);
    public static final List D = j2.b.l(i.f2165e, i.f2166f);
    public final long A;
    public final n1 B;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y.i f2238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n1 f2239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f2240e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List f2241f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l f2242g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f2243h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f2244i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f2245j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f2246k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f2247l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f2248m;
    public final ProxySelector n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f2249o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final SocketFactory f2250p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final SSLSocketFactory f2251q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final X509TrustManager f2252r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List f2253s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List f2254t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final u2.c f2255u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final f f2256v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final m0.a f2257w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f2258x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f2259y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f2260z;

    public u(t tVar) throws NoSuchAlgorithmException, KeyStoreException {
        this.f2238c = tVar.f2213a;
        this.f2239d = tVar.f2214b;
        this.f2240e = j2.b.x(tVar.f2215c);
        this.f2241f = j2.b.x(tVar.f2216d);
        this.f2242g = tVar.f2217e;
        this.f2243h = tVar.f2218f;
        this.f2244i = tVar.f2219g;
        this.f2245j = tVar.f2220h;
        this.f2246k = tVar.f2221i;
        this.f2247l = tVar.f2222j;
        this.f2248m = tVar.f2223k;
        ProxySelector proxySelector = tVar.f2224l;
        proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
        this.n = proxySelector == null ? s2.a.f3237a : proxySelector;
        this.f2249o = tVar.f2225m;
        this.f2250p = tVar.n;
        List list = tVar.f2228q;
        this.f2253s = list;
        this.f2254t = tVar.f2229r;
        this.f2255u = tVar.f2230s;
        this.f2258x = tVar.f2233v;
        this.f2259y = tVar.f2234w;
        this.f2260z = tVar.f2235x;
        this.A = tVar.f2236y;
        n1 n1Var = tVar.f2237z;
        this.B = n1Var == null ? new n1(12) : n1Var;
        if (list != null && list.isEmpty()) {
            this.f2251q = null;
            this.f2257w = null;
            this.f2252r = null;
            this.f2256v = f.f2143c;
            break;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                this.f2251q = null;
                this.f2257w = null;
                this.f2252r = null;
                this.f2256v = f.f2143c;
                break;
            }
            if (((i) it.next()).f2167a) {
                SSLSocketFactory sSLSocketFactory = tVar.f2226o;
                if (sSLSocketFactory == null) {
                    q2.m mVar = q2.m.f3156a;
                    X509TrustManager x509TrustManagerJ = q2.m.f3156a.j();
                    this.f2252r = x509TrustManagerJ;
                    this.f2251q = q2.m.f3156a.i(x509TrustManagerJ);
                    m0.a aVarB = q2.m.f3156a.b(x509TrustManagerJ);
                    this.f2257w = aVarB;
                    f fVar = tVar.f2231t;
                    fVar.getClass();
                    this.f2256v = q1.e.a(fVar.f2145b, aVarB) ? fVar : new f(fVar.f2144a, aVarB);
                    break;
                }
                this.f2251q = sSLSocketFactory;
                m0.a aVar = tVar.f2232u;
                aVar.getClass();
                this.f2257w = aVar;
                X509TrustManager x509TrustManager = tVar.f2227p;
                x509TrustManager.getClass();
                this.f2252r = x509TrustManager;
                f fVar2 = tVar.f2231t;
                fVar2.getClass();
                this.f2256v = q1.e.a(fVar2.f2145b, aVar) ? fVar2 : new f(fVar2.f2144a, aVar);
                break;
            }
        }
        X509TrustManager x509TrustManager2 = this.f2252r;
        m0.a aVar2 = this.f2257w;
        SSLSocketFactory sSLSocketFactory2 = this.f2251q;
        List list2 = this.f2241f;
        List list3 = this.f2240e;
        list3.getClass();
        if (list3.contains(null)) {
            throw new IllegalStateException(("Null interceptor: " + list3).toString());
        }
        list2.getClass();
        if (list2.contains(null)) {
            throw new IllegalStateException(("Null network interceptor: " + list2).toString());
        }
        List list4 = this.f2253s;
        if (list4 == null || !list4.isEmpty()) {
            Iterator it2 = list4.iterator();
            while (it2.hasNext()) {
                if (((i) it2.next()).f2167a) {
                    if (sSLSocketFactory2 == null) {
                        o2.k("sslSocketFactory == null");
                        throw null;
                    }
                    if (aVar2 == null) {
                        o2.k("certificateChainCleaner == null");
                        throw null;
                    }
                    if (x509TrustManager2 != null) {
                        return;
                    }
                    o2.k("x509TrustManager == null");
                    throw null;
                }
            }
        }
        if (sSLSocketFactory2 != null) {
            o2.k("Check failed.");
            throw null;
        }
        if (aVar2 != null) {
            o2.k("Check failed.");
            throw null;
        }
        if (x509TrustManager2 != null) {
            o2.k("Check failed.");
            throw null;
        }
        if (q1.e.a(this.f2256v, f.f2143c)) {
            return;
        }
        o2.k("Check failed.");
        throw null;
    }

    @Override // i2.d0
    public final v2.g a(b2.d dVar, c cVar) {
        v2.g gVar = new v2.g(l2.e.f2421h, dVar, cVar, new Random(), 0, this.A);
        if (((o) dVar.f267d).a("Sec-WebSocket-Extensions") != null) {
            gVar.c(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
            return gVar;
        }
        t tVar = new t();
        tVar.f2213a = this.f2238c;
        tVar.f2214b = this.f2239d;
        i1.o.B(tVar.f2215c, this.f2240e);
        i1.o.B(tVar.f2216d, this.f2241f);
        tVar.f2217e = this.f2242g;
        tVar.f2218f = this.f2243h;
        tVar.f2219g = this.f2244i;
        tVar.f2220h = this.f2245j;
        tVar.f2221i = this.f2246k;
        tVar.f2222j = this.f2247l;
        tVar.f2223k = this.f2248m;
        tVar.f2224l = this.n;
        tVar.f2225m = this.f2249o;
        tVar.n = this.f2250p;
        tVar.f2226o = this.f2251q;
        tVar.f2227p = this.f2252r;
        tVar.f2228q = this.f2253s;
        tVar.f2229r = this.f2254t;
        tVar.f2230s = this.f2255u;
        tVar.f2231t = this.f2256v;
        tVar.f2232u = this.f2257w;
        tVar.f2233v = this.f2258x;
        tVar.f2234w = this.f2259y;
        tVar.f2235x = this.f2260z;
        tVar.f2236y = this.A;
        tVar.f2237z = this.B;
        byte[] bArr = j2.b.f2361a;
        tVar.f2217e = new b2.a(23);
        List list = v2.g.f3304w;
        list.getClass();
        ArrayList arrayList = new ArrayList(list);
        v vVar = v.f2265h;
        if (!arrayList.contains(vVar) && !arrayList.contains(v.f2262e)) {
            b2.a.l(arrayList, "protocols must contain h2_prior_knowledge or http/1.1: ");
            return null;
        }
        if (arrayList.contains(vVar) && arrayList.size() > 1) {
            b2.a.l(arrayList, "protocols containing h2_prior_knowledge cannot use other protocols: ");
            return null;
        }
        if (arrayList.contains(v.f2261d)) {
            b2.a.l(arrayList, "protocols must not contain http/1.0: ");
            return null;
        }
        if (arrayList.contains(null)) {
            o2.i("protocols must not contain null");
            return null;
        }
        arrayList.remove(v.f2263f);
        if (!arrayList.equals(tVar.f2229r)) {
            tVar.f2237z = null;
        }
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        listUnmodifiableList.getClass();
        tVar.f2229r = listUnmodifiableList;
        u uVar = new u(tVar);
        w wVarA = dVar.a();
        wVarA.b("Upgrade", "websocket");
        wVarA.b("Connection", "Upgrade");
        wVarA.b("Sec-WebSocket-Key", gVar.f3310f);
        wVarA.b("Sec-WebSocket-Version", "13");
        wVarA.b("Sec-WebSocket-Extensions", "permessage-deflate");
        b2.d dVarA = wVarA.a();
        m2.i iVar = new m2.i(uVar, dVarA, true);
        gVar.f3311g = iVar;
        iVar.e(new y.c(gVar, dVarA, 9));
        return gVar;
    }

    public final Object clone() {
        return super.clone();
    }
}
