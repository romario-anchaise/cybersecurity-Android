// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: androidx.lifecycle.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0066d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0066d f1673c = new C0066d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f1674a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f1675b = new HashMap();

    public static void b(HashMap map, C0065c c0065c, EnumC0076n enumC0076n, Class cls) {
        EnumC0076n enumC0076n2 = (EnumC0076n) map.get(c0065c);
        if (enumC0076n2 == null || enumC0076n == enumC0076n2) {
            if (enumC0076n2 == null) {
                map.put(c0065c, enumC0076n);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0065c.f1672b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + enumC0076n2 + ", new value " + enumC0076n);
    }

    public final C0064b a(Class cls, Method[] methodArr) {
        int i2;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        HashMap map2 = this.f1674a;
        if (superclass != null) {
            C0064b c0064bA = (C0064b) map2.get(superclass);
            if (c0064bA == null) {
                c0064bA = a(superclass, null);
            }
            map.putAll(c0064bA.f1670b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            C0064b c0064bA2 = (C0064b) map2.get(cls2);
            if (c0064bA2 == null) {
                c0064bA2 = a(cls2, null);
            }
            for (Map.Entry entry : c0064bA2.f1670b.entrySet()) {
                b(map, (C0065c) entry.getKey(), (EnumC0076n) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e2) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
            }
        }
        boolean z2 = false;
        for (Method method : methodArr) {
            y yVar = (y) method.getAnnotation(y.class);
            if (yVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else {
                    if (!InterfaceC0082u.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i2 = 1;
                }
                EnumC0076n enumC0076nValue = yVar.value();
                if (parameterTypes.length > 1) {
                    if (!EnumC0076n.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (enumC0076nValue != EnumC0076n.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i2 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                b(map, new C0065c(method, i2), enumC0076nValue, cls);
                z2 = true;
            }
        }
        C0064b c0064b = new C0064b(map);
        map2.put(cls, c0064b);
        this.f1675b.put(cls, Boolean.valueOf(z2));
        return c0064b;
    }
}
