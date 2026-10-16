// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package e2;

import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ScheduledFuture f806b;

    public /* synthetic */ g(ScheduledFuture scheduledFuture, int i3) {
        this.f805a = i3;
        this.f806b = scheduledFuture;
    }

    public void a() {
        int i3 = this.f805a;
        ScheduledFuture scheduledFuture = this.f806b;
        switch (i3) {
            case 1:
                scheduledFuture.cancel(false);
                break;
            default:
                scheduledFuture.cancel(false);
                break;
        }
    }
}
