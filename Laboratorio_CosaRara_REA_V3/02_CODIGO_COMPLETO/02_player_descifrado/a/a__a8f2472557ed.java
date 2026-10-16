// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package a;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f0c;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f0c) {
            case 0:
                b.z().f3c.f6d.execute(runnable);
                break;
            default:
                runnable.run();
                break;
        }
    }
}
