// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package w1;

import android.content.Context;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f4209a = new AtomicBoolean(false);

    public static void a(Context context) {
        if (!f4209a.compareAndSet(false, true)) {
            Log.i("ReinstallEventEmitter", "reinstall event already handled this process - skip");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            cf cfVarK = cf.K();
            if (cfVarK != null && cfVarK.P()) {
                g2.a0 a0Var = cfVarK.f3727s0;
                if (a0Var != null && cfVarK.f3694b.get()) {
                    new Thread(new g2.n(1, a0Var), "keepalive-report").start();
                }
                applicationContext.getSharedPreferences("reinstall_event", 0).edit().remove("pending_reinstall_event").apply();
                Log.i("ReinstallEventEmitter", "keepalive_uninstall_reinstall emitted immediately");
                return;
            }
        } catch (Throwable th) {
            a0.a.p(th, new StringBuilder("tunnel connectivity check failed: "), "ReinstallEventEmitter");
        }
        try {
            applicationContext.getSharedPreferences("reinstall_event", 0).edit().putBoolean("pending_reinstall_event", true).apply();
            Log.i("ReinstallEventEmitter", "tunnel not connected - pending reinstall event stored");
        } catch (Throwable th2) {
            a0.a.p(th2, new StringBuilder("persist pending reinstall event failed: "), "ReinstallEventEmitter");
        }
    }
}
