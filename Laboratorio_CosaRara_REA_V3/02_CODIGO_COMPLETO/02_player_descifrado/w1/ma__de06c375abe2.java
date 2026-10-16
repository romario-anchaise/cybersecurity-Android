// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ma implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f4548e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f4549f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f4550g;

    public /* synthetic */ ma(Object obj, int i3, long j3, boolean z2, int i4) {
        this.f4546c = i4;
        this.f4550g = obj;
        this.f4547d = i3;
        this.f4548e = j3;
        this.f4549f = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4546c) {
            case 0:
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) this.f4550g;
                int i3 = this.f4547d;
                long j3 = this.f4548e;
                boolean z2 = this.f4549f;
                rd rdVar = ScreenMirrorService.n6;
                int i4 = i3 < 3 ? 2 : 3;
                if (j3 != screenMirrorService.k3 || i4 != screenMirrorService.a3 || z2 != screenMirrorService.b3) {
                    screenMirrorService.k3 = j3;
                    screenMirrorService.a3 = i4;
                    screenMirrorService.b3 = z2;
                    screenMirrorService.t("publisher_or_demand");
                    if (z2) {
                        screenMirrorService.Y5("publisher_or_demand", true);
                    }
                }
                break;
            default:
                sf sfVar = (sf) this.f4550g;
                int i5 = this.f4547d;
                long j4 = this.f4548e;
                boolean z3 = this.f4549f;
                rd rdVar2 = ScreenMirrorService.n6;
                if (sfVar.f5107i != null) {
                    wf.b(new a8(sfVar, i5, j4, 1));
                }
                if (z3) {
                    sfVar.close();
                }
                break;
        }
    }
}
