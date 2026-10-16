// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f5975b;

    public d(String str, Long l3) {
        this.f5974a = str;
        this.f5975b = l3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f5974a.equals(dVar.f5974a) && this.f5975b.equals(dVar.f5975b);
    }

    public final int hashCode() {
        return this.f5975b.hashCode() + (this.f5974a.hashCode() * 31);
    }

    public final String toString() {
        return "Preference(key=" + this.f5974a + ", value=" + this.f5975b + ')';
    }
}
