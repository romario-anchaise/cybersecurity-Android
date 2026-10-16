// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package y0;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ o f6097d;

    public /* synthetic */ m(o oVar, int i3) {
        this.f6096c = i3;
        this.f6097d = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6096c) {
            case 0:
                o oVar = this.f6097d;
                int i3 = oVar.f6117k;
                if (i3 == 3 || i3 == 0) {
                    oVar.f6117k = 1;
                    oVar.f();
                }
                break;
            default:
                o oVar2 = this.f6097d;
                int i4 = oVar2.f6117k;
                if (i4 == 1 || i4 == 2) {
                    oVar2.e();
                    oVar2.f6117k = 3;
                    oVar2.a("close", new Object[0]);
                }
                break;
        }
    }
}
