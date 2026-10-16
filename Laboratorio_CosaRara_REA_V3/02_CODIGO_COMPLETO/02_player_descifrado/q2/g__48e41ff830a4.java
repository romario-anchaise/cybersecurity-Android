// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q2;

import i2.v;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f3137d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Provider f3138c;

    static {
        boolean z2 = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, e.class.getClassLoader());
            if (Conscrypt.isAvailable() && e.a()) {
                z2 = true;
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        f3137d = z2;
    }

    public g() {
        Provider providerNewProvider = Conscrypt.newProvider();
        providerNewProvider.getClass();
        this.f3138c = providerNewProvider;
    }

    @Override // q2.m
    public final void d(SSLSocket sSLSocket, String str, List list) {
        list.getClass();
        if (Conscrypt.isConscrypt(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((v) obj) != v.f2261d) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(i1.k.A(arrayList));
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj2 = arrayList.get(i3);
                i3++;
                arrayList2.add(((v) obj2).f2268c);
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) arrayList2.toArray(new String[0]));
        }
    }

    @Override // q2.m
    public final String e(SSLSocket sSLSocket) {
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // q2.m
    public final SSLContext h() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f3138c);
        sSLContext.getClass();
        return sSLContext;
    }

    @Override // q2.m
    public final SSLSocketFactory i(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sSLContextH = h();
        sSLContextH.init(null, new TrustManager[]{x509TrustManager}, null);
        SSLSocketFactory socketFactory = sSLContextH.getSocketFactory();
        socketFactory.getClass();
        return socketFactory;
    }

    @Override // q2.m
    public final X509TrustManager j() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        trustManagers.getClass();
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                trustManager.getClass();
                X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
                Conscrypt.setHostnameVerifier(x509TrustManager, f.f3136a);
                return x509TrustManager;
            }
        }
        String string = Arrays.toString(trustManagers);
        string.getClass();
        b2.a.b("Unexpected default trust managers: ".concat(string));
        return null;
    }
}
