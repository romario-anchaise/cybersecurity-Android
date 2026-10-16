// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package R0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f542a = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f543b = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_prev");
    private volatile Object _next;
    private volatile Object _prev;

    public c(t tVar) {
        this._prev = tVar;
    }

    public abstract boolean a();

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f542a;
        Object obj = atomicReferenceFieldUpdater.get(this);
        u uVar = a.f536b;
        if ((obj == uVar ? null : (c) obj) == null) {
            return;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f543b;
            c cVar = (c) atomicReferenceFieldUpdater2.get(this);
            while (cVar != null && cVar.a()) {
                cVar = (c) atomicReferenceFieldUpdater2.get(cVar);
            }
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            c cVar2 = obj2 == uVar ? null : (c) obj2;
            F0.i.b(cVar2);
            while (cVar2.a()) {
                Object obj3 = atomicReferenceFieldUpdater.get(cVar2);
                c cVar3 = obj3 == uVar ? null : (c) obj3;
                if (cVar3 == null) {
                    break;
                } else {
                    cVar2 = cVar3;
                }
            }
            while (true) {
                Object obj4 = atomicReferenceFieldUpdater2.get(cVar2);
                c cVar4 = ((c) obj4) == null ? null : cVar;
                while (true) {
                    if (atomicReferenceFieldUpdater2.compareAndSet(cVar2, obj4, cVar4)) {
                        break;
                    } else if (atomicReferenceFieldUpdater2.get(cVar2) != obj4) {
                    }
                }
            }
            if (cVar != null) {
                atomicReferenceFieldUpdater.set(cVar, cVar2);
            }
            if (cVar2.a()) {
                Object obj5 = atomicReferenceFieldUpdater.get(cVar2);
                if ((obj5 == uVar ? null : (c) obj5) != null) {
                    continue;
                }
            }
            if (cVar == null || !cVar.a()) {
                return;
            }
        }
    }
}
