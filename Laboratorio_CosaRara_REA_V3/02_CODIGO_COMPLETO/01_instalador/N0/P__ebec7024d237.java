// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class P extends U {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f399f = AtomicIntegerFieldUpdater.newUpdater(P.class, "_invoked");
    private volatile int _invoked;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final E0.l f400e;

    public P(E0.l lVar) {
        this.f400e = lVar;
    }

    @Override // E0.l
    public final /* bridge */ /* synthetic */ Object d(Object obj) {
        l((Throwable) obj);
        return p034t0.h.f4132b;
    }

    @Override // N0.W
    public final void l(Throwable th) {
        if (f399f.compareAndSet(this, 0, 1)) {
            this.f400e.d(th);
        }
    }
}
