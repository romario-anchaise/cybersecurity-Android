// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i2 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Runnable f4237d;

    public /* synthetic */ i2(int i3, Runnable runnable) {
        this.f4236c = i3;
        this.f4237d = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4236c) {
            case 0:
                try {
                    this.f4237d.run();
                } catch (Throwable unused) {
                    return;
                }
                break;
            default:
                Runnable runnable = this.f4237d;
                if (runnable != null) {
                    try {
                        runnable.run();
                    } catch (RuntimeException e3) {
                        Log.e("TunnelManager", "tunnel-state task crashed", e3);
                    }
                    break;
                }
                break;
        }
    }
}
