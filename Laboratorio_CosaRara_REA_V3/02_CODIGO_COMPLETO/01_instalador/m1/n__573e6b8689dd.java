// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: m1.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0210n implements InterfaceC0201e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f3843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0201e f3844b;

    public C0210n(Executor executor, InterfaceC0201e interfaceC0201e) {
        this.f3843a = executor;
        this.f3844b = interfaceC0201e;
    }

    @Override // m1.InterfaceC0201e
    public final X0.y a() {
        return this.f3844b.a();
    }

    @Override // m1.InterfaceC0201e
    public final void cancel() {
        this.f3844b.cancel();
    }

    @Override // m1.InterfaceC0201e
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final InterfaceC0201e clone() {
        return new C0210n(this.f3843a, this.f3844b.clone());
    }

    @Override // m1.InterfaceC0201e
    public final O j() {
        return this.f3844b.j();
    }

    @Override // m1.InterfaceC0201e
    public final boolean n() {
        return this.f3844b.n();
    }

    @Override // m1.InterfaceC0201e
    public final void r(InterfaceC0204h interfaceC0204h) {
        this.f3844b.r(new H.s(this, interfaceC0204h, 14, false));
    }
}
