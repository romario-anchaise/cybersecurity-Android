// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f1;

import a2.i;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends Thread {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static b f1112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ExecutorService f1113f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f1110c = Logger.getLogger(b.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f1111d = new a(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f1114g = 0;

    public static void a(Runnable runnable) {
        if (Thread.currentThread() == f1112e) {
            runnable.run();
        } else {
            b(runnable);
        }
    }

    public static void b(Runnable runnable) {
        ExecutorService executorService;
        synchronized (b.class) {
            try {
                f1114g++;
                if (f1113f == null) {
                    f1113f = Executors.newSingleThreadExecutor(f1111d);
                }
                executorService = f1113f;
            } catch (Throwable th) {
                throw th;
            }
        }
        executorService.execute(new i(4, runnable));
    }
}
