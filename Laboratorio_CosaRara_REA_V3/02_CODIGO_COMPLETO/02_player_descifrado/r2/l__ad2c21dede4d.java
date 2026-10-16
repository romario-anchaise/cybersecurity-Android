// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package r2;

import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f3185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f3186b;

    public l(k kVar) {
        this.f3185a = kVar;
    }

    @Override // r2.m
    public final boolean a(SSLSocket sSLSocket) {
        return this.f3185a.a(sSLSocket);
    }

    @Override // r2.m
    public final String b(SSLSocket sSLSocket) {
        m mVarE = e(sSLSocket);
        if (mVarE != null) {
            return mVarE.b(sSLSocket);
        }
        return null;
    }

    @Override // r2.m
    public final boolean c() {
        return true;
    }

    @Override // r2.m
    public final void d(SSLSocket sSLSocket, String str, List list) {
        list.getClass();
        m mVarE = e(sSLSocket);
        if (mVarE != null) {
            mVarE.d(sSLSocket, str, list);
        }
    }

    public final synchronized m e(SSLSocket sSLSocket) {
        try {
            if (this.f3186b == null && this.f3185a.a(sSLSocket)) {
                this.f3186b = this.f3185a.b(sSLSocket);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f3186b;
    }
}
