// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a2 f711a = new a2();

    public static int a(long j3) {
        if (1 > j3 || j3 >= 1955521) {
            o2.i("invalid WDV1 frame byte count");
            return 0;
        }
        long j4 = ((j3 - 1) / ((long) 8148)) + 1;
        if (1 <= j4 && j4 < 241) {
            return (int) j4;
        }
        o2.i("WDV1 frame requires too many chunks");
        return 0;
    }
}
