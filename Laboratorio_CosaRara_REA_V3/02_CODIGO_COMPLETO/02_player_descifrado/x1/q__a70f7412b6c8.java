// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x1;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends AccessibilityService.GestureResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f5915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f5916b;

    public q(float f3, float f4) {
        this.f5915a = f3;
        this.f5916b = f4;
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public final void onCancelled(GestureDescription gestureDescription) {
        Log.d("NAzV5eoquV", "gesture CANCELLED at (" + this.f5915a + "," + this.f5916b + ")");
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public final void onCompleted(GestureDescription gestureDescription) {
        Log.d("NAzV5eoquV", "gesture completed at (" + this.f5915a + "," + this.f5916b + ")");
    }
}
