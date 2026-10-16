// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.keepalive;

import android.content.Context;
import android.util.Log;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import c2.c;
import c2.p;
import p.e;
import p.j;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionKeepAliveWorker extends Worker {
    public ConnectionKeepAliveWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.Worker
    public final j g() {
        Context context = this.f2850a;
        if (p.i(context)) {
            Log.d("Keepalive", "workmanager healthy");
            p.p(context);
            return new j(e.f2842c);
        }
        Log.i("Keepalive", "workmanager unhealthy -> abe + recover");
        c.e(context, "workmanager", false);
        p.s(context, "workmanager", false);
        a2.c.c(context);
        return new j(e.f2842c);
    }
}
