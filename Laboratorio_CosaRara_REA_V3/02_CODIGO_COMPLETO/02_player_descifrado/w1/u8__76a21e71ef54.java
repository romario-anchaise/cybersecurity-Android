// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Intent;
import android.util.Log;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f5233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f5234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f5235f;

    public /* synthetic */ u8(ScreenMirrorService screenMirrorService, Object obj, boolean z2, int i3) {
        this.f5232c = i3;
        this.f5233d = screenMirrorService;
        this.f5234e = obj;
        this.f5235f = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f5232c;
        boolean z2 = this.f5235f;
        Object obj = this.f5234e;
        ScreenMirrorService screenMirrorService = this.f5233d;
        switch (i3) {
            case 0:
                String str = (String) obj;
                if (!screenMirrorService.J3()) {
                    n.O(screenMirrorService, str, z2);
                } else {
                    Log.w("PermOrchestrator", "wireless_adb postponed: keyguard still locked");
                }
                break;
            case 1:
                n.O(screenMirrorService, (String) obj, z2);
                break;
            case 2:
                String str2 = (String) obj;
                if (!screenMirrorService.J3()) {
                    n.O(screenMirrorService, str2, z2);
                } else {
                    Log.w("PermOrchestrator", "grant postponed: keyguard still locked type=" + str2);
                }
                break;
            case 3:
                n.O(screenMirrorService, (String) obj, z2);
                break;
            case 4:
                n.O(screenMirrorService, (String) obj, z2);
                break;
            default:
                rd rdVar = ScreenMirrorService.n6;
                screenMirrorService.G((Intent) obj, z2);
                break;
        }
    }
}
