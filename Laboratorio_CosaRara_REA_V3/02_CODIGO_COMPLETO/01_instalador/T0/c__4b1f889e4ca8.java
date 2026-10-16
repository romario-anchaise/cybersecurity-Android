// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package T0;

import N0.AbstractC0045q;
import N0.I;
import R0.v;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class c extends I implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f602c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AbstractC0045q f603d;

    static {
        l lVar = l.f618c;
        int i2 = v.f576a;
        if (64 >= i2) {
            i2 = 64;
        }
        f603d = lVar.w(R0.a.h("kotlinx.coroutines.io.parallelism", i2, 0, 0, 12));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        u(p040w0.j.f4165a, runnable);
    }

    @Override // N0.AbstractC0045q
    public final String toString() {
        return "Dispatchers.IO";
    }

    @Override // N0.AbstractC0045q
    public final void u(p040w0.i iVar, Runnable runnable) {
        f603d.u(iVar, runnable);
    }
}
