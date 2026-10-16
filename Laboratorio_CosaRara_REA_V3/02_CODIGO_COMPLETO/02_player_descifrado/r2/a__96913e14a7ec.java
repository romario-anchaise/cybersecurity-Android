// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package r2;

import android.net.ssl.SSLSockets;
import java.io.IOException;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements m {
    @Override // r2.m
    public final boolean a(SSLSocket sSLSocket) {
        return SSLSockets.isSupportedSocket(sSLSocket);
    }

    @Override // r2.m
    public final String b(SSLSocket sSLSocket) {
        String applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null ? true : applicationProtocol.equals("")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // r2.m
    public final boolean c() {
        q2.m mVar = q2.m.f3156a;
        return q2.c.r();
    }

    @Override // r2.m
    public final void d(SSLSocket sSLSocket, String str, List list) throws IOException {
        list.getClass();
        try {
            SSLSockets.setUseSessionTickets(sSLSocket, true);
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            q2.m mVar = q2.m.f3156a;
            sSLParameters.setApplicationProtocols((String[]) q2.c.b(list).toArray(new String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalArgumentException e3) {
            throw new IOException("Android internal error", e3);
        }
    }
}
