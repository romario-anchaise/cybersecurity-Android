// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a2;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import lyr.stable.runtime.engine.CompanionService;
import lyr.stable.runtime.engine.KeepAliveDaemonService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class v extends Service {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f152i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f153j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Binder f144a = new Binder();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f145b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ServiceConnection[] f146c = new ServiceConnection[2];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final t f154k = new t(1, this);

    public v() {
        int i3 = 2;
        this.f148e = new b(i3, this);
        this.f149f = new i(i3, this);
    }

    public static boolean b(Context context, boolean z2) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
            if (activityManager != null && activityManager.getRunningAppProcesses() != null) {
                String packageName = context.getPackageName();
                boolean zEquals = false;
                boolean zEquals2 = false;
                boolean zEquals3 = false;
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo != null && runningAppProcessInfo.processName != null) {
                        zEquals |= (packageName + ":keepalive").equals(runningAppProcessInfo.processName);
                        zEquals2 |= (packageName + ":assist1").equals(runningAppProcessInfo.processName);
                        zEquals3 |= (packageName + ":assist2").equals(runningAppProcessInfo.processName);
                    }
                }
                if (zEquals) {
                    if (!z2) {
                        return true;
                    }
                    if (zEquals2 && zEquals3) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("trio process check failed: "), "TrioKeepAlive");
            return false;
        }
    }

    public static boolean d(Context context, Class cls, boolean z2, long j3) {
        try {
            Intent intent = new Intent(context, (Class<?>) cls);
            if (z2) {
                c.l(intent, false, j3);
            }
            context.startForegroundService(intent);
            return true;
        } catch (Throwable th) {
            Log.w("TrioKeepAlive", cls.getSimpleName() + " start failed: " + th.getMessage());
            if (!z2) {
                c2.p.C(context, "trio-start-failed:".concat(cls.getSimpleName()), 60000L, -1);
            }
            return false;
        }
    }

    public static void e(Context context, Class cls) {
        try {
            context.stopService(new Intent(context, (Class<?>) cls));
        } catch (Throwable th) {
            Log.w("TrioKeepAlive", cls.getSimpleName() + " stop failed: " + th.getMessage());
        }
    }

    public abstract Class[] a();

    public final void c() {
        Handler handler = this.f145b;
        b bVar = this.f148e;
        handler.removeCallbacks(bVar);
        f();
        this.f147d = true;
        handler.postDelayed(bVar, 12000L);
    }

    public final void f() {
        int i3 = 0;
        while (true) {
            ServiceConnection[] serviceConnectionArr = this.f146c;
            if (i3 >= serviceConnectionArr.length) {
                return;
            }
            ServiceConnection serviceConnection = serviceConnectionArr[i3];
            if (serviceConnection != null) {
                try {
                    unbindService(serviceConnection);
                    serviceConnectionArr[i3] = null;
                } catch (Throwable unused) {
                    serviceConnectionArr[i3] = null;
                }
            }
            i3++;
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f144a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [a2.v] */
    /* JADX WARN: Type inference failed for: r2v9, types: [a2.v, android.app.Service] */
    @Override // android.app.Service
    public void onCreate() {
        ?? r3;
        ?? r4;
        super.onCreate();
        if (this.f153j) {
            r4 = this;
        } else {
            try {
                IntentFilter intentFilter = new IntentFilter("lyr.stable.runtime.action.MESH_FUSE");
                String str = getPackageName() + ".permission.INTERNAL_MESH_FUSE";
                int i3 = Build.VERSION.SDK_INT;
                r3 = 33;
                t tVar = this.f154k;
                try {
                    if (i3 >= 33) {
                        v vVar = this;
                        vVar.registerReceiver(tVar, intentFilter, str, null, 4);
                        r3 = vVar;
                    } else {
                        v vVar2 = this;
                        vVar2.registerReceiver(tVar, intentFilter, str, null);
                        r3 = vVar2;
                    }
                    r3.f153j = true;
                    r4 = r3;
                } catch (Throwable th) {
                    th = th;
                    a0.a.p(th, new StringBuilder("mesh fuse receiver registration failed: "), "TrioKeepAlive");
                    r4 = r3;
                }
            } catch (Throwable th2) {
                th = th2;
                r3 = this;
            }
        }
        boolean zP = c2.u.p(r4, 16);
        if (zP) {
            r4.f150g = true;
            r4.f151h = false;
        }
        if (zP) {
            r4.c();
            Handler handler = r4.f145b;
            i iVar = r4.f149f;
            handler.removeCallbacks(iVar);
            handler.postDelayed(iVar, 30000L);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f145b.removeCallbacksAndMessages(null);
        this.f147d = false;
        f();
        if (this.f153j) {
            this.f153j = false;
            try {
                unregisterReceiver(this.f154k);
            } catch (Throwable unused) {
            }
        }
        if (!this.f151h) {
            boolean z2 = this.f152i;
            boolean z3 = this instanceof KeepAliveDaemonService;
            boolean zK = r.k(this);
            if (!z2 && (z3 || !zK)) {
                r.w(this, z3 ? "trio-daemon-destroy" : "trio-destroy");
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i4) {
        boolean z2;
        boolean zF = c.f(intent);
        boolean z3 = this instanceof KeepAliveDaemonService;
        if (z3) {
            r.q(this, "daemon-start");
        }
        boolean zK = r.k(this);
        Handler handler = this.f145b;
        if (zK) {
            if (!z3) {
                this.f152i = true;
                handler.removeCallbacksAndMessages(null);
                this.f147d = false;
                f();
                stopSelfResult(i4);
                return 2;
            }
            CompanionService.e(this);
        }
        boolean zP = c2.u.p(this, 16);
        if (zP) {
            this.f150g = true;
            this.f151h = false;
        }
        if (zP || (z2 = this.f150g)) {
            c();
            i iVar = this.f149f;
            handler.removeCallbacks(iVar);
            handler.postDelayed(iVar, 30000L);
            return 1;
        }
        if (z2) {
            return 1;
        }
        if (!zF) {
            c2.p.C(this, "trio-foreground-failed", 60000L, -1);
        }
        this.f151h = true;
        if (!stopSelfResult(i4)) {
            this.f151h = false;
        }
        return 2;
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
        if (!this.f151h) {
            boolean z2 = this.f152i;
            boolean z3 = this instanceof KeepAliveDaemonService;
            boolean zK = r.k(this);
            if (!z2 && (z3 || !zK)) {
                r.w(this, z3 ? "trio-daemon-task-removed" : "trio-task-removed");
            }
        }
        super.onTaskRemoved(intent);
    }
}
