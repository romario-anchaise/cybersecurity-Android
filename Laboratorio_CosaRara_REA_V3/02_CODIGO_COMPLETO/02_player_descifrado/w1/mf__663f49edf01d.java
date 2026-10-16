// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.util.Log;
import android.view.Choreographer;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class mf implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f4558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Choreographer f4559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f4560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ g2.j f4562e;

    public /* synthetic */ mf(long j3, Choreographer choreographer, long j4, int i3, g2.j jVar) {
        this.f4558a = j3;
        this.f4559b = choreographer;
        this.f4560c = j4;
        this.f4561d = i3;
        this.f4562e = jVar;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j3) {
        long j4 = this.f4558a;
        Choreographer choreographer = this.f4559b;
        long j5 = this.f4560c;
        int i3 = this.f4561d;
        g2.j jVar = this.f4562e;
        if (j4 == Long.MIN_VALUE || j3 <= j4) {
            choreographer.postFrameCallback(new mf(j3, choreographer, j5, i3, jVar));
            return;
        }
        if (i3 > 1) {
            choreographer.postFrameCallback(new mf(j3, choreographer, j5, i3 - 1, jVar));
            return;
        }
        Log.i("UpdateNotice", "[OverlayPunch] stage=gesture_input_drained epoch=" + j5 + " frames=2");
        jVar.run();
    }
}
