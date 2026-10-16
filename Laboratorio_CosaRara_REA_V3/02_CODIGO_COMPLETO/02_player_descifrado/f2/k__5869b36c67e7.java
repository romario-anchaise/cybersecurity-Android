// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f1219b = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile JSONObject f1220a;

    public static JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectB = b(context, jSONObject2.optString("file"));
        if (jSONObjectB == null) {
            return null;
        }
        String strOptString = jSONObjectB.optString("extends", "");
        if (!TextUtils.isEmpty(strOptString) && jSONObject != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray("profiles")) != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i3);
                if (jSONObjectOptJSONObject != null && strOptString.equals(jSONObjectOptJSONObject.optString("profileId"))) {
                    JSONObject jSONObjectA = a(context, jSONObject, jSONObjectOptJSONObject);
                    if (jSONObjectA == null) {
                        break;
                    }
                    try {
                        JSONObject jSONObject3 = new JSONObject(jSONObjectA.toString());
                        JSONObject jSONObjectOptJSONObject2 = jSONObject3.optJSONObject("steps");
                        if (jSONObjectOptJSONObject2 == null) {
                            jSONObjectOptJSONObject2 = new JSONObject();
                            jSONObject3.put("steps", jSONObjectOptJSONObject2);
                        }
                        JSONObject jSONObjectOptJSONObject3 = jSONObjectB.optJSONObject("steps");
                        if (jSONObjectOptJSONObject3 != null) {
                            Iterator<String> itKeys = jSONObjectOptJSONObject3.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                jSONObjectOptJSONObject2.put(next, jSONObjectOptJSONObject3.get(next));
                            }
                        }
                        if (jSONObjectB.has("profileId")) {
                            jSONObject3.put("profileId", jSONObjectB.get("profileId"));
                        }
                        return jSONObject3;
                    } catch (Exception unused) {
                        break;
                    }
                }
            }
        }
        return jSONObjectB;
    }

    public static JSONObject b(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            String strB = j.b(context, "permission_profiles/" + str);
            if (strB != null) {
                try {
                    return new JSONObject(strB);
                } catch (Exception e3) {
                    StringBuilder sbK = a0.a.k("profile parse failed ", str, ": ");
                    sbK.append(e3.getMessage());
                    Log.w("AuthProfileResolver", sbK.toString());
                    return null;
                }
            }
        }
        return null;
    }

    public static boolean c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return d(str).equals(d(str2));
    }

    public static String d(String str) {
        return str == null ? "" : str.trim().toLowerCase(Locale.ROOT).replace(' ', '_');
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0072  */
    public final y.i e(Context context) {
        String strSubstring;
        String str;
        JSONObject jSONObject = this.f1220a;
        if (jSONObject == null) {
            String strB = j.b(context, "permission_profiles/index.json");
            if (strB == null) {
                jSONObject = new JSONObject();
            } else {
                try {
                    this.f1220a = new JSONObject(strB);
                    jSONObject = this.f1220a;
                } catch (Exception e3) {
                    Log.w("AuthProfileResolver", "index parse failed: " + e3.getMessage());
                    jSONObject = new JSONObject();
                }
            }
        }
        String strD = d(Build.MANUFACTURER);
        String strD2 = d(Build.MODEL);
        if (TextUtils.isEmpty(strD)) {
            strSubstring = strD2;
        } else {
            if (strD2.startsWith(strD + "_")) {
                strSubstring = strD2.substring(strD.length() + 1);
            } else {
                strSubstring = strD2;
            }
        }
        if (!TextUtils.isEmpty(strD)) {
            if (TextUtils.isEmpty(strSubstring)) {
                strSubstring = strD;
            } else {
                strSubstring = strD + "_" + strSubstring;
            }
        }
        JSONObject jSONObject2 = null;
        JSONArray jSONArrayOptJSONArray = jSONObject != null ? jSONObject.optJSONArray("profiles") : null;
        String str2 = "model";
        if (jSONArrayOptJSONArray != null) {
            int i3 = -1;
            int i4 = 0;
            while (i4 < jSONArrayOptJSONArray.length()) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i4);
                if (jSONObjectOptJSONObject == null || !c(jSONObjectOptJSONObject.optString("manufacturer"), strD)) {
                    str = strD;
                } else {
                    if (!jSONObjectOptJSONObject.has("androidSdk") || jSONObjectOptJSONObject.isNull("androidSdk")) {
                        str = strD;
                    } else {
                        str = strD;
                        if (jSONObjectOptJSONObject.optInt("androidSdk") == Build.VERSION.SDK_INT || jSONObjectOptJSONObject.optBoolean("sdkAgnostic", false)) {
                        }
                    }
                    String strOptString = jSONObjectOptJSONObject.optString("model", "");
                    String strOptString2 = jSONObjectOptJSONObject.optString("modelKey", "");
                    if ((TextUtils.isEmpty(strOptString) && TextUtils.isEmpty(strOptString2)) || ((!TextUtils.isEmpty(strOptString) && c(strOptString, strD2)) || (!TextUtils.isEmpty(strOptString2) && c(strOptString2, strSubstring)))) {
                        int i5 = !TextUtils.isEmpty(jSONObjectOptJSONObject.optString("manufacturer")) ? 10 : 0;
                        if (!TextUtils.isEmpty(jSONObjectOptJSONObject.optString("model")) || !TextUtils.isEmpty(jSONObjectOptJSONObject.optString("modelKey"))) {
                            i5 += 100;
                        }
                        if (jSONObjectOptJSONObject.has("androidSdk") && !jSONObjectOptJSONObject.isNull("androidSdk")) {
                            i5 += 1000;
                        }
                        if (jSONObjectOptJSONObject.optBoolean("sdkAgnostic", false) && (!jSONObjectOptJSONObject.has("androidSdk") || jSONObjectOptJSONObject.isNull("androidSdk"))) {
                            i5++;
                        }
                        if (i5 > i3) {
                            i3 = i5;
                            jSONObject2 = jSONObjectOptJSONObject;
                        }
                    }
                }
                i4++;
                strD = str;
            }
        }
        if (jSONObject2 == null) {
            JSONObject jSONObjectB = b(context, "generic_android.json");
            if (jSONObjectB == null) {
                jSONObjectB = new JSONObject();
            }
            return new y.i(jSONObjectB, "generic_android_v1", "generic", "generic_android.json");
        }
        JSONObject jSONObjectA = a(context, jSONObject, jSONObject2);
        if (jSONObjectA == null) {
            jSONObjectA = new JSONObject();
        }
        String strOptString3 = jSONObject2.optString("profileId", jSONObject2.optString("file"));
        boolean z2 = (TextUtils.isEmpty(jSONObject2.optString("model")) && TextUtils.isEmpty(jSONObject2.optString("modelKey"))) ? false : true;
        boolean zIsEmpty = TextUtils.isEmpty(jSONObject2.optString("manufacturer"));
        boolean z3 = jSONObject2.has("androidSdk") && !jSONObject2.isNull("androidSdk");
        if (!zIsEmpty && z2 && z3) {
            str2 = "modelSdk";
        } else if (!zIsEmpty && z2 && jSONObject2.optBoolean("sdkAgnostic", false)) {
            str2 = "modelSdkAgnostic";
        } else if (zIsEmpty || !z2) {
            if (!zIsEmpty && z3) {
                str2 = "brandSdk";
            } else if (zIsEmpty || !jSONObject2.optBoolean("sdkAgnostic", false)) {
                str2 = !zIsEmpty ? "brand" : "generic";
            } else {
                str2 = "brandSdkAgnostic";
            }
        }
        return new y.i(jSONObjectA, strOptString3, str2, jSONObject2.optString("file"));
    }
}
