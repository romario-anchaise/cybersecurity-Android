// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p022m0;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class s extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f3739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3740c;

    public s(Method method, Object obj) {
        this.f3739b = method;
        this.f3740c = obj;
    }

    @Override // p022m0.w
    public final Object a(Class cls) {
        String strM = H.s.m(cls);
        if (strM != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(strM));
        }
        return this.f3739b.invoke(this.f3740c, cls);
    }
}
