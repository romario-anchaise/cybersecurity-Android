// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f3590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f3591g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f3592h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f3593i;

    public b9(int i3, int i4, long j3, String str, String str2, String str3, String str4, String str5, String str6) {
        this.f3585a = Math.max(0L, j3);
        this.f3586b = (i3 <= 0 || i3 > 4194304) ? 0 : i3;
        this.f3587c = c9.g(str);
        this.f3588d = Math.max(0, i4);
        this.f3589e = n4.a(str2);
        this.f3590f = n4.a(str3);
        this.f3591g = n4.e(str4);
        this.f3592h = n4.a(str5);
        this.f3593i = n4.e(str6);
    }

    public static b9 a(JSONObject jSONObject) {
        if (jSONObject.optInt("version", 0) != 1) {
            return null;
        }
        long jOptLong = jSONObject.optLong("startedAtMs", 0L);
        b9 b9Var = new b9(jSONObject.optInt("pid", 0), jSONObject.optInt("versionCode", 0), jOptLong, jSONObject.optString("processName", ""), jSONObject.optString("versionName", ""), jSONObject.optString("stableCoreBehaviorId", ""), jSONObject.optString("coreSourceSha256", ""), jSONObject.optString("buildProvenance", ""), jSONObject.optString("buildId", ""));
        if (b9Var.f3585a <= 0 || b9Var.f3586b <= 0 || b9Var.f3587c.isEmpty() || b9Var.f3588d <= 0 || b9Var.f3593i.isEmpty()) {
            return null;
        }
        return b9Var;
    }
}
