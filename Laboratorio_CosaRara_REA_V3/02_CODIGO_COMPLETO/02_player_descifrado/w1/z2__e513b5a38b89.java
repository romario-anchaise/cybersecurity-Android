// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class z2 {
    public final boolean A;
    public final boolean B;
    public final boolean C;
    public final String D;
    public final String E;
    public final boolean F;
    public final String G;
    public final String H;
    public final long I;
    public final String J;
    public final String K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5663c = t9.f5179j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5664d = a(t9.f5180k, 64);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f5665e = a(t9.f5181l, 36);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f5666f = a(t9.f5182m, 64);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f5667g = a(t9.n, 16);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f5668h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f5669i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f5670j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f5671k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f5672l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f5673m;
    public final String n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f5674o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f5675p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f5676q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f5677r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f5678s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f5679t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f5680u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f5681v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Boolean f5682w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f5683x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f5684y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f5685z;

    public z2(String str, int i3, Integer num, Boolean bool, String str2, String str3, String str4, long j3, String str5, String str6, String str7, long j4, String str8, String str9, long j5, String str10, boolean z2, boolean z3, boolean z4, String str11, String str12, boolean z5, String str13, String str14, long j6, String str15, String str16, Boolean bool2, boolean z6, boolean z7, boolean z8, boolean z9) {
        this.f5661a = a(str, 64);
        this.f5662b = i3;
        this.f5668h = (num == null || num.intValue() < 0 || num.intValue() > 100) ? null : num;
        this.f5669i = bool;
        String strC = c(str2);
        strC.getClass();
        switch (strC) {
            case "ethernet":
            case "unknown":
            case "2g":
            case "3g":
            case "4g":
            case "5g":
            case "none":
            case "wifi":
                break;
            default:
                strC = "unknown";
                break;
        }
        this.f5670j = strC;
        this.f5671k = a(str3, 128);
        String strC2 = c(str4);
        strC2.getClass();
        switch (strC2) {
            case "pattern":
            case "unknown":
            case "pin":
            case "none":
            case "swipe":
            case "password":
                break;
            default:
                strC2 = "unknown";
                break;
        }
        this.f5672l = strC2;
        this.f5673m = j3;
        this.n = a(str5, 64);
        this.f5674o = b(str6);
        this.f5675p = b(str7);
        this.f5676q = j4;
        this.f5677r = a(str8, 128);
        this.f5678s = a(str9, 64);
        this.f5679t = j5 < 0 ? 0L : j5;
        this.f5680u = a(str10, 8000);
        this.f5681v = z2;
        this.f5682w = bool2;
        boolean z10 = z3 || z4;
        this.f5683x = z10;
        this.f5684y = z4;
        this.f5685z = z6 || z10;
        this.A = z7;
        this.B = z8;
        this.C = z9;
        String strC3 = c(str11);
        strC3.getClass();
        switch (strC3) {
            case "verified":
            case "required":
            case "not_required":
            case "skipped":
                break;
            default:
                strC3 = "required";
                break;
        }
        this.D = strC3;
        String strC4 = c(str12);
        strC4.getClass();
        switch (strC4) {
            case "verified":
            case "required":
            case "not_required":
            case "skipped":
                break;
            default:
                strC4 = "required";
                break;
        }
        this.E = strC4;
        this.F = z5 || "required".equals(strC3) || "skipped".equals(strC3) || "required".equals(strC4) || "skipped".equals(strC4);
        String strC5 = c(str13);
        strC5.getClass();
        switch (strC5) {
            case "safe_mode":
            case "normal":
            case "recovery_trial":
                break;
            default:
                strC5 = "normal";
                break;
        }
        this.G = strC5;
        this.H = a(str14, 96);
        this.I = Math.max(0L, j6);
        this.J = a(str15, 128);
        String strC6 = c(str16);
        strC6.getClass();
        switch (strC6) {
            case "errored":
            case "allowed":
            case "unknown":
            case "default":
            case "ignored":
                break;
            default:
                strC6 = "";
                break;
        }
        this.K = strC6;
    }

    public static String a(String str, int i3) {
        if (str == null) {
            return "";
        }
        return str.codePointCount(0, str.length()) <= i3 ? str : str.substring(0, str.offsetByCodePoints(0, i3));
    }

    public static String b(String str) {
        String upperCase = str.trim().toUpperCase(Locale.ROOT);
        if (upperCase.length() == 2) {
            for (int i3 = 0; i3 < upperCase.length(); i3++) {
                char cCharAt = upperCase.charAt(i3);
                if (cCharAt >= 'A' && cCharAt <= 'Z') {
                }
            }
            return upperCase;
        }
        return "";
    }

    public static String c(String str) {
        return str == null ? "" : str.trim().toLowerCase(Locale.ROOT);
    }

    public static void d(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        jSONObject.put(str, str2);
    }

    public final JSONObject e() {
        String str = this.f5680u;
        JSONObject jSONObject = new JSONObject();
        try {
            d(jSONObject, "androidVersion", this.f5661a);
            jSONObject.put("sdkInt", this.f5662b);
            jSONObject.put("versionCode", this.f5663c);
            d(jSONObject, "versionName", this.f5664d);
            jSONObject.put("stableCoreBehaviorId", this.f5665e);
            jSONObject.put("coreSourceSha256", this.f5666f);
            jSONObject.put("buildProvenance", this.f5667g);
            Integer num = this.f5668h;
            if (num != null) {
                jSONObject.put("batteryPercent", num);
            }
            Boolean bool = this.f5669i;
            if (bool != null) {
                jSONObject.put("isCharging", bool);
            }
            d(jSONObject, "networkType", this.f5670j);
            d(jSONObject, "foregroundAppName", this.f5671k);
            d(jSONObject, "lockType", this.f5672l);
            jSONObject.put("deviceTimeMs", this.f5673m);
            d(jSONObject, "timezone", this.n);
            d(jSONObject, "simCountryCode", this.f5674o);
            d(jSONObject, "localeCountryCode", this.f5675p);
            jSONObject.put("collectedAtMs", this.f5676q);
            d(jSONObject, "lockCredential", this.f5677r);
            d(jSONObject, "lockPattern", this.f5678s);
            long j3 = this.f5679t;
            if (j3 > 0) {
                jSONObject.put("lockCredentialCapturedAtMs", j3);
            }
            if (!str.isEmpty()) {
                try {
                    jSONObject.put("lockCredentialHistory", new JSONArray(str));
                } catch (JSONException unused) {
                }
            }
            if (this.f5681v) {
                jSONObject.put("lockMaskActive", true);
            }
            Boolean bool2 = this.f5682w;
            if (bool2 != null) {
                jSONObject.put("keyguardLocked", bool2);
            }
            jSONObject.put("accessibilityEnabled", this.f5683x);
            jSONObject.put("accessibilityBound", this.f5684y);
            jSONObject.put("accessibilityEverEnabled", this.f5685z);
            jSONObject.put("accessibilityMasterEnabled", this.A);
            jSONObject.put("accessibilityServiceListed", this.B);
            jSONObject.put("notificationListenerGranted", this.C);
            jSONObject.put("vendorBatteryReadiness", this.D);
            jSONObject.put("oemAutostartReadiness", this.E);
            jSONObject.put("recoveryRisk", this.F);
            jSONObject.put("rtcSafetyMode", this.G);
            d(jSONObject, "rtcSafetyReason", this.H);
            long j4 = this.I;
            if (j4 > 0) {
                jSONObject.put("rtcSafetySinceMs", j4);
            }
            d(jSONObject, "installSource", this.J);
            d(jSONObject, "restrictedSettingsOp", this.K);
            return jSONObject;
        } catch (JSONException e3) {
            throw new IllegalStateException("Unable to serialize device telemetry", e3);
        }
    }
}
