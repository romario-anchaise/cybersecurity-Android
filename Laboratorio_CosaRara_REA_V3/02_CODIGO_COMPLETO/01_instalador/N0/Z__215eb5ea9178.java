// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class Z extends R0.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final W f412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b0 f413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a0 f414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ L f415e;

    public Z(W w2, a0 a0Var, L l2) {
        this.f414d = a0Var;
        this.f415e = l2;
        this.f412b = w2;
    }

    @Override // R0.b
    public final void b(Object obj, Object obj2) {
        R0.k kVar = (R0.k) obj;
        boolean z2 = obj2 == null;
        W w2 = this.f412b;
        L l2 = z2 ? w2 : this.f413c;
        if (l2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = R0.k.f558a;
            while (!atomicReferenceFieldUpdater.compareAndSet(kVar, this, l2)) {
                if (atomicReferenceFieldUpdater.get(kVar) != this) {
                    return;
                }
            }
            if (z2) {
                b0 b0Var = this.f413c;
                F0.i.b(b0Var);
                w2.g(b0Var);
            }
        }
    }

    @Override // R0.b
    public final R0.u c(Object obj) {
        if (this.f414d.y() == this.f415e) {
            return null;
        }
        return R0.a.f539e;
    }
}
