// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a3 implements IntConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f3459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f3460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f3461c;

    public /* synthetic */ a3(AtomicBoolean atomicBoolean, AtomicInteger atomicInteger, CountDownLatch countDownLatch) {
        this.f3459a = atomicBoolean;
        this.f3460b = atomicInteger;
        this.f3461c = countDownLatch;
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i3) {
        if (this.f3459a.compareAndSet(false, true)) {
            this.f3460b.set(i3);
            this.f3461c.countDown();
        }
    }
}
