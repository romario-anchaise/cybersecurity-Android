// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w2;

import java.util.concurrent.atomic.AtomicReference;
import w1.o2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f5808a = new s(new byte[0], 0, 0, false, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference[] f5810c;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f5809b = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i3 = 0; i3 < iHighestOneBit; i3++) {
            atomicReferenceArr[i3] = new AtomicReference();
        }
        f5810c = atomicReferenceArr;
    }

    public static final void a(s sVar) {
        sVar.getClass();
        if (sVar.f5806f != null || sVar.f5807g != null) {
            o2.i("Failed requirement.");
            return;
        }
        if (sVar.f5804d) {
            return;
        }
        AtomicReference atomicReference = f5810c[(int) (Thread.currentThread().getId() & (((long) f5809b) - 1))];
        s sVar2 = f5808a;
        s sVar3 = (s) atomicReference.getAndSet(sVar2);
        if (sVar3 == sVar2) {
            return;
        }
        int i3 = sVar3 != null ? sVar3.f5803c : 0;
        if (i3 >= 65536) {
            atomicReference.set(sVar3);
            return;
        }
        sVar.f5806f = sVar3;
        sVar.f5802b = 0;
        sVar.f5803c = i3 + 8192;
        atomicReference.set(sVar);
    }

    public static final s b() {
        AtomicReference atomicReference = f5810c[(int) (Thread.currentThread().getId() & (((long) f5809b) - 1))];
        s sVar = f5808a;
        s sVar2 = (s) atomicReference.getAndSet(sVar);
        if (sVar2 == sVar) {
            return new s();
        }
        if (sVar2 == null) {
            atomicReference.set(null);
            return new s();
        }
        atomicReference.set(sVar2.f5806f);
        sVar2.f5806f = null;
        sVar2.f5803c = 0;
        return sVar2;
    }
}
