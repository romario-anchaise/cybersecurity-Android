// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c1 implements h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f735e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f736f;

    public c1(long j3, String str, String str2, String str3, boolean z2, String str4) {
        this.f731a = j3;
        this.f732b = str;
        this.f733c = str2;
        this.f734d = str3;
        this.f735e = z2;
        this.f736f = str4;
    }

    @Override // e2.h1
    public final String a() {
        return "rtc.capture.set";
    }

    @Override // e2.h1
    public final long b() {
        return this.f731a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c1)) {
            return false;
        }
        c1 c1Var = (c1) obj;
        return this.f731a == c1Var.f731a && this.f732b.equals(c1Var.f732b) && this.f733c.equals(c1Var.f733c) && this.f734d.equals(c1Var.f734d) && this.f735e == c1Var.f735e && this.f736f.equals(c1Var.f736f);
    }

    public final int hashCode() {
        return this.f736f.hashCode() + ((Boolean.hashCode(this.f735e) + a0.a.e(a0.a.e(a0.a.e(Long.hashCode(this.f731a) * 31, 31, this.f732b), 31, this.f733c), 31, this.f734d)) * 31);
    }

    public final String toString() {
        return "RtcCaptureSet(generation=" + this.f731a + ", requestId=" + this.f732b + ", mode=" + this.f733c + ", transport=" + this.f734d + ", transportSpecified=" + this.f735e + ", authorizationPolicy=" + this.f736f + ")";
    }
}
