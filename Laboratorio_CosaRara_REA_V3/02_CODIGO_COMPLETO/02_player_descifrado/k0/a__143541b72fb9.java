// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import h0.o;
import h0.y;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import m0.b;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f2396b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f2397c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f2398a = new ConcurrentHashMap();

    public static a a() {
        if (f2397c == null) {
            synchronized (f2396b) {
                try {
                    if (f2397c == null) {
                        f2397c = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        a aVar = f2397c;
        o.c(aVar);
        return aVar;
    }

    public final void b(Context context, ServiceConnection serviceConnection) {
        if (!(serviceConnection instanceof y)) {
            ConcurrentHashMap concurrentHashMap = this.f2398a;
            if (concurrentHashMap.containsKey(serviceConnection)) {
                try {
                    try {
                        context.unbindService((ServiceConnection) concurrentHashMap.get(serviceConnection));
                    } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
                    }
                    return;
                } finally {
                    concurrentHashMap.remove(serviceConnection);
                }
            }
        }
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused2) {
        }
    }

    public final boolean c(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i3, Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((b.a(context).f358a.getPackageManager().getApplicationInfo(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (serviceConnection instanceof y) {
            if (executor == null) {
                executor = null;
            }
            return executor != null ? context.bindService(intent, i3, executor, serviceConnection) : context.bindService(intent, serviceConnection, i3);
        }
        ConcurrentHashMap concurrentHashMap = this.f2398a;
        ServiceConnection serviceConnection2 = (ServiceConnection) concurrentHashMap.putIfAbsent(serviceConnection, serviceConnection);
        if (serviceConnection2 != null && serviceConnection != serviceConnection2) {
            Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
        }
        if (executor == null) {
            executor = null;
        }
        try {
            boolean zBindService = executor != null ? context.bindService(intent, i3, executor, serviceConnection) : context.bindService(intent, serviceConnection, i3);
            if (zBindService) {
                return zBindService;
            }
            concurrentHashMap.remove(serviceConnection, serviceConnection);
            return false;
        } catch (Throwable th) {
            concurrentHashMap.remove(serviceConnection, serviceConnection);
            throw th;
        }
    }
}
