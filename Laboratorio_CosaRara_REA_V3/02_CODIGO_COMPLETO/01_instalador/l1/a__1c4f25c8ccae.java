// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package l1;

import java.io.EOFException;
import k1.C0193i;
import k1.D;
import k1.y;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f3534a;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(M0.a.f360a);
        F0.i.d(bytes, "getBytes(...)");
        f3534a = bytes;
    }

    public static final String a(C0193i c0193i, long j2) throws EOFException {
        F0.i.e(c0193i, "<this>");
        if (j2 > 0) {
            long j3 = j2 - 1;
            if (c0193i.x(j3) == 13) {
                String strI = c0193i.I(j3, M0.a.f360a);
                c0193i.K(2L);
                return strI;
            }
        }
        String strI2 = c0193i.I(j2, M0.a.f360a);
        c0193i.K(1L);
        return strI2;
    }

    public static final int b(C0193i c0193i, y yVar, boolean z2) {
        int i2;
        int i3;
        D d2;
        byte[] bArr;
        int i4;
        F0.i.e(c0193i, "<this>");
        F0.i.e(yVar, "options");
        D d3 = c0193i.f3481a;
        int i5 = -2;
        if (d3 == null) {
            return z2 ? -2 : -1;
        }
        int i6 = d3.f3445b;
        int i7 = d3.f3446c;
        byte[] bArr2 = d3.f3444a;
        D d4 = d3;
        int i8 = -1;
        int i9 = 0;
        loop0: while (true) {
            int i10 = i9 + 1;
            int[] iArr = yVar.f3516b;
            int i11 = iArr[i9];
            int i12 = i9 + 2;
            int i13 = iArr[i10];
            if (i13 != -1) {
                i8 = i13;
            }
            if (d4 == null) {
                break;
            }
            if (i11 >= 0) {
                int i14 = i6 + 1;
                int i15 = bArr2[i6] & 255;
                int i16 = i12 + i11;
                while (i12 != i16) {
                    if (i15 == iArr[i12]) {
                        i2 = iArr[i12 + i11];
                        if (i14 == i7) {
                            d4 = d4.f3449f;
                            F0.i.b(d4);
                            i3 = d4.f3445b;
                            i7 = d4.f3446c;
                            bArr2 = d4.f3444a;
                            if (d4 == d3) {
                                d4 = null;
                            }
                        } else {
                            i3 = i14;
                        }
                    } else {
                        i12++;
                    }
                }
                return i8;
            }
            int i17 = (i11 * (-1)) + i12;
            while (true) {
                int i18 = i6 + 1;
                int i19 = i12 + 1;
                if ((bArr2[i6] & 255) != iArr[i12]) {
                    return i8;
                }
                boolean z3 = i19 == i17;
                if (i18 == i7) {
                    F0.i.b(d4);
                    D d5 = d4.f3449f;
                    F0.i.b(d5);
                    i4 = d5.f3445b;
                    int i20 = d5.f3446c;
                    bArr = d5.f3444a;
                    if (d5 != d3) {
                        d2 = d5;
                        i7 = i20;
                    } else {
                        if (!z3) {
                            break loop0;
                        }
                        i7 = i20;
                        d2 = null;
                    }
                } else {
                    d2 = d4;
                    bArr = bArr2;
                    i4 = i18;
                }
                if (z3) {
                    i2 = iArr[i19];
                    i3 = i4;
                    bArr2 = bArr;
                    d4 = d2;
                    break;
                }
                i6 = i4;
                bArr2 = bArr;
                d4 = d2;
                i12 = i19;
            }
            if (i2 >= 0) {
                return i2;
            }
            i9 = -i2;
            i6 = i3;
            i5 = -2;
        }
        return z2 ? i5 : i8;
    }
}
