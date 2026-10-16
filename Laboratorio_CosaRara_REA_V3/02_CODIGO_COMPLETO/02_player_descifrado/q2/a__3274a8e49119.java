// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q2;

import android.net.http.X509TrustManagerExtensions;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f3131d = c.r();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f3132c;

    public a() {
        int i3 = 0;
        ArrayList arrayListZ = i1.j.z(c.r() ? new r2.a() : null, new r2.l(r2.f.f3177f), new r2.l(r2.j.f3184a), new r2.l(r2.h.f3183a));
        ArrayList arrayList = new ArrayList();
        int size = arrayListZ.size();
        while (i3 < size) {
            Object obj = arrayListZ.get(i3);
            i3++;
            if (((r2.m) obj).c()) {
                arrayList.add(obj);
            }
        }
        this.f3132c = arrayList;
    }

    @Override // q2.m
    public final m0.a b(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        r2.b bVar = x509TrustManagerExtensions != null ? new r2.b(x509TrustManager, x509TrustManagerExtensions) : null;
        return bVar != null ? bVar : new u2.a(c(x509TrustManager));
    }

    @Override // q2.m
    public final void d(SSLSocket sSLSocket, String str, List list) {
        Object obj;
        list.getClass();
        ArrayList arrayList = this.f3132c;
        int size = arrayList.size();
        int i3 = 0;
        do {
            if (i3 >= size) {
                obj = null;
                break;
            } else {
                obj = arrayList.get(i3);
                i3++;
            }
        } while (!((r2.m) obj).a(sSLSocket));
        r2.m mVar = (r2.m) obj;
        if (mVar != null) {
            mVar.d(sSLSocket, str, list);
        }
    }

    @Override // q2.m
    public final String e(SSLSocket sSLSocket) {
        Object obj;
        ArrayList arrayList = this.f3132c;
        int size = arrayList.size();
        int i3 = 0;
        do {
            if (i3 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i3);
            i3++;
        } while (!((r2.m) obj).a(sSLSocket));
        r2.m mVar = (r2.m) obj;
        if (mVar != null) {
            return mVar.b(sSLSocket);
        }
        return null;
    }

    @Override // q2.m
    public final boolean f(String str) {
        str.getClass();
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }
}
