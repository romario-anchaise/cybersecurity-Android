// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ m f4158d;

    public /* synthetic */ h(m mVar, int i3) {
        this.f4157c = i3;
        this.f4158d = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4157c) {
            case 0:
                this.f4158d.a();
                break;
            case 1:
                this.f4158d.d("binder_died");
                break;
            case 2:
                this.f4158d.f(34, n.r());
                break;
            default:
                this.f4158d.f(35, n.r());
                break;
        }
    }
}
