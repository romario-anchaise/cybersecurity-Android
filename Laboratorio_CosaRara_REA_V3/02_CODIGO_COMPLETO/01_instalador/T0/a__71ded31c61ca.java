// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package T0;

import F0.n;
import R0.u;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes.dex */
public final class a extends Thread {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f584i = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f590f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ b f591h;
    private volatile int indexInArray;
    private volatile Object nextParkedWorker;
    private volatile int workerCtl;

    public a(b bVar, int i2) {
        this.f591h = bVar;
        setDaemon(true);
        this.f585a = new m();
        this.f586b = new n();
        this.f587c = 4;
        this.nextParkedWorker = b.f595k;
        H0.e.f256a.getClass();
        this.f590f = H0.e.f257b.a().nextInt();
        f(i2);
    }

    public final h a(boolean z2) {
        h hVarE;
        h hVarE2;
        b bVar;
        long j2;
        int i2 = this.f587c;
        h hVar = null;
        m mVar = this.f585a;
        b bVar2 = this.f591h;
        if (i2 != 1) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = b.f593i;
            do {
                bVar = this.f591h;
                j2 = atomicLongFieldUpdater.get(bVar);
                if (((int) ((9223367638808264704L & j2) >> 42)) == 0) {
                    mVar.getClass();
                    loop1: while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m.f619b;
                        h hVar2 = (h) atomicReferenceFieldUpdater.get(mVar);
                        if (hVar2 == null || hVar2.f608b.f609a != 1) {
                            int i3 = m.f621d.get(mVar);
                            int i4 = m.f620c.get(mVar);
                            while (i3 != i4 && m.f622e.get(mVar) != 0) {
                                i4--;
                                h hVarC = mVar.c(i4, true);
                                if (hVarC != null) {
                                    hVar = hVarC;
                                    break;
                                }
                            }
                            break;
                        }
                        do {
                            if (atomicReferenceFieldUpdater.compareAndSet(mVar, hVar2, null)) {
                                hVar = hVar2;
                                break loop1;
                            }
                        } while (atomicReferenceFieldUpdater.get(mVar) == hVar2);
                    }
                    if (hVar != null) {
                        return hVar;
                    }
                    h hVar3 = (h) bVar2.f601f.d();
                    return hVar3 == null ? i(1) : hVar3;
                }
            } while (!b.f593i.compareAndSet(bVar, j2, j2 - 4398046511104L));
            this.f587c = 1;
        }
        if (z2) {
            boolean z3 = d(bVar2.f596a * 2) == 0;
            if (z3 && (hVarE2 = e()) != null) {
                return hVarE2;
            }
            mVar.getClass();
            h hVarB = (h) m.f619b.getAndSet(mVar, null);
            if (hVarB == null) {
                hVarB = mVar.b();
            }
            if (hVarB != null) {
                return hVarB;
            }
            if (!z3 && (hVarE = e()) != null) {
                return hVarE;
            }
        } else {
            h hVarE3 = e();
            if (hVarE3 != null) {
                return hVarE3;
            }
        }
        return i(3);
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i2) {
        int i3 = this.f590f;
        int i4 = i3 ^ (i3 << 13);
        int i5 = i4 ^ (i4 >> 17);
        int i6 = i5 ^ (i5 << 5);
        this.f590f = i6;
        int i7 = i2 - 1;
        return (i7 & i2) == 0 ? i6 & i7 : (i6 & Integer.MAX_VALUE) % i2;
    }

    public final h e() {
        int iD = d(2);
        b bVar = this.f591h;
        if (iD == 0) {
            h hVar = (h) bVar.f600e.d();
            return hVar != null ? hVar : (h) bVar.f601f.d();
        }
        h hVar2 = (h) bVar.f601f.d();
        return hVar2 != null ? hVar2 : (h) bVar.f600e.d();
    }

    public final void f(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f591h.f599d);
        sb.append("-worker-");
        sb.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
        setName(sb.toString());
        this.indexInArray = i2;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(int i2) {
        int i3 = this.f587c;
        boolean z2 = i3 == 1;
        if (z2) {
            b.f593i.addAndGet(this.f591h, 4398046511104L);
        }
        if (i3 != i2) {
            this.f587c = i2;
        }
        return z2;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00df A[SYNTHETIC] */
    public final h i(int i2) {
        int i3;
        h hVarC;
        long j2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = b.f593i;
        b bVar = this.f591h;
        int i4 = (int) (atomicLongFieldUpdater.get(bVar) & 2097151);
        h hVar = null;
        if (i4 < 2) {
            return null;
        }
        int iD = d(i4);
        int i5 = 0;
        long jMin = Long.MAX_VALUE;
        while (i5 < i4) {
            int i6 = iD + 1;
            if (i6 > i4) {
                i6 = 1;
            }
            a aVar = (a) bVar.g.b(i6);
            if (aVar == null || aVar == this) {
                i3 = i6;
            } else {
                m mVar = aVar.f585a;
                if (i2 != 3) {
                    mVar.getClass();
                    int i7 = m.f621d.get(mVar);
                    int i8 = m.f620c.get(mVar);
                    boolean z2 = i2 == 1;
                    while (true) {
                        if (i7 != i8 && (!z2 || m.f622e.get(mVar) != 0)) {
                            int i9 = i7 + 1;
                            hVarC = mVar.c(i7, z2);
                            if (hVarC != null) {
                                break;
                            }
                            i7 = i9;
                        } else {
                            hVarC = hVar;
                            break;
                        }
                    }
                } else {
                    hVarC = mVar.b();
                }
                n nVar = this.f586b;
                if (hVarC != null) {
                    nVar.f180a = hVarC;
                    i3 = i6;
                } else {
                    while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m.f619b;
                        h hVar2 = (h) atomicReferenceFieldUpdater.get(mVar);
                        if (hVar2 != null) {
                            if (((hVar2.f608b.f609a == 1 ? 1 : 2) & i2) != 0) {
                                k.f616f.getClass();
                                i3 = i6;
                                long jNanoTime = System.nanoTime() - hVar2.f607a;
                                long j3 = k.f612b;
                                if (jNanoTime < j3) {
                                    j2 = j3 - jNanoTime;
                                    hVar = null;
                                    break;
                                }
                                while (true) {
                                    hVar = null;
                                    if (atomicReferenceFieldUpdater.compareAndSet(mVar, hVar2, null)) {
                                        nVar.f180a = hVar2;
                                    } else if (atomicReferenceFieldUpdater.get(mVar) != hVar2) {
                                        i6 = i3;
                                        hVar = null;
                                    }
                                }
                            }
                        }
                        i3 = i6;
                        j2 = -2;
                        break;
                    }
                    if (j2 == -1) {
                        h hVar3 = (h) nVar.f180a;
                        nVar.f180a = hVar;
                        return hVar3;
                    }
                    if (j2 > 0) {
                        jMin = Math.min(jMin, j2);
                    }
                }
                j2 = -1;
                if (j2 == -1) {
                    h hVar4 = (h) nVar.f180a;
                    nVar.f180a = hVar;
                    return hVar4;
                }
                if (j2 > 0) {
                    jMin = Math.min(jMin, j2);
                }
            }
            i5++;
            iD = i3;
            hVar = null;
        }
        if (jMin == Long.MAX_VALUE) {
            jMin = 0;
        }
        this.f589e = jMin;
        return null;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j2;
        int i2;
        loop0: while (true) {
            boolean z2 = false;
            while (true) {
                b bVar = this.f591h;
                bVar.getClass();
                int i3 = 5;
                if (b.f594j.get(bVar) != 0 || this.f587c == 5) {
                    break loop0;
                }
                h hVarA = a(this.g);
                int i4 = 3;
                if (hVarA == null) {
                    this.g = false;
                    if (this.f589e == 0) {
                        Object obj = this.nextParkedWorker;
                        u uVar = b.f595k;
                        if (obj != uVar) {
                            f584i.set(this, -1);
                            while (this.nextParkedWorker != b.f595k) {
                                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f584i;
                                if (atomicIntegerFieldUpdater.get(this) != -1) {
                                    break;
                                }
                                b bVar2 = this.f591h;
                                bVar2.getClass();
                                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = b.f594j;
                                if (atomicIntegerFieldUpdater2.get(bVar2) != 0 || this.f587c == i3) {
                                    break;
                                }
                                h(i4);
                                Thread.interrupted();
                                if (this.f588d == 0) {
                                    this.f588d = System.nanoTime() + this.f591h.f598c;
                                }
                                LockSupport.parkNanos(this.f591h.f598c);
                                if (System.nanoTime() - this.f588d >= 0) {
                                    this.f588d = 0L;
                                    b bVar3 = this.f591h;
                                    synchronized (bVar3.g) {
                                        try {
                                            if (!(atomicIntegerFieldUpdater2.get(bVar3) != 0)) {
                                                AtomicLongFieldUpdater atomicLongFieldUpdater2 = b.f593i;
                                                if (((int) (atomicLongFieldUpdater2.get(bVar3) & 2097151)) > bVar3.f596a) {
                                                    if (atomicIntegerFieldUpdater.compareAndSet(this, -1, 1)) {
                                                        int i5 = this.indexInArray;
                                                        f(0);
                                                        bVar3.j(this, i5, 0);
                                                        int andDecrement = (int) (atomicLongFieldUpdater2.getAndDecrement(bVar3) & 2097151);
                                                        if (andDecrement != i5) {
                                                            Object objB = bVar3.g.b(andDecrement);
                                                            F0.i.b(objB);
                                                            a aVar = (a) objB;
                                                            bVar3.g.c(i5, aVar);
                                                            aVar.f(i5);
                                                            bVar3.j(aVar, andDecrement, i5);
                                                        }
                                                        bVar3.g.c(andDecrement, null);
                                                        this.f587c = 5;
                                                    }
                                                }
                                            }
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    }
                                }
                                i3 = 5;
                                i4 = 3;
                            }
                        } else {
                            b bVar4 = this.f591h;
                            bVar4.getClass();
                            if (this.nextParkedWorker == uVar) {
                                do {
                                    atomicLongFieldUpdater = b.f592h;
                                    j2 = atomicLongFieldUpdater.get(bVar4);
                                    i2 = this.indexInArray;
                                    this.nextParkedWorker = bVar4.g.b((int) (j2 & 2097151));
                                } while (!atomicLongFieldUpdater.compareAndSet(bVar4, j2, ((j2 + 2097152) & (-2097152)) | ((long) i2)));
                            }
                        }
                    } else {
                        if (z2) {
                            h(3);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f589e);
                            this.f589e = 0L;
                            break;
                        }
                        z2 = true;
                    }
                } else {
                    this.f589e = 0L;
                    int i6 = hVarA.f608b.f609a;
                    this.f588d = 0L;
                    if (this.f587c == 3) {
                        this.f587c = 2;
                    }
                    b bVar5 = this.f591h;
                    if (i6 != 0 && h(2) && !bVar5.r() && !bVar5.n(b.f593i.get(bVar5))) {
                        bVar5.r();
                    }
                    bVar5.getClass();
                    try {
                        hVarA.run();
                    } catch (Throwable th2) {
                        Thread threadCurrentThread = Thread.currentThread();
                        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th2);
                    }
                    if (i6 != 0) {
                        b.f593i.addAndGet(bVar5, -2097152L);
                        if (this.f587c == 5) {
                            break;
                        }
                        this.f587c = 4;
                        break;
                    }
                    break;
                }
            }
        }
        h(5);
    }
}
