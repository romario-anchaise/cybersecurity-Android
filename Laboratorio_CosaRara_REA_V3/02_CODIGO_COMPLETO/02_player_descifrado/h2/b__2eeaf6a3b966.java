// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h2;

import android.content.Context;
import android.content.SharedPreferences;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long[] f1956b = {1000, 1500, 2000, 3000};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long[] f1957c = {5000, 10000, 20000, 30000};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long[] f1958d = {5000, 8000, 12000, 20000};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1959a;

    public b(Context context, int i3) {
        switch (i3) {
            case 2:
                Context applicationContext = context.getApplicationContext();
                Context contextCreateDeviceProtectedStorageContext = (applicationContext != null ? applicationContext : context).createDeviceProtectedStorageContext();
                if (contextCreateDeviceProtectedStorageContext == null) {
                    o2.k("Device-Protected context unavailable");
                    throw null;
                }
                SharedPreferences sharedPreferences = contextCreateDeviceProtectedStorageContext.getSharedPreferences("reconnect_backoff_state", 0);
                if (sharedPreferences != null) {
                    this.f1959a = sharedPreferences;
                    return;
                } else {
                    o2.k("Device-Protected preferences unavailable");
                    throw null;
                }
            default:
                Context applicationContext2 = context.getApplicationContext();
                this.f1959a = applicationContext2 != null ? applicationContext2 : context;
                return;
        }
    }

    public synchronized l a(long j3) {
        l lVar;
        long jMax = Math.max(1L, j3);
        long j4 = ((SharedPreferences) this.f1959a).getLong("updated_at_ms", 0L);
        long j5 = jMax > 9223372036854655807L ? Long.MAX_VALUE : 120000 + jMax;
        if (((SharedPreferences) this.f1959a).getInt("version", 0) == 1 && j4 > 0 && j4 <= j5 && jMax - j4 <= 600000) {
            int iMax = Math.max(0, Math.min(1000000, ((SharedPreferences) this.f1959a).getInt("attempt", 0)));
            boolean z2 = ((SharedPreferences) this.f1959a).getBoolean("storm", false);
            long j6 = ((SharedPreferences) this.f1959a).getLong("first_failure_at_ms", jMax);
            long j7 = (j6 <= 0 || j6 > jMax) ? jMax : j6;
            long j8 = ((SharedPreferences) this.f1959a).getLong("retry_not_before_ms", 0L);
            return new l(iMax, z2, j7, j8 >= jMax ? Math.min(j8, j5) : 0L);
        }
        synchronized (this) {
            ((SharedPreferences) this.f1959a).edit().clear().commit();
            lVar = new l(0, false, 0L, 0L);
        }
        return lVar;
    }

    public long b(long[] jArr, int i3, long j3) {
        long jMin = Math.min(jArr[i3], j3);
        int i4 = i3 + 1;
        return Math.floorMod(((a) this.f1959a).getAsLong(), ((i4 < jArr.length ? Math.min(jArr[i4], j3) : jMin) - jMin) + 1) + jMin;
    }

    public b() {
        this.f1959a = new a(0);
    }
}
