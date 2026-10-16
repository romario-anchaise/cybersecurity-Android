// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.content.Context;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f1215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Map f1216b;

    static {
        byte[] bArr = new byte[32];
        for (int i3 = 0; i3 < 64; i3 += 2) {
            bArr[i3 / 2] = (byte) (Character.digit("7c3a91e04b8f26d15a90c4e8b37f12d06e5a9c18b4d703f2a1e86c59d0b2473e".charAt(i3 + 1), 16) + (Character.digit("7c3a91e04b8f26d15a90c4e8b37f12d06e5a9c18b4d703f2a1e86c59d0b2473e".charAt(i3), 16) << 4));
        }
        f1215a = bArr;
    }

    public static Map a(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (bArr == null || bArr.length < 20) {
            return Collections.EMPTY_MAP;
        }
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
        cipher.init(2, new SecretKeySpec(f1215a, "AES"), new IvParameterSpec(bArr2));
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(cipher.doFinal(bArr, 16, bArr.length - 16)).order(ByteOrder.BIG_ENDIAN);
        int i3 = byteBufferOrder.getInt();
        if (i3 < 0 || i3 > 4096) {
            return Collections.EMPTY_MAP;
        }
        HashMap map = new HashMap();
        for (int i4 = 0; i4 < i3; i4++) {
            byte[] bArr3 = new byte[byteBufferOrder.getShort() & 65535];
            byteBufferOrder.get(bArr3);
            int i5 = byteBufferOrder.getInt();
            if (i5 < 0 || i5 > byteBufferOrder.remaining()) {
                break;
            }
            byte[] bArr4 = new byte[i5];
            byteBufferOrder.get(bArr4);
            map.put(new String(bArr3, StandardCharsets.UTF_8), bArr4);
        }
        return map;
    }

    public static String b(Context context, String str) {
        Map map;
        Map map2 = f1216b;
        if (map2 == null) {
            synchronized (j.class) {
                if (f1216b != null) {
                    map = f1216b;
                } else {
                    try {
                        InputStream inputStreamOpen = context.getApplicationContext().getAssets().open("76c6854504.enc");
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i3 = inputStreamOpen.read(bArr);
                            if (i3 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i3);
                        }
                        inputStreamOpen.close();
                        f1216b = a(byteArrayOutputStream.toByteArray());
                    } catch (Throwable th) {
                        Log.w("AuthProfilePack", "load failed: " + th.getMessage());
                        f1216b = Collections.EMPTY_MAP;
                    }
                    map = f1216b;
                }
            }
            map2 = map;
        }
        byte[] bArr2 = (byte[]) map2.get(str);
        if (bArr2 == null) {
            return null;
        }
        return new String(bArr2, StandardCharsets.UTF_8);
    }
}
