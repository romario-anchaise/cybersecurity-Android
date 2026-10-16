// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package s;

import p.m;
import z.t;
import z.u;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g f3198d;

    public /* synthetic */ f(g gVar, int i3) {
        this.f3197c = i3;
        this.f3198d = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f3197c;
        g gVar = this.f3198d;
        switch (i3) {
            case 0:
                g.a(gVar);
                return;
            default:
                if (gVar.f3206g != 0) {
                    m.d().a(g.f3199m, "Already started work for " + gVar.f3202c);
                    return;
                }
                gVar.f3206g = 1;
                m.d().a(g.f3199m, "onAllConstraintsMet for " + gVar.f3202c);
                if (!gVar.f3203d.f3222d.g(gVar.f3211l, null)) {
                    gVar.b();
                    return;
                }
                u uVar = gVar.f3203d.f3221c;
                y.j jVar = gVar.f3202c;
                synchronized (uVar.f6279d) {
                    m.d().a(u.f6275e, "Starting timer for " + jVar);
                    uVar.a(jVar);
                    t tVar = new t(uVar, jVar);
                    uVar.f6277b.put(jVar, tVar);
                    uVar.f6278c.put(jVar, gVar);
                    uVar.f6276a.f3005a.postDelayed(tVar, 600000L);
                    break;
                }
                return;
        }
    }
}
