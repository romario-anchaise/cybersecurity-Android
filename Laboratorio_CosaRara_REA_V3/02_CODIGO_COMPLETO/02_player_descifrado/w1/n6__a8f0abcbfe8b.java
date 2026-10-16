// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class n6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f4636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4637d;

    public n6(int i3, String str, boolean z2, boolean z3) {
        this.f4634a = i3;
        this.f4635b = z2;
        this.f4636c = z3;
        this.f4637d = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n6)) {
            return false;
        }
        n6 n6Var = (n6) obj;
        return this.f4634a == n6Var.f4634a && this.f4635b == n6Var.f4635b && this.f4636c == n6Var.f4636c && this.f4637d.equals(n6Var.f4637d);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f4634a), Boolean.valueOf(this.f4635b), Boolean.valueOf(this.f4636c), this.f4637d);
    }
}
