// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p016j0;

import E0.l;
import N0.C0033e;
import X0.D;
import X0.InterfaceC0058e;
import b1.j;
import java.io.IOException;
import p034t0.h;

/* JADX INFO: loaded from: classes.dex */
public final class g implements InterfaceC0058e, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f3377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0033e f3378b;

    public g(j jVar, C0033e c0033e) {
        this.f3377a = jVar;
        this.f3378b = c0033e;
    }

    @Override // E0.l
    public final Object d(Object obj) {
        try {
            this.f3377a.cancel();
        } catch (Throwable unused) {
        }
        return h.f4132b;
    }

    @Override // X0.InterfaceC0058e
    public final void g(j jVar, IOException iOException) {
        if (jVar.f2142m) {
            return;
        }
        this.f3378b.b(p029q.j.b(iOException));
    }

    @Override // X0.InterfaceC0058e
    public final void h(D d2) {
        this.f3378b.b(d2);
    }
}
