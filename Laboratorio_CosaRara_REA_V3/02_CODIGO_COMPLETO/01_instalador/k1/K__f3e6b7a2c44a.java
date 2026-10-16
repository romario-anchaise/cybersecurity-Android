// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class K {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final J f3456d = new J();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3459c;

    public K a() {
        this.f3457a = false;
        return this;
    }

    public K b() {
        this.f3459c = 0L;
        return this;
    }

    public long c() {
        if (this.f3457a) {
            return this.f3458b;
        }
        throw new IllegalStateException("No deadline");
    }

    public K d(long j2) {
        this.f3457a = true;
        this.f3458b = j2;
        return this;
    }

    public boolean e() {
        return this.f3457a;
    }

    public void f() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f3457a && this.f3458b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public K g(long j2, TimeUnit timeUnit) {
        F0.i.e(timeUnit, "unit");
        if (j2 < 0) {
            throw new IllegalArgumentException(F0.h.d("timeout < 0: ", j2).toString());
        }
        this.f3459c = timeUnit.toNanos(j2);
        return this;
    }
}
