// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Handler;
import android.util.Log;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qa implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4936c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f4937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f4938e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f4939f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f4940g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f4941h;

    public /* synthetic */ qa(ScreenMirrorService screenMirrorService, long j3, String str, String str2, long j4) {
        this.f4939f = screenMirrorService;
        this.f4937d = j3;
        this.f4940g = str;
        this.f4941h = str2;
        this.f4938e = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        switch (this.f4936c) {
            case 0:
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) this.f4939f;
                long j3 = this.f4937d;
                String str2 = (String) this.f4940g;
                String str3 = (String) this.f4941h;
                long j4 = this.f4938e;
                if (screenMirrorService.f2488e1.get() == j3 && !screenMirrorService.X && !screenMirrorService.Y) {
                    screenMirrorService.U0.s();
                    screenMirrorService.U0.w(j4, str2, str3);
                    break;
                }
                break;
            default:
                hd hdVar = (hd) this.f4939f;
                long j5 = this.f4937d;
                Handler handler = (Handler) this.f4940g;
                long j6 = this.f4938e;
                p5 p5Var = (p5) this.f4941h;
                ScreenMirrorService screenMirrorService2 = hdVar.f4227g;
                rd rdVar = ScreenMirrorService.n6;
                int iE = p5Var.e();
                if (screenMirrorService2.I3(j5, handler) && screenMirrorService2.F4.compareAndSet(j6, 0L) && screenMirrorService2.f2537s.get()) {
                    if (iE == 1) {
                        str = "NONE";
                    } else if (iE != 2) {
                        str = iE != 3 ? "null" : "CALLBACK_ACTIVE_HELD";
                    } else {
                        str = "CALLBACK_MISSING_RELEASED";
                    }
                    Log.w("ScreenMirror", "JPEG callback timed out; physicalDisposition=".concat(str));
                    handler.post(new f2.t(screenMirrorService2, 15));
                    break;
                }
                break;
        }
    }

    public /* synthetic */ qa(hd hdVar, long j3, Handler handler, long j4, p5 p5Var) {
        this.f4939f = hdVar;
        this.f4937d = j3;
        this.f4940g = handler;
        this.f4938e = j4;
        this.f4941h = p5Var;
    }
}
