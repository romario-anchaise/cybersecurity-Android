// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f f6135d;

    public /* synthetic */ c(f fVar, int i3) {
        this.f6134c = i3;
        this.f6135d = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f6134c;
        f fVar = this.f6135d;
        switch (i3) {
            case 0:
                if (y.f.i(fVar.n, fVar.f6155o, fVar.f6156p, fVar.f6157q)) {
                    fVar.l();
                }
                break;
            default:
                fVar.a();
                fVar.k();
                break;
        }
    }
}
