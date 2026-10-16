// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.engine;

import a2.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class DreamWakeReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2588a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null || !"lyr.stable.runtime.action.WAKE_OWN_DREAM".equals(intent.getAction())) {
            return;
        }
        AtomicReference atomicReference = KeepAliveDreamService.f2603d;
        KeepAliveDreamService keepAliveDreamService = (KeepAliveDreamService) atomicReference.get();
        boolean zPost = false;
        if (keepAliveDreamService != null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                zPost = keepAliveDreamService.f2605b.post(new b(1, keepAliveDreamService));
            } else if (atomicReference.get() == keepAliveDreamService) {
                try {
                    keepAliveDreamService.wakeUp();
                    Log.i("KeepAliveDream", "event=remote_wake requested=true");
                    zPost = true;
                } catch (Throwable unused) {
                }
            }
        }
        Log.i("DreamWakeReceiver", "event=remote_wake delivered=" + zPost);
    }
}
