// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f2820a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f2821b;

    public a(boolean z2) {
        this.f2821b = z2;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, (this.f2821b ? "WM.task-" : "androidx.work-") + this.f2820a.incrementAndGet());
    }
}
