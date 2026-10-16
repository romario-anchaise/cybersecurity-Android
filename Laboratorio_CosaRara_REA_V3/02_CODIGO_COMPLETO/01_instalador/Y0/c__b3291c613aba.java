// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p044y0;

import N0.C0033e;
import R0.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p040w0.d;
import p040w0.e;
import p040w0.g;
import p040w0.i;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f4197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient d f4198c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar) {
        super(dVar);
        i iVarG = dVar != null ? dVar.g() : null;
        this.f4197b = iVarG;
    }

    @Override // p040w0.d
    public final i g() {
        i iVar = this.f4197b;
        F0.i.b(iVar);
        return iVar;
    }

    @Override // p044y0.a
    public final void h() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        d dVar = this.f4198c;
        if (dVar != null && dVar != this) {
            i iVar = this.f4197b;
            F0.i.b(iVar);
            g gVarJ = iVar.j(e.f4164a);
            F0.i.b(gVarJ);
            R0.g gVar = (R0.g) dVar;
            do {
                atomicReferenceFieldUpdater = R0.g.f547h;
            } while (atomicReferenceFieldUpdater.get(gVar) == a.f538d);
            Object obj = atomicReferenceFieldUpdater.get(gVar);
            C0033e c0033e = obj instanceof C0033e ? (C0033e) obj : null;
            if (c0033e != null) {
                c0033e.n();
            }
        }
        this.f4198c = b.f4196a;
    }
}
