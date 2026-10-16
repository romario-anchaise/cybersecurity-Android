// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.media.projection.MediaProjection;
import android.os.Handler;
import android.util.Log;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class vc extends MediaProjection.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f5333a;

    public vc(ScreenMirrorService screenMirrorService) {
        this.f5333a = screenMirrorService;
    }

    @Override // android.media.projection.MediaProjection.Callback
    public final void onStop() {
        Log.w("ScreenMirror", "MediaProjection.onStop —— 锁屏/系统暂停，回退到低速截屏通道");
        Handler handler = this.f5333a.T3;
        if (handler != null) {
            handler.post(new v8(6, this));
            return;
        }
        this.f5333a.P6();
        this.f5333a.m4 = null;
        this.f5333a.X6();
    }
}
