// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class A extends R0.s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f383e = AtomicIntegerFieldUpdater.newUpdater(A.class, "_decision");
    private volatile int _decision;

    @Override // R0.s, N0.a0
    public final void h(Object obj) {
        i(obj);
    }

    @Override // R0.s, N0.a0
    public final void i(Object obj) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        do {
            atomicIntegerFieldUpdater = f383e;
            int i2 = atomicIntegerFieldUpdater.get(this);
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                R0.a.f(p029q.j.l(this.f571d), AbstractC0049v.j(obj), null);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 2));
    }
}
