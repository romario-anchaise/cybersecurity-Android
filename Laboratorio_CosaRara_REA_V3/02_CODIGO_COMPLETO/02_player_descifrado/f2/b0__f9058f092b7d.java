// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f1134d;

    public /* synthetic */ b0(Context context, int i3) {
        this.f1133c = i3;
        this.f1134d = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        switch (this.f1133c) {
            case 0:
                if (l.f1254y) {
                    return;
                }
                if (!w1.n.L(this.f1134d)) {
                    c2.p.s(this.f1134d, "splash-keepalive", false);
                    Handler handler2 = l.f1253x;
                    if (handler2 == null || l.f1254y) {
                        return;
                    }
                    handler2.postDelayed(this, 15000L);
                    return;
                }
                l.f1254y = true;
                Handler handler3 = l.f1253x;
                HandlerThread handlerThread = l.f1252w;
                l.f1253x = null;
                l.f1252w = null;
                if (handler3 != null) {
                    handler3.removeCallbacksAndMessages(null);
                }
                if (handlerThread != null) {
                    handlerThread.quitSafely();
                    return;
                }
                return;
            default:
                w1.n.t(this.f1134d);
                synchronized (w1.n.n) {
                    try {
                        if (w1.n.f4583v && (handler = w1.n.f4577p) != null) {
                            handler.postDelayed(this, 3000L);
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
        }
    }
}
