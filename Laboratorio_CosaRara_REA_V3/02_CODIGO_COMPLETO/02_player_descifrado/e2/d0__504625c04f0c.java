// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f747f;

    public d0(int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f742a = i3;
        this.f743b = i4;
        this.f744c = i5;
        this.f745d = i6;
        this.f746e = i7;
        this.f747f = i8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return this.f742a == d0Var.f742a && this.f743b == d0Var.f743b && this.f744c == d0Var.f744c && this.f745d == d0Var.f745d && this.f746e == d0Var.f746e && this.f747f == d0Var.f747f;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f747f) + ((Integer.hashCode(this.f746e) + ((Integer.hashCode(this.f745d) + ((Integer.hashCode(this.f744c) + ((Integer.hashCode(this.f743b) + (Integer.hashCode(this.f742a) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ContainLayout(outputWidth=" + this.f742a + ", outputHeight=" + this.f743b + ", left=" + this.f744c + ", top=" + this.f745d + ", contentWidth=" + this.f746e + ", contentHeight=" + this.f747f + ")";
    }
}
