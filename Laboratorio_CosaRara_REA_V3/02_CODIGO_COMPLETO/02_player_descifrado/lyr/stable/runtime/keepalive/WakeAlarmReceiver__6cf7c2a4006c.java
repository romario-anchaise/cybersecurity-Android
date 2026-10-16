// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.keepalive;

import a2.c;
import a2.r;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import c2.p;
import c2.q;
import lyr.stable.runtime.MirrorOnePixelActivity;
import w1.f;
import w1.m;
import w1.n;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class WakeAlarmReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (context == null) {
            return;
        }
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                return;
            }
            boolean zK = p.k(applicationContext);
            r.q(applicationContext, "wake-alarm");
            p.D(applicationContext);
            boolean z2 = ConnectionKeepAliveService.f2621j;
            boolean zF = q.f(applicationContext);
            boolean zE = q.e(applicationContext);
            boolean zB = f.b(applicationContext).b(SystemClock.elapsedRealtime());
            if (!zB) {
                m mVarC = m.c(applicationContext);
                mVarC.getClass();
                mVarC.f(20, n.h0("wake-alarm-owner-stale"));
            }
            boolean z3 = !z2 || zF || zE || !zB;
            if (!z2 || zF) {
                Log.i("WakeAlarm", "restart keepalive running=" + z2 + " mainTickStale=" + zF);
                p.F(applicationContext, "wake_alarm");
                WatchdogService.a(applicationContext, "wake_alarm");
            }
            if (!zK) {
                if (z3) {
                    p.s(applicationContext, "wake-alarm-unhealthy-locked", false);
                }
                Log.i("WakeAlarm", "locked phase: DE-safe wake recovery only");
                return;
            }
            p.z(applicationContext, "wake_alarm");
            m mVarC2 = m.c(applicationContext);
            mVarC2.getClass();
            mVarC2.f(14, n.h0("wake_alarm"));
            MirrorOnePixelActivity.a(applicationContext);
            c.p(applicationContext, true, false, 0L);
            c.o(applicationContext, "HB", false, false, false, 0L);
            if (zE) {
                Log.i("WakeAlarm", "heartbeat stale -> recoverImmediate");
                c2.c.e(applicationContext, "wake_alarm-heartbeat-stale", true);
            }
            if (z3) {
                p.s(applicationContext, "wake-alarm-unhealthy", false);
            }
        } catch (Throwable th) {
            Log.w("WakeAlarm", "wake alarm failed", th);
        }
    }
}
