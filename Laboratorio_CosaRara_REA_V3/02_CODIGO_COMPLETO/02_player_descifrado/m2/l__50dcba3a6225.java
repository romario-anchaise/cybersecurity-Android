// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m2;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w2.j f2738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w2.i f2739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ g0.k f2740e;

    public l(w2.j jVar, w2.i iVar, g0.k kVar) {
        this.f2740e = kVar;
        jVar.getClass();
        iVar.getClass();
        this.f2738c = jVar;
        this.f2739d = iVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f2740e.b(true, true, null);
    }
}
