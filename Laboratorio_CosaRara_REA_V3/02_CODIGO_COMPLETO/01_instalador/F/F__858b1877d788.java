// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p009f;

import O.g;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class F implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2410a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque f2411b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final G f2412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f2413d;

    public F(G g) {
        this.f2412c = g;
    }

    public final void a() {
        synchronized (this.f2410a) {
            try {
                Runnable runnable = (Runnable) this.f2411b.poll();
                this.f2413d = runnable;
                if (runnable != null) {
                    this.f2412c.execute(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this.f2410a) {
            try {
                this.f2411b.add(new g(this, 2, runnable));
                if (this.f2413d == null) {
                    a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
