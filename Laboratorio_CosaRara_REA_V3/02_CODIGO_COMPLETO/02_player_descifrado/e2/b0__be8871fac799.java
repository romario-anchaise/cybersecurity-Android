// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import w1.j4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d2 f717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f719d;

    public b0(v vVar, d2 d2Var, long j3, boolean z2) {
        this.f716a = vVar;
        this.f717b = d2Var;
        this.f718c = j3;
        this.f719d = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0)) {
            return false;
        }
        b0 b0Var = (b0) obj;
        return this.f716a.equals(b0Var.f716a) && this.f717b.equals(b0Var.f717b) && this.f718c == b0Var.f718c && this.f719d == b0Var.f719d;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f719d) + j4.b((this.f717b.hashCode() + (this.f716a.hashCode() * 31)) * 31, 31, this.f718c);
    }

    public final String toString() {
        return "AccessibilityWebpSessionStats(encodeQueue=" + this.f716a + ", publisher=" + this.f717b + ", interactionRevision=" + this.f718c + ", closed=" + this.f719d + ")";
    }
}
