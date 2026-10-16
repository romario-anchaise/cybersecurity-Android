// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.app.ApplicationExitInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f3668a = Pattern.compile("^[A-Za-z0-9._:-]{1,256}$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f3669b;

    static {
        Pattern patternCompile;
        String str = t9.f5178i;
        String strTrim = str == null ? "" : str.trim();
        if (strTrim.isEmpty()) {
            patternCompile = Pattern.compile("(?!x)x");
        } else {
            patternCompile = Pattern.compile("(?:^|\\s)" + Pattern.quote(strTrim) + "((?:\\.[A-Za-z0-9_$<>]+)+)\\s*\\(");
        }
        f3669b = patternCompile;
    }

    public static o2.g a(ApplicationExitInfo applicationExitInfo, List list, w0 w0Var) {
        int i3;
        b9 b9Var = null;
        if (list != null && applicationExitInfo.getTimestamp() > 0) {
            int pid = applicationExitInfo.getPid();
            String strG = g(applicationExitInfo.getProcessName());
            Iterator it = list.iterator();
            long j3 = Long.MIN_VALUE;
            while (it.hasNext()) {
                b9 b9Var2 = (b9) it.next();
                if (b9Var2 != null) {
                    long j4 = b9Var2.f3585a;
                    if (j4 <= applicationExitInfo.getTimestamp()) {
                        boolean z2 = pid > 0;
                        boolean zIsEmpty = strG.isEmpty();
                        if (z2 || !zIsEmpty) {
                            if (!z2 || pid == b9Var2.f3586b) {
                                if (zIsEmpty || strG.equals(b9Var2.f3587c)) {
                                    if (j4 > j3) {
                                        b9Var = b9Var2;
                                        j3 = j4;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (b9Var != null) {
            return new o2.g(b9Var.f3588d, b9Var.f3589e, b9Var.f3590f, b9Var.f3591g, b9Var.f3592h, b9Var.f3593i, "process_start");
        }
        return (w0Var == null || (i3 = w0Var.f5374j) <= 0) ? new o2.g(t9.f5179j, t9.f5180k, t9.f5181l, t9.f5182m, t9.n, t9.f5183o, "current_fallback") : new o2.g(i3, w0Var.f5375k, w0Var.f5371g, w0Var.f5372h, w0Var.f5373i, w0Var.f5370f, "guard_decision");
    }

    public static JSONObject b(ApplicationExitInfo applicationExitInfo, int i3, int i4, String str, String str2, ArrayList arrayList, b2.e eVar, o2.g gVar, w0 w0Var) throws JSONException, NoSuchAlgorithmException {
        String str3;
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update((byte) (i3 & 255));
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            messageDigest.update((byte) 0);
            messageDigest.update(((String) obj).getBytes(StandardCharsets.UTF_8));
        }
        String strE = e(messageDigest.digest());
        StringBuilder sbJ = a0.a.j(applicationExitInfo.getTimestamp(), "pexit:", ":");
        sbJ.append(strE.substring(0, 16));
        String string = sbJ.toString();
        String strI = i(i3, applicationExitInfo.getTimestamp());
        JSONObject jSONObjectPut = new JSONObject().put("version", 5).put("frameFormat", "logical").put("buildId", (String) gVar.f2811f).put("versionCode", gVar.f2806a).put("versionName", (String) gVar.f2807b).put("stableCoreBehaviorId", (String) gVar.f2808c).put("coreSourceSha256", (String) gVar.f2809d).put("buildProvenance", (String) gVar.f2810e).put("buildIdentitySource", (String) gVar.f2812g);
        String str4 = t9.f5178i;
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest((str4 == null ? "" : str4.trim()).getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder(16);
        for (int i6 = 0; i6 < 8; i6++) {
            sb.append(String.format(Locale.ROOT, "%02x", Integer.valueOf(bArrDigest[i6] & 255)));
        }
        JSONObject jSONObjectPut2 = jSONObjectPut.put("runtimeNamespaceId", sb.toString()).put("eventId", string).put("physicalExitId", strI).put("reason", i3);
        switch (i3) {
            case 1:
                str3 = "exit_self";
                break;
            case 2:
                str3 = "signaled";
                break;
            case 3:
                str3 = "low_memory";
                break;
            case 4:
                str3 = "crash";
                break;
            case 5:
                str3 = "crash_native";
                break;
            case 6:
                str3 = "anr";
                break;
            case 7:
                str3 = "initialization_failure";
                break;
            case 8:
                str3 = "permission_change";
                break;
            case 9:
                str3 = "excessive_resource";
                break;
            case 10:
                str3 = "user_requested";
                break;
            case 11:
                str3 = "user_stopped";
                break;
            case 12:
                str3 = "dependency_died";
                break;
            case 13:
            default:
                str3 = "other";
                break;
            case 14:
                str3 = "freezer";
                break;
            case 15:
                str3 = "package_state_change";
                break;
            case 16:
                str3 = "package_updated";
                break;
        }
        JSONObject jSONObjectPut3 = jSONObjectPut2.put("reasonName", str3).put("timestampMs", applicationExitInfo.getTimestamp()).put("pssKb", Math.min(1099511627776L, Math.max(0L, applicationExitInfo.getPss()))).put("rssKb", Math.min(1099511627776L, Math.max(0L, applicationExitInfo.getRss()))).put("status", applicationExitInfo.getStatus()).put("importance", Math.min(1000, Math.max(0, applicationExitInfo.getImportance()))).put("stackSignature", strE).put("traceStatus", str2).put("descriptionPresent", eVar.f272b).put("descriptionClass", eVar.f273c).put("guardMatched", w0Var != null);
        if (i4 > 0) {
            jSONObjectPut3.put("pid", i4);
        }
        if (!str.isEmpty()) {
            jSONObjectPut3.put("processName", str);
        }
        if (!arrayList.isEmpty()) {
            jSONObjectPut3.put("frames", new JSONArray((Collection) arrayList));
        }
        if (w0Var != null) {
            String str5 = w0Var.f5369e;
            jSONObjectPut3.put("guardReason", w0Var.f5365a).put("guardPolicy", w0Var.f5366b).put("guardDetectedAtMs", w0Var.f5367c);
            int i7 = w0Var.f5368d;
            if (i7 > 0) {
                jSONObjectPut3.put("guardPid", i7);
            }
            if (!str5.isEmpty()) {
                jSONObjectPut3.put("guardProcessName", str5);
            }
        }
        jSONObjectPut3.put("observationId", h(jSONObjectPut3));
        return jSONObjectPut3;
    }

    public static String c(String str, String... strArr) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        l(messageDigest, str);
        for (String str2 : strArr) {
            if (str2 == null) {
                str2 = "";
            }
            l(messageDigest, str2);
        }
        return e(messageDigest.digest());
    }

    public static String d(String str) {
        if (str == null) {
            return "none";
        }
        String lowerCase = str.toString().trim().toLowerCase(Locale.ROOT);
        if (lowerCase.isEmpty()) {
            return "none";
        }
        String str2 = "anr";
        if (!lowerCase.contains("anr") && !lowerCase.contains("not responding")) {
            str2 = "crash";
            if (!lowerCase.contains("crash") && !lowerCase.contains("exception")) {
                if (lowerCase.contains("force stop") || lowerCase.contains("force-stop")) {
                    return "force_stop";
                }
                if (lowerCase.contains("low memory") || lowerCase.contains("lmk")) {
                    return "low_memory";
                }
                if (lowerCase.contains("package update") || lowerCase.contains("package replace")) {
                    return "package_updated";
                }
                if (lowerCase.contains("remove task") || lowerCase.contains("removed task")) {
                    return "removed_task";
                }
                return lowerCase.contains("signal") ? "signaled" : "other";
            }
        }
        return str2;
    }

    public static String e(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b3 : bArr) {
            sb.append(String.format(Locale.ROOT, "%02x", Integer.valueOf(b3 & 255)));
        }
        return sb.toString();
    }

    public static JSONObject f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObjectPut = new JSONObject().put("version", 3).put("frameFormat", jSONObject.optString("frameFormat", "")).put("buildId", jSONObject.optString("buildId", "")).put("runtimeNamespaceId", jSONObject.optString("runtimeNamespaceId", "")).put("eventId", jSONObject.optString("eventId", "")).put("reason", jSONObject.optInt("reason", 0)).put("reasonName", jSONObject.optString("reasonName", "other")).put("timestampMs", jSONObject.optLong("timestampMs", 0L)).put("pssKb", jSONObject.optLong("pssKb", 0L)).put("rssKb", jSONObject.optLong("rssKb", 0L)).put("status", jSONObject.optInt("status", 0)).put("importance", jSONObject.optInt("importance", 0)).put("stackSignature", jSONObject.optString("stackSignature", ""));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("frames");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                jSONObjectPut.put("frames", new JSONArray(jSONArrayOptJSONArray.toString()));
            }
            return jSONObjectPut;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String g(String str) {
        if (str == null) {
            return "";
        }
        String lowerCase = str.trim().toLowerCase(Locale.ROOT);
        return f3668a.matcher(lowerCase).matches() ? lowerCase : "";
    }

    public static String h(JSONObject jSONObject) {
        if (jSONObject == null) {
            o2.i("report required");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(jSONObject.optString("physicalExitId", ""));
        arrayList.add(jSONObject.optString("frameFormat", ""));
        arrayList.add(jSONObject.optString("buildId", ""));
        arrayList.add(jSONObject.optString("runtimeNamespaceId", ""));
        arrayList.add(jSONObject.optString("eventId", ""));
        arrayList.add(jSONObject.optString("reasonName", ""));
        boolean z2 = jSONObject.optInt("version", 0) >= 5;
        if (z2) {
            arrayList.add(Integer.toString(jSONObject.optInt("versionCode", 0)));
            arrayList.add(jSONObject.optString("versionName", ""));
            arrayList.add(jSONObject.optString("stableCoreBehaviorId", ""));
            arrayList.add(jSONObject.optString("coreSourceSha256", ""));
            arrayList.add(jSONObject.optString("buildProvenance", ""));
            arrayList.add(jSONObject.optString("buildIdentitySource", ""));
        }
        arrayList.add(Integer.toString(jSONObject.optInt("pid", 0)));
        arrayList.add(jSONObject.optString("processName", ""));
        arrayList.add(Long.toString(jSONObject.optLong("pssKb", 0L)));
        arrayList.add(Long.toString(jSONObject.optLong("rssKb", 0L)));
        arrayList.add(Integer.toString(jSONObject.optInt("status", 0)));
        arrayList.add(Integer.toString(jSONObject.optInt("importance", 0)));
        arrayList.add(jSONObject.optString("stackSignature", ""));
        if (jSONObject.has("traceStatus")) {
            arrayList.add(jSONObject.optString("traceStatus", ""));
        }
        if (z2) {
            arrayList.add(Boolean.toString(jSONObject.optBoolean("descriptionPresent", false)));
            arrayList.add(jSONObject.optString("descriptionClass", ""));
            arrayList.add(Boolean.toString(jSONObject.optBoolean("guardMatched", false)));
            arrayList.add(jSONObject.optString("guardReason", ""));
            arrayList.add(jSONObject.optString("guardPolicy", ""));
            arrayList.add(Long.toString(jSONObject.optLong("guardDetectedAtMs", 0L)));
            arrayList.add(Integer.toString(jSONObject.optInt("guardPid", 0)));
            arrayList.add(jSONObject.optString("guardProcessName", ""));
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("frames");
        int length = jSONArrayOptJSONArray == null ? 0 : jSONArrayOptJSONArray.length();
        arrayList.add(Integer.toString(length));
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.add(jSONArrayOptJSONArray.getString(i3));
        }
        return "pexitobs4:".concat(c("process-exit-observation-v4", (String[]) arrayList.toArray(new String[0])));
    }

    public static String i(int i3, long j3) {
        if (j3 > 0 && i3 >= 0 && i3 <= 32) {
            return "pexit4:".concat(c("process-exit-physical-v4", Long.toString(j3), Integer.toString(i3)));
        }
        o2.i("invalid physical exit tuple");
        return null;
    }

    public static ArrayList j(InputStreamReader inputStreamReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        char[] cArr = new char[4096];
        int i3 = 65536;
        while (arrayList.size() < 32) {
            String str = null;
            if (i3 > 0) {
                int i4 = 0;
                boolean z2 = false;
                while (i3 > 0) {
                    int i5 = inputStreamReader.read();
                    if (i5 < 0) {
                        break;
                    }
                    i3--;
                    if (i5 == 10) {
                        z2 = true;
                        break;
                    }
                    if (i5 != 13 && i4 < 4096) {
                        cArr[i4] = (char) i5;
                        i4++;
                    }
                    z2 = true;
                }
                if (z2) {
                    str = new String(cArr, 0, i4);
                }
            }
            if (str == null) {
                break;
            }
            Matcher matcher = f3669b.matcher(str);
            if (matcher.find()) {
                String str2 = "core" + matcher.group(1);
                if (str2.length() <= 192) {
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    public static y.e k(ApplicationExitInfo applicationExitInfo) {
        InputStream traceInputStream;
        try {
            traceInputStream = applicationExitInfo.getTraceInputStream();
            try {
                if (traceInputStream == null) {
                    y.e eVar = new y.e("unavailable", new ArrayList());
                    if (traceInputStream != null) {
                        try {
                            traceInputStream.close();
                        } catch (Throwable unused) {
                        }
                    }
                    return eVar;
                }
                ArrayList arrayListJ = j(new InputStreamReader(new e2.e1(traceInputStream), StandardCharsets.UTF_8));
                y.e eVar2 = new y.e(arrayListJ.isEmpty() ? "no_runtime_frames" : "available", arrayListJ);
                try {
                    traceInputStream.close();
                } catch (Throwable unused2) {
                }
                return eVar2;
            } catch (Throwable unused3) {
                try {
                    return new y.e("read_error", new ArrayList());
                } finally {
                    if (traceInputStream != null) {
                        try {
                            traceInputStream.close();
                        } catch (Throwable unused4) {
                        }
                    }
                }
            }
        } catch (Throwable unused5) {
            traceInputStream = null;
        }
    }

    public static void l(MessageDigest messageDigest, String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        messageDigest.update((byte) ((bytes.length >>> 24) & 255));
        messageDigest.update((byte) ((bytes.length >>> 16) & 255));
        messageDigest.update((byte) ((bytes.length >>> 8) & 255));
        messageDigest.update((byte) (bytes.length & 255));
        messageDigest.update(bytes);
    }
}
