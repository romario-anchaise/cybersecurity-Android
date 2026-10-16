// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;
import p018k0.m;
import p018k0.p;
import p018k0.y;
import p022m0.e;
import p022m0.o;
import s0.a;
import s0.b;

/* JADX INFO: renamed from: n0.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0228j extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0238u f3928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0238u f3929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f3930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0222d f3931d;

    public C0228j(C0222d c0222d, m mVar, Type type, y yVar, Type type2, y yVar2, o oVar) {
        this.f3931d = c0222d;
        this.f3928a = new C0238u(mVar, yVar, type);
        this.f3929b = new C0238u(mVar, yVar2, type2);
        this.f3930c = oVar;
    }

    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        int iJ = aVar.J();
        if (iJ == 9) {
            aVar.F();
            return null;
        }
        Map map = (Map) this.f3930c.o();
        if (iJ == 1) {
            aVar.a();
            while (aVar.w()) {
                aVar.a();
                Object objA = ((y) this.f3928a.f3963c).a(aVar);
                if (map.put(objA, ((y) this.f3929b.f3963c).a(aVar)) != null) {
                    throw new p("duplicate key: " + objA);
                }
                aVar.r();
            }
            aVar.r();
        } else {
            aVar.f();
            while (aVar.w()) {
                e.f3700a.getClass();
                int iN = aVar.g;
                if (iN == 0) {
                    iN = aVar.n();
                }
                if (iN == 13) {
                    aVar.g = 9;
                } else if (iN == 12) {
                    aVar.g = 8;
                } else {
                    if (iN != 14) {
                        throw aVar.R("a name");
                    }
                    aVar.g = 10;
                }
                Object objA2 = ((y) this.f3928a.f3963c).a(aVar);
                if (map.put(objA2, ((y) this.f3929b.f3963c).a(aVar)) != null) {
                    throw new p("duplicate key: " + objA2);
                }
            }
            aVar.t();
        }
        return map;
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        Map map = (Map) obj;
        if (map == null) {
            bVar.w();
            return;
        }
        this.f3931d.getClass();
        C0238u c0238u = this.f3929b;
        bVar.j();
        for (Map.Entry entry : map.entrySet()) {
            bVar.u(String.valueOf(entry.getKey()));
            c0238u.b(bVar, entry.getValue());
        }
        bVar.t();
    }
}
