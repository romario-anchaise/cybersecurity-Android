// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class se implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g2.d0 f5100d;

    public /* synthetic */ se(int i3, g2.d0 d0Var) {
        this.f5099c = i3;
        this.f5100d = d0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f5099c;
        g2.d0 d0Var = this.f5100d;
        switch (i3) {
            case 0:
                try {
                    d0Var.close();
                } catch (IOException unused) {
                    return;
                }
                break;
            case 1:
                try {
                    d0Var.close();
                } catch (IOException unused2) {
                    return;
                }
                break;
            case 2:
                try {
                    d0Var.close();
                } catch (IOException unused3) {
                    return;
                }
                break;
            default:
                try {
                    d0Var.close();
                } catch (IOException unused4) {
                    return;
                }
                break;
        }
    }
}
