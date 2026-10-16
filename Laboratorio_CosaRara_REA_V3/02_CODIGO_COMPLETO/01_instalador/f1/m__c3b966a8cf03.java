// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f1;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.openjsse.net.ssl.OpenJSSE;

/* JADX INFO: loaded from: classes.dex */
public final class m extends n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f2734d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Provider f2735c = new OpenJSSE();

    static {
        boolean z2 = false;
        try {
            Class.forName("org.openjsse.net.ssl.OpenJSSE", false, l.class.getClassLoader());
            z2 = true;
        } catch (ClassNotFoundException unused) {
        }
        f2734d = z2;
    }

    @Override // f1.n
    public final void d(SSLSocket sSLSocket, String str, List list) {
        F0.i.e(list, "protocols");
        super.d(sSLSocket, str, list);
    }

    @Override // f1.n
    public final String f(SSLSocket sSLSocket) {
        return null;
    }

    @Override // f1.n
    public final SSLContext k() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.3", this.f2735c);
        F0.i.d(sSLContext, "getInstance(\"TLSv1.3\", provider)");
        return sSLContext;
    }

    @Override // f1.n
    public final X509TrustManager m() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.f2735c);
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        F0.i.b(trustManagers);
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                F0.i.c(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                return (X509TrustManager) trustManager;
            }
        }
        String string = Arrays.toString(trustManagers);
        F0.i.d(string, "toString(this)");
        throw new IllegalStateException("Unexpected default trust managers: ".concat(string).toString());
    }
}
