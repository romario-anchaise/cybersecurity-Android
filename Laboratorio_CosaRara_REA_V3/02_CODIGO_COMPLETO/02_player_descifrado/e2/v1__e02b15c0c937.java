// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class v1 implements h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f1051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f1055e;

    public v1(long j3, String str, String str2, String str3, String str4) {
        this.f1051a = j3;
        this.f1052b = str;
        this.f1053c = str2;
        this.f1054d = str3;
        this.f1055e = str4;
    }

    @Override // e2.h1
    public final String a() {
        return "rtc.start";
    }

    @Override // e2.h1
    public final long b() {
        return this.f1051a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v1)) {
            return false;
        }
        v1 v1Var = (v1) obj;
        return this.f1051a == v1Var.f1051a && this.f1052b.equals(v1Var.f1052b) && this.f1053c.equals(v1Var.f1053c) && this.f1054d.equals(v1Var.f1054d) && this.f1055e.equals(v1Var.f1055e);
    }

    public final int hashCode() {
        return this.f1055e.hashCode() + a0.a.e(a0.a.e(a0.a.e(Long.hashCode(this.f1051a) * 31, 31, this.f1052b), 31, this.f1053c), 31, this.f1054d);
    }

    public final String toString() {
        return "RtcStart(generation=" + this.f1051a + ", token=<redacted>)";
    }
}
