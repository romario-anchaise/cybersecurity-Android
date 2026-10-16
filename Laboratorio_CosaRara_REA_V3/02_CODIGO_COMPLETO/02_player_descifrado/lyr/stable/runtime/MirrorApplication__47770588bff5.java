// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime;

import a0.a;
import a2.c;
import a2.m;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.AtomicFile;
import android.util.Log;
import android.webkit.WebView;
import c2.p;
import c2.q;
import c2.u;
import e2.b1;
import f2.l;
import g0.j;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import w1.c9;
import w1.cf;
import w1.d0;
import w1.e9;
import w1.f;
import w1.ge;
import w1.i6;
import w1.j4;
import w1.m0;
import w1.n;
import w1.n4;
import w1.t9;
import w1.y0;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class MirrorApplication extends Application {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f2452a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f2453b = new AtomicBoolean();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f2454c = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f2455d = new AtomicInteger();

    public static void a(Context context) {
        if (j4.a(context) != 2) {
            return;
        }
        AtomicBoolean atomicBoolean = f2454c;
        if (atomicBoolean.compareAndSet(false, true)) {
            try {
                WebView.setDataDirectorySuffix("a11y");
                Log.i("MirrorApplication", "WebView data directory suffix=a11y");
            } catch (Throwable th) {
                atomicBoolean.set(false);
                Log.e("MirrorApplication", "WebView data directory isolation failed", th);
            }
        }
    }

    public static boolean b(Context context) {
        AtomicBoolean atomicBoolean = f2453b;
        int i3 = 0;
        if (!atomicBoolean.compareAndSet(false, true)) {
            return atomicBoolean.get();
        }
        try {
            Log.i("MirrorApplication", "RTC safety initialized " + b1.e(context).a());
        } catch (Throwable th) {
            Log.e("MirrorApplication", "RTC safety initialization failed", th);
        }
        try {
            AtomicBoolean atomicBoolean2 = e9.f3902a;
            Context applicationContext = context == null ? null : context.getApplicationContext();
            if (applicationContext != null) {
                e9.f3903b.execute(new m(applicationContext, 12));
            }
        } catch (Throwable th2) {
            a.p(th2, new StringBuilder("process exit collection failed: "), "MirrorApplication");
        }
        try {
            cf cfVarK = cf.K();
            cfVarK.f3702f.execute(new ge(cfVarK, i3));
        } catch (Throwable th3) {
            a.p(th3, new StringBuilder("tunnel unlock continuation failed: "), "MirrorApplication");
        }
        return true;
    }

    public static boolean c(Context context) {
        boolean zCommit;
        boolean zCommit2;
        boolean zCommit3;
        AtomicBoolean atomicBoolean = f2452a;
        if (!atomicBoolean.compareAndSet(false, true)) {
            return atomicBoolean.get();
        }
        synchronized (u.f461b) {
            try {
                SharedPreferences sharedPreferencesA = u.a(context, "keepalive_prefs");
                SharedPreferences sharedPreferencesA2 = u.a(context, "screen_mirror_tunnel");
                SharedPreferences sharedPreferencesC = u.c(context);
                if (sharedPreferencesA != null && sharedPreferencesA2 != null && u.q(sharedPreferencesC)) {
                    SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
                    SharedPreferences.Editor editorEdit2 = sharedPreferencesA2.edit();
                    SharedPreferences.Editor editorEdit3 = sharedPreferencesC.edit();
                    if (editorEdit != null && editorEdit2 != null && editorEdit3 != null) {
                        boolean zF = u.f(sharedPreferencesA, sharedPreferencesC, editorEdit, editorEdit3, "setup_complete") | u.g(sharedPreferencesA, sharedPreferencesC, editorEdit, editorEdit3, "last_heartbeat_time") | u.g(sharedPreferencesA, sharedPreferencesC, editorEdit, editorEdit3, "recovery_main_process_tick_at") | u.g(sharedPreferencesA, sharedPreferencesC, editorEdit, editorEdit3, "recovery_epoch") | u.f(sharedPreferencesA, sharedPreferencesC, editorEdit, editorEdit3, "device_revoked");
                        boolean zH = u.h(sharedPreferencesA2, sharedPreferencesC, editorEdit2, editorEdit3, "gatewayUrl") | u.h(sharedPreferencesA2, sharedPreferencesC, editorEdit2, editorEdit3, "deviceId");
                        if (zF || zH) {
                            try {
                                zCommit = editorEdit3.commit();
                            } catch (Throwable unused) {
                                zCommit = false;
                            }
                        } else {
                            zCommit = true;
                        }
                        if (zF) {
                            try {
                                zCommit2 = editorEdit.commit();
                            } catch (Throwable unused2) {
                                zCommit2 = false;
                            }
                            zCommit &= zCommit2;
                        }
                        if (zH) {
                            try {
                                zCommit3 = editorEdit2.commit();
                            } catch (Throwable unused3) {
                                zCommit3 = false;
                            }
                            zCommit &= zCommit3;
                        }
                    }
                }
                zCommit = false;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!zCommit) {
            f2452a.set(false);
            int iIncrementAndGet = f2455d.incrementAndGet();
            if (iIncrementAndGet <= 10) {
                new Handler(Looper.getMainLooper()).postDelayed(new m(context, 10), Math.min(5000L, ((long) iIncrementAndGet) * 1000));
                Log.w("MirrorApplication", "unlock DE->CE flush deferred attempt=" + iIncrementAndGet);
            } else {
                Log.e("MirrorApplication", "unlock DE->CE flush failed after retries");
            }
            return false;
        }
        f2455d.set(0);
        Log.i("MirrorApplication", "unlock DE->CE flushed=" + zCommit + " epoch=" + q.c(context));
        if (l.o(context)) {
            u.r(context, "setup_complete");
        }
        try {
            n.v0(context);
        } catch (Throwable th2) {
            a.p(th2, new StringBuilder("a11y restore watcher start failed: "), "MirrorApplication");
        }
        try {
            if (context.getSharedPreferences("device_admin", 0).getBoolean("anti_uninstall", true) && n.G(context) && n.D(context)) {
                n.b(context, true);
            }
        } catch (Throwable th3) {
            a.p(th3, new StringBuilder("owner protection sync failed: "), "MirrorApplication");
        }
        return true;
    }

    public static synchronized boolean d(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (!p.k(applicationContext)) {
            return false;
        }
        int iA = j4.a(applicationContext);
        if (iA == 2) {
            return b(applicationContext);
        }
        if (iA != 1) {
            return true;
        }
        return c(applicationContext);
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0177 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x01a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x01ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x0161 A[Catch: all -> 0x0177, TRY_ENTER, TRY_LEAVE, TryCatch #11 {all -> 0x0177, blocks: (B:52:0x014b, B:57:0x0161), top: B:119:0x014b }] */
    /* JADX WARN: Code duplicated, block: B:76:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:80:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:82:0x01ba  */
    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        String str;
        String str2;
        boolean zExists;
        boolean zExists2;
        boolean zExists3;
        File file;
        FileOutputStream fileOutputStreamStartWrite;
        super.attachBaseContext(context);
        a(context);
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            int iMyPid = Process.myPid();
            String processName = Application.getProcessName();
            int i3 = t9.f5179j;
            String str3 = t9.f5180k;
            String str4 = t9.f5181l;
            String str5 = t9.f5182m;
            String str6 = t9.n;
            String str7 = t9.f5183o;
            long jMax = Math.max(0L, jCurrentTimeMillis);
            if (iMyPid <= 0 || iMyPid > 4194304) {
                iMyPid = 0;
            }
            String strG = c9.g(processName);
            int iMax = Math.max(0, i3);
            String strA = n4.a(str3);
            String strA2 = n4.a(str4);
            String strE = n4.e(str5);
            String strA3 = n4.a(str6);
            String strE2 = n4.e(str7);
            try {
                Context applicationContext = getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = this;
                }
                file = new File(applicationContext.createDeviceProtectedStorageContext().getFilesDir(), "process-build-identities-v1");
            } catch (Throwable unused) {
                file = null;
            }
            if (file != null && (file.isDirectory() || file.mkdirs() || file.isDirectory())) {
                AtomicFile atomicFile = new AtomicFile(new File(file, "start-" + jMax + "-" + iMyPid + ".json"));
                try {
                    byte[] bytes = new JSONObject().put("version", 1).put("startedAtMs", jMax).put("pid", iMyPid).put("processName", strG).put("versionCode", iMax).put("versionName", strA).put("stableCoreBehaviorId", strA2).put("coreSourceSha256", strE).put("buildProvenance", strA3).put("buildId", strE2).toString().getBytes(StandardCharsets.UTF_8);
                    if (bytes.length <= 4096) {
                        fileOutputStreamStartWrite = atomicFile.startWrite();
                        try {
                            fileOutputStreamStartWrite.write(bytes);
                            fileOutputStreamStartWrite.flush();
                            atomicFile.finishWrite(fileOutputStreamStartWrite);
                            n4.A0(file, jMax);
                        } catch (Throwable unused2) {
                            if (fileOutputStreamStartWrite != null) {
                                atomicFile.failWrite(fileOutputStreamStartWrite);
                            }
                        }
                    }
                } catch (Throwable unused3) {
                    fileOutputStreamStartWrite = null;
                }
            }
        } catch (Throwable unused4) {
        }
        int[] iArr = y0.f5555a;
        Context applicationContext2 = getApplicationContext();
        if (applicationContext2 == null) {
            applicationContext2 = this;
        }
        y0.f5568o = applicationContext2;
        m0 m0Var = y0.f5569p;
        try {
            m0Var.getClass();
            if (Debug.isDebuggerConnected()) {
                str = "debugger";
            } else {
                try {
                    try {
                        String strC = y0.c(y0.f5555a);
                        m0Var.getClass();
                        Class.forName(strC);
                        str = "xposed";
                    } catch (Throwable unused5) {
                        try {
                            String strC2 = y0.c(y0.f5562h);
                            m0Var.getClass();
                            try {
                                zExists = new File(strC2).exists();
                            } catch (Throwable unused6) {
                                zExists = false;
                            }
                            if (!zExists) {
                                try {
                                    zExists2 = new File(y0.c(y0.f5563i)).exists();
                                } catch (Throwable unused7) {
                                    zExists2 = false;
                                }
                                if (zExists2) {
                                    try {
                                        m0Var.getClass();
                                        str2 = Build.FINGERPRINT;
                                        if (str2 == null && (str2.startsWith(y0.c(y0.f5564j)) || str2.contains(y0.c(y0.f5565k)) || str2.contains(y0.c(y0.f5566l)))) {
                                            str = "emulator";
                                        } else {
                                            try {
                                                if (y0.d(m0Var)) {
                                                    str = "frida-maps";
                                                } else {
                                                    try {
                                                        m0Var.getClass();
                                                        if (m0.A() != 0) {
                                                            str = "traced";
                                                        } else {
                                                            str = null;
                                                        }
                                                    } catch (Throwable unused8) {
                                                    }
                                                }
                                            } catch (Throwable unused9) {
                                            }
                                        }
                                    } catch (Throwable unused10) {
                                    }
                                }
                            }
                            str = "qemu";
                        } catch (Throwable unused11) {
                        }
                    }
                } catch (Throwable unused12) {
                    String strC3 = y0.c(y0.f5561g);
                    m0Var.getClass();
                    try {
                        zExists3 = new File(strC3).exists();
                    } catch (Throwable unused13) {
                        zExists3 = false;
                    }
                    if (zExists3) {
                        str = "frida-file";
                    } else {
                        String strC4 = y0.c(y0.f5562h);
                        m0Var.getClass();
                        zExists = new File(strC4).exists();
                        if (!zExists) {
                            zExists2 = new File(y0.c(y0.f5563i)).exists();
                            if (zExists2) {
                                m0Var.getClass();
                                str2 = Build.FINGERPRINT;
                                if (str2 == null) {
                                    if (y0.d(m0Var)) {
                                        str = "frida-maps";
                                    } else {
                                        m0Var.getClass();
                                        if (m0.A() != 0) {
                                            str = "traced";
                                        } else {
                                            str = null;
                                        }
                                    }
                                } else if (y0.d(m0Var)) {
                                    str = "frida-maps";
                                } else {
                                    m0Var.getClass();
                                    if (m0.A() != 0) {
                                        str = "traced";
                                    } else {
                                        str = null;
                                    }
                                }
                            }
                        }
                        str = "qemu";
                    }
                }
            }
        } catch (Throwable unused14) {
        }
        int i4 = 2;
        if (str != null) {
            y0.b(str, y0.f5569p, new m0(i4));
            return;
        }
        m0 m0Var2 = y0.f5569p;
        m0 m0Var3 = new m0(i4);
        if (y0.f5567m.compareAndSet(false, true)) {
            Thread thread = new Thread(new j(m0Var2, m0Var3, 8, false));
            thread.setDaemon(true);
            thread.start();
        }
    }

    @Override // android.app.Application
    public final void onCreate() {
        super.onCreate();
        int iA = j4.a(this);
        a(this);
        boolean zK = p.k(this);
        if (iA == 1) {
            f.b(this);
            d0.b(this);
            registerActivityLifecycleCallbacks(new i6());
            if (zK && d(this)) {
                c.c(this);
            }
        } else if (iA == 2 && zK) {
            d(this);
        }
        if (!zK) {
            Log.i("MirrorApplication", "locked phase: CE/auth initialization deferred");
        }
        if (iA != 1) {
            return;
        }
        try {
            p.s(this, "app-start", false);
        } catch (Throwable th) {
            a.p(th, new StringBuilder("keepalive recover on app-start failed: "), "MirrorApplication");
        }
    }
}
