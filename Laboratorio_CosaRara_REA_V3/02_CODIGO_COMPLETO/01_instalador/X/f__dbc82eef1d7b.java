// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X;

import E0.p;
import N0.InterfaceC0047t;
import f1.l;
import java.io.IOException;
import k1.C0190f;

/* JADX INFO: loaded from: classes.dex */
public final class f extends p044y0.h implements p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ g f866e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, p040w0.d dVar) {
        super(dVar);
        this.f866e = gVar;
    }

    @Override // p044y0.a
    public final p040w0.d a(Object obj, p040w0.d dVar) {
        return new f(this.f866e, dVar);
    }

    @Override // E0.p
    public final Object c(Object obj, Object obj2) {
        return ((f) a((InterfaceC0047t) obj, (p040w0.d) obj2)).f(p034t0.h.f4132b);
    }

    @Override // p044y0.a
    public final Object f(Object obj) {
        p029q.j.o(obj);
        g gVar = this.f866e;
        synchronized (gVar) {
            if (!gVar.f878l || gVar.f879m) {
                return p034t0.h.f4132b;
            }
            try {
                gVar.y();
            } catch (IOException unused) {
                gVar.f880n = true;
            }
            try {
                if (gVar.f875i >= 2000) {
                    gVar.A();
                }
            } catch (IOException unused2) {
                gVar.f881o = true;
                gVar.f876j = l.e(new C0190f());
            }
            return p034t0.h.f4132b;
        }
    }
}
