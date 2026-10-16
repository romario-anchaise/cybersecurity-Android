// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f1982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f1983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f1984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f1985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f1986h;

    public e(String str, String str2, String str3, long j3, long j4, i iVar, String str4, String str5) {
        Objects.requireNonNull(str, "deviceId");
        this.f1979a = str;
        Objects.requireNonNull(str2, "sessionId");
        this.f1980b = str2;
        this.f1981c = str3;
        this.f1982d = j3;
        this.f1983e = j4;
        i iVar2 = new i();
        if (iVar != null) {
            iVar2.f2052a = iVar.f2052a;
        }
        this.f1984f = iVar2;
        Objects.requireNonNull(str4, "controlContinuityCredential");
        this.f1985g = str4;
        Objects.requireNonNull(str5, "controlContinuityAttemptId");
        this.f1986h = str5;
    }
}
