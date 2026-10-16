// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d2;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r f608d = new r(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue f609a = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f611c = new AtomicBoolean(true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Semaphore f610b = new Semaphore(64);

    public s() {
        Thread thread = new Thread(new a2.b(8, this), "keylog-pull-cleanup");
        thread.setDaemon(true);
        thread.start();
    }

    public final synchronized boolean a(a2.h hVar) {
        if (this.f611c.get() && this.f610b.tryAcquire()) {
            boolean zOffer = this.f609a.offer(new a2.h(this, hVar, 4));
            if (!zOffer) {
                this.f610b.release();
            }
            return zOffer;
        }
        return false;
    }

    public final synchronized void b(Runnable runnable) {
        try {
            boolean z2 = !this.f611c.get() && this.f609a.remove(f608d);
            this.f609a.offer(runnable);
            if (z2) {
                this.f609a.offer(f608d);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c() {
        if (this.f611c.compareAndSet(true, false)) {
            this.f609a.offer(f608d);
        }
    }
}
