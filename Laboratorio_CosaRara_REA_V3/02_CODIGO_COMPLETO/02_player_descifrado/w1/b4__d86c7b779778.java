// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.concurrent.ScheduledFuture;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b4 implements c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ScheduledFuture f3551b;

    public /* synthetic */ b4(ScheduledFuture scheduledFuture, int i3) {
        this.f3550a = i3;
        this.f3551b = scheduledFuture;
    }

    @Override // w1.c4
    public final void cancel() {
        int i3 = this.f3550a;
        ScheduledFuture scheduledFuture = this.f3551b;
        switch (i3) {
            case 0:
                scheduledFuture.cancel(false);
                break;
            default:
                rd rdVar = ScreenMirrorService.n6;
                scheduledFuture.cancel(false);
                break;
        }
    }
}
