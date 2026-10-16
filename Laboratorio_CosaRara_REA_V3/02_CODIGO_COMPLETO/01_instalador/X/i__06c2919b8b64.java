// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X;

import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public final class i implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f885a;

    public i(d dVar) {
        this.f885a = dVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f885a.close();
    }
}
