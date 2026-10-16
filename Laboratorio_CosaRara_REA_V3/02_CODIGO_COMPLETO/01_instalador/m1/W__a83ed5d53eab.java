// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import N0.C0033e;
import N0.C0041m;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import lyr.stable.wrapper.wallpaper.BingWallpaperApi;

/* JADX INFO: loaded from: classes.dex */
public abstract class W {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Type[] f3829a = new Type[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f3830b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Constructor f3831c;

    public static final Object b(InterfaceC0201e interfaceC0201e, p040w0.d dVar) {
        C0033e c0033e = new C0033e(p029q.j.l(dVar), 1);
        c0033e.q();
        int i2 = 0;
        c0033e.s(new C0215t(interfaceC0201e, i2));
        interfaceC0201e.r(new C0216u(c0033e, i2));
        return c0033e.p();
    }

    public static final Object c(InterfaceC0201e interfaceC0201e, p040w0.d dVar) {
        int i2 = 1;
        C0033e c0033e = new C0033e(p029q.j.l(dVar), 1);
        c0033e.q();
        c0033e.s(new C0215t(interfaceC0201e, i2));
        interfaceC0201e.r(new C0216u(c0033e, i2));
        return c0033e.p();
    }

    public static void d(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean e(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            Type ownerType = parameterizedType.getOwnerType();
            Type ownerType2 = parameterizedType2.getOwnerType();
            return (ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return e(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    public static Type f(Type type, Class cls, Class cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i2 = 0; i2 < length; i2++) {
                Class<?> cls3 = interfaces[i2];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i2];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return f(cls.getGenericInterfaces()[i2], interfaces[i2], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<?> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return f(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Type g(int i2, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i2 >= 0 && i2 < actualTypeArguments.length) {
            Type type = actualTypeArguments[i2];
            return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
        }
        throw new IllegalArgumentException("Index " + i2 + " not in range [0," + actualTypeArguments.length + ") for " + parameterizedType);
    }

    public static Class h(Type type) {
        Objects.requireNonNull(type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            throw new IllegalArgumentException();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance((Class<?>) h(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return h(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
    }

    public static Type i(Type type, Class cls) {
        if (Map.class.isAssignableFrom(cls)) {
            return q(type, cls, f(type, cls, Map.class));
        }
        throw new IllegalArgumentException();
    }

    public static boolean j(Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (j(type2)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            return j(((GenericArrayType) type).getGenericComponentType());
        }
        if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
            return true;
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
    }

    public static Object k(Object obj, Method method, Object[] objArr) throws NoSuchMethodException {
        Constructor declaredConstructor = f3831c;
        if (declaredConstructor == null) {
            declaredConstructor = B.f.f().getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            f3831c = declaredConstructor;
        }
        return B.f.l(declaredConstructor.newInstance(BingWallpaperApi.class, -1)).unreflectSpecial(method, BingWallpaperApi.class).bindTo(obj).invokeWithArguments(objArr);
    }

    public static boolean l(Annotation[] annotationArr, Class cls) {
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    public static boolean m(Type type) {
        return f3830b && type == p034t0.h.class;
    }

    public static IllegalArgumentException n(Method method, Exception exc, String str, Object... objArr) {
        return new IllegalArgumentException(String.format(str, objArr) + "\n    for method " + method.getDeclaringClass().getSimpleName() + "." + method.getName(), exc);
    }

    public static IllegalArgumentException o(Method method, int i2, String str, Object... objArr) {
        return n(method, null, str + " (" + J.f3769b.c(method, i2) + ")", objArr);
    }

    public static IllegalArgumentException p(Method method, Exception exc, int i2, String str, Object... objArr) {
        return n(method, exc, str + " (" + J.f3769b.c(method, i2) + ")", objArr);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0016  */
    public static Type q(Type type, Class cls, Type type2) {
        Type type3;
        WildcardType wildcardType;
        Type typeQ;
        Type type4;
        Type type5 = type2;
        while (type5 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type5;
            GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
            Class cls2 = genericDeclaration instanceof Class ? (Class) genericDeclaration : null;
            if (cls2 == null) {
                type4 = typeVariable;
            } else {
                Type typeF = f(type, cls, cls2);
                if (typeF instanceof ParameterizedType) {
                    TypeVariable[] typeParameters = cls2.getTypeParameters();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= typeParameters.length) {
                            throw new NoSuchElementException();
                        }
                        if (typeVariable.equals(typeParameters[i2])) {
                            type4 = ((ParameterizedType) typeF).getActualTypeArguments()[i2];
                            break;
                        }
                        i2++;
                    }
                } else {
                    type4 = typeVariable;
                }
            }
            if (type4 == typeVariable) {
                return type4;
            }
            type5 = type4;
        }
        if (type5 instanceof Class) {
            Class cls3 = (Class) type5;
            if (cls3.isArray()) {
                Class<?> componentType = cls3.getComponentType();
                Type typeQ2 = q(type, cls, componentType);
                return componentType == typeQ2 ? cls3 : new T(typeQ2);
            }
        }
        if (type5 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type5;
            Type genericComponentType = genericArrayType.getGenericComponentType();
            Type typeQ3 = q(type, cls, genericComponentType);
            return genericComponentType == typeQ3 ? genericArrayType : new T(typeQ3);
        }
        if (type5 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type5;
            Type ownerType = parameterizedType.getOwnerType();
            Type typeQ4 = q(type, cls, ownerType);
            boolean z2 = typeQ4 != ownerType;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            for (int i3 = 0; i3 < length; i3++) {
                Type typeQ5 = q(type, cls, actualTypeArguments[i3]);
                if (typeQ5 != actualTypeArguments[i3]) {
                    if (!z2) {
                        actualTypeArguments = (Type[]) actualTypeArguments.clone();
                        z2 = true;
                    }
                    actualTypeArguments[i3] = typeQ5;
                }
            }
            return z2 ? new U(typeQ4, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
        }
        if (type5 instanceof WildcardType) {
            wildcardType = (WildcardType) type5;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length == 1) {
                Type typeQ6 = q(type, cls, lowerBounds[0]);
                if (typeQ6 != lowerBounds[0]) {
                    type3 = type5;
                    type3 = wildcardType;
                    return new V(new Type[]{Object.class}, new Type[]{typeQ6});
                }
            } else if (upperBounds.length == 1 && (typeQ = q(type, cls, upperBounds[0])) != upperBounds[0]) {
                type3 = type5;
                type3 = wildcardType;
                type3 = wildcardType;
                return new V(new Type[]{typeQ}, f3829a);
            }
        }
        type3 = type5;
        type3 = wildcardType;
        type3 = wildcardType;
        type3 = type5;
        type3 = wildcardType;
        type3 = type5;
        type3 = wildcardType;
        type3 = type5;
        return type3;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final void r(Throwable th, p040w0.d dVar) {
        C0217v c0217v;
        if (dVar instanceof C0217v) {
            c0217v = (C0217v) dVar;
            int i2 = c0217v.f3861e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c0217v.f3861e = i2 - Integer.MIN_VALUE;
            } else {
                c0217v = new C0217v(dVar);
            }
        } else {
            c0217v = new C0217v(dVar);
        }
        Object obj = c0217v.f3860d;
        int i3 = c0217v.f3861e;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            p029q.j.o(obj);
            throw new C0041m();
        }
        p029q.j.o(obj);
        c0217v.f3861e = 1;
        T0.d dVar2 = N0.C.f385a;
        p040w0.i iVar = c0217v.f4197b;
        F0.i.b(iVar);
        dVar2.u(iVar, new R0.h(c0217v, 1, th));
    }

    public static void s(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    public static String t(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public abstract void a(L l2, Object obj);
}
