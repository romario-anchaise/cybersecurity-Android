// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w;

import android.content.Context;
import android.net.ConnectivityManager;
import p.m;
import y.r;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConnectivityManager f3368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f3369g;

    public h(Context context, r rVar) {
        super(context, rVar);
        Object systemService = this.f3362b.getSystemService("connectivity");
        systemService.getClass();
        this.f3368f = (ConnectivityManager) systemService;
        this.f3369g = new g(this);
    }

    @Override // w.e
    public final Object a() {
        return i.a(this.f3368f);
    }

    @Override // w.e
    public final void d() {
        try {
            m.d().a(i.f3370a, "Registering network callback");
            z.i.a(this.f3368f, this.f3369g);
        } catch (IllegalArgumentException e3) {
            m.d().c(i.f3370a, "Received exception while registering network callback", e3);
        } catch (SecurityException e4) {
            m.d().c(i.f3370a, "Received exception while registering network callback", e4);
        }
    }

    @Override // w.e
    public final void e() {
        try {
            m.d().a(i.f3370a, "Unregistering network callback");
            z.g.c(this.f3368f, this.f3369g);
        } catch (IllegalArgumentException e3) {
            m.d().c(i.f3370a, "Received exception while unregistering network callback", e3);
        } catch (SecurityException e4) {
            m.d().c(i.f3370a, "Received exception while unregistering network callback", e4);
        }
    }
}
