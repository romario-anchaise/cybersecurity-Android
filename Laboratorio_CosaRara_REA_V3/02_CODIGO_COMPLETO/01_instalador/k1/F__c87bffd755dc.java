// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class F extends C0196l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient byte[][] f3453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient int[] f3454f;

    public F(byte[][] bArr, int[] iArr) {
        super(C0196l.f3483d.f3484a);
        this.f3453e = bArr;
        this.f3454f = iArr;
    }

    @Override // k1.C0196l
    public final C0196l b(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[][] bArr = this.f3453e;
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr = this.f3454f;
            int i4 = iArr[length + i2];
            int i5 = iArr[i2];
            messageDigest.update(bArr[i2], i4, i5 - i3);
            i2++;
            i3 = i5;
        }
        byte[] bArrDigest = messageDigest.digest();
        F0.i.b(bArrDigest);
        return new C0196l(bArrDigest);
    }

    @Override // k1.C0196l
    public final int c() {
        return this.f3454f[this.f3453e.length - 1];
    }

    @Override // k1.C0196l
    public final String d() {
        return s().d();
    }

    @Override // k1.C0196l
    public final int e(byte[] bArr, int i2) {
        F0.i.e(bArr, "other");
        return s().e(bArr, i2);
    }

    @Override // k1.C0196l
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0196l) {
            C0196l c0196l = (C0196l) obj;
            if (c0196l.c() == c() && k(0, c0196l, c())) {
                return true;
            }
        }
        return false;
    }

    @Override // k1.C0196l
    public final byte[] g() {
        return r();
    }

    @Override // k1.C0196l
    public final byte h(int i2) {
        byte[][] bArr = this.f3453e;
        int length = bArr.length - 1;
        int[] iArr = this.f3454f;
        f1.d.g(iArr[length], i2, 1L);
        int iG = l1.b.g(this, i2);
        return bArr[iG][(i2 - (iG == 0 ? 0 : iArr[iG - 1])) + iArr[bArr.length + iG]];
    }

    @Override // k1.C0196l
    public final int hashCode() {
        int i2 = this.f3485b;
        if (i2 != 0) {
            return i2;
        }
        byte[][] bArr = this.f3453e;
        int length = bArr.length;
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        while (i3 < length) {
            int[] iArr = this.f3454f;
            int i6 = iArr[length + i3];
            int i7 = iArr[i3];
            byte[] bArr2 = bArr[i3];
            int i8 = (i7 - i5) + i6;
            while (i6 < i8) {
                i4 = (i4 * 31) + bArr2[i6];
                i6++;
            }
            i3++;
            i5 = i7;
        }
        this.f3485b = i4;
        return i4;
    }

    @Override // k1.C0196l
    public final int i(byte[] bArr, int i2) {
        F0.i.e(bArr, "other");
        return s().i(bArr, i2);
    }

    @Override // k1.C0196l
    public final boolean k(int i2, C0196l c0196l, int i3) {
        F0.i.e(c0196l, "other");
        if (i2 < 0 || i2 > c() - i3) {
            return false;
        }
        int i4 = i3 + i2;
        int iG = l1.b.g(this, i2);
        int i5 = 0;
        while (i2 < i4) {
            int[] iArr = this.f3454f;
            int i6 = iG == 0 ? 0 : iArr[iG - 1];
            int i7 = iArr[iG] - i6;
            byte[][] bArr = this.f3453e;
            int i8 = iArr[bArr.length + iG];
            int iMin = Math.min(i4, i7 + i6) - i2;
            if (!c0196l.l(i5, bArr[iG], (i2 - i6) + i8, iMin)) {
                return false;
            }
            i5 += iMin;
            i2 += iMin;
            iG++;
        }
        return true;
    }

    @Override // k1.C0196l
    public final boolean l(int i2, byte[] bArr, int i3, int i4) {
        F0.i.e(bArr, "other");
        if (i2 < 0 || i2 > c() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int i5 = i4 + i2;
        int iG = l1.b.g(this, i2);
        while (i2 < i5) {
            int[] iArr = this.f3454f;
            int i6 = iG == 0 ? 0 : iArr[iG - 1];
            int i7 = iArr[iG] - i6;
            byte[][] bArr2 = this.f3453e;
            int i8 = iArr[bArr2.length + iG];
            int iMin = Math.min(i5, i7 + i6) - i2;
            if (!f1.d.c((i2 - i6) + i8, i3, iMin, bArr2[iG], bArr)) {
                return false;
            }
            i3 += iMin;
            i2 += iMin;
            iG++;
        }
        return true;
    }

    @Override // k1.C0196l
    public final C0196l m(int i2, int i3) {
        if (i3 == -1234567890) {
            i3 = c();
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(("beginIndex=" + i2 + " < 0").toString());
        }
        if (i3 > c()) {
            throw new IllegalArgumentException(("endIndex=" + i3 + " > length(" + c() + ')').toString());
        }
        int i4 = i3 - i2;
        if (i4 < 0) {
            throw new IllegalArgumentException(("endIndex=" + i3 + " < beginIndex=" + i2).toString());
        }
        if (i2 == 0 && i3 == c()) {
            return this;
        }
        if (i2 == i3) {
            return C0196l.f3483d;
        }
        int iG = l1.b.g(this, i2);
        int iG2 = l1.b.g(this, i3 - 1);
        int i5 = iG2 + 1;
        byte[][] bArr = this.f3453e;
        F0.i.e(bArr, "<this>");
        p028p0.a.d(i5, bArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(bArr, iG, i5);
        F0.i.d(objArrCopyOfRange, "copyOfRange(...)");
        byte[][] bArr2 = (byte[][]) objArrCopyOfRange;
        int[] iArr = new int[bArr2.length * 2];
        int[] iArr2 = this.f3454f;
        if (iG <= iG2) {
            int i6 = iG;
            int i7 = 0;
            while (true) {
                iArr[i7] = Math.min(iArr2[i6] - i2, i4);
                int i8 = i7 + 1;
                iArr[i7 + bArr2.length] = iArr2[bArr.length + i6];
                if (i6 == iG2) {
                    break;
                }
                i6++;
                i7 = i8;
            }
        }
        int i9 = iG != 0 ? iArr2[iG - 1] : 0;
        int length = bArr2.length;
        iArr[length] = (i2 - i9) + iArr[length];
        return new F(bArr2, iArr);
    }

    @Override // k1.C0196l
    public final C0196l o() {
        return s().o();
    }

    @Override // k1.C0196l
    public final void q(C0193i c0193i, int i2) {
        F0.i.e(c0193i, "buffer");
        int iG = l1.b.g(this, 0);
        int i3 = 0;
        while (i3 < i2) {
            int[] iArr = this.f3454f;
            int i4 = iG == 0 ? 0 : iArr[iG - 1];
            int i5 = iArr[iG] - i4;
            byte[][] bArr = this.f3453e;
            int i6 = iArr[bArr.length + iG];
            int iMin = Math.min(i2, i5 + i4) - i3;
            int i7 = (i3 - i4) + i6;
            D d2 = new D(bArr[iG], i7, i7 + iMin, true);
            D d3 = c0193i.f3481a;
            if (d3 == null) {
                d2.g = d2;
                d2.f3449f = d2;
                c0193i.f3481a = d2;
            } else {
                D d4 = d3.g;
                F0.i.b(d4);
                d4.b(d2);
            }
            i3 += iMin;
            iG++;
        }
        c0193i.f3482b += (long) i2;
    }

    public final byte[] r() {
        byte[] bArr = new byte[c()];
        byte[][] bArr2 = this.f3453e;
        int length = bArr2.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int[] iArr = this.f3454f;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = i6 - i3;
            p036u0.e.r(i4, i5, i5 + i7, bArr2[i2], bArr);
            i4 += i7;
            i2++;
            i3 = i6;
        }
        return bArr;
    }

    public final C0196l s() {
        return new C0196l(r());
    }

    @Override // k1.C0196l
    public final String toString() {
        return s().toString();
    }
}
