// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package s;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import p.m;
import w1.a1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3187a = m.f("Alarms");

    public static void a(Context context, y.j jVar, int i3) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        String str = c.f3188e;
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        c.d(intent, jVar);
        PendingIntent service = PendingIntent.getService(context, i3, intent, 603979776);
        if (service == null || alarmManager == null) {
            return;
        }
        m.d().a(f3187a, "Cancelling existing alarm with (workSpecId, systemId) (" + jVar + ", " + i3 + ")");
        alarmManager.cancel(service);
    }

    public static void b(Context context, WorkDatabase workDatabase, y.j jVar, long j3) {
        y.i iVarP = workDatabase.p();
        y.g gVarB = iVarP.b(jVar);
        if (gVarB != null) {
            int i3 = gVarB.f5981c;
            a(context, jVar, i3);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            String str = c.f3188e;
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_DELAY_MET");
            c.d(intent, jVar);
            PendingIntent service = PendingIntent.getService(context, i3, intent, 201326592);
            if (alarmManager != null) {
                a.a(alarmManager, 0, j3, service);
                return;
            }
            return;
        }
        Object objN = workDatabase.n(new a1(1, new z.f(workDatabase, 0)));
        objN.getClass();
        int iIntValue = ((Number) objN).intValue();
        iVarP.c(new y.g(jVar.f5988b, iIntValue, jVar.f5987a));
        AlarmManager alarmManager2 = (AlarmManager) context.getSystemService("alarm");
        String str2 = c.f3188e;
        Intent intent2 = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent2.setAction("ACTION_DELAY_MET");
        c.d(intent2, jVar);
        PendingIntent service2 = PendingIntent.getService(context, iIntValue, intent2, 201326592);
        if (alarmManager2 != null) {
            a.a(alarmManager2, 0, j3, service2);
        }
    }
}
