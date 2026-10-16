// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z1;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f6310b = new d(new int[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f6311a;

    public d(int[] iArr) {
        this.f6311a = iArr;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            return Arrays.equals(this.f6311a, ((d) obj).f6311a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f6311a);
    }

    public final String toString() {
        return Arrays.toString(this.f6311a);
    }
}
