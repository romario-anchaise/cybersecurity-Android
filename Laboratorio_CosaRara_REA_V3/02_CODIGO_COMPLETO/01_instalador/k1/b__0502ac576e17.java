// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package k1;

import H.C0028c;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: renamed from: k1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0186b extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                ReentrantLock reentrantLock = C0189e.f3471h;
                ReentrantLock reentrantLock2 = C0189e.f3471h;
                reentrantLock2.lock();
                try {
                    C0189e c0189eK = C0028c.k();
                    if (c0189eK == C0189e.f3475l) {
                        C0189e.f3475l = null;
                        reentrantLock2.unlock();
                        return;
                    } else {
                        reentrantLock2.unlock();
                        if (c0189eK != null) {
                            c0189eK.j();
                        }
                    }
                } catch (Throwable th) {
                    reentrantLock2.unlock();
                    throw th;
                }
            } catch (InterruptedException unused) {
                continue;
            }
        }
    }
}
