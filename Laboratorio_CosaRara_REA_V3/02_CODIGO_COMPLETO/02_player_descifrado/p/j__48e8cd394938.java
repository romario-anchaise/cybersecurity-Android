// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class j extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f2849a;

    public j(e eVar) {
        this.f2849a = eVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        return this.f2849a.equals(((j) obj).f2849a);
    }

    public final int hashCode() {
        return this.f2849a.hashCode() + (j.class.getName().hashCode() * 31);
    }

    public final String toString() {
        return "Success {mOutputData=" + this.f2849a + '}';
    }
}
