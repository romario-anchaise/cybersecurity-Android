// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* JADX INFO: loaded from: classes.dex */
public final class V implements WildcardType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f3827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f3828b;

    public V(Type[] typeArr, Type[] typeArr2) {
        if (typeArr2.length > 1) {
            throw new IllegalArgumentException();
        }
        if (typeArr.length != 1) {
            throw new IllegalArgumentException();
        }
        if (typeArr2.length != 1) {
            typeArr[0].getClass();
            W.d(typeArr[0]);
            this.f3828b = null;
            this.f3827a = typeArr[0];
            return;
        }
        typeArr2[0].getClass();
        W.d(typeArr2[0]);
        if (typeArr[0] != Object.class) {
            throw new IllegalArgumentException();
        }
        this.f3828b = typeArr2[0];
        this.f3827a = Object.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && W.e(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.f3828b;
        return type != null ? new Type[]{type} : W.f3829a;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.f3827a};
    }

    public final int hashCode() {
        Type type = this.f3828b;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.f3827a.hashCode() + 31);
    }

    public final String toString() {
        Type type = this.f3828b;
        if (type != null) {
            return "? super " + W.t(type);
        }
        Type type2 = this.f3827a;
        if (type2 == Object.class) {
            return "?";
        }
        return "? extends " + W.t(type2);
    }
}
