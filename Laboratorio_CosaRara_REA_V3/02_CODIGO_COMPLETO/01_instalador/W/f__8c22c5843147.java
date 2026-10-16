// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W;

import N0.AbstractC0049v;
import N0.C0030b;
import N0.C0033e;
import N0.C0038j;
import N0.N;
import R0.u;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p010f0.m f746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final U0.d f747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f748d;

    public f(o oVar, p010f0.m mVar, U0.d dVar, k kVar) {
        this.f745a = oVar;
        this.f746b = mVar;
        this.f747c = dVar;
        this.f748d = kVar;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(p044y0.c cVar) throws Throwable {
        d dVar;
        U0.d dVar2;
        int andDecrement;
        int i2;
        f fVar;
        C0033e c0033e;
        C0033e c0033e2;
        U0.a aVar;
        Throwable th;
        if (cVar instanceof d) {
            dVar = (d) cVar;
            int i3 = dVar.f742h;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                dVar.f742h = i3 - Integer.MIN_VALUE;
            } else {
                dVar = new d(this, cVar);
            }
        } else {
            dVar = new d(this, cVar);
        }
        Object obj = dVar.f741f;
        p042x0.a aVar2 = p042x0.a.f4189a;
        int i4 = dVar.f742h;
        try {
            if (i4 == 0) {
                p029q.j.o(obj);
                dVar.f739d = this;
                dVar2 = this.f747c;
                dVar.f740e = dVar2;
                dVar.f742h = 1;
                dVar2.getClass();
                do {
                    andDecrement = U0.d.g.getAndDecrement(dVar2);
                    i2 = dVar2.f640a;
                } while (andDecrement > i2);
                Object obj2 = p034t0.h.f4132b;
                if (andDecrement <= 0) {
                    p040w0.d dVarL = p029q.j.l(dVar);
                    if (dVarL instanceof R0.g) {
                        R0.g gVar = (R0.g) dVarL;
                        loop2: while (true) {
                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = R0.g.f547h;
                            Object obj3 = atomicReferenceFieldUpdater.get(gVar);
                            u uVar = R0.a.f538d;
                            if (obj3 == null) {
                                atomicReferenceFieldUpdater.set(gVar, uVar);
                                c0033e = null;
                                break;
                            }
                            if (obj3 instanceof C0033e) {
                                do {
                                    if (atomicReferenceFieldUpdater.compareAndSet(gVar, obj3, uVar)) {
                                        c0033e = (C0033e) obj3;
                                        break loop2;
                                    }
                                } while (atomicReferenceFieldUpdater.get(gVar) == obj3);
                            } else if (obj3 != uVar && !(obj3 instanceof Throwable)) {
                                throw new IllegalStateException(("Inconsistent state " + obj3).toString());
                            }
                        }
                        if (c0033e != null) {
                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = C0033e.g;
                            Object obj4 = atomicReferenceFieldUpdater2.get(c0033e);
                            if (!(obj4 instanceof C0038j) || ((C0038j) obj4).f436d == null) {
                                C0033e.f422f.set(c0033e, 536870911);
                                atomicReferenceFieldUpdater2.set(c0033e, C0030b.f419a);
                                c0033e2 = c0033e;
                            } else {
                                c0033e.n();
                                c0033e2 = null;
                            }
                            if (c0033e2 == null) {
                                c0033e2 = new C0033e(dVarL, 2);
                            }
                        } else {
                            c0033e2 = new C0033e(dVarL, 2);
                        }
                    } else {
                        c0033e2 = new C0033e(dVarL, 1);
                    }
                    try {
                        if (!dVar2.a(c0033e2)) {
                            while (true) {
                                int andDecrement2 = U0.d.g.getAndDecrement(dVar2);
                                if (andDecrement2 <= i2) {
                                    if (andDecrement2 > 0) {
                                        c0033e2.x(obj2, c0033e2.f384c, dVar2.f641b);
                                        break;
                                    }
                                    if (dVar2.a(c0033e2)) {
                                        break;
                                    }
                                }
                            }
                        }
                        Object objP = c0033e2.p();
                        if (objP != aVar2) {
                            objP = obj2;
                        }
                        if (objP == aVar2) {
                            obj2 = objP;
                        }
                    } catch (Throwable th2) {
                        c0033e2.w();
                        throw th2;
                    }
                }
                if (obj2 == aVar2) {
                    return aVar2;
                }
                fVar = this;
            } else {
                if (i4 != 1) {
                    if (i4 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aVar = (U0.a) dVar.f739d;
                    try {
                        p029q.j.o(obj);
                        h hVar = (h) obj;
                        ((U0.d) aVar).b();
                        return hVar;
                    } catch (Throwable th3) {
                        th = th3;
                        ((U0.d) aVar).b();
                        throw th;
                    }
                }
                U0.d dVar3 = dVar.f740e;
                fVar = (f) dVar.f739d;
                p029q.j.o(obj);
                dVar2 = dVar3;
            }
            e eVar = new e(0, fVar);
            dVar.f739d = dVar2;
            dVar.f740e = null;
            dVar.f742h = 2;
            Object objN = AbstractC0049v.n(p040w0.j.f4165a, new N(eVar, null), dVar);
            if (objN == aVar2) {
                return aVar2;
            }
            aVar = dVar2;
            obj = objN;
            h hVar2 = (h) obj;
            ((U0.d) aVar).b();
            return hVar2;
        } catch (Throwable th4) {
            aVar = dVar2;
            th = th4;
            ((U0.d) aVar).b();
            throw th;
        }
    }
}
