// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j8 f4207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ i8 f4208e;

    public /* synthetic */ h8(j8 j8Var, i8 i8Var, int i3) {
        this.f4206c = i3;
        this.f4207d = j8Var;
        this.f4208e = i8Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4206c) {
            case 0:
                this.f4207d.D(this.f4208e);
                break;
            default:
                this.f4207d.D(this.f4208e);
                break;
        }
    }
}
