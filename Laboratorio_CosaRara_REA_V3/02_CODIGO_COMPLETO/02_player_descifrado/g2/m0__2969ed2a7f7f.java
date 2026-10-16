// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import w1.o2;
import w1.pb;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 extends OutputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final x1.e f1684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final pb f1685e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f1686f = new AtomicBoolean();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f1687g = new byte[64];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1688h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1689i;

    public m0(int i3, x1.e eVar, pb pbVar) {
        this.f1683c = i3;
        this.f1684d = eVar;
        this.f1685e = pbVar;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f1686f.set(true);
        synchronized (this) {
            this.f1688h = 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0094  */
    public final boolean d() throws IOException {
        int i3;
        char c3;
        char c4;
        boolean z2;
        int iK;
        u0 u0Var;
        char c5;
        boolean z3;
        boolean z4;
        boolean z5 = this.f1689i;
        byte b3 = 65;
        byte b4 = 67;
        pb pbVar = this.f1685e;
        int i4 = this.f1683c;
        if (z5) {
            i3 = 0;
            c3 = 3;
            c4 = 2;
            z2 = false;
        } else {
            int i5 = i4 == 1 ? 16 : 12;
            c3 = 3;
            if (this.f1688h < i5) {
                return false;
            }
            byte[] bArr = new byte[i5];
            c4 = 2;
            System.arraycopy(this.f1687g, 0, bArr, 0, i5);
            int i6 = this.f1688h - i5;
            if (i6 > 0) {
                byte[] bArr2 = this.f1687g;
                System.arraycopy(bArr2, i5, bArr2, 0, i6);
            }
            this.f1688h = i6;
            if (i4 == 1) {
                if (bArr[0] == 77) {
                    i3 = 0;
                    if (bArr[1] == 73 && bArr[2] == 82 && bArr[3] == 49) {
                        byte b5 = bArr[4];
                        if (b5 == 72) {
                            c5 = 7;
                            if (bArr[5] == 50 && bArr[6] == 54 && bArr[7] == 52) {
                                z3 = true;
                            }
                            if (b5 != 74 && bArr[5] == 80 && bArr[6] == 69 && bArr[c5] == 71) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (z3 && !z4) {
                                o2.l("invalid MIR1 codec");
                                return false;
                            }
                            if (q2.k.k(8, bArr) > 0 || q2.k.k(12, bArr) <= 0) {
                                o2.l("invalid MIR1 dimensions");
                                return false;
                            }
                        } else {
                            c5 = 7;
                        }
                        z3 = false;
                        if (b5 != 74) {
                            z4 = false;
                        } else {
                            z4 = false;
                        }
                        if (z3) {
                        }
                        if (q2.k.k(8, bArr) > 0) {
                        }
                        o2.l("invalid MIR1 dimensions");
                        return false;
                    }
                }
                o2.l("invalid MIR1 header");
                return false;
            }
            i3 = 0;
            if (bArr[0] != 67 || bArr[1] != 65 || bArr[2] != 77 || bArr[3] != 49 || q2.k.k(4, bArr) <= 0 || q2.k.k(8, bArr) <= 0) {
                o2.l("invalid CAM1 header");
                return false;
            }
            pbVar.a(i4 == 1 ? u0.f1748g : u0.f1752k, i4 == 1 ? "screen:h264" : "camera:frame", bArr);
            this.f1689i = true;
            z2 = true;
        }
        while (this.f1688h >= 16) {
            byte[] bArr3 = this.f1687g;
            if (i4 == 1) {
                iK = q2.k.k(i3, bArr3);
            } else {
                if (bArr3[i3] != b4 || bArr3[1] != b3 || bArr3[c4] != 77 || bArr3[c3] != 49) {
                    o2.l("invalid CAM1 frame magic");
                    return false;
                }
                iK = q2.k.k(12, bArr3);
            }
            if (iK < 0 || iK > 33554416) {
                o2.l("media frame exceeds 32 MiB");
                return false;
            }
            int i7 = iK + 16;
            if (this.f1688h < i7) {
                break;
            }
            byte[] bArr4 = new byte[i7];
            i3 = 0;
            System.arraycopy(this.f1687g, 0, bArr4, 0, i7);
            int i8 = this.f1688h - i7;
            if (i8 > 0) {
                byte[] bArr5 = this.f1687g;
                System.arraycopy(bArr5, i7, bArr5, 0, i8);
            }
            this.f1688h = i8;
            if (i4 == 1) {
                int iK2 = q2.k.k(12, bArr4);
                if ((iK2 & 4) == 0) {
                    if ((iK2 & 2) != 0) {
                        u0Var = u0.f1749h;
                    } else {
                        u0Var = (iK2 & 1) != 0 ? u0.f1750i : u0.f1751j;
                    }
                    pbVar.a(u0Var, "screen:h264", bArr4);
                }
                b3 = 65;
                b4 = 67;
            } else {
                pbVar.a(u0.f1753l, "camera:frame", bArr4);
            }
            z2 = true;
            b3 = 65;
            b4 = 67;
        }
        return z2;
    }

    @Override // java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i3, int i4) {
        try {
            if (bArr == null) {
                throw new NullPointerException("source");
            }
            if (i3 < 0 || i4 < 0 || i4 > bArr.length - i3) {
                throw new IndexOutOfBoundsException();
            }
            if (i4 == 0) {
                return;
            }
            if (this.f1686f.get() || !this.f1684d.getAsBoolean()) {
                throw new IOException("Socket.IO media sink retired");
            }
            int i5 = i4 + i3;
            while (i3 < i5) {
                int i6 = 33554432 - this.f1688h;
                if (i6 != 0) {
                    int iMin = Math.min(i6, i5 - i3);
                    int i7 = this.f1688h + iMin;
                    byte[] bArr2 = this.f1687g;
                    if (i7 > bArr2.length) {
                        int length = bArr2.length;
                        while (length < i7 && length < 33554432) {
                            length = Math.min(33554432, Math.max(length * 2, i7));
                        }
                        byte[] bArr3 = new byte[length];
                        System.arraycopy(this.f1687g, 0, bArr3, 0, this.f1688h);
                        this.f1687g = bArr3;
                    }
                    System.arraycopy(bArr, i3, this.f1687g, this.f1688h, iMin);
                    this.f1688h += iMin;
                    i3 += iMin;
                    d();
                } else if (!d()) {
                    throw new IOException("media frame exceeds 32 MiB");
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i3) {
        write(new byte[]{(byte) i3}, 0, 1);
    }
}
