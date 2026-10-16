// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import X0.InterfaceC0057d;

/* JADX INFO: renamed from: m1.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0213q extends r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC0203g f3848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f3849e;

    public C0213q(N n2, InterfaceC0057d interfaceC0057d, InterfaceC0209m interfaceC0209m, InterfaceC0203g interfaceC0203g, boolean z2) {
        super(n2, interfaceC0057d, interfaceC0209m);
        this.f3848d = interfaceC0203g;
        this.f3849e = z2;
    }

    @Override // m1.r
    public final Object a(y yVar, Object[] objArr) {
        InterfaceC0201e interfaceC0201e = (InterfaceC0201e) this.f3848d.k(yVar);
        p040w0.d dVar = (p040w0.d) objArr[objArr.length - 1];
        try {
            if (!this.f3849e) {
                return W.b(interfaceC0201e, dVar);
            }
            F0.i.c(interfaceC0201e, "null cannot be cast to non-null type retrofit2.Call<kotlin.Unit?>");
            return W.c(interfaceC0201e, dVar);
        } catch (LinkageError e2) {
            throw e2;
        } catch (ThreadDeath e3) {
            throw e3;
        } catch (VirtualMachineError e4) {
            throw e4;
        } catch (Throwable th) {
            W.r(th, dVar);
            return p042x0.a.f4189a;
        }
    }
}
