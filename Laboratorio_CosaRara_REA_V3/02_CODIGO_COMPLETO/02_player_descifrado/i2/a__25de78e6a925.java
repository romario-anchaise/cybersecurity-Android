// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i2;

import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f2107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SocketFactory f2108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SSLSocketFactory f2109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HostnameVerifier f2110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f2111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f2112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ProxySelector f2113g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final q f2114h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f2115i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f2116j;

    public a(String str, int i3, b bVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, f fVar, b bVar2, List list, List list2, ProxySelector proxySelector) {
        str.getClass();
        bVar.getClass();
        socketFactory.getClass();
        bVar2.getClass();
        list.getClass();
        list2.getClass();
        proxySelector.getClass();
        this.f2107a = bVar;
        this.f2108b = socketFactory;
        this.f2109c = sSLSocketFactory;
        this.f2110d = hostnameVerifier;
        this.f2111e = fVar;
        this.f2112f = bVar2;
        this.f2113g = proxySelector;
        p pVar = new p();
        String str2 = sSLSocketFactory != null ? "https" : "http";
        if (str2.equalsIgnoreCase("http")) {
            pVar.f2193d = "http";
        } else {
            if (!str2.equalsIgnoreCase("https")) {
                o2.i("unexpected scheme: ".concat(str2));
                throw null;
            }
            pVar.f2193d = "https";
        }
        String strC = q2.c.C(b.e(str, 0, 0, 7));
        if (strC == null) {
            o2.i("unexpected host: ".concat(str));
            throw null;
        }
        pVar.f2196g = strC;
        if (1 > i3 || i3 >= 65536) {
            o2.h(a0.a.g("unexpected port: ", i3));
            throw null;
        }
        pVar.f2191b = i3;
        this.f2114h = pVar.a();
        this.f2115i = j2.b.x(list);
        this.f2116j = j2.b.x(list2);
    }

    public final boolean a(a aVar) {
        aVar.getClass();
        return q1.e.a(this.f2107a, aVar.f2107a) && q1.e.a(this.f2112f, aVar.f2112f) && q1.e.a(this.f2115i, aVar.f2115i) && q1.e.a(this.f2116j, aVar.f2116j) && q1.e.a(this.f2113g, aVar.f2113g) && q1.e.a(this.f2109c, aVar.f2109c) && q1.e.a(this.f2110d, aVar.f2110d) && q1.e.a(this.f2111e, aVar.f2111e) && this.f2114h.f2204e == aVar.f2114h.f2204e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return q1.e.a(this.f2114h, aVar.f2114h) && a(aVar);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f2111e) + ((Objects.hashCode(this.f2110d) + ((Objects.hashCode(this.f2109c) + ((this.f2113g.hashCode() + ((this.f2116j.hashCode() + ((this.f2115i.hashCode() + ((this.f2112f.hashCode() + ((this.f2107a.hashCode() + a0.a.e(527, 31, this.f2114h.f2207h)) * 31)) * 31)) * 31)) * 31)) * 961)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Address{");
        q qVar = this.f2114h;
        sb.append(qVar.f2203d);
        sb.append(':');
        sb.append(qVar.f2204e);
        sb.append(", ");
        sb.append("proxySelector=" + this.f2113g);
        sb.append('}');
        return sb.toString();
    }
}
