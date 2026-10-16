// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

/* JADX INFO: loaded from: classes.dex */
public abstract class p implements G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final G f3498a;

    public p(G g) {
        F0.i.e(g, "delegate");
        this.f3498a = g;
    }

    @Override // k1.G
    public final K c() {
        return this.f3498a.c();
    }

    @Override // k1.G, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3498a.close();
    }

    @Override // k1.G, java.io.Flushable
    public void flush() {
        this.f3498a.flush();
    }

    @Override // k1.G
    public void i(C0193i c0193i, long j2) {
        F0.i.e(c0193i, "source");
        this.f3498a.i(c0193i, j2);
    }

    public final String toString() {
        return getClass().getSimpleName() + '(' + this.f3498a + ')';
    }
}
