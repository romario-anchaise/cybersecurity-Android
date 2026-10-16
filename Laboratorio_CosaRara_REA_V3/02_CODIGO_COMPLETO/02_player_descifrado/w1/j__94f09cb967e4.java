// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k f4292d;

    public /* synthetic */ j(k kVar, int i3) {
        this.f4291c = i3;
        this.f4292d = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f4291c;
        k kVar = this.f4292d;
        switch (i3) {
            case 0:
                kVar.f4378a.d("service_disconnected");
                break;
            case 1:
                kVar.f4378a.d("null_binding");
                break;
            default:
                kVar.f4378a.d("binding_died");
                break;
        }
    }
}
