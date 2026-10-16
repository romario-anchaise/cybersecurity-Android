// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package s1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f3236f = new c(1, 0, 1);

    @Override // s1.a
    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        if (isEmpty() && ((c) obj).isEmpty()) {
            return true;
        }
        c cVar = (c) obj;
        return this.f3229c == cVar.f3229c && this.f3230d == cVar.f3230d;
    }

    @Override // s1.a
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f3229c * 31) + this.f3230d;
    }

    @Override // s1.a
    public final boolean isEmpty() {
        return this.f3229c > this.f3230d;
    }

    @Override // s1.a
    public final String toString() {
        return this.f3229c + ".." + this.f3230d;
    }
}
