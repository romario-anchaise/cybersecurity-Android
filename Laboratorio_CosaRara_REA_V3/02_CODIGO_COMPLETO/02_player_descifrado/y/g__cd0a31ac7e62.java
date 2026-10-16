// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5981c;

    public g(int i3, int i4, String str) {
        str.getClass();
        this.f5979a = str;
        this.f5980b = i3;
        this.f5981c = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return q1.e.a(this.f5979a, gVar.f5979a) && this.f5980b == gVar.f5980b && this.f5981c == gVar.f5981c;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f5981c) + ((Integer.hashCode(this.f5980b) + (this.f5979a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "SystemIdInfo(workSpecId=" + this.f5979a + ", generation=" + this.f5980b + ", systemId=" + this.f5981c + ')';
    }
}
