// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package R0;

import N0.AbstractC0029a;
import N0.AbstractC0049v;

/* JADX INFO: loaded from: classes.dex */
public class s extends AbstractC0029a implements p044y0.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p044y0.c f571d;

    public s(p040w0.i iVar, p044y0.c cVar) {
        super(iVar, true);
        this.f571d = cVar;
    }

    @Override // N0.a0
    public final boolean D() {
        return true;
    }

    @Override // p044y0.d
    public final p044y0.d d() {
        p044y0.c cVar = this.f571d;
        if (cVar != null) {
            return cVar;
        }
        return null;
    }

    @Override // N0.a0
    public void h(Object obj) {
        a.f(p029q.j.l(this.f571d), AbstractC0049v.j(obj), null);
    }

    @Override // N0.a0
    public void i(Object obj) {
        this.f571d.b(AbstractC0049v.j(obj));
    }
}
