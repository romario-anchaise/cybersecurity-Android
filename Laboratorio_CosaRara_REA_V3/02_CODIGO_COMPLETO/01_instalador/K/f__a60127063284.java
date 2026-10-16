// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package K;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class f extends b {
    public f(byte[] bArr) {
        super(bArr);
        this.f288a.mark(Integer.MAX_VALUE);
    }

    public final void f(long j2) throws IOException {
        int i2 = this.f289b;
        if (i2 > j2) {
            this.f289b = 0;
            this.f288a.reset();
        } else {
            j2 -= (long) i2;
        }
        a((int) j2);
    }

    public f(InputStream inputStream) {
        super(inputStream);
        if (inputStream.markSupported()) {
            this.f288a.mark(Integer.MAX_VALUE);
            return;
        }
        throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
    }
}
