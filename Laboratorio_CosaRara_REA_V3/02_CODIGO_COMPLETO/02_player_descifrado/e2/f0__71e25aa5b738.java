// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f796c;

    public f0(boolean z2, int i3, float f3) {
        this.f794a = z2;
        this.f795b = i3;
        this.f796c = f3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return this.f794a == f0Var.f794a && this.f795b == f0Var.f795b && Float.compare(this.f796c, f0Var.f796c) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f796c) + ((Integer.hashCode(this.f795b) + (Boolean.hashCode(this.f794a) * 31)) * 31);
    }

    public final String toString() {
        return "State(active=" + this.f794a + ", opacity=" + this.f795b + ", gain=" + this.f796c + ")";
    }

    public /* synthetic */ f0() {
        this(false, 0, 1.0f);
    }
}
