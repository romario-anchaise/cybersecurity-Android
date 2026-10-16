// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p022m0;

import H.s;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class u extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f3743b;

    public u(Method method) {
        this.f3743b = method;
    }

    @Override // p022m0.w
    public final Object a(Class cls) {
        String strM = s.m(cls);
        if (strM != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(strM));
        }
        return this.f3743b.invoke(null, cls, Object.class);
    }
}
