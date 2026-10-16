// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import k1.C0193i;
import k1.C0196l;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0193i f2291b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2293d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2296h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2297i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2290a = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2292c = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2294e = 4096;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C0109b[] f2295f = new C0109b[8];
    public int g = 7;

    public d(C0193i c0193i) {
        this.f2291b = c0193i;
    }

    public final void a(int i2) {
        int i3;
        if (i2 > 0) {
            int length = this.f2295f.length - 1;
            int i4 = 0;
            while (true) {
                i3 = this.g;
                if (length < i3 || i2 <= 0) {
                    break;
                }
                C0109b c0109b = this.f2295f[length];
                F0.i.b(c0109b);
                i2 -= c0109b.f2283c;
                int i5 = this.f2297i;
                C0109b c0109b2 = this.f2295f[length];
                F0.i.b(c0109b2);
                this.f2297i = i5 - c0109b2.f2283c;
                this.f2296h--;
                i4++;
                length--;
            }
            C0109b[] c0109bArr = this.f2295f;
            int i6 = i3 + 1;
            System.arraycopy(c0109bArr, i6, c0109bArr, i6 + i4, this.f2296h);
            C0109b[] c0109bArr2 = this.f2295f;
            int i7 = this.g + 1;
            Arrays.fill(c0109bArr2, i7, i7 + i4, (Object) null);
            this.g += i4;
        }
    }

    public final void b(C0109b c0109b) {
        int i2 = this.f2294e;
        int i3 = c0109b.f2283c;
        if (i3 > i2) {
            C0109b[] c0109bArr = this.f2295f;
            p036u0.e.w(c0109bArr, 0, c0109bArr.length);
            this.g = this.f2295f.length - 1;
            this.f2296h = 0;
            this.f2297i = 0;
            return;
        }
        a((this.f2297i + i3) - i2);
        int i4 = this.f2296h + 1;
        C0109b[] c0109bArr2 = this.f2295f;
        if (i4 > c0109bArr2.length) {
            C0109b[] c0109bArr3 = new C0109b[c0109bArr2.length * 2];
            System.arraycopy(c0109bArr2, 0, c0109bArr3, c0109bArr2.length, c0109bArr2.length);
            this.g = this.f2295f.length - 1;
            this.f2295f = c0109bArr3;
        }
        int i5 = this.g;
        this.g = i5 - 1;
        this.f2295f[i5] = c0109b;
        this.f2296h++;
        this.f2297i += i3;
    }

    public final void c(C0196l c0196l) throws EOFException {
        F0.i.e(c0196l, "data");
        C0193i c0193i = this.f2291b;
        if (this.f2290a) {
            int[] iArr = z.f2394a;
            int iC = c0196l.c();
            long j2 = 0;
            for (int i2 = 0; i2 < iC; i2++) {
                byte bH = c0196l.h(i2);
                byte[] bArr = Y0.b.f1119a;
                j2 += (long) z.f2395b[bH & 255];
            }
            if (((int) ((j2 + ((long) 7)) >> 3)) < c0196l.c()) {
                C0193i c0193i2 = new C0193i();
                int[] iArr2 = z.f2394a;
                int iC2 = c0196l.c();
                long j3 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < iC2; i4++) {
                    byte bH2 = c0196l.h(i4);
                    byte[] bArr2 = Y0.b.f1119a;
                    int i5 = bH2 & 255;
                    int i6 = z.f2394a[i5];
                    byte b2 = z.f2395b[i5];
                    j3 = (j3 << b2) | ((long) i6);
                    i3 += b2;
                    while (i3 >= 8) {
                        i3 -= 8;
                        c0193i2.Q((int) (j3 >> i3));
                    }
                }
                if (i3 > 0) {
                    c0193i2.Q((int) ((255 >>> i3) | (j3 << (8 - i3))));
                }
                C0196l c0196lD = c0193i2.D(c0193i2.f3482b);
                e(c0196lD.c(), 127, 128);
                c0193i.N(c0196lD);
                return;
            }
        }
        e(c0196l.c(), 127, 0);
        c0193i.N(c0196l);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0069  */
    public final void d(ArrayList arrayList) throws EOFException {
        int length;
        int length2;
        if (this.f2293d) {
            int i2 = this.f2292c;
            if (i2 < this.f2294e) {
                e(i2, 31, 32);
            }
            this.f2293d = false;
            this.f2292c = Integer.MAX_VALUE;
            e(this.f2294e, 31, 32);
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0109b c0109b = (C0109b) arrayList.get(i3);
            C0196l c0196lO = c0109b.f2281a.o();
            Integer num = (Integer) e.f2299b.get(c0196lO);
            C0196l c0196l = c0109b.f2282b;
            if (num != null) {
                int iIntValue = num.intValue();
                length2 = iIntValue + 1;
                if (2 > length2 || length2 >= 8) {
                    length = length2;
                    length2 = -1;
                } else {
                    C0109b[] c0109bArr = e.f2298a;
                    if (F0.i.a(c0109bArr[iIntValue].f2282b, c0196l)) {
                        length = length2;
                    } else if (F0.i.a(c0109bArr[length2].f2282b, c0196l)) {
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
                int length3 = this.f2295f.length;
                for (int i4 = this.g + 1; i4 < length3; i4++) {
                    C0109b c0109b2 = this.f2295f[i4];
                    F0.i.b(c0109b2);
                    if (F0.i.a(c0109b2.f2281a, c0196lO)) {
                        C0109b c0109b3 = this.f2295f[i4];
                        F0.i.b(c0109b3);
                        if (F0.i.a(c0109b3.f2282b, c0196l)) {
                            length2 = e.f2298a.length + (i4 - this.g);
                            break;
                        } else if (length == -1) {
                            length = (i4 - this.g) + e.f2298a.length;
                        }
                    }
                }
            }
            if (length2 != -1) {
                e(length2, 127, 128);
            } else if (length == -1) {
                this.f2291b.Q(64);
                c(c0196lO);
                c(c0196l);
                b(c0109b);
            } else {
                C0196l c0196l2 = C0109b.f2276d;
                c0196lO.getClass();
                F0.i.e(c0196l2, "prefix");
                if (!c0196lO.k(0, c0196l2, c0196l2.c()) || F0.i.a(C0109b.f2280i, c0196lO)) {
                    e(length, 63, 64);
                    c(c0196l);
                    b(c0109b);
                } else {
                    e(length, 15, 0);
                    c(c0196l);
                }
            }
        }
    }

    public final void e(int i2, int i3, int i4) {
        C0193i c0193i = this.f2291b;
        if (i2 < i3) {
            c0193i.Q(i2 | i4);
            return;
        }
        c0193i.Q(i4 | i3);
        int i5 = i2 - i3;
        while (i5 >= 128) {
            c0193i.Q(128 | (i5 & 127));
            i5 >>>= 7;
        }
        c0193i.Q(i5);
    }
}
