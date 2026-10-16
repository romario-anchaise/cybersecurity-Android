// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f3126a;

    public g(Class cls) {
        this.f3126a = cls;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            return this.f3126a.equals(((g) obj).f3126a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3126a.hashCode();
    }

    public final String toString() {
        return this.f3126a + " (Kotlin reflection is not available)";
    }
}
