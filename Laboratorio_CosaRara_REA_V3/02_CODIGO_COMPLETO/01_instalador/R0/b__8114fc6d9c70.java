// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package R0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f541a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus");
    private volatile Object _consensus = a.f535a;

    @Override // R0.p
    public final Object a(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f541a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        u uVar = a.f535a;
        if (obj2 == uVar) {
            u uVarC = c(obj);
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 == uVar) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, uVar, uVarC)) {
                    if (atomicReferenceFieldUpdater.get(this) != uVar) {
                        obj2 = atomicReferenceFieldUpdater.get(this);
                    }
                }
                obj2 = uVarC;
            }
        }
        b(obj, obj2);
        return obj2;
    }

    public abstract void b(Object obj, Object obj2);

    public abstract u c(Object obj);
}
