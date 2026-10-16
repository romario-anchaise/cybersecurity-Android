// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f1658a = p036u0.e.p(new Class[]{Application.class, F.class});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f1659b = p029q.j.m(F.class);

    public static final Constructor a(Class cls, List list) {
        F0.i.e(list, "signature");
        Constructor<?>[] constructors = cls.getConstructors();
        F0.i.d(constructors, "modelClass.constructors");
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            F0.i.d(parameterTypes, "constructor.parameterTypes");
            int length = parameterTypes.length;
            List arrayList = length != 0 ? length != 1 ? new ArrayList(new p021m.d(1, parameterTypes)) : p029q.j.m(parameterTypes[0]) : p036u0.n.f4146a;
            if (list.equals(arrayList)) {
                return constructor;
            }
            if (list.size() == arrayList.size() && arrayList.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final N b(Class cls, Constructor constructor, Object... objArr) {
        try {
            return (N) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Failed to access " + cls, e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e4.getCause());
        }
    }
}
