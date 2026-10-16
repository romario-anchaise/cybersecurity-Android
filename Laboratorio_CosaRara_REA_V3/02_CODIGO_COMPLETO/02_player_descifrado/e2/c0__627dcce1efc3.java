// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f729a = new c0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Bitmap.CompressFormat f730b = Bitmap.CompressFormat.WEBP_LOSSY;

    public static byte[] a(Bitmap bitmap, int i3) throws IOException {
        if (bitmap.isRecycled()) {
            o2.i("bitmap is recycled");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            if (!bitmap.compress(f730b, i3, byteArrayOutputStream)) {
                throw new IllegalStateException("WebP compression failed");
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            byteArray.getClass();
            return byteArray;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                y.f.c(byteArrayOutputStream, th);
                throw th2;
            }
        }
    }
}
