// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime;

import a0.a;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.Window;
import w1.n4;
import w1.v8;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class WakeActivity extends Activity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f2576b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PowerManager.WakeLock f2577a;

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n4.t(this);
        try {
            setShowWhenLocked(true);
            setTurnScreenOn(true);
            Window window = getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.clearFlags(2);
            window.addFlags(2621568);
        } catch (Throwable th) {
            a.p(th, new StringBuilder("window wake flags failed: "), "WakeActivity");
        }
        try {
            PowerManager powerManager = (PowerManager) getSystemService("power");
            if (powerManager != null) {
                PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(805306378, "ScreenMirror:wakeOnly");
                this.f2577a = wakeLockNewWakeLock;
                wakeLockNewWakeLock.acquire(2500L);
            }
        } catch (Throwable th2) {
            a.p(th2, new StringBuilder("wake lock failed: "), "WakeActivity");
        }
        getWindow().getDecorView().postDelayed(new v8(13, this), 700L);
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        try {
            PowerManager.WakeLock wakeLock = this.f2577a;
            if (wakeLock != null && wakeLock.isHeld()) {
                this.f2577a.release();
            }
        } catch (Throwable unused) {
        }
        super.onDestroy();
    }
}
