// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h1;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f1946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f1947d;

    public b(Serializable serializable, Object obj) {
        this.f1946c = serializable;
        this.f1947d = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return q1.e.a(this.f1946c, bVar.f1946c) && q1.e.a(this.f1947d, bVar.f1947d);
    }

    public final int hashCode() {
        Object obj = this.f1946c;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f1947d;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f1946c + ", " + this.f1947d + ')';
    }
}
