// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p034t0;

import E0.a;
import F0.i;
import F0.j;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class g implements b, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f4129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f4130b = h.f4133c;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4131c = this;

    /* JADX WARN: Multi-variable type inference failed */
    public g(a aVar) {
        this.f4129a = (j) aVar;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [E0.a, F0.j, java.lang.Object] */
    @Override // p034t0.b
    public final Object getValue() {
        Object objA;
        Object obj = this.f4130b;
        h hVar = h.f4133c;
        if (obj != hVar) {
            return obj;
        }
        synchronized (this.f4131c) {
            objA = this.f4130b;
            if (objA == hVar) {
                ?? r1 = this.f4129a;
                i.b(r1);
                objA = r1.a();
                this.f4130b = objA;
                this.f4129a = null;
            }
        }
        return objA;
    }

    public final String toString() {
        return this.f4130b != h.f4133c ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
