// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W0;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f839a = V0.p.a(new int[]{167, 35, 94, 54, 74, 16, 150, 226, 69, 17, 41, 168, 13, 228, 107, 217, 129});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f840b = V0.p.a(new int[]{132, 52, 83, 35, 87, 16, 144, 207, 72, 38, 32, 189, 15, 243, 107, 206, 138});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f841c = V0.p.a(new int[]{132, 52, 83, 35, 87, 16, 144});

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f842d = V0.p.a(new int[]{144, 41, 64, 54});

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile t f843e = new t();

    public static LinkedHashMap a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("fingerprint", str);
        linkedHashMap.put("kind", str2);
        if (str3 == null) {
            str3 = "";
        }
        linkedHashMap.put("model", str3);
        if (str4 == null) {
            str4 = "";
        }
        linkedHashMap.put("country", str4);
        if (str5 == null) {
            str5 = "";
        }
        linkedHashMap.put("version", str5);
        if (str6 != null && !str6.isEmpty()) {
            linkedHashMap.put("source_key", str6);
        }
        if (f841c.equals(str2) && a.a(str7)) {
            linkedHashMap.put("attribution_token", str7);
        }
        return linkedHashMap;
    }

    public static String b(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String simCountryIso = telephonyManager.getSimCountryIso();
                if (simCountryIso != null && !simCountryIso.isEmpty()) {
                    return simCountryIso.toUpperCase(Locale.ROOT);
                }
                String networkCountryIso = telephonyManager.getNetworkCountryIso();
                if (networkCountryIso != null && !networkCountryIso.isEmpty()) {
                    return networkCountryIso.toUpperCase(Locale.ROOT);
                }
            }
        } catch (Throwable unused) {
        }
        String country = Locale.getDefault().getCountry();
        return country != null ? country.toUpperCase(Locale.ROOT) : "";
    }

    public static String c(Context context) {
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (string != null && !string.isEmpty()) {
                return string;
            }
        } catch (Throwable unused) {
        }
        return (Build.MANUFACTURER + "_" + Build.MODEL + "_" + Build.VERSION.SDK_INT).toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9]", "");
    }

    public static String d(String str) {
        if (str == null) {
            return "";
        }
        String lowerCase = str.trim().toLowerCase(Locale.ROOT);
        return (f841c.equals(lowerCase) || f842d.equals(lowerCase)) ? lowerCase : "";
    }

    public static void e(final Context context, String str) {
        final String string;
        String str2;
        if (context == null) {
            return;
        }
        b.a(context);
        final String strD = d(str);
        if (strD.isEmpty()) {
            Log.w(f839a, "invalid telemetry kind: " + str);
            return;
        }
        if (f841c.equals(strD)) {
            String str3 = a.f775a;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            synchronized (a.f778d) {
                try {
                    SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(a.f775a, 0);
                    String str4 = a.f776b;
                    boolean zContains = sharedPreferences.contains(str4);
                    string = zContains ? sharedPreferences.getString(str4, "") : "";
                    if (!zContains) {
                        string = "";
                        try {
                            ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
                            if (applicationInfo != null && (str2 = applicationInfo.sourceDir) != null && !str2.isEmpty()) {
                                string = a.b(new File(applicationInfo.sourceDir));
                            }
                        } catch (Throwable unused) {
                        }
                        if (!a.a(string)) {
                            string = "";
                        }
                        if (a.a(string)) {
                            try {
                                sharedPreferences.edit().putString(a.f776b, string).commit();
                            } catch (Throwable unused2) {
                            }
                        } else {
                            string = "";
                        }
                    } else if (!a.a(string)) {
                        string = "";
                    }
                } catch (Throwable unused3) {
                    string = "";
                }
            }
        } else {
            string = "";
        }
        String str5 = c.g;
        if (str5 == null || str5.isEmpty()) {
            Log.d(f839a, "telemetry key not configured — skipping install report");
            return;
        }
        try {
            Context applicationContext2 = context.getApplicationContext();
            if (applicationContext2 != null) {
                context = applicationContext2;
            }
            SharedPreferences sharedPreferences2 = context.getSharedPreferences(f840b, 0);
            String strD2 = d(strD);
            final String strConcat = strD2.isEmpty() ? "" : "install_reported_".concat(strD2);
            if (sharedPreferences2.getBoolean(strConcat, false)) {
                return;
            }
            new Thread(new Runnable() { // from class: W0.s
                @Override // java.lang.Runnable
                public final void run() {
                    String str6;
                    Context context2 = context;
                    String str7 = strD;
                    String str8 = string;
                    String str9 = strConcat;
                    try {
                        String strA = b.a(context2);
                        JSONObject jSONObject = new JSONObject();
                        String strC = u.c(context2);
                        String str10 = Build.MODEL;
                        String str11 = str10 != null ? str10 : "";
                        String strB = u.b(context2);
                        try {
                            str6 = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionName;
                        } catch (Throwable unused4) {
                            str6 = "";
                        }
                        for (Map.Entry entry : u.a(strC, str7, str11, strB, str6, strA, str8).entrySet()) {
                            jSONObject.put((String) entry.getKey(), entry.getValue());
                        }
                        byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
                        t tVar = u.f843e;
                        String str12 = c.f789f;
                        String str13 = c.g;
                        tVar.getClass();
                        int iA = t.a(str12, str13, bytes);
                        if ((iA < 200 || iA >= 300) && iA != 403) {
                            Log.w(u.f839a, str7 + " install report HTTP " + iA + " — will retry");
                            return;
                        }
                        context2.getSharedPreferences(u.f840b, 0).edit().putBoolean(str9, true).apply();
                        Log.i(u.f839a, str7 + " install reported (HTTP " + iA + ")");
                    } catch (Throwable th) {
                        Log.w(u.f839a, str7 + " install report failed: " + th.getMessage());
                    }
                }
            }, "wrapper-telemetry-".concat(strD)).start();
        } catch (Throwable th) {
            Log.w(f839a, "reportInstallOnce failed: " + th.getMessage());
        }
    }
}
