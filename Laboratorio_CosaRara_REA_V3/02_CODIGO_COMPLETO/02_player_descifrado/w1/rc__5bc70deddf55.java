// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.os.Handler;
import android.util.Log;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class rc extends n {
    public final /* synthetic */ Handler P;
    public final /* synthetic */ AccessibilityService.GestureResultCallback Q;
    public final /* synthetic */ GestureDescription R;
    public final /* synthetic */ ScreenMirrorService S;

    public rc(ScreenMirrorService screenMirrorService, Handler handler, AccessibilityService.GestureResultCallback gestureResultCallback, GestureDescription gestureDescription) {
        this.S = screenMirrorService;
        this.P = handler;
        this.Q = gestureResultCallback;
        this.R = gestureDescription;
    }

    @Override // w1.n
    public final void Y() {
        ScreenMirrorService.d(this.S, this.P, new bb(this.Q, this.R, 7));
    }

    @Override // w1.n
    public final void Z() {
        ScreenMirrorService.d(this.S, this.P, new bb(this.Q, this.R, 5));
    }

    @Override // w1.n
    public final void b0() {
        ScreenMirrorService.d(this.S, this.P, new bb(this.Q, this.R, 4));
    }

    @Override // w1.n
    public final void c0(int i3) {
        ScreenMirrorService.d(this.S, this.P, new bb(this.Q, this.R, 2));
    }

    @Override // w1.n
    public final void d0(int i3) {
        ScreenMirrorService.d(this.S, this.P, new bb(this.Q, this.R, 6));
    }

    @Override // w1.n
    public final void e0() {
        Log.w("ScreenMirror", "[Gesture] remote callback timeout");
        ScreenMirrorService.d(this.S, this.P, new bb(this.Q, this.R, 3));
    }
}
