// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.HardwareRenderer;
import android.graphics.Paint;
import android.graphics.RecordingCanvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.RenderNode;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Locale;
import w1.o2;
import w1.t9;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f720a = {78, 83, 86};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f721b = new Object();

    public static final int a(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        int i12 = (((i5 >>> i11) & 255) * i6) + (((i3 >>> i11) & 255) * i4);
        return y.f.e((((((((i8 >>> i11) & 255) * i6) + (((i7 >>> i11) & 255) * i4)) * i10) + (i12 * i9)) + 32768) >>> 16, 255);
    }

    public static void b(Context context, long j3) {
        synchronized (f721b) {
            try {
                SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("rtc_safety_v1", 0);
                int iA = a0.a.a(sharedPreferences.getString("mode", "normal"));
                long j4 = sharedPreferences.getLong("trial_health_started_ms", 0L);
                if (iA != 3 || j4 <= 0 || j3 < j4 || j3 - j4 < 1800000) {
                    return;
                }
                sharedPreferences.edit().putString("mode", "normal").putString("reason", "recovery_trial_healthy").putLong("since_ms", 0L).remove("trial_request_id").remove("trial_started_ms").remove("trial_health_started_ms").commit();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static final Bitmap c(Bitmap bitmap, int i3, int i4) throws Throwable {
        Image imageAcquireNextImage;
        HardwareBuffer hardwareBuffer;
        if (bitmap.isRecycled()) {
            o2.i("source bitmap is recycled");
            return null;
        }
        d0 d0VarD = d(bitmap.getWidth(), bitmap.getHeight(), i3, i4);
        int i5 = d0VarD.f747f;
        int i6 = d0VarD.f746e;
        int i7 = d0VarD.f745d;
        int i8 = d0VarD.f744c;
        Bitmap bitmap2 = null;
        if (bitmap.getConfig() != Bitmap.Config.HARDWARE) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.getClass();
            try {
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.drawColor(-16777216);
                canvas.drawBitmap(bitmap, (Rect) null, new RectF(i8, i7, i8 + i6, i7 + i5), new Paint(7));
                return bitmapCreateBitmap;
            } catch (Throwable th) {
                bitmapCreateBitmap.recycle();
                throw th;
            }
        }
        String str = Build.FINGERPRINT;
        String str2 = Build.HARDWARE;
        String str3 = Build.PRODUCT;
        if (str == null) {
            str = "";
        }
        Locale locale = Locale.ROOT;
        locale.getClass();
        String lowerCase = str.toLowerCase(locale);
        lowerCase.getClass();
        if (str2 == null) {
            str2 = "";
        }
        String lowerCase2 = str2.toLowerCase(locale);
        lowerCase2.getClass();
        if (str3 == null) {
            str3 = "";
        }
        String lowerCase3 = str3.toLowerCase(locale);
        lowerCase3.getClass();
        if (v1.l.z(lowerCase, "generic", false) || v1.d.B(lowerCase, "/sdk_gphone") || v1.d.B(lowerCase2, "goldfish") || v1.d.B(lowerCase2, "ranchu") || v1.l.z(lowerCase3, "sdk_gphone", false) || v1.d.B(lowerCase3, "emulator")) {
            Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
            if (bitmapCopy == null) {
                o2.k("emulator screenshot software copy failed");
                return null;
            }
            try {
                return c(bitmapCopy, i3, i4);
            } finally {
                bitmapCopy.recycle();
            }
        }
        ImageReader imageReaderNewInstance = ImageReader.newInstance(d0VarD.f742a, d0VarD.f743b, 1, 2, 771L);
        imageReaderNewInstance.getClass();
        HardwareRenderer hardwareRenderer = new HardwareRenderer();
        try {
            RenderNode renderNode = new RenderNode("MirrorScreenshotContain");
            renderNode.setPosition(0, 0, d0VarD.f742a, d0VarD.f743b);
            RecordingCanvas recordingCanvasBeginRecording = renderNode.beginRecording();
            recordingCanvasBeginRecording.getClass();
            try {
                recordingCanvasBeginRecording.drawColor(-16777216);
                recordingCanvasBeginRecording.drawBitmap(bitmap, (Rect) null, new RectF(i8, i7, i8 + i6, i7 + i5), new Paint(7));
                renderNode.endRecording();
                hardwareRenderer.setSurface(imageReaderNewInstance.getSurface());
                hardwareRenderer.setContentRoot(renderNode);
                int iSyncAndDraw = hardwareRenderer.createRenderRequest().setWaitForPresent(true).syncAndDraw();
                if (iSyncAndDraw != 0) {
                    throw new IllegalStateException(("hardware screenshot scaling failed: sync=" + iSyncAndDraw).toString());
                }
                imageAcquireNextImage = imageReaderNewInstance.acquireNextImage();
                if (imageAcquireNextImage == null) {
                    throw new IllegalStateException("hardware screenshot scaling produced no image");
                }
                try {
                    hardwareBuffer = imageAcquireNextImage.getHardwareBuffer();
                    if (hardwareBuffer == null) {
                        throw new IllegalStateException("hardware screenshot scaling produced no buffer");
                    }
                    try {
                        Bitmap bitmapWrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer, null);
                        if (bitmapWrapHardwareBuffer == null) {
                            throw new IllegalStateException("hardware screenshot scaling bitmap wrap failed");
                        }
                        try {
                            Bitmap bitmapCopy2 = bitmapWrapHardwareBuffer.copy(Bitmap.Config.ARGB_8888, false);
                            if (bitmapCopy2 == null) {
                                throw new IllegalStateException("hardware screenshot scaling software copy failed");
                            }
                            bitmapWrapHardwareBuffer.recycle();
                            hardwareBuffer.close();
                            imageAcquireNextImage.close();
                            try {
                                hardwareRenderer.destroy();
                                return bitmapCopy2;
                            } finally {
                                imageReaderNewInstance.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bitmap2 = bitmapWrapHardwareBuffer;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    hardwareBuffer = null;
                }
                if (bitmap2 != null) {
                    bitmap2.recycle();
                }
                if (hardwareBuffer != null) {
                    hardwareBuffer.close();
                }
                if (imageAcquireNextImage != null) {
                    imageAcquireNextImage.close();
                }
                try {
                    hardwareRenderer.destroy();
                    throw th;
                } finally {
                    imageReaderNewInstance.close();
                }
            } catch (Throwable th5) {
                renderNode.endRecording();
                throw th5;
            }
        } catch (Throwable th6) {
            th = th6;
            imageAcquireNextImage = null;
            hardwareBuffer = null;
        }
    }

    public static final d0 d(int i3, int i4, int i5, int i6) {
        if (i3 <= 0 || i4 <= 0) {
            o2.i("Failed requirement.");
            return null;
        }
        if (i5 <= 0 || i6 <= 0) {
            o2.i("Failed requirement.");
            return null;
        }
        double d3 = i3;
        double d4 = i4;
        double dMin = Math.min(((double) i5) / d3, ((double) i6) / d4);
        int iMin = Math.min(i5, Math.max(1, q2.k.o(d3 * dMin)));
        int iMin2 = Math.min(i6, Math.max(1, q2.k.o(d4 * dMin)));
        return new d0(i5, i6, (i5 - iMin) / 2, (i6 - iMin2) / 2, iMin, iMin2);
    }

    public static u1 e(Context context) {
        u1 u1VarI;
        synchronized (f721b) {
            try {
                Context applicationContext = context.getApplicationContext();
                SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("rtc_safety_v1", 0);
                int i3 = t9.f5179j;
                if (sharedPreferences.getInt("mode_version", i3) != i3) {
                    sharedPreferences.edit().putString("mode", "normal").putInt("mode_version", i3).putString("reason", "runtime_version_changed").putLong("since_ms", 0L).remove("trial_request_id").remove("trial_started_ms").remove("trial_health_started_ms").commit();
                }
                u1VarI = i(applicationContext);
            } catch (Throwable th) {
                throw th;
            }
        }
        return u1VarI;
    }

    public static final ArrayList f(long j3, byte[] bArr, boolean z2) {
        byte[] byteArray;
        bArr.getClass();
        if (bArr.length > 61440) {
            o2.i("node snapshot exceeds v3 decompression limit");
            return null;
        }
        int i3 = (!z2 || bArr.length <= 4096) ? 0 : 1;
        if (i3 != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length / 2);
            a1 a1Var = new a1(byteArrayOutputStream);
            try {
                a1Var.write(bArr);
                a1Var.close();
                byteArray = byteArrayOutputStream.toByteArray();
                byteArray.getClass();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    y.f.c(a1Var, th);
                    throw th2;
                }
            }
        } else {
            byteArray = bArr;
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(byteArray.length + 5).order(ByteOrder.BIG_ENDIAN);
        byteBufferOrder.put((byte) i3);
        byteBufferOrder.putInt(bArr.length);
        byteBufferOrder.put(byteArray);
        byte[] bArrArray = byteBufferOrder.array();
        if (bArrArray.length <= 65536) {
            return g(3, j3, bArrArray);
        }
        o2.i("encoded node snapshot too large");
        return null;
    }

    public static ArrayList g(int i3, long j3, byte[] bArr) {
        if (1 > i3 || i3 >= 4) {
            o2.i("Failed requirement.");
            return null;
        }
        if (j3 < 0) {
            o2.i("Failed requirement.");
            return null;
        }
        if (bArr.length > 65536) {
            o2.i("node snapshot too large");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        int i5 = 0;
        while (i5 < bArr.length) {
            int i6 = i5 + 1184;
            int iMin = Math.min(i6, bArr.length);
            if (i3 < 3 && iMin < bArr.length) {
                while (iMin > i5 && (bArr[iMin] & 192) == 128) {
                    iMin--;
                }
                if (iMin == i5) {
                    iMin = Math.min(i6, bArr.length);
                }
            }
            arrayList.add(i1.h.u(bArr, i5, iMin));
            i5 = iMin;
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new byte[0]);
        }
        if (arrayList.size() > 64) {
            o2.i("node snapshot has too many chunks");
            return null;
        }
        ArrayList arrayList2 = new ArrayList(i1.k.A(arrayList));
        int size = arrayList.size();
        int i7 = 0;
        while (i7 < size) {
            Object obj = arrayList.get(i7);
            i7++;
            int i8 = i4 + 1;
            if (i4 < 0) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            byte[] bArr2 = (byte[]) obj;
            ByteBuffer byteBufferOrder = ByteBuffer.allocate(bArr2.length + 16).order(ByteOrder.BIG_ENDIAN);
            byteBufferOrder.put(f720a);
            byteBufferOrder.put((byte) i3);
            byteBufferOrder.putLong(j3);
            byteBufferOrder.putShort((short) i4);
            byteBufferOrder.putShort((short) arrayList.size());
            byteBufferOrder.put(bArr2);
            arrayList2.add(byteBufferOrder.array());
            i4 = i8;
        }
        return arrayList2;
    }

    public static final e0 h(int i3, int i4, int i5) {
        if (i3 <= 0 || i4 <= 0) {
            o2.i("Failed requirement.");
            return null;
        }
        if (i5 <= 0) {
            o2.i("Failed requirement.");
            return null;
        }
        long j3 = i5;
        long j4 = 20;
        long j5 = 2;
        long j6 = 2147483646;
        return new e0((int) y.f.f((((((long) i3) * j3) / j4) / j5) * j5, j5, j6), (int) y.f.f((((((long) i4) * j3) / j4) / j5) * j5, j5, j6));
    }

    public static u1 i(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("rtc_safety_v1", 0);
        return new u1(a0.a.a(sharedPreferences.getString("mode", "normal")), sharedPreferences.getString("reason", ""), sharedPreferences.getLong("since_ms", 0L), sharedPreferences.getLong("trial_started_ms", 0L), sharedPreferences.getLong("trial_health_started_ms", 0L));
    }
}
