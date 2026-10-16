// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package r2;

import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements k {
    @Override // r2.k
    public final boolean a(SSLSocket sSLSocket) {
        return q2.g.f3137d && Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // r2.k
    public final m b(SSLSocket sSLSocket) {
        return new j();
    }
}
