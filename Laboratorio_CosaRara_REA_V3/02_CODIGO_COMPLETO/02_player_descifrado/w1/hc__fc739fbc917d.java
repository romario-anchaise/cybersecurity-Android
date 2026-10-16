// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.media.projection.MediaProjection;
import android.os.Handler;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class hc extends MediaProjection.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f4218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaProjection f4219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f4220c;

    public hc(ScreenMirrorService screenMirrorService, long j3, MediaProjection mediaProjection) {
        this.f4220c = screenMirrorService;
        this.f4218a = j3;
        this.f4219b = mediaProjection;
    }

    @Override // android.media.projection.MediaProjection.Callback
    public final void onStop() {
        ScreenMirrorService screenMirrorService = this.f4220c;
        b2.b bVar = new b2.b(this, this.f4218a, this.f4219b, 7);
        rd rdVar = ScreenMirrorService.n6;
        Handler handler = screenMirrorService.T3;
        if (n.p(handler == null ? null : new q.c(handler), bVar)) {
            return;
        }
        try {
            bVar.run();
        } catch (Throwable unused) {
        }
    }
}
