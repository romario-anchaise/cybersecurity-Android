// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: loaded from: classes.dex */
public interface G extends Closeable, Flushable {
    K c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();

    void i(C0193i c0193i, long j2);
}
