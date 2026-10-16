// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f6273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y.j f6274d;

    public t(u uVar, y.j jVar) {
        this.f6273c = uVar;
        this.f6274d = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f6273c.f6279d) {
            try {
                if (((t) this.f6273c.f6277b.remove(this.f6274d)) != null) {
                    s.g gVar = (s.g) this.f6273c.f6278c.remove(this.f6274d);
                    if (gVar != null) {
                        y.j jVar = this.f6274d;
                        p.m.d().a(s.g.f3199m, "Exceeded time limits on execution for " + jVar);
                        gVar.f3207h.execute(new s.f(gVar, 0));
                    }
                } else {
                    p.m.d().a("WrkTimerRunnable", "Timer with " + this.f6274d + " is already marked as complete.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
