// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package q;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends h.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3036c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f3037d;

    public i(Context context) {
        super(9, 10);
        this.f3037d = context;
    }

    @Override // h.a
    public final void a(k.c cVar) {
        switch (this.f3036c) {
            case 0:
                if (this.f1854b >= 10) {
                    cVar.B(new Object[]{"reschedule_needed", 1});
                    return;
                } else {
                    this.f3037d.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
                    return;
                }
            default:
                cVar.f2373c.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
                Context context = this.f3037d;
                SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
                if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
                    long j3 = sharedPreferences.getLong("last_cancel_all_time_ms", 0L);
                    long j4 = sharedPreferences.getBoolean("reschedule_needed", false) ? 1L : 0L;
                    cVar.d();
                    try {
                        cVar.B(new Object[]{"last_cancel_all_time_ms", Long.valueOf(j3)});
                        cVar.B(new Object[]{"reschedule_needed", Long.valueOf(j4)});
                        sharedPreferences.edit().clear().apply();
                        cVar.F();
                        cVar.z();
                    } catch (Throwable th) {
                        cVar.z();
                        throw th;
                    }
                }
                SharedPreferences sharedPreferences2 = context.getSharedPreferences("androidx.work.util.id", 0);
                if (sharedPreferences2.contains("next_job_scheduler_id") || sharedPreferences2.contains("next_job_scheduler_id")) {
                    int i3 = sharedPreferences2.getInt("next_job_scheduler_id", 0);
                    int i4 = sharedPreferences2.getInt("next_alarm_manager_id", 0);
                    cVar.d();
                    try {
                        cVar.B(new Object[]{"next_job_scheduler_id", Integer.valueOf(i3)});
                        cVar.B(new Object[]{"next_alarm_manager_id", Integer.valueOf(i4)});
                        sharedPreferences2.edit().clear().apply();
                        cVar.F();
                        return;
                    } finally {
                        cVar.z();
                    }
                }
                return;
        }
    }

    public i(Context context, int i3, int i4) {
        super(i3, i4);
        this.f3037d = context;
    }
}
