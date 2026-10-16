// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import N0.C0041m;

/* JADX INFO: renamed from: m1.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0205i implements InterfaceC0204h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0206j f3841b;

    public /* synthetic */ C0205i(C0206j c0206j, int i2) {
        this.f3840a = i2;
        this.f3841b = c0206j;
    }

    @Override // m1.InterfaceC0204h
    public final void b(InterfaceC0201e interfaceC0201e, O o2) {
        switch (this.f3840a) {
            case 0:
                boolean zF = o2.f3818a.f();
                C0206j c0206j = this.f3841b;
                if (!zF) {
                    c0206j.completeExceptionally(new C0041m(o2));
                } else {
                    c0206j.complete(o2.f3819b);
                }
                break;
            default:
                this.f3841b.complete(o2);
                break;
        }
    }

    @Override // m1.InterfaceC0204h
    public final void j(InterfaceC0201e interfaceC0201e, Throwable th) {
        switch (this.f3840a) {
            case 0:
                this.f3841b.completeExceptionally(th);
                break;
            default:
                this.f3841b.completeExceptionally(th);
                break;
        }
    }
}
