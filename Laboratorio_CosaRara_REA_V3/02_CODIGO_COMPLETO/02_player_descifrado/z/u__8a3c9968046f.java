// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f6275e = p.m.f("WorkTimer");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q.c f6276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f6277b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f6278c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f6279d = new Object();

    public u(q.c cVar) {
        this.f6276a = cVar;
    }

    public final void a(y.j jVar) {
        synchronized (this.f6279d) {
            try {
                if (((t) this.f6277b.remove(jVar)) != null) {
                    p.m.d().a(f6275e, "Stopping timer for " + jVar);
                    this.f6278c.remove(jVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
