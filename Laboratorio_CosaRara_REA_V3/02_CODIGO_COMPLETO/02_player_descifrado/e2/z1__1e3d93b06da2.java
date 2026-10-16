// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import java.util.Arrays;
import w1.j4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f1102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f1103f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f1104g;

    public z1(long j3, long j4, int i3, int i4, long j5, long j6, byte[] bArr) {
        this.f1098a = j3;
        this.f1099b = j4;
        this.f1100c = i3;
        this.f1101d = i4;
        this.f1102e = j5;
        this.f1103f = j6;
        this.f1104g = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z1)) {
            return false;
        }
        z1 z1Var = (z1) obj;
        return this.f1098a == z1Var.f1098a && this.f1099b == z1Var.f1099b && this.f1100c == z1Var.f1100c && this.f1101d == z1Var.f1101d && this.f1102e == z1Var.f1102e && this.f1103f == z1Var.f1103f && this.f1104g.equals(z1Var.f1104g);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f1104g) + j4.b(j4.b((Integer.hashCode(this.f1101d) + ((Integer.hashCode(this.f1100c) + j4.b(Long.hashCode(this.f1098a) * 31, 31, this.f1099b)) * 31)) * 31, 31, this.f1102e), 31, this.f1103f);
    }

    public final String toString() {
        return "WebpFrame(epoch=" + h1.d.a(this.f1098a) + ", frameSequence=" + this.f1099b + ", width=" + this.f1100c + ", height=" + this.f1101d + ", capturedAtMs=" + h1.d.a(this.f1102e) + ", encodeDurationMs=" + this.f1103f + ", webp=" + Arrays.toString(this.f1104g) + ")";
    }
}
