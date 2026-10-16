// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ob implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f4746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f4747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f4748f;

    public /* synthetic */ ob(int i3, long j3, String str, ScreenMirrorService screenMirrorService) {
        this.f4745c = i3;
        this.f4746d = screenMirrorService;
        this.f4747e = j3;
        this.f4748f = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4745c) {
            case 0:
                rd rdVar = ScreenMirrorService.n6;
                long j3 = this.f4747e;
                String str = this.f4748f;
                ScreenMirrorService screenMirrorService = this.f4746d;
                screenMirrorService.S7(j3, new ob(1, j3, str, screenMirrorService), 0, 0);
                break;
            default:
                rd rdVar2 = ScreenMirrorService.n6;
                this.f4746d.K7(0, this.f4747e, this.f4748f);
                break;
        }
    }
}
