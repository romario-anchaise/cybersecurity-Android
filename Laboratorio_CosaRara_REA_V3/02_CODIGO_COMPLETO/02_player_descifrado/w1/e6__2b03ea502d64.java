// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e6 implements AutoCloseable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ExecutorService f3875c;

    public e6(ExecutorService executorService) {
        this.f3875c = executorService;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.f3875c.shutdownNow();
    }
}
