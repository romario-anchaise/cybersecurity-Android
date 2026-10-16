// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import w1.wf;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class BlackOverlayExpiryReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (context == null || intent == null || !"lyr.stable.runtime.action.BLACK_OVERLAY_EXPIRE".equals(intent.getAction())) {
            return;
        }
        final long longExtra = intent.getLongExtra("startedAtMs", 0L);
        final long longExtra2 = intent.getLongExtra("expiresAtMs", 0L);
        wf.T(context);
        wf.Z(new Runnable() { // from class: w1.hf
            @Override // java.lang.Runnable
            public final void run() {
                long j3 = longExtra;
                long j4 = longExtra2;
                synchronized (wf.f5439b) {
                    try {
                        SharedPreferences sharedPreferencesM = wf.m();
                        if (sharedPreferencesM != null && sharedPreferencesM.getBoolean("desired", false) && sharedPreferencesM.getLong("started_at_ms", 0L) == j3 && sharedPreferencesM.getLong("expires_at_ms", 0L) == j4) {
                            wf.y();
                        } else {
                            Log.i("UpdateNotice", "stale black overlay expiry ignored");
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }
}
