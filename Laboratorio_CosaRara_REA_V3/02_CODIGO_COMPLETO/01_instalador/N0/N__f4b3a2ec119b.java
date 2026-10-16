// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class N extends p044y0.h implements E0.p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ W.e f397f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(W.e eVar, p040w0.d dVar) {
        super(dVar);
        this.f397f = eVar;
    }

    @Override // p044y0.a
    public final p040w0.d a(Object obj, p040w0.d dVar) {
        N n2 = new N(this.f397f, dVar);
        n2.f396e = obj;
        return n2;
    }

    @Override // E0.p
    public final Object c(Object obj, Object obj2) {
        return ((N) a((InterfaceC0047t) obj, (p040w0.d) obj2)).f(p034t0.h.f4132b);
    }

    @Override // p044y0.a
    public final Object f(Object obj) throws Throwable {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        p029q.j.o(obj);
        p040w0.i iVarC = ((InterfaceC0047t) this.f396e).c();
        W.e eVar = this.f397f;
        try {
            S sE = AbstractC0049v.e(iVarC);
            i0 i0Var = new i0(sE);
            i0Var.f432b = ((a0) sE).C(true, true, i0Var);
            do {
                atomicIntegerFieldUpdater = i0.f430c;
                i2 = atomicIntegerFieldUpdater.get(i0Var);
                if (i2 != 0) {
                    if (i2 == 2 || i2 == 3) {
                        break;
                        break;
                    }
                    i0.b(i2);
                    throw null;
                }
            } while (!atomicIntegerFieldUpdater.compareAndSet(i0Var, i2, 0));
            try {
                return eVar.a();
            } finally {
                i0Var.a();
            }
        } catch (InterruptedException e2) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e2);
        }
    }
}
