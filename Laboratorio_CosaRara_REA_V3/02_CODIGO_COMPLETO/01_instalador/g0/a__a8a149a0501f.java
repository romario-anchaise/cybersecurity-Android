// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g0;

/* JADX INFO: loaded from: classes.dex */
public final class a extends f1.d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f2738m;

    public a(int i2) {
        this.f2738m = i2;
        if (i2 <= 0) {
            throw new IllegalArgumentException("px must be > 0.");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            if (this.f2738m == ((a) obj).f2738m) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2738m;
    }

    public final String toString() {
        return String.valueOf(this.f2738m);
    }
}
