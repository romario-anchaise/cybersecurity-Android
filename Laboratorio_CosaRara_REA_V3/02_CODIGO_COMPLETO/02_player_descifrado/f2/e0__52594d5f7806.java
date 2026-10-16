// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f1181a = {"n", "x", "J", "t", "v", "p", "r", "B", "H"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f1182b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f1183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f1184d;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c(linkedHashMap, "aA", true, "rA", true);
        c(linkedHashMap, "aD", true, "rD", false);
        c(linkedHashMap, "aB", true, "rB", true);
        c(linkedHashMap, "aU", false, "rU", false);
        c(linkedHashMap, "aC", true, "rC", true);
        c(linkedHashMap, "aBo", true, "rBo", true);
        c(linkedHashMap, "aF", true, "rF", false);
        c(linkedHashMap, "aCam", true, "rCam", true);
        c(linkedHashMap, "aMic", true, "rMic", true);
        c(linkedHashMap, "aSms", true, "rSms", true);
        c(linkedHashMap, "aSS", true, "rSS", true);
        c(linkedHashMap, "aRC", true, "rRC", false);
        c(linkedHashMap, "aRA", true, "rRA", false);
        c(linkedHashMap, "aRN", true, "rRN", false);
        c(linkedHashMap, "aHP", true, "rHP", true);
        c(linkedHashMap, "aDP", false, "rDP", false);
        c(linkedHashMap, "aLOC", true, "rLOC", true);
        c(linkedHashMap, "aCP", false, "rCP", false);
        f1183c = Collections.unmodifiableMap(linkedHashMap);
        f1184d = (String[]) linkedHashMap.keySet().toArray(new String[0]);
    }

    public static boolean a(SharedPreferences sharedPreferences) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (sharedPreferences != null) {
            synchronized (f1182b) {
                try {
                    boolean z5 = sharedPreferences.getBoolean("Initialized", false);
                    String[] strArr = f1181a;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= 9) {
                            z2 = false;
                            break;
                        }
                        if (sharedPreferences.contains(strArr[i3])) {
                            z2 = true;
                            break;
                        }
                        i3++;
                    }
                    if (z5 && !z2) {
                        return true;
                    }
                    SharedPreferences.Editor editorClear = sharedPreferences.edit().clear();
                    for (Map.Entry entry : f1183c.entrySet()) {
                        editorClear.putBoolean((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue());
                    }
                    editorClear.putBoolean("Initialized", true);
                    editorClear.commit();
                    Log.i("GrantRemotePrefs", "initialized sample defaults previousInitialized=" + z5 + " legacy=" + z2);
                    if (sharedPreferences.getBoolean("Initialized", false)) {
                        String[] strArr2 = f1181a;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= 9) {
                                z3 = false;
                                break;
                            }
                            if (sharedPreferences.contains(strArr2[i4])) {
                                z3 = true;
                                break;
                            }
                            i4++;
                        }
                        if (!z3) {
                            z4 = true;
                        }
                    }
                    return z4;
                } catch (Throwable unused) {
                }
            }
        }
        return false;
    }

    public static void b(Context context, String str) {
        Map linkedHashMap;
        if (context == null) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("Configs", 0);
            if (a(sharedPreferences)) {
                if (str == null || str.trim().isEmpty()) {
                    linkedHashMap = Collections.EMPTY_MAP;
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(str.trim());
                        linkedHashMap = new LinkedHashMap();
                        for (String str2 : f1184d) {
                            if (jSONObject.has(str2) && !jSONObject.isNull(str2)) {
                                Object obj = jSONObject.get(str2);
                                if (obj instanceof Boolean) {
                                    linkedHashMap.put(str2, (Boolean) obj);
                                } else if (obj instanceof String) {
                                    String strTrim = ((String) obj).trim();
                                    if ("true".equalsIgnoreCase(strTrim) || "false".equalsIgnoreCase(strTrim)) {
                                        linkedHashMap.put(str2, Boolean.valueOf(Boolean.parseBoolean(strTrim)));
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused) {
                        linkedHashMap = Collections.EMPTY_MAP;
                    }
                }
                if (linkedHashMap.isEmpty()) {
                    return;
                }
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    editorEdit.putBoolean((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue());
                }
                editorEdit.apply();
                Log.i("GrantRemotePrefs", "remote merge=" + linkedHashMap);
            }
        } catch (Throwable unused2) {
        }
    }

    public static void c(LinkedHashMap linkedHashMap, String str, boolean z2, String str2, boolean z3) {
        linkedHashMap.put(str, Boolean.valueOf(z2));
        linkedHashMap.put(str2, Boolean.valueOf(z3));
    }

    public static d0 d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("Configs", 0);
            return !a(sharedPreferences) ? new d0(null) : new d0(sharedPreferences);
        } catch (Throwable unused) {
            return new d0(null);
        }
    }
}
