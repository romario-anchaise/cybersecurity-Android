// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: N0.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0033e extends B implements InterfaceC0032d, p044y0.d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f422f = AtomicIntegerFieldUpdater.newUpdater(C0033e.class, "_decisionAndIndex");
    public static final AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(C0033e.class, Object.class, "_state");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f423h = AtomicReferenceFieldUpdater.newUpdater(C0033e.class, Object.class, "_parentHandle");
    private volatile int _decisionAndIndex;
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p040w0.d f424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p040w0.i f425e;

    public C0033e(p040w0.d dVar, int i2) {
        super(i2);
        this.f424d = dVar;
        this.f425e = dVar.g();
        this._decisionAndIndex = 536870911;
        this._state = C0030b.f419a;
    }

    public static void v(d0 d0Var, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + d0Var + ", already has " + obj).toString());
    }

    public static Object y(d0 d0Var, Object obj, int i2, E0.l lVar) {
        if ((obj instanceof C0039k) || !AbstractC0049v.h(i2)) {
            return obj;
        }
        if (lVar != null || (d0Var instanceof O)) {
            return new C0038j(obj, d0Var instanceof O ? (O) d0Var : null, lVar, (CancellationException) null, 16);
        }
        return obj;
    }

    @Override // N0.B
    public final void a(Object obj, CancellationException cancellationException) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof d0) {
                throw new IllegalStateException("Not completed");
            }
            if (obj2 instanceof C0039k) {
                return;
            }
            if (!(obj2 instanceof C0038j)) {
                C0038j c0038j = new C0038j(obj2, (O) null, (E0.l) null, cancellationException, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, c0038j)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    }
                }
                return;
            }
            C0038j c0038j2 = (C0038j) obj2;
            if (c0038j2.f437e != null) {
                throw new IllegalStateException("Must be called at most once");
            }
            C0038j c0038jA = C0038j.a(c0038j2, null, cancellationException, 15);
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, c0038jA)) {
                    O o2 = c0038j2.f434b;
                    if (o2 != null) {
                        j(o2, cancellationException);
                    }
                    E0.l lVar = c0038j2.f435c;
                    if (lVar != null) {
                        k(lVar, cancellationException);
                        return;
                    }
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj2);
        }
    }

    @Override // p040w0.d
    public final void b(Object obj) {
        Throwable thA = p034t0.f.a(obj);
        if (thA != null) {
            obj = new C0039k(thA, false);
        }
        x(obj, this.f384c, null);
    }

    @Override // N0.B
    public final p040w0.d c() {
        return this.f424d;
    }

    @Override // p044y0.d
    public final p044y0.d d() {
        p040w0.d dVar = this.f424d;
        if (dVar instanceof p044y0.d) {
            return (p044y0.d) dVar;
        }
        return null;
    }

    @Override // N0.B
    public final Throwable e(Object obj) {
        Throwable thE = super.e(obj);
        if (thE != null) {
            return thE;
        }
        return null;
    }

    @Override // N0.B
    public final Object f(Object obj) {
        return obj instanceof C0038j ? ((C0038j) obj).f433a : obj;
    }

    @Override // p040w0.d
    public final p040w0.i g() {
        return this.f425e;
    }

    @Override // N0.B
    public final Object i() {
        return g.get(this);
    }

    public final void j(O o2, Throwable th) {
        try {
            o2.a(th);
        } catch (Throwable th2) {
            AbstractC0049v.f(this.f425e, new C0041m("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void k(E0.l lVar, Throwable th) {
        try {
            lVar.d(th);
        } catch (Throwable th2) {
            AbstractC0049v.f(this.f425e, new C0041m("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void l(R0.t tVar, Throwable th) {
        int i2 = f422f.get(this) & 536870911;
        if (i2 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            tVar.e(i2);
        } catch (Throwable th2) {
            AbstractC0049v.f(this.f425e, new C0041m("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void m(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof d0)) {
                return;
            }
            C0034f c0034f = new C0034f(this, th, (obj instanceof O) || (obj instanceof R0.t));
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, c0034f)) {
                    d0 d0Var = (d0) obj;
                    if (d0Var instanceof O) {
                        j((O) obj, th);
                    } else if (d0Var instanceof R0.t) {
                        l((R0.t) obj, th);
                    }
                    if (!u()) {
                        n();
                    }
                    o(this.f384c);
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj);
        }
    }

    public final void n() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f423h;
        D d2 = (D) atomicReferenceFieldUpdater.get(this);
        if (d2 == null) {
            return;
        }
        d2.c();
        atomicReferenceFieldUpdater.set(this, c0.f421a);
    }

    public final void o(int i2) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i3;
        do {
            atomicIntegerFieldUpdater = f422f;
            i3 = atomicIntegerFieldUpdater.get(this);
            int i4 = i3 >> 29;
            if (i4 != 0) {
                if (i4 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                boolean z2 = i2 == 4;
                p040w0.d dVar = this.f424d;
                if (z2 || !(dVar instanceof R0.g) || AbstractC0049v.h(i2) != AbstractC0049v.h(this.f384c)) {
                    AbstractC0049v.k(this, dVar, z2);
                    return;
                }
                AbstractC0045q abstractC0045q = ((R0.g) dVar).f548d;
                p040w0.i iVar = ((R0.g) dVar).f549e.f4197b;
                F0.i.b(iVar);
                if (abstractC0045q.v()) {
                    abstractC0045q.u(iVar, this);
                    return;
                }
                H hA = h0.a();
                if (hA.f390c >= 4294967296L) {
                    p036u0.d dVar2 = hA.f392e;
                    if (dVar2 == null) {
                        dVar2 = new p036u0.d();
                        hA.f392e = dVar2;
                    }
                    dVar2.addLast(this);
                    return;
                }
                hA.y(true);
                try {
                    AbstractC0049v.k(this, dVar, true);
                    do {
                    } while (hA.z());
                } catch (Throwable th) {
                    try {
                        h(th, null);
                    } finally {
                        hA.w();
                    }
                }
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, 1073741824 + (536870911 & i3)));
    }

    public final Object p() throws Throwable {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        boolean zU = u();
        do {
            atomicIntegerFieldUpdater = f422f;
            i2 = atomicIntegerFieldUpdater.get(this);
            int i3 = i2 >> 29;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (zU) {
                    w();
                }
                Object obj = g.get(this);
                if (obj instanceof C0039k) {
                    throw ((C0039k) obj).f440a;
                }
                if (AbstractC0049v.h(this.f384c)) {
                    S s2 = (S) this.f425e.j(r.f453b);
                    if (s2 != null && !s2.a()) {
                        CancellationException cancellationExceptionU = ((a0) s2).u();
                        a(obj, cancellationExceptionU);
                        throw cancellationExceptionU;
                    }
                }
                return f(obj);
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 536870912 + (536870911 & i2)));
        if (((D) f423h.get(this)) == null) {
            r();
        }
        if (zU) {
            w();
        }
        return p042x0.a.f4189a;
    }

    public final void q() {
        D dR = r();
        if (dR == null || (g.get(this) instanceof d0)) {
            return;
        }
        dR.c();
        f423h.set(this, c0.f421a);
    }

    public final D r() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        S s2 = (S) this.f425e.j(r.f453b);
        if (s2 == null) {
            return null;
        }
        D dG = AbstractC0049v.g(s2, true, new C0035g(this), 2);
        do {
            atomicReferenceFieldUpdater = f423h;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, dG)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return dG;
    }

    public final void s(E0.l lVar) {
        t(lVar instanceof O ? (O) lVar : new O(lVar));
    }

    public final void t(d0 d0Var) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof C0030b) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, d0Var)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                    }
                }
                return;
            }
            if (obj instanceof O ? true : obj instanceof R0.t) {
                v(d0Var, obj);
                throw null;
            }
            if (obj instanceof C0039k) {
                C0039k c0039k = (C0039k) obj;
                c0039k.getClass();
                if (!C0039k.f439b.compareAndSet(c0039k, 0, 1)) {
                    v(d0Var, obj);
                    throw null;
                }
                if (obj instanceof C0034f) {
                    if (!(obj instanceof C0039k)) {
                        c0039k = null;
                    }
                    Throwable th = c0039k != null ? c0039k.f440a : null;
                    if (d0Var instanceof O) {
                        j((O) d0Var, th);
                        return;
                    } else {
                        F0.i.c(d0Var, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                        l((R0.t) d0Var, th);
                        return;
                    }
                }
                return;
            }
            if (!(obj instanceof C0038j)) {
                if (d0Var instanceof R0.t) {
                    return;
                }
                F0.i.c(d0Var, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                C0038j c0038j = new C0038j(obj, (O) d0Var, (E0.l) null, (CancellationException) null, 28);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c0038j)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                    }
                }
                return;
            }
            C0038j c0038j2 = (C0038j) obj;
            if (c0038j2.f434b != null) {
                v(d0Var, obj);
                throw null;
            }
            if (d0Var instanceof R0.t) {
                return;
            }
            F0.i.c(d0Var, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
            O o2 = (O) d0Var;
            Throwable th2 = c0038j2.f437e;
            if (th2 != null) {
                j(o2, th2);
                return;
            }
            C0038j c0038jA = C0038j.a(c0038j2, o2, null, 29);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c0038jA)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                }
            }
            return;
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("CancellableContinuation(");
        sb.append(AbstractC0049v.l(this.f424d));
        sb.append("){");
        Object obj = g.get(this);
        if (obj instanceof d0) {
            str = "Active";
        } else {
            str = obj instanceof C0034f ? "Cancelled" : "Completed";
        }
        sb.append(str);
        sb.append("}@");
        sb.append(AbstractC0049v.d(this));
        return sb.toString();
    }

    public final boolean u() {
        if (this.f384c == 2) {
            p040w0.d dVar = this.f424d;
            F0.i.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (R0.g.f547h.get((R0.g) dVar) != null) {
                return true;
            }
        }
        return false;
    }

    public final void w() {
        p040w0.d dVar = this.f424d;
        Throwable th = null;
        R0.g gVar = dVar instanceof R0.g ? (R0.g) dVar : null;
        if (gVar != null) {
            loop0: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = R0.g.f547h;
                Object obj = atomicReferenceFieldUpdater.get(gVar);
                R0.u uVar = R0.a.f538d;
                if (obj != uVar) {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException(("Inconsistent state " + obj).toString());
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(gVar, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(gVar) != obj) {
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                    }
                    th = (Throwable) obj;
                    break;
                }
                do {
                    if (atomicReferenceFieldUpdater.compareAndSet(gVar, uVar, this)) {
                        break loop0;
                    }
                } while (atomicReferenceFieldUpdater.get(gVar) == uVar);
            }
            if (th == null) {
                return;
            }
            n();
            m(th);
        }
    }

    public final void x(Object obj, int i2, E0.l lVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof d0)) {
                if (obj2 instanceof C0034f) {
                    C0034f c0034f = (C0034f) obj2;
                    c0034f.getClass();
                    if (C0034f.f426c.compareAndSet(c0034f, 0, 1)) {
                        if (lVar != null) {
                            k(lVar, c0034f.f440a);
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
            }
            Object objY = y((d0) obj2, obj, i2, lVar);
            do {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, objY)) {
                    if (!u()) {
                        n();
                    }
                    o(i2);
                    return;
                }
            } while (atomicReferenceFieldUpdater.get(this) == obj2);
        }
    }
}
