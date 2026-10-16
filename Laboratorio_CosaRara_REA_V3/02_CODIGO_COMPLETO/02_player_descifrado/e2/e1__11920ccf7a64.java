// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e1 extends InputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InputStream f784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f785e;

    public e1(int i3, InputStream inputStream) {
        this.f783c = 0;
        inputStream.getClass();
        this.f785e = i3;
        this.f784d = inputStream;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i3, int i4) throws IOException {
        int i5;
        switch (this.f783c) {
            case 0:
                bArr.getClass();
                if (i4 == 0) {
                    return 0;
                }
                int i6 = this.f785e;
                InputStream inputStream = this.f784d;
                if (i6 < 0) {
                    return inputStream.read(bArr, i3, i4);
                }
                bArr[i3] = (byte) i6;
                this.f785e = -1;
                if (i4 != 1 && (i5 = inputStream.read(bArr, i3 + 1, i4 - 1)) >= 0) {
                    return 1 + i5;
                }
                return 1;
            default:
                int i7 = this.f785e;
                if (i7 <= 0) {
                    return -1;
                }
                int i8 = this.f784d.read(bArr, i3, Math.min(i4, i7));
                if (i8 > 0) {
                    this.f785e -= i8;
                }
                return i8;
        }
    }

    public e1(InputStream inputStream) {
        this.f783c = 1;
        this.f784d = inputStream;
        this.f785e = 65536;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        switch (this.f783c) {
            case 0:
                int i3 = this.f785e;
                if (i3 >= 0) {
                    this.f785e = -1;
                    return i3;
                }
                return this.f784d.read();
            default:
                if (this.f785e <= 0) {
                    return -1;
                }
                int i4 = this.f784d.read();
                if (i4 >= 0) {
                    this.f785e--;
                }
                return i4;
        }
    }
}
