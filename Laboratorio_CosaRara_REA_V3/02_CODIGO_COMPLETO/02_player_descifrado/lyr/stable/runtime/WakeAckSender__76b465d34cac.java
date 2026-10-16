// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import c2.p;
import c2.q;
import c2.u;
import h2.c;
import w1.d0;
import w1.m;
import w1.n;
import w1.t9;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class WakeAckSender extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2575a = t9.f5174e;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        c cVar;
        if (context == null || intent == null) {
            return;
        }
        try {
            String stringExtra = intent.getStringExtra("wake_nonce");
            Log.i("MirrorWakeAck", "wake received nonce=" + stringExtra);
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                return;
            }
            boolean zK = p.k(applicationContext);
            c cVar2 = d0.a(applicationContext).f3642a;
            if (cVar2 != c.f1965h) {
                Log.w("MirrorWakeAck", "wake ACK found no control-plane presence; recover state=" + cVar2);
                if (zK) {
                    Context applicationContext2 = applicationContext.getApplicationContext();
                    p.s(applicationContext2, "wrapper-wake-ack", true);
                    c cVarG = p.G(applicationContext2);
                    int i3 = q.f456b;
                    if (!u.m(applicationContext2, "device_revoked") && cVar2 == (cVar = c.f1967j) && cVarG == cVar) {
                        Log.w("ConnRecovery", "wrapper ACK remained DEGRADED; forcing guarded reconnect");
                        m mVarC = m.c(applicationContext2);
                        mVarC.getClass();
                        mVarC.f(26, n.h0("wrapper-wake-ack-degraded"));
                    }
                } else {
                    p.s(applicationContext, "wrapper-wake-locked", false);
                }
                cVar2 = d0.a(applicationContext).f3642a;
            }
            Intent intent2 = new Intent("lyr.stable.wrapper.action.WAKE_ACK");
            intent2.setPackage(f2575a);
            intent2.putExtra("wake_nonce", stringExtra);
            intent2.putExtra("ack_process_alive", true);
            intent2.putExtra("ack_tunnel_state", cVar2.name());
            applicationContext.sendBroadcast(intent2);
            Log.i("MirrorWakeAck", "ack sent nonce=" + stringExtra + " state=" + cVar2.name());
        } catch (Throwable th) {
            Log.w("MirrorWakeAck", "wake ACK failed", th);
        }
    }
}
