// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
public final class b implements j1.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final X509TrustManager f2703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f2704b;

    public b(X509TrustManager x509TrustManager, Method method) {
        this.f2703a = x509TrustManager;
        this.f2704b = method;
    }

    @Override // j1.d
    public final X509Certificate a(X509Certificate x509Certificate) {
        try {
            Object objInvoke = this.f2704b.invoke(this.f2703a, x509Certificate);
            F0.i.c(objInvoke, "null cannot be cast to non-null type java.security.cert.TrustAnchor");
            return ((TrustAnchor) objInvoke).getTrustedCert();
        } catch (IllegalAccessException e2) {
            throw new AssertionError("unable to get issues and signature", e2);
        } catch (InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return F0.i.a(this.f2703a, bVar.f2703a) && F0.i.a(this.f2704b, bVar.f2704b);
    }

    public final int hashCode() {
        return this.f2704b.hashCode() + (this.f2703a.hashCode() * 31);
    }

    public final String toString() {
        return "CustomTrustRootIndex(trustManager=" + this.f2703a + ", findByIssuerAndSignatureMethod=" + this.f2704b + ')';
    }
}
