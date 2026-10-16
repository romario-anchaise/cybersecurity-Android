// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import w1.j4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f898e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f899f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f900g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f901h;

    public n(long j3, long j4, b bVar, long j5, long j6, long j7, long j8, long j9) {
        this.f894a = j3;
        this.f895b = j4;
        this.f896c = bVar;
        this.f897d = j5;
        this.f898e = j6;
        this.f899f = j7;
        this.f900g = j8;
        this.f901h = j9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f894a == nVar.f894a && this.f895b == nVar.f895b && this.f896c == nVar.f896c && this.f897d == nVar.f897d && this.f898e == nVar.f898e && this.f899f == nVar.f899f && this.f900g == nVar.f900g && this.f901h == nVar.f901h;
    }

    public final int hashCode() {
        return Long.hashCode(this.f901h) + j4.b(j4.b(j4.b(j4.b((this.f896c.hashCode() + j4.b(Long.hashCode(this.f894a) * 31, 31, this.f895b)) * 31, 31, this.f897d), 31, this.f898e), 31, this.f899f), 31, this.f900g);
    }

    public final String toString() {
        StringBuilder sbJ = a0.a.j(this.f894a, "RequestAction(requestId=", ", generation=");
        sbJ.append(this.f895b);
        sbJ.append(", reason=");
        sbJ.append(this.f896c);
        j4.d(sbJ, ", interactionRevision=", this.f897d, ", pendingSinceNs=");
        sbJ.append(this.f898e);
        j4.d(sbJ, ", requestWaitMs=", this.f899f, ", controlToRequestWaitMs=");
        sbJ.append(this.f900g);
        sbJ.append(", requestStartNs=");
        sbJ.append(this.f901h);
        sbJ.append(")");
        return sbJ.toString();
    }
}
