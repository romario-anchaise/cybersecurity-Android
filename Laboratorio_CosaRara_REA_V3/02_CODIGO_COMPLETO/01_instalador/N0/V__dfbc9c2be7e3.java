// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package N0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public class V extends a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f403c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V(S s2) {
        super(true);
        boolean z2 = true;
        B(s2);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a0.f418b;
        InterfaceC0036h interfaceC0036h = (InterfaceC0036h) atomicReferenceFieldUpdater.get(this);
        C0037i c0037i = interfaceC0036h instanceof C0037i ? (C0037i) interfaceC0036h : null;
        if (c0037i == null) {
            z2 = false;
            break;
        }
        a0 a0VarK = c0037i.k();
        while (!a0VarK.v()) {
            InterfaceC0036h interfaceC0036h2 = (InterfaceC0036h) atomicReferenceFieldUpdater.get(a0VarK);
            C0037i c0037i2 = interfaceC0036h2 instanceof C0037i ? (C0037i) interfaceC0036h2 : null;
            if (c0037i2 == null) {
                z2 = false;
                break;
            }
            a0VarK = c0037i2.k();
        }
        this.f403c = z2;
    }

    @Override // N0.a0
    public final boolean v() {
        return this.f403c;
    }

    @Override // N0.a0
    public final boolean w() {
        return true;
    }
}
