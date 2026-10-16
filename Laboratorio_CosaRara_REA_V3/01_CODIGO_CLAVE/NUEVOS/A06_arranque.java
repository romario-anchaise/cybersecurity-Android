// EXTRAIDO POR REA; representacion java; no es proyecto original.
// Evidencia: ev_429d8070ffd5ccd30e0483d6debe30a07a4a3dfc65b29d0c11fbb5faaad18ba6
// Selector: {'path': 'C:\\Users\\Romario\\Documents\\Codex\\2026-10-15\\ho\\work\\player_unpacked_for_analysis.apk', 'class_name': 'lyr.stable.runtime.keepalive.BootReceiver', 'method_name': 'onReceive'}

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
