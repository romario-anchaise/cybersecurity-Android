// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package r2;

import java.util.List;
import javax.net.ssl.SSLSocket;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f3183a = new g();

    @Override // r2.m
    public final boolean a(SSLSocket sSLSocket) {
        return false;
    }

    @Override // r2.m
    public final String b(SSLSocket sSLSocket) {
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null ? true : applicationProtocol.equals("")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // r2.m
    public final boolean c() {
        boolean z2 = q2.d.f3134d;
        return q2.d.f3134d;
    }

    @Override // r2.m
    public final void d(SSLSocket sSLSocket, String str, List list) {
        list.getClass();
        if (a(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            q2.m mVar = q2.m.f3156a;
            parameters.setApplicationProtocols((String[]) q2.c.b(list).toArray(new String[0]));
            bCSSLSocket.setParameters(parameters);
        }
    }
}
