// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class f extends z {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReentrantLock f5761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Condition f5762i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f5763j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f5764k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static f f5765l;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f5767f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f5768g;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f5761h = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        conditionNewCondition.getClass();
        f5762i = conditionNewCondition;
        f5763j = 60000L;
        f5764k = 60000000000L;
    }

    public final void i() {
        f fVar;
        long j3 = this.f5817c;
        boolean z2 = this.f5815a;
        if (j3 != 0 || z2) {
            ReentrantLock reentrantLock = f5761h;
            reentrantLock.lock();
            try {
                if (this.f5766e) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.f5766e = true;
                if (f5765l == null) {
                    f5765l = new f();
                    c cVar = new c("Okio Watchdog");
                    cVar.setDaemon(true);
                    cVar.start();
                }
                long jNanoTime = System.nanoTime();
                if (j3 != 0 && z2) {
                    this.f5768g = Math.min(j3, c() - jNanoTime) + jNanoTime;
                } else if (j3 != 0) {
                    this.f5768g = j3 + jNanoTime;
                } else {
                    if (!z2) {
                        throw new AssertionError();
                    }
                    this.f5768g = c();
                }
                long j4 = this.f5768g - jNanoTime;
                f fVar2 = f5765l;
                fVar2.getClass();
                while (true) {
                    fVar = fVar2.f5767f;
                    if (fVar == null || j4 < fVar.f5768g - jNanoTime) {
                        break;
                        break;
                    }
                    fVar2 = fVar;
                }
                this.f5767f = fVar;
                fVar2.f5767f = this;
                if (fVar2 == f5765l) {
                    f5762i.signal();
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public final boolean j() {
        ReentrantLock reentrantLock = f5761h;
        reentrantLock.lock();
        try {
            if (!this.f5766e) {
                return false;
            }
            this.f5766e = false;
            f fVar = f5765l;
            while (fVar != null) {
                f fVar2 = fVar.f5767f;
                if (fVar2 == this) {
                    fVar.f5767f = this.f5767f;
                    this.f5767f = null;
                    return false;
                }
                fVar = fVar2;
            }
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void k() {
    }
}
