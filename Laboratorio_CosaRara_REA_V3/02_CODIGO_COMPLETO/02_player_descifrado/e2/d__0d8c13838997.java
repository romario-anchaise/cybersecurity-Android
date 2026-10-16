// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f741b;

    public d(int i3, int i4) {
        this.f740a = i3;
        this.f741b = i4;
        if (i3 <= 0 || i4 <= 0) {
            o2.i("Failed requirement.");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f740a == dVar.f740a && this.f741b == dVar.f741b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f741b) + (Integer.hashCode(this.f740a) * 31);
    }

    public final String toString() {
        return "CaptureTarget(width=" + this.f740a + ", height=" + this.f741b + ")";
    }
}
