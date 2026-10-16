// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package V;

import E0.p;
import N0.InterfaceC0047t;
import android.graphics.Bitmap;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class i extends p044y0.h implements p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ p010f0.i f674f;
    public final /* synthetic */ k g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ g0.h f675h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ c f676i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Bitmap f677j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(p010f0.i iVar, k kVar, g0.h hVar, c cVar, Bitmap bitmap, p040w0.d dVar) {
        super(dVar);
        this.f674f = iVar;
        this.g = kVar;
        this.f675h = hVar;
        this.f676i = cVar;
        this.f677j = bitmap;
    }

    @Override // p044y0.a
    public final p040w0.d a(Object obj, p040w0.d dVar) {
        return new i(this.f674f, this.g, this.f675h, this.f676i, this.f677j, dVar);
    }

    @Override // E0.p
    public final Object c(Object obj, Object obj2) {
        return ((i) a((InterfaceC0047t) obj, (p040w0.d) obj2)).f(p034t0.h.f4132b);
    }

    @Override // p044y0.a
    public final Object f(Object obj) {
        p042x0.a aVar = p042x0.a.f4189a;
        int i2 = this.f673e;
        if (i2 == 0) {
            p029q.j.o(obj);
            ArrayList arrayList = this.g.f686i;
            boolean z2 = this.f677j != null;
            p010f0.i iVar = this.f674f;
            p001a0.j jVar = new p001a0.j(iVar, arrayList, 0, iVar, this.f675h, this.f676i, z2);
            this.f673e = 1;
            obj = jVar.b(iVar, this);
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            p029q.j.o(obj);
        }
        return obj;
    }
}
