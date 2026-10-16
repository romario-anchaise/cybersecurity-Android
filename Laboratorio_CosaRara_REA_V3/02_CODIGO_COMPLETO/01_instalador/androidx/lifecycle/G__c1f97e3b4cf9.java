// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public final class G implements InterfaceC0080s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final F f1643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1644c;

    public G(String str, F f2) {
        this.f1642a = str;
        this.f1643b = f2;
    }

    @Override // androidx.lifecycle.InterfaceC0080s
    public final void g(InterfaceC0082u interfaceC0082u, EnumC0076n enumC0076n) {
        if (enumC0076n == EnumC0076n.ON_DESTROY) {
            this.f1644c = false;
            interfaceC0082u.getLifecycle().c(this);
        }
    }

    public final void h(Q.e eVar, AbstractC0078p abstractC0078p) {
        F0.i.e(eVar, "registry");
        F0.i.e(abstractC0078p, "lifecycle");
        if (this.f1644c) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f1644c = true;
        abstractC0078p.a(this);
        eVar.c(this.f1642a, this.f1643b.f1641e);
    }
}
