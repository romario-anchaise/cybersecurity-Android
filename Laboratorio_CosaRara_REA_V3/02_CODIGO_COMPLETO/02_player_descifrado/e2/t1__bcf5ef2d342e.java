// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class t1 implements h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1002b;

    public t1(String str, long j3) {
        this.f1001a = j3;
        this.f1002b = str;
    }

    @Override // e2.h1
    public final String a() {
        return "rtc.refresh-token";
    }

    @Override // e2.h1
    public final long b() {
        return this.f1001a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t1)) {
            return false;
        }
        t1 t1Var = (t1) obj;
        return this.f1001a == t1Var.f1001a && this.f1002b.equals(t1Var.f1002b);
    }

    public final int hashCode() {
        return this.f1002b.hashCode() + (Long.hashCode(this.f1001a) * 31);
    }

    public final String toString() {
        return "RtcRefreshToken(generation=" + this.f1001a + ", token=<redacted>)";
    }
}
