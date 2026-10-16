// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p022m0;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ParameterizedType, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f3694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f3695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type[] f3696c;

    public b(Type type, Type type2, Type... typeArr) {
        Objects.requireNonNull(type2);
        if (type == null && (type2 instanceof Class)) {
            Class cls = (Class) type2;
            if (!Modifier.isStatic(cls.getModifiers()) && cls.getDeclaringClass() != null) {
                throw new IllegalArgumentException("Must specify owner type for " + type2);
            }
        }
        this.f3694a = type == null ? null : d.a(type);
        this.f3695b = d.a(type2);
        Type[] typeArr2 = (Type[]) typeArr.clone();
        this.f3696c = typeArr2;
        int length = typeArr2.length;
        for (int i2 = 0; i2 < length; i2++) {
            Objects.requireNonNull(this.f3696c[i2]);
            d.c(this.f3696c[i2]);
            Type[] typeArr3 = this.f3696c;
            typeArr3[i2] = d.a(typeArr3[i2]);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && d.e(this, (ParameterizedType) obj);
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.f3696c.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.f3694a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f3695b;
    }

    public final int hashCode() {
        int iHashCode = Arrays.hashCode(this.f3696c) ^ this.f3695b.hashCode();
        Type type = this.f3694a;
        return iHashCode ^ (type != null ? type.hashCode() : 0);
    }

    public final String toString() {
        Type[] typeArr = this.f3696c;
        int length = typeArr.length;
        Type type = this.f3695b;
        if (length == 0) {
            return d.k(type);
        }
        StringBuilder sb = new StringBuilder((length + 1) * 30);
        sb.append(d.k(type));
        sb.append("<");
        sb.append(d.k(typeArr[0]));
        for (int i2 = 1; i2 < length; i2++) {
            sb.append(", ");
            sb.append(d.k(typeArr[i2]));
        }
        sb.append(">");
        return sb.toString();
    }
}
