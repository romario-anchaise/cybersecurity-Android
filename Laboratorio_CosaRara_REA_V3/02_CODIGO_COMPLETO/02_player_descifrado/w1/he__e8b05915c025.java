// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.concurrent.RejectedExecutionException;
import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class he implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ cf f4229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f4230e;

    public /* synthetic */ he(cf cfVar, ScreenMirrorService screenMirrorService, int i3) {
        this.f4228c = i3;
        this.f4229d = cfVar;
        this.f4230e = screenMirrorService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4228c) {
            case 0:
                cf cfVar = this.f4229d;
                try {
                    cfVar.f3702f.execute(new he(cfVar, this.f4230e, 2));
                } catch (RejectedExecutionException unused) {
                    return;
                }
                break;
            case 1:
                cf cfVar2 = this.f4229d;
                ScreenMirrorService screenMirrorService = this.f4230e;
                if (cfVar2.f3731u0 == screenMirrorService) {
                    g2.k0 k0Var = cfVar2.D;
                    if (k0Var != null && k0Var.C()) {
                        boolean z2 = cfVar2.H;
                        boolean z3 = cfVar2.I;
                        if (z2 && !z3) {
                            cfVar2.e(k0Var);
                        }
                        if (cfVar2.J) {
                            cfVar2.d(k0Var);
                        }
                    }
                    if (cfVar2.f3731u0 == screenMirrorService) {
                        long j3 = cfVar2.P.get();
                        if (j3 > 0) {
                            screenMirrorService.L4(cfVar2.M, j3, cfVar2.L);
                            break;
                        }
                    }
                }
                break;
            case 2:
                cf cfVar3 = this.f4229d;
                if (this.f4230e == cfVar3.f3731u0 && cfVar3.J && cfVar3.f()) {
                    cfVar3.d(cfVar3.D);
                    break;
                }
                break;
            default:
                cf cfVar4 = this.f4229d;
                ScreenMirrorService screenMirrorService2 = this.f4230e;
                if (cfVar4.f3731u0 == screenMirrorService2) {
                    long j4 = cfVar4.P.get();
                    if (j4 > 0) {
                        screenMirrorService2.L4(cfVar4.M, j4, cfVar4.L);
                        break;
                    }
                }
                break;
        }
    }
}
