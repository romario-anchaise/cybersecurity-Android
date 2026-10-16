// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.graphics.Rect;
import android.hardware.camera2.CameraDevice;
import android.media.ImageReader;
import android.util.Log;
import android.view.Surface;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a2 extends CameraDevice.StateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g.j f3452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f3454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Rect f3455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ float f3456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f3457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ e2 f3458g;

    public a2(e2 e2Var, g.j jVar, long j3, long j4, Rect rect, float f3, String str) {
        this.f3458g = e2Var;
        this.f3452a = jVar;
        this.f3453b = j3;
        this.f3454c = j4;
        this.f3455d = rect;
        this.f3456e = f3;
        this.f3457f = str;
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onDisconnected(CameraDevice cameraDevice) {
        e2 e2Var = this.f3458g;
        g.j jVar = this.f3452a;
        try {
            jVar.a();
            e2Var.h(jVar);
            if (e2Var.i(cameraDevice, this.f3454c)) {
                return;
            }
            cameraDevice.close();
        } catch (Throwable th) {
            e2.b(e2Var, "onDisconnected", cameraDevice, this.f3454c, jVar, th);
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onError(CameraDevice cameraDevice, int i3) {
        e2 e2Var = this.f3458g;
        g.j jVar = this.f3452a;
        try {
            Log.w("CameraServer", "camera error " + i3);
            jVar.a();
            e2Var.h(jVar);
            if (e2Var.i(cameraDevice, this.f3454c)) {
                return;
            }
            cameraDevice.close();
        } catch (Throwable th) {
            e2.b(e2Var, "onError", cameraDevice, this.f3454c, jVar, th);
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onOpened(CameraDevice cameraDevice) {
        Object obj;
        boolean zM;
        try {
            g.j jVar = this.f3452a;
            synchronized (jVar) {
                if (jVar.f1413b != 1) {
                    obj = null;
                } else {
                    jVar.f1413b = 2;
                    obj = jVar.f1414c;
                }
            }
            ImageReader imageReader = (ImageReader) obj;
            if (imageReader == null) {
                cameraDevice.close();
                return;
            }
            synchronized (this.f3458g.f3849c) {
                try {
                    e2 e2Var = this.f3458g;
                    if (e2Var.f3861p == this.f3452a) {
                        e2Var.f3861p = null;
                    }
                    zM = e2Var.m(this.f3453b, this.f3454c);
                    if (zM) {
                        e2 e2Var2 = this.f3458g;
                        e2Var2.n = cameraDevice;
                        e2Var2.f3859m = imageReader;
                        e2Var2.f3863r = this.f3455d;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!zM) {
                cameraDevice.close();
                imageReader.close();
                return;
            }
            e2 e2Var3 = this.f3458g;
            Rect rect = this.f3455d;
            float f3 = this.f3456e;
            long j3 = this.f3453b;
            long j4 = this.f3454c;
            String str = this.f3457f;
            try {
                Surface surface = imageReader.getSurface();
                cameraDevice.createCaptureSession(Arrays.asList(surface), new b2(e2Var3, j3, j4, cameraDevice, surface, str, f3, rect, imageReader), e2Var3.f3858l);
            } catch (Throwable th2) {
                Log.w("CameraServer", "createCaptureSession failed", th2);
                try {
                    e2Var3.i(cameraDevice, j4);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th3) {
            e2.b(this.f3458g, "onOpened", cameraDevice, this.f3454c, this.f3452a, th3);
        }
    }
}
