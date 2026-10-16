// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import p018k0.m;
import p018k0.p;
import p018k0.y;
import p022m0.o;
import s0.a;
import s0.b;

/* JADX INFO: renamed from: n0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0221c extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3889a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f3890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f3891c;

    public C0221c(m mVar, Type type, y yVar, o oVar) {
        this.f3890b = new C0238u(mVar, yVar, type);
        this.f3891c = oVar;
    }

    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        switch (this.f3889a) {
            case 0:
                if (aVar.J() == 9) {
                    aVar.F();
                    return null;
                }
                Collection collection = (Collection) ((o) this.f3891c).o();
                aVar.a();
                while (aVar.w()) {
                    collection.add(((y) ((C0238u) this.f3890b).f3963c).a(aVar));
                }
                aVar.r();
                return collection;
            default:
                Object objA = ((S) this.f3891c).f3881c.a(aVar);
                if (objA != null) {
                    Class cls = (Class) this.f3890b;
                    if (!cls.isInstance(objA)) {
                        throw new p("Expected a " + cls.getName() + " but was " + objA.getClass().getName() + "; at path " + aVar.v(true));
                    }
                }
                return objA;
        }
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        switch (this.f3889a) {
            case 0:
                Collection collection = (Collection) obj;
                if (collection != null) {
                    bVar.f();
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        ((C0238u) this.f3890b).b(bVar, it.next());
                    }
                    bVar.r();
                } else {
                    bVar.w();
                }
                break;
            default:
                ((S) this.f3891c).f3881c.b(bVar, obj);
                break;
        }
    }

    public C0221c(S s2, Class cls) {
        this.f3891c = s2;
        this.f3890b = cls;
    }
}
