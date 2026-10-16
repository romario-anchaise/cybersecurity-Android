// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package v2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f3327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f3329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f3330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f3331f;

    public h(boolean z2, Integer num, boolean z3, Integer num2, boolean z4, boolean z5) {
        this.f3326a = z2;
        this.f3327b = num;
        this.f3328c = z3;
        this.f3329d = num2;
        this.f3330e = z4;
        this.f3331f = z5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f3326a == hVar.f3326a && q1.e.a(this.f3327b, hVar.f3327b) && this.f3328c == hVar.f3328c && q1.e.a(this.f3329d, hVar.f3329d) && this.f3330e == hVar.f3330e && this.f3331f == hVar.f3331f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    public final int hashCode() {
        boolean z2 = this.f3326a;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i3 = r1 * 31;
        Integer num = this.f3327b;
        int iHashCode = (i3 + (num == null ? 0 : num.hashCode())) * 31;
        boolean z3 = this.f3328c;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i4 = (iHashCode + r3) * 31;
        Integer num2 = this.f3329d;
        int iHashCode2 = (i4 + (num2 != null ? num2.hashCode() : 0)) * 31;
        boolean z4 = this.f3330e;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int i5 = (iHashCode2 + r4) * 31;
        boolean z5 = this.f3331f;
        return i5 + (z5 ? 1 : z5);
    }

    public final String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.f3326a + ", clientMaxWindowBits=" + this.f3327b + ", clientNoContextTakeover=" + this.f3328c + ", serverMaxWindowBits=" + this.f3329d + ", serverNoContextTakeover=" + this.f3330e + ", unknownValues=" + this.f3331f + ')';
    }
}
