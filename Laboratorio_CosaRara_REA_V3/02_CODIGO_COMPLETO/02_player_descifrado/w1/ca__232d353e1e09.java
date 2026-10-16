// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.util.Log;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ca implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f3670c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f3671d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ float f3672e;

    public /* synthetic */ ca(ScreenMirrorService screenMirrorService, float f3, float f4) {
        this.f3670c = screenMirrorService;
        this.f3671d = f3;
        this.f3672e = f4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScreenMirrorService screenMirrorService = this.f3670c;
        float f3 = this.f3671d;
        float f4 = this.f3672e;
        rd rdVar = ScreenMirrorService.n6;
        try {
            n3 n3Var = screenMirrorService.R3;
            if (n3Var == null) {
                return;
            }
            int iA = n3.a(f3, n3Var.f4617a);
            int iA2 = n3.a(f4, n3Var.f4618b);
            Path path = new Path();
            path.moveTo(iA, iA2);
            GestureDescription gestureDescriptionBuild = new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 80)).build();
            Log.i("ScreenMirror", "[Inject] TAP @ " + iA + "," + iA2 + " dur=80 locked=" + screenMirrorService.J3());
            screenMirrorService.W0(e4.f3869d, gestureDescriptionBuild, null, null);
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("[Ctrl] tap fail: "), "ScreenMirror");
        }
    }
}
