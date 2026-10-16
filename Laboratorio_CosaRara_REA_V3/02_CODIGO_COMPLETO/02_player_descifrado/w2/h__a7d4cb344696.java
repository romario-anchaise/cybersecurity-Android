// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w2;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import w1.j4;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements j, i, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s f5776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f5777d;

    public final g A(g gVar) {
        gVar.getClass();
        byte[] bArr = x2.a.f5966a;
        if (gVar == b.f5754a) {
            gVar = new g();
        }
        if (gVar.f5769c != null) {
            o2.k("already attached to a buffer");
            return null;
        }
        gVar.f5769c = this;
        gVar.f5770d = true;
        return gVar;
    }

    public final byte[] B(long j3) throws EOFException {
        if (j3 < 0 || j3 > 2147483647L) {
            o2.j("byteCount: ", j3);
            return null;
        }
        if (this.f5777d < j3) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j3];
        readFully(bArr);
        return bArr;
    }

    public final String C(long j3, Charset charset) throws EOFException {
        charset.getClass();
        if (j3 < 0 || j3 > 2147483647L) {
            o2.j("byteCount: ", j3);
            return null;
        }
        if (this.f5777d < j3) {
            throw new EOFException();
        }
        if (j3 == 0) {
            return "";
        }
        s sVar = this.f5776c;
        sVar.getClass();
        int i3 = sVar.f5802b;
        if (((long) i3) + j3 > sVar.f5803c) {
            return new String(B(j3), charset);
        }
        int i4 = (int) j3;
        String str = new String(sVar.f5801a, i3, i4, charset);
        int i5 = sVar.f5802b + i4;
        sVar.f5802b = i5;
        this.f5777d -= j3;
        if (i5 == sVar.f5803c) {
            this.f5776c = sVar.a();
            t.a(sVar);
        }
        return str;
    }

    public final String D() {
        return C(this.f5777d, v1.a.f3277a);
    }

    public final k E(int i3) {
        if (i3 == 0) {
            return k.f5778f;
        }
        b.c(this.f5777d, 0L, i3);
        s sVar = this.f5776c;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3) {
            sVar.getClass();
            int i7 = sVar.f5803c;
            int i8 = sVar.f5802b;
            if (i7 == i8) {
                throw new AssertionError("s.limit == s.pos");
            }
            i5 += i7 - i8;
            i6++;
            sVar = sVar.f5806f;
        }
        byte[][] bArr = new byte[i6][];
        int[] iArr = new int[i6 * 2];
        s sVar2 = this.f5776c;
        int i9 = 0;
        while (i4 < i3) {
            sVar2.getClass();
            bArr[i9] = sVar2.f5801a;
            i4 += sVar2.f5803c - sVar2.f5802b;
            iArr[i9] = Math.min(i4, i3);
            iArr[i9 + i6] = sVar2.f5802b;
            sVar2.f5804d = true;
            i9++;
            sVar2 = sVar2.f5806f;
        }
        return new u(bArr, iArr);
    }

    public final s F(int i3) {
        if (i3 < 1 || i3 > 8192) {
            o2.i("unexpected capacity");
            return null;
        }
        s sVar = this.f5776c;
        if (sVar == null) {
            s sVarB = t.b();
            this.f5776c = sVarB;
            sVarB.f5807g = sVarB;
            sVarB.f5806f = sVarB;
            return sVarB;
        }
        s sVar2 = sVar.f5807g;
        sVar2.getClass();
        if (sVar2.f5803c + i3 <= 8192 && sVar2.f5805e) {
            return sVar2;
        }
        s sVarB2 = t.b();
        sVar2.b(sVarB2);
        return sVarB2;
    }

    public final void G(int i3, byte[] bArr) {
        bArr.getClass();
        int i4 = 0;
        long j3 = i3;
        b.c(bArr.length, 0, j3);
        while (i4 < i3) {
            s sVarF = F(1);
            int iMin = Math.min(i3 - i4, 8192 - sVarF.f5803c);
            int i5 = i4 + iMin;
            i1.h.s(bArr, sVarF.f5801a, sVarF.f5803c, i4, i5);
            sVarF.f5803c += iMin;
            i4 = i5;
        }
        this.f5777d += j3;
    }

    public final void H(k kVar) {
        kVar.getClass();
        kVar.l(this, kVar.c());
    }

    public final void I(x xVar) {
        xVar.getClass();
        while (xVar.f(8192L, this) != -1) {
        }
    }

    public final void J(int i3) {
        s sVarF = F(1);
        byte[] bArr = sVarF.f5801a;
        int i4 = sVarF.f5803c;
        sVarF.f5803c = i4 + 1;
        bArr[i4] = (byte) i3;
        this.f5777d++;
    }

    public final void K(long j3) {
        if (j3 == 0) {
            J(48);
            return;
        }
        long j4 = (j3 >>> 1) | j3;
        long j5 = j4 | (j4 >>> 2);
        long j6 = j5 | (j5 >>> 4);
        long j7 = j6 | (j6 >>> 8);
        long j8 = j7 | (j7 >>> 16);
        long j9 = j8 | (j8 >>> 32);
        long j10 = j9 - ((j9 >>> 1) & 6148914691236517205L);
        long j11 = ((j10 >>> 2) & 3689348814741910323L) + (j10 & 3689348814741910323L);
        long j12 = ((j11 >>> 4) + j11) & 1085102592571150095L;
        long j13 = j12 + (j12 >>> 8);
        long j14 = j13 + (j13 >>> 16);
        int i3 = (int) ((((j14 & 63) + ((j14 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        s sVarF = F(i3);
        byte[] bArr = sVarF.f5801a;
        int i4 = sVarF.f5803c;
        for (int i5 = (i4 + i3) - 1; i5 >= i4; i5--) {
            bArr[i5] = x2.a.f5966a[(int) (15 & j3)];
            j3 >>>= 4;
        }
        sVarF.f5803c += i3;
        this.f5777d += (long) i3;
    }

    public final void L(int i3) {
        s sVarF = F(4);
        byte[] bArr = sVarF.f5801a;
        int i4 = sVarF.f5803c;
        bArr[i4] = (byte) ((i3 >>> 24) & 255);
        bArr[i4 + 1] = (byte) ((i3 >>> 16) & 255);
        bArr[i4 + 2] = (byte) ((i3 >>> 8) & 255);
        bArr[i4 + 3] = (byte) (i3 & 255);
        sVarF.f5803c = i4 + 4;
        this.f5777d += 4;
    }

    public final void M(int i3) {
        s sVarF = F(2);
        byte[] bArr = sVarF.f5801a;
        int i4 = sVarF.f5803c;
        bArr[i4] = (byte) ((i3 >>> 8) & 255);
        bArr[i4 + 1] = (byte) (i3 & 255);
        sVarF.f5803c = i4 + 2;
        this.f5777d += 2;
    }

    public final void N(int i3, int i4, String str) {
        char cCharAt;
        str.getClass();
        if (i3 < 0) {
            o2.h(a0.a.g("beginIndex < 0: ", i3));
            return;
        }
        if (i4 < i3) {
            o2.h(a0.a.f(i4, i3, "endIndex < beginIndex: ", " < "));
            return;
        }
        if (i4 > str.length()) {
            StringBuilder sbI = a0.a.i(i4, "endIndex > string.length: ", " > ");
            sbI.append(str.length());
            throw new IllegalArgumentException(sbI.toString().toString());
        }
        while (i3 < i4) {
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 128) {
                s sVarF = F(1);
                byte[] bArr = sVarF.f5801a;
                int i5 = sVarF.f5803c - i3;
                int iMin = Math.min(i4, 8192 - i5);
                int i6 = i3 + 1;
                bArr[i3 + i5] = (byte) cCharAt2;
                while (true) {
                    i3 = i6;
                    if (i3 >= iMin || (cCharAt = str.charAt(i3)) >= 128) {
                        break;
                    }
                    i6 = i3 + 1;
                    bArr[i3 + i5] = (byte) cCharAt;
                }
                int i7 = sVarF.f5803c;
                int i8 = (i5 + i3) - i7;
                sVarF.f5803c = i7 + i8;
                this.f5777d += (long) i8;
            } else {
                if (cCharAt2 < 2048) {
                    s sVarF2 = F(2);
                    byte[] bArr2 = sVarF2.f5801a;
                    int i9 = sVarF2.f5803c;
                    bArr2[i9] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i9 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    sVarF2.f5803c = i9 + 2;
                    this.f5777d += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    s sVarF3 = F(3);
                    byte[] bArr3 = sVarF3.f5801a;
                    int i10 = sVarF3.f5803c;
                    bArr3[i10] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i10 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i10 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    sVarF3.f5803c = i10 + 3;
                    this.f5777d += 3;
                } else {
                    int i11 = i3 + 1;
                    char cCharAt3 = i11 < i4 ? str.charAt(i11) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        J(63);
                        i3 = i11;
                    } else {
                        int i12 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        s sVarF4 = F(4);
                        byte[] bArr4 = sVarF4.f5801a;
                        int i13 = sVarF4.f5803c;
                        bArr4[i13] = (byte) ((i12 >> 18) | 240);
                        bArr4[i13 + 1] = (byte) (((i12 >> 12) & 63) | 128);
                        bArr4[i13 + 2] = (byte) (((i12 >> 6) & 63) | 128);
                        bArr4[i13 + 3] = (byte) ((i12 & 63) | 128);
                        sVarF4.f5803c = i13 + 4;
                        this.f5777d += 4;
                        i3 += 2;
                    }
                }
                i3++;
            }
        }
    }

    public final void O(String str) {
        str.getClass();
        N(0, str.length(), str);
    }

    public final void P(int i3) {
        String str;
        if (i3 < 128) {
            J(i3);
            return;
        }
        if (i3 < 2048) {
            s sVarF = F(2);
            byte[] bArr = sVarF.f5801a;
            int i4 = sVarF.f5803c;
            bArr[i4] = (byte) ((i3 >> 6) | 192);
            bArr[i4 + 1] = (byte) ((i3 & 63) | 128);
            sVarF.f5803c = i4 + 2;
            this.f5777d += 2;
            return;
        }
        if (55296 <= i3 && i3 < 57344) {
            J(63);
            return;
        }
        if (i3 < 65536) {
            s sVarF2 = F(3);
            byte[] bArr2 = sVarF2.f5801a;
            int i5 = sVarF2.f5803c;
            bArr2[i5] = (byte) ((i3 >> 12) | 224);
            bArr2[i5 + 1] = (byte) (((i3 >> 6) & 63) | 128);
            bArr2[i5 + 2] = (byte) ((i3 & 63) | 128);
            sVarF2.f5803c = i5 + 3;
            this.f5777d += 3;
            return;
        }
        if (i3 <= 1114111) {
            s sVarF3 = F(4);
            byte[] bArr3 = sVarF3.f5801a;
            int i6 = sVarF3.f5803c;
            bArr3[i6] = (byte) ((i3 >> 18) | 240);
            bArr3[i6 + 1] = (byte) (((i3 >> 12) & 63) | 128);
            bArr3[i6 + 2] = (byte) (((i3 >> 6) & 63) | 128);
            bArr3[i6 + 3] = (byte) ((i3 & 63) | 128);
            sVarF3.f5803c = i6 + 4;
            this.f5777d += 4;
            return;
        }
        StringBuilder sb = new StringBuilder("Unexpected code point: 0x");
        if (i3 != 0) {
            char[] cArr = x2.b.f5967a;
            int i7 = 0;
            char[] cArr2 = {cArr[(i3 >> 28) & 15], cArr[(i3 >> 24) & 15], cArr[(i3 >> 20) & 15], cArr[(i3 >> 16) & 15], cArr[(i3 >> 12) & 15], cArr[(i3 >> 8) & 15], cArr[(i3 >> 4) & 15], cArr[i3 & 15]};
            while (i7 < 8 && cArr2[i7] == '0') {
                i7++;
            }
            if (i7 < 0) {
                throw new IndexOutOfBoundsException(j4.c(i7, "startIndex: ", ", endIndex: 8, size: 8"));
            }
            if (i7 > 8) {
                o2.i(j4.c(i7, "startIndex: ", " > endIndex: 8"));
                return;
            }
            str = new String(cArr2, i7, 8 - i7);
        } else {
            str = "0";
        }
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // w2.x
    public final z a() {
        return z.f5814d;
    }

    @Override // w2.j
    public final void b(long j3, h hVar) {
        long j4 = this.f5777d;
        if (j4 >= j3) {
            hVar.t(j3, this);
        } else {
            hVar.t(j4, this);
            throw new EOFException();
        }
    }

    @Override // w2.i
    public final /* bridge */ /* synthetic */ i c(long j3) {
        K(j3);
        return this;
    }

    public final Object clone() {
        h hVar = new h();
        if (this.f5777d == 0) {
            return hVar;
        }
        s sVar = this.f5776c;
        sVar.getClass();
        s sVarC = sVar.c();
        hVar.f5776c = sVarC;
        sVarC.f5807g = sVarC;
        sVarC.f5806f = sVarC;
        for (s sVar2 = sVar.f5806f; sVar2 != sVar; sVar2 = sVar2.f5806f) {
            s sVar3 = sVarC.f5807g;
            sVar3.getClass();
            sVar2.getClass();
            sVar3.b(sVar2.c());
        }
        hVar.f5777d = this.f5777d;
        return hVar;
    }

    public final void d(h hVar, long j3, long j4) {
        hVar.getClass();
        long j5 = j3;
        b.c(this.f5777d, j5, j4);
        if (j4 == 0) {
            return;
        }
        hVar.f5777d += j4;
        s sVar = this.f5776c;
        while (true) {
            sVar.getClass();
            long j6 = sVar.f5803c - sVar.f5802b;
            if (j5 < j6) {
                break;
            }
            j5 -= j6;
            sVar = sVar.f5806f;
        }
        long j7 = j4;
        while (j7 > 0) {
            sVar.getClass();
            s sVarC = sVar.c();
            int i3 = sVarC.f5802b + ((int) j5);
            sVarC.f5802b = i3;
            sVarC.f5803c = Math.min(i3 + ((int) j7), sVarC.f5803c);
            s sVar2 = hVar.f5776c;
            if (sVar2 == null) {
                sVarC.f5807g = sVarC;
                sVarC.f5806f = sVarC;
                hVar.f5776c = sVarC;
            } else {
                s sVar3 = sVar2.f5807g;
                sVar3.getClass();
                sVar3.b(sVarC);
            }
            j7 -= (long) (sVarC.f5803c - sVarC.f5802b);
            sVar = sVar.f5806f;
            j5 = 0;
        }
    }

    @Override // w2.j
    public final k e(long j3) throws EOFException {
        if (j3 < 0 || j3 > 2147483647L) {
            o2.j("byteCount: ", j3);
            return null;
        }
        if (this.f5777d < j3) {
            throw new EOFException();
        }
        if (j3 < 4096) {
            return new k(B(j3));
        }
        k kVarE = E((int) j3);
        skip(j3);
        return kVarE;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        long j3 = this.f5777d;
        h hVar = (h) obj;
        if (j3 != hVar.f5777d) {
            return false;
        }
        if (j3 == 0) {
            return true;
        }
        s sVar = this.f5776c;
        sVar.getClass();
        s sVar2 = hVar.f5776c;
        sVar2.getClass();
        int i3 = sVar.f5802b;
        int i4 = sVar2.f5802b;
        long j4 = 0;
        while (j4 < this.f5777d) {
            long jMin = Math.min(sVar.f5803c - i3, sVar2.f5803c - i4);
            long j5 = 0;
            while (j5 < jMin) {
                int i5 = i3 + 1;
                int i6 = i4 + 1;
                if (sVar.f5801a[i3] != sVar2.f5801a[i4]) {
                    return false;
                }
                j5++;
                i3 = i5;
                i4 = i6;
            }
            if (i3 == sVar.f5803c) {
                sVar = sVar.f5806f;
                sVar.getClass();
                i3 = sVar.f5802b;
            }
            if (i4 == sVar2.f5803c) {
                sVar2 = sVar2.f5806f;
                sVar2.getClass();
                i4 = sVar2.f5802b;
            }
            j4 += jMin;
        }
        return true;
    }

    @Override // w2.x
    public final long f(long j3, h hVar) {
        hVar.getClass();
        if (j3 < 0) {
            o2.j("byteCount < 0: ", j3);
            return 0L;
        }
        long j4 = this.f5777d;
        if (j4 == 0) {
            return -1L;
        }
        if (j3 > j4) {
            j3 = j4;
        }
        hVar.t(j3, this);
        return j3;
    }

    @Override // w2.j
    public final String g(long j3) throws EOFException {
        if (j3 < 0) {
            o2.j("limit < 0: ", j3);
            return null;
        }
        long j4 = j3 != Long.MAX_VALUE ? j3 + 1 : Long.MAX_VALUE;
        long jZ = z((byte) 10, 0L, j4);
        if (jZ != -1) {
            return x2.a.a(jZ, this);
        }
        if (j4 < this.f5777d && y(j4 - 1) == 13 && y(j4) == 10) {
            return x2.a.a(j4, this);
        }
        h hVar = new h();
        d(hVar, 0L, Math.min(32, this.f5777d));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f5777d, j3) + " content=" + hVar.e(hVar.f5777d).d() + (char) 8230);
    }

    public final int hashCode() {
        s sVar = this.f5776c;
        if (sVar == null) {
            return 0;
        }
        int i3 = 1;
        do {
            int i4 = sVar.f5803c;
            for (int i5 = sVar.f5802b; i5 < i4; i5++) {
                i3 = (i3 * 31) + sVar.f5801a[i5];
            }
            sVar = sVar.f5806f;
            sVar.getClass();
        } while (sVar != this.f5776c);
        return i3;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // w2.j
    public final int k(p pVar) {
        pVar.getClass();
        int iB = x2.a.b(this, pVar, false);
        if (iB == -1) {
            return -1;
        }
        skip(pVar.f5793c[iB].c());
        return iB;
    }

    @Override // w2.j
    public final String n() {
        return g(Long.MAX_VALUE);
    }

    @Override // w2.j
    public final void p(long j3) throws EOFException {
        if (this.f5777d < j3) {
            throw new EOFException();
        }
    }

    @Override // w2.i
    public final /* bridge */ /* synthetic */ i q(String str) {
        O(str);
        return this;
    }

    public final int read(byte[] bArr, int i3, int i4) {
        bArr.getClass();
        b.c(bArr.length, i3, i4);
        s sVar = this.f5776c;
        if (sVar == null) {
            return -1;
        }
        int iMin = Math.min(i4, sVar.f5803c - sVar.f5802b);
        byte[] bArr2 = sVar.f5801a;
        int i5 = sVar.f5802b;
        i1.h.s(bArr2, bArr, i3, i5, i5 + iMin);
        int i6 = sVar.f5802b + iMin;
        sVar.f5802b = i6;
        this.f5777d -= (long) iMin;
        if (i6 == sVar.f5803c) {
            this.f5776c = sVar.a();
            t.a(sVar);
        }
        return iMin;
    }

    @Override // w2.j
    public final byte readByte() {
        if (this.f5777d == 0) {
            throw new EOFException();
        }
        s sVar = this.f5776c;
        sVar.getClass();
        int i3 = sVar.f5802b;
        int i4 = sVar.f5803c;
        int i5 = i3 + 1;
        byte b3 = sVar.f5801a[i3];
        this.f5777d--;
        if (i5 != i4) {
            sVar.f5802b = i5;
            return b3;
        }
        this.f5776c = sVar.a();
        t.a(sVar);
        return b3;
    }

    @Override // w2.j
    public final void readFully(byte[] bArr) {
        bArr.getClass();
        int i3 = 0;
        while (i3 < bArr.length) {
            int i4 = read(bArr, i3, bArr.length - i3);
            if (i4 == -1) {
                throw new EOFException();
            }
            i3 += i4;
        }
    }

    @Override // w2.j
    public final int readInt() {
        if (this.f5777d < 4) {
            throw new EOFException();
        }
        s sVar = this.f5776c;
        sVar.getClass();
        int i3 = sVar.f5802b;
        int i4 = sVar.f5803c;
        if (i4 - i3 < 4) {
            return (readByte() & 255) | ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8);
        }
        byte[] bArr = sVar.f5801a;
        int i5 = i3 + 3;
        int i6 = ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3] & 255) << 24) | ((bArr[i3 + 2] & 255) << 8);
        int i7 = i3 + 4;
        int i8 = (bArr[i5] & 255) | i6;
        this.f5777d -= 4;
        if (i7 != i4) {
            sVar.f5802b = i7;
            return i8;
        }
        this.f5776c = sVar.a();
        t.a(sVar);
        return i8;
    }

    @Override // w2.j
    public final long readLong() throws EOFException {
        if (this.f5777d < 8) {
            throw new EOFException();
        }
        s sVar = this.f5776c;
        sVar.getClass();
        int i3 = sVar.f5802b;
        int i4 = sVar.f5803c;
        if (i4 - i3 < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = sVar.f5801a;
        int i5 = i3 + 7;
        long j3 = ((((long) bArr[i3]) & 255) << 56) | ((((long) bArr[i3 + 1]) & 255) << 48) | ((((long) bArr[i3 + 2]) & 255) << 40) | ((((long) bArr[i3 + 3]) & 255) << 32) | ((((long) bArr[i3 + 4]) & 255) << 24) | ((((long) bArr[i3 + 5]) & 255) << 16) | ((((long) bArr[i3 + 6]) & 255) << 8);
        int i6 = i3 + 8;
        long j4 = j3 | (((long) bArr[i5]) & 255);
        this.f5777d -= 8;
        if (i6 != i4) {
            sVar.f5802b = i6;
            return j4;
        }
        this.f5776c = sVar.a();
        t.a(sVar);
        return j4;
    }

    @Override // w2.j
    public final short readShort() throws EOFException {
        if (this.f5777d < 2) {
            throw new EOFException();
        }
        s sVar = this.f5776c;
        sVar.getClass();
        int i3 = sVar.f5802b;
        int i4 = sVar.f5803c;
        if (i4 - i3 < 2) {
            return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
        }
        byte[] bArr = sVar.f5801a;
        int i5 = i3 + 1;
        int i6 = (bArr[i3] & 255) << 8;
        int i7 = i3 + 2;
        int i8 = (bArr[i5] & 255) | i6;
        this.f5777d -= 2;
        if (i7 == i4) {
            this.f5776c = sVar.a();
            t.a(sVar);
        } else {
            sVar.f5802b = i7;
        }
        return (short) i8;
    }

    @Override // w2.j
    public final void skip(long j3) {
        while (j3 > 0) {
            s sVar = this.f5776c;
            if (sVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j3, sVar.f5803c - sVar.f5802b);
            long j4 = iMin;
            this.f5777d -= j4;
            j3 -= j4;
            int i3 = sVar.f5802b + iMin;
            sVar.f5802b = i3;
            if (i3 == sVar.f5803c) {
                this.f5776c = sVar.a();
                t.a(sVar);
            }
        }
    }

    @Override // w2.v
    public final void t(long j3, h hVar) {
        s sVarB;
        hVar.getClass();
        if (hVar == this) {
            o2.i("source == this");
            return;
        }
        b.c(hVar.f5777d, 0L, j3);
        while (j3 > 0) {
            s sVar = hVar.f5776c;
            sVar.getClass();
            int i3 = sVar.f5803c;
            s sVar2 = hVar.f5776c;
            sVar2.getClass();
            long j4 = i3 - sVar2.f5802b;
            int i4 = 0;
            if (j3 < j4) {
                s sVar3 = this.f5776c;
                s sVar4 = sVar3 != null ? sVar3.f5807g : null;
                if (sVar4 != null && sVar4.f5805e) {
                    if ((((long) sVar4.f5803c) + j3) - ((long) (sVar4.f5804d ? 0 : sVar4.f5802b)) <= 8192) {
                        s sVar5 = hVar.f5776c;
                        sVar5.getClass();
                        sVar5.d(sVar4, (int) j3);
                        hVar.f5777d -= j3;
                        this.f5777d += j3;
                        return;
                    }
                }
                s sVar6 = hVar.f5776c;
                sVar6.getClass();
                int i5 = (int) j3;
                if (i5 <= 0 || i5 > sVar6.f5803c - sVar6.f5802b) {
                    o2.i("byteCount out of range");
                    return;
                }
                if (i5 >= 1024) {
                    sVarB = sVar6.c();
                } else {
                    sVarB = t.b();
                    byte[] bArr = sVar6.f5801a;
                    byte[] bArr2 = sVarB.f5801a;
                    int i6 = sVar6.f5802b;
                    i1.h.s(bArr, bArr2, 0, i6, i6 + i5);
                }
                sVarB.f5803c = sVarB.f5802b + i5;
                sVar6.f5802b += i5;
                s sVar7 = sVar6.f5807g;
                sVar7.getClass();
                sVar7.b(sVarB);
                hVar.f5776c = sVarB;
            }
            s sVar8 = hVar.f5776c;
            sVar8.getClass();
            long j5 = sVar8.f5803c - sVar8.f5802b;
            hVar.f5776c = sVar8.a();
            s sVar9 = this.f5776c;
            if (sVar9 == null) {
                this.f5776c = sVar8;
                sVar8.f5807g = sVar8;
                sVar8.f5806f = sVar8;
            } else {
                s sVar10 = sVar9.f5807g;
                sVar10.getClass();
                sVar10.b(sVar8);
                s sVar11 = sVar8.f5807g;
                if (sVar11 == sVar8) {
                    o2.k("cannot compact");
                    return;
                }
                sVar11.getClass();
                if (sVar11.f5805e) {
                    int i7 = sVar8.f5803c - sVar8.f5802b;
                    s sVar12 = sVar8.f5807g;
                    sVar12.getClass();
                    int i8 = 8192 - sVar12.f5803c;
                    s sVar13 = sVar8.f5807g;
                    sVar13.getClass();
                    if (!sVar13.f5804d) {
                        s sVar14 = sVar8.f5807g;
                        sVar14.getClass();
                        i4 = sVar14.f5802b;
                    }
                    if (i7 <= i8 + i4) {
                        s sVar15 = sVar8.f5807g;
                        sVar15.getClass();
                        sVar8.d(sVar15, i7);
                        sVar8.a();
                        t.a(sVar8);
                    }
                }
            }
            hVar.f5777d -= j5;
            this.f5777d += j5;
            j3 -= j5;
        }
    }

    public final String toString() {
        long j3 = this.f5777d;
        if (j3 <= 2147483647L) {
            return E((int) j3).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f5777d).toString());
    }

    @Override // w2.j
    public final long u() throws EOFException {
        int i3;
        if (this.f5777d == 0) {
            throw new EOFException();
        }
        int i4 = 0;
        boolean z2 = false;
        long j3 = 0;
        do {
            s sVar = this.f5776c;
            sVar.getClass();
            byte[] bArr = sVar.f5801a;
            int i5 = sVar.f5802b;
            int i6 = sVar.f5803c;
            while (i5 < i6) {
                byte b3 = bArr[i5];
                if (b3 >= 48 && b3 <= 57) {
                    i3 = b3 - 48;
                } else if (b3 >= 97 && b3 <= 102) {
                    i3 = b3 - 87;
                } else {
                    if (b3 < 65 || b3 > 70) {
                        z2 = true;
                        if (i4 != 0) {
                            break;
                        }
                        char[] cArr = x2.b.f5967a;
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(new String(new char[]{cArr[(b3 >> 4) & 15], cArr[b3 & 15]})));
                    }
                    i3 = b3 - 55;
                }
                if (((-1152921504606846976L) & j3) != 0) {
                    h hVar = new h();
                    hVar.K(j3);
                    hVar.J(b3);
                    throw new NumberFormatException("Number too large: ".concat(hVar.D()));
                }
                j3 = (j3 << 4) | ((long) i3);
                i5++;
                i4++;
            }
            if (i5 == i6) {
                this.f5776c = sVar.a();
                t.a(sVar);
            } else {
                sVar.f5802b = i5;
            }
            if (z2) {
                break;
            }
        } while (this.f5776c != null);
        this.f5777d -= (long) i4;
        return j3;
    }

    @Override // w2.j
    public final String v(Charset charset) {
        return C(this.f5777d, charset);
    }

    public final boolean w() {
        return this.f5777d == 0;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        int iRemaining = byteBuffer.remaining();
        int i3 = iRemaining;
        while (i3 > 0) {
            s sVarF = F(1);
            int iMin = Math.min(i3, 8192 - sVarF.f5803c);
            byteBuffer.get(sVarF.f5801a, sVarF.f5803c, iMin);
            i3 -= iMin;
            sVarF.f5803c += iMin;
        }
        this.f5777d += (long) iRemaining;
        return iRemaining;
    }

    @Override // w2.i
    public final /* bridge */ /* synthetic */ i writeByte(int i3) {
        J(i3);
        return this;
    }

    @Override // w2.i
    public final /* bridge */ /* synthetic */ i writeInt(int i3) {
        L(i3);
        return this;
    }

    @Override // w2.i
    public final /* bridge */ /* synthetic */ i writeShort(int i3) {
        M(i3);
        return this;
    }

    @Override // w2.i
    public final /* bridge */ /* synthetic */ i x(k kVar) {
        H(kVar);
        return this;
    }

    public final byte y(long j3) {
        b.c(this.f5777d, j3, 1L);
        s sVar = this.f5776c;
        sVar.getClass();
        long j4 = this.f5777d;
        if (j4 - j3 < j3) {
            while (j4 > j3) {
                sVar = sVar.f5807g;
                sVar.getClass();
                j4 -= (long) (sVar.f5803c - sVar.f5802b);
            }
            return sVar.f5801a[(int) ((((long) sVar.f5802b) + j3) - j4)];
        }
        long j5 = 0;
        while (true) {
            int i3 = sVar.f5803c;
            int i4 = sVar.f5802b;
            long j6 = ((long) (i3 - i4)) + j5;
            if (j6 > j3) {
                return sVar.f5801a[(int) ((((long) i4) + j3) - j5)];
            }
            sVar = sVar.f5806f;
            sVar.getClass();
            j5 = j6;
        }
    }

    public final long z(byte b3, long j3, long j4) {
        s sVar;
        long j5 = 0;
        if (0 > j3 || j3 > j4) {
            StringBuilder sb = new StringBuilder("size=");
            sb.append(this.f5777d);
            j4.d(sb, " fromIndex=", j3, " toIndex=");
            sb.append(j4);
            throw new IllegalArgumentException(sb.toString().toString());
        }
        long j6 = this.f5777d;
        if (j4 > j6) {
            j4 = j6;
        }
        if (j3 == j4 || (sVar = this.f5776c) == null) {
            return -1L;
        }
        if (j6 - j3 < j3) {
            while (j6 > j3) {
                sVar = sVar.f5807g;
                sVar.getClass();
                j6 -= (long) (sVar.f5803c - sVar.f5802b);
            }
            while (j6 < j4) {
                byte[] bArr = sVar.f5801a;
                int iMin = (int) Math.min(sVar.f5803c, (((long) sVar.f5802b) + j4) - j6);
                for (int i3 = (int) ((((long) sVar.f5802b) + j3) - j6); i3 < iMin; i3++) {
                    if (bArr[i3] == b3) {
                        return ((long) (i3 - sVar.f5802b)) + j6;
                    }
                }
                j6 += (long) (sVar.f5803c - sVar.f5802b);
                sVar = sVar.f5806f;
                sVar.getClass();
                j3 = j6;
            }
            return -1L;
        }
        while (true) {
            long j7 = ((long) (sVar.f5803c - sVar.f5802b)) + j5;
            if (j7 > j3) {
                break;
            }
            sVar = sVar.f5806f;
            sVar.getClass();
            j5 = j7;
        }
        while (j5 < j4) {
            byte[] bArr2 = sVar.f5801a;
            int iMin2 = (int) Math.min(sVar.f5803c, (((long) sVar.f5802b) + j4) - j5);
            for (int i4 = (int) ((((long) sVar.f5802b) + j3) - j5); i4 < iMin2; i4++) {
                if (bArr2[i4] == b3) {
                    return ((long) (i4 - sVar.f5802b)) + j5;
                }
            }
            j5 += (long) (sVar.f5803c - sVar.f5802b);
            sVar = sVar.f5806f;
            sVar.getClass();
            j3 = j5;
        }
        return -1L;
    }

    @Override // w2.i
    public final i write(byte[] bArr) {
        G(bArr.length, bArr);
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        s sVar = this.f5776c;
        if (sVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), sVar.f5803c - sVar.f5802b);
        byteBuffer.put(sVar.f5801a, sVar.f5802b, iMin);
        int i3 = sVar.f5802b + iMin;
        sVar.f5802b = i3;
        this.f5777d -= (long) iMin;
        if (i3 == sVar.f5803c) {
            this.f5776c = sVar.a();
            t.a(sVar);
        }
        return iMin;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, w2.v
    public final void close() {
    }

    @Override // w2.i, w2.v, java.io.Flushable
    public final void flush() {
    }

    @Override // w2.i
    public final i i() {
        return this;
    }

    @Override // w2.i
    public final h s() {
        return this;
    }
}
