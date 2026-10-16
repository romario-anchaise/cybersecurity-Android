// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Size;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import lyr.stable.runtime.ScreenMirrorService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e2 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final byte[] f3846w = {67, 65, 77, 49};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3848b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f3849c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a2.o f3850d = new a2.o();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ExecutorService f3851e = Executors.newSingleThreadExecutor(new a2.l(15));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f3852f = new AtomicBoolean(false);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f3853g = new AtomicBoolean(false);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicLong f3854h = new AtomicLong(0);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile String f3855i = "back";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c2 f3856j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HandlerThread f3857k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Handler f3858l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageReader f3859m;
    public CameraDevice n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CameraCaptureSession f3860o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public g.j f3861p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public CaptureRequest.Builder f3862q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Rect f3863r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicLong f3864s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AtomicLong f3865t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile long f3866u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f3867v;

    public e2(ScreenMirrorService screenMirrorService) {
        c2 c2Var = new c2();
        c2Var.f3650a = 1.0f;
        c2Var.f3651b = 1.0f;
        this.f3856j = c2Var;
        this.f3864s = new AtomicLong();
        this.f3865t = new AtomicLong();
        this.f3847a = screenMirrorService.getApplicationContext();
    }

    public static void a(e2 e2Var, y.e eVar) {
        try {
            e2Var.f3851e.execute(new z1(e2Var, eVar, 0));
        } catch (RejectedExecutionException unused) {
        }
    }

    public static void b(e2 e2Var, String str, CameraDevice cameraDevice, long j3, g.j jVar, Throwable th) {
        Log.w("CameraServer", str.concat(" callback failed"), th);
        try {
            jVar.a();
        } catch (Throwable unused) {
        }
        try {
            e2Var.h(jVar);
        } catch (Throwable unused2) {
        }
        try {
            if (e2Var.i(cameraDevice, j3) || cameraDevice == null) {
                return;
            }
            cameraDevice.close();
        } catch (Throwable unused3) {
        }
    }

    public static void c(e2 e2Var, String str, CameraCaptureSession cameraCaptureSession, CameraDevice cameraDevice, long j3, Throwable th) {
        Log.w("CameraServer", str.concat(" callback failed"), th);
        if (cameraCaptureSession != null) {
            try {
                cameraCaptureSession.close();
            } catch (Throwable unused) {
            }
        }
        try {
            e2Var.i(cameraDevice, j3);
        } catch (Throwable unused2) {
        }
    }

    public static void d(e2 e2Var, Size size, long j3) {
        OutputStream outputStream = (OutputStream) e2Var.f3850d.b(j3);
        if (outputStream == null) {
            return;
        }
        try {
            byte[] bArr = {0, 0, 0, 0, (byte) (size.getWidth() >> 24), (byte) (size.getWidth() >> 16), (byte) (size.getWidth() >> 8), (byte) size.getWidth(), (byte) (size.getHeight() >> 24), (byte) (size.getHeight() >> 16), (byte) (size.getHeight() >> 8), (byte) size.getHeight()};
            System.arraycopy(f3846w, 0, bArr, 0, 4);
            synchronized (outputStream) {
                outputStream.write(bArr);
                outputStream.flush();
            }
        } catch (IOException e3) {
            a0.a.m(e3, new StringBuilder("write CAM1 header failed: "), "CameraServer");
            e2Var.k(outputStream, j3);
        }
    }

    public static String e(CountDownLatch countDownLatch, c2.t tVar, String[] strArr, String str, String str2) {
        boolean z2;
        try {
            if (countDownLatch.await(3L, TimeUnit.SECONDS)) {
                return strArr[0];
            }
            z2 = false;
        } catch (InterruptedException unused) {
            z2 = true;
        }
        synchronized (tVar) {
            if (tVar.f458a == 1) {
                tVar.f458a = 4;
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                return y(str, str2.concat(z2 ? " interrupted" : " timed out"));
            }
            while (countDownLatch.getCount() != 0) {
                try {
                    countDownLatch.await();
                } catch (InterruptedException unused2) {
                    z2 = true;
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
            return strArr[0];
        }
    }

    public static Rect f(Rect rect, float f3, float f4) {
        int[] iArr;
        if (rect == null) {
            o2.i("sensor rect must be non-empty");
            return null;
        }
        int i3 = rect.left;
        int i4 = rect.top;
        int i5 = rect.right;
        int i6 = rect.bottom;
        int i7 = i5 - i3;
        int i8 = i6 - i4;
        if (i7 <= 0 || i8 <= 0) {
            o2.i("sensor rect must be non-empty");
            return null;
        }
        float fG = g(f3, f4);
        if (fG == 1.0f) {
            iArr = new int[]{i3, i4, i5, i6};
        } else {
            int iMax = Math.max(1, (int) Math.floor(i7 / fG));
            int iMax2 = Math.max(1, (int) Math.floor(i8 / fG));
            if (((iMax ^ i7) & 1) != 0) {
                iMax = iMax > 1 ? iMax - 1 : Math.min(2, i7);
            }
            if (((iMax2 ^ i8) & 1) != 0) {
                iMax2 = iMax2 > 1 ? iMax2 - 1 : Math.min(2, i8);
            }
            int i9 = ((i7 - iMax) / 2) + i3;
            int i10 = ((i8 - iMax2) / 2) + i4;
            iArr = new int[]{i9, i10, iMax + i9, iMax2 + i10};
        }
        return new Rect(iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    public static float g(float f3, float f4) {
        if (!Float.isFinite(f4) || f4 < 1.0f) {
            f4 = 1.0f;
        }
        if (!Float.isFinite(f3)) {
            f3 = 1.0f;
        }
        return Math.max(1.0f, Math.min(f3, f4));
    }

    public static String q(CameraManager cameraManager, String str) throws CameraAccessException {
        String[] cameraIdList = cameraManager.getCameraIdList();
        int length = cameraIdList.length;
        Integer[] numArr = new Integer[length];
        for (int i3 = 0; i3 < cameraIdList.length; i3++) {
            numArr[i3] = (Integer) cameraManager.getCameraCharacteristics(cameraIdList[i3]).get(CameraCharacteristics.LENS_FACING);
        }
        if (cameraIdList.length != length) {
            return null;
        }
        int i4 = !"front".equals(str) ? 1 : 0;
        for (int i5 = 0; i5 < cameraIdList.length; i5++) {
            Integer num = numArr[i5];
            if (num != null && num.intValue() == i4) {
                return cameraIdList[i5];
            }
        }
        return null;
    }

    public static float r(CameraCharacteristics cameraCharacteristics) {
        Float f3 = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f3 == null || !Float.isFinite(f3.floatValue()) || f3.floatValue() < 1.0f) {
            return 1.0f;
        }
        return f3.floatValue();
    }

    public static byte[] x(Image image) {
        Image.Plane[] planes = image.getPlanes();
        if (planes == null || planes.length < 3) {
            return null;
        }
        int width = image.getWidth();
        int height = image.getHeight();
        Image.Plane plane = planes[0];
        Image.Plane plane2 = planes[1];
        Image.Plane plane3 = planes[2];
        if (plane == null || plane2 == null || plane3 == null) {
            return null;
        }
        ByteBuffer buffer = plane.getBuffer();
        int rowStride = plane.getRowStride();
        int pixelStride = plane.getPixelStride();
        ByteBuffer buffer2 = plane2.getBuffer();
        int rowStride2 = plane2.getRowStride();
        int pixelStride2 = plane2.getPixelStride();
        ByteBuffer buffer3 = plane3.getBuffer();
        int rowStride3 = plane3.getRowStride();
        int pixelStride3 = plane3.getPixelStride();
        if (width <= 0 || height <= 0 || (width & 1) != 0 || (height & 1) != 0) {
            o2.i("YUV dimensions must be positive and even");
            return null;
        }
        long j3 = ((long) height) * ((long) width);
        if (j3 > 32000000) {
            o2.i("YUV frame too large");
            return null;
        }
        int i3 = width / 2;
        int i4 = height / 2;
        n4.X0(buffer, height, width, rowStride, pixelStride, "Y");
        n4.X0(buffer2, i4, i3, rowStride2, pixelStride2, "U");
        n4.X0(buffer3, i4, i3, rowStride3, pixelStride3, "V");
        long j4 = (((long) i4) * ((long) i3) * 2) + j3;
        if (j4 > 2147483647L) {
            o2.i("YUV frame length overflow");
            return null;
        }
        byte[] bArr = new byte[(int) j4];
        ByteBuffer byteBufferDuplicate = buffer.duplicate();
        ByteBuffer byteBufferDuplicate2 = buffer2.duplicate();
        ByteBuffer byteBufferDuplicate3 = buffer3.duplicate();
        int iPosition = byteBufferDuplicate.position();
        int iPosition2 = byteBufferDuplicate2.position();
        int iPosition3 = byteBufferDuplicate3.position();
        int i5 = 0;
        int i6 = 0;
        while (i5 < height) {
            int i7 = (i5 * rowStride) + iPosition;
            byte[] bArr2 = bArr;
            int i8 = 0;
            while (i8 < width) {
                bArr2[i6] = byteBufferDuplicate.get((i8 * pixelStride) + i7);
                i8++;
                i6++;
            }
            i5++;
            bArr = bArr2;
        }
        byte[] bArr3 = bArr;
        for (int i9 = 0; i9 < i4; i9++) {
            int i10 = (i9 * rowStride2) + iPosition2;
            int i11 = (i9 * rowStride3) + iPosition3;
            for (int i12 = 0; i12 < i3; i12++) {
                int i13 = i6 + 1;
                bArr3[i6] = byteBufferDuplicate3.get((i12 * pixelStride3) + i11);
                i6 += 2;
                bArr3[i13] = byteBufferDuplicate2.get((i12 * pixelStride2) + i10);
            }
        }
        YuvImage yuvImage = new YuvImage(bArr3, 17, width, height, null);
        s1 s1Var = new s1(8388608);
        if (yuvImage.compressToJpeg(new Rect(0, 0, width, height), 70, s1Var)) {
            return s1Var.toByteArray();
        }
        return null;
    }

    public static String y(String str, String str2) {
        try {
            JSONObject jSONObjectPut = new JSONObject().put("error", str);
            if (str2 == null) {
                str2 = "";
            }
            return jSONObjectPut.put("message", str2).toString();
        } catch (JSONException unused) {
            return "{\"error\":\"camera_zoom_failed\",\"message\":\"json encoding failed\"}";
        }
    }

    public static String z(float f3, float f4, String str) {
        try {
            return new JSONObject().put("ok", true).put("facing", str).put("ratio", f3).put("maxRatio", f4).toString();
        } catch (JSONException e3) {
            return y("camera_zoom_failed", e3.getMessage());
        }
    }

    public final void h(g.j jVar) {
        synchronized (this.f3849c) {
            try {
                if (this.f3861p == jVar) {
                    this.f3861p = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean i(CameraDevice cameraDevice, long j3) {
        return j(0L, false, cameraDevice, j3, true);
    }

    public final boolean j(long j3, boolean z2, CameraDevice cameraDevice, long j4, boolean z3) {
        synchronized (this.f3849c) {
            if (z2) {
                try {
                    if (this.f3866u != j3) {
                        return false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z3 && (this.n != cameraDevice || this.f3864s.get() != j4)) {
                return false;
            }
            this.f3864s.incrementAndGet();
            CameraCaptureSession cameraCaptureSession = this.f3860o;
            CameraDevice cameraDevice2 = this.n;
            ImageReader imageReader = this.f3859m;
            g.j jVar = this.f3861p;
            this.f3860o = null;
            this.n = null;
            this.f3859m = null;
            this.f3861p = null;
            this.f3862q = null;
            this.f3863r = null;
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.close();
                } catch (Throwable unused) {
                }
            }
            if (cameraDevice2 != null) {
                try {
                    cameraDevice2.close();
                } catch (Throwable unused2) {
                }
            }
            if (imageReader != null) {
                try {
                    imageReader.close();
                } catch (Throwable unused3) {
                }
            }
            if (jVar == null) {
                return true;
            }
            jVar.a();
            return true;
        }
    }

    public final void k(OutputStream outputStream, long j3) {
        d2.t tVar;
        a2.o oVar = this.f3850d;
        synchronized (oVar) {
            tVar = (d2.t) oVar.f124c;
        }
        if (tVar != null && ((g2.m0) tVar.f613d) == outputStream && tVar.f612c == j3) {
            a2.o oVar2 = this.f3850d;
            synchronized (oVar2) {
                d2.t tVar2 = (d2.t) oVar2.f124c;
                if (tVar2 != null && ((g2.m0) tVar2.f613d) == outputStream && tVar2.f612c == j3) {
                    oVar2.f124c = null;
                    oVar2.f122a++;
                    a(this, new y.e(tVar2, null));
                }
            }
        }
    }

    public final String l(final String str, final Float f3) {
        if (this.f3853g.get()) {
            return y("camera_closed", "camera server is closed");
        }
        if (!"front".equals(str) && !"back".equals(str)) {
            return y("invalid_facing", "facing must be front or back");
        }
        Handler handler = this.f3858l;
        if (handler == null || !this.f3852f.get()) {
            return p(str, f3, null, 0L, 0L);
        }
        final long j3 = this.f3866u;
        final long j4 = this.f3865t.get();
        final c2.t tVar = new c2.t(j3);
        final String[] strArr = new String[1];
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        return !handler.post(new Runnable() { // from class: w1.w1
            @Override // java.lang.Runnable
            public final void run() {
                e2 e2Var = this.f5376c;
                String[] strArr2 = strArr;
                String str2 = str;
                Float f4 = f3;
                c2.t tVar2 = tVar;
                long j5 = j3;
                long j6 = j4;
                CountDownLatch countDownLatch2 = countDownLatch;
                try {
                    strArr2[0] = e2Var.p(str2, f4, tVar2, j5, j6);
                } finally {
                    countDownLatch2.countDown();
                }
            }
        }) ? y("camera_zoom_failed", "camera handler unavailable") : e(countDownLatch, tVar, strArr, "camera_zoom_failed", "camera zoom");
    }

    public final boolean m(long j3, long j4) {
        return n(j3) && this.f3864s.get() == j4;
    }

    public final boolean n(long j3) {
        return j3 != 0 && this.f3852f.get() && this.f3866u == j3 && this.f3850d.b(j3) != null;
    }

    public final void o(final long j3) {
        String str;
        Size size;
        boolean zM;
        if (n(j3)) {
            try {
                synchronized (this.f3849c) {
                    try {
                        if (n(j3)) {
                            long jIncrementAndGet = this.f3864s.incrementAndGet();
                            synchronized (this.f3848b) {
                                str = this.f3855i;
                            }
                            CameraManager cameraManager = (CameraManager) this.f3847a.getSystemService("camera");
                            if (cameraManager == null) {
                                return;
                            }
                            String strQ = q(cameraManager, str);
                            if (strQ == null) {
                                Log.w("CameraServer", "no camera for lens=" + str);
                                return;
                            }
                            CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(strQ);
                            Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
                            float fR = r(cameraCharacteristics);
                            Size[] outputSizes = ((StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(35);
                            if (outputSizes == null || outputSizes.length == 0) {
                                size = new Size(640, 480);
                            } else {
                                int i3 = 0;
                                size = outputSizes[0];
                                int length = outputSizes.length;
                                int i4 = Integer.MAX_VALUE;
                                while (i3 < length) {
                                    Size size2 = outputSizes[i3];
                                    int height = size2.getHeight() * size2.getWidth();
                                    Size[] sizeArr = outputSizes;
                                    if (height >= 307200 && height < i4) {
                                        i4 = height;
                                        size = size2;
                                    }
                                    i3++;
                                    outputSizes = sizeArr;
                                }
                            }
                            if (m(j3, jIncrementAndGet)) {
                                ImageReader imageReaderNewInstance = ImageReader.newInstance(size.getWidth(), size.getHeight(), 35, 2);
                                g.j jVar = new g.j(imageReaderNewInstance, new d2.b(1));
                                try {
                                    synchronized (this.f3849c) {
                                        try {
                                            zM = m(j3, jIncrementAndGet);
                                            if (zM) {
                                                this.f3861p = jVar;
                                            }
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    }
                                    if (!zM) {
                                        jVar.a();
                                        return;
                                    }
                                    imageReaderNewInstance.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: w1.v1
                                        @Override // android.media.ImageReader.OnImageAvailableListener
                                        public final void onImageAvailable(ImageReader imageReader) {
                                            Image imageAcquireLatestImage;
                                            e2 e2Var = this.f5284a;
                                            long j4 = j3;
                                            Image image = null;
                                            try {
                                                try {
                                                    if (e2Var.n(j4)) {
                                                        long jCurrentTimeMillis = System.currentTimeMillis();
                                                        if (jCurrentTimeMillis - e2Var.f3867v < 100) {
                                                            imageAcquireLatestImage = imageReader.acquireLatestImage();
                                                            if (imageAcquireLatestImage == null) {
                                                                return;
                                                            }
                                                        } else {
                                                            e2Var.f3867v = jCurrentTimeMillis;
                                                            imageAcquireLatestImage = imageReader.acquireLatestImage();
                                                            if (imageAcquireLatestImage != null) {
                                                                byte[] bArrX = e2.x(imageAcquireLatestImage);
                                                                if (bArrX != null) {
                                                                    e2Var.w(bArrX, j4);
                                                                }
                                                            } else if (imageAcquireLatestImage == null) {
                                                                return;
                                                            }
                                                        }
                                                        imageAcquireLatestImage.close();
                                                    }
                                                } catch (Throwable th2) {
                                                    try {
                                                        Log.w("CameraServer", "image callback dropped frame", th2);
                                                        if (0 != 0) {
                                                            image.close();
                                                        }
                                                    } catch (Throwable th3) {
                                                        if (0 != 0) {
                                                            try {
                                                                image.close();
                                                            } catch (Throwable unused) {
                                                            }
                                                        }
                                                        throw th3;
                                                    }
                                                }
                                            } catch (Throwable unused2) {
                                            }
                                        }
                                    }, this.f3858l);
                                    if (m(j3, jIncrementAndGet)) {
                                        cameraManager.openCamera(strQ, new a2(this, jVar, j3, jIncrementAndGet, rect, fR, str), this.f3858l);
                                    } else {
                                        jVar.a();
                                    }
                                } catch (Throwable th2) {
                                    try {
                                        jVar.a();
                                    } catch (Throwable unused) {
                                    }
                                    try {
                                        h(jVar);
                                    } catch (Throwable unused2) {
                                    }
                                    Log.w("CameraServer", "openCamera setup failed", th2);
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                Log.w("CameraServer", "openCamera failed", th4);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006a, code lost:
    
        if (r19.a(n(r3) ? r3 : 0) == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String p(java.lang.String r17, java.lang.Float r18, c2.t r19, long r20, long r22) {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.e2.p(java.lang.String, java.lang.Float, c2.t, long, long):java.lang.String");
    }

    public final void s(long j3) {
        if (this.f3853g.get() || this.f3850d.b(j3) == null || this.f3852f.getAndSet(true)) {
            return;
        }
        this.f3866u = j3;
        if (this.f3847a.checkSelfPermission("android.permission.CAMERA") != 0) {
            Log.w("CameraServer", "camera permission missing");
            this.f3852f.set(false);
            if (this.f3866u == j3) {
                this.f3866u = 0L;
                return;
            }
            return;
        }
        HandlerThread handlerThread = new HandlerThread("camera-server");
        this.f3857k = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.f3857k.getLooper());
        this.f3858l = handler;
        handler.post(new y1(this, j3, 1));
    }

    public final boolean t(long j3) {
        if (this.f3866u != j3) {
            return true;
        }
        this.f3852f.set(false);
        Handler handler = this.f3858l;
        if (handler != null) {
            handler.post(new y1(this, j3, 0));
        }
        HandlerThread handlerThread = this.f3857k;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            try {
                handlerThread.join(3000L);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            if (handlerThread.isAlive()) {
                Log.w("CameraServer", "camera thread did not stop generation=" + j3);
                return false;
            }
        }
        if (this.f3866u != j3) {
            return true;
        }
        this.f3857k = null;
        this.f3858l = null;
        this.f3866u = 0L;
        return true;
    }

    public final void u() {
        long j3 = this.f3866u;
        while (j3 != 0 && !t(j3)) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
        }
        if (j3 == 0) {
            j(0L, false, null, 0L, false);
        }
    }

    public final boolean v(String str, long j3) {
        if (n(j3)) {
            synchronized (this.f3848b) {
                try {
                    if (!n(j3)) {
                        return false;
                    }
                    if (str.equals(this.f3855i)) {
                        return true;
                    }
                    this.f3865t.incrementAndGet();
                    this.f3855i = str;
                    this.f3856j.a(1.0f, Float.MAX_VALUE, str);
                    j(0L, false, null, 0L, false);
                    if (n(j3)) {
                        o(j3);
                        return n(j3);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return false;
    }

    public final void w(byte[] bArr, long j3) {
        OutputStream outputStream = (OutputStream) this.f3850d.b(j3);
        if (outputStream != null) {
            try {
                long jIncrementAndGet = this.f3854h.incrementAndGet();
                byte[] bArr2 = new byte[bArr.length + 16];
                System.arraycopy(f3846w, 0, bArr2, 0, 4);
                bArr2[4] = (byte) (jIncrementAndGet >> 56);
                bArr2[5] = (byte) (jIncrementAndGet >> 48);
                bArr2[6] = (byte) (jIncrementAndGet >> 40);
                bArr2[7] = (byte) (jIncrementAndGet >> 32);
                bArr2[8] = (byte) (jIncrementAndGet >> 24);
                bArr2[9] = (byte) (jIncrementAndGet >> 16);
                bArr2[10] = (byte) (jIncrementAndGet >> 8);
                bArr2[11] = (byte) jIncrementAndGet;
                int length = bArr.length;
                bArr2[12] = (byte) (length >> 24);
                bArr2[13] = (byte) (length >> 16);
                bArr2[14] = (byte) (length >> 8);
                bArr2[15] = (byte) length;
                System.arraycopy(bArr, 0, bArr2, 16, length);
                synchronized (outputStream) {
                    outputStream.write(bArr2);
                    outputStream.flush();
                }
            } catch (IOException e3) {
                a0.a.m(e3, new StringBuilder("write frame failed: "), "CameraServer");
                k(outputStream, j3);
            }
        }
    }
}
