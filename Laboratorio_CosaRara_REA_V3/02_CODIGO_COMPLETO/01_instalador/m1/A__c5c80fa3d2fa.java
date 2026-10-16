// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import java.io.IOException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class A extends W {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Method f3745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final InterfaceC0209m f3747f;

    public A(Method method, int i2, InterfaceC0209m interfaceC0209m) {
        this.f3745d = method;
        this.f3746e = i2;
        this.f3747f = interfaceC0209m;
    }

    @Override // m1.W
    public final void a(L l2, Object obj) {
        int i2 = this.f3746e;
        Method method = this.f3745d;
        if (obj == null) {
            throw W.o(method, i2, "Body parameter value must not be null.", new Object[0]);
        }
        try {
            l2.f3783k = (X0.B) this.f3747f.p(obj);
        } catch (IOException e2) {
            throw W.p(method, e2, i2, "Unable to convert " + obj + " to RequestBody", new Object[0]);
        }
    }
}
