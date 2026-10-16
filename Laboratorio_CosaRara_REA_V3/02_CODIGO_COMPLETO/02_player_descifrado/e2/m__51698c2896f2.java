// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f867b;

    public m(long j3, long j4) {
        this.f866a = j3;
        this.f867b = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f866a == mVar.f866a && this.f867b == mVar.f867b;
    }

    public final int hashCode() {
        return Long.hashCode(this.f867b) + (Long.hashCode(this.f866a) * 31);
    }

    public final String toString() {
        StringBuilder sbJ = a0.a.j(this.f866a, "PostControlAnnouncement(revision=", ", announcedAtNs=");
        sbJ.append(this.f867b);
        sbJ.append(")");
        return sbJ.toString();
    }
}
