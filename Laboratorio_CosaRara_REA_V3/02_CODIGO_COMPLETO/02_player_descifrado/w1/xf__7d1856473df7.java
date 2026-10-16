// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.SystemClock;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class xf implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ag f5549d;

    public /* synthetic */ xf(ag agVar, int i3) {
        this.f5548c = i3;
        this.f5549d = agVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zB4;
        ba baVar;
        int i3 = this.f5548c;
        ag agVar = this.f5549d;
        switch (i3) {
            case 0:
                if (!agVar.f3526g) {
                    try {
                        ScreenMirrorService screenMirrorService = agVar.f3523d.f3821a;
                        rd rdVar = ScreenMirrorService.n6;
                        zB4 = screenMirrorService.b4();
                    } catch (Throwable unused) {
                        zB4 = false;
                    }
                    agVar.f3522c.getClass();
                    yf yfVar = new yf(SystemClock.uptimeMillis() + 4000);
                    if (agVar.f3525f == null) {
                        agVar.f3525f = yfVar;
                        agVar.d(yfVar, zB4);
                    } else {
                        agVar.f3524e.addLast(yfVar);
                    }
                    break;
                }
                break;
            default:
                if (!agVar.f3526g) {
                    agVar.f3526g = true;
                    yf yfVar2 = agVar.f3525f;
                    agVar.f3525f = null;
                    agVar.f3524e.clear();
                    if (yfVar2 != null && (baVar = yfVar2.f5653b) != null) {
                        agVar.f3522c.f3005a.removeCallbacks(baVar);
                        break;
                    }
                }
                break;
        }
    }
}
