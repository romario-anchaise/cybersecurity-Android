// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.concurrent.atomic.AtomicBoolean;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ta implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f5184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j2 f5185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f5186e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ g2.m0 f5187f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ cf f5188g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ie f5189h;

    public /* synthetic */ ta(AtomicBoolean atomicBoolean, j2 j2Var, int i3, g2.m0 m0Var, cf cfVar, ie ieVar) {
        this.f5184c = atomicBoolean;
        this.f5185d = j2Var;
        this.f5186e = i3;
        this.f5187f = m0Var;
        this.f5188g = cfVar;
        this.f5189h = ieVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        rd rdVar = ScreenMirrorService.n6;
        if (this.f5184c.compareAndSet(false, true)) {
            j2 j2Var = this.f5185d;
            if (j2Var != null) {
                j2Var.f(this.f5186e, this.f5187f);
            }
            this.f5188g.f3702f.execute(new v8(2, this.f5189h));
        }
    }
}
