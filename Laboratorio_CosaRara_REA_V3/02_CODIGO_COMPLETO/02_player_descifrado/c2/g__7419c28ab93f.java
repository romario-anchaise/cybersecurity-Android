// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package c2;

import lyr.stable.runtime.keepalive.ConnectionKeepAliveService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ConnectionKeepAliveService f424d;

    public /* synthetic */ g(ConnectionKeepAliveService connectionKeepAliveService, int i3) {
        this.f423c = i3;
        this.f424d = connectionKeepAliveService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f423c) {
            case 0:
                if (ConnectionKeepAliveService.f2621j) {
                    ConnectionKeepAliveService connectionKeepAliveService = this.f424d;
                    int i3 = q.f456b;
                    u.s(connectionKeepAliveService, "recovery_main_process_tick_at", System.currentTimeMillis());
                    if (p.i(this.f424d)) {
                        p.p(this.f424d);
                    }
                    this.f424d.f2623a.postDelayed(this, 5000L);
                    break;
                }
                break;
            default:
                if (ConnectionKeepAliveService.f2621j) {
                    p.z(this.f424d, "service-loop");
                    this.f424d.f2623a.postDelayed(this, 8000L);
                    break;
                }
                break;
        }
    }
}
