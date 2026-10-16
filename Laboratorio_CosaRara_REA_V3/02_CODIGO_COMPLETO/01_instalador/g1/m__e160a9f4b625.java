// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g1;

import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes.dex */
public final class m implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f2774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f2775b;

    public m(l lVar) {
        this.f2774a = lVar;
    }

    @Override // g1.n
    public final boolean a(SSLSocket sSLSocket) {
        return this.f2774a.a(sSLSocket);
    }

    @Override // g1.n
    public final String b(SSLSocket sSLSocket) {
        n nVarE = e(sSLSocket);
        if (nVarE != null) {
            return nVarE.b(sSLSocket);
        }
        return null;
    }

    @Override // g1.n
    public final boolean c() {
        return true;
    }

    @Override // g1.n
    public final void d(SSLSocket sSLSocket, String str, List list) {
        F0.i.e(list, "protocols");
        n nVarE = e(sSLSocket);
        if (nVarE != null) {
            nVarE.d(sSLSocket, str, list);
        }
    }

    public final synchronized n e(SSLSocket sSLSocket) {
        try {
            if (this.f2775b == null && this.f2774a.a(sSLSocket)) {
                this.f2775b = this.f2774a.b(sSLSocket);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f2775b;
    }
}
