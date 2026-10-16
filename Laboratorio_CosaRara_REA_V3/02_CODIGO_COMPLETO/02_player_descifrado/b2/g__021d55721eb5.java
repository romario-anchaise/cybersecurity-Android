// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package b2;

import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.telecom.TelecomManager;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import f2.q0;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import lyr.stable.runtime.ScreenMirrorService;
import org.json.JSONObject;
import w1.f1;
import w1.g2;
import w1.oa;
import w1.t9;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile g f278p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScreenMirrorService f283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f285c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile d f288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile oa f289g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile g2 f290h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ScheduledExecutorService f291i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f292j;
    public volatile long n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Object f277o = new Object();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final HashSet f279q = new HashSet(Arrays.asList("com.android.permissioncontroller", "com.google.android.permissioncontroller", "com.samsung.android.permissioncontroller", "com.android.packageinstaller", "com.google.android.packageinstaller", "com.samsung.android.packageinstaller", "com.miui.packageinstaller", "com.huawei.packageinstaller", "com.lbe.security.miui", "com.coloros.permissioncontroller", "com.oplus.permissioncontroller", "com.oplus.securitypermission", "com.huawei.systemmanager", "com.vivo.permissionmanager"));

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final HashSet f280r = new HashSet(Arrays.asList("com.android.documentsui", "com.google.android.documentsui"));

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final HashSet f281s = new HashSet(Arrays.asList("com.android.dialer", "com.android.incallui", "com.android.phone", "com.google.android.dialer", "com.samsung.android.dialer", "com.samsung.android.incallui"));

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String[] f282t = {"android.telecom.CallRedirectionService", "android.telecom.CallScreeningService", "android.service.voice.VoiceInteractionService", "android.companion.CompanionDeviceService"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f286d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f287e = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f293k = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicLong f294l = new AtomicLong();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f295m = "";

    /* JADX WARN: Code duplicated, block: B:14:0x008b  */
    public g(ScreenMirrorService screenMirrorService) {
        boolean z2;
        this.f283a = screenMirrorService;
        m mVar = new m(screenMirrorService, 0);
        this.f284b = mVar;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            jCurrentTimeMillis = Math.max(jCurrentTimeMillis, mVar.e());
        } catch (Throwable unused) {
        }
        this.f294l.set(jCurrentTimeMillis);
        h hVarD = h.f296d;
        try {
            hVarD = this.f284b.d();
        } catch (Throwable unused2) {
            Log.i("AppForegroundGuard", "CE guard config unavailable before unlock");
        }
        l lVar = new l(hVarD, new a(1));
        this.f285c = lVar;
        d dVar = new d();
        ((HashSet) dVar.f268e).addAll(f279q);
        ((HashSet) dVar.f270g).addAll(f281s);
        this.f288f = dVar;
        PowerManager powerManager = (PowerManager) this.f283a.getSystemService("power");
        boolean z3 = false;
        if (powerManager != null) {
            try {
                if (powerManager.isInteractive()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } catch (Throwable unused3) {
            }
        } else {
            z2 = true;
        }
        KeyguardManager keyguardManager = (KeyguardManager) this.f283a.getSystemService("keyguard");
        if (keyguardManager != null) {
            try {
                if (keyguardManager.isKeyguardLocked()) {
                    z3 = true;
                }
            } catch (Throwable unused4) {
            }
        }
        lVar.n(z2, z3);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x006a  */
    /* JADX WARN: Code duplicated, block: B:49:0x0086  */
    /* JADX WARN: Code duplicated, block: B:54:0x009f  */
    /* JADX WARN: Code duplicated, block: B:57:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00d9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00db  */
    /* JADX WARN: Code duplicated, block: B:62:0x00e2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00eb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:68:0x00fd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:70:0x0106 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x0108  */
    /* JADX WARN: Code duplicated, block: B:72:0x010f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x0111  */
    /* JADX WARN: Code duplicated, block: B:74:0x0118 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x011a  */
    /* JADX WARN: Code duplicated, block: B:76:0x0121 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x0123  */
    /* JADX WARN: Code duplicated, block: B:78:0x012a  */
    public static e B(Context context, String str, d dVar) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean zEquals;
        boolean z6;
        boolean zContains;
        boolean zContains2;
        boolean zEquals2;
        boolean zContains3;
        ActivityInfo activityInfo;
        ApplicationInfo applicationInfo;
        PackageManager packageManager = context.getPackageManager();
        try {
            try {
                z2 = packageManager.getApplicationInfo(str, 0).enabled;
                try {
                    int applicationEnabledSetting = packageManager.getApplicationEnabledSetting(str);
                    if (applicationEnabledSetting == 2 || applicationEnabledSetting == 3 || applicationEnabledSetting == 4) {
                        z2 = false;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                } catch (Throwable th) {
                    th = th;
                    z3 = true;
                    a0.a.q(th, new StringBuilder("target state lookup failed: "), "AppForegroundGuard");
                    if (z3) {
                        z4 = false;
                    } else {
                        z4 = false;
                    }
                    String lowerCase = str.toLowerCase(Locale.ROOT);
                    if (str.equals(context.getPackageName())) {
                        z5 = true;
                    } else {
                        z5 = true;
                    }
                    zEquals = lowerCase.equals("com.android.systemui");
                    if (((HashSet) dVar.f267d).contains(str)) {
                    }
                    zContains = ((HashSet) dVar.f268e).contains(str);
                    zContains2 = ((HashSet) dVar.f266c).contains(str);
                    zEquals2 = str.equals(dVar.f265b);
                    zContains3 = ((HashSet) dVar.f269f).contains(str);
                    if (str.trim().isEmpty()) {
                        return e.a("empty_target");
                    }
                    if (!z3) {
                        return e.a("not_installed");
                    }
                    if (!z2) {
                        return e.a("target_disabled");
                    }
                    if (!z4) {
                        return e.a("not_launchable");
                    }
                    if (z5) {
                        return e.a("runtime_or_host");
                    }
                    if (zContains2) {
                        return e.a("launcher");
                    }
                    if (zEquals) {
                        return e.a("system_ui");
                    }
                    if (z6) {
                        return e.a("settings");
                    }
                    if (zContains) {
                        return e.a("permission_or_installer");
                    }
                    if (zEquals2) {
                        return e.a("default_ime");
                    }
                    return zContains3 ? e.a("role_holder") : new e(true, "ok", 1);
                }
                z3 = true;
            } catch (PackageManager.NameNotFoundException unused2) {
                z3 = true;
                z2 = false;
            } catch (Throwable th2) {
                th = th2;
                z3 = true;
                z2 = false;
            }
        } catch (PackageManager.NameNotFoundException unused3) {
            z2 = false;
            z3 = false;
        } catch (Throwable th3) {
            th = th3;
            z2 = false;
            z3 = false;
        }
        if (z3 || !z2) {
            z4 = false;
        } else {
            try {
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
                ResolveInfo resolveInfoResolveActivity = launchIntentForPackage != null ? packageManager.resolveActivity(launchIntentForPackage, 65536) : null;
                if (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null || !activityInfo.enabled || (applicationInfo = activityInfo.applicationInfo) == null || !applicationInfo.enabled) {
                    z4 = false;
                } else {
                    z4 = true;
                }
            } catch (Throwable th4) {
                a0.a.q(th4, new StringBuilder("target launch lookup failed: "), "AppForegroundGuard");
            }
        }
        String lowerCase2 = str.toLowerCase(Locale.ROOT);
        if (str.equals(context.getPackageName()) || str.equals(t9.f5174e)) {
            z5 = true;
        } else {
            z5 = false;
        }
        zEquals = lowerCase2.equals("com.android.systemui");
        z6 = !((HashSet) dVar.f267d).contains(str) || lowerCase2.equals("com.android.settings");
        zContains = ((HashSet) dVar.f268e).contains(str);
        zContains2 = ((HashSet) dVar.f266c).contains(str);
        zEquals2 = str.equals(dVar.f265b);
        zContains3 = ((HashSet) dVar.f269f).contains(str);
        if (str.trim().isEmpty()) {
            return e.a("empty_target");
        }
        if (!z3) {
            return e.a("not_installed");
        }
        if (!z2) {
            return e.a("target_disabled");
        }
        if (!z4) {
            return e.a("not_launchable");
        }
        if (z5) {
            return e.a("runtime_or_host");
        }
        if (zContains2) {
            return e.a("launcher");
        }
        if (zEquals) {
            return e.a("system_ui");
        }
        if (z6) {
            return e.a("settings");
        }
        if (zContains) {
            return e.a("permission_or_installer");
        }
        if (zEquals2) {
            return e.a("default_ime");
        }
        if (zContains3) {
        }
    }

    public static JSONObject a(k kVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("state", a0.a.s(kVar.f314a));
            jSONObject.put("started", kVar.f315b);
            jSONObject.put("configured", kVar.f316c);
            jSONObject.put("enabled", kVar.f317d);
            jSONObject.put("targetPackage", kVar.f318e);
            jSONObject.put("revision", kVar.f319f);
            jSONObject.put("activePackage", kVar.f320g);
            jSONObject.put("activeClass", kVar.f321h);
            jSONObject.put("interactive", kVar.f322i);
            jSONObject.put("keyguardLocked", kVar.f323j);
            jSONObject.put("suppressed", kVar.f324k);
            jSONObject.put("exemption", kVar.f325l);
            jSONObject.put("pauseRemainingMs", kVar.f326m);
            jSONObject.put("exemptionRemainingMs", kVar.n);
            jSONObject.put("launchInFlight", kVar.f327o);
            jSONObject.put("launchAttempt", kVar.f328p);
            jSONObject.put("consecutiveFailures", kVar.f329q);
            jSONObject.put("verifyRemainingMs", kVar.f330r);
            jSONObject.put("backoffRemainingMs", kVar.f331s);
            jSONObject.put("lastError", kVar.f332t);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static void b(String str, Set set) {
        if (str == null || str.isEmpty()) {
            return;
        }
        set.add(str);
    }

    public static void c(PackageManager packageManager, Intent intent, Set set) {
        ActivityInfo activityInfo;
        try {
            ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 65536);
            if (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null) {
                return;
            }
            String str = activityInfo.packageName;
            if ("android".equals(str)) {
                return;
            }
            b(str, set);
        } catch (Throwable unused) {
        }
    }

    public static void d(PackageManager packageManager, Intent intent, Set set) {
        ActivityInfo activityInfo;
        try {
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 131072);
            if (listQueryIntentActivities == null) {
                return;
            }
            for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null) {
                    b(activityInfo.packageName, set);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static c f(Context context, boolean z2, String str, long j3) {
        if (context == null) {
            return m(false, false, "no_context", h.f296d);
        }
        try {
            m mVar = new m(context, 0);
            h hVarD = mVar.d();
            h hVar = new h(j3, str, z2);
            if (j3 < 0) {
                return m(false, false, "invalid_revision", hVarD);
            }
            int iE = l.e(hVarD, hVar);
            if (iE == 3) {
                return m(false, false, "stale_revision", hVarD);
            }
            if (iE == 4) {
                return m(false, false, "revision_conflict", hVarD);
            }
            if (iE == 2) {
                return m(true, false, "idempotent", hVarD);
            }
            if (z2) {
                e eVarB = B(context, hVar.f298b, g(context));
                if (!eVarB.f272b) {
                    return m(false, false, eVarB.f273c, hVarD);
                }
            }
            try {
                return !mVar.h(hVar) ? m(false, false, "persist_failed", hVarD) : m(true, true, "applied", hVar);
            } catch (Throwable unused) {
                return m(false, false, "persist_failed", hVarD);
            }
        } catch (Throwable unused2) {
            return m(false, false, "credential_storage_unavailable", h.f296d);
        }
    }

    public static d g(Context context) {
        String str;
        ServiceInfo serviceInfo;
        d dVar = new d();
        HashSet hashSet = (HashSet) dVar.f268e;
        hashSet.addAll(f279q);
        HashSet hashSet2 = (HashSet) dVar.f270g;
        hashSet2.addAll(f281s);
        HashSet hashSet3 = (HashSet) dVar.f266c;
        HashSet hashSet4 = (HashSet) dVar.f267d;
        HashSet hashSet5 = (HashSet) dVar.f269f;
        PackageManager packageManager = context.getPackageManager();
        try {
            Object objInvoke = packageManager.getClass().getMethod("getPermissionControllerPackageName", null).invoke(packageManager, null);
            str = objInvoke instanceof String ? (String) objInvoke : "";
        } catch (Throwable unused) {
        }
        b(str, hashSet);
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        d(packageManager, intent, hashSet3);
        hashSet5.addAll(hashSet3);
        d(packageManager, new Intent("android.settings.SETTINGS"), hashSet4);
        d(packageManager, new Intent("android.settings.APPLICATION_SETTINGS"), hashSet4);
        d(packageManager, new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), hashSet4);
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://example.invalid/"));
        intent2.addCategory("android.intent.category.BROWSABLE");
        c(packageManager, intent2, hashSet5);
        c(packageManager, new Intent("android.intent.action.DIAL", Uri.parse("tel:112")), hashSet5);
        c(packageManager, new Intent("android.intent.action.SENDTO", Uri.parse("smsto:")), hashSet5);
        c(packageManager, new Intent("android.intent.action.ASSIST"), hashSet5);
        c(packageManager, new Intent("android.telephony.action.EMERGENCY_ASSISTANCE"), hashSet5);
        Intent intent3 = new Intent("android.intent.action.MAIN");
        intent3.addCategory("android.intent.category.APP_GALLERY");
        c(packageManager, intent3, hashSet5);
        Intent intent4 = new Intent("android.intent.action.PICK");
        intent4.setType("image/*");
        c(packageManager, intent4, hashSet5);
        for (String str2 : f282t) {
            try {
                List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(new Intent(str2), 131072);
                if (listQueryIntentServices != null) {
                    for (ResolveInfo resolveInfo : listQueryIntentServices) {
                        if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
                            b(serviceInfo.packageName, hashSet5);
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        TelecomManager telecomManager = (TelecomManager) context.getSystemService("telecom");
        if (telecomManager != null) {
            try {
                String defaultDialerPackage = telecomManager.getDefaultDialerPackage();
                b(defaultDialerPackage, hashSet2);
                b(defaultDialerPackage, hashSet5);
            } catch (Throwable unused3) {
            }
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
            if (string == null) {
                string = "";
            }
            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(string);
            if (componentNameUnflattenFromString != null) {
                dVar.f265b = componentNameUnflattenFromString.getPackageName();
            }
        } catch (Throwable unused4) {
        }
        try {
            String string2 = Settings.Secure.getString(context.getContentResolver(), "assistant");
            ComponentName componentNameUnflattenFromString2 = ComponentName.unflattenFromString(string2 != null ? string2 : "");
            if (componentNameUnflattenFromString2 != null) {
                b(componentNameUnflattenFromString2.getPackageName(), hashSet5);
            }
        } catch (Throwable unused5) {
        }
        try {
            b(Settings.Secure.getString(context.getContentResolver(), "sms_default_application"), hashSet5);
        } catch (Throwable unused6) {
        }
        try {
            b(Settings.Secure.getString(context.getContentResolver(), "dialer_default_application"), hashSet5);
        } catch (Throwable unused7) {
        }
        return dVar;
    }

    public static c m(boolean z2, boolean z3, String str, h hVar) {
        return new c(z2, z3, str, new l(hVar, new a(0)).p());
    }

    public static String o(Context context) {
        long jMax;
        h hVarD = h.f296d;
        String str = "";
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            m mVar = new m(context, 0);
            hVarD = mVar.d();
            synchronized (mVar) {
                jMax = Math.max(mVar.e() + 1, System.currentTimeMillis());
                mVar.f358a.getSharedPreferences("app_foreground_guard", 0).edit().putLong("status_sequence", jMax).commit();
            }
            try {
                if (hVarD.f297a) {
                    str = "accessibility_unbound";
                }
            } catch (Throwable unused) {
                jCurrentTimeMillis = jMax;
                str = "credential_storage_unavailable";
                jMax = jCurrentTimeMillis;
            }
        } catch (Throwable unused2) {
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("configured", hVarD.f299c >= 0);
            jSONObject.put("enabled", hVarD.f297a);
            jSONObject.put("targetPackage", hVarD.f298b);
            jSONObject.put("revision", hVarD.f299c);
            jSONObject.put("state", hVarD.f297a ? "ERROR" : "DISABLED");
            jSONObject.put("foregroundPackage", "");
            jSONObject.put("exemption", "");
            jSONObject.put("lastError", str);
            jSONObject.put("accessibilityBound", false);
            jSONObject.put("statusSequence", jMax);
        } catch (Exception unused3) {
        }
        return jSONObject.toString();
    }

    public static JSONObject r(k kVar, long j3, boolean z2, long j4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("configured", kVar.f316c);
            jSONObject.put("enabled", kVar.f317d);
            jSONObject.put("targetPackage", kVar.f318e);
            jSONObject.put("revision", kVar.f319f);
            jSONObject.put("state", a0.a.s(kVar.f314a));
            jSONObject.put("foregroundPackage", kVar.f320g);
            jSONObject.put("exemption", kVar.f325l);
            long jMax = kVar.f326m;
            if (jMax <= 0) {
                jMax = Math.max(0L, kVar.n);
            }
            if (jMax > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j5 = Long.MAX_VALUE;
                if (jMax <= Long.MAX_VALUE - jCurrentTimeMillis) {
                    j5 = jCurrentTimeMillis + jMax;
                }
                jSONObject.put("expiresAt", j5);
            }
            if (j3 > 0) {
                jSONObject.put("lastActionAt", j3);
            }
            jSONObject.put("lastError", kVar.f332t);
            jSONObject.put("accessibilityBound", z2);
            jSONObject.put("statusSequence", j4);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public final void A() {
        boolean asBoolean;
        g2 g2Var = this.f290h;
        if (g2Var == null) {
            return;
        }
        try {
            asBoolean = g2Var.getAsBoolean();
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("suppression source failed: "), "AppForegroundGuard");
            asBoolean = true;
        }
        synchronized (this.f286d) {
            l lVar = this.f285c;
            synchronized (lVar) {
                try {
                    lVar.f338f = asBoolean;
                    if (asBoolean) {
                        lVar.c();
                    }
                    lVar.i(lVar.f333a.n());
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final c e(long j3, String str, boolean z2) {
        h hVar;
        h hVar2 = new h(j3, str, z2);
        synchronized (this.f286d) {
            try {
                l lVar = this.f285c;
                synchronized (lVar) {
                    hVar = lVar.f334b;
                }
                if (j3 < 0) {
                    return s("invalid_revision", false, false);
                }
                int iE = l.e(hVar, hVar2);
                if (iE == 3) {
                    return s("stale_revision", false, false);
                }
                if (iE == 4) {
                    return s("revision_conflict", false, false);
                }
                if (iE == 2) {
                    return s("idempotent", true, false);
                }
                d dVarG = g(this.f283a);
                this.f288f = dVarG;
                if (z2) {
                    e eVarB = B(this.f283a, hVar2.f298b, dVarG);
                    if (!eVarB.f272b) {
                        return s(eVarB.f273c, false, false);
                    }
                }
                try {
                    if (!this.f284b.h(hVar2)) {
                        return s("persist_failed", false, false);
                    }
                    this.f285c.b(hVar2);
                    c cVarS = s("applied", true, true);
                    p();
                    if (z2) {
                        t();
                    }
                    l(false);
                    return cVarS;
                } catch (Throwable th) {
                    Log.w("AppForegroundGuard", "config commit failed: " + th.getMessage());
                    return s("persist_failed", false, false);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void h() {
        synchronized (this.f286d) {
            l lVar = this.f285c;
            synchronized (lVar) {
                lVar.f343k = 0L;
                lVar.i(lVar.f333a.n());
            }
        }
        p();
        t();
        l(false);
    }

    public final void i(j jVar) {
        i iVarG;
        q0 q0VarD;
        synchronized (this.f286d) {
            try {
                iVarG = this.f285c.g(jVar);
                if (iVarG.f301a == 2) {
                    this.n = System.currentTimeMillis();
                    q0VarD = f1.d(this.f283a, iVarG.f302b);
                    this.f285c.h(iVarG, q0VarD.f1308a, q0VarD.f1310c);
                } else {
                    q0VarD = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (q0VarD == null) {
            v();
            l(false);
            return;
        }
        boolean z2 = q0VarD.f1308a;
        int i3 = iVarG.f303c;
        if (z2) {
            a0.a.o(a0.a.i(i3, "launch attempt=", " package="), iVarG.f302b, "AppForegroundGuard");
        } else {
            StringBuilder sbI = a0.a.i(i3, "launch rejected attempt=", " package=");
            sbI.append(iVarG.f302b);
            sbI.append(" error=");
            sbI.append(q0VarD.f1310c);
            Log.w("AppForegroundGuard", sbI.toString());
        }
        v();
        l(false);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0049  */
    /* JADX WARN: Code duplicated, block: B:43:0x009a  */
    /* JADX WARN: Code duplicated, block: B:68:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:87:0x013d  */
    public final j j(String str, String str2, f fVar) {
        boolean z2;
        boolean zContains;
        boolean z3;
        boolean z4;
        KeyguardManager keyguardManager;
        TelecomManager telecomManager;
        d dVar = this.f288f;
        String str3 = str != null ? str : "";
        String str4 = str2 != null ? str2 : "";
        if (str3.isEmpty() || str4.isEmpty()) {
            z2 = false;
        } else {
            String lowerCase = str4.toLowerCase(Locale.ROOT);
            if (((HashSet) dVar.f268e).contains(str3) && (lowerCase.contains("grantpermissionsactivity") || lowerCase.contains("grantpermissionactivity") || lowerCase.contains("requestpermissionsactivity"))) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (str3.isEmpty() || str4.isEmpty()) {
            zContains = false;
        } else {
            Locale locale = Locale.ROOT;
            String lowerCase2 = str3.toLowerCase(locale);
            String lowerCase3 = str4.toLowerCase(locale);
            if (f280r.contains(str3)) {
                zContains = lowerCase3.contains("activity");
            } else if ((lowerCase2.equals("android") || lowerCase2.equals("com.android.intentresolver") || lowerCase2.equals("com.google.android.intentresolver")) && (lowerCase3.contains("resolveractivity") || lowerCase3.contains("chooseractivity"))) {
                zContains = true;
            } else {
                zContains = false;
            }
        }
        if (str3.isEmpty() || str4.isEmpty()) {
            z3 = false;
        } else {
            String lowerCase4 = str4.toLowerCase(Locale.ROOT);
            if (((HashSet) dVar.f270g).contains(str3)) {
                ScreenMirrorService screenMirrorService = this.f283a;
                if (screenMirrorService.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0 && (telecomManager = (TelecomManager) screenMirrorService.getSystemService("telecom")) != null) {
                    try {
                        if (telecomManager.isInCall() && (lowerCase4.contains("incall") || lowerCase4.contains("in_call") || lowerCase4.contains("callactivity") || lowerCase4.contains("ongoingcall"))) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                    } catch (Throwable unused) {
                    }
                } else {
                    z3 = false;
                }
            } else {
                z3 = false;
            }
        }
        if (str3.isEmpty() || str4.isEmpty()) {
            z4 = false;
        } else {
            String lowerCase5 = str4.toLowerCase(Locale.ROOT);
            if (!str3.equals("com.android.systemui") || (keyguardManager = (KeyguardManager) this.f283a.getSystemService("keyguard")) == null) {
                z4 = false;
            } else {
                try {
                    if (keyguardManager.isKeyguardLocked() && (lowerCase5.contains("keyguard") || lowerCase5.contains("bouncer") || lowerCase5.contains("lockscreen"))) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                } catch (Throwable unused2) {
                }
            }
        }
        return new j(str3, str4, z2, zContains, z3, z4, fVar.f275b, fVar.f276c, fVar.f274a);
    }

    public final long k() {
        long j3;
        long jMax;
        do {
            j3 = this.f294l.get();
            jMax = Math.max(1 + j3, System.currentTimeMillis());
        } while (!this.f294l.compareAndSet(j3, jMax));
        m mVar = this.f284b;
        synchronized (mVar) {
            if (jMax <= mVar.e()) {
                return jMax;
            }
            mVar.f358a.getSharedPreferences("app_foreground_guard", 0).edit().putLong("status_sequence", jMax).apply();
            return jMax;
        }
    }

    public final void l(boolean z2) {
        oa oaVar = this.f289g;
        if (oaVar == null) {
            return;
        }
        synchronized (this.f293k) {
            try {
                k kVarP = this.f285c.p();
                String str = a0.a.s(kVarP.f314a) + "|" + kVarP.f315b + "|" + kVarP.f317d + "|" + kVarP.f318e + "|" + kVarP.f319f + "|" + kVarP.f320g + "|" + kVarP.f322i + "|" + kVarP.f323j + "|" + kVarP.f324k + "|" + kVarP.f325l + "|" + kVarP.f328p + "|" + kVarP.f329q + "|" + kVarP.f332t + "|" + this.n;
                if (z2 || !str.equals(this.f295m)) {
                    this.f295m = str;
                    try {
                        oaVar.f4744a.m0(r(kVarP, this.n, kVarP.f315b, k()).toString());
                    } catch (Throwable th) {
                        Log.w("AppForegroundGuard", "status listener failed: " + th.getMessage());
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void n() {
        synchronized (this.f286d) {
            l lVar = this.f285c;
            synchronized (lVar) {
                lVar.f343k = l.l(lVar.f333a.n(), 60000L);
                lVar.c();
                lVar.i(lVar.f333a.n());
            }
            this.f285c.p();
        }
        p();
        l(false);
    }

    public final void p() {
        synchronized (this.f287e) {
            try {
                boolean zO = this.f285c.o();
                ScheduledExecutorService scheduledExecutorService = this.f291i;
                if (!zO) {
                    this.f291i = null;
                    this.f292j = 0L;
                    if (scheduledExecutorService != null) {
                        scheduledExecutorService.shutdownNow();
                    }
                    return;
                }
                if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
                    ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new a2.l(1));
                    this.f291i = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
                    scheduledExecutorServiceNewSingleThreadScheduledExecutor.scheduleWithFixedDelay(new a2.b(3, this), 0L, 200L, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void q() {
        h hVar;
        synchronized (f277o) {
            synchronized (this.f286d) {
                try {
                    h hVarD = this.f284b.d();
                    l lVar = this.f285c;
                    synchronized (lVar) {
                        hVar = lVar.f334b;
                    }
                    if (!hVarD.equals(hVar)) {
                        this.f285c.b(hVarD);
                    }
                } catch (Throwable unused) {
                    Log.i("AppForegroundGuard", "CE guard config still unavailable");
                }
            }
        }
    }

    public final c s(String str, boolean z2, boolean z3) {
        return new c(z2, z3, str, this.f285c.p());
    }

    public final void t() {
        A();
        if (this.f285c.o()) {
            try {
                y.m mVarU = u(false);
                i(j((String) mVarU.f5993c, (String) mVarU.f5994d, (f) mVarU.f5995e));
            } catch (Throwable th) {
                a0.a.q(th, new StringBuilder("watchdog tick failed: "), "AppForegroundGuard");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x00e3 A[EXC_TOP_SPLITTER, PHI: r3 r6 r8
  0x00e3: PHI (r3v6 boolean) = (r3v4 boolean), (r3v8 boolean) binds: [B:77:0x00ea, B:72:0x00e0] A[DONT_GENERATE, DONT_INLINE]
  0x00e3: PHI (r6v5 boolean) = (r6v4 boolean), (r6v7 boolean) binds: [B:77:0x00ea, B:72:0x00e0] A[DONT_GENERATE, DONT_INLINE]
  0x00e3: PHI (r8v2 android.view.accessibility.AccessibilityNodeInfo) = (r8v1 android.view.accessibility.AccessibilityNodeInfo), (r8v6 android.view.accessibility.AccessibilityNodeInfo) binds: [B:77:0x00ea, B:72:0x00e0] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public final y.m u(boolean z2) {
        String str;
        AccessibilityNodeInfo rootInActiveWindow;
        String string;
        String string2;
        f fVar;
        AccessibilityNodeInfo root;
        try {
            rootInActiveWindow = this.f283a.getRootInActiveWindow();
            if (rootInActiveWindow != null) {
                try {
                    CharSequence packageName = rootInActiveWindow.getPackageName();
                    string2 = packageName != null ? packageName.toString() : "";
                    try {
                        CharSequence className = rootInActiveWindow.getClassName();
                        string = className != null ? className.toString() : "";
                    } catch (Throwable th) {
                        str = string2;
                        th = th;
                        try {
                            Log.d("AppForegroundGuard", "active package unavailable: " + th.getMessage());
                            if (rootInActiveWindow != null) {
                                try {
                                    rootInActiveWindow.recycle();
                                } catch (Throwable unused) {
                                }
                            }
                            string = "";
                            string2 = str;
                        } catch (Throwable th2) {
                            if (rootInActiveWindow != null) {
                                try {
                                    rootInActiveWindow.recycle();
                                } catch (Throwable unused2) {
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str = "";
                }
            } else {
                string = "";
                string2 = string;
            }
            if (rootInActiveWindow != null) {
                try {
                    rootInActiveWindow.recycle();
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable th4) {
            th = th4;
            str = "";
            rootInActiveWindow = null;
        }
        d dVar = this.f288f;
        k kVarP = this.f285c.p();
        boolean z3 = false;
        if (z2 || string2.equals(dVar.f265b) || kVarP.f325l.startsWith("ime")) {
            String str2 = kVarP.f318e;
            try {
                List<AccessibilityWindowInfo> windows = this.f283a.getWindows();
                if (windows == null) {
                    fVar = new f(false, false, false);
                } else {
                    boolean z4 = false;
                    for (AccessibilityWindowInfo accessibilityWindowInfo : windows) {
                        if (accessibilityWindowInfo != null) {
                            try {
                                if (accessibilityWindowInfo.getType() == 2 && (accessibilityWindowInfo.isActive() || accessibilityWindowInfo.isFocused())) {
                                    z3 = true;
                                }
                                if (str2.isEmpty() || accessibilityWindowInfo.getType() != 1) {
                                    root = null;
                                } else {
                                    root = accessibilityWindowInfo.getRoot();
                                    if (root != null) {
                                        try {
                                            CharSequence packageName2 = root.getPackageName();
                                            if (str2.equals(packageName2 != null ? packageName2.toString() : "")) {
                                                z4 = true;
                                            }
                                        } catch (Throwable unused4) {
                                            if (root != null) {
                                                try {
                                                    root.recycle();
                                                } catch (Throwable unused5) {
                                                }
                                            }
                                        }
                                    }
                                }
                                if (root != null) {
                                    root.recycle();
                                }
                            } catch (Throwable unused6) {
                                root = null;
                            }
                            accessibilityWindowInfo.recycle();
                        }
                    }
                    fVar = new f(true, z3, z4);
                }
            } catch (Throwable unused7) {
                fVar = new f(false, false, false);
            }
        } else {
            fVar = new f(false, false, false);
        }
        return new y.m(string2, string, fVar);
    }

    public final void v() {
        long j3;
        g gVar;
        l lVar = this.f285c;
        synchronized (lVar) {
            long jN = lVar.f333a.n();
            if (lVar.f349r) {
                j3 = lVar.f350s ? l.j(lVar.f352u, jN) : l.j(lVar.f353v, jN);
            } else {
                j3 = 0;
            }
        }
        if (j3 <= 0) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() + j3;
        synchronized (this.f287e) {
            try {
                ScheduledExecutorService scheduledExecutorService = this.f291i;
                if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
                    long j4 = this.f292j;
                    if (j4 <= 0 || j4 > jUptimeMillis) {
                        this.f292j = jUptimeMillis;
                        try {
                            gVar = this;
                            try {
                                scheduledExecutorService.schedule(new b(gVar, scheduledExecutorService, jUptimeMillis, 0), j3, TimeUnit.MILLISECONDS);
                            } catch (Throwable unused) {
                                if (gVar.f292j == jUptimeMillis) {
                                    gVar.f292j = 0L;
                                }
                            }
                        } catch (Throwable unused2) {
                            gVar = this;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void w(boolean z2, boolean z3) {
        k kVarP = this.f285c.p();
        boolean z4 = z2 && !z3 && (!kVarP.f322i || kVarP.f323j);
        if (z4) {
            q();
        }
        synchronized (this.f286d) {
            this.f285c.n(z2, z3);
        }
        p();
        if (z4) {
            t();
        }
        l(false);
    }

    public final void x() {
        synchronized (f277o) {
            q();
            this.f288f = g(this.f283a);
            synchronized (this.f286d) {
                l lVar = this.f285c;
                synchronized (lVar) {
                    lVar.f335c = true;
                    lVar.i(lVar.f333a.n());
                }
            }
            f278p = this;
        }
        A();
        p();
        l(true);
    }

    public final String y() {
        String string;
        synchronized (this.f293k) {
            string = r(this.f285c.p(), this.n, true, k()).toString();
        }
        return string;
    }

    public final void z() {
        synchronized (f277o) {
            try {
                if (f278p == this) {
                    f278p = null;
                }
                synchronized (this.f286d) {
                    l lVar = this.f285c;
                    synchronized (lVar) {
                        lVar.f335c = false;
                        lVar.c();
                        lVar.d();
                        lVar.C = 1;
                        lVar.f342j = "";
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.f287e) {
            try {
                ScheduledExecutorService scheduledExecutorService = this.f291i;
                this.f291i = null;
                this.f292j = 0L;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        l(true);
    }
}
