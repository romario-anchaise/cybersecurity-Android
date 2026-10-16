// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d0;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import h0.f;
import h0.i;
import h0.j;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile e f533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f534d = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0.c f535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f536b = new AtomicLong(-1);

    public e(Context context) {
        this.f535a = new j0.c(context, new j("ads_identifier:api"));
    }

    public final synchronized void a(int i3, int i4, long j3, long j4) {
        AtomicLong atomicLong = this.f536b;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = atomicLong.get();
        StringBuilder sb = new StringBuilder(String.valueOf(j5).length() + 14);
        sb.append("shouldSendLog ");
        sb.append(j5);
        Log.i("AdvertisingIdClient", sb.toString());
        if (atomicLong.get() == -1 || jElapsedRealtime - atomicLong.get() > 1800000) {
            j0.c cVar = this.f535a;
            if (cVar != null) {
                u0.e eVarA = cVar.a(new i(0, Arrays.asList(new f(35401, i3, 0, j3, j4, null, null, 0, i4))));
                d dVar = new d(this, jElapsedRealtime);
                eVarA.getClass();
                eVarA.f3257b.d(new u0.d(u0.c.f3251a, dVar));
                synchronized (eVarA.f3256a) {
                    try {
                        if (eVarA.f3258c) {
                            eVarA.f3257b.e(eVarA);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }
}
