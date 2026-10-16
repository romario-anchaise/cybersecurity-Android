// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f1;

import H.C0028c;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;

/* JADX INFO: loaded from: classes.dex */
public final class h extends n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f2722d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Provider f2723c;

    static {
        boolean z2 = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, f.class.getClassLoader());
            if (Conscrypt.isAvailable() && f.a()) {
                z2 = true;
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        f2722d = z2;
    }

    public h() {
        Provider providerNewProvider = Conscrypt.newProvider();
        F0.i.d(providerNewProvider, "newProvider()");
        this.f2723c = providerNewProvider;
    }

    @Override // f1.n
    public final void d(SSLSocket sSLSocket, String str, List list) {
        F0.i.e(list, "protocols");
        if (!Conscrypt.isConscrypt(sSLSocket)) {
            super.d(sSLSocket, str, list);
        } else {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) C0028c.i(list).toArray(new String[0]));
        }
    }

    @Override // f1.n
    public final String f(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // f1.n
    public final SSLContext k() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f2723c);
        F0.i.d(sSLContext, "getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // f1.n
    public final SSLSocketFactory l(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sSLContextK = k();
        sSLContextK.init(null, new TrustManager[]{x509TrustManager}, null);
        SSLSocketFactory socketFactory = sSLContextK.getSocketFactory();
        F0.i.d(socketFactory, "newSSLContext().apply {\n…null)\n    }.socketFactory");
        return socketFactory;
    }

    @Override // f1.n
    public final X509TrustManager m() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        F0.i.b(trustManagers);
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                F0.i.c(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
                Conscrypt.setHostnameVerifier(x509TrustManager, g.f2721a);
                return x509TrustManager;
            }
        }
        String string = Arrays.toString(trustManagers);
        F0.i.d(string, "toString(this)");
        throw new IllegalStateException("Unexpected default trust managers: ".concat(string).toString());
    }
}
