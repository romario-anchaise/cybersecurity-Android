// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class uc extends AccessibilityService.GestureResultCallback {
    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public final void onCancelled(GestureDescription gestureDescription) {
        Log.w("ScreenMirror", "[Gesture] onCancelled —— 被系统取消了");
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public final void onCompleted(GestureDescription gestureDescription) {
        Log.i("ScreenMirror", "[Gesture] onCompleted");
    }
}
