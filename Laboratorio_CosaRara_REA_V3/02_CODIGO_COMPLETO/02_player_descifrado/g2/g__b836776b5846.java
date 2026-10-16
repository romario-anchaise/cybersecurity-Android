// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

import java.io.Serializable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Serializable f1599b;

    public /* synthetic */ g(Serializable serializable, int i3) {
        this.f1598a = i3;
        this.f1599b = serializable;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        int i3 = this.f1598a;
        Serializable serializable = this.f1599b;
        switch (i3) {
            case 0:
            case 1:
                return a0.a.l(runnable, (String) serializable, true);
            default:
                Thread thread = new Thread(runnable, "keylog-pull-session-cleanup-" + ((AtomicInteger) serializable).incrementAndGet());
                thread.setDaemon(true);
                return thread;
        }
    }
}
