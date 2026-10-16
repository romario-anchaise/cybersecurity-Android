// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

/* JADX INFO: renamed from: N0.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0045q extends p040w0.a implements p040w0.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0044p f451b = new C0044p(p040w0.e.f4164a, C0043o.f448b);

    public AbstractC0045q() {
        super(p040w0.e.f4164a);
    }

    @Override // p040w0.a, p040w0.i
    public final p040w0.g j(p040w0.h hVar) {
        p040w0.g gVarA;
        F0.i.e(hVar, "key");
        if (!(hVar instanceof C0044p)) {
            if (p040w0.e.f4164a == hVar) {
                return this;
            }
            return null;
        }
        C0044p c0044p = (C0044p) hVar;
        p040w0.h hVar2 = this.f4158a;
        if ((hVar2 == c0044p || c0044p.f450b == hVar2) && (gVarA = c0044p.a(this)) != null) {
            return gVarA;
        }
        return null;
    }

    @Override // p040w0.a, p040w0.i
    public final p040w0.i r(p040w0.h hVar) {
        F0.i.e(hVar, "key");
        boolean z2 = hVar instanceof C0044p;
        p040w0.j jVar = p040w0.j.f4165a;
        if (z2) {
            C0044p c0044p = (C0044p) hVar;
            p040w0.h hVar2 = this.f4158a;
            if ((hVar2 == c0044p || c0044p.f450b == hVar2) && c0044p.a(this) != null) {
                return jVar;
            }
        } else if (p040w0.e.f4164a == hVar) {
            return jVar;
        }
        return this;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + AbstractC0049v.d(this);
    }

    public abstract void u(p040w0.i iVar, Runnable runnable);

    public boolean v() {
        return !(this instanceof j0);
    }
}
