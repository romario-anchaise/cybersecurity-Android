// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.AccessibilityService;
import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicLong;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class hd implements AccessibilityService.TakeScreenshotCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f4222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f4223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f4224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p5 f4225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final qa f4226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f4227g;

    public hd(ScreenMirrorService screenMirrorService, long j3, Handler handler, ThreadPoolExecutor threadPoolExecutor, long j4, p5 p5Var) {
        this.f4227g = screenMirrorService;
        this.f4221a = j3;
        this.f4222b = handler;
        this.f4223c = threadPoolExecutor;
        this.f4224d = j4;
        this.f4225e = p5Var;
        this.f4226f = new qa(this, j3, handler, j4, p5Var);
    }

    public final void a(long j3) {
        ScreenMirrorService screenMirrorService = this.f4227g;
        if (screenMirrorService.F4.compareAndSet(-this.f4224d, 0L)) {
            long j4 = this.f4221a;
            Handler handler = this.f4222b;
            if (screenMirrorService.I3(j4, handler) && screenMirrorService.f2537s.get()) {
                handler.postDelayed(new pa(screenMirrorService, 25), Math.max(0L, j3));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0033 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x0034  */
    @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
    public final void onFailure(int i3) {
        int i4;
        boolean z2;
        this.f4222b.removeCallbacks(this.f4226f);
        AtomicLong atomicLong = this.f4227g.F4;
        long j3 = this.f4224d;
        boolean zCompareAndSet = atomicLong.compareAndSet(j3, -j3);
        if (this.f4225e.a()) {
            p5 p5Var = this.f4225e;
            i4 = i3;
            z2 = x7.a((x7) p5Var.f4805d, p5Var.f4802a, p5Var.f4803b, false, i4);
            if (zCompareAndSet) {
                if (z2 || !this.f4227g.I3(this.f4221a, this.f4222b)) {
                    a(Math.max(1L, ScreenMirrorService.o6.f()));
                }
                synchronized (this.f4227g) {
                    try {
                        if (this.f4227g.I3(this.f4221a, this.f4222b) && this.f4227g.F4.get() == (-this.f4224d)) {
                            long jUptimeMillis = SystemClock.uptimeMillis() - this.f4227g.H4;
                            if (i4 == 3) {
                                ScreenMirrorService screenMirrorService = this.f4227g;
                                screenMirrorService.I4 = Math.min(1000L, screenMirrorService.I4 + 50);
                            }
                            long jMax = i4 == 3 ? Math.max(this.f4227g.I4 - jUptimeMillis, 50L) : 200L;
                            Log.e("MirrorPerf", "JPEG失败 错误码:" + i4 + " 距上次成功:" + jUptimeMillis + "ms");
                            if (i4 == 3) {
                                Log.w("MirrorScreenshotPerf", "stage=oem source=jpeg errorCode=3 sharedIntervalMs=" + ScreenMirrorService.o6.b());
                            }
                            a(Math.max(jMax, ScreenMirrorService.o6.f()));
                            return;
                        }
                        a(Math.max(1L, ScreenMirrorService.o6.f()));
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return;
        }
        i4 = i3;
        if (zCompareAndSet) {
            return;
        }
        if (z2) {
        }
        a(Math.max(1L, ScreenMirrorService.o6.f()));
    }

    @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
    public final void onSuccess(final AccessibilityService.ScreenshotResult screenshotResult) {
        HardwareBuffer hardwareBuffer;
        final hd hdVar;
        this.f4222b.removeCallbacks(this.f4226f);
        AtomicLong atomicLong = this.f4227g.F4;
        long j3 = this.f4224d;
        boolean zCompareAndSet = atomicLong.compareAndSet(j3, -j3);
        boolean z2 = this.f4225e.a() && this.f4225e.c();
        try {
            hardwareBuffer = screenshotResult.getHardwareBuffer();
        } catch (Throwable unused) {
            hardwareBuffer = null;
        }
        final HardwareBuffer hardwareBuffer2 = hardwareBuffer;
        if (!zCompareAndSet || !z2) {
            if (hardwareBuffer2 != null) {
                try {
                    hardwareBuffer2.close();
                } catch (Throwable unused2) {
                }
            }
            if (zCompareAndSet) {
                a(Math.max(1L, ScreenMirrorService.o6.f()));
                return;
            }
            return;
        }
        synchronized (this.f4227g) {
            try {
                if (!this.f4227g.I3(this.f4221a, this.f4222b) || this.f4227g.F4.get() != (-this.f4224d)) {
                    if (hardwareBuffer2 != null) {
                        try {
                            hardwareBuffer2.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    a(Math.max(1L, ScreenMirrorService.o6.f()));
                    return;
                }
                long jUptimeMillis = SystemClock.uptimeMillis();
                long jCurrentTimeMillis = System.currentTimeMillis();
                ScreenMirrorService screenMirrorService = this.f4227g;
                final long j4 = jCurrentTimeMillis - screenMirrorService.J4;
                final long j5 = screenMirrorService.H4 > 0 ? jUptimeMillis - this.f4227g.H4 : 0L;
                this.f4227g.H4 = jUptimeMillis;
                if (this.f4227g.I4 > 250) {
                    ScreenMirrorService screenMirrorService2 = this.f4227g;
                    screenMirrorService2.I4 = Math.max(250L, screenMirrorService2.I4 - 10);
                }
                final int i3 = this.f4227g.h4;
                final int i4 = this.f4227g.i4;
                final int i5 = this.f4227g.f2472a;
                try {
                    hdVar = this;
                    try {
                        this.f4223c.execute(new Runnable() { // from class: w1.gd
                            /* JADX WARN: Code duplicated, block: B:107:0x019b A[EXC_TOP_SPLITTER, SYNTHETIC] */
                            /* JADX WARN: Code duplicated, block: B:112:0x0143 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.lang.Runnable
                            public final void run() throws Throwable {
                                Bitmap bitmapWrapHardwareBuffer;
                                Bitmap bitmap;
                                Bitmap bitmap2;
                                Bitmap bitmapCreateScaledBitmap;
                                Bitmap bitmap3;
                                long jUptimeMillis2;
                                long j6;
                                hd hdVar2 = this.f4143c;
                                HardwareBuffer hardwareBuffer3 = hardwareBuffer2;
                                AccessibilityService.ScreenshotResult screenshotResult2 = screenshotResult;
                                int i6 = i3;
                                int i7 = i4;
                                int iMin = i5;
                                long j7 = j5;
                                long j8 = j4;
                                try {
                                    try {
                                        ScreenMirrorService screenMirrorService3 = hdVar2.f4227g;
                                        long j9 = hdVar2.f4221a;
                                        Handler handler = hdVar2.f4222b;
                                        rd rdVar = ScreenMirrorService.n6;
                                        if (screenMirrorService3.I3(j9, handler) && hdVar2.f4227g.F4.get() == (-hdVar2.f4224d)) {
                                            bitmapWrapHardwareBuffer = hardwareBuffer3 != null ? Bitmap.wrapHardwareBuffer(hardwareBuffer3, screenshotResult2.getColorSpace()) : null;
                                            if (bitmapWrapHardwareBuffer != null) {
                                                try {
                                                    bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapWrapHardwareBuffer, i6, i7, false);
                                                    try {
                                                        long jS0 = cf.K() != null ? cf.K().S0() : 0L;
                                                        if (jS0 > 24000) {
                                                            iMin = Math.max(20, iMin - 6);
                                                        } else if (jS0 < 8000) {
                                                            iMin = Math.min(60, iMin + 3);
                                                        }
                                                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(49152);
                                                        bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, iMin, byteArrayOutputStream);
                                                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                                                        synchronized (hdVar2.f4227g) {
                                                            if (hdVar2.f4227g.I3(hdVar2.f4221a, hdVar2.f4222b) && hdVar2.f4227g.F4.get() == (-hdVar2.f4224d)) {
                                                                hdVar2.f4227g.f2472a = iMin;
                                                                hdVar2.f4227g.K4 = byteArray;
                                                                hdVar2.f4227g.L4++;
                                                                ScreenMirrorService screenMirrorService4 = hdVar2.f4227g;
                                                                screenMirrorService4.S(1, screenMirrorService4.L4, byteArray);
                                                                Log.d("MirrorPerf", String.format("JPEG | 系统响应: %dms | 实际FPS: %.1f", Long.valueOf(j8), Double.valueOf(j7 > 0 ? 1000.0d / j7 : 0.0d)));
                                                            } else {
                                                                if (bitmapCreateScaledBitmap != bitmapWrapHardwareBuffer) {
                                                                    bitmapCreateScaledBitmap.recycle();
                                                                }
                                                                if (!bitmapWrapHardwareBuffer.isRecycled()) {
                                                                    bitmapWrapHardwareBuffer.recycle();
                                                                }
                                                                if (hardwareBuffer3 != null) {
                                                                    try {
                                                                        hardwareBuffer3.close();
                                                                    } catch (Exception unused4) {
                                                                    }
                                                                }
                                                                jUptimeMillis2 = hdVar2.f4227g.I4 - (SystemClock.uptimeMillis() - hdVar2.f4227g.H4);
                                                                j6 = 0;
                                                            }
                                                        }
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        bitmap3 = bitmapWrapHardwareBuffer;
                                                        Log.e("MirrorPerf", "JPEG处理异常: " + e.getMessage());
                                                        if (bitmapCreateScaledBitmap != null && bitmapCreateScaledBitmap != bitmap3) {
                                                            bitmapCreateScaledBitmap.recycle();
                                                        }
                                                        if (bitmap3 != null && !bitmap3.isRecycled()) {
                                                            bitmap3.recycle();
                                                        }
                                                        if (hardwareBuffer3 != null) {
                                                            hardwareBuffer3.close();
                                                        }
                                                    }
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    bitmapCreateScaledBitmap = null;
                                                    bitmap3 = bitmapWrapHardwareBuffer;
                                                    Log.e("MirrorPerf", "JPEG处理异常: " + e.getMessage());
                                                    if (bitmapCreateScaledBitmap != null) {
                                                        bitmapCreateScaledBitmap.recycle();
                                                    }
                                                    if (bitmap3 != null) {
                                                        bitmap3.recycle();
                                                    }
                                                    if (hardwareBuffer3 != null) {
                                                        hardwareBuffer3.close();
                                                    }
                                                    jUptimeMillis2 = hdVar2.f4227g.I4 - (SystemClock.uptimeMillis() - hdVar2.f4227g.H4);
                                                    j6 = 0;
                                                    hdVar2.a(Math.max(j6, jUptimeMillis2));
                                                } catch (Throwable th) {
                                                    th = th;
                                                    bitmap2 = null;
                                                    bitmap = bitmapWrapHardwareBuffer;
                                                    if (0 != 0) {
                                                        bitmap2.recycle();
                                                    }
                                                    if (bitmap != 0) {
                                                        bitmap.recycle();
                                                    }
                                                    if (hardwareBuffer3 != null) {
                                                        try {
                                                            hardwareBuffer3.close();
                                                        } catch (Exception unused5) {
                                                        }
                                                    }
                                                    hdVar2.a(Math.max(0L, hdVar2.f4227g.I4 - (SystemClock.uptimeMillis() - hdVar2.f4227g.H4)));
                                                    throw th;
                                                }
                                            } else {
                                                bitmapCreateScaledBitmap = null;
                                            }
                                            if (bitmapCreateScaledBitmap != null && bitmapCreateScaledBitmap != bitmapWrapHardwareBuffer) {
                                                bitmapCreateScaledBitmap.recycle();
                                            }
                                            if (bitmapWrapHardwareBuffer != null && !bitmapWrapHardwareBuffer.isRecycled()) {
                                                bitmapWrapHardwareBuffer.recycle();
                                            }
                                            if (hardwareBuffer3 != null) {
                                                hardwareBuffer3.close();
                                            }
                                            jUptimeMillis2 = hdVar2.f4227g.I4 - (SystemClock.uptimeMillis() - hdVar2.f4227g.H4);
                                            j6 = 0;
                                        } else {
                                            if (hardwareBuffer3 != null) {
                                                try {
                                                    hardwareBuffer3.close();
                                                } catch (Exception unused6) {
                                                }
                                            }
                                            jUptimeMillis2 = hdVar2.f4227g.I4 - (SystemClock.uptimeMillis() - hdVar2.f4227g.H4);
                                            j6 = 0;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bitmap = screenshotResult2;
                                        if (0 != 0 && 0 != bitmap) {
                                            bitmap2.recycle();
                                        }
                                        if (bitmap != 0 && !bitmap.isRecycled()) {
                                            bitmap.recycle();
                                        }
                                        if (hardwareBuffer3 != null) {
                                            hardwareBuffer3.close();
                                        }
                                        hdVar2.a(Math.max(0L, hdVar2.f4227g.I4 - (SystemClock.uptimeMillis() - hdVar2.f4227g.H4)));
                                        throw th;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    bitmapWrapHardwareBuffer = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                    bitmapWrapHardwareBuffer = null;
                                }
                                hdVar2.a(Math.max(j6, jUptimeMillis2));
                            }
                        });
                    } catch (Throwable unused4) {
                        if (hardwareBuffer2 != null) {
                            try {
                                hardwareBuffer2.close();
                            } catch (Throwable unused5) {
                            }
                        }
                        hdVar.a(Math.max(200L, ScreenMirrorService.o6.f()));
                    }
                } catch (Throwable unused6) {
                    hdVar = this;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
