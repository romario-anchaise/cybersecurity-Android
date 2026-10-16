// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends InputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d0 f1544c;

    public b0(d0 d0Var) {
        this.f1544c = d0Var;
    }

    @Override // java.io.InputStream
    public final int available() {
        int length;
        synchronized (this.f1544c.f1574g) {
            try {
                d0 d0Var = this.f1544c;
                byte[] bArr = d0Var.f1579l;
                length = bArr != null ? bArr.length - d0Var.f1580m : 0;
                Iterator it = d0Var.f1576i.iterator();
                while (it.hasNext()) {
                    length += ((byte[]) it.next()).length;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return length;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f1544c.close();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i3, int i4) throws IOException {
        int i5;
        if (bArr == null) {
            throw new NullPointerException("target");
        }
        if (i3 < 0 || i4 < 0 || i4 > bArr.length - i3) {
            throw new IndexOutOfBoundsException();
        }
        if (i4 == 0) {
            return 0;
        }
        synchronized (this.f1544c.f1574g) {
            while (true) {
                try {
                    d0 d0Var = this.f1544c;
                    byte[] bArr2 = d0Var.f1579l;
                    if (bArr2 != null && (i5 = d0Var.f1580m) < bArr2.length) {
                        int iMin = Math.min(i4, bArr2.length - i5);
                        d0 d0Var2 = this.f1544c;
                        System.arraycopy(d0Var2.f1579l, d0Var2.f1580m, bArr, i3, iMin);
                        d0 d0Var3 = this.f1544c;
                        int i6 = d0Var3.f1580m + iMin;
                        d0Var3.f1580m = i6;
                        byte[] bArr3 = d0Var3.f1579l;
                        if (i6 == bArr3.length && bArr3 != null) {
                            int length = bArr3.length;
                            d0Var3.f1579l = null;
                            d0Var3.f1580m = 0;
                            d0Var3.n -= length;
                            b1 b1Var = d0Var3.f1570c;
                            if (length > 0) {
                                b1Var.f1547c.addAndGet(-length);
                            } else {
                                b1Var.getClass();
                            }
                        }
                        return iMin;
                    }
                    boolean zIsEmpty = d0Var.f1576i.isEmpty();
                    d0 d0Var4 = this.f1544c;
                    if (!zIsEmpty) {
                        d0Var4.f1579l = (byte[]) d0Var4.f1576i.removeFirst();
                        d0 d0Var5 = this.f1544c;
                        d0Var5.f1580m = 0;
                        byte[] bArr4 = d0Var5.f1579l;
                        if (bArr4.length == 0 && bArr4 != null) {
                            int length2 = bArr4.length;
                            d0Var5.f1579l = null;
                            d0Var5.f1580m = 0;
                            d0Var5.n -= length2;
                            b1 b1Var2 = d0Var5.f1570c;
                            if (length2 > 0) {
                                b1Var2.f1547c.addAndGet(-length2);
                            } else {
                                b1Var2.getClass();
                            }
                        }
                    } else {
                        if (d0Var4.f1582p) {
                            IOException iOException = d0Var4.f1583q;
                            if (iOException == null) {
                                throw new IOException("logical stream closed");
                            }
                            throw iOException;
                        }
                        if (d0Var4.f1581o) {
                            d0Var4.f1570c.j(d0Var4, d0Var4.f1571d);
                            IOException iOException2 = this.f1544c.f1583q;
                            if (iOException2 == null) {
                                return -1;
                            }
                            throw iOException2;
                        }
                        try {
                            d0Var4.f1574g.wait();
                        } catch (InterruptedException e3) {
                            Thread.currentThread().interrupt();
                            throw new IOException("interrupted while reading logical stream", e3);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] bArr = new byte[1];
        if (read(bArr, 0, 1) < 0) {
            return -1;
        }
        return bArr[0] & 255;
    }
}
