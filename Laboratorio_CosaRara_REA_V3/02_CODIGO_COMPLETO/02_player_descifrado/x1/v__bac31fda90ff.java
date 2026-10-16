// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w f5940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f5941e;

    public /* synthetic */ v(w wVar, String str, int i3) {
        this.f5939c = i3;
        this.f5940d = wVar;
        this.f5941e = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5939c) {
            case 0:
                this.f5940d.n(this.f5941e);
                break;
            case 1:
                this.f5940d.n(this.f5941e);
                break;
            default:
                this.f5940d.n(this.f5941e);
                break;
        }
    }
}
