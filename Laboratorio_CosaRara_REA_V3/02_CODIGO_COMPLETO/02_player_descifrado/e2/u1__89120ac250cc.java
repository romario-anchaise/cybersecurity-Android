// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f1018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f1019e;

    public u1(int i3, String str, long j3, long j4, long j5) {
        this.f1015a = i3;
        this.f1016b = str;
        this.f1017c = j3;
        this.f1018d = j4;
        this.f1019e = j5;
    }

    public final String a() {
        int i3 = this.f1015a;
        try {
            return new JSONObject().put("mode", a0.a.c(i3)).put("reason", this.f1016b).put("since_ms", this.f1017c).put("trial_started_ms", this.f1018d).put("trial_health_started_ms", this.f1019e).toString();
        } catch (JSONException unused) {
            return "{\"mode\":\"" + a0.a.c(i3) + "\"}";
        }
    }
}
