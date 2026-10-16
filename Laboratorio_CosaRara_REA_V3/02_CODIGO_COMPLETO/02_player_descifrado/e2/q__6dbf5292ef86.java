// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import w1.j4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d2.o f922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f925d;

    public q(d2.o oVar, long j3, long j4, long j5) {
        oVar.getClass();
        this.f922a = oVar;
        this.f923b = j3;
        this.f924c = j4;
        this.f925d = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return q1.e.a(this.f922a, qVar.f922a) && this.f923b == qVar.f923b && this.f924c == qVar.f924c && this.f925d == qVar.f925d;
    }

    public final int hashCode() {
        return Long.hashCode(this.f925d) + j4.b(j4.b(this.f922a.hashCode() * 31, 31, this.f923b), 31, this.f924c);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("WakeupScheduleAction(scheduler=");
        sb.append(this.f922a);
        sb.append(", token=");
        sb.append(this.f923b);
        j4.d(sb, ", generation=", this.f924c, ", delayNs=");
        sb.append(this.f925d);
        sb.append(")");
        return sb.toString();
    }
}
