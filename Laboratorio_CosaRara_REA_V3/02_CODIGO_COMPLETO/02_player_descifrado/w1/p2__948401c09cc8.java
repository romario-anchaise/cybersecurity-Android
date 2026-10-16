// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p2 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ t2 f4775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ f4 f4776e;

    public /* synthetic */ p2(t2 t2Var, f4 f4Var, int i3) {
        this.f4774c = i3;
        this.f4775d = t2Var;
        this.f4776e = f4Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4774c) {
            case 0:
                this.f4775d.c(this.f4776e, 2, 6);
                break;
            default:
                this.f4775d.c(this.f4776e, 3, 13);
                break;
        }
    }
}
