// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package R0;

import N0.AbstractC0049v;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f558a = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f559b = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_prev");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f560c = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_removedRef");
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    public final k f() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f559b;
            k kVar = (k) atomicReferenceFieldUpdater2.get(this);
            k kVar2 = kVar;
            while (true) {
                k kVar3 = null;
                while (true) {
                    atomicReferenceFieldUpdater = f558a;
                    obj = atomicReferenceFieldUpdater.get(kVar2);
                    if (obj == this) {
                        if (kVar == kVar2) {
                            return kVar2;
                        }
                        while (!atomicReferenceFieldUpdater2.compareAndSet(this, kVar, kVar2)) {
                            if (atomicReferenceFieldUpdater2.get(this) != kVar) {
                                break;
                            }
                        }
                        return kVar2;
                    }
                    if (j()) {
                        return null;
                    }
                    if (obj == null) {
                        return kVar2;
                    }
                    if (obj instanceof p) {
                        ((p) obj).a(kVar2);
                        break;
                    }
                    if (!(obj instanceof q)) {
                        F0.i.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                        kVar3 = kVar2;
                        kVar2 = (k) obj;
                    } else {
                        if (kVar3 != null) {
                            break;
                        }
                        kVar2 = (k) atomicReferenceFieldUpdater2.get(kVar2);
                    }
                }
                k kVar4 = ((q) obj).f570a;
                while (!atomicReferenceFieldUpdater.compareAndSet(kVar3, kVar2, kVar4)) {
                    if (atomicReferenceFieldUpdater.get(kVar3) != kVar2) {
                        break;
                    }
                }
                kVar2 = kVar3;
            }
        }
    }

    public final void g(k kVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f559b;
            k kVar2 = (k) atomicReferenceFieldUpdater.get(kVar);
            if (h() != kVar) {
                return;
            }
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(kVar, kVar2, this)) {
                    if (j()) {
                        kVar.f();
                        return;
                    }
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(kVar) == kVar2);
        }
    }

    public final Object h() {
        while (true) {
            Object obj = f558a.get(this);
            if (!(obj instanceof p)) {
                return obj;
            }
            ((p) obj).a(this);
        }
    }

    public final k i() {
        k kVar;
        Object objH = h();
        q qVar = objH instanceof q ? (q) objH : null;
        if (qVar != null && (kVar = qVar.f570a) != null) {
            return kVar;
        }
        F0.i.c(objH, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (k) objH;
    }

    public boolean j() {
        return h() instanceof q;
    }

    public String toString() {
        return new j(this) + '@' + AbstractC0049v.d(this);
    }
}
