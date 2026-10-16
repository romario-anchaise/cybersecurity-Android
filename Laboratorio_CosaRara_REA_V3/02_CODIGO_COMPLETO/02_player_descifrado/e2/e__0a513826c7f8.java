// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import w1.j4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f777g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f779i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f780j;

    public e(long j3, b bVar, long j4, long j5, long j6, boolean z2, long j7, long j8, long j9, long j10) {
        this.f771a = j3;
        this.f772b = bVar;
        this.f773c = j4;
        this.f774d = j5;
        this.f775e = j6;
        this.f776f = z2;
        this.f777g = j7;
        this.f778h = j8;
        this.f779i = j9;
        this.f780j = j10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f771a == eVar.f771a && this.f772b == eVar.f772b && this.f773c == eVar.f773c && this.f774d == eVar.f774d && this.f775e == eVar.f775e && this.f776f == eVar.f776f && this.f777g == eVar.f777g && this.f778h == eVar.f778h && this.f779i == eVar.f779i && this.f780j == eVar.f780j;
    }

    public final int hashCode() {
        return Long.hashCode(this.f780j) + j4.b(j4.b(j4.b((Boolean.hashCode(this.f776f) + j4.b(j4.b(j4.b((this.f772b.hashCode() + (Long.hashCode(this.f771a) * 31)) * 31, 31, this.f773c), 31, this.f774d), 31, this.f775e)) * 31, 31, this.f777g), 31, this.f778h), 31, this.f779i);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CaptureTimingSample(requestId=");
        sb.append(this.f771a);
        sb.append(", reason=");
        sb.append(this.f772b);
        j4.d(sb, ", interactionRevision=", this.f773c, ", requestWaitMs=");
        sb.append(this.f774d);
        j4.d(sb, ", controlToRequestWaitMs=", this.f775e, ", staleByControlDrop=");
        sb.append(this.f776f);
        sb.append(", takeScreenshotCallbackMs=");
        sb.append(this.f777g);
        j4.d(sb, ", captureHandoffMs=", this.f778h, ", sinkConvertPushMs=");
        sb.append(this.f779i);
        sb.append(", totalRequestToPushMs=");
        sb.append(this.f780j);
        sb.append(")");
        return sb.toString();
    }
}
