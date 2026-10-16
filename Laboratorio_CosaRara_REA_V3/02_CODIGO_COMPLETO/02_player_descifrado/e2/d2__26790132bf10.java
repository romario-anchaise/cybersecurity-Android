// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import w1.j4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f763f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f764g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f765h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f766i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f767j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f768k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f769l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f770m;

    public d2(long j3, long j4, long j5, long j6, long j7, boolean z2, boolean z3, long j8, long j9, long j10, long j11, b bVar, long j12) {
        this.f758a = j3;
        this.f759b = j4;
        this.f760c = j5;
        this.f761d = j6;
        this.f762e = j7;
        this.f763f = z2;
        this.f764g = z3;
        this.f765h = j8;
        this.f766i = j9;
        this.f767j = j10;
        this.f768k = j11;
        this.f769l = bVar;
        this.f770m = j12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d2)) {
            return false;
        }
        d2 d2Var = (d2) obj;
        return this.f758a == d2Var.f758a && this.f759b == d2Var.f759b && this.f760c == d2Var.f760c && this.f761d == d2Var.f761d && this.f762e == d2Var.f762e && this.f763f == d2Var.f763f && this.f764g == d2Var.f764g && this.f765h == d2Var.f765h && this.f766i == d2Var.f766i && this.f767j == d2Var.f767j && this.f768k == d2Var.f768k && this.f769l == d2Var.f769l && this.f770m == d2Var.f770m;
    }

    public final int hashCode() {
        int iB = j4.b(j4.b(j4.b(j4.b((Boolean.hashCode(this.f764g) + ((Boolean.hashCode(this.f763f) + j4.b(j4.b(j4.b(j4.b(Long.hashCode(this.f758a) * 31, 31, this.f759b), 31, this.f760c), 31, this.f761d), 31, this.f762e)) * 31)) * 31, 31, this.f765h), 31, this.f766i), 31, this.f767j), 31, this.f768k);
        b bVar = this.f769l;
        return Long.hashCode(this.f770m) + ((iB + (bVar == null ? 0 : bVar.hashCode())) * 31);
    }

    public final String toString() {
        StringBuilder sbJ = a0.a.j(this.f758a, "WebpPublisherStats(submitted=", ", started=");
        sbJ.append(this.f759b);
        j4.d(sbJ, ", succeeded=", this.f760c, ", failed=");
        sbJ.append(this.f761d);
        j4.d(sbJ, ", droppedStale=", this.f762e, ", inFlight=");
        sbJ.append(this.f763f);
        sbJ.append(", pending=");
        sbJ.append(this.f764g);
        sbJ.append(", lastQueueWaitMs=");
        sbJ.append(this.f765h);
        j4.d(sbJ, ", lastSendDurationMs=", this.f766i, ", maxSendDurationMs=");
        sbJ.append(this.f767j);
        j4.d(sbJ, ", droppedByControl=", this.f768k, ", lastReason=");
        sbJ.append(this.f769l);
        sbJ.append(", lastInteractionRevision=");
        sbJ.append(this.f770m);
        sbJ.append(")");
        return sbJ.toString();
    }
}
