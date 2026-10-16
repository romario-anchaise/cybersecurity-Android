// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.engine;

import a0.a;
import a2.b;
import a2.c;
import a2.r;
import a2.v;
import android.app.ActivityManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import c2.p;
import c2.u;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class CompanionService extends Service {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f2584d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2587c;

    public static boolean a(Context context) {
        ArrayList arrayListC = c(context);
        return arrayListC != null && b(arrayListC, EngineService.class, true) && b(arrayListC, CompanionService.class, true) && b(arrayListC, KeepAliveDaemonService.class, true) && b(arrayListC, SilentMusicKeepAliveService.class, true) && b(arrayListC, MediaKeepAliveStarter$BrowserService.class, false) && b(arrayListC, MediaKeepAliveStarter$RouteService.class, false) && b(arrayListC, MediaKeepAliveStarter$Route2Service.class, false) && b(arrayListC, KeepAliveDaemonService.class, true) && b(arrayListC, KeepAliveAssist1Service.class, true) && b(arrayListC, KeepAliveAssist2Service.class, true) && v.b(context, true);
    }

    public static boolean b(ArrayList arrayList, Class cls, boolean z2) {
        ComponentName componentName;
        String name = cls.getName();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ActivityManager.RunningServiceInfo runningServiceInfo = (ActivityManager.RunningServiceInfo) obj;
            if (runningServiceInfo != null && (componentName = runningServiceInfo.service) != null && name.equals(componentName.getClassName())) {
                boolean z3 = runningServiceInfo.started;
                boolean z4 = runningServiceInfo.foreground;
                if (z3 && (!z2 || z4)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static ArrayList c(Context context) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        ComponentName componentName;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
        if (activityManager == null || (runningServices = activityManager.getRunningServices(Integer.MAX_VALUE)) == null) {
            return null;
        }
        String packageName = context.getPackageName();
        ArrayList arrayList = new ArrayList();
        for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
            if (runningServiceInfo != null && (componentName = runningServiceInfo.service) != null && packageName.equals(componentName.getPackageName())) {
                arrayList.add(runningServiceInfo);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0043  */
    public static boolean d(Context context, boolean z2, long j3) {
        boolean z3;
        boolean z4;
        if (r.k(context)) {
            z3 = false;
        } else {
            try {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                Intent intent = new Intent(applicationContext, (Class<?>) SilentMusicKeepAliveService.class);
                if (z2) {
                    c.l(intent, false, j3);
                }
                applicationContext.startForegroundService(intent);
                z3 = true;
            } catch (Throwable th) {
                a.p(th, new StringBuilder("start failed: "), "SilentMusicKA");
                if (!z2) {
                    p.C(context, "silent-music-start-failed", 60000L, -1);
                }
                z3 = false;
            }
        }
        if (r.k(context)) {
            z4 = false;
        } else {
            Context applicationContext2 = context.getApplicationContext();
            if (applicationContext2 == null) {
                applicationContext2 = context;
            }
            boolean zR = c.r(applicationContext2, MediaKeepAliveStarter$BrowserService.class);
            boolean zR2 = c.r(applicationContext2, MediaKeepAliveStarter$RouteService.class);
            boolean zR3 = c.r(applicationContext2, MediaKeepAliveStarter$Route2Service.class);
            if (zR && zR2 && zR3) {
                z4 = true;
            } else {
                z4 = false;
            }
        }
        Context applicationContext3 = context.getApplicationContext();
        if (applicationContext3 != null) {
            context = applicationContext3;
        }
        Context applicationContext4 = context.getApplicationContext();
        if (applicationContext4 == null) {
            applicationContext4 = context;
        }
        return z3 && z4 && (v.d(applicationContext4, KeepAliveDaemonService.class, z2, j3) && v.d(context, KeepAliveAssist1Service.class, z2, j3) && v.d(context, KeepAliveAssist2Service.class, z2, j3));
    }

    public static void e(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        try {
            applicationContext.sendBroadcast(new Intent("lyr.stable.runtime.action.MESH_FUSE").setPackage(applicationContext.getPackageName()), applicationContext.getPackageName() + ".permission.INTERNAL_MESH_FUSE");
        } catch (Throwable th) {
            a.p(th, new StringBuilder("mesh fuse broadcast failed: "), "TrioKeepAlive");
        }
        Context applicationContext2 = context.getApplicationContext();
        if (applicationContext2 == null) {
            applicationContext2 = context;
        }
        try {
            applicationContext2.stopService(new Intent(applicationContext2, (Class<?>) SilentMusicKeepAliveService.class));
        } catch (Throwable th2) {
            a.p(th2, new StringBuilder("fuse stop failed: "), "SilentMusicKA");
        }
        Context applicationContext3 = context.getApplicationContext();
        if (applicationContext3 == null) {
            applicationContext3 = context;
        }
        c.t(applicationContext3, MediaKeepAliveStarter$BrowserService.class);
        c.t(applicationContext3, MediaKeepAliveStarter$RouteService.class);
        c.t(applicationContext3, MediaKeepAliveStarter$Route2Service.class);
        Context applicationContext4 = context.getApplicationContext();
        if (applicationContext4 != null) {
            context = applicationContext4;
        }
        v.e(context, KeepAliveAssist1Service.class);
        v.e(context, KeepAliveAssist2Service.class);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        if (u.p(this, 16)) {
            this.f2585a = true;
            this.f2586b = false;
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        if (!this.f2586b) {
            r.w(this, "companion-destroy");
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i4) {
        boolean z2;
        r.q(this, "companion-start");
        boolean zF = c.f(intent);
        boolean zP = u.p(this, 16);
        if (zP) {
            this.f2585a = true;
            this.f2586b = false;
        }
        if (zP || (z2 = this.f2585a)) {
            if (intent != null && ("HB".equals(intent.getAction()) || intent.getBooleanExtra("FROM_ALARM", false))) {
                p.D(this);
            }
            if (zF) {
                this.f2587c = true;
                new Thread(new a2.a(this, c.f(intent) && intent.getBooleanExtra("MESH_REPAIR_ESSENTIAL_ONLY", false), c.f(intent) ? intent.getLongExtra("MESH_REPAIR_ID", 0L) : 0L, 0), "companion-mesh-repair").start();
                return 1;
            }
            if (!this.f2587c) {
                this.f2587c = true;
                if (intent != null && intent.getBooleanExtra("FIRST_SETUP", false)) {
                    new Thread(new b(0, this), "companion-R").start();
                    return 1;
                }
                r.w(this, "companion-recovery-start");
            }
        } else if (!z2) {
            if (!zF) {
                p.C(this, "companion-foreground-failed", 60000L, -1);
            }
            this.f2586b = true;
            if (stopSelfResult(i4)) {
                return 2;
            }
            this.f2586b = false;
            return 2;
        }
        return 1;
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
        if (!this.f2586b) {
            r.w(this, "companion-task-removed");
        }
        super.onTaskRemoved(intent);
    }
}
