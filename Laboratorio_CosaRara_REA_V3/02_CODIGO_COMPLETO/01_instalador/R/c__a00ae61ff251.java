// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package p031r;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    public static File a(Context context) {
        return context.getCodeCacheDir();
    }

    public static Drawable b(Context context, int i2) {
        return context.getDrawable(i2);
    }

    public static File c(Context context) {
        return context.getNoBackupFilesDir();
    }
}
