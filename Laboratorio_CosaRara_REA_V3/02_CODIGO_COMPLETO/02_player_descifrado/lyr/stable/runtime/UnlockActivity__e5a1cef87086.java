// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime;

import a0.a;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import w1.df;
import w1.n4;
import w1.v8;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class UnlockActivity extends Activity {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f2573b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PowerManager.WakeLock f2574a;

    public final void a() {
        getWindow().getDecorView().postDelayed(new v8(11, this), 1200L);
    }

    public final void b() {
        try {
            setShowWhenLocked(true);
            setTurnScreenOn(true);
            getWindow().addFlags(6815872);
        } catch (Throwable th) {
            a.p(th, new StringBuilder("set flags fail: "), "UnlockActivity");
        }
        try {
            PowerManager.WakeLock wakeLock = this.f2574a;
            if (wakeLock != null && wakeLock.isHeld()) {
                this.f2574a.release();
            }
            PowerManager powerManager = (PowerManager) getSystemService("power");
            if (powerManager != null) {
                PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(805306378, "ScreenMirror:unlock");
                this.f2574a = wakeLockNewWakeLock;
                wakeLockNewWakeLock.acquire(3000L);
            }
        } catch (Throwable th2) {
            a.p(th2, new StringBuilder("wakeLock fail: "), "UnlockActivity");
        }
        try {
            KeyguardManager keyguardManager = (KeyguardManager) getSystemService("keyguard");
            if (keyguardManager != null) {
                keyguardManager.requestDismissKeyguard(this, new df(this));
            } else {
                a();
            }
        } catch (Throwable th3) {
            Log.w("UnlockActivity", "requestDismissKeyguard fail: " + th3.getMessage());
            a();
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n4.t(this);
        b();
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        try {
            PowerManager.WakeLock wakeLock = this.f2574a;
            if (wakeLock == null || !wakeLock.isHeld()) {
                return;
            }
            this.f2574a.release();
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        n4.t(this);
        setIntent(intent);
        b();
    }
}
