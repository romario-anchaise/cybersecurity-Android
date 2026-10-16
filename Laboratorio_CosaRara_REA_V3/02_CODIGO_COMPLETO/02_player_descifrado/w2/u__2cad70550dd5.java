// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends k {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final transient byte[][] f5811g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final transient int[] f5812h;

    public u(byte[][] bArr, int[] iArr) {
        super(k.f5778f.f5779c);
        this.f5811g = bArr;
        this.f5812h = iArr;
    }

    @Override // w2.k
    public final String a() {
        throw null;
    }

    @Override // w2.k
    public final k b(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[][] bArr = this.f5811g;
        int length = bArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int[] iArr = this.f5812h;
            int i5 = iArr[length + i3];
            int i6 = iArr[i3];
            messageDigest.update(bArr[i3], i5, i6 - i4);
            i3++;
            i4 = i6;
        }
        byte[] bArrDigest = messageDigest.digest();
        bArrDigest.getClass();
        return new k(bArrDigest);
    }

    @Override // w2.k
    public final int c() {
        return this.f5812h[this.f5811g.length - 1];
    }

    @Override // w2.k
    public final String d() {
        return new k(j()).d();
    }

    @Override // w2.k
    public final byte[] e() {
        return j();
    }

    @Override // w2.k
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return kVar.c() == c() && g(c(), kVar);
    }

    @Override // w2.k
    public final byte f(int i3) {
        byte[][] bArr = this.f5811g;
        int length = bArr.length - 1;
        int[] iArr = this.f5812h;
        b.c(iArr[length], i3, 1L);
        int iB = x2.b.b(this, i3);
        return bArr[iB][(i3 - (iB == 0 ? 0 : iArr[iB - 1])) + iArr[bArr.length + iB]];
    }

    @Override // w2.k
    public final boolean g(int i3, k kVar) {
        kVar.getClass();
        if (c() - i3 >= 0) {
            int iB = x2.b.b(this, 0);
            int i4 = 0;
            int i5 = 0;
            while (i4 < i3) {
                int[] iArr = this.f5812h;
                int i6 = iB == 0 ? 0 : iArr[iB - 1];
                int i7 = iArr[iB] - i6;
                byte[][] bArr = this.f5811g;
                int i8 = iArr[bArr.length + iB];
                int iMin = Math.min(i3, i7 + i6) - i4;
                if (kVar.h(i5, bArr[iB], (i4 - i6) + i8, iMin)) {
                    i5 += iMin;
                    i4 += iMin;
                    iB++;
                }
            }
            return true;
        }
        return false;
    }

    @Override // w2.k
    public final boolean h(int i3, byte[] bArr, int i4, int i5) {
        bArr.getClass();
        if (i3 >= 0 && i3 <= c() - i5 && i4 >= 0 && i4 <= bArr.length - i5) {
            int i6 = i5 + i3;
            int iB = x2.b.b(this, i3);
            while (i3 < i6) {
                int[] iArr = this.f5812h;
                int i7 = iB == 0 ? 0 : iArr[iB - 1];
                int i8 = iArr[iB] - i7;
                byte[][] bArr2 = this.f5811g;
                int i9 = iArr[bArr2.length + iB];
                int iMin = Math.min(i6, i8 + i7) - i3;
                int i10 = (i3 - i7) + i9;
                byte[] bArr3 = bArr2[iB];
                bArr3.getClass();
                for (int i11 = 0; i11 < iMin; i11++) {
                    if (bArr3[i11 + i10] == bArr[i11 + i4]) {
                    }
                }
                i4 += iMin;
                i3 += iMin;
                iB++;
            }
            return true;
        }
        return false;
    }

    @Override // w2.k
    public final int hashCode() {
        int i3 = this.f5780d;
        if (i3 != 0) {
            return i3;
        }
        byte[][] bArr = this.f5811g;
        int length = bArr.length;
        int i4 = 0;
        int i5 = 1;
        int i6 = 0;
        while (i4 < length) {
            int[] iArr = this.f5812h;
            int i7 = iArr[length + i4];
            int i8 = iArr[i4];
            byte[] bArr2 = bArr[i4];
            int i9 = (i8 - i6) + i7;
            while (i7 < i9) {
                i5 = (i5 * 31) + bArr2[i7];
                i7++;
            }
            i4++;
            i6 = i8;
        }
        this.f5780d = i5;
        return i5;
    }

    @Override // w2.k
    public final k i() {
        return new k(j()).i();
    }

    @Override // w2.k
    public final byte[] j() {
        byte[] bArr = new byte[c()];
        byte[][] bArr2 = this.f5811g;
        int length = bArr2.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < length) {
            int[] iArr = this.f5812h;
            int i6 = iArr[length + i3];
            int i7 = iArr[i3];
            int i8 = i7 - i4;
            i1.h.s(bArr2[i3], bArr, i5, i6, i6 + i8);
            i5 += i8;
            i3++;
            i4 = i7;
        }
        return bArr;
    }

    @Override // w2.k
    public final void l(h hVar, int i3) {
        int iB = x2.b.b(this, 0);
        int i4 = 0;
        while (i4 < i3) {
            int[] iArr = this.f5812h;
            int i5 = iB == 0 ? 0 : iArr[iB - 1];
            int i6 = iArr[iB] - i5;
            byte[][] bArr = this.f5811g;
            int i7 = iArr[bArr.length + iB];
            int iMin = Math.min(i3, i6 + i5) - i4;
            int i8 = (i4 - i5) + i7;
            s sVar = new s(bArr[iB], i8, i8 + iMin, true, false);
            s sVar2 = hVar.f5776c;
            if (sVar2 == null) {
                sVar.f5807g = sVar;
                sVar.f5806f = sVar;
                hVar.f5776c = sVar;
            } else {
                s sVar3 = sVar2.f5807g;
                sVar3.getClass();
                sVar3.b(sVar);
            }
            i4 += iMin;
            iB++;
        }
        hVar.f5777d += (long) i3;
    }

    @Override // w2.k
    public final String toString() {
        return new k(j()).toString();
    }
}
