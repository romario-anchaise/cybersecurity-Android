// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: renamed from: X0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0054a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0055b f935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SocketFactory f936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SSLSocketFactory f937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j1.c f938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C0059f f939e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C0055b f940f;
    public final ProxySelector g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p f941h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f942i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f943j;

    public C0054a(String str, int i2, C0055b c0055b, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, j1.c cVar, C0059f c0059f, C0055b c0055b2, List list, List list2, ProxySelector proxySelector) {
        F0.i.e(str, "uriHost");
        F0.i.e(c0055b, "dns");
        F0.i.e(socketFactory, "socketFactory");
        F0.i.e(c0055b2, "proxyAuthenticator");
        F0.i.e(list, "protocols");
        F0.i.e(list2, "connectionSpecs");
        F0.i.e(proxySelector, "proxySelector");
        this.f935a = c0055b;
        this.f936b = socketFactory;
        this.f937c = sSLSocketFactory;
        this.f938d = cVar;
        this.f939e = c0059f;
        this.f940f = c0055b2;
        this.g = proxySelector;
        o oVar = new o();
        String str2 = sSLSocketFactory != null ? "https" : "http";
        if (str2.equalsIgnoreCase("http")) {
            oVar.f1013a = "http";
        } else {
            if (!str2.equalsIgnoreCase("https")) {
                throw new IllegalArgumentException("unexpected scheme: ".concat(str2));
            }
            oVar.f1013a = "https";
        }
        String strZ = f1.l.Z(C0055b.e(str, 0, 0, false, 7));
        if (strZ == null) {
            throw new IllegalArgumentException("unexpected host: ".concat(str));
        }
        oVar.f1016d = strZ;
        if (1 > i2 || i2 >= 65536) {
            throw new IllegalArgumentException(F0.h.b(i2, "unexpected port: ").toString());
        }
        oVar.f1017e = i2;
        this.f941h = oVar.a();
        this.f942i = Y0.b.w(list);
        this.f943j = Y0.b.w(list2);
    }

    public final boolean a(C0054a c0054a) {
        F0.i.e(c0054a, "that");
        return F0.i.a(this.f935a, c0054a.f935a) && F0.i.a(this.f940f, c0054a.f940f) && F0.i.a(this.f942i, c0054a.f942i) && F0.i.a(this.f943j, c0054a.f943j) && F0.i.a(this.g, c0054a.g) && F0.i.a(null, null) && F0.i.a(this.f937c, c0054a.f937c) && F0.i.a(this.f938d, c0054a.f938d) && F0.i.a(this.f939e, c0054a.f939e) && this.f941h.f1025e == c0054a.f941h.f1025e;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0054a) {
            C0054a c0054a = (C0054a) obj;
            if (F0.i.a(this.f941h, c0054a.f941h) && a(c0054a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f939e) + ((Objects.hashCode(this.f938d) + ((Objects.hashCode(this.f937c) + ((this.g.hashCode() + ((this.f943j.hashCode() + ((this.f942i.hashCode() + ((this.f940f.hashCode() + ((this.f935a.hashCode() + ((this.f941h.f1028i.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 961)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Address{");
        p pVar = this.f941h;
        sb.append(pVar.f1024d);
        sb.append(':');
        sb.append(pVar.f1025e);
        sb.append(", ");
        sb.append("proxySelector=" + this.g);
        sb.append('}');
        return sb.toString();
    }
}
