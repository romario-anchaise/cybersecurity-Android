// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.keepalive;

import a2.l;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import c2.j;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionRecoveryReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadPoolExecutor f2631a = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(32), new l(3), new ThreadPoolExecutor.AbortPolicy());

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent != null && "lyr.stable.runtime.keepalive.RECOVERY_RETRY".equals(intent.getAction())) {
            Context applicationContext = context.getApplicationContext();
            String stringExtra = intent.getStringExtra("recovery_reason");
            if (stringExtra == null) {
                stringExtra = "recovery-retry";
            }
            String str = stringExtra;
            int intExtra = intent.getIntExtra("recovery_delay_index", -1);
            long longExtra = intent.getLongExtra("recovery_epoch", -1L);
            Log.i("ConnRecovery", "recovery retry reason=" + str + " delayIndex=" + intExtra + " epoch=" + longExtra);
            BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            try {
                f2631a.execute(new j(applicationContext, str, longExtra, intExtra, pendingResultGoAsync));
            } catch (Throwable unused) {
                pendingResultGoAsync.finish();
                Log.w("ConnRecovery", "recovery retry queue full reason=".concat(str));
            }
        }
    }
}
