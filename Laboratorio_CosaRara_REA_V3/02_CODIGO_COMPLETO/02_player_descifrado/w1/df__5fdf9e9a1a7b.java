// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.app.KeyguardManager;
import android.util.Log;
import lyr.stable.runtime.UnlockActivity;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class df extends KeyguardManager.KeyguardDismissCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnlockActivity f3822a;

    public df(UnlockActivity unlockActivity) {
        this.f3822a = unlockActivity;
    }

    @Override // android.app.KeyguardManager.KeyguardDismissCallback
    public final void onDismissCancelled() {
        Log.i("UnlockActivity", "keyguard dismiss cancelled");
        int i3 = UnlockActivity.f2573b;
        this.f3822a.a();
    }

    @Override // android.app.KeyguardManager.KeyguardDismissCallback
    public final void onDismissError() {
        Log.w("UnlockActivity", "keyguard dismiss error (likely password required)");
        int i3 = UnlockActivity.f2573b;
        this.f3822a.a();
    }

    @Override // android.app.KeyguardManager.KeyguardDismissCallback
    public final void onDismissSucceeded() {
        Log.i("UnlockActivity", "keyguard dismissed (no password or already unlocked)");
        int i3 = UnlockActivity.f2573b;
        this.f3822a.a();
    }
}
