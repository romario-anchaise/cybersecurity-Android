// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.defense;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import c2.p;
import w1.n;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class WeakRecoveryReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null || !"lyr.stable.runtime.action.WEAK_RECOVERY".equals(intent.getAction())) {
            return;
        }
        Log.i("WeakRecoveryReceiver", "Weak recovery -> ConnectionRecovery");
        if (p.k(context)) {
            try {
                n.t(context);
            } catch (Throwable th) {
                Log.w("WeakRecoveryReceiver", "ensureNow failed", th);
            }
        }
        try {
            p.s(context, "weak-recovery", true);
        } catch (Throwable th2) {
            Log.w("WeakRecoveryReceiver", "ConnectionRecovery failed", th2);
        }
    }
}
