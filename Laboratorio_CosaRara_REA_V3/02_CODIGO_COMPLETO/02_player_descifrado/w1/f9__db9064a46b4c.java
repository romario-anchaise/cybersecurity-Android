// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class f9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4018b;

    public f9(String str, long j3) {
        if (j3 < 0 || str == null || str.isEmpty()) {
            o2.i("invalid projection request identity");
            throw null;
        }
        this.f4017a = j3;
        this.f4018b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f9)) {
            return false;
        }
        f9 f9Var = (f9) obj;
        return this.f4017a == f9Var.f4017a && this.f4018b.equals(f9Var.f4018b);
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.f4017a), this.f4018b);
    }
}
