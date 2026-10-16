// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package R0;

import N0.AbstractC0045q;
import N0.AbstractC0049v;
import N0.C0039k;
import N0.C0040l;
import N0.H;
import N0.InterfaceC0046s;
import N0.S;
import N0.a0;
import N0.g0;
import N0.h0;
import N0.k0;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final u f537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u f538d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f535a = new u(0, "NO_DECISION");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f536b = new u(0, "CLOSED");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final u f539e = new u(0, "CONDITION_FALSE");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final u f540f = new u(0, "NO_THREAD_ELEMENTS");

    static {
        int i2 = 0;
        f537c = new u(i2, "UNDEFINED");
        f538d = new u(i2, "REUSABLE_CLAIMED");
    }

    public static final void a(int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException(F0.h.b(i2, "Expected positive parallelism level, but got ").toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [U0.f] */
    /* JADX WARN: Type inference failed for: r4v1, types: [R0.c, R0.t, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r7v0, types: [E0.p] */
    public static final Object b(U0.f fVar, long j2, E0.p pVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        while (true) {
            if (fVar.f573c >= j2 && !fVar.a()) {
                return fVar;
            }
            Object obj = c.f542a.get(fVar);
            u uVar = f536b;
            if (obj == uVar) {
                return uVar;
            }
            t tVar = (t) ((c) obj);
            if (tVar == null) {
                tVar = (t) pVar.c(Long.valueOf(fVar.f573c + 1), fVar);
                do {
                    atomicReferenceFieldUpdater = c.f542a;
                    if (atomicReferenceFieldUpdater.compareAndSet(fVar, null, tVar)) {
                        if (fVar.a()) {
                            fVar.b();
                        }
                    }
                } while (atomicReferenceFieldUpdater.get(fVar) == null);
            }
            fVar = tVar;
        }
    }

    public static final t c(Object obj) {
        if (obj == f536b) {
            throw new IllegalStateException("Does not contain segment");
        }
        F0.i.c(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (t) obj;
    }

    public static final void d(p040w0.i iVar, Throwable th) throws IllegalAccessException, InvocationTargetException {
        Throwable runtimeException;
        Iterator it = e.f545a.iterator();
        while (it.hasNext()) {
            try {
                ((InterfaceC0046s) it.next()).f(iVar, th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    p029q.j.a(runtimeException, th);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            p029q.j.a(th, new f(iVar));
        } catch (Throwable unused) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    public static final void e(p040w0.i iVar, Object obj) {
        if (obj == f540f) {
            return;
        }
        if (!(obj instanceof y)) {
            Object objN = iVar.n(null, w.f578d);
            F0.i.c(objN, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            androidx.fragment.app.y.a(objN);
            throw null;
        }
        y yVar = (y) obj;
        g0[] g0VarArr = yVar.f583b;
        int length = g0VarArr.length - 1;
        if (length < 0) {
            return;
        }
        g0 g0Var = g0VarArr[length];
        F0.i.b(null);
        Object obj2 = yVar.f582a[length];
        throw null;
    }

    public static final void f(p040w0.d dVar, Object obj, E0.l lVar) {
        Object c0039k;
        if (!(dVar instanceof g)) {
            dVar.b(obj);
            return;
        }
        g gVar = (g) dVar;
        Throwable thA = p034t0.f.a(obj);
        if (thA == null) {
            c0039k = lVar != null ? new C0040l(obj, lVar) : obj;
        } else {
            c0039k = new C0039k(thA, false);
        }
        AbstractC0045q abstractC0045q = gVar.f548d;
        p044y0.c cVar = gVar.f549e;
        cVar.g();
        boolean zV = abstractC0045q.v();
        p040w0.i iVar = cVar.f4197b;
        if (zV) {
            gVar.f550f = c0039k;
            gVar.f384c = 1;
            F0.i.b(iVar);
            gVar.f548d.u(iVar, gVar);
            return;
        }
        H hA = h0.a();
        if (hA.f390c >= 4294967296L) {
            gVar.f550f = c0039k;
            gVar.f384c = 1;
            p036u0.d dVar2 = hA.f392e;
            if (dVar2 == null) {
                dVar2 = new p036u0.d();
                hA.f392e = dVar2;
            }
            dVar2.addLast(gVar);
            return;
        }
        hA.y(true);
        try {
            F0.i.b(iVar);
            S s2 = (S) iVar.j(N0.r.f453b);
            if (s2 == null || s2.a()) {
                Object obj2 = gVar.g;
                F0.i.b(iVar);
                Object objJ = j(iVar, obj2);
                k0 k0VarM = objJ != f540f ? AbstractC0049v.m(cVar, iVar, objJ) : null;
                try {
                    cVar.b(obj);
                    if (k0VarM == null || k0VarM.N()) {
                        e(iVar, objJ);
                    }
                } catch (Throwable th) {
                    if (k0VarM == null || k0VarM.N()) {
                        e(iVar, objJ);
                    }
                    throw th;
                }
            } else {
                CancellationException cancellationExceptionU = ((a0) s2).u();
                gVar.a(c0039k, cancellationExceptionU);
                gVar.b(p029q.j.b(cancellationExceptionU));
            }
            while (hA.z()) {
            }
        } catch (Throwable th2) {
            try {
                gVar.h(th2, null);
            } finally {
                hA.w();
            }
        }
    }

    public static final long g(String str, long j2, long j3, long j4) {
        String property;
        int i2 = v.f576a;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j2;
        }
        Long lK = M0.l.K(property);
        if (lK == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + property + '\'').toString());
        }
        long jLongValue = lK.longValue();
        if (j3 <= jLongValue && jLongValue <= j4) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j3 + ".." + j4 + ", but is '" + jLongValue + '\'').toString());
    }

    public static int h(String str, int i2, int i3, int i4, int i5) {
        if ((i5 & 4) != 0) {
            i3 = 1;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return (int) g(str, i2, i3, i4);
    }

    public static final Object i(p040w0.i iVar) {
        Object objN = iVar.n(0, w.f577c);
        F0.i.b(objN);
        return objN;
    }

    public static final Object j(p040w0.i iVar, Object obj) {
        if (obj == null) {
            obj = i(iVar);
        }
        if (obj == 0) {
            return f540f;
        }
        if (obj instanceof Integer) {
            return iVar.n(new y(iVar, ((Number) obj).intValue()), w.f579e);
        }
        androidx.fragment.app.y.a(obj);
        throw null;
    }
}
