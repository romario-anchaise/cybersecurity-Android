// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;
import lyr.stable.runtime.MirrorOnePixelActivity;
import lyr.stable.runtime.keepalive.WakeScreenActivity;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i6 implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (activity == null) {
            AtomicInteger atomicInteger = c2.s.f457a;
            return;
        }
        AtomicInteger atomicInteger2 = c2.s.f457a;
        Class<?> cls = activity.getClass();
        if (WakeScreenActivity.class.isAssignableFrom(cls) || MirrorOnePixelActivity.class.isAssignableFrom(cls)) {
            return;
        }
        c2.s.f457a.updateAndGet(new c2.r());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (activity != null) {
            AtomicInteger atomicInteger = c2.s.f457a;
            Class<?> cls = activity.getClass();
            if (!WakeScreenActivity.class.isAssignableFrom(cls) && !MirrorOnePixelActivity.class.isAssignableFrom(cls)) {
                c2.s.f457a.incrementAndGet();
            }
        } else {
            AtomicInteger atomicInteger2 = c2.s.f457a;
        }
        try {
            m mVarC = m.c(activity);
            mVarC.getClass();
            mVarC.f(16, n.h0("activity_resumed"));
        } catch (Throwable th) {
            Log.d("MirrorApplication", "capability refresh on resume failed", th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
