// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes.dex */
public abstract class G extends H implements InterfaceC0053z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f388f = AtomicReferenceFieldUpdater.newUpdater(G.class, Object.class, "_queue");
    public static final AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(G.class, Object.class, "_delayed");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f389h = AtomicIntegerFieldUpdater.newUpdater(G.class, "_isCompleted");
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    @Override // N0.H
    public void A() {
        h0.f428a.set(null);
        f389h.set(this, 1);
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f388f;
            Object obj = atomicReferenceFieldUpdater.get(this);
            R0.u uVar = AbstractC0049v.f455b;
            if (obj == null) {
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, null, uVar)) {
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == null);
            } else if (obj instanceof R0.n) {
                ((R0.n) obj).b();
                break;
            } else {
                if (obj == uVar) {
                    break;
                }
                R0.n nVar = new R0.n(8, true);
                nVar.a((Runnable) obj);
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, nVar)) {
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == obj);
            }
        }
        while (D() <= 0) {
        }
        System.nanoTime();
    }

    public void B(Runnable runnable) {
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f388f;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (f389h.get(this) == 0) {
                if (obj == null) {
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, null, runnable)) {
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == null);
                } else if (obj instanceof R0.n) {
                    R0.n nVar = (R0.n) obj;
                    int iA = nVar.a(runnable);
                    if (iA == 0) {
                        break;
                    }
                    if (iA == 1) {
                        R0.n nVarC = nVar.c();
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, nVarC) && atomicReferenceFieldUpdater.get(this) == obj) {
                        }
                    } else if (iA != 2) {
                    }
                } else if (obj != AbstractC0049v.f455b) {
                    R0.n nVar2 = new R0.n(8, true);
                    nVar2.a((Runnable) obj);
                    nVar2.a(runnable);
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj, nVar2)) {
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == obj);
                }
            }
            RunnableC0050w.f462i.B(runnable);
            return;
        }
        Thread threadX = x();
        if (Thread.currentThread() != threadX) {
            LockSupport.unpark(threadX);
        }
    }

    public final boolean C() {
        p036u0.d dVar = this.f392e;
        if (!(dVar != null ? dVar.isEmpty() : true)) {
            return false;
        }
        Object obj = f388f.get(this);
        if (obj == null) {
            return true;
        }
        if (obj instanceof R0.n) {
            long j2 = R0.n.f564f.get((R0.n) obj);
            if (((int) (1073741823 & j2)) == ((int) ((j2 & 1152921503533105152L) >> 30))) {
                return true;
            }
        } else if (obj == AbstractC0049v.f455b) {
            return true;
        }
        return false;
    }

    public final long D() {
        Runnable runnable;
        if (z()) {
            return 0L;
        }
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f388f;
            Object obj = atomicReferenceFieldUpdater.get(this);
            runnable = null;
            if (obj == null) {
                break;
            }
            if (obj instanceof R0.n) {
                R0.n nVar = (R0.n) obj;
                Object objD = nVar.d();
                if (objD != R0.n.g) {
                    runnable = (Runnable) objD;
                    break;
                }
                R0.n nVarC = nVar.c();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, nVarC) && atomicReferenceFieldUpdater.get(this) == obj) {
                }
            } else {
                if (obj == AbstractC0049v.f455b) {
                    break;
                }
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                        runnable = (Runnable) obj;
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == obj);
            }
        }
        if (runnable != null) {
            runnable.run();
            return 0L;
        }
        p036u0.d dVar = this.f392e;
        if (((dVar == null || dVar.isEmpty()) ? Long.MAX_VALUE : 0L) == 0) {
            return 0L;
        }
        Object obj2 = f388f.get(this);
        if (obj2 == null) {
        } else if (obj2 instanceof R0.n) {
            long j2 = R0.n.f564f.get((R0.n) obj2);
            if (((int) (1073741823 & j2)) != ((int) ((j2 & 1152921503533105152L) >> 30))) {
                return 0L;
            }
        } else if (obj2 != AbstractC0049v.f455b) {
            return 0L;
        }
        return Long.MAX_VALUE;
    }

    @Override // N0.AbstractC0045q
    public final void u(p040w0.i iVar, Runnable runnable) {
        B(runnable);
    }
}
