// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p018k0;

import p024n0.AbstractC0237t;
import s0.a;
import s0.b;

/* JADX INFO: loaded from: classes.dex */
public class l extends AbstractC0237t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f3414a = null;

    @Override // p018k0.y
    public final Object a(a aVar) {
        y yVar = this.f3414a;
        if (yVar != null) {
            return yVar.a(aVar);
        }
        throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
    }

    @Override // p018k0.y
    public final void b(b bVar, Object obj) {
        y yVar = this.f3414a;
        if (yVar == null) {
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }
        yVar.b(bVar, obj);
    }

    @Override // p024n0.AbstractC0237t
    public final y c() {
        y yVar = this.f3414a;
        if (yVar != null) {
            return yVar;
        }
        throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
    }
}
