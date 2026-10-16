// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p001a0;

import E0.p;
import F0.n;
import N0.InterfaceC0047t;
import V.b;
import V.c;
import Z.m;
import p010f0.i;
import p029q.j;
import p042x0.a;
import p044y0.h;

/* JADX INFO: loaded from: classes.dex */
public final class d extends h implements p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1182e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ h f1183f;
    public final /* synthetic */ n g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ n f1184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ i f1185i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f1186j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ n f1187k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ c f1188l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(h hVar, n nVar, n nVar2, i iVar, Object obj, n nVar3, c cVar, p040w0.d dVar) {
        super(dVar);
        this.f1183f = hVar;
        this.g = nVar;
        this.f1184h = nVar2;
        this.f1185i = iVar;
        this.f1186j = obj;
        this.f1187k = nVar3;
        this.f1188l = cVar;
    }

    @Override // p044y0.a
    public final p040w0.d a(Object obj, p040w0.d dVar) {
        return new d(this.f1183f, this.g, this.f1184h, this.f1185i, this.f1186j, this.f1187k, this.f1188l, dVar);
    }

    @Override // E0.p
    public final Object c(Object obj, Object obj2) {
        return ((d) a((InterfaceC0047t) obj, (p040w0.d) obj2)).f(p034t0.h.f4132b);
    }

    @Override // p044y0.a
    public final Object f(Object obj) throws Throwable {
        a aVar = a.f4189a;
        int i2 = this.f1182e;
        if (i2 == 0) {
            j.o(obj);
            m mVar = (m) this.g.f180a;
            b bVar = (b) this.f1184h.f180a;
            p010f0.m mVar2 = (p010f0.m) this.f1187k.f180a;
            this.f1182e = 1;
            obj = h.a(this.f1183f, mVar, bVar, this.f1185i, this.f1186j, mVar2, this.f1188l, this);
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j.o(obj);
        }
        return obj;
    }
}
