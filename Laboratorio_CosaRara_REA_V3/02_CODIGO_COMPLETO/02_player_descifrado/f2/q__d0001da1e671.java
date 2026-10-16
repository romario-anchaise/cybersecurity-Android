// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import lyr.stable.runtime.ScreenMirrorService;
import w1.aa;
import w1.rd;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ r f1307d;

    public /* synthetic */ q(r rVar, int i3) {
        this.f1306c = i3;
        this.f1307d = rVar;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x004f  */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z2;
        int i3 = this.f1306c;
        r rVar = this.f1307d;
        int i4 = 0;
        switch (i3) {
            case 0:
                rVar.f1318h = false;
                ScreenMirrorService screenMirrorService = rVar.f1311a;
                int iN = l.n(screenMirrorService);
                if (l.q(screenMirrorService)) {
                    String str = Build.MANUFACTURER;
                    if (i0.J(l.k(), iN)) {
                        if (rVar.d(null) == 3 || rVar.f1318h) {
                            return;
                        }
                        rVar.f1318h = true;
                        aa aaVar = rVar.f1316f;
                        q qVar = new q(rVar, i4);
                        ScreenMirrorService screenMirrorService2 = aaVar.f3491d;
                        rd rdVar = ScreenMirrorService.n6;
                        if (screenMirrorService2.d5(600L, qVar)) {
                            return;
                        }
                        rVar.f1318h = false;
                        return;
                    }
                }
                rVar.f1314d.k();
                rVar.f1317g = false;
                return;
            default:
                rVar.f1320j = false;
                ScreenMirrorService screenMirrorService3 = rVar.f1311a;
                int iE = i0.E(screenMirrorService3);
                if (iE == 1) {
                    l.N(screenMirrorService3, "miui_appop_allowed_after_click");
                    Log.i("AutoSetupClick", "auto-start switch verified by MIUI AppOp");
                    return;
                }
                AccessibilityNodeInfo accessibilityNodeInfoK = i0.k(screenMirrorService3, "auto-start-verify", null, new b2.a(6));
                if (accessibilityNodeInfoK == null) {
                    return;
                }
                try {
                    y.m mVar = rVar.f1313c;
                    ArrayList arrayListO = y.m.o(screenMirrorService3);
                    mVar.getClass();
                    AccessibilityNodeInfo accessibilityNodeInfoI = mVar.i(accessibilityNodeInfoK, l.V(arrayListO), arrayListO);
                    if (accessibilityNodeInfoI != null) {
                        try {
                            z2 = y.m.m(accessibilityNodeInfoI);
                        } catch (Throwable th) {
                            y.m.q(accessibilityNodeInfoI);
                            throw th;
                        }
                    }
                    y.m.q(accessibilityNodeInfoI);
                    if (!z2 || iE == 2) {
                        Log.w("AutoSetupClick", "auto-start switch click not yet verified");
                    } else {
                        l.N(screenMirrorService3, "checked_after_click");
                        Log.i("AutoSetupClick", "auto-start switch verified enabled");
                    }
                    y.m.q(accessibilityNodeInfoK);
                    return;
                } catch (Throwable th2) {
                    y.m.q(accessibilityNodeInfoK);
                    throw th2;
                }
        }
    }
}
