// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package O;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    public static Handler a(Looper looper) {
        return Handler.createAsync(looper);
    }
}
