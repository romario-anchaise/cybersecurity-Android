// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f1698a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap f1699b = new HashMap();

    public static void a(Constructor constructor, InterfaceC0081t interfaceC0081t) {
        try {
            F0.i.d(constructor.newInstance(interfaceC0081t), "{\n            constructo…tance(`object`)\n        }");
            throw new ClassCastException();
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    /* JADX WARN: Code duplicated, block: B:61:0x0117  */
    /* JADX WARN: Code duplicated, block: B:66:0x0123  */
    /* JADX WARN: Code duplicated, block: B:69:0x0127  */
    /* JADX WARN: Code duplicated, block: B:72:0x0133 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x0135  */
    /* JADX WARN: Code duplicated, block: B:77:0x014b  */
    /* JADX WARN: Code duplicated, block: B:87:0x0150 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x0146 A[SYNTHETIC] */
    public static int b(Class cls) {
        Constructor<?> declaredConstructor;
        boolean zBooleanValue;
        Class<?>[] interfaces;
        int i2;
        boolean z2;
        HashMap map = f1698a;
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int i3 = 1;
        if (cls.getCanonicalName() != null) {
            ArrayList arrayList = null;
            try {
                Package r3 = cls.getPackage();
                String canonicalName = cls.getCanonicalName();
                String name = r3 != null ? r3.getName() : "";
                F0.i.d(name, "fullPackage");
                if (name.length() != 0) {
                    F0.i.d(canonicalName, "name");
                    canonicalName = canonicalName.substring(name.length() + 1);
                    F0.i.d(canonicalName, "this as java.lang.String).substring(startIndex)");
                }
                F0.i.d(canonicalName, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
                String strConcat = M0.m.P(canonicalName, ".", "_").concat("_LifecycleAdapter");
                if (name.length() != 0) {
                    strConcat = name + '.' + strConcat;
                }
                declaredConstructor = Class.forName(strConcat).getDeclaredConstructor(cls);
                if (!declaredConstructor.isAccessible()) {
                    declaredConstructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                declaredConstructor = null;
            } catch (NoSuchMethodException e2) {
                throw new RuntimeException(e2);
            }
            HashMap map2 = f1699b;
            if (declaredConstructor != null) {
                map2.put(cls, p029q.j.m(declaredConstructor));
            } else {
                C0066d c0066d = C0066d.f1673c;
                HashMap map3 = c0066d.f1675b;
                Boolean bool = (Boolean) map3.get(cls);
                if (bool != null) {
                    zBooleanValue = bool.booleanValue();
                } else {
                    try {
                        Method[] declaredMethods = cls.getDeclaredMethods();
                        int length = declaredMethods.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length) {
                                map3.put(cls, Boolean.FALSE);
                                zBooleanValue = false;
                                break;
                            }
                            if (((y) declaredMethods[i4].getAnnotation(y.class)) != null) {
                                c0066d.a(cls, declaredMethods);
                                zBooleanValue = true;
                                break;
                            }
                            i4++;
                        }
                    } catch (NoClassDefFoundError e3) {
                        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e3);
                    }
                }
                if (!zBooleanValue) {
                    Class superclass = cls.getSuperclass();
                    if (superclass != null && InterfaceC0081t.class.isAssignableFrom(superclass)) {
                        F0.i.d(superclass, "superclass");
                        if (b(superclass) != 1) {
                            Object obj = map2.get(superclass);
                            F0.i.b(obj);
                            arrayList = new ArrayList((Collection) obj);
                            interfaces = cls.getInterfaces();
                            F0.i.d(interfaces, "klass.interfaces");
                            for (Class<?> cls2 : interfaces) {
                                if (cls2 == null && InterfaceC0081t.class.isAssignableFrom(cls2)) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (!z2) {
                                    F0.i.d(cls2, "intrface");
                                    if (b(cls2) == 1) {
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        Object obj2 = map2.get(cls2);
                                        F0.i.b(obj2);
                                        arrayList.addAll((Collection) obj2);
                                    }
                                }
                            }
                            if (arrayList != null) {
                                map2.put(cls, arrayList);
                            }
                        }
                    } else {
                        interfaces = cls.getInterfaces();
                        F0.i.d(interfaces, "klass.interfaces");
                        while (i2 < r7) {
                            if (cls2 == null) {
                                z2 = false;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                F0.i.d(cls2, "intrface");
                                if (b(cls2) == 1) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    Object obj3 = map2.get(cls2);
                                    F0.i.b(obj3);
                                    arrayList.addAll((Collection) obj3);
                                }
                            }
                        }
                        if (arrayList != null) {
                            map2.put(cls, arrayList);
                        }
                    }
                }
            }
            i3 = 2;
        }
        map.put(cls, Integer.valueOf(i3));
        return i3;
    }
}
