// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

/* JADX INFO: loaded from: classes.dex */
public final class O implements d0, E0.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E0.l f398a;

    public O(E0.l lVar) {
        this.f398a = lVar;
    }

    public final void a(Throwable th) {
        this.f398a.d(th);
    }

    @Override // E0.l
    public final /* bridge */ /* synthetic */ Object d(Object obj) {
        a((Throwable) obj);
        return p034t0.h.f4132b;
    }

    public final String toString() {
        return "InvokeOnCancel[" + this.f398a.getClass().getSimpleName() + '@' + AbstractC0049v.d(this) + ']';
    }
}
