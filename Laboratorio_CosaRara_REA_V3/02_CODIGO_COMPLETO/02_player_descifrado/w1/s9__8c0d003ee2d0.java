// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import lyr.stable.runtime.RuntimePermissionActivity;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s9 implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ RuntimePermissionActivity f5076d;

    public /* synthetic */ s9(RuntimePermissionActivity runtimePermissionActivity, int i3) {
        this.f5075c = i3;
        this.f5076d = runtimePermissionActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f5075c;
        RuntimePermissionActivity runtimePermissionActivity = this.f5076d;
        switch (i3) {
            case 0:
                int i4 = RuntimePermissionActivity.f2466f;
                runtimePermissionActivity.d();
                break;
            default:
                int i5 = RuntimePermissionActivity.f2466f;
                runtimePermissionActivity.e();
                break;
        }
    }
}
