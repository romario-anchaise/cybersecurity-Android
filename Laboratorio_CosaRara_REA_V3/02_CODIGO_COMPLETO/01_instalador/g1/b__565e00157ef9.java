// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g1;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public final class b extends f1.d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final X509TrustManager f2758m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final X509TrustManagerExtensions f2759n;

    public b(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        this.f2758m = x509TrustManager;
        this.f2759n = x509TrustManagerExtensions;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof b) && ((b) obj).f2758m == this.f2758m;
    }

    @Override // f1.d
    public final List h(List list, String str) throws SSLPeerUnverifiedException {
        F0.i.e(list, "chain");
        F0.i.e(str, "hostname");
        try {
            List<X509Certificate> listCheckServerTrusted = this.f2759n.checkServerTrusted((X509Certificate[]) list.toArray(new X509Certificate[0]), "RSA", str);
            F0.i.d(listCheckServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return listCheckServerTrusted;
        } catch (CertificateException e2) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
            sSLPeerUnverifiedException.initCause(e2);
            throw sSLPeerUnverifiedException;
        }
    }

    public final int hashCode() {
        return System.identityHashCode(this.f2758m);
    }
}
