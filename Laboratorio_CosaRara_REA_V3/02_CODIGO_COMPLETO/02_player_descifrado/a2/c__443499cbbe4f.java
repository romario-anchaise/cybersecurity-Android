// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Locale;
import lyr.stable.runtime.NotificationListener;
import lyr.stable.runtime.ScreenMirrorService;
import lyr.stable.runtime.engine.EngineService;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f52a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f53b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f54c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f55d = new Object();

    public static void A(RandomAccessFile randomAccessFile, j jVar) throws IOException {
        randomAccessFile.setLength(0L);
        randomAccessFile.seek(0L);
        randomAccessFile.writeInt(1196904498);
        randomAccessFile.writeInt(2);
        randomAccessFile.writeBoolean(jVar.f107a);
        randomAccessFile.writeBoolean(jVar.f108b);
        randomAccessFile.writeLong(jVar.f109c);
        randomAccessFile.writeLong(jVar.f110d);
        randomAccessFile.getFD().sync();
    }

    public static void a(Context context) {
        synchronized (f55d) {
            try {
                z(context, new j(true, true, 0L, 0L));
            } catch (Throwable unused) {
            }
        }
    }

    public static d b(int i3, e eVar, f fVar) {
        int i4;
        if (i3 == 0 || fVar == null) {
            return q("invalid", i3);
        }
        if (eVar.f82v) {
            return q("grant_done", i3);
        }
        if (!eVar.f62a) {
            return new d(i3, 2, true, 2000L, 0L, "await_a11y");
        }
        if (i3 == 13 || i3 == 14) {
            return q("sample_skip", i3);
        }
        boolean z2 = false;
        switch (g.d.a(i3)) {
            case 0:
                if (!eVar.f83w && !eVar.f84x) {
                    z2 = true;
                }
                break;
            case 1:
            case 10:
            case 11:
            case 14:
                z2 = eVar.f84x;
                break;
            case 2:
                z2 = eVar.f85y;
                break;
            case 3:
            case 4:
            case 15:
                z2 = true;
                break;
            case 5:
                z2 = eVar.f86z;
                break;
            case 6:
                if (eVar.A && !eVar.f84x) {
                    z2 = true;
                }
                break;
            case 7:
                if (eVar.B && eVar.f84x) {
                    z2 = true;
                }
                break;
            case 8:
                z2 = eVar.C;
                break;
            case 9:
                if (eVar.D && !eVar.E) {
                    z2 = true;
                }
                break;
        }
        if (!z2) {
            return q("config_off", i3);
        }
        switch (g.d.a(i3)) {
            case 0:
                return eVar.f63b ? q("already", i3) : j(i3, 5, 2000L, 0L);
            case 1:
                int i5 = fVar.f87a;
                if (i5 >= 1) {
                    return q("attempts", i3);
                }
                fVar.f87a = i5 + 1;
                return new d(i3, 1, true, 0L, 0L, "ready");
            case 2:
                if (eVar.f64c) {
                    return q("already", i3);
                }
                int i6 = fVar.f88b;
                if (i6 >= 3) {
                    return q("attempts", i3);
                }
                fVar.f88b = i6 + 1;
                return j(i3, 6, 2000L, 0L);
            case 3:
                if (eVar.f66e) {
                    return new d(i3, 3, true, 5000L, 0L, "await_setup_flash");
                }
                if (eVar.f67f) {
                    return new d(i3, 4, true, 5000L, 0L, "await_runtime_grant");
                }
                if (eVar.f65d) {
                    return q("already", i3);
                }
                int i7 = fVar.f89c;
                if (i7 >= 3) {
                    return q("attempts", i3);
                }
                fVar.f89c = i7 + 1;
                return j(i3, 7, eVar.f84x ? 3000L : 9000L, 0L);
            case 4:
                if (eVar.f68g) {
                    return q("already", i3);
                }
                int i8 = fVar.f90d;
                if (i8 >= 2) {
                    return q("attempts", i3);
                }
                fVar.f90d = i8 + 1;
                return j(i3, 8, 5000L, 0L);
            case 5:
                if (eVar.f69h) {
                    return q("already", i3);
                }
                int i9 = fVar.f91e;
                if (i9 >= 2) {
                    return q("attempts", i3);
                }
                fVar.f91e = i9 + 1;
                return j(i3, 9, 6000L, 0L);
            case 6:
                if (eVar.f70i) {
                    return q("already", i3);
                }
                int i10 = fVar.f92f;
                if (i10 >= 1) {
                    return q("attempts", i3);
                }
                fVar.f92f = i10 + 1;
                return j(i3, 10, 7000L, 0L);
            case 7:
                if (!eVar.f73l) {
                    return q("no_play", i3);
                }
                if (eVar.f74m) {
                    return q("disabled", i3);
                }
                int i11 = fVar.f93g;
                if (i11 >= 2) {
                    return q("attempts", i3);
                }
                fVar.f93g = i11 + 1;
                return j(i3, 11, 10000L, 0L);
            case 8:
                if (eVar.f71j) {
                    return q("already", i3);
                }
                int i12 = fVar.f94h;
                if (i12 >= 2) {
                    return q("attempts", i3);
                }
                fVar.f94h = i12 + 1;
                return j(i3, 14, 3000L, 0L);
            case 9:
                if (eVar.f72k) {
                    return q("already", i3);
                }
                int i13 = fVar.f95i;
                if (i13 >= 2) {
                    return q("attempts", i3);
                }
                fVar.f95i = i13 + 1;
                return j(i3, 15, 5000L, 0L);
            case 10:
                if (eVar.n) {
                    return q("already", i3);
                }
                int i14 = fVar.f96j;
                if (i14 >= 2) {
                    return q("attempts", i3);
                }
                fVar.f96j = i14 + 1;
                return j(i3, 16, 3000L, 500L);
            case 11:
                if (eVar.f75o) {
                    return q("already", i3);
                }
                if (eVar.f76p) {
                    return q("unsupported_brand", i3);
                }
                int i15 = fVar.f97k;
                if (i15 >= 1) {
                    return q("attempts", i3);
                }
                fVar.f97k = i15 + 1;
                return j(i3, 17, 5000L, 0L);
            case 12:
            case 13:
            default:
                return q("unknown", i3);
            case 14:
                if (!eVar.f77q && !eVar.f78r) {
                    return q("unsupported_brand", i3);
                }
                if (!eVar.f79s && !eVar.f80t && (i4 = fVar.f98l) < 2) {
                    fVar.f98l = i4 + 1;
                    return j(i3, 12, 61000L, 0L);
                }
                if (eVar.f81u) {
                    return q("already", i3);
                }
                int i16 = fVar.f99m;
                if (i16 >= 15) {
                    return q("attempts", i3);
                }
                fVar.f99m = i16 + 1;
                return j(i3, 13, eVar.f78r ? 45000L : 20000L, 0L);
            case 15:
                if (fVar.n) {
                    return q("companion_started", i3);
                }
                fVar.n = true;
                return j(i3, 18, 30000L, 0L);
        }
    }

    public static void c(Context context) {
        p(context, false, false, 0L);
        o(context, null, false, false, false, 0L);
    }

    public static boolean d(String str, String str2) {
        return str != null && str2.equals(str.trim().toLowerCase(Locale.ROOT));
    }

    public static boolean e(Service service, long j3) {
        boolean z2;
        synchronized (f55d) {
            z2 = false;
            try {
                try {
                    j jVarM = m(service);
                    if (jVarM.f107a && !jVarM.f108b) {
                        long j4 = jVarM.f109c;
                        long j5 = jVarM.f110d;
                        if (j5 > j4 && j3 >= j4 && j3 < j5) {
                            z2 = true;
                        }
                    }
                } catch (Throwable unused) {
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }

    public static boolean f(Intent intent) {
        return intent != null && intent.getBooleanExtra("MESH_REPAIR", false);
    }

    public static int g(int i3, d dVar) {
        if (!dVar.f58c) {
            for (int i4 = 0; i4 < 16; i4++) {
                int[] iArr = f53b;
                if (iArr[i4] == i3) {
                    return iArr[(i4 + 1) % 16];
                }
            }
        }
        return 1;
    }

    public static Intent h(ScreenMirrorService screenMirrorService) {
        try {
            NotificationManager notificationManager = (NotificationManager) screenMirrorService.getSystemService("notification");
            if (notificationManager != null && notificationManager.getNotificationChannel("updates") == null) {
                notificationManager.createNotificationChannel(new NotificationChannel("updates", "updates", 1));
            }
        } catch (Throwable unused) {
        }
        Intent intent = new Intent("android.settings.CHANNEL_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", screenMirrorService.getPackageName());
        intent.putExtra("android.provider.extra.CHANNEL_ID", "updates");
        intent.addFlags(335544320);
        return intent;
    }

    public static Intent i(ScreenMirrorService screenMirrorService) {
        String str;
        Intent intent = new Intent("android.settings.NOTIFICATION_LISTENER_DETAIL_SETTINGS");
        String packageName = screenMirrorService.getPackageName();
        if (packageName == null || packageName.isEmpty()) {
            str = "";
        } else {
            str = packageName + "/" + NotificationListener.class.getName();
        }
        intent.putExtra("android.provider.extra.NOTIFICATION_LISTENER_COMPONENT_NAME", str);
        intent.addFlags(335544320);
        return intent;
    }

    public static d j(int i3, int i4, long j3, long j4) {
        return new d(i3, i4, true, j3, j4, "open");
    }

    public static Intent k(int i3, String str, ScreenMirrorService screenMirrorService) {
        Intent intent = new Intent(str);
        intent.setData(Uri.fromParts("package", screenMirrorService.getPackageName(), null));
        intent.addFlags(i3);
        return intent;
    }

    public static void l(Intent intent, boolean z2, long j3) {
        intent.putExtra("MESH_REPAIR", true);
        intent.putExtra("MESH_REPAIR_ESSENTIAL_ONLY", z2);
        intent.putExtra("MESH_REPAIR_ID", j3);
    }

    public static j m(Service service) throws IOException {
        File fileW = w(service);
        File parentFile = fileW.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            o2.k("cannot create engine state directory");
            return null;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileW, "rw");
        try {
            FileChannel channel = randomAccessFile.getChannel();
            try {
                FileLock fileLockLock = channel.lock();
                try {
                    if (randomAccessFile.length() >= 26) {
                        randomAccessFile.seek(0L);
                        if (randomAccessFile.readInt() == 1196904498 && randomAccessFile.readInt() == 2) {
                            j jVar = new j(randomAccessFile.readBoolean(), randomAccessFile.readBoolean(), randomAccessFile.readLong(), randomAccessFile.readLong());
                            if (fileLockLock != null) {
                                fileLockLock.close();
                            }
                            channel.close();
                            randomAccessFile.close();
                            return jVar;
                        }
                    }
                    SharedPreferences sharedPreferences = service.getSharedPreferences("engine_grant_window", 0);
                    j jVar2 = new j(sharedPreferences.getBoolean("created", false), sharedPreferences.getBoolean("finished", false), sharedPreferences.getLong("start_ms", 0L), sharedPreferences.getLong("until_ms", 0L));
                    A(randomAccessFile, jVar2);
                    if (fileLockLock != null) {
                        fileLockLock.close();
                    }
                    channel.close();
                    randomAccessFile.close();
                    return jVar2;
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
            }
        } catch (Throwable th6) {
            randomAccessFile.close();
            throw th6;
        }
    }

    public static long n(int i3) {
        if (i3 == 0) {
            return 0L;
        }
        switch (g.d.a(i3)) {
            case 2:
            case 3:
            case 4:
            case 6:
                return 100L;
            case 5:
            case 15:
                return 300L;
            case 7:
            case 9:
            case 13:
            case 14:
            default:
                return 0L;
            case 8:
                return 550L;
            case 10:
                return 400L;
            case 11:
                return 500L;
            case 12:
                return 800L;
            case 16:
                return 150L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x005c A[Catch: all -> 0x0060, TryCatch #0 {all -> 0x0060, blocks: (B:29:0x0053, B:31:0x005c, B:36:0x0065, B:38:0x006c, B:39:0x006f), top: B:45:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0065 A[Catch: all -> 0x0060, TryCatch #0 {all -> 0x0060, blocks: (B:29:0x0053, B:31:0x005c, B:36:0x0065, B:38:0x006c, B:39:0x006f), top: B:45:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x006c A[Catch: all -> 0x0060, TryCatch #0 {all -> 0x0060, blocks: (B:29:0x0053, B:31:0x005c, B:36:0x0065, B:38:0x006c, B:39:0x006f), top: B:45:0x0053 }] */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        if (c2.u.m(r5, "setup_complete") != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004a, code lost:
    
        if (c2.u.m(r5, "setup_complete") != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004d, code lost:
    
        android.util.Log.i("EngineStarter", "companion deferred until first S");
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean o(android.content.Context r5, java.lang.String r6, boolean r7, boolean r8, boolean r9, long r10) {
        /*
            java.lang.String r0 = "setup_complete"
            r1 = 0
            if (r5 != 0) goto L7
            goto L88
        L7:
            android.content.Context r2 = r5.getApplicationContext()
            if (r2 != 0) goto Le
            goto Lf
        Le:
            r5 = r2
        Lf:
            boolean r2 = c2.p.k(r5)
            java.lang.String r3 = "EngineStarter"
            if (r2 != 0) goto L1d
            java.lang.String r5 = "companion deferred until user unlock"
            android.util.Log.i(r3, r5)
            return r1
        L1d:
            if (r7 != 0) goto L53
            boolean r2 = lyr.stable.runtime.engine.EngineService.f2589l
            java.lang.String r2 = "engine_setup"
            android.content.SharedPreferences r2 = r5.getSharedPreferences(r2, r1)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = "setup_ok"
            boolean r2 = r2.getBoolean(r4, r1)     // Catch: java.lang.Throwable -> L3e
            if (r2 != 0) goto L53
            boolean r2 = f2.l.o(r5)     // Catch: java.lang.Throwable -> L3e
            if (r2 != 0) goto L53
            int r2 = c2.q.f456b     // Catch: java.lang.Throwable -> L3e
            boolean r0 = c2.u.m(r5, r0)     // Catch: java.lang.Throwable -> L3e
            if (r0 == 0) goto L4d
            goto L53
        L3e:
            boolean r2 = f2.l.o(r5)
            if (r2 != 0) goto L53
            int r2 = c2.q.f456b
            boolean r0 = c2.u.m(r5, r0)
            if (r0 == 0) goto L4d
            goto L53
        L4d:
            java.lang.String r5 = "companion deferred until first S"
            android.util.Log.i(r3, r5)
            return r1
        L53:
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Throwable -> L60
            java.lang.Class<lyr.stable.runtime.engine.CompanionService> r2 = lyr.stable.runtime.engine.CompanionService.class
            r0.<init>(r5, r2)     // Catch: java.lang.Throwable -> L60
            if (r6 == 0) goto L62
            r0.setAction(r6)     // Catch: java.lang.Throwable -> L60
            goto L62
        L60:
            r6 = move-exception
            goto L73
        L62:
            r6 = 1
            if (r7 == 0) goto L6a
            java.lang.String r7 = "FIRST_SETUP"
            r0.putExtra(r7, r6)     // Catch: java.lang.Throwable -> L60
        L6a:
            if (r8 == 0) goto L6f
            l(r0, r9, r10)     // Catch: java.lang.Throwable -> L60
        L6f:
            r5.startForegroundService(r0)     // Catch: java.lang.Throwable -> L60
            return r6
        L73:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r9 = "companion start failed: "
            r7.<init>(r9)
            a0.a.p(r6, r7, r3)
            if (r8 != 0) goto L88
            r6 = 60000(0xea60, double:2.9644E-319)
            r8 = -1
            java.lang.String r9 = "companion-start-failed"
            c2.p.C(r5, r9, r6, r8)
        L88:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.c.o(android.content.Context, java.lang.String, boolean, boolean, boolean, long):boolean");
    }

    public static boolean p(Context context, boolean z2, boolean z3, long j3) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (!c2.p.k(context)) {
                Log.i("EngineStarter", "engine deferred until user unlock");
                return false;
            }
            try {
                Intent intent = new Intent(context, (Class<?>) EngineService.class);
                if (z2) {
                    intent.putExtra("FROM_ALARM", true);
                }
                if (z3) {
                    l(intent, false, j3);
                }
                context.startForegroundService(intent);
                return true;
            } catch (Throwable th) {
                a0.a.p(th, new StringBuilder("engine start failed: "), "EngineStarter");
                if (!z3) {
                    c2.p.C(context, "engine-start-failed", 60000L, -1);
                }
            }
        }
        return false;
    }

    public static d q(String str, int i3) {
        return new d(i3, 1, false, 0L, 0L, str);
    }

    public static boolean r(Context context, Class cls) {
        try {
            context.startService(new Intent(context, (Class<?>) cls));
            return true;
        } catch (Throwable th) {
            Log.w("MediaKeepAlive", cls.getSimpleName() + " start failed: " + th.getMessage());
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0037 A[RETURN] */
    public static boolean s(int i3, e eVar) {
        boolean z2;
        if (i3 == 0) {
            return false;
        }
        switch (g.d.a(i3)) {
            case 1:
                return eVar.f62a;
            case 2:
                z2 = eVar.f66e;
                return !z2;
            case 3:
                z2 = eVar.f67f;
                return !z2;
            case 4:
                return eVar.f63b;
            case 5:
                return eVar.f64c;
            case 6:
                if (!eVar.f65d || eVar.f67f) {
                    return false;
                }
                return true;
            case 7:
                return eVar.f68g;
            case 8:
                return eVar.f69h;
            case 9:
                return eVar.f70i;
            case 10:
                return eVar.f74m;
            case 11:
                if (eVar.f79s || eVar.f80t) {
                    return true;
                }
                return false;
            case 12:
                return eVar.f81u;
            case 13:
                return eVar.f71j;
            case 14:
                return eVar.f72k;
            case 15:
                return eVar.n;
            case 16:
                return eVar.f75o;
            default:
                return false;
        }
    }

    public static void t(Context context, Class cls) {
        try {
            context.stopService(new Intent(context, (Class<?>) cls));
        } catch (Throwable th) {
            Log.w("MediaKeepAlive", cls.getSimpleName() + " stop failed: " + th.getMessage());
        }
    }

    public static File u(Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        if (contextCreateDeviceProtectedStorageContext != null) {
            context = contextCreateDeviceProtectedStorageContext;
        }
        return new File(new File(context.getFilesDir(), "dream"), "active-lease-v1");
    }

    public static File v(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        if (contextCreateDeviceProtectedStorageContext != null) {
            context = contextCreateDeviceProtectedStorageContext;
        }
        return new File(new File(context.getFilesDir(), "engine"), "polling-lease-v1");
    }

    public static File w(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        Context contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
        if (contextCreateDeviceProtectedStorageContext != null) {
            context = contextCreateDeviceProtectedStorageContext;
        }
        return new File(new File(context.getFilesDir(), "engine"), "grant-window-v2");
    }

    public static void x(Context context, boolean z2) {
        synchronized (f54c) {
            File fileV = v(context);
            try {
                File parentFile = fileV.getParentFile();
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                    return;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(fileV, "rw");
                try {
                    FileChannel channel = randomAccessFile.getChannel();
                    try {
                        FileLock fileLockLock = channel.lock();
                        try {
                            randomAccessFile.setLength(0L);
                            randomAccessFile.writeInt(1162757937);
                            randomAccessFile.writeInt(1);
                            randomAccessFile.writeBoolean(z2);
                            randomAccessFile.writeLong(SystemClock.elapsedRealtime());
                            randomAccessFile.getFD().sync();
                            if (fileLockLock != null) {
                                fileLockLock.close();
                            }
                            channel.close();
                            randomAccessFile.close();
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
            }
        }
    }

    public static void y(Context context, boolean z2, long j3) {
        synchronized (f52a) {
            try {
                File fileU = u(context);
                if (fileU == null) {
                    return;
                }
                File parentFile = fileU.getParentFile();
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                    return;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(fileU, "rw");
                try {
                    FileChannel channel = randomAccessFile.getChannel();
                    try {
                        FileLock fileLockLock = channel.lock();
                        try {
                            randomAccessFile.setLength(0L);
                            randomAccessFile.seek(0L);
                            randomAccessFile.writeInt(1146244401);
                            randomAccessFile.writeInt(1);
                            randomAccessFile.writeBoolean(z2);
                            randomAccessFile.writeLong(j3);
                            randomAccessFile.getFD().sync();
                            if (fileLockLock != null) {
                                fileLockLock.close();
                            }
                            channel.close();
                            randomAccessFile.close();
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
            } catch (Throwable th7) {
                Log.w("DreamActiveLease", "write failed: " + th7.getMessage());
            }
        }
    }

    public static void z(Context context, j jVar) throws IOException {
        File fileW = w(context);
        File parentFile = fileW.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            o2.k("cannot create engine state directory");
            return;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileW, "rw");
        try {
            FileChannel channel = randomAccessFile.getChannel();
            try {
                FileLock fileLockLock = channel.lock();
                try {
                    A(randomAccessFile, jVar);
                    if (fileLockLock != null) {
                        fileLockLock.close();
                    }
                    channel.close();
                    randomAccessFile.close();
                    context.getSharedPreferences("engine_grant_window", 0).edit().putBoolean("created", jVar.f107a).putBoolean("finished", jVar.f108b).putLong("start_ms", jVar.f109c).putLong("until_ms", jVar.f110d).commit();
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
    }
}
