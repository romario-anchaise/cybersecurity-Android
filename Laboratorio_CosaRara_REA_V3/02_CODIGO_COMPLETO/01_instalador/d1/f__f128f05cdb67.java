// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d1;

import F0.h;
import F0.i;
import k1.C0193i;

/* JADX INFO: loaded from: classes.dex */
public final class f extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2224d;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f2211b) {
            return;
        }
        if (!this.f2224d) {
            a();
        }
        this.f2211b = true;
    }

    @Override // d1.a, k1.I
    public final long m(C0193i c0193i, long j2) {
        i.e(c0193i, "sink");
        if (j2 < 0) {
            throw new IllegalArgumentException(h.d("byteCount < 0: ", j2).toString());
        }
        if (this.f2211b) {
            throw new IllegalStateException("closed");
        }
        if (this.f2224d) {
            return -1L;
        }
        long jM = super.m(c0193i, j2);
        if (jM != -1) {
            return jM;
        }
        this.f2224d = true;
        a();
        return -1L;
    }
}
