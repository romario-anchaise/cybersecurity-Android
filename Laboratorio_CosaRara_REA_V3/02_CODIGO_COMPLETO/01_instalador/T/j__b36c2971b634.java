// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p033t;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class j extends i {
    @Override // p033t.i
    public final Typeface t(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.f4119f, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f4124l.invoke(null, objNewInstance, "sans-serif", -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // p033t.i
    public final Method y(Class cls) throws NoSuchMethodException {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, String.class, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
