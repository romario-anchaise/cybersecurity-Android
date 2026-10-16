// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c2;

import android.accessibilityservice.AccessibilityService;
import android.app.AlarmManager;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.PowerManager;
import android.os.SystemClock;
import android.os.UserManager;
import android.util.Log;
import g2.a0;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Locale;
import lyr.stable.runtime.defense.WeakRecoveryReceiver;
import lyr.stable.runtime.engine.CompanionService;
import lyr.stable.runtime.engine.EngineService;
import lyr.stable.runtime.engine.KeepAliveDaemonService;
import lyr.stable.runtime.keepalive.ConnectionKeepAliveService;
import lyr.stable.runtime.keepalive.ConnectionRecoveryReceiver;
import lyr.stable.runtime.keepalive.WakeAlarmReceiver;
import lyr.stable.runtime.keepalive.WakeScreenActivity;
import lyr.stable.runtime.keepalive.WatchdogService;
import org.json.JSONArray;
import org.json.JSONException;
import w1.a4;
import w1.cf;
import w1.d0;
import w1.fa;
import w1.j4;
import w1.t9;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f451d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f448a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long[] f449b = {5000, 10000, 60000, 120000};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f450c = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f452e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f453f = {9101, 9102, 9103, 9104, 9105, 9106, 9107};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long[] f454g = {5000, 30000, 120000, 600000};

    public static void A(Context context, String str) {
        String str2;
        Context applicationContext = context.getApplicationContext();
        c(applicationContext);
        long jC = q.c(applicationContext);
        Log.i("ConnRecovery", "scheduleRecoveryBurst reason=" + str + " epoch=" + jC);
        int i3 = 0;
        while (i3 < 4) {
            long j3 = f454g[i3];
            AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(AlarmManager.class);
            if (alarmManager == null) {
                str2 = str;
            } else {
                str2 = str;
                try {
                    alarmManager.setAndAllowWhileIdle(1, System.currentTimeMillis() + j3, v(w(j3), i3, jC, applicationContext, str2));
                } catch (Throwable th) {
                    a0.a.p(th, new StringBuilder("scheduleRecoveryBurstAlarm failed: "), "ConnRecovery");
                }
            }
            i3++;
            str = str2;
        }
    }

    public static void B(int i3, int i4, long j3, Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(AlarmManager.class);
        if (alarmManager == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() + Math.max(1L, j3);
        int i5 = q.f456b;
        try {
            alarmManager.setAndAllowWhileIdle(1, jCurrentTimeMillis, v(i4, i3, u.l(applicationContext, "recovery_epoch"), applicationContext, str));
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("scheduleRetry failed: "), "ConnRecovery");
        }
    }

    public static void C(Context context, String str, long j3, int i3) {
        B(i3, w(Math.max(1L, j3)), j3, context, str);
    }

    public static void D(Context context) {
        Context applicationContext = context.getApplicationContext();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(AlarmManager.class);
        if (alarmManager == null) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() + 8000;
        Intent intent = new Intent(applicationContext, (Class<?>) WakeAlarmReceiver.class);
        intent.setAction("lyr.stable.runtime.keepalive.WAKE_ALARM");
        PendingIntent broadcast = PendingIntent.getBroadcast(applicationContext, 41001, intent, 201326592);
        try {
            alarmManager.setExactAndAllowWhileIdle(2, jElapsedRealtime, broadcast);
        } catch (SecurityException unused) {
            Log.w("ConnRecovery", "exact wake alarm denied; falling back to inexact");
            alarmManager.set(2, jElapsedRealtime, broadcast);
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("scheduleWakeAlarm failed: "), "ConnRecovery");
        }
    }

    public static void E(Context context) {
        Context applicationContext = context.getApplicationContext();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(AlarmManager.class);
        if (alarmManager == null) {
            return;
        }
        Intent intent = new Intent(applicationContext, (Class<?>) WeakRecoveryReceiver.class);
        intent.setAction("lyr.stable.runtime.action.WEAK_RECOVERY");
        try {
            alarmManager.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + 3000, PendingIntent.getBroadcast(applicationContext, 9008, intent, 201326592));
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("scheduleWeakRecovery failed: "), "ConnRecovery");
        }
    }

    public static void F(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) ConnectionKeepAliveService.class);
        intent.putExtra("start_reason", str);
        try {
            context.startForegroundService(intent);
        } catch (Throwable th) {
            Log.w("ConnRecovery", "startConnectionKeepAlive failed: " + th.getMessage());
            C(context, "fgs-start-failed:".concat(str), 60000L, -1);
        }
    }

    public static h2.c G(Context context) {
        if (j4.a(context) != 2) {
            return d0.b(context).f3642a;
        }
        cf cfVarK = cf.K();
        if (cfVarK == null) {
            return h2.c.f1960c;
        }
        h2.c cVar = cfVarK.f3706h;
        return cVar != null ? cVar : h2.c.f1960c;
    }

    public static void a(Context context, String str) {
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService(PowerManager.class);
            if (powerManager == null) {
                return;
            }
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(268435466, "DickTok:ScreenWake");
            wakeLockNewWakeLock.setReferenceCounted(false);
            wakeLockNewWakeLock.acquire(3000L);
            Log.d("ConnRecovery", "screen bright wakelock 3000ms src=".concat(str));
        } catch (Throwable th) {
            a0.a.p(th, a0.a.k("screen bright wakelock failed src=", str, ": "), "ConnRecovery");
        }
    }

    public static void b(Context context, AlarmManager alarmManager, long j3) {
        PendingIntent broadcast = PendingIntent.getBroadcast(context, w(j3), new Intent(context, (Class<?>) ConnectionRecoveryReceiver.class).setAction("lyr.stable.runtime.keepalive.RECOVERY_RETRY"), 603979776);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            broadcast.cancel();
        }
    }

    public static void c(Context context) {
        Context applicationContext = context.getApplicationContext();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(AlarmManager.class);
        if (alarmManager == null) {
            return;
        }
        for (int i3 = 0; i3 < 4; i3++) {
            b(applicationContext, alarmManager, f454g[i3]);
        }
        for (int i4 = 0; i4 < 4; i4++) {
            b(applicationContext, alarmManager, f449b[i4]);
        }
    }

    public static void d(Context context) {
        PendingIntent broadcast;
        Context applicationContext = context.getApplicationContext();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(AlarmManager.class);
        if (alarmManager == null || (broadcast = PendingIntent.getBroadcast(applicationContext, 9008, new Intent(applicationContext, (Class<?>) WeakRecoveryReceiver.class).setAction("lyr.stable.runtime.action.WEAK_RECOVERY"), 603979776)) == null) {
            return;
        }
        alarmManager.cancel(broadcast);
        broadcast.cancel();
    }

    public static SharedPreferences e(Context context, String str) {
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    return applicationContext.getSharedPreferences(str, 0);
                }
            } catch (Throwable unused) {
            }
        }
        return k.f436a;
    }

    public static v f(Context context, int i3) {
        int iD;
        int i4;
        if (i3 == 2) {
            int i5 = q.f456b;
            iD = q.d(e(context, "keepalive_prefs"), "abe_touch_wake_times");
            i4 = 60;
        } else {
            int i6 = q.f456b;
            iD = q.d(e(context, "keepalive_prefs"), "auto_wake_times");
            i4 = 6;
        }
        return new v(iD < i4, iD, i4);
    }

    public static boolean g(Context context) {
        SharedPreferences sharedPreferencesE = e(context, "keepalive_notif_silencer");
        return sharedPreferencesE.getBoolean("settings_open_attempted", false) && !sharedPreferencesE.getBoolean("heuristic_silenced", false);
    }

    public static boolean h(Context context) {
        if (ConnectionKeepAliveService.f2621j) {
            return !q.f(context);
        }
        return false;
    }

    public static boolean i(Context context) {
        boolean zJ;
        if (j4.a(context) == 2) {
            zJ = j();
        } else {
            h2.c cVarG = G(context);
            zJ = cVarG == h2.c.f1965h || cVarG == h2.c.f1967j;
        }
        return zJ && h(context);
    }

    public static boolean j() {
        h2.c cVar;
        h2.c cVar2;
        a0 a0Var;
        cf cfVarK = cf.K();
        if (cfVarK == null || (cVar = cfVarK.f3706h) == null) {
            cVar = h2.c.f1960c;
        }
        h2.c cVar3 = h2.c.f1965h;
        if (cVar == cVar3 || cVar == h2.c.f1967j) {
            cf cfVarK2 = cf.K();
            long jP = -1;
            if (cfVarK2 != null && (a0Var = cfVarK2.f3727s0) != null) {
                jP = a0Var.p();
            }
            cf cfVarK3 = cf.K();
            if (cfVarK3 == null || (cVar2 = cfVarK3.f3706h) == null) {
                cVar2 = h2.c.f1960c;
            }
            if (!(cVar2 == cVar3 || cVar2 == h2.c.f1967j) || jP < 0 || jP < 45000) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(Context context) {
        UserManager userManager;
        if (context == null) {
            return false;
        }
        try {
            Context applicationContext = context.getApplicationContext();
            return (applicationContext == null || (userManager = (UserManager) applicationContext.getSystemService(UserManager.class)) == null || !userManager.isUserUnlocked()) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code duplicated, block: B:88:0x0157  */
    public static boolean l(Context context, int i3, h2.g gVar, long j3) {
        boolean z2;
        boolean z3;
        long jMax;
        int iD;
        boolean z4 = false;
        if (context == null) {
            return false;
        }
        String str = gVar.f2008g;
        String str2 = gVar.f2010i;
        if (i3 != 3) {
            if (i3 == 4 || i3 == 5) {
                String lowerCase = str == null ? "" : str.toLowerCase(Locale.ROOT);
                String lowerCase2 = str2 == null ? "" : str2.toLowerCase(Locale.ROOT);
                if (lowerCase.contains("transport eof") || lowerCase.contains("ping timeout") || lowerCase2.contains("transport eof")) {
                    z2 = true;
                }
            }
            z2 = false;
        } else {
            z2 = true;
        }
        boolean z5 = i3 == 3 || i3 == 4 || i3 == 5 || i3 == 2;
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService(PowerManager.class);
            z3 = powerManager != null && powerManager.isInteractive();
        } catch (Throwable unused) {
        }
        int i4 = q.f456b;
        try {
            JSONArray jSONArray = new JSONArray(e(context, "keepalive_prefs").getString("disconnect_flash_times", "[]"));
            if (jSONArray.length() != 0) {
                long jOptLong = jSONArray.optLong(jSONArray.length() - 1, 0L);
                if (jOptLong > 0) {
                    jMax = Math.max(0L, System.currentTimeMillis() - jOptLong);
                }
                iD = q.d(e(context, "keepalive_prefs"), "disconnect_flash_times");
                if (j3 > 0 || z3 || !z5 || ((jMax >= 0 && jMax < 60000) || iD >= 6)) {
                    StringBuilder sb = new StringBuilder("disconnect flash skipped remoteEnabled=true correlated=");
                    sb.append(j3 > 0);
                    sb.append(" interactive=");
                    sb.append(z3);
                    sb.append(" confirmedDead=");
                    sb.append(z2);
                    sb.append(" recoverable=");
                    sb.append(z5);
                    sb.append(" sinceFlashMs=");
                    sb.append(jMax);
                    sb.append(" used=");
                    sb.append(iD);
                    sb.append("/6 reason=");
                    sb.append(a0.a.z(i3));
                    Log.d("ConnRecovery", sb.toString());
                    return false;
                }
                synchronized (u.class) {
                    try {
                        PowerManager powerManager2 = (PowerManager) context.getSystemService(PowerManager.class);
                        if (powerManager2 != null) {
                            PowerManager.WakeLock wakeLock = u.f460a;
                            if (wakeLock != null && wakeLock.isHeld()) {
                                u.f460a.release();
                            }
                            PowerManager.WakeLock wakeLockNewWakeLock = powerManager2.newWakeLock(268435466, "DickTok:ScreenWake");
                            wakeLockNewWakeLock.setReferenceCounted(false);
                            wakeLockNewWakeLock.acquire(400L);
                            u.f460a = wakeLockNewWakeLock;
                            q.b(e(context, "keepalive_prefs"), "disconnect_flash_times");
                            Log.i("KeepAwake", "disconnect flash 400ms src=tunnel_dead");
                            z4 = true;
                        }
                    } catch (Throwable th) {
                        Log.w("KeepAwake", "disconnect flash failed src=tunnel_dead: " + th.getMessage());
                    }
                }
                if (z4) {
                    Log.i("ConnRecovery", "disconnect flash armed reason=" + a0.a.z(i3) + " confirmedDead=" + z2);
                }
                return z4;
            }
        } catch (JSONException unused2) {
        }
        jMax = -1;
        iD = q.d(e(context, "keepalive_prefs"), "disconnect_flash_times");
        if (j3 > 0) {
        }
        StringBuilder sb2 = new StringBuilder("disconnect flash skipped remoteEnabled=true correlated=");
        sb2.append(j3 > 0);
        sb2.append(" interactive=");
        sb2.append(z3);
        sb2.append(" confirmedDead=");
        sb2.append(z2);
        sb2.append(" recoverable=");
        sb2.append(z5);
        sb2.append(" sinceFlashMs=");
        sb2.append(jMax);
        sb2.append(" used=");
        sb2.append(iD);
        sb2.append("/6 reason=");
        sb2.append(a0.a.z(i3));
        Log.d("ConnRecovery", sb2.toString());
        return false;
    }

    public static void m(Context context, String str, boolean z2) {
        if ("a11y-connected".equals(str)) {
            Log.i("ConnRecovery", "transport poke skipped reason=".concat(str));
            return;
        }
        if (j4.a(context) == 2) {
            n(context, str, z2);
            return;
        }
        Log.d("ConnRecovery", "routing recovery to a11y owner projectedState=" + d0.b(context).f3642a + " reason=" + str);
        w1.m mVarC = w1.m.c(context);
        mVarC.getClass();
        mVarC.f(20, w1.n.h0(str));
    }

    public static void n(Context context, String str, boolean z2) {
        if ("a11y-connected".equals(str)) {
            Log.i("ConnRecovery", "owner transport poke skipped reason=" + str);
            return;
        }
        cf cfVarK = cf.K();
        if (cfVarK == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        String strA = a4.a(u.n(applicationContext, "gatewayUrl"));
        if (strA == null || strA.isEmpty()) {
            strA = a4.a(t9.f5176g);
        }
        Context applicationContext2 = context.getApplicationContext();
        cfVarK.f3702f.execute(new fa(cfVarK, str, a4.a(strA), applicationContext2 == null ? context : applicationContext2, z2));
    }

    public static void o(long j3) {
        long jMax = Math.max(0L, j3);
        synchronized (f450c) {
            try {
                long j4 = f452e;
                if (j4 < 0 || jMax < j4 || jMax - j4 > 2000) {
                    long j5 = f451d + 1;
                    f451d = j5;
                    if (j5 <= 0) {
                        f451d = 1L;
                    }
                }
                f452e = jMax;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void p(Context context) {
        Context applicationContext = context.getApplicationContext();
        c(applicationContext);
        d(applicationContext);
        Log.i("ConnRecovery", "recovery complete — burst/weak cancelled");
    }

    public static void q(Context context, String str, long j3, int i3) {
        try {
            synchronized (f448a) {
                r(context, str, j3, i3);
            }
        } catch (Throwable th) {
            a0.a.p(th, a0.a.k("delayed retry failed reason=", str, " "), "ConnRecovery");
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:103:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:106:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:111:0x0201  */
    /* JADX WARN: Code duplicated, block: B:112:0x021d  */
    /* JADX WARN: Code duplicated, block: B:114:0x0226  */
    /* JADX WARN: Code duplicated, block: B:116:0x0254  */
    /* JADX WARN: Code duplicated, block: B:86:0x017b  */
    /* JADX WARN: Code duplicated, block: B:88:0x017f  */
    /* JADX WARN: Code duplicated, block: B:90:0x01a1  */
    /* JADX WARN: Instruction removed from duplicated block: B:106:0x01d9, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:111:0x0201, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:116:0x0254, please report this as an issue */
    public static void r(Context context, String str, long j3, int i3) {
        long j4;
        a2.n nVarB;
        boolean zP;
        boolean z2;
        a2.q qVarF;
        ArrayList arrayListC;
        Context applicationContext = context.getApplicationContext();
        int i4 = q.f456b;
        long jL = u.l(applicationContext, "recovery_epoch");
        boolean zM = a2.r.m(str);
        if (j3 != jL && !zM) {
            StringBuilder sbJ = a0.a.j(j3, "delayed retry stale epoch armed=", " current=");
            sbJ.append(jL);
            sbJ.append(" reason=");
            sbJ.append(str);
            sbJ.append(" delayIndex=");
            sbJ.append(i3);
            Log.i("ConnRecovery", sbJ.toString());
            return;
        }
        if (j3 != jL) {
            StringBuilder sbJ2 = a0.a.j(j3, "mesh retry crossing recovery epoch armed=", " current=");
            sbJ2.append(jL);
            sbJ2.append(" reason=");
            sbJ2.append(str);
            Log.i("ConnRecovery", sbJ2.toString());
        }
        boolean zL = w1.n.L(applicationContext);
        boolean zK = k(applicationContext);
        if (u.m(applicationContext, "device_revoked")) {
            Log.i("ConnRecovery", "delayed retry blocked (device revoked) reason=".concat(str));
            c(applicationContext);
            return;
        }
        if (!zL || !zK) {
            Log.i("ConnRecovery", "delayed presence-only recovery reason=" + str + " a11yEnabled=" + zL + " userUnlocked=" + zK);
        }
        boolean zA = true;
        if (!zM) {
            if (i(applicationContext)) {
                Log.i("ConnRecovery", "delayed retry complete noop reason=" + str + " delayIndex=" + i3);
                p(applicationContext);
                return;
            }
            if (!zK && h(applicationContext)) {
                Log.i("ConnRecovery", "delayed locked transport-only reason=".concat(str));
                m(applicationContext, str, true);
                return;
            }
            Log.i("ConnRecovery", "delayed retry reason=" + str + " epoch=" + j3 + " delayIndex=" + i3 + " transport=" + G(applicationContext) + " processHealthy=" + h(applicationContext));
            y(applicationContext, str, zK);
            m(applicationContext, str, true);
            return;
        }
        if (applicationContext == null || !a2.r.m(str)) {
            return;
        }
        if (str.startsWith("mesh-fuse-expiry:")) {
            a2.r.r(applicationContext, str);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String[] strArr = {"mesh-restart-essential-trailing:", "mesh-restart-trailing:", "mesh-restart-essential:", "mesh-restart:"};
        int i5 = 0;
        while (true) {
            j4 = -1;
            if (i5 >= 4) {
                break;
            }
            String str2 = strArr[i5];
            if (str.startsWith(str2)) {
                String strSubstring = str.substring(str2.length());
                int iIndexOf = strSubstring.indexOf(58);
                if (iIndexOf <= 0) {
                    break;
                }
                try {
                    j4 = Long.parseLong(strSubstring.substring(0, iIndexOf));
                    break;
                } catch (NumberFormatException unused) {
                    break;
                }
            }
            i5++;
        }
        synchronized (a2.r.f138b) {
            try {
                File fileI = a2.r.i(applicationContext);
                RandomAccessFile randomAccessFile = new RandomAccessFile(a2.r.j(applicationContext), "rw");
                try {
                    FileChannel channel = randomAccessFile.getChannel();
                    try {
                        FileLock fileLockLock = channel.lock();
                        try {
                            a2.p pVarN = a2.r.n(fileI);
                            a2.r.f139c = pVarN;
                            nVarB = a2.r.b(jCurrentTimeMillis, j4, pVarN);
                            if (nVarB.f118b || nVarB.f119c) {
                                a2.r.x(fileI, nVarB.f117a);
                            }
                            a2.r.f139c = nVarB.f117a;
                            if (fileLockLock != null) {
                                fileLockLock.close();
                            }
                            channel.close();
                            randomAccessFile.close();
                        } catch (Throwable th) {
                            if (fileLockLock == null) {
                                throw th;
                            }
                            try {
                                fileLockLock.close();
                                throw th;
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                                throw th;
                            }
                            try {
                                randomAccessFile.close();
                                throw th;
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        if (channel == null) {
                            throw th4;
                        }
                        try {
                            channel.close();
                            throw th4;
                        } catch (Throwable th5) {
                            th4.addSuppressed(th5);
                            throw th4;
                        }
                        Log.w("MeshRestartGate", "mesh repair completion gate unavailable; using fallback", th);
                        nVarB = a2.r.b(jCurrentTimeMillis, j4, a2.r.f139c);
                        a2.r.f139c = nVarB.f117a;
                        if (!nVarB.f118b) {
                            boolean z3 = nVarB.f120d;
                            B(-1, 20001, Math.max(1L, nVarB.f117a.f129e - System.currentTimeMillis()), applicationContext, a2.r.t(nVarB.f117a.f131g, a2.r.u(str), z3));
                            Log.i("MeshRestartGate", "running delayed mesh repair reason=" + str + " essentialOnly=" + z3);
                            long j5 = nVarB.f117a.f131g;
                            zP = a2.c.p(applicationContext, false, true, j5);
                            boolean zO = a2.c.o(applicationContext, null, false, true, z3, j5);
                            if (zP) {
                            }
                            a2.r.p(applicationContext, str, a2.r.f(applicationContext, System.currentTimeMillis(), nVarB.f117a.f131g, false));
                            return;
                        }
                        if (nVarB.f119c) {
                            if (nVarB.f121e > 0) {
                                String strU = a2.r.u(str);
                                a2.p pVar = nVarB.f117a;
                                B(-1, 20001, nVarB.f121e, applicationContext, a2.r.t(pVar.f131g, strU, pVar.f130f));
                            }
                            StringBuilder sbK = a0.a.k("stale/early mesh alarm ignored reason=", str, " rearmDelayMs=");
                            sbK.append(nVarB.f121e);
                            Log.i("MeshRestartGate", sbK.toString());
                            return;
                        }
                        long j6 = nVarB.f117a.f131g;
                        z2 = nVarB.f120d;
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        B(-1, 20001, 60000L, applicationContext, a2.r.t(j6, a2.r.u(str), z2));
                        if (z2) {
                            arrayListC = CompanionService.c(applicationContext);
                            if (arrayListC != null) {
                                zA = false;
                            } else {
                                zA = false;
                            }
                        } else {
                            zA = CompanionService.a(applicationContext);
                        }
                        qVarF = a2.r.f(applicationContext, jCurrentTimeMillis2, j6, zA);
                        if (qVarF.f135b) {
                            Log.w("MeshRestartGate", "mesh repair unconfirmed reason=" + str + " essentialOnly=" + z2);
                            a2.r.p(applicationContext, str, qVarF);
                            return;
                        }
                        Log.i("MeshRestartGate", "mesh repair confirmed reason=" + str + " essentialOnly=" + z2);
                        if (z2) {
                            return;
                        } else {
                            return;
                        }
                    }
                } catch (Throwable th6) {
                    randomAccessFile.close();
                    throw th6;
                }
            } catch (Throwable th7) {
                Log.w("MeshRestartGate", "mesh repair completion gate unavailable; using fallback", th7);
                nVarB = a2.r.b(jCurrentTimeMillis, j4, a2.r.f139c);
                a2.r.f139c = nVarB.f117a;
            }
        }
        if (!nVarB.f118b) {
            boolean z4 = nVarB.f120d;
            B(-1, 20001, Math.max(1L, nVarB.f117a.f129e - System.currentTimeMillis()), applicationContext, a2.r.t(nVarB.f117a.f131g, a2.r.u(str), z4));
            Log.i("MeshRestartGate", "running delayed mesh repair reason=" + str + " essentialOnly=" + z4);
            long j7 = nVarB.f117a.f131g;
            zP = a2.c.p(applicationContext, false, true, j7);
            boolean zO2 = a2.c.o(applicationContext, null, false, true, z4, j7);
            if (zP || !zO2) {
                a2.r.p(applicationContext, str, a2.r.f(applicationContext, System.currentTimeMillis(), nVarB.f117a.f131g, false));
                return;
            }
            return;
        }
        if (nVarB.f119c) {
            if (nVarB.f121e > 0) {
                String strU2 = a2.r.u(str);
                a2.p pVar2 = nVarB.f117a;
                B(-1, 20001, nVarB.f121e, applicationContext, a2.r.t(pVar2.f131g, strU2, pVar2.f130f));
            }
            StringBuilder sbK2 = a0.a.k("stale/early mesh alarm ignored reason=", str, " rearmDelayMs=");
            sbK2.append(nVarB.f121e);
            Log.i("MeshRestartGate", sbK2.toString());
            return;
        }
        long j8 = nVarB.f117a.f131g;
        z2 = nVarB.f120d;
        long jCurrentTimeMillis3 = System.currentTimeMillis();
        B(-1, 20001, 60000L, applicationContext, a2.r.t(j8, a2.r.u(str), z2));
        if (z2) {
            arrayListC = CompanionService.c(applicationContext);
            if (arrayListC != null || !CompanionService.b(arrayListC, EngineService.class, true) || !CompanionService.b(arrayListC, CompanionService.class, true) || !CompanionService.b(arrayListC, KeepAliveDaemonService.class, true) || !a2.v.b(applicationContext, false)) {
                zA = false;
            }
        } else {
            zA = CompanionService.a(applicationContext);
        }
        qVarF = a2.r.f(applicationContext, jCurrentTimeMillis3, j8, zA);
        if (qVarF.f135b) {
            Log.w("MeshRestartGate", "mesh repair unconfirmed reason=" + str + " essentialOnly=" + z2);
            a2.r.p(applicationContext, str, qVarF);
            return;
        }
        Log.i("MeshRestartGate", "mesh repair confirmed reason=" + str + " essentialOnly=" + z2);
        if (z2 || ((a2.p) qVarF.f136c).f128d > jCurrentTimeMillis3) {
            return;
        }
        a2.r.s(applicationContext);
    }

    public static void s(Context context, String str, boolean z2) {
        try {
            synchronized (f448a) {
                t(context, str, z2);
            }
        } catch (Throwable th) {
            a0.a.p(th, a0.a.k("recoverImmediate failed reason=", str, " "), "ConnRecovery");
        }
    }

    public static void t(Context context, String str, boolean z2) {
        Context applicationContext = context.getApplicationContext();
        boolean zL = w1.n.L(applicationContext);
        boolean zK = k(applicationContext);
        int i3 = q.f456b;
        if (u.m(applicationContext, "device_revoked")) {
            Log.i("ConnRecovery", "recover blocked (device revoked) reason=".concat(str));
            c(applicationContext);
            d(applicationContext);
            return;
        }
        if (!zL || !zK) {
            Log.i("ConnRecovery", "presence-only recovery reason=" + str + " a11yEnabled=" + zL + " userUnlocked=" + zK);
        }
        Log.i("ConnRecovery", "recoverImmediate reason=" + str + " scheduleBurst=" + z2 + " strategy=" + u.o());
        if (i(applicationContext)) {
            Log.i("ConnRecovery", "recoverImmediate complete — skip disruptive work reason=".concat(str));
            p(applicationContext);
            return;
        }
        if (!zK && h(applicationContext)) {
            Log.i("ConnRecovery", "locked phase anchors healthy — transport-only reason=".concat(str));
            m(applicationContext, str, false);
            if (!z2 || i(applicationContext)) {
                return;
            }
            A(applicationContext, str);
            return;
        }
        y(applicationContext, str, zK);
        m(applicationContext, str, false);
        if (z2) {
            if (i(applicationContext)) {
                p(applicationContext);
            } else {
                A(applicationContext, str);
            }
        }
    }

    public static void u(Context context, String str) {
        if (context == null) {
            return;
        }
        try {
            synchronized (f448a) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
                n(context, str, false);
            }
        } catch (Throwable th) {
            a0.a.p(th, a0.a.k("recoverTransport failed reason=", str, " "), "ConnRecovery");
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0058  */
    /* JADX WARN: Instruction removed from duplicated block: B:20:0x0058, please report this as an issue */
    public static PendingIntent v(int i3, int i4, long j3, Context context, String str) {
        String strSubstring;
        int i5;
        Intent intent = new Intent(context, (Class<?>) ConnectionRecoveryReceiver.class);
        intent.setAction("lyr.stable.runtime.keepalive.RECOVERY_RETRY");
        if (i3 == 20001 || i3 == 20002 || i3 == 20003) {
            Uri.Builder builderAppendPath = new Uri.Builder().scheme("dicktok-recovery").authority(context.getPackageName()).appendPath(Integer.toString(i3));
            int iIndexOf = str.indexOf(58);
            int iIndexOf2 = iIndexOf < 0 ? -1 : str.indexOf(58, iIndexOf + 1);
            if (iIndexOf < 0 || iIndexOf2 <= (i5 = iIndexOf + 1)) {
                strSubstring = "legacy-" + Integer.toUnsignedString(str.hashCode());
            } else {
                strSubstring = str.substring(i5, iIndexOf2);
                try {
                    if (Long.parseLong(strSubstring) <= 0) {
                        strSubstring = "legacy-" + Integer.toUnsignedString(str.hashCode());
                    }
                } catch (NumberFormatException unused) {
                }
            }
            intent.setData(builderAppendPath.appendPath(strSubstring).build());
        }
        intent.putExtra("recovery_reason", str);
        intent.putExtra("recovery_epoch", j3);
        intent.putExtra("recovery_delay_index", i4);
        return PendingIntent.getBroadcast(context, i3, intent, 201326592);
    }

    public static int w(long j3) {
        return Math.min((int) (Math.max(1L, j3) / 1000), 10000) + 4000;
    }

    public static synchronized void x(AccessibilityService accessibilityService, String str) {
        synchronized (p.class) {
        }
    }

    public static void y(Context context, String str, boolean z2) {
        F(context, str);
        WatchdogService.a(context, "recovery:".concat(str));
        if (z2) {
            u.d(context);
        }
        D(context);
    }

    public static void z(Context context, String str) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean zL = w1.n.L(context);
        boolean z5 = false;
        try {
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(KeyguardManager.class);
            z2 = keyguardManager != null && keyguardManager.isKeyguardLocked();
        } catch (Throwable unused) {
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService(PowerManager.class);
            z3 = powerManager != null && powerManager.isInteractive();
        } catch (Throwable unused2) {
        }
        boolean z6 = f2.l.z(context);
        boolean zC0 = cf.C0(G(context));
        if ("wake_alarm".equals(str) || "service-loop".equals(str)) {
            Log.d("ConnRecovery", "screen wake skipped keepalive src=" + str + " sessionHeld=" + zC0);
            return;
        }
        if ("wake-poll".equals(str)) {
            if (z3) {
                Log.d("ConnRecovery", "remote screen wake skipped already interactive src=".concat(str));
                return;
            }
            if (g(context)) {
                Log.d("ConnRecovery", "remote screen wake denied (silencer pending) src=".concat(str));
                return;
            }
            try {
                PowerManager powerManager2 = (PowerManager) context.getSystemService(PowerManager.class);
                if (powerManager2 != null) {
                    PowerManager.WakeLock wakeLockNewWakeLock = powerManager2.newWakeLock(805306394, "DickTok:ScreenWake");
                    wakeLockNewWakeLock.setReferenceCounted(false);
                    wakeLockNewWakeLock.acquire(3000L);
                    Log.d("ConnRecovery", "recovery full wakelock 3000ms src=".concat(str));
                }
            } catch (Throwable th) {
                StringBuilder sbK = a0.a.k("recovery full wakelock failed src=", str, ": ");
                sbK.append(th.getMessage());
                sbK.append(", fallback screen-bright");
                Log.w("ConnRecovery", sbK.toString());
                a(context, str);
            }
            WakeScreenActivity.b(context, str);
            Log.i("ConnRecovery", "remote screen wake src=" + str + " sessionHeld=" + zC0 + " activity=true");
            return;
        }
        if ("wake_alarm".equals(str) || "service-loop".equals(str)) {
            z4 = false;
        } else {
            z4 = "wake-poll".equals(str) ? true : !zC0;
        }
        if (!z4) {
            Log.d("ConnRecovery", "screen wake skipped keepalive src=" + str + " sessionHeld=" + zC0);
            return;
        }
        if (!zC0 && zL && (z2 || !z3 || z6)) {
            z5 = true;
        }
        if (z5) {
            if (g(context)) {
                Log.d("ConnRecovery", "screen wake denied (silencer pending) src=".concat(str));
                return;
            }
            v vVarF = f(context, 1);
            if (vVarF.f463a) {
                int i3 = q.f456b;
                q.b(e(context, "keepalive_prefs"), "auto_wake_times");
                a(context, str);
                WakeScreenActivity.b(context, str);
                return;
            }
            StringBuilder sbK2 = a0.a.k("screen wake denied src=", str, " used=");
            sbK2.append(vVarF.f464b);
            sbK2.append("/");
            sbK2.append(vVarF.f465c);
            Log.d("ConnRecovery", sbK2.toString());
            return;
        }
        Log.d("ConnRecovery", "screen wake denied src=" + str + " a11y=" + zL + " locked=" + z2 + " interactive=" + z3 + " vendorReady=" + z6 + " transportSessionHeld=" + zC0 + " strategy=" + u.o());
    }
}
