// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w2;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                ReentrantLock reentrantLock = f.f5761h;
                reentrantLock.lock();
                try {
                    f fVarA = b.a();
                    if (fVarA == f.f5765l) {
                        f.f5765l = null;
                        reentrantLock.unlock();
                        return;
                    } else {
                        reentrantLock.unlock();
                        if (fVarA != null) {
                            fVarA.k();
                        }
                    }
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            } catch (InterruptedException unused) {
                continue;
            }
        }
    }
}
