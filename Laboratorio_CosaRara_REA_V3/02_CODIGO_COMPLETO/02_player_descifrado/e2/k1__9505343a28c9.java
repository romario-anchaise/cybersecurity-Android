// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f848b;

    public k1(g gVar, g gVar2) {
        this.f847a = gVar;
        this.f848b = gVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k1)) {
            return false;
        }
        k1 k1Var = (k1) obj;
        return q1.e.a(this.f847a, k1Var.f847a) && q1.e.a(this.f848b, k1Var.f848b);
    }

    public final int hashCode() {
        g gVar = this.f847a;
        int iHashCode = (gVar == null ? 0 : gVar.hashCode()) * 31;
        g gVar2 = this.f848b;
        return iHashCode + (gVar2 != null ? gVar2.hashCode() : 0);
    }

    public final String toString() {
        return "PendingTimers(retry=" + this.f847a + ", firstFrame=" + this.f848b + ")";
    }
}
