// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z1 f902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f904c;

    public n0(z1 z1Var, b bVar, long j3) {
        this.f902a = z1Var;
        this.f903b = bVar;
        this.f904c = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return this.f902a.equals(n0Var.f902a) && this.f903b == n0Var.f903b && this.f904c == n0Var.f904c;
    }

    public final int hashCode() {
        return Long.hashCode(this.f904c) + ((this.f903b.hashCode() + (this.f902a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "EncodedWebpFrame(frame=" + this.f902a + ", reason=" + this.f903b + ", interactionRevision=" + this.f904c + ")";
    }
}
