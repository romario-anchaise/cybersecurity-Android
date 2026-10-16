// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final D f3450a = new D(new byte[0], 0, 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference[] f3452c;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f3451b = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i2 = 0; i2 < iHighestOneBit; i2++) {
            atomicReferenceArr[i2] = new AtomicReference();
        }
        f3452c = atomicReferenceArr;
    }

    public static final void a(D d2) {
        F0.i.e(d2, "segment");
        if (d2.f3449f != null || d2.g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (d2.f3447d) {
            return;
        }
        AtomicReference atomicReference = f3452c[(int) (Thread.currentThread().getId() & (((long) f3451b) - 1))];
        D d3 = f3450a;
        D d4 = (D) atomicReference.getAndSet(d3);
        if (d4 == d3) {
            return;
        }
        int i2 = d4 != null ? d4.f3446c : 0;
        if (i2 >= 65536) {
            atomicReference.set(d4);
            return;
        }
        d2.f3449f = d4;
        d2.f3445b = 0;
        d2.f3446c = i2 + 8192;
        atomicReference.set(d2);
    }

    public static final D b() {
        AtomicReference atomicReference = f3452c[(int) (Thread.currentThread().getId() & (((long) f3451b) - 1))];
        D d2 = f3450a;
        D d3 = (D) atomicReference.getAndSet(d2);
        if (d3 == d2) {
            return new D();
        }
        if (d3 == null) {
            atomicReference.set(null);
            return new D();
        }
        atomicReference.set(d3.f3449f);
        d3.f3449f = null;
        d3.f3446c = 0;
        return d3;
    }
}
