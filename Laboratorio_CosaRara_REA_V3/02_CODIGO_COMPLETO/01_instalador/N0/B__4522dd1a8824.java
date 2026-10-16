// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public abstract class B extends T0.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f384c;

    public B(int i2) {
        super(0L, T0.k.g);
        this.f384c = i2;
    }

    public abstract void a(Object obj, CancellationException cancellationException);

    public abstract p040w0.d c();

    public Throwable e(Object obj) {
        C0039k c0039k = obj instanceof C0039k ? (C0039k) obj : null;
        if (c0039k != null) {
            return c0039k.f440a;
        }
        return null;
    }

    public final void h(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            p029q.j.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        F0.i.b(th);
        AbstractC0049v.f(c().g(), new C0048u("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object i();

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, InvocationTargetException {
        Object objB = p034t0.h.f4132b;
        T0.i iVar = this.f608b;
        try {
            p040w0.d dVarC = c();
            F0.i.c(dVarC, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            R0.g gVar = (R0.g) dVarC;
            p044y0.c cVar = gVar.f549e;
            Object obj = gVar.g;
            p040w0.i iVar2 = cVar.f4197b;
            F0.i.b(iVar2);
            Object objJ = R0.a.j(iVar2, obj);
            k0 k0VarM = objJ != R0.a.f540f ? AbstractC0049v.m(cVar, iVar2, objJ) : null;
            try {
                p040w0.i iVar3 = cVar.f4197b;
                F0.i.b(iVar3);
                Object objI = i();
                Throwable thE = e(objI);
                S s2 = (thE == null && AbstractC0049v.h(this.f384c)) ? (S) iVar3.j(r.f453b) : null;
                if (s2 != null && !s2.a()) {
                    CancellationException cancellationExceptionU = ((a0) s2).u();
                    a(objI, cancellationExceptionU);
                    cVar.b(p029q.j.b(cancellationExceptionU));
                } else if (thE != null) {
                    cVar.b(p029q.j.b(thE));
                } else {
                    cVar.b(f(objI));
                }
                if (k0VarM == null || k0VarM.N()) {
                    R0.a.e(iVar2, objJ);
                }
                try {
                    iVar.getClass();
                } catch (Throwable th) {
                    objB = p029q.j.b(th);
                }
                h(null, p034t0.f.a(objB));
            } catch (Throwable th2) {
                if (k0VarM == null || k0VarM.N()) {
                    R0.a.e(iVar2, objJ);
                }
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                iVar.getClass();
            } catch (Throwable th4) {
                objB = p029q.j.b(th4);
            }
            h(th3, p034t0.f.a(objB));
        }
    }

    public Object f(Object obj) {
        return obj;
    }
}
