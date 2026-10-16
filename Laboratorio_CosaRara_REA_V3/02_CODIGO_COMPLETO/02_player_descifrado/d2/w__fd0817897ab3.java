// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d2;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f640h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f641i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f642j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f643k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f644l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f645m;
    public final String n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f646o;

    public w(String str, long j3, int i3, String str2, String str3, String str4, String str5, String str6, String str7, int i4, boolean z2, String str8, String str9, String str10) {
        this.f633a = str == null ? "" : str;
        this.f634b = j3;
        this.f635c = i3;
        this.f636d = str2;
        this.f637e = str3 == null ? "" : str3;
        this.f638f = str4 == null ? "" : str4;
        this.f639g = str5 == null ? "" : str5;
        this.f640h = "";
        this.f641i = str6 == null ? "" : str6;
        this.f642j = str7 == null ? "" : str7;
        this.f643k = i4;
        this.f644l = z2;
        this.f645m = str8 == null ? "" : str8;
        this.n = str9 == null ? "" : str9;
        this.f646o = str10 != null ? str10 : "";
    }

    public final JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.f633a);
        jSONObject.put("ts", this.f634b);
        jSONObject.put("tzOffsetMinutes", this.f635c);
        jSONObject.put("eventType", this.f636d);
        jSONObject.put("packageName", this.f637e);
        jSONObject.put("className", this.f638f);
        jSONObject.put("text", this.f639g);
        jSONObject.put("beforeText", this.f640h);
        jSONObject.put("viewId", this.f641i);
        jSONObject.put("hint", this.f642j);
        jSONObject.put("addedCount", this.f643k);
        jSONObject.put("removedCount", 0);
        jSONObject.put("fromIndex", 0);
        jSONObject.put("isPassword", this.f644l);
        String str = this.f645m;
        if (!str.isEmpty()) {
            jSONObject.put("fieldSessionId", str);
        }
        String str2 = this.n;
        if (!str2.isEmpty() || !str.isEmpty()) {
            jSONObject.put("inputText", str2);
        }
        String str3 = this.f646o;
        if (!str3.isEmpty()) {
            jSONObject.put("completionText", str3);
        }
        return jSONObject;
    }
}
