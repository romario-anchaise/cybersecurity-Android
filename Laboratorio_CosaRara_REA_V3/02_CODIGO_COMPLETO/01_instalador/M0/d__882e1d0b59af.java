// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p022m0;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Type[] f3699a = new Type[0];

    public static Type a(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new a(a(cls.getComponentType())) : cls;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new a(((GenericArrayType) type).getGenericComponentType());
        }
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
    }

    public static void b(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static void c(Type type) {
        b(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
    }

    public static void d(String str) {
        if (str.length() <= 10000) {
            return;
        }
        throw new NumberFormatException("Number string too large: " + str.substring(0, 30) + "...");
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
            return Objects.equals(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
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
        return Objects.equals(typeVariable.getGenericDeclaration(), typeVariable2.getGenericDeclaration()) && typeVariable.getName().equals(typeVariable2.getName());
    }

    public static void f(List list) {
        Iterator it = list.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    public static Type g(Type type, Class cls, Class cls2) {
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
                    return g(cls.getGenericInterfaces()[i2], interfaces[i2], cls2);
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
                    return g(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Class h(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            b(rawType instanceof Class);
            return (Class) rawType;
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
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
    }

    public static BigDecimal i(String str) {
        d(str);
        BigDecimal bigDecimal = new BigDecimal(str);
        if (Math.abs(bigDecimal.scale()) < 10000) {
            return bigDecimal;
        }
        throw new NumberFormatException("Number has unsupported scale: ".concat(str));
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0030  */
    /* JADX WARN: Code duplicated, block: B:42:0x0085  */
    /* JADX WARN: Code duplicated, block: B:44:0x0089  */
    /* JADX WARN: Code duplicated, block: B:47:0x009b  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:52:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:60:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:66:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:68:0x0102  */
    /* JADX WARN: Code duplicated, block: B:69:0x0109  */
    /* JADX WARN: Code duplicated, block: B:71:0x011a  */
    /* JADX WARN: Code duplicated, block: B:77:0x012b  */
    /* JADX WARN: Code duplicated, block: B:78:0x0132  */
    /* JADX WARN: Code duplicated, block: B:93:0x00d5 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.lang.Object, java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r11v17, types: [java.lang.reflect.Type[]] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.reflect.WildcardType] */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v3, types: [m0.c] */
    /* JADX WARN: Type inference failed for: r11v4, types: [m0.c] */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.reflect.ParameterizedType] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.reflect.GenericArrayType] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r4v5 */
    public static Type j(Type type, Class cls, Type type2, HashMap map) {
        Type[] lowerBounds;
        Type[] upperBounds;
        Type typeJ;
        Type[] upperBounds2;
        Type typeJ2;
        Type[] lowerBounds2;
        Type typeJ3;
        boolean z2;
        Type[] actualTypeArguments;
        int length;
        Type bVar;
        Type typeJ4;
        Type genericComponentType;
        Type typeJ5;
        TypeVariable typeVariable;
        TypeVariable typeVariable2 = null;
        do {
            if (!(type2 instanceof TypeVariable)) {
                if (!(type2 instanceof Class)) {
                    if (type2 instanceof GenericArrayType) {
                        if (type2 instanceof ParameterizedType) {
                            if (type2 instanceof WildcardType) {
                                break;
                            }
                            type2 = (WildcardType) type2;
                            lowerBounds = type2.getLowerBounds();
                            upperBounds = type2.getUpperBounds();
                            if (lowerBounds.length == 1) {
                                if (upperBounds.length != 1) {
                                    break;
                                }
                                if (typeJ instanceof WildcardType) {
                                    upperBounds2 = ((WildcardType) typeJ).getUpperBounds();
                                } else {
                                    upperBounds2 = new Type[]{typeJ};
                                }
                                type2 = new c(upperBounds2, f3699a);
                                break;
                            }
                            typeJ2 = j(type, cls, lowerBounds[0], map);
                            if (typeJ2 != lowerBounds[0]) {
                                break;
                            }
                            if (typeJ2 instanceof WildcardType) {
                                lowerBounds2 = ((WildcardType) typeJ2).getLowerBounds();
                            } else {
                                lowerBounds2 = new Type[]{typeJ2};
                            }
                            type2 = new c(new Type[]{Object.class}, lowerBounds2);
                            break;
                        }
                        type2 = (ParameterizedType) type2;
                        Type ownerType = type2.getOwnerType();
                        typeJ3 = j(type, cls, ownerType, map);
                        z2 = !Objects.equals(typeJ3, ownerType);
                        actualTypeArguments = type2.getActualTypeArguments();
                        length = actualTypeArguments.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            typeJ4 = j(type, cls, actualTypeArguments[i2], map);
                            if (Objects.equals(typeJ4, actualTypeArguments[i2])) {
                                if (!z2) {
                                    actualTypeArguments = (Type[]) actualTypeArguments.clone();
                                    z2 = true;
                                }
                                actualTypeArguments[i2] = typeJ4;
                            }
                        }
                        if (z2) {
                            break;
                        }
                        bVar = new b(typeJ3, type2.getRawType(), actualTypeArguments);
                        type2 = bVar;
                        break;
                    }
                    type2 = (GenericArrayType) type2;
                    genericComponentType = type2.getGenericComponentType();
                    typeJ5 = j(type, cls, genericComponentType, map);
                    if (Objects.equals(genericComponentType, typeJ5)) {
                        bVar = new a(typeJ5);
                        type2 = bVar;
                        break;
                    }
                    break;
                }
                Class cls2 = (Class) type2;
                if (!cls2.isArray()) {
                    if (type2 instanceof GenericArrayType) {
                        if (type2 instanceof ParameterizedType) {
                            if (type2 instanceof WildcardType) {
                                break;
                            }
                            type2 = (WildcardType) type2;
                            lowerBounds = type2.getLowerBounds();
                            upperBounds = type2.getUpperBounds();
                            if (lowerBounds.length == 1) {
                                if (upperBounds.length != 1 && (typeJ = j(type, cls, upperBounds[0], map)) != upperBounds[0]) {
                                    if (typeJ instanceof WildcardType) {
                                        upperBounds2 = ((WildcardType) typeJ).getUpperBounds();
                                    } else {
                                        upperBounds2 = new Type[]{typeJ};
                                    }
                                    type2 = new c(upperBounds2, f3699a);
                                    break;
                                }
                                break;
                                break;
                            }
                            typeJ2 = j(type, cls, lowerBounds[0], map);
                            if (typeJ2 != lowerBounds[0]) {
                                break;
                            }
                            if (typeJ2 instanceof WildcardType) {
                                lowerBounds2 = ((WildcardType) typeJ2).getLowerBounds();
                            } else {
                                lowerBounds2 = new Type[]{typeJ2};
                            }
                            type2 = new c(new Type[]{Object.class}, lowerBounds2);
                            break;
                        }
                        type2 = (ParameterizedType) type2;
                        Type ownerType2 = type2.getOwnerType();
                        typeJ3 = j(type, cls, ownerType2, map);
                        z2 = !Objects.equals(typeJ3, ownerType2);
                        actualTypeArguments = type2.getActualTypeArguments();
                        length = actualTypeArguments.length;
                        while (i2 < length) {
                            typeJ4 = j(type, cls, actualTypeArguments[i2], map);
                            if (Objects.equals(typeJ4, actualTypeArguments[i2])) {
                                if (!z2) {
                                    actualTypeArguments = (Type[]) actualTypeArguments.clone();
                                    z2 = true;
                                }
                                actualTypeArguments[i2] = typeJ4;
                            }
                        }
                        if (z2) {
                            break;
                        }
                        bVar = new b(typeJ3, type2.getRawType(), actualTypeArguments);
                        type2 = bVar;
                        break;
                    }
                    type2 = (GenericArrayType) type2;
                    genericComponentType = type2.getGenericComponentType();
                    typeJ5 = j(type, cls, genericComponentType, map);
                    if (Objects.equals(genericComponentType, typeJ5)) {
                        break;
                    }
                    bVar = new a(typeJ5);
                    type2 = bVar;
                    break;
                }
                Class<?> componentType = cls2.getComponentType();
                Type typeJ6 = j(type, cls, componentType, map);
                if (!Objects.equals(componentType, typeJ6)) {
                    bVar = new a(typeJ6);
                    type2 = bVar;
                    break;
                }
                type2 = cls2;
                break;
            }
            typeVariable = (TypeVariable) type2;
            Type type3 = (Type) map.get(typeVariable);
            if (type3 != null) {
                return type3 == Void.TYPE ? type2 : type3;
            }
            map.put(typeVariable, Void.TYPE);
            if (typeVariable2 == null) {
                typeVariable2 = typeVariable;
            }
            GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
            Class cls3 = genericDeclaration instanceof Class ? (Class) genericDeclaration : null;
            if (cls3 == null) {
                type2 = typeVariable;
            } else {
                Type typeG = g(type, cls, cls3);
                if (typeG instanceof ParameterizedType) {
                    TypeVariable[] typeParameters = cls3.getTypeParameters();
                    int length2 = typeParameters.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length2) {
                            throw new NoSuchElementException();
                        }
                        if (typeVariable.equals(typeParameters[i3])) {
                            type2 = ((ParameterizedType) typeG).getActualTypeArguments()[i3];
                            break;
                        }
                        i3++;
                    }
                } else {
                    type2 = typeVariable;
                }
            }
        } while (type2 != typeVariable);
        if (typeVariable2 != null) {
            map.put(typeVariable2, type2);
        }
        return type2;
    }

    public static String k(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
