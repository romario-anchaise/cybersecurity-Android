// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package T0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f619b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f620c = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f621d = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f622e = AtomicIntegerFieldUpdater.newUpdater(m.class, "blockingTasksInBuffer");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f623a = new AtomicReferenceArray(128);
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    public final h a(h hVar) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f620c;
        if (atomicIntegerFieldUpdater.get(this) - f621d.get(this) == 127) {
            return hVar;
        }
        if (hVar.f608b.f609a == 1) {
            f622e.incrementAndGet(this);
        }
        int i2 = atomicIntegerFieldUpdater.get(this) & 127;
        while (true) {
            AtomicReferenceArray atomicReferenceArray = this.f623a;
            if (atomicReferenceArray.get(i2) == null) {
                atomicReferenceArray.lazySet(i2, hVar);
                atomicIntegerFieldUpdater.incrementAndGet(this);
                return null;
            }
            Thread.yield();
        }
    }

    public final h b() {
        h hVar;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f621d;
            int i2 = atomicIntegerFieldUpdater.get(this);
            if (i2 - f620c.get(this) == 0) {
                return null;
            }
            int i3 = i2 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i2, i2 + 1) && (hVar = (h) this.f623a.getAndSet(i3, null)) != null) {
                if (hVar.f608b.f609a == 1) {
                    f622e.decrementAndGet(this);
                }
                return hVar;
            }
        }
    }

    public final h c(int i2, boolean z2) {
        int i3 = i2 & 127;
        AtomicReferenceArray atomicReferenceArray = this.f623a;
        h hVar = (h) atomicReferenceArray.get(i3);
        if (hVar != null) {
            if ((hVar.f608b.f609a == 1) == z2) {
                while (!atomicReferenceArray.compareAndSet(i3, hVar, null)) {
                    if (atomicReferenceArray.get(i3) != hVar) {
                    }
                }
                if (z2) {
                    f622e.decrementAndGet(this);
                }
                return hVar;
            }
        }
        return null;
    }
}
