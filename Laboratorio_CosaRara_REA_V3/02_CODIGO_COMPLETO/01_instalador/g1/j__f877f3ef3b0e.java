// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g1;

import javax.net.ssl.SSLSocket;
import org.conscrypt.Conscrypt;

/* JADX INFO: loaded from: classes.dex */
public final class j implements l {
    @Override // g1.l
    public final boolean a(SSLSocket sSLSocket) {
        boolean z2 = f1.h.f2722d;
        return f1.f.b() && Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // g1.l
    public final n b(SSLSocket sSLSocket) {
        return new k();
    }
}
