// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import N0.C0033e;
import X0.InterfaceC0057d;

/* JADX INFO: renamed from: m1.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0212p extends r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f3846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC0203g f3847e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0212p(N n2, InterfaceC0057d interfaceC0057d, InterfaceC0209m interfaceC0209m, InterfaceC0203g interfaceC0203g, int i2) {
        super(n2, interfaceC0057d, interfaceC0209m);
        this.f3846d = i2;
        this.f3847e = interfaceC0203g;
    }

    @Override // m1.r
    public final Object a(y yVar, Object[] objArr) {
        switch (this.f3846d) {
            case 0:
                return this.f3847e.k(yVar);
            default:
                InterfaceC0201e interfaceC0201e = (InterfaceC0201e) this.f3847e.k(yVar);
                p040w0.d dVar = (p040w0.d) objArr[objArr.length - 1];
                try {
                    C0033e c0033e = new C0033e(p029q.j.l(dVar), 1);
                    c0033e.q();
                    c0033e.s(new C0215t(interfaceC0201e, 2));
                    interfaceC0201e.r(new C0216u(c0033e, 2));
                    return c0033e.p();
                } catch (Exception e2) {
                    W.r(e2, dVar);
                    return p042x0.a.f4189a;
                }
        }
    }
}
