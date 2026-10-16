// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p017k;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f3404a = new AtomicInteger(0);

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("arch_disk_io_" + this.f3404a.getAndIncrement());
        return thread;
    }
}
