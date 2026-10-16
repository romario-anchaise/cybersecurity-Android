// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package g2;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f0 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k0 f1597d;

    public /* synthetic */ f0(k0 k0Var, int i3) {
        this.f1596c = i3;
        this.f1597d = k0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f1596c;
        k0 k0Var = this.f1597d;
        switch (i3) {
            case 0:
                k0Var.n.set(false);
                if (k0Var.f1657j.get() && !k0Var.f1651d.f3425b) {
                    w0.s sVar = k0Var.f1651d;
                    sVar.getClass();
                    f1.b.a(new w0.p(sVar, 0));
                    break;
                }
                break;
            default:
                k0Var.f1660m.set(false);
                k0Var.K();
                break;
        }
    }
}
