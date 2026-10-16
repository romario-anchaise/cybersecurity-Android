// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HandlerThread f3873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Handler f3874b;

    public final boolean a(Runnable runnable) {
        Handler handler = this.f3874b;
        return handler != null && handler.post(runnable);
    }

    public final synchronized void b() {
        if (this.f3873a != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("keylog-worker");
        this.f3873a = handlerThread;
        handlerThread.start();
        this.f3874b = new Handler(this.f3873a.getLooper());
    }
}
