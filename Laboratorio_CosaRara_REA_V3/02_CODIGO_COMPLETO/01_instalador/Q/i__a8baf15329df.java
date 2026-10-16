// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p029q;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static Intent a(Activity activity) {
        return activity.getParentActivityIntent();
    }

    public static boolean b(Activity activity, Intent intent) {
        return activity.navigateUpTo(intent);
    }

    public static boolean c(Activity activity, Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }
}
