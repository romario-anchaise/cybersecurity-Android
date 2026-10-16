// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package androidx.work.impl.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import p.m;
import z.d;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class ForceStopRunnable$BroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f241a = m.f("ForceStopRunnable$Rcvr");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null || !"ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
            return;
        }
        if (m.d().f2856a <= 2) {
            Log.v(f241a, "Rescheduling alarm that keeps track of force-stops.");
        }
        String str = d.f6236g;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        int i3 = Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728;
        Intent intent2 = new Intent();
        intent2.setComponent(new ComponentName(context, (Class<?>) ForceStopRunnable$BroadcastReceiver.class));
        intent2.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, -1, intent2, i3);
        long jCurrentTimeMillis = System.currentTimeMillis() + d.f6237h;
        if (alarmManager != null) {
            alarmManager.setExact(0, jCurrentTimeMillis, broadcast);
        }
    }
}
