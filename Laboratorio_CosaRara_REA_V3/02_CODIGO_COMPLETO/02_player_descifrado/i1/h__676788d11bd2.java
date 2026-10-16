// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package i1;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends y.f {
    public static void s(byte[] bArr, byte[] bArr2, int i3, int i4, int i5) {
        bArr.getClass();
        bArr2.getClass();
        System.arraycopy(bArr, i4, bArr2, i3, i5 - i4);
    }

    public static void t(Object[] objArr, Object[] objArr2, int i3, int i4, int i5) {
        objArr.getClass();
        objArr2.getClass();
        System.arraycopy(objArr, i4, objArr2, i3, i5 - i4);
    }

    public static byte[] u(byte[] bArr, int i3, int i4) {
        bArr.getClass();
        y.f.g(i4, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i3, i4);
        bArrCopyOfRange.getClass();
        return bArrCopyOfRange;
    }
}
