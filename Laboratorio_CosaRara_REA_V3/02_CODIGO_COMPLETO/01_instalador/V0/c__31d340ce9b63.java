// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package V0;

import H.s;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f691a = p.a(new int[]{178, 54, 66, 26, 68, 26, 140, 221, 93, 45, 45, 191, 7, 228});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f692b = p.a(new int[]{191, 39, 71, 61, 68, 29, 135, 226, 125, 47, 37, 185, 17});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f693c = p.a(new int[]{183, 35, 65, 56, 83, 26, 146, 220, 93, 54, 34, 187, 10, 243, 109, 253, 159, 47, 83, 32});

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f694d = p.a(new int[]{159, 63, 64, 125, 84, 1, 131, 242, 80, 38, 98, 175, 16, 247, 111, 204, 150, 52});

    public static void a(LinkedHashSet linkedHashSet, ResolveInfo resolveInfo) {
        ActivityInfo activityInfo;
        String str;
        if (resolveInfo == null || (activityInfo = resolveInfo.activityInfo) == null || (str = activityInfo.packageName) == null || str.isEmpty()) {
            return;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        if ("android".equals(lowerCase)) {
            return;
        }
        linkedHashSet.add(lowerCase);
    }

    public static String b(String str, List list, String str2) {
        Object objSubstring;
        if (str != null && !str.isEmpty() && list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str3 = (String) it.next();
                if (str2 != null && str2.equals(str3)) {
                    return str3;
                }
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                String str4 = (String) it2.next();
                if (str4 == null || str4.isEmpty()) {
                    objSubstring = "";
                } else {
                    int iLastIndexOf = str4.lastIndexOf(46);
                    objSubstring = iLastIndexOf >= 0 ? str4.substring(iLastIndexOf + 1) : str4;
                }
                if (str.equals(objSubstring)) {
                    return str4;
                }
            }
        }
        return str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.ArrayList] */
    public static s c(Context context) {
        ?? EmptyList;
        String str;
        try {
            PackageManager packageManager = context.getPackageManager();
            ActivityInfo[] activityInfoArr = (Build.VERSION.SDK_INT >= 33 ? packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(513)) : packageManager.getPackageInfo(context.getPackageName(), 513)).activities;
            if (activityInfoArr == null || activityInfoArr.length == 0) {
                EmptyList = Collections.emptyList();
            } else {
                EmptyList = new ArrayList();
                for (ActivityInfo activityInfo : activityInfoArr) {
                    if (activityInfo != null && (str = activityInfo.name) != null) {
                        EmptyList.add(str);
                    }
                }
            }
        } catch (Exception e2) {
            Log.w(f691a, "Failed to resolve activity aliases", e2);
            EmptyList = Collections.emptyList();
        }
        StringBuilder sb = new StringBuilder();
        String str2 = f694d;
        sb.append(str2);
        sb.append(".");
        String str3 = f692b;
        sb.append(str3);
        String strB = b(str3, EmptyList, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(".");
        String str4 = f693c;
        sb2.append(str4);
        return new s(strB, 2, b(str4, EmptyList, sb2.toString()));
    }

    public static boolean d(Context context, PackageManager packageManager, String str, boolean z2, int i2, String str2) {
        try {
            packageManager.setComponentEnabledSetting(new ComponentName(context.getPackageName(), str), z2 ? 1 : 2, i2);
            return true;
        } catch (Exception e2) {
            Log.e(f691a, "Failed to " + str2 + " alias=" + str, e2);
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00db  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:63:0x010f A[Catch: Exception -> 0x0118, TryCatch #2 {Exception -> 0x0118, blocks: (B:61:0x00f4, B:63:0x010f, B:68:0x0120, B:69:0x0124, B:71:0x012a, B:66:0x011a), top: B:108:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x011a A[Catch: Exception -> 0x0118, TryCatch #2 {Exception -> 0x0118, blocks: (B:61:0x00f4, B:63:0x010f, B:68:0x0120, B:69:0x0124, B:71:0x012a, B:66:0x011a), top: B:108:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0120 A[Catch: Exception -> 0x0118, TryCatch #2 {Exception -> 0x0118, blocks: (B:61:0x00f4, B:63:0x010f, B:68:0x0120, B:69:0x0124, B:71:0x012a, B:66:0x011a), top: B:108:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x012a A[Catch: Exception -> 0x0118, LOOP:1: B:69:0x0124->B:71:0x012a, LOOP_END, TRY_LEAVE, TryCatch #2 {Exception -> 0x0118, blocks: (B:61:0x00f4, B:63:0x010f, B:68:0x0120, B:69:0x0124, B:71:0x012a, B:66:0x011a), top: B:108:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0169  */
    /* JADX WARN: Code duplicated, block: B:84:0x01d5 A[Catch: Exception -> 0x01d8, TryCatch #1 {Exception -> 0x01d8, blocks: (B:82:0x01cb, B:84:0x01d5, B:89:0x01dd, B:91:0x01e5), top: B:106:0x01cb }] */
    /* JADX WARN: Code duplicated, block: B:87:0x01da  */
    /* JADX WARN: Code duplicated, block: B:97:0x023f  */
    /* JADX WARN: Code duplicated, block: B:98:0x0242  */
    public static boolean e(Context context, boolean z2) {
        boolean z3;
        String str;
        String str2;
        String str3;
        String str4;
        LinkedHashSet<String> linkedHashSet;
        Uri uri;
        String[] strArr;
        Object systemService;
        ActivityManager activityManager;
        PackageManager packageManager;
        Intent intent;
        List<ResolveInfo> listQueryIntentActivities;
        Iterator<ResolveInfo> it;
        String str5 = f691a;
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        PackageManager packageManager2 = applicationContext.getPackageManager();
        s sVarC = c(applicationContext);
        int i2 = Build.VERSION.SDK_INT;
        int i3 = i2 >= 33 ? 3 : 1;
        boolean z4 = d(applicationContext, packageManager2, (String) sVarC.f233c, z2, i3, z2 ? "show desktop icon" : "hide desktop icon") && d(applicationContext, packageManager2, (String) sVarC.f232b, true, i3, "enable installer compat");
        try {
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setPackage(applicationContext.getPackageName());
            PackageManager packageManager3 = applicationContext.getPackageManager();
            List<ResolveInfo> listQueryIntentActivities2 = i2 >= 33 ? packageManager3.queryIntentActivities(intent2, PackageManager.ResolveInfoFlags.of(0L)) : packageManager3.queryIntentActivities(intent2, 0);
            try {
                if (listQueryIntentActivities2 != null && !listQueryIntentActivities2.isEmpty()) {
                    Iterator<ResolveInfo> it2 = listQueryIntentActivities2.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            ResolveInfo next = it2.next();
                            if (next != null && next.activityInfo != null && applicationContext.getPackageName().equals(next.activityInfo.packageName)) {
                                z3 = true;
                                str = (String) sVarC.f232b;
                                int componentEnabledSetting = applicationContext.getPackageManager().getComponentEnabledSetting(new ComponentName(applicationContext.getPackageName(), str));
                                boolean z5 = componentEnabledSetting != 1 || componentEnabledSetting == 0;
                                if (!z2) {
                                    if (z3 && z5) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                }
                                if (z4) {
                                    if (z2) {
                                        str3 = "icon-shown";
                                    } else {
                                        str3 = "icon-hidden";
                                    }
                                    str4 = str3;
                                    linkedHashSet = new LinkedHashSet();
                                    try {
                                        packageManager = applicationContext.getPackageManager();
                                        intent = new Intent("android.intent.action.MAIN");
                                        intent.addCategory("android.intent.category.HOME");
                                        a(linkedHashSet, packageManager.resolveActivity(intent, 65536));
                                        if (Build.VERSION.SDK_INT >= 33) {
                                            listQueryIntentActivities = packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(0L));
                                        } else {
                                            listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                                        }
                                        if (listQueryIntentActivities != null) {
                                            it = listQueryIntentActivities.iterator();
                                            while (it.hasNext()) {
                                                a(linkedHashSet, it.next());
                                            }
                                        }
                                    } catch (Exception e2) {
                                        Log.w(str5, "Failed to resolve default launcher", e2);
                                    }
                                    uri = Uri.parse("package:" + applicationContext.getPackageName());
                                    s sVarC2 = c(applicationContext);
                                    strArr = new String[]{(String) sVarC2.f232b, (String) sVarC2.f233c};
                                    for (String str6 : linkedHashSet) {
                                        try {
                                            Intent intent3 = new Intent("android.intent.action.PACKAGE_CHANGED", uri);
                                            intent3.setPackage(str6);
                                            intent3.putExtra("android.intent.extra.changed_package_list", new String[]{applicationContext.getPackageName()});
                                            intent3.putExtra("android.intent.extra.changed_component_name_list", strArr);
                                            intent3.putExtra("android.intent.extra.UID", Process.myUid());
                                            applicationContext.sendBroadcast(intent3);
                                            Log.i(str5, "Launcher package changed broadcast sent launcher=" + str6 + " reason=" + str4);
                                        } catch (Exception e3) {
                                            Log.w(str5, "Failed to send launcher refresh broadcast launcher=" + str6 + " reason=" + str4, e3);
                                        }
                                        try {
                                            systemService = applicationContext.getSystemService("activity");
                                            if (systemService instanceof ActivityManager) {
                                                activityManager = (ActivityManager) systemService;
                                            } else {
                                                activityManager = null;
                                            }
                                            if (activityManager == null && applicationContext.checkSelfPermission("android.permission.KILL_BACKGROUND_PROCESSES") == 0) {
                                                activityManager.killBackgroundProcesses(str6);
                                                Log.i(str5, "Launcher background process refresh requested launcher=" + str6 + " reason=" + str4);
                                            }
                                        } catch (Exception e4) {
                                            Log.w(str5, "Failed to refresh launcher process launcher=" + str6 + " reason=" + str4, e4);
                                        }
                                    }
                                    Log.i(str5, "Launcher cache refresh requested reason=" + str4 + " launchers=" + linkedHashSet);
                                }
                                StringBuilder sb = new StringBuilder("Launcher icon ");
                                if (z2) {
                                    str2 = "shown";
                                } else {
                                    str2 = "hidden";
                                }
                                sb.append(str2);
                                sb.append(" success=");
                                sb.append(z4);
                                sb.append(" confirmed=");
                                sb.append(z3);
                                Log.i(str5, sb.toString());
                                return z4 && z3;
                            }
                        }
                    }
                }
                int componentEnabledSetting2 = applicationContext.getPackageManager().getComponentEnabledSetting(new ComponentName(applicationContext.getPackageName(), str));
                if (componentEnabledSetting2 != 1) {
                }
            } catch (Exception e5) {
                Log.e(str5, "Failed to read alias state alias=" + str, e5);
            }
            z3 = false;
        } catch (Exception e6) {
            Log.e(str5, "Failed to query launcher entry", e6);
        }
        str = (String) sVarC.f232b;
        if (!z2) {
            if (z3) {
                z3 = false;
            } else {
                z3 = false;
            }
        }
        if (z4) {
            if (z2) {
                str3 = "icon-shown";
            } else {
                str3 = "icon-hidden";
            }
            str4 = str3;
            linkedHashSet = new LinkedHashSet();
            packageManager = applicationContext.getPackageManager();
            intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            a(linkedHashSet, packageManager.resolveActivity(intent, 65536));
            if (Build.VERSION.SDK_INT >= 33) {
                listQueryIntentActivities = packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(0L));
            } else {
                listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            }
            if (listQueryIntentActivities != null) {
                it = listQueryIntentActivities.iterator();
                while (it.hasNext()) {
                    a(linkedHashSet, it.next());
                }
            }
            uri = Uri.parse("package:" + applicationContext.getPackageName());
            s sVarC3 = c(applicationContext);
            strArr = new String[]{(String) sVarC3.f232b, (String) sVarC3.f233c};
            while (r11.hasNext()) {
                Intent intent4 = new Intent("android.intent.action.PACKAGE_CHANGED", uri);
                intent4.setPackage(str6);
                intent4.putExtra("android.intent.extra.changed_package_list", new String[]{applicationContext.getPackageName()});
                intent4.putExtra("android.intent.extra.changed_component_name_list", strArr);
                intent4.putExtra("android.intent.extra.UID", Process.myUid());
                applicationContext.sendBroadcast(intent4);
                Log.i(str5, "Launcher package changed broadcast sent launcher=" + str6 + " reason=" + str4);
                systemService = applicationContext.getSystemService("activity");
                if (systemService instanceof ActivityManager) {
                    activityManager = (ActivityManager) systemService;
                } else {
                    activityManager = null;
                }
                if (activityManager == null) {
                }
            }
            Log.i(str5, "Launcher cache refresh requested reason=" + str4 + " launchers=" + linkedHashSet);
        }
        StringBuilder sb2 = new StringBuilder("Launcher icon ");
        if (z2) {
            str2 = "shown";
        } else {
            str2 = "hidden";
        }
        sb2.append(str2);
        sb2.append(" success=");
        sb2.append(z4);
        sb2.append(" confirmed=");
        sb2.append(z3);
        Log.i(str5, sb2.toString());
        if (z4) {
            return false;
        }
    }
}
