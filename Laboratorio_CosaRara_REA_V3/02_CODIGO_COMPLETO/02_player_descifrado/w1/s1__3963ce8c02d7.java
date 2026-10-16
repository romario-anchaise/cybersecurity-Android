// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class s1 extends ByteArrayOutputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5038c;

    public s1(int i3) {
        super(Math.min(i3, 32768));
        if (i3 > 0) {
            this.f5038c = i3;
        } else {
            o2.i("maxBytes must be positive");
            throw null;
        }
    }

    public final void d(int i3) {
        int i4 = ((ByteArrayOutputStream) this).count;
        int i5 = this.f5038c;
        if (i3 <= i5 - i4) {
            return;
        }
        o2.k(j4.c(i5, "encoded image exceeds ", " bytes"));
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i3, int i4) {
        if (bArr != null && i3 >= 0 && i4 >= 0) {
            if (i3 <= bArr.length - i4) {
                d(i4);
                super.write(bArr, i3, i4);
            }
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i3) {
        d(1);
        super.write(i3);
    }
}
