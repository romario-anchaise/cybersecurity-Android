// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class S implements Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static S f1667a;

    @Override // androidx.lifecycle.Q
    public N b(Class cls) throws InvocationTargetException {
        try {
            Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
            F0.i.d(objNewInstance, "{\n                modelC…wInstance()\n            }");
            return (N) objNewInstance;
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Cannot create an instance of " + cls, e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("Cannot create an instance of " + cls, e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("Cannot create an instance of " + cls, e4);
        }
    }
}
