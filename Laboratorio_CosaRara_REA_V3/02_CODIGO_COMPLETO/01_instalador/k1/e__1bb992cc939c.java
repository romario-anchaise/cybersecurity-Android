// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import H.C0028c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: renamed from: k1.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0189e extends K {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReentrantLock f3471h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Condition f3472i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f3473j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f3474k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static C0189e f3475l;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C0189e f3477f;
    public long g;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f3471h = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        F0.i.d(conditionNewCondition, "newCondition(...)");
        f3472i = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f3473j = millis;
        f3474k = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final void h() {
        long j2 = this.f3459c;
        boolean z2 = this.f3457a;
        if (j2 != 0 || z2) {
            ReentrantLock reentrantLock = f3471h;
            reentrantLock.lock();
            try {
                if (this.f3476e != 0) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.f3476e = 1;
                C0028c.g(this, j2, z2);
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public final boolean i() {
        ReentrantLock reentrantLock = f3471h;
        reentrantLock.lock();
        try {
            int i2 = this.f3476e;
            this.f3476e = 0;
            if (i2 != 1) {
                boolean z2 = i2 == 2;
                reentrantLock.unlock();
                return z2;
            }
            C0189e c0189e = f3475l;
            while (c0189e != null) {
                C0189e c0189e2 = c0189e.f3477f;
                if (c0189e2 == this) {
                    c0189e.f3477f = this.f3477f;
                    this.f3477f = null;
                    reentrantLock.unlock();
                    return false;
                }
                c0189e = c0189e2;
            }
            throw new IllegalStateException("node was not found in the queue");
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public void j() {
    }
}
