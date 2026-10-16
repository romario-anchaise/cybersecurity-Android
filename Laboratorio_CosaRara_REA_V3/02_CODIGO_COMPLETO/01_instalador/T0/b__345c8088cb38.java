// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package T0;

import N0.AbstractC0049v;
import R0.r;
import R0.u;
import androidx.fragment.app.y;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Executor, Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f592h = AtomicLongFieldUpdater.newUpdater(b.class, "parkedWorkersStack");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f593i = AtomicLongFieldUpdater.newUpdater(b.class, "controlState");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f594j = AtomicIntegerFieldUpdater.newUpdater(b.class, "_isTerminated");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final u f595k = new u(0, "NOT_IN_STACK");
    private volatile int _isTerminated;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f598c;
    private volatile long controlState;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f600e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f601f;
    public final r g;
    private volatile long parkedWorkersStack;

    public b(int i2, int i3, long j2, String str) {
        this.f596a = i2;
        this.f597b = i3;
        this.f598c = j2;
        this.f599d = str;
        if (i2 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
        }
        if (i3 < i2) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        }
        if (i3 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
        this.f600e = new e();
        this.f601f = new e();
        this.g = new r((i2 + 1) * 2);
        this.controlState = ((long) i2) << 42;
        this._isTerminated = 0;
    }

    public final int a() {
        synchronized (this.g) {
            try {
                if (f594j.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f593i;
                long j2 = atomicLongFieldUpdater.get(this);
                int i2 = (int) (j2 & 2097151);
                int i3 = i2 - ((int) ((j2 & 4398044413952L) >> 21));
                if (i3 < 0) {
                    i3 = 0;
                }
                if (i3 >= this.f596a) {
                    return 0;
                }
                if (i2 >= this.f597b) {
                    return 0;
                }
                int i4 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i4 <= 0 || this.g.b(i4) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                a aVar = new a(this, i4);
                this.g.c(i4, aVar);
                if (i4 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i5 = i3 + 1;
                aVar.start();
                return i5;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0089  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws InterruptedException {
        int i2;
        h hVarA;
        if (f594j.compareAndSet(this, 0, 1)) {
            Thread threadCurrentThread = Thread.currentThread();
            a aVar = threadCurrentThread instanceof a ? (a) threadCurrentThread : null;
            if (aVar == null || !F0.i.a(aVar.f591h, this)) {
                aVar = null;
            }
            synchronized (this.g) {
                i2 = (int) (f593i.get(this) & 2097151);
            }
            if (1 <= i2) {
                int i3 = 1;
                while (true) {
                    Object objB = this.g.b(i3);
                    F0.i.b(objB);
                    a aVar2 = (a) objB;
                    if (aVar2 != aVar) {
                        while (aVar2.isAlive()) {
                            LockSupport.unpark(aVar2);
                            aVar2.join(10000L);
                        }
                        m mVar = aVar2.f585a;
                        e eVar = this.f601f;
                        mVar.getClass();
                        h hVar = (h) m.f619b.getAndSet(mVar, null);
                        if (hVar != null) {
                            eVar.a(hVar);
                        }
                        while (true) {
                            h hVarB = mVar.b();
                            if (hVarB == null) {
                                break;
                            } else {
                                eVar.a(hVarB);
                            }
                        }
                    }
                    if (i3 == i2) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            this.f601f.b();
            this.f600e.b();
            while (true) {
                if (aVar != null) {
                    hVarA = aVar.a(true);
                    if (hVarA == null) {
                        hVarA = (h) this.f600e.d();
                        if (hVarA == null) {
                            break;
                            break;
                        }
                    }
                } else {
                    hVarA = (h) this.f600e.d();
                    if (hVarA == null && (hVarA = (h) this.f601f.d()) == null) {
                        break;
                    }
                }
                try {
                    hVarA.run();
                } catch (Throwable th) {
                    Thread threadCurrentThread2 = Thread.currentThread();
                    threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
                }
            }
            if (aVar != null) {
                aVar.h(5);
            }
            f592h.set(this, 0L);
            f593i.set(this, 0L);
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        f(runnable, k.g, false);
    }

    public final void f(Runnable runnable, i iVar, boolean z2) {
        h jVar;
        int i2;
        k.f616f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof h) {
            jVar = (h) runnable;
            jVar.f607a = jNanoTime;
            jVar.f608b = iVar;
        } else {
            jVar = new j(runnable, jNanoTime, iVar);
        }
        boolean z3 = false;
        boolean z4 = jVar.f608b.f609a == 1;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f593i;
        long jAddAndGet = z4 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        a aVar = threadCurrentThread instanceof a ? (a) threadCurrentThread : null;
        if (aVar == null || !F0.i.a(aVar.f591h, this)) {
            aVar = null;
        }
        if (aVar != null && (i2 = aVar.f587c) != 5 && (jVar.f608b.f609a != 0 || i2 != 2)) {
            aVar.g = true;
            m mVar = aVar.f585a;
            if (z2) {
                jVar = mVar.a(jVar);
            } else {
                mVar.getClass();
                h hVar = (h) m.f619b.getAndSet(mVar, jVar);
                jVar = hVar == null ? null : mVar.a(hVar);
            }
        }
        if (jVar != null) {
            if (!(jVar.f608b.f609a == 1 ? this.f601f.a(jVar) : this.f600e.a(jVar))) {
                throw new RejectedExecutionException(this.f599d + " was terminated");
            }
        }
        if (z2 && aVar != null) {
            z3 = true;
        }
        if (z4) {
            if (z3 || r() || n(jAddAndGet)) {
                return;
            }
            r();
            return;
        }
        if (z3 || r() || n(atomicLongFieldUpdater.get(this))) {
            return;
        }
        r();
    }

    public final void j(a aVar, int i2, int i3) {
        while (true) {
            long j2 = f592h.get(this);
            int i4 = (int) (2097151 & j2);
            long j3 = (2097152 + j2) & (-2097152);
            if (i4 == i2) {
                if (i3 == 0) {
                    Object objC = aVar.c();
                    while (true) {
                        if (objC == f595k) {
                            i4 = -1;
                            break;
                        }
                        if (objC == null) {
                            i4 = 0;
                            break;
                        }
                        a aVar2 = (a) objC;
                        int iB = aVar2.b();
                        if (iB != 0) {
                            i4 = iB;
                            break;
                        }
                        objC = aVar2.c();
                    }
                } else {
                    i4 = i3;
                }
            }
            if (i4 >= 0) {
                if (f592h.compareAndSet(this, j2, ((long) i4) | j3)) {
                    return;
                }
            }
        }
    }

    public final boolean n(long j2) {
        int i2 = ((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21));
        if (i2 < 0) {
            i2 = 0;
        }
        int i3 = this.f596a;
        if (i2 < i3) {
            int iA = a();
            if (iA == 1 && i3 > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean r() {
        u uVar;
        int iB;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f592h;
            long j2 = atomicLongFieldUpdater.get(this);
            a aVar = (a) this.g.b((int) (2097151 & j2));
            if (aVar == null) {
                aVar = null;
            } else {
                long j3 = (2097152 + j2) & (-2097152);
                Object objC = aVar.c();
                while (true) {
                    uVar = f595k;
                    if (objC == uVar) {
                        iB = -1;
                        break;
                    }
                    if (objC == null) {
                        iB = 0;
                        break;
                    }
                    a aVar2 = (a) objC;
                    iB = aVar2.b();
                    if (iB != 0) {
                        break;
                    }
                    objC = aVar2.c();
                }
                if (iB >= 0 && atomicLongFieldUpdater.compareAndSet(this, j2, j3 | ((long) iB))) {
                    aVar.g(uVar);
                }
            }
            if (aVar == null) {
                return false;
            }
            if (a.f584i.compareAndSet(aVar, -1, 0)) {
                LockSupport.unpark(aVar);
                return true;
            }
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        r rVar = this.g;
        int iA = rVar.a();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < iA; i7++) {
            a aVar = (a) rVar.b(i7);
            if (aVar != null) {
                m mVar = aVar.f585a;
                mVar.getClass();
                int i8 = m.f619b.get(mVar) != null ? (m.f620c.get(mVar) - m.f621d.get(mVar)) + 1 : m.f620c.get(mVar) - m.f621d.get(mVar);
                int iB = y.b(aVar.f587c);
                if (iB == 0) {
                    i2++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i8);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iB == 1) {
                    i3++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i8);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iB == 2) {
                    i4++;
                } else if (iB == 3) {
                    i5++;
                    if (i8 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i8);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (iB == 4) {
                    i6++;
                }
            }
        }
        long j2 = f593i.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f599d);
        sb4.append('@');
        sb4.append(AbstractC0049v.d(this));
        sb4.append("[Pool Size {core = ");
        int i9 = this.f596a;
        sb4.append(i9);
        sb4.append(", max = ");
        sb4.append(this.f597b);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i2);
        sb4.append(", blocking = ");
        sb4.append(i3);
        sb4.append(", parked = ");
        sb4.append(i4);
        sb4.append(", dormant = ");
        sb4.append(i5);
        sb4.append(", terminated = ");
        sb4.append(i6);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.f600e.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.f601f.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j2));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j2) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i9 - ((int) ((j2 & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
