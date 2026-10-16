// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class r extends K {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public K f3500e;

    public r(K k2) {
        F0.i.e(k2, "delegate");
        this.f3500e = k2;
    }

    @Override // k1.K
    public final K a() {
        return this.f3500e.a();
    }

    @Override // k1.K
    public final K b() {
        return this.f3500e.b();
    }

    @Override // k1.K
    public final long c() {
        return this.f3500e.c();
    }

    @Override // k1.K
    public final K d(long j2) {
        return this.f3500e.d(j2);
    }

    @Override // k1.K
    public final boolean e() {
        return this.f3500e.e();
    }

    @Override // k1.K
    public final void f() throws InterruptedIOException {
        this.f3500e.f();
    }

    @Override // k1.K
    public final K g(long j2, TimeUnit timeUnit) {
        F0.i.e(timeUnit, "unit");
        return this.f3500e.g(j2, timeUnit);
    }
}
