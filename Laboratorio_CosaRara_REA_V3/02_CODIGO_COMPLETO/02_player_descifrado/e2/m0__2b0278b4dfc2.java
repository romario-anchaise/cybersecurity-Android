// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f869b;

    public m0(int i3, int i4) {
        this.f868a = i3;
        this.f869b = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        return this.f868a == m0Var.f868a && this.f869b == m0Var.f869b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f869b) + (Integer.hashCode(this.f868a) * 31);
    }

    public final String toString() {
        return "DisplayTarget(width=" + this.f868a + ", height=" + this.f869b + ")";
    }
}
