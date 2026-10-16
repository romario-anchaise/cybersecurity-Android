// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

/* JADX INFO: renamed from: m1.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0215t extends F0.j implements E0.l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0201e f3857c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0215t(InterfaceC0201e interfaceC0201e, int i2) {
        super(1);
        this.f3856b = i2;
        this.f3857c = interfaceC0201e;
    }

    @Override // E0.l
    public final Object d(Object obj) {
        switch (this.f3856b) {
            case 0:
                this.f3857c.cancel();
                break;
            case 1:
                this.f3857c.cancel();
                break;
            default:
                this.f3857c.cancel();
                break;
        }
        return p034t0.h.f4132b;
    }
}
