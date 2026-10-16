// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.IntConsumer;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bc implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3600c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f3601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f3602e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f3603f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f3604g;

    public /* synthetic */ bc(g.j jVar, int i3, AtomicReference atomicReference, long j3) {
        this.f3603f = jVar;
        this.f3601d = i3;
        this.f3604g = atomicReference;
        this.f3602e = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3600c) {
            case 0:
                ScreenMirrorService screenMirrorService = (ScreenMirrorService) this.f3603f;
                long j3 = this.f3602e;
                IntConsumer intConsumer = (IntConsumer) this.f3604g;
                int i3 = this.f3601d;
                rd rdVar = ScreenMirrorService.n6;
                screenMirrorService.R7(j3, intConsumer, i3);
                break;
            default:
                g.j jVar = (g.j) this.f3603f;
                int i4 = this.f3601d;
                AtomicReference atomicReference = (AtomicReference) this.f3604g;
                long j4 = this.f3602e;
                cf cfVar = (cf) jVar.f1415d;
                g2.a0 a0Var = (g2.a0) atomicReference.get();
                if (i4 == cfVar.f3708i.get() && a0Var != null && a0Var == cfVar.f3727s0) {
                    if (cfVar.f3706h == h2.c.f1965h) {
                        cfVar.N0(h2.c.f1967j, 3, null);
                    }
                    if (cfVar.B0 != null) {
                        c2.c.e(cfVar.B0, "socket-heartbeat-stale", true);
                    }
                    Log.w("TunnelManager", "Socket.IO control heartbeat stale ageMs=" + j4 + " generation=" + i4);
                    break;
                }
                break;
        }
    }

    public /* synthetic */ bc(ScreenMirrorService screenMirrorService, long j3, IntConsumer intConsumer, int i3) {
        this.f3603f = screenMirrorService;
        this.f3602e = j3;
        this.f3604g = intConsumer;
        this.f3601d = i3;
    }
}
