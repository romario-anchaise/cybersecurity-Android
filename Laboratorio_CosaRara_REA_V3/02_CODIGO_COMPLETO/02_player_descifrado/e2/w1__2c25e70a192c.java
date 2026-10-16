// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class w1 implements h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1070b;

    public w1(String str, long j3) {
        this.f1069a = j3;
        this.f1070b = str;
    }

    @Override // e2.h1
    public final String a() {
        return "rtc.stop";
    }

    @Override // e2.h1
    public final long b() {
        return this.f1069a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w1)) {
            return false;
        }
        w1 w1Var = (w1) obj;
        return this.f1069a == w1Var.f1069a && this.f1070b.equals(w1Var.f1070b);
    }

    public final int hashCode() {
        return this.f1070b.hashCode() + (Long.hashCode(this.f1069a) * 31);
    }

    public final String toString() {
        return "RtcStop(generation=" + this.f1069a + ", reason=" + this.f1070b + ")";
    }
}
