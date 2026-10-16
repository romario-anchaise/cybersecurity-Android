// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p022m0;

import H.s;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class t extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f3741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3742c;

    public t(Method method, int i2) {
        this.f3741b = method;
        this.f3742c = i2;
    }

    @Override // p022m0.w
    public final Object a(Class cls) {
        String strM = s.m(cls);
        if (strM != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(strM));
        }
        return this.f3741b.invoke(null, cls, Integer.valueOf(this.f3742c));
    }
}
