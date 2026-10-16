// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends q2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f18a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f19b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f20c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f21d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f22e;

    public f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f18a = atomicReferenceFieldUpdater;
        this.f19b = atomicReferenceFieldUpdater2;
        this.f20c = atomicReferenceFieldUpdater3;
        this.f21d = atomicReferenceFieldUpdater4;
        this.f22e = atomicReferenceFieldUpdater5;
    }

    @Override // q2.c
    public final boolean d(j jVar, e eVar, e eVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f21d;
            if (atomicReferenceFieldUpdater.compareAndSet(jVar, eVar, eVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(jVar) == eVar);
        return false;
    }

    @Override // q2.c
    public final boolean e(j jVar, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f22e;
            if (atomicReferenceFieldUpdater.compareAndSet(jVar, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(jVar) == obj);
        return false;
    }

    @Override // q2.c
    public final boolean f(j jVar, i iVar, i iVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f20c;
            if (atomicReferenceFieldUpdater.compareAndSet(jVar, iVar, iVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(jVar) == iVar);
        return false;
    }

    @Override // q2.c
    public final void y(i iVar, i iVar2) {
        this.f19b.lazySet(iVar, iVar2);
    }

    @Override // q2.c
    public final void z(i iVar, Thread thread) {
        this.f18a.lazySet(iVar, thread);
    }
}
