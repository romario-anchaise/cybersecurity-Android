// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f700b;

    public /* synthetic */ a(n nVar, p pVar, int i3) {
        this((i3 & 1) != 0 ? null : nVar, (i3 & 4) != 0 ? new p((g) null, 3) : pVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return q1.e.a(this.f699a, aVar.f699a) && q1.e.a(null, null) && q1.e.a(this.f700b, aVar.f700b);
    }

    public final int hashCode() {
        n nVar = this.f699a;
        return this.f700b.hashCode() + ((nVar == null ? 0 : nVar.hashCode()) * 961);
    }

    public final String toString() {
        return "CapturePlan(request=" + this.f699a + ", interval=" + ((Object) null) + ", wakeup=" + this.f700b + ")";
    }

    public a(n nVar, p pVar) {
        pVar.getClass();
        this.f699a = nVar;
        this.f700b = pVar;
    }
}
