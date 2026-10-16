// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f4883a = new AtomicBoolean();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f4884b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f4885c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f4886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f4887e;

    public static p1 a() {
        synchronized (f4884b) {
            try {
                long j3 = f4885c;
                if (!f4883a.get()) {
                    return new p1(j3, false);
                }
                f4886d++;
                f4887e = 0L;
                return new p1(j3, true);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
