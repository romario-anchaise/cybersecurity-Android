// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import w1.j4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class z0 implements h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f1097d;

    public z0(long j3, String str, long j4, long j5) {
        this.f1094a = j3;
        this.f1095b = str;
        this.f1096c = j4;
        this.f1097d = j5;
    }

    @Override // e2.h1
    public final String a() {
        return "lease.update";
    }

    @Override // e2.h1
    public final long b() {
        return this.f1094a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z0)) {
            return false;
        }
        z0 z0Var = (z0) obj;
        return this.f1094a == z0Var.f1094a && this.f1095b.equals(z0Var.f1095b) && this.f1096c == z0Var.f1096c && this.f1097d == z0Var.f1097d;
    }

    public final int hashCode() {
        return Long.hashCode(this.f1097d) + j4.b(a0.a.e(Long.hashCode(this.f1094a) * 31, 31, this.f1095b), 31, this.f1096c);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LeaseUpdate(generation=");
        sb.append(this.f1094a);
        sb.append(", viewerIdentity=");
        sb.append(this.f1095b);
        j4.d(sb, ", leaseEpoch=", this.f1096c, ", expiresAtMs=");
        sb.append(this.f1097d);
        sb.append(")");
        return sb.toString();
    }
}
