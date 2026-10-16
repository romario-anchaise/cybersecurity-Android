// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g1;

import H.C0028c;
import java.util.List;
import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* JADX INFO: loaded from: classes.dex */
public final class k implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f2773a = new j();

    @Override // g1.n
    public final boolean a(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // g1.n
    public final String b(SSLSocket sSLSocket) {
        if (a(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // g1.n
    public final boolean c() {
        boolean z2 = f1.h.f2722d;
        return f1.h.f2722d;
    }

    @Override // g1.n
    public final void d(SSLSocket sSLSocket, String str, List list) {
        F0.i.e(list, "protocols");
        if (a(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            f1.n nVar = f1.n.f2736a;
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) C0028c.i(list).toArray(new String[0]));
        }
    }
}
