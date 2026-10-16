// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p010f0;

import E0.p;
import N0.AbstractC0049v;
import N0.InterfaceC0047t;
import androidx.lifecycle.AbstractC0078p;
import p012h0.a;
import p029q.j;
import p040w0.d;
import p044y0.h;

/* JADX INFO: loaded from: classes.dex */
public final class t extends h implements p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ u f2696e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(u uVar, d dVar) {
        super(dVar);
        this.f2696e = uVar;
    }

    @Override // p044y0.a
    public final d a(Object obj, d dVar) {
        return new t(this.f2696e, dVar);
    }

    @Override // E0.p
    public final Object c(Object obj, Object obj2) {
        t tVar = (t) a((InterfaceC0047t) obj, (d) obj2);
        p034t0.h hVar = p034t0.h.f4132b;
        tVar.f(hVar);
        return hVar;
    }

    @Override // p044y0.a
    public final Object f(Object obj) {
        j.o(obj);
        u uVar = this.f2696e;
        s sVar = uVar.f2699c;
        if (sVar != null) {
            AbstractC0049v.a(sVar.f2695e);
            AbstractC0078p abstractC0078p = sVar.f2694d;
            a aVar = sVar.f2693c;
            if (aVar != null) {
                abstractC0078p.c(aVar);
            }
            abstractC0078p.c(sVar);
        }
        uVar.f2699c = null;
        return p034t0.h.f4132b;
    }
}
