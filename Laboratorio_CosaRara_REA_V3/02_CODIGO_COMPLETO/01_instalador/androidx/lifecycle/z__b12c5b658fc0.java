// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;

/* JADX INFO: loaded from: classes.dex */
public abstract class z {
    public static final void a(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        F0.i.e(activity, "activity");
        F0.i.e(activityLifecycleCallbacks, "callback");
        activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }
}
