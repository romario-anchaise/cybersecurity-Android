// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p2;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w2.r f2888c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2891f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2892g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2886a = 4096;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f2887b = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b[] f2889d = new b[8];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2890e = 7;

    public c(q qVar) {
        this.f2888c = new w2.r(qVar);
    }

    public final int a(int i3) {
        int i4;
        int i5 = 0;
        if (i3 > 0) {
            int length = this.f2889d.length;
            while (true) {
                length--;
                i4 = this.f2890e;
                if (length < i4 || i3 <= 0) {
                    break;
                }
                b bVar = this.f2889d[length];
                bVar.getClass();
                int i6 = bVar.f2884c;
                i3 -= i6;
                this.f2892g -= i6;
                this.f2891f--;
                i5++;
            }
            b[] bVarArr = this.f2889d;
            System.arraycopy(bVarArr, i4 + 1, bVarArr, i4 + 1 + i5, this.f2891f);
            this.f2890e += i5;
        }
        return i5;
    }

    public final w2.k b(int i3) throws IOException {
        if (i3 >= 0) {
            b[] bVarArr = e.f2901a;
            if (i3 <= bVarArr.length - 1) {
                return bVarArr[i3].f2882a;
            }
        }
        int length = this.f2890e + 1 + (i3 - e.f2901a.length);
        if (length >= 0) {
            b[] bVarArr2 = this.f2889d;
            if (length < bVarArr2.length) {
                b bVar = bVarArr2[length];
                bVar.getClass();
                return bVar.f2882a;
            }
        }
        b2.a.k("Header index too large ", i3 + 1);
        return null;
    }

    public final void c(b bVar) {
        this.f2887b.add(bVar);
        int i3 = bVar.f2884c;
        int i4 = this.f2886a;
        if (i3 > i4) {
            b[] bVarArr = this.f2889d;
            Arrays.fill(bVarArr, 0, bVarArr.length, (Object) null);
            this.f2890e = this.f2889d.length - 1;
            this.f2891f = 0;
            this.f2892g = 0;
            return;
        }
        a((this.f2892g + i3) - i4);
        int i5 = this.f2891f + 1;
        b[] bVarArr2 = this.f2889d;
        if (i5 > bVarArr2.length) {
            b[] bVarArr3 = new b[bVarArr2.length * 2];
            System.arraycopy(bVarArr2, 0, bVarArr3, bVarArr2.length, bVarArr2.length);
            this.f2890e = this.f2889d.length - 1;
            this.f2889d = bVarArr3;
        }
        int i6 = this.f2890e;
        this.f2890e = i6 - 1;
        this.f2889d[i6] = bVar;
        this.f2891f++;
        this.f2892g += i3;
    }

    public final w2.k d() throws EOFException {
        w2.r rVar = this.f2888c;
        byte b3 = rVar.readByte();
        byte[] bArr = j2.b.f2361a;
        int i3 = b3 & 255;
        int i4 = 0;
        boolean z2 = (b3 & 128) == 128;
        long jE = e(i3, 127);
        if (!z2) {
            return rVar.e(jE);
        }
        w2.h hVar = new w2.h();
        int[] iArr = y.f2999a;
        rVar.getClass();
        x xVar = y.f3001c;
        x xVar2 = xVar;
        int i5 = 0;
        for (long j3 = 0; j3 < jE; j3++) {
            byte b4 = rVar.readByte();
            byte[] bArr2 = j2.b.f2361a;
            i4 = (i4 << 8) | (b4 & 255);
            i5 += 8;
            while (i5 >= 8) {
                x[] xVarArr = (x[]) xVar2.f2998c;
                xVarArr.getClass();
                xVar2 = xVarArr[(i4 >>> (i5 - 8)) & 255];
                xVar2.getClass();
                if (((x[]) xVar2.f2998c) == null) {
                    hVar.J(xVar2.f2996a);
                    i5 -= xVar2.f2997b;
                    xVar2 = xVar;
                } else {
                    i5 -= 8;
                }
            }
        }
        while (i5 > 0) {
            x[] xVarArr2 = (x[]) xVar2.f2998c;
            xVarArr2.getClass();
            x xVar3 = xVarArr2[(i4 << (8 - i5)) & 255];
            xVar3.getClass();
            int i6 = xVar3.f2997b;
            if (((x[]) xVar3.f2998c) != null || i6 > i5) {
                break;
            }
            hVar.J(xVar3.f2996a);
            i5 -= i6;
            xVar2 = xVar;
        }
        return hVar.e(hVar.f5777d);
    }

    public final int e(int i3, int i4) throws EOFException {
        int i5 = i3 & i4;
        if (i5 < i4) {
            return i5;
        }
        int i6 = 0;
        while (true) {
            byte b3 = this.f2888c.readByte();
            byte[] bArr = j2.b.f2361a;
            int i7 = b3 & 255;
            if ((b3 & 128) == 0) {
                return i4 + (i7 << i6);
            }
            i4 += (b3 & 127) << i6;
            i6 += 7;
        }
    }
}
