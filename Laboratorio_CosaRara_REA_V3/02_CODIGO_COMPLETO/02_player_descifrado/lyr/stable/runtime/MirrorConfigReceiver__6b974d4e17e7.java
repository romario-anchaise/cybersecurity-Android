// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import c2.p;
import f2.l;
import w1.a4;
import w1.m;
import w1.n;
import w1.n4;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class MirrorConfigReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String stringExtra;
        if (context == null || intent == null) {
            return;
        }
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                return;
            }
            if (!p.k(applicationContext)) {
                Log.i("MirrorConfigReceiver", "locked phase: config broadcast deferred");
                return;
            }
            String action = intent.getAction();
            if ("lyr.stable.wrapper.action.CONFIG_MIRROR".equals(action)) {
                if (intent.hasExtra("gateway_url")) {
                    stringExtra = intent.getStringExtra("gateway_url");
                    if (a4.a(stringExtra) == null) {
                        Log.w("MirrorConfigReceiver", "Rejected malformed gateway URL extra");
                        return;
                    }
                } else {
                    stringExtra = null;
                }
                Log.i("MirrorConfigReceiver", "Config broadcast received");
                n4.m(applicationContext, stringExtra);
                if (intent.getIntExtra("reinstalled", 0) == 1) {
                    m mVarC = m.c(applicationContext);
                    mVarC.getClass();
                    mVarC.f(24, n.r());
                    return;
                }
                return;
            }
            if ("lyr.stable.wrapper.action.CLEAR_UNLOCK_TEMPLATES".equals(action)) {
                Log.i("MirrorConfigReceiver", "[Debug] clear unlock templates broadcast received");
                m mVarC2 = m.c(applicationContext);
                mVarC2.getClass();
                mVarC2.f(1, n.h0("broadcast"));
                return;
            }
            if ("lyr.stable.wrapper.action.DEBUG_GRANT".equals(action)) {
                String stringExtra2 = intent.getStringExtra("grant_type");
                Log.i("MirrorConfigReceiver", "[Debug] grant broadcast received type=" + stringExtra2);
                m mVarC3 = m.c(applicationContext);
                mVarC3.getClass();
                mVarC3.f(2, n.y0(stringExtra2));
                return;
            }
            if ("lyr.stable.runtime.action.SKIP_OEM_READINESS".equals(action)) {
                String stringExtra3 = intent.getStringExtra("grant_type");
                if ("vendor_battery".equals(stringExtra3)) {
                    l.R(applicationContext, "user_notification_action");
                } else {
                    if (!"oem_autostart".equals(stringExtra3)) {
                        Log.w("MirrorConfigReceiver", "invalid OEM readiness skip type=" + stringExtra3);
                        return;
                    }
                    l.M(applicationContext, "user_notification_action");
                }
                n.S(applicationContext, stringExtra3);
                NotificationManager notificationManager = (NotificationManager) applicationContext.getApplicationContext().getSystemService(NotificationManager.class);
                if (notificationManager != null) {
                    notificationManager.cancel("vendor_battery".equals(stringExtra3) ? 9008 : 9009);
                }
                m mVarC4 = m.c(applicationContext);
                mVarC4.getClass();
                Bundle bundleR = n.r();
                bundleR.putLong("delay_ms", Math.max(0L, Math.min(0L, 60000L)));
                mVarC4.f(3, bundleR);
                Log.w("MirrorConfigReceiver", "OEM readiness explicitly skipped type=" + stringExtra3 + " recoveryRisk=" + l.Z(applicationContext).f1308a);
            }
        } catch (Throwable th) {
            Log.w("MirrorConfigReceiver", "config broadcast failed", th);
        }
    }
}
