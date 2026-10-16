// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f3005a;

    public c() {
        this.f3005a = Handler.createAsync(Looper.getMainLooper());
    }

    public /* synthetic */ c(Handler handler) {
        this.f3005a = handler;
    }
}
