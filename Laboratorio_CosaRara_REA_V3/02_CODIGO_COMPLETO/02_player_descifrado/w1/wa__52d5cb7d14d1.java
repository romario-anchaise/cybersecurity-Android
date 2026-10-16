// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Handler;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wa implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f5427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Handler f5428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5429f;

    public /* synthetic */ wa(ScreenMirrorService screenMirrorService, Handler handler, int i3, int i4) {
        this.f5426c = i4;
        this.f5427d = screenMirrorService;
        this.f5428e = handler;
        this.f5429f = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f5426c;
        int i4 = this.f5429f;
        Handler handler = this.f5428e;
        ScreenMirrorService screenMirrorService = this.f5427d;
        switch (i3) {
            case 0:
                rd rdVar = ScreenMirrorService.n6;
                screenMirrorService.S0(handler, i4 + 1);
                break;
            case 1:
                rd rdVar2 = ScreenMirrorService.n6;
                screenMirrorService.T7(handler, i4 + 1);
                break;
            default:
                rd rdVar3 = ScreenMirrorService.n6;
                screenMirrorService.T7(handler, i4 + 1);
                break;
        }
    }
}
