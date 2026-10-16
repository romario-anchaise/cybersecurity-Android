// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package z;

import android.content.Context;
import android.os.PowerManager;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6255a = p.m.f("WakeLocks");

    public static final PowerManager.WakeLock a(Context context, String str) {
        context.getClass();
        Object systemService = context.getApplicationContext().getSystemService("power");
        systemService.getClass();
        String strConcat = "WorkManager: ".concat(str);
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) systemService).newWakeLock(1, strConcat);
        synchronized (o.f6256a) {
        }
        wakeLockNewWakeLock.getClass();
        return wakeLockNewWakeLock;
    }
}
