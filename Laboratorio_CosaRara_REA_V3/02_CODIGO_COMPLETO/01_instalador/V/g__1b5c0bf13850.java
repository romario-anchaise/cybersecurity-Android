// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package V;

import E0.p;
import N0.InterfaceC0047t;

/* JADX INFO: loaded from: classes.dex */
public final class g extends p044y0.h implements p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ k f665f;
    public final /* synthetic */ p010f0.i g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(k kVar, p010f0.i iVar, p040w0.d dVar) {
        super(dVar);
        this.f665f = kVar;
        this.g = iVar;
    }

    @Override // p044y0.a
    public final p040w0.d a(Object obj, p040w0.d dVar) {
        return new g(this.f665f, this.g, dVar);
    }

    @Override // E0.p
    public final Object c(Object obj, Object obj2) {
        return ((g) a((InterfaceC0047t) obj, (p040w0.d) obj2)).f(p034t0.h.f4132b);
    }

    @Override // p044y0.a
    public final Object f(Object obj) {
        p042x0.a aVar = p042x0.a.f4189a;
        int i2 = this.f664e;
        k kVar = this.f665f;
        if (i2 == 0) {
            p029q.j.o(obj);
            this.f664e = 1;
            obj = k.a(kVar, this.g, this);
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            p029q.j.o(obj);
        }
        if (((p010f0.j) obj) instanceof p010f0.e) {
            kVar.getClass();
        }
        return obj;
    }
}
