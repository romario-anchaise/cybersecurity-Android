// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.io.EOFException;

/* JADX INFO: renamed from: k1.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0190f implements G {
    @Override // k1.G
    public final K c() {
        return K.f3456d;
    }

    @Override // k1.G
    public final void i(C0193i c0193i, long j2) throws EOFException {
        F0.i.e(c0193i, "source");
        c0193i.K(j2);
    }

    @Override // k1.G, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // k1.G, java.io.Flushable
    public final void flush() {
    }
}
