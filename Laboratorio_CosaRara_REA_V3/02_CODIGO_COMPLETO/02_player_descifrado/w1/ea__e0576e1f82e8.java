// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ea implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f3905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f3906e;

    public /* synthetic */ ea(int i3, ScreenMirrorService screenMirrorService, boolean z2) {
        this.f3904c = i3;
        this.f3905d = screenMirrorService;
        this.f3906e = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f3904c;
        boolean z2 = this.f3906e;
        ScreenMirrorService screenMirrorService = this.f3905d;
        switch (i3) {
            case 0:
                boolean z3 = screenMirrorService.m3 != z2;
                screenMirrorService.m3 = z2;
                if (z3) {
                    screenMirrorService.Y5("visual_mask_changed", true);
                }
                break;
            default:
                rd rdVar = ScreenMirrorService.n6;
                screenMirrorService.H6(z2);
                break;
        }
    }
}
