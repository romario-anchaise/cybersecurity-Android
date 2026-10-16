// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import lyr.stable.runtime.ScreenMirrorService;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class la implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Process f4465d;

    public /* synthetic */ la(Process process, int i3) {
        this.f4464c = i3;
        this.f4465d = process;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f4464c;
        Process process = this.f4465d;
        switch (i3) {
            case 0:
                rd rdVar = ScreenMirrorService.n6;
                try {
                    n4.H(process.getInputStream());
                } catch (Throwable unused) {
                    return;
                }
                break;
            case 1:
                rd rdVar2 = ScreenMirrorService.n6;
                try {
                    n4.H(process.getErrorStream());
                } catch (Throwable unused2) {
                    return;
                }
                break;
            case 2:
                try {
                    do {
                    } while (process.getInputStream().read(new byte[512]) != -1);
                } catch (Exception unused3) {
                    return;
                }
                break;
            default:
                try {
                    do {
                    } while (process.getErrorStream().read(new byte[512]) != -1);
                } catch (Exception unused4) {
                    return;
                }
                break;
        }
    }
}
