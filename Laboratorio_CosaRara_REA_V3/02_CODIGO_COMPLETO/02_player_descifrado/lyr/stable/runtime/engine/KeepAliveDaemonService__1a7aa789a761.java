// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.engine;

import a2.v;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import w1.g;
import w1.n;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class KeepAliveDaemonService extends v {
    @Override // a2.v
    public final Class[] a() {
        return new Class[]{KeepAliveAssist1Service.class, KeepAliveAssist2Service.class};
    }

    @Override // a2.v, android.app.Service
    public final void onCreate() {
        super.onCreate();
        Context applicationContext = getApplicationContext();
        synchronized (n.f4570h) {
            if (applicationContext != null) {
                this = applicationContext;
            }
            try {
                n.f4573k = this;
                if (n.f4571i == null) {
                    HandlerThread handlerThread = new HandlerThread("a11y-bind-monitor");
                    n.f4571i = handlerThread;
                    handlerThread.start();
                    n.f4572j = new Handler(n.f4571i.getLooper());
                }
                Handler handler = n.f4572j;
                g gVar = n.f4575m;
                handler.removeCallbacks(gVar);
                n.f4572j.post(gVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a2.v, android.app.Service
    public final void onDestroy() {
        HandlerThread handlerThread;
        synchronized (n.f4570h) {
            try {
                Handler handler = n.f4572j;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                handlerThread = n.f4571i;
                n.f4571i = null;
                n.f4572j = null;
                n.f4573k = null;
                n.f4574l = 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        super.onDestroy();
    }
}
