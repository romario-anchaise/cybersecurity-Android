// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import w1.j4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q1 f958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y1 f960c;

    public r1(q1 q1Var, long j3, y1 y1Var) {
        q1Var.getClass();
        this.f958a = q1Var;
        this.f959b = j3;
        this.f960c = y1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r1)) {
            return false;
        }
        r1 r1Var = (r1) obj;
        return this.f958a == r1Var.f958a && this.f959b == r1Var.f959b && q1.e.a(this.f960c, r1Var.f960c);
    }

    public final int hashCode() {
        int iB = j4.b(this.f958a.hashCode() * 31, 31, this.f959b);
        y1 y1Var = this.f960c;
        return iB + (y1Var == null ? 0 : y1Var.hashCode());
    }

    public final String toString() {
        return "Detached(source=" + this.f958a + ", projectionGeneration=" + this.f959b + ", webp=" + this.f960c + ")";
    }
}
