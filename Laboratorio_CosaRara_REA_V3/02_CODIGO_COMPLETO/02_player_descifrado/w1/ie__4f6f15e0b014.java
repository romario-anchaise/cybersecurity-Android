// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ie implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ cf f4288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ g2.k0 f4289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ g2.m0 f4290f;

    public /* synthetic */ ie(cf cfVar, g2.k0 k0Var, g2.m0 m0Var, int i3) {
        this.f4287c = i3;
        this.f4288d = cfVar;
        this.f4289e = k0Var;
        this.f4290f = m0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z2;
        boolean z3;
        switch (this.f4287c) {
            case 0:
                cf cfVar = this.f4288d;
                g2.m0 m0Var = this.f4290f;
                g2.k0 k0Var = this.f4289e;
                cf.o(m0Var);
                try {
                    cfVar.f3702f.execute(new ie(cfVar, k0Var, m0Var, 1));
                    return;
                } catch (RejectedExecutionException unused) {
                    j6.d("hybrid:camera");
                    return;
                }
            case 1:
                cf cfVar2 = this.f4288d;
                g2.k0 k0Var2 = this.f4289e;
                g2.m0 m0Var2 = this.f4290f;
                synchronized (cfVar2.C) {
                    try {
                        z2 = k0Var2 == cfVar2.D && cfVar2.G == m0Var2;
                        if (z2) {
                            cfVar2.G = null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                if (z2) {
                    j6.d("hybrid:camera");
                    return;
                }
                return;
            case 2:
                cf cfVar3 = this.f4288d;
                g2.k0 k0Var3 = this.f4289e;
                g2.m0 m0Var3 = this.f4290f;
                synchronized (cfVar3.C) {
                    try {
                        z3 = k0Var3 == cfVar3.D && cfVar3.F == m0Var3;
                        if (z3) {
                            cfVar3.F = null;
                            cfVar3.E = null;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                    break;
                }
                if (z3) {
                    j6.d("hybrid:h264");
                    return;
                }
                return;
            default:
                cf cfVar4 = this.f4288d;
                g2.m0 m0Var4 = this.f4290f;
                g2.k0 k0Var4 = this.f4289e;
                cf.o(m0Var4);
                try {
                    cfVar4.f3702f.execute(new ie(cfVar4, k0Var4, m0Var4, 2));
                    return;
                } catch (RejectedExecutionException unused2) {
                    j6.d("hybrid:h264");
                    return;
                }
        }
    }

    public /* synthetic */ ie(cf cfVar, g2.m0 m0Var, g2.k0 k0Var, int i3) {
        this.f4287c = i3;
        this.f4288d = cfVar;
        this.f4290f = m0Var;
        this.f4289e = k0Var;
    }
}
