// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements Executor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Executor f6248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f6249e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayDeque f6247c = new ArrayDeque();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f6250f = new Object();

    public l(Executor executor) {
        this.f6248d = executor;
    }

    public final void a() {
        Runnable runnable = (Runnable) this.f6247c.poll();
        this.f6249e = runnable;
        if (runnable != null) {
            this.f6248d.execute(runnable);
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this.f6250f) {
            try {
                this.f6247c.add(new g0.j(this, runnable, 16, false));
                if (this.f6249e == null) {
                    a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
