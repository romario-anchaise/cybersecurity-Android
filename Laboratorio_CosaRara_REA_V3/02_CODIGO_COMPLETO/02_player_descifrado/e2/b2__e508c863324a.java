// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import java.util.List;
import w1.j4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z1 f722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f725d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f726e;

    public b2(z1 z1Var, List list, long j3, b bVar, long j4) {
        list.getClass();
        this.f722a = z1Var;
        this.f723b = list;
        this.f724c = j3;
        this.f725d = bVar;
        this.f726e = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b2)) {
            return false;
        }
        b2 b2Var = (b2) obj;
        return this.f722a.equals(b2Var.f722a) && q1.e.a(this.f723b, b2Var.f723b) && this.f724c == b2Var.f724c && this.f725d == b2Var.f725d && this.f726e == b2Var.f726e;
    }

    public final int hashCode() {
        return Long.hashCode(this.f726e) + ((this.f725d.hashCode() + j4.b((this.f723b.hashCode() + (this.f722a.hashCode() * 31)) * 31, 31, this.f724c)) * 31);
    }

    public final String toString() {
        return "WebpPublishIntent(frame=" + this.f722a + ", packets=" + this.f723b + ", queuedAtNs=" + this.f724c + ", reason=" + this.f725d + ", interactionRevision=" + this.f726e + ")";
    }
}
