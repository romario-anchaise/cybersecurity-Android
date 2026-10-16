// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f782b;

    public e0(int i3, int i4) {
        this.f781a = i3;
        this.f782b = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return this.f781a == e0Var.f781a && this.f782b == e0Var.f782b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f782b) + (Integer.hashCode(this.f781a) * 31);
    }

    public final String toString() {
        return "ContainedSize(width=" + this.f781a + ", height=" + this.f782b + ")";
    }
}
