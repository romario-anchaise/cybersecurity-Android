// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.app.Notification;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.util.LruCache;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import lyr.stable.runtime.NotificationListener;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class v7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InputStream f5308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OutputStream f5309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final se f5310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DataOutputStream f5311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DataInputStream f5312f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Thread f5313g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f5314h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashSet f5315i = new HashSet();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f5316j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ w7 f5317k;

    public v7(w7 w7Var, InputStream inputStream, OutputStream outputStream, String str, se seVar) {
        this.f5317k = w7Var;
        this.f5307a = str;
        this.f5308b = inputStream;
        this.f5309c = outputStream;
        this.f5310d = seVar;
    }

    public final synchronized void a() {
        if (this.f5316j) {
            return;
        }
        this.f5316j = true;
        this.f5317k.f5405e.remove(this);
        se seVar = this.f5310d;
        if (seVar != null) {
            try {
                seVar.run();
            } catch (Throwable th) {
                Log.w("MirrorNotifSrv", "onClose fail (" + this.f5307a + "): " + th.getMessage());
            }
        }
    }

    public final JSONObject b(StatusBarNotification statusBarNotification) {
        String str;
        String strA;
        HashSet hashSet = this.f5315i;
        w7 w7Var = this.f5317k;
        try {
            Notification notification = statusBarNotification.getNotification();
            if (notification == null) {
                return null;
            }
            String packageName = statusBarNotification.getPackageName();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", statusBarNotification.getKey());
            jSONObject.put("packageName", packageName);
            LruCache lruCache = w7Var.f5407g;
            if (packageName == null) {
                str = "";
            } else {
                String string = (String) lruCache.get(packageName);
                if (string != null) {
                    str = string;
                } else {
                    try {
                        PackageManager packageManager = w7Var.f5401a.getPackageManager();
                        string = packageManager.getApplicationLabel(packageManager.getApplicationInfo(packageName, 0)).toString();
                        lruCache.put(packageName, string);
                        str = string;
                    } catch (Throwable unused) {
                        lruCache.put(packageName, packageName);
                        str = packageName;
                    }
                }
            }
            jSONObject.put("appName", str);
            jSONObject.put("postTime", statusBarNotification.getPostTime());
            jSONObject.put("isOngoing", statusBarNotification.isOngoing());
            jSONObject.put("isClearable", statusBarNotification.isClearable());
            Bundle bundle = notification.extras;
            if (bundle != null) {
                jSONObject.put("title", w7.b(bundle, "android.title"));
                jSONObject.put("text", w7.b(bundle, "android.text"));
                jSONObject.put("subText", w7.b(bundle, "android.subText"));
                jSONObject.put("bigText", w7.b(bundle, "android.bigText"));
                jSONObject.put("summaryText", w7.b(bundle, "android.summaryText"));
                jSONObject.put("infoText", w7.b(bundle, "android.infoText"));
            }
            CharSequence charSequence = notification.tickerText;
            if (charSequence != null) {
                jSONObject.put("tickerText", charSequence.toString());
            }
            if (!hashSet.contains(packageName) && (strA = w7.a(w7Var, packageName)) != null) {
                jSONObject.put("appIcon", strA);
                hashSet.add(packageName);
            }
            return jSONObject;
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("encodeNotification: "), "MirrorNotifSrv");
            return null;
        }
    }

    public final void c(int i3, byte[] bArr) {
        try {
            NotificationListener notificationListenerC = NotificationListener.c();
            if (i3 == 16) {
                String strOptString = new JSONObject(new String(bArr, StandardCharsets.UTF_8)).optString("key", "");
                if (notificationListenerC != null && !strOptString.isEmpty()) {
                    try {
                        notificationListenerC.cancelNotification(strOptString);
                    } catch (Throwable th) {
                        Log.w("MirrorNotifLsnr", "cancelNotification fail: " + th.getMessage());
                    }
                }
            } else if (i3 == 17) {
                if (notificationListenerC != null) {
                    try {
                        notificationListenerC.cancelAllNotifications();
                    } catch (Throwable th2) {
                        Log.w("MirrorNotifLsnr", "cancelAllNotifications fail: " + th2.getMessage());
                    }
                }
            } else if (i3 != 18) {
                Log.w("MirrorNotifSrv", "unknown PC cmd: " + i3);
            } else if (f()) {
                e();
            }
        } catch (Throwable th3) {
            a0.a.p(th3, new StringBuilder("handleCommand: "), "MirrorNotifSrv");
        }
    }

    public final void d(byte b3, JSONObject jSONObject) {
        synchronized (this.f5314h) {
            try {
                this.f5311e.write(w7.c(b3, jSONObject));
                this.f5311e.flush();
            } catch (IOException e3) {
                Log.w("MirrorNotifSrv", "sendFrame fail (peer=" + this.f5307a + "): " + e3.getMessage());
                a();
                this.f5317k.f5405e.remove(this);
            }
        }
    }

    public final void e() {
        try {
            NotificationListener notificationListenerC = NotificationListener.c();
            StatusBarNotification[] statusBarNotificationArrB = notificationListenerC != null ? notificationListenerC.b() : new StatusBarNotification[0];
            JSONArray jSONArray = new JSONArray();
            for (StatusBarNotification statusBarNotification : statusBarNotificationArrB) {
                JSONObject jSONObjectB = b(statusBarNotification);
                if (jSONObjectB != null) {
                    jSONArray.put(jSONObjectB);
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("items", jSONArray);
            d((byte) 1, jSONObject);
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("sendSnapshot: "), "MirrorNotifSrv");
        }
    }

    public final boolean f() {
        try {
            NotificationListener notificationListenerC = NotificationListener.c();
            boolean z2 = notificationListenerC != null && notificationListenerC.f2460b;
            boolean zD = this.f5317k.d();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("listenerConnected", z2);
            jSONObject.put("hasAccess", zD);
            jSONObject.put("sdkInt", Build.VERSION.SDK_INT);
            jSONObject.put("model", Build.MANUFACTURER + " " + Build.MODEL);
            d((byte) 4, jSONObject);
            return zD;
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("sendState: "), "MirrorNotifSrv");
            return false;
        }
    }
}
