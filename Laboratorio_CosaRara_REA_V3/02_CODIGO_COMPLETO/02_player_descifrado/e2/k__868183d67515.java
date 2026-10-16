// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f840c;

    public k(f fVar, l lVar, long j3) {
        this.f838a = fVar;
        this.f839b = lVar;
        this.f840c = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f838a.equals(kVar.f838a) && this.f839b.equals(kVar.f839b) && this.f840c == kVar.f840c;
    }

    public final int hashCode() {
        return Long.hashCode(this.f840c) + ((this.f839b.hashCode() + (this.f838a.hashCode() * 961)) * 31);
    }

    public final String toString() {
        return "FramePreparation(output=" + this.f838a + ", interval=null, processingToken=" + this.f839b + ", captureCallbackStartedNs=" + this.f840c + ")";
    }
}
