// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a0;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f23c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f24d;

    public g(l lVar, j jVar) {
        this.f23c = lVar;
        this.f24d = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f23c.f32c != this) {
            return;
        }
        if (j.f30h.e(this.f23c, this, j.f(this.f24d))) {
            j.c(this.f23c);
        }
    }
}
