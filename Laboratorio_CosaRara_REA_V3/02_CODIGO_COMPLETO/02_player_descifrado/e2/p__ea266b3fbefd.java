// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f915b;

    public /* synthetic */ p(g gVar, int i3) {
        this((i3 & 1) != 0 ? null : gVar, (q) null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return q1.e.a(this.f914a, pVar.f914a) && q1.e.a(this.f915b, pVar.f915b);
    }

    public final int hashCode() {
        g gVar = this.f914a;
        int iHashCode = (gVar == null ? 0 : gVar.hashCode()) * 31;
        q qVar = this.f915b;
        return iHashCode + (qVar != null ? qVar.hashCode() : 0);
    }

    public final String toString() {
        return "WakeupActions(cancel=" + this.f914a + ", schedule=" + this.f915b + ")";
    }

    public p(g gVar, q qVar) {
        this.f914a = gVar;
        this.f915b = qVar;
    }
}
