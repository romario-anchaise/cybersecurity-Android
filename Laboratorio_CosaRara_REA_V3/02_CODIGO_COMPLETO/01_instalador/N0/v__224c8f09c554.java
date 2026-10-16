// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: N0.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0049v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final R0.u f456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final R0.u f457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final R0.u f458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final R0.u f459f;
    public static final R0.u g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final R0.u f454a = new R0.u(0, "RESUME_TOKEN");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final R0.u f455b = new R0.u(0, "CLOSED_EMPTY");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final E f460h = new E(false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final E f461i = new E(true);

    static {
        int i2 = 0;
        f456c = new R0.u(i2, "COMPLETING_ALREADY");
        f457d = new R0.u(i2, "COMPLETING_WAITING_CHILDREN");
        f458e = new R0.u(i2, "COMPLETING_RETRY");
        f459f = new R0.u(i2, "TOO_LATE_TO_CANCEL");
        g = new R0.u(i2, "SEALED");
    }

    public static void a(S s2) {
        a0 a0Var = (a0) s2;
        a0Var.getClass();
        a0Var.k(new T(a0Var.m(), null, a0Var));
    }

    public static void b(R0.d dVar) {
        S s2 = (S) dVar.f544a.j(r.f453b);
        if (s2 != null) {
            a0 a0Var = (a0) s2;
            a0Var.k(new T(a0Var.m(), null, a0Var));
        } else {
            throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + dVar).toString());
        }
    }

    public static final p040w0.i c(p040w0.i iVar, p040w0.i iVar2, boolean z2) {
        Boolean bool = Boolean.FALSE;
        C0042n c0042n = C0042n.f446d;
        boolean zBooleanValue = ((Boolean) iVar.n(bool, c0042n)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) iVar2.n(bool, c0042n)).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return iVar.t(iVar2);
        }
        p040w0.j jVar = p040w0.j.f4165a;
        p040w0.i iVar3 = (p040w0.i) iVar.n(jVar, new C0042n(2, 2));
        Object objN = iVar2;
        if (zBooleanValue2) {
            objN = iVar2.n(jVar, C0042n.f445c);
        }
        return iVar3.t((p040w0.i) objN);
    }

    public static final String d(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final S e(p040w0.i iVar) {
        S s2 = (S) iVar.j(r.f453b);
        if (s2 != null) {
            return s2;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + iVar).toString());
    }

    public static final void f(p040w0.i iVar, Throwable th) {
        try {
            InterfaceC0046s interfaceC0046s = (InterfaceC0046s) iVar.j(r.f452a);
            if (interfaceC0046s != null) {
                interfaceC0046s.f(iVar, th);
            } else {
                R0.a.d(iVar, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                p029q.j.a(runtimeException, th);
                th = runtimeException;
            }
            R0.a.d(iVar, th);
        }
    }

    public static /* synthetic */ D g(S s2, boolean z2, W w2, int i2) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        return ((a0) s2).C(z2, (i2 & 2) != 0, w2);
    }

    public static final boolean h(int i2) {
        return i2 == 1 || i2 == 2;
    }

    public static C0052y i(InterfaceC0047t interfaceC0047t, O0.c cVar, E0.p pVar, int i2) {
        boolean z2 = true;
        p040w0.i iVar = cVar;
        if ((i2 & 1) != 0) {
            iVar = p040w0.j.f4165a;
        }
        p040w0.i iVarC = c(interfaceC0047t.c(), iVar, true);
        T0.d dVar = C.f385a;
        if (iVarC != dVar && iVarC.j(p040w0.e.f4164a) == null) {
            iVarC = iVarC.t(dVar);
        }
        C0052y c0052y = new C0052y(iVarC, z2, 1);
        c0052y.M(1, c0052y, pVar);
        return c0052y;
    }

    public static final Object j(Object obj) {
        return obj instanceof C0039k ? p029q.j.b(((C0039k) obj).f440a) : obj;
    }

    public static final void k(C0033e c0033e, p040w0.d dVar, boolean z2) {
        Object obj = C0033e.g.get(c0033e);
        Throwable thE = c0033e.e(obj);
        Object objB = thE != null ? p029q.j.b(thE) : c0033e.f(obj);
        if (!z2) {
            dVar.b(objB);
            return;
        }
        F0.i.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        R0.g gVar = (R0.g) dVar;
        p044y0.c cVar = gVar.f549e;
        p040w0.i iVar = cVar.f4197b;
        F0.i.b(iVar);
        Object objJ = R0.a.j(iVar, gVar.g);
        k0 k0VarM = objJ != R0.a.f540f ? m(cVar, iVar, objJ) : null;
        try {
            cVar.b(objB);
        } finally {
            if (k0VarM == null || k0VarM.N()) {
                R0.a.e(iVar, objJ);
            }
        }
    }

    public static final String l(p040w0.d dVar) {
        Object objB;
        if (dVar instanceof R0.g) {
            return dVar.toString();
        }
        try {
            objB = dVar + '@' + d(dVar);
        } catch (Throwable th) {
            objB = p029q.j.b(th);
        }
        if (p034t0.f.a(objB) != null) {
            objB = dVar.getClass().getName() + '@' + d(dVar);
        }
        return (String) objB;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [y0.c] */
    /* JADX WARN: Type inference failed for: r2v1, types: [y0.d] */
    /* JADX WARN: Type inference failed for: r2v2, types: [y0.d] */
    public static final k0 m(p044y0.c cVar, p040w0.i iVar, Object obj) {
        k0 k0Var = null;
        if (cVar == 0) {
            return null;
        }
        if (iVar.j(l0.f444a) != null) {
            while (!(cVar instanceof A) && (cVar = cVar.d()) != 0) {
                if (cVar instanceof k0) {
                    k0Var = (k0) cVar;
                    break;
                }
            }
            if (k0Var != null) {
                k0Var.O(iVar, obj);
            }
        }
        return k0Var;
    }

    public static final Object n(p040w0.i iVar, E0.p pVar, p044y0.c cVar) throws Throwable {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        L l2;
        p040w0.i iVar2 = cVar.f4197b;
        F0.i.b(iVar2);
        p040w0.i iVarT = !((Boolean) iVar.n(Boolean.FALSE, C0042n.f446d)).booleanValue() ? iVar2.t(iVar) : c(iVar2, iVar, false);
        S s2 = (S) iVarT.j(r.f453b);
        if (s2 != null && !s2.a()) {
            throw ((a0) s2).u();
        }
        if (iVarT == iVar2) {
            R0.s sVar = new R0.s(iVarT, cVar);
            return f1.l.Y(sVar, sVar, pVar);
        }
        p040w0.e eVar = p040w0.e.f4164a;
        if (F0.i.a(iVarT.j(eVar), iVar2.j(eVar))) {
            k0 k0Var = new k0(iVarT, cVar);
            p040w0.i iVar3 = k0Var.f416c;
            Object objJ = R0.a.j(iVar3, null);
            try {
                return f1.l.Y(k0Var, k0Var, pVar);
            } finally {
                R0.a.e(iVar3, objJ);
            }
        }
        A a2 = new A(iVarT, cVar);
        f1.d.A(pVar, a2, a2);
        do {
            atomicIntegerFieldUpdater = A.f383e;
            int i2 = atomicIntegerFieldUpdater.get(a2);
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                Object objY = a2.y();
                M m2 = objY instanceof M ? (M) objY : null;
                if (m2 != null && (l2 = m2.f395a) != null) {
                    objY = l2;
                }
                if (objY instanceof C0039k) {
                    throw ((C0039k) objY).f440a;
                }
                return objY;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(a2, 0, 1));
        return p042x0.a.f4189a;
    }
}
