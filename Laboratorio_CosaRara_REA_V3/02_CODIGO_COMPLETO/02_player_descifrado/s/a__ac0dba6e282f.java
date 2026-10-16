// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package s;

import android.app.AlarmManager;
import android.app.PendingIntent;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static void a(AlarmManager alarmManager, int i3, long j3, PendingIntent pendingIntent) {
        alarmManager.setExact(i3, j3, pendingIntent);
    }
}
