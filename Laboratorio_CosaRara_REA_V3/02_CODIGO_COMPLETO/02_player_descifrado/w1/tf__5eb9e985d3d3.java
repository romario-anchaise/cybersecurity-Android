// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class tf implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ uf f5209d;

    public /* synthetic */ tf(uf ufVar, int i3) {
        this.f5208c = i3;
        this.f5209d = ufVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5208c) {
            case 0:
                uf.a(this.f5209d);
                break;
            case 1:
                this.f5209d.c(false);
                break;
            default:
                uf ufVar = this.f5209d;
                if (!ufVar.f5267l) {
                    ufVar.f5261f.setVisibility(4);
                }
                break;
        }
    }
}
