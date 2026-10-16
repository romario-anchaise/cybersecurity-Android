// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.util.Log;
import lyr.stable.runtime.BqqSNkWB;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u1 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BqqSNkWB f5217d;

    public /* synthetic */ u1(BqqSNkWB bqqSNkWB, int i3) {
        this.f5216c = i3;
        this.f5217d = bqqSNkWB;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f5216c;
        BqqSNkWB bqqSNkWB = this.f5217d;
        switch (i3) {
            case 0:
                int i4 = BqqSNkWB.f2435f;
                Context applicationContext = bqqSNkWB.getApplicationContext();
                if (applicationContext != null) {
                    Thread thread = new Thread(new a2.h(bqqSNkWB, applicationContext, 16), "clipboard-reader");
                    thread.setDaemon(true);
                    thread.start();
                } else {
                    bqqSNkWB.b();
                }
                break;
            case 1:
                int i5 = BqqSNkWB.f2435f;
                Log.w("BqqSNkWB", "Timeout waiting for focus, finishing");
                bqqSNkWB.b();
                break;
            default:
                int i6 = BqqSNkWB.f2435f;
                try {
                    bqqSNkWB.finish();
                    bqqSNkWB.overridePendingTransition(0, 0);
                } catch (Throwable th) {
                    a0.a.p(th, new StringBuilder("finish failed: "), "BqqSNkWB");
                }
                break;
        }
    }
}
