// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.hardware.display.DisplayManager;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class gc implements DisplayManager.DisplayListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f4142a;

    public gc(ScreenMirrorService screenMirrorService) {
        this.f4142a = screenMirrorService;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i3) {
        m3 m3Var = this.f4142a.W3;
        if (i3 != 0 || m3Var == null) {
            return;
        }
        try {
            m3Var.d(this.f4142a.u5());
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("display metrics refresh failed: "), "ScreenMirror");
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i3) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i3) {
    }
}
