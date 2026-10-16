// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.util.Log;
import android.view.Choreographer;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ef implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Choreographer f3941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f3942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Runnable f3943d;

    public /* synthetic */ ef(int i3, Choreographer choreographer, long j3, Runnable runnable) {
        this.f3940a = i3;
        this.f3941b = choreographer;
        this.f3942c = j3;
        this.f3943d = runnable;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j3) {
        int i3 = this.f3940a;
        long j4 = this.f3942c;
        Runnable runnable = this.f3943d;
        if (i3 > 1) {
            Choreographer choreographer = this.f3941b;
            choreographer.postFrameCallback(new ef(i3 - 1, choreographer, j4, runnable));
            return;
        }
        Log.i("UpdateNotice", "[OverlayPunch] stage=input_frames_drained epoch=" + j4 + " frames=6");
        runnable.run();
    }
}
