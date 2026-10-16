// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package R0;

import N0.d0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class t extends c implements d0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f572d = AtomicIntegerFieldUpdater.newUpdater(t.class, "cleanedAndPointers");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f573c;
    private volatile int cleanedAndPointers;

    public t(long j2, U0.f fVar, int i2) {
        super(fVar);
        this.f573c = j2;
        this.cleanedAndPointers = i2 << 16;
    }

    @Override // R0.c
    public final boolean a() {
        if (f572d.get(this) == d()) {
            Object obj = c.f542a.get(this);
            if ((obj == a.f536b ? null : (c) obj) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean c() {
        if (f572d.addAndGet(this, -65536) == d()) {
            Object obj = c.f542a.get(this);
            if ((obj == a.f536b ? null : (c) obj) != null) {
                return true;
            }
        }
        return false;
    }

    public abstract int d();

    public abstract void e(int i2);

    public final boolean f() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        do {
            atomicIntegerFieldUpdater = f572d;
            i2 = atomicIntegerFieldUpdater.get(this);
            if (i2 == d()) {
                Object obj = c.f542a.get(this);
                if ((obj == a.f536b ? null : (c) obj) != null) {
                    return false;
                }
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 65536 + i2));
        return true;
    }
}
