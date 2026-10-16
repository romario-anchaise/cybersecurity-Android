// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.Service;
import android.util.Log;
import androidx.work.impl.foreground.SystemForegroundService;
import p.m;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static void a(Service service, int i3, Notification notification, int i4) {
        try {
            service.startForeground(i3, notification, i4);
        } catch (ForegroundServiceStartNotAllowedException e3) {
            m mVarD = m.d();
            String str = SystemForegroundService.f236f;
            if (mVarD.f2856a <= 5) {
                Log.w(str, "Unable to start foreground service", e3);
            }
        }
    }
}
