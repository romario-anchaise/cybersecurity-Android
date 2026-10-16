// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g0 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k0 f1601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ s0 f1602e;

    public /* synthetic */ g0(k0 k0Var, s0 s0Var, int i3) {
        this.f1600c = i3;
        this.f1601d = k0Var;
        this.f1602e = s0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1600c) {
            case 0:
                long j3 = this.f1602e.f1728a;
                k0 k0Var = this.f1601d;
                h0 h0VarW = k0Var.w(j3);
                if (h0VarW != null) {
                    k0Var.z(h0VarW, 2);
                    k0Var.G("ack_timeout");
                    k0Var.D();
                    k0Var.K();
                    break;
                }
                break;
            default:
                k0 k0Var2 = this.f1601d;
                try {
                    k0Var2.f1654g.execute(new g0(k0Var2, this.f1602e, 0));
                } catch (RejectedExecutionException unused) {
                    return;
                }
                break;
        }
    }
}
