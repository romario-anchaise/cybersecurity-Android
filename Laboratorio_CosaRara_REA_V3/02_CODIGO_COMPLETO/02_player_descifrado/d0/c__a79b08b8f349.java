// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package d0;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends Thread {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference f528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CountDownLatch f530e;

    public c(a aVar, long j3) {
        super("AdIdClientAutoDisconnectThread");
        this.f528c = new WeakReference(aVar);
        this.f529d = j3;
        this.f530e = new CountDownLatch(1);
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        a aVar;
        WeakReference weakReference = this.f528c;
        try {
            if (this.f530e.await(this.f529d, TimeUnit.MILLISECONDS) || (aVar = (a) weakReference.get()) == null) {
                return;
            }
            aVar.b();
        } catch (InterruptedException unused) {
            a aVar2 = (a) weakReference.get();
            if (aVar2 != null) {
                aVar2.b();
            }
        }
    }
}
