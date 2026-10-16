// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime.keepalive;

import a2.c;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import c2.p;
import c2.q;
import f2.l;
import lyr.stable.runtime.MirrorApplication;
import lyr.stable.runtime.ScreenMirrorService;
import w1.a;
import w1.f;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class BootReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action;
        if (intent == null || (action = intent.getAction()) == null) {
            return;
        }
        try {
            Context applicationContext = context.getApplicationContext();
            boolean zK = p.k(applicationContext);
            int i3 = 0;
            boolean z2 = zK && MirrorApplication.d(applicationContext);
            q.a(applicationContext, action);
            boolean zEquals = "android.intent.action.MY_PACKAGE_REPLACED".equals(action);
            Object obj = f.f3944a;
            Context applicationContext2 = applicationContext.getApplicationContext();
            if (applicationContext2 == null) {
                applicationContext2 = applicationContext;
            }
            try {
                f.f3947d.execute(new a(applicationContext2, zEquals, i3));
            } catch (Throwable th) {
                Log.w("A11yBindLease", "arm startup grace rejected: " + th.getMessage());
            }
            Log.i("ConnRecovery", "boot event action=".concat(action));
            if (z2 && ("android.intent.action.BOOT_COMPLETED".equals(action) || "android.intent.action.LOCKED_BOOT_COMPLETED".equals(action))) {
                l.A(applicationContext);
            }
            if (!zK || z2) {
                p.s(applicationContext, "system:".concat(action), false);
            }
            if (z2) {
                ScreenMirrorService screenMirrorServiceU2 = ScreenMirrorService.U2();
                if (screenMirrorServiceU2 == null || !screenMirrorServiceU2.F5) {
                    c.c(applicationContext);
                }
            }
        } catch (Throwable th2) {
            a0.a.p(th2, a0.a.k("boot event failed action=", action, " "), "ConnRecovery");
        }
    }
}
