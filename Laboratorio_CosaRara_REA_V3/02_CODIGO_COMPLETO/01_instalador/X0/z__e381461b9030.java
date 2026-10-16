// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package X0;

import k1.C0196l;
import k1.InterfaceC0194j;

/* JADX INFO: loaded from: classes.dex */
public final class z extends B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1103a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f1104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1105c;

    public z(s sVar, C0196l c0196l) {
        this.f1104b = sVar;
        this.f1105c = c0196l;
    }

    @Override // X0.B
    public final long a() {
        switch (this.f1103a) {
            case 0:
                return ((C0196l) this.f1105c).c();
            default:
                return ((B) this.f1105c).a();
        }
    }

    @Override // X0.B
    public final s b() {
        switch (this.f1103a) {
            case 0:
                break;
        }
        return this.f1104b;
    }

    @Override // X0.B
    public final void c(InterfaceC0194j interfaceC0194j) {
        switch (this.f1103a) {
            case 0:
                interfaceC0194j.p((C0196l) this.f1105c);
                break;
            default:
                ((B) this.f1105c).c(interfaceC0194j);
                break;
        }
    }

    public z(B b2, s sVar) {
        this.f1105c = b2;
        this.f1104b = sVar;
    }
}
