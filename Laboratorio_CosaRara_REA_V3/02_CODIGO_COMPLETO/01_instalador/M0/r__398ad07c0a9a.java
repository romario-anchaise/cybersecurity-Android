// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p022m0;

import java.lang.reflect.AccessibleObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f3738a;

    static {
        r pVar;
        if (i.f3712a >= 9) {
            try {
                pVar = new p(AccessibleObject.class.getDeclaredMethod("canAccess", Object.class));
            } catch (NoSuchMethodException unused) {
                pVar = null;
            }
        } else {
            pVar = null;
        }
        if (pVar == null) {
            pVar = new q();
        }
        f3738a = pVar;
    }

    public abstract boolean a(Object obj, AccessibleObject accessibleObject);
}
