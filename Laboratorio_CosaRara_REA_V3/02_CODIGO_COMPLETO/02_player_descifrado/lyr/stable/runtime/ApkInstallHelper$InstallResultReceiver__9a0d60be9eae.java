// Decompiled with JADX from the REA-supplied audited engine JAR; not original source.
package lyr.stable.runtime;

import a0.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import w1.z0;

/* JADX INFO: compiled from: r8-map-id-5347474c40041fa035618ae5fd6f249b536e43095feee62dfa1b0bceecef7771 */
/* JADX INFO: loaded from: classes.dex */
public final class ApkInstallHelper$InstallResultReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String string;
        int intExtra = intent.getIntExtra("android.content.pm.extra.STATUS", 1);
        String stringExtra = intent.getStringExtra("android.content.pm.extra.STATUS_MESSAGE");
        String stringExtra2 = intent.getStringExtra("android.content.pm.extra.PACKAGE_NAME");
        if (intExtra == 0) {
            StringBuilder sb = new StringBuilder("{\"ok\":true,\"status\":\"success\",\"package\":\"");
            sb.append(stringExtra2 != null ? stringExtra2 : "");
            sb.append("\"}");
            string = sb.toString();
            Log.i("ApkInstall", "install success pkg=" + stringExtra2);
        } else {
            StringBuilder sbI = a.i(intExtra, "{\"ok\":false,\"status\":\"failure\",\"code\":", ",\"message\":\"");
            sbI.append(z0.b(stringExtra));
            sbI.append("\"}");
            String string2 = sbI.toString();
            Log.w("ApkInstall", "install failure code=" + intExtra + " msg=" + stringExtra);
            string = string2;
        }
        z0.f5657a.set(string);
    }
}
