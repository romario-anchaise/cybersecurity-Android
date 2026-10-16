// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Handler;
import com.os9sp.yfwkcq0dwfxaf.R;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ka implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f4410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Handler f4411e;

    public /* synthetic */ ka(ScreenMirrorService screenMirrorService, Handler handler, int i3) {
        this.f4409c = i3;
        this.f4410d = screenMirrorService;
        this.f4411e = handler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f4409c;
        Handler handler = this.f4411e;
        ScreenMirrorService screenMirrorService = this.f4410d;
        switch (i3) {
            case 0:
                rd rdVar = ScreenMirrorService.n6;
                s8.i(100);
                try {
                    s8.j(screenMirrorService.getString(R.string.init_overlay_status_done));
                    break;
                } catch (Throwable unused) {
                }
                screenMirrorService.S0(handler, 0);
                break;
            case 1:
                rd rdVar2 = ScreenMirrorService.n6;
                screenMirrorService.O2(handler, "timeout_residue");
                break;
            default:
                rd rdVar3 = ScreenMirrorService.n6;
                screenMirrorService.O2(handler, "timeout");
                break;
        }
    }
}
