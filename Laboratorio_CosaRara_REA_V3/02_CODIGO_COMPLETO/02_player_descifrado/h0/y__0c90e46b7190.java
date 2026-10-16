// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class y implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f1938a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1939b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IBinder f1941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final x f1942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ComponentName f1943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ a0 f1944g;

    public y(a0 a0Var, x xVar) {
        this.f1944g = a0Var;
        this.f1942e = xVar;
    }

    public final e0.b a(String str, Executor executor) {
        try {
            Intent intentA = q.a(this.f1944g.f1860b, this.f1942e);
            this.f1939b = 3;
            StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
            if (Build.VERSION.SDK_INT >= 31) {
                StrictMode.setVmPolicy(l0.b.a(new StrictMode.VmPolicy.Builder(vmPolicy)).build());
            }
            try {
                a0 a0Var = this.f1944g;
                k0.a aVar = a0Var.f1862d;
                Context context = a0Var.f1860b;
                x xVar = this.f1942e;
                boolean zC = aVar.c(context, str, intentA, this, 4225, executor);
                this.f1940c = zC;
                if (zC) {
                    a0Var.f1861c.sendMessageDelayed(a0Var.f1861c.obtainMessage(1, xVar), a0Var.f1864f);
                    return e0.b.f657h;
                }
                this.f1939b = 2;
                try {
                    a0Var.f1862d.b(a0Var.f1860b, this);
                } catch (IllegalArgumentException unused) {
                }
                return new e0.b(16, null, null);
            } finally {
                StrictMode.setVmPolicy(vmPolicy);
            }
        } catch (p e3) {
            return e3.f1921c;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a0 a0Var = this.f1944g;
        synchronized (a0Var.f1859a) {
            try {
                a0Var.f1861c.removeMessages(1, this.f1942e);
                this.f1941d = iBinder;
                this.f1943f = componentName;
                Iterator it = this.f1938a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f1939b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        a0 a0Var = this.f1944g;
        synchronized (a0Var.f1859a) {
            try {
                a0Var.f1861c.removeMessages(1, this.f1942e);
                this.f1941d = null;
                this.f1943f = componentName;
                Iterator it = this.f1938a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f1939b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
