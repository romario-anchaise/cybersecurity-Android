// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5997b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return q1.e.a(this.f5996a, nVar.f5996a) && this.f5997b == nVar.f5997b;
    }

    public final int hashCode() {
        return g.d.a(this.f5997b) + (this.f5996a.hashCode() * 31);
    }

    public final String toString() {
        return "IdAndState(id=" + this.f5996a + ", state=" + a0.a.B(this.f5997b) + ')';
    }
}
