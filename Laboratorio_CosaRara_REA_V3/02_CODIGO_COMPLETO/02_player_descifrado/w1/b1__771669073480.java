// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f3540a;

    public /* synthetic */ b1(SharedPreferences sharedPreferences) {
        this.f3540a = sharedPreferences;
    }

    public static b1 b(Context context) {
        Context applicationContext = context != null ? context.getApplicationContext() : null;
        if (applicationContext != null) {
            try {
                applicationContext = applicationContext.createDeviceProtectedStorageContext();
            } catch (Throwable unused) {
            }
        }
        if (applicationContext != null) {
            return new b1(applicationContext.getSharedPreferences("injection_rules", 0));
        }
        o2.k("no_context");
        return null;
    }

    public synchronized String a(String str) {
        long jOptLong;
        try {
            JSONObject jSONObject = new JSONObject(str);
            jOptLong = jSONObject.optLong("revision", 0L);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("rules");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
            }
            HashSet hashSet = new HashSet();
            for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i3);
                if (jSONObjectOptJSONObject != null) {
                    hashSet.add(jSONObjectOptJSONObject.optString("ruleId", ""));
                }
            }
            SharedPreferences.Editor editorEdit = null;
            for (String str2 : this.f3540a.getAll().keySet()) {
                if (str2.startsWith("state_") && !hashSet.contains(str2.substring(6))) {
                    if (editorEdit == null) {
                        editorEdit = this.f3540a.edit();
                    }
                    editorEdit.remove(str2);
                }
            }
            if (editorEdit == null) {
                editorEdit = this.f3540a.edit();
            }
            editorEdit.putString("rules_json", jSONArrayOptJSONArray.toString()).putLong("revision", jOptLong).apply();
            Log.i("InjectionRuleStore", "sync applied revision=" + jOptLong + " rules=" + jSONArrayOptJSONArray.length());
        } catch (Throwable th) {
            Log.w("InjectionRuleStore", "sync apply failed: " + th.getMessage());
            return "{\"ok\":false,\"error\":\"invalid_sync_payload\"}";
        }
        return "{\"ok\":true,\"revision\":" + jOptLong + "}";
    }

    public synchronized void c(String str) {
        p4 p4VarF = f(str);
        if (p4VarF == null) {
            return;
        }
        p4VarF.f4800y = "fulfilled";
        h(p4VarF);
    }

    public void d(p4 p4Var) {
        try {
            String string = this.f3540a.getString("state_" + p4Var.f4777a, "");
            if (string.isEmpty()) {
                return;
            }
            JSONObject jSONObject = new JSONObject(string);
            p4Var.f4800y = jSONObject.optString("status", "armed");
            p4Var.f4801z = jSONObject.optInt("shownCount", 0);
            p4Var.A = jSONObject.optLong("lastShownAtMs", 0L);
            p4Var.B = jSONObject.optInt("unlockCycle", -1);
        } catch (Throwable unused) {
        }
    }

    public d0.d e() {
        SharedPreferences sharedPreferences = this.f3540a;
        long j3 = sharedPreferences.getLong("revision", 1L);
        long j4 = j3 > 0 ? j3 : 1L;
        String string = sharedPreferences.getString("snapshot", "");
        if (string == null || string.isEmpty()) {
            return new d0.d(j4, (c1) null);
        }
        try {
            c1 c1VarB = d1.b(new JSONObject(string));
            return new d0.d(j4, new c1(c1VarB.f3643a, c1VarB.f3644b, c1VarB.f3645c, c1VarB.f3646d, c1VarB.f3647e, sharedPreferences.getInt("package_sequence", 0), sharedPreferences.getLong("elapsed_at_sync", 0L)));
        } catch (Exception unused) {
            return new d0.d(j4, (c1) null);
        }
    }

    public synchronized p4 f(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                ArrayList arrayListG = g();
                int size = arrayListG.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayListG.get(i3);
                    i3++;
                    p4 p4Var = (p4) obj;
                    if (str.equals(p4Var.f4777a)) {
                        return p4Var;
                    }
                }
                return null;
            }
        }
        return null;
    }

    public synchronized ArrayList g() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(this.f3540a.getString("rules_json", "[]"));
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i3);
                if (jSONObjectOptJSONObject != null) {
                    p4 p4VarA = p4.a(jSONObjectOptJSONObject);
                    if (!p4VarA.f4777a.isEmpty()) {
                        d(p4VarA);
                        arrayList.add(p4VarA);
                    }
                }
            }
        } catch (Throwable th) {
            Log.w("InjectionRuleStore", "rules parse failed: " + th.getMessage());
        }
        arrayList.sort(new j1(1));
        return arrayList;
    }

    public void h(p4 p4Var) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", p4Var.f4800y);
            jSONObject.put("shownCount", p4Var.f4801z);
            jSONObject.put("lastShownAtMs", p4Var.A);
            jSONObject.put("unlockCycle", p4Var.B);
            this.f3540a.edit().putString("state_" + p4Var.f4777a, jSONObject.toString()).apply();
        } catch (Throwable unused) {
        }
    }

    public void i(c1 c1Var) {
        this.f3540a.edit().putLong("revision", c1Var.f3643a).putString("snapshot", d1.c(c1Var).toString()).putInt("package_sequence", c1Var.f3648f).putLong("elapsed_at_sync", c1Var.f3649g).commit();
    }
}
