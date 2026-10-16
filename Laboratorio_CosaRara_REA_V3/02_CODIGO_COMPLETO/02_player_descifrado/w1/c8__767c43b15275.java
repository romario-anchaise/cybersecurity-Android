// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f3667d;

    public c8(long j3, long j4, int i3, long j5) {
        this.f3664a = j3;
        this.f3665b = j4;
        this.f3666c = i3;
        this.f3667d = j5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c8)) {
            return false;
        }
        c8 c8Var = (c8) obj;
        return this.f3664a == c8Var.f3664a && this.f3665b == c8Var.f3665b && this.f3666c == c8Var.f3666c && this.f3667d == c8Var.f3667d;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.f3664a), Long.valueOf(this.f3665b), Integer.valueOf(this.f3666c), Long.valueOf(this.f3667d));
    }
}
