// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5988b;

    public j(String str, int i3) {
        str.getClass();
        this.f5987a = str;
        this.f5988b = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return q1.e.a(this.f5987a, jVar.f5987a) && this.f5988b == jVar.f5988b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f5988b) + (this.f5987a.hashCode() * 31);
    }

    public final String toString() {
        return "WorkGenerationalId(workSpecId=" + this.f5987a + ", generation=" + this.f5988b + ')';
    }
}
