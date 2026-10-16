// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.media.ImageReader;
import android.util.Size;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b2 extends CameraCaptureSession.StateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f3541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CameraDevice f3543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Surface f3544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f3545e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ float f3546f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Rect f3547g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ImageReader f3548h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ e2 f3549i;

    public b2(e2 e2Var, long j3, long j4, CameraDevice cameraDevice, Surface surface, String str, float f3, Rect rect, ImageReader imageReader) {
        this.f3549i = e2Var;
        this.f3541a = j3;
        this.f3542b = j4;
        this.f3543c = cameraDevice;
        this.f3544d = surface;
        this.f3545e = str;
        this.f3546f = f3;
        this.f3547g = rect;
        this.f3548h = imageReader;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        e2.c(this.f3549i, "onConfigureFailed", cameraCaptureSession, this.f3543c, this.f3542b, new IllegalStateException("capture session configure failed"));
    }

    @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
    public final void onConfigured(CameraCaptureSession cameraCaptureSession) {
        CameraDevice cameraDevice;
        float f3;
        try {
            if (this.f3549i.m(this.f3541a, this.f3542b) && (cameraDevice = this.f3543c) == this.f3549i.n) {
                CaptureRequest.Builder builderCreateCaptureRequest = cameraDevice.createCaptureRequest(1);
                builderCreateCaptureRequest.addTarget(this.f3544d);
                builderCreateCaptureRequest.set(CaptureRequest.CONTROL_MODE, 1);
                synchronized (this.f3549i.f3848b) {
                    e2 e2Var = this.f3549i;
                    String str = this.f3545e;
                    c2 c2Var = e2Var.f3856j;
                    synchronized (c2Var) {
                        try {
                            f3 = "front".equals(str) ? c2Var.f3650a : c2Var.f3651b;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                float fG = e2.g(f3, this.f3546f);
                Rect rect = this.f3547g;
                if (rect != null) {
                    builderCreateCaptureRequest.set(CaptureRequest.SCALER_CROP_REGION, e2.f(rect, fG, this.f3546f));
                }
                if (!this.f3549i.m(this.f3541a, this.f3542b)) {
                    cameraCaptureSession.close();
                    return;
                }
                cameraCaptureSession.setRepeatingRequest(builderCreateCaptureRequest.build(), null, this.f3549i.f3858l);
                synchronized (this.f3549i.f3849c) {
                    try {
                        if (!this.f3549i.m(this.f3541a, this.f3542b)) {
                            cameraCaptureSession.close();
                            return;
                        }
                        e2 e2Var2 = this.f3549i;
                        e2Var2.f3860o = cameraCaptureSession;
                        e2Var2.f3862q = builderCreateCaptureRequest;
                        e2.d(e2Var2, new Size(this.f3548h.getWidth(), this.f3548h.getHeight()), this.f3541a);
                        return;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            cameraCaptureSession.close();
        } catch (Throwable th3) {
            e2.c(this.f3549i, "onConfigured", cameraCaptureSession, this.f3543c, this.f3542b, th3);
        }
    }
}
