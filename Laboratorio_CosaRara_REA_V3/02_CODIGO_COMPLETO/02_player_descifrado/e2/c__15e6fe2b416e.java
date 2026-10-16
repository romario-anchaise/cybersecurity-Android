// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f728b;

    public c(b bVar, long j3) {
        this.f727a = bVar;
        this.f728b = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f727a == cVar.f727a && this.f728b == cVar.f728b;
    }

    public final int hashCode() {
        return Long.hashCode(this.f728b) + (this.f727a.hashCode() * 31);
    }

    public final String toString() {
        return "CaptureRequest(reason=" + this.f727a + ", interactionRevision=" + this.f728b + ")";
    }
}
