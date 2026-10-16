// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ue implements Executor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ cf f5255c;

    public /* synthetic */ ue(cf cfVar) {
        this.f5255c = cfVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f5255c.f3704g.post(new i2(1, runnable));
    }
}
