// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m2;

import p.u;
import q.q;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends q1.f implements p1.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f2735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f2736e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f2737f;

    public /* synthetic */ k(Object obj, Object obj2, Object obj3, int i3) {
        this.f2734c = i3;
        this.f2735d = obj;
        this.f2736e = obj2;
        this.f2737f = obj3;
    }

    @Override // p1.a
    public final Object d() {
        switch (this.f2734c) {
            case 0:
                m0.a aVar = ((i2.f) this.f2735d).f2145b;
                aVar.getClass();
                return aVar.b(((i2.a) this.f2737f).f2114h.f2203d, ((i2.n) this.f2736e).a());
            default:
                new z.c(new q.m((q) this.f2736e, "connection_keep_alive", 2, m0.a.k((u) this.f2735d), 0), (y.c) this.f2737f).run();
                return h1.e.f1953c;
        }
    }
}
