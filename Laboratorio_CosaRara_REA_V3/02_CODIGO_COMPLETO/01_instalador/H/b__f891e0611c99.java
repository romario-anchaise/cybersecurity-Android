// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package H;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: H.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0027b {
    public static Handler a(Looper looper) {
        return Handler.createAsync(looper);
    }
}
