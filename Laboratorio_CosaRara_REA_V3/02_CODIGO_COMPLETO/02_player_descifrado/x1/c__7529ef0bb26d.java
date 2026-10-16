// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g f5844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f5845e;

    public /* synthetic */ c(g gVar, long j3, int i3) {
        this.f5843c = i3;
        this.f5844d = gVar;
        this.f5845e = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5843c) {
            case 0:
                long j3 = this.f5845e;
                g gVar = this.f5844d;
                if (gVar.a(j3)) {
                    gVar.s();
                }
                break;
            default:
                this.f5844d.u(this.f5845e, "", "");
                break;
        }
    }
}
