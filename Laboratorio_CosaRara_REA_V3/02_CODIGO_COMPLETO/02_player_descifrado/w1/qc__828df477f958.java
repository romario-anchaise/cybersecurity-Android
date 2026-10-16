// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.AccessibilityService;
import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class qc implements AccessibilityService.TakeScreenshotCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ja f4947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f4948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p5 f4949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f4951e;

    public qc(ScreenMirrorService screenMirrorService, ja jaVar, AtomicBoolean atomicBoolean, p5 p5Var, int i3) {
        this.f4951e = screenMirrorService;
        this.f4947a = jaVar;
        this.f4948b = atomicBoolean;
        this.f4949c = p5Var;
        this.f4950d = i3;
    }

    @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
    public final void onFailure(int i3) {
        ScreenMirrorService screenMirrorService = this.f4951e;
        screenMirrorService.f2475a2.removeCallbacks(this.f4947a);
        boolean zCompareAndSet = this.f4948b.compareAndSet(true, false);
        p5 p5Var = this.f4949c;
        if (p5Var.a() && x7.a((x7) p5Var.f4805d, p5Var.f4802a, p5Var.f4803b, false, i3)) {
            Log.w("ScreenMirror", "[LockMask] background screenshot fail code=" + i3);
            if (i3 == 3) {
                Log.w("MirrorScreenshotPerf", "stage=oem source=lock_mask errorCode=3 sharedIntervalMs=" + ScreenMirrorService.o6.b());
            }
        }
        if (zCompareAndSet) {
            screenMirrorService.L6(this.f4950d);
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0097  */
    /* JADX WARN: Code duplicated, block: B:63:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
    public final void onSuccess(AccessibilityService.ScreenshotResult screenshotResult) {
        Bitmap bitmap;
        Bitmap bitmapCopy;
        Bitmap bitmapM;
        Bitmap bitmap2;
        ScreenMirrorService screenMirrorService = this.f4951e;
        screenMirrorService.f2475a2.removeCallbacks(this.f4947a);
        boolean zCompareAndSet = this.f4948b.compareAndSet(true, false);
        p5 p5Var = this.f4949c;
        boolean zA = p5Var.a();
        HardwareBuffer hardwareBuffer = null;
        bitmapWrapHardwareBuffer = null;
        bitmapWrapHardwareBuffer = null;
        bitmapWrapHardwareBuffer = null;
        Bitmap bitmapWrapHardwareBuffer = null;
        try {
            HardwareBuffer hardwareBuffer2 = screenshotResult.getHardwareBuffer();
            if (zCompareAndSet && zA && hardwareBuffer2 != null) {
                try {
                    bitmapWrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer2, screenshotResult.getColorSpace());
                    if (zCompareAndSet) {
                        bitmapCopy = bitmapWrapHardwareBuffer.copy(Bitmap.Config.ARGB_8888, false);
                        bitmapM = ScreenMirrorService.m(bitmapCopy);
                        if (bitmapM != bitmapCopy) {
                            bitmapCopy.recycle();
                        }
                        bitmap2 = screenMirrorService.Z1;
                        if (bitmap2 != null) {
                            screenMirrorService.Z1.recycle();
                        }
                        screenMirrorService.Z1 = bitmapM;
                        Log.i("ScreenMirror", "[LockMask] real lockscreen background captured " + bitmapM.getWidth() + "x" + bitmapM.getHeight() + " + gaussian blur");
                    }
                    if (bitmapWrapHardwareBuffer != null) {
                        bitmapWrapHardwareBuffer.recycle();
                    }
                    if (hardwareBuffer2 != null) {
                        hardwareBuffer2.close();
                    }
                    if (zA) {
                        p5Var.c();
                    }
                } catch (Throwable th) {
                    th = th;
                    bitmap = bitmapWrapHardwareBuffer;
                    hardwareBuffer = hardwareBuffer2;
                    try {
                        Log.w("ScreenMirror", "[LockMask] background copy fail: " + th.getMessage());
                        if (bitmap != null && !bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                        if (hardwareBuffer != null) {
                            try {
                                hardwareBuffer.close();
                            } catch (Throwable unused) {
                            }
                        }
                        if (zA) {
                            p5Var.c();
                        }
                    } catch (Throwable th2) {
                        if (bitmap != null && !bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                        if (hardwareBuffer != null) {
                            try {
                                hardwareBuffer.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        if (!zA) {
                            throw th2;
                        }
                        p5Var.c();
                        throw th2;
                    }
                }
            } else {
                if (zCompareAndSet && zA && bitmapWrapHardwareBuffer != null) {
                    bitmapCopy = bitmapWrapHardwareBuffer.copy(Bitmap.Config.ARGB_8888, false);
                    bitmapM = ScreenMirrorService.m(bitmapCopy);
                    if (bitmapM != bitmapCopy && !bitmapCopy.isRecycled()) {
                        bitmapCopy.recycle();
                    }
                    bitmap2 = screenMirrorService.Z1;
                    if (bitmap2 != null && !bitmap2.isRecycled()) {
                        screenMirrorService.Z1.recycle();
                    }
                    screenMirrorService.Z1 = bitmapM;
                    Log.i("ScreenMirror", "[LockMask] real lockscreen background captured " + bitmapM.getWidth() + "x" + bitmapM.getHeight() + " + gaussian blur");
                }
                if (bitmapWrapHardwareBuffer != null && !bitmapWrapHardwareBuffer.isRecycled()) {
                    bitmapWrapHardwareBuffer.recycle();
                }
                if (hardwareBuffer2 != null) {
                    try {
                        hardwareBuffer2.close();
                    } catch (Throwable unused3) {
                    }
                }
                if (zA) {
                    p5Var.c();
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bitmap = null;
        }
        if (zCompareAndSet) {
            screenMirrorService.L6(this.f4950d);
        }
    }
}
