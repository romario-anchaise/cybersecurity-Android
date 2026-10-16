// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4770b;

    public p0(int i3, int i4) {
        this.f4769a = i3;
        this.f4770b = i4;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof p0)) {
            return false;
        }
        p0 p0Var = (p0) obj;
        return this.f4769a == p0Var.f4769a && this.f4770b == p0Var.f4770b;
    }

    public final int hashCode() {
        return (this.f4769a * 31) + this.f4770b;
    }
}
