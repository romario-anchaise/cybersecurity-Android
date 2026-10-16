// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import p018k0.p;
import p018k0.y;
import p028p0.d;
import s0.a;
import s0.b;

/* JADX INFO: renamed from: n0.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0233o extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0235q f3947a;

    public AbstractC0233o(C0235q c0235q) {
        this.f3947a = c0235q;
    }

    @Override // p018k0.y
    public final Object a(a aVar) throws IOException {
        if (aVar.J() == 9) {
            aVar.F();
            return null;
        }
        Object objC = c();
        Map map = this.f3947a.f3950a;
        try {
            aVar.f();
            while (aVar.w()) {
                C0232n c0232n = (C0232n) map.get(aVar.D());
                if (c0232n == null) {
                    aVar.P();
                } else {
                    e(objC, aVar, c0232n);
                }
            }
            aVar.t();
            return d(objC);
        } catch (IllegalAccessException e2) {
            p028p0.a aVar2 = d.f4001a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.11.0). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e2);
        } catch (IllegalStateException e3) {
            throw new p(e3);
        }
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.w();
            return;
        }
        bVar.j();
        try {
            Iterator it = this.f3947a.f3951b.iterator();
            while (it.hasNext()) {
                ((C0232n) it.next()).a(bVar, obj);
            }
            bVar.t();
        } catch (IllegalAccessException e2) {
            p028p0.a aVar = d.f4001a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.11.0). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e2);
        }
    }

    public abstract Object c();

    public abstract Object d(Object obj);

    public abstract void e(Object obj, a aVar, C0232n c0232n);
}
