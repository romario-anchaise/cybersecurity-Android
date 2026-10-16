// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package I0;

import F0.i;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: loaded from: classes.dex */
public final class a extends H0.a {
    @Override // H0.a
    public final Random a() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        i.d(threadLocalRandomCurrent, "current(...)");
        return threadLocalRandomCurrent;
    }
}
