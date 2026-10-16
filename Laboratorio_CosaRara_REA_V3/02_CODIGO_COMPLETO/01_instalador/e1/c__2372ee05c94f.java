// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e1;

import java.io.IOException;
import java.util.ArrayList;
import k1.C0193i;
import k1.C0196l;

/* JADX INFO: renamed from: e1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0110c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k1.C f2286c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2289f;
    public int g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2284a = 4096;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f2285b = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0109b[] f2287d = new C0109b[8];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2288e = 7;

    public C0110c(r rVar) {
        this.f2286c = f1.l.f(rVar);
    }

    public final int a(int i2) {
        int i3;
        int i4 = 0;
        if (i2 > 0) {
            int length = this.f2287d.length;
            while (true) {
                length--;
                i3 = this.f2288e;
                if (length < i3 || i2 <= 0) {
                    break;
                }
                C0109b c0109b = this.f2287d[length];
                F0.i.b(c0109b);
                int i5 = c0109b.f2283c;
                i2 -= i5;
                this.g -= i5;
                this.f2289f--;
                i4++;
            }
            C0109b[] c0109bArr = this.f2287d;
            System.arraycopy(c0109bArr, i3 + 1, c0109bArr, i3 + 1 + i4, this.f2289f);
            this.f2288e += i4;
        }
        return i4;
    }

    public final C0196l b(int i2) throws IOException {
        if (i2 >= 0) {
            C0109b[] c0109bArr = e.f2298a;
            if (i2 <= c0109bArr.length - 1) {
                return c0109bArr[i2].f2281a;
            }
        }
        int length = this.f2288e + 1 + (i2 - e.f2298a.length);
        if (length >= 0) {
            C0109b[] c0109bArr2 = this.f2287d;
            if (length < c0109bArr2.length) {
                C0109b c0109b = c0109bArr2[length];
                F0.i.b(c0109b);
                return c0109b.f2281a;
            }
        }
        throw new IOException("Header index too large " + (i2 + 1));
    }

    public final void c(C0109b c0109b) {
        this.f2285b.add(c0109b);
        int i2 = this.f2284a;
        int i3 = c0109b.f2283c;
        if (i3 > i2) {
            C0109b[] c0109bArr = this.f2287d;
            p036u0.e.w(c0109bArr, 0, c0109bArr.length);
            this.f2288e = this.f2287d.length - 1;
            this.f2289f = 0;
            this.g = 0;
            return;
        }
        a((this.g + i3) - i2);
        int i4 = this.f2289f + 1;
        C0109b[] c0109bArr2 = this.f2287d;
        if (i4 > c0109bArr2.length) {
            C0109b[] c0109bArr3 = new C0109b[c0109bArr2.length * 2];
            System.arraycopy(c0109bArr2, 0, c0109bArr3, c0109bArr2.length, c0109bArr2.length);
            this.f2288e = this.f2287d.length - 1;
            this.f2287d = c0109bArr3;
        }
        int i5 = this.f2288e;
        this.f2288e = i5 - 1;
        this.f2287d[i5] = c0109b;
        this.f2289f++;
        this.g += i3;
    }

    public final C0196l d() {
        int i2;
        k1.C c2 = this.f2286c;
        byte bJ = c2.j();
        byte[] bArr = Y0.b.f1119a;
        int i3 = bJ & 255;
        int i4 = 0;
        boolean z2 = (bJ & 128) == 128;
        long jE = e(i3, 127);
        if (!z2) {
            return c2.n(jE);
        }
        C0193i c0193i = new C0193i();
        int[] iArr = z.f2394a;
        F0.i.e(c2, "source");
        y yVar = z.f2396c;
        y yVar2 = yVar;
        int i5 = 0;
        for (long j2 = 0; j2 < jE; j2++) {
            byte bJ2 = c2.j();
            byte[] bArr2 = Y0.b.f1119a;
            i4 = (i4 << 8) | (bJ2 & 255);
            i5 += 8;
            while (i5 >= 8) {
                y[] yVarArr = yVar2.f2391a;
                F0.i.b(yVarArr);
                yVar2 = yVarArr[(i4 >>> (i5 - 8)) & 255];
                F0.i.b(yVar2);
                if (yVar2.f2391a == null) {
                    c0193i.Q(yVar2.f2392b);
                    i5 -= yVar2.f2393c;
                    yVar2 = yVar;
                } else {
                    i5 -= 8;
                }
            }
        }
        while (i5 > 0) {
            y[] yVarArr2 = yVar2.f2391a;
            F0.i.b(yVarArr2);
            y yVar3 = yVarArr2[(i4 << (8 - i5)) & 255];
            F0.i.b(yVar3);
            if (yVar3.f2391a != null || (i2 = yVar3.f2393c) > i5) {
                break;
            }
            c0193i.Q(yVar3.f2392b);
            i5 -= i2;
            yVar2 = yVar;
        }
        return c0193i.D(c0193i.f3482b);
    }

    public final int e(int i2, int i3) {
        int i4 = i2 & i3;
        if (i4 < i3) {
            return i4;
        }
        int i5 = 0;
        while (true) {
            byte bJ = this.f2286c.j();
            byte[] bArr = Y0.b.f1119a;
            int i6 = bJ & 255;
            if ((bJ & 128) == 0) {
                return i3 + (i6 << i5);
            }
            i3 += (bJ & 127) << i5;
            i5 += 7;
        }
    }
}
