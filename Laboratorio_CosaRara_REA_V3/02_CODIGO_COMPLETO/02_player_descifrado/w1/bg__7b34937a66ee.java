// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.util.Log;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class bg {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f3633c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile int f3636f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f3638h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f3631a = "idle";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f3632b = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile String f3634d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile String f3635e = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile String f3637g = "";

    public final boolean a() {
        return (this.f3634d.isEmpty() || this.f3632b.isEmpty() || this.f3633c <= 0) ? false : true;
    }

    public final synchronized JSONObject b() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("stage", this.f3631a);
            jSONObject.put("pair_ip", this.f3632b);
            jSONObject.put("pair_port", this.f3633c);
            jSONObject.put("pair_code", this.f3634d);
            jSONObject.put("connect_ip", this.f3635e);
            jSONObject.put("connect_port", this.f3636f);
            jSONObject.put("error", this.f3637g);
            jSONObject.put("updated_at_ms", this.f3638h);
            jSONObject.put("ready", a());
        } catch (Exception e3) {
            Log.w("WirelessAdb", "toJson failed: " + e3.getMessage());
        }
        return jSONObject;
    }
}
