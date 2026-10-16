// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.function.LongBinaryOperator;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z implements LongBinaryOperator {
    @Override // java.util.function.LongBinaryOperator
    public final long applyAsLong(long j3, long j4) {
        return Math.max(j3, j4);
    }
}
