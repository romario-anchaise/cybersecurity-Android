// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f455a = SystemClock.elapsedRealtime();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f456b = 0;

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getApplicationContext().createDeviceProtectedStorageContext().getSharedPreferences("keepalive_direct_boot", 0);
        try {
            JSONArray jSONArray = new JSONArray(sharedPreferences.getString("boot_event_log", "[]"));
            jSONArray.put(System.currentTimeMillis() + ":" + str);
            while (jSONArray.length() > 32) {
                jSONArray.remove(0);
            }
            sharedPreferences.edit().putString("boot_event_log", jSONArray.toString()).apply();
        } catch (JSONException unused) {
            sharedPreferences.edit().putString("boot_event_log", "[]").apply();
        }
    }

    public static void b(SharedPreferences sharedPreferences, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            JSONArray jSONArray = new JSONArray(sharedPreferences.getString(str, "[]"));
            jSONArray.put(jCurrentTimeMillis);
            long j3 = jCurrentTimeMillis - 600001;
            int i3 = 0;
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                long jOptLong = jSONArray.optLong(i4, 0L);
                if (jOptLong >= j3) {
                    if (i3 != i4) {
                        jSONArray.put(i3, jOptLong);
                    }
                    i3++;
                }
            }
            while (jSONArray.length() > i3) {
                jSONArray.remove(jSONArray.length() - 1);
            }
            while (jSONArray.length() > 128) {
                jSONArray.remove(0);
            }
            sharedPreferences.edit().putString(str, jSONArray.toString()).apply();
        } catch (JSONException unused) {
            sharedPreferences.edit().putString(str, "[]").apply();
        }
    }

    public static long c(Context context) {
        long j3;
        synchronized (u.f461b) {
            try {
                y.c cVarJ = u.j(context, "keepalive_prefs");
                long jMax = ((SharedPreferences) cVarJ.f5973e).getLong("recovery_epoch", 0L);
                SharedPreferences sharedPreferences = (SharedPreferences) cVarJ.f5972d;
                if (sharedPreferences != null) {
                    jMax = Math.max(jMax, sharedPreferences.getLong("recovery_epoch", 0L));
                }
                j3 = Long.MAX_VALUE;
                if (jMax != Long.MAX_VALUE) {
                    j3 = 1 + jMax;
                }
                u.k((SharedPreferences) cVarJ.f5973e, "recovery_epoch", j3, true);
                u.k((SharedPreferences) cVarJ.f5972d, "recovery_epoch", j3, true);
            } catch (Throwable th) {
                throw th;
            }
        }
        return j3;
    }

    public static int d(SharedPreferences sharedPreferences, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis() - 600001;
        try {
            JSONArray jSONArray = new JSONArray(sharedPreferences.getString(str, "[]"));
            int i3 = 0;
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                if (jSONArray.optLong(i4, 0L) >= jCurrentTimeMillis) {
                    i3++;
                }
            }
            return i3;
        } catch (JSONException unused) {
            return 0;
        }
    }

    public static boolean e(Context context) {
        Context applicationContext;
        Object obj = o.f443a;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = o.f447e;
        int i3 = 1;
        if (jElapsedRealtime < j3 || jElapsedRealtime - j3 >= 1000) {
            if (context == null) {
                applicationContext = null;
            } else {
                applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
            }
            if (applicationContext != null && o.f445c.compareAndSet(false, true)) {
                o.f447e = jElapsedRealtime;
                try {
                    o.f446d.execute(new a2.m(applicationContext, i3));
                } catch (Throwable th) {
                    o.f445c.set(false);
                    a0.a.p(th, new StringBuilder("cache refresh rejected: "), "GatewayHeartbeatLease");
                }
            }
        }
        n nVar = (n) o.f444b.get();
        long jMin = Long.MAX_VALUE;
        if (nVar.f441a) {
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            if (nVar.f441a) {
                long j4 = nVar.f442b;
                if (j4 >= 0 && jElapsedRealtime2 >= j4) {
                    jMin = jElapsedRealtime2 - j4;
                }
            }
        } else {
            long jL = u.l(context, "last_heartbeat_time");
            jMin = Math.min(Math.max(0L, jL > 0 ? Math.max(0L, System.currentTimeMillis() - jL) : Long.MAX_VALUE), Math.max(0L, Math.max(0L, SystemClock.elapsedRealtime() - f455a)));
        }
        return jMin > 90000;
    }

    public static boolean f(Context context) {
        long jL = u.l(context, "recovery_main_process_tick_at");
        return jL <= 0 || System.currentTimeMillis() - jL > 90000;
    }
}
