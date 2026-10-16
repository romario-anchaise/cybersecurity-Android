// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p015j;

import p013i.E;

/* JADX INFO: loaded from: classes.dex */
public final class H extends AbstractViewOnTouchListenerC0184z0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ P f3050j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ T f3051k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(T t2, T t3, P p2) {
        super(t3);
        this.f3051k = t2;
        this.f3050j = p2;
    }

    @Override // p015j.AbstractViewOnTouchListenerC0184z0
    public final E b() {
        return this.f3050j;
    }

    @Override // p015j.AbstractViewOnTouchListenerC0184z0
    public final boolean c() {
        T t2 = this.f3051k;
        if (t2.getInternalPopup().b()) {
            return true;
        }
        t2.f3121f.f(J.b(t2), J.a(t2));
        return true;
    }
}
