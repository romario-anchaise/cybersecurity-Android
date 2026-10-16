// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Log;
import java.util.HashSet;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PowerManager.WakeLock f4332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WifiManager.WifiLock f4333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static PowerManager.WakeLock f4334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static WifiManager.WifiLock f4335d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static PowerManager.WakeLock f4338g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static WifiManager.WifiLock f4339h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashSet f4336e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Handler f4337f = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d2.r f4340i = new d2.r(8);

    public static void a(ScreenMirrorService screenMirrorService) {
        WifiManager.WifiLock wifiLock;
        Context applicationContext = screenMirrorService.getApplicationContext();
        try {
            PowerManager powerManager = (PowerManager) applicationContext.getSystemService("power");
            if (powerManager == null) {
                return;
            }
            synchronized (j6.class) {
                try {
                    PowerManager.WakeLock wakeLock = f4334c;
                    if (wakeLock == null || !wakeLock.isHeld()) {
                        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, applicationContext.getPackageName() + ":A11yRadio");
                        f4334c = wakeLockNewWakeLock;
                        wakeLockNewWakeLock.setReferenceCounted(false);
                        f4334c.acquire();
                    }
                    WifiManager wifiManager = (WifiManager) applicationContext.getSystemService("wifi");
                    if (wifiManager != null && ((wifiLock = f4335d) == null || !wifiLock.isHeld())) {
                        WifiManager.WifiLock wifiLockCreateWifiLock = wifiManager.createWifiLock(3, applicationContext.getPackageName() + ":A11yRadioWifi");
                        f4335d = wifiLockCreateWifiLock;
                        wifiLockCreateWifiLock.setReferenceCounted(false);
                        f4335d.acquire();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            Log.i("MirrorRecovery", "a11y radio CPU+WiFi HIGH_PERF held");
        } catch (Throwable th2) {
            Log.w("MirrorRecovery", "a11y radio lock acquire failed", th2);
        }
    }

    public static void b(Context context, String str) {
        WifiManager.WifiLock wifiLock;
        PowerManager.WakeLock wakeLock;
        if (context == null || str.isEmpty()) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        synchronized (j6.class) {
            HashSet hashSet = f4336e;
            hashSet.add(str);
            f4337f.removeCallbacks(f4340i);
            try {
                PowerManager powerManager = (PowerManager) applicationContext.getSystemService("power");
                if (powerManager != null && ((wakeLock = f4338g) == null || !wakeLock.isHeld())) {
                    PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, applicationContext.getPackageName() + ":ViewerLease");
                    f4338g = wakeLockNewWakeLock;
                    wakeLockNewWakeLock.setReferenceCounted(false);
                    f4338g.acquire();
                }
                WifiManager wifiManager = (WifiManager) applicationContext.getSystemService("wifi");
                if (wifiManager != null && ((wifiLock = f4339h) == null || !wifiLock.isHeld())) {
                    WifiManager.WifiLock wifiLockCreateWifiLock = wifiManager.createWifiLock(3, applicationContext.getPackageName() + ":ViewerLeaseWifi");
                    f4339h = wifiLockCreateWifiLock;
                    wifiLockCreateWifiLock.setReferenceCounted(false);
                    f4339h.acquire();
                }
                Log.i("MirrorRecovery", "viewer lease acquired id=" + str + " count=" + hashSet.size());
            } catch (Throwable th) {
                Log.w("MirrorRecovery", "viewer lease lock acquire failed", th);
            }
        }
    }

    public static void c() {
        synchronized (j6.class) {
            PowerManager.WakeLock wakeLock = f4334c;
            if (wakeLock != null && wakeLock.isHeld()) {
                try {
                    f4334c.release();
                } catch (Throwable unused) {
                }
            }
            f4334c = null;
            WifiManager.WifiLock wifiLock = f4335d;
            if (wifiLock != null && wifiLock.isHeld()) {
                try {
                    f4335d.release();
                } catch (Throwable unused2) {
                }
            }
            f4335d = null;
        }
        Log.i("MirrorRecovery", "a11y radio locks released");
    }

    public static void d(String str) {
        if (str.isEmpty()) {
            return;
        }
        synchronized (j6.class) {
            try {
                HashSet hashSet = f4336e;
                hashSet.remove(str);
                Log.i("MirrorRecovery", "viewer lease released id=" + str + " count=" + hashSet.size());
                if (hashSet.isEmpty()) {
                    Handler handler = f4337f;
                    d2.r rVar = f4340i;
                    handler.removeCallbacks(rVar);
                    handler.postDelayed(rVar, 60000L);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
