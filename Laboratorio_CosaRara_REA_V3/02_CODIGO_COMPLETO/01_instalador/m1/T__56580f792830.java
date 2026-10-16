// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package m1;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public final class T implements GenericArrayType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f3823a;

    public T(Type type) {
        this.f3823a = type;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && W.e(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f3823a;
    }

    public final int hashCode() {
        return this.f3823a.hashCode();
    }

    public final String toString() {
        return W.t(this.f3823a) + "[]";
    }
}
