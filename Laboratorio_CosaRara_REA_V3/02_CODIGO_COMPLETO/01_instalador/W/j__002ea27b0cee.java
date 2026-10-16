// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class j extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f760b = 1073741824;

    public j(InputStream inputStream) {
        this.f759a = inputStream;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f760b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f759a.close();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        int i2 = this.f759a.read();
        if (i2 == -1) {
            this.f760b = 0;
        }
        return i2;
    }

    @Override // java.io.InputStream
    public final long skip(long j2) {
        return this.f759a.skip(j2);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        int i2 = this.f759a.read(bArr);
        if (i2 == -1) {
            this.f760b = 0;
        }
        return i2;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.f759a.read(bArr, i2, i3);
        if (i4 == -1) {
            this.f760b = 0;
        }
        return i4;
    }
}
