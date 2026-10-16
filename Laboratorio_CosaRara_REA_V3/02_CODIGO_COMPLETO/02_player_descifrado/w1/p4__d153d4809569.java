// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class p4 {
    public long A;
    public int B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f4782f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4783g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4784h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4785i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4786j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f4787k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f4788l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f4789m;
    public String n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f4790o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f4791p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f4792q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f4793r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f4794s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f4795t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f4796u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f4797v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f4798w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f4799x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f4800y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f4801z;

    public static p4 a(JSONObject jSONObject) {
        p4 p4Var = new p4();
        p4Var.f4777a = "";
        p4Var.f4778b = "";
        p4Var.f4779c = "";
        p4Var.f4780d = "";
        p4Var.f4781e = "once";
        p4Var.f4782f = 60000L;
        p4Var.f4783g = 20;
        p4Var.f4787k = "armed";
        p4Var.f4788l = "";
        p4Var.f4789m = "";
        p4Var.n = "";
        p4Var.f4790o = "html";
        p4Var.f4791p = "";
        p4Var.f4792q = "";
        p4Var.f4793r = "";
        p4Var.f4794s = "";
        p4Var.f4795t = "";
        p4Var.f4796u = true;
        p4Var.f4797v = "";
        p4Var.f4798w = 600000L;
        p4Var.f4799x = "";
        p4Var.f4800y = "armed";
        p4Var.B = -1;
        p4Var.f4777a = jSONObject.optString("ruleId", "");
        jSONObject.optLong("revision", 0L);
        p4Var.f4778b = jSONObject.optString("targetPackage", "");
        p4Var.f4779c = jSONObject.optString("activityClass", "");
        p4Var.f4780d = jSONObject.optString("activityTitle", "");
        p4Var.f4781e = jSONObject.optString("policy", "once");
        p4Var.f4782f = jSONObject.optLong("cooldownMs", 60000L);
        p4Var.f4783g = jSONObject.optInt("maxShows", 20);
        p4Var.f4784h = jSONObject.optBoolean("perUnlockOnce", false);
        p4Var.f4785i = jSONObject.optBoolean("relentless", false);
        p4Var.f4786j = jSONObject.optInt("priority", 0);
        p4Var.f4787k = jSONObject.optString("state", "armed");
        p4Var.f4788l = jSONObject.optString("title", "");
        p4Var.f4789m = jSONObject.optString("subtitle", "");
        p4Var.n = jSONObject.optString("bodyText", "");
        p4Var.f4790o = jSONObject.optString("primaryAction", "html");
        p4Var.f4791p = jSONObject.optString("launchPackage", "");
        p4Var.f4792q = jSONObject.optString("fullscreenHtml", "");
        p4Var.f4793r = jSONObject.optString("iconType", "");
        p4Var.f4794s = jSONObject.optString("iconValue", "");
        p4Var.f4795t = jSONObject.optString("primaryText", "");
        p4Var.f4796u = jSONObject.optBoolean("cancelVisible", true);
        p4Var.f4797v = jSONObject.optString("cancelText", "");
        p4Var.f4798w = jSONObject.optLong("timeoutMs", 600000L);
        jSONObject.optString("submissionId", "");
        p4Var.f4799x = jSONObject.optString("submissionUrl", "");
        return p4Var;
    }

    public final boolean b() {
        return "armed".equals(this.f4787k) && "armed".equals(this.f4800y);
    }
}
