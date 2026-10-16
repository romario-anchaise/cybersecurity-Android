// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p025o;

import f1.l;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class d extends l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f3974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f3975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f3976e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f3977f;
    public final AtomicReferenceFieldUpdater g;

    public d(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f3974c = atomicReferenceFieldUpdater;
        this.f3975d = atomicReferenceFieldUpdater2;
        this.f3976e = atomicReferenceFieldUpdater3;
        this.f3977f = atomicReferenceFieldUpdater4;
        this.g = atomicReferenceFieldUpdater5;
    }

    @Override // f1.l
    public final void P(f fVar, f fVar2) {
        this.f3975d.lazySet(fVar, fVar2);
    }

    @Override // f1.l
    public final void Q(f fVar, Thread thread) {
        this.f3974c.lazySet(fVar, thread);
    }

    @Override // f1.l
    public final boolean g(g gVar, c cVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        c cVar2 = c.f3972b;
        do {
            atomicReferenceFieldUpdater = this.f3977f;
            if (atomicReferenceFieldUpdater.compareAndSet(gVar, cVar, cVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(gVar) == cVar);
        return false;
    }

    @Override // f1.l
    public final boolean h(g gVar, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.g;
            if (atomicReferenceFieldUpdater.compareAndSet(gVar, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(gVar) == obj);
        return false;
    }

    @Override // f1.l
    public final boolean i(g gVar, f fVar, f fVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f3976e;
            if (atomicReferenceFieldUpdater.compareAndSet(gVar, fVar, fVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(gVar) == fVar);
        return false;
    }
}
