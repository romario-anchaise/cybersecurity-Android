// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.IdentityHashMap;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a9 implements AutoCloseable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q.c f3483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final pa f3484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f3485e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IdentityHashMap f3486f = new IdentityHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a2.i f3487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3488h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3489i;

    public a9(q.c cVar, pa paVar) {
        this.f3483c = cVar;
        this.f3484d = paVar;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        boolean z2;
        Thread threadCurrentThread = Thread.currentThread();
        synchronized (this.f3485e) {
            try {
                if (!this.f3489i) {
                    this.f3489i = true;
                    a2.i iVar = this.f3487g;
                    if (iVar != null) {
                        this.f3483c.f3005a.removeCallbacks(iVar);
                        this.f3487g = null;
                    }
                }
                z2 = false;
                while (this.f3488h > ((Integer) this.f3486f.getOrDefault(threadCurrentThread, 0)).intValue()) {
                    try {
                        this.f3485e.wait();
                    } catch (InterruptedException unused) {
                        z2 = true;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            threadCurrentThread.interrupt();
        }
    }
}
