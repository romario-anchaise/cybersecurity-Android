// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w0;

import java.util.TimerTask;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends TimerTask {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3389d;

    public /* synthetic */ g(int i3, Object obj) {
        this.f3388c = i3;
        this.f3389d = obj;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        switch (this.f3388c) {
            case 0:
                f1.b.a((f) this.f3389d);
                break;
            default:
                f1.b.a(new a2.i(13, this));
                break;
        }
    }
}
