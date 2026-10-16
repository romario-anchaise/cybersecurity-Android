// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f6251f = p.m.f("StopWorkRunnable");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q.q f6252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q.l f6253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f6254e;

    public m(q.q qVar, q.l lVar, boolean z2) {
        this.f6252c = qVar;
        this.f6253d = lVar;
        this.f6254e = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zC;
        q.u uVar;
        boolean z2 = this.f6254e;
        q.q qVar = this.f6252c;
        if (z2) {
            q.h hVar = qVar.f3060f;
            q.l lVar = this.f6253d;
            hVar.getClass();
            String str = lVar.f3039a.f5987a;
            synchronized (hVar.f3035l) {
                try {
                    p.m.d().a(q.h.f3023m, "Processor stopping foreground work " + str);
                    uVar = (q.u) hVar.f3029f.remove(str);
                    if (uVar != null) {
                        hVar.f3031h.remove(str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            zC = q.h.c(str, uVar);
        } else {
            q.h hVar2 = qVar.f3060f;
            q.l lVar2 = this.f6253d;
            hVar2.getClass();
            String str2 = lVar2.f3039a.f5987a;
            synchronized (hVar2.f3035l) {
                try {
                    q.u uVar2 = (q.u) hVar2.f3030g.remove(str2);
                    if (uVar2 == null) {
                        p.m.d().a(q.h.f3023m, "WorkerWrapper could not be found for " + str2);
                    } else {
                        Set set = (Set) hVar2.f3031h.get(str2);
                        if (set != null && set.contains(lVar2)) {
                            p.m.d().a(q.h.f3023m, "Processor stopping background work " + str2);
                            hVar2.f3031h.remove(str2);
                            zC = q.h.c(str2, uVar2);
                        }
                    }
                    zC = false;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        p.m.d().a(f6251f, "StopWorkRunnable for " + this.f6253d.f3039a.f5987a + "; Processor.stopWork = " + zC);
    }
}
