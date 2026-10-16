// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p034t0;

import F0.j;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class i implements b, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f4135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f4136b;

    /* JADX WARN: Type inference failed for: r0v2, types: [E0.a, F0.j, java.lang.Object] */
    @Override // p034t0.b
    public final Object getValue() {
        if (this.f4136b == h.f4133c) {
            ?? r1 = this.f4135a;
            F0.i.b(r1);
            this.f4136b = r1.a();
            this.f4135a = null;
        }
        return this.f4136b;
    }

    public final String toString() {
        return this.f4136b != h.f4133c ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
