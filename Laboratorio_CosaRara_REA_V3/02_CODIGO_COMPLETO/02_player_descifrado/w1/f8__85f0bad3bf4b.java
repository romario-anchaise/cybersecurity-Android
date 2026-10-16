// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g8 f4016d;

    public /* synthetic */ f8(g8 g8Var, int i3) {
        this.f4015c = i3;
        this.f4016d = g8Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f4015c;
        g8 g8Var = this.f4016d;
        switch (i3) {
            case 0:
                g8Var.d(true);
                break;
            default:
                g8Var.d(false);
                break;
        }
    }
}
