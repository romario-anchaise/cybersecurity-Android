// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class d1 implements h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f753f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f754g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f755h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f756i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f757j;

    public d1(long j3, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        str.getClass();
        str6.getClass();
        str9.getClass();
        this.f748a = j3;
        this.f749b = str;
        this.f750c = str2;
        this.f751d = str3;
        this.f752e = str4;
        this.f753f = str5;
        this.f754g = str6;
        this.f755h = str7;
        this.f756i = str8;
        this.f757j = str9;
    }

    @Override // e2.h1
    public final String a() {
        return "rtc.capture.status";
    }

    @Override // e2.h1
    public final long b() {
        return this.f748a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d1)) {
            return false;
        }
        d1 d1Var = (d1) obj;
        return this.f748a == d1Var.f748a && q1.e.a(this.f749b, d1Var.f749b) && this.f750c.equals(d1Var.f750c) && this.f751d.equals(d1Var.f751d) && this.f752e.equals(d1Var.f752e) && this.f753f.equals(d1Var.f753f) && q1.e.a(this.f754g, d1Var.f754g) && this.f755h.equals(d1Var.f755h) && this.f756i.equals(d1Var.f756i) && q1.e.a(this.f757j, d1Var.f757j);
    }

    public final int hashCode() {
        return this.f757j.hashCode() + a0.a.e(a0.a.e(a0.a.e(a0.a.e(a0.a.e(a0.a.e(a0.a.e(a0.a.e(Long.hashCode(this.f748a) * 31, 31, this.f749b), 31, this.f750c), 31, this.f751d), 31, this.f752e), 31, this.f753f), 31, this.f754g), 31, this.f755h), 31, this.f756i);
    }

    public final String toString() {
        return "RtcCaptureStatus(generation=" + this.f748a + ", requestId=" + this.f749b + ", desiredMode=" + this.f750c + ", actualSource=" + this.f751d + ", phase=" + this.f752e + ", reason=" + this.f753f + ", requestedTransport=" + this.f754g + ", actualTransport=" + this.f755h + ", condition=" + this.f756i + ", authorizationPolicy=" + this.f757j + ")";
    }
}
