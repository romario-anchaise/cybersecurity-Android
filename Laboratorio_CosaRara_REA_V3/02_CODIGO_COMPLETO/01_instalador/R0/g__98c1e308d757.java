// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package R0;

import N0.AbstractC0045q;
import N0.AbstractC0049v;
import N0.B;
import N0.C0039k;
import N0.C0040l;
import N0.H;
import N0.h0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class g extends B implements p044y0.d, p040w0.d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f547h = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AbstractC0045q f548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p044y0.c f549e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f550f;
    public final Object g;

    public g(AbstractC0045q abstractC0045q, p044y0.c cVar) {
        super(-1);
        this.f548d = abstractC0045q;
        this.f549e = cVar;
        this.f550f = a.f537c;
        p040w0.i iVar = cVar.f4197b;
        F0.i.b(iVar);
        this.g = a.i(iVar);
    }

    @Override // N0.B
    public final void a(Object obj, CancellationException cancellationException) {
        if (obj instanceof C0040l) {
            ((C0040l) obj).f443b.d(cancellationException);
        }
    }

    @Override // p040w0.d
    public final void b(Object obj) {
        p044y0.c cVar = this.f549e;
        p040w0.i iVar = cVar.f4197b;
        F0.i.b(iVar);
        Throwable thA = p034t0.f.a(obj);
        Object c0039k = thA == null ? obj : new C0039k(thA, false);
        AbstractC0045q abstractC0045q = this.f548d;
        if (abstractC0045q.v()) {
            this.f550f = c0039k;
            this.f384c = 0;
            abstractC0045q.u(iVar, this);
            return;
        }
        H hA = h0.a();
        if (hA.f390c >= 4294967296L) {
            this.f550f = c0039k;
            this.f384c = 0;
            p036u0.d dVar = hA.f392e;
            if (dVar == null) {
                dVar = new p036u0.d();
                hA.f392e = dVar;
            }
            dVar.addLast(this);
            return;
        }
        hA.y(true);
        try {
            p040w0.i iVar2 = cVar.f4197b;
            F0.i.b(iVar2);
            Object objJ = a.j(iVar2, this.g);
            try {
                cVar.b(obj);
                a.e(iVar2, objJ);
                while (hA.z()) {
                }
            } catch (Throwable th) {
                a.e(iVar2, objJ);
                throw th;
            }
        } catch (Throwable th2) {
            try {
                h(th2, null);
            } finally {
                hA.w();
            }
        }
    }

    @Override // p044y0.d
    public final p044y0.d d() {
        p044y0.c cVar = this.f549e;
        if (cVar != null) {
            return cVar;
        }
        return null;
    }

    @Override // p040w0.d
    public final p040w0.i g() {
        p040w0.i iVar = this.f549e.f4197b;
        F0.i.b(iVar);
        return iVar;
    }

    @Override // N0.B
    public final Object i() {
        Object obj = this.f550f;
        this.f550f = a.f537c;
        return obj;
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f548d + ", " + AbstractC0049v.l(this.f549e) + ']';
    }

    @Override // N0.B
    public final p040w0.d c() {
        return this;
    }
}
