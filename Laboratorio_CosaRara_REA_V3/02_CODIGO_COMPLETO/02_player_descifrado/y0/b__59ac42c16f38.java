// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y0;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f6038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f6039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f6040d;

    public b(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        JSONArray jSONArray = jSONObject.getJSONArray("upgrades");
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i3 = 0; i3 < length; i3++) {
            strArr[i3] = jSONArray.getString(i3);
        }
        this.f6037a = jSONObject.getString("sid");
        this.f6038b = strArr;
        this.f6039c = jSONObject.getLong("pingInterval");
        this.f6040d = jSONObject.getLong("pingTimeout");
    }
}
