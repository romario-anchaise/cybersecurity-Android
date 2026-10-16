// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package U0;

import F0.h;
import M0.o;
import N0.AbstractC0049v;
import N0.C0033e;
import N0.C0038j;
import N0.InterfaceC0032d;
import N0.d0;
import R0.t;
import R0.u;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class d implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f636c = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "head");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f637d = AtomicLongFieldUpdater.newUpdater(d.class, "deqIdx");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f638e = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "tail");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f639f = AtomicLongFieldUpdater.newUpdater(d.class, "enqIdx");
    public static final AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(d.class, "_availablePermits");
    private volatile int _availablePermits;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f641b;
    private volatile long deqIdx;
    private volatile long enqIdx;
    private volatile Object head;
    private volatile Object tail;

    public d(int i2, int i3) {
        this.f640a = i2;
        if (i2 <= 0) {
            throw new IllegalArgumentException(h.b(i2, "Semaphore should have at least 1 permit, but had ").toString());
        }
        if (i3 < 0 || i3 > i2) {
            throw new IllegalArgumentException(h.b(i2, "The number of acquired permits should be in 0..").toString());
        }
        f fVar = new f(0L, null, 2);
        this.head = fVar;
        this.tail = fVar;
        this._availablePermits = i2 - i3;
        this.f641b = new o(1, this);
    }

    public final boolean a(C0033e c0033e) {
        Object objB;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f638e;
        f fVar = (f) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f639f.getAndIncrement(this);
        b bVar = b.f634i;
        long j2 = andIncrement / ((long) e.f647f);
        loop0: while (true) {
            objB = R0.a.b(fVar, j2, bVar);
            if (objB != R0.a.f536b) {
                t tVarC = R0.a.c(objB);
                while (true) {
                    t tVar = (t) atomicReferenceFieldUpdater.get(this);
                    if (tVar.f573c >= tVarC.f573c) {
                        break loop0;
                    }
                    if (!tVarC.f()) {
                        break;
                    }
                    do {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, tVar, tVarC)) {
                            if (!tVar.c()) {
                                break loop0;
                            }
                            tVar.b();
                            break loop0;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == tVar);
                    if (tVarC.c()) {
                        tVarC.b();
                    }
                }
            } else {
                break;
            }
        }
        f fVar2 = (f) R0.a.c(objB);
        int i3 = (int) (andIncrement % ((long) e.f647f));
        AtomicReferenceArray atomicReferenceArray = fVar2.f648e;
        while (!atomicReferenceArray.compareAndSet(i3, null, c0033e)) {
            if (atomicReferenceArray.get(i3) != null) {
                u uVar = e.f643b;
                u uVar2 = e.f644c;
                while (!atomicReferenceArray.compareAndSet(i3, uVar, uVar2)) {
                    if (atomicReferenceArray.get(i3) != uVar) {
                        return false;
                    }
                }
                c0033e.x(p034t0.h.f4132b, c0033e.f384c, this.f641b);
                return true;
            }
        }
        do {
            atomicIntegerFieldUpdater = C0033e.f422f;
            i2 = atomicIntegerFieldUpdater.get(c0033e);
            if ((i2 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(c0033e, i2, ((i2 >> 29) << 29) + i3));
        c0033e.t(fVar2);
        return true;
    }

    public final void b() {
        int i2;
        Object objB;
        boolean z2;
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            int i3 = this.f640a;
            if (andIncrement >= i3) {
                do {
                    i2 = atomicIntegerFieldUpdater.get(this);
                    if (i2 <= i3) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, i3));
                throw new IllegalStateException(("The number of released permits cannot be greater than " + i3).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f636c;
            f fVar = (f) atomicReferenceFieldUpdater.get(this);
            long andIncrement2 = f637d.getAndIncrement(this);
            long j2 = andIncrement2 / ((long) e.f647f);
            c cVar = c.f635i;
            while (true) {
                objB = R0.a.b(fVar, j2, cVar);
                if (objB != R0.a.f536b) {
                    t tVarC = R0.a.c(objB);
                    while (true) {
                        t tVar = (t) atomicReferenceFieldUpdater.get(this);
                        if (tVar.f573c >= tVarC.f573c) {
                            break;
                        }
                        if (!tVarC.f()) {
                            break;
                        }
                        do {
                            if (atomicReferenceFieldUpdater.compareAndSet(this, tVar, tVarC)) {
                                if (!tVar.c()) {
                                    break;
                                }
                                tVar.b();
                                break;
                            }
                        } while (atomicReferenceFieldUpdater.get(this) == tVar);
                        if (tVarC.c()) {
                            tVarC.b();
                        }
                    }
                } else {
                    break;
                }
            }
            f fVar2 = (f) R0.a.c(objB);
            u uVar = null;
            R0.c.f543b.lazySet(fVar2, null);
            z2 = false;
            if (fVar2.f573c <= j2) {
                int i4 = (int) (andIncrement2 % ((long) e.f647f));
                u uVar2 = e.f643b;
                AtomicReferenceArray atomicReferenceArray = fVar2.f648e;
                Object andSet = atomicReferenceArray.getAndSet(i4, uVar2);
                if (andSet == null) {
                    int i5 = e.f642a;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= i5) {
                            u uVar3 = e.f643b;
                            u uVar4 = e.f645d;
                            do {
                                if (atomicReferenceArray.compareAndSet(i4, uVar3, uVar4)) {
                                    z2 = true;
                                    break;
                                }
                            } while (atomicReferenceArray.get(i4) == uVar3);
                            z2 = !z2;
                            break;
                        }
                        if (atomicReferenceArray.get(i4) == e.f644c) {
                            z2 = true;
                            break;
                        }
                        i6++;
                    }
                } else if (andSet != e.f646e) {
                    if (!(andSet instanceof InterfaceC0032d)) {
                        throw new IllegalStateException(("unexpected: " + andSet).toString());
                    }
                    p034t0.h hVar = p034t0.h.f4132b;
                    C0033e c0033e = (C0033e) ((InterfaceC0032d) andSet);
                    while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = C0033e.g;
                        Object obj = atomicReferenceFieldUpdater2.get(c0033e);
                        boolean z3 = obj instanceof d0;
                        u uVar5 = AbstractC0049v.f454a;
                        if (!z3) {
                            boolean z4 = obj instanceof C0038j;
                            break;
                        }
                        Object objY = C0033e.y((d0) obj, hVar, c0033e.f384c, this.f641b);
                        do {
                            if (atomicReferenceFieldUpdater2.compareAndSet(c0033e, obj, objY)) {
                                if (!c0033e.u()) {
                                    c0033e.n();
                                }
                                uVar = uVar5;
                                break;
                            }
                        } while (atomicReferenceFieldUpdater2.get(c0033e) == obj);
                    }
                    if (uVar != null) {
                        c0033e.o(c0033e.f384c);
                        z2 = true;
                        break;
                        break;
                    }
                }
            }
        } while (!z2);
    }
}
