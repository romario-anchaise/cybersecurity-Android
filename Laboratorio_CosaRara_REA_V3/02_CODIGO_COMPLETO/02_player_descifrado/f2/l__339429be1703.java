// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import lyr.stable.runtime.ScreenMirrorService;
import lyr.stable.runtime.setup.AuthSetupActivity;
import org.json.JSONArray;
import org.json.JSONObject;
import w1.cf;
import w1.j4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f1231a = {"查看和执行", "查看您与之交互", "检索窗口", "无障碍服务", "accessibility service", "retrieve window", "observe your screen", "view and perform", "servicio de accesibilidad", "ver y realizar"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f1232b = {"已安装的服务", "已下载的应用", "已安装的应用", "installed services", "downloaded apps", "installed apps", "servicios instalados", "aplicaciones descargadas"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f1233c = {"无障碍", "辅助功能", "accessibility", "accesibilidad"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f1234d = {"wlan", "wi-fi", "wifi", "蓝牙", "bluetooth", "电池", "battery", "显示", "display", "brightness", "声音", "sound", "通知", "notification", "batería", "pantalla", "brillo", "sonido", "notificaciones"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f1235e = {"自启动", "autostart", "auto-start", "auto start", "后台自启动", "开机自启动", "电池优化", "battery optimization", "不受限制", "unrestricted", "允许后台高耗电", "不优化", "inicio automático", "iniciar automáticamente", "optimización de batería", "sin restricciones", "no optimizar", "actividad en segundo plano"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f1236f = {"转到上一层", "转到上一级", "向上导航", "navigate up", "navigate to previous", "navigate to parent", "navegar hacia arriba", "subir un nivel"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f1237g = {"允许", "确定", "allow", "ok", "got it", "permitir", "aceptar", "acepto"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f1238h = {"取消", "拒绝", "不允许", "cancel", "deny", "don't allow", "dont allow", "rechazar", "cancelar"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f1239i = {"accessibility", "accessibilityservice", "downloadedapps", "installedservices", "screenreader", "无障碍", "辅助功能", "已下载的应用", "已安装的服务", "无障碍服务", "辅助服务"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f1240j = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f1241k = {"应用", "應用", "Apps", "Aplicaciones"};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String[] f1242l = {"自启动", "自啟動", "Auto launch", "Autostart", "Iniciar automáticamente", "Inicio automático"};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f1243m = {"关联启动", "關聯啟動", "Associated launch", "Ejecución de aplicaciones asociadas", "Inicio asociado"};
    public static final String[] n = {"电池用量", "電池用量", "电池使用情况", "電池使用情況", "耗电详情", "耗電詳情", "耗电管理", "耗電管理", "Battery usage", "App battery usage", "Uso de batería", "Uso de la batería"};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String[] f1244o = {"允许后台运行", "允許後台執行", "允许后台活动", "允許背景活動", "完全允许后台行为", "完全允許背景行為", "完全允许后台运行", "完全允許後台執行", "Allow background activity", "Allow all background activity", "Run in background", "Permitir actividad en segundo plano", "Permitir toda la actividad en segundo plano", "Ejecutar en segundo plano"};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String[] f1245p = {"app_manager_permission_power_saving_title", "app_manager_details_electric_title_new", "app_manager_details_electric_title"};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String[] f1246q = {"app_manager_powerkeeper_no_restrict", "app_powerkeeper_no_restrict"};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String[] f1247r = {"省电策略", "省電策略", "Battery saver", "Battery saving", "Ahorro de batería"};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String[] f1248s = {"无限制", "無限制", "No restrictions", "Sin restricciones", "Nenhuma restrição", "Нет ограничений", "Kısıtlama yok", "لا توجد قيود"};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Object f1249t = new Object();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static volatile Intent f1250u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static volatile int f1251v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static volatile HandlerThread f1252w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static volatile Handler f1253x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static volatile boolean f1254y;

    public static void A(Context context) {
        try {
            SharedPreferences sharedPreferencesE = c2.p.e(context, "bind_shield");
            if (sharedPreferencesE == null || (sharedPreferencesE instanceof c2.k)) {
                Log.i("BindShield", "BOOT_SHIELD_SKIP|ce_locked");
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() + 55000;
            sharedPreferencesE.edit().putBoolean("pref_boot_shield_armed_by_boot", true).putLong("pref_boot_shield_armed_until", jCurrentTimeMillis).apply();
            Log.i("BindShield", "BOOT_SHIELD_ARMED until=" + jCurrentTimeMillis);
        } catch (Throwable unused) {
            Log.i("BindShield", "BOOT_SHIELD_SKIP|ce_locked");
        }
    }

    public static ArrayList B(Context context, String str, String[] strArr, String... strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArr2) {
            b(b0(context, str, str2), arrayList);
        }
        for (String str3 : strArr) {
            b(str3, arrayList);
        }
        return arrayList;
    }

    public static ArrayList C(String str, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        b(str, arrayList);
        for (String str2 : strArr) {
            b(str2, arrayList);
        }
        return arrayList;
    }

    public static boolean D(String str, String str2, String str3, String[] strArr) {
        if (H(str3) || I(str3)) {
            return false;
        }
        if (G(str2, str3, strArr)) {
            return true;
        }
        if (str != null && !str.isEmpty()) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            if ("com.samsung.accessibility".equals(lowerCase) || "com.miui.accessibility".equals(lowerCase) || "com.coloros.accessibility".equals(lowerCase) || "com.oplus.accessibility".equals(lowerCase) || "com.huawei.accessibility".equals(lowerCase)) {
                return true;
            }
        }
        if (L(str2).contains("accessibility")) {
            return true;
        }
        String strL = L(str3);
        if (i(strL, f1232b)) {
            return true;
        }
        return w(str) && i(strL, f1233c);
    }

    public static boolean E(String str, String str2, String str3, String str4, String str5) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str5 == null || !str5.equals(str)) {
            String strU = U(str + " " + str2);
            if ("com.android.settings".equals(str) || "com.android.settings".equals(str2) || strU.contains("settings") || strU.contains("accessibility") || strU.contains("permissionmanager")) {
                if (U(str3).contains("accessibility")) {
                    return true;
                }
                String strU2 = U(str4);
                for (int i3 = 0; i3 < 11; i3++) {
                    if (strU2.contains(U(f1239i[i3]))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean F(String str) {
        return j(str, "com.vivo.permissionmanager", "com.miui.securitycenter", "com.coloros.safecenter", "com.oppo.safe", "com.oplus.safecenter", "com.oplus.battery", "com.huawei.systemmanager", "autostart", "startup", "bgstart");
    }

    public static boolean G(String str, String str2, String[] strArr) {
        if (!H(str2) && !I(str2)) {
            String strL = L(str);
            if (strL.contains("toggleaccessibility") || strL.contains("accessibilityservice") || strL.contains("accessibilityservicesettings") || i(L(str2), f1231a)) {
                return true;
            }
            String strL2 = L(str2);
            if (!strL2.isEmpty() && strArr != null) {
                for (String str3 : strArr) {
                    if (str3 != null && !str3.isEmpty() && strL2.contains(str3.toLowerCase(Locale.ROOT))) {
                        if (strL2.contains("要开启") || strL2.contains("要启用") || strL2.contains("使用") || strL2.contains("use ") || strL2.contains("usar ")) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean H(String str) {
        String strL = L(str);
        if (strL.isEmpty() || i(L(strL), f1231a)) {
            return false;
        }
        return i(strL, f1235e);
    }

    public static boolean I(String str) {
        String strL = L(str);
        if (!strL.isEmpty()) {
            int i3 = 0;
            for (int i4 = 0; i4 < 19; i4++) {
                if (strL.contains(f1234d[i4])) {
                    i3++;
                }
            }
            if (i3 >= 2) {
                return true;
            }
        }
        return false;
    }

    public static boolean J(String str, String str2, String str3) {
        return !H(str3) && !I(str3) && w(str) && L(str2).contains("subsettings") && str3.trim().length() < 24;
    }

    public static boolean K(String str) {
        return j(str, "com.android.settings", "com.google.android.permissioncontroller", "com.android.permissioncontroller", "com.vivo.permissionmanager", "com.vivo.abe", "com.miui.powerkeeper", "com.miui.securitycenter", "com.coloros.safecenter", "com.oppo.safe", "com.oplus.safecenter", "com.huawei.systemmanager", "battery", "powerkeeper", "powermanager");
    }

    public static String L(String str) {
        return str == null ? "" : str.toLowerCase(Locale.ROOT);
    }

    public static void M(Context context, String str) {
        SharedPreferences.Editor editorPutBoolean = context.getApplicationContext().getSharedPreferences("auth_setup_steps", 4).edit().putBoolean("auto_start_explicitly_skipped", true).putInt("auto_start_skip_version", 3).putBoolean("auto_start_step_verified", false);
        if (str == null) {
            str = "";
        }
        editorPutBoolean.putString("auto_start_skip_reason", str).apply();
    }

    public static void N(Context context, String str) {
        SharedPreferences.Editor editorRemove = Y(context).edit().putBoolean("auto_start_step_verified", true).putInt("auto_start_validation_version", 3).remove("auto_start_explicitly_skipped").remove("auto_start_skip_version");
        if (str == null) {
            str = "";
        }
        editorRemove.putString("auto_start_done_reason", str).commit();
    }

    public static void O(Context context, int i3, Intent intent) {
        if (i3 != -1 || intent == null) {
            return;
        }
        synchronized (f1249t) {
            f1251v = i3;
            f1250u = new Intent(intent);
            w1.e eVarA = w1.f.a(context, null);
            if (eVarA.b(SystemClock.elapsedRealtime())) {
                i0.R(context, true, eVarA.f3825c);
            } else {
                i0.R(context, false, 0L);
            }
        }
        if (j4.a(context) == 2) {
            try {
                cf.K().i0(context, "projection_grant_stashed");
            } catch (Throwable unused) {
            }
        } else {
            w1.m mVarC = w1.m.c(context);
            mVarC.getClass();
            mVarC.f(16, w1.n.h0("projection_grant_stashed"));
        }
    }

    public static void P(AuthSetupActivity authSetupActivity, int i3, long j3) {
        c2.p.e(authSetupActivity, "auto_setup_prefs").edit().putBoolean(i0("settings_launch_in_flight", i3), true).putLong(i0("settings_launched_at", i3), j3).putLong(i0("deadline", i3), i0.O(i3) + j3).apply();
    }

    public static void Q(AuthSetupActivity authSetupActivity, int i3) {
        c2.p.e(authSetupActivity, "auto_setup_prefs").edit().putBoolean(i0("attempted", i3), true).apply();
    }

    public static void R(Context context, String str) {
        SharedPreferences.Editor editorPutBoolean = context.getApplicationContext().getSharedPreferences("auth_setup_steps", 4).edit().putBoolean("vendor_battery_explicitly_skipped", true).putInt("vendor_battery_skip_version", 5).putBoolean("vendor_battery_step_verified", false);
        if (str == null) {
            str = "";
        }
        editorPutBoolean.putString("vendor_battery_skip_reason", str).apply();
    }

    public static void S(ContextWrapper contextWrapper, String str) {
        SharedPreferences.Editor editorRemove = Y(contextWrapper).edit().putBoolean("vendor_battery_step_verified", true).putInt("vendor_battery_validation_version", 5).remove("vendor_battery_explicitly_skipped").remove("vendor_battery_skip_version");
        if (str == null) {
            str = "";
        }
        editorRemove.putString("vendor_battery_done_reason", str).apply();
    }

    public static boolean T(String str, ArrayList arrayList) {
        int iIndexOf;
        int i3;
        char cCharAt;
        if (!str.isEmpty()) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            for (int i4 = 0; i4 < lowerCase.length() && (iIndexOf = lowerCase.indexOf("com.", i4)) >= 0; i4 = i3) {
                i3 = iIndexOf + 4;
                while (i3 < lowerCase.length() && (((cCharAt = lowerCase.charAt(i3)) >= 'a' && cCharAt <= 'z') || ((cCharAt >= '0' && cCharAt <= '9') || cCharAt == '_' || cCharAt == '.'))) {
                    i3++;
                }
                String strSubstring = lowerCase.substring(iIndexOf, i3);
                if (strSubstring.length() > 6 && strSubstring.indexOf(46, 4) > 0) {
                    int size = arrayList.size();
                    int i5 = 0;
                    while (i5 < size) {
                        Object obj = arrayList.get(i5);
                        i5++;
                        String str2 = (String) obj;
                        if (str2 == null || !strSubstring.equals(str2.toLowerCase(Locale.ROOT))) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static String U(String str) {
        return str == null ? "" : str.toLowerCase(Locale.ROOT).replaceAll("[\\s_\\-·•]+", "");
    }

    public static ArrayList V(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            String str = (String) obj;
            String strReplaceAll = str != null ? str.toLowerCase(Locale.ROOT).replaceAll("[\\s_\\-·•]+", "") : "";
            if (strReplaceAll.length() >= 4) {
                arrayList2.add(strReplaceAll);
            }
        }
        return arrayList2;
    }

    public static File W(Context context) {
        return new File(new File(context.getFilesDir(), "diagnostics"), "pending_auth_route_discovery.json");
    }

    public static void X(Context context, String str) {
        File file = new File(context.getFilesDir(), "diagnostics");
        if (!file.exists() && !file.mkdirs()) {
            Log.w("AuthRouteDiscovery", "diagnostics dir create failed");
        }
        File file2 = new File(file, "pending_auth_route_discovery.json.tmp");
        File fileW = W(context);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                Charset charset = StandardCharsets.UTF_8;
                fileOutputStream.write(str.getBytes(charset));
                fileOutputStream.close();
                if (fileW.exists() && !fileW.delete()) {
                    Log.w("AuthRouteDiscovery", "pending replace delete failed");
                }
                if (file2.renameTo(fileW)) {
                    return;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(fileW);
                try {
                    fileOutputStream2.write(str.getBytes(charset));
                    fileOutputStream2.close();
                    file2.delete();
                } catch (Throwable th) {
                    fileOutputStream2.close();
                    throw th;
                }
            } catch (Throwable th2) {
                fileOutputStream.close();
                throw th2;
            }
        } catch (Exception e3) {
            Log.w("AuthRouteDiscovery", "persist pending failed: " + e3.getMessage());
        }
    }

    public static SharedPreferences Y(Context context) {
        return context.getApplicationContext().getSharedPreferences("auth_setup_steps", 4);
    }

    public static q0 Z(Context context) {
        String str;
        String str2 = Build.MANUFACTURER;
        boolean z2 = false;
        boolean z3 = k() != 1;
        boolean z4 = z(context);
        boolean zY = y(context);
        String str3 = "required";
        if (z4) {
            str = "verified";
        } else if (zY) {
            str = "skipped";
        } else {
            str = !z3 ? "not_required" : "required";
        }
        boolean zP = p(context);
        SharedPreferences sharedPreferencesY = Y(context);
        if (sharedPreferencesY.getBoolean("auto_start_explicitly_skipped", false) && sharedPreferencesY.getInt("auto_start_skip_version", 0) == 3) {
            z2 = true;
        }
        if (zP) {
            str3 = "verified";
        } else if (z2) {
            str3 = "skipped";
        } else if (!z3) {
            str3 = "not_required";
        }
        return new q0(str, str3);
    }

    public static void a(Intent intent, ComponentName componentName) {
        String strFlattenToString = componentName.flattenToString();
        intent.putExtra("android.intent.extra.COMPONENT_NAME", strFlattenToString);
        intent.putExtra(":settings:fragment_args_key", strFlattenToString);
        Bundle bundle = new Bundle();
        bundle.putString(":settings:fragment_args_key", strFlattenToString);
        bundle.putString("preference_key", strFlattenToString);
        bundle.putParcelable("component_name", componentName);
        intent.putExtra(":settings:show_fragment_args", bundle);
    }

    public static List a0(ScreenMirrorService screenMirrorService, int i3) {
        if (i3 != 0) {
            if (i3 == 1) {
                return c(screenMirrorService);
            }
            if (i3 != 6) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", screenMirrorService.getPackageName());
            arrayList.add(intent);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        String packageName = screenMirrorService.getPackageName();
        Intent intent2 = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
        intent2.setData(Uri.parse("package:" + packageName));
        arrayList2.add(intent2);
        arrayList2.add(new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS"));
        Intent intent3 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent3.setData(Uri.parse("package:" + packageName));
        arrayList2.add(intent3);
        return arrayList2;
    }

    public static void b(String str, ArrayList arrayList) {
        if (str == null) {
            return;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return;
        }
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            if (((String) obj).equalsIgnoreCase(strTrim)) {
                return;
            }
        }
        arrayList.add(strTrim);
    }

    public static String b0(Context context, String str, String str2) {
        String string;
        if (context == null || str2 == null || str2.isEmpty()) {
            return "";
        }
        try {
            Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(str);
            int identifier = resourcesForApplication.getIdentifier(str2, "string", str);
            if (identifier != 0 && (string = resourcesForApplication.getString(identifier)) != null) {
                return string.toString().trim();
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static ArrayList c(Context context) {
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        arrayList.add(intent);
        return arrayList;
    }

    public static int c0(String str, String str2) {
        if (str == null) {
            str = "";
        }
        String lowerCase = str2 != null ? str2.toLowerCase(Locale.ROOT) : "";
        if (str.contains("EditText") || lowerCase.contains("search_src_text") || lowerCase.contains("search_edit")) {
            return 3;
        }
        if (str.contains("AutoCompleteTextView")) {
            return 2;
        }
        return (str.contains("SearchView") || lowerCase.contains("search_view") || lowerCase.contains("search_bar")) ? 1 : 0;
    }

    public static JSONArray d(y.i iVar, int i3) {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObjectE = iVar.e(i3);
        if (jSONObjectE != null && (jSONArrayOptJSONArray = jSONObjectE.optJSONArray("routes")) != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i4);
                if (jSONObjectOptJSONObject2 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("intent")) != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("type");
                    if ("component".equals(strOptString)) {
                        jSONArray.put(jSONObjectOptJSONObject.optString("packageName") + "/" + jSONObjectOptJSONObject.optString("className"));
                    } else if ("action".equals(strOptString)) {
                        jSONArray.put(jSONObjectOptJSONObject.optString("action"));
                    }
                }
            }
        }
        return jSONArray;
    }

    public static e d0(int i3, ComponentName componentName, CharSequence charSequence) {
        String str = Build.MANUFACTURER;
        ArrayList arrayList = new ArrayList();
        if (i3 >= 29) {
            Intent intent = new Intent("android.settings.ACCESSIBILITY_DETAILS_SETTINGS");
            a(intent, componentName);
            arrayList.add(intent);
        }
        String strFlattenToString = componentName.flattenToString();
        String packageName = (charSequence == null || charSequence.length() == 0) ? componentName.getPackageName() : charSequence.toString();
        Bundle bundle = new Bundle();
        bundle.putString("preference_key", strFlattenToString);
        bundle.putBoolean("checked", false);
        bundle.putString("title", packageName);
        bundle.putParcelable("component_name", componentName);
        Intent className = new Intent().setClassName("com.android.settings", "com.android.settings.SubSettings");
        className.putExtra(":settings:show_fragment", "com.android.settings.accessibility.ToggleAccessibilityServicePreferenceFragment");
        className.putExtra(":settings:show_fragment_args", bundle);
        className.putExtra(":settings:fragment_args_key", strFlattenToString);
        arrayList.add(className);
        String lowerCase = str == null ? "" : str.trim().toLowerCase(Locale.ROOT);
        if ((lowerCase != null ? lowerCase.trim().toLowerCase(Locale.ROOT) : "").contains("samsung")) {
            Intent intent2 = new Intent("com.samsung.accessibility.installed_service");
            a(intent2, componentName);
            arrayList.add(intent2);
        } else if (lowerCase.contains("oppo") || lowerCase.contains("realme") || lowerCase.contains("oneplus")) {
            Intent intent3 = new Intent("com.coloros.settings.action.ACCESSIBILITY_SETTINGS");
            a(intent3, componentName);
            arrayList.add(intent3);
            Intent intent4 = new Intent("com.realme.settings.action.ACCESSIBILITY_SETTINGS");
            a(intent4, componentName);
            arrayList.add(intent4);
        } else if (lowerCase.contains("vivo") || lowerCase.contains("iqoo")) {
            Intent intent5 = new Intent("com.vivo.settings.action.ACCESSIBILITY_SETTINGS");
            a(intent5, componentName);
            arrayList.add(intent5);
        } else if (lowerCase.contains("huawei") || lowerCase.contains("honor")) {
            Intent className2 = new Intent().setClassName("com.huawei.settings", "com.huawei.settings.accessibility.HwAccessibilitySettingsActivity");
            a(className2, componentName);
            arrayList.add(className2);
        }
        Intent className3 = new Intent().setClassName("com.android.settings", "com.android.settings.Settings$AccessibilitySettingsActivity");
        a(className3, componentName);
        arrayList.add(className3);
        Intent intent6 = new Intent("android.settings.ACCESSIBILITY_SETTINGS");
        a(intent6, componentName);
        arrayList.add(intent6);
        return new e(arrayList, 0);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00b9  */
    public static JSONObject e(Context context) {
        Object obj;
        boolean z2;
        ArrayList arrayList;
        JSONArray jSONArray;
        Object obj2;
        String str;
        boolean z3;
        String string;
        Iterator<PackageInfo> it;
        String string2;
        JSONObject jSONObject = new JSONObject();
        y.i iVarE = k.f1219b.e(context);
        JSONArray jSONArray2 = new JSONArray();
        int[] iArr = i0.f1209h;
        int i3 = 0;
        boolean z4 = false;
        while (true) {
            obj = "";
            z2 = true;
            if (i3 >= 7) {
                break;
            }
            int i4 = iArr[i3];
            String string3 = c2.p.e(context, "auto_setup_prefs").getString(i0("result", i4), "");
            String string4 = c2.p.e(context, "auto_setup_prefs").getString(i0("reason", i4), "");
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("index", i4);
                jSONObject2.put("key", i0.L(i4));
                jSONObject2.put("result", string3);
                jSONObject2.put("reason", string4);
                boolean zY = i0.y(i4, string3, string4);
                jSONObject2.put("needsRoute", zY);
                JSONArray jSONArrayD = d(iVarE, i4);
                if (jSONArrayD.length() > 0) {
                    jSONObject2.put("attemptedRoutes", jSONArrayD);
                }
                if (zY) {
                    z4 = true;
                }
            } catch (Exception unused) {
            }
            jSONArray2.put(jSONObject2);
            i3++;
        }
        if (z4) {
            arrayList = new ArrayList();
            if (context != null) {
                PackageManager packageManager = context.getPackageManager();
                try {
                    List<PackageInfo> installedPackages = packageManager.getInstalledPackages(1);
                    if (installedPackages != null) {
                        Iterator<PackageInfo> it2 = installedPackages.iterator();
                        while (it2.hasNext()) {
                            PackageInfo next = it2.next();
                            if (next != null && (str = next.packageName) != null && next.activities != null && !i0.w(str, i0.f1205d).isEmpty()) {
                                ApplicationInfo applicationInfo = next.applicationInfo;
                                if (applicationInfo == null) {
                                    z3 = false;
                                } else {
                                    int i5 = applicationInfo.flags;
                                    if ((i5 & 1) == 0 && (i5 & 128) == 0) {
                                        z3 = false;
                                    } else {
                                        z3 = z2;
                                    }
                                }
                                if (applicationInfo != null) {
                                    try {
                                        CharSequence charSequenceLoadLabel = applicationInfo.loadLabel(packageManager);
                                        string = charSequenceLoadLabel == null ? "" : charSequenceLoadLabel.toString();
                                    } catch (Throwable unused2) {
                                    }
                                }
                                ActivityInfo[] activityInfoArr = next.activities;
                                int length = activityInfoArr.length;
                                int i6 = 0;
                                while (i6 < length) {
                                    ActivityInfo activityInfo = activityInfoArr[i6];
                                    if (activityInfo != null) {
                                        it = it2;
                                        if (activityInfo.name == null) {
                                            packageManager = packageManager;
                                        } else {
                                            String str2 = activityInfo.permission;
                                            if (str2 == null) {
                                                str2 = "";
                                            }
                                            boolean z5 = str2.isEmpty() || context.checkCallingOrSelfPermission(str2) == 0;
                                            String str3 = str2;
                                            String str4 = next.packageName;
                                            String str5 = activityInfo.name;
                                            try {
                                                CharSequence charSequenceLoadLabel2 = activityInfo.loadLabel(packageManager);
                                                string2 = charSequenceLoadLabel2 == null ? "" : charSequenceLoadLabel2.toString();
                                            } catch (Throwable unused3) {
                                            }
                                            arrayList.add(new n(str4, str5, string2, string, activityInfo.exported, activityInfo.enabled, z3, str3, z5));
                                        }
                                    } else {
                                        packageManager = packageManager;
                                        it = it2;
                                    }
                                    i6++;
                                    it2 = it;
                                    packageManager = packageManager;
                                    z2 = true;
                                }
                            }
                        }
                    }
                } catch (Throwable unused4) {
                }
            }
        } else {
            arrayList = null;
        }
        JSONObject jSONObject3 = new JSONObject();
        if (arrayList != null) {
            int[] iArr2 = i0.f1204c;
            int i7 = 0;
            for (int i8 = 3; i7 < i8; i8 = 3) {
                int i9 = iArr2[i7];
                if (i0.y(i9, c2.p.e(context, "auto_setup_prefs").getString(i0("result", i9), ""), c2.p.e(context, "auto_setup_prefs").getString(i0("reason", i9), ""))) {
                    try {
                        jSONObject3.put(i0.L(i9), i0.g(i9, arrayList));
                    } catch (Exception unused5) {
                    }
                }
                i7++;
            }
        }
        try {
            jSONArray = new JSONArray(context.getSharedPreferences("auth_route_discovery", 0).getString("page_snapshots", "[]"));
        } catch (Exception unused6) {
            jSONArray = new JSONArray();
        }
        try {
            jSONObject.put("schemaVersion", 1);
            jSONObject.put("flowVersion", 3);
            Object obj3 = Build.MANUFACTURER;
            if (obj3 == null) {
                obj3 = "";
            }
            jSONObject.put("manufacturer", obj3);
            Object obj4 = Build.MODEL;
            if (obj4 != null) {
                obj = obj4;
            }
            jSONObject.put("model", obj);
            jSONObject.put("sdk", Build.VERSION.SDK_INT);
            switch (k()) {
                case 1:
                    obj2 = "UNKNOWN";
                    break;
                case 2:
                    obj2 = "XIAOMI";
                    break;
                case 3:
                    obj2 = "OPPO";
                    break;
                case 4:
                    obj2 = "VIVO";
                    break;
                case 5:
                    obj2 = "HUAWEI";
                    break;
                case 6:
                    obj2 = "SAMSUNG";
                    break;
                default:
                    throw null;
            }
            jSONObject.put("family", obj2);
            jSONObject.put("profileId", (String) iVarE.f5984b);
            jSONObject.put("matchLevel", (String) iVarE.f5985c);
            jSONObject.put("profileFile", (String) iVarE.f5986d);
            jSONObject.put("queryAllPackages", i0.B(context));
            jSONObject.put("steps", jSONArray2);
            if (jSONObject3.length() > 0) {
                jSONObject.put("discoveries", jSONObject3);
            }
            if (jSONArray.length() > 0) {
                jSONObject.put("pageSnapshots", jSONArray);
            }
        } catch (Exception unused7) {
        }
        return jSONObject;
    }

    public static void e0(AuthSetupActivity authSetupActivity, boolean z2) {
        c2.p.e(authSetupActivity, "auto_setup_prefs").edit().putBoolean("auto_setup_flow_active", z2).apply();
    }

    /* JADX WARN: Code duplicated, block: B:55:0x0112  */
    /* JADX WARN: Code duplicated, block: B:57:0x011a  */
    /* JADX WARN: Code duplicated, block: B:58:0x0132 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x0134  */
    /* JADX WARN: Code duplicated, block: B:60:0x0136  */
    /* JADX WARN: Code duplicated, block: B:64:0x015b  */
    /* JADX WARN: Code duplicated, block: B:67:0x0165  */
    /* JADX WARN: Code duplicated, block: B:69:0x0171  */
    /* JADX WARN: Code duplicated, block: B:70:0x0173  */
    /* JADX WARN: Instruction removed from duplicated block: B:57:0x011a, please report this as an issue */
    public static List f(Context context, int i3, List list) {
        String strOptString;
        JSONObject jSONObjectOptJSONObject;
        Iterator<String> itKeys;
        String strOptString2;
        String strReplace;
        String strReplace2;
        Context applicationContext = context.getApplicationContext();
        String str = Build.MANUFACTURER;
        if (i0.J(k(), i3)) {
            if (k() != 2) {
                return c(applicationContext);
            }
            String packageName = applicationContext.getPackageName();
            int i4 = applicationContext.getApplicationInfo().uid;
            Intent intent = new Intent("miui.intent.action.APP_MANAGER_APPLICATION_DETAIL");
            intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.appmanager.ApplicationsDetailsActivity"));
            intent.putExtra("package_name", packageName);
            intent.putExtra("package_uid", i4);
            return Collections.singletonList(intent);
        }
        JSONObject jSONObjectE = k.f1219b.e(applicationContext).e(i3);
        if (jSONObjectE == null) {
            return (list == null || list.isEmpty()) ? Collections.EMPTY_LIST : new ArrayList(list);
        }
        if (jSONObjectE.optBoolean("notRequired", false)) {
            return Collections.EMPTY_LIST;
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectE.optJSONArray("routes");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            if (!jSONObjectE.has("useLegacyFallback") || jSONObjectE.optBoolean("useLegacyFallback", true)) {
                return (list == null || list.isEmpty()) ? Collections.EMPTY_LIST : new ArrayList(list);
            }
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < jSONArrayOptJSONArray.length(); i5++) {
            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i5);
            if (jSONObjectOptJSONObject2 != null) {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("intent");
                Intent intent2 = null;
                if (jSONObjectOptJSONObject3 != null) {
                    String lowerCase = jSONObjectOptJSONObject3.optString("type", "").toLowerCase(Locale.ROOT);
                    if ("component".equals(lowerCase)) {
                        String strOptString3 = jSONObjectOptJSONObject3.optString("packageName", "");
                        String strOptString4 = jSONObjectOptJSONObject3.optString("className", "");
                        if (!TextUtils.isEmpty(strOptString3) && !TextUtils.isEmpty(strOptString4)) {
                            intent2 = new Intent();
                            intent2.setComponent(new ComponentName(strOptString3, strOptString4));
                            strOptString = jSONObjectOptJSONObject3.optString("data", "");
                            if (!TextUtils.isEmpty(strOptString)) {
                                if ("package:".equals(strOptString)) {
                                    intent2.setData(Uri.parse("package:" + applicationContext.getPackageName()));
                                } else {
                                    if (strOptString == null) {
                                        strReplace2 = "";
                                    } else {
                                        strReplace2 = strOptString.replace("{packageName}", applicationContext.getPackageName()).replace("{uid}", String.valueOf(applicationContext.getApplicationInfo().uid));
                                    }
                                    intent2.setData(Uri.parse(strReplace2));
                                }
                            }
                            jSONObjectOptJSONObject = jSONObjectOptJSONObject3.optJSONObject("extras");
                            if (jSONObjectOptJSONObject != null) {
                                itKeys = jSONObjectOptJSONObject.keys();
                                while (itKeys.hasNext()) {
                                    String next = itKeys.next();
                                    strOptString2 = jSONObjectOptJSONObject.optString(next, "");
                                    if (strOptString2 == null) {
                                        strReplace = "";
                                    } else {
                                        strReplace = strOptString2.replace("{packageName}", applicationContext.getPackageName()).replace("{uid}", String.valueOf(applicationContext.getApplicationInfo().uid));
                                    }
                                    intent2.putExtra(next, strReplace);
                                }
                            }
                        }
                    } else if ("action".equals(lowerCase)) {
                        String strOptString5 = jSONObjectOptJSONObject3.optString("action", "");
                        if (!TextUtils.isEmpty(strOptString5)) {
                            intent2 = new Intent(strOptString5);
                            String strOptString6 = jSONObjectOptJSONObject3.optString("packageName", "");
                            if (!TextUtils.isEmpty(strOptString6)) {
                                intent2.setPackage(strOptString6);
                            }
                            strOptString = jSONObjectOptJSONObject3.optString("data", "");
                            if (!TextUtils.isEmpty(strOptString)) {
                                if ("package:".equals(strOptString)) {
                                    intent2.setData(Uri.parse("package:" + applicationContext.getPackageName()));
                                } else {
                                    if (strOptString == null) {
                                        strReplace2 = "";
                                    } else {
                                        strReplace2 = strOptString.replace("{packageName}", applicationContext.getPackageName()).replace("{uid}", String.valueOf(applicationContext.getApplicationInfo().uid));
                                    }
                                    intent2.setData(Uri.parse(strReplace2));
                                }
                            }
                            jSONObjectOptJSONObject = jSONObjectOptJSONObject3.optJSONObject("extras");
                            if (jSONObjectOptJSONObject != null) {
                                itKeys = jSONObjectOptJSONObject.keys();
                                while (itKeys.hasNext()) {
                                    String next2 = itKeys.next();
                                    strOptString2 = jSONObjectOptJSONObject.optString(next2, "");
                                    if (strOptString2 == null) {
                                        strReplace = "";
                                    } else {
                                        strReplace = strOptString2.replace("{packageName}", applicationContext.getPackageName()).replace("{uid}", String.valueOf(applicationContext.getApplicationInfo().uid));
                                    }
                                    intent2.putExtra(next2, strReplace);
                                }
                            }
                        }
                    }
                }
                if (intent2 != null) {
                    arrayList.add(intent2);
                }
            }
        }
        return !arrayList.isEmpty() ? arrayList : Collections.EMPTY_LIST;
    }

    public static void f0(AuthSetupActivity authSetupActivity, int i3) {
        c2.p.e(authSetupActivity, "auto_setup_prefs").edit().putInt("auto_setup_return_attempts", i3).apply();
    }

    public static b2.e g(Context context, Intent intent, String str) {
        String str2;
        String action;
        String str3 = "SETTINGS_ACTIVITY_NOT_RESOLVED";
        boolean z2 = false;
        if (intent == null) {
            return new b2.e(z2, str3, 4);
        }
        boolean z3 = true;
        boolean z4 = intent.getComponent() == null && (action = intent.getAction()) != null && !action.isEmpty() && ("android.settings.ACCESSIBILITY_SETTINGS".equals(action) || "android.settings.APP_BATTERY_SETTINGS".equals(action) || "android.settings.APPLICATION_DETAILS_SETTINGS".equals(action) || "android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS".equals(action) || "android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS".equals(action) || "android.settings.action.MANAGE_OVERLAY_PERMISSION".equals(action) || "android.settings.APP_NOTIFICATION_SETTINGS".equals(action) || "android.settings.CHANNEL_NOTIFICATION_SETTINGS".equals(action) || "android.settings.APPLICATION_SETTINGS".equals(action) || "android.settings.MANAGE_UNKNOWN_APP_SOURCES".equals(action));
        ActivityInfo activityInfo = null;
        try {
            ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
            if (resolveInfoResolveActivity != null) {
                activityInfo = resolveInfoResolveActivity.activityInfo;
            }
        } catch (Throwable unused) {
        }
        boolean z5 = activityInfo != null;
        boolean z6 = activityInfo != null && activityInfo.exported;
        boolean z7 = activityInfo != null && context.getPackageName().equals(activityInfo.packageName);
        boolean z8 = activityInfo == null || (str2 = activityInfo.permission) == null || str2.isEmpty() || context.checkCallingOrSelfPermission(activityInfo.permission) == 0;
        boolean zContains = str.contains("vendor-battery");
        if (z4) {
            return new b2.e(z3, "SETTINGS_GENERIC_INTENT_ALLOWED", 4);
        }
        if (!z5) {
            return new b2.e(z2, str3, 4);
        }
        if (!z6 && !z7) {
            return new b2.e(z2, "SETTINGS_ACTIVITY_NOT_EXPORTED", 4);
        }
        if (z8) {
            return new b2.e(z3, "SETTINGS_ACTIVITY_STARTABLE", 4);
        }
        return zContains ? new b2.e(z3, "SETTINGS_ACTIVITY_REQUIRES_PERMISSION_WILL_ATTEMPT", 4) : new b2.e(z2, "SETTINGS_ACTIVITY_REQUIRES_PERMISSION", 4);
    }

    public static void g0(AuthSetupActivity authSetupActivity, boolean z2) {
        c2.p.e(authSetupActivity, "auto_setup_prefs").edit().putBoolean("auto_setup_waiting_for_app_foreground", z2).apply();
    }

    public static boolean h(Context context, int i3, Intent intent) {
        if (intent == null || i3 != -1 || n(context) != 3) {
            return false;
        }
        if (!q(context) && !v(context, 3, System.currentTimeMillis())) {
            return false;
        }
        O(context, i3, intent);
        return true;
    }

    public static boolean h0(Context context, List list, String str) {
        if (list == null || list.isEmpty()) {
            Log.i("SettingsIntent", str.concat(": empty intent list"));
            return false;
        }
        boolean z2 = context instanceof Activity;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Intent intent = (Intent) it.next();
            if (intent != null) {
                b2.e eVarG = g(context, intent, str);
                if (eVarG.f272b) {
                    try {
                        Intent intent2 = new Intent(intent);
                        if (!z2) {
                            intent2.addFlags(335675392);
                        }
                        context.startActivity(intent2);
                        Log.i("SettingsIntent", str + ": started");
                        return true;
                    } catch (Throwable th) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(": start failed — ");
                        a0.a.p(th, sb, "SettingsIntent");
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(": skip ");
                    a0.a.o(sb2, eVarG.f273c, "SettingsIntent");
                }
            }
        }
        Log.w("SettingsIntent", str + ": no startable intent among " + list.size());
        return false;
    }

    public static boolean i(String str, String[] strArr) {
        if (str != null && !str.isEmpty()) {
            for (String str2 : strArr) {
                if (str2 != null && !str2.isEmpty() && str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String i0(String str, int i3) {
        return "auto_setup_step_" + i3 + "_" + str;
    }

    public static boolean j(String str, String... strArr) {
        if (str != null && !str.isEmpty()) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            for (String str2 : strArr) {
                if (lowerCase.contains(str2.toLowerCase(Locale.ROOT))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static File j0(Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        if (contextCreateDeviceProtectedStorageContext != null) {
            context = contextCreateDeviceProtectedStorageContext;
        }
        return new File(new File(context.getFilesDir(), "a11y"), "bind-shield-v1");
    }

    public static int k() {
        String str = Build.MANUFACTURER;
        String lowerCase = str == null ? "" : str.toLowerCase(Locale.ROOT);
        if (lowerCase.contains("xiaomi") || lowerCase.contains("redmi") || lowerCase.contains("poco")) {
            return 2;
        }
        if (lowerCase.contains("oppo") || lowerCase.contains("realme") || lowerCase.contains("oneplus")) {
            return 3;
        }
        if (lowerCase.contains("vivo") || lowerCase.contains("iqoo")) {
            return 4;
        }
        if (lowerCase.contains("huawei") || lowerCase.contains("honor")) {
            return 5;
        }
        return lowerCase.contains("samsung") ? 6 : 1;
    }

    public static void k0(Context context) {
        g2.a0 a0Var;
        JSONObject jSONObject;
        try {
            cf cfVarK = cf.K();
            if (cfVarK == null || !cfVarK.P()) {
                Log.i("AuthRouteDiscovery", "tunnel offline — pending kept");
                return;
            }
            File fileW = W(context);
            String str = "";
            if (fileW.exists()) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(fileW);
                    try {
                        byte[] bArr = new byte[(int) Math.min(fileW.length(), 32768L)];
                        int i3 = fileInputStream.read(bArr);
                        String str2 = i3 <= 0 ? "" : new String(bArr, 0, i3, StandardCharsets.UTF_8);
                        fileInputStream.close();
                        str = str2;
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                } catch (Exception e3) {
                    Log.w("AuthRouteDiscovery", "read pending failed: " + e3.getMessage());
                }
            }
            if (str.isEmpty()) {
                context.getSharedPreferences("auth_route_discovery", 0).edit().putBoolean("pending", false).apply();
                return;
            }
            if (!str.isEmpty()) {
                String strConcat = "event:auth_route_discovery\t".concat(str);
                if (cf.Q(strConcat) && (a0Var = cfVarK.f3727s0) != null && cfVarK.f3694b.get()) {
                    g2.d0 d0VarW = null;
                    try {
                        try {
                            d0VarW = a0Var.w();
                            d0VarW.f1578k.write(strConcat.concat("\n").getBytes(StandardCharsets.UTF_8));
                            d0VarW.f1578k.flush();
                            Log.i("TunnelManager", "auth_route_discovery reported to gateway");
                            try {
                                d0VarW.close();
                            } catch (IOException e4) {
                                a0.a.m(e4, new StringBuilder("auth_route_discovery stream close failed: "), "TunnelManager");
                            }
                            try {
                                jSONObject = new JSONObject(str);
                            } catch (Exception unused) {
                                jSONObject = new JSONObject();
                            }
                            String strK = i0.K(jSONObject);
                            context.getSharedPreferences("auth_route_discovery", 0).edit().putBoolean("pending", false).putString("last_sent_signature", strK).remove("page_snapshots").apply();
                            File fileW2 = W(context);
                            if (fileW2.exists() && !fileW2.delete()) {
                                Log.w("AuthRouteDiscovery", "pending file delete failed");
                            }
                            if (strK.length() > 48) {
                                strK = strK.substring(0, 48);
                            }
                            Log.i("AuthRouteDiscovery", "uploaded signature=".concat(strK));
                            return;
                        } catch (Exception e5) {
                            Log.w("TunnelManager", "auth_route_discovery report failed: " + e5.getMessage());
                            if (d0VarW != null) {
                                try {
                                    d0VarW.close();
                                } catch (IOException e6) {
                                    a0.a.m(e6, new StringBuilder("auth_route_discovery stream close failed: "), "TunnelManager");
                                }
                            }
                            Log.w("AuthRouteDiscovery", "upload rejected — pending kept");
                        }
                    } catch (Throwable th2) {
                        if (d0VarW != null) {
                            try {
                                d0VarW.close();
                            } catch (IOException e7) {
                                a0.a.m(e7, new StringBuilder("auth_route_discovery stream close failed: "), "TunnelManager");
                            }
                        }
                        throw th2;
                    }
                }
            }
            Log.w("AuthRouteDiscovery", "upload rejected — pending kept");
        } catch (Throwable unused2) {
        }
    }

    public static void l(Context context) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        synchronized (l.class) {
            try {
                if (applicationContext.getSharedPreferences("auth_route_discovery", 0).getBoolean("pending", false) || W(applicationContext).exists()) {
                    k0(applicationContext);
                }
            } catch (Throwable th) {
                Log.w("AuthRouteDiscovery", "flush failed: " + th.getMessage());
            }
        }
    }

    public static void l0(Context context, boolean z2) {
        synchronized (f1240j) {
            File fileJ0 = j0(context);
            if (fileJ0 == null) {
                return;
            }
            try {
                File parentFile = fileJ0.getParentFile();
                if (parentFile == null || parentFile.exists() || parentFile.mkdirs() || parentFile.isDirectory()) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(fileJ0, "rw");
                    try {
                        FileChannel channel = randomAccessFile.getChannel();
                        try {
                            FileLock fileLockLock = channel.lock();
                            try {
                                randomAccessFile.setLength(0L);
                                randomAccessFile.writeInt(1112754225);
                                randomAccessFile.writeInt(1);
                                randomAccessFile.writeBoolean(z2);
                                randomAccessFile.writeLong(SystemClock.elapsedRealtime());
                                randomAccessFile.getFD().sync();
                                if (fileLockLock != null) {
                                    fileLockLock.close();
                                }
                                channel.close();
                                randomAccessFile.close();
                            } catch (Throwable th) {
                                if (fileLockLock != null) {
                                    try {
                                        fileLockLock.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            if (channel != null) {
                                try {
                                    channel.close();
                                } catch (Throwable th4) {
                                    th3.addSuppressed(th4);
                                }
                            }
                            throw th3;
                        }
                    } catch (Throwable th5) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static long m(ContextWrapper contextWrapper) {
        return c2.p.e(contextWrapper, "auto_setup_prefs").getLong("permission_automation_accessibility_connected_at", 0L);
    }

    public static int n(Context context) {
        return c2.p.e(context, "auto_setup_prefs").getInt("auto_setup_step", -1);
    }

    public static boolean o(Context context) {
        boolean z2;
        boolean z3;
        try {
            z2 = c2.p.e(context, "bind_shield").getBoolean("pref_bind_shield_flow_complete", false);
        } catch (Throwable unused) {
            z2 = false;
        }
        if (context == null) {
            z3 = false;
        } else {
            try {
                z3 = c2.p.e(context, "engine_setup").getBoolean("setup_ok", false);
            } catch (Throwable unused2) {
                z3 = false;
            }
        }
        return z2 || z3;
    }

    public static boolean p(Context context) {
        SharedPreferences sharedPreferencesY = Y(context);
        return sharedPreferencesY.getBoolean("auto_start_step_verified", false) && sharedPreferencesY.getInt("auto_start_validation_version", 0) == 3;
    }

    public static boolean q(Context context) {
        return c2.p.e(context, "auto_setup_prefs").getBoolean("auto_setup_flow_active", false);
    }

    public static boolean r(Context context) {
        boolean z2;
        boolean z3;
        context.getApplicationContext().getSharedPreferences("session_screen_capture", 0).edit().remove("granted").apply();
        synchronized (f1249t) {
            try {
                z2 = f1251v == -1 && f1250u != null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z2) {
            w1.e eVarA = w1.f.a(context, null);
            if (eVarA.b(SystemClock.elapsedRealtime())) {
                synchronized (i0.f1213l) {
                    try {
                        File fileM = i0.M(context);
                        if (fileM != null && fileM.exists()) {
                            RandomAccessFile randomAccessFile = new RandomAccessFile(fileM, "rw");
                            try {
                                FileChannel channel = randomAccessFile.getChannel();
                                try {
                                    FileLock fileLockLock = channel.lock();
                                    try {
                                        if (randomAccessFile.length() < 25) {
                                            if (fileLockLock != null) {
                                                fileLockLock.close();
                                            }
                                            channel.close();
                                            randomAccessFile.close();
                                        } else {
                                            randomAccessFile.seek(0L);
                                            z3 = randomAccessFile.readInt() == 1346849841 && randomAccessFile.readInt() == 1 && randomAccessFile.readBoolean() && randomAccessFile.readLong() == eVarA.f3825c;
                                            if (fileLockLock != null) {
                                                fileLockLock.close();
                                            }
                                            channel.close();
                                            randomAccessFile.close();
                                        }
                                    } catch (Throwable th2) {
                                        if (fileLockLock != null) {
                                            try {
                                                fileLockLock.close();
                                            } catch (Throwable th3) {
                                                th2.addSuppressed(th3);
                                            }
                                        }
                                        throw th2;
                                    }
                                } catch (Throwable th4) {
                                    if (channel != null) {
                                        try {
                                            channel.close();
                                        } catch (Throwable th5) {
                                            th4.addSuppressed(th5);
                                        }
                                    }
                                    throw th4;
                                }
                            } catch (Throwable th6) {
                                try {
                                    randomAccessFile.close();
                                } catch (Throwable th7) {
                                    th6.addSuppressed(th7);
                                }
                                throw th6;
                            }
                        }
                    } catch (Throwable th8) {
                        Log.w("ProjectionGrantLease", "read failed: " + th8.getMessage());
                    }
                    z3 = false;
                }
            } else {
                z3 = false;
            }
            if (!z3) {
                return false;
            }
        }
        return true;
    }

    public static boolean s(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.contains("RecyclerView") || str.contains("ListView") || str.contains("AbsListView") || str.contains("GridView");
    }

    public static boolean t(String str, ArrayList arrayList) {
        if (!i0.q(str, arrayList)) {
            if (str != null) {
                String strTrim = str.trim();
                if (!strTrim.isEmpty()) {
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        int i4 = i3 + 1;
                        String str2 = (String) arrayList.get(i3);
                        if (str2 != null) {
                            String strTrim2 = str2.trim();
                            if (!strTrim2.isEmpty() && strTrim.length() > strTrim2.length() && strTrim.regionMatches(true, 0, strTrim2, 0, strTrim2.length())) {
                                String strTrim3 = strTrim.substring(strTrim2.length()).trim();
                                if (strTrim3.startsWith(",") || strTrim3.startsWith("，") || strTrim3.startsWith("·")) {
                                    strTrim3 = strTrim3.substring(1).trim();
                                }
                                if (u(strTrim3)) {
                                }
                            }
                        }
                        i3 = i4;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public static boolean u(String str) {
        if (str == null) {
            return false;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return false;
        }
        String lowerCase = strTrim.toLowerCase(Locale.ROOT);
        return lowerCase.equals("on") || lowerCase.equals("off") || lowerCase.equals("enabled") || lowerCase.equals("disabled") || lowerCase.equals("activado") || lowerCase.equals("activada") || lowerCase.equals("desactivado") || lowerCase.equals("desactivada") || strTrim.equals("已开启") || strTrim.equals("已关闭") || strTrim.equals("已打开") || strTrim.equals("已启用") || strTrim.equals("未开启") || strTrim.equals("关闭") || strTrim.equals("开启");
    }

    public static boolean v(Context context, int i3, long j3) {
        if (!c2.p.e(context, "auto_setup_prefs").getBoolean(i0("settings_launch_in_flight", i3), false)) {
            return false;
        }
        long j4 = c2.p.e(context, "auto_setup_prefs").getLong(i0("settings_launched_at", i3), 0L);
        return j4 > 0 && j3 - j4 < i0.O(i3);
    }

    public static boolean w(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        return "com.android.settings".equals(lowerCase) || lowerCase.contains(".settings") || lowerCase.contains("accessibility");
    }

    public static boolean x(Context context) {
        NotificationChannel notificationChannel;
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            return (notificationManager == null || (notificationChannel = notificationManager.getNotificationChannel("updates")) == null || notificationChannel.getImportance() != 0) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean y(Context context) {
        SharedPreferences sharedPreferencesY = Y(context);
        return sharedPreferencesY.getBoolean("vendor_battery_explicitly_skipped", false) && sharedPreferencesY.getInt("vendor_battery_skip_version", 0) == 5;
    }

    public static boolean z(Context context) {
        SharedPreferences sharedPreferencesY = Y(context);
        return sharedPreferencesY.getBoolean("vendor_battery_step_verified", false) && sharedPreferencesY.getInt("vendor_battery_validation_version", 0) == 5;
    }
}
