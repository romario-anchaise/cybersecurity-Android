// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p034t0;

import F0.i;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4127b;

    public d(Object obj, Object obj2) {
        this.f4126a = obj;
        this.f4127b = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return i.a(this.f4126a, dVar.f4126a) && i.a(this.f4127b, dVar.f4127b);
    }

    public final int hashCode() {
        Object obj = this.f4126a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f4127b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f4126a + ", " + this.f4127b + ')';
    }
}
