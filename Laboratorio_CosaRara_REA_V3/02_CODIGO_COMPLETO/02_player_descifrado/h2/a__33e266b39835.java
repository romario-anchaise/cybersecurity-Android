// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package h2;

import android.os.SystemClock;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.LongSupplier;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements LongSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1955a;

    public /* synthetic */ a(int i3) {
        this.f1955a = i3;
    }

    @Override // java.util.function.LongSupplier
    public final long getAsLong() {
        switch (this.f1955a) {
            case 0:
                return ThreadLocalRandom.current().nextLong();
            case 1:
                return SystemClock.uptimeMillis();
            case 2:
                return System.nanoTime();
            default:
                return System.currentTimeMillis();
        }
    }
}
