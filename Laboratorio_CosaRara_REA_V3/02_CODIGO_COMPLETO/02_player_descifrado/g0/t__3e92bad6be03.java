// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g0;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.Map;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class t extends n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f1488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u0.b f1489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e0.i f1490d;

    public t(s sVar, u0.b bVar, e0.i iVar) {
        super(2);
        this.f1489c = bVar;
        this.f1488b = sVar;
        this.f1490d = iVar;
        if (sVar.f1485a) {
            o2.i("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
            throw null;
        }
    }

    @Override // g0.n
    public final boolean a(h hVar) {
        return this.f1488b.f1485a;
    }

    @Override // g0.n
    public final e0.d[] b(h hVar) {
        return (e0.d[]) this.f1488b.f1486b;
    }

    @Override // g0.n
    public final void c(Status status) {
        this.f1490d.getClass();
        this.f1489c.a(status.f474e != null ? new f0.f(status) : new f0.a(status));
    }

    @Override // g0.n
    public final void d(Exception exc) {
        this.f1489c.a(exc);
    }

    @Override // g0.n
    public final void e(h hVar) throws DeadObjectException {
        u0.b bVar = this.f1489c;
        try {
            this.f1488b.a(hVar.f1457b, bVar);
        } catch (DeadObjectException e3) {
            throw e3;
        } catch (RemoteException e4) {
            c(n.g(e4));
        } catch (RuntimeException e5) {
            bVar.a(e5);
        }
    }

    @Override // g0.n
    public final void f(y.e eVar, boolean z2) {
        u0.b bVar = this.f1489c;
        ((Map) eVar.f5977d).put(bVar, Boolean.valueOf(z2));
        u0.e eVar2 = bVar.f3250a;
        y.c cVar = new y.c(eVar, bVar);
        eVar2.getClass();
        eVar2.f3257b.d(new u0.d(u0.c.f3251a, cVar));
        synchronized (eVar2.f3256a) {
            try {
                if (eVar2.f3258c) {
                    eVar2.f3257b.e(eVar2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
