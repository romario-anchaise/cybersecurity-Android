// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class q implements I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f3499a;

    public q(I i2) {
        F0.i.e(i2, "delegate");
        this.f3499a = i2;
    }

    @Override // k1.I
    public final K c() {
        return this.f3499a.c();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3499a.close();
    }

    @Override // k1.I
    public long m(C0193i c0193i, long j2) {
        F0.i.e(c0193i, "sink");
        return this.f3499a.m(c0193i, j2);
    }

    public final String toString() {
        return getClass().getSimpleName() + '(' + this.f3499a + ')';
    }
}
