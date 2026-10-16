// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.accessibilityservice.AccessibilityService;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m0 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f1260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AccessibilityService f1261e;

    public /* synthetic */ m0(int i3, long j3, AccessibilityService accessibilityService) {
        this.f1259c = i3;
        this.f1260d = j3;
        this.f1261e = accessibilityService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1259c) {
            case 0:
                long j3 = this.f1260d;
                AccessibilityService accessibilityService = this.f1261e;
                if (p0.f1303w == j3) {
                    c0.e(12);
                    if (accessibilityService instanceof ScreenMirrorService) {
                        ((ScreenMirrorService) accessibilityService).B5();
                    }
                    p0.f1303w = 0L;
                    break;
                }
                break;
            default:
                long j4 = this.f1260d;
                AccessibilityService accessibilityService2 = this.f1261e;
                if (p0.f1303w == j4 && c0.g(12)) {
                    p0.f1282a.c(accessibilityService2);
                    p0.f1290i.postDelayed(new m0(0, j4, accessibilityService2), 500L);
                    break;
                }
                break;
        }
    }
}
