// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f5035a = Collections.unmodifiableList(Arrays.asList("breach_type", "breach_ts", "recovery_ts", "downtime_ms", "foreground_pkg", "last_heartbeat_ts", "device_model", "device_brand", "device_manufacturer", "android_version", "versionCode", "versionName", "legacy_app_version", "delivery_version", "supersedes_event_id", "settingsMasterEnabled", "settingsServiceListed", "accessibilityEverEnabled", "foregroundPackage", "foregroundLabel", "foregroundObservedAgeMs", "foregroundIsAccessibilitySettings", "screenInteractive", "keyguardLocked", "packageFirstInstallAtMs", "packageLastUpdateAtMs"));

    public static int a(String str) {
        if (str == null) {
            return 0;
        }
        return str.codePointCount(0, str.length());
    }

    public static String b(List list, boolean z2) {
        if (list == null || list.isEmpty()) {
            throw new w0.t("batch items empty");
        }
        if (list.size() > 20) {
            throw new w0.t("batch exceeds 20 items");
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e0 e0Var = (e0) it.next();
            if (e0Var == null) {
                throw new w0.t("event is null");
            }
            String str = e0Var.f3839h;
            long j3 = e0Var.f3837f;
            String str2 = e0Var.f3833b;
            String str3 = e0Var.f3834c;
            String str4 = e0Var.f3835d;
            String str5 = e0Var.f3838g;
            String str6 = e0Var.f3836e;
            if (!j(str2)) {
                throw new w0.t("event id invalid");
            }
            if (!j(str4)) {
                throw new w0.t("transition id invalid");
            }
            if (!str6.isEmpty() && (!j(str6) || !str4.equals(str6))) {
                throw new w0.t("episode id invalid");
            }
            if (!"a11y_lost".equals(str3) && !"a11y_unbind".equals(str3) && !"a11y_reenabled".equals(str3) && !"security_breach".equals(str3)) {
                throw new w0.t("event kind invalid");
            }
            if (j3 <= 0) {
                throw new w0.t("observedAtMs must be positive");
            }
            if (a(str5) > 64 || c(str5)) {
                throw new w0.t("source too long");
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() > 32) {
                    throw new w0.t("too many detail keys");
                }
                Iterator<String> itKeys = jSONObject.keys();
                while (true) {
                    String strValueOf = "";
                    if (itKeys.hasNext()) {
                        String next = itKeys.next();
                        Object objOpt = jSONObject.opt(next);
                        if (objOpt != null && objOpt != JSONObject.NULL) {
                            strValueOf = String.valueOf(objOpt);
                        }
                        if (next == null || next.isEmpty() || a(next) > 64 || a(strValueOf) > 2048 || c(next) || c(strValueOf)) {
                            throw new w0.t("detail key/value invalid");
                        }
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", str2);
                jSONObject2.put("kind", str3);
                if (z2) {
                    jSONObject2.put("transitionId", str4);
                    if (!str6.isEmpty()) {
                        jSONObject2.put("episodeId", str6);
                    }
                } else {
                    if (!str6.isEmpty()) {
                        str4 = str6;
                    }
                    jSONObject2.put("episodeId", str4);
                }
                jSONObject2.put("observedAtMs", j3);
                if (!str5.isEmpty()) {
                    jSONObject2.put("source", str5);
                }
                JSONObject jSONObject3 = new JSONObject(str);
                JSONObject jSONObject4 = new JSONObject();
                ArrayList arrayList = new ArrayList();
                Iterator<String> itKeys2 = jSONObject3.keys();
                while (itKeys2.hasNext()) {
                    arrayList.add(itKeys2.next());
                }
                Collections.sort(arrayList);
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    String str7 = (String) obj;
                    Object objOpt2 = jSONObject3.opt(str7);
                    jSONObject4.put(str7, (objOpt2 == null || objOpt2 == JSONObject.NULL) ? "" : String.valueOf(objOpt2));
                }
                if (jSONObject4.length() > 0) {
                    jSONObject2.put("detail", jSONObject4);
                }
                jSONArray.put(jSONObject2);
            } catch (Exception e3) {
                throw new w0.t("detail JSON invalid", e3);
            }
        }
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("items", jSONArray);
        String str8 = "report:a11y_event_batch:" + jSONObject5;
        int length = str8.getBytes(StandardCharsets.UTF_8).length;
        if (length <= 16384) {
            return str8;
        }
        throw new r(j4.c(length, "batch is ", " bytes; max=16384"));
    }

    public static boolean c(String str) {
        if (str == null) {
            return false;
        }
        int iCharCount = 0;
        while (iCharCount < str.length()) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (Character.getType(iCodePointAt) == 15) {
                return true;
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return false;
    }

    public static String d(String str) {
        return str == null ? "" : i(f(str), 64);
    }

    public static m2.b e(String str) {
        if (!str.startsWith("a11y_event_ack:")) {
            o2.i("invalid a11y_event_ack prefix");
            return null;
        }
        if (str.getBytes(StandardCharsets.UTF_8).length > 16384) {
            o2.i("a11y_event_ack exceeds byte limit");
            return null;
        }
        JSONObject jSONObject = new JSONObject(str.substring(15));
        boolean zOptBoolean = jSONObject.optBoolean("accepted", false);
        boolean zOptBoolean2 = jSONObject.optBoolean("retry", false);
        int iOptInt = jSONObject.optInt("saved", 0);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ids");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                String strOptString = jSONArrayOptJSONArray.optString(i3, "");
                if (j(strOptString)) {
                    arrayList.add(strOptString);
                }
            }
        }
        return new m2.b(zOptBoolean, zOptBoolean2, iOptInt, Collections.unmodifiableList(arrayList));
    }

    public static String f(String str) {
        if (str == null || !c(str)) {
            return str == null ? "" : str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        int iCharCount = 0;
        while (iCharCount < str.length()) {
            int iCodePointAt = str.codePointAt(iCharCount);
            sb.appendCodePoint(Character.getType(iCodePointAt) == 15 ? 32 : iCodePointAt);
            iCharCount += Character.charCount(iCodePointAt);
        }
        return sb.toString();
    }

    public static LinkedHashMap g(JSONObject jSONObject) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            arrayList.add(itKeys.next());
        }
        Collections.sort(arrayList);
        arrayList.sort(Comparator.comparingInt(new q(0)).thenComparing(new d2.i(1)));
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            String str = (String) obj;
            if (linkedHashMap.size() >= 32) {
                break;
            }
            String strValueOf = "";
            String strI = str == null ? "" : i(f(str).trim(), 64);
            if (!strI.isEmpty() && !linkedHashMap.containsKey(strI)) {
                Object objOpt = jSONObject.opt(str);
                if (objOpt != null && objOpt != JSONObject.NULL) {
                    strValueOf = String.valueOf(objOpt);
                }
                linkedHashMap.put(strI, i(f(strValueOf), 2048));
            }
        }
        return linkedHashMap;
    }

    public static JSONObject h(LinkedHashMap linkedHashMap) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    public static String i(String str, int i3) {
        if (str == null || i3 <= 0) {
            return "";
        }
        return a(str) <= i3 ? str : str.substring(0, str.offsetByCodePoints(0, i3));
    }

    public static boolean j(String str) {
        return (str == null || str.isEmpty() || a(str) > 64 || c(str)) ? false : true;
    }
}
