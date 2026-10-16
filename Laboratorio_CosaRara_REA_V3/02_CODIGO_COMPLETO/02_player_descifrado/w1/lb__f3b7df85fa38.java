// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class lb implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ScreenMirrorService f4467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ n5 f4468e;

    public /* synthetic */ lb(ScreenMirrorService screenMirrorService, n5 n5Var, int i3) {
        this.f4466c = i3;
        this.f4467d = screenMirrorService;
        this.f4468e = n5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f4466c;
        n5 n5Var = this.f4468e;
        ScreenMirrorService screenMirrorService = this.f4467d;
        switch (i3) {
            case 0:
                rd rdVar = ScreenMirrorService.n6;
                screenMirrorService.r1(n5Var);
                screenMirrorService.d1();
                break;
            case 1:
                screenMirrorService.f2515l0.d(n5Var, n5Var.f4625e, 14);
                break;
            default:
                if (screenMirrorService.f2515l0.e(n5Var, 14)) {
                    screenMirrorService.X(n5Var.f4621a);
                    break;
                }
                break;
        }
    }
}
