// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z0;

import a2.i;
import g0.j;
import i2.y;
import w2.k;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends i2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f6294a;

    public f(g gVar) {
        this.f6294a = gVar;
    }

    @Override // i2.c
    public final void i(v2.g gVar, int i3, String str) {
        f1.b.a(new i(23, this));
    }

    @Override // i2.c
    public final void k(v2.g gVar, Exception exc, y yVar) {
        f1.b.a(new j(this, exc, 27));
    }

    @Override // i2.c
    public final void l(String str, v2.g gVar) {
        f1.b.a(new j(this, str, 25));
    }

    @Override // i2.c
    public final void m(v2.g gVar, k kVar) {
        f1.b.a(new j(this, kVar, 26));
    }

    @Override // i2.c
    public final void n(v2.g gVar, y yVar) {
        f1.b.a(new j(this, yVar.f2292h.d(), 24));
    }
}
