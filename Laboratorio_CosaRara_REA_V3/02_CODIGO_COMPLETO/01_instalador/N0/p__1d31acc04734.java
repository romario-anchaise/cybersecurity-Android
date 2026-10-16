// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p024n0;

import java.lang.reflect.Field;
import p018k0.p;
import p022m0.o;
import p028p0.d;
import s0.a;

/* JADX INFO: renamed from: n0.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0234p extends AbstractC0233o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f3948b;

    public C0234p(o oVar, C0235q c0235q) {
        super(c0235q);
        this.f3948b = oVar;
    }

    @Override // p024n0.AbstractC0233o
    public final Object c() {
        return this.f3948b.o();
    }

    @Override // p024n0.AbstractC0233o
    public final void e(Object obj, a aVar, C0232n c0232n) throws IllegalAccessException {
        Object objA = c0232n.g.a(aVar);
        if (objA == null && c0232n.f3945h) {
            return;
        }
        Field field = c0232n.f3940b;
        if (c0232n.f3942d) {
            C0236s.a(obj, field);
        } else if (c0232n.f3946i) {
            throw new p("Cannot set value of 'static final' " + d.d(field, false));
        }
        field.set(obj, objA);
    }

    @Override // p024n0.AbstractC0233o
    public final Object d(Object obj) {
        return obj;
    }
}
