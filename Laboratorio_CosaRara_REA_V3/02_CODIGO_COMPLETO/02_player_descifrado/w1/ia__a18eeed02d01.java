// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ia implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f4277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f4278e;

    public /* synthetic */ ia(int i3, String str, ScreenMirrorService screenMirrorService) {
        this.f4276c = i3;
        this.f4277d = screenMirrorService;
        this.f4278e = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4276c) {
            case 0:
                ScreenMirrorService screenMirrorService = this.f4277d;
                String str = this.f4278e;
                rd rdVar = ScreenMirrorService.n6;
                screenMirrorService.o(str);
                break;
            case 1:
                ScreenMirrorService screenMirrorService2 = this.f4277d;
                String str2 = this.f4278e;
                rd rdVar2 = ScreenMirrorService.n6;
                screenMirrorService2.M2(str2);
                break;
            default:
                ScreenMirrorService screenMirrorService3 = this.f4277d;
                String str3 = this.f4278e;
                screenMirrorService3.K5 = null;
                if (!screenMirrorService3.X && !screenMirrorService3.Y && c2.p.k(screenMirrorService3)) {
                    if (!screenMirrorService3.t3()) {
                        screenMirrorService3.B6(str3);
                    } else if (screenMirrorService3.F5) {
                        screenMirrorService3.M2("init-retry");
                    }
                    break;
                }
                break;
        }
    }
}
