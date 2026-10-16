// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f4127a = Pattern.compile("repi:[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}");

    public static String a(j3 j3Var) {
        long j3 = j3Var.f4306c;
        long j4 = j3Var.f4305b;
        String str = j3Var.f4304a;
        if (!f4127a.matcher(str).matches() || j4 <= 0 || j3 < j4) {
            o2.i("reconnect_episode_close_invalid");
            return null;
        }
        String str2 = "report:reconnect_episode:" + new JSONObject().put("version", 1).put("episodeId", str).put("openedAtMs", j4).put("closedAtMs", j3);
        if (str2.getBytes(StandardCharsets.UTF_8).length <= 4096) {
            return str2;
        }
        o2.i("reconnect_episode_close_too_large");
        return null;
    }

    public static a2.q b(String str, String str2) {
        if (str == null || !str.startsWith("reconnect_episode_ack:") || str.getBytes(StandardCharsets.UTF_8).length > 4096) {
            return a2.q.a();
        }
        JSONObject jSONObject = new JSONObject(str.substring(22));
        if (!str2.equals(jSONObject.optString("episodeId", ""))) {
            return a2.q.a();
        }
        boolean zOptBoolean = jSONObject.optBoolean("accepted", false);
        boolean zOptBoolean2 = jSONObject.has("retryable") ? jSONObject.optBoolean("retryable", true) : true;
        String strOptString = jSONObject.optString("reason", "");
        return zOptBoolean ? new a2.q(strOptString, true, false) : new a2.q(strOptString, false, zOptBoolean2);
    }
}
