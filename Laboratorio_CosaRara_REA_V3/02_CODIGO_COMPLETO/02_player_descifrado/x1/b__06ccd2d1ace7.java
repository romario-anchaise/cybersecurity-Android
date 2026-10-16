// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package x1;

import lyr.stable.runtime.defense.AppUninstallActivity;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AppUninstallActivity f5842d;

    public /* synthetic */ b(AppUninstallActivity appUninstallActivity, int i3) {
        this.f5841c = i3;
        this.f5842d = appUninstallActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f5841c;
        AppUninstallActivity appUninstallActivity = this.f5842d;
        switch (i3) {
            case 0:
                int i4 = AppUninstallActivity.f2578c;
                appUninstallActivity.a("onNewIntent");
                break;
            case 1:
                int i5 = AppUninstallActivity.f2578c;
                appUninstallActivity.a("onCreate");
                break;
            default:
                appUninstallActivity.finish();
                break;
        }
    }
}
