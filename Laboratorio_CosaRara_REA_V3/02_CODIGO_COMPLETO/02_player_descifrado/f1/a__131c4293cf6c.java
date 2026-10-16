// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f1;

import java.util.concurrent.ThreadFactory;
import y0.l;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1109a;

    public /* synthetic */ a(int i3) {
        this.f1109a = i3;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f1109a) {
            case 0:
                b bVar = new b(runnable);
                b.f1112e = bVar;
                bVar.setName("EventThread");
                b.f1112e.setDaemon(Thread.currentThread().isDaemon());
                return b.f1112e;
            default:
                Thread thread = new Thread(runnable, "engine.io-client.heartbeat-" + l.B.getAndIncrement());
                thread.setDaemon(true);
                return thread;
        }
    }
}
