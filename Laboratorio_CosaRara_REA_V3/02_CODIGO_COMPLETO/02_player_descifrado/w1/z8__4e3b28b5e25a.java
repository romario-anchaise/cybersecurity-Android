// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class z8 implements AutoCloseable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q.c f5718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final aa f5719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f5720e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public w0.f f5721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public w0.f f5722g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5723h;

    public z8(q.c cVar, aa aaVar) {
        this.f5718c = cVar;
        this.f5719d = aaVar;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f5720e) {
            try {
                if (this.f5723h) {
                    return;
                }
                this.f5723h = true;
                w0.f fVar = this.f5721f;
                if (fVar != null) {
                    this.f5718c.f3005a.removeCallbacks(fVar);
                    this.f5721f = null;
                }
                w0.f fVar2 = this.f5722g;
                if (fVar2 != null) {
                    this.f5718c.f3005a.removeCallbacks(fVar2);
                    this.f5722g = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
