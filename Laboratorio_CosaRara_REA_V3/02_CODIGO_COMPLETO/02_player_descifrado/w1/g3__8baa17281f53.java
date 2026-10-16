// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f4071a = Pattern.compile("repi:[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f4072b = Pattern.compile("dinc:[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}");

    public static String a(JSONObject jSONObject, long j3) throws JSONException {
        Charset charset;
        if (jSONObject == null) {
            o2.i("disconnect incident missing");
            return null;
        }
        JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
        Object objOpt = jSONObject2.opt("cleanup");
        boolean z2 = (objOpt instanceof Boolean) && ((Boolean) objOpt).booleanValue();
        String strOptString = jSONObject2.optString("supersedesEventId", "");
        if ((objOpt != null && !(objOpt instanceof Boolean)) || z2 != f4072b.matcher(strOptString).matches() || (!z2 && jSONObject2.has("supersedesEventId"))) {
            o2.i("disconnect_incident_cleanup_invalid");
            return null;
        }
        int iOptInt = jSONObject2.optInt("version", 1);
        if (iOptInt == 2) {
            String strOptString2 = jSONObject2.optString("reconnectInstabilityEpisodeId", "");
            long jOptLong = jSONObject2.optLong("episodeOpenedAtMs", 0L);
            long jOptLong2 = jSONObject2.optLong("occurredAtMs", 0L);
            if (!f4071a.matcher(strOptString2).matches() || jOptLong <= 0 || jOptLong > jOptLong2) {
                o2.i("disconnect_incident_episode_invalid");
                return null;
            }
        } else if (iOptInt == 1 && (jSONObject2.has("reconnectInstabilityEpisodeId") || jSONObject2.has("episodeOpenedAtMs"))) {
            o2.i("disconnect_incident_v1_episode_invalid");
            return null;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("events");
        if (jSONArrayOptJSONArray == null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONObject2.put("events", jSONArrayOptJSONArray);
        }
        int iMax = Math.max(0, jSONObject2.optInt("omittedCount", 0));
        while (jSONArrayOptJSONArray.length() > 64) {
            jSONArrayOptJSONArray.remove(0);
            iMax++;
        }
        if (j3 > 0) {
            jSONObject2.put("droppedCount", j3);
        } else {
            jSONObject2.remove("droppedCount");
        }
        if (iMax > 0) {
            jSONObject2.put("eventsTruncated", true);
            jSONObject2.put("omittedCount", iMax);
        } else {
            jSONObject2.remove("eventsTruncated");
            jSONObject2.remove("omittedCount");
        }
        String str = "report:disconnect_incident:" + jSONObject2;
        while (true) {
            charset = StandardCharsets.UTF_8;
            if (str.getBytes(charset).length <= 16384 || jSONArrayOptJSONArray.length() <= 1) {
                break;
            }
            jSONArrayOptJSONArray.remove(0);
            iMax++;
            if (iMax > 0) {
                jSONObject2.put("eventsTruncated", true);
                jSONObject2.put("omittedCount", iMax);
            } else {
                jSONObject2.remove("eventsTruncated");
                jSONObject2.remove("omittedCount");
            }
            str = "report:disconnect_incident:" + jSONObject2;
        }
        if (str.getBytes(charset).length <= 16384) {
            return str;
        }
        o2.i("disconnect_incident_too_large");
        return null;
    }

    public static a2.q b(String str, String str2) {
        if (str == null || !str.startsWith("disconnect_incident_ack:")) {
            return a2.q.a();
        }
        if (str.getBytes(StandardCharsets.UTF_8).length > 16384) {
            return a2.q.a();
        }
        JSONObject jSONObject = new JSONObject(str.substring(24));
        String strOptString = jSONObject.optString("eventId", "");
        if (str2 == null || !str2.equals(strOptString)) {
            return a2.q.a();
        }
        boolean zOptBoolean = jSONObject.optBoolean("accepted", false);
        boolean zOptBoolean2 = jSONObject.has("retryable") ? jSONObject.optBoolean("retryable", true) : true;
        String strOptString2 = jSONObject.optString("reason", "");
        return zOptBoolean ? new a2.q(strOptString2, true, false) : new a2.q(strOptString2, false, zOptBoolean2);
    }
}
