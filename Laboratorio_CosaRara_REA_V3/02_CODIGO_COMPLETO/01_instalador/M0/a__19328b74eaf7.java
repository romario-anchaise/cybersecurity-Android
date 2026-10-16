// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p022m0;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class a implements GenericArrayType, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f3693a;

    public a(Type type) {
        Objects.requireNonNull(type);
        this.f3693a = d.a(type);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && d.e(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f3693a;
    }

    public final int hashCode() {
        return this.f3693a.hashCode();
    }

    public final String toString() {
        return d.k(this.f3693a) + "[]";
    }
}
