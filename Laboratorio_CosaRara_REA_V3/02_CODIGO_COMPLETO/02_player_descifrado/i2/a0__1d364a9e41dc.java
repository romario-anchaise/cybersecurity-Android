// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i2;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a0 implements Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        j2.b.d(y());
    }

    public abstract long d();

    public abstract s w();

    public abstract w2.j y();
}
