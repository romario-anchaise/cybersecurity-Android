// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class s7 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f5055d = Pattern.compile("[A-Za-z0-9._:-]{1,96}");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5058c;

    public s7(int i3, String str, String str2) {
        this.f5056a = i3;
        this.f5057b = str;
        this.f5058c = str2;
    }

    public static s7 b(String str) {
        int iOptInt;
        String strTrim = str.trim();
        if ("watch:nodes:v3".equals(strTrim)) {
            return new s7(1, "force_full", "");
        }
        if (!strTrim.startsWith("nodes:refresh:")) {
            return null;
        }
        String strTrim2 = strTrim.substring(14).trim();
        if (strTrim2.isEmpty() || strTrim2.length() > 4096) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(strTrim2);
            if (jSONObject.optInt("v", 3) != 3) {
                return null;
            }
            String strOptString = jSONObject.optString("mode", "");
            if (!"if_changed".equals(strOptString) && !"force_full".equals(strOptString)) {
                return null;
            }
            String strOptString2 = jSONObject.optString("requestId", "");
            if (f5055d.matcher(strOptString2).matches() && (iOptInt = jSONObject.optInt("deadlineMs", 1000)) >= 0 && iOptInt <= 10000) {
                return new s7(2, strOptString, strOptString2);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String a(String str, boolean z2) {
        try {
            JSONObject jSONObjectPut = new JSONObject().put("ok", z2).put("v", 3).put("kind", "refresh_ack").put("requestId", this.f5058c).put("mode", this.f5057b);
            if (!z2 && !str.isEmpty()) {
                jSONObjectPut.put("error", str);
            }
            return jSONObjectPut.toString();
        } catch (Throwable unused) {
            return z2 ? "{\"ok\":true,\"v\":3,\"kind\":\"refresh_ack\"}" : "{\"ok\":false,\"v\":3,\"kind\":\"refresh_ack\"}";
        }
    }
}
