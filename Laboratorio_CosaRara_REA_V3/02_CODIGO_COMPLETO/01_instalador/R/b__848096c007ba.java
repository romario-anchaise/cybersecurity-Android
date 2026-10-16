// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p031r;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static File[] a(Context context) {
        return context.getExternalCacheDirs();
    }

    public static File[] b(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    public static File[] c(Context context) {
        return context.getObbDirs();
    }
}
