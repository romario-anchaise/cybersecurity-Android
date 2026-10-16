// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w2;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y f5814d = new y();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f5816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5817c;

    public z a() {
        this.f5815a = false;
        return this;
    }

    public z b() {
        this.f5817c = 0L;
        return this;
    }

    public long c() {
        if (this.f5815a) {
            return this.f5816b;
        }
        o2.k("No deadline");
        return 0L;
    }

    public z d(long j3) {
        this.f5815a = true;
        this.f5816b = j3;
        return this;
    }

    public boolean e() {
        return this.f5815a;
    }

    public void f() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f5815a && this.f5816b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public z g(long j3, TimeUnit timeUnit) {
        timeUnit.getClass();
        if (j3 >= 0) {
            this.f5817c = timeUnit.toNanos(j3);
            return this;
        }
        o2.j("timeout < 0: ", j3);
        return null;
    }

    public long h() {
        return this.f5817c;
    }
}
