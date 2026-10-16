// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.util.Log;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class mc extends n {
    public final /* synthetic */ ScreenMirrorService P;

    public mc(ScreenMirrorService screenMirrorService) {
        this.P = screenMirrorService;
    }

    @Override // w1.n
    public final void Y() {
        this.P.S.incrementAndGet();
        Log.w("ScreenMirror", "[RemoteWake] stage=cancelled");
    }

    @Override // w1.n
    public final void Z() {
        this.P.R.incrementAndGet();
        Log.i("ScreenMirror", "[RemoteWake] stage=completed");
    }

    @Override // w1.n
    public final void a0() {
        ScreenMirrorService.e(this.P, "declined");
    }

    @Override // w1.n
    public final void b0() {
        ScreenMirrorService.e(this.P, "dispatch_rejected");
    }

    @Override // w1.n
    public final void c0(int i3) {
        String str;
        if (i3 == 1) {
            str = "BUSY";
        } else if (i3 == 2) {
            str = "STALE";
        } else if (i3 != 3) {
            str = i3 != 4 ? "null" : "TIMEOUT";
        } else {
            str = "CLOSED";
        }
        ScreenMirrorService.e(this.P, "dropped:".concat(str));
    }

    @Override // w1.n
    public final void d0(int i3) {
        ScreenMirrorService.e(this.P, "invalid:" + i3);
    }

    @Override // w1.n
    public final void e0() {
        this.P.T.incrementAndGet();
        Log.w("ScreenMirror", "[RemoteWake] stage=timed_out");
    }
}
