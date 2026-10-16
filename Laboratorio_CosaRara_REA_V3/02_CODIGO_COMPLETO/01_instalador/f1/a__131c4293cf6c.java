// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f1;

import H.C0028c;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public final class a extends n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f2701d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f2702c;

    static {
        f2701d = C0028c.v() && Build.VERSION.SDK_INT >= 29;
    }

    public a() {
        ArrayList arrayListX = p036u0.e.x(new g1.n[]{(!C0028c.v() || Build.VERSION.SDK_INT < 29) ? null : new g1.a(), new g1.m(g1.f.f2763f), new g1.m(g1.k.f2773a), new g1.m(g1.h.f2769a)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : arrayListX) {
            if (((g1.n) obj).c()) {
                arrayList.add(obj);
            }
        }
        this.f2702c = arrayList;
    }

    @Override // f1.n
    public final d b(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        g1.b bVar = x509TrustManagerExtensions != null ? new g1.b(x509TrustManager, x509TrustManagerExtensions) : null;
        return bVar != null ? bVar : new j1.a(c(x509TrustManager));
    }

    @Override // f1.n
    public final void d(SSLSocket sSLSocket, String str, List list) {
        Object next;
        F0.i.e(list, "protocols");
        Iterator it = this.f2702c.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((g1.n) next).a(sSLSocket));
        g1.n nVar = (g1.n) next;
        if (nVar != null) {
            nVar.d(sSLSocket, str, list);
        }
    }

    @Override // f1.n
    public final String f(SSLSocket sSLSocket) {
        Object next;
        Iterator it = this.f2702c.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((g1.n) next).a(sSLSocket));
        g1.n nVar = (g1.n) next;
        if (nVar != null) {
            return nVar.b(sSLSocket);
        }
        return null;
    }

    @Override // f1.n
    public final boolean h(String str) {
        F0.i.e(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }
}
