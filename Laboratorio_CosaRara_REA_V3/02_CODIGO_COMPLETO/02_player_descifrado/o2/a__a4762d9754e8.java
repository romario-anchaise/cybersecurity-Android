// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package o2;

import java.io.IOException;
import m2.m;
import w2.h;
import w2.j;
import w2.l;
import w2.x;
import w2.z;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements x {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f2789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ g f2791e;

    public a(g gVar) {
        this.f2791e = gVar;
        this.f2789c = new l(((j) gVar.f2809d).a());
    }

    @Override // w2.x
    public final z a() {
        return this.f2789c;
    }

    public final void d() {
        g gVar = this.f2791e;
        int i3 = gVar.f2806a;
        if (i3 == 6) {
            return;
        }
        if (i3 != 5) {
            throw new IllegalStateException("state: " + gVar.f2806a);
        }
        l lVar = this.f2789c;
        z zVar = lVar.f5782e;
        lVar.f5782e = z.f5814d;
        zVar.a();
        zVar.b();
        gVar.f2806a = 6;
    }

    @Override // w2.x
    public long f(long j3, h hVar) {
        g gVar = this.f2791e;
        hVar.getClass();
        try {
            return ((j) gVar.f2809d).f(j3, hVar);
        } catch (IOException e3) {
            ((m) gVar.f2808c).k();
            d();
            throw e3;
        }
    }
}
