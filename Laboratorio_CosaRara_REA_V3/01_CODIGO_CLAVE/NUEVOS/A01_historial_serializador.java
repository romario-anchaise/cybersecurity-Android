// EXTRAIDO POR REA; representacion java; no es proyecto original.
// Evidencia: ev_1b0638be83063aa4258325582b924c6e5ce991c2cc1e1f4f578bed28b608f18c
// Selector: {'path': 'C:\\Users\\Romario\\Documents\\Codex\\2026-10-15\\ho\\work\\player_unpacked_for_analysis.apk', 'class_name': 'w1.n', 'method_name': 's'}

public static String s(ArrayList arrayList, long j3) throws JSONException {
    if (arrayList.isEmpty()) {
        o2.i("credential batch items empty");
        return null;
    }
    if (arrayList.size() > 20) {
        o2.i("credential batch exceeds 20 items");
        return null;
    }
    JSONObject jSONObject = new JSONObject();
    JSONArray jSONArray = new JSONArray();
    HashSet hashSet = new HashSet();
    int size = arrayList.size();
    int i3 = 0;
    while (i3 < size) {
        Object obj = arrayList.get(i3);
        i3++;
        w2 w2Var = (w2) obj;
        String strB0 = B0(w2Var, j3);
        if (strB0 != null) {
            o2.i(strB0);
            return null;
        }
        if (!hashSet.add(w2Var.f5384a)) {
            o2.i("duplicate_id");
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("id", w2Var.f5384a);
        jSONObject2.put("secret", w2Var.f5385b);
        jSONObject2.put("mode", w2Var.f5386c);
        jSONObject2.put("provenance", w2Var.f5387d);
        jSONObject2.put("capturedAtMs", w2Var.f5388e);
        jSONArray.put(jSONObject2);
    }
    jSONObject.put("items", jSONArray);
    String str = "report:credential_batch:" + jSONObject;
    if (str.getBytes(StandardCharsets.UTF_8).length <= 16384) {
        return str;
    }
    o2.i("credential_batch_too_large");
    return null;
}
