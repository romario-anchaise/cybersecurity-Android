// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import java.io.Closeable;
import k1.InterfaceC0195k;

/* JADX INFO: loaded from: classes.dex */
public abstract class G implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public E f925a;

    public abstract long a();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Y0.b.d(j());
    }

    public abstract s f();

    public abstract InterfaceC0195k j();
}
