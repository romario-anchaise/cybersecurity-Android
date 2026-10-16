// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package r2;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends m0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final X509TrustManager f3172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final X509TrustManagerExtensions f3173d;

    public b(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        this.f3172c = x509TrustManager;
        this.f3173d = x509TrustManagerExtensions;
    }

    @Override // m0.a
    public final List b(String str, List list) throws SSLPeerUnverifiedException {
        list.getClass();
        str.getClass();
        try {
            List<X509Certificate> listCheckServerTrusted = this.f3173d.checkServerTrusted((X509Certificate[]) list.toArray(new X509Certificate[0]), "RSA", str);
            listCheckServerTrusted.getClass();
            return listCheckServerTrusted;
        } catch (CertificateException e3) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e3.getMessage());
            sSLPeerUnverifiedException.initCause(e3);
            throw sSLPeerUnverifiedException;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof b) && ((b) obj).f3172c == this.f3172c;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f3172c);
    }
}
