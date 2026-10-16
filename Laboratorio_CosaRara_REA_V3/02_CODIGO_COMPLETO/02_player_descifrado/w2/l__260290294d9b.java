// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w2;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class l extends z {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public z f5782e;

    public l(z zVar) {
        zVar.getClass();
        this.f5782e = zVar;
    }

    @Override // w2.z
    public final z a() {
        return this.f5782e.a();
    }

    @Override // w2.z
    public final z b() {
        return this.f5782e.b();
    }

    @Override // w2.z
    public final long c() {
        return this.f5782e.c();
    }

    @Override // w2.z
    public final z d(long j3) {
        return this.f5782e.d(j3);
    }

    @Override // w2.z
    public final boolean e() {
        return this.f5782e.e();
    }

    @Override // w2.z
    public final void f() throws InterruptedIOException {
        this.f5782e.f();
    }

    @Override // w2.z
    public final z g(long j3, TimeUnit timeUnit) {
        timeUnit.getClass();
        return this.f5782e.g(j3, timeUnit);
    }

    @Override // w2.z
    public final long h() {
        return this.f5782e.h();
    }
}
