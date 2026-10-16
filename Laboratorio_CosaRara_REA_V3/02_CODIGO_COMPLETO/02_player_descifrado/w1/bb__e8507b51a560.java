// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bb implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AccessibilityService.GestureResultCallback f3598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ GestureDescription f3599e;

    public /* synthetic */ bb(AccessibilityService.GestureResultCallback gestureResultCallback, GestureDescription gestureDescription, int i3) {
        this.f3597c = i3;
        this.f3598d = gestureResultCallback;
        this.f3599e = gestureDescription;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f3597c;
        GestureDescription gestureDescription = this.f3599e;
        AccessibilityService.GestureResultCallback gestureResultCallback = this.f3598d;
        switch (i3) {
            case 0:
                rd rdVar = ScreenMirrorService.n6;
                gestureResultCallback.onCompleted(gestureDescription);
                break;
            case 1:
                rd rdVar2 = ScreenMirrorService.n6;
                gestureResultCallback.onCancelled(gestureDescription);
                break;
            case 2:
                if (gestureResultCallback != null) {
                    gestureResultCallback.onCancelled(gestureDescription);
                }
                break;
            case 3:
                if (gestureResultCallback != null) {
                    gestureResultCallback.onCancelled(gestureDescription);
                }
                break;
            case 4:
                if (gestureResultCallback != null) {
                    gestureResultCallback.onCancelled(gestureDescription);
                }
                break;
            case 5:
                if (gestureResultCallback != null) {
                    gestureResultCallback.onCompleted(gestureDescription);
                }
                break;
            case 6:
                if (gestureResultCallback != null) {
                    gestureResultCallback.onCancelled(gestureDescription);
                }
                break;
            default:
                if (gestureResultCallback != null) {
                    gestureResultCallback.onCancelled(gestureDescription);
                }
                break;
        }
    }
}
