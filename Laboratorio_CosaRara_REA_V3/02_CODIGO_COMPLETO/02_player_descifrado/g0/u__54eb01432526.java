// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g0;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class u extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u0.b f1491b;

    public u(u0.b bVar) {
        super(4);
        this.f1491b = bVar;
    }

    @Override // g0.n
    public final boolean a(h hVar) {
        if (hVar.f1461f.get(null) == null) {
            return false;
        }
        throw new ClassCastException();
    }

    @Override // g0.n
    public final e0.d[] b(h hVar) {
        if (hVar.f1461f.get(null) == null) {
            return null;
        }
        throw new ClassCastException();
    }

    @Override // g0.n
    public final void c(Status status) {
        this.f1491b.a(new f0.a(status));
    }

    @Override // g0.n
    public final void d(Exception exc) {
        this.f1491b.a(exc);
    }

    @Override // g0.n
    public final void e(h hVar) throws DeadObjectException {
        try {
            h(hVar);
        } catch (DeadObjectException e3) {
            c(n.g(e3));
            throw e3;
        } catch (RemoteException e4) {
            c(n.g(e4));
        } catch (RuntimeException e5) {
            this.f1491b.a(e5);
        }
    }

    public final void h(h hVar) {
        if (hVar.f1461f.remove(null) != null) {
            throw new ClassCastException();
        }
        u0.b bVar = this.f1491b;
        Boolean bool = Boolean.FALSE;
        u0.e eVar = bVar.f3250a;
        synchronized (eVar.f3256a) {
            try {
                if (eVar.f3258c) {
                    return;
                }
                eVar.f3258c = true;
                eVar.f3259d = bool;
                eVar.f3257b.e(eVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // g0.n
    public final /* bridge */ /* synthetic */ void f(y.e eVar, boolean z2) {
    }
}
