// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p022m0;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class p extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f3737b;

    public p(Method method) {
        this.f3737b = method;
    }

    @Override // p022m0.r
    public final boolean a(Object obj, AccessibleObject accessibleObject) {
        try {
            return ((Boolean) this.f3737b.invoke(accessibleObject, obj)).booleanValue();
        } catch (Exception e2) {
            throw new RuntimeException("Failed invoking canAccess", e2);
        }
    }
}
