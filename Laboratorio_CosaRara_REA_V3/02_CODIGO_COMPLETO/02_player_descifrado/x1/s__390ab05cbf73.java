// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x1;

import lyr.stable.runtime.defense.SelfUninstallActivity;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SelfUninstallActivity f5926d;

    public /* synthetic */ s(SelfUninstallActivity selfUninstallActivity, int i3) {
        this.f5925c = i3;
        this.f5926d = selfUninstallActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f5925c;
        SelfUninstallActivity selfUninstallActivity = this.f5926d;
        switch (i3) {
            case 0:
                int i4 = SelfUninstallActivity.f2581c;
                selfUninstallActivity.a("onNewIntent");
                break;
            case 1:
                int i5 = SelfUninstallActivity.f2581c;
                selfUninstallActivity.a("onCreate");
                break;
            default:
                selfUninstallActivity.finish();
                break;
        }
    }
}
