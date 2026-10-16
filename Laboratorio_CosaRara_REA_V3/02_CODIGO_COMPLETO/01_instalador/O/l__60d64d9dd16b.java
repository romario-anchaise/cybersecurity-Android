// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package O;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public static PackageInfo a(PackageManager packageManager, Context context) throws PackageManager.NameNotFoundException {
        return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
    }
}
