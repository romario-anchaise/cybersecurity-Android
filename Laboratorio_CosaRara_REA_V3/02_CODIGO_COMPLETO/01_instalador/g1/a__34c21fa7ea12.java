// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g1;

import H.C0028c;
import android.net.ssl.SSLSockets;
import android.os.Build;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public final class a implements n {
    @Override // g1.n
    public final boolean a(SSLSocket sSLSocket) {
        return SSLSockets.isSupportedSocket(sSLSocket);
    }

    @Override // g1.n
    public final String b(SSLSocket sSLSocket) {
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null ? true : applicationProtocol.equals("")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // g1.n
    public final boolean c() {
        f1.n nVar = f1.n.f2736a;
        return C0028c.v() && Build.VERSION.SDK_INT >= 29;
    }

    @Override // g1.n
    public final void d(SSLSocket sSLSocket, String str, List list) throws IOException {
        F0.i.e(list, "protocols");
        try {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            f1.n nVar = f1.n.f2736a;
            sSLParameters.setApplicationProtocols((String[]) C0028c.i(list).toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e2) {
            throw new IOException("Android internal error", e2);
        }
    }
}
