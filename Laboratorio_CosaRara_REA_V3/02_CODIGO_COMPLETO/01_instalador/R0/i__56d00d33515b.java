// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package R0;

import N0.AbstractC0045q;
import N0.AbstractC0051x;
import N0.InterfaceC0053z;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class i extends AbstractC0045q implements InterfaceC0053z {
    public static final AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(i.class, "runningWorkers");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC0045q f554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l f556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f557f;
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public i(AbstractC0045q abstractC0045q, int i2) {
        this.f554c = abstractC0045q;
        this.f555d = i2;
        if ((abstractC0045q instanceof InterfaceC0053z ? (InterfaceC0053z) abstractC0045q : null) == null) {
            int i3 = AbstractC0051x.f464a;
        }
        this.f556e = new l();
        this.f557f = new Object();
    }

    @Override // N0.AbstractC0045q
    public final void u(p040w0.i iVar, Runnable runnable) {
        this.f556e.a(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g;
        if (atomicIntegerFieldUpdater.get(this) < this.f555d) {
            synchronized (this.f557f) {
                if (atomicIntegerFieldUpdater.get(this) >= this.f555d) {
                    return;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
                Runnable runnableW = w();
                if (runnableW == null) {
                    return;
                }
                this.f554c.u(this, new h(this, runnableW));
            }
        }
    }

    public final Runnable w() {
        while (true) {
            Runnable runnable = (Runnable) this.f556e.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f557f) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f556e.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }
}
