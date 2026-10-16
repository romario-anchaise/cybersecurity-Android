// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: N0.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0035g extends U {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C0033e f427e;

    public C0035g(C0033e c0033e) {
        this.f427e = c0033e;
    }

    @Override // E0.l
    public final /* bridge */ /* synthetic */ Object d(Object obj) {
        l((Throwable) obj);
        return p034t0.h.f4132b;
    }

    @Override // N0.W
    public final void l(Throwable th) {
        a0 a0VarK = k();
        C0033e c0033e = this.f427e;
        c0033e.getClass();
        CancellationException cancellationExceptionU = a0VarK.u();
        if (c0033e.u()) {
            p040w0.d dVar = c0033e.f424d;
            F0.i.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            R0.g gVar = (R0.g) dVar;
            loop0: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = R0.g.f547h;
                Object obj = atomicReferenceFieldUpdater.get(gVar);
                R0.u uVar = R0.a.f538d;
                if (F0.i.a(obj, uVar)) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(gVar, uVar, cancellationExceptionU)) {
                        if (atomicReferenceFieldUpdater.get(gVar) != uVar) {
                        }
                    }
                    return;
                } else {
                    if (obj instanceof Throwable) {
                        return;
                    }
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(gVar, obj, null)) {
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(gVar) == obj);
                }
            }
        }
        c0033e.m(cancellationExceptionU);
        if (c0033e.u()) {
            return;
        }
        c0033e.n();
    }
}
