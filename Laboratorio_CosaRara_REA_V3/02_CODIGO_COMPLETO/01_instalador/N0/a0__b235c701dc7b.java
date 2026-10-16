// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public class a0 implements S, e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f417a = AtomicReferenceFieldUpdater.newUpdater(a0.class, Object.class, "_state");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f418b = AtomicReferenceFieldUpdater.newUpdater(a0.class, Object.class, "_parentHandle");
    private volatile Object _parentHandle;
    private volatile Object _state;

    public a0(boolean z2) {
        this._state = z2 ? AbstractC0049v.f461i : AbstractC0049v.f460h;
    }

    public static C0037i F(R0.k kVar) {
        while (kVar.j()) {
            R0.k kVarF = kVar.f();
            if (kVarF == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = R0.k.f559b;
                Object obj = atomicReferenceFieldUpdater.get(kVar);
                while (true) {
                    kVar = (R0.k) obj;
                    if (!kVar.j()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(kVar);
                }
            } else {
                kVar = kVarF;
            }
        }
        while (true) {
            kVar = kVar.i();
            if (!kVar.j()) {
                if (kVar instanceof C0037i) {
                    return (C0037i) kVar;
                }
                if (kVar instanceof b0) {
                    return null;
                }
            }
        }
    }

    public static String K(Object obj) {
        if (!(obj instanceof Y)) {
            if (obj instanceof L) {
                return ((L) obj).a() ? "Active" : "New";
            }
            return obj instanceof C0039k ? "Cancelled" : "Completed";
        }
        Y y2 = (Y) obj;
        if (y2.e()) {
            return "Cancelling";
        }
        return y2.f() ? "Completing" : "Active";
    }

    public final void B(S s2) {
        byte b2;
        c0 c0Var = c0.f421a;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f418b;
        if (s2 == null) {
            atomicReferenceFieldUpdater.set(this, c0Var);
            return;
        }
        a0 a0Var = (a0) s2;
        do {
            Object objY = a0Var.y();
            boolean z2 = objY instanceof E;
            b2 = 0;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f417a;
            if (z2) {
                if (!((E) objY).f387a) {
                    E e2 = AbstractC0049v.f461i;
                    while (true) {
                        if (atomicReferenceFieldUpdater2.compareAndSet(a0Var, objY, e2)) {
                            a0Var.getClass();
                            b2 = 1;
                        } else if (atomicReferenceFieldUpdater2.get(a0Var) != objY) {
                            b2 = -1;
                        }
                    }
                }
            } else if (objY instanceof K) {
                b0 b0Var = ((K) objY).f394a;
                while (true) {
                    if (atomicReferenceFieldUpdater2.compareAndSet(a0Var, objY, b0Var)) {
                        a0Var.getClass();
                        b2 = 1;
                    } else if (atomicReferenceFieldUpdater2.get(a0Var) != objY) {
                        b2 = -1;
                    }
                }
            }
            if (b2 == 0) {
                break;
            }
        } while (b2 != 1);
        InterfaceC0036h interfaceC0036h = (InterfaceC0036h) AbstractC0049v.g(a0Var, true, new C0037i(this), 2);
        atomicReferenceFieldUpdater.set(this, interfaceC0036h);
        if (y() instanceof L) {
            return;
        }
        interfaceC0036h.c();
        atomicReferenceFieldUpdater.set(this, c0Var);
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0027 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:75:0x00be  */
    /* JADX WARN: Code duplicated, block: B:97:0x00b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x00c6 A[SYNTHETIC] */
    public final D C(boolean z2, boolean z3, E0.l lVar) {
        W q2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Throwable thD;
        if (z2) {
            q2 = lVar instanceof U ? (U) lVar : null;
            if (q2 == null) {
                q2 = new P(lVar);
            }
        } else {
            q2 = lVar instanceof W ? (W) lVar : null;
            if (q2 == null) {
                q2 = new Q(lVar);
            }
        }
        q2.f404d = this;
        while (true) {
            Object objY = y();
            if (objY instanceof E) {
                E e2 = (E) objY;
                if (e2.f387a) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f417a;
                    while (!atomicReferenceFieldUpdater2.compareAndSet(this, objY, q2)) {
                        if (atomicReferenceFieldUpdater2.get(this) != objY) {
                        }
                    }
                    return q2;
                }
                b0 b0Var = new b0();
                L k2 = e2.f387a ? b0Var : new K(b0Var);
                do {
                    atomicReferenceFieldUpdater = f417a;
                    if (atomicReferenceFieldUpdater.compareAndSet(this, e2, k2)) {
                        break;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == e2);
            } else {
                if (!(objY instanceof L)) {
                    if (z3) {
                        C0039k c0039k = objY instanceof C0039k ? (C0039k) objY : null;
                        lVar.d(c0039k != null ? c0039k.f440a : null);
                    }
                    return c0.f421a;
                }
                b0 b0VarB = ((L) objY).b();
                if (b0VarB == null) {
                    F0.i.c(objY, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    J((W) objY);
                } else {
                    D d2 = c0.f421a;
                    if (z2 && (objY instanceof Y)) {
                        synchronized (objY) {
                            try {
                                thD = ((Y) objY).d();
                                if (thD == null || ((lVar instanceof C0037i) && !((Y) objY).f())) {
                                    if (e((L) objY, b0VarB, q2)) {
                                        if (thD == null) {
                                            return q2;
                                        }
                                        d2 = q2;
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (thD != null) {
                            if (z3) {
                                lVar.d(thD);
                            }
                            return d2;
                        }
                        if (e((L) objY, b0VarB, q2)) {
                            return q2;
                        }
                    } else {
                        thD = null;
                        if (thD != null) {
                            if (z3) {
                                lVar.d(thD);
                            }
                            return d2;
                        }
                        if (e((L) objY, b0VarB, q2)) {
                            return q2;
                        }
                    }
                }
            }
        }
    }

    public boolean D() {
        return false;
    }

    public final Object E(Object obj) throws IllegalAccessException, InvocationTargetException {
        Object objL;
        do {
            objL = L(y(), obj);
            if (objL == AbstractC0049v.f456c) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                C0039k c0039k = obj instanceof C0039k ? (C0039k) obj : null;
                throw new IllegalStateException(str, c0039k != null ? c0039k.f440a : null);
            }
        } while (objL == AbstractC0049v.f458e);
        return objL;
    }

    public final void G(b0 b0Var, Throwable th) throws IllegalAccessException, InvocationTargetException {
        Object objH = b0Var.h();
        F0.i.c(objH, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        C0041m c0041m = null;
        for (R0.k kVarI = (R0.k) objH; !kVarI.equals(b0Var); kVarI = kVarI.i()) {
            if (kVarI instanceof U) {
                W w2 = (W) kVarI;
                try {
                    w2.l(th);
                } catch (Throwable th2) {
                    if (c0041m != null) {
                        p029q.j.a(c0041m, th2);
                    } else {
                        c0041m = new C0041m("Exception in completion handler " + w2 + " for " + this, th2);
                    }
                }
            }
        }
        if (c0041m != null) {
            A(c0041m);
        }
        l(th);
    }

    public final void J(W w2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        b0 b0Var = new b0();
        w2.getClass();
        R0.k.f559b.lazySet(b0Var, w2);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = R0.k.f558a;
        atomicReferenceFieldUpdater2.lazySet(b0Var, w2);
        loop0: while (w2.h() == w2) {
            do {
                if (atomicReferenceFieldUpdater2.compareAndSet(w2, w2, b0Var)) {
                    b0Var.g(w2);
                    break loop0;
                }
            } while (atomicReferenceFieldUpdater2.get(w2) == w2);
        }
        R0.k kVarI = w2.i();
        do {
            atomicReferenceFieldUpdater = f417a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, w2, kVarI)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == w2);
    }

    public final Object L(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        if (!(obj instanceof L)) {
            return AbstractC0049v.f456c;
        }
        if (((obj instanceof E) || (obj instanceof W)) && !(obj instanceof C0037i) && !(obj2 instanceof C0039k)) {
            L l2 = (L) obj;
            Object m2 = obj2 instanceof L ? new M((L) obj2) : obj2;
            do {
                atomicReferenceFieldUpdater = f417a;
                if (atomicReferenceFieldUpdater.compareAndSet(this, l2, m2)) {
                    H(obj2);
                    p(l2, obj2);
                    return obj2;
                }
            } while (atomicReferenceFieldUpdater.get(this) == l2);
            return AbstractC0049v.f458e;
        }
        L l3 = (L) obj;
        b0 b0VarX = x(l3);
        if (b0VarX == null) {
            return AbstractC0049v.f458e;
        }
        C0037i c0037iF = null;
        Y y2 = l3 instanceof Y ? (Y) l3 : null;
        if (y2 == null) {
            y2 = new Y(b0VarX, null);
        }
        synchronized (y2) {
            if (y2.f()) {
                return AbstractC0049v.f456c;
            }
            Y.f408b.set(y2, 1);
            if (y2 != l3) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f417a;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, l3, y2)) {
                    if (atomicReferenceFieldUpdater2.get(this) != l3) {
                        return AbstractC0049v.f458e;
                    }
                }
            }
            boolean zE = y2.e();
            C0039k c0039k = obj2 instanceof C0039k ? (C0039k) obj2 : null;
            if (c0039k != null) {
                y2.c(c0039k.f440a);
            }
            Throwable thD = y2.d();
            if (zE) {
                thD = null;
            }
            if (thD != null) {
                G(b0VarX, thD);
            }
            C0037i c0037i = l3 instanceof C0037i ? (C0037i) l3 : null;
            if (c0037i == null) {
                b0 b0VarB = l3.b();
                if (b0VarB != null) {
                    c0037iF = F(b0VarB);
                }
            } else {
                c0037iF = c0037i;
            }
            if (c0037iF != null) {
                while (AbstractC0049v.g(c0037iF.f429e, false, new X(this, y2, c0037iF, obj2), 1) == c0.f421a) {
                    c0037iF = F(c0037iF);
                    if (c0037iF == null) {
                    }
                }
                return AbstractC0049v.f457d;
            }
            return s(y2, obj2);
        }
    }

    @Override // N0.S
    public boolean a() {
        Object objY = y();
        return (objY instanceof L) && ((L) objY).a();
    }

    public final boolean e(L l2, b0 b0Var, W w2) {
        char c2;
        Z z2 = new Z(w2, this, l2);
        do {
            R0.k kVarF = b0Var.f();
            if (kVarF == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = R0.k.f559b;
                Object obj = atomicReferenceFieldUpdater.get(b0Var);
                while (true) {
                    kVarF = (R0.k) obj;
                    if (!kVarF.j()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(kVarF);
                }
            }
            R0.k.f559b.lazySet(w2, kVarF);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = R0.k.f558a;
            atomicReferenceFieldUpdater2.lazySet(w2, b0Var);
            z2.f413c = b0Var;
            while (true) {
                if (atomicReferenceFieldUpdater2.compareAndSet(kVarF, b0Var, z2)) {
                    if (z2.a(kVarF) != null) {
                        c2 = 2;
                        break;
                    }
                    c2 = 1;
                    break;
                }
                if (atomicReferenceFieldUpdater2.get(kVarF) != b0Var) {
                    c2 = 0;
                    break;
                }
            }
            if (c2 == 1) {
                return true;
            }
        } while (c2 != 2);
        return false;
    }

    @Override // p040w0.g
    public final p040w0.h getKey() {
        return r.f453b;
    }

    public void i(Object obj) {
        h(obj);
    }

    @Override // p040w0.i
    public final p040w0.g j(p040w0.h hVar) {
        return p028p0.a.g(this, hVar);
    }

    public final boolean k(Object obj) {
        R0.u uVar;
        Object objL = AbstractC0049v.f456c;
        if (w()) {
            do {
                Object objY = y();
                if (!(objY instanceof L) || ((objY instanceof Y) && ((Y) objY).f())) {
                    objL = AbstractC0049v.f456c;
                    break;
                }
                objL = L(objY, new C0039k(q(obj), false));
            } while (objL == AbstractC0049v.f458e);
            if (objL == AbstractC0049v.f457d) {
                return true;
            }
        }
        if (objL == AbstractC0049v.f456c) {
            Throwable thQ = null;
            loop1: while (true) {
                Object objY2 = y();
                if (objY2 instanceof Y) {
                    synchronized (objY2) {
                        try {
                            Y y2 = (Y) objY2;
                            y2.getClass();
                            if (Y.f410d.get(y2) == AbstractC0049v.g) {
                                uVar = AbstractC0049v.f459f;
                            } else {
                                boolean zE = ((Y) objY2).e();
                                if (thQ == null) {
                                    thQ = q(obj);
                                }
                                ((Y) objY2).c(thQ);
                                Throwable thD = zE ? null : ((Y) objY2).d();
                                if (thD != null) {
                                    G(((Y) objY2).f411a, thD);
                                }
                                uVar = AbstractC0049v.f456c;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } else if (objY2 instanceof L) {
                    if (thQ == null) {
                        thQ = q(obj);
                    }
                    L l2 = (L) objY2;
                    if (l2.a()) {
                        b0 b0VarX = x(l2);
                        if (b0VarX == null) {
                            continue;
                        } else {
                            Y y3 = new Y(b0VarX, thQ);
                            while (true) {
                                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f417a;
                                if (atomicReferenceFieldUpdater.compareAndSet(this, l2, y3)) {
                                    G(b0VarX, thQ);
                                    uVar = AbstractC0049v.f456c;
                                } else if (atomicReferenceFieldUpdater.get(this) != l2) {
                                }
                            }
                        }
                    } else {
                        Object objL2 = L(objY2, new C0039k(thQ, false));
                        if (objL2 == AbstractC0049v.f456c) {
                            throw new IllegalStateException(("Cannot happen in " + objY2).toString());
                        }
                        if (objL2 != AbstractC0049v.f458e) {
                            objL = objL2;
                            break;
                        }
                    }
                } else {
                    uVar = AbstractC0049v.f459f;
                }
                objL = uVar;
                break;
            }
        }
        if (objL != AbstractC0049v.f456c && objL != AbstractC0049v.f457d) {
            if (objL == AbstractC0049v.f459f) {
                return false;
            }
            h(objL);
        }
        return true;
    }

    public final boolean l(Throwable th) {
        if (D()) {
            return true;
        }
        boolean z2 = th instanceof CancellationException;
        InterfaceC0036h interfaceC0036h = (InterfaceC0036h) f418b.get(this);
        if (interfaceC0036h == null || interfaceC0036h == c0.f421a) {
            return z2;
        }
        return interfaceC0036h.e(th) || z2;
    }

    public String m() {
        return "Job was cancelled";
    }

    @Override // p040w0.i
    public final Object n(Object obj, E0.p pVar) {
        return pVar.c(obj, this);
    }

    public boolean o(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return k(th) && v();
    }

    public final void p(L l2, Object obj) throws IllegalAccessException, InvocationTargetException {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f418b;
        InterfaceC0036h interfaceC0036h = (InterfaceC0036h) atomicReferenceFieldUpdater.get(this);
        if (interfaceC0036h != null) {
            interfaceC0036h.c();
            atomicReferenceFieldUpdater.set(this, c0.f421a);
        }
        C0041m c0041m = null;
        C0039k c0039k = obj instanceof C0039k ? (C0039k) obj : null;
        Throwable th = c0039k != null ? c0039k.f440a : null;
        if (l2 instanceof W) {
            try {
                ((W) l2).l(th);
                return;
            } catch (Throwable th2) {
                A(new C0041m("Exception in completion handler " + l2 + " for " + this, th2));
                return;
            }
        }
        b0 b0VarB = l2.b();
        if (b0VarB != null) {
            Object objH = b0VarB.h();
            F0.i.c(objH, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            for (R0.k kVarI = (R0.k) objH; !kVarI.equals(b0VarB); kVarI = kVarI.i()) {
                if (kVarI instanceof W) {
                    W w2 = (W) kVarI;
                    try {
                        w2.l(th);
                    } catch (Throwable th3) {
                        if (c0041m != null) {
                            p029q.j.a(c0041m, th3);
                        } else {
                            c0041m = new C0041m("Exception in completion handler " + w2 + " for " + this, th3);
                        }
                    }
                }
            }
            if (c0041m != null) {
                A(c0041m);
            }
        }
    }

    public final Throwable q(Object obj) {
        Throwable thD;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        a0 a0Var = (a0) ((e0) obj);
        Object objY = a0Var.y();
        if (objY instanceof Y) {
            thD = ((Y) objY).d();
        } else if (objY instanceof C0039k) {
            thD = ((C0039k) objY).f440a;
        } else {
            if (objY instanceof L) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objY).toString());
            }
            thD = null;
        }
        CancellationException t2 = thD instanceof CancellationException ? (CancellationException) thD : null;
        if (t2 == null) {
            t2 = new T("Parent job is ".concat(K(objY)), thD, a0Var);
        }
        return t2;
    }

    @Override // p040w0.i
    public final p040w0.i r(p040w0.h hVar) {
        return p028p0.a.n(this, hVar);
    }

    public final Object s(Y y2, Object obj) throws IllegalAccessException, InvocationTargetException {
        Object obj2 = null;
        Throwable t2 = null;
        C0039k c0039k = obj instanceof C0039k ? (C0039k) obj : null;
        Throwable th = c0039k != null ? c0039k.f440a : null;
        synchronized (y2) {
            y2.e();
            ArrayList<Throwable> arrayListG = y2.g(th);
            if (!arrayListG.isEmpty()) {
                for (Object obj3 : arrayListG) {
                    if (!(((Throwable) obj3) instanceof CancellationException)) {
                        obj2 = obj3;
                        break;
                    }
                }
                t2 = (Throwable) obj2;
                if (t2 == null) {
                    t2 = (Throwable) arrayListG.get(0);
                }
            } else if (y2.e()) {
                t2 = new T(m(), null, this);
            }
            if (t2 != null && arrayListG.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListG.size()));
                for (Throwable th2 : arrayListG) {
                    if (th2 != t2 && th2 != t2 && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        p029q.j.a(t2, th2);
                    }
                }
            }
        }
        if (t2 != null && t2 != th) {
            obj = new C0039k(t2, false);
        }
        if (t2 != null && (l(t2) || z(t2))) {
            F0.i.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            C0039k.f439b.compareAndSet((C0039k) obj, 0, 1);
        }
        H(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f417a;
        Object m2 = obj instanceof L ? new M((L) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, y2, m2) && atomicReferenceFieldUpdater.get(this) == y2) {
        }
        p(y2, obj);
        return obj;
    }

    @Override // p040w0.i
    public final p040w0.i t(p040w0.i iVar) {
        F0.i.e(iVar, "context");
        return p029q.j.n(this, iVar);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName() + '{' + K(y()) + '}');
        sb.append('@');
        sb.append(AbstractC0049v.d(this));
        return sb.toString();
    }

    public final CancellationException u() {
        CancellationException cancellationException;
        Object objY = y();
        if (!(objY instanceof Y)) {
            if (objY instanceof L) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (!(objY instanceof C0039k)) {
                return new T(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            Throwable th = ((C0039k) objY).f440a;
            cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
            return cancellationException == null ? new T(m(), th, this) : cancellationException;
        }
        Throwable thD = ((Y) objY).d();
        if (thD == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String strConcat = getClass().getSimpleName().concat(" is cancelling");
        cancellationException = thD instanceof CancellationException ? (CancellationException) thD : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        if (strConcat == null) {
            strConcat = m();
        }
        return new T(strConcat, thD, this);
    }

    public boolean v() {
        return true;
    }

    public boolean w() {
        return false;
    }

    public final b0 x(L l2) {
        b0 b0VarB = l2.b();
        if (b0VarB != null) {
            return b0VarB;
        }
        if (l2 instanceof E) {
            return new b0();
        }
        if (l2 instanceof W) {
            J((W) l2);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + l2).toString());
    }

    public final Object y() {
        while (true) {
            Object obj = f417a.get(this);
            if (!(obj instanceof R0.p)) {
                return obj;
            }
            ((R0.p) obj).a(this);
        }
    }

    public boolean z(Throwable th) {
        return false;
    }

    public void I() {
    }

    public void A(C0041m c0041m) {
        throw c0041m;
    }

    public void H(Object obj) {
    }

    public void h(Object obj) {
    }
}
