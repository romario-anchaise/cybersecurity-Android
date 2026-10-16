// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x1;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile a f5836e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile ScreenMirrorService f5837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f5838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f5839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f5840d;

    static {
        new HashSet(Arrays.asList("com.android.launcher", "com.android.launcher2", "com.android.launcher3", "com.google.android.apps.nexuslauncher", "com.samsung.android.launcher", "com.sec.android.app.launcher", "com.miui.home", "com.miui.launcher", "com.huawei.android.launcher", "com.hihonor.android.launcher", "com.oppo.launcher", "com.coloros.launcher", "com.oneplus.launcher", "com.vivo.launcher", "com.bbk.launcher2", "com.motorola.android.launcher", "com.motorola.android.launcher3", "com.motorola.launcher3", "com.transsion.xoslauncher", "com.transsion.hilauncher", "com.infinix.xlauncher", "com.itel.launcher", "com.cyanogenmod.trebuchet", "com.teslacoilsw.launcher", "com.actionlauncher.playstore", "com.smartlauncher.themes", "com.microsoft.launcher", "nl.taskcoach"));
        new HashSet(Arrays.asList("com.android.dialer", "com.google.android.dialer", "com.android.contacts", "com.android.mms", "com.google.android.apps.messaging", "com.android.incallui", "com.android.systemui", "com.android.phone", "com.google.android.gms"));
    }

    public a(ScreenMirrorService screenMirrorService) {
        new Handler(Looper.getMainLooper());
        Set set = Collections.EMPTY_SET;
        this.f5837a = screenMirrorService;
        SharedPreferences sharedPreferencesE = c2.p.e(screenMirrorService, "anti_uninstall_guard");
        this.f5838b = sharedPreferencesE;
        screenMirrorService.getPackageName();
        this.f5839c = sharedPreferencesE.getBoolean("enabled", true);
    }

    public static void a(String str) {
        if (str == null) {
            str = "";
        }
        System.currentTimeMillis();
        Log.i("AntiUninstallGuard", "operator uninstall window package=" + str + " durationMs=15000");
    }

    public static a b(ScreenMirrorService screenMirrorService) {
        if (f5836e == null) {
            synchronized (a.class) {
                try {
                    if (f5836e == null) {
                        f5836e = new a(screenMirrorService);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (f5836e.f5837a != screenMirrorService) {
            Log.i("AntiUninstallGuard", "service rebound, refresh reference");
            f5836e.f5837a = screenMirrorService;
        }
        return f5836e;
    }

    public final synchronized void c() {
        Log.i("AntiUninstallGuard", "locale identity cache invalidated");
    }

    public final void d(boolean z2) {
        if (this.f5840d == z2) {
            return;
        }
        this.f5840d = z2;
        Log.i("AntiUninstallGuard", z2 ? "operator teardown hold" : "operator teardown hold cleared");
    }

    public final void e(boolean z2) {
        this.f5839c = z2;
        this.f5838b.edit().putBoolean("enabled", z2).apply();
        Log.i("AntiUninstallGuard", z2 ? "enabled" : "disabled");
    }
}
