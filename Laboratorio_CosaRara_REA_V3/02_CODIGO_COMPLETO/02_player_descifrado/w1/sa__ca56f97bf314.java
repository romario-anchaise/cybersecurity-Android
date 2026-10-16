// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class sa implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f5078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f5079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Runnable f5080f;

    public /* synthetic */ sa(ScreenMirrorService screenMirrorService, long j3, Runnable runnable, int i3) {
        this.f5077c = i3;
        this.f5078d = screenMirrorService;
        this.f5079e = j3;
        this.f5080f = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5077c) {
            case 0:
                ScreenMirrorService screenMirrorService = this.f5078d;
                long j3 = this.f5079e;
                Runnable runnable = this.f5080f;
                if (screenMirrorService.Z.get() == j3) {
                    runnable.run();
                }
                break;
            case 1:
                ScreenMirrorService screenMirrorService2 = this.f5078d;
                long j4 = this.f5079e;
                Runnable runnable2 = this.f5080f;
                if (j4 == screenMirrorService2.f2536r2) {
                    if (screenMirrorService2.b4() && screenMirrorService2.J3()) {
                        runnable2.run();
                    } else {
                        screenMirrorService2.Z();
                    }
                    break;
                }
                break;
            default:
                ScreenMirrorService screenMirrorService3 = this.f5078d;
                long j5 = this.f5079e;
                Runnable runnable3 = this.f5080f;
                rd rdVar = ScreenMirrorService.n6;
                screenMirrorService3.S7(j5, runnable3, 1, 1);
                break;
        }
    }
}
