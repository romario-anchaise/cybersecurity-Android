// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p2;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w2.h f2893a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2895c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2899g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2900h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2894b = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2896d = 4096;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b[] f2897e = new b[8];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2898f = 7;

    public d(w2.h hVar) {
        this.f2893a = hVar;
    }

    public final void a(int i3) {
        int i4;
        if (i3 > 0) {
            int length = this.f2897e.length - 1;
            int i5 = 0;
            while (true) {
                i4 = this.f2898f;
                if (length < i4 || i3 <= 0) {
                    break;
                }
                b bVar = this.f2897e[length];
                bVar.getClass();
                i3 -= bVar.f2884c;
                int i6 = this.f2900h;
                b bVar2 = this.f2897e[length];
                bVar2.getClass();
                this.f2900h = i6 - bVar2.f2884c;
                this.f2899g--;
                i5++;
                length--;
            }
            b[] bVarArr = this.f2897e;
            int i7 = i4 + 1;
            System.arraycopy(bVarArr, i7, bVarArr, i7 + i5, this.f2899g);
            b[] bVarArr2 = this.f2897e;
            int i8 = this.f2898f + 1;
            Arrays.fill(bVarArr2, i8, i8 + i5, (Object) null);
            this.f2898f += i5;
        }
    }

    public final void b(b bVar) {
        int i3 = bVar.f2884c;
        int i4 = this.f2896d;
        if (i3 > i4) {
            b[] bVarArr = this.f2897e;
            Arrays.fill(bVarArr, 0, bVarArr.length, (Object) null);
            this.f2898f = this.f2897e.length - 1;
            this.f2899g = 0;
            this.f2900h = 0;
            return;
        }
        a((this.f2900h + i3) - i4);
        int i5 = this.f2899g + 1;
        b[] bVarArr2 = this.f2897e;
        if (i5 > bVarArr2.length) {
            b[] bVarArr3 = new b[bVarArr2.length * 2];
            System.arraycopy(bVarArr2, 0, bVarArr3, bVarArr2.length, bVarArr2.length);
            this.f2898f = this.f2897e.length - 1;
            this.f2897e = bVarArr3;
        }
        int i6 = this.f2898f;
        this.f2898f = i6 - 1;
        this.f2897e[i6] = bVar;
        this.f2899g++;
        this.f2900h += i3;
    }

    public final void c(w2.k kVar) throws EOFException {
        kVar.getClass();
        int[] iArr = y.f2999a;
        int iC = kVar.c();
        long j3 = 0;
        long j4 = 0;
        for (int i3 = 0; i3 < iC; i3++) {
            byte bF = kVar.f(i3);
            byte[] bArr = j2.b.f2361a;
            j4 += (long) y.f3000b[bF & 255];
        }
        int i4 = (int) ((j4 + ((long) 7)) >> 3);
        int iC2 = kVar.c();
        w2.h hVar = this.f2893a;
        if (i4 >= iC2) {
            e(kVar.c(), 127, 0);
            hVar.H(kVar);
            return;
        }
        w2.h hVar2 = new w2.h();
        int[] iArr2 = y.f2999a;
        int iC3 = kVar.c();
        int i5 = 0;
        for (int i6 = 0; i6 < iC3; i6++) {
            byte bF2 = kVar.f(i6);
            byte[] bArr2 = j2.b.f2361a;
            int i7 = bF2 & 255;
            int i8 = y.f2999a[i7];
            byte b3 = y.f3000b[i7];
            j3 = (j3 << b3) | ((long) i8);
            i5 += b3;
            while (i5 >= 8) {
                i5 -= 8;
                hVar2.J((int) (j3 >> i5));
            }
        }
        if (i5 > 0) {
            hVar2.J((int) ((j3 << (8 - i5)) | (255 >>> i5)));
        }
        w2.k kVarE = hVar2.e(hVar2.f5777d);
        e(kVarE.c(), 127, 128);
        hVar.H(kVarE);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0069  */
    public final void d(ArrayList arrayList) throws EOFException {
        int length;
        int length2;
        if (this.f2895c) {
            int i3 = this.f2894b;
            if (i3 < this.f2896d) {
                e(i3, 31, 32);
            }
            this.f2895c = false;
            this.f2894b = Integer.MAX_VALUE;
            e(this.f2896d, 31, 32);
        }
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            b bVar = (b) arrayList.get(i4);
            w2.k kVarI = bVar.f2882a.i();
            w2.k kVar = bVar.f2883b;
            Integer num = (Integer) e.f2902b.get(kVarI);
            if (num != null) {
                int iIntValue = num.intValue();
                length2 = iIntValue + 1;
                if (2 > length2 || length2 >= 8) {
                    length = length2;
                    length2 = -1;
                } else {
                    b[] bVarArr = e.f2901a;
                    if (q1.e.a(bVarArr[iIntValue].f2883b, kVar)) {
                        length = length2;
                    } else if (q1.e.a(bVarArr[length2].f2883b, kVar)) {
                        length2 = iIntValue + 2;
                        length = length2;
                    } else {
                        length = length2;
                        length2 = -1;
                    }
                }
            } else {
                length = -1;
                length2 = -1;
            }
            if (length2 == -1) {
                int length3 = this.f2897e.length;
                for (int i5 = this.f2898f + 1; i5 < length3; i5++) {
                    b bVar2 = this.f2897e[i5];
                    bVar2.getClass();
                    if (q1.e.a(bVar2.f2882a, kVarI)) {
                        b bVar3 = this.f2897e[i5];
                        bVar3.getClass();
                        if (q1.e.a(bVar3.f2883b, kVar)) {
                            length2 = e.f2901a.length + (i5 - this.f2898f);
                            break;
                        } else if (length == -1) {
                            length = (i5 - this.f2898f) + e.f2901a.length;
                        }
                    }
                }
            }
            if (length2 != -1) {
                e(length2, 127, 128);
            } else if (length == -1) {
                this.f2893a.J(64);
                c(kVarI);
                c(kVar);
                b(bVar);
            } else {
                w2.k kVar2 = b.f2876d;
                kVarI.getClass();
                kVar2.getClass();
                if (!kVarI.g(kVar2.c(), kVar2) || q1.e.a(b.f2881i, kVarI)) {
                    e(length, 63, 64);
                    c(kVar);
                    b(bVar);
                } else {
                    e(length, 15, 0);
                    c(kVar);
                }
            }
        }
    }

    public final void e(int i3, int i4, int i5) {
        w2.h hVar = this.f2893a;
        if (i3 < i4) {
            hVar.J(i3 | i5);
            return;
        }
        hVar.J(i5 | i4);
        int i6 = i3 - i4;
        while (i6 >= 128) {
            hVar.J(128 | (i6 & 127));
            i6 >>>= 7;
        }
        hVar.J(i6);
    }
}
