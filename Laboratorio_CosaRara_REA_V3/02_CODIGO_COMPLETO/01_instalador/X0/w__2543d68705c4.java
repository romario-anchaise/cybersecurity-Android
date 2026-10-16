// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import A.C0005e;
import java.net.ProxySelector;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public final class w implements Cloneable, InterfaceC0057d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H.x f1066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0005e f1067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f1068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f1069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final W0.t f1070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f1071f;
    public final C0055b g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f1072h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f1073i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final C0055b f1074j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C0055b f1075k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ProxySelector f1076l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final C0055b f1077m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SocketFactory f1078n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final SSLSocketFactory f1079o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final X509TrustManager f1080p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List f1081q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List f1082r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final j1.c f1083s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final C0059f f1084t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final f1.d f1085u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f1086v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f1087w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f1088x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final C0005e f1089y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final List f1065z = Y0.b.l(x.f1093e, x.f1091c);

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final List f1064A = Y0.b.l(j.f987e, j.f988f);

    public w(v vVar) {
        this.f1066a = vVar.f1045a;
        this.f1067b = vVar.f1046b;
        this.f1068c = Y0.b.w(vVar.f1047c);
        this.f1069d = Y0.b.w(vVar.f1048d);
        this.f1070e = vVar.f1049e;
        this.f1071f = vVar.f1050f;
        this.g = vVar.g;
        this.f1072h = vVar.f1051h;
        this.f1073i = vVar.f1052i;
        this.f1074j = vVar.f1053j;
        this.f1075k = vVar.f1054k;
        ProxySelector proxySelector = ProxySelector.getDefault();
        this.f1076l = proxySelector == null ? h1.a.f2842a : proxySelector;
        this.f1077m = vVar.f1055l;
        this.f1078n = vVar.f1056m;
        List list = vVar.f1057n;
        this.f1081q = list;
        this.f1082r = vVar.f1058o;
        this.f1083s = vVar.f1059p;
        this.f1086v = vVar.f1061r;
        this.f1087w = vVar.f1062s;
        this.f1088x = vVar.f1063t;
        this.f1089y = new C0005e(13);
        if (list != null && list.isEmpty()) {
            this.f1079o = null;
            this.f1085u = null;
            this.f1080p = null;
            this.f1084t = C0059f.f961c;
            break;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                this.f1079o = null;
                this.f1085u = null;
                this.f1080p = null;
                this.f1084t = C0059f.f961c;
                break;
            }
            if (((j) it.next()).f989a) {
                f1.n nVar = f1.n.f2736a;
                X509TrustManager x509TrustManagerM = f1.n.f2736a.m();
                this.f1080p = x509TrustManagerM;
                this.f1079o = f1.n.f2736a.l(x509TrustManagerM);
                f1.d dVarB = f1.n.f2736a.b(x509TrustManagerM);
                this.f1085u = dVarB;
                C0059f c0059f = vVar.f1060q;
                this.f1084t = F0.i.a(c0059f.f963b, dVarB) ? c0059f : new C0059f(c0059f.f962a, dVarB);
                break;
            }
        }
        List list2 = this.f1068c;
        F0.i.c(list2, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list2.contains(null)) {
            throw new IllegalStateException(("Null interceptor: " + list2).toString());
        }
        List list3 = this.f1069d;
        F0.i.c(list3, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (list3.contains(null)) {
            throw new IllegalStateException(("Null network interceptor: " + list3).toString());
        }
        X509TrustManager x509TrustManager = this.f1080p;
        f1.d dVar = this.f1085u;
        SSLSocketFactory sSLSocketFactory = this.f1079o;
        List list4 = this.f1081q;
        if (list4 == null || !list4.isEmpty()) {
            Iterator it2 = list4.iterator();
            while (it2.hasNext()) {
                if (((j) it2.next()).f989a) {
                    if (sSLSocketFactory == null) {
                        throw new IllegalStateException("sslSocketFactory == null");
                    }
                    if (dVar == null) {
                        throw new IllegalStateException("certificateChainCleaner == null");
                    }
                    if (x509TrustManager == null) {
                        throw new IllegalStateException("x509TrustManager == null");
                    }
                    return;
                }
            }
        }
        if (sSLSocketFactory != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (dVar != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (x509TrustManager != null) {
            throw new IllegalStateException("Check failed.");
        }
        if (!F0.i.a(this.f1084t, C0059f.f961c)) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final Object clone() {
        return super.clone();
    }
}
