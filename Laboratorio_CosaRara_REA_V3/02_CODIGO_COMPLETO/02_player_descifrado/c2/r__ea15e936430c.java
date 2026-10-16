// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c2;

import java.util.function.IntUnaryOperator;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r implements IntUnaryOperator {
    @Override // java.util.function.IntUnaryOperator
    public final int applyAsInt(int i3) {
        return Math.max(0, i3 - 1);
    }
}
