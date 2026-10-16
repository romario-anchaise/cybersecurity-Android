// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class U implements ParameterizedType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f3824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f3825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type[] f3826c;

    public U(Type type, Type type2, Type... typeArr) {
        if (type2 instanceof Class) {
            if ((type == null) != (((Class) type2).getEnclosingClass() == null)) {
                throw new IllegalArgumentException();
            }
        }
        for (Type type3 : typeArr) {
            Objects.requireNonNull(type3, "typeArgument == null");
            W.d(type3);
        }
        this.f3824a = type;
        this.f3825b = type2;
        this.f3826c = (Type[]) typeArr.clone();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && W.e(this, (ParameterizedType) obj);
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.f3826c.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.f3824a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f3825b;
    }

    public final int hashCode() {
        int iHashCode = Arrays.hashCode(this.f3826c) ^ this.f3825b.hashCode();
        Type type = this.f3824a;
        return iHashCode ^ (type != null ? type.hashCode() : 0);
    }

    public final String toString() {
        Type[] typeArr = this.f3826c;
        int length = typeArr.length;
        Type type = this.f3825b;
        if (length == 0) {
            return W.t(type);
        }
        StringBuilder sb = new StringBuilder((typeArr.length + 1) * 30);
        sb.append(W.t(type));
        sb.append("<");
        sb.append(W.t(typeArr[0]));
        for (int i2 = 1; i2 < typeArr.length; i2++) {
            sb.append(", ");
            sb.append(W.t(typeArr[i2]));
        }
        sb.append(">");
        return sb.toString();
    }
}
