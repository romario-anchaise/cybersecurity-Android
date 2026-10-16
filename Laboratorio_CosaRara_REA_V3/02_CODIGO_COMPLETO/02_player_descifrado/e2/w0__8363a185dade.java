// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import w1.j4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f1064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m0 f1065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f1067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f1068e;

    public w0(f fVar, m0 m0Var, long j3, long j4, long j5) {
        fVar.getClass();
        this.f1064a = fVar;
        this.f1065b = m0Var;
        this.f1066c = j3;
        this.f1067d = j4;
        this.f1068e = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w0)) {
            return false;
        }
        w0 w0Var = (w0) obj;
        return q1.e.a(this.f1064a, w0Var.f1064a) && this.f1065b.equals(w0Var.f1065b) && this.f1066c == w0Var.f1066c && this.f1067d == w0Var.f1067d && this.f1068e == w0Var.f1068e;
    }

    public final int hashCode() {
        return Long.hashCode(this.f1068e) + j4.b(j4.b((this.f1065b.hashCode() + (this.f1064a.hashCode() * 31)) * 31, 31, this.f1066c), 31, this.f1067d);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EncodeJob(frame=");
        sb.append(this.f1064a);
        sb.append(", target=");
        sb.append(this.f1065b);
        sb.append(", capturedAtMs=");
        sb.append(this.f1066c);
        j4.d(sb, ", queuedAtNs=", this.f1067d, ", generation=");
        sb.append(this.f1068e);
        sb.append(")");
        return sb.toString();
    }
}
