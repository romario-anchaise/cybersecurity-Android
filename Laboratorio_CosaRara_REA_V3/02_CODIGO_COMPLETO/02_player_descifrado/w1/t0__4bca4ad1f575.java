// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f5123a = Pattern.compile("^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b2.a f5124b = new b2.a(28);

    public static String a(String str) {
        if (str == null) {
            return "";
        }
        String lowerCase = str.trim().toLowerCase(Locale.ROOT);
        return (lowerCase.isEmpty() || "00000000-0000-0000-0000-000000000000".equals(lowerCase) || !f5123a.matcher(lowerCase).matches()) ? "" : lowerCase;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0059 A[DONT_GENERATE] */
    public static String b(final Context context) {
        boolean zIsDone;
        final b2.a aVar = f5124b;
        if (aVar != null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            FutureTask futureTask = new FutureTask(new Callable() { // from class: w1.r0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    int i3;
                    b2.a aVar2 = aVar;
                    Context context2 = context;
                    aVar2.getClass();
                    d0.a aVar3 = d0.a.f519i;
                    if (aVar3 == null) {
                        synchronized (d0.a.f518h) {
                            try {
                                aVar3 = d0.a.f519i;
                                if (aVar3 == null) {
                                    Log.d("AdvertisingIdClient", "Creating AdvertisingIdClient");
                                    aVar3 = new d0.a(context2);
                                    d0.a.f519i = aVar3;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    Log.d("AdvertisingIdClient", "AdvertisingIdClient already created.");
                    if (d0.e.f533c == null) {
                        synchronized (d0.e.f534d) {
                            try {
                                if (d0.e.f533c == null) {
                                    d0.e.f533c = new d0.e(context2);
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    }
                    d0.e eVar = d0.e.f533c;
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    try {
                        b2.e eVarE = aVar3.e();
                        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                        aVar3.c(eVarE, jElapsedRealtime2, null);
                        eVar.a(0, (int) (SystemClock.elapsedRealtime() - jElapsedRealtime), jElapsedRealtime, SystemClock.elapsedRealtime());
                        StringBuilder sb = new StringBuilder(String.valueOf(jElapsedRealtime2).length() + 25);
                        sb.append("GetInfoInternal elapse ");
                        sb.append(jElapsedRealtime2);
                        sb.append("ms");
                        Log.i("AdvertisingIdClient", sb.toString());
                        return new s0(eVarE.f273c, eVarE.f272b);
                    } catch (Throwable th3) {
                        aVar3.c(null, -1L, th3);
                        if (th3 instanceof IOException) {
                            i3 = 1;
                        } else if (th3 instanceof e0.g) {
                            i3 = 9;
                        } else {
                            i3 = th3 instanceof IllegalStateException ? 8 : -1;
                        }
                        eVar.a(i3, (int) (SystemClock.elapsedRealtime() - jElapsedRealtime), jElapsedRealtime, SystemClock.elapsedRealtime());
                        throw th3;
                    }
                }
            });
            Thread thread = new Thread(futureTask, "gaid-read");
            thread.setDaemon(true);
            thread.start();
            try {
                try {
                    s0 s0Var = (s0) futureTask.get(750L, TimeUnit.MILLISECONDS);
                    if (s0Var != null && !s0Var.f5037b) {
                        return a(s0Var.f5036a);
                    }
                    if (!zIsDone) {
                        return "";
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                } catch (ExecutionException | TimeoutException unused2) {
                }
            } finally {
                if (!futureTask.isDone()) {
                    futureTask.cancel(true);
                }
            }
        }
        return "";
    }
}
