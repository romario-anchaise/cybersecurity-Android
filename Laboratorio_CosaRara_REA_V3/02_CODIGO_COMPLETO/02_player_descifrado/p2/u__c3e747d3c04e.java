// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p2;

import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends w2.f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ v f2976m;

    public u(v vVar) {
        this.f2976m = vVar;
    }

    @Override // w2.f
    public final void k() {
        this.f2976m.e(9);
        n nVar = this.f2976m.f2978b;
        synchronized (nVar) {
            long j3 = nVar.f2937p;
            long j4 = nVar.f2936o;
            if (j3 < j4) {
                return;
            }
            nVar.f2936o = j4 + 1;
            nVar.f2938q = System.nanoTime() + ((long) 1000000000);
            nVar.f2932j.c(new l2.b(nVar.f2927e + " ping", nVar, 2), 0L);
        }
    }

    public final void l() {
        if (j()) {
            throw new SocketTimeoutException("timeout");
        }
    }
}
