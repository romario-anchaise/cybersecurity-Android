// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package r2;

import java.util.List;
import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f3184a = new i();

    @Override // r2.m
    public final boolean a(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // r2.m
    public final String b(SSLSocket sSLSocket) {
        if (a(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // r2.m
    public final boolean c() {
        boolean z2 = q2.g.f3137d;
        return q2.g.f3137d;
    }

    @Override // r2.m
    public final void d(SSLSocket sSLSocket, String str, List list) {
        list.getClass();
        if (a(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            q2.m mVar = q2.m.f3156a;
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) q2.c.b(list).toArray(new String[0]));
        }
    }
}
