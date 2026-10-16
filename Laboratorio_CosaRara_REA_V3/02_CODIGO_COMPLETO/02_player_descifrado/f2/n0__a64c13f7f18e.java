// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.accessibilityservice.AccessibilityService;
import android.provider.Settings;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n0 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AccessibilityService f1272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ x1.r f1273e;

    public /* synthetic */ n0(AccessibilityService accessibilityService, x1.r rVar, int i3) {
        this.f1271c = i3;
        this.f1272d = accessibilityService;
        this.f1273e = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zCanDrawOverlays;
        switch (this.f1271c) {
            case 0:
                AccessibilityService accessibilityService = this.f1272d;
                p0.x(accessibilityService, this.f1273e, p0.q(accessibilityService), false);
                break;
            case 1:
                p0.I(this.f1272d, 0, this.f1273e);
                break;
            case 2:
                AccessibilityService accessibilityService2 = this.f1272d;
                try {
                    zCanDrawOverlays = Settings.canDrawOverlays(accessibilityService2);
                } catch (Throwable unused) {
                    zCanDrawOverlays = false;
                }
                if (!zCanDrawOverlays) {
                    p0.x(accessibilityService2, this.f1273e, p0.q(accessibilityService2), true);
                } else {
                    c0.e(4);
                    p0.U();
                    p0.f1282a.c(accessibilityService2);
                    p0.Q(accessibilityService2);
                }
                break;
            default:
                AccessibilityService accessibilityService3 = this.f1272d;
                p0.x(accessibilityService3, this.f1273e, p0.q(accessibilityService3), false);
                break;
        }
    }
}
