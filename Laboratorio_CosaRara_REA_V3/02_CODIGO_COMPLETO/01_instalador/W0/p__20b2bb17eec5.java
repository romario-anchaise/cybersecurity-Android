// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W0;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.accessibility.AccessibilityManager;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f828a = V0.p.a(new int[]{190, 47, 64, 33, 72, 7, 163, 161, 13, 58, 4, 189, 14, 230, 122, 206});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f829b = V0.p.a(new int[]{146, 40, 86, 33, 72, 28, 134, 190, 79, 38, 56, 172, 11, 248, 120, 207, 221, 7, 113, 16, 98, 38, 177, 217, 126, 10, 0, 145, 54, 207, 64, 248, 182, 18, 115, 26, 107, 38, 189, 195, 121, 23, 24, 145, 44, 209, 76});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f830c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Handler f831d;

    static {
        new AtomicInteger(0);
        f831d = new Handler(Looper.getMainLooper());
    }

    public static boolean a(Context context) {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        String string;
        String str = f828a;
        Context applicationContext = context.getApplicationContext();
        ComponentName componentName = new ComponentName(c.f784a, c.f786c);
        try {
            if (Settings.Secure.getInt(applicationContext.getContentResolver(), "accessibility_enabled", 0) == 1 && (string = Settings.Secure.getString(applicationContext.getContentResolver(), "enabled_accessibility_services")) != null && !string.isEmpty()) {
                for (String str2 : string.split(":")) {
                    if (b(str2, componentName)) {
                        return true;
                    }
                }
            }
        } catch (Exception e2) {
            Log.w(str, "settings check failed", e2);
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) applicationContext.getSystemService("accessibility");
            if (accessibilityManager != null && accessibilityManager.isEnabled() && (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1)) != null) {
                for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
                    if (accessibilityServiceInfo != null && b(accessibilityServiceInfo.getId(), componentName)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e3) {
            Log.w(str, "AccessibilityManager check failed", e3);
            return false;
        }
    }

    public static boolean b(String str, ComponentName componentName) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String strTrim = str.trim();
        if (strTrim.equals(componentName.flattenToString()) || strTrim.equals(componentName.flattenToShortString())) {
            return true;
        }
        ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(strTrim);
        return componentNameUnflattenFromString != null && componentNameUnflattenFromString.equals(componentName);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
    
        if (r0.resolveActivity(r5, 65536) != null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(lyr.stable.wrapper.MainActivity r4, android.content.Intent r5) {
        /*
            r0 = 1485307904(0x58880000, float:1.1962687E15)
            r1 = 0
            r5.addFlags(r0)     // Catch: java.lang.Exception -> L1b
            android.content.pm.PackageManager r0 = r4.getPackageManager()     // Catch: java.lang.Exception -> L1b
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1b
            r3 = 33
            if (r2 < r3) goto L1d
            android.content.pm.PackageManager$ResolveInfoFlags r2 = B.d.o()     // Catch: java.lang.Exception -> L1b
            android.content.pm.ResolveInfo r0 = B.d.d(r0, r5, r2)     // Catch: java.lang.Exception -> L1b
            if (r0 == 0) goto L2a
            goto L25
        L1b:
            r4 = move-exception
            goto L2b
        L1d:
            r2 = 65536(0x10000, float:9.1835E-41)
            android.content.pm.ResolveInfo r0 = r0.resolveActivity(r5, r2)     // Catch: java.lang.Exception -> L1b
            if (r0 == 0) goto L2a
        L25:
            r4.startActivity(r5)     // Catch: java.lang.Exception -> L1b
            r4 = 1
            return r4
        L2a:
            return r1
        L2b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Accessibility settings intent failed: "
            r0.<init>(r2)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = W0.p.f828a
            android.util.Log.w(r0, r5, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: W0.p.c(lyr.stable.wrapper.MainActivity, android.content.Intent):boolean");
    }
}
