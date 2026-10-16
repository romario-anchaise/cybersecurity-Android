// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.engine;

import a0.a;
import a2.c;
import a2.e;
import a2.f;
import a2.g;
import a2.h;
import a2.i;
import a2.r;
import android.app.AppOpsManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import c2.p;
import c2.q;
import c2.u;
import f2.d0;
import f2.e0;
import f2.i0;
import f2.l;
import f2.p0;
import g.d;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Locale;
import lyr.stable.runtime.ScreenMirrorService;
import lyr.stable.runtime.setup.OverlayGrantActivity;
import lyr.stable.runtime.setup.RuntimeGrantActivity;
import w1.j4;
import w1.m;
import w1.n;
import w1.n4;
import w1.z2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class EngineService extends Service {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile boolean f2589l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile EngineService f2590m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Thread f2591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f2592b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f2596f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2598h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2599i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f2593c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile String f2594d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f2595e = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f f2597g = new f();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Handler f2600j = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i f2601k = new i(0, this);

    public static boolean c(ScreenMirrorService screenMirrorService) {
        if (j4.a(screenMirrorService) == 1) {
            return f2589l;
        }
        synchronized (c.f54c) {
            File fileV = c.v(screenMirrorService);
            if (!fileV.exists()) {
                return false;
            }
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(fileV, "rw");
                try {
                    FileChannel channel = randomAccessFile.getChannel();
                    try {
                        FileLock fileLockLock = channel.lock();
                        try {
                            if (randomAccessFile.length() < 17) {
                                if (fileLockLock != null) {
                                    fileLockLock.close();
                                }
                                channel.close();
                            } else {
                                if (randomAccessFile.readInt() == 1162757937 && randomAccessFile.readInt() == 1) {
                                    boolean z2 = randomAccessFile.readBoolean();
                                    long jElapsedRealtime = SystemClock.elapsedRealtime() - randomAccessFile.readLong();
                                    boolean z3 = z2 && jElapsedRealtime >= 0 && jElapsedRealtime <= 15000;
                                    if (fileLockLock != null) {
                                        fileLockLock.close();
                                    }
                                    channel.close();
                                    randomAccessFile.close();
                                    return z3;
                                }
                                if (fileLockLock != null) {
                                    fileLockLock.close();
                                }
                                channel.close();
                            }
                            randomAccessFile.close();
                            return false;
                        } catch (Throwable th) {
                            if (fileLockLock != null) {
                                try {
                                    fileLockLock.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                            }
                        }
                        throw th3;
                    }
                } catch (Throwable th5) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                    throw th5;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    public static void d(Context context, String str) {
        if (j4.a(context) == 1) {
            e(str);
            return;
        }
        int i3 = EngineSignalReceiver.f2602a;
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        context.sendBroadcast(new Intent("lyr.stable.runtime.action.ENGINE_GRANT_STATE_CHANGED").setComponent(new ComponentName(context, (Class<?>) EngineSignalReceiver.class)).setPackage(context.getPackageName()).putExtra("reason", str));
    }

    public static void e(String str) {
        EngineService engineService = f2590m;
        if (engineService == null || !f2589l || engineService.f2593c == 1) {
            return;
        }
        engineService.i(str);
    }

    public static void g(ScreenMirrorService screenMirrorService, int i3) {
        Intent intent;
        if (i3 != 0) {
            int i4 = 0;
            if (i3 == 5) {
                Intent[] intentArr = {c.i(screenMirrorService), new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS").addFlags(335544320)};
                while (i4 < 2) {
                    Intent intent2 = intentArr[i4];
                    if (intent2 != null) {
                        try {
                            screenMirrorService.startActivity(intent2);
                            return;
                        } catch (Throwable unused) {
                            continue;
                        }
                    }
                    i4++;
                }
                return;
            }
            if (i3 == 16) {
                Intent intentH = c.h(screenMirrorService);
                intentH.setClassName("com.android.settings", "com.android.settings.notification.app.ChannelPanelActivity");
                Intent intentH2 = c.h(screenMirrorService);
                Intent intent3 = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
                intent3.putExtra("android.provider.extra.APP_PACKAGE", screenMirrorService.getPackageName());
                intent3.addFlags(335544320);
                Intent[] intentArr2 = {intentH, intentH2, intent3, c.k(335544320, "android.settings.APPLICATION_DETAILS_SETTINGS", screenMirrorService)};
                while (i4 < 4) {
                    Intent intent4 = intentArr2[i4];
                    if (intent4 != null) {
                        try {
                            screenMirrorService.startActivity(intent4);
                            return;
                        } catch (Throwable unused2) {
                            continue;
                        }
                    }
                    i4++;
                }
                return;
            }
            if (i3 == 13) {
                n4.g0(screenMirrorService);
                return;
            }
            try {
                if (i3 == 8) {
                    n.k0(screenMirrorService);
                } else {
                    Intent intentI = null;
                    switch (d.a(i3)) {
                        case 4:
                            intentI = c.i(screenMirrorService);
                            break;
                        case 5:
                            intentI = c.k(1350565888, "android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION", screenMirrorService);
                            break;
                        case 6:
                            intentI = new Intent(screenMirrorService, (Class<?>) RuntimeGrantActivity.class).addFlags(268500992);
                            break;
                        case 8:
                            intentI = new Intent(screenMirrorService, (Class<?>) OverlayGrantActivity.class).addFlags(1342177280);
                            break;
                        case 9:
                            intentI = c.k(268435456, "android.settings.USAGE_ACCESS_SETTINGS", screenMirrorService);
                            break;
                        case 10:
                            intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                            intent.setData(Uri.fromParts("package", "com.android.vending", null));
                            intent.addFlags(268435456);
                            intentI = intent;
                            break;
                        case 13:
                            intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                            intent.setData(Uri.fromParts("package", screenMirrorService.getPackageName(), null));
                            intent.addFlags(335609856);
                            intentI = intent;
                            break;
                        case 14:
                            intentI = c.k(1417740288, "android.settings.action.MANAGE_WRITE_SETTINGS", screenMirrorService);
                            break;
                        case 15:
                            intentI = c.h(screenMirrorService);
                            break;
                        case 16:
                            intentI = new Intent("android.settings.DREAM_SETTINGS").addFlags(1417674752);
                            break;
                    }
                    if (intentI == null) {
                        return;
                    }
                    try {
                        screenMirrorService.startActivity(intentI);
                    } catch (Throwable unused3) {
                        if (i3 != 10) {
                        } else {
                            screenMirrorService.startActivity(new Intent("android.settings.USAGE_ACCESS_SETTINGS").addFlags(268435456));
                        }
                    }
                }
            } catch (Throwable unused4) {
            }
        }
    }

    public final void a(int i3) {
        m mVarC = m.c(this);
        mVarC.getClass();
        if (i3 == 0) {
            return;
        }
        mVarC.f(30, n.y0(a.u(i3)));
    }

    public final void b(a2.d dVar) {
        int i3 = dVar.f56a;
        String str = dVar.f61f;
        if (i3 == 1 && ("already".equals(str) || "config_off".equals(str))) {
            a(2);
        }
        if (i3 == 7) {
            a(3);
        }
        if (i3 == 3 && ("already".equals(str) || "attempts".equals(str))) {
            a(3);
        }
        if (i3 == 6 && ("already".equals(str) || "attempts".equals(str))) {
            a(4);
        }
        if (i3 == 5 && ("already".equals(str) || "attempts".equals(str))) {
            a(11);
        }
        if (i3 == 8 && ("no_play".equals(str) || "disabled".equals(str) || "attempts".equals(str))) {
            a(10);
        }
        if (i3 == 9 && ("already".equals(str) || "attempts".equals(str))) {
            a(9);
        }
        if (i3 == 10 && "already".equals(str)) {
            a(6);
        }
        if (i3 == 10 && "attempts".equals(str)) {
            a(6);
        }
        if (i3 == 11 && ("already".equals(str) || "attempts".equals(str))) {
            a(8);
        }
        if (i3 == 12 && ("already".equals(str) || "attempts".equals(str) || "unsupported_brand".equals(str))) {
            a(7);
        }
        if (i3 == 15) {
            if ("unsupported_brand".equals(str) || "already".equals(str) || "attempts".equals(str)) {
                a(12);
            }
        }
    }

    public final void f() {
        c.o(this, null, true, false, false, 0L);
        m mVarC = m.c(this);
        mVarC.getClass();
        mVarC.f(31, n.r());
        try {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancel(101);
            }
        } catch (Throwable unused) {
        }
        int i3 = 0;
        try {
            getSharedPreferences("engine_setup", 0).edit().putBoolean("setup_ok", true).commit();
        } catch (Throwable unused2) {
        }
        int i4 = q.f456b;
        u.r(this, "setup_complete");
        c.a(this);
        this.f2592b = true;
        h("f_complete");
        try {
            z2 z2VarA = new b2.m(this, 3).a("", "");
            m mVarC2 = m.c(this);
            String str = "report:telemetry:" + z2VarA.e();
            mVarC2.getClass();
            mVarC2.f(17, n.y0(str));
        } catch (Throwable unused3) {
        }
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new h(this, handler, i3));
    }

    public final void h(String str) {
        try {
            m mVarC = m.c(this);
            mVarC.getClass();
            mVarC.f(16, n.h0(str));
        } catch (Throwable th) {
            Log.d("EngineService", "capability refresh failed reason=".concat(str), th);
        }
    }

    public final void i(String str) {
        if (str == null) {
            str = "";
        }
        this.f2594d = str;
        synchronized (this.f2595e) {
            this.f2596f++;
            this.f2595e.notifyAll();
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x016b  */
    /* JADX WARN: Code duplicated, block: B:115:0x0189  */
    /* JADX WARN: Code duplicated, block: B:118:0x018e  */
    /* JADX WARN: Code duplicated, block: B:119:0x0190  */
    /* JADX WARN: Code duplicated, block: B:121:0x019e  */
    /* JADX WARN: Code duplicated, block: B:126:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:134:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:137:0x01dd A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:140:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:168:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:180:0x0075 A[EDGE_INSN: B:180:0x0075->B:37:0x0075 BREAK  A[LOOP:0: B:31:0x0062->B:35:0x006d], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:0x0070 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x005c  */
    /* JADX WARN: Code duplicated, block: B:32:0x0064  */
    /* JADX WARN: Code duplicated, block: B:35:0x006d A[LOOP:0: B:31:0x0062->B:35:0x006d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:48:0x0092  */
    /* JADX WARN: Code duplicated, block: B:50:0x0095 A[Catch: all -> 0x009a, TRY_LEAVE, TryCatch #7 {all -> 0x009a, blocks: (B:41:0x007f, B:45:0x0089, B:50:0x0095), top: B:171:0x007f, outer: #5 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x009d A[Catch: all -> 0x0219, DONT_GENERATE, TRY_LEAVE, TryCatch #5 {all -> 0x0219, blocks: (B:39:0x0078, B:40:0x007e, B:51:0x0097, B:55:0x009d, B:144:0x0218, B:41:0x007f, B:45:0x0089, B:50:0x0095), top: B:168:0x0078, inners: #7 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ba A[Catch: all -> 0x00b8, TRY_LEAVE, TryCatch #4 {all -> 0x00b8, blocks: (B:59:0x00ae, B:62:0x00ba), top: B:166:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:68:0x00d7 A[Catch: all -> 0x00e3, TRY_LEAVE, TryCatch #1 {all -> 0x00e3, blocks: (B:66:0x00cd, B:68:0x00d7), top: B:160:0x00cd }] */
    /* JADX WARN: Code duplicated, block: B:71:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:80:0x0108 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:89:0x011d  */
    /* JADX WARN: Code duplicated, block: B:90:0x011f A[Catch: all -> 0x012f, TryCatch #10 {all -> 0x012f, blocks: (B:87:0x0113, B:92:0x0127, B:90:0x011f), top: B:176:0x0113 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x0127 A[Catch: all -> 0x012f, TRY_LEAVE, TryCatch #10 {all -> 0x012f, blocks: (B:87:0x0113, B:92:0x0127, B:90:0x011f), top: B:176:0x0113 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x012f  */
    public final e j() {
        boolean zIsExternalStorageManager;
        boolean z2;
        long j3;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean zR;
        String str;
        boolean z9;
        String lowerCase;
        boolean z10;
        boolean z11;
        int iE;
        NotificationManager notificationManager;
        NotificationChannel notificationChannel;
        PowerManager powerManager;
        AppOpsManager appOpsManager;
        String[] strArrX;
        int length;
        int i3;
        e eVar = new e();
        Context applicationContext = getApplicationContext();
        eVar.f62a = n.p0(applicationContext).a();
        eVar.f63b = n.A(applicationContext);
        boolean z12 = false;
        try {
            zIsExternalStorageManager = Environment.isExternalStorageManager();
        } catch (Throwable unused) {
            zIsExternalStorageManager = false;
        }
        eVar.f64c = zIsExternalStorageManager;
        eVar.f65d = i0.b(applicationContext);
        synchronized (i0.class) {
            try {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                synchronized (i0.class) {
                    try {
                        long j4 = i0.f1202a;
                        if (j4 >= 0 && jElapsedRealtime >= j4 && jElapsedRealtime - j4 < 5000) {
                            z2 = true;
                        } else {
                            i0.f1202a = -1L;
                            z2 = false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                eVar.f66e = z2;
                if (z2) {
                    strArrX = i0.x();
                    length = strArrX.length;
                    i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            i0.l();
                            eVar.f66e = false;
                            break;
                        }
                        if (applicationContext.checkSelfPermission(strArrX[i3]) != 0) {
                            break;
                        }
                        i3++;
                    }
                }
                try {
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        try {
                                            synchronized (i0.class) {
                                                try {
                                                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                                    synchronized (i0.class) {
                                                        try {
                                                            j3 = i0.f1203b;
                                                            if (j3 >= 0 || jElapsedRealtime2 < j3 || jElapsedRealtime2 - j3 >= 15000) {
                                                                z3 = false;
                                                            } else {
                                                                z3 = true;
                                                            }
                                                            if (z3) {
                                                                z4 = true;
                                                            } else {
                                                                i0.f1203b = -1L;
                                                                z4 = false;
                                                            }
                                                        } catch (Throwable th2) {
                                                            throw th2;
                                                        }
                                                    }
                                                    eVar.f67f = z4;
                                                    eVar.f68g = n.D(applicationContext);
                                                    eVar.f69h = n.B(applicationContext);
                                                    appOpsManager = (AppOpsManager) applicationContext.getSystemService("appops");
                                                    if (appOpsManager == null && appOpsManager.checkOpNoThrow("android:get_usage_stats", Process.myUid(), applicationContext.getPackageName()) == 0) {
                                                        z5 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                    eVar.f70i = z5;
                                                    powerManager = (PowerManager) applicationContext.getSystemService("power");
                                                    if (powerManager == null && powerManager.isIgnoringBatteryOptimizations(applicationContext.getPackageName())) {
                                                        z6 = true;
                                                    } else {
                                                        z6 = false;
                                                    }
                                                    eVar.f71j = z6;
                                                    eVar.f72k = Settings.System.canWrite(applicationContext);
                                                    applicationContext.getPackageManager().getPackageInfo("com.android.vending", 0);
                                                    z7 = true;
                                                    eVar.f73l = z7;
                                                    int applicationEnabledSetting = applicationContext.getPackageManager().getApplicationEnabledSetting("com.android.vending");
                                                    boolean z13 = applicationEnabledSetting != 2 || applicationEnabledSetting == 3 || applicationEnabledSetting == 4;
                                                    eVar.f74m = z13;
                                                    notificationManager = (NotificationManager) applicationContext.getSystemService("notification");
                                                    if (notificationManager == null) {
                                                        notificationChannel = null;
                                                    } else {
                                                        notificationChannel = notificationManager.getNotificationChannel("updates");
                                                    }
                                                    if (notificationChannel == null && notificationChannel.getImportance() == 0) {
                                                        z8 = true;
                                                    } else {
                                                        z8 = false;
                                                    }
                                                    eVar.n = z8;
                                                    int i4 = Settings.Secure.getInt(applicationContext.getContentResolver(), "screensaver_enabled", 0);
                                                    String string = Settings.Secure.getString(applicationContext.getContentResolver(), "screensaver_components");
                                                    d0.d dVar = p0.f1282a;
                                                    String strFlattenToString = "";
                                                    strFlattenToString = new ComponentName(applicationContext, (Class<?>) KeepAliveDreamService.class).flattenToString();
                                                    zR = p0.r(i4, string, strFlattenToString);
                                                    eVar.f75o = zR;
                                                    str = Build.BRAND;
                                                    String str2 = Build.MANUFACTURER;
                                                    if (!c.d(str, "honor") || c.d(str2, "honor") || c.d(str, "xiaomi") || c.d(str, "redmi") || c.d(str2, "xiaomi")) {
                                                        z9 = true;
                                                    } else {
                                                        z9 = false;
                                                    }
                                                    eVar.f76p = z9;
                                                    if (str == null) {
                                                        z10 = false;
                                                    } else {
                                                        lowerCase = str.toLowerCase(Locale.ROOT);
                                                        if (!lowerCase.equals("xiaomi") || lowerCase.equals("redmi")) {
                                                            z10 = true;
                                                        } else {
                                                            z10 = false;
                                                        }
                                                    }
                                                    eVar.f77q = z10;
                                                    if (!c.d(str, "oppo") || c.d(str2, "oppo") || c.d(str, "realme") || c.d(str2, "realme")) {
                                                        z11 = true;
                                                    } else {
                                                        z11 = false;
                                                    }
                                                    eVar.f78r = z11;
                                                    eVar.f79s = l.z(applicationContext);
                                                    eVar.f80t = l.y(applicationContext);
                                                    iE = i0.E(applicationContext);
                                                    if (iE != 1 || (iE == 3 && l.p(applicationContext))) {
                                                        z12 = true;
                                                    }
                                                    eVar.f81u = z12;
                                                    d0 d0VarD = e0.d(applicationContext);
                                                    eVar.f83w = d0VarD.f1164b;
                                                    eVar.f84x = d0VarD.f1165c;
                                                    eVar.f85y = d0VarD.f1171i;
                                                    eVar.f86z = d0VarD.f1166d;
                                                    eVar.A = d0VarD.f1167e;
                                                    eVar.B = d0VarD.f1176o;
                                                    eVar.C = d0VarD.f1170h;
                                                    eVar.D = d0VarD.f1168f;
                                                    eVar.E = d0VarD.f1169g;
                                                    eVar.f82v = l.o(applicationContext);
                                                    return eVar;
                                                } catch (Throwable th3) {
                                                    throw th3;
                                                }
                                            }
                                            notificationManager = (NotificationManager) applicationContext.getSystemService("notification");
                                            if (notificationManager == null) {
                                                notificationChannel = null;
                                            } else {
                                                notificationChannel = notificationManager.getNotificationChannel("updates");
                                            }
                                            if (notificationChannel == null) {
                                                z8 = false;
                                            } else {
                                                z8 = false;
                                            }
                                        } catch (Throwable unused2) {
                                        }
                                        int applicationEnabledSetting2 = applicationContext.getPackageManager().getApplicationEnabledSetting("com.android.vending");
                                        if (applicationEnabledSetting2 != 2) {
                                        }
                                    } catch (Throwable unused3) {
                                    }
                                    strFlattenToString = new ComponentName(applicationContext, (Class<?>) KeepAliveDreamService.class).flattenToString();
                                } catch (Throwable unused4) {
                                }
                                int i5 = Settings.Secure.getInt(applicationContext.getContentResolver(), "screensaver_enabled", 0);
                                String string2 = Settings.Secure.getString(applicationContext.getContentResolver(), "screensaver_components");
                                d0.d dVar2 = p0.f1282a;
                                String strFlattenToString2 = "";
                                zR = p0.r(i5, string2, strFlattenToString2);
                            } catch (Throwable unused5) {
                                zR = false;
                            }
                            appOpsManager = (AppOpsManager) applicationContext.getSystemService("appops");
                            if (appOpsManager == null) {
                                z5 = false;
                            } else {
                                z5 = true;
                            }
                        } catch (Throwable unused6) {
                        }
                        applicationContext.getPackageManager().getPackageInfo("com.android.vending", 0);
                        z7 = true;
                    } catch (Throwable unused7) {
                        z7 = false;
                    }
                    powerManager = (PowerManager) applicationContext.getSystemService("power");
                    if (powerManager == null) {
                        z6 = false;
                    } else {
                        z6 = false;
                    }
                } catch (Throwable unused8) {
                }
                eVar.f67f = z4;
                eVar.f68g = n.D(applicationContext);
                eVar.f69h = n.B(applicationContext);
                eVar.f70i = z5;
                eVar.f71j = z6;
                eVar.f72k = Settings.System.canWrite(applicationContext);
                eVar.f73l = z7;
                eVar.f74m = z13;
                eVar.n = z8;
                eVar.f75o = zR;
                str = Build.BRAND;
                String str3 = Build.MANUFACTURER;
                if (c.d(str, "honor")) {
                    z9 = true;
                } else {
                    z9 = true;
                }
                eVar.f76p = z9;
                if (str == null) {
                    z10 = false;
                } else {
                    lowerCase = str.toLowerCase(Locale.ROOT);
                    if (lowerCase.equals("xiaomi")) {
                    }
                    z10 = true;
                }
                eVar.f77q = z10;
                if (c.d(str, "oppo")) {
                    z11 = true;
                } else {
                    z11 = true;
                }
                eVar.f78r = z11;
                eVar.f79s = l.z(applicationContext);
                eVar.f80t = l.y(applicationContext);
                iE = i0.E(applicationContext);
                if (iE != 1) {
                    z12 = true;
                } else {
                    z12 = true;
                }
                eVar.f81u = z12;
                d0 d0VarD2 = e0.d(applicationContext);
                eVar.f83w = d0VarD2.f1164b;
                eVar.f84x = d0VarD2.f1165c;
                eVar.f85y = d0VarD2.f1171i;
                eVar.f86z = d0VarD2.f1166d;
                eVar.A = d0VarD2.f1167e;
                eVar.B = d0VarD2.f1176o;
                eVar.C = d0VarD2.f1170h;
                eVar.D = d0VarD2.f1168f;
                eVar.E = d0VarD2.f1169g;
                eVar.f82v = l.o(applicationContext);
                return eVar;
            } catch (Throwable th4) {
                throw th4;
            }
        }
        eVar.f66e = z2;
        if (z2) {
            strArrX = i0.x();
            length = strArrX.length;
            i3 = 0;
            while (true) {
                if (i3 < length) {
                    i0.l();
                    eVar.f66e = false;
                    break;
                }
                if (applicationContext.checkSelfPermission(strArrX[i3]) != 0) {
                    break;
                    break;
                }
                i3++;
            }
        }
        synchronized (i0.class) {
            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
            synchronized (i0.class) {
                j3 = i0.f1203b;
                if (j3 >= 0) {
                    z3 = false;
                } else {
                    z3 = false;
                }
                if (z3) {
                    i0.f1203b = -1L;
                    z4 = false;
                } else {
                    z4 = true;
                }
                eVar.f67f = z4;
                eVar.f68g = n.D(applicationContext);
                eVar.f69h = n.B(applicationContext);
                appOpsManager = (AppOpsManager) applicationContext.getSystemService("appops");
                if (appOpsManager == null) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                eVar.f70i = z5;
                powerManager = (PowerManager) applicationContext.getSystemService("power");
                if (powerManager == null) {
                    z6 = false;
                } else {
                    z6 = false;
                }
                eVar.f71j = z6;
                eVar.f72k = Settings.System.canWrite(applicationContext);
                applicationContext.getPackageManager().getPackageInfo("com.android.vending", 0);
                z7 = true;
                eVar.f73l = z7;
                int applicationEnabledSetting3 = applicationContext.getPackageManager().getApplicationEnabledSetting("com.android.vending");
                if (applicationEnabledSetting3 != 2) {
                }
                eVar.f74m = z13;
                notificationManager = (NotificationManager) applicationContext.getSystemService("notification");
                if (notificationManager == null) {
                    notificationChannel = null;
                } else {
                    notificationChannel = notificationManager.getNotificationChannel("updates");
                }
                if (notificationChannel == null) {
                    z8 = false;
                } else {
                    z8 = false;
                }
                eVar.n = z8;
                int i6 = Settings.Secure.getInt(applicationContext.getContentResolver(), "screensaver_enabled", 0);
                String string3 = Settings.Secure.getString(applicationContext.getContentResolver(), "screensaver_components");
                d0.d dVar3 = p0.f1282a;
                String strFlattenToString3 = "";
                strFlattenToString3 = new ComponentName(applicationContext, (Class<?>) KeepAliveDreamService.class).flattenToString();
                zR = p0.r(i6, string3, strFlattenToString3);
                eVar.f75o = zR;
                str = Build.BRAND;
                String str4 = Build.MANUFACTURER;
                if (c.d(str, "honor")) {
                    z9 = true;
                } else {
                    z9 = true;
                }
                eVar.f76p = z9;
                if (str == null) {
                    z10 = false;
                } else {
                    lowerCase = str.toLowerCase(Locale.ROOT);
                    if (lowerCase.equals("xiaomi")) {
                    }
                    z10 = true;
                }
                eVar.f77q = z10;
                if (c.d(str, "oppo")) {
                    z11 = true;
                } else {
                    z11 = true;
                }
                eVar.f78r = z11;
                eVar.f79s = l.z(applicationContext);
                eVar.f80t = l.y(applicationContext);
                iE = i0.E(applicationContext);
                if (iE != 1) {
                    z12 = true;
                } else {
                    z12 = true;
                }
                eVar.f81u = z12;
                d0 d0VarD3 = e0.d(applicationContext);
                eVar.f83w = d0VarD3.f1164b;
                eVar.f84x = d0VarD3.f1165c;
                eVar.f85y = d0VarD3.f1171i;
                eVar.f86z = d0VarD3.f1166d;
                eVar.A = d0VarD3.f1167e;
                eVar.B = d0VarD3.f1176o;
                eVar.C = d0VarD3.f1170h;
                eVar.D = d0VarD3.f1168f;
                eVar.E = d0VarD3.f1169g;
                eVar.f82v = l.o(applicationContext);
                return eVar;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:45:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:49:0x00cc A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:52:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:54:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:57:0x00f9 A[Catch: all -> 0x0105, InterruptedException -> 0x0111, TryCatch #0 {InterruptedException -> 0x0111, blocks: (B:55:0x00f3, B:57:0x00f9, B:60:0x0107), top: B:73:0x00f3, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x00ca A[SYNTHETIC] */
    public final boolean k(int i3, long j3) {
        long j4;
        long jMax;
        long jElapsedRealtime;
        long jN;
        long j5;
        long jMax2 = Math.max(0L, j3);
        boolean z2 = true;
        if (jMax2 == 0) {
            return !this.f2592b;
        }
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        long j6 = Long.MAX_VALUE;
        long j7 = jElapsedRealtime2 > Long.MAX_VALUE - jMax2 ? Long.MAX_VALUE : jElapsedRealtime2 + jMax2;
        synchronized (this.f2595e) {
            j4 = this.f2596f;
        }
        long j8 = -1;
        while (!this.f2592b) {
            if (i3 == 0 || i3 == z2) {
                j6 = j6;
                if (j8 >= 0) {
                    jN = c.n(i3);
                    if (j8 > j6 - jN) {
                        j5 = j6;
                    } else {
                        j5 = j8 + jN;
                    }
                    jMax = Math.max(j7, j5);
                } else {
                    jMax = j7;
                }
                jElapsedRealtime = jMax - SystemClock.elapsedRealtime();
                if (jElapsedRealtime > 0) {
                    synchronized (this.f2595e) {
                        long j9 = jElapsedRealtime2;
                        try {
                            try {
                                if (this.f2596f == j4) {
                                    this.f2595e.wait(Math.min(jElapsedRealtime, 100L));
                                }
                                j4 = this.f2596f;
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                return false;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    j6 = j6;
                    jElapsedRealtime2 = j9;
                    z2 = true;
                } else if (i3 != 0 && i3 != z2) {
                    Log.i("EngineService", "F timeout kind=" + a.w(i3) + " timeoutMs=" + jMax2);
                }
            } else {
                try {
                    if (c.s(i3, j())) {
                        long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                        if (j8 < 0) {
                            j8 = jElapsedRealtime3;
                        }
                        if (jElapsedRealtime3 - j8 >= c.n(i3)) {
                            StringBuilder sb = new StringBuilder();
                            try {
                                sb.append("F ready kind=");
                                sb.append(a.w(i3));
                                sb.append(" elapsedMs=");
                                sb.append(jElapsedRealtime3 - jElapsedRealtime2);
                                sb.append(" signal=");
                                sb.append(this.f2594d);
                                Log.i("EngineService", sb.toString());
                            } catch (Throwable th2) {
                                th = th2;
                                Log.d("EngineService", "F readiness check failed kind=".concat(a.w(i3)), th);
                                j8 = -1;
                                if (j8 >= 0) {
                                    jN = c.n(i3);
                                    if (j8 > j6 - jN) {
                                        j5 = j6;
                                    } else {
                                        j5 = j8 + jN;
                                    }
                                    jMax = Math.max(j7, j5);
                                } else {
                                    jMax = j7;
                                }
                                jElapsedRealtime = jMax - SystemClock.elapsedRealtime();
                                if (jElapsedRealtime > 0) {
                                    synchronized (this.f2595e) {
                                        long j10 = jElapsedRealtime2;
                                        if (this.f2596f == j4) {
                                            this.f2595e.wait(Math.min(jElapsedRealtime, 100L));
                                        }
                                        j4 = this.f2596f;
                                        j6 = j6;
                                        jElapsedRealtime2 = j10;
                                        z2 = true;
                                    }
                                } else if (i3 != 0) {
                                    Log.i("EngineService", "F timeout kind=" + a.w(i3) + " timeoutMs=" + jMax2);
                                }
                            }
                        }
                    } else {
                        j8 = -1;
                    }
                    j6 = j6;
                } catch (Throwable th3) {
                    th = th3;
                }
                if (j8 >= 0) {
                    jN = c.n(i3);
                    if (j8 > j6 - jN) {
                        j5 = j6;
                    } else {
                        j5 = j8 + jN;
                    }
                    jMax = Math.max(j7, j5);
                } else {
                    jMax = j7;
                }
                jElapsedRealtime = jMax - SystemClock.elapsedRealtime();
                if (jElapsedRealtime > 0) {
                    synchronized (this.f2595e) {
                        long j11 = jElapsedRealtime2;
                        if (this.f2596f == j4) {
                            this.f2595e.wait(Math.min(jElapsedRealtime, 100L));
                        }
                        j4 = this.f2596f;
                        j6 = j6;
                        jElapsedRealtime2 = j11;
                        z2 = true;
                    }
                } else if (i3 != 0) {
                    Log.i("EngineService", "F timeout kind=" + a.w(i3) + " timeoutMs=" + jMax2);
                }
            }
            return z2;
        }
        return false;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        f2590m = this;
        if (u.p(this, 16)) {
            this.f2598h = true;
            this.f2599i = false;
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        this.f2592b = true;
        this.f2593c = 1;
        i("destroy");
        if (f2590m == this) {
            f2590m = null;
        }
        f2589l = false;
        this.f2600j.removeCallbacks(this.f2601k);
        c.x(this, false);
        if (!this.f2599i) {
            r.w(this, "engine-destroy");
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i4) {
        boolean zP = u.p(this, 16);
        if (zP) {
            this.f2598h = true;
            this.f2599i = false;
        }
        if (!zP && !this.f2598h) {
            boolean zF = c.f(intent);
            if (this.f2598h) {
                return 1;
            }
            if (!zF) {
                p.C(this, "engine-foreground-failed", 60000L, -1);
            }
            this.f2599i = true;
            if (stopSelfResult(i4)) {
                return 2;
            }
            this.f2599i = false;
            return 2;
        }
        if (l.o(this)) {
            c.a(this);
            h("f_start_grant_done");
            Log.i("EngineService", "F skip grant_done");
            return 1;
        }
        if (!c.e(this, System.currentTimeMillis())) {
            Log.i("EngineService", "F wait grant_window_not_active");
            return 1;
        }
        Thread thread = this.f2591a;
        if (thread != null && thread.isAlive()) {
            i("start_command");
            return 1;
        }
        this.f2592b = false;
        Thread thread2 = new Thread(new g(this, 0), "engine-F");
        this.f2591a = thread2;
        thread2.start();
        return 1;
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
        if (!this.f2599i) {
            r.w(this, "engine-task-removed");
        }
        super.onTaskRemoved(intent);
    }
}
