// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

import java.net.SocketTimeoutException;
import k1.C0189e;

/* JADX INFO: loaded from: classes.dex */
public final class v extends C0189e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ w f2371m;

    public v(w wVar) {
        this.f2371m = wVar;
    }

    @Override // k1.C0189e
    public final void j() {
        this.f2371m.e(9);
        o oVar = this.f2371m.f2373b;
        synchronized (oVar) {
            long j2 = oVar.f2332n;
            long j3 = oVar.f2331m;
            if (j2 < j3) {
                return;
            }
            oVar.f2331m = j3 + 1;
            oVar.f2333o = System.nanoTime() + ((long) 1000000000);
            oVar.f2326h.c(new a1.b(oVar.f2322c + " ping", oVar, 2), 0L);
        }
    }

    public final void k() {
        if (i()) {
            throw new SocketTimeoutException("timeout");
        }
    }
}
