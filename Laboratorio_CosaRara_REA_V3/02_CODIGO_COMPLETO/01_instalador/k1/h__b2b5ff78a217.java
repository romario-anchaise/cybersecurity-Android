// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.io.OutputStream;

/* JADX INFO: renamed from: k1.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0192h extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0193i f3480a;

    public C0192h(C0193i c0193i) {
        this.f3480a = c0193i;
    }

    public final String toString() {
        return this.f3480a + ".outputStream()";
    }

    @Override // java.io.OutputStream
    public final void write(int i2) {
        this.f3480a.Q(i2);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i2, int i3) {
        F0.i.e(bArr, "data");
        this.f3480a.O(bArr, i2, i3);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
    }
}
