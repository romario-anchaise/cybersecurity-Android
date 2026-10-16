// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t0 f1013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1014c;

    public u0(long j3, t0 t0Var, long j4) {
        t0Var.getClass();
        this.f1012a = j3;
        this.f1013b = t0Var;
        this.f1014c = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u0)) {
            return false;
        }
        u0 u0Var = (u0) obj;
        return this.f1012a == u0Var.f1012a && q1.e.a(this.f1013b, u0Var.f1013b) && this.f1014c == u0Var.f1014c;
    }

    public final int hashCode() {
        return Long.hashCode(this.f1014c) + ((this.f1013b.hashCode() + (Long.hashCode(this.f1012a) * 31)) * 31);
    }

    public final String toString() {
        return "ReservedSend(id=" + this.f1012a + ", raw=" + this.f1013b + ", startedAtNs=" + this.f1014c + ")";
    }
}
