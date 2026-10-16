// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p010f0;

import N0.AbstractC0049v;
import N0.S;
import androidx.lifecycle.AbstractC0078p;
import androidx.lifecycle.InterfaceC0082u;

/* JADX INFO: loaded from: classes.dex */
public final class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC0078p f2597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final S f2598b;

    public a(AbstractC0078p abstractC0078p, S s2) {
        this.f2597a = abstractC0078p;
        this.f2598b = s2;
    }

    @Override // p010f0.p
    public final void a() {
        this.f2597a.c(this);
    }

    @Override // androidx.lifecycle.InterfaceC0067e
    public final void c(InterfaceC0082u interfaceC0082u) {
        AbstractC0049v.a(this.f2598b);
    }

    @Override // p010f0.p
    public final void start() {
        this.f2597a.a(this);
    }
}
