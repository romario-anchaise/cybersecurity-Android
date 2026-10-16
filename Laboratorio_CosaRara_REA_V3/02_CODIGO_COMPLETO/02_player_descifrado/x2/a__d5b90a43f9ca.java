// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x2;

import java.io.EOFException;
import w2.h;
import w2.p;
import w2.s;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f5966a;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(v1.a.f3277a);
        bytes.getClass();
        f5966a = bytes;
    }

    public static final String a(long j3, h hVar) throws EOFException {
        if (j3 > 0) {
            long j4 = j3 - 1;
            if (hVar.y(j4) == 13) {
                String strC = hVar.C(j4, v1.a.f3277a);
                hVar.skip(2L);
                return strC;
            }
        }
        String strC2 = hVar.C(j3, v1.a.f3277a);
        hVar.skip(1L);
        return strC2;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00a1 A[LOOP:0: B:8:0x001c->B:49:0x00a1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:55:0x00a0 A[SYNTHETIC] */
    public static final int b(h hVar, p pVar, boolean z2) {
        int i3;
        int i4;
        int i5;
        s sVar;
        int i6;
        pVar.getClass();
        s sVar2 = hVar.f5776c;
        if (sVar2 == null) {
            return z2 ? -2 : -1;
        }
        byte[] bArr = sVar2.f5801a;
        int i7 = sVar2.f5802b;
        int i8 = sVar2.f5803c;
        int[] iArr = pVar.f5794d;
        s sVar3 = sVar2;
        int i9 = -1;
        int i10 = 0;
        loop0: while (true) {
            int i11 = i10 + 1;
            int i12 = iArr[i10];
            int i13 = i10 + 2;
            int i14 = iArr[i11];
            if (i14 != -1) {
                i9 = i14;
            }
            if (sVar3 == null) {
                break;
            }
            if (i12 >= 0) {
                int i15 = i7 + 1;
                int i16 = bArr[i7] & 255;
                int i17 = i13 + i12;
                while (i13 != i17) {
                    if (i16 == iArr[i13]) {
                        i3 = iArr[i13 + i12];
                        if (i15 == i8) {
                            sVar3 = sVar3.f5806f;
                            sVar3.getClass();
                            int i18 = sVar3.f5802b;
                            byte[] bArr2 = sVar3.f5801a;
                            i4 = sVar3.f5803c;
                            if (sVar3 == sVar2) {
                                i5 = i18;
                                bArr = bArr2;
                                sVar3 = null;
                            } else {
                                i5 = i18;
                                bArr = bArr2;
                            }
                        } else {
                            i4 = i8;
                            i5 = i15;
                        }
                        if (i3 >= 0) {
                            return i3;
                        }
                        int i19 = i4;
                        i10 = -i3;
                        i7 = i5;
                        i8 = i19;
                    } else {
                        i13++;
                    }
                }
                return i9;
            }
            int i20 = (i12 * (-1)) + i13;
            while (true) {
                int i21 = i7 + 1;
                int i22 = i13 + 1;
                if ((bArr[i7] & 255) == iArr[i13]) {
                    boolean z3 = i22 == i20;
                    if (i21 == i8) {
                        sVar3.getClass();
                        s sVar4 = sVar3.f5806f;
                        sVar4.getClass();
                        i5 = sVar4.f5802b;
                        byte[] bArr3 = sVar4.f5801a;
                        i6 = sVar4.f5803c;
                        if (sVar4 != sVar2) {
                            sVar = sVar4;
                            bArr = bArr3;
                        } else {
                            if (!z3) {
                                break loop0;
                            }
                            bArr = bArr3;
                            sVar = null;
                        }
                    } else {
                        sVar = sVar3;
                        i6 = i8;
                        i5 = i21;
                    }
                    if (z3) {
                        i3 = iArr[i22];
                        int i23 = i6;
                        sVar3 = sVar;
                        i4 = i23;
                        break;
                    }
                    i7 = i5;
                    i8 = i6;
                    sVar3 = sVar;
                    i13 = i22;
                }
                return i9;
            }
            if (i3 >= 0) {
                return i3;
            }
            int i110 = i4;
            i10 = -i3;
            i7 = i5;
            i8 = i110;
        }
        if (z2) {
            return -2;
        }
        return i9;
    }
}
