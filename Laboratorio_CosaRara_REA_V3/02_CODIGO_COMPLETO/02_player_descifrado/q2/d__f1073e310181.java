// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q2;

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

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f3134d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Provider f3135c = new BouncyCastleJsseProvider();

    static {
        boolean z2 = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, c.class.getClassLoader());
            z2 = true;
        } catch (ClassNotFoundException unused) {
        }
        f3134d = z2;
    }

    @Override // q2.m
    public final void d(SSLSocket sSLSocket, String str, List list) {
        list.getClass();
    }

    @Override // q2.m
    public final String e(SSLSocket sSLSocket) {
        return null;
    }

    @Override // q2.m
    public final SSLContext h() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f3135c);
        sSLContext.getClass();
        return sSLContext;
    }

    @Override // q2.m
    public final X509TrustManager j() throws NoSuchAlgorithmException, KeyStoreException, NoSuchProviderException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        trustManagers.getClass();
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                trustManager.getClass();
                return (X509TrustManager) trustManager;
            }
        }
        String string = Arrays.toString(trustManagers);
        string.getClass();
        b2.a.b("Unexpected default trust managers: ".concat(string));
        return null;
    }
}
