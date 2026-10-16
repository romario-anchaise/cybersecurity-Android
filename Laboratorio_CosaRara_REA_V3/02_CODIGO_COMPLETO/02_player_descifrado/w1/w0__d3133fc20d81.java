// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f5367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f5369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f5370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f5371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f5372h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f5373i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f5374j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f5375k;

    /* JADX WARN: Code duplicated, block: B:14:0x0020  */
    /* JADX WARN: Code duplicated, block: B:20:0x0033  */
    /* JADX WARN: Code duplicated, block: B:23:0x003e  */
    /* JADX WARN: Code duplicated, block: B:24:0x0040  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x0060  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x0072  */
    public w0(String str, String str2, long j3, int i3, String str3, String str4, String str5, String str6, String str7, int i4, String str8) {
        String lowerCase;
        String lowerCase2;
        if (str != null) {
            if (!x0.f5481a.contains(str)) {
            }
            this.f5365a = str;
            this.f5366b = (str2 == null && x0.f5482b.contains(str2)) ? str2 : "";
            this.f5367c = Math.max(0L, j3);
            this.f5368d = (i3 > 0 || i3 > 4194304) ? 0 : i3;
            this.f5369e = c9.g(str3);
            if (str4 == null) {
                lowerCase = "";
            } else {
                lowerCase = str4.trim().toLowerCase(Locale.ROOT);
            }
            this.f5370f = lowerCase.matches("^[a-f0-9]{64}$") ? lowerCase : "";
            this.f5371g = x0.a(str5, 64);
            if (str6 == null) {
                lowerCase2 = "";
            } else {
                lowerCase2 = str6.trim().toLowerCase(Locale.ROOT);
            }
            this.f5372h = lowerCase2.matches("^[a-f0-9]{64}$") ? lowerCase2 : "";
            this.f5373i = x0.a(str7, 16);
            this.f5374j = Math.max(0, i4);
            this.f5375k = x0.a(str8, 64);
        }
        List list = x0.f5481a;
        str = "";
        this.f5365a = str;
        this.f5366b = (str2 == null && x0.f5482b.contains(str2)) ? str2 : "";
        this.f5367c = Math.max(0L, j3);
        this.f5368d = (i3 > 0 || i3 > 4194304) ? 0 : i3;
        this.f5369e = c9.g(str3);
        if (str4 == null) {
            lowerCase = "";
        } else {
            lowerCase = str4.trim().toLowerCase(Locale.ROOT);
        }
        this.f5370f = lowerCase.matches("^[a-f0-9]{64}$") ? lowerCase : "";
        this.f5371g = x0.a(str5, 64);
        if (str6 == null) {
            lowerCase2 = "";
        } else {
            lowerCase2 = str6.trim().toLowerCase(Locale.ROOT);
        }
        this.f5372h = lowerCase2.matches("^[a-f0-9]{64}$") ? lowerCase2 : "";
        this.f5373i = x0.a(str7, 16);
        this.f5374j = Math.max(0, i4);
        this.f5375k = x0.a(str8, 64);
    }

    public static w0 a(JSONObject jSONObject) {
        if (jSONObject.optInt("version", 0) != 1) {
            return null;
        }
        w0 w0Var = new w0(jSONObject.optString("reason", ""), jSONObject.optString("policy", ""), jSONObject.optLong("detectedAtMs", 0L), jSONObject.optInt("pid", 0), jSONObject.optString("processName", ""), jSONObject.optString("buildId", ""), jSONObject.optString("stableCoreBehaviorId", ""), jSONObject.optString("coreSourceSha256", ""), jSONObject.optString("buildProvenance", ""), jSONObject.optInt("versionCode", 0), jSONObject.optString("versionName", ""));
        if (w0Var.f5365a.isEmpty() || w0Var.f5366b.isEmpty() || w0Var.f5367c <= 0) {
            return null;
        }
        return w0Var;
    }

    public final JSONObject b() {
        return new JSONObject().put("version", 1).put("reason", this.f5365a).put("policy", this.f5366b).put("detectedAtMs", this.f5367c).put("pid", this.f5368d).put("processName", this.f5369e).put("buildId", this.f5370f).put("stableCoreBehaviorId", this.f5371g).put("coreSourceSha256", this.f5372h).put("buildProvenance", this.f5373i).put("versionCode", this.f5374j).put("versionName", this.f5375k);
    }
}
