// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c2;

import android.accessibilityservice.AccessibilityService;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import f2.c0;
import f2.k0;
import f2.p0;
import w1.p9;
import w1.wf;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AccessibilityService f410d;

    public /* synthetic */ d(AccessibilityService accessibilityService, int i3) {
        this.f409c = i3;
        this.f410d = accessibilityService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zD;
        boolean zCanDrawOverlays;
        int i3 = this.f409c;
        AccessibilityService accessibilityService = this.f410d;
        switch (i3) {
            case 0:
                Log.i("A11yHealth", "remote wake-poll claimed");
                p.z(accessibilityService, "wake-poll");
                p.s(accessibilityService, "wake-poll", true);
                break;
            case 1:
                try {
                    zD = w1.n.D(accessibilityService);
                } catch (Throwable unused) {
                    zD = false;
                }
                if (!zD) {
                    k0.l();
                } else {
                    k0.f();
                }
                break;
            case 2:
                try {
                    zCanDrawOverlays = Settings.canDrawOverlays(accessibilityService);
                } catch (Throwable unused2) {
                    zCanDrawOverlays = false;
                }
                if (zCanDrawOverlays) {
                    c0.e(4);
                    p0.U();
                    p0.f1282a.c(accessibilityService);
                    p0.Q(accessibilityService);
                }
                break;
            case 3:
                p0.f1282a.c(accessibilityService);
                break;
            case 4:
                p0.f1282a.c(accessibilityService);
                break;
            case 5:
                p0.f1282a.c(accessibilityService);
                break;
            case 6:
                if (p0.Y(accessibilityService)) {
                    c0.e(10);
                    p0.f1294m = false;
                    p0.f1282a.c(accessibilityService);
                }
                break;
            case 7:
                try {
                    if (Settings.System.canWrite(accessibilityService)) {
                        c0.e(6);
                    }
                } catch (Throwable unused3) {
                    return;
                }
                break;
            case 8:
                if (p9.f4839c == accessibilityService) {
                    Handler handler = p9.f4837a;
                    d2.r rVar = p9.G;
                    handler.removeCallbacks(rVar);
                    handler.postDelayed(rVar, 350L);
                    break;
                }
                break;
            case 9:
                if (p9.f4839c == accessibilityService) {
                    p9.n("screen_on_unlocked");
                    break;
                }
                break;
            default:
                wf.X(accessibilityService, "screen_on");
                wf.c0();
                break;
        }
    }
}
