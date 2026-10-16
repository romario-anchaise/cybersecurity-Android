// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package u0;

import h0.o;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f3250a = new e();

    public final void a(Exception exc) {
        e eVar = this.f3250a;
        eVar.getClass();
        o.d(exc, "Exception must not be null");
        synchronized (eVar.f3256a) {
            try {
                if (eVar.f3258c) {
                    return;
                }
                eVar.f3258c = true;
                eVar.f3260e = exc;
                eVar.f3257b.e(eVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
