// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Log;
import android.view.Surface;
import java.nio.Buffer;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o0 implements p1.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ r0 f910d;

    public /* synthetic */ o0(r0 r0Var, int i3) {
        this.f909c = i3;
        this.f910d = r0Var;
    }

    @Override // p1.a
    public final Object d() {
        int i3 = this.f909c;
        final r0 r0Var = this.f910d;
        switch (i3) {
            case 0:
                r0Var.g();
                break;
            case 1:
                Surface surface = r0Var.f938c;
                int i4 = r0Var.f937b;
                int i5 = r0Var.f936a;
                if (i5 <= 0 || i4 <= 0) {
                    o2.h(a0.a.f(i5, i4, "invalid H.264 bridge size ", "x"));
                    return null;
                }
                if (!surface.isValid()) {
                    o2.i("encoder input surface is invalid");
                    return null;
                }
                EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
                r0Var.f942g = eGLDisplayEglGetDisplay;
                if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
                    o2.k("eglGetDisplay failed");
                    return null;
                }
                int[] iArr = new int[2];
                if (!EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
                    b2.a.b("eglInitialize failed: ".concat(r0.c()));
                    return null;
                }
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                int[] iArr2 = new int[1];
                if (!EGL14.eglChooseConfig(r0Var.f942g, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0) || iArr2[0] <= 0) {
                    b2.a.b("eglChooseConfig failed: ".concat(r0.c()));
                    return null;
                }
                EGLConfig eGLConfig = eGLConfigArr[0];
                if (eGLConfig == null) {
                    o2.k("Required value was null.");
                    return null;
                }
                EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(r0Var.f942g, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                r0Var.f943h = eGLContextEglCreateContext;
                if (eGLContextEglCreateContext == EGL14.EGL_NO_CONTEXT) {
                    b2.a.b("eglCreateContext failed: ".concat(r0.c()));
                    return null;
                }
                EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(r0Var.f942g, eGLConfig, surface, new int[]{12344}, 0);
                r0Var.f944i = eGLSurfaceEglCreateWindowSurface;
                if (eGLSurfaceEglCreateWindowSurface == EGL14.EGL_NO_SURFACE) {
                    b2.a.b("eglCreateWindowSurface failed: ".concat(r0.c()));
                    return null;
                }
                r0Var.e();
                int iB = r0.b("\n            attribute vec4 aPosition;\n            attribute vec4 aTextureCoordinate;\n            uniform mat4 uTextureMatrix;\n            varying vec2 vTextureCoordinate;\n            void main() {\n                gl_Position = aPosition;\n                vTextureCoordinate = (uTextureMatrix * aTextureCoordinate).xy;\n            }\n        ", 35633);
                int iB2 = r0.b("\n            #extension GL_OES_EGL_image_external : require\n            precision mediump float;\n            uniform samplerExternalOES uTexture;\n            uniform float uGain;\n            varying vec2 vTextureCoordinate;\n            void main() {\n                vec4 color = texture2D(uTexture, vTextureCoordinate);\n                gl_FragColor = vec4(min(color.rgb * uGain, vec3(1.0)), color.a);\n            }\n        ", 35632);
                try {
                    int iGlCreateProgram = GLES20.glCreateProgram();
                    if (iGlCreateProgram == 0) {
                        throw new IllegalStateException("glCreateProgram failed: ".concat(r0.d()).toString());
                    }
                    GLES20.glAttachShader(iGlCreateProgram, iB);
                    GLES20.glAttachShader(iGlCreateProgram, iB2);
                    GLES20.glLinkProgram(iGlCreateProgram);
                    int[] iArr3 = new int[1];
                    GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr3, 0);
                    if (iArr3[0] != 1) {
                        throw new IllegalStateException(("program link failed: " + GLES20.glGetProgramInfoLog(iGlCreateProgram)).toString());
                    }
                    GLES20.glDeleteShader(iB);
                    GLES20.glDeleteShader(iB2);
                    r0Var.f945j = iGlCreateProgram;
                    int iGlGetAttribLocation = GLES20.glGetAttribLocation(iGlCreateProgram, "aPosition");
                    r0.h("aPosition", iGlGetAttribLocation);
                    r0Var.n = iGlGetAttribLocation;
                    int iGlGetAttribLocation2 = GLES20.glGetAttribLocation(r0Var.f945j, "aTextureCoordinate");
                    r0.h("aTextureCoordinate", iGlGetAttribLocation2);
                    r0Var.f949o = iGlGetAttribLocation2;
                    int iGlGetUniformLocation = GLES20.glGetUniformLocation(r0Var.f945j, "uTextureMatrix");
                    r0.h("uTextureMatrix", iGlGetUniformLocation);
                    r0Var.f950p = iGlGetUniformLocation;
                    int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(r0Var.f945j, "uTexture");
                    r0.h("uTexture", iGlGetUniformLocation2);
                    r0Var.f951q = iGlGetUniformLocation2;
                    int iGlGetUniformLocation3 = GLES20.glGetUniformLocation(r0Var.f945j, "uGain");
                    r0.h("uGain", iGlGetUniformLocation3);
                    r0Var.f952r = iGlGetUniformLocation3;
                    int[] iArr4 = new int[1];
                    GLES20.glGenTextures(1, iArr4, 0);
                    int i6 = iArr4[0];
                    r0Var.f946k = i6;
                    if (i6 == 0) {
                        b2.a.b("glGenTextures failed: ".concat(r0.d()));
                        return null;
                    }
                    GLES20.glBindTexture(36197, i6);
                    GLES20.glTexParameteri(36197, 10241, 9729);
                    GLES20.glTexParameteri(36197, 10240, 9729);
                    GLES20.glTexParameteri(36197, 10242, 33071);
                    GLES20.glTexParameteri(36197, 10243, 33071);
                    r0.a("configure external texture");
                    SurfaceTexture surfaceTexture = new SurfaceTexture(r0Var.f946k);
                    surfaceTexture.setDefaultBufferSize(i5, i4);
                    surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: e2.p0
                        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                        public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                            SurfaceTexture surfaceTexture3;
                            r0 r0Var2 = r0Var;
                            float[] fArr = r0Var2.f955u;
                            if (r0Var2.f941f.get() || (surfaceTexture3 = r0Var2.f947l) == null) {
                                return;
                            }
                            try {
                                r0Var2.e();
                                surfaceTexture3.updateTexImage();
                                surfaceTexture3.getTransformMatrix(fArr);
                                long timestamp = surfaceTexture3.getTimestamp();
                                long j3 = (1000000000 / ((long) 30)) - 1000000;
                                if (j3 < 1) {
                                    j3 = 1;
                                }
                                long j4 = r0Var2.f954t;
                                if (j4 == Long.MIN_VALUE || timestamp <= j4 || timestamp - j4 >= j3) {
                                    r0Var2.f954t = timestamp;
                                    float f3 = ((f0) g0.f808b.get()).f796c;
                                    float fD = Math.abs(f3) <= Float.MAX_VALUE ? y.f.d(f3, 1.0f, 50.0f) : 1.0f;
                                    GLES20.glViewport(0, 0, r0Var2.f936a, r0Var2.f937b);
                                    GLES20.glUseProgram(r0Var2.f945j);
                                    GLES20.glActiveTexture(33984);
                                    GLES20.glBindTexture(36197, r0Var2.f946k);
                                    GLES20.glUniform1i(r0Var2.f951q, 0);
                                    GLES20.glUniform1f(r0Var2.f952r, fD);
                                    GLES20.glUniformMatrix4fv(r0Var2.f950p, 1, false, fArr, 0);
                                    r0Var2.f956v.position(0);
                                    GLES20.glEnableVertexAttribArray(r0Var2.n);
                                    GLES20.glVertexAttribPointer(r0Var2.n, 2, 5126, false, 0, (Buffer) r0Var2.f956v);
                                    r0Var2.f957w.position(0);
                                    GLES20.glEnableVertexAttribArray(r0Var2.f949o);
                                    GLES20.glVertexAttribPointer(r0Var2.f949o, 2, 5126, false, 0, (Buffer) r0Var2.f957w);
                                    GLES20.glDrawArrays(5, 0, 4);
                                    GLES20.glDisableVertexAttribArray(r0Var2.n);
                                    GLES20.glDisableVertexAttribArray(r0Var2.f949o);
                                    r0.a("draw frame");
                                    if (timestamp > 0) {
                                        EGLExt.eglPresentationTimeANDROID(r0Var2.f942g, r0Var2.f944i, timestamp);
                                    }
                                    if (!EGL14.eglSwapBuffers(r0Var2.f942g, r0Var2.f944i)) {
                                        throw new IllegalStateException("eglSwapBuffers failed: ".concat(r0.c()).toString());
                                    }
                                    r0Var2.f953s = 0;
                                    g0.d(true);
                                }
                            } catch (Throwable th) {
                                int i7 = r0Var2.f953s + 1;
                                r0Var2.f953s = i7;
                                if (i7 == 1 || i7 % 30 == 0) {
                                    Log.w("H264BlackoutGain", "frame draw failed count=" + i7 + ": " + th.getMessage());
                                }
                                if (r0Var2.f953s >= 3) {
                                    g0.d(false);
                                }
                            }
                        }
                    }, r0Var.f940e);
                    r0Var.f947l = surfaceTexture;
                    r0Var.f948m = new Surface(surfaceTexture);
                    Log.i("H264BlackoutGain", "initialized " + i5 + "x" + i4 + " pre-H264 RGB gain at <=30fps");
                    return h1.e.f1953c;
                } catch (Throwable th) {
                    GLES20.glDeleteShader(iB);
                    GLES20.glDeleteShader(iB2);
                    throw th;
                }
            default:
                r0Var.g();
                break;
        }
        return h1.e.f1953c;
    }
}
