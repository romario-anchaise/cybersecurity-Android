// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g1;

import H.C0028c;
import java.util.List;
import javax.net.ssl.SSLSocket;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* JADX INFO: loaded from: classes.dex */
public final class h implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f2769a = new g();

    @Override // g1.n
    public final boolean a(SSLSocket sSLSocket) {
        return false;
    }

    @Override // g1.n
    public final String b(SSLSocket sSLSocket) {
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null ? true : F0.i.a(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // g1.n
    public final boolean c() {
        boolean z2 = f1.e.f2719d;
        return f1.e.f2719d;
    }

    @Override // g1.n
    public final void d(SSLSocket sSLSocket, String str, List list) {
        F0.i.e(list, "protocols");
        if (a(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            f1.n nVar = f1.n.f2736a;
            parameters.setApplicationProtocols((String[]) C0028c.i(list).toArray(new String[0]));
            bCSSLSocket.setParameters(parameters);
        }
    }
}
