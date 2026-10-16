// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class i0 implements E0.l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f430c = AtomicIntegerFieldUpdater.newUpdater(i0.class, "_state");
    private volatile int _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread f431a = Thread.currentThread();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public D f432b;

    public i0(S s2) {
    }

    public static void b(int i2) {
        throw new IllegalStateException(("Illegal state " + i2).toString());
    }

    public final void a() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f430c;
            int i2 = atomicIntegerFieldUpdater.get(this);
            if (i2 != 0) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        b(i2);
                        throw null;
                    }
                }
            } else if (atomicIntegerFieldUpdater.compareAndSet(this, i2, 1)) {
                D d2 = this.f432b;
                if (d2 != null) {
                    d2.c();
                    return;
                }
                return;
            }
        }
    }

    @Override // E0.l
    public final Object d(Object obj) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        do {
            atomicIntegerFieldUpdater = f430c;
            i2 = atomicIntegerFieldUpdater.get(this);
            if (i2 != 0) {
                if (i2 != 1 && i2 != 2 && i2 != 3) {
                    b(i2);
                    throw null;
                }
            }
            return p034t0.h.f4132b;
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 2));
        this.f431a.interrupt();
        atomicIntegerFieldUpdater.set(this, 3);
        return p034t0.h.f4132b;
    }
}
