// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package u;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3248d;

    public a(boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f3245a = z2;
        this.f3246b = z3;
        this.f3247c = z4;
        this.f3248d = z5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f3245a == aVar.f3245a && this.f3246b == aVar.f3246b && this.f3247c == aVar.f3247c && this.f3248d == aVar.f3248d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    public final int hashCode() {
        boolean z2 = this.f3245a;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i3 = r1 * 31;
        boolean z3 = this.f3246b;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i4 = (i3 + r3) * 31;
        boolean z4 = this.f3247c;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int i5 = (i4 + r4) * 31;
        boolean z5 = this.f3248d;
        return i5 + (z5 ? 1 : z5);
    }

    public final String toString() {
        return "NetworkState(isConnected=" + this.f3245a + ", isValidated=" + this.f3246b + ", isMetered=" + this.f3247c + ", isNotRoaming=" + this.f3248d + ')';
    }
}
