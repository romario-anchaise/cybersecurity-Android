// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class y3 {
    public static final Set n = Set.of((Object[]) new String[]{"preset", "sensorType", "centerX", "centerY", "radius", "edge", "offset", "horizontal", "vertical", "title", "subtitle", "textY", "timeoutMs", "opacity"});

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Double f5578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Double f5579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Double f5580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f5581f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Double f5582g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f5583h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f5584i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f5585j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f5586k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final double f5587l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f5588m;

    public y3(String str, String str2, Double d3, Double d4, Double d5, String str3, Double d6, String str4, String str5, String str6, String str7, double d7, long j3) {
        this.f5576a = str;
        this.f5577b = str2;
        this.f5578c = d3;
        this.f5579d = d4;
        this.f5580e = d5;
        this.f5581f = str3;
        this.f5582g = d6;
        this.f5583h = str4;
        this.f5584i = str5;
        this.f5585j = str6;
        this.f5586k = str7;
        this.f5587l = d7;
        this.f5588m = j3 >= 1000 ? Math.min(j3, 3600000L) : 1000L;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:167:0x02de  */
    /* JADX WARN: Code duplicated, block: B:168:0x02e1  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static y3 a(String str) throws x3 {
        Double dValueOf;
        String str2;
        String str3;
        Double d3;
        boolean z2;
        boolean z3;
        double d4;
        if (str.isEmpty()) {
            throw new x3("invalid_fingerprint_payload");
        }
        if (str.length() > 10924) {
            throw new x3("fingerprint_payload_too_large");
        }
        if ((str.length() & 3) == 1) {
            throw new x3("invalid_fingerprint_payload");
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt < 'a' || cCharAt > 'z') && !((cCharAt >= '0' && cCharAt <= '9') || cCharAt == '-' || cCharAt == '_'))) {
                throw new x3("invalid_fingerprint_payload");
            }
        }
        try {
            byte[] bArrDecode = Base64.getUrlDecoder().decode(str);
            if (bArrDecode.length > 8192) {
                throw new x3("fingerprint_payload_too_large");
            }
            try {
                CharsetDecoder charsetDecoderNewDecoder = StandardCharsets.UTF_8.newDecoder();
                CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
                String string = charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).decode(ByteBuffer.wrap(bArrDecode)).toString();
                Double dValueOf2 = Double.valueOf(0.5d);
                try {
                    JSONTokener jSONTokener = new JSONTokener(string);
                    Object objNextValue = jSONTokener.nextValue();
                    if (!(objNextValue instanceof JSONObject) || jSONTokener.nextClean() != 0) {
                        throw new x3("invalid_fingerprint_spec");
                    }
                    JSONObject jSONObject = (JSONObject) objNextValue;
                    try {
                        try {
                            Iterator<String> itKeys = jSONObject.keys();
                            while (itKeys.hasNext()) {
                                Double d5 = dValueOf2;
                                if (!n.contains(itKeys.next())) {
                                    throw new x3("unknown_fingerprint_field");
                                }
                                dValueOf2 = d5;
                            }
                            Double d6 = dValueOf2;
                            String strJ = j("preset", jSONObject);
                            try {
                                if (!"fingerprint".equals(strJ)) {
                                    throw new x3("invalid_fingerprint_preset");
                                }
                                String strJ2 = j("sensorType", jSONObject);
                                Double dF = f("centerX", jSONObject);
                                Double dF2 = f("centerY", jSONObject);
                                Double dF3 = f("radius", jSONObject);
                                String strH = h("edge", jSONObject);
                                Double dF4 = f("offset", jSONObject);
                                Double d7 = dF;
                                String strH2 = h("horizontal", jSONObject);
                                String strH3 = h("vertical", jSONObject);
                                String str4 = strH2;
                                String strE = e(h("title", jSONObject), c(strJ2), 80, "title");
                                String strE2 = e(h("subtitle", jSONObject), b(strJ2), 160, "subtitle");
                                Double dF5 = f("textY", jSONObject);
                                double dDoubleValue = dF5 != null ? dF5.doubleValue() : 0.4d;
                                if (dF5 != null && (dDoubleValue < 0.05d || dDoubleValue > 0.95d)) {
                                    throw new x3("invalid_textY");
                                }
                                long jI = i(jSONObject);
                                g(jSONObject);
                                boolean z4 = jSONObject.has("centerX") || jSONObject.has("centerY") || jSONObject.has("radius");
                                boolean z5 = jSONObject.has("edge") || jSONObject.has("offset");
                                boolean z6 = jSONObject.has("horizontal") || jSONObject.has("vertical");
                                switch (strJ2.hashCode()) {
                                    case -1458576723:
                                        if (strJ2.equals("front_press")) {
                                            if (z4 || strH == null || dF4 == null || z6 || !"bottom".equals(strH) || !d(dF4.doubleValue())) {
                                                throw new x3("invalid_front_press_spec");
                                            }
                                            dValueOf = d6;
                                            strH = strH;
                                            str2 = str4;
                                            str3 = strH3;
                                            d3 = dF3;
                                            if ("under_display".equals(strJ2)) {
                                                d4 = dDoubleValue;
                                            } else {
                                                d4 = 0.4d;
                                            }
                                            "under_display".equals(strJ2);
                                            return new y3(strJ, strJ2, d7, dF2, d3, strH, dValueOf, str2, str3, strE, strE2, d4, jI);
                                        }
                                        throw new x3("invalid_fingerprint_sensor_type");
                                    case -785077669:
                                        if (strJ2.equals("under_display")) {
                                            if (d7 == null || dF2 == null || dF3 == null || z5 || z6 || !d(d7.doubleValue()) || !d(dF2.doubleValue()) || dF3.doubleValue() <= 0.0d || dF3.doubleValue() > 1.0d) {
                                                throw new x3("invalid_under_display_spec");
                                            }
                                            dF3 = Double.valueOf(0.1d);
                                            d7 = d6;
                                            str2 = str4;
                                            str3 = strH3;
                                            d3 = dF3;
                                            dValueOf = dF4;
                                            if ("under_display".equals(strJ2)) {
                                                d4 = 0.4d;
                                            } else {
                                                d4 = dDoubleValue;
                                            }
                                            "under_display".equals(strJ2);
                                            return new y3(strJ, strJ2, d7, dF2, d3, strH, dValueOf, str2, str3, strE, strE2, d4, jI);
                                        }
                                        throw new x3("invalid_fingerprint_sensor_type");
                                    case 3496356:
                                        if (strJ2.equals("rear")) {
                                            if (!z4 && !z5 && str4 != null && strH3 != null) {
                                                String[] strArr = {"left", "center", "right"};
                                                int i4 = 0;
                                                while (true) {
                                                    if (i4 < 3) {
                                                        String str5 = str4;
                                                        if (strArr[i4].equals(str5)) {
                                                            z2 = true;
                                                        } else {
                                                            i4++;
                                                            str4 = str5;
                                                        }
                                                    } else {
                                                        z2 = false;
                                                    }
                                                }
                                                if (z2) {
                                                    String[] strArr2 = {"upper", "middle", "lower"};
                                                    int i5 = 0;
                                                    while (true) {
                                                        if (i5 < 3) {
                                                            String str6 = strH3;
                                                            if (strArr2[i5].equals(str6)) {
                                                                z3 = true;
                                                            } else {
                                                                i5++;
                                                                strH3 = str6;
                                                            }
                                                        } else {
                                                            z3 = false;
                                                        }
                                                    }
                                                    if (z3) {
                                                        str2 = "center";
                                                        str3 = "middle";
                                                        d3 = dF3;
                                                        dValueOf = dF4;
                                                        if ("under_display".equals(strJ2)) {
                                                            d4 = 0.4d;
                                                        } else {
                                                            d4 = dDoubleValue;
                                                        }
                                                        "under_display".equals(strJ2);
                                                        return new y3(strJ, strJ2, d7, dF2, d3, strH, dValueOf, str2, str3, strE, strE2, d4, jI);
                                                    }
                                                }
                                            }
                                            throw new x3("invalid_rear_spec");
                                        }
                                        throw new x3("invalid_fingerprint_sensor_type");
                                    case 3530071:
                                        if (strJ2.equals("side")) {
                                            if (z4 || strH == null || dF4 == null || z6 || !(("left".equals(strH) || "right".equals(strH)) && d(dF4.doubleValue()))) {
                                                throw new x3("invalid_side_spec");
                                            }
                                            strH = "right";
                                            str3 = strH3;
                                            str2 = str4;
                                            dValueOf = Double.valueOf(0.66d);
                                            d3 = dF3;
                                            if ("under_display".equals(strJ2)) {
                                                d4 = 0.4d;
                                            } else {
                                                d4 = dDoubleValue;
                                            }
                                            "under_display".equals(strJ2);
                                            return new y3(strJ, strJ2, d7, dF2, d3, strH, dValueOf, str2, str3, strE, strE2, d4, jI);
                                        }
                                        throw new x3("invalid_fingerprint_sensor_type");
                                    default:
                                        throw new x3("invalid_fingerprint_sensor_type");
                                }
                            } catch (Exception unused) {
                                throw new x3("invalid_fingerprint_spec");
                            }
                        } catch (x3 e3) {
                            throw e3;
                        }
                    } catch (Exception unused2) {
                    }
                } catch (x3 e4) {
                    throw e4;
                } catch (Exception unused3) {
                    throw new x3("invalid_fingerprint_spec");
                }
            } catch (CharacterCodingException unused4) {
                throw new x3("invalid_fingerprint_payload");
            }
        } catch (IllegalArgumentException unused5) {
            throw new x3("invalid_fingerprint_payload");
        }
    }

    public static String b(String str) {
        if ("side".equals(str)) {
            return "Toca el sensor de huellas lateral para continuar";
        }
        if ("front_press".equals(str)) {
            return "Presiona el botón frontal de huella para continuar";
        }
        return "rear".equals(str) ? "Toca el sensor de huellas trasero para continuar" : "Coloca el dedo en el sensor de huellas para continuar";
    }

    public static String c(String str) {
        if ("side".equals(str)) {
            return "Usa el sensor lateral";
        }
        if ("front_press".equals(str)) {
            return "Pulsa el sensor frontal";
        }
        return "rear".equals(str) ? "Usa el sensor trasero" : "Verifica tu huella digital";
    }

    public static boolean d(double d3) {
        return d3 >= 0.0d && d3 <= 1.0d;
    }

    public static String e(String str, String str2, int i3, String str3) throws x3 {
        if (str == null) {
            return str2;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty() || strTrim.codePointCount(0, strTrim.length()) > i3) {
            throw new x3("invalid_".concat(str3));
        }
        return strTrim;
    }

    public static Double f(String str, JSONObject jSONObject) throws JSONException, x3 {
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        Object obj = jSONObject.get(str);
        if (!(obj instanceof Number)) {
            throw new x3("invalid_".concat(str));
        }
        double dDoubleValue = ((Number) obj).doubleValue();
        if (Double.isFinite(dDoubleValue)) {
            return Double.valueOf(dDoubleValue);
        }
        throw new x3("invalid_".concat(str));
    }

    public static void g(JSONObject jSONObject) throws JSONException, x3 {
        if (!jSONObject.has("opacity") || jSONObject.isNull("opacity")) {
            return;
        }
        Object obj = jSONObject.get("opacity");
        if (!(obj instanceof Number)) {
            throw new x3("invalid_opacity");
        }
        Number number = (Number) obj;
        double dDoubleValue = number.doubleValue();
        int iIntValue = number.intValue();
        if (!Double.isFinite(dDoubleValue) || dDoubleValue != iIntValue) {
            throw new x3("invalid_opacity");
        }
    }

    public static String h(String str, JSONObject jSONObject) throws JSONException, x3 {
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        Object obj = jSONObject.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new x3("invalid_".concat(str));
    }

    public static long i(JSONObject jSONObject) throws JSONException, x3 {
        if (!jSONObject.has("timeoutMs") || jSONObject.isNull("timeoutMs")) {
            throw new x3("missing_timeoutMs");
        }
        Object obj = jSONObject.get("timeoutMs");
        if (!(obj instanceof Number)) {
            throw new x3("invalid_timeoutMs");
        }
        Number number = (Number) obj;
        double dDoubleValue = number.doubleValue();
        long jLongValue = number.longValue();
        if (Double.isFinite(dDoubleValue) && dDoubleValue == jLongValue && jLongValue > 0) {
            return jLongValue;
        }
        throw new x3("invalid_timeoutMs");
    }

    public static String j(String str, JSONObject jSONObject) throws JSONException, x3 {
        String strH = h(str, jSONObject);
        if (strH == null || strH.isEmpty()) {
            throw new x3("missing_".concat(str));
        }
        return strH;
    }

    public final float k(int i3, int i4) {
        int iMin = Math.min(i3, i4);
        Double d3 = this.f5580e;
        float fDoubleValue = (d3 == null || iMin <= 0) ? 0.0f : (float) (d3.doubleValue() * ((double) iMin));
        Double d4 = this.f5579d;
        float fDoubleValue2 = (d4 == null || i4 <= 0) ? 0.0f : (float) (d4.doubleValue() * ((double) i4));
        float fL0 = n.l0(i3, i4);
        float fMax = Math.max(0.0f, fDoubleValue);
        float fG = (n.g(24.0f, Math.min(Math.max(1, i3), Math.max(1, i4)) * 0.032f, 42.0f) * 1.2f * 3.0f) + n.g(8.0f, Math.min(Math.max(1, i3), Math.max(1, i4)) * 0.012f, 16.0f) + (n.g(32.0f, Math.min(Math.max(1, i3), Math.max(1, i4)) * 0.044f, 56.0f) * 1.12f * 2.0f) + fL0 + 30.0f + fMax;
        float fMax2 = (Math.max(0, i4) - fL0) - fMax;
        return fG <= fMax2 ? n.g(fG, fDoubleValue2, fMax2) : n.g(fL0 + fMax, fDoubleValue2, fMax2);
    }
}
