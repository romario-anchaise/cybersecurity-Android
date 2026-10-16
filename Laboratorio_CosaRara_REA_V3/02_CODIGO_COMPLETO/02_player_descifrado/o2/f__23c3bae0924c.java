// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package o2;

import w1.o2;
import w2.h;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2805f;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f2790d) {
            return;
        }
        if (!this.f2805f) {
            d();
        }
        this.f2790d = true;
    }

    @Override // o2.a, w2.x
    public final long f(long j3, h hVar) {
        if (this.f2790d) {
            o2.k("closed");
            return 0L;
        }
        if (this.f2805f) {
            return -1L;
        }
        long jF = super.f(8192L, hVar);
        if (jF != -1) {
            return jF;
        }
        this.f2805f = true;
        d();
        return -1L;
    }
}
