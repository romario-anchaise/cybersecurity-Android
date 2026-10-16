// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class nc extends AccessibilityService.GestureResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n5 f4655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p5 f4656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f4657c;

    public nc(ScreenMirrorService screenMirrorService, n5 n5Var, p5 p5Var) {
        this.f4657c = screenMirrorService;
        this.f4655a = n5Var;
        this.f4656b = p5Var;
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public final void onCancelled(GestureDescription gestureDescription) {
        n5 n5Var = this.f4655a;
        od odVar = n5Var.f4625e;
        ScreenMirrorService.v4("callback", odVar.f4756b, n5Var.f4622b, odVar.f4757c, "result=cancelled");
        ScreenMirrorService screenMirrorService = this.f4657c;
        p5 p5Var = this.f4656b;
        if (screenMirrorService.N3(p5Var)) {
            screenMirrorService.p(p5Var, "down_cancelled");
        } else {
            screenMirrorService.p(p5Var, "down_cancelled_after_stale");
        }
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public final void onCompleted(GestureDescription gestureDescription) {
        n5 n5Var = this.f4655a;
        od odVar = n5Var.f4625e;
        ScreenMirrorService.v4("callback", odVar.f4756b, n5Var.f4622b, odVar.f4757c, "result=completed");
        if (!this.f4657c.N3(this.f4656b) || !this.f4657c.f2515l0.f(this.f4655a)) {
            this.f4657c.p(this.f4656b, "down_completed_after_stale");
            return;
        }
        o5 o5Var = this.f4657c.f2515l0;
        n5 n5Var2 = this.f4655a;
        synchronized (o5Var) {
            if (n5Var2 != null) {
                if (o5Var.f4716g == n5Var2) {
                    n5Var2.f4625e.c(4, 0);
                }
            }
        }
        ScreenMirrorService screenMirrorService = this.f4657c;
        screenMirrorService.f2532q0 = false;
        screenMirrorService.r1(this.f4655a);
        this.f4657c.d1();
    }
}
