// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n0 f999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1000b;

    public t0(n0 n0Var, long j3) {
        n0Var.getClass();
        this.f999a = n0Var;
        this.f1000b = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t0)) {
            return false;
        }
        t0 t0Var = (t0) obj;
        return q1.e.a(this.f999a, t0Var.f999a) && this.f1000b == t0Var.f1000b;
    }

    public final int hashCode() {
        return Long.hashCode(this.f1000b) + (this.f999a.hashCode() * 31);
    }

    public final String toString() {
        return "RawIntent(encoded=" + this.f999a + ", queuedAtNs=" + this.f1000b + ")";
    }
}
