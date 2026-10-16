// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import android.graphics.Bitmap;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y.r f789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f792f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f793g;

    public f(int i3, int i4, y.r rVar, long j3, long j4, b bVar, long j5) {
        this.f787a = i3;
        this.f788b = i4;
        this.f789c = rVar;
        this.f790d = j3;
        this.f791e = j4;
        this.f792f = bVar;
        this.f793g = j5;
    }

    public static final f a(Bitmap bitmap, long j3, long j4) {
        bitmap.getClass();
        if (bitmap.isRecycled()) {
            o2.i("bitmap is recycled");
            return null;
        }
        if (bitmap.getConfig() == Bitmap.Config.HARDWARE) {
            o2.i("captured bitmap must own software pixels");
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        y.r rVar = new y.r();
        rVar.f6032a = bitmap;
        rVar.f6033b = new AtomicBoolean(false);
        rVar.f6034c = null;
        return new f(width, height, rVar, j3, j4, b.f712c, 0L);
    }

    public final void b() {
        y.r rVar = this.f789c;
        if (((AtomicBoolean) rVar.f6033b).compareAndSet(false, true)) {
            try {
                synchronized (rVar) {
                    int[] iArr = (int[]) rVar.f6034c;
                    if (iArr != null) {
                        Arrays.fill(iArr, 0, iArr.length, 0);
                    }
                    rVar.f6034c = null;
                    Bitmap bitmap = (Bitmap) rVar.f6032a;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        ((Bitmap) rVar.f6032a).recycle();
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
