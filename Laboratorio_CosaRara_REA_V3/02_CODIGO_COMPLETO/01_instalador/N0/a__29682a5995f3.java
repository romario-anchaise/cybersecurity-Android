// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

/* JADX INFO: renamed from: N0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0029a extends a0 implements p040w0.d, InterfaceC0047t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p040w0.i f416c;

    public AbstractC0029a(p040w0.i iVar, boolean z2) {
        super(z2);
        B((S) iVar.j(r.f453b));
        this.f416c = iVar.t(this);
    }

    @Override // N0.a0
    public final void A(C0041m c0041m) {
        AbstractC0049v.f(this.f416c, c0041m);
    }

    @Override // N0.a0
    public final void H(Object obj) {
        if (obj instanceof C0039k) {
            C0039k c0039k = (C0039k) obj;
            Throwable th = c0039k.f440a;
            c0039k.getClass();
            C0039k.f439b.get(c0039k);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void M(int i2, AbstractC0029a abstractC0029a, E0.p pVar) {
        int iB = androidx.fragment.app.y.b(i2);
        if (iB == 0) {
            f1.d.A(pVar, abstractC0029a, this);
            return;
        }
        if (iB != 1) {
            if (iB == 2) {
                p029q.j.l(((p044y0.a) pVar).a(abstractC0029a, this)).b(p034t0.h.f4132b);
                return;
            }
            if (iB != 3) {
                throw new C0041m();
            }
            try {
                p040w0.i iVar = this.f416c;
                Object objJ = R0.a.j(iVar, null);
                try {
                    F0.q.a(pVar);
                    Object objC = pVar.c(abstractC0029a, this);
                    R0.a.e(iVar, objJ);
                    if (objC != p042x0.a.f4189a) {
                        b(objC);
                    }
                } catch (Throwable th) {
                    R0.a.e(iVar, objJ);
                    throw th;
                }
            } catch (Throwable th2) {
                b(p029q.j.b(th2));
            }
        }
    }

    @Override // p040w0.d
    public final void b(Object obj) {
        Throwable thA = p034t0.f.a(obj);
        if (thA != null) {
            obj = new C0039k(thA, false);
        }
        Object objE = E(obj);
        if (objE == AbstractC0049v.f457d) {
            return;
        }
        i(objE);
    }

    @Override // N0.InterfaceC0047t
    public final p040w0.i c() {
        return this.f416c;
    }

    @Override // p040w0.d
    public final p040w0.i g() {
        return this.f416c;
    }

    @Override // N0.a0
    public final String m() {
        return getClass().getSimpleName().concat(" was cancelled");
    }
}
