// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i2;

import e2.n1;
import java.net.ProxySelector;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y.i f2213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n1 f2214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f2215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f2216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l f2217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f2219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2220h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2221i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f2222j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f2223k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ProxySelector f2224l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f2225m;
    public SocketFactory n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SSLSocketFactory f2226o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public X509TrustManager f2227p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List f2228q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List f2229r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public u2.c f2230s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public f f2231t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public m0.a f2232u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2233v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2234w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2235x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f2236y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public n1 f2237z;

    public t() {
        y.i iVar = new y.i();
        iVar.f5984b = new ArrayDeque();
        iVar.f5985c = new ArrayDeque();
        iVar.f5986d = new ArrayDeque();
        this.f2213a = iVar;
        this.f2214b = new n1(8);
        this.f2215c = new ArrayList();
        this.f2216d = new ArrayList();
        this.f2217e = new b2.a(23);
        this.f2218f = true;
        b bVar = b.f2117a;
        this.f2219g = bVar;
        this.f2220h = true;
        this.f2221i = true;
        this.f2222j = b.f2118b;
        this.f2223k = b.f2119c;
        this.f2225m = bVar;
        SocketFactory socketFactory = SocketFactory.getDefault();
        socketFactory.getClass();
        this.n = socketFactory;
        this.f2228q = u.D;
        this.f2229r = u.C;
        this.f2230s = u2.c.f3266a;
        this.f2231t = f.f2143c;
        this.f2233v = 10000;
        this.f2234w = 10000;
        this.f2235x = 10000;
        this.f2236y = 1024L;
    }

    public final void a(SocketFactory socketFactory) {
        socketFactory.getClass();
        if (socketFactory instanceof SSLSocketFactory) {
            o2.i("socketFactory instanceof SSLSocketFactory");
            return;
        }
        if (!socketFactory.equals(this.n)) {
            this.f2237z = null;
        }
        this.n = socketFactory;
    }
}
