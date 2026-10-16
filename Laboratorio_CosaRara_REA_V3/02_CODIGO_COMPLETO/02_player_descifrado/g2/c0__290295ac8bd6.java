// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 extends OutputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d0 f1556c;

    public c0(d0 d0Var) {
        this.f1556c = d0Var;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f1556c.close();
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i3, int i4) throws IOException {
        if (bArr == null) {
            throw new NullPointerException("source");
        }
        if (i3 < 0 || i4 < 0 || i4 > bArr.length - i3) {
            throw new IndexOutOfBoundsException();
        }
        synchronized (this.f1556c.f1575h) {
            int i5 = 0;
            while (i5 < i4) {
                synchronized (this.f1556c.f1574g) {
                    d0 d0Var = this.f1556c;
                    if (d0Var.f1582p || d0Var.f1581o) {
                        IOException iOException = d0Var.f1583q;
                        if (iOException != null) {
                            throw iOException;
                        }
                        throw new EOFException("logical stream closed");
                    }
                    throw th;
                }
                int iMin = Math.min(33554432, i4 - i5);
                byte[] bArr2 = new byte[iMin];
                System.arraycopy(bArr, i3 + i5, bArr2, 0, iMin);
                try {
                    d0 d0Var2 = this.f1556c;
                    d0Var2.f1570c.c(d0Var2.f1571d, d0Var2.f1573f, bArr2);
                    i5 += iMin;
                } catch (IOException e3) {
                    this.f1556c.d(e3, true);
                    throw e3;
                }
            }
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i3) throws IOException {
        write(new byte[]{(byte) i3}, 0, 1);
    }
}
