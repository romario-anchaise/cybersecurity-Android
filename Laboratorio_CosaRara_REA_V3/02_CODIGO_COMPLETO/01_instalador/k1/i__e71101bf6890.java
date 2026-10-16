// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: k1.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0193i implements InterfaceC0195k, InterfaceC0194j, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public D f3481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3482b;

    public final int A(byte[] bArr, int i2, int i3) {
        F0.i.e(bArr, "sink");
        f1.d.g(bArr.length, i2, i3);
        D d2 = this.f3481a;
        if (d2 == null) {
            return -1;
        }
        int iMin = Math.min(i3, d2.f3446c - d2.f3445b);
        int i4 = d2.f3445b;
        p036u0.e.r(i2, i4, i4 + iMin, d2.f3444a, bArr);
        int i5 = d2.f3445b + iMin;
        d2.f3445b = i5;
        this.f3482b -= (long) iMin;
        if (i5 == d2.f3446c) {
            this.f3481a = d2.a();
            E.a(d2);
        }
        return iMin;
    }

    public final byte B() throws EOFException {
        if (this.f3482b == 0) {
            throw new EOFException();
        }
        D d2 = this.f3481a;
        F0.i.b(d2);
        int i2 = d2.f3445b;
        int i3 = d2.f3446c;
        int i4 = i2 + 1;
        byte b2 = d2.f3444a[i2];
        this.f3482b--;
        if (i4 == i3) {
            this.f3481a = d2.a();
            E.a(d2);
        } else {
            d2.f3445b = i4;
        }
        return b2;
    }

    public final byte[] C(long j2) throws EOFException {
        if (j2 < 0 || j2 > 2147483647L) {
            throw new IllegalArgumentException(F0.h.d("byteCount: ", j2).toString());
        }
        if (this.f3482b < j2) {
            throw new EOFException();
        }
        int i2 = (int) j2;
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int iA = A(bArr, i3, i2 - i3);
            if (iA == -1) {
                throw new EOFException();
            }
            i3 += iA;
        }
        return bArr;
    }

    public final C0196l D(long j2) throws EOFException {
        if (j2 < 0 || j2 > 2147483647L) {
            throw new IllegalArgumentException(F0.h.d("byteCount: ", j2).toString());
        }
        if (this.f3482b < j2) {
            throw new EOFException();
        }
        if (j2 < 4096) {
            return new C0196l(C(j2));
        }
        C0196l c0196lL = L((int) j2);
        K(j2);
        return c0196lL;
    }

    public final long E() throws EOFException {
        int i2;
        if (this.f3482b == 0) {
            throw new EOFException();
        }
        int i3 = 0;
        boolean z2 = false;
        long j2 = 0;
        do {
            D d2 = this.f3481a;
            F0.i.b(d2);
            int i4 = d2.f3445b;
            int i5 = d2.f3446c;
            while (i4 < i5) {
                byte b2 = d2.f3444a[i4];
                if (b2 >= 48 && b2 <= 57) {
                    i2 = b2 - 48;
                } else if (b2 >= 97 && b2 <= 102) {
                    i2 = b2 - 87;
                } else {
                    if (b2 < 65 || b2 > 70) {
                        if (i3 != 0) {
                            z2 = true;
                            break;
                        }
                        char[] cArr = l1.b.f3535a;
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(new String(new char[]{cArr[(b2 >> 4) & 15], cArr[b2 & 15]})));
                    }
                    i2 = b2 - 55;
                }
                if ((j2 & (-1152921504606846976L)) != 0) {
                    C0193i c0193i = new C0193i();
                    c0193i.S(j2);
                    c0193i.Q(b2);
                    throw new NumberFormatException("Number too large: ".concat(c0193i.J()));
                }
                j2 = (j2 << 4) | ((long) i2);
                i4++;
                i3++;
            }
            if (i4 == i5) {
                this.f3481a = d2.a();
                E.a(d2);
            } else {
                d2.f3445b = i4;
            }
            if (z2) {
                break;
            }
        } while (this.f3481a != null);
        this.f3482b -= (long) i3;
        return j2;
    }

    public final int F() throws EOFException {
        if (this.f3482b < 4) {
            throw new EOFException();
        }
        D d2 = this.f3481a;
        F0.i.b(d2);
        int i2 = d2.f3445b;
        int i3 = d2.f3446c;
        if (i3 - i2 < 4) {
            return ((B() & 255) << 24) | ((B() & 255) << 16) | ((B() & 255) << 8) | (B() & 255);
        }
        byte[] bArr = d2.f3444a;
        int i4 = i2 + 3;
        int i5 = ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 2] & 255) << 8);
        int i6 = i2 + 4;
        int i7 = i5 | (bArr[i4] & 255);
        this.f3482b -= 4;
        if (i6 == i3) {
            this.f3481a = d2.a();
            E.a(d2);
        } else {
            d2.f3445b = i6;
        }
        return i7;
    }

    public final short G() throws EOFException {
        if (this.f3482b < 2) {
            throw new EOFException();
        }
        D d2 = this.f3481a;
        F0.i.b(d2);
        int i2 = d2.f3445b;
        int i3 = d2.f3446c;
        if (i3 - i2 < 2) {
            return (short) (((B() & 255) << 8) | (B() & 255));
        }
        int i4 = i2 + 1;
        byte[] bArr = d2.f3444a;
        int i5 = (bArr[i2] & 255) << 8;
        int i6 = i2 + 2;
        int i7 = (bArr[i4] & 255) | i5;
        this.f3482b -= 2;
        if (i6 == i3) {
            this.f3481a = d2.a();
            E.a(d2);
        } else {
            d2.f3445b = i6;
        }
        return (short) i7;
    }

    public final short H() throws EOFException {
        short sG = G();
        return (short) (((sG & 255) << 8) | ((65280 & sG) >>> 8));
    }

    public final String I(long j2, Charset charset) throws EOFException {
        F0.i.e(charset, "charset");
        if (j2 < 0 || j2 > 2147483647L) {
            throw new IllegalArgumentException(F0.h.d("byteCount: ", j2).toString());
        }
        if (this.f3482b < j2) {
            throw new EOFException();
        }
        if (j2 == 0) {
            return "";
        }
        D d2 = this.f3481a;
        F0.i.b(d2);
        int i2 = d2.f3445b;
        if (((long) i2) + j2 > d2.f3446c) {
            return new String(C(j2), charset);
        }
        int i3 = (int) j2;
        String str = new String(d2.f3444a, i2, i3, charset);
        int i4 = d2.f3445b + i3;
        d2.f3445b = i4;
        this.f3482b -= j2;
        if (i4 == d2.f3446c) {
            this.f3481a = d2.a();
            E.a(d2);
        }
        return str;
    }

    public final String J() {
        return I(this.f3482b, M0.a.f360a);
    }

    public final void K(long j2) throws EOFException {
        while (j2 > 0) {
            D d2 = this.f3481a;
            if (d2 == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j2, d2.f3446c - d2.f3445b);
            long j3 = iMin;
            this.f3482b -= j3;
            j2 -= j3;
            int i2 = d2.f3445b + iMin;
            d2.f3445b = i2;
            if (i2 == d2.f3446c) {
                this.f3481a = d2.a();
                E.a(d2);
            }
        }
    }

    public final C0196l L(int i2) {
        if (i2 == 0) {
            return C0196l.f3483d;
        }
        f1.d.g(this.f3482b, 0L, i2);
        D d2 = this.f3481a;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            F0.i.b(d2);
            int i6 = d2.f3446c;
            int i7 = d2.f3445b;
            if (i6 == i7) {
                throw new AssertionError("s.limit == s.pos");
            }
            i4 += i6 - i7;
            i5++;
            d2 = d2.f3449f;
        }
        byte[][] bArr = new byte[i5][];
        int[] iArr = new int[i5 * 2];
        D d3 = this.f3481a;
        int i8 = 0;
        while (i3 < i2) {
            F0.i.b(d3);
            bArr[i8] = d3.f3444a;
            i3 += d3.f3446c - d3.f3445b;
            iArr[i8] = Math.min(i3, i2);
            iArr[i8 + i5] = d3.f3445b;
            d3.f3447d = true;
            i8++;
            d3 = d3.f3449f;
        }
        return new F(bArr, iArr);
    }

    public final D M(int i2) {
        if (i2 < 1 || i2 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        D d2 = this.f3481a;
        if (d2 == null) {
            D dB = E.b();
            this.f3481a = dB;
            dB.g = dB;
            dB.f3449f = dB;
            return dB;
        }
        D d3 = d2.g;
        F0.i.b(d3);
        if (d3.f3446c + i2 <= 8192 && d3.f3448e) {
            return d3;
        }
        D dB2 = E.b();
        d3.b(dB2);
        return dB2;
    }

    public final void N(C0196l c0196l) {
        F0.i.e(c0196l, "byteString");
        c0196l.q(this, c0196l.c());
    }

    public final void O(byte[] bArr, int i2, int i3) {
        F0.i.e(bArr, "source");
        long j2 = i3;
        f1.d.g(bArr.length, i2, j2);
        int i4 = i3 + i2;
        while (i2 < i4) {
            D dM = M(1);
            int iMin = Math.min(i4 - i2, 8192 - dM.f3446c);
            int i5 = i2 + iMin;
            p036u0.e.r(dM.f3446c, i2, i5, bArr, dM.f3444a);
            dM.f3446c += iMin;
            i2 = i5;
        }
        this.f3482b += j2;
    }

    public final void P(I i2) {
        F0.i.e(i2, "source");
        while (i2.m(this, 8192L) != -1) {
        }
    }

    public final void Q(int i2) {
        D dM = M(1);
        int i3 = dM.f3446c;
        dM.f3446c = i3 + 1;
        dM.f3444a[i3] = (byte) i2;
        this.f3482b++;
    }

    public final void R(long j2) {
        boolean z2;
        byte[] bArr;
        if (j2 == 0) {
            Q(48);
            return;
        }
        int i2 = 1;
        if (j2 < 0) {
            j2 = -j2;
            if (j2 < 0) {
                U("-9223372036854775808");
                return;
            }
            z2 = true;
        } else {
            z2 = false;
        }
        if (j2 < 100000000) {
            if (j2 < 10000) {
                if (j2 >= 100) {
                    i2 = j2 < 1000 ? 3 : 4;
                } else if (j2 >= 10) {
                    i2 = 2;
                }
            } else if (j2 < 1000000) {
                i2 = j2 < 100000 ? 5 : 6;
            } else {
                i2 = j2 < 10000000 ? 7 : 8;
            }
        } else if (j2 < 1000000000000L) {
            if (j2 < 10000000000L) {
                i2 = j2 < 1000000000 ? 9 : 10;
            } else {
                i2 = j2 < 100000000000L ? 11 : 12;
            }
        } else if (j2 < 1000000000000000L) {
            if (j2 < 10000000000000L) {
                i2 = 13;
            } else {
                i2 = j2 < 100000000000000L ? 14 : 15;
            }
        } else if (j2 < 100000000000000000L) {
            i2 = j2 < 10000000000000000L ? 16 : 17;
        } else {
            i2 = j2 < 1000000000000000000L ? 18 : 19;
        }
        if (z2) {
            i2++;
        }
        D dM = M(i2);
        int i3 = dM.f3446c + i2;
        while (true) {
            bArr = dM.f3444a;
            if (j2 == 0) {
                break;
            }
            long j3 = 10;
            i3--;
            bArr[i3] = l1.a.f3534a[(int) (j2 % j3)];
            j2 /= j3;
        }
        if (z2) {
            bArr[i3 - 1] = 45;
        }
        dM.f3446c += i2;
        this.f3482b += (long) i2;
    }

    public final void S(long j2) {
        if (j2 == 0) {
            Q(48);
            return;
        }
        long j3 = (j2 >>> 1) | j2;
        long j4 = j3 | (j3 >>> 2);
        long j5 = j4 | (j4 >>> 4);
        long j6 = j5 | (j5 >>> 8);
        long j7 = j6 | (j6 >>> 16);
        long j8 = j7 | (j7 >>> 32);
        long j9 = j8 - ((j8 >>> 1) & 6148914691236517205L);
        long j10 = ((j9 >>> 2) & 3689348814741910323L) + (j9 & 3689348814741910323L);
        long j11 = ((j10 >>> 4) + j10) & 1085102592571150095L;
        long j12 = j11 + (j11 >>> 8);
        long j13 = j12 + (j12 >>> 16);
        int i2 = (int) ((((j13 & 63) + ((j13 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        D dM = M(i2);
        int i3 = dM.f3446c;
        for (int i4 = (i3 + i2) - 1; i4 >= i3; i4--) {
            dM.f3444a[i4] = l1.a.f3534a[(int) (15 & j2)];
            j2 >>>= 4;
        }
        dM.f3446c += i2;
        this.f3482b += (long) i2;
    }

    public final void T(int i2) {
        D dM = M(4);
        int i3 = dM.f3446c;
        byte[] bArr = dM.f3444a;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        bArr[i3 + 1] = (byte) ((i2 >>> 16) & 255);
        bArr[i3 + 2] = (byte) ((i2 >>> 8) & 255);
        bArr[i3 + 3] = (byte) (i2 & 255);
        dM.f3446c = i3 + 4;
        this.f3482b += 4;
    }

    public final void U(String str) {
        F0.i.e(str, "string");
        V(str, 0, str.length());
    }

    public final void V(String str, int i2, int i3) {
        char cCharAt;
        F0.i.e(str, "string");
        if (i2 < 0) {
            throw new IllegalArgumentException(F0.h.b(i2, "beginIndex < 0: ").toString());
        }
        if (i3 < i2) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i3 + " < " + i2).toString());
        }
        if (i3 > str.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i3 + " > " + str.length()).toString());
        }
        while (i2 < i3) {
            char cCharAt2 = str.charAt(i2);
            if (cCharAt2 < 128) {
                D dM = M(1);
                int i4 = dM.f3446c - i2;
                int iMin = Math.min(i3, 8192 - i4);
                int i5 = i2 + 1;
                byte[] bArr = dM.f3444a;
                bArr[i2 + i4] = (byte) cCharAt2;
                while (true) {
                    i2 = i5;
                    if (i2 >= iMin || (cCharAt = str.charAt(i2)) >= 128) {
                        break;
                    }
                    i5 = i2 + 1;
                    bArr[i2 + i4] = (byte) cCharAt;
                }
                int i6 = dM.f3446c;
                int i7 = (i4 + i2) - i6;
                dM.f3446c = i6 + i7;
                this.f3482b += (long) i7;
            } else {
                if (cCharAt2 < 2048) {
                    D dM2 = M(2);
                    int i8 = dM2.f3446c;
                    byte[] bArr2 = dM2.f3444a;
                    bArr2[i8] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i8 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    dM2.f3446c = i8 + 2;
                    this.f3482b += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    D dM3 = M(3);
                    int i9 = dM3.f3446c;
                    byte[] bArr3 = dM3.f3444a;
                    bArr3[i9] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i9 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i9 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    dM3.f3446c = i9 + 3;
                    this.f3482b += 3;
                } else {
                    int i10 = i2 + 1;
                    char cCharAt3 = i10 < i3 ? str.charAt(i10) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        Q(63);
                        i2 = i10;
                    } else {
                        int i11 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        D dM4 = M(4);
                        int i12 = dM4.f3446c;
                        byte[] bArr4 = dM4.f3444a;
                        bArr4[i12] = (byte) ((i11 >> 18) | 240);
                        bArr4[i12 + 1] = (byte) (((i11 >> 12) & 63) | 128);
                        bArr4[i12 + 2] = (byte) (((i11 >> 6) & 63) | 128);
                        bArr4[i12 + 3] = (byte) ((i11 & 63) | 128);
                        dM4.f3446c = i12 + 4;
                        this.f3482b += 4;
                        i2 += 2;
                    }
                }
                i2++;
            }
        }
    }

    public final void W(int i2) {
        String str;
        int i3 = 0;
        if (i2 < 128) {
            Q(i2);
            return;
        }
        if (i2 < 2048) {
            D dM = M(2);
            int i4 = dM.f3446c;
            byte[] bArr = dM.f3444a;
            bArr[i4] = (byte) ((i2 >> 6) | 192);
            bArr[1 + i4] = (byte) ((i2 & 63) | 128);
            dM.f3446c = i4 + 2;
            this.f3482b += 2;
            return;
        }
        if (55296 <= i2 && i2 < 57344) {
            Q(63);
            return;
        }
        if (i2 < 65536) {
            D dM2 = M(3);
            int i5 = dM2.f3446c;
            byte[] bArr2 = dM2.f3444a;
            bArr2[i5] = (byte) ((i2 >> 12) | 224);
            bArr2[1 + i5] = (byte) (((i2 >> 6) & 63) | 128);
            bArr2[2 + i5] = (byte) ((i2 & 63) | 128);
            dM2.f3446c = i5 + 3;
            this.f3482b += 3;
            return;
        }
        if (i2 <= 1114111) {
            D dM3 = M(4);
            int i6 = dM3.f3446c;
            byte[] bArr3 = dM3.f3444a;
            bArr3[i6] = (byte) ((i2 >> 18) | 240);
            bArr3[1 + i6] = (byte) (((i2 >> 12) & 63) | 128);
            bArr3[2 + i6] = (byte) (((i2 >> 6) & 63) | 128);
            bArr3[3 + i6] = (byte) ((i2 & 63) | 128);
            dM3.f3446c = i6 + 4;
            this.f3482b += 4;
            return;
        }
        StringBuilder sb = new StringBuilder("Unexpected code point: 0x");
        if (i2 != 0) {
            char[] cArr = l1.b.f3535a;
            char[] cArr2 = {cArr[(i2 >> 28) & 15], cArr[(i2 >> 24) & 15], cArr[(i2 >> 20) & 15], cArr[(i2 >> 16) & 15], cArr[(i2 >> 12) & 15], cArr[(i2 >> 8) & 15], cArr[(i2 >> 4) & 15], cArr[i2 & 15]};
            while (i3 < 8 && cArr2[i3] == '0') {
                i3++;
            }
            if (i3 < 0) {
                throw new IndexOutOfBoundsException("startIndex: " + i3 + ", endIndex: 8, size: 8");
            }
            if (i3 > 8) {
                throw new IllegalArgumentException("startIndex: " + i3 + " > endIndex: 8");
            }
            str = new String(cArr2, i3, 8 - i3);
        } else {
            str = "0";
        }
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // k1.I
    public final K c() {
        return K.f3456d;
    }

    public final Object clone() {
        C0193i c0193i = new C0193i();
        if (this.f3482b != 0) {
            D d2 = this.f3481a;
            F0.i.b(d2);
            D dC = d2.c();
            c0193i.f3481a = dC;
            dC.g = dC;
            dC.f3449f = dC;
            for (D d3 = d2.f3449f; d3 != d2; d3 = d3.f3449f) {
                D d4 = dC.g;
                F0.i.b(d4);
                F0.i.b(d3);
                d4.b(d3.c());
            }
            c0193i.f3482b = this.f3482b;
        }
        return c0193i;
    }

    @Override // k1.InterfaceC0194j
    public final InterfaceC0194j d(byte[] bArr) {
        F0.i.e(bArr, "source");
        O(bArr, 0, bArr.length);
        return this;
    }

    @Override // k1.InterfaceC0194j
    public final /* bridge */ /* synthetic */ InterfaceC0194j e(byte[] bArr, int i2, int i3) {
        O(bArr, i2, i3);
        return this;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof C0193i) {
                long j2 = this.f3482b;
                C0193i c0193i = (C0193i) obj;
                if (j2 == c0193i.f3482b) {
                    if (j2 != 0) {
                        D d2 = this.f3481a;
                        F0.i.b(d2);
                        D d3 = c0193i.f3481a;
                        F0.i.b(d3);
                        int i2 = d2.f3445b;
                        int i3 = d3.f3445b;
                        long j3 = 0;
                        while (j3 < this.f3482b) {
                            long jMin = Math.min(d2.f3446c - i2, d3.f3446c - i3);
                            long j4 = 0;
                            while (j4 < jMin) {
                                int i4 = i2 + 1;
                                byte b2 = d2.f3444a[i2];
                                int i5 = i3 + 1;
                                if (b2 == d3.f3444a[i3]) {
                                    j4++;
                                    i3 = i5;
                                    i2 = i4;
                                }
                            }
                            if (i2 == d2.f3446c) {
                                D d4 = d2.f3449f;
                                F0.i.b(d4);
                                i2 = d4.f3445b;
                                d2 = d4;
                            }
                            if (i3 == d3.f3446c) {
                                d3 = d3.f3449f;
                                F0.i.b(d3);
                                i3 = d3.f3445b;
                            }
                            j3 += jMin;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // k1.InterfaceC0195k
    public final long g(InterfaceC0194j interfaceC0194j) {
        long j2 = this.f3482b;
        if (j2 > 0) {
            interfaceC0194j.i(this, j2);
        }
        return j2;
    }

    @Override // k1.InterfaceC0195k
    public final int h(y yVar) throws EOFException {
        F0.i.e(yVar, "options");
        int iB = l1.a.b(this, yVar, false);
        if (iB == -1) {
            return -1;
        }
        K(yVar.f3515a[iB].c());
        return iB;
    }

    public final int hashCode() {
        D d2 = this.f3481a;
        if (d2 == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = d2.f3446c;
            for (int i4 = d2.f3445b; i4 < i3; i4++) {
                i2 = (i2 * 31) + d2.f3444a[i4];
            }
            d2 = d2.f3449f;
            F0.i.b(d2);
        } while (d2 != this.f3481a);
        return i2;
    }

    @Override // k1.G
    public final void i(C0193i c0193i, long j2) {
        D dB;
        F0.i.e(c0193i, "source");
        if (c0193i == this) {
            throw new IllegalArgumentException("source == this");
        }
        f1.d.g(c0193i.f3482b, 0L, j2);
        while (j2 > 0) {
            D d2 = c0193i.f3481a;
            F0.i.b(d2);
            int i2 = d2.f3446c;
            D d3 = c0193i.f3481a;
            F0.i.b(d3);
            long j3 = i2 - d3.f3445b;
            int i3 = 0;
            if (j2 < j3) {
                D d4 = this.f3481a;
                D d5 = d4 != null ? d4.g : null;
                if (d5 != null && d5.f3448e) {
                    if ((((long) d5.f3446c) + j2) - ((long) (d5.f3447d ? 0 : d5.f3445b)) <= 8192) {
                        D d6 = c0193i.f3481a;
                        F0.i.b(d6);
                        d6.d(d5, (int) j2);
                        c0193i.f3482b -= j2;
                        this.f3482b += j2;
                        return;
                    }
                }
                D d7 = c0193i.f3481a;
                F0.i.b(d7);
                int i4 = (int) j2;
                if (i4 <= 0 || i4 > d7.f3446c - d7.f3445b) {
                    throw new IllegalArgumentException("byteCount out of range");
                }
                if (i4 >= 1024) {
                    dB = d7.c();
                } else {
                    dB = E.b();
                    int i5 = d7.f3445b;
                    p036u0.e.r(0, i5, i5 + i4, d7.f3444a, dB.f3444a);
                }
                dB.f3446c = dB.f3445b + i4;
                d7.f3445b += i4;
                D d8 = d7.g;
                F0.i.b(d8);
                d8.b(dB);
                c0193i.f3481a = dB;
            }
            D d9 = c0193i.f3481a;
            F0.i.b(d9);
            long j4 = d9.f3446c - d9.f3445b;
            c0193i.f3481a = d9.a();
            D d10 = this.f3481a;
            if (d10 == null) {
                this.f3481a = d9;
                d9.g = d9;
                d9.f3449f = d9;
            } else {
                D d11 = d10.g;
                F0.i.b(d11);
                d11.b(d9);
                D d12 = d9.g;
                if (d12 == d9) {
                    throw new IllegalStateException("cannot compact");
                }
                F0.i.b(d12);
                if (d12.f3448e) {
                    int i6 = d9.f3446c - d9.f3445b;
                    D d13 = d9.g;
                    F0.i.b(d13);
                    int i7 = 8192 - d13.f3446c;
                    D d14 = d9.g;
                    F0.i.b(d14);
                    if (!d14.f3447d) {
                        D d15 = d9.g;
                        F0.i.b(d15);
                        i3 = d15.f3445b;
                    }
                    if (i6 <= i7 + i3) {
                        D d16 = d9.g;
                        F0.i.b(d16);
                        d9.d(d16, i6);
                        d9.a();
                        E.a(d9);
                    }
                }
            }
            c0193i.f3482b -= j4;
            this.f3482b += j4;
            j2 -= j4;
        }
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // k1.InterfaceC0194j
    public final /* bridge */ /* synthetic */ InterfaceC0194j k(String str) {
        U(str);
        return this;
    }

    @Override // k1.InterfaceC0194j
    public final /* bridge */ /* synthetic */ InterfaceC0194j l(long j2) {
        R(j2);
        return this;
    }

    @Override // k1.I
    public final long m(C0193i c0193i, long j2) {
        F0.i.e(c0193i, "sink");
        if (j2 < 0) {
            throw new IllegalArgumentException(F0.h.d("byteCount < 0: ", j2).toString());
        }
        long j3 = this.f3482b;
        if (j3 == 0) {
            return -1L;
        }
        if (j2 > j3) {
            j2 = j3;
        }
        c0193i.i(this, j2);
        return j2;
    }

    @Override // k1.InterfaceC0194j
    public final /* bridge */ /* synthetic */ InterfaceC0194j o(int i2) {
        Q(i2);
        return this;
    }

    @Override // k1.InterfaceC0194j
    public final /* bridge */ /* synthetic */ InterfaceC0194j p(C0196l c0196l) {
        N(c0196l);
        return this;
    }

    @Override // k1.InterfaceC0195k
    public final boolean q(long j2) {
        return this.f3482b >= j2;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        F0.i.e(byteBuffer, "sink");
        D d2 = this.f3481a;
        if (d2 == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), d2.f3446c - d2.f3445b);
        byteBuffer.put(d2.f3444a, d2.f3445b, iMin);
        int i2 = d2.f3445b + iMin;
        d2.f3445b = i2;
        this.f3482b -= (long) iMin;
        if (i2 == d2.f3446c) {
            this.f3481a = d2.a();
            E.a(d2);
        }
        return iMin;
    }

    @Override // k1.InterfaceC0195k
    public final InputStream s() {
        return new C0191g(this, 0);
    }

    public final void t() {
        K(this.f3482b);
    }

    public final String toString() {
        long j2 = this.f3482b;
        if (j2 <= 2147483647L) {
            return L((int) j2).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f3482b).toString());
    }

    public final long u() {
        long j2 = this.f3482b;
        if (j2 == 0) {
            return 0L;
        }
        D d2 = this.f3481a;
        F0.i.b(d2);
        D d3 = d2.g;
        F0.i.b(d3);
        int i2 = d3.f3446c;
        if (i2 < 8192 && d3.f3448e) {
            j2 -= (long) (i2 - d3.f3445b);
        }
        return j2;
    }

    public final void v(C0193i c0193i, long j2, long j3) {
        F0.i.e(c0193i, "out");
        f1.d.g(this.f3482b, j2, j3);
        if (j3 == 0) {
            return;
        }
        c0193i.f3482b += j3;
        D d2 = this.f3481a;
        while (true) {
            F0.i.b(d2);
            long j4 = d2.f3446c - d2.f3445b;
            if (j2 < j4) {
                break;
            }
            j2 -= j4;
            d2 = d2.f3449f;
        }
        while (j3 > 0) {
            F0.i.b(d2);
            D dC = d2.c();
            int i2 = dC.f3445b + ((int) j2);
            dC.f3445b = i2;
            dC.f3446c = Math.min(i2 + ((int) j3), dC.f3446c);
            D d3 = c0193i.f3481a;
            if (d3 == null) {
                dC.g = dC;
                dC.f3449f = dC;
                c0193i.f3481a = dC;
            } else {
                D d4 = d3.g;
                F0.i.b(d4);
                d4.b(dC);
            }
            j3 -= (long) (dC.f3446c - dC.f3445b);
            d2 = d2.f3449f;
            j2 = 0;
        }
    }

    public final boolean w() {
        return this.f3482b == 0;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        F0.i.e(byteBuffer, "source");
        int iRemaining = byteBuffer.remaining();
        int i2 = iRemaining;
        while (i2 > 0) {
            D dM = M(1);
            int iMin = Math.min(i2, 8192 - dM.f3446c);
            byteBuffer.get(dM.f3444a, dM.f3446c, iMin);
            i2 -= iMin;
            dM.f3446c += iMin;
        }
        this.f3482b += (long) iRemaining;
        return iRemaining;
    }

    public final byte x(long j2) {
        f1.d.g(this.f3482b, j2, 1L);
        D d2 = this.f3481a;
        if (d2 == null) {
            F0.i.b(null);
            throw null;
        }
        long j3 = this.f3482b;
        if (j3 - j2 < j2) {
            while (j3 > j2) {
                d2 = d2.g;
                F0.i.b(d2);
                j3 -= (long) (d2.f3446c - d2.f3445b);
            }
            return d2.f3444a[(int) ((((long) d2.f3445b) + j2) - j3)];
        }
        long j4 = 0;
        while (true) {
            int i2 = d2.f3446c;
            int i3 = d2.f3445b;
            long j5 = ((long) (i2 - i3)) + j4;
            if (j5 > j2) {
                return d2.f3444a[(int) ((((long) i3) + j2) - j4)];
            }
            d2 = d2.f3449f;
            F0.i.b(d2);
            j4 = j5;
        }
    }

    public final long y(C0196l c0196l) {
        int i2;
        int i3;
        F0.i.e(c0196l, "targetBytes");
        D d2 = this.f3481a;
        if (d2 == null) {
            return -1L;
        }
        long j2 = this.f3482b;
        long j3 = 0;
        byte[] bArr = c0196l.f3484a;
        if (j2 < 0) {
            while (j2 > 0) {
                d2 = d2.g;
                F0.i.b(d2);
                j2 -= (long) (d2.f3446c - d2.f3445b);
            }
            if (bArr.length == 2) {
                byte b2 = bArr[0];
                byte b3 = bArr[1];
                while (j2 < this.f3482b) {
                    i2 = (int) ((((long) d2.f3445b) + j3) - j2);
                    int i4 = d2.f3446c;
                    while (true) {
                        if (i2 >= i4) {
                            j3 = ((long) (d2.f3446c - d2.f3445b)) + j2;
                            d2 = d2.f3449f;
                            F0.i.b(d2);
                            j2 = j3;
                        } else {
                            byte b4 = d2.f3444a[i2];
                            if (b4 == b2 || b4 == b3) {
                                i3 = d2.f3445b;
                            } else {
                                i2++;
                            }
                        }
                    }
                }
                return -1L;
            }
            while (j2 < this.f3482b) {
                i2 = (int) ((((long) d2.f3445b) + j3) - j2);
                int i5 = d2.f3446c;
                while (true) {
                    if (i2 < i5) {
                        byte b5 = d2.f3444a[i2];
                        int length = bArr.length;
                        int i6 = 0;
                        while (true) {
                            if (i6 >= length) {
                                i2++;
                            } else if (b5 == bArr[i6]) {
                                i3 = d2.f3445b;
                            } else {
                                i6++;
                            }
                        }
                    } else {
                        j3 = ((long) (d2.f3446c - d2.f3445b)) + j2;
                        d2 = d2.f3449f;
                        F0.i.b(d2);
                        j2 = j3;
                    }
                }
            }
            return -1L;
        }
        j2 = 0;
        while (true) {
            long j4 = ((long) (d2.f3446c - d2.f3445b)) + j2;
            if (j4 > 0) {
                break;
            }
            d2 = d2.f3449f;
            F0.i.b(d2);
            j2 = j4;
        }
        if (bArr.length == 2) {
            byte b6 = bArr[0];
            byte b7 = bArr[1];
            while (j2 < this.f3482b) {
                i2 = (int) ((((long) d2.f3445b) + j3) - j2);
                int i7 = d2.f3446c;
                while (true) {
                    if (i2 >= i7) {
                        j3 = ((long) (d2.f3446c - d2.f3445b)) + j2;
                        d2 = d2.f3449f;
                        F0.i.b(d2);
                        j2 = j3;
                    } else {
                        byte b8 = d2.f3444a[i2];
                        if (b8 == b6 || b8 == b7) {
                            i3 = d2.f3445b;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            return -1L;
        }
        while (j2 < this.f3482b) {
            i2 = (int) ((((long) d2.f3445b) + j3) - j2);
            int i8 = d2.f3446c;
            while (true) {
                if (i2 < i8) {
                    byte b9 = d2.f3444a[i2];
                    int length2 = bArr.length;
                    int i9 = 0;
                    while (true) {
                        if (i9 >= length2) {
                            i2++;
                        } else if (b9 == bArr[i9]) {
                            i3 = d2.f3445b;
                        } else {
                            i9++;
                        }
                    }
                } else {
                    j3 = ((long) (d2.f3446c - d2.f3445b)) + j2;
                    d2 = d2.f3449f;
                    F0.i.b(d2);
                    j2 = j3;
                }
            }
        }
        return -1L;
        return ((long) (i2 - i3)) + j2;
    }

    public final boolean z(C0196l c0196l) {
        F0.i.e(c0196l, "bytes");
        byte[] bArr = c0196l.f3484a;
        int length = bArr.length;
        if (length < 0 || this.f3482b < length || bArr.length < length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (x(i2) != bArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // k1.InterfaceC0195k
    public final C0193i b() {
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, k1.G
    public final void close() {
    }

    @Override // k1.G, java.io.Flushable
    public final void flush() {
    }
}
