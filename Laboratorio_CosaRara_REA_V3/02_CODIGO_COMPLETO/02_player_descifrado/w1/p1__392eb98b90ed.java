// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class p1 implements AutoCloseable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f4771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f4772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f4773e = new AtomicBoolean();

    public p1(long j3, boolean z2) {
        this.f4771c = j3;
        this.f4772d = z2;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        if (this.f4773e.compareAndSet(false, true) && this.f4772d) {
            synchronized (q1.f4884b) {
                try {
                    if (this.f4771c != q1.f4885c) {
                        return;
                    }
                    int i3 = q1.f4886d;
                    if (i3 > 0) {
                        q1.f4886d = i3 - 1;
                    }
                    if (q1.f4886d == 0) {
                        q1.f4887e = SystemClock.elapsedRealtime() + 1500;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
