// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import p.m;
import q.q;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f227a = m.f("RescheduleReceiver");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        m.d().a(f227a, "Received intent " + intent);
        try {
            q qVarA = q.a(context);
            BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            synchronized (q.f3054m) {
                try {
                    BroadcastReceiver.PendingResult pendingResult = qVarA.f3063i;
                    if (pendingResult != null) {
                        pendingResult.finish();
                    }
                    qVarA.f3063i = pendingResultGoAsync;
                    if (qVarA.f3062h) {
                        pendingResultGoAsync.finish();
                        qVarA.f3063i = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (IllegalStateException e3) {
            m.d().c(f227a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e3);
        }
    }
}
