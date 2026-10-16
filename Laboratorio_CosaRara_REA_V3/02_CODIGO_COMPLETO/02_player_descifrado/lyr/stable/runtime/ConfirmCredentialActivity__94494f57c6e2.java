// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime;

import a0.a;
import a2.b;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import w1.m;
import w1.n;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class ConfirmCredentialActivity extends Activity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile long f2441c = -1500;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f2442d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f2443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f2444b;

    @Override // android.app.Activity
    public final void onActivityResult(int i3, int i4, Intent intent) {
        super.onActivityResult(i3, i4, intent);
        Log.i("ConfirmCredential", "onActivityResult requestCode=" + i3 + " result=" + i4);
        new Handler(Looper.getMainLooper()).postDelayed(new b(15, this), 400L);
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - f2441c < 1500) {
            Log.i("ConfirmCredential", "anti-repeat: finishing early");
            finish();
            return;
        }
        f2441c = jElapsedRealtime;
        m mVarC = m.c(this);
        this.f2443a = mVarC;
        mVarC.getClass();
        mVarC.f(4, n.r());
        this.f2444b = true;
        KeyguardManager keyguardManager = (KeyguardManager) getSystemService("keyguard");
        Intent intentCreateConfirmDeviceCredentialIntent = null;
        if (keyguardManager != null) {
            try {
                intentCreateConfirmDeviceCredentialIntent = keyguardManager.createConfirmDeviceCredentialIntent(null, null);
            } catch (Throwable th) {
                a.p(th, new StringBuilder("createConfirmDeviceCredentialIntent failed: "), "ConfirmCredential");
            }
        }
        if (intentCreateConfirmDeviceCredentialIntent == null) {
            Log.w("ConfirmCredential", "no confirm intent (no lock set?); aborting native-confirm session");
            f2441c = -1500L;
            m mVar = this.f2443a;
            mVar.getClass();
            mVar.f(6, n.r());
            this.f2444b = false;
            finish();
            return;
        }
        try {
            startActivityForResult(intentCreateConfirmDeviceCredentialIntent, 1001);
        } catch (Throwable th2) {
            a.p(th2, new StringBuilder("startActivityForResult failed: "), "ConfirmCredential");
            f2441c = -1500L;
            m mVar2 = this.f2443a;
            mVar2.getClass();
            mVar2.f(6, n.r());
            this.f2444b = false;
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        if (this.f2443a == null || !this.f2444b) {
            return;
        }
        m mVar = this.f2443a;
        mVar.getClass();
        mVar.f(6, n.r());
        this.f2444b = false;
    }
}
