// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0 f807a = new g0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReference f808b = new AtomicReference(new f0());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f809c = new AtomicBoolean(false);

    public static final Bitmap a(Bitmap bitmap, float f3) {
        bitmap.getClass();
        if (bitmap.isRecycled()) {
            o2.i("source bitmap is recycled");
            return null;
        }
        float fC = c(f3);
        if (fC <= 1.0f) {
            return bitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.getClass();
        try {
            ColorMatrix colorMatrix = new ColorMatrix(new float[]{fC, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, fC, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, fC, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
            Paint paint = new Paint(7);
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, 0.0f, 0.0f, paint);
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            bitmapCreateBitmap.recycle();
            throw th;
        }
    }

    public static final float b(int i3) {
        int iE = 255 - y.f.e(q2.k.p((y.f.e(i3, 100) * 255.0f) / 100.0f), 255);
        if (iE < 1) {
            iE = 1;
        }
        return y.f.d(150.0f / iE, 1.0f, 50.0f);
    }

    public static float c(float f3) {
        if (Math.abs(f3) <= Float.MAX_VALUE) {
            return y.f.d(f3, 1.0f, 50.0f);
        }
        return 1.0f;
    }

    public static final void d(boolean z2) {
        f809c.set(z2);
    }
}
