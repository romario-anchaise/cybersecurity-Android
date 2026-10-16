// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.engine;

import a2.r;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class MediaKeepAliveStarter$BrowserService extends Service {
    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i4) {
        if (!r.k(this)) {
            return 1;
        }
        stopSelfResult(i4);
        return 2;
    }
}
