// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p029q;

import android.app.Activity;
import android.app.SharedElementCallback;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static void a(Activity activity) {
        activity.finishAfterTransition();
    }

    public static void b(Activity activity) {
        activity.postponeEnterTransition();
    }

    public static void c(Activity activity, SharedElementCallback sharedElementCallback) {
        activity.setEnterSharedElementCallback(sharedElementCallback);
    }

    public static void d(Activity activity, SharedElementCallback sharedElementCallback) {
        activity.setExitSharedElementCallback(sharedElementCallback);
    }

    public static void e(Activity activity) {
        activity.startPostponedEnterTransition();
    }
}
