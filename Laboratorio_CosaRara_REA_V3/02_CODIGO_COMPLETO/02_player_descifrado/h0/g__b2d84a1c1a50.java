// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static g f1896a;

    public g() {
        List list = Collections.EMPTY_LIST;
    }

    public static final String a(byte[] bArr, byte[][] bArr2, int i3) {
        int i4;
        boolean z2;
        int i5;
        int i6;
        byte[] bArr3 = PublicSuffixDatabase.f2813e;
        int length = bArr.length;
        int i7 = 0;
        while (i7 < length) {
            int i8 = (i7 + length) / 2;
            while (i8 > -1 && bArr[i8] != 10) {
                i8--;
            }
            int i9 = i8 + 1;
            int i10 = 1;
            while (true) {
                i4 = i9 + i10;
                if (bArr[i4] == 10) {
                    break;
                }
                i10++;
            }
            int i11 = i4 - i9;
            int i12 = i3;
            boolean z3 = false;
            int i13 = 0;
            int i14 = 0;
            while (true) {
                if (z3) {
                    i5 = 46;
                    z2 = false;
                } else {
                    byte b3 = bArr2[i12][i13];
                    byte[] bArr4 = j2.b.f2361a;
                    int i15 = b3 & 255;
                    z2 = z3;
                    i5 = i15;
                }
                byte b4 = bArr[i9 + i14];
                byte[] bArr5 = j2.b.f2361a;
                i6 = i5 - (b4 & 255);
                if (i6 != 0) {
                    break;
                }
                i14++;
                i13++;
                if (i14 == i11) {
                    break;
                }
                if (bArr2[i12].length != i13) {
                    z3 = z2;
                } else {
                    if (i12 == bArr2.length - 1) {
                        break;
                    }
                    i12++;
                    i13 = -1;
                    z3 = true;
                }
            }
            if (i6 >= 0) {
                if (i6 <= 0) {
                    int i16 = i11 - i14;
                    int length2 = bArr2[i12].length - i13;
                    int length3 = bArr2.length;
                    for (int i17 = i12 + 1; i17 < length3; i17++) {
                        length2 += bArr2[i17].length;
                    }
                    if (length2 >= i16) {
                        if (length2 <= i16) {
                            Charset charset = StandardCharsets.UTF_8;
                            charset.getClass();
                            return new String(bArr, i9, i11, charset);
                        }
                    }
                }
                i7 = i4 + 1;
            }
            length = i8;
        }
        return null;
    }
}
