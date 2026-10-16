// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p032r0;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Objects;
import p022m0.d;

/* JADX INFO: loaded from: classes.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f4029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f4030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4031c;

    public a() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == a.class) {
                Type typeA = d.a(parameterizedType.getActualTypeArguments()[0]);
                if (!Objects.equals(System.getProperty("gson.allowCapturingTypeVariables"), "true")) {
                    a(typeA);
                }
                this.f4030b = typeA;
                this.f4029a = d.h(typeA);
                this.f4031c = typeA.hashCode();
                return;
            }
        } else if (genericSuperclass == a.class) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("type-token-raw"));
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    public static void a(Type type) {
        if (type instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type;
            throw new IllegalArgumentException("TypeToken type argument must not contain a type variable; captured type variable " + typeVariable.getName() + " declared by " + typeVariable.getGenericDeclaration() + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("typetoken-type-variable"));
        }
        if (type instanceof GenericArrayType) {
            a(((GenericArrayType) type).getGenericComponentType());
            return;
        }
        int i2 = 0;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type ownerType = parameterizedType.getOwnerType();
            if (ownerType != null) {
                a(ownerType);
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            while (i2 < length) {
                a(actualTypeArguments[i2]);
                i2++;
            }
            return;
        }
        if (!(type instanceof WildcardType)) {
            if (type == null) {
                throw new IllegalArgumentException("TypeToken captured `null` as type argument; probably a compiler / runtime bug");
            }
            return;
        }
        WildcardType wildcardType = (WildcardType) type;
        for (Type type2 : wildcardType.getLowerBounds()) {
            a(type2);
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        int length2 = upperBounds.length;
        while (i2 < length2) {
            a(upperBounds[i2]);
            i2++;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            if (d.e(this.f4030b, ((a) obj).f4030b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f4031c;
    }

    public final String toString() {
        return d.k(this.f4030b);
    }

    public a(Type type) {
        Objects.requireNonNull(type);
        Type typeA = d.a(type);
        this.f4030b = typeA;
        this.f4029a = d.h(typeA);
        this.f4031c = typeA.hashCode();
    }
}
