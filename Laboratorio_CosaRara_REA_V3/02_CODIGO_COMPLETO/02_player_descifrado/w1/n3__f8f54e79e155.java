// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4619c;

    public n3(int i3, int i4, int i5) {
        if (i3 <= 0 || i4 <= 0 || i5 <= 0) {
            o2.i("width, height, and densityDpi must be positive");
            throw null;
        }
        this.f4617a = i3;
        this.f4618b = i4;
        this.f4619c = i5;
    }

    public static int a(float f3, int i3) {
        return Math.min((int) (Math.max(0.0f, Math.min(1.0f, f3)) * i3), i3 - 1);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n3)) {
            return false;
        }
        n3 n3Var = (n3) obj;
        return this.f4617a == n3Var.f4617a && this.f4618b == n3Var.f4618b && this.f4619c == n3Var.f4619c;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f4617a), Integer.valueOf(this.f4618b), Integer.valueOf(this.f4619c));
    }

    public final String toString() {
        return "DisplaySnapshot{width=" + this.f4617a + ", height=" + this.f4618b + ", densityDpi=" + this.f4619c + '}';
    }
}
