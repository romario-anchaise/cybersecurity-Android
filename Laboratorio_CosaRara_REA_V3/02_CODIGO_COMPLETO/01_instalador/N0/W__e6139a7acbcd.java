// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class W extends R0.k implements D, L, E0.l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a0 f404d;

    @Override // N0.L
    public final boolean a() {
        return true;
    }

    @Override // N0.L
    public final b0 b() {
        return null;
    }

    @Override // N0.D
    public final void c() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2;
        a0 a0VarK = k();
        while (true) {
            Object objY = a0VarK.y();
            if (objY instanceof W) {
                if (objY != this) {
                    return;
                }
                E e2 = AbstractC0049v.f461i;
                do {
                    atomicReferenceFieldUpdater2 = a0.f417a;
                    if (atomicReferenceFieldUpdater2.compareAndSet(a0VarK, objY, e2)) {
                        return;
                    }
                } while (atomicReferenceFieldUpdater2.get(a0VarK) == objY);
            } else {
                if (!(objY instanceof L) || ((L) objY).b() == null) {
                    return;
                }
                while (true) {
                    Object objH = h();
                    if (objH instanceof R0.q) {
                        R0.k kVar = ((R0.q) objH).f570a;
                        return;
                    }
                    if (objH == this) {
                        return;
                    }
                    F0.i.c(objH, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                    R0.k kVar2 = (R0.k) objH;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = R0.k.f560c;
                    R0.q qVar = (R0.q) atomicReferenceFieldUpdater3.get(kVar2);
                    if (qVar == null) {
                        qVar = new R0.q(kVar2);
                        atomicReferenceFieldUpdater3.lazySet(kVar2, qVar);
                    }
                    do {
                        atomicReferenceFieldUpdater = R0.k.f558a;
                        if (atomicReferenceFieldUpdater.compareAndSet(this, objH, qVar)) {
                            kVar2.f();
                            return;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == objH);
                }
            }
        }
    }

    public final a0 k() {
        a0 a0Var = this.f404d;
        if (a0Var != null) {
            return a0Var;
        }
        F0.i.h("job");
        throw null;
    }

    public abstract void l(Throwable th);

    @Override // R0.k
    public final String toString() {
        return getClass().getSimpleName() + '@' + AbstractC0049v.d(this) + "[job@" + AbstractC0049v.d(k()) + ']';
    }
}
