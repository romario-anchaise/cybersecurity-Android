// EXTRAIDO POR REA; representacion java; no es proyecto original.
// Evidencia: ev_2c9ec331dd11c7d1d8b337ac0beb551b833d74184fc3c5237a62458e00f6ac6c
// Selector: {'path': 'C:\\Users\\Romario\\Documents\\Codex\\2026-10-15\\ho\\work\\player_unpacked_for_analysis.apk', 'class_name': 'w1.n', 'method_name': 'f0'}

public static v2 f0(String str) {
    if (!str.startsWith("credential_ack:")) {
        o2.i("invalid credential_ack prefix");
        return null;
    }
    if (str.getBytes(StandardCharsets.UTF_8).length > 16384) {
        o2.i("credential_ack exceeds byte limit");
        return null;
    }
    JSONObject jSONObject = new JSONObject(str.substring(15));
    boolean zOptBoolean = jSONObject.optBoolean("accepted", false);
    Object objOpt = jSONObject.opt("retryable");
    boolean zBooleanValue = objOpt instanceof Boolean ? ((Boolean) objOpt).booleanValue() : true;
    String strOptString = jSONObject.optString("reason", "");
    String strTrim = strOptString == null ? "" : strOptString.trim();
    String str2 = strTrim.matches("[a-z0-9_]{1,64}") ? strTrim : "";
    int iOptInt = jSONObject.optInt("saved", 0);
    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ids");
    ArrayList arrayList = new ArrayList();
    HashSet hashSet = new HashSet();
    if (jSONArrayOptJSONArray != null) {
        for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
            String strOptString2 = jSONArrayOptJSONArray.optString(i3, "");
            if (strOptString2 != null && !strOptString2.isEmpty() && strOptString2.codePointCount(0, strOptString2.length()) <= 64 && hashSet.add(strOptString2)) {
                arrayList.add(strOptString2);
            }
        }
    }
    return new v2(zOptBoolean, zBooleanValue, str2, Math.max(0, iOptInt), Collections.unmodifiableList(arrayList));
}
