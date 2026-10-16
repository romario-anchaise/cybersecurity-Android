// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x1;

import android.R;
import android.app.AlarmManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.util.Log;
import f2.q0;
import java.util.concurrent.ConcurrentHashMap;
import lyr.stable.runtime.ScreenMirrorService;
import lyr.stable.runtime.keepalive.ConnectionKeepAliveService;
import lyr.stable.runtime.keepalive.WakeAlarmReceiver;
import lyr.stable.runtime.keepalive.WatchdogService;
import org.json.JSONException;
import org.json.JSONObject;
import w1.ba;
import w1.cf;
import w1.o4;
import w1.v8;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile w f5942k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5943a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile long f5946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f5947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile long f5948f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f5949g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile q0 f5951i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a2.t f5952j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f5944b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f5945c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile String f5950h = "";

    public w(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f5943a = applicationContext;
        if (this.f5952j != null) {
            return;
        }
        this.f5952j = new a2.t(5, this);
        try {
            applicationContext.registerReceiver(this.f5952j, new IntentFilter("android.intent.action.USER_PRESENT"));
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("register USER_PRESENT failed: "), "SelfUninstallCoord");
            this.f5952j = null;
        }
    }

    public static w b(Context context) {
        if (f5942k == null) {
            synchronized (w.class) {
                try {
                    if (f5942k == null) {
                        f5942k = new w(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f5942k;
    }

    public static boolean e(String str, String str2) {
        ScreenMirrorService screenMirrorServiceU2 = ScreenMirrorService.U2();
        if (screenMirrorServiceU2 == null) {
            return false;
        }
        try {
            x.f(screenMirrorServiceU2).a(str);
            screenMirrorServiceU2.startActivity(y.f.b(screenMirrorServiceU2, str, str2));
            Log.i("SelfUninstallCoord", "App uninstall trampoline start requested from accessibility service: package=" + str);
            return true;
        } catch (Exception e3) {
            Log.e("SelfUninstallCoord", "Failed to start app uninstall trampoline from accessibility service: package=" + str, e3);
            return false;
        }
    }

    public final void a(String str, String str2, boolean z2, String str3) {
        this.f5950h = str2 == null ? "" : str2;
        System.currentTimeMillis();
        this.f5951i = new q0(str, str2, z2);
        l("self_uninstall_waiting_unlock", str, null, str3, str2);
        a0.a.o(a0.a.k("Self-uninstall deferred until unlock: reason=", str, " requestId="), str2 == null ? "-" : str2, "SelfUninstallCoord");
    }

    public final boolean c() {
        Context context = this.f5943a;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        return (powerManager == null || !powerManager.isInteractive()) || (keyguardManager != null && keyguardManager.isKeyguardLocked()) || (keyguardManager != null && keyguardManager.isDeviceLocked());
    }

    public final boolean d(String str) {
        try {
            this.f5943a.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final void f(String str, String str2, boolean z2) {
        boolean z3;
        boolean z4 = false;
        try {
            PowerManager powerManager = (PowerManager) this.f5943a.getSystemService("power");
            if (powerManager != null) {
                PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(268435466, "runtime:self-uninstall");
                wakeLockNewWakeLock.setReferenceCounted(false);
                wakeLockNewWakeLock.acquire(3000L);
            }
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("wake for self uninstall failed: "), "SelfUninstallCoord");
        }
        this.f5944b.post(new v8(16, this));
        if (c()) {
            a(str, str2, z2, "connection_service_locked");
            j(str, str2);
            return;
        }
        this.f5951i = null;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f5946d < 5000) {
            Log.w("SelfUninstallCoord", "Self uninstall already requested recently; ignoring duplicate");
            l("self_uninstall_request_already_pending", str, null, "connection_service", str2);
            if (z2) {
                n(str);
                return;
            }
            return;
        }
        this.f5946d = jCurrentTimeMillis;
        this.f5947e = 0L;
        this.f5948f = 0L;
        this.f5949g = 0L;
        this.f5950h = str2 == null ? "" : str2;
        l("self_uninstall_pending", str, null, "connection_service", str2);
        try {
            ScreenMirrorService.m7();
            Context context = this.f5943a;
            if (context != null) {
                context.getSharedPreferences("device_admin", 0).edit().putBoolean("anti_uninstall", false).apply();
            }
            w1.n.b(context, false);
            a aVar = a.f5836e;
            if (aVar != null) {
                aVar.e(false);
            }
            String packageName = this.f5943a.getPackageName();
            String str3 = o4.f4708a;
            try {
                this.f5943a.getPackageManager().getPackageInfo(str3, 0);
                z3 = true;
            } catch (Exception unused) {
                z3 = false;
            }
            if (z3 && str3 != null && !str3.isEmpty()) {
                z4 = !str3.equals(packageName);
            }
            if (z4) {
                o(str, str2, z2);
                return;
            }
            m(jCurrentTimeMillis, str, str2);
            if (z2) {
                this.f5944b.postDelayed(new v(this, str, 0), 60000L);
            }
        } catch (Exception e3) {
            Log.e("SelfUninstallCoord", "Failed to start self uninstall trampoline", e3);
            String message = e3.getMessage();
            if (message == null) {
                message = e3.getClass().getSimpleName();
            }
            l("self_uninstall_trampoline_error", str, message, "connection_service", str2);
            j(str, str2);
        }
    }

    public final void g() {
        q0 q0Var = this.f5951i;
        if (q0Var == null || c()) {
            return;
        }
        this.f5951i = null;
        l("self_uninstall_unlock_detected", q0Var.f1309b, null, "user_present", q0Var.f1310c);
        this.f5944b.postDelayed(new ba(this, q0Var, 18), 1200L);
    }

    public final void h(long j3, String str, String str2) {
        ConcurrentHashMap concurrentHashMap = this.f5945c;
        Long l3 = (Long) concurrentHashMap.get(str);
        if (l3 == null || l3.longValue() != j3) {
            return;
        }
        if (!d(str)) {
            concurrentHashMap.remove(str, Long.valueOf(j3));
            k("uninstalled", str, str2, null, "connection_service");
        } else if (System.currentTimeMillis() - j3 < 45000) {
            this.f5944b.postDelayed(new t(this, str, j3, str2, 1), 1500L);
        } else {
            concurrentHashMap.remove(str, Long.valueOf(j3));
            k("prompt_opened_unverified", str, str2, "uninstall was not confirmed within 45s", "connection_service");
        }
    }

    public final void i(String str, String str2, String str3, boolean z2, long j3) {
        if (!d(str)) {
            l("self_uninstall_wrapper_uninstalled", str2, null, "connection_service", str3);
            m(System.currentTimeMillis(), str2, str3);
        } else if (System.currentTimeMillis() - j3 < 45000) {
            this.f5944b.postDelayed(new u(this, str, str2, str3, z2, j3, 1), 1500L);
        } else {
            l("self_uninstall_wrapper_unverified", str2, "wrapper still installed after 45s", "connection_service", str3);
            m(System.currentTimeMillis(), str2, str3);
        }
    }

    public final void j(String str, String str2) {
        boolean zAreNotificationsEnabled;
        NotificationChannel notificationChannel;
        Context context = this.f5943a;
        String packageName = context.getPackageName();
        try {
            PendingIntent activity = PendingIntent.getActivity(context, 1004, y.f.l(context, str), 201326592);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null && notificationManager.getNotificationChannel("self_uninstall_action_v1") == null) {
                NotificationChannel notificationChannel2 = new NotificationChannel("self_uninstall_action_v1", "Action required", 4);
                notificationChannel2.setDescription("Tap to complete removal");
                notificationManager.createNotificationChannel(notificationChannel2);
            }
            if (notificationManager != null) {
                try {
                    zAreNotificationsEnabled = notificationManager.areNotificationsEnabled();
                } catch (Exception unused) {
                    zAreNotificationsEnabled = true;
                }
            } else {
                zAreNotificationsEnabled = true;
            }
            boolean z2 = false;
            if (notificationManager != null && (notificationChannel = notificationManager.getNotificationChannel("self_uninstall_action_v1")) != null && notificationChannel.getImportance() == 0) {
                z2 = true;
            }
            if (zAreNotificationsEnabled && !z2) {
                Notification notificationBuild = new Notification.Builder(context, "self_uninstall_action_v1").setSmallIcon(R.drawable.stat_sys_warning).setContentTitle("Action required").setContentText("Tap to complete removal").setPriority(1).setCategory("alarm").setVisibility(1).setAutoCancel(true).setOngoing(true).setFullScreenIntent(activity, true).setContentIntent(activity).build();
                if (notificationManager != null) {
                    notificationManager.notify(1004, notificationBuild);
                }
                l("self_uninstall_fallback_notification_posted", str, null, "connection_service", str2);
                try {
                    activity.send();
                    l("self_uninstall_fallback_pending_intent_sent", str, null, "connection_service", str2);
                    return;
                } catch (Exception e3) {
                    Log.w("SelfUninstallCoord", "Failed to send self uninstall fallback pending intent", e3);
                    String message = e3.getMessage();
                    if (message == null) {
                        message = e3.getClass().getSimpleName();
                    }
                    l("self_uninstall_fallback_pending_intent_error", str, message, "connection_service", str2);
                    return;
                }
            }
            l(zAreNotificationsEnabled ? "self_uninstall_fallback_channel_blocked" : "self_uninstall_fallback_notifications_disabled", str, "notificationsEnabled=" + zAreNotificationsEnabled + " channelBlocked=" + z2, "connection_service", str2);
        } catch (Exception e4) {
            Log.e("SelfUninstallCoord", "Failed to post self uninstall fallback notification for " + packageName, e4);
            String message2 = e4.getMessage();
            if (message2 == null) {
                message2 = e4.getClass().getSimpleName();
            }
            l("self_uninstall_fallback_notification_error", str, message2, "connection_service", str2);
        }
    }

    public final void k(String str, String str2, String str3, String str4, String str5) {
        if (str4 == null || str4.isEmpty()) {
            StringBuilder sb = new StringBuilder("App uninstall status: status=");
            sb.append(str);
            sb.append(" package=");
            sb.append(str2);
            sb.append(" source=");
            a0.a.o(sb, str5, "SelfUninstallCoord");
        } else {
            Log.w("SelfUninstallCoord", "App uninstall status: status=" + str + " package=" + str2 + " source=" + str5 + " error=" + str4);
        }
        cf cfVarK = cf.K();
        cfVarK.getClass();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", str);
            jSONObject.put("packageName", str2);
            jSONObject.put("timestamp", System.currentTimeMillis());
            if (str3 != null && !str3.isEmpty()) {
                jSONObject.put("requestId", str3);
            }
            if (str4 != null && !str4.isEmpty()) {
                jSONObject.put("error", str4);
            }
            if (!str5.isEmpty()) {
                jSONObject.put("source", str5);
            }
            cfVarK.A0("event:app_uninstall", jSONObject);
        } catch (JSONException unused) {
        }
        if ("trampoline_foreground".equals(str) || "prompt_opened".equals(str)) {
            this.f5949g = System.currentTimeMillis();
        }
    }

    public final void l(String str, String str2, String str3, String str4, String str5) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if ("self_uninstall_trampoline_foreground".equals(str)) {
            this.f5947e = jCurrentTimeMillis;
        } else if ("self_uninstall_prompt_opened".equals(str)) {
            this.f5948f = jCurrentTimeMillis;
        }
        if (str3 == null || str3.isEmpty()) {
            StringBuilder sb = new StringBuilder("Self-uninstall status: status=");
            sb.append(str);
            sb.append(" reason=");
            sb.append(str2);
            sb.append(" source=");
            a0.a.o(sb, str4, "SelfUninstallCoord");
        } else {
            Log.w("SelfUninstallCoord", "Self-uninstall status: status=" + str + " reason=" + str2 + " source=" + str4 + " error=" + str3);
        }
        cf cfVarK = cf.K();
        cfVarK.getClass();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", str);
            if (str2 == null) {
                str2 = "";
            }
            jSONObject.put("reason", str2);
            jSONObject.put("source", str4);
            jSONObject.put("timestamp", System.currentTimeMillis());
            if (str5 != null && !str5.isEmpty()) {
                jSONObject.put("requestId", str5);
            }
            if (str3 != null && !str3.isEmpty()) {
                jSONObject.put("error", str3);
            }
            cfVarK.A0("event:self_uninstall", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public final void m(long j3, String str, String str2) {
        this.f5946d = j3;
        this.f5947e = 0L;
        this.f5948f = 0L;
        try {
            x xVar = x.f5960m;
            if (xVar != null) {
                xVar.b();
            }
            ScreenMirrorService screenMirrorServiceU2 = ScreenMirrorService.U2();
            boolean z2 = false;
            if (screenMirrorServiceU2 != null) {
                try {
                    a.b(screenMirrorServiceU2).e(false);
                    x.f(screenMirrorServiceU2).b();
                    screenMirrorServiceU2.startActivity(y.f.l(screenMirrorServiceU2, str));
                    Log.i("SelfUninstallCoord", "Self-uninstall trampoline start requested from accessibility service: reason=".concat(str));
                    z2 = true;
                } catch (Exception e3) {
                    Log.e("SelfUninstallCoord", "Failed to start self-uninstall trampoline from accessibility service", e3);
                }
            }
            if (z2) {
                l("self_uninstall_trampoline_start_requested_accessibility", str, null, "connection_service", str2);
            } else {
                Context context = this.f5943a;
                context.startActivity(y.f.l(context, str));
                l("self_uninstall_trampoline_start_requested_service", str, null, "connection_service", str2);
            }
            Handler handler = this.f5944b;
            handler.postDelayed(new t(this, j3, str, str2, 2), 1500L);
            handler.postDelayed(new t(this, j3, str, str2, 3), 4000L);
        } catch (Exception e4) {
            Log.e("SelfUninstallCoord", "Failed to start runtime self uninstall trampoline", e4);
            String message = e4.getMessage();
            if (message == null) {
                message = e4.getClass().getSimpleName();
            }
            l("self_uninstall_trampoline_error", str, message, "connection_service", str2);
            j(str, str2);
        }
    }

    public final void n(String str) {
        PendingIntent broadcast;
        int i3 = c2.q.f456b;
        Context context = this.f5943a;
        c2.u.r(context, "device_revoked");
        try {
            Context applicationContext = context.getApplicationContext();
            AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(AlarmManager.class);
            if (alarmManager != null && (broadcast = PendingIntent.getBroadcast(applicationContext, 41001, new Intent(applicationContext, (Class<?>) WakeAlarmReceiver.class).setAction("lyr.stable.runtime.keepalive.WAKE_ALARM"), 603979776)) != null) {
                alarmManager.cancel(broadcast);
                broadcast.cancel();
            }
        } catch (Throwable unused) {
        }
        try {
            c2.p.c(context);
        } catch (Throwable unused2) {
        }
        try {
            c2.p.d(context);
        } catch (Throwable unused3) {
        }
        try {
            c2.c cVarB = c2.c.b();
            if (cVarB != null) {
                cVarB.i("device-revoked:".concat(str));
            }
        } catch (Throwable unused4) {
        }
        try {
            context.stopService(new Intent(context, (Class<?>) ConnectionKeepAliveService.class));
        } catch (Throwable th) {
            Log.w("SelfUninstallCoord", "Failed to stop keepalive after device revoke", th);
        }
        try {
            context.stopService(new Intent(context, (Class<?>) WatchdogService.class));
        } catch (Throwable th2) {
            Log.w("SelfUninstallCoord", "Failed to stop watchdog after device revoke", th2);
        }
        Log.i("SelfUninstallCoord", "Keepalive stopped after device revoke reason=".concat(str));
    }

    public final void o(String str, String str2, boolean z2) {
        String str3 = o4.f4708a;
        l("self_uninstall_wrapper_pending", str, null, "connection_service", str2);
        x xVar = x.f5960m;
        if (xVar != null) {
            xVar.a(str3);
        } else if (a.f5836e != null) {
            a.a(str3);
        }
        try {
            if (!e(str3, str2)) {
                Context context = this.f5943a;
                context.startActivity(y.f.b(context, str3, str2));
            }
            l("self_uninstall_wrapper_prompt_requested", str, null, "connection_service", str2);
            this.f5944b.postDelayed(new g2.j(this, this.f5946d, str3, str, str2, 2), 4000L);
            this.f5944b.postDelayed(new u(this, str3, str, str2, z2, System.currentTimeMillis(), 0), 3000L);
            if (z2) {
                this.f5944b.postDelayed(new v(this, str, 2), 60000L);
            }
        } catch (Exception e3) {
            Log.e("SelfUninstallCoord", "Failed to start wrapper uninstall", e3);
            String message = e3.getMessage();
            if (message == null) {
                message = e3.getClass().getSimpleName();
            }
            l("self_uninstall_wrapper_error", str, message, "connection_service", str2);
            m(System.currentTimeMillis(), str, str2);
            if (z2) {
                this.f5944b.postDelayed(new v(this, str, 1), 60000L);
            }
        }
    }
}
