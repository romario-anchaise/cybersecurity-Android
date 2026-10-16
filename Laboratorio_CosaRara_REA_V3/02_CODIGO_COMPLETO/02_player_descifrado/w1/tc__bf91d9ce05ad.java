// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class tc extends AccessibilityService.GestureResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ pa f5198c;

    public tc(int i3, int i4, pa paVar) {
        this.f5196a = i3;
        this.f5197b = i4;
        this.f5198c = paVar;
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public final void onCancelled(GestureDescription gestureDescription) {
        Log.w("ScreenMirror", "[SoftKb] tapReveal cancelled tag=pw-toggle x=" + this.f5196a + " y=" + this.f5197b);
        this.f5198c.run();
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public final void onCompleted(GestureDescription gestureDescription) {
        Log.i("ScreenMirror", "[SoftKb] tapReveal completed tag=pw-toggle x=" + this.f5196a + " y=" + this.f5197b);
        this.f5198c.run();
    }
}
