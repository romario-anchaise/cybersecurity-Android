// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Surface f938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HandlerThread f939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public EGLDisplay f942g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public EGLContext f943h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public EGLSurface f944i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f945j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f946k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SurfaceTexture f947l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Surface f948m;
    public int n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f949o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f950p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f951q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f952r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f953s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f954t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final float[] f955u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final FloatBuffer f956v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final FloatBuffer f957w;

    public r0(int i3, int i4, Surface surface) {
        this.f936a = i3;
        this.f937b = i4;
        this.f938c = surface;
        HandlerThread handlerThread = new HandlerThread("h264-blackout-gain");
        handlerThread.start();
        this.f939d = handlerThread;
        this.f940e = new Handler(handlerThread.getLooper());
        this.f941f = new AtomicBoolean(false);
        this.f942g = EGL14.EGL_NO_DISPLAY;
        this.f943h = EGL14.EGL_NO_CONTEXT;
        this.f944i = EGL14.EGL_NO_SURFACE;
        this.n = -1;
        this.f949o = -1;
        this.f950p = -1;
        this.f951q = -1;
        this.f952r = -1;
        this.f954t = Long.MIN_VALUE;
        this.f955u = new float[16];
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer.put(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
        floatBufferAsFloatBuffer.position(0);
        this.f956v = floatBufferAsFloatBuffer;
        FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        floatBufferAsFloatBuffer2.put(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
        floatBufferAsFloatBuffer2.position(0);
        this.f957w = floatBufferAsFloatBuffer2;
        try {
            i("initialize", new o0(this, 1));
            g0.d(true);
        } catch (Throwable th) {
            try {
                i("cleanup failed initialization", new o0(this, 2));
            } catch (Throwable unused) {
            }
            this.f939d.quitSafely();
            throw th;
        }
    }

    public static void a(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        throw new IllegalStateException((str + " failed: 0x" + Integer.toHexString(iGlGetError)).toString());
    }

    public static int b(String str, int i3) {
        int iGlCreateShader = GLES20.glCreateShader(i3);
        if (iGlCreateShader == 0) {
            b2.a.b("glCreateShader failed: ".concat(d()));
            return 0;
        }
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] == 1) {
            return iGlCreateShader;
        }
        String strGlGetShaderInfoLog = GLES20.glGetShaderInfoLog(iGlCreateShader);
        GLES20.glDeleteShader(iGlCreateShader);
        b2.a.f(strGlGetShaderInfoLog, "shader compile failed: ");
        return 0;
    }

    public static String c() {
        return "0x" + Integer.toHexString(EGL14.eglGetError());
    }

    public static String d() {
        return "0x" + Integer.toHexString(GLES20.glGetError());
    }

    public static void h(String str, int i3) {
        if (i3 >= 0) {
            return;
        }
        b2.a.b("shader location missing: ".concat(str));
    }

    public final void e() {
        EGLDisplay eGLDisplay = this.f942g;
        EGLSurface eGLSurface = this.f944i;
        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f943h)) {
            return;
        }
        b2.a.b("eglMakeCurrent failed: ".concat(c()));
    }

    public final void f() {
        HandlerThread handlerThread = this.f939d;
        if (this.f941f.compareAndSet(false, true)) {
            g0.d(false);
            try {
                i("release", new o0(this, 0));
                handlerThread.quitSafely();
            } catch (Throwable th) {
                try {
                    Log.w("H264BlackoutGain", "release failed: " + th.getMessage());
                } finally {
                    handlerThread.quitSafely();
                }
            }
        }
    }

    public final void g() {
        EGLContext eGLContext;
        EGLSurface eGLSurface;
        SurfaceTexture surfaceTexture = this.f947l;
        if (surfaceTexture != null) {
            surfaceTexture.setOnFrameAvailableListener(null);
        }
        Surface surface = this.f948m;
        if (surface != null) {
            surface.release();
        }
        this.f948m = null;
        SurfaceTexture surfaceTexture2 = this.f947l;
        if (surfaceTexture2 != null) {
            surfaceTexture2.release();
        }
        this.f947l = null;
        EGLDisplay eGLDisplay = this.f942g;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY && (eGLContext = this.f943h) != EGL14.EGL_NO_CONTEXT && (eGLSurface = this.f944i) != EGL14.EGL_NO_SURFACE) {
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
        }
        int i3 = this.f946k;
        if (i3 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i3}, 0);
            this.f946k = 0;
        }
        int i4 = this.f945j;
        if (i4 != 0) {
            GLES20.glDeleteProgram(i4);
            this.f945j = 0;
        }
        EGLDisplay eGLDisplay2 = this.f942g;
        if (eGLDisplay2 != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface2 = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface2, eGLSurface2, EGL14.EGL_NO_CONTEXT);
            EGLSurface eGLSurface3 = this.f944i;
            if (eGLSurface3 != EGL14.EGL_NO_SURFACE) {
                EGL14.eglDestroySurface(this.f942g, eGLSurface3);
            }
            EGLContext eGLContext2 = this.f943h;
            if (eGLContext2 != EGL14.EGL_NO_CONTEXT) {
                EGL14.eglDestroyContext(this.f942g, eGLContext2);
            }
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f942g);
        }
        this.f944i = EGL14.EGL_NO_SURFACE;
        this.f943h = EGL14.EGL_NO_CONTEXT;
        this.f942g = EGL14.EGL_NO_DISPLAY;
    }

    public final void i(String str, p1.a aVar) {
        if (Looper.myLooper() == this.f939d.getLooper()) {
            aVar.d();
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicReference atomicReference = new AtomicReference();
        if (!this.f940e.post(new q0(aVar, atomicReference, countDownLatch, 0))) {
            b2.a.b("failed to schedule H.264 gain bridge ".concat(str));
        } else {
            if (!countDownLatch.await(5000L, TimeUnit.MILLISECONDS)) {
                b2.a.b("timed out waiting for H.264 gain bridge ".concat(str));
                return;
            }
            Throwable th = (Throwable) atomicReference.get();
            if (th != null) {
                throw new IllegalStateException(a0.a.h("H.264 gain bridge ", str, " failed"), th);
            }
        }
    }
}
