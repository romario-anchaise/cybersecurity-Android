// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w0;

import java.util.Timer;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Timer f3391b;

    public /* synthetic */ h(Timer timer, int i3) {
        this.f3390a = i3;
        this.f3391b = timer;
    }

    @Override // w0.m
    public final void destroy() {
        switch (this.f3390a) {
            case 0:
                this.f3391b.cancel();
                break;
            default:
                this.f3391b.cancel();
                break;
        }
    }
}
