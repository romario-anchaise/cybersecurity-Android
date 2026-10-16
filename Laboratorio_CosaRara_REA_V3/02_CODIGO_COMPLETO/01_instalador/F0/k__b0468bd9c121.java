// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package F0;

/* JADX INFO: loaded from: classes.dex */
public final class k implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f177a;

    public k(Class cls) {
        this.f177a = cls;
    }

    @Override // F0.d
    public final Class a() {
        return this.f177a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            if (i.a(this.f177a, ((k) obj).f177a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f177a.hashCode();
    }

    public final String toString() {
        return this.f177a.toString() + " (Kotlin reflection is not available)";
    }
}
