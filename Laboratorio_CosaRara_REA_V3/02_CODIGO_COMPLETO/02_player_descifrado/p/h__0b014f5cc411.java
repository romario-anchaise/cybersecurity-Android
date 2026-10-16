// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class h extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f2848a = e.f2842c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        return this.f2848a.equals(((h) obj).f2848a);
    }

    public final int hashCode() {
        return this.f2848a.hashCode() + (h.class.getName().hashCode() * 31);
    }

    public final String toString() {
        return "Failure {mOutputData=" + this.f2848a + '}';
    }
}
