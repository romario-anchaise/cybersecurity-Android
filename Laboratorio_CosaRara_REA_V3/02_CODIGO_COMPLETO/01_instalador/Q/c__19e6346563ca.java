// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p029q;

import R0.h;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f4002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Activity f4003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4005d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f4006e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4007f = false;

    public c(Activity activity) {
        this.f4003b = activity;
        this.f4004c = activity.hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (this.f4003b == activity) {
            this.f4003b = null;
            this.f4006e = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (!this.f4006e || this.f4007f || this.f4005d) {
            return;
        }
        Object obj = this.f4002a;
        try {
            Object obj2 = d.f4010c.get(activity);
            if (obj2 == obj && activity.hashCode() == this.f4004c) {
                d.g.postAtFrontOfQueue(new h(d.f4009b.get(activity), 4, obj2));
                this.f4007f = true;
                this.f4002a = null;
            }
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (this.f4003b == activity) {
            this.f4005d = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
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
