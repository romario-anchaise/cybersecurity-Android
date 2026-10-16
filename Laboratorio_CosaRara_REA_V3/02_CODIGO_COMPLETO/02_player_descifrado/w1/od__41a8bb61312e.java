// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class od {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f4755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f4758d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f4759e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile int f4760f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile int f4761g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f4762h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f4763i;

    public od(ScreenMirrorService screenMirrorService, OutputStream outputStream, int i3, int i4) {
        this.f4763i = screenMirrorService;
        this.f4755a = outputStream;
        this.f4756b = i3;
        this.f4757c = i4;
    }

    public final void a(n5 n5Var, boolean z2, int i3) {
        this.f4762h = n5Var.f4622b;
        int i4 = this.f4756b;
        long j3 = this.f4762h;
        int i5 = this.f4757c;
        StringBuilder sb = new StringBuilder("state=");
        sb.append(z2 ? "active" : "queued");
        sb.append(" queueDepth=");
        sb.append(i3);
        ScreenMirrorService.v4("accepted", i4, j3, i5, sb.toString());
    }

    public final boolean b(n5 n5Var) {
        ScreenMirrorService screenMirrorService = this.f4763i;
        if (!this.f4758d.get() && this.f4759e.compareAndSet(false, true)) {
            ScreenMirrorService.v4("dispatch", this.f4756b, n5Var.f4622b, this.f4757c, "watchdogMs=2000");
            try {
                screenMirrorService.u6(2000L, new ba(this, n5Var, 8));
                return true;
            } catch (Throwable unused) {
                if (screenMirrorService.f2515l0.c(n5Var, this, 4)) {
                    screenMirrorService.X(n5Var.f4621a);
                }
            }
        }
        return false;
    }

    public final synchronized void c(int i3, int i4) {
        if (this.f4758d.compareAndSet(false, true)) {
            this.f4761g = i4;
            this.f4760f = i3;
            ScreenMirrorService.v4("terminal", this.f4756b, this.f4762h, this.f4757c, "status=" + i3 + " reason=" + i4);
            this.f4763i.F6(this.f4755a, this.f4756b, this.f4757c, i3, 100, 2, i4);
        }
    }

    public final void d() {
        rd rdVar = ScreenMirrorService.n6;
        this.f4763i.F6(this.f4755a, this.f4756b, this.f4757c, 0, 0, 2, 0);
    }

    public final synchronized void e(od odVar) {
        try {
            int i3 = this.f4760f;
            if (i3 < 0) {
                odVar.d();
            } else if (i3 == 4) {
                odVar.c(4, 0);
            } else {
                int i4 = this.f4761g;
                if (i3 == 5) {
                    odVar.c(5, i4);
                } else {
                    odVar.c(6, i4);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
