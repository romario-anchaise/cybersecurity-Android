// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread f849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CountDownLatch f850b;

    public l() {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getClass();
        this.f849a = threadCurrentThread;
        this.f850b = new CountDownLatch(1);
    }
}
