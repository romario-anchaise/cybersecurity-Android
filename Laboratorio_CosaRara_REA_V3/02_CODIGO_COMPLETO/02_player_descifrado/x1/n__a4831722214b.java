// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f5902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CountDownLatch f5903d = new CountDownLatch(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicInteger f5904e = new AtomicInteger(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f5905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f5906g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile Throwable f5907h;

    public n(m mVar, long j3) {
        this.f5902c = mVar;
        this.f5905f = j3;
    }

    public final void a(boolean z2) {
        while (true) {
            int i3 = this.f5904e.get();
            if (i3 == 2 || i3 == 3) {
                break;
            }
            try {
                this.f5903d.await();
            } catch (InterruptedException unused) {
                z2 = true;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    public final boolean b() {
        Throwable th = this.f5907h;
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        if (th == null) {
            return this.f5906g;
        }
        throw new IllegalStateException(th);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f5904e.compareAndSet(0, 1)) {
            if (System.nanoTime() - this.f5905f >= 0) {
                this.f5904e.set(3);
                this.f5903d.countDown();
                return;
            }
            try {
                this.f5906g = this.f5902c.mo0run();
                this.f5904e.set(2);
                this.f5903d.countDown();
            } catch (Throwable th) {
                try {
                    this.f5907h = th;
                } finally {
                    this.f5904e.set(2);
                    this.f5903d.countDown();
                }
            }
        }
    }
}
