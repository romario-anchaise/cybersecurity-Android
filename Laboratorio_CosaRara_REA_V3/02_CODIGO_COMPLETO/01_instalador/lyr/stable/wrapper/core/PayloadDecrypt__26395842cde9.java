// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.wrapper.core;

import V0.o;
import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class PayloadDecrypt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3643a = o.f728n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f3644b = o.f729o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f3645c = o.f726l;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f3646d = b(16, o.f725k);

    static {
        System.loadLibrary("payload");
    }

    public static byte[] a(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int i2 = f3645c;
            if (length >= i2 + 32) {
                byte[] bArr2 = new byte[16];
                System.arraycopy(bArr, i2, bArr2, 0, 16);
                int i3 = i2 + 16;
                int length2 = bArr.length - i3;
                byte[] bArr3 = new byte[length2];
                System.arraycopy(bArr, i3, bArr3, 0, length2);
                byte[] bArrNativeAesCbcDecrypt = nativeAesCbcDecrypt(bArr3, bArr2, f3646d);
                if (bArrNativeAesCbcDecrypt != null) {
                    return bArrNativeAesCbcDecrypt;
                }
                throw new IllegalStateException("native aes decrypt failed");
            }
        }
        throw new IllegalArgumentException("payload chunk too short");
    }

    public static byte[] b(int i2, String str) {
        if (str == null || str.length() != i2 * 2) {
            throw new IllegalStateException("invalid hexadecimal value length");
        }
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * 2;
            bArr[i3] = (byte) Integer.parseInt(str.substring(i4, i4 + 2), 16);
        }
        return bArr;
    }

    public static byte[] c(Context context) throws IOException {
        byte[] bArrA;
        byte[] bArrA2;
        byte[] bArrD = d(context, f3643a);
        byte[] bArrD2 = d(context, f3644b);
        if (o.f727m == 0) {
            bArrA = a(bArrD);
            bArrA2 = a(bArrD2);
        } else {
            byte[] bArrA3 = a(bArrD2);
            byte[] bArrA4 = a(bArrD);
            bArrA = bArrA3;
            bArrA2 = bArrA4;
        }
        byte[] bArr = new byte[bArrA.length + bArrA2.length];
        System.arraycopy(bArrA, 0, bArr, 0, bArrA.length);
        System.arraycopy(bArrA2, 0, bArr, bArrA.length, bArrA2.length);
        byte[] bArrNativeGunzip = nativeGunzip(bArr);
        if (bArrNativeGunzip == null) {
            throw new IllegalStateException("native gunzip failed");
        }
        if (o.f719d == null || MessageDigest.isEqual(b(32, o.f732r), MessageDigest.getInstance("SHA-256").digest(bArrNativeGunzip))) {
            return bArrNativeGunzip;
        }
        throw new SecurityException("embedded core payload digest mismatch");
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static byte[] d(Context context, String str) throws IOException {
        InputStream inputStreamOpen = context.getAssets().open(str);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int i2 = inputStreamOpen.read(bArr);
                    if (i2 == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        inputStreamOpen.close();
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (Throwable th4) {
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
            }
            throw th4;
        }
    }

    private static native byte[] nativeAesCbcDecrypt(byte[] bArr, byte[] bArr2, byte[] bArr3);

    private static native byte[] nativeGunzip(byte[] bArr);
}
