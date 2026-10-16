// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import w1.j4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class y0 implements h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1088c;

    public y0(long j3, long j4, String str) {
        this.f1086a = j3;
        this.f1087b = j4;
        this.f1088c = str;
    }

    @Override // e2.h1
    public final String a() {
        return "lease.clear";
    }

    @Override // e2.h1
    public final long b() {
        return this.f1086a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y0)) {
            return false;
        }
        y0 y0Var = (y0) obj;
        return this.f1086a == y0Var.f1086a && this.f1087b == y0Var.f1087b && this.f1088c.equals(y0Var.f1088c);
    }

    public final int hashCode() {
        return this.f1088c.hashCode() + j4.b(Long.hashCode(this.f1086a) * 31, 31, this.f1087b);
    }

    public final String toString() {
        StringBuilder sbJ = a0.a.j(this.f1086a, "LeaseClear(generation=", ", leaseEpoch=");
        sbJ.append(this.f1087b);
        sbJ.append(", reason=");
        sbJ.append(this.f1088c);
        sbJ.append(")");
        return sbJ.toString();
    }
}
