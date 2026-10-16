// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p029q;

import android.app.AppOpsManager;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    public static int a(AppOpsManager appOpsManager, String str, int i2, String str2) {
        if (appOpsManager == null) {
            return 1;
        }
        return appOpsManager.checkOpNoThrow(str, i2, str2);
    }

    public static String b(Context context) {
        return context.getOpPackageName();
    }

    public static AppOpsManager c(Context context) {
        return (AppOpsManager) context.getSystemService(AppOpsManager.class);
    }
}
