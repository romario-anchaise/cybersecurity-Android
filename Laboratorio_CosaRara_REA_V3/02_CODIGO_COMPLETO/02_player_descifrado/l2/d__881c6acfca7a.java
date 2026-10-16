// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package l2;

import g2.g;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import w1.bf;
import w1.v8;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadPoolExecutor f2420a;

    public d(String str) {
        this.f2420a = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue(1), new g(str, 1), new ThreadPoolExecutor.AbortPolicy());
    }

    public synchronized void a(Runnable runnable, v8 v8Var) {
        Runnable runnable2;
        Runnable runnable3;
        if (this.f2420a.isShutdown()) {
            throw new RejectedExecutionException("telemetry executor is shut down");
        }
        Runnable runnablePoll = this.f2420a.getQueue().poll();
        if (runnablePoll instanceof bf) {
            bf bfVar = (bf) runnablePoll;
            if (bfVar.f3630e.compareAndSet(false, true) && (runnable3 = bfVar.f3629d) != null) {
                runnable3.run();
            }
        }
        bf bfVar2 = new bf(runnable, v8Var);
        try {
            this.f2420a.execute(bfVar2);
        } catch (RejectedExecutionException e3) {
            if (bfVar2.f3630e.compareAndSet(false, true) && (runnable2 = bfVar2.f3629d) != null) {
                runnable2.run();
            }
            throw e3;
        }
    }

    public d(j2.a aVar) {
        this.f2420a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), aVar);
    }
}
