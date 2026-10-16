// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q8 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f4926d;

    public /* synthetic */ q8(String str, int i3) {
        this.f4925c = i3;
        this.f4926d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f4925c;
        String str = this.f4926d;
        switch (i3) {
            case 0:
                s8.j(str);
                break;
            default:
                wf.P(str);
                break;
        }
    }
}
