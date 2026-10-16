// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: renamed from: N0.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0050w extends G implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final RunnableC0050w f462i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f463j;

    static {
        Long l2;
        RunnableC0050w runnableC0050w = new RunnableC0050w();
        f462i = runnableC0050w;
        runnableC0050w.y(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l2 = 1000L;
        }
        f463j = timeUnit.toNanos(l2.longValue());
    }

    @Override // N0.G, N0.H
    public final void A() {
        debugStatus = 4;
        super.A();
    }

    @Override // N0.G
    public final void B(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.B(runnable);
    }

    public final synchronized void E() {
        int i2 = debugStatus;
        if (i2 == 2 || i2 == 3) {
            debugStatus = 3;
            G.f388f.set(this, null);
            G.g.set(this, null);
            notifyAll();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        h0.f428a.set(this);
        try {
            synchronized (this) {
                int i2 = debugStatus;
                if (i2 == 2 || i2 == 3) {
                    _thread = null;
                    E();
                    if (C()) {
                        return;
                    }
                    x();
                    return;
                }
                debugStatus = 1;
                notifyAll();
                long j2 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long jD = D();
                    if (jD == Long.MAX_VALUE) {
                        long jNanoTime = System.nanoTime();
                        if (j2 == Long.MAX_VALUE) {
                            j2 = f463j + jNanoTime;
                        }
                        long j3 = j2 - jNanoTime;
                        if (j3 <= 0) {
                            _thread = null;
                            E();
                            if (C()) {
                                return;
                            }
                            x();
                            return;
                        }
                        if (jD > j3) {
                            jD = j3;
                        }
                    } else {
                        j2 = Long.MAX_VALUE;
                    }
                    if (jD > 0) {
                        int i3 = debugStatus;
                        if (i3 == 2 || i3 == 3) {
                            _thread = null;
                            E();
                            if (C()) {
                                return;
                            }
                            x();
                            return;
                        }
                        LockSupport.parkNanos(this, jD);
                    }
                }
            }
        } catch (Throwable th) {
            _thread = null;
            E();
            if (!C()) {
                x();
            }
            throw th;
        }
    }

    @Override // N0.H
    public final Thread x() {
        Thread thread = _thread;
        if (thread == null) {
            synchronized (this) {
                thread = _thread;
                if (thread == null) {
                    thread = new Thread(this, "N0.w");
                    _thread = thread;
                    thread.setDaemon(true);
                    thread.start();
                }
            }
        }
        return thread;
    }
}
