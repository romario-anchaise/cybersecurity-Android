// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import java.util.ArrayDeque;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class oc extends AccessibilityService.GestureResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ od f4749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n5 f4750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p5 f4751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f4753e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f4754f;

    public oc(ScreenMirrorService screenMirrorService, od odVar, n5 n5Var, p5 p5Var, int i3, boolean z2) {
        this.f4754f = screenMirrorService;
        this.f4749a = odVar;
        this.f4750b = n5Var;
        this.f4751c = p5Var;
        this.f4752d = i3;
        this.f4753e = z2;
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public final void onCancelled(GestureDescription gestureDescription) {
        od odVar = this.f4749a;
        if (odVar != null) {
            ScreenMirrorService.v4("callback", odVar.f4756b, this.f4750b.f4622b, odVar.f4757c, "result=cancelled");
        }
        rd rdVar = ScreenMirrorService.n6;
        ScreenMirrorService screenMirrorService = this.f4754f;
        p5 p5Var = this.f4751c;
        boolean zN3 = screenMirrorService.N3(p5Var);
        int i3 = this.f4752d;
        if (zN3) {
            StringBuilder sbI = a0.a.i(i3, "segment_cancelled:", ":up=");
            sbI.append(this.f4753e);
            screenMirrorService.p(p5Var, sbI.toString());
        } else {
            screenMirrorService.p(p5Var, "segment_cancelled_after_stale:" + i3);
        }
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public final void onCompleted(GestureDescription gestureDescription) {
        boolean z2;
        od odVar = this.f4749a;
        if (odVar != null) {
            ScreenMirrorService.v4("callback", odVar.f4756b, this.f4750b.f4622b, odVar.f4757c, "result=completed");
        }
        ScreenMirrorService screenMirrorService = this.f4754f;
        p5 p5Var = this.f4751c;
        rd rdVar = ScreenMirrorService.n6;
        boolean zN3 = screenMirrorService.N3(p5Var);
        ScreenMirrorService screenMirrorService2 = this.f4754f;
        if (!zN3) {
            screenMirrorService2.p(this.f4751c, "segment_completed_after_stale:" + this.f4752d);
            return;
        }
        screenMirrorService2.f2532q0 = false;
        screenMirrorService2.a6(this.f4753e);
        boolean z3 = this.f4753e;
        ScreenMirrorService screenMirrorService3 = this.f4754f;
        if (!z3) {
            screenMirrorService3.d1();
            return;
        }
        n5 n5Var = null;
        screenMirrorService3.B0 = null;
        d0.d dVar = screenMirrorService3.f2519m0;
        p5 p5Var2 = this.f4751c;
        synchronized (dVar) {
            if (((p5) dVar.f532b) != p5Var2) {
                z2 = false;
            } else {
                dVar.f532b = null;
                z2 = true;
            }
        }
        ScreenMirrorService screenMirrorService4 = this.f4754f;
        if (!z2) {
            screenMirrorService4.p(this.f4751c, "up_clear_after_stale:" + this.f4752d);
            return;
        }
        screenMirrorService4.h0(2);
        ScreenMirrorService screenMirrorService5 = this.f4754f;
        p5 p5Var3 = this.f4751c;
        screenMirrorService5.i0(p5Var3.f4805d, p5Var3.f4803b);
        o5 o5Var = this.f4754f.f2515l0;
        n5 n5Var2 = this.f4750b;
        synchronized (o5Var) {
            try {
                if (o5Var.f4716g == n5Var2 && n5Var2.f4629i) {
                    od odVar2 = n5Var2.f4633m;
                    if (odVar2 != null) {
                        odVar2.c(4, 0);
                    }
                    long j3 = n5Var2.f4622b;
                    ArrayDeque arrayDeque = o5Var.f4712c;
                    arrayDeque.addLast(Long.valueOf(j3));
                    while (arrayDeque.size() > 16) {
                        arrayDeque.removeFirst();
                    }
                    n5Var = (n5) o5Var.f4711b.pollFirst();
                    o5Var.f4716g = n5Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (n5Var != null) {
            this.f4754f.a7(n5Var);
        }
    }
}
