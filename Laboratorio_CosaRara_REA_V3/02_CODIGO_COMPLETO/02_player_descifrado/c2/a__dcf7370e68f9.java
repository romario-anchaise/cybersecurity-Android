// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c2;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.util.Log;
import e2.n1;
import lyr.stable.runtime.ScreenMirrorService;
import w1.h2;
import w1.rd;
import w1.sf;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends AccessibilityService.GestureResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f400b;

    public a(int i3, sf sfVar, n1 n1Var) {
        this.f399a = 2;
        this.f400b = n1Var;
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public final void onCancelled(GestureDescription gestureDescription) {
        int i3 = this.f399a;
        Object obj = this.f400b;
        switch (i3) {
            case 0:
                Log.d("AbeTouch", "gesture cancelled src=" + ((String) obj));
                break;
            case 1:
                Log.w("ScreenMirror", "[Unlock] pattern capture inject cancelled");
                rd rdVar = ScreenMirrorService.n6;
                ((ScreenMirrorService) obj).P2();
                break;
            default:
                rd rdVar2 = ScreenMirrorService.n6;
                h2.a((h2) ((n1) obj).f905c, false);
                break;
        }
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public final void onCompleted(GestureDescription gestureDescription) {
        int i3 = this.f399a;
        Object obj = this.f400b;
        switch (i3) {
            case 0:
                Log.d("AbeTouch", "gesture ok src=" + ((String) obj));
                break;
            case 1:
                StringBuilder sb = new StringBuilder("[Unlock] pattern capture inject completed locked=");
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) obj;
                sb.append(screenMirrorService.J3());
                Log.i("ScreenMirror", sb.toString());
                screenMirrorService.P2();
                break;
            default:
                rd rdVar = ScreenMirrorService.n6;
                h2.a((h2) ((n1) obj).f905c, true);
                break;
        }
    }

    public /* synthetic */ a(int i3, Object obj) {
        this.f399a = i3;
        this.f400b = obj;
    }
}
