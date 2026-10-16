// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class bf implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f3628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Runnable f3629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f3630e = new AtomicBoolean(false);

    public bf(Runnable runnable, Runnable runnable2) {
        this.f3628c = runnable;
        this.f3629d = runnable2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3630e.compareAndSet(false, true)) {
            this.f3628c.run();
        }
    }
}
