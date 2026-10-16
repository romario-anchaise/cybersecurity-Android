// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y1 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e2 f5571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f5572e;

    public /* synthetic */ y1(e2 e2Var, long j3, int i3) {
        this.f5570c = i3;
        this.f5571d = e2Var;
        this.f5572e = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5570c) {
            case 0:
                this.f5571d.j(this.f5572e, true, null, 0L, false);
                break;
            default:
                this.f5571d.o(this.f5572e);
                break;
        }
    }
}
