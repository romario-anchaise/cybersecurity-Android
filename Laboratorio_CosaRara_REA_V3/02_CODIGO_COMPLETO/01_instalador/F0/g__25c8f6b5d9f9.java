// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p010f0;

import F0.i;
import androidx.lifecycle.AbstractC0078p;
import androidx.lifecycle.EnumC0077o;
import androidx.lifecycle.InterfaceC0067e;
import androidx.lifecycle.InterfaceC0081t;

/* JADX INFO: loaded from: classes.dex */
public final class g extends AbstractC0078p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f2621a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f2622b = new f();

    @Override // androidx.lifecycle.AbstractC0078p
    public final void a(InterfaceC0081t interfaceC0081t) {
        if (!(interfaceC0081t instanceof InterfaceC0067e)) {
            throw new IllegalArgumentException((interfaceC0081t + " must implement androidx.lifecycle.DefaultLifecycleObserver.").toString());
        }
        InterfaceC0067e interfaceC0067e = (InterfaceC0067e) interfaceC0081t;
        interfaceC0067e.getClass();
        f fVar = f2622b;
        i.e(fVar, "owner");
        interfaceC0067e.f(fVar);
        interfaceC0067e.b(fVar);
    }

    @Override // androidx.lifecycle.AbstractC0078p
    public final EnumC0077o b() {
        return EnumC0077o.f1685e;
    }

    public final String toString() {
        return "f0.g";
    }

    @Override // androidx.lifecycle.AbstractC0078p
    public final void c(InterfaceC0081t interfaceC0081t) {
    }
}
