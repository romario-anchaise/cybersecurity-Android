// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import w1.j4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f1059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f1060e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f1061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f1062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f1063h;

    public w(long j3, long j4, long j5, boolean z2, b bVar, long j6, boolean z3, boolean z4) {
        this.f1056a = j3;
        this.f1057b = j4;
        this.f1058c = j5;
        this.f1059d = z2;
        this.f1060e = bVar;
        this.f1061f = j6;
        this.f1062g = z3;
        this.f1063h = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f1056a == wVar.f1056a && this.f1057b == wVar.f1057b && this.f1058c == wVar.f1058c && this.f1059d == wVar.f1059d && this.f1060e == wVar.f1060e && this.f1061f == wVar.f1061f && this.f1062g == wVar.f1062g && this.f1063h == wVar.f1063h;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f1063h) + ((Boolean.hashCode(this.f1062g) + j4.b((this.f1060e.hashCode() + ((Boolean.hashCode(this.f1059d) + j4.b(j4.b(Long.hashCode(this.f1056a) * 31, 31, this.f1057b), 31, this.f1058c)) * 31)) * 31, 31, this.f1061f)) * 31);
    }

    public final String toString() {
        StringBuilder sbJ = a0.a.j(this.f1056a, "AccessibilityWebpEncodeTimingSample(capturedAtMs=", ", queueWaitMs=");
        sbJ.append(this.f1057b);
        j4.d(sbJ, ", encodeMs=", this.f1058c, ", success=");
        sbJ.append(this.f1059d);
        sbJ.append(", reason=");
        sbJ.append(this.f1060e);
        sbJ.append(", interactionRevision=");
        sbJ.append(this.f1061f);
        sbJ.append(", published=");
        sbJ.append(this.f1062g);
        sbJ.append(", staleByControlDrop=");
        sbJ.append(this.f1063h);
        sbJ.append(")");
        return sbJ.toString();
    }
}
