// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f3902a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f3903b = Executors.newSingleThreadExecutor(new a2.l(21));

    public static int a(String str, JSONObject jSONObject, boolean z2) {
        if (str == null || str.isEmpty()) {
            return 2;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            boolean zEquals = false;
            if (jSONObject2.optBoolean("ok", false)) {
                if (!z2) {
                    zEquals = jSONObject.optString("eventId", "").equals(jSONObject2.optString("eventId", ""));
                } else if (jSONObject.optString("physicalExitId", "").equals(jSONObject2.optString("physicalExitId", "")) && jSONObject.optString("observationId", "").equals(jSONObject2.optString("observationId", ""))) {
                    zEquals = true;
                }
                if (zEquals) {
                    return 1;
                }
            }
            return jSONObject2.optBoolean("retry", true) ? 2 : 3;
        } catch (JSONException unused) {
            return 2;
        }
    }

    public static synchronized void b(SharedPreferences sharedPreferences, JSONObject jSONObject) {
        if (sharedPreferences != null) {
            d9 d9VarJ0 = n4.j0(sharedPreferences);
            if (n4.I0(d9VarJ0.f3812a, jSONObject)) {
                n4.F0(d9VarJ0, jSONObject.optString("observationId", ""));
                SharedPreferences.Editor editorPutInt = sharedPreferences.edit().putInt("state_version", 5);
                n4.M0(editorPutInt, d9VarJ0, null);
                editorPutInt.commit();
            }
        }
    }

    public static boolean c(JSONObject jSONObject) {
        int iOptInt = jSONObject == null ? 0 : jSONObject.optInt("version", 0);
        return jSONObject != null && (iOptInt == 4 || iOptInt == 5) && jSONObject.optString("eventId", "").startsWith("pexit:") && jSONObject.optString("physicalExitId", "").matches("pexit4:[0-9a-f]{64}") && jSONObject.optString("observationId", "").matches("pexitobs4:[0-9a-f]{64}");
    }

    public static JSONObject d(Context context) {
        String string;
        if (context == null || (string = context.getApplicationContext().getSharedPreferences("process_exit_reporter", 0).getString("latest", "")) == null || string.isEmpty()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            int iOptInt = jSONObject.optInt("version", 1);
            JSONObject jSONObjectPut = new JSONObject().put("version", iOptInt).put("frameFormat", jSONObject.optString("frameFormat", "")).put("buildId", jSONObject.optString("buildId", "")).put("runtimeNamespaceId", jSONObject.optString("runtimeNamespaceId", "")).put("reason", jSONObject.optInt("reason", 0)).put("reasonName", jSONObject.optString("reasonName", "other")).put("timestampMs", jSONObject.optLong("timestampMs", 0L)).put("pssKb", jSONObject.optLong("pssKb", 0L)).put("rssKb", jSONObject.optLong("rssKb", 0L)).put("stackSignature", jSONObject.optString("stackSignature", ""));
            if (iOptInt >= 3) {
                jSONObjectPut.put("status", jSONObject.optInt("status", 0));
                jSONObjectPut.put("importance", jSONObject.optInt("importance", 0));
            }
            if (jSONObject.has("pid")) {
                jSONObjectPut.put("pid", jSONObject.optInt("pid", 0));
            }
            String strOptString = jSONObject.optString("processName", "");
            if (!strOptString.isEmpty()) {
                jSONObjectPut.put("processName", strOptString);
            }
            String strOptString2 = jSONObject.optString("traceStatus", "");
            if (!strOptString2.isEmpty()) {
                jSONObjectPut.put("traceStatus", strOptString2);
            }
            if (iOptInt >= 5) {
                jSONObjectPut.put("versionCode", jSONObject.optInt("versionCode", 0)).put("versionName", jSONObject.optString("versionName", "")).put("stableCoreBehaviorId", jSONObject.optString("stableCoreBehaviorId", "")).put("coreSourceSha256", jSONObject.optString("coreSourceSha256", "")).put("buildProvenance", jSONObject.optString("buildProvenance", "")).put("buildIdentitySource", jSONObject.optString("buildIdentitySource", "")).put("descriptionPresent", jSONObject.optBoolean("descriptionPresent", false)).put("descriptionClass", jSONObject.optString("descriptionClass", "none")).put("guardMatched", jSONObject.optBoolean("guardMatched", false));
                if (jSONObject.optBoolean("guardMatched", false)) {
                    jSONObjectPut.put("guardReason", jSONObject.optString("guardReason", "")).put("guardPolicy", jSONObject.optString("guardPolicy", "")).put("guardDetectedAtMs", jSONObject.optLong("guardDetectedAtMs", 0L));
                }
            }
            return jSONObjectPut;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static int e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return 0;
        }
        int length = jSONObject.optJSONArray("frames") == null ? 0 : jSONObject.optJSONArray("frames").length();
        int i3 = jSONObject.optInt("pid", 0) > 0 ? 1 : 0;
        if (!jSONObject.optString("processName", "").isEmpty()) {
            i3++;
        }
        if (jSONObject.optLong("pssKb", 0L) > 0) {
            i3++;
        }
        if (jSONObject.optLong("rssKb", 0L) > 0) {
            i3++;
        }
        if (jSONObject.optInt("status", 0) != 0) {
            i3++;
        }
        if (jSONObject.optInt("importance", 0) > 0) {
            i3++;
        }
        if (!jSONObject.optString("traceStatus", "").isEmpty()) {
            i3++;
        }
        if (jSONObject.optInt("versionCode", 0) > 0) {
            i3++;
        }
        if (!jSONObject.optString("coreSourceSha256", "").isEmpty()) {
            i3++;
        }
        if (!jSONObject.optString("descriptionClass", "").isEmpty()) {
            i3++;
        }
        if (jSONObject.optBoolean("guardMatched", false)) {
            i3 += 2;
        }
        return (length * 16) + i3;
    }

    public static void f(Context context) {
        if (f3902a.compareAndSet(false, true)) {
            f3903b.execute(new a2.m(context, 13));
        }
    }
}
