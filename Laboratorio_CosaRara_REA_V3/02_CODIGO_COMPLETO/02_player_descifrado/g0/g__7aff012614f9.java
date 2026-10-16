// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g0;

import androidx.work.impl.foreground.SystemForegroundService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f1455e;

    public /* synthetic */ g(Object obj, int i3, int i4) {
        this.f1453c = i4;
        this.f1455e = obj;
        this.f1454d = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1453c) {
            case 0:
                ((h) this.f1455e).i(this.f1454d);
                break;
            default:
                ((SystemForegroundService) this.f1455e).f240e.cancel(this.f1454d);
                break;
        }
    }
}
