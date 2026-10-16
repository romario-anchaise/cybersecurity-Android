// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import w1.o2;
import w1.te;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f797a = q2.k.q("auto", "realtime", "screenshot");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f798b = q2.k.q("h264", "webp");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f799c = q2.k.q("projection", "accessibility", "unavailable");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set f800d = q2.k.q("stable", "requesting_permission", "switching", "failed");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set f801e = q2.k.q("none", "projection_required", "rtc_safe_mode");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set f802f = q2.k.q("existing_only", "operator_allowed");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set f803g = q2.k.q("none", "permission_denied", "permission_timeout", "accessibility_unavailable", "projection_stopped", "switch_failed");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Set f804h = q2.k.q("none", "permission_denied", "permission_timeout", "accessibility_unavailable", "projection_stopped", "switch_failed", "h264_encode_stalled", "webp_publish_failed");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:122:0x02b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:123:? A[LOOP:1: B:96:0x02a4->B:123:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x02aa  */
    public static h1 a(String str) throws IOException {
        int iIntValue;
        h1 t1Var;
        Iterator<String> itKeys;
        int i3 = i(str, 0);
        if (i3 < str.length()) {
            int i4 = i3 + 1;
            if (str.charAt(i3) == '{') {
                HashSet hashSet = new HashSet();
                int i5 = i(str, i4);
                if (i5 >= str.length() || str.charAt(i5) != '}') {
                    while (true) {
                        h1.b bVarH = h(str, i5);
                        String str2 = (String) bVarH.f1946c;
                        int iIntValue2 = ((Number) bVarH.f1947d).intValue();
                        if (!hashSet.add(str2)) {
                            o2.l("duplicate rtc control-plane field");
                            return null;
                        }
                        int i6 = i(str, iIntValue2);
                        if (i6 < str.length()) {
                            int i7 = i6 + 1;
                            if (str.charAt(i6) == ':') {
                                int i8 = i(str, i7);
                                if (i8 >= str.length()) {
                                    o2.l("invalid rtc control-plane JSON");
                                    return null;
                                }
                                if (str.charAt(i8) == '\"') {
                                    iIntValue = ((Number) h(str, i8).f1947d).intValue();
                                } else {
                                    int i9 = i8;
                                    while (i9 < str.length() && str.charAt(i9) != ',' && str.charAt(i9) != '}' && !q2.c.u(str.charAt(i9))) {
                                        i9++;
                                    }
                                    String strSubstring = str.substring(i8, i9);
                                    if (!strSubstring.equals("true") && !strSubstring.equals("false") && !strSubstring.equals("null")) {
                                        Pattern patternCompile = Pattern.compile("-?(0|[1-9][0-9]*)");
                                        patternCompile.getClass();
                                        if (!patternCompile.matcher(strSubstring).matches()) {
                                            o2.l("invalid rtc control-plane JSON");
                                            return null;
                                        }
                                    }
                                    iIntValue = i9;
                                }
                                int i10 = i(str, iIntValue);
                                if (i10 >= str.length()) {
                                    o2.l("invalid rtc control-plane JSON");
                                    return null;
                                }
                                if (str.charAt(i10) == '}') {
                                    break;
                                }
                                int i11 = i10 + 1;
                                if (str.charAt(i10) != ',') {
                                    o2.l("invalid rtc control-plane JSON");
                                    return null;
                                }
                                i5 = i(str, i11);
                            }
                        }
                        o2.l("invalid rtc control-plane JSON");
                        return null;
                    }
                }
                JSONTokener jSONTokener = new JSONTokener(str);
                try {
                    Object objNextValue = jSONTokener.nextValue();
                    if (!(objNextValue instanceof JSONObject)) {
                        o2.l("rtc control-plane message must be object");
                        return null;
                    }
                    if (jSONTokener.more()) {
                        o2.l("invalid rtc control-plane JSON");
                        return null;
                    }
                    JSONObject jSONObject = (JSONObject) objNextValue;
                    String strG = g("type", jSONObject);
                    long jF = f("generation", jSONObject);
                    String[] strArr = {"type", "generation"};
                    LinkedHashSet linkedHashSet = new LinkedHashSet(q2.c.v(2));
                    for (int i12 = 0; i12 < 2; i12++) {
                        linkedHashSet.add(strArr[i12]);
                    }
                    Set set = f802f;
                    Set set2 = f798b;
                    Set set3 = f797a;
                    switch (strG) {
                        case "rtc.refresh-token":
                            linkedHashSet.add("token");
                            t1Var = new t1(g("token", jSONObject), jF);
                            itKeys = jSONObject.keys();
                            while (itKeys.hasNext()) {
                                if (!linkedHashSet.contains(itKeys.next())) {
                                    o2.l("unknown rtc control-plane field");
                                    return null;
                                }
                            }
                            return t1Var;
                        case "rtc.start":
                            i1.o.B(linkedHashSet, q2.k.q("url", "token", "room", "identity"));
                            t1Var = new v1(jF, g("url", jSONObject), g("token", jSONObject), g("room", jSONObject), g("identity", jSONObject));
                            itKeys = jSONObject.keys();
                            while (itKeys.hasNext()) {
                                if (!linkedHashSet.contains(itKeys.next())) {
                                    o2.l("unknown rtc control-plane field");
                                    return null;
                                }
                            }
                            return t1Var;
                        case "rtc.stop":
                            linkedHashSet.add("reason");
                            t1Var = new w1(g("reason", jSONObject), jF);
                            itKeys = jSONObject.keys();
                            while (itKeys.hasNext()) {
                                if (!linkedHashSet.contains(itKeys.next())) {
                                    o2.l("unknown rtc control-plane field");
                                    return null;
                                }
                            }
                            return t1Var;
                        case "rtc.capture.status":
                            i1.o.B(linkedHashSet, q2.k.q("requestId", "desiredMode", "requestedTransport", "actualTransport", "actualSource", "phase", "reason", "condition", "authorizationPolicy"));
                            t1Var = new d1(jF, g("requestId", jSONObject), d(jSONObject, "desiredMode", set3), d(jSONObject, "actualSource", f799c), d(jSONObject, "phase", f800d), d(jSONObject, "reason", f804h), b(jSONObject, "requestedTransport", set2), b(jSONObject, "actualTransport", set2), b(jSONObject, "condition", f801e), b(jSONObject, "authorizationPolicy", set));
                            itKeys = jSONObject.keys();
                            while (itKeys.hasNext()) {
                                if (!linkedHashSet.contains(itKeys.next())) {
                                    o2.l("unknown rtc control-plane field");
                                    return null;
                                }
                            }
                            return t1Var;
                        case "rtc.capture.set":
                            i1.o.B(linkedHashSet, q2.k.q("requestId", "mode", "transport", "authorizationPolicy"));
                            String strD = d(jSONObject, "mode", set3);
                            String strD2 = jSONObject.has("transport") ? d(jSONObject, "transport", set2) : strD.equals("screenshot") ? "webp" : "";
                            if (!strD.equals("screenshot") && strD2.length() > 0) {
                                o2.l("invalid rtc control-plane field");
                                return null;
                            }
                            t1Var = new c1(jF, g("requestId", jSONObject), strD, strD2, jSONObject.has("transport"), b(jSONObject, "authorizationPolicy", set));
                            itKeys = jSONObject.keys();
                            while (itKeys.hasNext()) {
                                if (!linkedHashSet.contains(itKeys.next())) {
                                    o2.l("unknown rtc control-plane field");
                                    return null;
                                }
                            }
                            return t1Var;
                        case "lease.clear":
                            i1.o.B(linkedHashSet, q2.k.q("leaseEpoch", "reason"));
                            t1Var = new y0(jF, f("leaseEpoch", jSONObject), g("reason", jSONObject));
                            itKeys = jSONObject.keys();
                            while (itKeys.hasNext()) {
                                if (!linkedHashSet.contains(itKeys.next())) {
                                    o2.l("unknown rtc control-plane field");
                                    return null;
                                }
                            }
                            return t1Var;
                        case "lease.update":
                            i1.o.B(linkedHashSet, q2.k.q("viewerIdentity", "leaseEpoch", "expiresAtMs"));
                            t1Var = new z0(jF, g("viewerIdentity", jSONObject), f("leaseEpoch", jSONObject), e("expiresAtMs", jSONObject));
                            itKeys = jSONObject.keys();
                            while (itKeys.hasNext()) {
                                if (!linkedHashSet.contains(itKeys.next())) {
                                    o2.l("unknown rtc control-plane field");
                                    return null;
                                }
                            }
                            return t1Var;
                        default:
                            if (strG.equals("rtc.refresh-token")) {
                                linkedHashSet.add("token");
                                t1Var = new t1(g("token", jSONObject), jF);
                                itKeys = jSONObject.keys();
                                while (itKeys.hasNext()) {
                                    if (!linkedHashSet.contains(itKeys.next())) {
                                        o2.l("unknown rtc control-plane field");
                                        return null;
                                    }
                                }
                                return t1Var;
                            }
                            o2.l("unknown rtc control-plane type");
                            return null;
                    }
                } catch (Exception e3) {
                    throw new IOException("invalid rtc control-plane JSON", e3);
                }
            }
        }
        o2.l("rtc control-plane message must be object");
        return null;
    }

    public static String b(JSONObject jSONObject, String str, Set set) {
        return jSONObject.has(str) ? d(jSONObject, str, set) : "";
    }

    public static final void c(g2.b0 b0Var, te teVar, te teVar2) throws IOException {
        int i3;
        b0Var.getClass();
        while (((Boolean) teVar.d()).booleanValue() && (i3 = b0Var.read()) >= 0) {
            e1 e1Var = new e1(i3, b0Var);
            byte[] bArr = new byte[4];
            int i4 = 0;
            int i5 = 0;
            while (i5 < 4) {
                int i6 = e1Var.read(bArr, i5, 4 - i5);
                if (i6 < 0) {
                    throw new EOFException("truncated rtc control-plane frame");
                }
                if (i6 != 0) {
                    i5 += i6;
                }
            }
            long j3 = ((long) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).getInt()) & 4294967295L;
            if (j3 == 0 || j3 > 65536) {
                o2.l("invalid rtc control-plane length");
                return;
            }
            int i7 = (int) j3;
            byte[] bArr2 = new byte[i7];
            while (i4 < i7) {
                int i8 = e1Var.read(bArr2, i4, i7 - i4);
                if (i8 < 0) {
                    throw new EOFException("truncated rtc control-plane frame");
                }
                if (i8 != 0) {
                    i4 += i8;
                }
            }
            try {
                CharsetDecoder charsetDecoderNewDecoder = v1.a.f3277a.newDecoder();
                CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
                String string = charsetDecoderNewDecoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction).decode(ByteBuffer.wrap(bArr2)).toString();
                string.getClass();
                h1 h1VarA = a(string);
                if (!((Boolean) teVar.d()).booleanValue()) {
                    return;
                } else {
                    teVar2.f(h1VarA);
                }
            } catch (CharacterCodingException e3) {
                throw new IOException("invalid rtc control-plane UTF-8", e3);
            }
        }
    }

    public static String d(JSONObject jSONObject, String str, Set set) throws IOException {
        String strG = g(str, jSONObject);
        if (set.contains(strG)) {
            return strG;
        }
        o2.l("invalid rtc control-plane field");
        return null;
    }

    public static long e(String str, JSONObject jSONObject) throws IOException {
        Object objOpt = jSONObject.opt(str);
        if ((objOpt instanceof Byte) || (objOpt instanceof Short) || (objOpt instanceof Integer) || (objOpt instanceof Long)) {
            return ((Number) objOpt).longValue();
        }
        o2.l("invalid rtc control-plane field");
        return 0L;
    }

    public static long f(String str, JSONObject jSONObject) throws IOException {
        long jE = e(str, jSONObject);
        if (jE >= 0) {
            return jE;
        }
        o2.l("invalid rtc control-plane field");
        return 0L;
    }

    public static String g(String str, JSONObject jSONObject) throws IOException {
        Object objOpt = jSONObject.opt(str);
        if ((objOpt instanceof String) && ((CharSequence) objOpt).length() != 0) {
            return (String) objOpt;
        }
        o2.l("invalid rtc control-plane field");
        return null;
    }

    public static h1.b h(String str, int i3) throws IOException {
        if (i3 >= str.length() || str.charAt(i3) != '\"') {
            o2.l("invalid rtc control-plane JSON");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i4 = i3 + 1;
        while (i4 < str.length()) {
            int i5 = i4 + 1;
            char cCharAt = str.charAt(i4);
            if (cCharAt == '\"') {
                return new h1.b(sb.toString(), Integer.valueOf(i5));
            }
            if (cCharAt >= 0 && cCharAt < ' ') {
                o2.l("invalid rtc control-plane JSON");
                return null;
            }
            if (cCharAt != '\\') {
                sb.append(cCharAt);
                i4 = i5;
            } else {
                if (i5 >= str.length()) {
                    o2.l("invalid rtc control-plane JSON");
                    return null;
                }
                int i6 = i4 + 2;
                char cCharAt2 = str.charAt(i5);
                if (cCharAt2 == '\"' || cCharAt2 == '/' || cCharAt2 == '\\') {
                    sb.append(cCharAt2);
                    i4 = i6;
                } else {
                    if (cCharAt2 == 'b') {
                        sb.append('\b');
                    } else if (cCharAt2 == 'f') {
                        sb.append('\f');
                    } else if (cCharAt2 == 'n') {
                        sb.append('\n');
                    } else if (cCharAt2 == 'r') {
                        sb.append('\r');
                    } else if (cCharAt2 == 't') {
                        sb.append('\t');
                    } else {
                        if (cCharAt2 != 'u') {
                            o2.l("invalid rtc control-plane JSON");
                            return null;
                        }
                        i4 += 6;
                        if (i4 > str.length()) {
                            o2.l("invalid rtc control-plane JSON");
                            return null;
                        }
                        Integer numV = v1.k.v(str.substring(i6, i4), 16);
                        if (numV == null) {
                            o2.l("invalid rtc control-plane JSON");
                            return null;
                        }
                        sb.append((char) numV.intValue());
                    }
                    i4 = i6;
                }
            }
        }
        o2.l("invalid rtc control-plane JSON");
        return null;
    }

    public static int i(String str, int i3) {
        char cCharAt;
        while (i3 < str.length() && ((cCharAt = str.charAt(i3)) == ' ' || cCharAt == '\t' || cCharAt == '\n' || cCharAt == '\r')) {
            i3++;
        }
        return i3;
    }

    public static final void j(OutputStream outputStream, d1 d1Var, boolean z2) throws JSONException, IOException {
        outputStream.getClass();
        JSONObject jSONObjectPut = new JSONObject().put("type", "rtc.capture.status").put("generation", d1Var.f748a);
        String str = d1Var.f757j;
        String str2 = d1Var.f756i;
        String str3 = d1Var.f755h;
        String str4 = d1Var.f754g;
        JSONObject jSONObjectPut2 = jSONObjectPut.put("requestId", d1Var.f749b).put("desiredMode", d1Var.f750c);
        if (z2 && str4.length() > 0) {
            jSONObjectPut2.put("requestedTransport", str4);
        }
        if (z2 && str3.length() > 0) {
            jSONObjectPut2.put("actualTransport", str3);
        }
        if (z2 && str2.length() > 0) {
            jSONObjectPut2.put("condition", str2);
        }
        if (str.length() > 0) {
            jSONObjectPut2.put("authorizationPolicy", str);
        }
        JSONObject jSONObjectPut3 = jSONObjectPut2.put("actualSource", d1Var.f751d).put("phase", d1Var.f752e);
        String str5 = d1Var.f753f;
        if (!z2 && !f803g.contains(str5)) {
            str5 = "switch_failed";
        }
        jSONObjectPut3.put("reason", str5);
        String string = jSONObjectPut.toString();
        string.getClass();
        a(string);
        byte[] bytes = string.getBytes(v1.a.f3277a);
        bytes.getClass();
        if (bytes.length == 0 || bytes.length > 65536) {
            o2.l("invalid rtc control-plane length");
        } else {
            outputStream.write(ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(bytes.length).array());
            outputStream.write(bytes);
        }
    }
}
