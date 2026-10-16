// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime;

import a0.a;
import a2.b;
import android.app.Notification;
import android.os.Handler;
import android.os.Process;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;
import w1.u7;
import w1.w7;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class NotificationListener extends NotificationListenerService {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static WeakReference f2458c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f2459a = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f2460b = false;

    public static NotificationListener c() {
        WeakReference weakReference = f2458c;
        if (weakReference != null) {
            return (NotificationListener) weakReference.get();
        }
        return null;
    }

    public final void a(StatusBarNotification statusBarNotification) {
        Notification notification;
        try {
            if ("com.samsung.android.sm.devicesecurity".equals(statusBarNotification.getPackageName()) && (notification = statusBarNotification.getNotification()) != null && "APP_VERIFICATION".equals(notification.getChannelId())) {
                try {
                    cancelNotification(statusBarNotification.getKey());
                } catch (Throwable th) {
                    Log.w("MirrorNotifLsnr", "cancelNotification fail: " + th.getMessage());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final StatusBarNotification[] b() {
        try {
            StatusBarNotification[] activeNotifications = getActiveNotifications();
            return activeNotifications != null ? activeNotifications : new StatusBarNotification[0];
        } catch (Throwable th) {
            a.p(th, new StringBuilder("getActiveNotifications fail: "), "MirrorNotifLsnr");
            return new StatusBarNotification[0];
        }
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        f2458c = new WeakReference(this);
        Log.i("MirrorNotifLsnr", "NotificationListener onCreate pid=" + Process.myPid());
    }

    @Override // android.service.notification.NotificationListenerService, android.app.Service
    public final void onDestroy() {
        Log.w("MirrorNotifLsnr", "NotificationListener onDestroy");
        this.f2460b = false;
        WeakReference weakReference = f2458c;
        if (weakReference != null) {
            weakReference.clear();
        }
        super.onDestroy();
    }

    @Override // android.service.notification.NotificationListenerService
    public final void onListenerConnected() {
        super.onListenerConnected();
        this.f2460b = true;
        Log.i("MirrorNotifLsnr", "onListenerConnected, active=" + b().length);
        for (StatusBarNotification statusBarNotification : b()) {
            a(statusBarNotification);
        }
        for (w7 w7Var : this.f2459a) {
            try {
                Handler handler = w7Var.f5404d;
                if (handler != null) {
                    handler.post(new b(27, w7Var));
                }
            } catch (Throwable th) {
                a.p(th, new StringBuilder("listener.onConnected: "), "MirrorNotifLsnr");
            }
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public final void onListenerDisconnected() {
        super.onListenerDisconnected();
        this.f2460b = false;
        Log.w("MirrorNotifLsnr", "onListenerDisconnected");
    }

    @Override // android.service.notification.NotificationListenerService
    public final void onNotificationPosted(StatusBarNotification statusBarNotification) {
        if (statusBarNotification == null) {
            return;
        }
        a(statusBarNotification);
        for (w7 w7Var : this.f2459a) {
            try {
                Handler handler = w7Var.f5404d;
                if (handler != null) {
                    handler.post(new u7(w7Var, statusBarNotification, 0));
                }
            } catch (Throwable th) {
                a.p(th, new StringBuilder("listener.onPosted: "), "MirrorNotifLsnr");
            }
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public final void onNotificationRemoved(StatusBarNotification statusBarNotification) {
        if (statusBarNotification == null) {
            return;
        }
        for (w7 w7Var : this.f2459a) {
            try {
                Handler handler = w7Var.f5404d;
                if (handler != null) {
                    handler.post(new u7(w7Var, statusBarNotification, 1));
                }
            } catch (Throwable th) {
                a.p(th, new StringBuilder("listener.onRemoved: "), "MirrorNotifLsnr");
            }
        }
    }
}
