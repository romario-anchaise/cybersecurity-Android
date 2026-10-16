// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import w1.j4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f1023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f1024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f1025f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f1026g;

    public v(long j3, long j4, long j5, long j6, boolean z2, boolean z3, boolean z4) {
        this.f1020a = j3;
        this.f1021b = j4;
        this.f1022c = j5;
        this.f1023d = j6;
        this.f1024e = z2;
        this.f1025f = z3;
        this.f1026g = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f1020a == vVar.f1020a && this.f1021b == vVar.f1021b && this.f1022c == vVar.f1022c && this.f1023d == vVar.f1023d && this.f1024e == vVar.f1024e && this.f1025f == vVar.f1025f && this.f1026g == vVar.f1026g;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f1026g) + ((Boolean.hashCode(this.f1025f) + ((Boolean.hashCode(this.f1024e) + j4.b(j4.b(j4.b(Long.hashCode(this.f1020a) * 31, 31, this.f1021b), 31, this.f1022c), 31, this.f1023d)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sbJ = a0.a.j(this.f1020a, "AccessibilityWebpEncodeQueueStats(submitted=", ", droppedPending=");
        sbJ.append(this.f1021b);
        j4.d(sbJ, ", droppedByControl=", this.f1022c, ", droppedByPriority=");
        sbJ.append(this.f1023d);
        sbJ.append(", active=");
        sbJ.append(this.f1024e);
        sbJ.append(", pending=");
        sbJ.append(this.f1025f);
        sbJ.append(", closed=");
        sbJ.append(this.f1026g);
        sbJ.append(")");
        return sbJ.toString();
    }
}
