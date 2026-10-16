// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package f2;

import android.os.Build;
import android.os.PowerManager;
import lyr.stable.runtime.setup.AuthSetupActivity;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f1199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ long f1200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AuthSetupActivity f1201g;

    public i(AuthSetupActivity authSetupActivity, int i3, int i4, long j3, long j4) {
        this.f1201g = authSetupActivity;
        this.f1197c = i3;
        this.f1198d = i4;
        this.f1199e = j3;
        this.f1200f = j4;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0025  */
    @Override // java.lang.Runnable
    public final void run() {
        AuthSetupActivity authSetupActivity = this.f1201g;
        if (this.f1197c != authSetupActivity.f2660e || authSetupActivity.isFinishing()) {
            return;
        }
        boolean z2 = true;
        boolean zB = false;
        int i3 = this.f1198d;
        switch (i3) {
            case 0:
                try {
                    PowerManager powerManager = (PowerManager) authSetupActivity.getSystemService("power");
                    if (powerManager == null || !powerManager.isIgnoringBatteryOptimizations(authSetupActivity.getPackageName())) {
                        z2 = false;
                    }
                } catch (Throwable unused) {
                }
                zB = z2;
                break;
            case 1:
                zB = i0.B(authSetupActivity);
                break;
            case 2:
                zB = l.z(authSetupActivity);
                break;
            case 3:
                zB = l.r(authSetupActivity);
                break;
            case 4:
                zB = l.p(authSetupActivity);
                break;
            case 5:
                zB = authSetupActivity.getApplicationContext().getSharedPreferences("auth_setup_steps", 4).getBoolean("background_popup_step_verified", false);
                break;
            case 6:
                int i4 = Build.VERSION.SDK_INT;
                boolean zX = l.x(authSetupActivity);
                if (i4 < 33 && !zX) {
                    z2 = false;
                }
                zB = z2;
                break;
        }
        if (zB) {
            authSetupActivity.d(i3, "success", "verified");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f1199e;
        long j3 = this.f1200f;
        if (jCurrentTimeMillis >= j3) {
            authSetupActivity.l("timeout", i3);
        } else {
            authSetupActivity.f2656a.postDelayed(this, Math.min(1000L, j3 - jCurrentTimeMillis));
        }
    }
}
