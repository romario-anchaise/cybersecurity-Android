// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Handler;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class o3 implements AutoCloseable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d2.o f4702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final aa f4703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d2.o f4704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d2.c f4705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4706g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4707h;

    public o3(d2.o oVar, aa aaVar, d2.o oVar2) {
        this.f4702c = oVar;
        this.f4703d = aaVar;
        this.f4704e = oVar2;
    }

    @Override // java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.f4707h) {
            return;
        }
        this.f4707h = true;
        d2.c cVar = this.f4705f;
        if (cVar != null) {
            Handler handler = (Handler) cVar.f544d;
            a2.b bVar = (a2.b) cVar.f545e;
            rd rdVar = ScreenMirrorService.n6;
            handler.removeCallbacks(bVar);
            this.f4705f = null;
        }
    }

    public final void d(long j3) {
        a2.b bVar = new a2.b(19, this);
        Handler handler = (Handler) this.f4702c.f603d;
        rd rdVar = ScreenMirrorService.n6;
        handler.postDelayed(bVar, j3);
        this.f4705f = new d2.c(handler, bVar, 9);
    }
}
