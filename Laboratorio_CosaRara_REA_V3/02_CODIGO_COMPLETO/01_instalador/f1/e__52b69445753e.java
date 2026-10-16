// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f1;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;

/* JADX INFO: loaded from: classes.dex */
public final class e extends n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f2719d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Provider f2720c = new BouncyCastleJsseProvider();

    static {
        boolean z2 = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, d.class.getClassLoader());
            z2 = true;
        } catch (ClassNotFoundException unused) {
        }
        f2719d = z2;
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
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f2720c);
        F0.i.d(sSLContext, "getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // f1.n
    public final X509TrustManager m() throws NoSuchAlgorithmException, KeyStoreException, NoSuchProviderException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
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
