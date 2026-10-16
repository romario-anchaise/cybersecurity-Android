// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g0;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f1429e = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f1430a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f1431b = new AtomicBoolean();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f1432c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1433d = false;

    public final void a(boolean z2) {
        synchronized (f1429e) {
            try {
                ArrayList arrayList = this.f1432c;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    p0.e eVar = ((f) obj).f1452a.f1450m;
                    eVar.sendMessage(eVar.obtainMessage(1, Boolean.valueOf(z2)));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean zCompareAndSet = this.f1430a.compareAndSet(true, false);
        this.f1431b.set(true);
        if (zCompareAndSet) {
            a(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean zCompareAndSet = this.f1430a.compareAndSet(true, false);
        this.f1431b.set(true);
        if (zCompareAndSet) {
            a(false);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i3) {
        if (i3 == 20 && this.f1430a.compareAndSet(false, true)) {
            this.f1431b.set(true);
            a(true);
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
